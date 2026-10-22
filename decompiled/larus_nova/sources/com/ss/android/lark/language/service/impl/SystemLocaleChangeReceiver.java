package com.ss.android.lark.language.service.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.Log;
import cpb.d;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
public class SystemLocaleChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public apb.b f431091a;

    public SystemLocaleChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (this.f431091a != null) goto L6;
        e.a().getClass();
        int r102 = a.f431092f;
        this.f431091a = a.b.f431098a;
    L6:
        if ("android.intent.action.LOCALE_CHANGED".equals(r101.getAction()) == true) goto L8;
        return;
    L8:
        if (this.f431091a.a() == false) goto L10;
        System.exit(0);
        return;
    L10:
        Log.d("LocaleChangeReceiver", "expect locale = " + this.f431091a.getLanguageSetting() + ", curr = " + r100.getResources().getConfiguration().locale);
        Locale r103 = this.f431091a.getLanguageSetting();
        e.a().getClass();
        Application r104 = com.larksuite.framework.utils.b.f285948a;
        Intrinsics.checkNotNullParameter(LocaleWatchScene.CHANGE_LOCALE_FOLLOW_SYSTEM, "localeScene");
        Intrinsics.checkNotNullParameter(r104, "application");
        int r105 = cpb.c.f464733a;
        int r106 = d.f464734a;
        cpb.c.a.a(LocaleWatchScene.CHANGE_LOCALE_FOLLOW_SYSTEM, r104, r103, d.a.a(r104));
        this.f431091a.m(com.larksuite.framework.utils.b.f285948a, r103);
    }
}

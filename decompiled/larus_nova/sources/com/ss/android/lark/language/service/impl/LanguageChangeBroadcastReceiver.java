package com.ss.android.lark.language.service.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class LanguageChangeBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f431085b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<zob.b> f431086a;

    public LanguageChangeBroadcastReceiver() {
        this.f431086a = new CopyOnWriteArrayList();
    }

    public static String a(Context r100) {
        return r100.getPackageName() + ".language.permissions.LANGUAGE_BROADCAST";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Locale r102 = (Locale) r101.getSerializableExtra("KEY_ORIGIN_LOCALE");     // Catch: Exception -> L9
        Locale r103 = (Locale) r101.getSerializableExtra("KEY_NEW_LOCALE");     // Catch: Exception -> L9
        Iterator<zob.b> r104 = this.f431086a.iterator();     // Catch: Exception -> L9
    L4:
        if (r104.hasNext() == false) goto L19;
        zob.b r105 = r104.next();     // Catch: Exception -> L9
        if (r105 == null) goto L4;
        r105.a(r102, r103);     // Catch: Exception -> L9
        goto L4
    L19:
        return;
    L9:
        e = move-exception;
        Log.e("LanguageChangeBroadcast", "language broadcast receiver occurs error: " + e.getMessage());
    }
}

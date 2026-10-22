package com.ss.android.lark.chat.component;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin$newIntentHandler$2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.platform.dispatcher.h;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c.d f414711a;

    public c(NewIntentScrollMessagePlugin$newIntentHandler$2.a r100) {
        this.f414711a = r100;
    }

    @Override // com.ss.android.lark.platform.dispatcher.h
    public final void A0(Intent r100) {
        if (r100 == null) goto L6;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L6;
        fxa.b r102 = fxa.a.a(r101);
    L7:
        if (r102 != null) goto L10;
        Log.w("ChatDependencyComponent", "chatBundle == null");
        return;
    L10:
        this.f414711a.a(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }
}

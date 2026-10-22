package com.larksuite.component.card.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f283805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j18.f<CallbackProcessResponse> f283806b;

    public i(String r100, j18.f<CallbackProcessResponse> r101) {
        this.f283805a = r100;
        this.f283806b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Log.d("MsgCardPluginUtils", "alert cancel, actionId: " + this.f283805a);
        CallbackProcessResponse r102 = new CallbackProcessResponse();
        n18.b r103 = g.f283804a;
        r102.setApiErrNo(g.f283804a);
        this.f283806b.callback(r102);
    }
}

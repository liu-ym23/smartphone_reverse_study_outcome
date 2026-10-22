package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecialFocusPush f418566a;

    public c(SpecialFocusPush r100) {
        this.f418566a = r100;
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        SpecialFocusPush r101 = this.f418566a;
        Lazy<SpecialFocusPush> r102 = SpecialFocusPush.f418562b;
        r101.getClass();
        PushFocusChatter r103 = PushFocusChatter.ADAPTER.decode(r100);     // Catch: Exception -> L5
    L7:
        UICallbackExecutor.execute(new b(r101, r103));
        return;
    L5:
        e = move-exception;
        Log.w("SpecialFocusPush", e);
        r103 = null;
        goto L7
    }
}

package com.larus.bmhome.chat.cell.slot;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.router.SmartRouter;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements IIMCallback<wc9.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f297798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f297799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f297800c;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (this.f297800c == true) goto L5;
    L7:
        int r101 = R.string.larus_network_error;
    L8:
        t19.s r102 = t19.s.f544207a;
        Context r103 = this.f297798a.getContext();
        r102.getClass();
        t19.s.s(r103, r101);
        return;
    L5:
        if (r100.getCode() != 712013001) goto L7;
        r101 = R.string.larus_infra_branch_toast_chat_deleted;
        goto L8
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(wc9.e r100) {
        wc9.e r101 = r100;
        if (r101 == null) goto L11;
        Integer r102 = r101.f559217t;
        if (r102 != null) goto L8;
    L10:
        com.bytedance.router.i r103 = SmartRouter.buildRoute(this.f297798a.getContext(), "//flow/chat_page");
        String r104 = this.f297799b;
        r103.f267554c.putExtra("argConversationId", r104);
        r103.d();
        return;
    L8:
        if (r102.intValue() != 2) goto L10;
    L11:
        t19.s r105 = t19.s.f544207a;
        Context r106 = this.f297798a.getContext();
        r105.getClass();
        t19.s.s(r106, R.string.larus_infra_branch_toast_chat_deleted);
    }

    public h(TextView r100, String r101, boolean r102) {
        this.f297798a = r100;
        this.f297799b = r101;
        this.f297800c = r102;
    }
}

package com.bytedance.android.livesdk.ktvimpl.multichorus;

import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements rj0.b {
    public final /* synthetic */ MultiChorusViewModel.g a;

    public static final class a implements tf0.b {
        public final /* synthetic */ d a;

        public final void a() {
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus  apply failed so leave");
            MultiChorusViewModel.g r0 = this.a.a;
            r0.a.leaveMultiChorus(r0.b, MultiChorusViewModel$joinMultiChorus$1$1$1$onSuccess$1$applyFailure$1.INSTANCE, MultiChorusViewModel$joinMultiChorus$1$1$1$onSuccess$1$applyFailure$2.INSTANCE);
            this.a.a.c.invoke(new Throwable("failed"));
        }

        public a(d r1) {
            this.a = r1;
        }

        public final void b(IApplyResult r2) {
            Intrinsics.checkNotNullParameter(r2, "applyResult");
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus  apply success");
        }
    }

    public final void onFailed(Exception r1) {
    }

    public final void onSuccess() {
        this.a.a.getCurrentKtvStrategy().a(this.a.b, new a(this));
    }

    public d(MultiChorusViewModel.g r1) {
        this.a = r1;
    }
}

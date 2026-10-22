package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.android.window.shop.home.module.a {

    public static final class a extends QPresenter {

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.module.j$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0030a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0030a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                ECWindowDialogFragment r3 = ECQuickUtilKt.b(this.a.u(), ECWindowDialogFragment.class);
                if (r3 == null) goto L13;
                r3.dismissAllowingStateLoss();     // Catch: Exception -> L6
                return;
            L6:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r4 = DialogFragmentLancet.sLastShowStack;
                if (r4 == null) goto L14;
                com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            L14:
                return;
            }
        }

        public a() {
        }

        public final void A(QModel r2) {
            y().setOnClickListener(new ViewOnClickListenerC0030a(this));
        }
    }

    public final QIPresenter h() {
        return new a();
    }

    public j() {
        super(2131370922);
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r3) {
        Context r0 = a().b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        View r4 = new View(th.a.e(r0, true));
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r4;
    }
}

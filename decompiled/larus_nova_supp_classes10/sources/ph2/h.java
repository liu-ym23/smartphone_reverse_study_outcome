package ph2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends oh2.b {
    public static final /* synthetic */ int o = 0;
    public View n;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.getClass();
            BtmSDK.INSTANCE.getPageId(PageFinder.via(r2));
            throw null;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            r2.removeOnAttachStateChangeListener(this);
        }
    }

    static {
    }

    public h() {
        throw null;
    }

    public final String b() {
        return "INTRO_CARD";
    }

    public final QIPresenter h() {
        return null;
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // oh2.b
    public final void e(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.m = r4;
        ConstraintLayout r0 = new ConstraintLayout(r4);
        r0.setMinimumHeight(UtilityKotlinExtentionsKt.d(88));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r5 = Unit.INSTANCE;
        k(r0);
        this.l = r0;
        r0.addOnAttachStateChangeListener(new b(this));
    }

    public final void k(ConstraintLayout r6) {
        if (this.n == null) goto L18;
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        int r2 = nh2.a.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r6.getContext(), "context");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(null, "viewModel");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r6, "eventRoot");     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(null);     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        View r4 = (View) r3;
        if (r4 != null) goto L16;
        return;
    L16:
        r4.setId(View.generateViewId());
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-1, -2);
        r5.topToTop = 0;
        r5.bottomToBottom = 0;
        r5.startToStart = 0;
        r5.endToEnd = 0;
        Unit r7 = Unit.INSTANCE;
        r4.setLayoutParams(r5);
        r6.addView(r4);
        this.n = r4;
        throw null;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}

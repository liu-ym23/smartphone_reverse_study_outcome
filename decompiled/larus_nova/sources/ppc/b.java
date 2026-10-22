package ppc;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f530245a = null;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f530246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnCustomForwardConfirmDialogContentView f530247b;

        public a(g r100, OnCustomForwardConfirmDialogContentView r101) {
            this.f530246a = r100;
            this.f530247b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f530246a.f530254d.getDialogContent().f425138k == false) goto L6;
            OnCustomForwardConfirmDialogContentView r101 = this.f530247b;
            Activity r102 = this.f530246a.getActivity();
            Fragment r103 = this.f530246a.f530252b;
            Intrinsics.checkNotNull(r100);
            r101.p(r102, r103, r100);
            return;
        }
    }

    static {
        f530245a = new b();
    }

    public b() {
    }

    @Override // ppc.e
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OnCustomForwardConfirmDialogContentView r101 = r100.f530254d.getCustomConfirmDialogContentView();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.n1() != true) goto L7;
        return true;
    }

    @Override // ppc.e
    public final boolean b(g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OnCustomForwardConfirmDialogContentView r101 = r100.f530254d.getCustomConfirmDialogContentView();
        if (r101 != null) goto L5;
    L11:
        return false;
    L5:
        if (r101.n1() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        r100.f530253c.setBackground(null);
        ConstraintLayout r102 = new ConstraintLayout(r100.getActivity());
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r100.f530253c.addView(r102);
        r101.E1(r100.getActivity(), r102, r100.f530254d.getDialogContent(), new c());
        r102.setOnClickListener(new a(r100, r101));
        r100.f530253c.setVisibility(0);
        return true;
    }
}

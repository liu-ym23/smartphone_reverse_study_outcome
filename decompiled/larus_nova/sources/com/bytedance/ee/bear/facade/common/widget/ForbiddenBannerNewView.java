package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerNewView;", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "show", "", "state", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView$ForbiddenState;", "config", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenViewConfig;", "setViewDelegate", "viewDelegate", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView$IViewDelegate;", "showForbiddenWarning", "showInComplaint", "showComplaintFail", "showComplaintExceedLimitsDay", "showComplaintExceedLimits", "showComplaintSuccess", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForbiddenBannerNewView extends ForbiddenBannerView {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226492a = null;

        static {
            int[] r100 = new int[ForbiddenBannerView.ForbiddenState.values().length];
            r100[ForbiddenBannerView.ForbiddenState.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ForbiddenBannerView.ForbiddenState.IN_COMPLAINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ForbiddenBannerView.ForbiddenState.COMPLAINT_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f226492a = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226493a;

        public b(ForbiddenBannerNewView r100) {
            this.f226493a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226493a.f226499y;
            if (r101 == null) goto L6;
            r101.q8();
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226494a;

        public c(ForbiddenBannerNewView r100) {
            this.f226494a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226494a.f226499y;
            if (r101 == null) goto L6;
            r101.q8();
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226495a;

        public d(ForbiddenBannerNewView r100) {
            this.f226495a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226495a.f226499y;
            if (r101 == null) goto L6;
            r101.f5();
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226496a;

        public e(ForbiddenBannerNewView r100) {
            this.f226496a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226496a.f226499y;
            if (r101 == null) goto L6;
            r101.f5();
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226497a;

        public f(ForbiddenBannerNewView r100) {
            this.f226497a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226497a.f226499y;
            if (r101 == null) goto L6;
            r101.B6();
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForbiddenBannerNewView f226498a;

        public g(ForbiddenBannerNewView r100) {
            this.f226498a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ForbiddenBannerView.a r101 = this.f226498a.f226499y;
            if (r101 == null) goto L6;
            r101.s2();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void C6() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        String r101 = r100.getString(R.string.LarkCCM_Security_Appeal_Link);
        s r102 = this.f226500z;
        if (r102 == null) goto L9;
        String r103 = r102.c();
        Intrinsics.checkNotNull(r103);
        int r104 = StringsKt.lastIndexOf$default(r103, r101, 0, false, 6, null);
        int r105 = r101.length() + r104;
        setText(r103);
        S5(r104, r105, new d(this));
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void H6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r100.getString(R.string.LarkCCM_Security_SubmitAppeal_Link);
        s r102 = this.f226500z;
        if (r102 == null) goto L9;
        String r103 = r100.getString(R.string.LarkCCM_Security_UserAgreement_Link);
        String r104 = r102.e();
        Intrinsics.checkNotNull(r104);
        int r105 = StringsKt.indexOf$default(r104, r101, 0, false, 4, null);
        int r106 = r101.length() + r105;
        setText(r104);
        S5(r105, r106, new e(this));
        int r107 = StringsKt.indexOf$default(r104, r103, 0, false, 4, null);
        S5(r107, r103.length() + r107, new f(this));
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void N6() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.INFO);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_info_colorful);
        s r101 = this.f226500z;
        if (r101 == null) goto L9;
        String r102 = r101.d();
        String r103 = r100.getString(R.string.LarkCCM_Security_AppealProgress_Link);
        Intrinsics.checkNotNull(r102);
        int r104 = StringsKt.indexOf$default(r102, r103, 0, false, 4, null);
        int r105 = r103.length() + r104;
        setText(r102);
        S5(r104, r105, new g(this));
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void s6() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        String r101 = r100.getString(R.string.LarkCCM_Security_ContactSupport_Link);
        s r102 = this.f226500z;
        if (r102 == null) goto L9;
        String r103 = r102.b();
        Intrinsics.checkNotNull(r103);
        int r104 = StringsKt.indexOf$default(r103, r101, 0, false, 4, null);
        int r105 = r101.length() + r104;
        setText(r103);
        S5(r104, r105, new b(this));
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void u6() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        s r101 = this.f226500z;
        if (r101 == null) goto L9;
        String r102 = r101.a();
        String r103 = r100.getString(R.string.LarkCCM_Security_ContactSupport_Link);
        Intrinsics.checkNotNull(r102);
        int r104 = StringsKt.indexOf$default(r102, r103, 0, false, 4, null);
        int r105 = r103.length() + r104;
        setText(r102);
        S5(r104, r105, new c(this));
        setVisibility(0);
        return;
    }

    public ForbiddenBannerNewView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public void setViewDelegate(ForbiddenBannerView.a r100) {
        this.f226499y = r100;
    }

    public ForbiddenBannerNewView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void o6(ForbiddenBannerView.ForbiddenState r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f226500z = r101;
        int r102 = a.f226492a[r100.ordinal()];
        if (r102 != 1) goto L5;
        H6();
        return;
    L5:
        if (r102 != 2) goto L7;
        N6();
        return;
    L7:
        if (r102 != 3) goto L9;
        C6();
        return;
    L9:
        if (r102 != 4) goto L11;
        u6();
        return;
    L11:
        if (r102 == 5) goto L13;
        setVisibility(8);
        return;
    L13:
        s6();
    }

    public ForbiddenBannerNewView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}

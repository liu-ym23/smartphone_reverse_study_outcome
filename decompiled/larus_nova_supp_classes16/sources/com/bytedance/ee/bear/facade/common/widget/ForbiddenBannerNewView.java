package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.notice.UDNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerNewView;", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "show", "", "state", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView$ForbiddenState;", "config", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenViewConfig;", "setViewDelegate", "viewDelegate", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView$IViewDelegate;", "showForbiddenWarning", "showInComplaint", "showComplaintFail", "showComplaintExceedLimitsDay", "showComplaintExceedLimits", "showComplaintSuccess", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForbiddenBannerNewView extends ForbiddenBannerView {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForbiddenBannerView.ForbiddenState.values().length];
            r0[ForbiddenBannerView.ForbiddenState.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ForbiddenBannerView.ForbiddenState.IN_COMPLAINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ForbiddenBannerView.ForbiddenState.COMPLAINT_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public b(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.q8();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public c(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.q8();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public d(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.f5();
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public e(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.f5();
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public f(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.B6();
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ ForbiddenBannerNewView a;

        public g(ForbiddenBannerNewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ForbiddenBannerView.a r2 = this.a.y;
            if (r2 == null) goto L6;
            r2.s2();
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void C6() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        String r1 = r0.getString(2131889727);
        s r2 = this.z;
        if (r2 == null) goto L9;
        String r3 = r2.c();
        Intrinsics.checkNotNull(r3);
        int r4 = StringsKt.lastIndexOf$default(r3, r1, 0, false, 6, null);
        int r5 = r1.length() + r4;
        setText(r3);
        S5(r4, r5, new d(this));
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void H6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getString(2131889742);
        s r2 = this.z;
        if (r2 == null) goto L9;
        String r3 = r0.getString(2131889743);
        String r8 = r2.e();
        Intrinsics.checkNotNull(r8);
        int r4 = StringsKt.indexOf$default(r8, r1, 0, false, 4, null);
        int r5 = r1.length() + r4;
        setText(r8);
        S5(r4, r5, new e(this));
        int r6 = StringsKt.indexOf$default(r8, r3, 0, false, 4, null);
        S5(r6, r3.length() + r6, new f(this));
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void N6() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.INFO);
        setIconColorful(true);
        setIcon(2131254918);
        s r1 = this.z;
        if (r1 == null) goto L9;
        String r2 = r1.d();
        String r3 = r0.getString(2131889726);
        Intrinsics.checkNotNull(r2);
        int r4 = StringsKt.indexOf$default(r2, r3, 0, false, 4, null);
        int r5 = r3.length() + r4;
        setText(r2);
        S5(r4, r5, new g(this));
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void s6() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        String r1 = r0.getString(2131889728);
        s r2 = this.z;
        if (r2 == null) goto L9;
        String r3 = r2.b();
        Intrinsics.checkNotNull(r3);
        int r4 = StringsKt.indexOf$default(r3, r1, 0, false, 4, null);
        int r5 = r1.length() + r4;
        setText(r3);
        S5(r4, r5, new b(this));
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void u6() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        s r1 = this.z;
        if (r1 == null) goto L9;
        String r2 = r1.a();
        String r3 = r0.getString(2131889728);
        Intrinsics.checkNotNull(r2);
        int r4 = StringsKt.indexOf$default(r2, r3, 0, false, 4, null);
        int r5 = r3.length() + r4;
        setText(r2);
        S5(r4, r5, new c(this));
        setVisibility(0);
        return;
    }

    public ForbiddenBannerNewView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public void setViewDelegate(ForbiddenBannerView.a r1) {
        this.y = r1;
    }

    public ForbiddenBannerNewView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView
    public final void o6(ForbiddenBannerView.ForbiddenState r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.z = r3;
        int r4 = a.a[r2.ordinal()];
        if (r4 != 1) goto L5;
        H6();
        return;
    L5:
        if (r4 != 2) goto L7;
        N6();
        return;
    L7:
        if (r4 != 3) goto L9;
        C6();
        return;
    L9:
        if (r4 != 4) goto L11;
        u6();
        return;
    L11:
        if (r4 == 5) goto L13;
        setVisibility(8);
        return;
    L13:
        s6();
    }

    public ForbiddenBannerNewView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}

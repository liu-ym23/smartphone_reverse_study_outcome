package com.bytedance.ee.bear.bitable.uikit.empty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.bitable.databinding.BitableUikitEmptyLayoutBinding;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableUikitEmptyLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableUikitEmptyLayoutBinding;", "loading", "Lcom/airbnb/lottie/LottieAnimationView;", "getLoading", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLoading", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyView extends FrameLayout implements gv4.b<EmptyData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableUikitEmptyLayoutBinding f216130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieAnimationView f216131b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f216132a = null;

        static {
            f216132a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleItemModel f216133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f216134b;

        public b(SimpleItemModel r100, gv4.a r101) {
            this.f216133a = r100;
            this.f216134b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActionPayload r101 = this.f216133a.getClickActionPayload();
            if (r101 == null) goto L8;
            gv4.a r102 = this.f216134b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        L9:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleItemModel f216135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f216136b;

        public c(SimpleItemModel r100, gv4.a r101) {
            this.f216135a = r100;
            this.f216136b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActionPayload r101 = this.f216135a.getClickActionPayload();
            if (r101 == null) goto L8;
            gv4.a r102 = this.f216136b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        L9:
            return;
        }
    }

    public final BitableUikitEmptyLayoutBinding getBinding() {
        return this.f216130a;
    }

    public final LottieAnimationView getLoading() {
        return this.f216131b;
    }

    public EmptyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setLoading(LottieAnimationView r100) {
        this.f216131b = r100;
    }

    public EmptyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_uikit_empty_layout, this, false);
        addView(r102);
        int r103 = R.id.empty_state;
        UDEmptyState r104 = (UDEmptyState) ViewBindings.findChildViewById(r102, R.id.empty_state);
        if (r104 == null) goto L12;
        r103 = R.id.empty_view_loading_stub;
        ViewStub r105 = (ViewStub) ViewBindings.findChildViewById(r102, R.id.empty_view_loading_stub);
        if (r105 == null) goto L12;
        ConstraintLayout r106 = (ConstraintLayout) r102;
        Guideline r107 = (Guideline) ViewBindings.findChildViewById(r102, R.id.start_line);
        if (r107 == null) goto L10;
        this.f216130a = new BitableUikitEmptyLayoutBinding(r106, r104, r105, r107);
        setOnClickListener(a.f216132a);
        return;
    L10:
        r103 = R.id.start_line;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public final void a(EmptyData r100, gv4.a r101) {
        if (r100 != null) goto L6;
        m.z(this, false);
        return;
    L6:
        m.z(this, true);
        Icon r102 = r100.getIcon();
        if (r102 == null) goto L9;
        boolean r103 = Intrinsics.areEqual(r102.getLoading(), Boolean.TRUE);
    L10:
        if (r103 == false) goto L12;
        this.f216131b = e.k(true, this.f216131b, this.f216130a.f211061c);
        m.z(this.f216130a.f211060b, false);
    L19:
        Float r104 = r100.getGuidelinePercent();
        if (r104 == null) goto L22;
        float r105 = r104.floatValue();
        this.f216130a.f211062d.setGuidelinePercent(r105);
    L22:
        this.f216130a.f211060b.setTitle(r100.getTitle());
        UDEmptyState r106 = this.f216130a.f211060b;
        CharSequence r107 = r100.getTextEx();
        if (r107 != null) goto L25;
        r107 = r100.getText();
    L25:
        r106.setDesc(r107);
        SimpleItemModel r108 = r100.getButton();
        if (r108 == null) goto L28;
        UDEmptyState r109 = this.f216130a.f211060b;
        r109.showPrimaryAction(true);
        r109.setPrimaryText(r108.getText());
        r109.setPrimaryClickListener(new b(r108, r101));
    L29:
        SimpleItemModel r110 = r100.getSecondaryButton();
        if (r110 == null) goto L32;
        UDEmptyState r111 = this.f216130a.f211060b;
        r111.showSecondaryAction(true);
        r111.setSecondaryText(r110.getText());
        r111.setSecondaryClickListener(new c(r110, r101));
        return;
    L32:
        this.f216130a.f211060b.showSecondaryAction(false);
        Unit r112 = Unit.INSTANCE;
        return;
    L28:
        this.f216130a.f211060b.showPrimaryAction(false);
        Unit r113 = Unit.INSTANCE;
        goto L29
    L12:
        Integer r114 = null;
        if (r100.getIcon() == null) goto L18;
        e.k(false, this.f216131b, null);
        m.z(this.f216130a.f211060b, true);
        UDEmptyState r115 = this.f216130a.f211060b;
        Icon r116 = r100.getIcon();
        if (r116 == null) goto L17;
        r114 = r116.getImgRes(getContext());
    L17:
        r115.setImageRes(r114);
        goto L19
    L18:
        e.k(false, this.f216131b, null);
        m.z(this.f216130a.f211060b, true);
        this.f216130a.f211060b.setImageRes(0);
        goto L19
    L9:
        r103 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 8) goto L6;
        e.k(false, this.f216131b, null);
        return;
    }
}

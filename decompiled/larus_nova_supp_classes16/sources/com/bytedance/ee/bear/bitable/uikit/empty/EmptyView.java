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
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableUikitEmptyLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableUikitEmptyLayoutBinding;", "loading", "Lcom/airbnb/lottie/LottieAnimationView;", "getLoading", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLoading", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyView extends FrameLayout implements gv4.b<EmptyData> {
    public final BitableUikitEmptyLayoutBinding a;
    public LottieAnimationView b;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SimpleItemModel a;
        public final /* synthetic */ gv4.a b;

        public b(SimpleItemModel r1, gv4.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ActionPayload r3 = this.a.getClickActionPayload();
            if (r3 == null) goto L8;
            gv4.a r0 = this.b;
            if (r0 == null) goto L9;
            r0.a(r3);
            return;
        L9:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SimpleItemModel a;
        public final /* synthetic */ gv4.a b;

        public c(SimpleItemModel r1, gv4.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ActionPayload r3 = this.a.getClickActionPayload();
            if (r3 == null) goto L8;
            gv4.a r0 = this.b;
            if (r0 == null) goto L9;
            r0.a(r3);
            return;
        L9:
            return;
        }
    }

    public final BitableUikitEmptyLayoutBinding getBinding() {
        return this.a;
    }

    public final LottieAnimationView getLoading() {
        return this.b;
    }

    public EmptyView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setLoading(LottieAnimationView r1) {
        this.b = r1;
    }

    public EmptyView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        ConstraintLayout r7 = LayoutInflater.from(r5).inflate(2131559180, this, false);
        addView(r7);
        int r8 = 2131371597;
        UDEmptyState r0 = ViewBindings.findChildViewById(r7, 2131371597);
        if (r0 == null) goto L12;
        r8 = 2131371609;
        ViewStub r1 = (ViewStub) ViewBindings.findChildViewById(r7, 2131371609);
        if (r1 == null) goto L12;
        ConstraintLayout r9 = r7;
        Guideline r3 = ViewBindings.findChildViewById(r7, 2131387219);
        if (r3 == null) goto L10;
        this.a = new BitableUikitEmptyLayoutBinding(r9, r0, r1, r3);
        setOnClickListener(a.a);
        return;
    L10:
        r8 = 2131387219;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }

    public final void a(EmptyData r6, gv4.a r7) {
        if (r6 != null) goto L6;
        m.z(this, false);
        return;
    L6:
        m.z(this, true);
        Icon r2 = r6.getIcon();
        if (r2 == null) goto L9;
        boolean r3 = Intrinsics.areEqual(r2.getLoading(), Boolean.TRUE);
    L10:
        if (r3 == false) goto L12;
        this.b = e.k(true, this.b, this.a.c);
        m.z(this.a.b, false);
    L19:
        Float r4 = r6.getGuidelinePercent();
        if (r4 == null) goto L22;
        float r5 = r4.floatValue();
        this.a.d.setGuidelinePercent(r5);
    L22:
        this.a.b.setTitle(r6.getTitle());
        UDEmptyState r8 = this.a.b;
        CharSequence r9 = r6.getTextEx();
        if (r9 != null) goto L25;
        r9 = r6.getText();
    L25:
        r8.setDesc(r9);
        SimpleItemModel r10 = r6.getButton();
        if (r10 == null) goto L28;
        UDEmptyState r11 = this.a.b;
        r11.showPrimaryAction(true);
        r11.setPrimaryText(r10.getText());
        r11.setPrimaryClickListener(new b(r10, r7));
    L29:
        SimpleItemModel r12 = r6.getSecondaryButton();
        if (r12 == null) goto L32;
        UDEmptyState r0 = this.a.b;
        r0.showSecondaryAction(true);
        r0.setSecondaryText(r12.getText());
        r0.setSecondaryClickListener(new c(r12, r7));
        return;
    L32:
        this.a.b.showSecondaryAction(false);
        Unit r13 = Unit.INSTANCE;
        return;
    L28:
        this.a.b.showPrimaryAction(false);
        Unit r14 = Unit.INSTANCE;
        goto L29
    L12:
        Integer r16 = null;
        if (r6.getIcon() == null) goto L18;
        e.k(false, this.b, null);
        m.z(this.a.b, true);
        UDEmptyState r17 = this.a.b;
        Icon r18 = r6.getIcon();
        if (r18 == null) goto L17;
        r16 = r18.getImgRes(getContext());
    L17:
        r17.setImageRes(r16);
        goto L19
    L18:
        e.k(false, this.b, null);
        m.z(this.a.b, true);
        this.a.b.setImageRes(0);
        goto L19
    L9:
        r3 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 8) goto L6;
        e.k(false, this.b, null);
        return;
    }
}

package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.bitable.baseadd.RecordSubmitState;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordFooterChild3Binding;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0002J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterChild3;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/FooterChild;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild3Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild3Binding;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "animSet", "Landroid/animation/AnimatorSet;", "mTargetVisibility", "", "state", "Lcom/bytedance/ee/bear/bitable/baseadd/RecordSubmitState;", "getState", "()Lcom/bytedance/ee/bear/bitable/baseadd/RecordSubmitState;", "setState", "(Lcom/bytedance/ee/bear/bitable/baseadd/RecordSubmitState;)V", "needFollowScroll", "", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateVisible", "updateSubmitView", "setSubmitNormal", "startLoading", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterChild3 extends FooterChild {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f214174f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f214175g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordFooterChild3Binding f214176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDLoadingDrawable f214177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimatorSet f214178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f214179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecordSubmitState f214180e;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordFooterChild3 f214181a;

        public b(ItemViewRecordFooterChild3 r100) {
            this.f214181a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            ItemViewRecordFooterChild3.b(this.f214181a);
            this.f214181a.d(RecordSubmitState.NORMAL);
        }
    }

    static {
        f214174f = UIHelper.dp2px(78.0f);
        f214175g = UIHelper.dp2px(16.0f);
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.FooterChild
    public final boolean a() {
        if (this.f214180e != RecordSubmitState.NORMAL) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c() {
        ViewGroup.LayoutParams r100 = this.f214176a.f210901d.getLayoutParams();
        if (r100 == null) goto L5;
        r100.width = -2;
    L5:
        this.f214176a.f210900c.setTranslationX(0.0f);
        this.f214176a.f210900c.setAlpha(1.0f);
    }

    public final BitableItemViewRecordFooterChild3Binding getBinding() {
        return this.f214176a;
    }

    public final RecordSubmitState getState() {
        return this.f214180e;
    }

    public ItemViewRecordFooterChild3(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final void b(ItemViewRecordFooterChild3 r100) {
        super.setVisibility(r100.f214179d);
    }

    public final void d(RecordSubmitState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterChild3.update submit state " + r100, null, null, null, 14);
        this.f214180e = r100;
        if (r100 != RecordSubmitState.NORMAL) goto L5;
    L21:
        c();
        this.f214176a.f210900c.setEnabled(true);
        this.f214176a.f210901d.setBackgroundResource(R.drawable.bitable_page_submit_record_bg);
        this.f214176a.f210899b.setImageResource(R.drawable.ud_icon_done_outlined);
        UDLoadingDrawable r101 = this.f214177b;
        if (r101 == null) goto L24;
        r101.stop();
    L24:
        this.f214176a.f210902e.setText(getContext().getString(R.string.Bitable_QuickAdd_Submit_Button));
        return;
    L5:
        if (r100 == RecordSubmitState.FAIL) goto L21;
        if (r100 != RecordSubmitState.LOADING) goto L16;
        c();
        this.f214176a.f210900c.setEnabled(false);
        this.f214176a.f210901d.setBackgroundResource(R.drawable.bitable_page_submit_record_bg);
        this.f214176a.f210902e.setText(getContext().getString(R.string.Bitable_QuickAdd_Submit_Button));
        if (this.f214177b != null) goto L12;
        UDLoadingDrawable r102 = new UDLoadingDrawable(getContext());
        r102.setColorSchemeColors(new int[]{UDColorUtils.getColor(getContext(), R.color.static_white)});
        r102.setStrokeWidth(h18.d.a(getContext(), 2.0f));
        r102.setCenterRadius(h18.d.a(getContext(), 6.0f));
        this.f214177b = r102;
    L12:
        this.f214176a.f210899b.setImageDrawable(this.f214177b);
        UDLoadingDrawable r103 = this.f214177b;
        if (r103 == null) goto L26;
        r103.start();
        return;
    L26:
        return;
    L16:
        if (r100 != RecordSubmitState.SUCCESS) goto L28;
        int r104 = this.f214176a.f210901d.getMeasuredWidth();
        float r105 = this.f214176a.f210902e.getPaint().measureText(getContext().getString(R.string.Bitable_QuickAdd_SubmitSuccess_Toast)) + f214174f;
        float r106 = f214175g + r105;
        this.f214176a.f210900c.setEnabled(false);
        this.f214176a.f210901d.setBackgroundResource(R.drawable.bitable_page_submit_record_success_bg);
        this.f214176a.f210899b.setImageResource(R.drawable.ud_icon_done_outlined);
        UDLoadingDrawable r107 = this.f214177b;
        if (r107 == null) goto L20;
        r107.stop();
    L20:
        this.f214176a.f210902e.setText(getContext().getString(R.string.Bitable_QuickAdd_SubmitSuccess_Toast));
        com.bytedance.ee.util.ui.g.c(this.f214176a.f210901d, r104, (int) r105).setDuration(200).start();
        this.f214178c.setDuration(200);
        this.f214178c.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f214176a.f210900c, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, r106}), ObjectAnimator.ofFloat(this.f214176a.f210900c, "alpha", new float[]{1.0f, 0.0f})});
        this.f214178c.setStartDelay(1000);
        this.f214178c.addListener(new b(this));
        this.f214178c.start();
        return;
    }

    public final void setState(RecordSubmitState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214180e = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        this.f214179d = r100;
        if (this.f214180e != RecordSubmitState.LOADING) goto L10;
        if (getVisibility() != 0) goto L10;
        if (r100 != 8) goto L10;
        d(RecordSubmitState.SUCCESS);
        return;
    L10:
        if (this.f214180e == RecordSubmitState.SUCCESS) goto L14;
        super.setVisibility(r100);
        return;
    }

    public ItemViewRecordFooterChild3(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_record_footer_child3, this);
        int r102 = R.id.submit_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.submit_icon);
        if (r103 == null) goto L13;
        r102 = R.id.submit_layout;
        UDShadowLayout r104 = (UDShadowLayout) ViewBindings.findChildViewById(this, R.id.submit_layout);
        if (r104 == null) goto L13;
        r102 = R.id.submit_record;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.submit_record);
        if (r105 == null) goto L13;
        r102 = R.id.submit_state;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.submit_state);
        if (r106 == null) goto L13;
        this.f214176a = new BitableItemViewRecordFooterChild3Binding(this, r103, r104, r105, r106);
        this.f214178c = new AnimatorSet();
        this.f214179d = 8;
        this.f214180e = RecordSubmitState.NORMAL;
        com.bytedance.ee.bear.bitable.common.e.b(this, 0.95f, 4);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    @Override // gv4.b
    public final void iq(Object r100, t r101) {
        ItemViewRecordFooterData r102 = (ItemViewRecordFooterData) r100;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isSubmitNormal() == false) goto L8;
        this.f214178c.cancel();
        d(RecordSubmitState.NORMAL);
    L8:
        if (r102.isSubmitSuccess() == false) goto L10;
        this.f214178c.cancel();
        d(RecordSubmitState.SUCCESS);
    L10:
        this.f214176a.f210900c.setOnClickListener(new i(r102, this, r101));
    }
}

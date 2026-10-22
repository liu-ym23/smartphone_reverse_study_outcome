package com.ss.android.lark.security.compliance.infra.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.security.compliance.infra.databinding.ScsWidgetCustomApplyButtonBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/widget/CustomApplyButton;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "status", "Lcom/ss/android/lark/security/compliance/infra/widget/CustomApplyButton$ApplyButtonStatus;", "viewBinding", "Lcom/ss/android/lark/security/compliance/infra/databinding/ScsWidgetCustomApplyButtonBinding;", "updateStatus", "", "startLoading", "cancelLoading", "setText", "text", "", "setOnClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "getRotateAnimation", "Landroid/view/animation/Animation;", "onDetachedFromWindow", "ApplyButtonStatus", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomApplyButton extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ApplyButtonStatus f440482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScsWidgetCustomApplyButtonBinding f440483b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/widget/CustomApplyButton$ApplyButtonStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLE", "ENABLE", "LOADING", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ApplyButtonStatus extends Enum<ApplyButtonStatus> {
        public static final ApplyButtonStatus DISABLE = null;
        public static final ApplyButtonStatus ENABLE = null;
        public static final ApplyButtonStatus LOADING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ApplyButtonStatus[] f440484a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440485b = null;

        public static EnumEntries<ApplyButtonStatus> getEntries() {
            return f440485b;
        }

        static {
            ApplyButtonStatus r100 = new ApplyButtonStatus("DISABLE", 0);
            DISABLE = r100;
            ApplyButtonStatus r101 = new ApplyButtonStatus("ENABLE", 1);
            ENABLE = r101;
            ApplyButtonStatus r102 = new ApplyButtonStatus("LOADING", 2);
            LOADING = r102;
            ApplyButtonStatus[] r103 = {r100, r101, r102};
            f440484a = r103;
            f440485b = EnumEntriesKt.enumEntries(r103);
        }

        public static ApplyButtonStatus[] values() {
            return (ApplyButtonStatus[]) f440484a.clone();
        }

        public static ApplyButtonStatus valueOf(String r100) {
            return (ApplyButtonStatus) r27.a.a(ApplyButtonStatus.class, r100);
        }

        public ApplyButtonStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440486a = null;

        static {
            int[] r100 = new int[ApplyButtonStatus.values().length];
            r100[ApplyButtonStatus.DISABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ApplyButtonStatus.ENABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ApplyButtonStatus.LOADING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f440486a = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomApplyButton f440487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f440488b;

        public b(CustomApplyButton r100, Function0<Unit> r101) {
            this.f440487a = r100;
            this.f440488b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CustomApplyButton r101 = this.f440487a;
            if (r101.f440482a != ApplyButtonStatus.ENABLE) goto L6;
            r101.b(ApplyButtonStatus.LOADING);
            CustomApplyButton.a(this.f440487a);
            this.f440488b.invoke();
            return;
        }
    }

    private final Animation getRotateAnimation() {
        RotateAnimation r100 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r100.setInterpolator(new LinearInterpolator());
        r100.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r100.setRepeatCount(-1);
        r100.setRepeatMode(1);
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f440483b.f440427c.getAnimation() == null) goto L5;
        this.f440483b.f440427c.clearAnimation();
    L5:
        super.onDetachedFromWindow();
    }

    public CustomApplyButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    public static final void a(CustomApplyButton r100) {
        r100.f440483b.f440427c.startAnimation(r100.getRotateAnimation());
    }

    public final void b(ApplyButtonStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (this.f440482a != r100) goto L5;
        return;
    L5:
        this.f440482a = r100;
        int r101 = a.f440486a[r100.ordinal()];
        if (r101 != 1) goto L8;
        this.f440483b.f440427c.setVisibility(4);
        this.f440483b.f440426b.setTextColor(getResources().getColor(R.color.text_disable));
        return;
    L8:
        if (r101 != 2) goto L10;
        this.f440483b.f440427c.setVisibility(4);
        this.f440483b.f440426b.setTextColor(getResources().getColor(R.color.primary_pri_500));
        return;
    L10:
        if (r101 != 3) goto L13;
        this.f440483b.f440427c.setVisibility(0);
        this.f440483b.f440426b.setTextColor(getResources().getColor(R.color.primary_content_loading));
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void setOnClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f440483b.f440426b.setOnClickListener(new b(this, r100));
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f440483b.f440426b.setText(r100);
    }

    public CustomApplyButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public CustomApplyButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f440482a = ApplyButtonStatus.DISABLE;
        setOrientation(0);
        LayoutInflater.from(r100).inflate(R.layout.scs_widget_custom_apply_button, this);
        int r103 = R.id.applyTextView;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.applyTextView);
        if (r104 == null) goto L9;
        r103 = R.id.loadingView;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.loadingView);
        if (r105 == null) goto L9;
        this.f440483b = new ScsWidgetCustomApplyButtonBinding(this, r104, r105);
        setGravity(16);
        b(ApplyButtonStatus.ENABLE);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }
}

package com.larus.login.impl.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import ck9.c;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u001eJ\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u001eJ\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020 H\u0002J\u0010\u00103\u001a\u00020\u00182\u0006\u00102\u001a\u00020 H\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0007H\u0002J\n\u0010:\u001a\u0004\u0018\u000107H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006<"}, d2 = {"Lcom/larus/login/impl/view/PhoneLoginButtonView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonLogin", "Landroid/widget/Button;", "getButtonLogin", "()Landroid/widget/Button;", "buttonIv", "Landroid/widget/ImageView;", "getButtonIv", "()Landroid/widget/ImageView;", "carrierContainer", "Landroid/widget/LinearLayout;", "tvMaskPhone", "Landroid/widget/TextView;", "onCarrierEditClick", "Lkotlin/Function0;", "", "getOnCarrierEditClick", "()Lkotlin/jvm/functions/Function0;", "setOnCarrierEditClick", "(Lkotlin/jvm/functions/Function0;)V", "shown", "", "lastMaskPhone", "", "lastCarrier", "Lcom/larus/account/base/model/PhoneOneKeyPlatform;", "lastRenderAt", "", "expandAnimator", "Landroid/animation/ValueAnimator;", "lastExpandAt", "carrierTargetHeight", "getCarrierTargetHeight", "()I", "renderCarrier", "phoneOneKeyInfo", "Lcom/larus/account/base/api/PhoneOneKeyInfo;", "animate", "hideCarrier", "isCarrierShown", "showCarrierImmediate", "maskPhone", "showCarrierWithAnimation", "expandCarrierFromZeroHeight", "onExpandFinished", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "shrinkLoginItemsPadding", "amount", "findLoginItemsParent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneLoginButtonView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Interpolator f358352m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f358353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f358354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f358355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f358357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f358358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f358359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PhoneOneKeyPlatform f358360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f358361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f358362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f358363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f358364l;

    public static final class a {
    }

    public PhoneLoginButtonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhoneLoginButtonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f358352m = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
    }

    public final void a() {
        if (this.f358358f == false) goto L5;
    L7:
        FLogger.f375446a.i("PhoneLoginButtonView", "hideCarrier");
        this.f358358f = false;
        this.f358359g = null;
        this.f358360h = null;
        ValueAnimator r100 = this.f358362j;
        if (r100 == null) goto L10;
        r100.cancel();
    L10:
        this.f358355c.setVisibility(8);
        return;
    L5:
        if (this.f358355c.getVisibility() == 0) goto L7;
    }

    public final ImageView getButtonIv() {
        return this.f358354b;
    }

    public final Button getButtonLogin() {
        return this.f358353a;
    }

    public final int getCarrierTargetHeight() {
        return this.f358364l;
    }

    public final Function0<Unit> getOnCarrierEditClick() {
        return this.f358357e;
    }

    public final void b(String r100) {
        ValueAnimator r101 = this.f358362j;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f358356d.setText(r100);
        ViewGroup.LayoutParams r102 = this.f358355c.getLayoutParams();
        if (r102 == null) goto L8;
        r102.height = -2;
    L8:
        this.f358355c.setLayoutParams(r102);
        this.f358355c.setAlpha(1.0f);
        this.f358355c.setVisibility(0);
        int r103 = this.f358364l;
        ViewParent r104 = getParent();
    L10:
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
        if (r105.getId() == R.id.login_items) goto L16;
        r104 = r105.getParent();
    L16:
        if (r105 == null) goto L22;
        r105.setPadding(r105.getPaddingLeft(), r105.getPaddingTop(), r105.getPaddingRight(), RangesKt.coerceAtLeast(r105.getPaddingBottom() - r103, 0));
        return;
    L22:
        return;
    L15:
        r105 = null;
        goto L16
    }

    public final void setOnCarrierEditClick(Function0<Unit> r100) {
        this.f358357e = r100;
    }

    public PhoneLoginButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setId(R.id.button_login_layout);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(1);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        addView(r103);
        LayoutInflater.from(r100).inflate(R.layout.larus_account_phone_login_button, r103, true);
        this.f358353a = (Button) findViewById(R.id.button_login);
        this.f358354b = (ImageView) findViewById(R.id.button_iv);
        LinearLayout r104 = (LinearLayout) findViewById(R.id.carrier_phone_container);
        this.f358355c = r104;
        this.f358356d = (TextView) findViewById(R.id.tv_mask_phone);
        r104.setOnClickListener(new c(this));
        this.f358364l = ((Number) i5.C.getValue()).intValue();
    }

    public /* synthetic */ PhoneLoginButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

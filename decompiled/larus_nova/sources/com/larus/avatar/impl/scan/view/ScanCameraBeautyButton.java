package com.larus.avatar.impl.scan.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p88.f;
import p88.g;
import v19.c;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyButton;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "currentLevel", "Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyLevel;", "beautyClickListener", "Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyButton$OnBeautyClickListener;", "isAnimating", "", "setBeautyLevel", "", "level", "getBeautyLevel", "setOnBeautyClickListener", "listener", "updateUI", "playIconSwitchAnimation", "newIconRes", "OnBeautyClickListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCameraBeautyButton extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f291180f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f291181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f291182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScanCameraBeautyLevel f291183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f291184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f291185e;

    public interface a {
        void a(ScanCameraBeautyLevel r100);
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f291186a = null;

        static {
            int[] r100 = new int[ScanCameraBeautyLevel.values().length];
            r100[ScanCameraBeautyLevel.NATURAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ScanCameraBeautyLevel.ENHANCED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ScanCameraBeautyLevel.OFF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f291186a = r100;
        }
    }

    public ScanCameraBeautyButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScanCameraBeautyButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ScanCameraBeautyLevel getBeautyLevel() {
        return this.f291183c;
    }

    public final void a(ScanCameraBeautyLevel r110) {
        int r100 = b.f291186a[r110.ordinal()];
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L9;
        if (r100 != 3) goto L8;
        int r101 = R.drawable.larus_digital_avatar_ic_beauty_off;
    L11:
        String r102 = null;
        if (this.f291181a.getDrawable() != null) goto L14;
        this.f291181a.setImageResource(r101);
    L21:
        TextView r103 = this.f291182b;
        Context r104 = getContext();
        if (r104 == null) goto L26;
        String r105 = r104.getString(R.string.larus_simplifyReplicaGen_pillEnhance);
        if (r105 == null) goto L26;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r102 = String.format(r105, Arrays.copyOf(new Object[]{r110.getDisplayName()}, 1));
    L26:
        r103.setText(r102);
        return;
    L14:
        this.f291185e = true;
        LinearInterpolator r107 = new LinearInterpolator();
        ViewParent r108 = this.f291181a.getParent();
        if ((r108 instanceof ViewGroup) == false) goto L17;
        ViewGroup r109 = (ViewGroup) r108;
    L18:
        if (r109 == null) goto L21;
        ImageView r111 = new ImageView(getContext());
        r111.setImageDrawable(this.f291181a.getDrawable());
        r111.setLayoutParams(this.f291181a.getLayoutParams());
        r111.setScaleType(this.f291181a.getScaleType());
        r109.addView(r111);
        AnimatorSet r112 = new AnimatorSet();
        r112.playTogether(new Animator[]{ObjectAnimator.ofFloat(r111, View.SCALE_X, new float[]{1.0f, 0.8f}), ObjectAnimator.ofFloat(r111, View.SCALE_Y, new float[]{1.0f, 0.8f}), ObjectAnimator.ofFloat(r111, View.ALPHA, new float[]{1.0f, 0.0f})});
        r112.setDuration(150);
        r112.setInterpolator(r107);
        this.f291181a.setImageResource(r101);
        this.f291181a.setScaleX(0.8f);
        this.f291181a.setScaleY(0.8f);
        this.f291181a.setAlpha(0.0f);
        AnimatorSet r113 = new AnimatorSet();
        r113.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f291181a, View.SCALE_X, new float[]{0.8f, 1.0f}), ObjectAnimator.ofFloat(this.f291181a, View.SCALE_Y, new float[]{0.8f, 1.0f}), ObjectAnimator.ofFloat(this.f291181a, View.ALPHA, new float[]{0.0f, 1.0f})});
        r113.setDuration(150);
        r113.setInterpolator(r107);
        r112.addListener(new g(r109, r111, this));
        r112.start();
        r113.start();
        goto L21
    L17:
        r109 = null;
        goto L18
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r101 = R.drawable.larus_digital_avatar_ic_beauty_enhanced;
        goto L11
    L10:
        r101 = R.drawable.larus_digital_avatar_ic_beauty_natural;
        goto L11
    }

    public final void setBeautyLevel(ScanCameraBeautyLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
        this.f291183c = r100;
        a(r100);
    }

    public final void setOnBeautyClickListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291184d = r100;
    }

    public ScanCameraBeautyButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ScanCameraBeautyLevel r103 = ScanCameraBeautyLevel.NATURAL;
        this.f291183c = r103;
        setOrientation(0);
        setGravity(17);
        int r104 = j0.f375426a;
        int r105 = j0.b(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        int r106 = j0.b(c.b(R.attr.larus_dp_10, null, R.dimen.larus_dp_10));
        setPadding(r105, r106, r105, r106);
        View r107 = LayoutInflater.from(r100).inflate(R.layout.larus_view_beauty_button, this, true);
        this.f291181a = (ImageView) r107.findViewById(R.id.beauty_icon);
        this.f291182b = (TextView) r107.findViewById(R.id.beauty_text);
        setBackgroundResource(R.drawable.larus_digital_avatar_beauty_btn_bg);
        e1.d(this, new f(this));
        a(r103);
    }

    public /* synthetic */ ScanCameraBeautyButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

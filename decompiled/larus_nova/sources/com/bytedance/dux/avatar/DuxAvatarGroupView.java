package com.bytedance.dux.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enable", "", "setAdaptLargeFont", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/dux/avatar/DuxAvatar;", "getTopAvatar", "getUnderAvatar", "Lcom/bytedance/dux/avatar/DuxAvatar$AvatarSize;", "size", "setAvatarGroupSize", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxAvatarGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f204819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxAvatar f204820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxAvatar f204821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f204822d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204823a = null;

        static {
            int[] r100 = new int[DuxAvatar.AvatarSize.values().length];
            r100[DuxAvatar.AvatarSize.DP_24.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[DuxAvatar.AvatarSize.DP_32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[DuxAvatar.AvatarSize.DP_36.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DuxAvatar.AvatarSize.DP_40.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[DuxAvatar.AvatarSize.DP_48.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[DuxAvatar.AvatarSize.DP_56.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[DuxAvatar.AvatarSize.DP_64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[DuxAvatar.AvatarSize.DP_72.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f204823a = r100;
        }
    }

    public DuxAvatarGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 14);
    }

    public DuxAvatarGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 12);
    }

    public final DuxAvatar getTopAvatar() {
        return this.f204821c;
    }

    public final DuxAvatar getUnderAvatar() {
        return this.f204820b;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f204822d = DuxLargeFontHelper.a(DuxAvatar.f204807i, r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setAvatarGroupSize(DuxAvatar.AvatarSize r110) {
        Intrinsics.checkNotNullParameter(r110, "size");
        switch(a.f204823a[r110.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        DuxAvatar.AvatarSize r100 = DuxAvatar.AvatarSize.DP_48;
    L15:
        if (r110.getDpValue() < DuxAvatar.AvatarSize.DP_56.getDpValue()) goto L17;
        float r101 = 3;
        DisplayMetrics r102 = R5(Resources.getSystem());
    L18:
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101, r102));
        DuxAvatar r104 = this.f204821c;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L91;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        int r107 = r103 * 2;
        int r108 = r100.getDpValue();
        boolean r109 = this.f204822d;
        if (r109 == true) goto L23;
    L25:
        if (r109 == true) goto L27;
    L29:
        int r111 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L30:
        r106.width = r111 + r107;
        int r112 = r100.getDpValue();
        boolean r113 = this.f204822d;
        if (r113 == true) goto L33;
    L35:
        if (r113 == true) goto L37;
    L39:
        int r114 = MathKt.roundToInt(TypedValue.applyDimension(1, r112, R5(Resources.getSystem())));
    L40:
        r106.height = r114 + r107;
        r104.setLayoutParams(r106);
        r104.setAvatarInset(r103);
        float r115 = r103;
        float r116 = -r115;
        r104.setTranslationX(r116);
        r104.setTranslationY(r115);
        DuxAvatar r117 = this.f204820b;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L89;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        int r120 = r100.getDpValue();
        boolean r121 = this.f204822d;
        if (r121 == true) goto L45;
    L47:
        if (r121 == true) goto L49;
    L51:
        int r122 = MathKt.roundToInt(TypedValue.applyDimension(1, r120, R5(Resources.getSystem())));
    L52:
        r119.width = r122 + r107;
        int r123 = r100.getDpValue();
        boolean r124 = this.f204822d;
        if (r124 == true) goto L55;
    L57:
        if (r124 == true) goto L59;
    L61:
        int r125 = MathKt.roundToInt(TypedValue.applyDimension(1, r123, R5(Resources.getSystem())));
    L62:
        r119.height = r107 + r125;
        r117.setLayoutParams(r119);
        r117.setAvatarInset(r103);
        r117.setTranslationX(r115);
        r117.setTranslationY(r116);
        ViewGroup.LayoutParams r126 = getLayoutParams();
        if (r126 == null) goto L87;
        int r127 = r110.getDpValue();
        boolean r128 = this.f204822d;
        if (r128 == true) goto L67;
    L69:
        if (r128 == true) goto L71;
    L73:
        int r129 = MathKt.roundToInt(TypedValue.applyDimension(1, r127, R5(Resources.getSystem())));
    L74:
        r126.height = r129;
        int r130 = r110.getDpValue();
        boolean r131 = this.f204822d;
        if (r131 == true) goto L77;
    L79:
        if (r131 == true) goto L81;
    L83:
        int r132 = MathKt.roundToInt(TypedValue.applyDimension(1, r130, R5(Resources.getSystem())));
    L84:
        r126.width = r132;
        setLayoutParams(r126);
        return;
    L81:
        if (this.f204819a == true) goto L83;
        r132 = MathKt.roundToInt(TypedValue.applyDimension(2, r130, R5(Resources.getSystem())));
        goto L84
    L77:
        if (this.f204819a == false) goto L79;
        r132 = MathKt.roundToInt(TypedValue.applyDimension(1, r130 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L84
    L71:
        if (this.f204819a == true) goto L73;
        r129 = MathKt.roundToInt(TypedValue.applyDimension(2, r127, R5(Resources.getSystem())));
        goto L74
    L67:
        if (this.f204819a == false) goto L69;
        r129 = MathKt.roundToInt(TypedValue.applyDimension(1, r127 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L74
    L87:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L59:
        if (this.f204819a == true) goto L61;
        r125 = MathKt.roundToInt(TypedValue.applyDimension(2, r123, R5(Resources.getSystem())));
        goto L62
    L55:
        if (this.f204819a == false) goto L57;
        r125 = MathKt.roundToInt(TypedValue.applyDimension(1, r123 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L62
    L49:
        if (this.f204819a == true) goto L51;
        r122 = MathKt.roundToInt(TypedValue.applyDimension(2, r120, R5(Resources.getSystem())));
        goto L52
    L45:
        if (this.f204819a == false) goto L47;
        r122 = MathKt.roundToInt(TypedValue.applyDimension(1, r120 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L52
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L37:
        if (this.f204819a == true) goto L39;
        r114 = MathKt.roundToInt(TypedValue.applyDimension(2, r112, R5(Resources.getSystem())));
        goto L40
    L33:
        if (this.f204819a == false) goto L35;
        r114 = MathKt.roundToInt(TypedValue.applyDimension(1, r112 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L40
    L27:
        if (this.f204819a == true) goto L29;
        r111 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L30
    L23:
        if (this.f204819a == false) goto L25;
        r111 = MathKt.roundToInt(TypedValue.applyDimension(1, r108 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L30
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        r101 = 2;
        r102 = R5(Resources.getSystem());
        goto L18
    L7:
        r100 = DuxAvatar.AvatarSize.DP_40;
        goto L15
    L8:
        r100 = DuxAvatar.AvatarSize.DP_40;
        goto L15
    L9:
        r100 = DuxAvatar.AvatarSize.DP_32;
        goto L15
    L10:
        r100 = DuxAvatar.AvatarSize.DP_24;
        goto L15
    L11:
        r100 = DuxAvatar.AvatarSize.DP_24;
        goto L15
    L12:
        r100 = DuxAvatar.AvatarSize.DP_20;
        goto L15
    L13:
        r100 = DuxAvatar.AvatarSize.DP_16;
        goto L15
    L5:
        throw new IllegalArgumentException("disallow the size: " + r110);
    }

    public DuxAvatarGroupView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f204819a = false;
        Lazy r103 = DuxLargeFontHelper.f205243a;
        this.f204822d = DuxLargeFontHelper.a(DuxAvatar.f204807i, null);
        ViewGroup.inflate(r100, R.layout.dux_widget_avatar_group, this);
        this.f204820b = (DuxAvatar) findViewById(R.id.under_avatar);
        this.f204821c = (DuxAvatar) findViewById(R.id.top_avatar);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.limitLargeFontScale});
        if (r104.hasValue(0) == false) goto L9;
        setAdaptLargeFont(Boolean.valueOf(r104.getBoolean(0, false)));
    L9:
        if (r104.hasValue(1) == false) goto L11;
        this.f204819a = r104.getBoolean(1, false);
    L11:
        r104.recycle();
    }
}

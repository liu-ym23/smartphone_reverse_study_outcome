package com.bytedance.dux.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.api.IDuxComponentService;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.widget.DuxCircleImageView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enable", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/dux/avatar/DuxAvatar$AvatarSize;", "size", "setAvatarSize", "", "inset", "setAvatarInset", "color", "setIconBorderColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setAvatar", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "Lcom/bytedance/dux/avatar/DuxAvatar$IconType;", "iconType", "setIconType", "Lcom/bytedance/dux/widget/DuxCircleImageView;", "getContentImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "getLogoImageView", "AvatarSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "IconType", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxAvatar extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DuxComponent f204807i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f204808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxCircleImageView f204809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxCircleImageView f204810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f204811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Space f204812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IconType f204813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f204814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f204815h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatar$AvatarSize;", "", "", "dpValue", "I", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_36", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum AvatarSize extends Enum<AvatarSize> {
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_36 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AvatarSize[] f204816a = null;
        private final int dpValue;

        public static AvatarSize valueOf(String r100) {
            return (AvatarSize) r27.a.a(AvatarSize.class, r100);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) f204816a.clone();
        }

        static {
            AvatarSize r100 = new AvatarSize("DP_16", 0, 16);
            DP_16 = r100;
            AvatarSize r101 = new AvatarSize("DP_20", 1, 20);
            DP_20 = r101;
            AvatarSize r102 = new AvatarSize("DP_24", 2, 24);
            DP_24 = r102;
            AvatarSize r103 = new AvatarSize("DP_32", 3, 32);
            DP_32 = r103;
            AvatarSize r104 = new AvatarSize("DP_36", 4, 36);
            DP_36 = r104;
            AvatarSize r105 = new AvatarSize("DP_40", 5, 40);
            DP_40 = r105;
            AvatarSize r110 = new AvatarSize("DP_48", 6, 48);
            DP_48 = r110;
            AvatarSize r111 = new AvatarSize("DP_56", 7, 56);
            DP_56 = r111;
            AvatarSize r112 = new AvatarSize("DP_64", 8, 64);
            DP_64 = r112;
            AvatarSize r113 = new AvatarSize("DP_72", 9, 72);
            DP_72 = r113;
            f204816a = new AvatarSize[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public final int getDpValue() {
            return this.dpValue;
        }

        public AvatarSize(String r100, int r101, int r102) {
            super(r100, r101);
            this.dpValue = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatar$IconType;", "", "ONLINE", "LOGO", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum IconType extends Enum<IconType> {
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IconType[] f204817a = null;

        public static IconType valueOf(String r100) {
            return (IconType) r27.a.a(IconType.class, r100);
        }

        public static IconType[] values() {
            return (IconType[]) f204817a.clone();
        }

        static {
            IconType r100 = new IconType("ONLINE", 0);
            ONLINE = r100;
            IconType r101 = new IconType("LOGO", 1);
            LOGO = r101;
            f204817a = new IconType[]{r100, r101};
        }

        public IconType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204818a = null;

        static {
            int[] r100 = new int[AvatarSize.values().length];
            r100[AvatarSize.DP_24.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[AvatarSize.DP_32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L44:
            r100[AvatarSize.DP_36.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L32:
            r100[AvatarSize.DP_40.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L34:
            r100[AvatarSize.DP_48.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L26:
            r100[AvatarSize.DP_56.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L36:
            r100[AvatarSize.DP_64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L38:
            r100[AvatarSize.DP_72.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L12:
            f204818a = r100;
            int[] r101 = new int[IconType.values().length];
            r101[IconType.LOGO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L28:
            r101[IconType.ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public DuxAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 14);
    }

    public DuxAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 12);
    }

    static {
        f204807i = DuxComponent.AVATAR;
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.f204811d;
    }

    public final DuxCircleImageView getContentImageView() {
        return this.f204809b;
    }

    public final DuxCircleImageView getLogoImageView() {
        return this.f204810c;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f204815h = DuxLargeFontHelper.a(f204807i, r100);
    }

    public final void setAvatar(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f204809b.setImageBitmap(r100);
    }

    public final void setAvatarInset(int r100) {
        DuxCircleImageView r101 = this.f204809b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r103.setMargins(r100, r100, r100, r100);
        r101.setLayoutParams(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatarSize(AvatarSize r110) {
        Intrinsics.checkNotNullParameter(r110, "size");
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L114;
        int r101 = r110.getDpValue();
        boolean r102 = this.f204815h;
        if (r102 == true) goto L7;
    L9:
        if (r102 == true) goto L11;
    L13:
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101, R5(Resources.getSystem())));
    L14:
        r100.width = r103;
        int r104 = r110.getDpValue();
        boolean r105 = this.f204815h;
        if (r105 == true) goto L17;
    L19:
        if (r105 == true) goto L21;
    L23:
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, R5(Resources.getSystem())));
    L24:
        r100.height = r106;
        setLayoutParams(r100);
        if (this.f204810c.isShown() == true) goto L27;
        return;
    L27:
        if (this.f204810c.getDrawable() == null) goto L116;
        IconType r107 = this.f204813f;
        float r108 = 16.0f;
        float r109 = 0.0f;
        if (r107 != IconType.ONLINE) goto L74;
        switch(b.f204818a[r110.ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L37;
            case 7: goto L34;
            case 8: goto L33;
            default: goto L32;
        };
    L32:
        r108 = 0.0f;
    L42:
        int r111 = MathKt.roundToInt(TypedValue.applyDimension(1, r109, R5(Resources.getSystem())));
        boolean r112 = this.f204815h;
        if (r112 == true) goto L45;
    L47:
        if (r112 == true) goto L49;
    L51:
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L52:
        int r114 = r111 + r113;
        int r115 = MathKt.roundToInt(TypedValue.applyDimension(1, r109, R5(Resources.getSystem())));
        boolean r116 = this.f204815h;
        if (r116 == true) goto L55;
    L57:
        if (r116 == true) goto L59;
    L61:
        int r117 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L62:
        int r118 = r115 + r117;
        int r119 = MathKt.roundToInt(TypedValue.applyDimension(1, r109, R5(Resources.getSystem())));
        boolean r120 = this.f204815h;
        if (r120 == true) goto L65;
    L67:
        if (r120 == true) goto L69;
    L71:
        int r121 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L72:
        S5(r114, r118, r119, r121);
        return;
    L69:
        if (this.f204808a == true) goto L71;
        r121 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L72
    L65:
        if (this.f204808a == false) goto L67;
        r121 = MathKt.roundToInt(TypedValue.applyDimension(1, r108 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L72
    L59:
        if (this.f204808a == true) goto L61;
        r117 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L62
    L55:
        if (this.f204808a == false) goto L57;
        r117 = MathKt.roundToInt(TypedValue.applyDimension(1, RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r108, R5(Resources.getSystem())));
        goto L62
    L49:
        if (this.f204808a == true) goto L51;
        r113 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L52
    L45:
        if (this.f204808a == false) goto L47;
        r113 = MathKt.roundToInt(TypedValue.applyDimension(1, RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r108, R5(Resources.getSystem())));
        goto L52
    L33:
        r109 = 5.0f;
        r108 = 22.0f;
        goto L42
    L34:
        r109 = 4.0f;
        r108 = 18.0f;
        goto L42
    L35:
        r108 = 14.0f;
        goto L37
    L36:
        r108 = 12.0f;
    L37:
        r109 = 3.0f;
        goto L42
    L38:
        r108 = 12.0f;
    L41:
        r109 = 2.0f;
        goto L42
    L39:
        r108 = 10.0f;
        goto L41
    L40:
        r108 = 8.0f;
        goto L41
    L74:
        if (r107 == IconType.LOGO) goto L76;
        return;
    L76:
        switch(b.f204818a[r110.ordinal()]) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L79;
            case 4: goto L79;
            case 5: goto L81;
            case 6: goto L81;
            case 7: goto L78;
            case 8: goto L78;
            default: goto L77;
        };
    L77:
        r108 = 0.0f;
        goto L81
    L78:
        r108 = 20.0f;
        goto L81
    L79:
        r108 = 12.0f;
        goto L81
    L80:
        r108 = 8.0f;
    L81:
        boolean r122 = this.f204815h;
        if (r122 == true) goto L84;
    L86:
        if (r122 == true) goto L88;
    L90:
        int r123 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L91:
        int r124 = r123 - MathKt.roundToInt(TypedValue.applyDimension(1, 2, R5(Resources.getSystem())));
        boolean r125 = this.f204815h;
        if (r125 == true) goto L94;
    L96:
        if (r125 == true) goto L98;
    L100:
        int r126 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L101:
        boolean r127 = this.f204815h;
        if (r127 == true) goto L104;
    L106:
        if (r127 == true) goto L108;
    L110:
        int r128 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, R5(Resources.getSystem())));
    L111:
        S5(r124, r126, 0, r128);
        return;
    L108:
        if (this.f204808a == true) goto L110;
        r128 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L111
    L104:
        if (this.f204808a == false) goto L106;
        r128 = MathKt.roundToInt(TypedValue.applyDimension(1, r108 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L111
    L98:
        if (this.f204808a == true) goto L100;
        r126 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L101
    L94:
        if (this.f204808a == false) goto L96;
        r126 = MathKt.roundToInt(TypedValue.applyDimension(1, RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r108, R5(Resources.getSystem())));
        goto L101
    L88:
        if (this.f204808a == true) goto L90;
        r123 = MathKt.roundToInt(TypedValue.applyDimension(2, r108, R5(Resources.getSystem())));
        goto L91
    L84:
        if (this.f204808a == false) goto L86;
        r123 = MathKt.roundToInt(TypedValue.applyDimension(1, RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r108, R5(Resources.getSystem())));
        goto L91
    L116:
        return;
    L21:
        if (this.f204808a == true) goto L23;
        r106 = MathKt.roundToInt(TypedValue.applyDimension(2, r104, R5(Resources.getSystem())));
        goto L24
    L17:
        if (this.f204808a == false) goto L19;
        r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L24
    L11:
        if (this.f204808a == true) goto L13;
        r103 = MathKt.roundToInt(TypedValue.applyDimension(2, r101, R5(Resources.getSystem())));
        goto L14
    L7:
        if (this.f204808a == false) goto L9;
        r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
        goto L14
    L114:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(int r100) {
        this.f204814g = r100;
    }

    public final void setIconType(IconType r100) {
        Intrinsics.checkNotNullParameter(r100, "iconType");
        this.f204813f = r100;
    }

    public final void setAvatar(int r100) {
        this.f204809b.setImageResource(r100);
    }

    public final void setAvatar(Drawable r100) {
        this.f204809b.setImageDrawable(r100);
    }

    public DuxAvatar(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f204808a = false;
        AvatarSize r103 = AvatarSize.DP_16;
        this.f204813f = IconType.LOGO;
        this.f204814g = -1;
        Lazy r104 = DuxLargeFontHelper.f205243a;
        DuxComponent r105 = f204807i;
        this.f204815h = DuxLargeFontHelper.a(r105, null);
        Intrinsics.checkNotNullParameter(r105, "<this>");
        boolean r106 = ((IDuxComponentService) ServiceManager.get().getService(IDuxComponentService.class)).isOptimized(r105.getId());
        ViewGroup.inflate(r100, R.layout.dux_widget_avatar, this);
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.limitLargeFontScale});
        if (r107.hasValue(0) == false) goto L9;
        setAdaptLargeFontInternal(Boolean.valueOf(r107.getBoolean(0, false)));
    L9:
        if (r107.hasValue(1) == false) goto L11;
        this.f204808a = r107.getBoolean(1, false);
    L11:
        r107.recycle();
        DuxCircleImageView r108 = (DuxCircleImageView) findViewById(R.id.iv_avatar);
        this.f204809b = r108;
        this.f204810c = (DuxCircleImageView) findViewById(R.id.iv_icon);
        this.f204811d = (AppCompatImageView) findViewById(R.id.iv_bg);
        this.f204812e = (Space) findViewById(R.id.spacer);
        setClipChildren(false);
        if (r106 == false) goto L14;
        float r109 = (float) 0.5d;
        DisplayMetrics r110 = R5(Resources.getSystem());
    L15:
        r108.setBorderWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r109, r110)));
        r108.setBorderColor(ContextCompat.getColor(r100, R.color.LineReverse2));
        return;
    L14:
        r109 = 1;
        r110 = R5(Resources.getSystem());
        goto L15
    }

    public final void S5(int r100, int r101, int r102, int r103) {
        Space r104 = this.f204812e;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L11;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = r100;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = r101;
        r104.setLayoutParams(r106);
        setAvatarInset(1);
        this.f204810c.setContentPadding(0);
        this.f204810c.setBorderWidth(r102);
        this.f204810c.setBorderColor(this.f204814g);
        DuxCircleImageView r107 = this.f204810c;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L9;
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        int r110 = r103 + (r102 * 2);
        ((ViewGroup.MarginLayoutParams) r109).width = r110;
        ((ViewGroup.MarginLayoutParams) r109).height = r110;
        r107.setLayoutParams(r109);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}

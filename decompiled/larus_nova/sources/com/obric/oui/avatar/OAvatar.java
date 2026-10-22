package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001f B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0014¨\u0006!"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarSize", "", "inset", "setAvatarInset", "color", "setIconBorderColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setAvatar", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "Lcom/obric/oui/avatar/OAvatar$IconType;", "iconType", "setIconType", "Lcom/obric/oui/avatar/OCircleImageView;", "getContentImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "getLogoImageView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OAvatar extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCircleImageView f398752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCircleImageView f398753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f398754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Space f398755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IconType f398756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f398757f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "", "dpValue", "I", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum AvatarSize extends Enum<AvatarSize> {
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AvatarSize[] f398758a = null;
        private final int dpValue;

        public static AvatarSize valueOf(String r100) {
            return (AvatarSize) r27.a.a(AvatarSize.class, r100);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) f398758a.clone();
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
            AvatarSize r104 = new AvatarSize("DP_40", 4, 40);
            DP_40 = r104;
            AvatarSize r105 = new AvatarSize("DP_48", 5, 48);
            DP_48 = r105;
            AvatarSize r110 = new AvatarSize("DP_56", 6, 56);
            DP_56 = r110;
            AvatarSize r111 = new AvatarSize("DP_64", 7, 64);
            DP_64 = r111;
            AvatarSize r112 = new AvatarSize("DP_72", 8, 72);
            DP_72 = r112;
            f398758a = new AvatarSize[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public final int getDpValue() {
            return this.dpValue;
        }

        public AvatarSize(String r100, int r101, int r102) {
            super(r100, r101);
            this.dpValue = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "ONLINE", "LOGO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum IconType extends Enum<IconType> {
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IconType[] f398759a = null;

        public static IconType valueOf(String r100) {
            return (IconType) r27.a.a(IconType.class, r100);
        }

        public static IconType[] values() {
            return (IconType[]) f398759a.clone();
        }

        static {
            IconType r100 = new IconType("ONLINE", 0);
            ONLINE = r100;
            IconType r101 = new IconType("LOGO", 1);
            LOGO = r101;
            f398759a = new IconType[]{r100, r101};
        }

        public IconType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f398760a = null;

        static {
            int[] r100 = new int[AvatarSize.values().length];
            r100[AvatarSize.DP_24.ordinal()] = 1;
            r100[AvatarSize.DP_32.ordinal()] = 2;
            r100[AvatarSize.DP_40.ordinal()] = 3;
            r100[AvatarSize.DP_48.ordinal()] = 4;
            r100[AvatarSize.DP_56.ordinal()] = 5;
            r100[AvatarSize.DP_64.ordinal()] = 6;
            r100[AvatarSize.DP_72.ordinal()] = 7;
            f398760a = r100;
            int[] r101 = new int[IconType.values().length];
            r101[IconType.LOGO.ordinal()] = 1;
            r101[IconType.ONLINE.ordinal()] = 2;
        }
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.f398754c;
    }

    public final OCircleImageView getContentImageView() {
        return this.f398752a;
    }

    public final OCircleImageView getLogoImageView() {
        return this.f398753b;
    }

    public OAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAvatar(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f398752a.setImageBitmap(r100);
    }

    public final void setAvatarInset(int r100) {
        OCircleImageView r101 = this.f398752a;
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
        if (r100 == null) goto L38;
        r100.width = d.n(this, r110.getDpValue());
        r100.height = d.n(this, r110.getDpValue());
        setLayoutParams(r100);
        if (this.f398753b.isShown() == true) goto L7;
        return;
    L7:
        if (this.f398753b.getDrawable() == null) goto L40;
        IconType r101 = this.f398756e;
        float r102 = 2.0f;
        float r103 = 10.0f;
        float r104 = 0.0f;
        if (r101 != IconType.ONLINE) goto L24;
        float r105 = 8.0f;
        switch(a.f398760a[r110.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L12;
        };
    L12:
        r105 = 0.0f;
        r102 = 0.0f;
    L22:
        R5(d.m(this, r104), d.m(this, r104), d.m(this, r102), d.m(this, r105));
        return;
    L13:
        float r111 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L15:
        r104 = r111;
        r103 = 12.0f;
    L17:
        r105 = r103;
        goto L22
    L14:
        r111 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L15
    L16:
        r104 = ((2 * 2.0f) + 10.0f) + 0.5f;
        goto L17
    L18:
        float r112 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L20:
        r104 = r112;
        r102 = 1.5f;
        goto L22
    L19:
        r112 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L20
    L21:
        r104 = ((2 * 1.0f) + 6.0f) - 1;
        r105 = 6.0f;
        r102 = 1.0f;
        goto L22
    L24:
        if (r101 == IconType.LOGO) goto L26;
        return;
    L26:
        switch(a.f398760a[r110.ordinal()]) {
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L28;
            default: goto L27;
        };
    L27:
        float r113 = 0.0f;
        r102 = 0.0f;
        r103 = 0.0f;
    L35:
        R5(d.m(this, r104), d.m(this, r113), d.m(this, r102), d.m(this, r103));
        return;
    L28:
        r103 = 20.0f;
        float r114 = (2 * 2.0f) + 20.0f;
        float r106 = r114 - 2.0f;
        float r115 = r114 - 4.0f;
    L34:
        float r116 = r106;
        r104 = r115;
        r113 = r116;
        goto L35
    L29:
        float r117 = (2 * 2.0f) + 16.0f;
        r106 = r117 - 2.0f;
        r115 = r117 - 4.0f;
        r103 = 16.0f;
        goto L34
    L30:
        float r118 = (2 * 1.5f) + 16.0f;
        float r107 = r118 - 1.5f;
        r115 = r118 - 3.5f;
        r106 = r107;
        r103 = 16.0f;
    L32:
        r102 = 1.5f;
        goto L34
    L31:
        float r119 = (2 * 1.5f) + 12.0f;
        float r108 = r119 - 1.5f;
        r115 = r119 - 3.5f;
        r106 = r108;
        r103 = 12.0f;
        goto L32
    L33:
        float r120 = (2 * 1.0f) + 10.0f;
        r106 = r120 - 1.0f;
        r115 = r120 - 3.0f;
        r102 = 1.0f;
        goto L34
    L40:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(int r100) {
        this.f398757f = r100;
    }

    public final void setIconType(IconType r100) {
        Intrinsics.checkNotNullParameter(r100, "iconType");
        this.f398756e = r100;
    }

    public final void setAvatar(int r100) {
        this.f398752a.setImageResource(r100);
    }

    public final void setAvatar(Drawable r100) {
        this.f398752a.setImageDrawable(r100);
    }

    public OAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        AvatarSize r102 = AvatarSize.DP_16;
        this.f398756e = IconType.LOGO;
        this.f398757f = -1;
        ViewGroup.inflate(r100, R.layout.o_widget_avatar, this);
        OCircleImageView r103 = (OCircleImageView) findViewById(R.id.iv_avatar);
        this.f398752a = r103;
        this.f398753b = (OCircleImageView) findViewById(R.id.iv_icon);
        this.f398754c = (AppCompatImageView) findViewById(R.id.iv_bg);
        this.f398755d = (Space) findViewById(R.id.spacer);
        setClipChildren(false);
        r103.setBorderWidth(d.n(this, 1));
        r103.setBorderColor(ContextCompat.getColor(r100, R.color.LineReverse2));
    }

    public final void R5(int r100, int r101, int r102, int r103) {
        Space r104 = this.f398755d;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L11;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = r100;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = r101;
        r104.setLayoutParams(r106);
        setAvatarInset(1);
        this.f398753b.setContentPadding(0);
        this.f398753b.setBorderWidth(r102);
        this.f398753b.setBorderColor(this.f398757f);
        OCircleImageView r107 = this.f398753b;
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

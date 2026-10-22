package com.larksuite.component.universe_design.gradient;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UDLinearGradientDrawable extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f285025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f285026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Orientation f285027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f285028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Shader f285029e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/gradient/UDLinearGradientDrawable$Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "TO_RIGHT", "TO_BOTTOM_RIGHT", "TO_BOTTOM", "TO_BOTTOM_LEFT", "TO_LEFT", "TO_TOP_LEFT", "TO_TOP", "TO_TOP_RIGHT", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Orientation extends Enum<Orientation> {
        public static final Orientation TO_BOTTOM = null;
        public static final Orientation TO_BOTTOM_LEFT = null;
        public static final Orientation TO_BOTTOM_RIGHT = null;
        public static final Orientation TO_LEFT = null;
        public static final Orientation TO_RIGHT = null;
        public static final Orientation TO_TOP = null;
        public static final Orientation TO_TOP_LEFT = null;
        public static final Orientation TO_TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Orientation[] f285030a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285031b = null;

        public static EnumEntries<Orientation> getEntries() {
            return f285031b;
        }

        static {
            Orientation r100 = new Orientation("TO_RIGHT", 0);
            TO_RIGHT = r100;
            Orientation r101 = new Orientation("TO_BOTTOM_RIGHT", 1);
            TO_BOTTOM_RIGHT = r101;
            Orientation r102 = new Orientation("TO_BOTTOM", 2);
            TO_BOTTOM = r102;
            Orientation r103 = new Orientation("TO_BOTTOM_LEFT", 3);
            TO_BOTTOM_LEFT = r103;
            Orientation r104 = new Orientation("TO_LEFT", 4);
            TO_LEFT = r104;
            Orientation r105 = new Orientation("TO_TOP_LEFT", 5);
            TO_TOP_LEFT = r105;
            Orientation r110 = new Orientation("TO_TOP", 6);
            TO_TOP = r110;
            Orientation r111 = new Orientation("TO_TOP_RIGHT", 7);
            TO_TOP_RIGHT = r111;
            Orientation[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f285030a = r112;
            f285031b = EnumEntriesKt.enumEntries(r112);
        }

        public static Orientation[] values() {
            return (Orientation[]) f285030a.clone();
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) r27.a.a(Orientation.class, r100);
        }

        public Orientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285032a = null;

        static {
            int[] r100 = new int[Orientation.values().length];
            r100[Orientation.TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[Orientation.TO_BOTTOM_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[Orientation.TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[Orientation.TO_TOP_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[Orientation.TO_TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[Orientation.TO_TOP_RIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[Orientation.TO_RIGHT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[Orientation.TO_BOTTOM_RIGHT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f285032a = r100;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final Shader a() {
        switch(a.f285032a[this.f285027c.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r100 = getBounds().left;
        int r101 = getBounds().top;
        int r102 = getBounds().right;
        int r103 = getBounds().bottom;
    L17:
        return new LinearGradient(r100, r101, r102, r103, this.f285025a, this.f285026b, Shader.TileMode.CLAMP);
    L7:
        r100 = getBounds().left;
        r101 = getBounds().top;
        r102 = getBounds().right;
    L12:
        r103 = r101;
        goto L17
    L8:
        r100 = getBounds().left;
        r101 = getBounds().bottom;
        r102 = getBounds().right;
        r103 = getBounds().top;
        goto L17
    L9:
        r100 = getBounds().left;
        r101 = getBounds().bottom;
        r103 = getBounds().top;
    L15:
        r102 = r100;
        goto L17
    L10:
        r100 = getBounds().right;
        r101 = getBounds().bottom;
        r102 = getBounds().left;
        r103 = getBounds().top;
        goto L17
    L11:
        r100 = getBounds().right;
        r101 = getBounds().top;
        r102 = getBounds().left;
        goto L12
    L13:
        r100 = getBounds().right;
        r101 = getBounds().top;
        r102 = getBounds().left;
        r103 = getBounds().bottom;
        goto L17
    L14:
        r100 = getBounds().left;
        r101 = getBounds().top;
        r103 = getBounds().bottom;
        goto L15
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(Xfermode r100) {
        this.f285028d.setXfermode(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f285028d.setShader(this.f285029e);
        r100.drawRect(getBounds(), this.f285028d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f285029e = a();
    }

    public UDLinearGradientDrawable(int r100, int r101, Orientation r102) {
        Intrinsics.checkNotNullParameter(r102, "orientation");
        this.f285025a = r100;
        this.f285026b = r101;
        this.f285027c = r102;
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        this.f285028d = r103;
        this.f285029e = a();
    }
}

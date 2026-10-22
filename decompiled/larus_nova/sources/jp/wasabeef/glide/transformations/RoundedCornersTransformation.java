package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.obric.miniapp.alarm.AccountType;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;
    private CornerType cornerType;
    private int diameter;
    private int margin;
    private int radius;

    public static final enum CornerType extends Enum<CornerType> {
        public static final CornerType ALL = null;
        public static final CornerType BOTTOM = null;
        public static final CornerType BOTTOM_LEFT = null;
        public static final CornerType BOTTOM_RIGHT = null;
        public static final CornerType DIAGONAL_FROM_TOP_LEFT = null;
        public static final CornerType DIAGONAL_FROM_TOP_RIGHT = null;
        public static final CornerType LEFT = null;
        public static final CornerType OTHER_BOTTOM_LEFT = null;
        public static final CornerType OTHER_BOTTOM_RIGHT = null;
        public static final CornerType OTHER_TOP_LEFT = null;
        public static final CornerType OTHER_TOP_RIGHT = null;
        public static final CornerType RIGHT = null;
        public static final CornerType TOP = null;
        public static final CornerType TOP_LEFT = null;
        public static final CornerType TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CornerType[] f499933a = null;

        static {
            CornerType r100 = new CornerType(AccountType.ALL, 0);
            ALL = r100;
            CornerType r101 = new CornerType("TOP_LEFT", 1);
            TOP_LEFT = r101;
            CornerType r102 = new CornerType("TOP_RIGHT", 2);
            TOP_RIGHT = r102;
            CornerType r103 = new CornerType("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            CornerType r104 = new CornerType("BOTTOM_RIGHT", 4);
            BOTTOM_RIGHT = r104;
            CornerType r105 = new CornerType("TOP", 5);
            TOP = r105;
            CornerType r110 = new CornerType("BOTTOM", 6);
            BOTTOM = r110;
            CornerType r111 = new CornerType("LEFT", 7);
            LEFT = r111;
            CornerType r112 = new CornerType("RIGHT", 8);
            RIGHT = r112;
            CornerType r113 = new CornerType("OTHER_TOP_LEFT", 9);
            OTHER_TOP_LEFT = r113;
            CornerType r114 = new CornerType("OTHER_TOP_RIGHT", 10);
            OTHER_TOP_RIGHT = r114;
            CornerType r115 = new CornerType("OTHER_BOTTOM_LEFT", 11);
            OTHER_BOTTOM_LEFT = r115;
            CornerType r106 = new CornerType("OTHER_BOTTOM_RIGHT", 12);
            OTHER_BOTTOM_RIGHT = r106;
            CornerType r107 = new CornerType("DIAGONAL_FROM_TOP_LEFT", 13);
            DIAGONAL_FROM_TOP_LEFT = r107;
            CornerType r108 = new CornerType("DIAGONAL_FROM_TOP_RIGHT", 14);
            DIAGONAL_FROM_TOP_RIGHT = r108;
            f499933a = new CornerType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static CornerType[] values() {
            return (CornerType[]) f499933a.clone();
        }

        public static CornerType valueOf(String r100) {
            return (CornerType) r27.a.a(CornerType.class, r100);
        }

        public CornerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499934a = null;

        static {
            int[] r100 = new int[CornerType.values().length];
            f499934a = r100;
            r100[CornerType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L54:
            f499934a[CornerType.TOP_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L38:
            f499934a[CornerType.TOP_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            f499934a[CornerType.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L56:
            f499934a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L40:
            f499934a[CornerType.TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L44:
            f499934a[CornerType.BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L62:
            f499934a[CornerType.LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L34:
            f499934a[CornerType.RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L58:
            f499934a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L60:
            f499934a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L46:
            f499934a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L52:
            f499934a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L36:
            f499934a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L42:
            f499934a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 425235636;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof RoundedCornersTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    public RoundedCornersTransformation(int r100, int r101) {
        this(r100, r101, CornerType.ALL);
    }

    public RoundedCornersTransformation(int r100, int r101, CornerType r102) {
        this.radius = r100;
        this.diameter = r100 * 2;
        this.margin = r101;
        this.cornerType = r102;
    }

    private void drawBottomLeftRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        int r105 = this.diameter;
        RectF r106 = new RectF(r104, r103 - r105, r104 + r105, r103);
        int r107 = this.radius;
        r100.drawRoundRect(r106, r107, r107, r101);
        int r108 = this.margin;
        r100.drawRect(new RectF(r108, r108, r108 + this.diameter, r103 - this.radius), r101);
        int r109 = this.margin;
        r100.drawRect(new RectF(this.radius + r109, r109, r102, r103), r101);
    }

    private void drawBottomRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.diameter;
        RectF r105 = new RectF(r102 - r104, r103 - r104, r102, r103);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.margin;
        r100.drawRect(new RectF(r107, r107, r102 - this.radius, r103), r101);
        int r108 = this.radius;
        r100.drawRect(new RectF(r102 - r108, this.margin, r102, r103 - r108), r101);
    }

    private void drawBottomRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        RectF r104 = new RectF(this.margin, r103 - this.diameter, r102, r103);
        int r105 = this.radius;
        r100.drawRoundRect(r104, r105, r105, r101);
        int r106 = this.margin;
        r100.drawRect(new RectF(r106, r106, r102, r103 - this.radius), r101);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas r100, Paint r101, float r102, float r110) {
        int r103 = this.margin;
        int r104 = this.diameter;
        RectF r105 = new RectF(r103, r103, r103 + r104, r103 + r104);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.diameter;
        RectF r108 = new RectF(r102 - r107, r110 - r107, r102, r110);
        int r109 = this.radius;
        r100.drawRoundRect(r108, r109, r109, r101);
        int r111 = this.margin;
        r100.drawRect(new RectF(r111, r111 + this.radius, r102 - this.diameter, r110), r101);
        int r112 = this.margin;
        r100.drawRect(new RectF(this.diameter + r112, r112, r102, r110 - this.radius), r101);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.diameter;
        int r105 = this.margin;
        RectF r106 = new RectF(r102 - r104, r105, r102, r105 + r104);
        int r107 = this.radius;
        r100.drawRoundRect(r106, r107, r107, r101);
        int r108 = this.margin;
        int r109 = this.diameter;
        RectF r110 = new RectF(r108, r103 - r109, r108 + r109, r103);
        int r111 = this.radius;
        r100.drawRoundRect(r110, r111, r111, r101);
        int r112 = this.margin;
        int r113 = this.radius;
        r100.drawRect(new RectF(r112, r112, r102 - r113, r103 - r113), r101);
        int r114 = this.margin;
        int r115 = this.radius;
        r100.drawRect(new RectF(r114 + r115, r114 + r115, r102, r103), r101);
    }

    private void drawLeftRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        RectF r105 = new RectF(r104, r104, r104 + this.diameter, r103);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.margin;
        r100.drawRect(new RectF(this.radius + r107, r107, r102, r103), r101);
    }

    private void drawOtherBottomLeftRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        RectF r105 = new RectF(r104, r104, r102, r104 + this.diameter);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        RectF r107 = new RectF(r102 - this.diameter, this.margin, r102, r103);
        int r108 = this.radius;
        r100.drawRoundRect(r107, r108, r108, r101);
        int r109 = this.margin;
        int r110 = this.radius;
        r100.drawRect(new RectF(r109, r109 + r110, r102 - r110, r103), r101);
    }

    private void drawOtherBottomRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        RectF r105 = new RectF(r104, r104, r102, r104 + this.diameter);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.margin;
        RectF r108 = new RectF(r107, r107, r107 + this.diameter, r103);
        int r109 = this.radius;
        r100.drawRoundRect(r108, r109, r109, r101);
        int r110 = this.margin;
        int r111 = this.radius;
        r100.drawRect(new RectF(r110 + r111, r110 + r111, r102, r103), r101);
    }

    private void drawOtherTopLeftRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        RectF r104 = new RectF(this.margin, r103 - this.diameter, r102, r103);
        int r105 = this.radius;
        r100.drawRoundRect(r104, r105, r105, r101);
        RectF r106 = new RectF(r102 - this.diameter, this.margin, r102, r103);
        int r107 = this.radius;
        r100.drawRoundRect(r106, r107, r107, r101);
        int r108 = this.margin;
        int r109 = this.radius;
        r100.drawRect(new RectF(r108, r108, r102 - r109, r103 - r109), r101);
    }

    private void drawOtherTopRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        RectF r105 = new RectF(r104, r104, r104 + this.diameter, r103);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        RectF r107 = new RectF(this.margin, r103 - this.diameter, r102, r103);
        int r108 = this.radius;
        r100.drawRoundRect(r107, r108, r108, r101);
        int r109 = this.margin;
        int r110 = this.radius;
        r100.drawRect(new RectF(r109 + r110, r109, r102, r103 - r110), r101);
    }

    private void drawRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        RectF r104 = new RectF(r102 - this.diameter, this.margin, r102, r103);
        int r105 = this.radius;
        r100.drawRoundRect(r104, r105, r105, r101);
        int r106 = this.margin;
        r100.drawRect(new RectF(r106, r106, r102 - this.radius, r103), r101);
    }

    private void drawRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        float r105 = r102 - r104;
        float r106 = r103 - r104;
        switch(a.f499934a[this.cornerType.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L4;
        };
    L4:
        int r107 = this.margin;
        RectF r108 = new RectF(r107, r107, r105, r106);
        int r109 = this.radius;
        r100.drawRoundRect(r108, r109, r109, r101);
        return;
    L5:
        drawDiagonalFromTopRightRoundRect(r100, r101, r105, r106);
        return;
    L6:
        drawDiagonalFromTopLeftRoundRect(r100, r101, r105, r106);
        return;
    L7:
        drawOtherBottomRightRoundRect(r100, r101, r105, r106);
        return;
    L8:
        drawOtherBottomLeftRoundRect(r100, r101, r105, r106);
        return;
    L9:
        drawOtherTopRightRoundRect(r100, r101, r105, r106);
        return;
    L10:
        drawOtherTopLeftRoundRect(r100, r101, r105, r106);
        return;
    L11:
        drawRightRoundRect(r100, r101, r105, r106);
        return;
    L12:
        drawLeftRoundRect(r100, r101, r105, r106);
        return;
    L13:
        drawBottomRoundRect(r100, r101, r105, r106);
        return;
    L14:
        drawTopRoundRect(r100, r101, r105, r106);
        return;
    L15:
        drawBottomRightRoundRect(r100, r101, r105, r106);
        return;
    L16:
        drawBottomLeftRoundRect(r100, r101, r105, r106);
        return;
    L17:
        drawTopRightRoundRect(r100, r101, r105, r106);
        return;
    L18:
        drawTopLeftRoundRect(r100, r101, r105, r106);
        return;
    L19:
        int r110 = this.margin;
        RectF r111 = new RectF(r110, r110, r105, r106);
        int r112 = this.radius;
        r100.drawRoundRect(r111, r112, r112, r101);
    }

    private void drawTopLeftRoundRect(Canvas r100, Paint r101, float r102, float r110) {
        int r103 = this.margin;
        int r104 = this.diameter;
        RectF r105 = new RectF(r103, r103, r103 + r104, r103 + r104);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.margin;
        int r108 = this.radius;
        r100.drawRect(new RectF(r107, r107 + r108, r107 + r108, r110), r101);
        int r109 = this.margin;
        r100.drawRect(new RectF(this.radius + r109, r109, r102, r110), r101);
    }

    private void drawTopRightRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.diameter;
        int r105 = this.margin;
        RectF r106 = new RectF(r102 - r104, r105, r102, r105 + r104);
        int r107 = this.radius;
        r100.drawRoundRect(r106, r107, r107, r101);
        int r108 = this.margin;
        r100.drawRect(new RectF(r108, r108, r102 - this.radius, r103), r101);
        int r109 = this.radius;
        r100.drawRect(new RectF(r102 - r109, this.margin + r109, r102, r103), r101);
    }

    private void drawTopRoundRect(Canvas r100, Paint r101, float r102, float r103) {
        int r104 = this.margin;
        RectF r105 = new RectF(r104, r104, r102, r104 + this.diameter);
        int r106 = this.radius;
        r100.drawRoundRect(r105, r106, r106, r101);
        int r107 = this.margin;
        r100.drawRect(new RectF(r107, r107 + this.radius, r102, r103), r101);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        Bitmap r107 = r101.get(r105, r106, Bitmap.Config.ARGB_8888);
        r107.setHasAlpha(true);
        Canvas r108 = new Canvas(r107);
        Paint r109 = new Paint();
        r109.setAntiAlias(true);
        Shader.TileMode r110 = Shader.TileMode.CLAMP;
        r109.setShader(new BitmapShader(r102, r110, r110));
        drawRoundRect(r108, r109, r105, r106);
        return r107;
    }
}

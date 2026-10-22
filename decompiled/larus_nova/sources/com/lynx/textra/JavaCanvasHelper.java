package com.lynx.textra;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public class JavaCanvasHelper {
    protected Canvas canvas_;
    protected int color_;
    protected boolean is_bold_;
    protected boolean is_italic_;
    protected boolean is_underline_;
    protected JavaFontManager mFontManager;
    protected Paint mPainter;
    protected final Paint paint_;
    protected int stroke_color_;
    protected char[] text_;
    protected float text_size_;
    protected float text_skew_;

    /* JADX INFO: renamed from: com.lynx.textra.JavaCanvasHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp = null;
        static final /* synthetic */ int[] $SwitchMap$com$lynx$textra$TTTextDefinition$PathType = null;

        static {
            int[] r100 = new int[TTTextDefinition.PathType.values().length];
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType = r100;
            r100[TTTextDefinition.PathType.kLines.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L93:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kArc.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L113:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kBezier.ordinal()] = 3;     // Catch: NoSuchFieldError -> L44
        L125:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kMoveTo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L45
        L131:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kMultiPath.ordinal()] = 5;     // Catch: NoSuchFieldError -> L46
        L12:
            int[] r101 = new int[TTTextDefinition.CanvasOp.values().length];
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp = r101;
            r101[TTTextDefinition.CanvasOp.kStartPaint.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L99:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kEndPaint.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L107:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSave.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L111:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRestore.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L119:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClear.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L139:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kTranslate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L52
        L77:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kScale.ordinal()] = 7;     // Catch: NoSuchFieldError -> L53
        L97:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRotate.ordinal()] = 8;     // Catch: NoSuchFieldError -> L54
        L103:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSkew.ordinal()] = 9;     // Catch: NoSuchFieldError -> L55
        L123:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClipRect.ordinal()] = 10;     // Catch: NoSuchFieldError -> L56
        L129:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClearRect.ordinal()] = 11;     // Catch: NoSuchFieldError -> L57
        L83:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kFillRect.ordinal()] = 12;     // Catch: NoSuchFieldError -> L58
        L85:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArc.ordinal()] = 13;     // Catch: NoSuchFieldError -> L59
        L105:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawLine.ordinal()] = 14;     // Catch: NoSuchFieldError -> L60
        L109:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawOval.ordinal()] = 15;     // Catch: NoSuchFieldError -> L61
        L133:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawPath.ordinal()] = 16;     // Catch: NoSuchFieldError -> L62
        L135:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRect.ordinal()] = 17;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawText.ordinal()] = 18;     // Catch: NoSuchFieldError -> L64
        L91:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArcTo.ordinal()] = 19;     // Catch: NoSuchFieldError -> L65
        L115:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawColor.ordinal()] = 20;     // Catch: NoSuchFieldError -> L66
        L117:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImage.ordinal()] = 21;     // Catch: NoSuchFieldError -> L67
        L137:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawCircle.ordinal()] = 22;     // Catch: NoSuchFieldError -> L68
        L75:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawGlyphs.ordinal()] = 23;     // Catch: NoSuchFieldError -> L69
        L95:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImageRect.ordinal()] = 24;     // Catch: NoSuchFieldError -> L70
        L101:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRunDelegate.ordinal()] = 25;     // Catch: NoSuchFieldError -> L71
        L121:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBackgroundDelegate.ordinal()] = 26;     // Catch: NoSuchFieldError -> L72
        L127:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBlockRegion.ordinal()] = 27;     // Catch: NoSuchFieldError -> L73
        L81:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRoundRect.ordinal()] = 28;     // Catch: NoSuchFieldError -> L74
            return;
        }
    }

    public void clear() {
    }

    public void endPaint() throws IOException {
    }

    public void startPaint() throws IOException {
    }

    public void restore() {
        this.canvas_.restore();
    }

    public void save() {
        this.canvas_.save();
    }

    public JavaCanvasHelper(JavaFontManager r100) {
        this.paint_ = new Paint();
        this.mFontManager = null;
        this.mPainter = new Paint();
        this.text_ = new char[20];
        this.mFontManager = r100;
    }

    public void clearRect(BBufferInputStream r100) throws IOException {
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
    }

    public void clipRect(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        float r103 = TTTextUtils.Dp2Px(r100.readFloat());
        float r104 = TTTextUtils.Dp2Px(r100.readFloat());
        this.canvas_.clipRect(r101, r102, r103, r104);
    }

    public void drawArc(BBufferInputStream r100) throws IOException {
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        r100.readInt();
        ReadPaint(r100, this.paint_);
    }

    public void drawArcTo(BBufferInputStream r100) throws IOException {
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        ReadPaint(r100, this.paint_);
    }

    public void drawBackgroundDelegate(BBufferInputStream r100) throws IOException {
        r100.readInt();
        ReadPaint(r100, this.paint_);
    }

    public void drawCircle(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        float r103 = TTTextUtils.Dp2Px(r100.readFloat());
        Paint r104 = ReadPaint(r100, this.paint_);
        r104.setColor(this.color_);
        int r105 = this.color_;
        if (r105 != 0) goto L5;
    L7:
        if (r105 == 0) goto L10;
        r104.setStyle(Paint.Style.FILL);
        this.canvas_.drawCircle(r101, r102, r103, r104);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r104.setStyle(Paint.Style.STROKE);
        r104.setColor(this.stroke_color_);
        this.canvas_.drawCircle(r101, r102, r103, r104);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r105) goto L7;
        r104.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawCircle(r101, r102, r103, r104);
    }

    public void drawColor(BBufferInputStream r100) throws IOException {
        r100.readInt();
    }

    public void drawGlyphs(BBufferInputStream r100) throws IOException {
        this.mFontManager.GetTypefaceByIndex(r100.readInt());
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        int r103 = r100.readInt();
        int[] r104 = new int[r103];
        float[] r105 = new float[r103 * 2];
        int r106 = 0;
    L3:
        if (r106 >= r103) goto L5;
        r104[r106] = r100.readShort();
        int r107 = r106 * 2;
        r105[r107] = r100.readFloat() + r101;
        r105[r107 + 1] = r100.readFloat() + r102;
        r106 = r106 + 1;
        goto L3
    }

    public void drawImage(BBufferInputStream r110) throws IOException {
        int r100 = r110.readInt();
        byte[] r101 = new byte[r100];
        r110.read(r101, 0, r100);
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        float r104 = TTTextUtils.Dp2Px(r110.readFloat());
        float r105 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r111 = ReadPaint(r110, this.paint_);
        Bitmap r106 = BitmapFactory.decodeByteArray(r101, 0, r100);
        this.canvas_.drawBitmap(r106, new Rect(0, 0, r106.getWidth(), r106.getHeight()), new Rect((int) r102, (int) r103, (int) r104, (int) r105), r111);
    }

    public void drawImgRect(BBufferInputStream r110) throws IOException {
        int r100 = r110.readInt();
        byte[] r101 = new byte[r100];
        r110.read(r101, 0, r100);
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        float r104 = TTTextUtils.Dp2Px(r110.readFloat());
        float r105 = TTTextUtils.Dp2Px(r110.readFloat());
        float r106 = TTTextUtils.Dp2Px(r110.readFloat());
        float r107 = TTTextUtils.Dp2Px(r110.readFloat());
        float r108 = TTTextUtils.Dp2Px(r110.readFloat());
        float r111 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r112 = ReadPaint(r110, this.paint_);
        Bitmap r109 = BitmapFactory.decodeByteArray(r101, 0, r100);
        this.canvas_.drawBitmap(r109, new Rect((int) r102, (int) r103, (int) r104, (int) r105), new Rect((int) r106, (int) r107, (int) r108, (int) r111), r112);
    }

    public void drawLine(BBufferInputStream r110) throws IOException {
        float r100 = TTTextUtils.Dp2Px(r110.readFloat());
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r111 = ReadPaint(r110, this.paint_);
        r111.setColor(this.color_);
        int r104 = this.color_;
        if (r104 != 0) goto L5;
    L7:
        if (r104 == 0) goto L10;
        r111.setStyle(Paint.Style.FILL);
        this.canvas_.drawLine(r100, r101, r102, r103, r111);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r111.setStyle(Paint.Style.STROKE);
        r111.setColor(this.stroke_color_);
        this.canvas_.drawLine(r100, r101, r102, r103, r111);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r104) goto L7;
        r111.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawLine(r100, r101, r102, r103, r111);
    }

    public void drawOval(BBufferInputStream r100) throws IOException {
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        ReadPaint(r100, this.paint_);
    }

    public void drawPath(BBufferInputStream r100) throws IOException {
        Path r101 = new Path();
        ReadPath(r101, r100);
        r101.close();
        Paint r102 = ReadPaint(r100, this.paint_);
        r102.setColor(this.color_);
        int r103 = this.color_;
        if (r103 != 0) goto L5;
    L7:
        if (r103 == 0) goto L10;
        r102.setStyle(Paint.Style.FILL);
        this.canvas_.drawPath(r101, r102);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r102.setStyle(Paint.Style.STROKE);
        r102.setColor(this.stroke_color_);
        this.canvas_.drawPath(r101, r102);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r103) goto L7;
        r102.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawPath(r101, r102);
    }

    public void drawRect(BBufferInputStream r110) throws IOException {
        float r100 = TTTextUtils.Dp2Px(r110.readFloat());
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r111 = ReadPaint(r110, this.paint_);
        r111.setColor(this.color_);
        int r104 = this.color_;
        if (r104 != 0) goto L5;
    L7:
        if (r104 == 0) goto L10;
        r111.setStyle(Paint.Style.FILL);
        this.canvas_.drawRect(r100, r101, r102, r103, r111);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r111.setStyle(Paint.Style.STROKE);
        r111.setColor(this.stroke_color_);
        this.canvas_.drawRect(r100, r101, r102, r103, r111);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r104) goto L7;
        r111.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawRect(r100, r101, r102, r103, r111);
    }

    public void drawRoundRect(BBufferInputStream r110) throws IOException {
        float r100 = TTTextUtils.Dp2Px(r110.readFloat());
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r111 = TTTextUtils.Dp2Px(r110.readFloat());
        float r112 = TTTextUtils.Dp2Px(r110.readFloat());
        float r113 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r114 = ReadPaint(r110, this.paint_);
        r114.setColor(this.color_);
        int r102 = this.color_;
        if (r102 != 0) goto L5;
    L7:
        if (r102 == 0) goto L10;
        r114.setStyle(Paint.Style.FILL);
        this.canvas_.drawRoundRect(r100, r101, r111, r112, r113, r113, r114);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r114.setStyle(Paint.Style.STROKE);
        r114.setColor(this.stroke_color_);
        this.canvas_.drawRoundRect(r100, r101, r111, r112, r113, r113, r114);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r102) goto L7;
        r114.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawRoundRect(r100, r101, r111, r112, r113, r113, r114);
    }

    public void drawRunDelegate(BBufferInputStream r100) throws IOException {
        r100.readInt();
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        TTTextUtils.Dp2Px(r100.readFloat());
        ReadPaint(r100, this.paint_);
    }

    public void drawText(BBufferInputStream r110) throws IOException {
        JavaTypeface r100 = this.mFontManager.GetTypefaceByIndex(r110.readInt());
        int r101 = r110.readInt();
        if (r101 <= this.text_.length) goto L5;
        this.text_ = new char[r101];
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        this.text_[r102] = (char) r110.readShort();
        r102 = r102 + 1;
    L8:
        if (r101 <= 0) goto L12;
        if (this.text_[r101 - 1] >= ' ') goto L12;
        r101 = r101 - 1;
    L12:
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        float r111 = TTTextUtils.Dp2Px(r110.readFloat());
        this.paint_.setTypeface(r100.mTypeface);
        Paint r112 = ReadPaint(r110, this.paint_);
        r112.setFakeBoldText(this.is_bold_);
        if (this.is_italic_ == false) goto L15;
        float r104 = -0.25f;
    L16:
        r112.setTextSkewX(r104 + this.text_skew_);
        r112.setColor(this.color_);
        int r105 = this.color_;
        if (r105 != 0) goto L19;
    L21:
        if (r105 == 0) goto L24;
        r112.setStyle(Paint.Style.FILL);
        this.canvas_.drawText(this.text_, 0, r101, r103, r111, r112);
    L24:
        if (this.stroke_color_ == 0) goto L31;
        r112.setStyle(Paint.Style.STROKE);
        r112.setColor(this.stroke_color_);
        this.canvas_.drawText(this.text_, 0, r101, r103, r111, r112);
        return;
    L31:
        return;
    L19:
        if (this.stroke_color_ != r105) goto L21;
        r112.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawText(this.text_, 0, r101, r103, r111, r112);
        return;
    L15:
        r104 = 0.0f;
        goto L16
    }

    public void fillRect(BBufferInputStream r100) throws IOException {
        int r101 = r100.readInt();
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        float r103 = TTTextUtils.Dp2Px(r100.readFloat());
        float r104 = TTTextUtils.Dp2Px(r100.readFloat());
        float r105 = TTTextUtils.Dp2Px(r100.readFloat());
        Paint r106 = new Paint();
        r106.setColor(r101);
        r106.setStyle(Paint.Style.FILL);
        this.canvas_.drawRect(r102, r103, r104, r105, r106);
    }

    public void rotate(BBufferInputStream r100) throws IOException {
        float r101 = r100.readFloat();
        this.canvas_.rotate(r101);
    }

    public void scale(BBufferInputStream r100) throws IOException {
        float r101 = r100.readFloat();
        float r102 = r100.readFloat();
        this.canvas_.scale(r101, r102);
    }

    public void skew(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        this.canvas_.skew(r101, r102);
    }

    public void translate(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        this.canvas_.translate(r101, r102);
    }

    public Paint ReadPaint(BBufferInputStream r100, Paint r101) throws IOException {
        boolean r102 = true;
        r101.setAntiAlias(true);
        r101.setStrokeWidth(TTTextUtils.Dp2Px(r100.readFloat()));
        this.color_ = r100.readInt();
        this.stroke_color_ = r100.readInt();
        float r103 = TTTextUtils.Dp2Px(r100.readFloat());
        this.text_size_ = r103;
        r101.setTextSize(r103);
        this.text_skew_ = r100.readFloat();
        byte r104 = r100.readByte();
        int r105 = r104 & 3;
        if (r105 != 1) goto L5;
        r101.setStrokeCap(Paint.Cap.ROUND);
    L10:
        if ((r104 & 4) <= 0) goto L12;
        boolean r106 = true;
    L13:
        this.is_bold_ = r106;
        if ((r104 & 8) <= 0) goto L16;
        boolean r107 = true;
    L17:
        this.is_italic_ = r107;
        if ((r104 & 16) > 0) goto L21;
        r102 = false;
    L21:
        this.is_underline_ = r102;
        return r101;
    L16:
        r107 = false;
        goto L17
    L12:
        r106 = false;
        goto L13
    L5:
        if (r105 == 2) goto L7;
        r101.setStrokeCap(Paint.Cap.BUTT);
        goto L10
    L7:
        r101.setStrokeCap(Paint.Cap.SQUARE);
        goto L10
    }

    public void ReadPath(Path r110, BBufferInputStream r111) throws IOException {
        TTTextDefinition.PathType r100 = TTTextDefinition.GetPathType(r111.readInt());
        int r101 = AnonymousClass1.$SwitchMap$com$lynx$textra$TTTextDefinition$PathType[r100.ordinal()];
        int r102 = 0;
        if (r101 != 1) goto L5;
        int r103 = r111.readInt();
    L26:
        if (r102 >= r103) goto L38;
        r110.lineTo(TTTextUtils.Dp2Px(r111.readFloat()), TTTextUtils.Dp2Px(r111.readFloat()));
        r102 = r102 + 1;
        goto L26
    L38:
        return;
    L5:
        if (r101 != 2) goto L7;
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        TTTextUtils.Dp2Px(r111.readFloat());
        return;
    L7:
        if (r101 != 3) goto L9;
        int r104 = r111.readInt();
        PointF[] r105 = new PointF[r104];
        int r106 = 0;
    L18:
        if (r106 >= r104) goto L20;
        r105[r106] = new PointF(TTTextUtils.Dp2Px(r111.readFloat()), TTTextUtils.Dp2Px(r111.readFloat()));
        r106 = r106 + 1;
        goto L18
    L20:
        if (r104 != 2) goto L22;
        PointF r112 = r105[0];
        float r107 = r112.x;
        float r113 = r112.y;
        PointF r108 = r105[1];
        r110.quadTo(r107, r113, r108.x, r108.y);
        return;
    L22:
        if (r104 < 3) goto L33;
        PointF r114 = r105[0];
        float r109 = r114.x;
        float r115 = r114.y;
        PointF r116 = r105[1];
        float r117 = r116.x;
        float r118 = r116.y;
        PointF r119 = r105[2];
        r110.cubicTo(r109, r115, r117, r118, r119.x, r119.y);
        return;
    L33:
        return;
    L9:
        if (r101 != 4) goto L11;
        r110.moveTo(TTTextUtils.Dp2Px(r111.readFloat()), TTTextUtils.Dp2Px(r111.readFloat()));
        return;
    L11:
        if (r101 != 5) goto L36;
        int r120 = r111.readInt();
    L14:
        if (r102 >= r120) goto L37;
        ReadPath(r110, r111);
        r102 = r102 + 1;
        goto L14
    L37:
        return;
    }

    public void drawBuffer(Canvas r100, byte[] r101) {
        this.canvas_ = r100;
        BBufferInputStream r102 = new BBufferInputStream(r101);
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r102.available() <= 0) goto L14;
        drawOp(TTTextDefinition.GetCanvasOp(r102.readByte()), r102);     // Catch: IOException -> L7
        goto L10
    }

    public void drawOp(TTTextDefinition.CanvasOp r100, BBufferInputStream r101) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[r100.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            case 27: goto L59;
            case 28: goto L5;
            default: goto L59;
        };
    L5:
        drawRoundRect(r101);
        return;
    L6:
        drawBackgroundDelegate(r101);
        return;
    L7:
        drawRunDelegate(r101);
        return;
    L8:
        drawImgRect(r101);
        return;
    L9:
        drawGlyphs(r101);
        return;
    L10:
        drawCircle(r101);
        return;
    L11:
        drawImage(r101);
        return;
    L12:
        drawColor(r101);
        return;
    L13:
        drawArcTo(r101);
        return;
    L14:
        drawText(r101);
        return;
    L15:
        drawRect(r101);
        return;
    L16:
        drawPath(r101);
        return;
    L17:
        drawOval(r101);
        return;
    L18:
        drawLine(r101);
        return;
    L19:
        drawArc(r101);
        return;
    L20:
        fillRect(r101);
        return;
    L21:
        clearRect(r101);
        return;
    L22:
        clipRect(r101);
        return;
    L23:
        skew(r101);
        return;
    L24:
        rotate(r101);
        return;
    L25:
        scale(r101);
        return;
    L26:
        translate(r101);
        return;
    L27:
        clear();
        return;
    L28:
        restore();
        return;
    L29:
        save();
        return;
    L30:
        endPaint();
        return;
    L31:
        startPaint();
        return;
    }
}

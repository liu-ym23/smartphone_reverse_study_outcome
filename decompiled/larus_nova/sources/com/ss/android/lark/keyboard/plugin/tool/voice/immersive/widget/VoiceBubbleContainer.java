package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0014J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u000fJ\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "arrowOrientation", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer$ArrowOrientation;", "bubblePadding", "", "mWidth", "mHeight", "left", "", "top", "right", "bottom", "arrowPosition", "arrowWidth", "arrowLength", "bubbleRadius", "bubbleColor", "arrowTopLeftRadius", "arrowTopRightRadius", "arrowDownLeftRadius", "arrowDownRightRadius", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setBubbleColor", "setBubbleRadius", "radius", "setArrowWidth", "getArrowWidth", "setArrowTLRadius", "setArrowTRRadius", "setArrowDLRadius", "setArrowDRRadius", "setArrowLength", "setArrowPosition", "initPadding", "initData", "invalidate", "postInvalidate", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ArrowOrientation", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceBubbleContainer extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f430626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f430627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrowOrientation f430628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f430629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f430630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f430631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f430632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f430633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f430634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f430635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f430636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f430637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f430638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f430639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f430640o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer$ArrowOrientation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "getType", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ArrowOrientation extends Enum<ArrowOrientation> {
        public static final ArrowOrientation BOTTOM = null;
        public static final ArrowOrientation LEFT = null;
        public static final ArrowOrientation RIGHT = null;
        public static final ArrowOrientation TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ArrowOrientation[] f430641a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f430642b = null;
        private final int value;

        public static EnumEntries<ArrowOrientation> getEntries() {
            return f430642b;
        }

        static {
            ArrowOrientation r100 = new ArrowOrientation("LEFT", 0, 1);
            LEFT = r100;
            ArrowOrientation r101 = new ArrowOrientation("TOP", 1, 2);
            TOP = r101;
            ArrowOrientation r102 = new ArrowOrientation("RIGHT", 2, 3);
            RIGHT = r102;
            ArrowOrientation r103 = new ArrowOrientation("BOTTOM", 3, 4);
            BOTTOM = r103;
            ArrowOrientation[] r104 = {r100, r101, r102, r103};
            f430641a = r104;
            f430642b = EnumEntriesKt.enumEntries(r104);
        }

        public static ArrowOrientation[] values() {
            return (ArrowOrientation[]) f430641a.clone();
        }

        public static ArrowOrientation valueOf(String r100) {
            return (ArrowOrientation) r27.a.a(ArrowOrientation.class, r100);
        }

        public final ArrowOrientation getType(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L19;
            if (r100 == 3) goto L18;
            if (r100 == 4) goto L17;
            return BOTTOM;
        L17:
            return BOTTOM;
        L18:
            return RIGHT;
        L19:
            return TOP;
        L15:
            return LEFT;
        }

        public ArrowOrientation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f430643a = null;

        static {
            int[] r100 = new int[ArrowOrientation.values().length];
            r100[ArrowOrientation.BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ArrowOrientation.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ArrowOrientation.LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ArrowOrientation.RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f430643a = r100;
        }
    }

    public final void R5() {
        float r100 = this.f430629d;
        ArrowOrientation r101 = this.f430628c;
        if (r101 != ArrowOrientation.RIGHT) goto L5;
        float r102 = this.f430635j;
    L6:
        this.f430631f = r100 - r102;
        float r103 = this.f430630e;
        if (r101 != ArrowOrientation.BOTTOM) goto L9;
        float r104 = this.f430635j;
    L10:
        this.f430632g = r103 - r104;
        this.f430626a.setColor(0);
        this.f430627b.reset();
        int r105 = this.f430633h;
        int r106 = this.f430635j;
        float r107 = r105 + r106;
        float r108 = this.f430632g;
        if (r107 <= r108) goto L13;
        float r109 = r108 - this.f430634i;
    L14:
        float r110 = r106 + r105;
        float r111 = this.f430631f;
        if (r110 <= r111) goto L17;
        float r112 = r111 - this.f430634i;
    L18:
        int r113 = a.f430643a[this.f430628c.ordinal()];
        if (r113 != 1) goto L21;
        float r114 = this.f430636k;
        int r115 = this.f430640o;
        if (r112 < (r114 + r115)) goto L37;
        this.f430627b.moveTo(r112 - r115, this.f430632g);
        Path r116 = this.f430627b;
        int r117 = this.f430640o;
        int r118 = this.f430634i;
        float r119 = r117 + ((r118 / 2.0f) - this.f430638m);
        int r120 = this.f430635j;
        r116.rCubicTo(r117, 0.0f, r119, r120, (r118 / 2.0f) + r117, r120);
    L38:
        int r121 = this.f430634i;
        float r122 = r121 + r112;
        float r123 = this.f430631f - this.f430636k;
        int r124 = this.f430639n;
        if (r122 >= (r123 - r124)) goto L41;
        int r125 = this.f430635j;
        this.f430627b.rCubicTo(this.f430637l, 0.0f, r121 / 2.0f, -r125, (r121 / 2.0f) + r124, -r125);
        this.f430627b.lineTo(this.f430631f - this.f430636k, this.f430632g);
    L41:
        Path r126 = this.f430627b;
        float r127 = this.f430631f;
        float r128 = this.f430632g;
        r126.quadTo(r127, r128, r127, r128 - this.f430636k);
        r126.lineTo(this.f430631f, this.f430636k + 0.0f);
        float r129 = this.f430631f;
        r126.quadTo(r129, 0.0f, r129 - this.f430636k, 0.0f);
        r126.lineTo(this.f430636k + 0.0f, 0.0f);
        r126.quadTo(0.0f, 0.0f, 0.0f, this.f430636k + 0.0f);
        r126.lineTo(0.0f, this.f430632g - this.f430636k);
        float r130 = this.f430636k;
        if (r112 < (this.f430640o + r130)) goto L44;
        float r131 = this.f430632g;
        r126.quadTo(0.0f, r131, r130 + 0.0f, r131);
    L45:
        this.f430627b.close();
        return;
    L44:
        float r132 = this.f430632g;
        r126.quadTo(0.0f, r132, r112 + (this.f430634i / 2.0f), this.f430635j + r132);
        goto L45
    L37:
        this.f430627b.moveTo((this.f430634i / 2.0f) + r112, this.f430632g + this.f430635j);
        goto L38
    L21:
        if (r113 != 3) goto L45;
        float r133 = this.f430636k;
        int r134 = this.f430640o;
        if (r109 < (r133 + r134)) goto L26;
        this.f430627b.moveTo(0.0f, r109 - r134);
        Path r135 = this.f430627b;
        int r136 = this.f430640o;
        int r137 = this.f430635j;
        int r138 = this.f430634i;
        r135.rCubicTo(0.0f, r136, -r137, ((r138 / 2.0f) - this.f430638m) + r136, -r137, (r138 / 2.0f) + r136);
    L27:
        int r139 = this.f430634i;
        float r140 = r139 + r109;
        float r141 = this.f430632g - this.f430636k;
        int r142 = this.f430639n;
        if (r140 >= (r141 - r142)) goto L30;
        Path r143 = this.f430627b;
        float r144 = this.f430637l;
        int r145 = this.f430635j;
        r143.rCubicTo(0.0f, r144, r145, r139 / 2.0f, r145, (r139 / 2.0f) + r142);
        this.f430627b.lineTo(0.0f, this.f430632g - this.f430636k);
    L30:
        Path r146 = this.f430627b;
        float r147 = this.f430632g;
        r146.quadTo(0.0f, r147, this.f430636k + 0.0f, r147);
        this.f430627b.lineTo(this.f430631f - this.f430636k, this.f430632g);
        Path r148 = this.f430627b;
        float r149 = this.f430631f;
        float r150 = this.f430632g;
        r148.quadTo(r149, r150, r149, r150 - this.f430636k);
        this.f430627b.lineTo(this.f430631f, this.f430636k + 0.0f);
        Path r151 = this.f430627b;
        float r152 = this.f430631f;
        r151.quadTo(r152, 0.0f, r152 - this.f430636k, 0.0f);
        this.f430627b.lineTo(this.f430636k + 0.0f, 0.0f);
        float r153 = this.f430636k;
        if (r109 < (this.f430640o + r153)) goto L33;
        this.f430627b.quadTo(0.0f, 0.0f, 0.0f, r153 + 0.0f);
        goto L45
    L33:
        this.f430627b.quadTo(0.0f, 0.0f, 0.0f - this.f430635j, r109 + (this.f430634i / 2.0f));
        goto L45
    L26:
        this.f430627b.moveTo(0.0f - this.f430635j, (this.f430634i / 2.0f) + r109);
        goto L27
    L17:
        r112 = r105;
        goto L18
    L13:
        r109 = r105;
        goto L14
    L9:
        r104 = 0.0f;
        goto L10
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final void invalidate() {
        R5();
        super.invalidate();
    }

    @Override // android.view.View
    public final void postInvalidate() {
        R5();
        super.postInvalidate();
    }

    public final int getArrowWidth() {
        return this.f430634i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawPath(this.f430627b, this.f430626a);
    }

    public final void setArrowPosition(int r100) {
        this.f430633h = r100;
    }

    public VoiceBubbleContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        this.f430626a = r102;
        this.f430627b = new Path();
        ArrowOrientation r103 = ArrowOrientation.BOTTOM;
        this.f430628c = r103;
        int r104 = UIUtils.dp2px(r100, 0.0f);
        this.f430634i = UIUtils.dp2px(r100, 12.0f);
        int r105 = UIUtils.dp2px(r100, 9.0f);
        this.f430635j = r105;
        this.f430636k = UIUtils.dp2px(r100, 10.0f);
        this.f430637l = UIUtils.dp2px(r100, 2.0f);
        this.f430638m = UIUtils.dp2px(r100, 2.0f);
        this.f430639n = UIUtils.dp2px(r100, 4.0f);
        this.f430640o = UIUtils.dp2px(r100, 4.0f);
        setWillNotDraw(false);
        r102.setFlags(5);
        r102.setStyle(Paint.Style.FILL);
        int r106 = a.f430643a[r103.ordinal()];
        if (r106 != 1) goto L5;
        setPadding(r104, r104, r104, r105 + r104);
    L16:
        setLayerType(1, null);
        return;
    L5:
        if (r106 != 2) goto L7;
        setPadding(r104, r105 + r104, r104, r104);
        goto L16
    L7:
        if (r106 != 3) goto L9;
        setPadding(r105 + r104, r104, r104, r104);
        goto L16
    L9:
        if (r106 != 4) goto L12;
        setPadding(r104, r105 + r104, r104, r104);
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f430629d = r100;
        this.f430630e = r101;
        R5();
    }
}

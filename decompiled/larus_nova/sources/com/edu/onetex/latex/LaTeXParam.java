package com.edu.onetex.latex;

import android.content.res.Resources;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.edu.onetex.latex.graphic.FontStyle;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zs7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00104\u001a\u00020\u0006\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u0010;\u001a\u000206\u0012\b\b\u0002\u0010>\u001a\u00020=\u0012\b\b\u0002\u0010B\u001a\u000206¢\u0006\u0004\bD\u0010EJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\"\u0010\u0016\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010$\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010R\u0017\u0010&\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b'\u0010\nR\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b3\u0010\nR\u0017\u00104\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u0010\nR\u0017\u00107\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010;\u001a\u0002068\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010B\u001a\u0002068\u0006¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010:¨\u0006F"}, d2 = {"Lcom/edu/onetex/latex/LaTeXParam;", "", "Lzs7/a;", "texSize", "", "getSize", "", "texWidth", "I", "getTexWidth", "()I", "setTexWidth", "(I)V", "textSize", FaceService.girlLabel, "getTextSize", "()F", "setTextSize", "(F)V", "alignValue", "getAlignValue", "setAlignValue", "splitStyleValue", "getSplitStyleValue", "setSplitStyleValue", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "texWidthSize", "Lzs7/a;", "getTexWidthSize", "()Lzs7/a;", "textSizeSize", "getTextSizeSize", "density", "getDensity", "fontStyle", "getFontStyle", "", "lineHeightMultiple", "D", "getLineHeightMultiple", "()D", "Lcom/edu/onetex/latex/TexAlignment;", "alignment", "Lcom/edu/onetex/latex/TexAlignment;", "getAlignment", "()Lcom/edu/onetex/latex/TexAlignment;", "foregroundColor", "getForegroundColor", "backgroundColor", "getBackgroundColor", "", "enablePhysicsFormula", "Z", "getEnablePhysicsFormula", "()Z", "enableRollbackAnalysis", "getEnableRollbackAnalysis", "Lcom/edu/onetex/latex/TextSplitStyle;", "splitStyle", "Lcom/edu/onetex/latex/TextSplitStyle;", "getSplitStyle", "()Lcom/edu/onetex/latex/TextSplitStyle;", "autoSpliteFormular", "getAutoSpliteFormular", "<init>", "(Ljava/lang/String;Lzs7/a;Lzs7/a;FIDLcom/edu/onetex/latex/TexAlignment;IIZZLcom/edu/onetex/latex/TextSplitStyle;Z)V", "onetex_release"}, k = 1, mv = {1, 4, 2})
public class LaTeXParam {
    private int alignValue;
    private final TexAlignment alignment;
    private final boolean autoSpliteFormular;
    private final int backgroundColor;
    private final String content;
    private final float density;
    private final boolean enablePhysicsFormula;
    private final boolean enableRollbackAnalysis;
    private final int fontStyle;
    private final int foregroundColor;
    private final double lineHeightMultiple;
    private final TextSplitStyle splitStyle;
    private int splitStyleValue;
    private int texWidth;
    private final a texWidthSize;
    private float textSize;
    private final a textSizeSize;

    public final int getAlignValue() {
        return this.alignValue;
    }

    public final TexAlignment getAlignment() {
        return this.alignment;
    }

    public final boolean getAutoSpliteFormular() {
        return this.autoSpliteFormular;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getContent() {
        return this.content;
    }

    public final float getDensity() {
        return this.density;
    }

    public final boolean getEnablePhysicsFormula() {
        return this.enablePhysicsFormula;
    }

    public final boolean getEnableRollbackAnalysis() {
        return this.enableRollbackAnalysis;
    }

    public final int getFontStyle() {
        return this.fontStyle;
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final double getLineHeightMultiple() {
        return this.lineHeightMultiple;
    }

    public final TextSplitStyle getSplitStyle() {
        return this.splitStyle;
    }

    public final int getSplitStyleValue() {
        return this.splitStyleValue;
    }

    public final int getTexWidth() {
        return this.texWidth;
    }

    public final a getTexWidthSize() {
        return this.texWidthSize;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final a getTextSizeSize() {
        return this.textSizeSize;
    }

    public final float getSize(a r100) {
        Intrinsics.checkNotNullParameter(r100, "texSize");
        int r101 = r100.f573489c;
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L7;
        float r102 = r100.f573488b;
        float r103 = this.density;
    L15:
        return r102 * r103;
    L7:
        if (r101 != 2) goto L14;
        r102 = r100.f573488b;
        r103 = this.density;
        goto L15
    L14:
        return r100.f573488b;
    L13:
        return r100.f573488b;
    }

    public final void setAlignValue(int r100) {
        this.alignValue = r100;
    }

    public final void setSplitStyleValue(int r100) {
        this.splitStyleValue = r100;
    }

    public final void setTexWidth(int r100) {
        this.texWidth = r100;
    }

    public final void setTextSize(float r100) {
        this.textSize = r100;
    }

    public LaTeXParam(String r100, a r101, a r102, float r103, int r104, double r105, TexAlignment r106, int r110, int r111, boolean r112, boolean r113, TextSplitStyle r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "texWidthSize");
        Intrinsics.checkNotNullParameter(r102, "textSizeSize");
        Intrinsics.checkNotNullParameter(r106, "alignment");
        Intrinsics.checkNotNullParameter(r114, "splitStyle");
        this.content = r100;
        this.texWidthSize = r101;
        this.textSizeSize = r102;
        this.density = r103;
        this.fontStyle = r104;
        this.lineHeightMultiple = r105;
        this.alignment = r106;
        this.foregroundColor = r110;
        this.backgroundColor = r111;
        this.enablePhysicsFormula = r112;
        this.enableRollbackAnalysis = r113;
        this.splitStyle = r114;
        this.autoSpliteFormular = r115;
        this.texWidth = (int) getSize(r101);
        this.textSize = getSize(r102);
        this.alignValue = r106.getValue();
        this.splitStyleValue = r114.getValue();
        r101.f573487a = r103;
        r102.f573487a = r103;
    }

    public LaTeXParam(String r110, a r111, a r210, float r211, int r212, double r213, TexAlignment r214, int r215, int r216, boolean r217, boolean r218, TextSplitStyle r310, boolean r311, int r312, DefaultConstructorMarker r313) {
        if ((r312 & 8) == 0) goto L5;
        Resources r100 = xs7.a.f565005a;
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
    L7:
        if ((r312 & 16) == 0) goto L9;
        int r102 = FontStyle.Regular.getValue();
    L11:
        if ((r312 & 32) == 0) goto L13;
        double r103 = 1.14d;
    L15:
        if ((r312 & 64) == 0) goto L17;
        TexAlignment r112 = TexAlignment.JUSTIFIED;
    L19:
        if ((r312 & 128) == 0) goto L21;
        int r113 = -16777216;
    L23:
        if ((r312 & 256) == 0) goto L25;
        int r114 = 0;
    L27:
        if ((r312 & 512) == 0) goto L29;
        boolean r115 = true;
    L31:
        if ((r312 & 1024) == 0) goto L33;
        boolean r116 = false;
    L35:
        if ((r312 & 2048) == 0) goto L37;
        TextSplitStyle r117 = TextSplitStyle.SPLIT_STYLE_CHAR;
    L39:
        if ((r312 & 4096) == 0) goto L41;
        boolean r118 = false;
    L42:
        this(r110, r111, r210, r101, r102, r103, r112, r113, r114, r115, r116, r117, r118);
        return;
    L41:
        r118 = r311;
        goto L42
    L37:
        r117 = r310;
        goto L39
    L33:
        r116 = r218;
        goto L35
    L29:
        r115 = r217;
        goto L31
    L25:
        r114 = r216;
        goto L27
    L21:
        r113 = r215;
        goto L23
    L17:
        r112 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}

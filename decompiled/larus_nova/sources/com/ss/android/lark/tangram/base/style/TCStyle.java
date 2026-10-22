package com.ss.android.lark.tangram.base.style;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001>B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00109\u001a\u00020\u0000H\u0016J\u0013\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010<H\u0096\u0002J\b\u0010=\u001a\u00020\nH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108¨\u0006?"}, d2 = {"Lcom/ss/android/lark/tangram/base/style/TCStyle;", "Ljava/io/Serializable;", "width", "Lcom/ss/android/lark/tangram/base/style/Value;", "height", "minWidth", "minHeight", "maxWidth", "maxHeight", "growWeight", "", "shrinkWeight", "aspectRatio", "", "scaleWidth", "scaleHeight", "align_self", "Lcom/ss/android/lark/tangram/base/style/Align;", "<init>", "(Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;IIFLcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Align;)V", "getWidth", "()Lcom/ss/android/lark/tangram/base/style/Value;", "setWidth", "(Lcom/ss/android/lark/tangram/base/style/Value;)V", "getHeight", "setHeight", "getMinWidth", "setMinWidth", "getMinHeight", "setMinHeight", "getMaxWidth", "setMaxWidth", "getMaxHeight", "setMaxHeight", "getGrowWeight", "()I", "setGrowWeight", "(I)V", "getShrinkWeight", "setShrinkWeight", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getScaleWidth", "setScaleWidth", "getScaleHeight", "setScaleHeight", "getAlign_self", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setAlign_self", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "isDataChange", "", "()Z", "setDataChange", "(Z)V", "clone", "equals", "other", "", "hashCode", "Builder", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class TCStyle implements Serializable {
    private Align align_self;
    private float aspectRatio;
    private int growWeight;
    private Value height;
    private boolean isDataChange;
    private Value maxHeight;
    private Value maxWidth;
    private Value minHeight;
    private Value minWidth;
    private Value scaleHeight;
    private Value scaleWidth;
    private int shrinkWeight;
    private Value width;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Value f441156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Value f441157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Value f441158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Value f441159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Value f441160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Value f441161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Value f441162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Value f441163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Align f441164i;

        public a() {
            Value.Companion.getClass();
            this.f441156a = Value.a.a();
            this.f441157b = Value.a.a();
            this.f441158c = Value.a.a();
            this.f441159d = Value.a.a();
            this.f441160e = Value.a.a();
            this.f441161f = Value.a.a();
            this.f441162g = Value.a.a();
            this.f441163h = Value.a.a();
            this.f441164i = Align.TOP;
        }
    }

    public TCStyle clone() {
        return new TCStyle(getWidth(), getHeight(), getMinWidth(), getMinHeight(), getMaxWidth(), getMaxHeight(), getGrowWeight(), getShrinkWeight(), getAspectRatio(), getScaleWidth(), getScaleHeight(), getAlign_self());
    }

    public int hashCode() {
        Value r100 = getWidth();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Value r104 = getHeight();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Value r107 = getMinWidth();
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Value r110 = getMinHeight();
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Value r113 = getMaxWidth();
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Value r116 = getMaxHeight();
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = ((((((int) (((((((r115 + r101) * 31) + getGrowWeight()) * 31) + getShrinkWeight()) * 31) + getAspectRatio())) * 31) + getScaleWidth().hashCode()) * 31) + getScaleHeight().hashCode()) * 31;
        if (this.isDataChange == false) goto L28;
        int r118 = 1231;
    L30:
        return r117 + r118;
    L28:
        r118 = 1237;
        goto L30
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public Align getAlign_self() {
        return this.align_self;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public int getGrowWeight() {
        return this.growWeight;
    }

    public Value getHeight() {
        return this.height;
    }

    public Value getMaxHeight() {
        return this.maxHeight;
    }

    public Value getMaxWidth() {
        return this.maxWidth;
    }

    public Value getMinHeight() {
        return this.minHeight;
    }

    public Value getMinWidth() {
        return this.minWidth;
    }

    public Value getScaleHeight() {
        return this.scaleHeight;
    }

    public Value getScaleWidth() {
        return this.scaleWidth;
    }

    public int getShrinkWeight() {
        return this.shrinkWeight;
    }

    public Value getWidth() {
        return this.width;
    }

    public final boolean isDataChange() {
        return this.isDataChange;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TCStyle) == true) goto L8;
        return false;
    L8:
        TCStyle r101 = (TCStyle) r100;
        if (Intrinsics.areEqual(getWidth(), r101.getWidth()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getHeight(), r101.getHeight()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getMinWidth(), r101.getMinWidth()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getMinHeight(), r101.getMinHeight()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(getMaxWidth(), r101.getMaxWidth()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getMaxHeight(), r101.getMaxHeight()) == true) goto L27;
        return false;
    L27:
        if (getGrowWeight() == r101.getGrowWeight()) goto L30;
        return false;
    L30:
        if (getShrinkWeight() == r101.getShrinkWeight()) goto L33;
        return false;
    L33:
        if (getAspectRatio() != r101.getAspectRatio()) goto L35;
        boolean r102 = true;
    L36:
        if (r102 == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(getScaleWidth(), r101.getScaleWidth()) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(getScaleHeight(), r101.getScaleHeight()) == true) goto L45;
        return false;
    L45:
        if (this.isDataChange == r101.isDataChange) goto L47;
        return false;
    L47:
        return true;
    L35:
        r102 = false;
        goto L36
    }

    public void setAlign_self(Align r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.align_self = r100;
    }

    public void setAspectRatio(float r100) {
        this.aspectRatio = r100;
    }

    public final void setDataChange(boolean r100) {
        this.isDataChange = r100;
    }

    public void setGrowWeight(int r100) {
        this.growWeight = r100;
    }

    public void setHeight(Value r100) {
        this.height = r100;
    }

    public void setMaxHeight(Value r100) {
        this.maxHeight = r100;
    }

    public void setMaxWidth(Value r100) {
        this.maxWidth = r100;
    }

    public void setMinHeight(Value r100) {
        this.minHeight = r100;
    }

    public void setMinWidth(Value r100) {
        this.minWidth = r100;
    }

    public void setScaleHeight(Value r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scaleHeight = r100;
    }

    public void setScaleWidth(Value r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scaleWidth = r100;
    }

    public void setShrinkWeight(int r100) {
        this.shrinkWeight = r100;
    }

    public void setWidth(Value r100) {
        this.width = r100;
    }

    public TCStyle(Value r100, Value r101, Value r102, Value r103, Value r104, Value r105, int r106, int r107, float r110, Value r111, Value r112, Align r113) {
        Intrinsics.checkNotNullParameter(r111, "scaleWidth");
        Intrinsics.checkNotNullParameter(r112, "scaleHeight");
        Intrinsics.checkNotNullParameter(r113, "align_self");
        this.width = r100;
        this.height = r101;
        this.minWidth = r102;
        this.minHeight = r103;
        this.maxWidth = r104;
        this.maxHeight = r105;
        this.growWeight = r106;
        this.shrinkWeight = r107;
        this.aspectRatio = r110;
        this.scaleWidth = r111;
        this.scaleHeight = r112;
        this.align_self = r113;
    }

    public /* synthetic */ TCStyle(Value r110, Value r111, Value r112, Value r113, Value r210, Value r211, int r212, int r213, float r214, Value r215, Value r216, Align r217, int r218, DefaultConstructorMarker r219) {
        if ((r218 & 4) == 0) goto L5;
        Value.Companion.getClass();
        Value r100 = Value.a.a();
    L7:
        if ((r218 & 8) == 0) goto L9;
        Value.Companion.getClass();
        Value r101 = Value.a.a();
    L11:
        if ((r218 & 16) == 0) goto L13;
        Value.Companion.getClass();
        Value r102 = Value.a.a();
    L15:
        if ((r218 & 32) == 0) goto L17;
        Value.Companion.getClass();
        Value r103 = Value.a.a();
    L19:
        if ((r218 & 64) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r218 & 128) == 0) goto L25;
        int r114 = 0;
    L27:
        if ((r218 & 256) == 0) goto L29;
        float r115 = 0.0f;
    L31:
        if ((r218 & 512) == 0) goto L33;
        Value.Companion.getClass();
        Value r116 = Value.a.a();
    L35:
        if ((r218 & 1024) == 0) goto L37;
        Value.Companion.getClass();
        Value r117 = Value.a.a();
    L39:
        if ((r218 & 2048) == 0) goto L41;
        Align r118 = Align.TOP;
    L42:
        this(r110, r111, r100, r101, r102, r103, r104, r114, r115, r116, r117, r118);
        return;
    L41:
        r118 = r217;
        goto L42
    L37:
        r117 = r216;
        goto L39
    L33:
        r116 = r215;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}

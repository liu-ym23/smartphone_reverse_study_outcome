package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_TYPE, "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$Data;", "getData", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$Data;", "setData", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$Data;)V", "equals", "", "o", "", "hashCode", "", "Data", "ColorStop", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorValueItem implements NonProguard {

    @SerializedName(WikiFolderPushPlugin.DATA)
    private Data data;

    @SerializedName(ResourceData.KEY_TYPE)
    private String type;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$ColorStop;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "alpha", "", "getAlpha", "()Ljava/lang/Float;", "setAlpha", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "offset", "getOffset", "setOffset", "equals", "", "o", "", "hashCode", "", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ColorStop implements NonProguard {

        @SerializedName("alpha")
        private Float alpha;

        @SerializedName("color")
        private String color;

        @SerializedName("offset")
        private Float offset;

        public ColorStop() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.color, this.alpha, this.offset});
        }

        public final Float getAlpha() {
            return this.alpha;
        }

        public final String getColor() {
            return this.color;
        }

        public final Float getOffset() {
            return this.offset;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (Intrinsics.areEqual(ColorStop.class, r5.getClass()) == false) goto L19;
            ColorStop r6 = (ColorStop) r5;
            if (Intrinsics.areEqual(this.color, r6.color) == true) goto L13;
        L17:
            return false;
        L13:
            if (Intrinsics.areEqual(this.alpha, r6.alpha) == false) goto L17;
            if (Intrinsics.areEqual(this.offset, r6.offset) == false) goto L17;
            return true;
        }

        public final void setAlpha(Float r1) {
            this.alpha = r1;
        }

        public final void setColor(String r1) {
            this.color = r1;
        }

        public final void setOffset(Float r1) {
            this.offset = r1;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020\u0005H\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$Data;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "r", "", "getR", "()Ljava/lang/Integer;", "setR", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "g", "getG", "setG", "b", "getB", "setB", "alpha", "", "getAlpha", "()Ljava/lang/Float;", "setAlpha", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "angle", "", "getAngle", "()Ljava/lang/Double;", "setAngle", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "colorStops", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem$ColorStop;", "getColorStops", "()Ljava/util/List;", "setColorStops", "(Ljava/util/List;)V", "equals", "", "o", "", "hashCode", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements NonProguard {

        @SerializedName("alpha")
        private Float alpha;

        @SerializedName("angle")
        private Double angle;

        @SerializedName("b")
        private Integer b;

        @SerializedName("color_stops")
        private List<ColorStop> colorStops;

        @SerializedName("g")
        private Integer g;

        @SerializedName("r")
        private Integer r;

        public Data() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.r, this.g, this.b, this.alpha, this.angle, this.colorStops});
        }

        public final Float getAlpha() {
            return this.alpha;
        }

        public final Double getAngle() {
            return this.angle;
        }

        public final Integer getB() {
            return this.b;
        }

        public final List<ColorStop> getColorStops() {
            return this.colorStops;
        }

        public final Integer getG() {
            return this.g;
        }

        public final Integer getR() {
            return this.r;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L25:
            return false;
        L8:
            if (Intrinsics.areEqual(Data.class, r5.getClass()) == false) goto L25;
            Data r6 = (Data) r5;
            if (Intrinsics.areEqual(this.r, r6.r) == true) goto L13;
        L23:
            return false;
        L13:
            if (Intrinsics.areEqual(this.g, r6.g) == false) goto L23;
            if (Intrinsics.areEqual(this.b, r6.b) == false) goto L23;
            if (Intrinsics.areEqual(this.alpha, r6.alpha) == false) goto L23;
            if (Intrinsics.areEqual(this.angle, r6.angle) == false) goto L23;
            if (Intrinsics.areEqual(this.colorStops, r6.colorStops) == false) goto L23;
            return true;
        }

        public final void setAlpha(Float r1) {
            this.alpha = r1;
        }

        public final void setAngle(Double r1) {
            this.angle = r1;
        }

        public final void setB(Integer r1) {
            this.b = r1;
        }

        public final void setColorStops(List<ColorStop> r1) {
            this.colorStops = r1;
        }

        public final void setG(Integer r1) {
            this.g = r1;
        }

        public final void setR(Integer r1) {
            this.r = r1;
        }
    }

    public ColorValueItem() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, this.data});
    }

    public final Data getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(ColorValueItem.class, r5.getClass()) == false) goto L17;
        ColorValueItem r6 = (ColorValueItem) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.data, r6.data) == false) goto L15;
        return true;
    }

    public final void setData(Data r1) {
        this.data = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }
}

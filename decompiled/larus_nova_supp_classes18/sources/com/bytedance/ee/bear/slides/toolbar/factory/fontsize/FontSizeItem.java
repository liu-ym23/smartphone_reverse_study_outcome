package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "min", "getMin", "setMin", "max", "getMax", "setMax", "extra", "getExtra", "setExtra", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontSizeItem implements NonProguard {

    @SerializedName("extra")
    private String extra;

    @SerializedName("max")
    private String max;

    @SerializedName("min")
    private String min;

    @SerializedName("value")
    private String value;

    public FontSizeItem() {
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMax() {
        return this.max;
    }

    public final String getMin() {
        return this.min;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public final void setMax(String r1) {
        this.max = r1;
    }

    public final void setMin(String r1) {
        this.min = r1;
    }

    public final void setValue(String r1) {
        this.value = r1;
    }
}

package com.bytedance.ee.bear.bitable.msgcenter.view;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/StringModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "text", "getText", "setText", "fontSize", "", "getFontSize", "()Ljava/lang/Integer;", "setFontSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lineHeight", "getLineHeight", "setLineHeight", "weight", "getWeight", "setWeight", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StringModel implements NonProguard {
    private String color;

    @SerializedName("font_size")
    private Integer fontSize;

    @SerializedName("line_height")
    private Integer lineHeight;
    private String text;
    private Integer weight;

    public StringModel() {
        this.text = "";
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setFontSize(Integer r100) {
        this.fontSize = r100;
    }

    public final void setLineHeight(Integer r100) {
        this.lineHeight = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setWeight(Integer r100) {
        this.weight = r100;
    }
}

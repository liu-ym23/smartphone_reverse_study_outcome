package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBorder;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "style", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/BorderStyle;", "getStyle", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/BorderStyle;", "setStyle", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/BorderStyle;)V", "width", "", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IBorder implements NonProguard {
    private String color;
    private BorderStyle style;
    private Float width;

    public String toString() {
        return "IBorder(color=" + this.color + ", style=" + this.style + ", width=" + this.width + ')';
    }

    public IBorder() {
        this.width = Float.valueOf(0.0f);
    }

    public final String getColor() {
        return this.color;
    }

    public final BorderStyle getStyle() {
        return this.style;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setStyle(BorderStyle r100) {
        this.style = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }
}

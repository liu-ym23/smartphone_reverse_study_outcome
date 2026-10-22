package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBackGroundInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "radius", "", "getRadius", "()I", "setRadius", "(I)V", "background", "", "getBackground", "()Ljava/lang/String;", "setBackground", "(Ljava/lang/String;)V", "border", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBorder;", "getBorder", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBorder;", "setBorder", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBorder;)V", "startRenderId", "getStartRenderId", "setStartRenderId", "endRenderId", "getEndRenderId", "setEndRenderId", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IBackGroundInfo implements NonProguard {
    private String background;
    private IBorder border;
    private String endRenderId;
    private int paddingHorizontal;
    private int radius;
    private String startRenderId;

    public String toString() {
        return "IBackGroundInfo(background=" + this.background + ", radius=" + this.radius + ", border=" + this.border + ", startRenderId=" + this.startRenderId + ", endRenderId=" + this.endRenderId + ')';
    }

    public IBackGroundInfo() {
        this.radius = 16;
    }

    public final String getBackground() {
        return this.background;
    }

    public final IBorder getBorder() {
        return this.border;
    }

    public final String getEndRenderId() {
        return this.endRenderId;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final String getStartRenderId() {
        return this.startRenderId;
    }

    public final void setBackground(String r100) {
        this.background = r100;
    }

    public final void setBorder(IBorder r100) {
        this.border = r100;
    }

    public final void setEndRenderId(String r100) {
        this.endRenderId = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setRadius(int r100) {
        this.radius = r100;
    }

    public final void setStartRenderId(String r100) {
        this.startRenderId = r100;
    }
}

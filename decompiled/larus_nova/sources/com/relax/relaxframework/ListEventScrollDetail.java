package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019¨\u0006,"}, d2 = {"Lcom/relax/relaxframework/ListEventScrollDetail;", "", "deltaX", "", "deltaY", "scrollLeft", "scrollTop", "scrollWidth", "scrollHeight", "listWidth", "listHeight", "eventSource", "", "attachedCells", "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/ListItemCellInfo;", "Lcom/bytedance/rts/foundation/RTSArray;", "(DDDDDDDDILjava/util/ArrayList;)V", "getAttachedCells", "()Ljava/util/ArrayList;", "setAttachedCells", "(Ljava/util/ArrayList;)V", "getDeltaX", "()D", "setDeltaX", "(D)V", "getDeltaY", "setDeltaY", "getEventSource", "()I", "setEventSource", "(I)V", "getListHeight", "setListHeight", "getListWidth", "setListWidth", "getScrollHeight", "setScrollHeight", "getScrollLeft", "setScrollLeft", "getScrollTop", "setScrollTop", "getScrollWidth", "setScrollWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListEventScrollDetail {
    private ArrayList<ListItemCellInfo> attachedCells;
    private double deltaX;
    private double deltaY;
    private int eventSource;
    private double listHeight;
    private double listWidth;
    private double scrollHeight;
    private double scrollLeft;
    private double scrollTop;
    private double scrollWidth;

    public final ArrayList<ListItemCellInfo> getAttachedCells() {
        return this.attachedCells;
    }

    public final double getDeltaX() {
        return this.deltaX;
    }

    public final double getDeltaY() {
        return this.deltaY;
    }

    public final int getEventSource() {
        return this.eventSource;
    }

    public final double getListHeight() {
        return this.listHeight;
    }

    public final double getListWidth() {
        return this.listWidth;
    }

    public final double getScrollHeight() {
        return this.scrollHeight;
    }

    public final double getScrollLeft() {
        return this.scrollLeft;
    }

    public final double getScrollTop() {
        return this.scrollTop;
    }

    public final double getScrollWidth() {
        return this.scrollWidth;
    }

    public final void setAttachedCells(ArrayList<ListItemCellInfo> r100) {
        this.attachedCells = r100;
    }

    public final void setDeltaX(double r100) {
        this.deltaX = r100;
    }

    public final void setDeltaY(double r100) {
        this.deltaY = r100;
    }

    public final void setEventSource(int r100) {
        this.eventSource = r100;
    }

    public final void setListHeight(double r100) {
        this.listHeight = r100;
    }

    public final void setListWidth(double r100) {
        this.listWidth = r100;
    }

    public final void setScrollHeight(double r100) {
        this.scrollHeight = r100;
    }

    public final void setScrollLeft(double r100) {
        this.scrollLeft = r100;
    }

    public final void setScrollTop(double r100) {
        this.scrollTop = r100;
    }

    public final void setScrollWidth(double r100) {
        this.scrollWidth = r100;
    }

    public ListEventScrollDetail(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114, int r210, ArrayList<ListItemCellInfo> r211) {
        this.deltaX = r100;
        this.deltaY = r101;
        this.scrollLeft = r102;
        this.scrollTop = r110;
        this.scrollWidth = r111;
        this.scrollHeight = r112;
        this.listWidth = r113;
        this.listHeight = r114;
        this.eventSource = r210;
        this.attachedCells = r211;
    }

    public /* synthetic */ ListEventScrollDetail(double r210, double r211, double r212, double r213, double r214, double r310, double r311, double r312, int r313, ArrayList r314, int r315, DefaultConstructorMarker r410) {
        if ((r315 & 512) == 0) goto L5;
        ArrayList r110 = null;
    L6:
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r110);
        return;
    L5:
        r110 = r314;
        goto L6
    }
}

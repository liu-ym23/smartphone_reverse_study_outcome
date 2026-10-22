package com.bytedance.ee.bear.sheet.tab.jsdata;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jn5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabData implements NonProguard, b {
    private List<SheetTabItem> data;
    private boolean draggable;
    private boolean editable;

    @Override // jn5.b
    public ArrayList<SheetTabItem> getSheetTabData() {
        ArrayList<SheetTabItem> r0 = new ArrayList();
        Iterator<SheetTabItem> r1 = this.data.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        SheetTabItem r2 = r1.next();
        if (r2.isHidden() == true) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public String toString() {
        return "SheetTabItems{ items=" + this.data + ", editable=" + this.editable + ", draggable=" + this.draggable + " }";
    }

    public SheetTabData() {
        this.editable = false;
        this.draggable = true;
    }

    @Override // jn5.b
    public boolean canEdit() {
        return this.editable;
    }

    public List<SheetTabItem> getData() {
        return this.data;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public SheetTabData(List<SheetTabItem> r2) {
        this.editable = false;
        this.draggable = true;
        this.data = r2;
    }

    public void setData(List<SheetTabItem> r1) {
        this.data = r1;
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public void setEditable(boolean r1) {
        this.editable = r1;
    }
}

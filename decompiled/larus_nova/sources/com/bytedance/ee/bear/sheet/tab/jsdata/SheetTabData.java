package com.bytedance.ee.bear.sheet.tab.jsdata;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jn5.b;

/* JADX INFO: loaded from: classes18.dex */
public class SheetTabData implements NonProguard, b {
    private List<SheetTabItem> data;
    private boolean draggable;
    private boolean editable;

    @Override // jn5.b
    public ArrayList<SheetTabItem> getSheetTabData() {
        ArrayList<SheetTabItem> r100 = new ArrayList();
        Iterator<SheetTabItem> r101 = this.data.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        SheetTabItem r102 = r101.next();
        if (r102.isHidden() == true) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
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

    public SheetTabData(List<SheetTabItem> r100) {
        this.editable = false;
        this.draggable = true;
        this.data = r100;
    }

    public void setData(List<SheetTabItem> r100) {
        this.data = r100;
    }

    public void setDraggable(boolean r100) {
        this.draggable = r100;
    }

    public void setEditable(boolean r100) {
        this.editable = r100;
    }
}

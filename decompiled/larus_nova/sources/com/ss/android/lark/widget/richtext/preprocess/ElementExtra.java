package com.ss.android.lark.widget.richtext.preprocess;

import android.text.Layout;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class ElementExtra implements Serializable {
    private static final long serialVersionUID = -47929645870592732L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient HashMap<String, HashMap<Integer, Layout>> f448340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient HashMap<String, HashMap<Integer, Layout>> f448341b;
    private int columnsCellMaxWidth;
    private int columnsCount;
    private String elementId;
    private FloorInfo floorInfo;
    private boolean isElementInTableCellNeedBold;
    private boolean isFromMe;
    private boolean isIgnore;
    private boolean isInColumnsCell;
    private boolean isInList;
    private boolean isInTableCell;
    private boolean isNeedSpacing;
    private Map<String, Integer> localStyle;
    private String parentId;
    private Map<String, String> remoteStyle;
    private int tableCellMaxWidth;
    private int tableRowSpan;

    public static class FloorInfo implements Serializable {
        public static final int NONE = -1;
        private static final long serialVersionUID = -6809914802218215075L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient RichTextElement.RichTextProperty f448342a;
        public int floor;
        public int index;
        public boolean isNeedDrawPrefix;

        public boolean isEnabled() {
            if (this.floor > (-1)) goto L5;
        L9:
            return false;
        L5:
            if (this.index <= (-1)) goto L9;
            if (this.f448342a == null) goto L9;
            return true;
        }

        public String toString() {
            return "FloorInfo{floor=" + this.floor + ", index=" + this.index + ", isNeedDrawPrefix=" + this.isNeedDrawPrefix + ", floorProperty=" + this.f448342a + '}';
        }

        public FloorInfo() {
            this.floor = -1;
            this.index = -1;
            this.isNeedDrawPrefix = true;
        }

        public RichTextElement.RichTextProperty getFloorProperty() {
            return this.f448342a;
        }

        public void setFloorProperty(RichTextElement.RichTextProperty r100) {
            if ((r100 instanceof RichTextElement.OLProperty) == false) goto L5;
        L6:
            this.f448342a = r100;
            return;
        L5:
            if ((r100 instanceof RichTextElement.ULProperty) == true) goto L6;
        }
    }

    public ElementExtra() {
        this.tableCellMaxWidth = 100;
        this.columnsCellMaxWidth = 100;
        this.isFromMe = false;
        this.tableRowSpan = 0;
        this.columnsCount = 0;
        this.remoteStyle = new ConcurrentHashMap();
        this.localStyle = new ConcurrentHashMap();
        this.floorInfo = new FloorInfo();
    }

    public int getColumnsCellMaxWidth() {
        return this.columnsCellMaxWidth;
    }

    public int getColumnsCount() {
        return this.columnsCount;
    }

    public HashMap<String, HashMap<Integer, Layout>> getColumnsLayoutMap() {
        return this.f448341b;
    }

    public String getElementId() {
        return this.elementId;
    }

    public FloorInfo getFloorInfo() {
        return this.floorInfo;
    }

    public Map<String, Integer> getLocalStyle() {
        return this.localStyle;
    }

    public String getParentId() {
        return this.parentId;
    }

    public Map<String, String> getRemoteStyle() {
        return this.remoteStyle;
    }

    public int getTableCellMaxWidth() {
        return this.tableCellMaxWidth;
    }

    public HashMap<String, HashMap<Integer, Layout>> getTableCellsLayoutMap() {
        return this.f448340a;
    }

    public int getTableRowSpan() {
        return this.tableRowSpan;
    }

    public boolean isElementInTableCellNeedBold() {
        return this.isElementInTableCellNeedBold;
    }

    public boolean isFromMe() {
        return this.isFromMe;
    }

    public boolean isIgnore() {
        return this.isIgnore;
    }

    public boolean isInColumnsCell() {
        return this.isInColumnsCell;
    }

    public boolean isInList() {
        return this.isInList;
    }

    public boolean isInTableCell() {
        return this.isInTableCell;
    }

    public boolean isNeedSpacing() {
        return this.isNeedSpacing;
    }

    public void appendLocalStyle(Map<String, Integer> r100) {
        if (r100 == null) goto L5;
        this.localStyle.putAll(r100);
        return;
    }

    public void appendRemoteStyle(Map<String, String> r100) {
        if (r100 == null) goto L9;
        this.remoteStyle.putAll(r100);
        Iterator<Map.Entry<String, String>> r101 = this.remoteStyle.entrySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next().getKey();
        if (((ArrayList) dec.a.f468103a).contains(r102) == true) goto L5;
        this.remoteStyle.remove(r102);
        goto L5
    L15:
        return;
    }

    public void setColumnsCellMaxWidth(int r100) {
        this.columnsCellMaxWidth = r100;
    }

    public void setColumnsCount(int r100) {
        this.columnsCount = r100;
    }

    public void setColumnsLayoutMap(HashMap<String, HashMap<Integer, Layout>> r100) {
        this.f448341b = r100;
    }

    public void setElementId(String r100) {
        this.elementId = r100;
    }

    public void setElementInTableCellNeedBold(boolean r100) {
        this.isElementInTableCellNeedBold = r100;
    }

    public void setFromMe(boolean r100) {
        this.isFromMe = r100;
    }

    public void setIgnore(boolean r100) {
        this.isIgnore = r100;
    }

    public void setInColumnsCell(boolean r100) {
        this.isInColumnsCell = r100;
    }

    public void setInList(boolean r100) {
        this.isInList = r100;
    }

    public void setInTableCell(boolean r100) {
        this.isInTableCell = r100;
    }

    public void setNeedSpacing(boolean r100) {
        this.isNeedSpacing = r100;
    }

    public void setParentId(String r100) {
        this.parentId = r100;
    }

    public void setTableCellMaxWidth(int r100) {
        this.tableCellMaxWidth = r100;
    }

    public void setTableCellsLayoutMap(HashMap<String, HashMap<Integer, Layout>> r100) {
        this.f448340a = r100;
    }

    public void setTableRowSpan(int r100) {
        this.tableRowSpan = r100;
    }

    public void appendLocalStyle(String r100, int r101) {
        this.localStyle.put(r100, Integer.valueOf(r101));
    }
}

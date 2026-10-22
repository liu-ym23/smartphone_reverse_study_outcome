package com.bytedance.ee.bear.sheet.filter;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterPageData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "total", "", "getTotal", "()I", "setTotal", "(I)V", "current", "getCurrent", "setCurrent", "size", "getSize", "setSize", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "list", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "getList", "()[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "setList", "([Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;)V", "[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "sheetId", "", "getSheetId", "()Ljava/lang/String;", "setSheetId", "(Ljava/lang/String;)V", "currentCol", "getCurrentCol", "setCurrentCol", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterPageData implements NonProguard {
    private int current;
    private int currentCol;
    private boolean hasNext;
    private FilterData.FilterOptionItem[] list;
    private String sheetId;
    private int size;
    private int total;

    public FilterPageData() {
    }

    public final int getCurrent() {
        return this.current;
    }

    public final int getCurrentCol() {
        return this.currentCol;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final FilterData.FilterOptionItem[] getList() {
        return this.list;
    }

    public final String getSheetId() {
        return this.sheetId;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setCurrent(int r1) {
        this.current = r1;
    }

    public final void setCurrentCol(int r1) {
        this.currentCol = r1;
    }

    public final void setHasNext(boolean r1) {
        this.hasNext = r1;
    }

    public final void setList(FilterData.FilterOptionItem[] r1) {
        this.list = r1;
    }

    public final void setSheetId(String r1) {
        this.sheetId = r1;
    }

    public final void setSize(int r1) {
        this.size = r1;
    }

    public final void setTotal(int r1) {
        this.total = r1;
    }
}

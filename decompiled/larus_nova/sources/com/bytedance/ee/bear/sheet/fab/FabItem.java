package com.bytedance.ee.bear.sheet.fab;

import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class FabItem implements NonProguard {
    private int bottomOffset;
    private FabSheetItem[] data;

    public static class FabSheetItem extends SheetItem {
        private String dateType;
        private String format;
        private String rangeType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CellType {
            public static final String CELL = "CELL";
            public static final String COL = "COL";
            public static final String ROW = "ROW";
        }

        @Override // com.bytedance.ee.bear.sheet.panel.SheetItem
        public String toString() {
            return "FabSheetItem{format='" + this.format + "', dateType='" + this.dateType + "', rangeType='" + this.rangeType + "'}";
        }

        @Override // com.bytedance.ee.bear.sheet.panel.SheetItem
        public int hashCode() {
            int r100 = super.hashCode() * 31;
            int r101 = 0;
            if (getFormat() == null) goto L5;
            int r102 = getFormat().hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            if (getDateType() == null) goto L9;
            int r104 = getDateType().hashCode();
        L10:
            int r105 = (r103 + r104) * 31;
            if (getRangeType() == null) goto L14;
            r101 = getRangeType().hashCode();
        L14:
            return r105 + r101;
        L9:
            r104 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public FabSheetItem() {
        }

        public String getDateType() {
            return this.dateType;
        }

        public String getFormat() {
            return this.format;
        }

        public String getRangeType() {
            return this.rangeType;
        }

        @Override // com.bytedance.ee.bear.sheet.panel.SheetItem
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FabSheetItem) == true) goto L9;
            return false;
        L9:
            if (super.equals(r100) == true) goto L11;
            return false;
        L11:
            FabSheetItem r101 = (FabSheetItem) r100;
            if (getFormat() == null) goto L17;
            if (getFormat().equals(r101.getFormat()) == true) goto L20;
        L18:
            return false;
        L20:
            if (getDateType() == null) goto L25;
            if (getDateType().equals(r101.getDateType()) == true) goto L28;
        L26:
            return false;
        L28:
            if (getRangeType() == null) goto L31;
            return getRangeType().equals(r101.getRangeType());
        L31:
            if (r101.getRangeType() == null) goto L36;
            return false;
        L36:
            return true;
        L25:
            if (r101.getDateType() == null) goto L28;
        L17:
            if (r101.getFormat() == null) goto L20;
            goto L18
        }

        public void setDateType(String r100) {
            this.dateType = r100;
        }

        public void setFormat(String r100) {
            this.format = r100;
        }

        public void setRangeType(String r100) {
            this.rangeType = r100;
        }
    }

    public FabItem() {
    }

    public int hashCode() {
        return (Arrays.hashCode(getData()) * 31) + getBottomOffset();
    }

    public int getBottomOffset() {
        return this.bottomOffset;
    }

    public FabSheetItem[] getData() {
        return this.data;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FabItem) == true) goto L8;
        return false;
    L8:
        FabItem r101 = (FabItem) r100;
        if (getBottomOffset() == r101.getBottomOffset()) goto L11;
    L13:
        return false;
    L11:
        if (Arrays.equals(getData(), r101.getData()) == false) goto L13;
        return true;
    }

    public void setBottomOffset(int r100) {
        this.bottomOffset = r100;
    }

    public void setData(FabSheetItem[] r100) {
        this.data = r100;
    }
}

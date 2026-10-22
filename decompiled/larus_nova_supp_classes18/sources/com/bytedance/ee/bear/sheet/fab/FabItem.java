package com.bytedance.ee.bear.sheet.fab;

import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
            int r0 = super.hashCode() * 31;
            int r2 = 0;
            if (getFormat() == null) goto L5;
            int r1 = getFormat().hashCode();
        L6:
            int r3 = (r0 + r1) * 31;
            if (getDateType() == null) goto L9;
            int r4 = getDateType().hashCode();
        L10:
            int r5 = (r3 + r4) * 31;
            if (getRangeType() == null) goto L14;
            r2 = getRangeType().hashCode();
        L14:
            return r5 + r2;
        L9:
            r4 = 0;
            goto L10
        L5:
            r1 = 0;
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
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FabSheetItem) == true) goto L9;
            return false;
        L9:
            if (super.equals(r5) == true) goto L11;
            return false;
        L11:
            FabSheetItem r6 = (FabSheetItem) r5;
            if (getFormat() == null) goto L17;
            if (getFormat().equals(r6.getFormat()) == true) goto L20;
        L18:
            return false;
        L20:
            if (getDateType() == null) goto L25;
            if (getDateType().equals(r6.getDateType()) == true) goto L28;
        L26:
            return false;
        L28:
            if (getRangeType() == null) goto L31;
            return getRangeType().equals(r6.getRangeType());
        L31:
            if (r6.getRangeType() == null) goto L36;
            return false;
        L36:
            return true;
        L25:
            if (r6.getDateType() == null) goto L28;
        L17:
            if (r6.getFormat() == null) goto L20;
            goto L18
        }

        public void setDateType(String r1) {
            this.dateType = r1;
        }

        public void setFormat(String r1) {
            this.format = r1;
        }

        public void setRangeType(String r1) {
            this.rangeType = r1;
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FabItem) == true) goto L8;
        return false;
    L8:
        FabItem r6 = (FabItem) r5;
        if (getBottomOffset() == r6.getBottomOffset()) goto L11;
    L13:
        return false;
    L11:
        if (Arrays.equals(getData(), r6.getData()) == false) goto L13;
        return true;
    }

    public void setBottomOffset(int r1) {
        this.bottomOffset = r1;
    }

    public void setData(FabSheetItem[] r1) {
        this.data = r1;
    }
}

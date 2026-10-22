package com.bytedance.ee.bear.sheet.inputbar.editor;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetInputData implements NonProguard {
    private InputData data;
    private boolean hideFAB;
    private SheetToolbarItem[] toolbarItems;

    public static class InputData implements NonProguard {
        private String cellInfo;
        private String dateType;
        private String format;
        private List<BaseSegment> segments;
        private Integer selectionEnd;
        private Integer selectionStart;
        private SegmentStyle style;
        private String value;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DateType {
            public static final String DATE = "date";
            public static final String DATETIME = "datetime";
            public static final String NULL = "";
            public static final String TIME = "time";
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface FormatType {
            public static final String DATE = "date";
            public static final String NUMBER = "number";
            public static final String TEXT = "text";
        }

        public InputData() {
        }

        public String toString() {
            return "InputData{format='" + this.format + "', dateType='" + this.dateType + "', segments=" + this.segments + ", style=" + this.style + ", cellInfo=" + this.cellInfo + '}';
        }

        public int hashCode() {
            int r1 = 0;
            if (getFormat() == null) goto L5;
            int r0 = getFormat().hashCode();
        L6:
            int r2 = r0 * 31;
            if (getDateType() == null) goto L9;
            int r3 = getDateType().hashCode();
        L10:
            int r4 = (r2 + r3) * 31;
            if (getSegments() == null) goto L13;
            int r5 = getSegments().hashCode();
        L14:
            int r6 = (r4 + r5) * 31;
            if (getStyle() == null) goto L18;
            r1 = getStyle().hashCode();
        L18:
            return r6 + r1;
        L13:
            r5 = 0;
            goto L14
        L9:
            r3 = 0;
            goto L10
        L5:
            r0 = 0;
            goto L6
        }

        public String getCellInfo() {
            return this.cellInfo;
        }

        public String getDateType() {
            return this.dateType;
        }

        public String getFormat() {
            return this.format;
        }

        public List<BaseSegment> getSegments() {
            return this.segments;
        }

        public Integer getSelectionEnd() {
            return this.selectionEnd;
        }

        public Integer getSelectionStart() {
            return this.selectionStart;
        }

        public SegmentStyle getStyle() {
            return this.style;
        }

        public String getValue() {
            return this.value;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof InputData) == true) goto L8;
            return false;
        L8:
            InputData r6 = (InputData) r5;
            if (getFormat() == null) goto L14;
            if (getFormat().equals(r6.getFormat()) == true) goto L17;
        L15:
            return false;
        L17:
            if (getDateType() == null) goto L22;
            if (getDateType().equals(r6.getDateType()) == true) goto L25;
        L23:
            return false;
        L25:
            if (getSegments() == null) goto L30;
            if (getSegments().equals(r6.getSegments()) == true) goto L33;
        L31:
            return false;
        L33:
            if (getStyle() == null) goto L36;
            return getStyle().equals(r6.getStyle());
        L36:
            if (r6.getStyle() == null) goto L41;
            return false;
        L41:
            return true;
        L30:
            if (r6.getSegments() == null) goto L33;
        L22:
            if (r6.getDateType() == null) goto L25;
        L14:
            if (r6.getFormat() == null) goto L17;
            goto L15
        }

        public void setCellInfo(String r1) {
            this.cellInfo = r1;
        }

        public void setDateType(String r1) {
            this.dateType = r1;
        }

        public void setFormat(String r1) {
            this.format = r1;
        }

        public void setSegments(List<BaseSegment> r1) {
            this.segments = r1;
        }

        public void setSelectionEnd(Integer r1) {
            this.selectionEnd = r1;
        }

        public void setSelectionStart(Integer r1) {
            this.selectionStart = r1;
        }

        public void setStyle(SegmentStyle r1) {
            this.style = r1;
        }

        public void setValue(String r1) {
            this.value = r1;
        }
    }

    public static class SheetToolbarItem implements NonProguard {
        private boolean hasSelectedState;
        private String id;
        private boolean isBadged;

        public SheetToolbarItem() {
        }

        public String toString() {
            return "SheetToolbarItemInfo{id='" + this.id + "', hasSelectedState=" + this.hasSelectedState + ", isBadged=" + this.isBadged + '}';
        }

        public String getId() {
            return this.id;
        }

        public boolean isBadged() {
            return this.isBadged;
        }

        public boolean isHasSelectedState() {
            return this.hasSelectedState;
        }

        public void setBadged(boolean r1) {
            this.isBadged = r1;
        }

        public void setHasSelectedState(boolean r1) {
            this.hasSelectedState = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }
    }

    public SheetInputData() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.data, Boolean.valueOf(this.hideFAB), this.toolbarItems});
    }

    public String toString() {
        return "SheetInputData{data=" + this.data + ", hideFAB=" + this.hideFAB + ", toolbarItems=" + Arrays.toString(this.toolbarItems) + '}';
    }

    public InputData getData() {
        return this.data;
    }

    public SheetToolbarItem[] getToolbarItems() {
        return this.toolbarItems;
    }

    public boolean isHideFAB() {
        return this.hideFAB;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SheetInputData) == true) goto L8;
        return false;
    L8:
        SheetInputData r6 = (SheetInputData) r5;
        if (getData() == null) goto L14;
        if (getData().equals(r6.getData()) == true) goto L16;
    L20:
        return false;
    L16:
        if (this.hideFAB != r6.hideFAB) goto L20;
        if (Arrays.deepEquals(this.toolbarItems, r6.toolbarItems) == false) goto L20;
        return true;
    L14:
        if (r6.getData() != null) goto L20;
        goto L20
    }

    public void setData(InputData r1) {
        this.data = r1;
    }

    public void setHideFAB(boolean r1) {
        this.hideFAB = r1;
    }

    public void setToolbarItems(SheetToolbarItem[] r1) {
        this.toolbarItems = r1;
    }
}

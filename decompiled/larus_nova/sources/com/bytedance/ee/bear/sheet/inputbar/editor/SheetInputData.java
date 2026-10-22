package com.bytedance.ee.bear.sheet.inputbar.editor;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
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
            int r100 = 0;
            if (getFormat() == null) goto L5;
            int r101 = getFormat().hashCode();
        L6:
            int r102 = r101 * 31;
            if (getDateType() == null) goto L9;
            int r103 = getDateType().hashCode();
        L10:
            int r104 = (r102 + r103) * 31;
            if (getSegments() == null) goto L13;
            int r105 = getSegments().hashCode();
        L14:
            int r106 = (r104 + r105) * 31;
            if (getStyle() == null) goto L18;
            r100 = getStyle().hashCode();
        L18:
            return r106 + r100;
        L13:
            r105 = 0;
            goto L14
        L9:
            r103 = 0;
            goto L10
        L5:
            r101 = 0;
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

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InputData) == true) goto L8;
            return false;
        L8:
            InputData r101 = (InputData) r100;
            if (getFormat() == null) goto L14;
            if (getFormat().equals(r101.getFormat()) == true) goto L17;
        L15:
            return false;
        L17:
            if (getDateType() == null) goto L22;
            if (getDateType().equals(r101.getDateType()) == true) goto L25;
        L23:
            return false;
        L25:
            if (getSegments() == null) goto L30;
            if (getSegments().equals(r101.getSegments()) == true) goto L33;
        L31:
            return false;
        L33:
            if (getStyle() == null) goto L36;
            return getStyle().equals(r101.getStyle());
        L36:
            if (r101.getStyle() == null) goto L41;
            return false;
        L41:
            return true;
        L30:
            if (r101.getSegments() == null) goto L33;
        L22:
            if (r101.getDateType() == null) goto L25;
        L14:
            if (r101.getFormat() == null) goto L17;
            goto L15
        }

        public void setCellInfo(String r100) {
            this.cellInfo = r100;
        }

        public void setDateType(String r100) {
            this.dateType = r100;
        }

        public void setFormat(String r100) {
            this.format = r100;
        }

        public void setSegments(List<BaseSegment> r100) {
            this.segments = r100;
        }

        public void setSelectionEnd(Integer r100) {
            this.selectionEnd = r100;
        }

        public void setSelectionStart(Integer r100) {
            this.selectionStart = r100;
        }

        public void setStyle(SegmentStyle r100) {
            this.style = r100;
        }

        public void setValue(String r100) {
            this.value = r100;
        }
    }

    public static class SheetToolbarItem implements NonProguard {
        private boolean hasSelectedState;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f237982id;
        private boolean isBadged;

        public SheetToolbarItem() {
        }

        public String toString() {
            return "SheetToolbarItemInfo{id='" + this.f237982id + "', hasSelectedState=" + this.hasSelectedState + ", isBadged=" + this.isBadged + '}';
        }

        public String getId() {
            return this.f237982id;
        }

        public boolean isBadged() {
            return this.isBadged;
        }

        public boolean isHasSelectedState() {
            return this.hasSelectedState;
        }

        public void setBadged(boolean r100) {
            this.isBadged = r100;
        }

        public void setHasSelectedState(boolean r100) {
            this.hasSelectedState = r100;
        }

        public void setId(String r100) {
            this.f237982id = r100;
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SheetInputData) == true) goto L8;
        return false;
    L8:
        SheetInputData r101 = (SheetInputData) r100;
        if (getData() == null) goto L14;
        if (getData().equals(r101.getData()) == true) goto L16;
    L20:
        return false;
    L16:
        if (this.hideFAB != r101.hideFAB) goto L20;
        if (Arrays.deepEquals(this.toolbarItems, r101.toolbarItems) == false) goto L20;
        return true;
    L14:
        if (r101.getData() != null) goto L20;
        goto L20
    }

    public void setData(InputData r100) {
        this.data = r100;
    }

    public void setHideFAB(boolean r100) {
        this.hideFAB = r100;
    }

    public void setToolbarItems(SheetToolbarItem[] r100) {
        this.toolbarItems = r100;
    }
}

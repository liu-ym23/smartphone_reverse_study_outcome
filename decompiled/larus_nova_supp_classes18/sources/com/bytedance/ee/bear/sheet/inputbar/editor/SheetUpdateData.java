package com.bytedance.ee.bear.sheet.inputbar.editor;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetUpdateData implements NonProguard {
    private String cellInfo;
    private String dateType;
    private int editState;
    private String format;
    private Boolean imeComposing;
    private List<BaseSegment> newValue;
    private Integer selectionEnd;
    private Integer selectionStart;
    private String source;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditState {
        public static final int CONTINUE = 3;
        public static final int END_CELL_AND_NEXT = 1;
        public static final int END_CELL_AND_PAN = 4;
        public static final int END_CELL_BY_MOBILE = 2;
    }

    public String getCellInfo() {
        return this.cellInfo;
    }

    public String getDateType() {
        return this.dateType;
    }

    public int getEditState() {
        return this.editState;
    }

    public String getFormat() {
        return this.format;
    }

    public Boolean getImeComposing() {
        return this.imeComposing;
    }

    public List<BaseSegment> getNewValue() {
        return this.newValue;
    }

    public Integer getSelectionEnd() {
        return this.selectionEnd;
    }

    public Integer getSelectionStart() {
        return this.selectionStart;
    }

    public String getSource() {
        return this.source;
    }

    public void setCellInfo(String r1) {
        this.cellInfo = r1;
    }

    public void setDateType(String r1) {
        this.dateType = r1;
    }

    public void setEditState(int r1) {
        this.editState = r1;
    }

    public void setFormat(String r1) {
        this.format = r1;
    }

    public void setImeComposing(Boolean r1) {
        this.imeComposing = r1;
    }

    public void setNewValue(List<BaseSegment> r1) {
        this.newValue = r1;
    }

    public void setSelectionEnd(Integer r1) {
        this.selectionEnd = r1;
    }

    public void setSelectionStart(Integer r1) {
        this.selectionStart = r1;
    }

    public void setSource(String r1) {
        this.source = r1;
    }

    public SheetUpdateData(int r1, List<BaseSegment> r2, String r3) {
        this.newValue = r2;
        this.editState = r1;
        this.cellInfo = r3;
    }

    public SheetUpdateData(int r1, List<BaseSegment> r2, String r3, String r4, String r5) {
        this.newValue = r2;
        this.editState = r1;
        this.format = r3;
        this.dateType = r4;
        this.cellInfo = r5;
    }

    public SheetUpdateData(int r1, List<BaseSegment> r2, String r3, String r4, String r5, Integer r6, Integer r7, String r8, Boolean r9) {
        this(r1, r2, r3, r4, r5);
        this.selectionStart = r6;
        this.selectionEnd = r7;
        this.source = r8;
        this.imeComposing = r9;
    }
}

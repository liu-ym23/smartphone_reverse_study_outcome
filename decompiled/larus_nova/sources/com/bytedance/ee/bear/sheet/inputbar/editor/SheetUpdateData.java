package com.bytedance.ee.bear.sheet.inputbar.editor;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setCellInfo(String r100) {
        this.cellInfo = r100;
    }

    public void setDateType(String r100) {
        this.dateType = r100;
    }

    public void setEditState(int r100) {
        this.editState = r100;
    }

    public void setFormat(String r100) {
        this.format = r100;
    }

    public void setImeComposing(Boolean r100) {
        this.imeComposing = r100;
    }

    public void setNewValue(List<BaseSegment> r100) {
        this.newValue = r100;
    }

    public void setSelectionEnd(Integer r100) {
        this.selectionEnd = r100;
    }

    public void setSelectionStart(Integer r100) {
        this.selectionStart = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }

    public SheetUpdateData(int r100, List<BaseSegment> r101, String r102) {
        this.newValue = r101;
        this.editState = r100;
        this.cellInfo = r102;
    }

    public SheetUpdateData(int r100, List<BaseSegment> r101, String r102, String r103, String r104) {
        this.newValue = r101;
        this.editState = r100;
        this.format = r102;
        this.dateType = r103;
        this.cellInfo = r104;
    }

    public SheetUpdateData(int r100, List<BaseSegment> r101, String r102, String r103, String r104, Integer r105, Integer r106, String r107, Boolean r108) {
        this(r100, r101, r102, r103, r104);
        this.selectionStart = r105;
        this.selectionEnd = r106;
        this.source = r107;
        this.imeComposing = r108;
    }
}

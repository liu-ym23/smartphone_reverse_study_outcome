package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class SearchCalendarEventInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -7929879512142632334L;
    private String mCalendarId;
    private Long mEndTime;
    private String mEventExactData;
    private String mEventKey;
    private boolean mIsGoogleEvent;
    private Long mOriginalTime;
    private Long mStartTime;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "calendar";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.mCalendarId, this.mEventKey, this.mOriginalTime, Boolean.valueOf(this.mIsGoogleEvent), this.mStartTime, this.mEndTime, this.mEventExactData});
    }

    public SearchCalendarEventInfo() {
        this.type = SearchCommonConstants.SearchResultType.CALENDAR_EVENT;
    }

    public String getCalendarId() {
        return this.mCalendarId;
    }

    public Long getEndTime() {
        return this.mEndTime;
    }

    public String getEventExactData() {
        return this.mEventExactData;
    }

    public String getEventKey() {
        return this.mEventKey;
    }

    public boolean getIsGoogleEvent() {
        return this.mIsGoogleEvent;
    }

    public Long getOriginalTime() {
        return this.mOriginalTime;
    }

    public Long getStartTime() {
        return this.mStartTime;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchCalendarEventInfo) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        SearchCalendarEventInfo r101 = (SearchCalendarEventInfo) r100;
        if (this.mIsGoogleEvent == r101.mIsGoogleEvent) goto L14;
    L26:
        return false;
    L14:
        if (Objects.equals(this.mCalendarId, r101.mCalendarId) == false) goto L26;
        if (Objects.equals(this.mEventKey, r101.mEventKey) == false) goto L26;
        if (Objects.equals(this.mOriginalTime, r101.mOriginalTime) == false) goto L26;
        if (Objects.equals(this.mStartTime, r101.mStartTime) == false) goto L26;
        if (Objects.equals(this.mEndTime, r101.mEndTime) == false) goto L26;
        if (Objects.equals(this.mEventExactData, r101.mEventExactData) == false) goto L26;
        return true;
    }

    public void setCalendarId(String r100) {
        this.mCalendarId = r100;
    }

    public void setEndTime(Long r100) {
        this.mEndTime = r100;
    }

    public void setEventExactData(String r100) {
        this.mEventExactData = r100;
    }

    public void setEventKey(String r100) {
        this.mEventKey = r100;
    }

    public void setIsGoogleEvent(boolean r100) {
        this.mIsGoogleEvent = r100;
    }

    public void setOriginalTime(Long r100) {
        this.mOriginalTime = r100;
    }

    public void setStartTime(Long r100) {
        this.mStartTime = r100;
    }
}

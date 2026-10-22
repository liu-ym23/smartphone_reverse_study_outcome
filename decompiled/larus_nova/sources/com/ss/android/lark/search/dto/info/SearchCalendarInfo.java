package com.ss.android.lark.search.dto.info;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u0006&"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchCalendarInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "calendar", "Lcom/ss/android/lark/search/dto/info/CalendarResult;", "<init>", "(Lcom/ss/android/lark/search/dto/info/CalendarResult;)V", "getCalendar", "()Lcom/ss/android/lark/search/dto/info/CalendarResult;", "isOver", "", "()Z", "isLastCalendarInOneDay", "setLastCalendarInOneDay", "(Z)V", "summaryTagList", "", "Lcom/ss/android/lark/search/dto/info/TagContent;", "getSummaryTagList", "()Ljava/util/List;", "setSummaryTagList", "(Ljava/util/List;)V", "nameTagList", "getNameTagList", "setNameTagList", "resourceTagList", "getResourceTagList", "setResourceTagList", "chatNameTagList", "getChatNameTagList", "setChatNameTagList", "attendeeTagList", "getAttendeeTagList", "setAttendeeTagList", "descTagList", "getDescTagList", "setDescTagList", "getResultTypeForReport", "", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCalendarInfo extends SearchBaseInfo {
    private List<TagContent> attendeeTagList;
    private final CalendarResult calendar;
    private List<TagContent> chatNameTagList;
    private List<TagContent> descTagList;
    private boolean isLastCalendarInOneDay;
    private final boolean isOver;
    private List<TagContent> nameTagList;
    private List<TagContent> resourceTagList;
    private List<TagContent> summaryTagList;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "calendar";
    }

    public final List<TagContent> getAttendeeTagList() {
        return this.attendeeTagList;
    }

    public final CalendarResult getCalendar() {
        return this.calendar;
    }

    public final List<TagContent> getChatNameTagList() {
        return this.chatNameTagList;
    }

    public final List<TagContent> getDescTagList() {
        return this.descTagList;
    }

    public final List<TagContent> getNameTagList() {
        return this.nameTagList;
    }

    public final List<TagContent> getResourceTagList() {
        return this.resourceTagList;
    }

    public final List<TagContent> getSummaryTagList() {
        return this.summaryTagList;
    }

    public final boolean isLastCalendarInOneDay() {
        return this.isLastCalendarInOneDay;
    }

    public final boolean isOver() {
        return this.isOver;
    }

    public SearchCalendarInfo(CalendarResult r100) {
        Intrinsics.checkNotNullParameter(r100, "calendar");
        this.calendar = r100;
        if (r100.getEndTime() >= System.currentTimeMillis()) goto L5;
        boolean r101 = true;
    L6:
        this.isOver = r101;
        this.summaryTagList = new ArrayList();
        this.nameTagList = new ArrayList();
        this.resourceTagList = new ArrayList();
        this.chatNameTagList = new ArrayList();
        this.attendeeTagList = new ArrayList();
        this.descTagList = new ArrayList();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setAttendeeTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attendeeTagList = r100;
    }

    public final void setChatNameTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chatNameTagList = r100;
    }

    public final void setDescTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.descTagList = r100;
    }

    public final void setLastCalendarInOneDay(boolean r100) {
        this.isLastCalendarInOneDay = r100;
    }

    public final void setNameTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nameTagList = r100;
    }

    public final void setResourceTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceTagList = r100;
    }

    public final void setSummaryTagList(List<TagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.summaryTagList = r100;
    }
}

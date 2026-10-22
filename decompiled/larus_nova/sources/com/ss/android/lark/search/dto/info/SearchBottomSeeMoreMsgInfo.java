package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchBottomSeeMoreMsgInfo;", "Lcom/ss/android/lark/search/dto/info/SearchMoreInfo;", "<init>", "()V", "isOpenSearchForEmail", "", "()Z", "setOpenSearchForEmail", "(Z)V", "isOpenSearchForCalendar", "setOpenSearchForCalendar", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBottomSeeMoreMsgInfo extends SearchMoreInfo {
    private boolean isOpenSearchForCalendar;
    private boolean isOpenSearchForEmail;

    public SearchBottomSeeMoreMsgInfo() {
    }

    public final boolean isOpenSearchForCalendar() {
        return this.isOpenSearchForCalendar;
    }

    public final boolean isOpenSearchForEmail() {
        return this.isOpenSearchForEmail;
    }

    public final void setOpenSearchForCalendar(boolean r100) {
        this.isOpenSearchForCalendar = r100;
    }

    public final void setOpenSearchForEmail(boolean r100) {
        this.isOpenSearchForEmail = r100;
    }
}

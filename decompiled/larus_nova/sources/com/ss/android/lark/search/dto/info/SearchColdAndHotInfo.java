package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchColdAndHotInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/search/dto/info/IFakeSearchUIInfo;", "coldAndHotType", "", "loading", "", "<init>", "(IZ)V", "getColdAndHotType", "()I", "getLoading", "()Z", "setLoading", "(Z)V", "emptyShowMsg", "", "getEmptyShowMsg", "()Ljava/lang/String;", "setEmptyShowMsg", "(Ljava/lang/String;)V", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchColdAndHotInfo extends SearchBaseInfo implements com.ss.android.lark.search.dto.info.a {
    public static final a Companion = null;
    private final int coldAndHotType;
    private String emptyShowMsg;
    private boolean loading;

    public static final class a {
        public static String a() {
            StringBuffer r100 = new StringBuffer();
            int r101 = 0;
        L4:
            if (r101 >= 11) goto L7;
            r100.append((int) (Math.random() * ((double) 10)));
            r101 = r101 + 1;
            goto L4
        L7:
            return r100.toString();
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getColdAndHotType() {
        return this.coldAndHotType;
    }

    public final String getEmptyShowMsg() {
        return this.emptyShowMsg;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setEmptyShowMsg(String r100) {
        this.emptyShowMsg = r100;
    }

    public final void setLoading(boolean r100) {
        this.loading = r100;
    }

    public SearchColdAndHotInfo(int r100, boolean r101) {
        this.coldAndHotType = r100;
        this.loading = r101;
    }

    public /* synthetic */ SearchColdAndHotInfo(int r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}

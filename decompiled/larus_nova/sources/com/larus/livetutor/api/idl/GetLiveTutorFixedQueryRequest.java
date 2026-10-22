package com.larus.livetutor.api.idl;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryRequest;", "Ljava/io/Serializable;", "isFirst", "", "enterMethod", "", "nextCursorId", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "recId", "tabId", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "()Ljava/lang/Boolean;", "setFirst", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "getNextCursorId", "()Ljava/lang/Long;", "setNextCursorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLimit", "setLimit", "getRecId", "setRecId", "getTabId", "setTabId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLiveTutorFixedQueryRequest implements Serializable {

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName(a.KEY_IS_FIRST)
    private Boolean isFirst;

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private Long limit;

    @SerializedName("next_cursor_id")
    private Long nextCursorId;

    @SerializedName("rec_id")
    private String recId;

    @SerializedName("tab_id")
    private Long tabId;

    public GetLiveTutorFixedQueryRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Long getLimit() {
        return this.limit;
    }

    public final Long getNextCursorId() {
        return this.nextCursorId;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final Long getTabId() {
        return this.tabId;
    }

    public final Boolean isFirst() {
        return this.isFirst;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFirst(Boolean r100) {
        this.isFirst = r100;
    }

    public final void setLimit(Long r100) {
        this.limit = r100;
    }

    public final void setNextCursorId(Long r100) {
        this.nextCursorId = r100;
    }

    public final void setRecId(String r100) {
        this.recId = r100;
    }

    public final void setTabId(Long r100) {
        this.tabId = r100;
    }

    public GetLiveTutorFixedQueryRequest(Boolean r100, String r101, Long r102, Long r103, String r104, Long r105) {
        this.isFirst = r100;
        this.enterMethod = r101;
        this.nextCursorId = r102;
        this.limit = r103;
        this.recId = r104;
        this.tabId = r105;
    }

    public /* synthetic */ GetLiveTutorFixedQueryRequest(Boolean r100, String r101, Long r102, Long r103, String r104, Long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        Long r105 = null;
        if ((r111 & 2) == 0) goto L8;
        String r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        Long r106 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        Long r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r108 = null;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}

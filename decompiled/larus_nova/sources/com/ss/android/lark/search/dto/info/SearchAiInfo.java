package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u00060"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchAiInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "shouldInsertToResult", "", "getShouldInsertToResult", "()Z", "setShouldInsertToResult", "(Z)V", "addToList", "getAddToList", "setAddToList", "spotlightRequestId", "", "getSpotlightRequestId", "()Ljava/lang/String;", "setSpotlightRequestId", "(Ljava/lang/String;)V", "currentRequestId", "getCurrentRequestId", "setCurrentRequestId", "value", "validAsk", "getValidAsk", "setValidAsk", "isShouldAnswerRequestFail", "setShouldAnswerRequestFail", "streamAnswerSessionId", "getStreamAnswerSessionId", "setStreamAnswerSessionId", "answerClickId", "getAnswerClickId", "setAnswerClickId", "queryIntention", "", "getQueryIntention", "()I", "setQueryIntention", "(I)V", "shouldOrder", "getShouldOrder", "setShouldOrder", "isShowingHongBao", "setShowingHongBao", "isNewUserForHongBao", "setNewUserForHongBao", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SearchAiInfo extends SearchBaseInfo {
    public static final int CODE_COMPLETE = 10000;
    public static final a Companion = null;
    public static final String DEFAULT_ID = "enterprise_qa";
    public static final String TAG = "AnswerInSearchInfo";
    private boolean addToList;
    private String answerClickId;
    private String currentRequestId;
    private boolean isNewUserForHongBao;
    private boolean isShouldAnswerRequestFail;
    private boolean isShowingHongBao;
    private int queryIntention;
    private boolean shouldInsertToResult;
    private boolean shouldOrder;
    private String spotlightRequestId;
    private String streamAnswerSessionId;
    private boolean validAsk;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SearchAiInfo() {
        this.shouldInsertToResult = true;
        this.spotlightRequestId = "";
        this.currentRequestId = "";
        this.streamAnswerSessionId = "";
        this.answerClickId = "";
    }

    public final boolean getAddToList() {
        return this.addToList;
    }

    public final String getAnswerClickId() {
        return this.answerClickId;
    }

    public final String getCurrentRequestId() {
        return this.currentRequestId;
    }

    public final int getQueryIntention() {
        return this.queryIntention;
    }

    public final boolean getShouldInsertToResult() {
        return this.shouldInsertToResult;
    }

    public final boolean getShouldOrder() {
        return this.shouldOrder;
    }

    public final String getSpotlightRequestId() {
        return this.spotlightRequestId;
    }

    public final String getStreamAnswerSessionId() {
        return this.streamAnswerSessionId;
    }

    public final boolean getValidAsk() {
        return this.validAsk;
    }

    public final boolean isNewUserForHongBao() {
        return this.isNewUserForHongBao;
    }

    public final boolean isShouldAnswerRequestFail() {
        return this.isShouldAnswerRequestFail;
    }

    public final boolean isShowingHongBao() {
        return this.isShowingHongBao;
    }

    public final void setAddToList(boolean r100) {
        this.addToList = r100;
    }

    public final void setAnswerClickId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.answerClickId = r100;
    }

    public final void setCurrentRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentRequestId = r100;
    }

    public final void setNewUserForHongBao(boolean r100) {
        this.isNewUserForHongBao = r100;
    }

    public final void setQueryIntention(int r100) {
        this.queryIntention = r100;
    }

    public final void setShouldAnswerRequestFail(boolean r100) {
        this.isShouldAnswerRequestFail = r100;
    }

    public final void setShouldInsertToResult(boolean r100) {
        this.shouldInsertToResult = r100;
    }

    public final void setShouldOrder(boolean r100) {
        this.shouldOrder = r100;
    }

    public final void setShowingHongBao(boolean r100) {
        this.isShowingHongBao = r100;
    }

    public final void setSpotlightRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spotlightRequestId = r100;
    }

    public final void setStreamAnswerSessionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        setId(r100);
        this.streamAnswerSessionId = r100;
    }

    public final void setValidAsk(boolean r100) {
        if (r100 == true) goto L4;
        String r101 = DEFAULT_ID;
    L5:
        setId(r101);
        this.validAsk = r100;
        return;
    L4:
        r101 = "enterprise_qa_long";
        goto L5
    }
}

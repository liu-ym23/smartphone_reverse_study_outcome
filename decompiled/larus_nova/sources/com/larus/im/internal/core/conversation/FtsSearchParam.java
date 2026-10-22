package com.larus.im.internal.core.conversation;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0010HÆ\u0003Jo\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\tHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/larus/im/internal/core/conversation/FtsSearchParam;", "", "query", "", "async", "", EffectConfiguration.KEY_CURSOR, "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "isFts", "conversationId", "conversationIdList", "", "senderId", "archiveFilter", "Lcom/larus/im/bean/conversation/ConversationArchiveFilter;", "<init>", "(Ljava/lang/String;ZJIZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/im/bean/conversation/ConversationArchiveFilter;)V", "getQuery", "()Ljava/lang/String;", "getAsync", "()Z", "getCursor", "()J", "getLimit", "()I", "getConversationId", "getConversationIdList", "()Ljava/util/List;", "getSenderId", "getArchiveFilter", "()Lcom/larus/im/bean/conversation/ConversationArchiveFilter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FtsSearchParam {
    private final ConversationArchiveFilter archiveFilter;
    private final boolean async;
    private final String conversationId;
    private final List<String> conversationIdList;
    private final long cursor;
    private final boolean isFts;
    private final int limit;
    private final String query;
    private final String senderId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FtsSearchParam copy$default(FtsSearchParam r110, String r111, boolean r112, long r113, int r114, boolean r115, String r116, List r117, String r210, ConversationArchiveFilter r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.query;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = r110.async;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.cursor;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.limit;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.isFts;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.conversationId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.conversationIdList;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r118 = r110.senderId;
    L35:
        if ((r212 & 256) == 0) goto L37;
        ConversationArchiveFilter r107 = r110.archiveFilter;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.query;
    }

    public final boolean component2() {
        return this.async;
    }

    public final long component3() {
        return this.cursor;
    }

    public final int component4() {
        return this.limit;
    }

    public final boolean component5() {
        return this.isFts;
    }

    public final String component6() {
        return this.conversationId;
    }

    public final List<String> component7() {
        return this.conversationIdList;
    }

    public final String component8() {
        return this.senderId;
    }

    public final ConversationArchiveFilter component9() {
        return this.archiveFilter;
    }

    public final FtsSearchParam copy(String r110, boolean r111, long r112, int r113, boolean r114, String r115, List<String> r210, String r211, ConversationArchiveFilter r212) {
        Intrinsics.checkNotNullParameter(r110, "query");
        Intrinsics.checkNotNullParameter(r212, "archiveFilter");
        return new FtsSearchParam(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FtsSearchParam) == true) goto L8;
        return false;
    L8:
        FtsSearchParam r101 = (FtsSearchParam) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (this.async == r101.async) goto L15;
        return false;
    L15:
        if (this.cursor == r101.cursor) goto L18;
        return false;
    L18:
        if (this.limit == r101.limit) goto L21;
        return false;
    L21:
        if (this.isFts == r101.isFts) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.conversationIdList, r101.conversationIdList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L33;
        return false;
    L33:
        if (this.archiveFilter == r101.archiveFilter) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = this.query.hashCode() * 31;
        int r101 = 1231;
        if (this.async == false) goto L5;
        int r102 = 1231;
    L6:
        long r103 = this.cursor;
        int r104 = (((((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.limit) * 31;
        if (this.isFts == true) goto L10;
        r101 = 1237;
    L10:
        int r105 = (r104 + r101) * 31;
        String r106 = this.conversationId;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        List<String> r110 = this.conversationIdList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.senderId;
        if (r113 == null) goto L23;
        r107 = r113.hashCode();
    L23:
        return ((r112 + r107) * 31) + this.archiveFilter.hashCode();
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "FtsSearchParam(query=" + this.query + ", async=" + this.async + ", cursor=" + this.cursor + ", limit=" + this.limit + ", isFts=" + this.isFts + ", conversationId=" + this.conversationId + ", conversationIdList=" + this.conversationIdList + ", senderId=" + this.senderId + ", archiveFilter=" + this.archiveFilter + ')';
    }

    public final ConversationArchiveFilter getArchiveFilter() {
        return this.archiveFilter;
    }

    public final boolean getAsync() {
        return this.async;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final List<String> getConversationIdList() {
        return this.conversationIdList;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final boolean isFts() {
        return this.isFts;
    }

    public FtsSearchParam(String r100, boolean r101, long r102, int r103, boolean r104, String r105, List<String> r106, String r110, ConversationArchiveFilter r111) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r111, "archiveFilter");
        this.query = r100;
        this.async = r101;
        this.cursor = r102;
        this.limit = r103;
        this.isFts = r104;
        this.conversationId = r105;
        this.conversationIdList = r106;
        this.senderId = r110;
        this.archiveFilter = r111;
    }

    public /* synthetic */ FtsSearchParam(String r110, boolean r111, long r112, int r113, boolean r210, String r211, List r212, String r213, ConversationArchiveFilter r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 4) == 0) goto L5;
        long r100 = Long.MAX_VALUE;
    L7:
        if ((r215 & 8) == 0) goto L9;
        int r101 = 10;
    L11:
        if ((r215 & 16) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r215 & 32) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r215 & 64) == 0) goto L21;
        List r115 = null;
    L23:
        if ((r215 & 128) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r215 & 256) == 0) goto L29;
        ConversationArchiveFilter r117 = ConversationArchiveFilter.ALL;
    L30:
        this(r110, r111, r100, r101, r102, r114, r115, r116, r117);
        return;
    L29:
        r117 = r214;
        goto L30
    L25:
        r116 = r213;
        goto L27
    L21:
        r115 = r212;
        goto L23
    L17:
        r114 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}

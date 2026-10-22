package com.larus.im.bean.message;

import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00060\u0001j\u0002`\u0002:\u0001!BS\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JU\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0010¨\u0006\""}, d2 = {"Lcom/larus/im/bean/message/MessageQueryResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "historyMessages", "", "Lcom/larus/im/bean/message/Message;", "hasMore", "", "pageToken", "", "ext", "", "domainPageToken", "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getHistoryMessages$annotations", "()V", "getHasMore$annotations", "getPageToken$annotations", "getExt$annotations", "getDomainPageToken$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageQueryResponse implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    public final String domainPageToken;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> ext;
    public final boolean hasMore;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<Message> historyMessages;
    public final String pageToken;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MessageQueryResponse() {
        this(null, false, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageQueryResponse copy$default(MessageQueryResponse r100, List r101, boolean r102, String r103, Map r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.historyMessages;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.hasMore;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.pageToken;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.ext;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.domainPageToken;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("domain_page_token")
    public static /* synthetic */ void getDomainPageToken$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("has_more")
    public static /* synthetic */ void getHasMore$annotations() {
    }

    @SerialName("history_messages")
    public static /* synthetic */ void getHistoryMessages$annotations() {
    }

    @SerialName("page_token")
    public static /* synthetic */ void getPageToken$annotations() {
    }

    public final List<Message> component1() {
        return this.historyMessages;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final String component3() {
        return this.pageToken;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final String component5() {
        return this.domainPageToken;
    }

    public final MessageQueryResponse copy(List<Message> r100, boolean r101, String r110, Map<String, String> r111, String r112) {
        return new MessageQueryResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageQueryResponse) == true) goto L8;
        return false;
    L8:
        MessageQueryResponse r101 = (MessageQueryResponse) r100;
        if (Intrinsics.areEqual(this.historyMessages, r101.historyMessages) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pageToken, r101.pageToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.domainPageToken, r101.domainPageToken) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<Message> r100 = this.historyMessages;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.pageToken;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Map<String, String> r109 = this.ext;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.domainPageToken;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageQueryResponse(historyMessages=" + this.historyMessages + ", hasMore=" + this.hasMore + ", pageToken=" + this.pageToken + ", ext=" + this.ext + ", domainPageToken=" + this.domainPageToken + ')';
    }

    public MessageQueryResponse(List<Message> r100, boolean r101, String r102, Map<String, String> r103, String r104) {
        this.historyMessages = r100;
        this.hasMore = r101;
        this.pageToken = r102;
        this.ext = r103;
        this.domainPageToken = r104;
    }

    public /* synthetic */ MessageQueryResponse(List r100, boolean r101, String r102, Map r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Map r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

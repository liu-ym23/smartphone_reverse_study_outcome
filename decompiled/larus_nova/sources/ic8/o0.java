package ic8;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nJ\u0012\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\rJ\b\u0010%\u001a\u0004\u0018\u00010\rJ\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u001b\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003Jg\u0010,\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020 HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecommendBotData;", "", "botList", "", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "hasMore", "", "tagList", "Lcom/larus/platform/api/creation/TabTag;", "selectTagId", "", "traceMap", "", "", "isFromCache", "<init>", "(Ljava/util/List;ZLjava/util/List;JLjava/util/Map;Z)V", "getBotList", "()Ljava/util/List;", "setBotList", "(Ljava/util/List;)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getTagList", "getSelectTagId", "()J", "getTraceMap", "()Ljava/util/Map;", "setFromCache", "selectIndex", "", "tagId", "setFrom", "", "scene", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient boolean f489246a;

    @SerializedName("bot_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<RecommendBot> botList;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("selected_tag_id")
    private final long selectTagId;

    @SerializedName("tag_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<zp9.w> tagList;

    @SerializedName("trace_map")
    private final Map<String, String> traceMap;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.botList, r101.botList) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L18;
        return false;
    L18:
        if (this.selectTagId == r101.selectTagId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceMap, r101.traceMap) == true) goto L24;
        return false;
    L24:
        if (this.f489246a == r101.f489246a) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        List<RecommendBot> r100 = this.botList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.hasMore == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        List<zp9.w> r107 = this.tagList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        long r109 = this.selectTagId;
        int r110 = (((r106 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Map<String, String> r111 = this.traceMap;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        int r112 = (r110 + r101) * 31;
        if (this.f489246a == true) goto L23;
        r104 = 1237;
    L23:
        return r112 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendBotData(botList=" + this.botList + ", hasMore=" + this.hasMore + ", tagList=" + this.tagList + ", selectTagId=" + this.selectTagId + ", traceMap=" + this.traceMap + ", isFromCache=" + this.f489246a + ')';
    }

    public final String d() {
        Map<String, String> r100 = this.traceMap;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("request_id");
    }

    public final int f() {
        List<zp9.w> r100 = this.tagList;
        if (r100 == null) goto L14;
        Iterator<zp9.w> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L18;
        zp9.w r103 = r101.next();
        if (this.selectTagId != r103.f573272a) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L17;
        r102 = r102 + 1;
        goto L6
    L17:
        return r102;
    L10:
        r104 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public o0() {
        this(CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), -1, MapsKt.emptyMap(), false);
    }

    public final List<RecommendBot> b() {
        return this.botList;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final List<zp9.w> e() {
        return this.tagList;
    }

    public final int g(long r100) {
        List<zp9.w> r101 = this.tagList;
        if (r101 == null) goto L14;
        Iterator<zp9.w> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L18;
        if (r100 != r102.next().f573272a) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L17;
        r103 = r103 + 1;
        goto L6
    L17:
        return r103;
    L10:
        r104 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public final void h(List<RecommendBot> r100) {
        this.botList = r100;
    }

    public final void i(String r100) {
        Map<String, String> r101 = this.traceMap;
        if (r101 == null) goto L12;
        String r102 = r101.get("request_id");
        if (r102 == null) goto L14;
        List<RecommendBot> r103 = this.botList;
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        RecommendBot r105 = (RecommendBot) r104.next();
        r105.f297431a = new RecommendFrom(r100, r102, null, 4);
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public static o0 a(o0 r100, List r101, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.botList;
    L5:
        List r102 = r101;
        if ((r111 & 2) == 0) goto L8;
        boolean r103 = r100.hasMore;
    L10:
        if ((r111 & 4) == 0) goto L12;
        List<zp9.w> r104 = r100.tagList;
    L14:
        if ((r111 & 8) == 0) goto L16;
        long r105 = r100.selectTagId;
    L18:
        if ((r111 & 16) == 0) goto L20;
        Map<String, String> r106 = r100.traceMap;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = r100.f489246a;
    L24:
        r100.getClass();
        return new o0(r102, r103, r104, r105, r106, r110);
    L20:
        r106 = null;
        goto L22
    L16:
        r105 = 0;
        goto L18
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = false;
        goto L10
    }

    public o0(List<RecommendBot> r100, boolean r101, List<zp9.w> r102, long r103, Map<String, String> r104, boolean r105) {
        this.botList = r100;
        this.hasMore = r101;
        this.tagList = r102;
        this.selectTagId = r103;
        this.traceMap = r104;
        this.f489246a = r105;
    }
}

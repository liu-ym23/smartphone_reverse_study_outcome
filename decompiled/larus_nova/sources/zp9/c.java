package zp9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jc\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/platform/api/creation/CommonCreationFeedData;", "", "hasMore", "", "traceMap", "", "", "creationList", "", "Lcom/larus/platform/api/creation/UserCreation;", "creationGroupList", "nextCursor", "<init>", "(ZLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getHasMore", "()Z", "getTraceMap", "()Ljava/util/Map;", "getCreationList", "()Ljava/util/List;", "getCreationGroupList", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("creation_group_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<List<UserCreation>> creationGroupList;

    @SerializedName("creation_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<UserCreation> creationList;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final String nextCursor;

    @SerializedName("trace_map")
    private final Map<String, String> traceMap;

    public c() {
        this(false, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.hasMore == r101.hasMore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.traceMap, r101.traceMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationList, r101.creationList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationGroupList, r101.creationGroupList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextCursor, r101.nextCursor) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.hasMore == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Map<String, String> r102 = this.traceMap;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<UserCreation> r106 = this.creationList;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        List<List<UserCreation>> r109 = this.creationGroupList;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.nextCursor;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommonCreationFeedData(hasMore=" + this.hasMore + ", traceMap=" + this.traceMap + ", creationList=" + this.creationList + ", creationGroupList=" + this.creationGroupList + ", nextCursor=" + this.nextCursor + ')';
    }

    public final List<List<UserCreation>> b() {
        return this.creationGroupList;
    }

    public final List<UserCreation> c() {
        return this.creationList;
    }

    public final boolean d() {
        return this.hasMore;
    }

    public final String e() {
        return this.nextCursor;
    }

    public final Map<String, String> f() {
        return this.traceMap;
    }

    public static c a(c r100, List r101) {
        boolean r102 = r100.hasMore;
        Map<String, String> r103 = r100.traceMap;
        List<UserCreation> r104 = r100.creationList;
        String r105 = r100.nextCursor;
        r100.getClass();
        return new c(r102, r103, r104, r101, r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(boolean r100, Map<String, String> r101, List<UserCreation> r102, List<? extends List<UserCreation>> r103, String r104) {
        this.hasMore = r100;
        this.traceMap = r101;
        this.creationList = r102;
        this.creationGroupList = r103;
        this.nextCursor = r104;
    }

    public /* synthetic */ c(boolean r100, Map r101, List r102, List r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Map r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        List r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L22:
        this(r103, r104, r105, r106, r107);
        return;
    L21:
        r107 = r111;
        goto L22
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}

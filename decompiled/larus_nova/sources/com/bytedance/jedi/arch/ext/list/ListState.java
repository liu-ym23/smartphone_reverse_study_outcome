package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.Uninitialized;
import com.bytedance.jedi.arch.ext.list.Payload;
import com.bytedance.locallife.dito.data.DitoNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004BS\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\tHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003Jj\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/ListState;", ExifInterface.GPS_DIRECTION_TRUE, "P", "Lcom/bytedance/jedi/arch/ext/list/Payload;", "Lcom/bytedance/jedi/arch/State;", WsConstants.KEY_PAYLOAD, "list", "", "refresh", "Lcom/bytedance/jedi/arch/Async;", DitoNode.LOAD_MORE, "isEmpty", "Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "(Lcom/bytedance/jedi/arch/ext/list/Payload;Ljava/util/List;Lcom/bytedance/jedi/arch/Async;Lcom/bytedance/jedi/arch/Async;Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;)V", "hasMore", "getHasMore", "()Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "getList", "()Ljava/util/List;", "getLoadMore", "()Lcom/bytedance/jedi/arch/Async;", "getPayload", "()Lcom/bytedance/jedi/arch/ext/list/Payload;", "Lcom/bytedance/jedi/arch/ext/list/Payload;", "getRefresh", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/jedi/arch/ext/list/Payload;Ljava/util/List;Lcom/bytedance/jedi/arch/Async;Lcom/bytedance/jedi/arch/Async;Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;)Lcom/bytedance/jedi/arch/ext/list/ListState;", "equals", "", "other", "", "hashCode", "", "toString", "", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class ListState<T, P extends Payload> implements State {
    private final DistinctBoolean isEmpty;
    private final List<T> list;
    private final Async<List<T>> loadMore;
    private final P payload;
    private final Async<List<T>> refresh;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListState copy$default(ListState r100, Payload r101, List r102, Async r103, Async r104, DistinctBoolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.payload;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.list;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.refresh;
    L11:
        Async r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.loadMore;
    L14:
        Async r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isEmpty;
    L17:
        Payload r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final P component1() {
        return this.payload;
    }

    public final List<T> component2() {
        return this.list;
    }

    public final Async<List<T>> component3() {
        return this.refresh;
    }

    public final Async<List<T>> component4() {
        return this.loadMore;
    }

    public final DistinctBoolean component5() {
        return this.isEmpty;
    }

    public final ListState<T, P> copy(P r100, List<? extends T> r101, Async<? extends List<? extends T>> r110, Async<? extends List<? extends T>> r111, DistinctBoolean r112) {
        return new ListState(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ListState) == false) goto L16;
        ListState r101 = (ListState) r100;
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.refresh, r101.refresh) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadMore, r101.loadMore) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isEmpty, r101.isEmpty) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        P r100 = this.payload;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<T> r104 = this.list;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Async<List<T>> r107 = this.refresh;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Async<List<T>> r110 = this.loadMore;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        DistinctBoolean r113 = this.isEmpty;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ListState(payload=" + this.payload + ", list=" + this.list + ", refresh=" + this.refresh + ", loadMore=" + this.loadMore + ", isEmpty=" + this.isEmpty + ")";
    }

    public final DistinctBoolean getHasMore() {
        return this.payload.getHasMore();
    }

    public final List<T> getList() {
        return this.list;
    }

    public final Async<List<T>> getLoadMore() {
        return this.loadMore;
    }

    public final P getPayload() {
        return this.payload;
    }

    public final Async<List<T>> getRefresh() {
        return this.refresh;
    }

    public final DistinctBoolean isEmpty() {
        return this.isEmpty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListState(P r100, List<? extends T> r101, Async<? extends List<? extends T>> r102, Async<? extends List<? extends T>> r103, DistinctBoolean r104) {
        this.payload = r100;
        this.list = r101;
        this.refresh = r102;
        this.loadMore = r103;
        this.isEmpty = r104;
    }

    public /* synthetic */ ListState(Payload r100, List r101, Async r102, Async r110, DistinctBoolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r103 = r101;
        if ((r112 & 4) == 0) goto L8;
        r102 = Uninitialized.INSTANCE;
    L8:
        Async r104 = r102;
        if ((r112 & 8) == 0) goto L11;
        r110 = Uninitialized.INSTANCE;
    L11:
        Async r105 = r110;
        if ((r112 & 16) == 0) goto L14;
        r111 = new DistinctBoolean(false);
    L14:
        this(r100, r103, r104, r105, r111);
    }
}

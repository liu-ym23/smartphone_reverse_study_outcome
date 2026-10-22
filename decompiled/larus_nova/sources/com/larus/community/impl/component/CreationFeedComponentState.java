package com.larus.community.impl.component;

import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/larus/community/impl/component/CreationFeedComponentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationModelList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "pageState", "Lcom/larus/community/impl/view/PageState;", "refreshState", "Lcom/larus/community/impl/view/RefreshState;", "moreState", "Lcom/larus/profile/api/model/MoreState;", "invokeLoadMoreEvent", "Lcom/larus/community/impl/component/InvokeEvent;", "invokeNotifyDataList", "Lcom/larus/community/impl/component/InvokeNotifyEvent;", "<init>", "(Ljava/util/List;Lcom/larus/community/impl/view/PageState;Lcom/larus/community/impl/view/RefreshState;Lcom/larus/profile/api/model/MoreState;Lcom/larus/community/impl/component/InvokeEvent;Lcom/larus/community/impl/component/InvokeNotifyEvent;)V", "getCreationModelList", "()Ljava/util/List;", "getPageState", "()Lcom/larus/community/impl/view/PageState;", "getRefreshState", "()Lcom/larus/community/impl/view/RefreshState;", "getMoreState", "()Lcom/larus/profile/api/model/MoreState;", "getInvokeLoadMoreEvent", "()Lcom/larus/community/impl/component/InvokeEvent;", "getInvokeNotifyDataList", "()Lcom/larus/community/impl/component/InvokeNotifyEvent;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFeedComponentState implements w1a.b {
    private final List<UserCreationModel> creationModelList;
    private final p1 invokeLoadMoreEvent;
    private final q1 invokeNotifyDataList;
    private final gs9.i moreState;
    private final r29.k pageState;
    private final r29.l refreshState;

    public CreationFeedComponentState() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationFeedComponentState copy$default(CreationFeedComponentState r100, List r101, r29.k r102, r29.l r103, gs9.i r104, p1 r105, q1 r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.creationModelList;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.pageState;
    L8:
        r29.k r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.refreshState;
    L11:
        r29.l r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.moreState;
    L14:
        gs9.i r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.invokeLoadMoreEvent;
    L17:
        p1 r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.invokeNotifyDataList;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<UserCreationModel> component1() {
        return this.creationModelList;
    }

    public final r29.k component2() {
        return this.pageState;
    }

    public final r29.l component3() {
        return this.refreshState;
    }

    public final gs9.i component4() {
        return this.moreState;
    }

    public final p1 component5() {
        return this.invokeLoadMoreEvent;
    }

    public final q1 component6() {
        return this.invokeNotifyDataList;
    }

    public final CreationFeedComponentState copy(List<UserCreationModel> r100, r29.k r110, r29.l r111, gs9.i r112, p1 r113, q1 r114) {
        Intrinsics.checkNotNullParameter(r100, "creationModelList");
        Intrinsics.checkNotNullParameter(r110, "pageState");
        return new CreationFeedComponentState(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationFeedComponentState) == true) goto L8;
        return false;
    L8:
        CreationFeedComponentState r101 = (CreationFeedComponentState) r100;
        if (Intrinsics.areEqual(this.creationModelList, r101.creationModelList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageState, r101.pageState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refreshState, r101.refreshState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moreState, r101.moreState) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.invokeLoadMoreEvent, r101.invokeLoadMoreEvent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.invokeNotifyDataList, r101.invokeNotifyDataList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.creationModelList.hashCode() * 31) + this.pageState.hashCode()) * 31;
        r29.l r101 = this.refreshState;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        gs9.i r105 = this.moreState;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        p1 r108 = this.invokeLoadMoreEvent;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        q1 r111 = this.invokeNotifyDataList;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationFeedComponentState(creationModelList=" + this.creationModelList + ", pageState=" + this.pageState + ", refreshState=" + this.refreshState + ", moreState=" + this.moreState + ", invokeLoadMoreEvent=" + this.invokeLoadMoreEvent + ", invokeNotifyDataList=" + this.invokeNotifyDataList + ')';
    }

    public final List<UserCreationModel> getCreationModelList() {
        return this.creationModelList;
    }

    public final p1 getInvokeLoadMoreEvent() {
        return this.invokeLoadMoreEvent;
    }

    public final q1 getInvokeNotifyDataList() {
        return this.invokeNotifyDataList;
    }

    public final gs9.i getMoreState() {
        return this.moreState;
    }

    public final r29.k getPageState() {
        return this.pageState;
    }

    public final r29.l getRefreshState() {
        return this.refreshState;
    }

    public CreationFeedComponentState(List<UserCreationModel> r100, r29.k r101, r29.l r102, gs9.i r103, p1 r104, q1 r105) {
        Intrinsics.checkNotNullParameter(r100, "creationModelList");
        Intrinsics.checkNotNullParameter(r101, "pageState");
        this.creationModelList = r100;
        this.pageState = r101;
        this.refreshState = r102;
        this.moreState = r103;
        this.invokeLoadMoreEvent = r104;
        this.invokeNotifyDataList = r105;
    }

    public /* synthetic */ CreationFeedComponentState(List r100, r29.k r101, r29.l r102, gs9.i r103, p1 r104, q1 r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = r29.k.d.f535815a;
    L8:
        r29.k r113 = r101;
        q1 r105 = null;
        if ((r111 & 4) == 0) goto L11;
        r29.l r106 = null;
    L13:
        if ((r111 & 8) == 0) goto L15;
        gs9.i r107 = null;
    L17:
        if ((r111 & 16) == 0) goto L19;
        p1 r108 = null;
    L21:
        if ((r111 & 32) != 0) goto L24;
        r105 = r110;
    L24:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L19:
        r108 = r104;
        goto L21
    L15:
        r107 = r103;
        goto L17
    L11:
        r106 = r102;
        goto L13
    }
}

package com.larus.avlink.record.page;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010)\u001a\u00020\u0012HÆ\u0003Ji\u0010*\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "historyList", "Lkotlin/Pair;", "Lcom/larus/avlink/record/page/Action;", "", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "deleteResult", "Lcom/larus/avlink/record/page/DeleteResult;", "uploadResult", "Lcom/larus/avlink/record/page/UploadResult;", "refreshResultTime", "", "pageState", "Lcom/larus/avlink/record/page/PageStatus;", "bottomState", "Lcom/larus/avlink/record/page/BottomStatus;", "syncState", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "<init>", "(Lkotlin/Pair;Lcom/larus/avlink/record/page/DeleteResult;Lcom/larus/avlink/record/page/UploadResult;JLcom/larus/avlink/record/page/PageStatus;Lcom/larus/avlink/record/page/BottomStatus;Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;)V", "getHistoryList", "()Lkotlin/Pair;", "getDeleteResult", "()Lcom/larus/avlink/record/page/DeleteResult;", "getUploadResult", "()Lcom/larus/avlink/record/page/UploadResult;", "getRefreshResultTime", "()J", "getPageState", "()Lcom/larus/avlink/record/page/PageStatus;", "getBottomState", "()Lcom/larus/avlink/record/page/BottomStatus;", "getSyncState", "()Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesState implements w1a.b {
    public static final int $stable = 8;
    private final BottomStatus bottomState;
    private final c deleteResult;
    private final Pair<Action, List<i0>> historyList;
    private final PageStatus pageState;
    private final long refreshResultTime;
    private final com.larus.dora.api.offline.record.d syncState;
    private final o1 uploadResult;

    public RecordMinutesState() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecordMinutesState copy$default(RecordMinutesState r100, Pair r110, c r111, o1 r112, long r113, PageStatus r114, BottomStatus r115, com.larus.dora.api.offline.record.d r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        Pair r101 = r100.historyList;
    L7:
        if ((r117 & 2) == 0) goto L9;
        c r102 = r100.deleteResult;
    L11:
        if ((r117 & 4) == 0) goto L13;
        o1 r103 = r100.uploadResult;
    L15:
        if ((r117 & 8) == 0) goto L17;
        long r104 = r100.refreshResultTime;
    L19:
        if ((r117 & 16) == 0) goto L21;
        PageStatus r105 = r100.pageState;
    L23:
        if ((r117 & 32) == 0) goto L25;
        BottomStatus r106 = r100.bottomState;
    L27:
        if ((r117 & 64) == 0) goto L29;
        com.larus.dora.api.offline.record.d r107 = r100.syncState;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Pair<Action, List<i0>> component1() {
        return this.historyList;
    }

    public final c component2() {
        return this.deleteResult;
    }

    public final o1 component3() {
        return this.uploadResult;
    }

    public final long component4() {
        return this.refreshResultTime;
    }

    public final PageStatus component5() {
        return this.pageState;
    }

    public final BottomStatus component6() {
        return this.bottomState;
    }

    public final com.larus.dora.api.offline.record.d component7() {
        return this.syncState;
    }

    public final RecordMinutesState copy(Pair<? extends Action, ? extends List<i0>> r110, c r111, o1 r112, long r113, PageStatus r114, BottomStatus r115, com.larus.dora.api.offline.record.d r116) {
        Intrinsics.checkNotNullParameter(r110, "historyList");
        Intrinsics.checkNotNullParameter(r116, "syncState");
        return new RecordMinutesState(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecordMinutesState) == true) goto L8;
        return false;
    L8:
        RecordMinutesState r101 = (RecordMinutesState) r100;
        if (Intrinsics.areEqual(this.historyList, r101.historyList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deleteResult, r101.deleteResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadResult, r101.uploadResult) == true) goto L18;
        return false;
    L18:
        if (this.refreshResultTime == r101.refreshResultTime) goto L21;
        return false;
    L21:
        if (this.pageState == r101.pageState) goto L24;
        return false;
    L24:
        if (this.bottomState == r101.bottomState) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.syncState, r101.syncState) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.historyList.hashCode() * 31;
        c r101 = this.deleteResult;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        o1 r105 = this.uploadResult;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.refreshResultTime;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        PageStatus r109 = this.pageState;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        BottomStatus r112 = this.bottomState;
        if (r112 == null) goto L19;
        r102 = r112.hashCode();
    L19:
        return ((r111 + r102) * 31) + this.syncState.hashCode();
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "RecordMinutesState(historyList=" + this.historyList + ", deleteResult=" + this.deleteResult + ", uploadResult=" + this.uploadResult + ", refreshResultTime=" + this.refreshResultTime + ", pageState=" + this.pageState + ", bottomState=" + this.bottomState + ", syncState=" + this.syncState + ')';
    }

    public final BottomStatus getBottomState() {
        return this.bottomState;
    }

    public final c getDeleteResult() {
        return this.deleteResult;
    }

    public final Pair<Action, List<i0>> getHistoryList() {
        return this.historyList;
    }

    public final PageStatus getPageState() {
        return this.pageState;
    }

    public final long getRefreshResultTime() {
        return this.refreshResultTime;
    }

    public final com.larus.dora.api.offline.record.d getSyncState() {
        return this.syncState;
    }

    public final o1 getUploadResult() {
        return this.uploadResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesState(Pair<? extends Action, ? extends List<i0>> r100, c r101, o1 r102, long r103, PageStatus r104, BottomStatus r105, com.larus.dora.api.offline.record.d r106) {
        Intrinsics.checkNotNullParameter(r100, "historyList");
        Intrinsics.checkNotNullParameter(r106, "syncState");
        this.historyList = r100;
        this.deleteResult = r101;
        this.uploadResult = r102;
        this.refreshResultTime = r103;
        this.pageState = r104;
        this.bottomState = r105;
        this.syncState = r106;
    }

    public RecordMinutesState(Pair r100, c r110, o1 r111, long r112, PageStatus r113, BottomStatus r114, com.larus.dora.api.offline.record.d r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        Pair r101 = new Pair(Action.UNKNOWN, CollectionsKt.emptyList());
    L6:
        o1 r102 = null;
        if ((r116 & 2) == 0) goto L9;
        c r103 = null;
    L11:
        if ((r116 & 4) != 0) goto L15;
        r102 = r111;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r116 & 16) == 0) goto L21;
        PageStatus r105 = PageStatus.LOADING;
    L23:
        if ((r116 & 32) != 0) goto L25;
        BottomStatus r106 = r114;
    L30:
        if ((r116 & 64) == 0) goto L32;
        com.larus.dora.api.offline.record.d r107 = com.larus.dora.api.offline.record.d.f331786i;
        com.larus.dora.api.offline.record.d r108 = com.larus.dora.api.offline.record.d.f331786i;
    L33:
        this(r101, r103, r102, r104, r105, r106, r108);
        return;
    L32:
        r108 = r115;
        goto L33
    L25:
        if (ia8.e.a().isRecording() == false) goto L27;
        r106 = BottomStatus.RECORDING;
        goto L30
    L27:
        r106 = BottomStatus.END_RECORDING;
        goto L30
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L9:
        r103 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }
}

package com.larus.bmhome.chat.cotdetail.component;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListComponentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "isStreaming", "", "isFromChunk", "threadMessageList", "", "Lcom/larus/im/bean/message/Message;", "<init>", "(ZZLjava/util/List;)V", "()Z", "getThreadMessageList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDetailListComponentState implements w1a.b {
    private final boolean isFromChunk;
    private final boolean isStreaming;
    private final List<Message> threadMessageList;

    public CotDetailListComponentState() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CotDetailListComponentState copy$default(CotDetailListComponentState r100, boolean r101, boolean r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isStreaming;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isFromChunk;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.threadMessageList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isStreaming;
    }

    public final boolean component2() {
        return this.isFromChunk;
    }

    public final List<Message> component3() {
        return this.threadMessageList;
    }

    public final CotDetailListComponentState copy(boolean r100, boolean r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r102, "threadMessageList");
        return new CotDetailListComponentState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotDetailListComponentState) == true) goto L8;
        return false;
    L8:
        CotDetailListComponentState r101 = (CotDetailListComponentState) r100;
        if (this.isStreaming == r101.isStreaming) goto L12;
        return false;
    L12:
        if (this.isFromChunk == r101.isFromChunk) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadMessageList, r101.threadMessageList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isStreaming == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isFromChunk == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.threadMessageList.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CotDetailListComponentState(isStreaming=" + this.isStreaming + ", isFromChunk=" + this.isFromChunk + ", threadMessageList=" + this.threadMessageList + ')';
    }

    public final List<Message> getThreadMessageList() {
        return this.threadMessageList;
    }

    public final boolean isFromChunk() {
        return this.isFromChunk;
    }

    public final boolean isStreaming() {
        return this.isStreaming;
    }

    public CotDetailListComponentState(boolean r100, boolean r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r102, "threadMessageList");
        this.isStreaming = r100;
        this.isFromChunk = r101;
        this.threadMessageList = r102;
    }

    public /* synthetic */ CotDetailListComponentState(boolean r100, boolean r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}

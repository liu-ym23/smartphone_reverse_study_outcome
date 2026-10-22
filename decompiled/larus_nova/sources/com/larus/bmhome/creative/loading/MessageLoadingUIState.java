package com.larus.bmhome.creative.loading;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "messageLoadingMap", "", "", "Lcom/larus/bmhome/creative/loading/ProgressLoadingUIState;", "updateId", "", "<init>", "(Ljava/util/Map;Ljava/lang/Long;)V", "getMessageLoadingMap", "()Ljava/util/Map;", "getUpdateId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/util/Map;Ljava/lang/Long;)Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageLoadingUIState implements b {
    private final Map<String, ProgressLoadingUIState> messageLoadingMap;
    private final Long updateId;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageLoadingUIState() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageLoadingUIState copy$default(MessageLoadingUIState r100, Map r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.messageLoadingMap;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.updateId;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, ProgressLoadingUIState> component1() {
        return this.messageLoadingMap;
    }

    public final Long component2() {
        return this.updateId;
    }

    public final MessageLoadingUIState copy(Map<String, ProgressLoadingUIState> r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "messageLoadingMap");
        return new MessageLoadingUIState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageLoadingUIState) == true) goto L8;
        return false;
    L8:
        MessageLoadingUIState r101 = (MessageLoadingUIState) r100;
        if (Intrinsics.areEqual(this.messageLoadingMap, r101.messageLoadingMap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updateId, r101.updateId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.messageLoadingMap.hashCode() * 31;
        Long r101 = this.updateId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "MessageLoadingUIState(messageLoadingMap=" + this.messageLoadingMap + ", updateId=" + this.updateId + ')';
    }

    public final Map<String, ProgressLoadingUIState> getMessageLoadingMap() {
        return this.messageLoadingMap;
    }

    public final Long getUpdateId() {
        return this.updateId;
    }

    public MessageLoadingUIState(Map<String, ProgressLoadingUIState> r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "messageLoadingMap");
        this.messageLoadingMap = r100;
        this.updateId = r101;
    }

    public /* synthetic */ MessageLoadingUIState(Map r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

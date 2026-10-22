package com.larus.uaigc.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/chat/CreationComponentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "id", "", "<init>", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationComponentState implements w1a.b {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f370381id;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationComponentState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreationComponentState copy$default(CreationComponentState r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f370381id;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.f370381id;
    }

    public final CreationComponentState copy(String r100) {
        return new CreationComponentState(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationComponentState) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f370381id, ((CreationComponentState) r100).f370381id) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.f370381id;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "CreationComponentState(id=" + this.f370381id + ')';
    }

    public CreationComponentState(String r100) {
        this.f370381id = r100;
    }

    public /* synthetic */ CreationComponentState(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

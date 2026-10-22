package com.bytedance.jedi.arch.ext.list;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/Payload;", "", "hasMore", "", EffectConfiguration.KEY_CURSOR, "", "(ZI)V", "getCursor", "()I", "Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "getHasMore", "()Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "equals", "other", "hashCode", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public class Payload {
    private final int cursor;
    private final DistinctBoolean hasMore;

    /* JADX WARN: Multi-variable type inference failed */
    public Payload() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public int hashCode() {
        return (this.hasMore.hashCode() * 31) + this.cursor;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final DistinctBoolean getHasMore() {
        return this.hasMore;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Payload) == true) goto L8;
        return false;
    L8:
        Payload r101 = (Payload) r100;
        if ((!Intrinsics.areEqual(this.hasMore, r101.hasMore)) == false) goto L12;
        return false;
    L12:
        if (this.cursor == r101.cursor) goto L14;
        return false;
    L14:
        return true;
    }

    public Payload(boolean r100, int r101) {
        this.cursor = r101;
        this.hasMore = new DistinctBoolean(r100);
    }

    public /* synthetic */ Payload(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}

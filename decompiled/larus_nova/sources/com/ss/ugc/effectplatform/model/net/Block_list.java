package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/Block_list;", "", "uri", "", "block_start", "", "block_end", "(Ljava/lang/String;JJ)V", "getBlock_end", "()J", "setBlock_end", "(J)V", "getBlock_start", "setBlock_start", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class Block_list {
    private long block_end;
    private long block_start;
    private String uri;

    public Block_list() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ Block_list copy$default(Block_list r100, String r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.block_start;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.block_end;
    L11:
        String r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    public final String component1() {
        return this.uri;
    }

    public final long component2() {
        return this.block_start;
    }

    public final long component3() {
        return this.block_end;
    }

    public final Block_list copy(String r100, long r101, long r110) {
        return new Block_list(r100, r101, r110);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Block_list) == false) goto L12;
        Block_list r101 = (Block_list) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
        return false;
    L8:
        if (this.block_start == r101.block_start) goto L10;
        return false;
    L10:
        if (this.block_end == r101.block_end) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.uri;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.block_start;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.block_end;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "Block_list(uri=" + this.uri + ", block_start=" + this.block_start + ", block_end=" + this.block_end + ")";
    }

    public final long getBlock_end() {
        return this.block_end;
    }

    public final long getBlock_start() {
        return this.block_start;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setBlock_end(long r100) {
        this.block_end = r100;
    }

    public final void setBlock_start(long r100) {
        this.block_start = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public Block_list(String r100, long r101, long r102) {
        this.uri = r100;
        this.block_start = r101;
        this.block_end = r102;
    }

    public /* synthetic */ Block_list(String r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L8;
        long r103 = 0;
    L10:
        if ((r110 & 4) == 0) goto L12;
        long r112 = 0;
    L13:
        this(r100, r103, r112);
        return;
    L12:
        r112 = r102;
        goto L13
    L8:
        r103 = r101;
        goto L10
    }
}

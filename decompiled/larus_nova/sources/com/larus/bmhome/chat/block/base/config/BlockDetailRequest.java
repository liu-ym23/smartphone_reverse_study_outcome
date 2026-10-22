package com.larus.bmhome.chat.block.base.config;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "Ljava/io/Serializable;", "message", "Lcom/larus/im/bean/message/Message;", "block", "", "Lcom/larus/im/bean/message/block/Block;", "title", "", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/util/List;Ljava/lang/String;)V", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getBlock", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockDetailRequest implements Serializable {
    private final List<Block> block;
    private final Message message;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlockDetailRequest copy$default(BlockDetailRequest r100, Message r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.message;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.block;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.title;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Message component1() {
        return this.message;
    }

    public final List<Block> component2() {
        return this.block;
    }

    public final String component3() {
        return this.title;
    }

    public final BlockDetailRequest copy(Message r100, List<Block> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        return new BlockDetailRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockDetailRequest) == true) goto L8;
        return false;
    L8:
        BlockDetailRequest r101 = (BlockDetailRequest) r100;
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.block, r101.block) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.message.hashCode() * 31) + this.block.hashCode()) * 31;
        String r101 = this.title;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "BlockDetailRequest(message=" + this.message + ", block=" + this.block + ", title=" + this.title + ')';
    }

    public final List<Block> getBlock() {
        return this.block;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }

    public BlockDetailRequest(Message r100, List<Block> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.message = r100;
        this.block = r101;
        this.title = r102;
    }

    public /* synthetic */ BlockDetailRequest(Message r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}

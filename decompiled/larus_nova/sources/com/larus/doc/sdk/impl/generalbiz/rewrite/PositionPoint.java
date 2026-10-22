package com.larus.doc.sdk.impl.generalbiz.rewrite;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PositionPoint;", "", "<init>", "()V", WikiFolderPushPlugin.BLOCK_ID, "", "getBlockId", "()Ljava/lang/String;", "setBlockId", "(Ljava/lang/String;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PositionPoint {

    @SerializedName(BitableResourceData.KEY_BLOCK_ID)
    private String blockId;

    @SerializedName("offset")
    private int offset;

    public PositionPoint() {
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final void setBlockId(String r100) {
        this.blockId = r100;
    }

    public final void setOffset(int r100) {
        this.offset = r100;
    }
}

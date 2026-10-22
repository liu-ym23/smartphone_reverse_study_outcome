package com.obric.aiagent.assistant.idl.bean;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/Block;", "Ljava/io/Serializable;", "blockType", "", WikiFolderPushPlugin.BLOCK_ID, "", "parentId", "content", "Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "isFinish", "", "appendFields", "", "metaInfo", "Lcom/obric/aiagent/assistant/idl/bean/BlockMetaInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/obric/aiagent/assistant/idl/bean/BlockContent;ZLjava/util/List;Ljava/util/List;)V", "getBlockType", "()I", "getBlockId", "()Ljava/lang/String;", "getParentId", "getContent", "()Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "()Z", "getAppendFields", "()Ljava/util/List;", "getMetaInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Block implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("append_fields")
    private final List<Integer> appendFields;

    @SerializedName(BitableResourceData.KEY_BLOCK_ID)
    private final String blockId;

    @SerializedName("block_type")
    private final int blockType;

    @SerializedName("content")
    private final BlockContent content;

    @SerializedName(EventConstant.Key.IS_FINISH)
    private final boolean isFinish;

    @SerializedName("meta_info")
    private final List<BlockMetaInfo> metaInfo;

    @SerializedName("parent_id")
    private final String parentId;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Block() {
        this(0, null, null, null, false, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Block copy$default(Block r100, int r101, String r102, String r103, BlockContent r104, boolean r110, List r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.blockType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.blockId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.parentId;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.content;
    L14:
        BlockContent r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isFinish;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.appendFields;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.metaInfo;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final String component3() {
        return this.parentId;
    }

    public final BlockContent component4() {
        return this.content;
    }

    public final boolean component5() {
        return this.isFinish;
    }

    public final List<Integer> component6() {
        return this.appendFields;
    }

    public final List<BlockMetaInfo> component7() {
        return this.metaInfo;
    }

    public final Block copy(int r110, String r111, String r112, BlockContent r113, boolean r114, List<Integer> r115, List<BlockMetaInfo> r116) {
        return new Block(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Block) == true) goto L8;
        return false;
    L8:
        Block r101 = (Block) r100;
        if (this.blockType == r101.blockType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r101.blockId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L21;
        return false;
    L21:
        if (this.isFinish == r101.isFinish) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appendFields, r101.appendFields) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.metaInfo, r101.metaInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.blockType * 31;
        String r101 = this.blockId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.parentId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        BlockContent r108 = this.content;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.isFinish == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        List<Integer> r113 = this.appendFields;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<BlockMetaInfo> r116 = this.metaInfo;
        if (r116 == null) goto L27;
        r102 = r116.hashCode();
    L27:
        return r115 + r102;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
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
        return "Block(blockType=" + this.blockType + ", blockId=" + this.blockId + ", parentId=" + this.parentId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", appendFields=" + this.appendFields + ", metaInfo=" + this.metaInfo + ')';
    }

    public final List<Integer> getAppendFields() {
        return this.appendFields;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final BlockContent getContent() {
        return this.content;
    }

    public final List<BlockMetaInfo> getMetaInfo() {
        return this.metaInfo;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public Block(int r100, String r101, String r102, BlockContent r103, boolean r104, List<Integer> r105, List<BlockMetaInfo> r106) {
        this.blockType = r100;
        this.blockId = r101;
        this.parentId = r102;
        this.content = r103;
        this.isFinish = r104;
        this.appendFields = r105;
        this.metaInfo = r106;
    }

    public /* synthetic */ Block(int r100, String r101, String r102, BlockContent r110, boolean r111, List r112, List r113, int r114, DefaultConstructorMarker r115) {
        boolean r103 = false;
        if ((r114 & 1) == 0) goto L5;
        int r116 = 0;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        BlockContent r106 = null;
    L19:
        if ((r114 & 16) != 0) goto L23;
        r103 = r111;
    L23:
        if ((r114 & 32) == 0) goto L25;
        List r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        List r117 = null;
    L30:
        this(r116, r104, r105, r106, r103, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

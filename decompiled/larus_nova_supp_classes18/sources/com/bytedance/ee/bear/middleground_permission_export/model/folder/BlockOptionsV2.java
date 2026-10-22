package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001cB\u008b\u0002\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;", "Lcom/bytedance/ee/util/io/NonProguard;", "share", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2$BlockEntity;", "Lkotlin/collections/ArrayList;", "managerCollaborator", "externalAccess", "shareExternal", "security", "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getShare", "()Ljava/util/ArrayList;", "getManagerCollaborator", "getExternalAccess", "getShareExternal", "getSecurity", "getCopy", "getShowCollaboratorInfo", "getComment", "getLinkShare", "getApplyEmbed", "BlockEntity", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BlockOptionsV2 implements NonProguard {
    private final ArrayList<BlockEntity> applyEmbed;
    private final ArrayList<BlockEntity> comment;
    private final ArrayList<BlockEntity> copy;
    private final ArrayList<BlockEntity> externalAccess;
    private final ArrayList<BlockEntity> linkShare;
    private final ArrayList<BlockEntity> managerCollaborator;
    private final ArrayList<BlockEntity> security;
    private final ArrayList<BlockEntity> share;
    private final ArrayList<BlockEntity> shareExternal;
    private final ArrayList<BlockEntity> showCollaboratorInfo;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2$BlockEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "blockType", "", "value", "canEscape", "", "isEscaped", "<init>", "(IIZZ)V", "getBlockType", "()I", "getValue", "getCanEscape", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BlockEntity implements NonProguard {
        private final int blockType;
        private final boolean canEscape;
        private final boolean isEscaped;
        private final int value;

        public BlockEntity() {
            this(0, 0, false, false, 15, null);
        }

        public static /* synthetic */ BlockEntity copy$default(BlockEntity r0, int r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.blockType;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.value;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.canEscape;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.isEscaped;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.blockType;
        }

        public final int component2() {
            return this.value;
        }

        public final boolean component3() {
            return this.canEscape;
        }

        public final boolean component4() {
            return this.isEscaped;
        }

        public final BlockEntity copy(int r2, int r3, boolean r4, boolean r5) {
            return new BlockEntity(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BlockEntity) == true) goto L8;
            return false;
        L8:
            BlockEntity r6 = (BlockEntity) r5;
            if (this.blockType == r6.blockType) goto L12;
            return false;
        L12:
            if (this.value == r6.value) goto L15;
            return false;
        L15:
            if (this.canEscape == r6.canEscape) goto L18;
            return false;
        L18:
            if (this.isEscaped == r6.isEscaped) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.blockType * 31) + this.value) * 31;
            int r2 = 1231;
            if (this.canEscape == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.isEscaped == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            return "BlockEntity(blockType=" + this.blockType + ", value=" + this.value + ", canEscape=" + this.canEscape + ", isEscaped=" + this.isEscaped + ')';
        }

        public final int getBlockType() {
            return this.blockType;
        }

        public final boolean getCanEscape() {
            return this.canEscape;
        }

        public final int getValue() {
            return this.value;
        }

        public final boolean isEscaped() {
            return this.isEscaped;
        }

        public BlockEntity(int r1, int r2, boolean r3, boolean r4) {
            this.blockType = r1;
            this.value = r2;
            this.canEscape = r3;
            this.isEscaped = r4;
        }

        public /* synthetic */ BlockEntity(int r2, int r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    public BlockOptionsV2() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final ArrayList<BlockEntity> getApplyEmbed() {
        return this.applyEmbed;
    }

    public final ArrayList<BlockEntity> getComment() {
        return this.comment;
    }

    public final ArrayList<BlockEntity> getCopy() {
        return this.copy;
    }

    public final ArrayList<BlockEntity> getExternalAccess() {
        return this.externalAccess;
    }

    public final ArrayList<BlockEntity> getLinkShare() {
        return this.linkShare;
    }

    public final ArrayList<BlockEntity> getManagerCollaborator() {
        return this.managerCollaborator;
    }

    public final ArrayList<BlockEntity> getSecurity() {
        return this.security;
    }

    public final ArrayList<BlockEntity> getShare() {
        return this.share;
    }

    public final ArrayList<BlockEntity> getShareExternal() {
        return this.shareExternal;
    }

    public final ArrayList<BlockEntity> getShowCollaboratorInfo() {
        return this.showCollaboratorInfo;
    }

    public BlockOptionsV2(ArrayList<BlockEntity> r2, ArrayList<BlockEntity> r3, ArrayList<BlockEntity> r4, ArrayList<BlockEntity> r5, ArrayList<BlockEntity> r6, ArrayList<BlockEntity> r7, ArrayList<BlockEntity> r8, ArrayList<BlockEntity> r9, ArrayList<BlockEntity> r10, ArrayList<BlockEntity> r11) {
        Intrinsics.checkNotNullParameter(r2, "share");
        Intrinsics.checkNotNullParameter(r3, "managerCollaborator");
        Intrinsics.checkNotNullParameter(r4, "externalAccess");
        Intrinsics.checkNotNullParameter(r5, "shareExternal");
        Intrinsics.checkNotNullParameter(r6, "security");
        Intrinsics.checkNotNullParameter(r7, "copy");
        Intrinsics.checkNotNullParameter(r8, "showCollaboratorInfo");
        Intrinsics.checkNotNullParameter(r9, "comment");
        Intrinsics.checkNotNullParameter(r10, "linkShare");
        Intrinsics.checkNotNullParameter(r11, "applyEmbed");
        this.share = r2;
        this.managerCollaborator = r3;
        this.externalAccess = r4;
        this.shareExternal = r5;
        this.security = r6;
        this.copy = r7;
        this.showCollaboratorInfo = r8;
        this.comment = r9;
        this.linkShare = r10;
        this.applyEmbed = r11;
    }

    public /* synthetic */ BlockOptionsV2(ArrayList r11, ArrayList r12, ArrayList r13, ArrayList r14, ArrayList r15, ArrayList r16, ArrayList r17, ArrayList r18, ArrayList r19, ArrayList r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        ArrayList r1 = new ArrayList();
    L7:
        if ((r21 & 2) == 0) goto L9;
        ArrayList r2 = new ArrayList();
    L11:
        if ((r21 & 4) == 0) goto L13;
        ArrayList r3 = new ArrayList();
    L15:
        if ((r21 & 8) == 0) goto L17;
        ArrayList r4 = new ArrayList();
    L19:
        if ((r21 & 16) == 0) goto L21;
        ArrayList r5 = new ArrayList();
    L23:
        if ((r21 & 32) == 0) goto L25;
        ArrayList r6 = new ArrayList();
    L27:
        if ((r21 & 64) == 0) goto L29;
        ArrayList r7 = new ArrayList();
    L31:
        if ((r21 & 128) == 0) goto L33;
        ArrayList r8 = new ArrayList();
    L35:
        if ((r21 & 256) == 0) goto L37;
        ArrayList r9 = new ArrayList();
    L39:
        if ((r21 & 512) == 0) goto L41;
        ArrayList r0 = new ArrayList();
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L41:
        r0 = r20;
        goto L42
    L37:
        r9 = r19;
        goto L39
    L33:
        r8 = r18;
        goto L35
    L29:
        r7 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}

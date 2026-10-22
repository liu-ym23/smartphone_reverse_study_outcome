package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001cB\u008b\u0002\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;", "Lcom/bytedance/ee/util/io/NonProguard;", "share", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2$BlockEntity;", "Lkotlin/collections/ArrayList;", "managerCollaborator", "externalAccess", "shareExternal", AppConstants.API_HOST_SI_PREFIX, "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getShare", "()Ljava/util/ArrayList;", "getManagerCollaborator", "getExternalAccess", "getShareExternal", "getSecurity", "getCopy", "getShowCollaboratorInfo", "getComment", "getLinkShare", "getApplyEmbed", "BlockEntity", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BlockOptionsV2 implements NonProguard {
    private final ArrayList<BlockEntity> applyEmbed;
    private final ArrayList<BlockEntity> comment;
    private final ArrayList<BlockEntity> copy;
    private final ArrayList<BlockEntity> externalAccess;
    private final ArrayList<BlockEntity> linkShare;
    private final ArrayList<BlockEntity> managerCollaborator;

    /* JADX INFO: renamed from: security, reason: collision with root package name */
    private final ArrayList<BlockEntity> f234424security;
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

        public static /* synthetic */ BlockEntity copy$default(BlockEntity r100, int r101, int r102, boolean r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.blockType;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.value;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.canEscape;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.isEscaped;
        L15:
            return r100.copy(r101, r102, r103, r104);
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

        public final BlockEntity copy(int r100, int r101, boolean r102, boolean r103) {
            return new BlockEntity(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BlockEntity) == true) goto L8;
            return false;
        L8:
            BlockEntity r101 = (BlockEntity) r100;
            if (this.blockType == r101.blockType) goto L12;
            return false;
        L12:
            if (this.value == r101.value) goto L15;
            return false;
        L15:
            if (this.canEscape == r101.canEscape) goto L18;
            return false;
        L18:
            if (this.isEscaped == r101.isEscaped) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.blockType * 31) + this.value) * 31;
            int r101 = 1231;
            if (this.canEscape == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.isEscaped == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
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

        public BlockEntity(int r100, int r101, boolean r102, boolean r103) {
            this.blockType = r100;
            this.value = r101;
            this.canEscape = r102;
            this.isEscaped = r103;
        }

        public /* synthetic */ BlockEntity(int r100, int r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this(r100, r101, r102, r103);
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
        return this.f234424security;
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

    public BlockOptionsV2(ArrayList<BlockEntity> r100, ArrayList<BlockEntity> r101, ArrayList<BlockEntity> r102, ArrayList<BlockEntity> r103, ArrayList<BlockEntity> r104, ArrayList<BlockEntity> r105, ArrayList<BlockEntity> r106, ArrayList<BlockEntity> r107, ArrayList<BlockEntity> r110, ArrayList<BlockEntity> r111) {
        Intrinsics.checkNotNullParameter(r100, "share");
        Intrinsics.checkNotNullParameter(r101, "managerCollaborator");
        Intrinsics.checkNotNullParameter(r102, "externalAccess");
        Intrinsics.checkNotNullParameter(r103, "shareExternal");
        Intrinsics.checkNotNullParameter(r104, AppConstants.API_HOST_SI_PREFIX);
        Intrinsics.checkNotNullParameter(r105, "copy");
        Intrinsics.checkNotNullParameter(r106, "showCollaboratorInfo");
        Intrinsics.checkNotNullParameter(r107, "comment");
        Intrinsics.checkNotNullParameter(r110, "linkShare");
        Intrinsics.checkNotNullParameter(r111, "applyEmbed");
        this.share = r100;
        this.managerCollaborator = r101;
        this.externalAccess = r102;
        this.shareExternal = r103;
        this.f234424security = r104;
        this.copy = r105;
        this.showCollaboratorInfo = r106;
        this.comment = r107;
        this.linkShare = r110;
        this.applyEmbed = r111;
    }

    public /* synthetic */ BlockOptionsV2(ArrayList r110, ArrayList r111, ArrayList r112, ArrayList r113, ArrayList r114, ArrayList r115, ArrayList r116, ArrayList r117, ArrayList r118, ArrayList r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        ArrayList r100 = new ArrayList();
    L7:
        if ((r211 & 2) == 0) goto L9;
        ArrayList r101 = new ArrayList();
    L11:
        if ((r211 & 4) == 0) goto L13;
        ArrayList r102 = new ArrayList();
    L15:
        if ((r211 & 8) == 0) goto L17;
        ArrayList r103 = new ArrayList();
    L19:
        if ((r211 & 16) == 0) goto L21;
        ArrayList r104 = new ArrayList();
    L23:
        if ((r211 & 32) == 0) goto L25;
        ArrayList r105 = new ArrayList();
    L27:
        if ((r211 & 64) == 0) goto L29;
        ArrayList r106 = new ArrayList();
    L31:
        if ((r211 & 128) == 0) goto L33;
        ArrayList r107 = new ArrayList();
    L35:
        if ((r211 & 256) == 0) goto L37;
        ArrayList r108 = new ArrayList();
    L39:
        if ((r211 & 512) == 0) goto L41;
        ArrayList r109 = new ArrayList();
    L42:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}

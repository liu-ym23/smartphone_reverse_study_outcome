package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/BlockInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceId", "", WikiFolderPushPlugin.BLOCK_ID, "opt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getSpaceId", "()Ljava/lang/String;", "getBlockId", "getOpt", "()I", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockInfo implements NonProguard {
    public static final a Companion = null;
    private static final String TAG = "FileBlockInfo";
    private final String blockId;
    private final int opt;
    private final String spaceId;

    public static final class a {
        public a() {
        }

        public static boolean a(BlockInfo r4) {
            boolean r0 = false;
            if (r4 != null) goto L7;
            tt5.a.d(BlockInfo.TAG, "isValid fail, info=null");
            return false;
        L7:
            if (TextUtils.isEmpty(r4.getBlockId()) == false) goto L9;
        L15:
            tt5.a.h(BlockInfo.TAG, "info=" + r4 + ", result=" + r0);
            return r0;
        L9:
            if (TextUtils.isEmpty(r4.getSpaceId()) == true) goto L15;
            if (r4.getOpt() != 1) goto L13;
        L14:
            r0 = true;
            goto L15
        L13:
            if (r4.getOpt() != 0) goto L15;
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ BlockInfo copy$default(BlockInfo r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.spaceId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.blockId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.opt;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.spaceId;
    }

    public final String component2() {
        return this.blockId;
    }

    public final int component3() {
        return this.opt;
    }

    public final BlockInfo copy(String r2, String r3, int r4) {
        return new BlockInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockInfo) == true) goto L8;
        return false;
    L8:
        BlockInfo r6 = (BlockInfo) r5;
        if (Intrinsics.areEqual(this.spaceId, r6.spaceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r6.blockId) == true) goto L15;
        return false;
    L15:
        if (this.opt == r6.opt) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.spaceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.blockId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.opt;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockInfo(spaceId=" + this.spaceId + ", blockId=" + du5.b.i(this.blockId) + ", opt=" + this.opt + ')';
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final int getOpt() {
        return this.opt;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public BlockInfo(String r1, String r2, int r3) {
        this.spaceId = r1;
        this.blockId = r2;
        this.opt = r3;
    }
}

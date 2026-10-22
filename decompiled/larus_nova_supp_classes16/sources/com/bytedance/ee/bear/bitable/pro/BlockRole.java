package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BlockRole;", "Lcom/bytedance/ee/util/io/NonProguard;", "blockId", "", "blockName", "perm", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBlockId", "()Ljava/lang/String;", "getBlockName", "getPerm", "()I", "getPermDesc", "context", "Landroid/content/Context;", "canRead", "", "getBlockPerm", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockRole implements NonProguard {
    public static final a Companion = null;
    private static final int PERM_EDIT = 2;
    private static final int PERM_FORBIDDEN = 0;
    private static final int PERM_MANAGER = 3;
    private static final int PERM_READ = 1;
    private final String blockId;
    private final String blockName;
    private final int perm;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BlockRole() {
        this(null, null, 0, 7, null);
    }

    public final boolean canRead() {
        if (getBlockPerm() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final String getBlockName() {
        return this.blockName;
    }

    public final int getBlockPerm() {
        return this.perm;
    }

    public final int getPerm() {
        return this.perm;
    }

    public final String getPermDesc(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = getBlockPerm();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L17;
        return r4.getString(2131886110);
    L17:
        return r4.getString(2131886109);
    L18:
        return r4.getString(2131886108);
    L19:
        return r4.getString(2131886111);
    L15:
        return r4.getString(2131886110);
    }

    public BlockRole(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "blockId");
        Intrinsics.checkNotNullParameter(r3, "blockName");
        this.blockId = r2;
        this.blockName = r3;
        this.perm = r4;
    }

    public /* synthetic */ BlockRole(String r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}

package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BlockRole;", "Lcom/bytedance/ee/util/io/NonProguard;", WikiFolderPushPlugin.BLOCK_ID, "", "blockName", "perm", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBlockId", "()Ljava/lang/String;", "getBlockName", "getPerm", "()I", "getPermDesc", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "canRead", "", "getBlockPerm", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final String getPermDesc(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = getBlockPerm();
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return r100.getString(R.string.Bitable_AdvancedPermUpgrade_Docs_NoAccess_Radio);
    L17:
        return r100.getString(R.string.Bitable_AdvancedPermUpgrade_Docs_Manageable_Radio);
    L18:
        return r100.getString(R.string.Bitable_AdvancedPermUpgrade_Docs_Editable_Radio);
    L19:
        return r100.getString(R.string.Bitable_AdvancedPermUpgrade_Docs_ViewOnly_Radio);
    L15:
        return r100.getString(R.string.Bitable_AdvancedPermUpgrade_Docs_NoAccess_Radio);
    }

    public BlockRole(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r101, "blockName");
        this.blockId = r100;
        this.blockName = r101;
        this.perm = r102;
    }

    public /* synthetic */ BlockRole(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}

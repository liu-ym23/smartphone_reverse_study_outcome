package com.bytedance.kmp.ec.yata.common.render;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/render/TreeType;", "", AccountType.MAIN, "POPUP", "COMMON_NODE", "NESTING_TREE", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum TreeType extends Enum<TreeType> {
    public static final TreeType COMMON_NODE = null;
    public static final TreeType MAIN = null;
    public static final TreeType NESTING_TREE = null;
    public static final TreeType POPUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TreeType[] f251561a = null;

    public static TreeType valueOf(String r100) {
        return (TreeType) a.a(TreeType.class, r100);
    }

    public static TreeType[] values() {
        return (TreeType[]) f251561a.clone();
    }

    static {
        TreeType r100 = new TreeType(AccountType.MAIN, 0);
        MAIN = r100;
        TreeType r101 = new TreeType("POPUP", 1);
        POPUP = r101;
        TreeType r102 = new TreeType("COMMON_NODE", 2);
        COMMON_NODE = r102;
        TreeType r103 = new TreeType("NESTING_TREE", 3);
        NESTING_TREE = r103;
        f251561a = new TreeType[]{r100, r101, r102, r103};
    }

    public TreeType(String r100, int r101) {
        super(r100, r101);
    }
}

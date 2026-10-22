package com.bytedance.ee.bear.bitable.pro.applypro;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionHandling;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_ADVANCED_PERMISSION", "SHOW_COMMON_NO_PERMISSION", "SHOW_PASSWORD_PERMISSION", "DELEGATE_COMMON_PRESERVING_PAGE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitablePermissionHandling extends Enum<BitablePermissionHandling> {
    public static final BitablePermissionHandling DELEGATE_COMMON_PRESERVING_PAGE = null;
    public static final BitablePermissionHandling SHOW_ADVANCED_PERMISSION = null;
    public static final BitablePermissionHandling SHOW_COMMON_NO_PERMISSION = null;
    public static final BitablePermissionHandling SHOW_PASSWORD_PERMISSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitablePermissionHandling[] f215149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215150b = null;

    public static EnumEntries<BitablePermissionHandling> getEntries() {
        return f215150b;
    }

    static {
        BitablePermissionHandling r100 = new BitablePermissionHandling("SHOW_ADVANCED_PERMISSION", 0);
        SHOW_ADVANCED_PERMISSION = r100;
        BitablePermissionHandling r101 = new BitablePermissionHandling("SHOW_COMMON_NO_PERMISSION", 1);
        SHOW_COMMON_NO_PERMISSION = r101;
        BitablePermissionHandling r102 = new BitablePermissionHandling("SHOW_PASSWORD_PERMISSION", 2);
        SHOW_PASSWORD_PERMISSION = r102;
        BitablePermissionHandling r103 = new BitablePermissionHandling("DELEGATE_COMMON_PRESERVING_PAGE", 3);
        DELEGATE_COMMON_PRESERVING_PAGE = r103;
        BitablePermissionHandling[] r104 = {r100, r101, r102, r103};
        f215149a = r104;
        f215150b = EnumEntriesKt.enumEntries(r104);
    }

    public static BitablePermissionHandling[] values() {
        return (BitablePermissionHandling[]) f215149a.clone();
    }

    public static BitablePermissionHandling valueOf(String r100) {
        return (BitablePermissionHandling) r27.a.a(BitablePermissionHandling.class, r100);
    }

    public BitablePermissionHandling(String r100, int r101) {
        super(r100, r101);
    }
}

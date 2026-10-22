package com.bytedance.ee.bear.bitable.pro.applypro;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionHandling;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_ADVANCED_PERMISSION", "SHOW_COMMON_NO_PERMISSION", "SHOW_PASSWORD_PERMISSION", "DELEGATE_COMMON_PRESERVING_PAGE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitablePermissionHandling extends Enum<BitablePermissionHandling> {
    public static final BitablePermissionHandling DELEGATE_COMMON_PRESERVING_PAGE = null;
    public static final BitablePermissionHandling SHOW_ADVANCED_PERMISSION = null;
    public static final BitablePermissionHandling SHOW_COMMON_NO_PERMISSION = null;
    public static final BitablePermissionHandling SHOW_PASSWORD_PERMISSION = null;
    public static final /* synthetic */ BitablePermissionHandling[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BitablePermissionHandling> getEntries() {
        return b;
    }

    static {
        BitablePermissionHandling r0 = new BitablePermissionHandling("SHOW_ADVANCED_PERMISSION", 0);
        SHOW_ADVANCED_PERMISSION = r0;
        BitablePermissionHandling r1 = new BitablePermissionHandling("SHOW_COMMON_NO_PERMISSION", 1);
        SHOW_COMMON_NO_PERMISSION = r1;
        BitablePermissionHandling r3 = new BitablePermissionHandling("SHOW_PASSWORD_PERMISSION", 2);
        SHOW_PASSWORD_PERMISSION = r3;
        BitablePermissionHandling r5 = new BitablePermissionHandling("DELEGATE_COMMON_PRESERVING_PAGE", 3);
        DELEGATE_COMMON_PRESERVING_PAGE = r5;
        BitablePermissionHandling[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static BitablePermissionHandling[] values() {
        return (BitablePermissionHandling[]) a.clone();
    }

    public static BitablePermissionHandling valueOf(String r1) {
        return (BitablePermissionHandling) r27.a.a(BitablePermissionHandling.class, r1);
    }

    public BitablePermissionHandling(String r1, int r2) {
        super(r1, r2);
    }
}

package com.bytedance.ee.bear.bitable.pro;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermissionUpdateStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ReadyToUpdate", "Updated", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionUpdateStatus extends Enum<PermissionUpdateStatus> {
    public static final a Companion = null;
    public static final PermissionUpdateStatus ReadyToUpdate = null;
    public static final PermissionUpdateStatus Updated = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionUpdateStatus[] f215105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215106b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<PermissionUpdateStatus> getEntries() {
        return f215106b;
    }

    static {
        PermissionUpdateStatus r100 = new PermissionUpdateStatus("ReadyToUpdate", 0, "ReadyToUpdate");
        ReadyToUpdate = r100;
        PermissionUpdateStatus r101 = new PermissionUpdateStatus("Updated", 1, "Updated");
        Updated = r101;
        PermissionUpdateStatus[] r102 = {r100, r101};
        f215105a = r102;
        f215106b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static PermissionUpdateStatus[] values() {
        return (PermissionUpdateStatus[]) f215105a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PermissionUpdateStatus valueOf(String r100) {
        return (PermissionUpdateStatus) r27.a.a(PermissionUpdateStatus.class, r100);
    }

    public PermissionUpdateStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

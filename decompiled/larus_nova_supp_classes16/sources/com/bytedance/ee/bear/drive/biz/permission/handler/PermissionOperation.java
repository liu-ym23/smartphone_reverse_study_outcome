package com.bytedance.ee.bear.drive.biz.permission.handler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/handler/PermissionOperation;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "EXPORT", "UPLOAD", "COPY", "CREATE_COPY", "UNKNOWN", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionOperation extends Enum<PermissionOperation> {
    public static final PermissionOperation COPY = null;
    public static final PermissionOperation CREATE_COPY = null;
    public static final PermissionOperation DOWNLOAD = null;
    public static final PermissionOperation EXPORT = null;
    public static final PermissionOperation UNKNOWN = null;
    public static final PermissionOperation UPLOAD = null;
    public static final /* synthetic */ PermissionOperation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PermissionOperation> getEntries() {
        return b;
    }

    static {
        PermissionOperation r0 = new PermissionOperation("DOWNLOAD", 0);
        DOWNLOAD = r0;
        PermissionOperation r1 = new PermissionOperation("EXPORT", 1);
        EXPORT = r1;
        PermissionOperation r3 = new PermissionOperation("UPLOAD", 2);
        UPLOAD = r3;
        PermissionOperation r5 = new PermissionOperation("COPY", 3);
        COPY = r5;
        PermissionOperation r7 = new PermissionOperation("CREATE_COPY", 4);
        CREATE_COPY = r7;
        PermissionOperation r9 = new PermissionOperation("UNKNOWN", 5);
        UNKNOWN = r9;
        PermissionOperation[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static PermissionOperation[] values() {
        return (PermissionOperation[]) a.clone();
    }

    public static PermissionOperation valueOf(String r1) {
        return (PermissionOperation) a.a(PermissionOperation.class, r1);
    }

    public PermissionOperation(String r1, int r2) {
        super(r1, r2);
    }
}

package com.bytedance.ee.bear.drive.biz.permission.handler;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/handler/PermissionOperation;", "", "<init>", "(Ljava/lang/String;I)V", HttpMethod.DOWNLOAD, "EXPORT", "UPLOAD", "COPY", "CREATE_COPY", "UNKNOWN", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionOperation extends Enum<PermissionOperation> {
    public static final PermissionOperation COPY = null;
    public static final PermissionOperation CREATE_COPY = null;
    public static final PermissionOperation DOWNLOAD = null;
    public static final PermissionOperation EXPORT = null;
    public static final PermissionOperation UNKNOWN = null;
    public static final PermissionOperation UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionOperation[] f223166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f223167b = null;

    public static EnumEntries<PermissionOperation> getEntries() {
        return f223167b;
    }

    static {
        PermissionOperation r100 = new PermissionOperation(HttpMethod.DOWNLOAD, 0);
        DOWNLOAD = r100;
        PermissionOperation r101 = new PermissionOperation("EXPORT", 1);
        EXPORT = r101;
        PermissionOperation r102 = new PermissionOperation("UPLOAD", 2);
        UPLOAD = r102;
        PermissionOperation r103 = new PermissionOperation("COPY", 3);
        COPY = r103;
        PermissionOperation r104 = new PermissionOperation("CREATE_COPY", 4);
        CREATE_COPY = r104;
        PermissionOperation r105 = new PermissionOperation("UNKNOWN", 5);
        UNKNOWN = r105;
        PermissionOperation[] r110 = {r100, r101, r102, r103, r104, r105};
        f223166a = r110;
        f223167b = EnumEntriesKt.enumEntries(r110);
    }

    public static PermissionOperation[] values() {
        return (PermissionOperation[]) f223166a.clone();
    }

    public static PermissionOperation valueOf(String r100) {
        return (PermissionOperation) a.a(PermissionOperation.class, r100);
    }

    public PermissionOperation(String r100, int r101) {
        super(r100, r101);
    }
}

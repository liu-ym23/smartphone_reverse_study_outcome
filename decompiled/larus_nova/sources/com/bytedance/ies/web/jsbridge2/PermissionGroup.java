package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;

/* JADX INFO: loaded from: classes19.dex */
public final enum PermissionGroup extends Enum<PermissionGroup> {
    public static final PermissionGroup PRIVATE = null;
    public static final PermissionGroup PROTECTED = null;
    public static final PermissionGroup PUBLIC = null;
    public static final PermissionGroup SECURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionGroup[] f249285a = null;

    static {
        PermissionGroup r100 = new PermissionGroup("PUBLIC", 0);
        PUBLIC = r100;
        PermissionGroup r101 = new PermissionGroup("PROTECTED", 1);
        PROTECTED = r101;
        PermissionGroup r102 = new PermissionGroup("PRIVATE", 2);
        PRIVATE = r102;
        PermissionGroup r103 = new PermissionGroup("SECURE", 3);
        SECURE = r103;
        f249285a = new PermissionGroup[]{r100, r101, r102, r103};
    }

    public static PermissionGroup[] values() {
        return (PermissionGroup[]) f249285a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != PRIVATE) goto L7;
        return BridgePrivilege.PRIVATE;
    L7:
        if (this != PROTECTED) goto L11;
        return "protected";
    L11:
        if (this != SECURE) goto L14;
        return "secure";
    L14:
        return "public";
    }

    public static PermissionGroup from(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = r100.toLowerCase();
        if (TextUtils.equals("protected", r101) == false) goto L11;
        return PROTECTED;
    L11:
        if (TextUtils.equals(BridgePrivilege.PRIVATE, r101) == false) goto L15;
        return PRIVATE;
    L15:
        if (TextUtils.equals("secure", r101) == false) goto L19;
        return SECURE;
    L19:
        return PUBLIC;
    L5:
        return PUBLIC;
    }

    public static PermissionGroup valueOf(String r100) {
        return (PermissionGroup) r27.a.a(PermissionGroup.class, r100);
    }

    public PermissionGroup(String r100, int r101) {
        super(r100, r101);
    }
}

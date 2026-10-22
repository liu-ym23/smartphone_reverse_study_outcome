package com.bytedance.timon.permission.storage.constant;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timon/permission/storage/constant/MediaPermissionResult;", "", "FULL", "USER_SELECT", UserProfileEvent.POSITION_NONE, "permission-keeper-storage_release"}, k = 1, mv = {1, 7, 1})
public final enum MediaPermissionResult extends Enum<MediaPermissionResult> {
    public static final MediaPermissionResult FULL = null;
    public static final MediaPermissionResult NONE = null;
    public static final MediaPermissionResult USER_SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaPermissionResult[] f270651a = null;

    public static MediaPermissionResult valueOf(String r100) {
        return (MediaPermissionResult) a.a(MediaPermissionResult.class, r100);
    }

    public static MediaPermissionResult[] values() {
        return (MediaPermissionResult[]) f270651a.clone();
    }

    static {
        MediaPermissionResult r100 = new MediaPermissionResult("FULL", 0);
        FULL = r100;
        MediaPermissionResult r101 = new MediaPermissionResult("USER_SELECT", 1);
        USER_SELECT = r101;
        MediaPermissionResult r102 = new MediaPermissionResult(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        f270651a = new MediaPermissionResult[]{r100, r101, r102};
    }

    public MediaPermissionResult(String r100, int r101) {
        super(r100, r101);
    }
}

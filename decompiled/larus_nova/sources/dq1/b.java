package dq1;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static final boolean a(IRoom r100) {
        if (LiveSettingKeys.LIVE_MULTI_CAMERA_SERVICES.getValue().booleanValue() == true) goto L10;
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.isMergeVSRoom() != true) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    public static final boolean b(boolean r100) {
        if (LiveSettingKeys.LIVE_MULTI_CAMERA_SERVICES.getValue().booleanValue() == true) goto L7;
        if (r100 == false) goto L7;
        return false;
    L7:
        return true;
    }
}

package st0;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final String a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$paramName");
        switch(r100.getType()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L5;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        return "go_to_ta_live";
    L6:
        return "group_manage";
    L7:
        return "create_group";
    L8:
        return "personal_center";
    L9:
        return "profile_setting";
    L10:
        return "block";
    L11:
        return "flash_sale";
    L12:
        return "secondary_follow";
    L13:
        return "to_other_anchor";
    L14:
        return ITTVideoEngineEventSource.KEY_MUTE;
    L15:
        return "manage";
    L16:
        return "report";
    L17:
        return INotificationHitPoint.NoticeType.AT;
    L18:
        return "fans_group";
    L19:
        return "follow";
    }
}

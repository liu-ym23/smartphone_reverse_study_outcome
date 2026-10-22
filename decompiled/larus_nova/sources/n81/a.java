package n81;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.r4;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518242a = 0;

    static {
    }

    public static boolean a(DataCenter r100) {
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        if (r102 == false) goto L10;
        return false;
    L10:
        if (r4.f65400a.getValue().booleanValue() == false) goto L23;
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r100, 0, 2);
        if (r103 == null) goto L18;
        m<Boolean> r104 = r103.getRoomTabAppointmentShowed();
        if (r104 == null) goto L18;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        if (r106 == true) goto L24;
        return true;
    L24:
        return false;
    L18:
        r106 = false;
        goto L19
    L23:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("AudienceRoomLabelUtils", r100);
    }
}

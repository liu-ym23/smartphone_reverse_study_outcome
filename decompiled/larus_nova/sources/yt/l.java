package yt;

import com.bytedance.android.gamecp.host_api.model.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569018a = 0;

    public static boolean a() {
        String r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().getCurrentUserId().toString();
        Room r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r101 == null) goto L6;
        String r102 = r101.getOwnerUserId();
        if (r102 == null) goto L6;
    L8:
        return Intrinsics.areEqual(r102, r100);
    L6:
        r102 = "";
        goto L8
    }

    static {
    }
}

package kn1;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.logsdk.format.Spm;
import is2.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504156a;

    @Override // is2.g
    public final String businessTypeV2() {
        return "RoomTaskALogger";
    }

    @Override // tw2.a
    public final Map<String, Object> getEnvData() {
        return null;
    }

    @Override // tw2.b
    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    @Override // tw2.b
    public final String getSpm() {
        return null;
    }

    @Override // tw2.b
    public final boolean isIgnored() {
        return false;
    }

    @Override // is2.g
    public final void onOrientationChangeV2(int r100) {
    }

    @Override // is2.g
    public final void onRoomBackgroundV2() {
    }

    @Override // is2.g
    public final void onRoomPrepareV2(boolean r100) {
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f504156a = r100;
    }

    @Override // is2.g
    public final void onRoomEnterV2(Room r100, ls2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "enterExtra");
        if (e.f504154a.booleanValue() == true) goto L5;
        return;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("room_id", Long.valueOf(r100.f162599id));
        long r103 = r100.f162599id;
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b8000").businessId(this.f504156a).args(r102).addArg("state", "enter").addArg("room_id", Long.valueOf(r103)), "room_enter");
    }

    @Override // is2.g
    public final void onRoomPreloadV2(Room r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r100, "room");
    }

    @Override // is2.g
    public final void onRoomExitV2(long r100, String r101, boolean r102, Room r103, ls2.e r104, boolean r105, EndReason r106) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r104, "error");
        Intrinsics.checkNotNullParameter(r106, "reason");
        if (e.f504154a.booleanValue() == true) goto L6;
        if (r105 == true) goto L6;
        return;
    L6:
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("room_id", Long.valueOf(r100));
        r107.put("notification", Boolean.valueOf(r102));
        r107.put("error_msg", r104.getErrMsgV2());
        int r108 = r104.getRoomErrorCodeV2();
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b8000").businessId(this.f504156a).result(r108).args(r107).addArg("state", "exit").addArg("room_id", Long.valueOf(r100)), "room_enter");
    }
}

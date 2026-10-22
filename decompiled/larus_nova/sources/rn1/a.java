package rn1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.roomset.IRoomSetManager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tw2.b;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements IRoomSetManager, b {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final Room getCurrentRoom() {
        return null;
    }

    @Override // tw2.a
    public final Map<String, Object> getEnvData() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final String getLogTag() {
        return "";
    }

    @Override // tw2.b
    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    @Override // tw2.b
    public final String getSpm() {
        return "a100.b9000.a4000";
    }

    @Override // tw2.b
    public final boolean isIgnored() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void logCoreFlow(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void logExtraFlow(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onChangeRoom(Room r100, Room r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onInit(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "tag");
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onInnerRoomsChange(ILiveRoomListProvider r100, List<Room> r101) {
        Intrinsics.checkNotNullParameter(r100, "mListProvider");
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onStartFirstRoom(Room r100, int r101) {
    }

    @Override // com.bytedance.android.livesdkapi.roomset.IRoomSetManager
    public final void onStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }
}

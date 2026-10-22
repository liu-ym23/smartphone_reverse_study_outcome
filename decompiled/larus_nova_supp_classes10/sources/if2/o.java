package if2;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o extends ILiveRoomListProvider {
    public final Bundle a;
    public List<Room> b;

    public final void alterSpecificItem(int r1, FeedItem r2) {
    }

    public final int indexOf(Bundle r1) {
        return 0;
    }

    public final void loadMore(int r1) {
    }

    public final String providerType() {
        return "SingleRoomListProvider";
    }

    public final void removeRoom(long r1) {
    }

    public final int size() {
        return 1;
    }

    public final List<Room> getPreloadRooms() {
        return this.b;
    }

    public final List<Room> getRoomList() {
        return Collections.EMPTY_LIST;
    }

    public o(Bundle r2) {
        this.b = new ArrayList();
        this.a = r2;
    }

    public final void addPreloadRooms(List<Room> r3) {
        if (Lists.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        this.b = new ArrayList();
    L8:
        this.b.clear();
        this.b.add((Room) ListProtector.get(r3, 0));
    }

    public final Bundle getRoomArgs(int r1) {
        return this.a;
    }
}

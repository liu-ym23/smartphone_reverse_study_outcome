package ui1;

import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static void a(ik1.b r100) {
        r100.f490188e.setAdapter(null);     // Catch: Exception -> L5
    L7:
        LiveDetailPagerAdapter r101 = r100.f490191h;
        if (r101 == null) goto L10;
        r101.f105094e.removeListener(r101.f105095f);
        r100.f490191h = null;
    L10:
        ILiveRoomListProvider r102 = r100.f490186c;
        if (r102 == null) goto L14;
        r102.release();
        r100.f490186c = null;
    L14:
        if (r100.f490192i == null) goto L19;
        r100.f490192i = null;
        return;
    L19:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}

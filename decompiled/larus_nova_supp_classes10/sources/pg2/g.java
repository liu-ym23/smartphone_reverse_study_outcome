package pg2;

import com.bytedance.android.livesdk.live.listprovider.DouyinXTabListProvider;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class g implements Consumer {
    public final /* synthetic */ i a;

    public /* synthetic */ g(i r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        i r0 = this.a;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.c r9 = (com.bytedance.android.livesdk.chatroom.followrecommendguide.c) r8;
        if (r9 != null) goto L5;
        r0.getClass();
        return;
    L5:
        if (r0.a == null) goto L41;
        int r1 = r9.a;
        if (r1 >= 0) goto L10;
        return;
    L10:
        if (r1 >= r0.f.getCount()) goto L42;
        r0.d();
        boolean r3 = false;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.h() != 3) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L22;
        i.g("onRecommendSwipeEvent is called event.isSlideUp = " + r9.b + ", position = " + r9.a);
        StringBuilder r4 = new StringBuilder("removeFollowData is called mOnTouchPosition = ");
        r4.append(r0.l);
        i.g(r4.toString());
        List r5 = r0.b.getRoomList();
        int r6 = r0.l;
    L18:
        if (r6 < 0) goto L20;
        r0.b.removeRoom(((Room) ListProtector.get(r5, r6)).getId());
        r6 = r6 - 1;
        goto L18
    L20:
        r0.l = -1;
        r0.l(r9.b, 0);
        r0.a.setCurrentItemWithDefaultVelocity(0);
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.h(r9.b);
    L35:
        r0.i(null);
        return;
    L22:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.h() != 4) goto L24;
        r3 = true;
    L24:
        if (r3 == false) goto L35;
        int r7 = r9.a;
        int r10 = r0.a.getCurrentItem();
        i.g("onRecommendSwipeEvent is called is bottom and up event.isSlideUp = " + r9.b + " , position = " + r7 + ", currentItem = " + r10);
        if (r7 < 0) goto L35;
        if (r7 >= r0.f.getCount()) goto L35;
        if (Math.abs(r10 - r7) != 1) goto L35;
        if ((r0.b instanceof DouyinXTabListProvider) == true) goto L34;
        r0.l(r9.b, r7);
    L34:
        r0.a.setCurrentItemWithDefaultVelocity(r7);
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.h(r9.b);
        goto L35
    L15:
        r2 = false;
        goto L16
    L42:
        return;
    }
}

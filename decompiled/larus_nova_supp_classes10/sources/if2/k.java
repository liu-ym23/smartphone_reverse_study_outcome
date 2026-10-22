package if2;

import com.bytedance.android.livesdk.list.RandomAccessRoomListProvider;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ RandomAccessRoomListProvider a;
    public final /* synthetic */ long b;

    public /* synthetic */ k(RandomAccessRoomListProvider r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r9) {
        RandomAccessRoomListProvider r0 = this.a;
        long r1 = this.b;
        Integer r10 = (Integer) r9;
        if (r0.K == null) goto L17;
        int r11 = r10.intValue();
        int r3 = r0.M;
        if (r11 > r3) goto L8;
        if (r3 <= 0) goto L8;
        r0.s("doRemoveRoom: index degrade " + r0.M);
        r0.M = r0.M + (-1);
    L8:
        int r12 = 0;
    L10:
        if (r12 >= r0.K.size()) goto L17;
        long r4 = ((Room) ListProtector.get(r0.K, r12)).getRoomId();
        if (r4 < 0) goto L16;
        if (r4 != r1) goto L16;
        ListProtector.remove(r0.K, r12);
    L16:
        r12 = r12 + 1;
    L17:
        r0.dispatchChange();
        return null;
    }
}

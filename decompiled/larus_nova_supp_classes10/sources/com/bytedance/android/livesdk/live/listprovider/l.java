package com.bytedance.android.livesdk.live.listprovider;

import android.util.Pair;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r7) {
        Pair r8 = (Pair) r7;
        if (r8 == null) goto L5;
        List r1 = (List) r8.first;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (((List) r8.first).isEmpty() == true) goto L46;
        Object r2 = r8.second;
        if (r2 == null) goto L48;
        JsonObject r3 = ((FeedExtra) r2).getLogPb();
        if (r3 == null) goto L47;
        Iterator<T> r9 = ((Iterable) r8.first).iterator();
    L16:
        if (r9.hasNext() == false) goto L49;
        FeedItem r4 = (FeedItem) r9.next();
        r4.logPb = r3.toString();
        r4.setPullType(2);
        ConcurrentHashMap<String, Object> r5 = m.a;
        int r6 = r4.type;
        if (r6 == 1) goto L21;
        if (r6 != 2) goto L16;
    L21:
        if ((r4.getItem() instanceof Room) == false) goto L16;
        Item r10 = r4.getItem();
        if ((r10 instanceof Room) == true) goto L25;
        r10 = null;
    L25:
        Room r11 = (Room) r10;
        if (r11 == null) goto L16;
        r11.setLog_pb(r4.logPb);
        User r12 = r11.getOwner();
        if (r12 == null) goto L34;
        String r13 = r4.logPb;
        if (r13 != null) goto L33;
        r13 = "";
    L33:
        r12.setLogPb(r13);
    L34:
        r11.setRequestId(r4.resId);
        r11.set_isFromRecommendCard(r4.isRecommendCard);
        r11.set_liveReason(r4.liveReason);
        r11.set_pullType(r4.getPullType());
        goto L16
    L49:
        return;
    L47:
        return;
    L48:
        return;
    L46:
        return;
    L5:
        r1 = null;
        goto L6
    }
}

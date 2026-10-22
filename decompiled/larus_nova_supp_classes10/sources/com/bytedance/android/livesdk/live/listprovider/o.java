package com.bytedance.android.livesdk.live.listprovider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FeedDraw;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.IPullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o extends ILiveRoomListProvider implements IPullable<Integer> {
    public kf2.g a;
    public final ArrayList<Room> b;
    public final ArrayList<Bundle> c;
    public final ArrayList<FeedItem> d;
    public FeedExtra e;
    public long f;
    public String g;
    public final String h;
    public final String i;
    public boolean j;
    public final CompositeDisposable k;
    public int l;
    public boolean m;
    public final String n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            if (r6 != null) goto L5;
            this.a.j = false;
            return;
        L5:
            o r1 = this.a;
            r1.e = (FeedExtra) r6.second;
            Object r2 = r6.first;
            if (r2 != null) goto L8;
        L14:
            this.a.j = false;
            return;
        L8:
            if (((List) r2).isEmpty() == true) goto L14;
            o r3 = this.a;
            if (r3.m == true) goto L13;
            r3.m = true;
            r3.b.clear();
            r3.c.clear();
            r3.d.clear();
        L13:
            o r4 = this.a;
            List r7 = (List) r6.first;
            FeedExtra r8 = (FeedExtra) r6.second;
            o.n(r4, r7, true);
            this.a.dispatchChange();
            this.a.j = false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.j = false;
            ((Throwable) r3).printStackTrace();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ IPullable.IPullCallback b;

        public d(o r1, IPullable.IPullCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Pair r8 = (Pair) r7;
            if (r8 != null) goto L7;
            IPullable.IPullCallback r9 = this.b;
            if (r9 == null) goto L30;
            r9.onSuccess(0);
            return;
        L30:
            return;
        L7:
            Object r2 = r8.first;
            if (r2 != null) goto L10;
        L26:
            IPullable.IPullCallback r10 = this.b;
            if (r10 == null) goto L34;
            r10.onSuccess(0);
            return;
        L34:
            return;
        L10:
            if (((List) r2).isEmpty() == true) goto L26;
            o r1 = this.a;
            r1.e = (FeedExtra) r8.second;
            r1.c.clear();
            this.a.b.clear();
            o r3 = this.a;
            List r4 = (List) r8.first;
            FeedExtra r11 = (FeedExtra) r8.second;
            o.n(r3, r4, false);
            if (this.a.b.size() <= 0) goto L23;
            Room r12 = (Room) ListProtector.get(this.a.b, 0);
            User r0 = r12.getOwner();
            if (r12.id <= 0) goto L23;
            if (r0 == null) goto L23;
            if (TextUtils.isEmpty(r0.getUserId()) == true) goto L23;
            o r5 = this.a;
            r5.f = r12.id;
            String r13 = r0.getUserId();
            if (r13 != null) goto L22;
            r13 = "";
        L22:
            r5.g = r13;
        L23:
            this.a.dispatchChange();
            IPullable.IPullCallback r14 = this.b;
            if (r14 == null) goto L32;
            r14.onSuccess(Integer.valueOf(this.a.size()));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ IPullable.IPullCallback a;

        public e(IPullable.IPullCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            IPullable.IPullCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r3);
            return;
        }
    }

    static {
    }

    public final void alterSpecificItem(int r1, FeedItem r2) {
    }

    public final void p() {
        this.m = false;
        this.b.add(new Room());
        this.c.add(new Bundle());
        this.d.add(new FeedItem());
    }

    public final void release() {
        this.c.clear();
        this.b.clear();
        this.k.clear();
        this.j = false;
    }

    public final int size() {
        return this.c.size();
    }

    public final List<Room> getRoomList() {
        return this.b;
    }

    public final FeedItem getFeedItem(int r3) {
        int r0 = this.d.size();
        if (1 > r3) goto L7;
        if (r0 <= r3) goto L7;
        return (FeedItem) ListProtector.get(this.d, r3);
    L7:
        return null;
    }

    public final Bundle getRoomArgs(int r2) {
        return (Bundle) ListProtector.get(this.c, r2);
    }

    public final int indexOf(Bundle r10) {
        long r1 = -1;
        if (r10 == null) goto L5;
        r1 = r10.getLong("live.intent.extra.ROOM_ID", -1);
    L5:
        int r11 = this.c.size();
        int r4 = 0;
    L6:
        if (r4 >= r11) goto L18;
        Object r5 = ListProtector.get(this.c, r4);
        if (((Bundle) r5).getLong("live.intent.extra.ROOM_ID", 0) != r1) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L15;
        r5 = null;
    L15:
        if (((Bundle) r5) != null) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        return r4;
    L10:
        r6 = false;
        goto L11
    L18:
        return -1;
    }

    public final void loadMore(int r22) {
        FeedExtra r1 = this.e;
        if (r1 == null) goto L8;
        if (((Extra) r1).hasMore == true) goto L8;
        return;
    L8:
        if (this.a != null) goto L11;
        this.a = new kf2.g();
    L11:
        if (this.j == false) goto L13;
        return;
    L13:
        HashMap r10 = new HashMap();
        r10.put("ad_offset", Integer.valueOf(this.l));
        kf2.g r2 = this.a;
        if (r2 == null) goto L28;
        FeedExtra r3 = this.e;
        if (r3 == null) goto L18;
        long r19 = r3.maxTime;
    L19:
        StringBuilder r4 = new StringBuilder();
        r4.append(this.i);
        FeedExtra r5 = this.e;
        if (r5 == null) goto L22;
        long r6 = r5.maxTime;
    L24:
        if (r6 != 0) goto L26;
        String r7 = "_refresh";
    L27:
        r4.append(r7);
        Observable r8 = kf2.g.f(r2, r19, r4.toString(), this.f, this.g, this.h, r10, 0, null, 0, -1, this.n, 29056);
    L29:
        if (r8 == null) goto L32;
        this.j = true;
        this.k.add(r8.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this)));
        return;
    L32:
        return;
    L26:
        r7 = "_loadmore";
        goto L27
    L22:
        r6 = 0;
        goto L24
    L18:
        r19 = 0;
        goto L19
    L28:
        r8 = null;
        goto L29
    }

    public final void o(FeedItem r5) {
        int r0 = r5.type;
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L7;
        return;
    L7:
        if ((r5.getItem() instanceof Room) == false) goto L30;
        Room r1 = r5.getItem();
        if (r1 == null) goto L28;
        Room r2 = r1;
        String r3 = r5.logPb;
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r2.setLog_pb(r3);
        User r6 = r2.getOwner();
        if (r6 == null) goto L19;
        String r7 = r5.logPb;
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r6.setLogPb(r7);
    L19:
        String r8 = r5.resId;
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        r2.setRequestId(r8);
        r2.setIsFromRecommendCard(r5.isRecommendCard);
        String r9 = r5.liveReason;
        if (r9 == null) goto L26;
        r4 = r9;
    L26:
        r2.setLiveReason(r4);
        r2.adRawString = r5.adRawString;
        nn2.a r10 = nn2.a.d;
        nn2.a.a.a().c(r2.id, r5.type);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    }

    public final void pullToRefresh(IPullable.IPullCallback<Integer> r21) {
        if (this.a != null) goto L5;
        this.a = new kf2.g();
    L5:
        this.l = 100;
        HashMap r11 = new HashMap();
        r11.put("ad_offset", Integer.valueOf(this.l));
        kf2.g r3 = this.a;
        if (r3 == null) goto L8;
        Observable r2 = kf2.g.f(r3, 0, this.i + "_pull_refresh", this.f, this.g, this.h, r11, 0, null, 0, -1, this.n, 29056);
    L9:
        if (r2 == null) goto L12;
        this.k.add(r2.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r21), new e(r21)));
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void removeRoom(long r6) {
        if (CollectionUtils.isEmpty(this.b) == false) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(this.c) == false) goto L7;
        return;
    L7:
        if (CollectionUtils.isEmpty(this.d) == false) goto L10;
        return;
    L10:
        if (this.j == false) goto L12;
    L18:
        int r0 = this.b.size();
        int r1 = 0;
    L19:
        if (r1 >= r0) goto L39;
        if (((Room) ListProtector.get(this.b, r1)).id == r6) goto L23;
        r1 = r1 + 1;
        goto L19
    L23:
        if (this.c.size() <= r1) goto L26;
        ListProtector.remove(this.c, r1);
    L26:
        if (this.b.size() <= r1) goto L29;
        ListProtector.remove(this.b, r1);
    L29:
        if (this.d.size() <= r1) goto L31;
        ListProtector.remove(this.d, r1);
    L31:
        dispatchChange();
        return;
    L39:
        return;
    L12:
        if (this.b.size() != 1) goto L18;
        FeedExtra r2 = this.e;
        if (r2 == null) goto L18;
        if (((Extra) r2).hasMore == true) goto L18;
    }

    public final void pullToRefresh(IPullable.IPullCallback<Integer> r1, IPullable.IPullCheck r2) {
        pullToRefresh(r1);
    }

    public static final void n(o r11, List r12, boolean r13) {
        r11.getClass();
        if (r12.isEmpty() == true) goto L40;
        int r0 = r12.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L47;
        FeedItem r2 = (FeedItem) ListProtector.get(r12, r1);
        if (r2.getItem() != null) goto L13;
        r2.setItem(r2.getRoom());     // Catch: Exception -> L11
        r11.o(r2);     // Catch: Exception -> L11
    L13:
        if (r2.type != 3) goto L15;
        r11.l = (r12.size() - r1) - 1;
    L15:
        Item r3 = r2.getItem();
        String r6 = null;
        if ((r3 instanceof Room) == true) goto L18;
        r3 = null;
    L18:
        Room r4 = (Room) r3;
        if (r4 == null) goto L39;
        if (r13 == false) goto L26;
        long r7 = r11.f;
        User r5 = r4.getOwner();
        if (r5 == null) goto L26;
        if (r7 != r5.getLiveRoomId()) goto L26;
        Logger.d("PreviewRoomListProvider", "Remove duplicate room " + r11.f);
    L26:
        r4.adRawString = r2.adRawString;
        r4.setIsFromRecommendCard(r2.isRecommendCard);
        String r8 = r2.liveReason;
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        r4.setLiveReason(r8);
        r11.b.add(r4);
        Bundle r9 = ArgumentsBuilder.buildRoomArgs(r4);
        if (r9 == null) goto L38;
        Room r10 = r2.getRoom();
        if (r10 == null) goto L35;
        r6 = r10.getOwnerUserIdString();
    L35:
        r9.putString("enter_from_user_id", r6);
        if (r2.isPseudoLiving == false) goto L38;
        r9.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
    L38:
        r11.c.add(r9);
        r11.d.add(r2);
    L39:
        r1 = r1 + 1;
        goto L6
    L47:
        return;
    }

    public o(Bundle r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "roomArgs");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "requestFrom");
        Intrinsics.checkNotNullParameter(r6, "enterSource");
        this.n = r6;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = -1;
        this.g = "";
        this.h = "";
        this.i = "";
        this.k = new CompositeDisposable();
        this.l = 100;
        boolean r0 = true;
        this.m = true;
        this.h = r4;
        if (r5.length() == 0) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        Bundle r7 = r3.getBundle("live.intent.extra.ENTER_LIVE_EXTRA");
        if (r7 == null) goto L12;
        this.i = FeedDraw.conventRequestFrom(r7.getString("enter_from_merge", ""), r7.getString("enter_method", ""), r7);
        return;
    L12:
        return;
    L10:
        this.i = r5;
    }
}

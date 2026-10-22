package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.livereplay.model.ECScrollProductCardData;
import com.bytedance.android.livesdk.livecommerce.livereplay.model.ECScrollProductCardResponse;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import el2.l;
import hh2.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import si2.g;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/ECScrollProductCardDataSource;", "Landroidx/paging/PositionalDataSource;", "Lni2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardDataSource extends PositionalDataSource<ni2.a> {
    public final l a;
    public final oi2.b b;
    public final com.bytedance.android.livesdk.livecommerce.livereplay.repository.b c;
    public final nl2.c d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECScrollProductCardDataSource a;
        public final /* synthetic */ PositionalDataSource.LoadInitialCallback b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PositionalDataSource.LoadInitialParams d;

        public a(ECScrollProductCardDataSource r1, PositionalDataSource.LoadInitialCallback r2, int r3, PositionalDataSource.LoadInitialParams r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            ECScrollProductCardResponse r10 = (ECScrollProductCardResponse) r9;
            List<Long> r0 = r10.getPageTimestamp();
            boolean r1 = false;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L10:
            if (r2 == true) goto L28;
            this.a.c.setPageTimestamp(r10.getPageTimestamp());
            if (r10.getCount() <= 0) goto L27;
            this.a.c.setTotalCount(r10.getCount());
            List<ECScrollProductCardData> r3 = r10.getReplayCards();
            if (r3 != null) goto L16;
        L17:
            r1 = true;
        L18:
            if (r1 == true) goto L26;
            this.a.c.setNetworkState(NetState.SUCCESS);
            PositionalDataSource.LoadInitialCallback r4 = this.b;
            ECScrollProductCardDataSource r5 = this.a;
            List<ECScrollProductCardData> r6 = r10.getReplayCards();
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L21:
            if (r8.hasNext() == false) goto L23;
            r7.add(com.bytedance.android.livesdk.livecommerce.livereplay.utils.b.a((ECScrollProductCardData) r8.next(), this.a.b.e, r10.getServerTime()));
            goto L21
        L23:
            r4.onResult(ECScrollProductCardDataSource.e(r5, r7, this.c, this.d.pageSize, r10.getCount()), this.d.requestedStartPosition, r10.getCount());
            com.bytedance.android.ec.monitor.duration.d r11 = i.a.get(mi2.a.a);
            if (r11 == null) goto L31;
            r11.a("request_end");
            return;
        L31:
            return;
        L26:
            this.a.c.setNetworkState(NetState.REPLAY_CARDS_EMPTY);
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitial response.replayCards is null or empty", null);
            return;
        L16:
            if (r3.isEmpty() == false) goto L18;
        L27:
            this.a.c.setNetworkState(NetState.COUNT_EMPTY);
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitial response.count: " + r10.getCount() + " is not expect", null);
            return;
        L28:
            this.a.c.setNetworkState(NetState.PAGE_TIMESTAMP_EMPTY);
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitial page_timestamp is null or empty", null);
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r2 = false;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECScrollProductCardDataSource a;

        public b(ECScrollProductCardDataSource r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c.setNetworkState(NetState.ERROR);
            ECExceptionMonitor.e((Throwable) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ECScrollProductCardDataSource a;
        public final /* synthetic */ PositionalDataSource.LoadRangeCallback b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PositionalDataSource.LoadRangeParams d;

        public c(ECScrollProductCardDataSource r1, PositionalDataSource.LoadRangeCallback r2, int r3, PositionalDataSource.LoadRangeParams r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            ECScrollProductCardResponse r10 = (ECScrollProductCardResponse) r9;
            List<ECScrollProductCardData> r0 = r10.getReplayCards();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L15;
            PositionalDataSource.LoadRangeCallback r2 = this.b;
            ECScrollProductCardDataSource r3 = this.a;
            List<ECScrollProductCardData> r4 = r10.getReplayCards();
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L12:
            if (r6.hasNext() == false) goto L14;
            r5.add(com.bytedance.android.livesdk.livecommerce.livereplay.utils.b.a((ECScrollProductCardData) r6.next(), this.a.b.e, r10.getServerTime()));
            goto L12
        L14:
            r2.onResult(ECScrollProductCardDataSource.e(r3, r5, this.c, this.d.loadSize, ((Number) this.a.b.d.invoke()).intValue()));
            return;
        L15:
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadRange response.replayCards is null or empty", null);
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public final void loadInitial(PositionalDataSource.LoadInitialParams r7, PositionalDataSource.LoadInitialCallback<ni2.a> r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().a("loadInitial");
        FilterNullArrayList<k> r0 = new FilterNullArrayList();
        r0.add(new k("room_id", this.b.a.roomId()));
        r0.add(new k("entrance_info", this.b.b.toString()));
        if (f.g() == false) goto L5;
        String r1 = "author_open_id";
    L6:
        r0.add(new k(r1, this.b.a.c()));
        int r2 = r7.pageSize;
        if (r2 > 0) goto L10;
        this.c.setNetworkState(NetState.PAGE_SIZE_ERROR);
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitial params.pageSize: " + r7.pageSize + " is error", null);
        return;
    L10:
        int r3 = (r7.requestedStartPosition / r2) + 1;
        r0.add(new k("page", String.valueOf(r3)));
        r0.add(new k("page_size", String.valueOf(r7.pageSize)));
        r0.add(new k("need_page_timestamp", "true"));
        com.bytedance.android.ec.monitor.duration.d r4 = i.a.get(mi2.a.a);
        if (r4 == null) goto L13;
        r4.a("request_start");
    L13:
        l r5 = this.a;
        if (r5 == null) goto L25;
        Observable r6 = r5.b(g.V, r0, ECScrollProductCardResponse.class, null);
        if (r6 == null) goto L26;
        Observable r9 = r6.subscribeOn(Schedulers.io());
        if (r9 == null) goto L27;
        Observable r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L28;
        Disposable r11 = r10.subscribe(new a(this, r8, r3, r7), new b(this));
        if (r11 == null) goto L29;
        nl2.b.a(r11, this.d);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r1 = "author_id";
        goto L6
    }

    public final void loadRange(PositionalDataSource.LoadRangeParams r7, PositionalDataSource.LoadRangeCallback<ni2.a> r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().a("loadRange");
        FilterNullArrayList<k> r0 = new FilterNullArrayList();
        r0.add(new k("room_id", this.b.a.roomId()));
        r0.add(new k("entrance_info", this.b.b.toString()));
        if (f.g() == false) goto L5;
        String r1 = "author_open_id";
    L6:
        r0.add(new k(r1, this.b.a.c()));
        int r2 = this.b.c;
        if (r2 > 0) goto L9;
    L23:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadRange params.loadSize: " + r7.loadSize + " this.params.pageSize: " + this.b.c + " is error", null);
        return;
    L9:
        if (r7.loadSize <= 0) goto L23;
        int r3 = (r7.startPosition / r2) + 1;
        r0.add(new k("page", String.valueOf(r3)));
        r0.add(new k("page_size", String.valueOf(this.b.c)));
        r0.add(new k("need_page_timestamp", "false"));
        l r4 = this.a;
        if (r4 == null) goto L25;
        Observable r5 = r4.b(g.V, r0, ECScrollProductCardResponse.class, null);
        if (r5 == null) goto L26;
        Observable r6 = r5.observeOn(Schedulers.io());
        if (r6 == null) goto L27;
        Observable r9 = r6.subscribeOn(Schedulers.io());
        if (r9 == null) goto L28;
        Disposable r10 = r9.subscribe(new c(this, r8, r3, r7), d.a);
        if (r10 == null) goto L29;
        nl2.b.a(r10, this.d);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r1 = "author_id";
        goto L6
    }

    public ECScrollProductCardDataSource(l r2, oi2.b r3, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b r4, nl2.c r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "disposableScope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static final List e(ECScrollProductCardDataSource r7, List r8, int r9, int r10, int r11) {
        r7.getClass();
        if (r11 > 0) goto L5;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("assertListEqualPageSize totalSize: " + r11 + " is Error", null);
        return r8;
    L5:
        int r12 = (r9 * r10) - r11;
        if (r12 > 0) goto L9;
        r12 = 0;
    L9:
        int r1 = r10 - r12;
        dm.a.b r2 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c();
        StringBuilder r3 = new StringBuilder("assertListEqualPageSize the origin size: ");
        ArrayList r5 = (ArrayList) r8;
        r3.append(r5.size());
        r3.append(" page: ");
        r3.append(r9);
        r3.append(" pageSize: ");
        r3.append(r10);
        r3.append(" totalSize: ");
        r3.append(r11);
        r3.append(" bufferSize: ");
        r3.append(r12);
        r3.append(" realPageSize: ");
        r3.append(r1);
        r2.a(r3.toString());
        if (r5.size() >= r1) goto L17;
        List r13 = CollectionsKt.toMutableList(r8);
    L13:
        if (r13.size() >= r1) goto L15;
        r13.add(new ni2.a(true, 7));
        goto L13
    L15:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().a("assertListEqualPageSize the origin size: " + r5.size() + " need append result size: " + r13.size());
    L20:
        return r13;
    L17:
        if (r5.size() <= r1) goto L23;
        r13 = r5.subList(0, r1);
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().a("assertListEqualPageSize the origin size: " + r5.size() + " need delete result size: " + r13.size());
        goto L20
    L23:
        return r8;
    }
}

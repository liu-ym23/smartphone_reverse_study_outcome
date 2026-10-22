package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.CardPosition;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mq3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<P extends mq3.a, C extends ShopWindowDataSourceConfig<P>> {
    public final CompositeDisposable a;
    public final g b;
    public int c;
    public final com.bytedance.android.window.shop.c d;
    public final C e;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.repository.tab.datasource.impl.a$a, reason: collision with other inner class name */
    public static final class C0040a<T, R> implements Function {
        public final /* synthetic */ a a;

        public C0040a(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            WindowTabDataListResponseDTODeprecated r8 = (WindowTabDataListResponseDTODeprecated) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r0 = WindowDataMapper.a;
            List r1 = WindowDataMapper.c(r8.getMixFullCards());
            a r2 = this.a;
            List<com.bytedance.android.window.shop.repository.dto.c> r3 = r8.getGlobalMixFullCards();
            r2.getClass();
            ArrayList r4 = new ArrayList();
            if (r3 == null) goto L18;
            Iterator<T> r5 = r3.iterator();
        L6:
            if (r5.hasNext() == false) goto L18;
            com.bytedance.android.window.shop.repository.dto.c r6 = (com.bytedance.android.window.shop.repository.dto.c) r5.next();
            Integer r9 = r6.c();
            if (r9 == null) goto L6;
            int r10 = r9.intValue();
            if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r10) == true) goto L11;
            com.bytedance.android.window.shop.repository.tab.entity.f r11 = WindowDataMapper.f(r6);
            if (r11 != null) goto L16;
            r4.addAll(WindowDataMapper.g(r6));
            goto L6
        L16:
            r4.add(r11);
            goto L6
        L11:
            v r12 = WindowDataMapper.e(r6, r10);
            if (r12 == null) goto L6;
            r4.add(r12);
        L18:
            Iterator r13 = r4.iterator();
        L20:
            if (r13.hasNext() == false) goto L22;
            com.bytedance.android.window.shop.repository.tab.entity.f r14 = (com.bytedance.android.window.shop.repository.tab.entity.f) r13.next();
            CardPosition r15 = CardPosition.GLOBAL;
            r14.getClass();
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r14.e = r15;
            goto L20
        L22:
            ((ArrayList) r1).addAll(r4);
            Unit r16 = Unit.INSTANCE;
            return TuplesKt.to(r8, r1);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

        public b(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            WindowTabDataListResponseDTODeprecated r0 = (WindowTabDataListResponseDTODeprecated) r7.component1();
            List<com.bytedance.android.window.shop.repository.tab.entity.f> r8 = (List) r7.component2();
            a.a(this.a, r8);
            com.bytedance.android.window.shop.repository.dto.v r1 = r0.getExtensionCardControl();
            if (r1 != null) goto L5;
        L6:
            this.a.b.update(r0.getHasMore());
        L7:
            this.a.b(r0, r8, this.b);
            a r9 = this.a;
            r9.f((mq3.a) r9.e.b(), r0);
            if (r0.getHasMore() == false) goto L18;
            List<com.bytedance.android.window.shop.repository.dto.c> r10 = r0.getMixFullCards();
            if (r10 != null) goto L12;
        L15:
            boolean r11 = true;
        L16:
            if (r11 == false) goto L18;
            this.a.c(this.b);
            goto L18
        L12:
            if (r10.isEmpty() == true) goto L15;
            r11 = false;
        L18:
            com.bytedance.android.window.shop.repository.dto.v r12 = r0.getExtensionCardControl();
            if (r12 != null) goto L21;
            return;
        L21:
            if (r12.b() != true) goto L33;
            a r13 = this.a;
            com.bytedance.android.window.shop.repository.tab.datasource.c r2 = this.b;
            r13.getClass();
            ShopRepository r3 = ShopRepository.a;
            mq3.a r4 = (mq3.a) r13.e.b();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "reqParam");
            ReplaySubject r5 = ReplaySubject.a();
            int r14 = kq3.a.a;
            Intrinsics.checkNotNullParameter(r4, "reqParam");
            r4.getExtensionCardParam();
            ECWindowApi.a.getClass();
            ECWindowApi r15 = ECWindowApi.a.a;
            if (r15 == null) goto L29;
            String r16 = r4.getSecAuthorId();
            String r17 = r4.getExtensionCardParam();
            if (r17 != null) goto L27;
            r17 = "";
        L27:
            Observable<WindowExtensionDataListResponseDTO> r18 = r15.getWindowExtensionData(r16, r17);
            if (r18 == null) goto L29;
        L30:
            r18.subscribeOn(Schedulers.io()).subscribe(r5);
            Disposable r19 = bg4.b.b(r5.map(com.bytedance.android.window.shop.repository.tab.datasource.impl.b.a)).subscribe(new com.bytedance.android.window.shop.repository.tab.datasource.impl.c(r13, r2), new com.bytedance.android.window.shop.repository.tab.datasource.impl.d(r13, r2));
            CompositeDisposable r20 = r13.a;
            Intrinsics.checkNotNullParameter(r19, "$this$addTo");
            Intrinsics.checkNotNullParameter(r20, "d");
            r20.add(r19);
            return;
        L29:
            r18 = Observable.error(new Throwable("ECNetworkService not init"));
            goto L30
        L33:
            return;
        L5:
            if (r1.b() == true) goto L7;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

        public c(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            ECExceptionMonitor.e((Throwable) r2);
            this.b.onError("");
            this.a.b.b = false;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            WindowTabDataListResponseDTODeprecated r3 = (WindowTabDataListResponseDTODeprecated) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r0 = WindowDataMapper.a;
            return TuplesKt.to(r3, WindowDataMapper.c(r3.getMixFullCards()));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

        public e(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r4) {
            Pair r5 = (Pair) r4;
            WindowTabDataListResponseDTODeprecated r0 = (WindowTabDataListResponseDTODeprecated) r5.component1();
            List<com.bytedance.android.window.shop.repository.tab.entity.f> r6 = (List) r5.component2();
            a.a(this.a, r6);
            this.a.b.update(r0.getHasMore());
            this.a.b(r0, r6, this.b);
            a r7 = this.a;
            r7.f((mq3.a) r7.e.b(), r0);
            if (r0.getHasMore() == false) goto L14;
            List<com.bytedance.android.window.shop.repository.dto.c> r8 = r0.getMixFullCards();
            if (r8 != null) goto L7;
        L10:
            boolean r9 = true;
        L11:
            if (r9 == false) goto L15;
            this.a.d(this.b);
            return;
        L15:
            return;
        L7:
            if (r8.isEmpty() == true) goto L10;
            r9 = false;
            goto L11
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

        public f(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            this.b.onError("");
            this.a.b.b = false;
            ECExceptionMonitor.e((Throwable) r3);
        }
    }

    public final com.bytedance.android.window.shop.c getType() {
        return this.d;
    }

    public static boolean e(WindowTabDataListResponseDTODeprecated r5) {
        Intrinsics.checkNotNullParameter(r5, "dto");
        if (r5.getHideEmptyStatus() == false) goto L6;
        return true;
    L6:
        if (r5.getMixFullCards() != null) goto L8;
        return false;
    L8:
        List<com.bytedance.android.window.shop.repository.dto.c> r6 = r5.getMixFullCards();
        if ((r6 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L31;
        com.bytedance.android.window.shop.repository.dto.c r0 = (com.bytedance.android.window.shop.repository.dto.c) r7.next();
        Integer r3 = r0.c();
        if (r3 != null) goto L20;
    L21:
        Integer r1 = r0.c();
        if (r1 != null) goto L25;
    L27:
        boolean r2 = false;
    L29:
        if (r2 == false) goto L15;
        return true;
    L25:
        if (r1.intValue() != 208) goto L27;
    L28:
        r2 = true;
        goto L29
    L20:
        if (r3.intValue() == 101) goto L28;
    L31:
        return false;
    L11:
        if (r6.isEmpty() == false) goto L13;
        goto L13
    }

    public final synchronized void c(com.bytedance.android.window.shop.repository.tab.datasource.c r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "callback");     // Catch: Throwable -> L21
        g r0 = this.b;     // Catch: Throwable -> L21
        if (r0.b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r0.a == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        r0.b = true;     // Catch: Throwable -> L21
        mq3.a r1 = (mq3.a) this.e.b();     // Catch: Throwable -> L21
        if (r1.getPageNum() == 0) goto L15;
    L17:
        r1.setFirstEnter(false);     // Catch: Throwable -> L21
        ShopRepository.a.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r1, "reqParam");     // Catch: Throwable -> L21
        Observable r2 = kq3.a.c(r1);     // Catch: Throwable -> L21
    L18:
        Disposable r5 = bg4.b.b(r2.map(new C0040a(this))).subscribe(new b(this, r4), new c(this, r4));     // Catch: Throwable -> L21
        CompositeDisposable r3 = this.a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r5, "$this$addTo");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r3, "d");     // Catch: Throwable -> L21
        r3.add(r5);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L15:
        if (this.e.b == null) goto L17;
        r1.setFirstEnter(true);     // Catch: Throwable -> L21
        C r6 = this.e;     // Catch: Throwable -> L21
        WindowTabDataListResponseDTODeprecated r7 = r6.b;     // Catch: Throwable -> L21
        r6.b = null;     // Catch: Throwable -> L21
        r2 = Observable.just(r7);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(com.bytedance.android.window.shop.repository.tab.datasource.c r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "callback");     // Catch: Throwable -> L15
        g r0 = this.b;     // Catch: Throwable -> L15
        if (r0.b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r0.a == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        r0.b = true;     // Catch: Throwable -> L15
        ShopRepository r1 = ShopRepository.a;     // Catch: Throwable -> L15
        mq3.a r2 = (mq3.a) this.e.b();     // Catch: Throwable -> L15
        r1.getClass();     // Catch: Throwable -> L15
        Disposable r5 = bg4.b.b(ShopRepository.b(r2).map(d.a)).subscribe(new e(this, r4), new f(this, r4));     // Catch: Throwable -> L15
        CompositeDisposable r3 = this.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r5, "$this$addTo");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r3, "d");     // Catch: Throwable -> L15
        r3.add(r5);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public a(com.bytedance.android.window.shop.c r2, C r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.d = r2;
        this.e = r3;
        ((mq3.a) r3.b()).setTabType(r2.getType());
        this.a = new CompositeDisposable();
        this.b = new g();
        this.c = 1;
    }

    public static final void a(a r4, List r5) {
        r4.c = 0;
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L38;
        com.bytedance.android.window.shop.repository.tab.entity.f r0 = (com.bytedance.android.window.shop.repository.tab.entity.f) r6.next();
        com.bytedance.android.window.shop.repository.tab.entity.f r2 = null;
        if ((r0 instanceof m) == true) goto L8;
        com.bytedance.android.window.shop.repository.tab.entity.f r1 = null;
    L9:
        m r3 = (m) r1;
        if (r3 == null) goto L23;
        rq3.a r7 = r3.j;
        if (r7 == null) goto L23;
        fo.b r8 = ((WindowV2ProductItemVO) r7).C;
        if (r8 == null) goto L23;
        fo.a r9 = wn.a.C;
        if (((Integer) r8.a(r9)) != null) goto L4;
        int r10 = r4.c + 1;
        r4.c = r10;
        Integer r11 = r0.b;
        if (r11 == null) goto L21;
        r10 = r11.intValue();
    L21:
        Integer r12 = (Integer) r8.b(r9, Integer.valueOf(r10));
    L23:
        if ((r0 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == false) goto L26;
        r2 = r0;
    L26:
        if (r2 == null) goto L4;
        WindowV2ProductItemVO r13 = r2.c();
        if (r13 == null) goto L4;
        fo.b r14 = r13.C;
        if (r14 == null) goto L4;
        fo.a r15 = wn.a.C;
        if (r14.a(r15) != null) goto L4;
        int r16 = r4.c + 1;
        r4.c = r16;
        Integer r17 = r0.b;
        if (r17 == null) goto L37;
        r16 = r17.intValue();
    L37:
        r14.b(r15, Integer.valueOf(r16));
        goto L4
    L8:
        r1 = r0;
        goto L9
    }

    public void f(P r3, WindowTabDataListResponseDTODeprecated r4) {
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        Intrinsics.checkNotNullParameter(r4, "windowTabDataListResponseDTO");
        r3.setPageNum(r4.getCursor());
        r3.setCommonPassThroughParam(r4.getCommonPassThrough());
        com.bytedance.android.window.shop.repository.dto.v r0 = r4.getExtensionCardControl();
        if (r0 != null) goto L5;
    L7:
        String r5 = null;
    L8:
        r3.setExtensionCardParam(r5);
        return;
    L5:
        if (r0.b() != true) goto L7;
        r5 = r4.getExtensionCardControl().a();
        goto L8
    }

    public void b(WindowTabDataListResponseDTODeprecated r5, List<com.bytedance.android.window.shop.repository.tab.entity.f> r6, com.bytedance.android.window.shop.repository.tab.datasource.c r7) {
        Intrinsics.checkNotNullParameter(r5, "dto");
        Intrinsics.checkNotNullParameter(r6, "voList");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if ((!r6.isEmpty()) == false) goto L6;
        r7.y(new n0(r6, this.d, null, 12), ShopWindowVODataType.NORMAL);
    L6:
        if (r5.getHasMore() == true) goto L9;
        r7.c(this);
        return;
    }
}

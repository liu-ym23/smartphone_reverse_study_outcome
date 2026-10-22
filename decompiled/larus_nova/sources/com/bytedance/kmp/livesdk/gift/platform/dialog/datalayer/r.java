package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oc6.c0;
import oc6.d0;

/* JADX INFO: loaded from: classes19.dex */
public final class r implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f252313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f252314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<c0> f252315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<d0> f252316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Long> f252317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f252318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xc6.d f252319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final sc6.b f252320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final yz0.g f252321i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f252322a;

        public a(r r100) {
            this.f252322a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Iterator<T> r101 = ((List) r100).iterator();
        L3:
            boolean r102 = false;
            if (r101.hasNext() == false) goto L11;
            T r103 = r101.next();
            if (((w1) r103).getPageType() != 17) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L3;
        L12:
            w1 r105 = (w1) r103;
            if (r105 == null) goto L31;
            r r106 = this.f252322a;
            r106.f252313a = r105.getPageSortStrategy();
            r r107 = this.f252322a;
            r107.f252314b = r105.getPageSortStrategy();
            Set<Long> r108 = this.f252322a.f252317e;
            r108.clear();
            Iterator<T> r109 = r105.getGifts().iterator();
        L16:
            if (r109.hasNext() == false) goto L18;
            r108.add(Long.valueOf(((h1) r109.next()).getId()));
            goto L16
        L18:
            d0 r110 = this.f252322a.f252316d.getValue();
            BehaviorSubject<d0> r111 = this.f252322a.f252316d;
            d0 r112 = new d0();
            if (r110 == null) goto L23;
            Boolean r113 = r110.a();
            if (r113 == null) goto L23;
            r102 = r113.booleanValue();
        L23:
            r112.b(Boolean.valueOf(r102));
            r112.c(r105.getPageSortStrategy());
            Unit r114 = Unit.INSTANCE;
            r111.onNext(r112);
            return;
        L31:
            return;
        L8:
            r104 = false;
            goto L9
        L11:
            r103 = null;
            goto L12
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f252320h.j6(false, -1).subscribe(new a(this)), this.f252318f);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f252318f.clear();
        if (this.f252313a == this.f252314b) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        this.f252320h.p7();
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public r(xc6.d r100, sc6.b r101, yz0.g r102) {
        Intrinsics.checkNotNullParameter(r100, "mostlyUsedDataSource");
        Intrinsics.checkNotNullParameter(r101, "giftListRoomRepository");
        Intrinsics.checkNotNullParameter(r102, "roomDataService");
        this.f252319g = r100;
        this.f252320h = r101;
        this.f252321i = r102;
        int r103 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f252315c = BehaviorSubject.createDefault(new c0());
        this.f252316d = BehaviorSubject.createDefault(new d0());
        this.f252317e = new LinkedHashSet();
        this.f252318f = new CompositeDisposable();
    }

    public static final void a(r r100, long r101, boolean r102) {
        c0 r103 = r100.f252315c.getValue();
        if (r103 == null) goto L9;
        List<Long> r104 = r103.a();
        if (r104 == null) goto L9;
        List<Long> r105 = CollectionsKt.toMutableList(r104);
        if (r105 == null) goto L9;
    L10:
        c0 r106 = new c0();
        if (r102 == true) goto L13;
        r105.remove(Long.valueOf(r101));
    L16:
        r106.b(r105);
        r100.f252315c.onNext(r106);
        return;
    L13:
        if (r105.contains(Long.valueOf(r101)) == true) goto L16;
        r105.add(Long.valueOf(r101));
    L9:
        r105 = new ArrayList();
        goto L10
    }
}

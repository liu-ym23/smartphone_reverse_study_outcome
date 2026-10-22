package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements com.bytedance.ee.bear.more.office.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<v> f235827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeLongPressActionContextFactory f235828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f235829c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f235830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeLongPressMenuAction f235831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z f235832c;

        public a(x r100, OfficeLongPressMenuAction r101, z r102) {
            this.f235830a = r100;
            this.f235831b = r101;
            this.f235832c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            x r100 = this.f235830a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f235831b, this.f235832c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public p(Function0<v> r100, OfficeLongPressActionContextFactory r101, x r102) {
        this.f235827a = r100;
        this.f235828b = r101;
        this.f235829c = r102;
    }

    @Override // com.bytedance.ee.bear.more.office.b
    public final void a(String r100, OfficeLongPressLarkAction r101, String r102, com.bytedance.ee.bear.more.office.a r103) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r103, "availability");
        v r104 = this.f235827a.invoke();
        if (r104 != null) goto L5;
        return;
    L5:
        this.f235828b.getClass();
        z r105 = OfficeLongPressActionContextFactory.g(r103);
        if (r104.d(r100, r101, r102, r105) == true) goto L9;
        StringBuilder r106 = new StringBuilder("drop async availability update. action=");
        r106.append(r101);
        r106.append(", actionId=");
        this.f235828b.getClass();
        r106.append(du5.b.k(r100));
        r106.append(", result=");
        this.f235828b.getClass();
        r106.append(OfficeLongPressActionContextFactory.d(r105));
        tt5.a.h("OfficeLongPressActionContextFactory", r106.toString());
        return;
    L9:
        StringBuilder r107 = new StringBuilder("accept async availability update. action=");
        r107.append(r101);
        r107.append(", actionId=");
        this.f235828b.getClass();
        r107.append(du5.b.k(r100));
        r107.append(", result=");
        this.f235828b.getClass();
        r107.append(OfficeLongPressActionContextFactory.d(r105));
        tt5.a.h("OfficeLongPressActionContextFactory", r107.toString());
        this.f235828b.getClass();
        OfficeLongPressMenuAction r108 = OfficeLongPressActionContextFactory.h(r101);
        if (r108 != null) goto L12;
        return;
    L12:
        this.f235828b.f235682g.post(new a(this.f235829c, r108, r105));
    }
}

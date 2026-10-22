package com.bytedance.ee.bear.bitable.core.bottompanel;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements com.bytedance.ee.bear.bitable.core.bottompanel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f210144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f210145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<ew4.a> f210146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<Integer, String> f210147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f210148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f210149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f210150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f210151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f210152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f210153j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.core.bottompanel.b$b, reason: collision with other inner class name */
    public static final class C3025b implements com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3025b f210154a = null;

        static {
            f210154a = new C3025b();
        }

        public C3025b() {
        }

        @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a
        public final void close() {
        }
    }

    public static final class c implements com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f210155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f210156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f210157c;

        public c(Ref.BooleanRef r100, b r101, int r102) {
            this.f210155a = r100;
            this.f210156b = r101;
            this.f210157c = r102;
        }

        @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a
        public final void close() {
            Ref.BooleanRef r100 = this.f210155a;
            if (r100.element == true) goto L9;
            r100.element = true;
            b r101 = this.f210156b;
            String r102 = r101.f210147d.remove(Integer.valueOf(this.f210157c));
            if (r102 == null) goto L10;
            tt5.a.h("OfficeBaseBottomPanelAbility", "release suppression owner:" + r102 + " count:" + r101.f210147d.size());
            r101.a(false);
            return;
        L10:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a
    public final void L4(ew4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f210146c.remove(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a
    public final com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a Yc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if (this.f210153j == true) goto L5;
        int r101 = this.f210152i;
        this.f210152i = r101 + 1;
        this.f210147d.put(Integer.valueOf(r101), r100);
        a(false);
        tt5.a.h("OfficeBaseBottomPanelAbility", "acquire suppression owner:" + r100 + " count:" + this.f210147d.size());
        return new c(new Ref.BooleanRef(), this, r101);
    L5:
        return C3025b.f210154a;
    }

    public final void a(boolean r100) {
        if (this.f210147d.isEmpty() == false) goto L5;
        int r101 = this.f210148e;
    L7:
        if (this.f210149f != r101) goto L11;
        if (r100 == false) goto L17;
        this.f210144a.invoke(Integer.valueOf(r101));
        return;
    L17:
        return;
    L11:
        this.f210149f = r101;
        this.f210144a.invoke(Integer.valueOf(r101));
        Iterator<T> r102 = this.f210146c.iterator();
    L13:
        if (r102.hasNext() == false) goto L15;
        ((ew4.a) r102.next()).a(r101);
        goto L13
    L15:
        return;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a
    public final void setBackgroundColor(int r100) {
        if (this.f210153j == true) goto L12;
        Integer r101 = this.f210151h;
        if (r101 != null) goto L8;
    L10:
        this.f210151h = Integer.valueOf(r100);
        this.f210145b.invoke(Integer.valueOf(r100));
        return;
    L8:
        if (r101.intValue() != r100) goto L10;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.bottompanel.a
    public final void u9(ew4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f210153j == false) goto L6;
        return;
    L6:
        if (this.f210146c.contains(r100) == true) goto L8;
        this.f210146c.add(r100);
    L8:
        r100.a(this.f210149f);
        r100.b(this.f210150g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super Integer, Unit> r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onHeightChanged");
        Intrinsics.checkNotNullParameter(r101, "onBackgroundColorChanged");
        this.f210144a = r100;
        this.f210145b = r101;
        this.f210146c = new CopyOnWriteArrayList();
        this.f210147d = new LinkedHashMap();
        this.f210150g = true;
    }
}

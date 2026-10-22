package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements l, sn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sn0.a f542618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerResStep f542619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n.a f542620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f542621d;

    public interface a {
        void a(LayoutConfigModel r100);

        void onFailed(Throwable r100);
    }

    /* JADX INFO: renamed from: sn0.b$b, reason: collision with other inner class name */
    public interface InterfaceC7630b {
        void onFailed();

        void onSuccess();
    }

    public b(n.a r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f542620c = r100;
        this.f542621d = r101;
        this.f542619b = ProducerResStep.GeckoOffline;
    }

    @Override // sn0.a
    public final void c(pn0.d r100, pn0.g r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        boolean r102 = this.f542620c.f542644b.d().f529895c;
        boolean r103 = this.f542620c.f542644b.d().f529896d.contains(String.valueOf(r100.g()));
        if (r102 == false) goto L9;
        if (r103 == true) goto L9;
        List<pn0.a> r104 = this.f542620c.f542643a;
        f r105 = new f(this, r100, r101);
        if (r104.isEmpty() == false) goto L8;
        e r106 = new e(this, r100, r101, r105);
        System.currentTimeMillis();
        this.f542620c.f542644b.c().a(this.f542620c.f542644b.a() + "entrance.json", new d(this, r100, r106));
        return;
    L8:
        e(r100, r101, r105);
        return;
    L9:
        d(r100.e(), "geckoOfflineProducer is banned by setting!!! ui_layout = " + r100.g() + ", geckoOfflineEnable = " + r102 + ", isDisableUILayout = " + r103 + ", disableUILayoutList = " + this.f542620c.f542644b.d().f529896d);
        sn0.a r107 = this.f542618a;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L12:
        r107.c(r100, r101);
    }

    public final void d(pn0.d.a r100, String r101) {
        StringBuilder r102 = r100.f529918a;
        r102.append("\n");
        r102.append("step: " + this.f542619b + ", content: " + r101);
    }

    @Override // sn0.l
    public final void a(pn0.d r100, pn0.g r101, sn0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        this.f542618a = r102;
        l r103 = this.f542621d;
        if (r103 == null) goto L6;
        r103.a(r100, r101, this);
        return;
    }

    public final void e(pn0.d r110, pn0.g r111, f r112) {
        int r100 = r110.g();
        int r101 = r111.f529940b;
        int r113 = r111.f529939a;
        if (r113 == 0) goto L5;
        r100 = r113;
    L5:
        Iterator<T> r114 = this.f542620c.f542643a.iterator();
    L6:
        boolean r102 = false;
        String r103 = null;
        if (r114.hasNext() == false) goto L22;
        Object r104 = r114.next();
        pn0.a r105 = (pn0.a) r104;
        if (r105.d() == r100) goto L11;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == false) goto L6;
    L23:
        pn0.a r107 = (pn0.a) r104;
        if (r107 == null) goto L26;
        r103 = r107.b();
    L26:
        if (r103 != null) goto L28;
    L29:
        r102 = true;
    L30:
        if (r102 == false) goto L33;
        r112.onFailed(new Throwable("targetFileName is null or empty, fileName: " + r103 + ", reviewList: " + this.f542620c.f542643a));
        return;
    L33:
        this.f542620c.f542644b.c().a(this.f542620c.f542644b.a() + r103, new c(this, r110, r112, r103));
        return;
    L28:
        if (r103.length() != 0) goto L30;
    L11:
        if (r105.c() == 0) goto L15;
        if (r105.c() != r101) goto L19;
    L15:
        if (Intrinsics.areEqual(r105.a(), "") == false) goto L17;
    L18:
        r106 = true;
        goto L20
    L17:
        if (Intrinsics.areEqual(r105.a(), "android") == false) goto L19;
    L22:
        r104 = null;
        goto L23
    }

    @Override // sn0.a
    public final void b(pn0.d r100, pn0.g r101, LayoutConfigModel r102, ProducerResStep r103) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "layoutConfig");
        Intrinsics.checkNotNullParameter(r103, "step");
        sn0.a r104 = this.f542618a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r104.b(r100, r101, r102, r103);
    }
}

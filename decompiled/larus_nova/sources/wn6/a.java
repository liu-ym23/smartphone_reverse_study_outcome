package wn6;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a<T extends View> implements ViewTreeObserver.OnWindowAttachListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f560467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kq6.b f560468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ft6.b f560469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f560470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f560471e;

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public final void onWindowAttached() {
    }

    public void c() {
        if (this.f560471e == false) goto L5;
        return;
    L5:
        Iterator r100 = ((LinkedHashMap) this.f560470d).entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        Map.Entry r101 = (Map.Entry) r100.next();
        ft6.b r102 = this.f560469c;
        String r103 = (String) r101.getKey();
        r101.getValue();
        r102.b(r103);
        goto L7
    L9:
        kq6.b r104 = this.f560468b;
        if (r104 == null) goto L17;
        Map<String, String> r105 = r104.get("start");
        if (r105 == null) goto L17;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        Map.Entry<String, String> r107 = r106.next();
        a(r107.getKey(), r107.getValue());
    L17:
        this.f560469c.start();
        this.f560471e = true;
    }

    public void d() {
        if (this.f560471e == true) goto L5;
        return;
    L5:
        kq6.b r100 = this.f560468b;
        if (r100 == null) goto L13;
        Map<String, String> r101 = r100.get("stop");
        if (r101 == null) goto L13;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, String> r103 = r102.next();
        a(r103.getKey(), r103.getValue());
    L13:
        this.f560469c.stop();
        this.f560471e = false;
    }

    public void b() {
        d();
        this.f560467a.getViewTreeObserver().removeOnWindowAttachListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public final void onWindowDetached() {
        b();
        this.f560469c.a();
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f560470d.put(r100, r101);
        if (this.f560471e == false) goto L6;
        this.f560469c.b(r100);
        return;
    }

    public a(T r100, String r101, kq6.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f560467a = r100;
        this.f560468b = r102;
        this.f560469c = HostServiceUtilsKt.A().b(r101);
        this.f560470d = new LinkedHashMap();
        r100.getViewTreeObserver().addOnWindowAttachListener(this);
    }
}

package uvc;

import com.alipay.sdk.m.u.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f551900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f551901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f551902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f551903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f551904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f551905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f551906g;

    public abstract void a(c r100);

    public String f() {
        return "";
    }

    public final void g() {
        b r100 = this.f551903d;
        if (r100 == null) goto L5;
        r100.f551904e = this.f551904e;
    L8:
        b r101 = this.f551904e;
        if (r101 == null) goto L11;
        r101.f551903d = r100;
    L14:
        this.f551900a = null;
        this.f551904e = null;
        this.f551903d = null;
        return;
    L11:
        b r102 = this.f551900a;
        if (r102 == null) goto L14;
        r102.f551902c = r100;
        goto L14
    L5:
        b r103 = this.f551900a;
        if (r103 == null) goto L8;
        r103.f551901b = this.f551904e;
        goto L8
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + f() + i.f25855d;
    }

    public b() {
        this.f551900a = null;
        this.f551901b = null;
        this.f551902c = null;
        this.f551903d = null;
        this.f551904e = null;
        this.f551905f = null;
        this.f551906g = new HashMap();
    }

    public b c() {
        return this.f551900a;
    }

    public final void b(b r100) {
        r100.g();
        r100.e(this);
        b r101 = this.f551902c;
        if (r101 == null) goto L5;
        r101.f551904e = r100;
        r100.f551903d = r101;
        this.f551902c = r100;
        return;
    L5:
        this.f551901b = r100;
        this.f551902c = r100;
    }

    public final void d(b r100) {
        r100.g();
        b r101 = this.f551904e;
        r100.f551904e = r101;
        if (r101 == null) goto L5;
        r101.f551903d = r100;
    L5:
        r100.f551903d = this;
        this.f551904e = r100;
        b r102 = this.f551900a;
        r100.f551900a = r102;
        if (r100.f551904e != null) goto L9;
        r102.f551902c = r100;
        return;
    }

    public void e(b r100) {
        this.f551900a = r100;
    }
}

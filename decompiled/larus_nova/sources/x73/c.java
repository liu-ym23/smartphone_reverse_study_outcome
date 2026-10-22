package x73;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.video.i;
import fj.e;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f562815f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f562816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f562817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<e> f562818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f562819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gj.b f562820e;

    public static final class a {
    }

    public void d(i r100, boolean r101) {
    }

    public void f() {
    }

    static {
        f562815f = ECAppInfoService.f48114e.i();
    }

    public final boolean b() {
        if (this.f562816a != null) goto L5;
        return true;
    L5:
        if (f562815f == true) goto L8;
        return false;
    L8:
        StringBuilder r100 = new StringBuilder("已经消费了 ");
        Object r101 = this.f562816a;
        if (Intrinsics.areEqual(r101, this.f562820e) == false) goto L11;
        String r102 = "playAbility";
    L15:
        r100.append(r102);
        r100.append("，禁止重复消费。");
        throw new IllegalArgumentException(r100.toString());
    L11:
        if (Intrinsics.areEqual(r101, this.f562819d) == false) goto L13;
        r102 = "videoPlayer";
        goto L15
    L13:
        r102 = "null";
        goto L15
    }

    public final boolean a(Object r100) {
        Object r101 = this.f562816a;
        if (r101 != null) goto L10;
        if (f562815f == true) goto L8;
        return false;
    L8:
        throw new IllegalArgumentException("未消费，无法归还。");
    L10:
        if ((!Intrinsics.areEqual(r101, r100)) == true) goto L12;
        return true;
    L12:
        if (f562815f == true) goto L14;
        return false;
    L14:
        StringBuilder r102 = new StringBuilder("当前消费的是 ");
        Object r103 = this.f562816a;
        if (Intrinsics.areEqual(r103, this.f562820e) == false) goto L17;
        String r104 = "playAbility";
    L21:
        r102.append(r104);
        r102.append("，无法归还。");
        throw new IllegalArgumentException(r102.toString());
    L17:
        if (Intrinsics.areEqual(r103, this.f562819d) == false) goto L19;
        r104 = "videoPlayer";
        goto L21
    L19:
        r104 = "null";
        goto L21
    }

    public void e(gj.b r100) {
        if (r100 == null) goto L4;
        Set<e> r101 = r100.getListeners();
    L5:
        this.f562818c = r101;
        if (r101 == null) goto L13;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        e r103 = (e) r102.next();
        if (r100 == null) goto L9;
        r100.Z(r103);
        goto L9
    L19:
        return;
    L13:
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final gj.b i(d r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        d r101 = this.f562817b;
        if (r101 == null) goto L7;
        if (r101 == null) goto L7;
        r101.a(this);
    L7:
        if (b() == true) goto L10;
        return null;
    L10:
        gj.b r102 = this.f562820e;
        this.f562816a = r102;
        this.f562817b = r100;
        e(r102);
        return this.f562820e;
    }

    public final i j(d r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        d r101 = this.f562817b;
        if (r101 == null) goto L6;
        r101.a(this);
    L6:
        if (b() == true) goto L9;
        return null;
    L9:
        this.f562816a = this.f562819d;
        this.f562817b = r100;
        f();
        return this.f562819d;
    }

    public c(i r100, gj.b r101) {
        this.f562819d = r100;
        this.f562820e = r101;
        if (r100 != null) goto L10;
        if (r101 == null) goto L6;
        return;
    L6:
        if (f562815f == true) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("videoPlayer 和 playAbility 不能都为 null");
    }

    public void c(gj.b r100, boolean r101) {
        if (r100 == null) goto L9;
        Set<e> r102 = r100.getListeners();
        if (r102 == null) goto L9;
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.Z((e) r103.next());
    L9:
        Set<e> r104 = this.f562818c;
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L24;
        e r106 = (e) r105.next();
        if (r100 == null) goto L13;
        r100.A(r106);
        goto L13
    L24:
        return;
    }

    public final void g(d r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "record");
        if ((!Intrinsics.areEqual(r100, this.f562817b)) == false) goto L6;
        return;
    L6:
        if (a(this.f562820e) == true) goto L8;
        return;
    L8:
        this.f562817b = null;
        this.f562816a = null;
        c(this.f562820e, Intrinsics.areEqual(r101, Boolean.TRUE));
    }

    public final void h(d r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "record");
        if ((!Intrinsics.areEqual(r100, this.f562817b)) == false) goto L6;
        return;
    L6:
        if (a(this.f562819d) == true) goto L8;
        return;
    L8:
        this.f562817b = null;
        this.f562816a = null;
        d(this.f562819d, !Intrinsics.areEqual(r101, Boolean.FALSE));
    }
}

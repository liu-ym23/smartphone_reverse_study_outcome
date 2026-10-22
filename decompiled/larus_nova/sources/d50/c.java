package d50;

import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f466892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f466893f;

    @Override // d50.a
    public final void b() {
        this.f466892e = -1;
        g();
    }

    @Override // d50.a
    public final void f() {
        this.f466892e = -1;
        g();
    }

    public final void g() {
        if (this.f466892e == (-1)) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, c50.d>> r100 = this.f466889b.entrySet().iterator();
        c50.c r101 = null;
    L7:
        if (r100.hasNext() == false) goto L29;
        Map.Entry<Integer, c50.d> r102 = r100.next();
        if (r102 == null) goto L7;
        if (r102.getKey() == null) goto L7;
        if (r102.getValue() == null) goto L7;
        if (this.f466891d.contains(Integer.valueOf(r102.getKey().intValue())) == true) goto L7;
        c50.d r103 = r102.getValue();
        if (r103.f22454d.size() > 0) goto L21;
        c50.c r104 = null;
    L22:
        if (r104 == null) goto L7;
        if (r101 == null) goto L28;
        if (r101.f22449c <= r104.f22449c) goto L7;
    L28:
        r101 = r104;
        goto L7
    L21:
        r104 = (c50.c) ListProtector.get(r103.f22454d, 0);
        goto L22
    L29:
        h(r101);
    }

    @Override // d50.a
    public final boolean c(c50.c r100) {
        g();
        return true;
    }

    @Override // d50.a
    public final boolean d(c50.c r100) {
        if (this.f466892e != r100.hashCode()) goto L7;
        this.f466892e = -1;
        g();
        return true;
    L7:
        return true;
    }

    @Override // d50.a
    public final void e(int r100) {
        g();
    }

    public void h(c50.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Message r101 = a(r100);
        if (r101 == null) goto L8;
        this.f466890c.a(this.f466889b, r100);
        this.f466892e = r100.hashCode();
        this.f466888a.sendMessageAtTime(r101, r100.f22449c + this.f466893f);
        return;
    }

    public c(c50.a r100, HashMap r101, f50.a r102, long r103) {
        super(r100, r101, r102);
        this.f466892e = -1;
        this.f466893f = 0;
        if (r103 > 0) goto L5;
        r103 = 0;
    L5:
        this.f466893f = r103;
    }
}

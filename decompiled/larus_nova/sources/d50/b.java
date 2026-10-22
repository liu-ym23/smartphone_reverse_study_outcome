package d50;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends a {
    @Override // d50.a
    public final void b() {
    }

    @Override // d50.a
    public final boolean d(c50.c r100) {
        return false;
    }

    @Override // d50.a
    public final void f() {
    }

    @Override // d50.a
    public final boolean c(c50.c r100) {
        int r101 = r100.f22450d;
        if (this.f466891d.contains(Integer.valueOf(r101)) == true) goto L10;
        Message r102 = a(r100);
        if (r102 == null) goto L8;
        this.f466890c.a(this.f466889b, r100);
        this.f466888a.sendMessageAtTime(r102, r100.f22449c);
        return true;
    L8:
        return false;
    L10:
        f50.a r103 = this.f466890c;
        HashMap<Integer, c50.d> r104 = this.f466889b;
        if (r103.f475607a == false) goto L17;
        if (r104 == null) goto L17;
        c50.d r105 = r104.get(Integer.valueOf(r100.f22450d));
        if (r105 == null) goto L17;
        r105.b();
    L17:
        return true;
    }

    @Override // d50.a
    public final void e(int r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        c50.d r101 = this.f466889b.get(Integer.valueOf(r100));
        if (r101 != null) goto L8;
        return;
    L8:
        ArrayList<c50.c> r102 = r101.f22454d;
        if (ListUtils.isEmpty(r102) == false) goto L11;
        return;
    L11:
        f50.a r103 = this.f466890c;
        Handler r104 = this.f466888a;
        HashMap<Integer, c50.d> r105 = this.f466889b;
        if (r103.f475607a == false) goto L19;
        if (r105 == null) goto L18;
        c50.d r106 = r105.get(Integer.valueOf(r100));
        if (r106 == null) goto L18;
        r106.b();
    L18:
        r103.b(r104, r105);
    L19:
        Iterator<c50.c> r107 = r102.iterator();
    L21:
        if (r107.hasNext() == false) goto L27;
        c50.c r108 = r107.next();
        if (r108 == null) goto L21;
        Message r109 = a(r108);
        if (r109 == null) goto L21;
        this.f466888a.sendMessage(r109);
        goto L21
    L27:
        f50.a r110 = this.f466890c;
        Handler r111 = this.f466888a;
        HashMap<Integer, c50.d> r112 = this.f466889b;
        if (r110.f475607a == false) goto L39;
        r110.b(r111, r112);
        return;
    }

    public b(c50.a r100, HashMap r101, f50.a r102) {
        super(r100, r101, r102);
    }
}

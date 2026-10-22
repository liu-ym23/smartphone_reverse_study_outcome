package ed5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f472212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f472213b;

    public final void a() {
        c r100 = this.f472213b;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.t0(this.f472212a.f472208a);
        c r101 = this.f472213b;
        a r102 = this.f472212a;
        r102.getClass();
        r101.C0(new LinkedHashSet(r102.f472209b));
    }

    public final void c() {
        a r100 = this.f472212a;
        r100.f472208a = false;
        r100.f472209b.clear();
        r100.f472210c.clear();
        a();
    }

    public b(a r100) {
        this.f472212a = r100;
    }

    public final void b(Document r100) {
        a r101 = this.f472212a;
        r101.f472208a = true;
        r101.f472209b.clear();
        r101.f472210c.clear();
        if (r100 == null) goto L7;
        String r102 = a.a(r100);
        if (TextUtils.isEmpty(r102) == true) goto L7;
        r101.f472209b.add(r102);
        r101.f472210c.add(r100);
    L7:
        a();
    }

    public final void d(c r100) {
        this.f472213b = r100;
        a();
    }

    public final void e(List r100) {
        a r101 = this.f472212a;
        r101.f472211d.clear();
        if (r100 == null) goto L6;
        r101.f472211d.addAll(r100);
    L6:
        if (r101.f472208a == false) goto L22;
        ArrayList r102 = new ArrayList();
        LinkedHashSet r103 = new LinkedHashSet();
        if (r100 == null) goto L18;
        Iterator r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L18;
        Document r105 = (Document) r104.next();
        String r106 = a.a(r105);
        if (TextUtils.isEmpty(r106) == true) goto L12;
        if (r101.f472209b.contains(r106) == false) goto L12;
        r103.add(r106);
        r102.add(r105);
    L18:
        r101.f472209b.clear();
        r101.f472209b.addAll(r103);
        r101.f472210c.clear();
        r101.f472210c.addAll(r102);
        if (hu5.a.d(r101.f472209b) == false) goto L21;
        r101.f472208a = true;
        goto L22
    L21:
        r101.f472208a = true;
    L22:
        a();
    }

    public final void f(Document r100) {
        a r101 = this.f472212a;
        r101.getClass();
        String r102 = a.a(r100);
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r101.f472208a = true;
        if (r101.f472209b.contains(r102) == false) goto L13;
        r101.f472209b.remove(r102);
        int r103 = r101.f472210c.size();
    L8:
        r103 = r103 - 1;
        if (r103 < 0) goto L15;
        if (TextUtils.equals(a.a((Document) ListProtector.get(r101.f472210c, r103)), r102) == false) goto L8;
        ListProtector.remove(r101.f472210c, r103);
    L15:
        if (hu5.a.d(r101.f472209b) == false) goto L17;
        r101.f472208a = false;
        r101.f472209b.clear();
        r101.f472210c.clear();
        goto L17
    L13:
        r101.f472209b.add(r102);
        r101.f472210c.add(r100);
    L17:
        a();
    }
}

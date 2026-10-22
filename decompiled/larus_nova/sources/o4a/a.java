package o4a;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import t4a.d;
import t4a.f;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseAbility f522010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f522011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f522012c;

    public /* synthetic */ a(BaseAbility r100, int r101, Map r102) {
        this.f522010a = r100;
        this.f522011b = r101;
        this.f522012c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseAbility r100 = this.f522010a;
        int r101 = this.f522011b;
        Map r102 = this.f522012c;
        if (((CopyOnWriteArrayList) r100.f380237a).isEmpty() == false) goto L6;
        return;
    L6:
        switch(BaseAbility.a.f380244a[Event.values()[r101].ordinal()]) {
            case 1: goto L61;
            case 2: goto L57;
            case 3: goto L53;
            case 4: goto L49;
            case 5: goto L45;
            case 6: goto L41;
            case 7: goto L37;
            case 8: goto L33;
            case 9: goto L23;
            case 10: goto L19;
            case 11: goto L12;
            case 12: goto L8;
            default: goto L81;
        };
    L8:
        t4a.a r103 = new t4a.a(r102);
        Iterator r104 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L10:
        if (r104.hasNext() == false) goto L82;
        ((f) r104.next()).k(r103);
        goto L10
    L82:
        return;
    L12:
        t4a.c r105 = new t4a.c(r102);
        if (r100.f380242f == false) goto L18;
        Iterator r106 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L16:
        if (r106.hasNext() == false) goto L83;
        ((f) r106.next()).o(r105);
        goto L16
    L83:
        return;
    L18:
        r100.f380243g = r105;
        return;
    L19:
        d r107 = new d(r102);
        Iterator r108 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L21:
        if (r108.hasNext() == false) goto L84;
        ((f) r108.next()).n(r107);
        goto L21
    L84:
        return;
    L23:
        t4a.c r109 = new t4a.c(r102);
        Iterator r110 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L25:
        if (r110.hasNext() == false) goto L27;
        ((f) r110.next()).e(r109);
        goto L25
    L27:
        WeakReference<q4a.b> r111 = r100.f380238b;
        if (r111 == null) goto L30;
        q4a.b r112 = r111.get();
    L31:
        if (r112 == null) goto L78;
        r112.e();
        return;
    L78:
        return;
    L30:
        r112 = null;
        goto L31
    L33:
        t4a.b r113 = new t4a.b(r102);
        Iterator r114 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L35:
        if (r114.hasNext() == false) goto L85;
        ((f) r114.next()).g(r113);
        goto L35
    L85:
        return;
    L37:
        t4a.c r115 = new t4a.c(r102);
        Iterator r116 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L39:
        if (r116.hasNext() == false) goto L86;
        ((f) r116.next()).a(r115);
        goto L39
    L86:
        return;
    L41:
        t4a.a r117 = new t4a.a(r102);
        Iterator r118 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L43:
        if (r118.hasNext() == false) goto L87;
        ((f) r118.next()).i(r117);
        goto L43
    L87:
        return;
    L45:
        t4a.c r119 = new t4a.c(r102);
        Iterator r120 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L47:
        if (r120.hasNext() == false) goto L88;
        ((f) r120.next()).c(r119);
        goto L47
    L88:
        return;
    L49:
        t4a.c r121 = new t4a.c(r102);
        Iterator r122 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L51:
        if (r122.hasNext() == false) goto L89;
        ((f) r122.next()).b(r121);
        goto L51
    L89:
        return;
    L53:
        t4a.c r123 = new t4a.c(r102);
        Iterator r124 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L55:
        if (r124.hasNext() == false) goto L90;
        ((f) r124.next()).d(r123);
        goto L55
    L90:
        return;
    L57:
        t4a.c r125 = new t4a.c(r102);
        Iterator r126 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L59:
        if (r126.hasNext() == false) goto L91;
        ((f) r126.next()).j(r125);
        goto L59
    L91:
        return;
    L61:
        t4a.c r127 = new t4a.c(r102);
        Iterator r128 = ((CopyOnWriteArrayList) r100.f380237a).iterator();
    L63:
        if (r128.hasNext() == false) goto L92;
        ((f) r128.next()).l(r127);
        goto L63
    L92:
        return;
    }
}

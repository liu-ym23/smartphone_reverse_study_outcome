package fa8;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b> f476039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f476040b;

    public a() {
        this.f476039a = new LinkedList();
    }

    public final void a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f476039a.add(new b(r100));
        this.f476040b += (long) r100.length;
    }

    public final int b(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r101 < 0) goto L20;
        int r102 = 0;
        if (r101 > (r100.length - 0)) goto L20;
        if (r101 == 0) goto L18;
        long r103 = this.f476040b;
        if (r103 == 0) goto L18;
        int r104 = (int) Math.min(r101, r103);
        Iterator<b> r105 = this.f476039a.iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L17;
        if (r102 >= r104) goto L17;
        b r107 = r105.next();
        int r108 = Math.min(r104 - r102, r107.f476041a.length - r107.f476042b);
        System.arraycopy(r107.f476041a, r107.f476042b, r100, r106, r108);
        int r109 = r107.f476042b + r108;
        r107.f476042b = r109;
        r102 = r102 + r108;
        r106 = r106 + r108;
        if (r109 != r107.f476041a.length) goto L12;
        r105.remove();
    L17:
        this.f476040b -= (long) r102;
    L18:
        return r102;
    L20:
        throw new IllegalArgumentException("Invalid read parameters");
    }
}

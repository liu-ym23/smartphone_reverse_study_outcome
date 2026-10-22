package xkc;

import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f564420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f564421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f564422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f564423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f564424f;

    public final boolean a() {
        ((ArrayList) this.f564423e).clear();
        j r100 = this.f564420b;
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (this.f564421c == null) goto L22;
        if (((ArrayList) r100.f564426b).size() <= 5) goto L10;
        List<String> r101 = this.f564423e;
        ArrayList r102 = (ArrayList) r101;
        r102.addAll(((ArrayList) this.f564420b.f564426b).subList(0, 5));
    L11:
        ArrayList r103 = new ArrayList(this.f564421c.f564426b);
        r103.removeAll(this.f564420b.f564426b);
        int r104 = 10 - ((ArrayList) this.f564423e).size();
        if (r103.size() < r104) goto L14;
        List<String> r105 = this.f564423e;
        ArrayList r106 = (ArrayList) r105;
        r106.addAll(r103.subList(0, r104));
        return true;
    L14:
        ((ArrayList) this.f564423e).addAll(r103);
        int r107 = 10 - ((ArrayList) this.f564423e).size();
        if ((((ArrayList) this.f564420b.f564426b).size() - 5) <= r107) goto L18;
        List<String> r108 = this.f564423e;
        ArrayList r109 = (ArrayList) this.f564420b.f564426b;
        ArrayList r110 = (ArrayList) r108;
        r110.addAll(r109.subList(5, r107 + 5));
        return true;
    L18:
        if ((((ArrayList) this.f564420b.f564426b).size() - 5) <= 0) goto L25;
        List<String> r111 = this.f564423e;
        List<String> r112 = this.f564420b.f564426b;
        int r113 = ((ArrayList) r112).size();
        ArrayList r114 = (ArrayList) r111;
        r114.addAll(((ArrayList) r112).subList(5, r113));
        return true;
    L25:
        return true;
    L10:
        List<String> r115 = this.f564423e;
        ArrayList r116 = (ArrayList) r115;
        r116.addAll(this.f564420b.f564426b);
        goto L11
    }

    public i(String r100) {
        this.f564422d = new ReentrantLock();
        this.f564423e = new ArrayList(10);
        new ArrayMap();
        this.f564424f = new ArrayList();
        this.f564419a = r100;
        new Random(System.currentTimeMillis());
    }
}

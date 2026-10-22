package n4a;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class g3 implements Comparator<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h3 f517296a;

    public g3(h3 r100) {
        this.f517296a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(String r100, String r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) this.f517296a.f517343c;
        long r103 = ((h3.b) r102.get(r101)).f517351c;
        ConcurrentHashMap r104 = (ConcurrentHashMap) this.f517296a.f517343c;
        long r105 = ((h3.b) r104.get(r100)).f517351c;
        if (r103 >= r105) goto L5;
        return -1;
    L5:
        if (r103 != r105) goto L7;
        return 0;
    L7:
        return 1;
    }
}

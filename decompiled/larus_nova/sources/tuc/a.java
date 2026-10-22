package tuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static zuc.a a(List<zuc.a> r100, int r101) {
        if (r101 >= 0) goto L4;
    L7:
        zuc.a r102 = new zuc.a();
        if (r101 >= 0) goto L10;
        zuc.a r103 = (zuc.a) ListProtector.get(r100, 0);
    L11:
        int r104 = r103.f573672a;
        int r105 = r103.f573674c;
        r102.f573672a = r104 + ((r105 - r104) * r101);
        r102.f573673b = r103.f573673b;
        int r106 = r103.f573672a;
        r102.f573674c = r105 + ((r105 - r106) * r101);
        int r107 = r103.f573675d;
        int r108 = (r103.f573674c - r106) * r101;
        r102.f573675d = r107 + r108;
        r102.f573676e = r103.f573676e + r108;
        return r102;
    L10:
        r101 = (r101 - r100.size()) + 1;
        r103 = (zuc.a) ListProtector.get(r100, r100.size() - 1);
        goto L11
    L4:
        if (r101 > (r100.size() - 1)) goto L7;
        return (zuc.a) ListProtector.get(r100, r101);
    }
}

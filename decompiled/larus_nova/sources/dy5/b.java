package dy5;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f470532a;

    public b() {
        this.f470532a = c.a.f470533a;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r110) {
        this.f470532a.getClass();
        boolean r100 = true;
        String r101 = r110.getName();     // Catch: Throwable -> L21
        int r102 = r101.lastIndexOf(".bin");     // Catch: Throwable -> L21
        if (r102 == (-1)) goto L18;
        String[] r103 = r101.substring(0, r102).split("_");     // Catch: Throwable -> L21
        if (r103.length < 2) goto L18;
        String r104 = r103[1];     // Catch: Throwable -> L21
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L21
        long r106 = CastLongProtector.parseLong(r104);     // Catch: Throwable -> L21
        long r107 = 0;
        if (r106 < 0) goto L15;
        r107 = r106 >> 16;
    L15:
        if ((r105 - r107) >= 604800000) goto L18;
        r100 = false;
    L18:
        if (r100 == false) goto L20;
        xu3.b.a(r110);
    L20:
        return false;
    }
}

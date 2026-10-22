package ebb;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, Long> f471980a;

    public d(Map<String, Long> r100) {
        this.f471980a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        File r102 = (File) r100;
        File r103 = (File) r101;
        Long r104 = this.f471980a.get(r103.getAbsolutePath());
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        Long r106 = this.f471980a.get(r102.getAbsolutePath());
        if (r106 == null) goto L9;
        long r107 = r106.longValue();
    L11:
        if (r105 >= r107) goto L13;
        return -1;
    L13:
        if (r105 != r107) goto L15;
        return 0;
    L15:
        return 1;
    L9:
        r107 = r102.lastModified();
        goto L11
    L5:
        r105 = r103.lastModified();
        goto L6
    }
}

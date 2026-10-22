package ms.bd.c;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes42.dex */
public final class h3 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f515156a;

    public h3(String r100) {
        this.f515156a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return r101.startsWith(this.f515156a);
    }
}

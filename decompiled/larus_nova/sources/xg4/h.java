package xg4;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f563654a;

    public h(long r100) {
        this.f563654a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return r101.endsWith("-" + this.f563654a);
    }
}

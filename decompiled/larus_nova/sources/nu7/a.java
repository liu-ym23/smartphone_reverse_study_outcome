package nu7;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f520609a;

    public a(String r100) {
        this.f520609a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return r101.startsWith(this.f520609a);
    }
}

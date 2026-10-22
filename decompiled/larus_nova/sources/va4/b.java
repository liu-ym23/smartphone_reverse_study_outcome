package va4;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553942c;

    public final File a() {
        return FilesKt.resolve(FilesKt.resolve(new PolarisFileWrapper(this.f553940a), this.f553941b), this.f553942c);
    }

    public b(String r100, String r101, String r102) {
        this.f553940a = r100;
        this.f553941b = r101;
        this.f553942c = r102;
    }
}

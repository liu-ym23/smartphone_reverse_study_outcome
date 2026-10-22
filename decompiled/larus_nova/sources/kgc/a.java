package kgc;

import com.ss.android.ttapkdiffpatch.SoLoadUtils;
import com.ss.android.ttapkdiffpatch.applier.ApplyPatchFailException;
import com.ss.android.ttapkdiffpatch.applier.DiffType;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements igc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f503399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f503400b;

    /* JADX INFO: renamed from: kgc.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C6551a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f503401a = null;

        static {
            int[] r100 = new int[DiffType.values().length];
            f503401a = r100;
            r100[DiffType.ArchivePatcher.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f503401a[DiffType.HDiffPatch.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final igc.b a(DiffType r100) throws ApplyPatchFailException {
        if (r100 == null) goto L15;
        int r101 = C6551a.f503401a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L11;
        return this.f503399a;
    L11:
        throw new ApplyPatchFailException(1010, "unknown diff type" + r100);
    L13:
        return this.f503400b;
    L15:
        throw new ApplyPatchFailException(1010, "empty diffType");
    }

    public a(ExecutorService r100, long r101) {
        d r102 = new d(new SoLoadUtils(), r101);
        this.f503399a = r102;
        this.f503400b = new c(r102, r100);
    }
}

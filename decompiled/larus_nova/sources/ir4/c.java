package ir4;

import com.bytedance.ee.bear.document.offline.file.upload.DriveFileUploadHelper;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f495447a = null;

    static {
        f495447a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.ee.bear.document.offline.file.upload.i r101 = (com.bytedance.ee.bear.document.offline.file.upload.i) r100;
        Intrinsics.checkNotNullParameter(r101, "helper");
        return r101 instanceof DriveFileUploadHelper;
    }
}

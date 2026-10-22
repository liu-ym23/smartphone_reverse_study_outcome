package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f563981a = null;

    static {
        f563981a = new c0();
    }

    public c0() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof FileEntity) == false) goto L9;
        FileEntity r101 = (FileEntity) r100;
        int r102 = (r101.getFileName().hashCode() + 0) * 31;
        long r103 = r101.getFileSize();
        int r104 = ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + r101.getContentUrl().hashCode()) * 31) + r101.getFileType().name().hashCode();
        String r105 = r101.getMimeType();
        if (r105 != null) goto L7;
        return r104;
    L7:
        return (r104 * 31) + r105.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}

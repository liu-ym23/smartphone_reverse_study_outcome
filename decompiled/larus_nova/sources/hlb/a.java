package hlb;

import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements d {

    /* JADX INFO: renamed from: hlb.a$a, reason: collision with other inner class name */
    public static final class C6162a {
    }

    static {
    }

    public a() {
    }

    @Override // hlb.d
    public final String getName() {
        return "FileDecryptTransform";
    }

    @Override // hlb.d
    public final boolean a(com.ss.android.lark.image.uploader.entity.b r100, ImageUploadTask r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "imageUploadTask");
        return r100.f426389c;
    }

    @Override // hlb.d
    public final String b(com.ss.android.lark.image.uploader.entity.b r100, ImageUploadTask r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "imageUploadTask");
        File r102 = com.ss.android.lark.vfs.d.a().G(r100.f426387a, true);
        if (r102 == null) goto L7;
        String r103 = r102.getAbsolutePath();
        if (r103 == null) goto L7;
        return r103;
    L7:
        return r100.f426387a;
    }
}

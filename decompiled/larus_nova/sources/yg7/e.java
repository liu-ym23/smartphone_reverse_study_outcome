package yg7;

import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.timon.permission.storage.constant.MediaPickType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567511a = 0;

    static {
    }

    public static MediaPickType a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = r100.toString();
        if (StringsKt.startsWith$default(r101, MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString(), false, 2, null) == true) goto L21;
        if (StringsKt.startsWith$default(r101, MediaStore.Images.Media.getContentUri("external_primary").toString(), false, 2, null) == true) goto L21;
        if (StringsKt.startsWith$default(r101, MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString(), false, 2, null) == true) goto L24;
        if (StringsKt.startsWith$default(r101, MediaStore.Video.Media.getContentUri("external_primary").toString(), false, 2, null) == true) goto L24;
        if (StringsKt.startsWith$default(r101, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString(), false, 2, null) == true) goto L23;
        if (StringsKt.startsWith$default(r101, MediaStore.Audio.Media.getContentUri("external_primary").toString(), false, 2, null) == true) goto L23;
        return MediaPickType.TYPE_ALL;
    L23:
        return MediaPickType.TYPE_AUDIO;
    L24:
        return MediaPickType.TYPE_VIDEO;
    L21:
        return MediaPickType.TYPE_IMAGE;
    }
}

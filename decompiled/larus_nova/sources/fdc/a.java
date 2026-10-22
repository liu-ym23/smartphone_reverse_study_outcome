package fdc;

import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(PhotoItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (PhotoPagerFgUtils.a() == true) goto L5;
        return false;
    L5:
        ResourceCleanScene r101 = r100.getResourceCleanScene();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.isCSAMDelete() != true) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final boolean b(PhotoItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (PhotoPagerFgUtils.a() == true) goto L7;
        return false;
    L7:
        if (r100.getResourceCleanScene() == null) goto L10;
        return true;
    L10:
        return r100.resourceIsCleaned;
    }

    @JvmStatic
    public static final boolean c(PhotoItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (PhotoPagerFgUtils.a() == true) goto L5;
        return false;
    L5:
        ResourceCleanScene r101 = r100.getResourceCleanScene();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
    L16:
        return true;
    L13:
        if (r100.resourceIsCleaned == true) goto L15;
        return false;
    L15:
        if (r100.getResourceCleanScene() == null) goto L16;
        return false;
    L8:
        if (r101.isUnifiedRegularDelete() != true) goto L10;
        r102 = true;
        goto L11
    }
}

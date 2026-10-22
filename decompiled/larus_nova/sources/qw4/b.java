package qw4;

import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final List<LocalSaveEntity> b(LocalSaveEntity r100) {
        if (r100 != null) goto L5;
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.listOf(r100);
    }

    public static final LocalSaveEntity a(UploadCallback.a r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "appId");
        String r103 = r100.f232476a;
        int r104 = a.f534992a;
        Intrinsics.checkNotNullParameter(r101, "appId");
        boolean r105 = false;
        if (r103 != null) goto L26;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L19;
        if (r102 != null) goto L14;
    L15:
        r105 = true;
    L16:
        if (r105 == true) goto L19;
        LocalSaveEntity r107 = new LocalSaveEntity(r101, r103, r102);     // Catch: Exception -> L8
    L23:
        if (r107 == null) goto L27;
        r107.setDataVersion(r100.f232480e);
        return r107;
    L27:
        return null;
    L14:
        if (r102.length() != 0) goto L16;
    L19:
        tt5.a.k("LocalSaveEntityExtensions", "generateLocalSaveEntity fail, data is null");     // Catch: Exception -> L8
    L22:
        r107 = null;
        goto L23
    L26:
    L8:
        e = move-exception;
        tt5.a.d("LocalSaveEntityExtensions", "generateLocalSaveEntity fail: " + e);
        goto L22
    L5:
        if (r103.length() == 0) goto L10;
        r106 = false;
        goto L11
    }
}

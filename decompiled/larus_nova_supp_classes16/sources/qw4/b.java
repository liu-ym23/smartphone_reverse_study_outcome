package qw4;

import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final List<LocalSaveEntity> b(LocalSaveEntity r0) {
        if (r0 != null) goto L5;
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.listOf(r0);
    }

    public static final LocalSaveEntity a(UploadCallback.a r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "appId");
        String r1 = r6.a;
        int r2 = a.a;
        Intrinsics.checkNotNullParameter(r7, "appId");
        boolean r0 = false;
        if (r1 != null) goto L26;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L19;
        if (r8 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L19;
        LocalSaveEntity r3 = new LocalSaveEntity(r7, r1, r8);     // Catch: Exception -> L8
    L23:
        if (r3 == null) goto L27;
        r3.setDataVersion(r6.e);
        return r3;
    L27:
        return null;
    L14:
        if (r8.length() != 0) goto L16;
    L19:
        tt5.a.k("LocalSaveEntityExtensions", "generateLocalSaveEntity fail, data is null");     // Catch: Exception -> L8
    L22:
        r3 = null;
        goto L23
    L26:
    L8:
        e = move-exception;
        tt5.a.d("LocalSaveEntityExtensions", "generateLocalSaveEntity fail: " + e);
        goto L22
    L5:
        if (r1.length() == 0) goto L10;
        r5 = false;
        goto L11
    }
}

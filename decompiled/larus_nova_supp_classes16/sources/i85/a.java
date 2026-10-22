package i85;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.lark.dependency.i;
import g85.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    static {
    }

    public static boolean a(Context r4, ArrayList r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "openEntities");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "openEntities");
        f r6 = o75.b.a().getMimeTypeManager();
        Iterator r7 = r5.iterator();
    L3:
        boolean r1 = false;
        if (r7.hasNext() == false) goto L30;
        BaseOpenEntity r0 = (BaseOpenEntity) r7.next();
        if (Intrinsics.areEqual(r0.getAppId(), "1002") == false) goto L3;
        String r2 = r0.getFileName();
        ((g85.b) r6).getClass();
        if (TextUtils.isEmpty(r2) == false) goto L10;
        boolean r3 = false;
    L11:
        if (r3 == true) goto L18;
        String r8 = r0.getFileName();
        if (TextUtils.isEmpty(r8) == true) goto L16;
        r1 = r8.endsWith(".msg");
    L16:
        if (r1 == false) goto L3;
    L18:
        if ((r0 instanceof LocalOpenEntity) == false) goto L3;
        tt5.a.h("EmailInterceptor", "open eml file from little app");
        i r9 = (i) org.koin.java.a.c(i.class, null, null, 6);
        ((LocalOpenEntity) r0).getLocalFilePath();
        r9.b();
        return true;
    L10:
        r3 = r2.endsWith(".eml");
        goto L11
    L30:
        return false;
    }
}

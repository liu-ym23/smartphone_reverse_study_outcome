package vn9;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.nova.R;
import cr9.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final boolean a(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = b.f465116a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (CollectionsKt.contains(b.f465117b, r100.getResourceType()) == true) goto L6;
        return false;
    L6:
        return b.a(r100.getResourceId());
    }

    public static final void b(Context r100) {
        s r101 = s.f544207a;
        if (r100 != null) goto L5;
        r100 = AppHost.f326268a.getApplication().getApplicationContext();
    L5:
        r101.getClass();
        s.s(r100, R.string.larus_LarkCCM_DoubaoLocalFile_OpenInDesktop_Toast_cn);
    }
}

package ah5;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = "ccm.exitWhenNoPermission";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r3, XBridgeMethod.Callback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TYPE);
        FragmentActivity r6 = (Context) provideContext(Context.class);
        if (r6 != null) goto L7;
        tt5.a.d("CCMNoPermissionExitMethod", "handle()...context is null");
        return;
    L7:
        if ((r6 instanceof FragmentActivity) == false) goto L19;
        Bundle r7 = (Bundle) r6.getIntent().getParcelableExtra("ori-bundle");
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.getInt(ResourceData.KEY_TYPE, sbb.e.g.b) != sbb.e.f.b) goto L17;
        FolderPermSetInfo r8 = (FolderPermSetInfo) r7.getParcelable("permission_doc_info");
        rc5.a r9 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        if (r8 == null) goto L15;
        String r10 = r8.c;
    L16:
        r9.v(r10);
        goto L17
    L15:
        r10 = null;
    L17:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).X9();
        return;
    }
}

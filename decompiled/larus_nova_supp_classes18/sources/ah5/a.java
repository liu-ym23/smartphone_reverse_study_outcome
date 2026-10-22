package ah5;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground_permission_export.model.f;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: ah5.a$a, reason: collision with other inner class name */
    public static final class C0000a {
    }

    static {
    }

    public a() {
        this.a = "ccm.jumpToInviteCollaborator";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r5, XBridgeMethod.Callback r6, XBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TYPE);
        FragmentActivity r8 = (Context) provideContext(Context.class);
        Fragment r9 = (Fragment) provideContext(Fragment.class);
        if ((r8 instanceof FragmentActivity) == true) goto L7;
        tt5.a.d("CCMJumpInviteCollaboratorMethod", "handle()...context is not FragmentActivity");
        return;
    L7:
        if (r9 == null) goto L12;
        Bundle r2 = r9.getArguments();
        if (r2 == null) goto L11;
        Bundle r0 = (Bundle) r2.getParcelable("ori-bundle");
    L13:
        if (r0 == null) goto L16;
        ((f) org.koin.java.a.c(f.class, null, null, 6)).a(r8, r9, r5.getString("userInfoList"), r0);
        return;
    L16:
        return;
    L11:
        r0 = null;
        goto L13
    L12:
        r0 = (Bundle) r8.getIntent().getParcelableExtra("ori-bundle");
        goto L13
    }
}

package nu4;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.invitemember.BitableShareInviteMemberFragment;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import pg5.b;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: nu4.a$a, reason: collision with other inner class name */
    public static final class C0264a {
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
        Intrinsics.checkNotNullParameter(r7, "type");
        FragmentActivity r8 = (Context) provideContext(Context.class);
        Bundle r1 = null;
        if (c.j() == false) goto L5;
        Fragment r0 = (Fragment) provideContext(Fragment.class);
    L6:
        if (r8 != null) goto L10;
        tt5.a.d("CCMJumpInviteCollaboratorMethod", "handle()...context is null");
        return;
    L10:
        if ((r8 instanceof FragmentActivity) == true) goto L12;
        return;
    L12:
        if (r0 == null) goto L16;
        Bundle r3 = r0.getArguments();
        if (r3 == null) goto L17;
        r1 = (Bundle) r3.getParcelable("ori-bundle");
    L17:
        if (r1 == null) goto L26;
        b r2 = b.a;
        ArrayList r9 = b.b(r5.getString("userInfoList"));
        if (r1.getInt("type", e.g.b) != e.r.b) goto L27;
        BitableSharePermSetInfo r10 = (BitableSharePermSetInfo) r1.getParcelable("permission_doc_info");
        if (r10 == null) goto L28;
        if (r9 == null) goto L29;
        int r4 = BitableShareInviteMemberFragment.p;
        BitableShareInviteMemberFragment.a.a(r8, r0, r10, r9, false);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L16:
        r1 = (Bundle) r8.getIntent().getParcelableExtra("ori-bundle");
        goto L17
    L5:
        r0 = null;
        goto L6
    }
}

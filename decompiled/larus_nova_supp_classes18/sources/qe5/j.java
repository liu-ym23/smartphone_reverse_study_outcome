package qe5;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends XCoreBridgeMethod implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.i {
    public XBridgeMethod.Callback a;
    public String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.i
    public final void b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("code", 1);
        XBridgeMethod.Callback r3 = this.a;
        if (r3 == null) goto L6;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("code", 1);
        r4.put(WikiFolderPushPlugin.DATA, r0);
        r4.put("msg", "");
        r3.invoke(r4);
        return;
    }

    public j() {
        this.c = "ccm.permission.apply_transfer";
    }

    public final void release() {
        super.release();
        if (TextUtils.isEmpty(this.b) == true) goto L8;
        jg5.j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r1 = this.b;
        r0.getClass();
        HashMap r2 = (HashMap) jg5.j.f;
        if (r2.containsKey(r1) == false) goto L9;
        r2.remove(r1);
        return;
    L9:
        return;
    }

    public final String getName() {
        return this.c;
    }

    public final void handle(XReadableMap r24, XBridgeMethod.Callback r25, XBridgePlatformType r26) {
        Intrinsics.checkNotNullParameter(r24, "params");
        Intrinsics.checkNotNullParameter(r25, "callback");
        Intrinsics.checkNotNullParameter(r26, ResourceData.KEY_TYPE);
        Context r4 = (Context) provideContext(Context.class);
        Fragment r5 = (Fragment) provideContext(Fragment.class);
        if (r4 != null) goto L6;
        tt5.a.d("CCMShowTransferApplyMethod", "handle()...context is null");
        return;
    L6:
        this.a = r25;
        String r10 = s.f(r24, "ownerId", "");
        int r8 = r24.getInt(ResourceData.KEY_TYPE);
        String r2 = s.f(r24, ResourceData.KEY_TOKEN, "");
        TransferApplyInfo r1 = new TransferApplyInfo(r8, r2, r10, null, null, 0, s.f(r24, "ownerName", ""), false, false, false, 0, false, false, 7864, null);
        this.b = r2;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((HashMap) jg5.j.f).put(r2, this);
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).wb(r4, r1, r5, false);
    }
}

package tl5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends vv4.a {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: tl5.b$b, reason: collision with other inner class name */
    public static final class C0313b implements tb5.h<Object> {
        public C0313b() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerRunOnNotUIThread.-CC.$default$authType(this);
        }

        public final void handle(Object r4, m r5) {
            tt5.a.d("GetStatusHandler", "handle");
            if (r5 == null) goto L16;
            RnSyncManager r6 = RnSyncManager.a;
            VFSPath r7 = RnSyncManager.c();
            JSONObject r0 = new JSONObject();
            r0.put("isInit", Boolean.valueOf(RnSyncManager.f.get()));
            r0.put("isDestroy", Boolean.valueOf(RnSyncManager.g.get()));
            r0.put("isConnect", Boolean.valueOf(RnSyncManager.v));
            if (r7 == null) goto L7;
            String r1 = r7.getRealPath();
        L8:
            r0.put("jsBundlePath", r1);
            if (r7 == null) goto L13;
            boolean r2 = true;
            if (com.suite.lark.component.storage.ext.b.b(r7) != true) goto L13;
        L14:
            r0.put("isBundleExist", Boolean.valueOf(r2));
            r0.put("extra", "");
            String r8 = r0.toJSONString();
            tt5.a.d("RnSyncManager", "getRnStatus:" + r8);
            r5.onCallBack(r8);
            return;
        L13:
            r2 = false;
            goto L14
        L7:
            r1 = null;
            goto L8
        }
    }

    static {
        a = "biz.rn.sendMessage";
        b = "biz.rn.reload";
        c = "biz.rn.getRnStatus";
        d = "biz.comment.postMessage";
    }

    public b() {
    }

    public final void onAttachToWeb(vv4.k r4) {
        Intrinsics.checkNotNullParameter(r4, "web");
        super.onAttachToWeb(r4);
        String r5 = a;
        String r1 = getWeb().getWebViewId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        bindBridgeHandlerAutoUnbind(r5, new k(r1));
        String r6 = d;
        String r3 = getWeb().getWebViewId();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        bindBridgeHandlerAutoUnbind(r6, new k(r2));
        bindBridgeHandlerAutoUnbind(b, new c());
        bindBridgeHandlerAutoUnbind(c, new C0313b());
    }
}

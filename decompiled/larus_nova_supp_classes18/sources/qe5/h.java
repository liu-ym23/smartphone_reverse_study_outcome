package qe5;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
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
public final class h extends XCoreBridgeMethod implements rh5.a {
    public final String a;
    public XBridgeMethod.Callback b;
    public String c;

    public static final class a {
    }

    static {
    }

    public h() {
        this.a = "ccm.permission.showCustomPasswordSetting";
    }

    public final void release() {
        super.release();
        tt5.a.h("ccm-lynx: CCMShowCustomPasswordSetMethod", "release");
        if (TextUtils.isEmpty(this.c) == true) goto L6;
        jg5.j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r1 = this.c;
        r0.getClass();
        ((HashMap) jg5.j.e).remove(r1);
        return;
    }

    public final String getName() {
        return this.a;
    }

    @Override // rh5.a
    public final void c(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "password");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("password", r5);
        r1.put("code", Integer.valueOf(r4));
        XBridgeMethod.Callback r6 = this.b;
        if (r6 == null) goto L6;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("code", 1);
        r0.put(WikiFolderPushPlugin.DATA, r1);
        r0.put("msg", "");
        r6.invoke(r0);
        return;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TYPE);
        Context r2 = (Context) provideContext(Context.class);
        Fragment r6 = (Fragment) provideContext(Fragment.class);
        if (r2 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowCustomPasswordSetMethod", "handle()...context is null");
        return;
    L6:
        this.b = r9;
        String r3 = s.f(r8, ResourceData.KEY_TOKEN, "");
        this.c = r3;
        int r4 = r8.getInt(ResourceData.KEY_TYPE);
        String r5 = s.f(r8, WikiFolderPushPlugin.DATA, "");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((HashMap) jg5.j.e).put(r3, this);
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).c5(r2, r3, r4, r5, r6);
    }
}

package ak5;

import android.os.Build;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.docsdk.impl.utils.AESUtils;
import com.bytedance.ee.eenet.util.HttpChannel;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public class a implements qr5.a.a {
        public final /* synthetic */ Map a;
        public final /* synthetic */ b0 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ f e;

        public a(f r1, Map r2, b0 r3, boolean r4, String r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final void a() {
        if (((Boolean) new ml5.b("debug_config").a("rust_net_enable", Boolean.TRUE)).booleanValue() == false) goto L5;
        lr5.b.d(HttpChannel.RustChannel);
    L6:
        boolean r3 = true;
        if (lr5.b.d == HttpChannel.RustChannel) goto L9;
    L16:
        com.bytedance.ee.bear.contract.j r0 = com.bytedance.ee.bear.contract.j.a.a;
        int r1 = ((NetService) org.koin.java.a.a(NetService.class)).getEnv();
        if (r1 != 2) goto L19;
    L22:
        boolean r9 = true;
    L23:
        String r2 = "";
        if (r9 == false) goto L26;
        String r10 = "#" + ((String) new ml5.b("debug_config").a("http_request_id", ""));
    L27:
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r5 = r4.i("ccm_gray.client.ccm", false);
        r4.i("ccm_gray.client.lark", false);
        if (r1 == 3) goto L31;
        r3 = false;
    L31:
        if (r5 == true) goto L34;
        if (r3 == true) goto L34;
    L34:
        HashMap r7 = new HashMap();
        g r6 = this.a;
        if (r6.d != null) goto L37;
        r6.d = (b0) org.koin.java.a.a(b0.class);
    L37:
        b0 r8 = r6.d;
        r7.put("doc-version-code", String.valueOf(r8.getVersionCode()));
        r7.put("doc-version-name", r8.getVersionName());
        r7.put("doc-package-name", r8.getPackageName());
        r7.put("doc-platform", r8.getPlatform());
        r7.put("doc-biz", r8.getPlatform());
        r7.put("doc-os", "Android");
        r7.put("doc-os-version", Build.VERSION.RELEASE);
        String r11 = r8.getDeviceModel();
        if (r11 != null) goto L59;
    L52:
        r7.put("doc-device-model", r2);
        r8.getChannelId();
        r7.put("doc-channel-id", "0");
        r7.put("doc-device-id", r8.getDeviceId());
        r7.put("called_from", "docs");
        r7.put("User-Agent", r8.h());
        if (eu5.c.c() == true) goto L55;
    L57:
        qr5.a.a = new a(this, r7, r8, r9, r10);
        return;
    L55:
        if (((com.bytedance.ee.bear.account.a) ClaymoreServiceLoader.loadFirst(com.bytedance.ee.bear.account.a.class)).loginEnv() != 3) goto L57;
        r7.put("env", "Pre_release");
        goto L57
    L59:
        r2 = r11.replace("\n", "");     // Catch: Throwable -> L50
        int r12 = r2.length();     // Catch: Throwable -> L50
        int r13 = 0;
    L41:
        if (r13 >= r12) goto L52;
        char r14 = r2.charAt(r13);     // Catch: Throwable -> L50
        if (r14 <= 31) goto L48;
        if (r14 >= 127) goto L48;
        r13 = r13 + 1;     // Catch: Throwable -> L50
    L48:
        r2 = URLEncoder.encode(r2, AESUtils.CHARSET);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        tt5.a.f("NetUtils", th, false);
        r2 = r11;
        goto L52
    L26:
        r10 = "";
        goto L27
    L19:
        if (r1 == 5) goto L22;
        r9 = false;
        goto L23
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("rust_net_proxy_enabled", false) == false) goto L11;
    L14:
        boolean r15 = true;
    L15:
        qr5.a.b.set(r15);
        goto L16
    L11:
        if (eu5.c.b(this.a.a) == true) goto L14;
        r15 = false;
        goto L15
    L5:
        lr5.b.d(HttpChannel.OkHttpChannel);
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(g r1) {
        this.a = r1;
    }
}

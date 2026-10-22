package yhc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.update.IUpdateConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IUpdateConfig f567718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f567719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f567720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f567721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f567722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExecutorService f567723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f567724g;

    public class a implements Callable<String> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() throws Exception {
            return ita.i.a(-1, "https://app-alpha.bytedance.net/ping", null);
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f567725a = null;

        static {
            f567725a = new p();
        }
    }

    public static String c() {
        AppCommonContext r100 = f0.f567694c;
        if (r100 == null) goto L13;
        Context r101 = r100.getContext();
        if (r101 == null) goto L13;
        if (NetworkUtils.isNetworkAvailable(r101) == false) goto L13;
        if (NetworkUtils.isWifi(r101) == false) goto L13;
        String r102 = k0.f567707a;
        b.f567725a.getClass();
        if (TextUtils.isEmpty("") == true) goto L13;
        String r103 = "0";
    L14:
        com.ss.android.update.c.c("test_inhouse_wifi_list", "inhouse_network_attr", CastIntegerProtector.parseInt(r103));
        return r103;
    L13:
        r103 = "-1";
        goto L14
    }

    public static boolean d() {
        AppCommonContext r100 = f0.f567694c;
        if (r100 == null) goto L10;
        Context r101 = r100.getContext();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(null) == false) goto L9;
        return false;
    L9:
        return ita.k.h(r101, null);
    L10:
        return false;
    }

    public final void a() {
        IUpdateConfig r100 = this.f567718a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getUpdateConfig() == null) goto L9;
        this.f567718a.getUpdateConfig().getClass();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public final boolean e() {
        if (this.f567720c == false) goto L6;
        ?? r100 = g();
    L9:
        com.ss.android.update.c.c("test_inhouse_network", "inhouse_network", r100);
        return r100;
    L6:
        if (c().equals("1") == false) goto L8;
        r100 = g();
        goto L9
    L8:
        r100 = 0;
        goto L9
    }

    public final boolean f() {
        AppCommonContext r100 = f0.f567694c;
        if (r100 == null) goto L13;
        Context r101 = r100.getContext();
        if (r101 == null) goto L13;
        if (NetworkUtils.isNetworkAvailable(r101) == false) goto L13;
        if (this.f567720c == false) goto L13;
        if (this.f567719b == false) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return true;
    L16:
        return g();
    L13:
        r102 = false;
        goto L14
    }

    public final boolean g() {
        String r100 = (String) this.f567723f.submit(this.f567724g).get(1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L7 TimeoutException -> L11
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (TextUtils.equals("pong", new JSONObject(r100).optString("message", "")) == false) goto L9;
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return false;
    }

    public p() {
        this.f567722e = true;
        this.f567724g = new a();
        AppCommonContext r100 = f0.f567694c;
        this.f567721d = e0.a(r100.getContext().getApplicationContext());
        r100.getUpdateVersionCode();
        IUpdateConfig r101 = f0.f567692a;
        this.f567718a = r101;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUpdateConfig() != null) goto L7;
        return;
    L7:
        if (r101.getUpdateConfig().f567745i == null) goto L12;
        this.f567719b = r101.getUpdateConfig().f567745i.f567689a;
        this.f567722e = true;
        this.f567720c = r101.getUpdateConfig().f567744h;
        r101.getUpdateConfig().getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().f567745i.getClass();
        r101.getUpdateConfig().getClass();
        this.f567723f = PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("UpdateAlphaManager"));
        return;
    }

    public final boolean b(int r100) {
        return this.f567721d.f567691a.getBoolean("bg_dl_ignore_" + r100, false);
    }
}

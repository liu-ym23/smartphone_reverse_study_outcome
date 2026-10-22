package fi7;

import android.app.Application;
import android.content.ClipData;
import android.net.Uri;
import android.text.TextUtils;
import ci7.f;
import ci7.l;
import ci7.p;
import ci7.t;
import ci7.u;
import ci7.v;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mi7.e;
import mi7.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f477411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f477412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f477413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<t> f477414d = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(fi7.b r100, int r101, String r102) {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClipData f477415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f477416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f477417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f477418d;

        @Override // java.lang.Runnable
        public final void run() {
            d.d(this.f477415a, this.f477416b, this.f477417c, this.f477418d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ClipData r100, String r101, String r102, boolean r103) {
            this.f477415a = r100;
            this.f477416b = r101;
            this.f477417c = r102;
            this.f477418d = r103;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallBackForAppLink f477419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f477420b;

        @Override // java.lang.Runnable
        public final void run() {
            d.e(this.f477419a, mi7.b.c(this.f477420b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(CallBackForAppLink r100, String r101) {
            this.f477419a = r100;
            this.f477420b = r101;
        }
    }

    static {
        long r100 = 1000;
        if (ZlinkApi.INSTANCE.getEnableSPOpt() == true) goto L6;
        Application r101 = l.a();
        List<WeakReference<ki7.b>> r102 = ki7.c.f503641a;
        r100 = ki7.d.b(r101).optLong("settings_app_link_interval", 1000);
    L6:
        f477413c = r100;
        f477414d = new CopyOnWriteArraySet();
    }

    public static void f(String r100) {
        ZlinkDependAbility r101 = p.f23879a;
        if (r101 != null) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == false) goto L37;
        String r103 = "";
        String r104 = null;
        if (TextUtils.isEmpty(r100) == false) goto L35;
    L19:
        Uri r105 = null;
    L20:
        ZlinkDependAbility r106 = p.f23879a;
        if (r106 == null) goto L24;
        r104 = r106.entranceOfLaunchLogForAppLink();
    L24:
        v r107 = v.a.f23889a;
        if (TextUtils.isEmpty(r107.f23888a) == true) goto L27;
    L31:
        h.a(new u(r103, r105, r104));
        return;
    L27:
        if (TextUtils.isEmpty(r103) == false) goto L29;
        String r108 = "unknown";
    L30:
        r107.f23888a = r108;
        e.c("LaunchLogManager", "set code launch mode : " + r103);
        goto L31
    L29:
        r108 = r103;
        goto L30
    L35:
        r105 = UriProtector.parse(r100);     // Catch: Exception -> L18
        if (r105.isOpaque() == true) goto L19;
        v r109 = v.a.f23889a;     // Catch: Exception -> L17
        if (r105.isOpaque() == true) goto L20;
        r103 = UriProtector.getQueryParameter(r105, AppConstants.BUNDLE_GD_LABEL);     // Catch: Exception -> L17
        goto L20
    L37:
        return;
    L5:
        r102 = r101.enableLaunchLogForAppLink();
        goto L6
    }

    public static void b(CallBackForAppLink r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (h.d() == false) goto L7;
        e(r100, mi7.b.c(r101));
        return;
    L7:
        h.e(new c(r100, r101));
    }

    public static void e(CallBackForAppLink r100, String r101) {
        if (f477412b != 0) goto L5;
    L13:
        f477411a = r101;
        f477412b = System.currentTimeMillis();
        boolean r102 = false;
    L14:
        if (r102 == false) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        r100.dealWithSchemaIsEmpty();
        f(r101);
        return;
    L19:
        r100.dealWithSchema(r101);
        f(r101);
        return;
    L5:
        if (f477413c == 0) goto L13;
        if ((System.currentTimeMillis() - f477412b) >= f477413c) goto L13;
        String r103 = f477411a;
        if (r103 == null) goto L13;
        if (r103.equals(r101) == false) goto L13;
        e.c("callbackForAppLink", "callback repeat, scheme = " + r101);
        r102 = true;
        goto L14
    }

    public static void c(fi7.b r100, int r101, String r102) {
        if (h.d() == false) goto L5;
        r100.onFailed();
        return;
    L5:
        h.e(new a(r100, r101, r102));
    }

    public static void a(String r100, String r101, ClipData r102, boolean r103) {
        if (h.d() == false) goto L5;
        d(r102, r100, r101, r103);
        return;
    L5:
        h.e(new b(r102, r100, r101, r103));
    }

    public static void d(ClipData r100, String r101, String r102, boolean r103) {
        ZlinkDependAbility r104 = p.f23879a;
        boolean r105 = false;
        if (r104 != null) goto L5;
        boolean r106 = false;
    L6:
        if (r106 == false) goto L10;
        if (r100 != null) goto L9;
        boolean r107 = true;
    L11:
        IZlinkDepend r108 = p.a();
        e.a("doCallBackForCheckClipboard", "callback dealWithClipboard hasCheckedClipboard:" + r107 + ",decodedText:" + r101 + ",fromDevicePrint:" + r103);
        if (r108 == null) goto L14;
        r105 = r108.dealWithClipboard(r107, r101, r103);
    L14:
        if (r105 == true) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r102) == true) goto L20;
        ci7.d.a(l.a(), r102, r100);
        return;
    L20:
        return;
    L9:
        r107 = false;
        goto L11
    L10:
        r107 = f.f23862a;
        goto L11
    L5:
        r106 = r104.getEnableClipboardOutside();
        goto L6
    }
}

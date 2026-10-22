package mlb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelector;
import com.ss.android.lark.imageqrcode.utils.ImageQRCodeSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.p;
import faceverify.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f514385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ArrayList<QRCodeResultInfo>> f514386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f514387c = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.a f514388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f514389b;

        public a(d.a r100, String r101) {
            this.f514388a = r100;
            this.f514389b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a r100 = this.f514388a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onError(this.f514389b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: mlb.b$b, reason: collision with other inner class name */
    public static final class RunnableC6829b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.a f514390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<QRCodeResultInfo> f514391b;

        public RunnableC6829b(d.a r100, ArrayList<QRCodeResultInfo> r101) {
            this.f514390a = r100;
            this.f514391b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a r100 = this.f514390a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f514391b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f514392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f514393b;

        public c(Bitmap r100, d.a r101) {
            this.f514392a = r100;
            this.f514393b = r101;
        }

        public final void a() {
            int r100 = com.ss.android.lark.imageqrcode.utils.a.f426671a;
            Bitmap r101 = this.f514392a;
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            Lazy r102 = ImageQRCodeSettings.f426670b;
            Bitmap r103 = p.b(r101, ((ImageQRCodeSettings.ImageQRCodeConfig) r102.getValue()).getSuperSizeSmallSide(), ((ImageQRCodeSettings.ImageQRCodeConfig) r102.getValue()).getSuperSizeBigSide());
            ArrayList<QRCodeResultInfo> r104 = ((mlb.a) ApiUtils.getApi(mlb.a.class)).decodeQRCode(r103);
            if (r104.isEmpty() == false) goto L5;
            ExecutorService r105 = b.f514385a;
            b.a(this.f514393b, "result is empty");
            return;
        L5:
            ExecutorService r106 = b.f514385a;
            b.b(this.f514393b, r104);
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
    }

    static {
        f514385a = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-ve-qrcode");
        f514386b = new ConcurrentHashMap();
        ArrayList<String> r100 = new ArrayList();
        r100.add(CancelRetainContactInfoFunctions.Token);
        r100.add("token");
        r100.add(q.KEY_TOKEN);
        f514387c = r100;
    }

    public static void c(String r100) {
        Log.i("ImageQRCodeKit", r100);
    }

    public static String d(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return "";
    L11:
        Iterator<String> r102 = f514387c.iterator();
        String r103 = r100;
    L13:
        if (r102.hasNext() == false) goto L18;
        String r104 = r102.next();
        if (r103 != null) goto L16;
        r103 = null;
        goto L13
    L16:
        r103 = StringsKt.replace$default(r103, r104, "xxx", false, 4, null);
        goto L13
    L18:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final void e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        c("scan, param:" + r100);
        Bitmap r101 = r100.f514400c;
        String r102 = r100.f514399b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        d.a r103 = r100.f514401d;
        if (r101 == null) goto L11;
        if (com.ss.android.lark.imageqrcode.utils.a.c(r101) == true) goto L11;
        f(r101, r103);
        return;
    L11:
        if (FileUtils.r(r102) == false) goto L21;
        c("scan path");
        ArrayList<QRCodeResultInfo> r104 = f514386b.get(r102);
        if (r104 == null) goto L18;
        boolean r105 = !r104.isEmpty();
        c("has cache, result is success:" + r105);
        if (r105 == false) goto L17;
        b(r103, r104);
        return;
    L17:
        a(r103, "path:" + r102 + " no has qr code");
        return;
    L18:
        c("no has cache");
        ExecutorService r106 = f514385a;
        if (r106 == null) goto L26;
        r106.execute(new mlb.c(r102, r103));
        return;
    L26:
        return;
    L21:
        a(r103, "param is invalid");
    }

    public static void a(d.a r100, String r101) {
        c("scan error:" + r101);
        new Handler(Looper.getMainLooper()).post(new a(r100, r101));
    }

    public static void b(d.a r100, ArrayList r101) {
        c("scan success, result size:" + r101.size());
        new Handler(Looper.getMainLooper()).post(new RunnableC6829b(r100, r101));
    }

    public static void f(Bitmap r100, d.a r101) {
        c("scan bitmap, width:" + r100.getWidth() + ", height:" + r100.getHeight());
        ExecutorService r102 = f514385a;
        if (r102 == null) goto L6;
        r102.execute(new c(r100, r101));
        return;
    }

    @JvmStatic
    public static final void g(Activity r100, QRCodeShowParam r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "param");
        c("show, param:" + r101);
        if (com.ss.android.lark.imageqrcode.utils.a.b(r100) == false) goto L5;
        return;
    L5:
        if (r101.isInValid() == true) goto L18;
        int r102 = ImageQRCodeSelector.f426646a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "param");
        int r103 = ImageQRCodeSelector.f426646a;
        ImageQRCodeSelector.b("launch, param:".concat(d(r101.toString())));
        if (z.e(r100) == false) goto L10;
        ImageQRCodeSelector.Launcher.MAIN_PROCESS.launch(r100, r101);
        return;
    L10:
        if (FileUtils.r(r101.getPath()) == false) goto L13;
        ImageQRCodeSelector.Launcher.NON_MAIN_PATH.launch(r100, r101);
        return;
    L13:
        if (r101.getBitmap() == null) goto L15;
        ImageQRCodeSelector.Launcher.NON_MAIN_BITMAP.launch(r100, r101);
        return;
    L15:
        ImageQRCodeSelector.b("non main process, param is invalid");
        return;
    }
}

package il7;

import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile f f490327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f490328e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f490329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f490330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f490331c;

    public interface a {
        void onError();

        void onSuccess(String r100);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    static {
        rk7.m r100 = rk7.m.f538361o;
        if (r100.e() != null) goto L5;
        File r101 = null;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "luckydog_native_pic");
        if (r102.exists() == true) goto L9;
        r102.mkdirs();
    L9:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102.getAbsolutePath());
        if (r102.getAbsolutePath().charAt(r102.getAbsolutePath().length() - 1) != '/') goto L12;
        String r104 = "";
    L13:
        r103.append(r104);
        f490328e = r103.toString();
        return;
    L12:
        r104 = HTTP.URL_DEFAULT;
        goto L13
    L5:
        r101 = r100.e().getFilesDir();
        goto L6
    }

    public static f a() {
        if (f490327d != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f490327d != null) goto L9;
        f490327d = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f490327d;
    }

    public f() {
        this.f490329a = new WeakHandler(Looper.getMainLooper(), this);
        this.f490330b = new HashMap();
        this.f490331c = new ConcurrentHashMap();
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L14;
    L9:
        Uri r101 = null;
    L10:
        if (r101 == null) goto L16;
        Uri.Builder r102 = r101.buildUpon();
        r102.authority("luckydog.snssdk.com");
        r102.scheme("https");
        return DigestUtils.md5Hex(r102.toString());
    L16:
        return null;
    L14:
        r101 = UriProtector.parse(r100);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static Uri c(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "getUriByFile file.length() = " + r100.length() + " file.exists() " + r100.exists());
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "getUriByFile file == null");
        return null;
    L5:
        if (r100.length() <= 0) goto L8;
        return Uri.fromFile(r100);
    }
}

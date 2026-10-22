package i3c;

import android.text.TextUtils;
import c3c.d;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.PushLazyLoadFeatureGatingStarted;
import com.bytedance.lark.pb.tool.v1.SetNetTypeRequest;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.utils.LarkContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f488116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f488117c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f488118d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f488119e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f488120f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f488121a;

    public class a implements g.b {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            PushLazyLoadFeatureGatingStarted r101 = PushLazyLoadFeatureGatingStarted.ADAPTER.decode(r100);     // Catch: IOException -> L13
            if (TextUtils.isEmpty(r101.user_id) == true) goto L11;
            String r102 = r101.user_id;     // Catch: IOException -> L13
            if (TextUtils.equals(r102, "absent_user") == false) goto L8;
        L9:
            r102 = "absent_user";
        L10:
            ((HashMap) b.f488118d).put(r102, Boolean.TRUE);     // Catch: IOException -> L13
            goto L11
        L8:
            if (TextUtils.isEmpty(r102) == false) goto L10;
        L11:
            Log.i("StoreRust", "setFGMoltenEnable, receive user_id: " + r101.user_id);     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            Log.e("StoreRust", "setFGMoltenEnable failed, err: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: i3c.b$b, reason: collision with other inner class name */
    public class C6226b implements SdkSender.IParser<String> {
        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final /* bridge */ /* synthetic */ String parse(byte[] r100) throws IOException {
            return "";
        }

        public C6226b() {
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f488122a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            f488122a = r100;
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f488122a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f488122a[NetworkUtils.NetworkType.MOBILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f488122a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f488122a[NetworkUtils.NetworkType.WIFI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f488117c = new HashMap();
        f488118d = new HashMap();
        f488119e = new Object();
    }

    public b(d r100) {
        LarkContext.getApplication();
        this.f488121a = r100;
    }

    public static void b(NetworkUtils.NetworkType r100) {
        int r101 = c.f488122a[r100.ordinal()];
        if (r101 != 1) goto L5;
        SetNetTypeRequest.NetType r102 = SetNetTypeRequest.NetType.ONLINE_2G;
    L17:
        SetNetTypeRequest.Builder r103 = new SetNetTypeRequest.Builder().net_type(r102);
        int r104 = f488116b;
        f488116b = r104 + 1;
        SetNetTypeRequest.Builder r105 = r103.invoke_order(Integer.valueOf(r104));
        SdkSender.asynSendRequestNonWrap(Command.SET_NET_TYPE, r105, null, new C6226b());
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = SetNetTypeRequest.NetType.ONLINE_3G;
        goto L17
    L7:
        if (r101 != 3) goto L9;
    L14:
        r102 = SetNetTypeRequest.NetType.ONLINE_4G;
        goto L17
    L9:
        if (r101 == 4) goto L14;
        if (r101 == 5) goto L13;
        r102 = SetNetTypeRequest.NetType.OFFLINE;
        goto L17
    L13:
        r102 = SetNetTypeRequest.NetType.ONLINE_WIFI;
        goto L17
    }

    public static void a(String r100, boolean r101) {
        if (TextUtils.equals(r100, "absent_user") == false) goto L5;
    L6:
        r100 = "absent_user";
    L7:
        Map<String, Boolean> r102 = f488117c;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Boolean.valueOf(r101));
        if (f488120f == false) goto L10;
        return;
    L10:
        Object r104 = f488119e;
        monitor-enter(r104);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (f488120f == false) goto L16;
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L16:
        g.e.f439875a.b(Command.PUSH_LAZY_LOAD_FEATURE_GATING_STARTED, new a());     // Catch: Throwable -> L19
        f488120f = true;     // Catch: Throwable -> L19
        Log.i("StoreRust", "RegisterMoltenPushInit");     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        goto L6
    }
}

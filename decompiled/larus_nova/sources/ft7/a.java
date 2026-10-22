package ft7;

import android.content.Context;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.nativelib.CryptoManager;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kt7.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f478778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f478779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f478780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f478781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f478782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f478783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f478784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f478785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f478786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f478787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f478788k;

    public a() {
    }

    static {
        f478778a = new a();
        f478780c = "";
        f478781d = "";
        f478782e = "";
        f478783f = "";
        f478784g = "";
        f478785h = "";
        f478786i = "";
        f478787j = "";
        f478788k = "";
    }

    public static String a() {
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == false) goto L5;
        Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("proto-version", "v2"), TuplesKt.to("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION), TuplesKt.to("sdk-version", "2"), TuplesKt.to("X-tt-Token", String.valueOf(r100.getXTTToken()))});
    L6:
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), (String) r104.getValue());
        goto L8
    L11:
        return r102.toString();
    L5:
        r101 = MapsKt.emptyMap();
        goto L6
    }

    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f478779b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (f478779b == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L18
        CryptoManager.getInstance().init(r101);     // Catch: Throwable -> L18
        LocalDataCrypto.getInstance().init(r101);     // Catch: Throwable -> L18
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L18
        r102.i("EnrollGlobal", "CryptoManager init");     // Catch: Throwable -> L18
        File r103 = r101.getExternalFilesDir(null);     // Catch: Throwable -> L18
        if (r103 == null) goto L14;
        String r104 = r103.getAbsolutePath();     // Catch: Throwable -> L18
        if (r104 == null) goto L14;
    L15:
        f478780c = r104;     // Catch: Throwable -> L18
        f478781d = f478780c + "/enroll";     // Catch: Throwable -> L18
        f478782e = f478781d + "/wakeup_sid";     // Catch: Throwable -> L18
        c.a(f478780c);     // Catch: Throwable -> L18
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L18
        r105.append(f478780c);     // Catch: Throwable -> L18
        String r106 = File.separator;     // Catch: Throwable -> L18
        r105.append(r106);     // Catch: Throwable -> L18
        r105.append("kws_silence_5s_use.wav");     // Catch: Throwable -> L18
        f478786i = r105.toString();     // Catch: Throwable -> L18
        f478783f = f478780c + r106 + "kws_second_model.bin";     // Catch: Throwable -> L18
        f478785h = f478780c + r106 + "kws_sid_model.bin";     // Catch: Throwable -> L18
        f478784g = f478780c + r106 + "lp_engine_res_cpu.bin";     // Catch: Throwable -> L18
        f478787j = f478780c + r106 + "key_info_kws_second_model.txt";     // Catch: Throwable -> L18
        f478788k = f478780c + r106 + "key_info_kws_sid_model.txt";     // Catch: Throwable -> L18
        r102.i("Global", "PATH_SPEECH_KWS_MODEL_DOUBAO=" + f478783f + " PATH_KEY_INFO_KWS_SECOND_MODEL=" + f478787j + " PATH_KEY_INFO_KWS_SID_MODEL=" + f478788k);     // Catch: Throwable -> L18
        f478779b = true;     // Catch: Throwable -> L18
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L14:
        r104 = "";
        goto L15
    }
}

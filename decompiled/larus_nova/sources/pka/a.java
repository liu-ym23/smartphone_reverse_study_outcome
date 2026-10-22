package pka;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.ArrayList;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f529681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f529682b = null;

    public a() {
    }

    static {
        f529681a = new a();
        f529682b = UriProtector.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    public static ContentProviderClient a(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static MemoryResponse b(String r100, IntentParams r101, DispatchContext r102) {
        Bundle r103 = new Bundle();
        r103.putParcelable("memoryIntentExecutorParams", r101);
        Long r104 = r102.getQuestionId();
        if (r104 == null) goto L6;
        r103.putLong("questionId", r104.longValue());
    L6:
        return c(r102.getContext(), r100, r103);
    }

    public static MemoryResponse c(Context r100, String r101, Bundle r102) {
        if (yia.a.a(r100) == MemoryServiceStatus.AVAILABLE) goto L32;
        return new MemoryResponse(407, "Memory service component disabled", 4);
    L32:
        ContentProviderClient r103 = a(r100.getContentResolver(), f529682b);     // Catch: Exception -> L29
        if (r103 == null) goto L10;
        Bundle r104 = null;
        r104 = r103.call(r101, null, r102);     // Catch: Throwable -> L14 Exception -> L16 DeadObjectException -> L18
    L20:
        r103.close();     // Catch: Exception -> L29
    L22:
        if (r104 == null) goto L38;
        r104.setClassLoader(a.class.getClassLoader());     // Catch: Exception -> L29
        MemoryResponse r105 = (MemoryResponse) r104.getParcelable("memory_response");     // Catch: Exception -> L29
        if (r105 == null) goto L37;
        return r105;
    L37:
        return new MemoryResponse(400, "internal error", 4);
    L38:
        return new MemoryResponse(400, "internal error", 4);
    L14:
        th = move-exception;
        r103.close();     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L18:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);     // Catch: Throwable -> L14
        goto L20
    L10:
        return new MemoryResponse(404, "provider client unavailable", 4);
    L29:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);
        return new MemoryResponse(404, e.getMessage(), 4);
    }

    public static MemoryResponse d(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Bundle r103 = new Bundle();
        r103.putString("doubaoGlassesStateKey", r101);
        r103.putString("doubaoGlassesStateValue", r102);
        return c(r100, "notifyDoubaoGlassesState", r103);
    }

    public static void e(Context r100, int r101, String r102, long r103, String r104, String r110, String r111, String r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "pkg");
        Intrinsics.checkNotNullParameter(r104, "appName");
        Bundle r105 = new Bundle();
        r105.putInt("notificationId", r101);
        r105.putString("pkg", r102);
        r105.putLong("postTime", r103);
        r105.putString("appName", r104);
        r105.putString("title", r110);
        r105.putString("subTitle", r111);
        r105.putString("content", r112);
        r105.putString("channel", r113);
        r105.putInt("flags", r114);
        Unit r106 = Unit.INSTANCE;
        c(r100, "receiveNotificationData", r105);
    }
}

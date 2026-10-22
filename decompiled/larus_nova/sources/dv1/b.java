package dv1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.room.api.record.LiveRecordMonitorServiceWidget;
import com.bytedance.android.livesdk.experience.record.FromType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f470142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f470143b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r210, Uri r211) {
        String[] r100 = a.f470135g;
        ALogger.d("ScreenRecordMonitorService", "Media content changed: " + r211);
        if (r211 == null) goto L7;
        String r101 = r211.toString();
        if (r101 == null) goto L7;
        String r102 = r101.toLowerCase();
    L8:
        if (r102 == null) goto L86;
        boolean r103 = false;
        if (StringsKt.contains$default(r102, "video", false, 2, null) != true) goto L87;
        a r104 = this.f470142a;
        c r105 = this.f470143b;
        if (r104.b() == true) goto L82;
        ALogger.w("ScreenRecordMonitorService", "Cannot check screen recording: missing storage permission");
        return;
    L82:
        Context r106 = r104.f470141f.get();     // Catch: Exception -> L77
        if (r106 == null) goto L18;
        ContentResolver r107 = r106.getContentResolver();     // Catch: Exception -> L77
    L20:
        if (r107 == null) goto L22;
        Cursor r110 = a.a(r107, r211, new String[]{"_data", "date_added", "_size", "_display_name"});     // Catch: Exception -> L77
    L23:
        if (r110 != null) goto L25;
        return;
    L25:
        if (r110.moveToFirst() == false) goto L90;
        int r108 = r110.getColumnIndex("_data");     // Catch: Exception -> L77
        int r111 = r110.getColumnIndex("_size");     // Catch: Exception -> L77
        int r112 = r110.getColumnIndex("date_added");     // Catch: Exception -> L77
        int r113 = r110.getColumnIndex("_display_name");     // Catch: Exception -> L77
        if (r108 == (-1)) goto L75;
        if (r112 == (-1)) goto L75;
        if (r113 == (-1)) goto L75;
        String r109 = r110.getString(r108);     // Catch: Exception -> L77
        if (r109 == null) goto L74;
        String r114 = r109.toLowerCase();     // Catch: Exception -> L77
        String r115 = r110.getString(r113);     // Catch: Exception -> L77
        if (r115 == null) goto L72;
        String r116 = r115.toLowerCase();     // Catch: Exception -> L77
        long r117 = r110.getLong(r112);     // Catch: Exception -> L77
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L38
        Object r119 = Result.m9449constructorimpl(Long.valueOf(r110.getLong(r111)));     // Catch: Throwable -> L38
    L41:
        if (Result.m9455isFailureimpl(r119) == false) goto L43;
        r119 = 0L;
    L43:
        long r120 = ((Number) r119).longValue();     // Catch: Exception -> L77
        if (((System.currentTimeMillis() / ((long) 1000)) - r117) > 30) goto L75;
        String[] r121 = a.f470135g;     // Catch: Exception -> L77
        int r122 = r121.length;     // Catch: Exception -> L77
        int r123 = 0;
    L46:
        if (r123 >= r122) goto L54;
        String r124 = r121[r123];     // Catch: Exception -> L77
        if (StringsKt.contains$default(r114, r124, false, 2, null) == true) goto L53;
        if (StringsKt.contains$default(r116, r124, false, 2, null) == true) goto L53;
        r123 = r123 + 1;     // Catch: Exception -> L77
    L53:
        r103 = true;
    L54:
        if (r103 == false) goto L75;
        if (r120 != 0) goto L66;
        if (FileUtils.getFileSize(r114) > 0) goto L66;
        if (((HashSet) r104.f470139d).contains(r211.toString()) == true) goto L75;
        Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread());     // Catch: Exception -> L77
        r105.a(FromType.ContentResolver);     // Catch: Exception -> L77
        Set<String> r125 = r104.f470139d;     // Catch: Exception -> L77
        String r126 = r211.toString();     // Catch: Exception -> L77
        HashSet r127 = (HashSet) r125;     // Catch: Exception -> L77
        if (r127.size() <= 200) goto L64;
        r127.clear();     // Catch: Exception -> L77
    L64:
        r127.add(r126);     // Catch: Exception -> L77
    L66:
        if (((HashSet) r104.f470140e).contains(r211.toString()) == true) goto L75;
        Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread());     // Catch: Exception -> L77
        r105.b(FromType.ContentResolver, r114, ((HashSet) r104.f470139d).contains(r211.toString()));     // Catch: Exception -> L77
        Set<String> r128 = r104.f470140e;     // Catch: Exception -> L77
        String r129 = r211.toString();     // Catch: Exception -> L77
        HashSet r130 = (HashSet) r128;     // Catch: Exception -> L77
        if (r130.size() <= 200) goto L70;
        r130.clear();     // Catch: Exception -> L77
    L70:
        r130.add(r129);     // Catch: Exception -> L77
    L38:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Exception -> L77
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L77
        goto L41
    L72:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L77
    L74:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L77
    L75:
        r110.close();     // Catch: Exception -> L77
        return;
    L90:
        return;
    L22:
        r110 = null;
        goto L23
    L18:
        r107 = null;
    L77:
        e = move-exception;
        ALogger.e("ScreenRecordMonitorService", "Error checking screen recording: " + e.getMessage());
        return;
    L87:
        return;
    L86:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public b(a r100, LiveRecordMonitorServiceWidget.a r101, Handler r102) {
        this.f470142a = r100;
        this.f470143b = r101;
        super(r102);
    }
}

package s81;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.k21;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.ss.android.socialbase.downloader.segment.Segment;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k21 f540947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MSManager f540948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<Context> f540949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CompositeDisposable f540950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static C7583a f540951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f540952f;

    /* JADX INFO: renamed from: s81.a$a, reason: collision with other inner class name */
    public static final class C7583a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f540953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f540954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f540955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f540956d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7583a) == false) goto L14;
            C7583a r101 = (C7583a) r100;
            if (Intrinsics.areEqual(this.f540953a, r101.f540953a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f540954b, r101.f540954b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f540955c, r101.f540955c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f540956d, r101.f540956d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            Boolean r100 = this.f540953a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.f540954b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.f540955c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.f540956d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "VolumeData(isMute=" + this.f540953a + ", isMusicActive=" + this.f540954b + ", volumeList=" + this.f540955c + ", currentTime=" + this.f540956d + ")";
        }

        public C7583a(Boolean r100, Boolean r101, List<String> r102, Long r103) {
            this.f540953a = r100;
            this.f540954b = r101;
            this.f540955c = r102;
            this.f540956d = r103;
        }
    }

    static {
        f540947a = new k21(0);
        f540952f = true;
    }

    public static void a() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
        C7583a r102 = f540951e;     // Catch: Throwable -> L27
        if (r102 == null) goto L6;
        Boolean r103 = r102.f540953a;     // Catch: Throwable -> L27
    L8:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L10;
        int r104 = 1;
    L11:
        r100.put(Segment.JsonKey.START, r104);     // Catch: Throwable -> L27
        C7583a r105 = f540951e;     // Catch: Throwable -> L27
        if (r105 == null) goto L14;
        Boolean r106 = r105.f540954b;     // Catch: Throwable -> L27
    L15:
        r100.put("bm", Intrinsics.areEqual(r106, Boolean.TRUE) ? 1 : 0);     // Catch: Throwable -> L27
        C7583a r107 = f540951e;     // Catch: Throwable -> L27
        if (r107 == null) goto L18;
        List<String> r108 = r107.f540955c;     // Catch: Throwable -> L27
    L19:
        r100.put("vol", r108);     // Catch: Throwable -> L27
        C7583a r109 = f540951e;     // Catch: Throwable -> L27
        if (r109 == null) goto L24;
        Long r110 = r109.f540956d;     // Catch: Throwable -> L27
        if (r110 == null) goto L24;
        long r111 = r110.longValue();     // Catch: Throwable -> L27
    L25:
        r100.put("ts", r111);     // Catch: Throwable -> L27
        Result.m9449constructorimpl(r100);     // Catch: Throwable -> L27
    L29:
        HashMap r112 = new HashMap();
        r112.put("live_mic", r100.toString());
        MSManager r113 = f540948b;
        if (r113 == null) goto L32;
        r113.setCustomInfo(r112, true);
    L32:
        ALogger.i("DataCollector", "flush data = " + r112);
        f540951e = null;
        return;
    L24:
        r111 = -1;
        goto L25
    L18:
        r108 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L10:
        r104 = 0;
        goto L11
    L6:
        r103 = null;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public static void b(boolean r100) {
        if (r100 == false) goto L8;
        Intent r101 = new Intent();
        Bundle r102 = new Bundle();
        r102.putCharSequence(com.heytap.mcssdk.constant.b.f276371u, String.valueOf(((IHostContext) k.n(IHostContext.class)).appId()));
        r102.putCharSequence("type", "background");
        r101.putExtra("live_tes", r102);
        r101.setAction("com.bytedance.metasec.notification.live.on");
        WeakReference<Context> r103 = f540949c;
        if (r103 == null) goto L14;
        Context r104 = r103.get();
        if (r104 == null) goto L15;
        LocalBroadcastManager.getInstance(r104).sendBroadcast(r101);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        Intent r105 = new Intent();
        r105.setAction("com.bytedance.metasec.notification.live.off");
        WeakReference<Context> r106 = f540949c;
        if (r106 == null) goto L17;
        Context r107 = r106.get();
        if (r107 == null) goto L18;
        LocalBroadcastManager.getInstance(r107).sendBroadcast(r105);
        return;
    L18:
        return;
    }
}

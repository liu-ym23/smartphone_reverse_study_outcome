package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMessageConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f478545a;

    public final void b() {
        ui6.d r100 = this.f478545a.l();
        if (r100 == null) goto L8;
        mi6.a r101 = r100.b();
        if (r101 == null) goto L9;
        r101.logout();
        return;
    L9:
        return;
    }

    public u1(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478545a = r100;
    }

    public final void e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        si6.b r101 = this.f478545a.b();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final long a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "userId");
        ui6.d r102 = this.f478545a.l();
        if (r102 == null) goto L7;
        mi6.a r103 = r102.b();
        if (r103 == null) goto L7;
        r103.s(r100, r101);
        return -2;
    L7:
        return -1;
    }

    public final long c(String r100, String r101, x r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "messageConfig");
        ui6.d r103 = this.f478545a.l();
        if (r103 == null) goto L10;
        mi6.a r104 = r103.b();
        if (r104 == null) goto L10;
        Object r105 = r102.getReal();
        if ((r105 instanceof LiveWrappedMessageConfig) == true) goto L9;
        r105 = null;
    L9:
        LiveWrappedMessageConfig r106 = (LiveWrappedMessageConfig) r105;
        r104.M(r100, r101);
        return -2;
    L10:
        return -1;
    }

    public final void d(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "uid");
        ri6.b r103 = this.f478545a.r();
        if (r103 == null) goto L6;
        r103.D(String.valueOf(r100), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r101, r102);
        return;
    }
}

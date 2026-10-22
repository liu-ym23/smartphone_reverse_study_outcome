package vs2;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.mammon.audiosdk.BuildConfig;
import jc1.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IHostPlugin.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f556979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f556980b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        this.f556980b.invoke();
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r210) {
        Intrinsics.checkNotNullParameter(r210, "packageName");
        String[] r100 = {"yuv", "c++_shared", "gaia_lib", "AGFX", "ttffmpeg", "iesapplogger", "bytenn", BuildConfig.LIBNAME, "quick", "napi", "jazz", "bytevc0", "effect", "fdk-aac", "RealXBase", "RealXAudio", "byteaudio", "vcbasekit", "bytevc1enc", "avframework"};
        IHostPlugin r110 = (IHostPlugin) k.f(IHostPlugin.class);
        int r111 = 0;
    L4:
        if (r111 >= 20) goto L11;
        String r101 = r100[r111];
        ALogger.e("LiveSoUtil", "start load library:" + r101);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L8
        r110.loadLibrary(2, this.f556979a, r110.getHostPackageName(), r101, a.class.getClassLoader());     // Catch: Throwable -> L8
    L10:
        r111 = r111 + 1;
    L8:
        th = move-exception;
        ALogger.e("LiveSoUtil", th);
        goto L10
    L11:
        boolean r102 = b.f556981a;
        b.f556981a = true;
        this.f556980b.invoke();
    }

    public a(Context r100, Function0 r101) {
        this.f556979a = r100;
        this.f556980b = r101;
    }
}

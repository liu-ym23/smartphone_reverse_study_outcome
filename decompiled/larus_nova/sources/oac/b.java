package oac;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f522590a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.videosend.tools.VideoTools.b
    public final void a(float r100) {
        b r101 = this.f522590a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.ss.android.lark.videosend.compress.b
    public final void b(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Log.i("VideoPreCompressCallback", "onCompressError:" + r100);
        b r101 = this.f522590a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void c(VideoCompressResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Log.i("VideoPreCompressCallback", "onCompressSuccess:" + r100.f444892a);
        b r101 = this.f522590a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.ss.android.lark.videosend.compress.m
    public final void e(String r100) {
        ((oac.a) ApiUtils.getApi(oac.a.class)).onPreCompressMediaStart(r100);
        b r101 = this.f522590a;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public b(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "compressPath");
        this.f522590a = r101;
    }

    @Override // com.ss.android.lark.videosend.compress.m
    public final void h(String r100, String r101) {
        ((oac.a) ApiUtils.getApi(oac.a.class)).onPreCompressMediaMerged(r100, r101);
        b r102 = this.f522590a;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }
}

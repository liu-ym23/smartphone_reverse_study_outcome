package zk8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class v implements yk8.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f572706a;

    public v(w r100) {
        this.f572706a = r100;
    }

    @Override // yk8.h
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        w r101 = this.f572706a;
        FileCardVMData r102 = r101.f572707a;
        if (r102 == null) goto L8;
        lc8.a r103 = r101.f572708b;
        if (r103 == null) goto L9;
        r103.a(r100, r102);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        w r101 = this.f572706a;
        FileCardVMData r102 = r101.f572707a;
        if (r102 == null) goto L8;
        lc8.a r103 = r101.f572708b;
        if (r103 == null) goto L9;
        r103.b(r100, r102);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        w r101 = this.f572706a;
        FileCardVMData r102 = r101.f572707a;
        if (r102 == null) goto L8;
        lc8.a r103 = r101.f572708b;
        if (r103 == null) goto L9;
        r103.a(r100, r102);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void d(final Context r100, yk8.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onStateChanged");
        FileCardVMData r102 = this.f572706a.f572707a;
        if (r102 == null) goto L12;
        int r103 = q.f572691a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "onStateChanged");
        String r104 = r102.t();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        if (StringsKt.isBlank(r104) == false) goto L10;
        FLogger.f375446a.i("FileBlockAudioController", "playAudio failed, empty url, fileName=" + r102.e());
        y.c(new p(r100));
        return;
    L10:
        n.f572677a.f(r100, r104, r101, new o(r100));
        return;
    }
}

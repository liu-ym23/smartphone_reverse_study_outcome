package en6;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.u;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements lp6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f473185a = null;

    public static final class a extends hf6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lp6.c f473186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f473187b;

        @Override // hf6.i
        public final void onCompleted(Bitmap r100) {
            this.f473186a.onCompleted(r100);
            rq6.a r101 = rq6.a.f538927a;
            r r102 = r.f473185a;
            r101.c("ImageController", "fetch completed, url = " + this.f473187b + ", bitmap = " + r100);
        }

        @Override // hf6.i
        public final void onFailed(Throwable r100) {
            this.f473186a.onFail();
            r r101 = r.f473185a;
            Objects.toString(r100);
        }

        public a(lp6.c r100, String r101) {
            this.f473186a = r100;
            this.f473187b = r101;
        }
    }

    static {
        f473185a = new r();
    }

    public r() {
    }

    @Override // lp6.d
    public final Bitmap b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        df6.c r102 = null;
        if (r101 == false) goto L12;
        return null;
    L12:
        if (df6.q.f468229c == false) goto L16;
        r102 = df6.q.f468227a.getCache();
    L16:
        return r102.b(UriProtector.parse(r100));
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // lp6.d
    public final void a(String r100, Context r101, lp6.c r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        u r103 = df6.q.d(r100);
        r103.f468277c = r101;
        r103.b("dito");
        r103.f468287m = Bitmap.Config.ARGB_8888;
        r103.e(new a(r102, r100));
    }
}

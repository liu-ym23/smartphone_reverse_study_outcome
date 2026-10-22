package m52;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h52.c> f512095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f512096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakHandler f512097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HandlerThread f512098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k<h52.c> f512099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f512100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f512101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super List<? extends h52.c>, Unit> f512102h;

    public b(k r100, Handler r101) {
        c r102 = c.f512103a;
        Intrinsics.checkNotNullParameter(r100, "renderProcessor");
        Intrinsics.checkNotNullParameter(r101, "uiHandler");
        Intrinsics.checkNotNullParameter(r102, "preProcessor");
        this.f512099e = r100;
        this.f512100f = r101;
        this.f512101g = r102;
        this.f512102h = null;
        this.f512095a = new LinkedList();
        this.f512096b = new a(this);
    }
}

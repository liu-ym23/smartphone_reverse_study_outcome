package yi1;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.bytedance.android.live.pushstream.report.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f567856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f567857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f567858c;

    public g(i r100, String r101, String r102) {
        this.f567856a = r100;
        this.f567857b = r101;
        this.f567858c = r102;
    }

    @Override // com.bytedance.android.live.pushstream.report.c
    public final void a(int r100, boolean r101, int r102, Throwable r103) {
        if (r100 == 2) goto L5;
        return;
    L5:
        if (r102 != 30001) goto L7;
    L8:
        ALogger.i("ttlive_anchor_swallow_back", "ping anchor end success");
        WeakReference<Activity> r104 = this.f567856a.f567863d;
        if (r104 == null) goto L26;
        Activity r105 = r104.get();
        if (r105 == null) goto L27;
        i r106 = this.f567856a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
        String r108 = this.f567857b;     // Catch: Throwable -> L18
        String r109 = this.f567858c;     // Catch: Throwable -> L18
        r106.getClass();     // Catch: Throwable -> L18
        String r110 = i.z(r108, r109);     // Catch: Throwable -> L18
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r110) == false) goto L16;
        a.a(r110, r105, "local");     // Catch: Throwable -> L18
    L16:
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Result.m9448boximpl(r111);
        return;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L27:
        return;
    L26:
        return;
    L7:
        if (r102 == 30003) goto L8;
    }
}

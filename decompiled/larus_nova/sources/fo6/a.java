package fo6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f478146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f478147b;

    public a(Function0<Unit> r100) {
        this.f478146a = r100;
    }

    @Override // fo6.d
    public void b(Context r100, Uri r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "intent");
        if (this.f478147b == true) goto L9;
        Function0<Unit> r103 = this.f478146a;
        if (r103 == null) goto L7;
        r103.invoke();
    L7:
        this.f478147b = true;
        return;
    }
}

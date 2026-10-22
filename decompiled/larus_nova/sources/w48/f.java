package w48;

import com.obric.assistant.reporter.ObricReporterImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements ow3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v48.g f558260a;

    public f(ObricReporterImpl.c r100) {
        this.f558260a = r100;
    }

    @Override // ow3.b
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "flatParams");
        v48.g r102 = this.f558260a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.a(r100, r101);
    }

    @Override // ow3.b
    public final void b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "flatParams");
        v48.g r102 = this.f558260a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.b(r100, r101);
    }
}

package un5;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f550808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f550809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f550810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f550811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f550812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f550813j;

    public final Integer getType() {
        return this.f550809f;
    }

    public k(Context r100, String r101, Integer r102, Integer r103, String r104, String r105, String r106, String r107, a.InterfaceC7903a r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        super(r100, r104, r110);
        this.f550808e = r101;
        this.f550809f = r102;
        this.f550810g = r103;
        this.f550811h = r105;
        this.f550812i = r106;
        this.f550813j = r107;
    }
}

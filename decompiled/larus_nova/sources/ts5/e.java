package ts5;

import com.bytedance.ee.lark.nativecomponent.service.NativeRenderType;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NativeRenderType f547399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f547400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OPTrace f547401f;

    public final String toString() {
        return "(id='" + this.f547396a + "', viewType='" + this.f547397b + "', tag=" + this.f547398c + ", renderType=" + this.f547399d + ')';
    }

    public e(String r100, String r101, String r102, NativeRenderType r103, List<f> r104, OPTrace r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "viewType");
        Intrinsics.checkNotNullParameter(r103, "renderType");
        Intrinsics.checkNotNullParameter(r105, "oPTrace");
        this.f547396a = r100;
        this.f547397b = r101;
        this.f547398c = r102;
        this.f547399d = r103;
        this.f547400e = r104;
        this.f547401f = r105;
    }
}

package eq6;

import com.bytedance.locallife.dito.core.update.Op;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<BaseDitoModel<?>> f473498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f473499e;

    public a() {
        throw null;
    }

    public a(Op r100, String r101, int r102, List r103) {
        Intrinsics.checkNotNullParameter(r100, "op");
        Intrinsics.checkNotNullParameter(r101, "containerType");
        super(r100);
        this.f473496b = r101;
        this.f473497c = r102;
        this.f473498d = r103;
        this.f473499e = null;
    }
}

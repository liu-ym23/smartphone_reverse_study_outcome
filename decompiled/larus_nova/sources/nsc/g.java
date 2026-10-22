package nsc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import io.noties.markwon.core.CoreProps;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.x;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f520443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Float> f520444c;

    @Override // lsc.x
    public final Object a(lsc.h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        return new io.noties.markwon.core.spans.m(r100.f510591a, CoreProps.f492264f.b(r101).intValue(), this.f520442a, this.f520443b, this.f520444c);
    }

    public g(int r100, Integer r101, Map<Integer, Float> r102) {
        this.f520442a = r100;
        this.f520443b = r101;
        this.f520444c = r102;
    }
}

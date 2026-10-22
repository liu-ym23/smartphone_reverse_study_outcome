package wsc;

import android.graphics.Rect;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.u;

/* JADX INFO: loaded from: classes5.dex */
public class j extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f561144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f561145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f561146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f561147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f561148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.business.markdown.api.extplugin.image.a f561149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f561150g;

    @Override // lsc.x
    public Object a(lsc.h r110, t r111) {
        Intrinsics.checkNotNullParameter(r110, "configuration");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        String r100 = n.f561168a.b(r111);
        o r101 = n.f561170c.a(r111);
        if (r101 == null) goto L5;
    L8:
        Integer r102 = n.f561171d.a(r111);
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        Integer r104 = n.f561172e.a(r111);
        if (r104 == null) goto L15;
        int r105 = r104.intValue();
        Integer r106 = this.f561146c;
        if (r106 == null) goto L25;
        int r112 = r106.intValue();
        Integer r107 = this.f561147d;
        if (r107 == null) goto L21;
        int r113 = r107.intValue();
    L22:
        msc.s r108 = r110.f510591a;
        u r109 = (u) r111;
        ((Boolean) r109.b(n.f561169b, Boolean.FALSE)).booleanValue();
        return new l(r103, r105, r100, r108, r101, this.f561144a, this.f561145b, r112, r113, this.f561148e, this.f561149f, this.f561150g);
    L21:
        r113 = 0;
        goto L22
    L25:
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L5:
        if (this.f561148e != null) goto L8;
        return Unit.INSTANCE;
    }

    public j(Integer r100, int r101, Integer r102, Integer r103, Rect r104, com.larus.business.markdown.api.extplugin.image.a r105, Map<String, ? extends Object> r106) {
        this.f561144a = r100;
        this.f561145b = r101;
        this.f561146c = r102;
        this.f561147d = r103;
        this.f561148e = r104;
        this.f561149f = r105;
        this.f561150g = r106;
    }
}

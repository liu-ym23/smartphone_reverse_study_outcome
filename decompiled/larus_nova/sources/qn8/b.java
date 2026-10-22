package qn8;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.standarduikit.splitline.view.SplitLineView;
import jc8.d;
import jc8.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pn8.c;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends jc8.b<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f534114d;

    @Override // jc8.b
    public final String c() {
        return "SpliteLineBlockHolder";
    }

    public b() {
    }

    @Override // jc8.b
    public final d f(jc8.a r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return e.d(r101);
    }

    @Override // jc8.b
    public final void g(jc8.a r100) {
        Intrinsics.checkNotNullParameter((a) r100, "blockModel");
        sn8.a r101 = new sn8.a(new Pair(0, 0));
        c r102 = this.f534114d;
        if (r102 == null) goto L18;
        Intrinsics.checkNotNullParameter(r101, "vmData");
        sn8.b r103 = (sn8.b) r102.f529986c.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "vmData");
        r103.f542671a = r101;
        sn8.a r104 = ((sn8.b) r102.f529986c.getValue()).f542671a;
        if (r104 != null) goto L7;
        rn8.a r105 = new rn8.a(null);
    L8:
        ((sn8.b) r102.f529986c.getValue()).getClass();
        rn8.b r106 = new rn8.b();
        SplitLineView r107 = (SplitLineView) r102.f529985b.getValue();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r105, "input");
        Intrinsics.checkNotNullParameter(r106, BdpAppEventConstant.PARAMS_OUTPUT);
        Pair<Integer, Integer> r108 = r105.f538693a;
        if (r108 == null) goto L11;
        int r109 = r108.getFirst().intValue();
    L12:
        Pair<Integer, Integer> r110 = r105.f538693a;
        if (r110 == null) goto L15;
        int r111 = r110.getSecond().intValue();
    L16:
        r107.setPadding(0, r109, 0, r111);
        return;
    L15:
        r111 = 0;
        goto L16
    L11:
        r109 = 0;
        goto L12
    L7:
        r105 = new rn8.a(r104.f542670a);
        goto L8
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        c r101 = new c(r100.getContext());
        this.f534114d = r101;
        return (SplitLineView) r101.f529985b.getValue();
    }
}

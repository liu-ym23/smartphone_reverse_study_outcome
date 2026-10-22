package com.relax.relaxframework;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.rts.foundation.Promise;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class RxInputBaseImpl extends RxAttributedElementImpl {
    public final void blur() {
        RxAttributedElementImpl.j0(this, "blur", null, 6);
    }

    public final void focus() {
        RxAttributedElementImpl.j0(this, ButtonColorBean.StateFocus, null, 6);
    }

    public final void p(final Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        Promise r101 = m("getValue", null, "{\"type\":\"tuple\",\"class\":\"[int32, string]\",\"fields\":{\"0\":{\"type\":\"primitive\",\"class\":\"int32\"},\"1\":{\"type\":\"primitive\",\"class\":\"string\"}}}");
        Function1<Object[], Object[]> r102 = new RxInputBaseImpl$getValue$1(r100);
        int r103 = Promise.f267559e;
        r101.c(r102, null);
        return;
    L5:
        Promise r104 = m("getValue", null, null);
        Function1<Object, Unit> r105 = new RxInputBaseImpl$getValue$2(r100);
        int r106 = Promise.f267559e;
        r104.c(r105, null);
    }

    public final void setValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        LinkedHashMap r101 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r101, "value", r100);
        RxAttributedElementImpl.j0(this, "setValue", r101, 4);
    }

    public RxInputBaseImpl(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "tagName");
        super(r100, r101);
    }
}

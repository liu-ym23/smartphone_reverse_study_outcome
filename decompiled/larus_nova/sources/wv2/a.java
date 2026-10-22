package wv2;

import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import h70.b;
import j70.f;
import j70.i;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends i<e0> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ((IAnswerQuestionService) k.n(IAnswerQuestionService.class)).getAnswerQuestionServiceWidget();
    }

    public a() {
    }

    @Override // j70.d
    public final boolean B(b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final f C(b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d.a.f467504e0;
    }
}

package m70;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.view.ViewElement;
import j70.e;
import j70.m;
import k70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends b<m> {
    public a() {
    }

    @Override // k70.b
    public final Element a(e r100) {
        m r101 = (m) r100;
        Intrinsics.checkNotNullParameter(r101, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        return new ViewElement(b(), r101);
    }
}

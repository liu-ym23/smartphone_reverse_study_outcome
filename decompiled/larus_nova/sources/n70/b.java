package n70;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.merge.MergeServiceWidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.merge.MergeWidgetElement;
import j70.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends k70.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.livesdk.preview.merge.a f518194b;

    public b() {
        Intrinsics.checkNotNullParameter(null, "widgetManager");
        this.f518194b = null;
    }

    @Override // k70.b
    public final Element a(e r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        if (r101.i() == false) goto L6;
        return new MergeServiceWidgetElement(this.f518194b, r101, b());
    L6:
        return new MergeWidgetElement(this.f518194b, r101, b());
    }
}

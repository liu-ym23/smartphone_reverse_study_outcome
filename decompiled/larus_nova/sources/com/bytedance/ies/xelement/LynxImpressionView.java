package com.bytedance.ies.xelement;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/LynxImpressionView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/ui/view/a;", "", "index", "", "impressionPercent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-scroll_release"}, k = 1, mv = {1, 6, 0})
public class LynxImpressionView extends UISimpleView<com.lynx.tasm.behavior.ui.view.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f249604c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249606b;

    public static final class a {
    }

    static {
    }

    public LynxImpressionView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.lynx.tasm.behavior.ui.view.a(r100);
    }

    @LynxProp(defaultInt = 0, name = "impression-percent")
    public void impressionPercent(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, ? extends EventsListener> r100) {
        super.setEvents(r100);
        Objects.toString(r100);
        if (r100 == null) goto L6;
        this.f249605a = r100.containsKey("impression");
        this.f249606b = r100.containsKey("exit");
        return;
    }
}

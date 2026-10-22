package com.lynx.tasm.behavior.ui.frame;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import java.util.HashMap;
import y6a.a;
import y6a.b;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: classes32.dex */
@LynxShadowNode(tagName = "frame")
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.frame")
public class FrameShadowNode extends CustomLayoutShadowNode implements e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f382494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f382495x;

    @Override // y6a.e
    public final void d(b r100, a r101) {
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void e() {
        h(this);
        super.e();
    }

    public FrameShadowNode() {
    }

    @Override // y6a.e
    public final k b(j r100, g r101) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r102 = new HashMap();
        r102.put("input_width", String.valueOf(r100.f566410a));
        r102.put("input_height", String.valueOf(r100.f566412c));
        r102.put("input_width_mode", r100.f566411b.name());
        r102.put("input_height_mode", r100.f566413d.name());
        TraceEvent.beginSection("FrameShadowNode.measure", r102);
    L5:
        int r103 = this.f382494w;
        if (r103 == 0) goto L8;
    L10:
        MeasureMode r104 = r100.f566411b;
        MeasureMode r105 = MeasureMode.EXACTLY;
        if (r104 != r105) goto L13;
        float r106 = r100.f566410a;
    L15:
        if (r100.f566413d != r105) goto L17;
        float r107 = r100.f566412c;
    L18:
        k r108 = new k(r106, r107);
    L20:
        if (TraceEvent.isTracingStarted() == false) goto L22;
        HashMap r109 = new HashMap();
        r109.put("width", String.valueOf(r108.f566414a[0]));
        r109.put("height", String.valueOf(r108.f566414a[1]));
        TraceEvent.endSection(0, "FrameShadowNode.measure", r109);
    L22:
        return r108;
    L17:
        r107 = this.f382495x;
        goto L18
    L13:
        r106 = r103;
        goto L15
    L8:
        if (this.f382495x != 0) goto L10;
        r108 = new k(r100.f566410a, r100.f566412c);
        goto L20
    }
}

package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.event.EventsListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class v0 extends LayoutContext {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LynxContext f383205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y6a.f f383206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f383207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0 f383208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayoutNodeManager f383209h;

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void scheduleLayout() {
        if (this.f381877b == false) goto L5;
        return;
    L5:
        this.f383206e.a(new u0(this));
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void detachNativePtr() {
        super.detachNativePtr();
        w0 r100 = this.f383208g;
        if (r100 == null) goto L12;
        SparseArray<ShadowNode> r101 = r100.f383214a;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.size() <= 0) goto L15;
        int r102 = 0;
    L10:
        if (r102 >= r101.size()) goto L16;
        ShadowNode r103 = r101.valueAt(r102);
        r103.f382222o = true;
        r103.t();
        r103.f382202a = null;
        r102 = r102 + 1;
        goto L10
    L16:
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void attachLayoutNodeManager(long r100) {
        this.f383209h.f381879a = r100;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void destroyNodes(int[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        int r103 = r100[r102];
        w0 r104 = this.f383208g;
        ShadowNode r105 = r104.f383214a.get(r103);
        r104.f383214a.remove(r103);
        if (r105 == null) goto L7;
        r105.f382222o = true;
        r105.t();
        r105.f382202a = null;
    L7:
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayoutBefore(int r100) {
        this.f383208g.a(r100).g();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final Object getExtraBundle(int r100) {
        ShadowNode r101 = this.f383208g.a(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.m();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void setFontFaces(ReadableMap r100) {
        this.f383205d.setFontFaces(r100.getMap("fontfaces"));
    }

    public v0(LynxContext r100, c r101, y6a.f r102) {
        this.f383205d = r100;
        this.f383208g = new w0();
        this.f383207f = r101;
        this.f383206e = r102;
        this.f383209h = new LayoutNodeManager();
        a(this);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void insertNode(int r100, int r101, int r102) {
        ShadowNode r103 = this.f383208g.a(r100);
        ShadowNode r104 = this.f383208g.a(r101);
        if (r103 == null) goto L18;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r102 != (-1)) goto L9;
    L10:
        r102 = r103.l();
    L16:
        r103.j(r104, r102);     // Catch: ArrayIndexOutOfBoundsException -> L13
    L14:
        r103.q();
        return;
    L13:
        LLog.w("ShadowNodeOwner", "Add child out of bounds, parentSignature: " + r100 + ", index: " + r102 + ", childSignature: " + r101);
        goto L14
    L9:
        if (r102 <= r103.l()) goto L16;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void removeNode(int r100, int r101, int r102) {
        ShadowNode r103 = this.f383208g.a(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        ShadowNode r104 = this.f383208g.a(r101);
        int r105 = -1;
        if (r104 == null) goto L11;
        ArrayList<ShadowNode> r106 = r103.f382218k;
        if (r106 == null) goto L11;
        r105 = r106.indexOf(r104);
    L11:
        if (r105 < 0) goto L17;
        r102 = r105;
    L17:
        r103.u(r102);     // Catch: ArrayIndexOutOfBoundsException -> L15
        return;
    L15:
        LLog.w("ShadowNodeOwner", "Remove child out of bounds, parentSignature: " + r100 + ", index: " + r102 + ", childSignature: " + r101);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void updateProps(int r100, PropBundle r101, ReadableMapBuffer r102) {
        ReadableArray r103 = null;
        if (r101 == null) goto L5;
        ReadableMap r104 = r101.getProps();
    L6:
        if (r101 == null) goto L8;
        r103 = r101.getEventHandlers();
    L8:
        ShadowNode r105 = this.f383208g.a(r100);
        if (r105 == null) goto L16;
        if (r104 == null) goto L12;
        r105.B(new x0(r104, r102));
    L12:
        if (r103 == null) goto L17;
        r105.x(EventsListener.convertEventListeners(r103));
        return;
    L17:
        return;
    L16:
        throw new RuntimeException("Trying to update non-existent view with tag " + r100);
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final int createNode(int r100, String r101, PropBundle r102, ReadableMapBuffer r103, boolean r104) {
        ReadableArray r105 = null;
        if (r102 == null) goto L5;
        ReadableMap r106 = r102.getProps();
    L6:
        if (r102 == null) goto L8;
        r105 = r102.getEventHandlers();
    L8:
        ShadowNode r107 = this.f383207f.c(r101).createShadowNode();
        if (r107 == null) goto L11;
        int r108 = 4;
    L14:
        r107.f382203b = r100;
        r107.f382217j = r101;
        r107.w(this.f383205d);
        r107.f382202a = this.f383209h;
        r107.x(EventsListener.convertEventListeners(r105));
        this.f383208g.f383214a.put(r107.f382203b, r107);
        if (r106 == null) goto L18;
        r107.B(new x0(r106, r103));
    L18:
        if (this.f381877b == true) goto L21;
        r107.e();
    L21:
        if (r107.p() == false) goto L23;
        r108 = r108 | 2;
    L23:
        if (r104 == true) goto L25;
        return r108;
    L25:
        if (r107.z() == true) goto L27;
        return r108;
    L27:
        return r108 | 32;
    L11:
        r108 = 1;
        if (r104 == false) goto L28;
        r107 = new NativeLayoutNodeRef();
        goto L14
    L28:
        return 1;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayout(int r100, int r101, int r102, int r103, int r104) {
        this.f383208g.a(r100).f(r103, r104);
    }
}

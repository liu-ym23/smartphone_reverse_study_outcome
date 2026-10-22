package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import java.util.Map;
import y6a.b;
import y6a.g;
import y6a.j;
import y6a.k;
import y6a.n;
import z6a.h;

/* JADX INFO: loaded from: classes32.dex */
public class NativeLayoutNodeRef extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f382212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f382213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f382214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f382215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f382216z;

    public static class a extends h {
        public a(int r100, Map<String, EventsListener> r101, EventTarget.EnableStatus r102, boolean r103, EventTarget.EnableStatus r104, EventTarget.PointerEventsValue r105, ReadableMap r106) {
            super(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean r() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean z() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final h A() {
        return new a(this.f382203b, this.f382223p, this.f382224q, this.f382228u, this.f382225r, this.f382226s, this.f382227t);
    }

    public NativeLayoutNodeRef() {
    }

    public final void C(b r100) {
        if (this.f382222o == false) goto L6;
        v("alignNativeNode for null, tag: ".concat(n()));
        return;
    L6:
        this.f382202a.a(this.f382203b, r100.f566404b, r100.f566403a);
    }

    @LynxProp(name = "idSelector")
    public void setIdSelector(String r100) {
        this.f382216z = r100;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r100) {
        y(r100);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        this.f382220m = r100;
    }

    public final k D(g r110, j r111) {
        if (this.f382222o == false) goto L6;
        v("measureNativeNode for null, tag: ".concat(n()));
        return new k(0.0f, 0.0f);
    L6:
        n r100 = this.f382221n;
        if (r100 != null) goto L9;
    L12:
        long r112 = this.f382202a.g(this.f382203b, r111.f566410a, r111.f566411b.intValue(), r111.f566412c, r111.f566413d.intValue(), r110.f566409a);
        return new k(Float.intBitsToFloat((int) ((r112 >> 32) & (-1))), Float.intBitsToFloat((int) (r112 & (-1))));
    L9:
        if (r100.f566415a != 1) goto L12;
        int[] r113 = this.f382202a.h(this.f382203b, r111.f566410a, r111.f566411b.intValue(), r111.f566412c, r111.f566413d.intValue(), r110.f566409a);
        return new k(r113[0], r113[1], r113[2]);
    }

    public final k E(g r100, j r101) {
        if (this.f382222o == false) goto L6;
        v("measureNativeNode for null, tag: ".concat(n()));
        return new k(0.0f, 0.0f);
    L6:
        int[] r102 = this.f382202a.h(this.f382203b, r101.f566410a, r101.f566411b.intValue(), r101.f566412c, r101.f566413d.intValue(), r100.f566409a);
        return new k(r102[0], r102[1], r102[2]);
    }
}

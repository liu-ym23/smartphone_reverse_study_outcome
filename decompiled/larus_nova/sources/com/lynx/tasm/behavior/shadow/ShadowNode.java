package com.lynx.tasm.behavior.shadow;

import com.bytedance.ies.xelement.text.emoji.LynxEmojiShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import f6a.a;
import java.util.ArrayList;
import java.util.Map;
import y6a.n;
import z6a.h;

/* JADX INFO: loaded from: classes32.dex */
public class ShadowNode extends LayoutNode {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f382217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<ShadowNode> f382218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShadowNode f382219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxContext f382220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f382221n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f382222o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, EventsListener> f382223p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public EventTarget.EnableStatus f382224q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EventTarget.EnableStatus f382225r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EventTarget.PointerEventsValue f382226s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ReadableMap f382227t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f382228u;

    public Object m() {
        return null;
    }

    public boolean p() {
        return this instanceof LynxInlineTruncationShadowNode;
    }

    public void s() {
    }

    public void t() {
    }

    public boolean z() {
        return this instanceof LynxEmojiShadowNode;
    }

    public h A() {
        return new h(this.f382203b, this.f382223p, this.f382224q, this.f382228u, this.f382225r, this.f382226s, this.f382227t);
    }

    public final LynxContext getContext() {
        LynxContext r100 = this.f382220m;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new AssertionError();
    }

    public final int l() {
        ArrayList<ShadowNode> r100 = this.f382218k;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public final String n() {
        String r100 = this.f382217j;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new AssertionError();
    }

    public void q() {
        if (this.f382222o == false) goto L6;
        return;
    L6:
        if (p() == true) goto L12;
        if (this.f382206e == true) goto L24;
        this.f382206e = true;
        this.f382202a.f(this.f382203b);
        return;
    L24:
        return;
    L12:
        if (p() == true) goto L14;
        ShadowNode r100 = this;
    L19:
        if (r100 == null) goto L25;
        r100.q();
        return;
    L25:
        return;
    L14:
        r100 = this.f382219l;
    L15:
        if (r100 == null) goto L19;
        if (r100.p() == false) goto L19;
        r100 = r100.f382219l;
        goto L15
    }

    public boolean r() {
        Map<String, EventsListener> r100 = this.f382223p;
        if (r100 != null) goto L5;
    L6:
        EventTarget.EnableStatus r101 = this.f382224q;
        EventTarget.EnableStatus r102 = EventTarget.EnableStatus.Undefined;
        if (r101 == r102) goto L9;
    L14:
        return true;
    L9:
        if (this.f382225r != r102) goto L14;
        if (this.f382226s != EventTarget.PointerEventsValue.Unset) goto L14;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L14;
        goto L6
    }

    public ShadowNode() {
        this.f382227t = new JavaOnlyMap();
        EventTarget.EnableStatus r100 = EventTarget.EnableStatus.Undefined;
        this.f382224q = r100;
        this.f382225r = r100;
        this.f382226s = EventTarget.PointerEventsValue.Unset;
        this.f382228u = true;
    }

    public final boolean o() {
        if (p() == true) goto L13;
        boolean r100 = this.f382206e;
        if (r100 == false) goto L8;
        return r100;
    L8:
        if (this.f382202a.e(this.f382203b) == false) goto L11;
        this.f382206e = true;
    L11:
        return this.f382206e;
    L13:
        if (p() == true) goto L15;
        ShadowNode r101 = this;
    L20:
        if (r101 != null) goto L22;
        return false;
    L22:
        return r101.o();
    L15:
        r101 = this.f382219l;
    L16:
        if (r101 == null) goto L20;
        if (r101.p() == false) goto L20;
        r101 = r101.f382219l;
        goto L16
    }

    public String toString() {
        return this.f382217j;
    }

    public final void B(x0 r100) {
        PropsUpdater.d(this, r100);     // Catch: Exception -> L4
        s();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("lynx_ShadowNode", "Catch exception for tag: ".concat(n()));
        getContext().handleException(e);
    }

    public final ShadowNode k(int r100) {
        ArrayList<ShadowNode> r101 = this.f382218k;
        if (r101 == null) goto L7;
        return (ShadowNode) ListProtector.get(r101, r100);
    L7:
        throw new ArrayIndexOutOfBoundsException("Index " + r100 + " out of bounds: node has no children");
    }

    @LynxProp(name = "dataset")
    public void setDataset(ReadableMap r100) {
        this.f382227t = r100;
    }

    @LynxProp(name = "event-through")
    public void setEventThrough(a r100) {
        if (r100 != null) goto L13;
        this.f382225r = EventTarget.EnableStatus.Undefined;
    L13:
    L10:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.f382225r = EventTarget.EnableStatus.Undefined;
        return;
    L5:
        if (r100.asBoolean() == false) goto L7;
        EventTarget.EnableStatus r101 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L10
    L8:
        this.f382225r = r101;     // Catch: Throwable -> L10
        return;
    L7:
        r101 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L10
        goto L8
    }

    @LynxProp(name = "enable-touch-pseudo-propagation")
    public void setEventThroughPropagation(a r100) {
        if (r100 != null) goto L11;
        this.f382228u = true;
        return;
    L11:
        this.f382228u = r100.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.f382228u = true;
    }

    @LynxProp(name = "ignore-focus")
    public void setIgnoreFocus(a r100) {
        if (r100 != null) goto L14;
        this.f382224q = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.f382224q = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r100.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r101 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.f382224q = r101;     // Catch: Throwable -> L11
        return;
    L8:
        r101 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "pointer-events")
    public void setPointerEvents(int r100) {
        if (r100 >= EventTarget.PointerEventsValue.Auto.ordinal()) goto L5;
        return;
    L5:
        if (r100 >= EventTarget.PointerEventsValue.Unset.ordinal()) goto L9;
        this.f382226s = EventTarget.PointerEventsValue.values()[r100];
        return;
    }

    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r100) {
        if (this.f382220m.isTextRefactorEnabled() == true) goto L6;
        y(r100);
        return;
    }

    public final void u(int r100) {
        ArrayList<ShadowNode> r101 = this.f382218k;
        if (r101 == null) goto L7;
        ((ShadowNode) ListProtector.remove(r101, r100)).f382219l = null;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("Index " + r100 + " out of bounds: node has no children");
    }

    public final void v(String r100) {
        if (this.f382220m == null) goto L6;
        LynxError r101 = new LynxError(60401, r100, "", "error");
        this.f382220m.handleLynxError(r101);
        return;
    }

    public void w(LynxContext r100) {
        this.f382220m = r100;
    }

    public void x(Map<String, EventsListener> r100) {
        this.f382223p = r100;
    }

    public final void y(ReadableArray r100) {
        if (this.f382221n != null) goto L6;
        this.f382221n = new n();
    L6:
        if (r100 != null) goto L8;
    L11:
        n r101 = this.f382221n;
        r101.f566415a = 0;
        r101.f566416b = 0.0f;
    L12:
        q();
        return;
    L8:
        if (r100.size() < 2) goto L11;
        n r102 = this.f382221n;
        r102.f566415a = r100.getInt(0);
        n r103 = this.f382221n;
        r103.f566416b = (float) r100.getDouble(1);
        goto L12
    }

    public void j(ShadowNode r100, int r101) {
        if (r100.f382219l != null) goto L10;
        if (this.f382218k != null) goto L7;
        this.f382218k = new ArrayList(4);
    L7:
        ListProtector.add(this.f382218k, r101, r100);
        r100.f382219l = this;
        return;
    L10:
        throw new RuntimeException("Tried to add child that already has a parent! Remove it from its parent first.");
    }
}

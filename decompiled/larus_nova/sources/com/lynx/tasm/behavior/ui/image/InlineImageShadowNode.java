package com.lynx.tasm.behavior.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import d7a.f;

/* JADX INFO: loaded from: classes32.dex */
public class InlineImageShadowNode extends AbsInlineImageShadowNode {
    public a Q;

    public class a extends f {

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        public final /* synthetic */ InlineImageShadowNode f382559h2;

        @Override // d7a.f
        public final void f() {
            this.f382559h2.q();
        }

        public a(InlineImageShadowNode r100, LynxContext r101) {
            this.f382559h2 = r100;
            super(r101);
        }

        @Override // d7a.f
        public final void k(int r100, int r101) {
            this.f382559h2.R(r100, r101);
        }

        @Override // d7a.f
        public final void j(LynxError r100, int r101, int r102) {
            this.f382559h2.Q(r100.getSummaryMessage());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineImageShadowNode f382560a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f382560a.Q;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.d();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(InlineImageShadowNode r100) {
            this.f382560a = r100;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a O() {
        float r100 = this.f382209h.c();
        float r101 = this.f382209h.a();
        return new d7a.b((int) Math.ceil(r100), (int) Math.ceil(r101), this.f382209h.b(), this.Q);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void s() {
        this.Q.B();
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
    }

    public InlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r100) {
        this.Q.u(r100);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r100) {
        this.Q.v(r100);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        super.w(r100);
        this.Q = new a(this, this.f382220m);
    }
}

package com.bytedance.lynx.tasm.ui.imageloader;

import android.graphics.drawable.Drawable;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public class InlineImageShadowNode extends AbsInlineImageShadowNode {
    public String Q;
    public String R;
    public b17.b S;

    public class a implements com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f264997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f264998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InlineImageShadowNode f264999c;

        @Override // com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a
        public final void a(Drawable r100, Throwable r101) {
            InlineImageShadowNode r102 = (InlineImageShadowNode) this.f264997a.get();
            if (r102 != null) goto L5;
            return;
        L5:
            String r103 = this.f264999c.Q;
            if (r103 != null) goto L11;
            if (this.f264998b == null) goto L13;
            return;
        L13:
            if (r100 != null) goto L19;
            int r104 = u7a.b.b(u7a.b.a(r101));
            if (r101 != null) goto L17;
            String r105 = "unknown";
        L18:
            this.f264999c.Q(r105);
            this.f264999c.getContext().reportResourceError(this.f264999c.Q, "image", new LynxError(r104, "Failed to load image, get null drawable from response. The reason is: " + r105, "", "error"));
        L20:
            b17.a r106 = r102.S.f16934q;
            r106.f16929a = r100;
            if (r100 == null) goto L23;
            r100.setCallback(r106.getCallback());
        L23:
            r106.a();
            return;
        L17:
            r105 = r101.getMessage();
            goto L18
        L19:
            this.f264999c.R(r100.getIntrinsicWidth(), r100.getIntrinsicHeight());
            goto L20
        L11:
            if (r103.equals(this.f264998b) == true) goto L13;
        }

        public a(InlineImageShadowNode r100, WeakReference r101, String r102) {
            this.f264999c = r100;
            this.f264997a = r101;
            this.f264998b = r102;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a O() {
        float r100 = this.f382209h.c();
        float r101 = this.f382209h.a();
        b17.b r102 = new b17.b((int) Math.ceil(r100), (int) Math.ceil(r101), this.f382209h.b());
        this.S = r102;
        b17.a r103 = r102.f16934q;
        r103.f16930b = this.R;
        r103.a();
        T();
        return this.S;
    }

    public final void T() {
        float r100 = this.f382209h.c();
        float r101 = this.f382209h.a();
        if (this.Q != null) goto L5;
        return;
    L5:
        if (r100 > 0.0f) goto L7;
        return;
    L7:
        if (r101 <= 0.0f) goto L16;
        com.bytedance.lynx.tasm.ui.imageloader.a.b r102 = com.bytedance.lynx.tasm.ui.imageloader.a.f265015a;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.a(getContext(), "InlineImage_" + r100 + " " + r101 + this.R, this.Q, r100, r101, null, new a(this, new WeakReference(this), this.Q));
        return;
    }

    public InlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r100) {
        this.R = r100;
        b17.b r101 = this.S;
        if (r101 == null) goto L6;
        b17.a r102 = r101.f16934q;
        r102.f16930b = r100;
        r102.a();
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r100) {
        this.Q = d7a.a.b(getContext(), r100, false);
        T();
    }
}

package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends LarkLinkPlugin {

    public static final class a extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.widget.f, com.ss.android.lark.keyboard.edittext2.span.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f429197a;

        public a(int r100) {
            this.f429197a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            if (r100 == null) goto L5;
            r100.setColor(this.f429197a);
            return;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.span.k
        public final k.a e(int r100, int r101, Editable r102) {
            return com.ss.android.lark.keyboard.edittext2.span.f.a.a(this, r100, r101, r102);
        }
    }

    public g() {
    }

    @Override // com.ss.android.lark.coremd.facade.plugins.a1, com.ss.android.lark.coremd.base.parse.g
    public final void c(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(n.class, new h());
    }
}

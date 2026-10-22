package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a extends com.ss.android.lark.coremdbiz.facade.plugins.a {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.mdeditor.plugins.a$a, reason: collision with other inner class name */
    public static final class C5097a extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.span.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f429194a;

        public C5097a(int r100) {
            this.f429194a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            if (r100 == null) goto L5;
            r100.setColor(this.f429194a);
            return;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.span.k
        public final k.a e(int r100, int r101, Editable r102) {
            return com.ss.android.lark.keyboard.edittext2.span.f.a.a(this, r100, r101, r102);
        }
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.plugins.a, com.ss.android.lark.coremd.base.parse.g
    public final void c(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(eab.a.class, new b());
    }
}

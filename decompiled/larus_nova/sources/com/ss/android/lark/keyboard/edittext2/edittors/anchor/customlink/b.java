package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.span.k;
import com.ss.android.lark.keyboard.edittext2.widget.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends CharacterStyle implements f, com.ss.android.lark.keyboard.edittext2.span.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f428982a;

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f428982a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L5;
        r100.setColor(UDColorUtils.getColor(this.f428982a, R.color.text_link_normal));
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        return com.ss.android.lark.keyboard.edittext2.span.f.a.a(this, r100, r101, r102);
    }
}

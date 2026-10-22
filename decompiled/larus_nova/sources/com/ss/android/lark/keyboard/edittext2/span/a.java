package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends CharacterStyle implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f429205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f429206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f429207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f429208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f429209f;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        int r101 = this.f429209f;
        if (r101 == 0) goto L7;
        if (r100 == null) goto L17;
        r100.setColor(r101);
        return;
    L17:
        return;
    L7:
        if (this.f429208e == false) goto L9;
    L14:
        if (r100 == null) goto L21;
        r100.setColor(UDColorUtils.getColor(this.f429204a, R.color.imtoken_at_user_name_color));
        return;
    L21:
        return;
    L9:
        if (this.f429207d == false) goto L11;
    L12:
        if (r100 == null) goto L19;
        r100.setColor(UDColorUtils.getColor(this.f429204a, R.color.text_title));
        return;
    L19:
        return;
    L11:
        if (this.f429206c == false) goto L14;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        return f.a.a(this, r100, r101, r102);
    }

    public a(Context r100, String r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uid");
        this.f429204a = r100;
        this.f429205b = r101;
        this.f429206c = r102;
        this.f429207d = r103;
        this.f429208e = r104;
    }
}

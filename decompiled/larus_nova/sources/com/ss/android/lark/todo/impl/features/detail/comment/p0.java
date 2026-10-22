package com.ss.android.lark.todo.impl.features.detail.comment;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentTitleSection f442975a;

    public p0(CommentTitleSection r100) {
        this.f442975a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f442975a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.w1.f443787a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_link_normal));
    }
}

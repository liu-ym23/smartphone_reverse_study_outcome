package com.ss.android.lark.todo.impl.features.common.richtext2;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FunctionEditText f442467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskLinkClickSpanHolder f442468b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        TodoDependencyHolder.a().browserDependency().openUrl(this.f442467a.getContext(), this.f442468b.f442459b.f486304a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
        r100.setColor(UDColorUtils.getColor(this.f442467a.getContext(), R.color.text_link_normal));
    }

    public g(FunctionEditText r100, TaskLinkClickSpanHolder r101) {
        this.f442467a = r100;
        this.f442468b = r101;
    }
}

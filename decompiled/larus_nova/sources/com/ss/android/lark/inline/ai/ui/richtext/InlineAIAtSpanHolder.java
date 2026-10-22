package com.ss.android.lark.inline.ai.ui.richtext;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class InlineAIAtSpanHolder extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f427607d = 0;

    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f427608a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f427608a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            if (Intrinsics.areEqual(this.f427608a, "all") == false) goto L5;
            return;
        L5:
            ContactSource.a r101 = new ContactSource.a();
            com.ss.android.lark.profile.utils.a.a(r100.getContext(), this.f427608a, new ContactSource(r101));
        }
    }

    public InlineAIAtSpanHolder(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        super(r100, r101);
        f(new AnonymousClass1(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.a
    public final void n(SpannableStringBuilder r100, hob.c r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(r101);
        r100.setSpan(new a(r101.f486308a), 0, r103, 33);
    }
}

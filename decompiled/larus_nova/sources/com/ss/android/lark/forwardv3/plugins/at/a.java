package com.ss.android.lark.forwardv3.plugins.at;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.at.a<c> implements com.ss.android.lark.keyboard.edittext2.edittors.at.b<c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f425496e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext2.edittors.a f425497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f425498d;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.plugins.at.a$a, reason: collision with other inner class name */
    public static final class C5026a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f425499a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
        }

        public C5026a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f425499a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            Log.i("ForwardAtSpanHolder", "forward mention at chatter onclick " + this.f425499a);
            if (Intrinsics.areEqual(this.f425499a, "all") == false) goto L5;
            return;
        L5:
            ForwardModuleV3.a().startProfile(r100.getContext(), this.f425499a);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void b() {
        f(new ForwardAtSpanHolder$prepareSpan$1(this, this.f425498d));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.a, com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Editable r101 = r100.getEditableText();
        r101.append(" ");
        Intrinsics.checkNotNull(r101);
        Pair<Integer, Integer> r102 = g(r101);
        int r103 = r102.component1().intValue();
        int r104 = r102.component2().intValue();
        r101.setSpan(e(this.f425497c).component2(), r103, r104, 33);
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(this.f425498d);
        RichTextElement.AtProperty r105 = this.f425498d.f486314g;
        if (r105 == null) goto L6;
        r101.setSpan(new p(RichTextElementCreator.h(r105), r101.subSequence(r103, r104).toString()), r103, r104, 33);
        super.c(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void d(c r100) {
        c r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        Log.i("ForwardAtSpanHolder", "onDataLoadedSuccess: " + r101.f486308a + ",  " + r101.f486311d);
        f(new ForwardAtSpanHolder$prepareSpan$1(this, r101));
    }

    public a(ForwardAtStrategy.c r100, com.ss.android.lark.keyboard.edittext2.edittors.a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Intrinsics.checkNotNullParameter(r101, "editor");
        Intrinsics.checkNotNullParameter(r102, "data");
        super(r102, "ForwardAtSpanHolder");
        this.f425497c = r101;
        this.f425498d = r102;
        if (r102.f486312e == false) goto L5;
        Log.i("ForwardAtSpanHolder", "at chatter is anonymous and not load chatter");
        return;
    L5:
        r100.a(r102, this);
    }
}

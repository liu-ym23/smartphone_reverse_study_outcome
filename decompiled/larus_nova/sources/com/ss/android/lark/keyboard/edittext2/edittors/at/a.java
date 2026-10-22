package com.ss.android.lark.keyboard.edittext2.edittors.at;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a<I extends hob.c> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditTextSpanHolder f429039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I f429040b;

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public void c(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f429039a.c(r100);
    }

    public boolean m(boolean r100, boolean r101) {
        if (r100 == true) goto L6;
        if (r101 == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static void j(hob.c r100) {
        Intrinsics.checkNotNullParameter(r100, "atInfo");
        RichTextElement.AtProperty r101 = r100.f486314g;
        if (r101 == null) goto L8;
        r101.setOriginUserName(r100.f486310c);
        RichTextElement.AtProperty r102 = r100.f486314g;
        if (r102 == null) goto L12;
        r102.setHighLight(r100.f486317j);
        return;
    L12:
        return;
    L8:
        RichTextElement.AtProperty r103 = RichTextElementCreator.b(r100.f486308a, r100.f486309b, r100.f486310c, r100.f486311d, r100.f486312e);
        r100.f486314g = r103;
        r103.setHighLight(r100.f486317j);
        RichTextElement.AtProperty r104 = r100.f486314g;
        if (r104 == null) goto L13;
        r104.setContentWithoutLimit(r100.f486309b);
        return;
    }

    public final Pair<SpannableStringBuilder, Object> e(com.ss.android.lark.keyboard.edittext2.edittors.a r110) {
        Intrinsics.checkNotNullParameter(r110, "editor");
        SpannableStringBuilder r100 = new SpannableStringBuilder("@" + this.f429040b.f486309b);
        I r101 = this.f429040b;
        Intrinsics.checkNotNullParameter(r110, "editor");
        Intrinsics.checkNotNullParameter(r101, "originData");
        String r102 = r101.f486308a;
        boolean r103 = r101.f486311d;
        boolean r104 = r101.f486312e;
        boolean r105 = r101.f486317j;
        int r111 = r110.f428976d;
        Context r112 = r110.context();
        com.ss.android.lark.keyboard.edittext2.span.a r113 = new com.ss.android.lark.keyboard.edittext2.span.a(r112, r102, r103, r104, r105);
        if (m(r103, r104) == false) goto L6;
        r113.f429209f = r111;
    L6:
        if (r101.f486316i == false) goto L8;
        r113.f429209f = UDColorUtils.getColor(r112, R.color.primary_60);
    L8:
        r100.setSpan(r113, 0, r100.length(), 33);
        return TuplesKt.to(r100, r113);
    }

    public final void f(Function1<? super FunctionEditText, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        EditTextSpanHolder r101 = this.f429039a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        r101.f429038c = r100;
        FunctionEditText r102 = r101.f429037b;
        if (r102 == null) goto L6;
        r100.invoke(r102);
        r101.f429038c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        return;
    }

    public Pair<Integer, Integer> g(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        return TuplesKt.to(Integer.valueOf(r100.getSpanStart(this)), Integer.valueOf(r100.getSpanEnd(this)));
    }

    public final boolean i(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r100, "editable");
        Pair<Integer, Integer> r101 = g(r100);
        int r102 = r101.component1().intValue();
        int r103 = r101.component2().intValue();
        if (r102 == (-1)) goto L24;
        if (r103 == (-1)) goto L24;
        if (r103 < r102) goto L24;
        if (r102 >= 0) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L20;
        if (r103 >= 0) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        boolean r107 = Intrinsics.areEqual(r100.subSequence(r102, r103), this.f429040b.f486309b);
    L25:
        if (r107 == false) goto L28;
        k(r100);
        return true;
    L28:
        return false;
    L15:
        if (r103 > r100.length()) goto L17;
        r105 = true;
    L20:
        r106 = false;
        goto L21
    L9:
        if (r102 > r100.length()) goto L11;
        r104 = true;
    L24:
        r107 = true;
        goto L25
    }

    public void k(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        r100.removeSpan(this);
    }

    public a(I r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "originData");
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f429039a = new EditTextSpanHolder(r101);
        this.f429040b = r100;
        hashCode();
    }

    public final void l(Editable r100, SpannableStringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Pair<Integer, Integer> r102 = g(r100);
        int r103 = r102.component1().intValue();
        int r104 = r102.component2().intValue();
        if (r103 == (-1)) goto L7;
        if (r104 == (-1)) goto L7;
        boolean r105 = false;
    L8:
        if (r105 == true) goto L11;
        k(r100);
        r100.replace(r103, r104, r101);
        return;
    L11:
        return;
    L7:
        r105 = true;
        goto L8
    }

    public final void h(SpannableStringBuilder r100, I r101, int r102, int r103, RichTextElement r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r104, "element");
        Map<String, String> r105 = r101.f486315h;
        if (r105 == null) goto L5;
        r104.getStyle().putAll(r105);
    L5:
        Map<String, String> r106 = r101.f486315h;
        FunctionEditText r107 = this.f429039a.f429037b;
        if (r107 == null) goto L8;
        Context r108 = r107.getContext();
    L9:
        com.ss.android.lark.keyboard.edittext2.edittors.richText.c.b(r100, r102, r103, r106, r108);
        return;
    L8:
        r108 = null;
        goto L9
    }
}

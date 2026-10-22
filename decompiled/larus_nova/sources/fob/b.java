package fob;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.at.EditTextSpanHolder;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.b;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b<T extends hob.b> implements com.ss.android.lark.keyboard.edittext2.widget.f, com.ss.android.lark.keyboard.edittext2.edittors.at.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditTextSpanHolder f478190a;

    public final void a(Function1<? super FunctionEditText, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f478190a.a(r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f478190a.c(r100);
    }

    public Object e() {
        return null;
    }

    public b() {
        this.f478190a = new EditTextSpanHolder("AnchorEditor");
    }

    public final Pair<Integer, Integer> b(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        return TuplesKt.to(Integer.valueOf(r100.getSpanStart(this)), Integer.valueOf(r100.getSpanEnd(this)));
    }

    public final void f(Editable r100, SpannableStringBuilder r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Pair<Integer, Integer> r103 = b(r100);
        int r104 = r103.component1().intValue();
        int r105 = r103.component2().intValue();
        if (r104 == (-1)) goto L7;
        if (r105 == (-1)) goto L7;
        boolean r106 = false;
    L8:
        if (r106 == true) goto L16;
        Intrinsics.checkNotNullParameter(r100, "editable");
        r100.removeSpan(this);
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r100, r104, r105);
        if (r102 == false) goto L12;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r101, 0, r101.length());
    L12:
        r100.replace(r104, r105, r101);
        Object r107 = e();
        if (r107 == null) goto L17;
        r100.removeSpan(r107);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r106 = true;
        goto L8
    }

    public final void d(SpannableStringBuilder r100, hob.b r101, int r102, RichTextElement r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r103, "element");
        Map<String, String> r104 = r101.f486305b;
        if (r104 == null) goto L5;
        r103.getStyle().putAll(r104);
    L5:
        Map<String, String> r105 = r101.f486305b;
        FunctionEditText r106 = this.f478190a.f429037b;
        if (r106 == null) goto L8;
        Context r107 = r106.getContext();
    L9:
        com.ss.android.lark.keyboard.edittext2.edittors.richText.c.b(r100, 0, r102, r105, r107);
        return;
    L8:
        r107 = null;
        goto L9
    }
}

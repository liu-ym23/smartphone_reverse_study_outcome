package dob;

import android.text.SpannableStringBuilder;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<d> f469528f;

    public a() {
        this.f469528f = new LinkedHashSet();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.a
    public final void V() {
        int r100 = e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r100 >= 0) goto L24;
        int r101 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getSelectionStart() - 1;
    L6:
        if (r101 <= (-1)) goto L22;
        Character r102 = StringsKt.getOrNull(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText(), r101);
        if (r102 != null) goto L11;
    L13:
        Character r103 = StringsKt.getOrNull(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText(), r101);
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L20;
        r101 = r101 - 1;
        goto L6
    L20:
        r101 = -1;
        goto L22
    L16:
        if (CharsKt.isWhitespace(r103.charValue()) != true) goto L18;
        r104 = true;
        goto L19
    L11:
        if (r102.charValue() != '@') goto L13;
    L22:
        if (r101 < 0) goto L29;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r101, com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getSelectionStart());
        return;
    L29:
        return;
    L24:
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r100, r100 + 1);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.a
    public final void U(com.ss.android.lark.keyboard.edittext2.edittors.at.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        super.U(r100);
        if ((r100 instanceof d) == false) goto L6;
        this.f469528f.add(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.c r100, SpannableStringBuilder r101, int r102, int r103) {
        hob.c r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r101, "text");
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_insert_at_space_fix")) == true) goto L5;
        return;
    L5:
        if (r104.f486313f == false) goto L10;
        if (r103 <= r102) goto L11;
        r101.append(' ');
        r104.f486313f = false;
        return;
    L11:
        return;
    }
}

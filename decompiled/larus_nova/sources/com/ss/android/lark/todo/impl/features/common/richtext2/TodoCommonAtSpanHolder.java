package com.ss.android.lark.todo.impl.features.common.richtext2;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.o;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoCommonAtSpanHolder extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.a implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f442460d = 0;

    @Override // com.ss.android.lark.todo.impl.features.common.richtext2.c
    public final void a(String r100) {
        Pattern r101 = o.f444744a;
        if (Intrinsics.areEqual(r100, "all") == true) goto L7;
        if (r100 == null) goto L8;
        TodoDependencyHolder.a().messengerModuleDependency().a(this.f429041c.context(), r100);
        return;
    L8:
        return;
    }

    public TodoCommonAtSpanHolder(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        super(r100, r101);
        f(new AnonymousClass1(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.a
    public final void n(SpannableStringBuilder r100, hob.c r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        super.n(r100, r101, 0, r103);
        r100.setSpan(new a(r101.f486308a, this), 0, r103, 33);
    }
}

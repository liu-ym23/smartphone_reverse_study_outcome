package com.ss.android.lark.forwardv3.plugins.at;

import android.text.Editable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import hob.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ForwardAtSpanHolder$prepareSpan$1 extends Lambda implements Function1<FunctionEditText, Unit> {
    final /* synthetic */ c $replaceData;
    final /* synthetic */ a this$0;

    public ForwardAtSpanHolder$prepareSpan$1(a r100, c r101) {
        this.this$0 = r100;
        this.$replaceData = r101;
        super(1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Editable r101 = r100.getEditableText();
        a r102 = this.this$0;
        Intrinsics.checkNotNull(r101);
        int r103 = a.f425496e;
        if (r102.i(r101) == false) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r104 = this.this$0.g(r101);
        int r105 = r104.component1().intValue();
        int r106 = r104.component2().intValue();
        final c r107 = this.$replaceData;
        a r108 = this.this$0;
        I r109 = r108.f429040b;
        r107.f486313f = r109.f486313f;
        r107.f486315h = r109.f486315h;
        final com.ss.android.lark.keyboard.edittext2.edittors.a r110 = r108.f425497c;
        com.ss.android.lark.keyboard.edittext2.edittors.at.common.a r111 = new ForwardAtSpanHolder$buildAtSpanHolder$1(r110, r107);
        this.this$0.getClass();
        r101.setSpan(r111, r105, r106, 33);
        a r112 = this.this$0;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r101, "editable");
        r101.removeSpan(r112);
        r111.c(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FunctionEditText r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

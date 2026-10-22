package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class PrivateDescriptionService implements a2b.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2b.g f411563a;

    public static final class a {
    }

    static {
    }

    @Inject
    public PrivateDescriptionService(a2b.g r100) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f411563a = r100;
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
    @Override // a2b.h
    public final Object S0(List<String> r110, PrivateDescriptionSource r111, Strategy r112, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r113) {
        if ((r113 instanceof PrivateDescriptionService$pullPrivateDescriptions$1) == false) goto L7;
        PrivateDescriptionService$pullPrivateDescriptions$1 r100 = (PrivateDescriptionService$pullPrivateDescriptions$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        List r115 = (List) r100.L$1;
        r111 = (PrivateDescriptionSource) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L14 ErrorResult -> L16
    L36:
    L60:
        return Result.m9449constructorimpl(r114);
    L16:
        ErrorResult e100 = e;
        List r116 = r115;
    L48:
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions failed, source=" + r111 + ", userIds=" + r116, e100);
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e100));
    L14:
        Throwable th10 = th;
        List r118 = r115;
    L42:
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions unexpected failed, source=" + r111 + ", userIds=" + r118, th10);
        Result.Companion r119 = Result.Companion;
        String r120 = th10.getMessage();
        if (r120 != null) goto L59;
        r120 = "pullPrivateDescriptions failed";
    L59:
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult(r120)));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r114);
        List r121 = CollectionsKt.distinct(r110);
        ArrayList r122 = new ArrayList();
        Iterator r123 = r121.iterator();
    L22:
        if (r123.hasNext() == false) goto L29;
        Object r104 = r123.next();
        String r105 = (String) r104;
        boolean r106 = !StringsKt.isBlank(r105);
        if (r106 == true) goto L26;
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions invalid userId=" + r105 + ", source=" + r111);
    L26:
        if (r106 == false) goto L22;
        r122.add(r104);
        goto L22
    L29:
        if (r122.isEmpty() == false) goto L50;
        Result.Companion r124 = Result.Companion;
        return Result.m9449constructorimpl(MapsKt.emptyMap());
    L50:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L40 ErrorResult -> L46
        a2b.g r126 = this.f411563a;     // Catch: Throwable -> L40 ErrorResult -> L46
        r100.L$0 = r111;     // Catch: Throwable -> L40 ErrorResult -> L46
        r100.L$1 = r122;     // Catch: Throwable -> L40 ErrorResult -> L46
        r100.label = 1;     // Catch: Throwable -> L40 ErrorResult -> L46
        Object r127 = r126.a(r122, r111, r112);     // Catch: Throwable -> L40 ErrorResult -> L46
        if (r127 != r102) goto L35;
        return r102;
    L35:
        r114 = r127;
        goto L36
    L46:
        e = move-exception;
        e100 = e;
        r116 = r122;
    L40:
        th = move-exception;
        th10 = th;
        r118 = r122;
    L7:
        r100 = new PrivateDescriptionService$pullPrivateDescriptions$1(this, r113);
        goto L8
    }
}

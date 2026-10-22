package com.larus.shortcuts.impl.dynamic;

import android.content.pm.ShortcutInfo;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.shortcuts.impl.dynamic.DynamicShortcutsManager$tryAddShortcut$1", f = "DynamicShortcutsManager.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
final class DynamicShortcutsManager$tryAddShortcut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<tw9.a> $shortcutInfoList;
    int label;

    public DynamicShortcutsManager$tryAddShortcut$1(List<tw9.a> r100, Continuation<? super DynamicShortcutsManager$tryAddShortcut$1> r101) {
        this.$shortcutInfoList = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DynamicShortcutsManager$tryAddShortcut$1(this.$shortcutInfoList, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DynamicShortcutsManager$tryAddShortcut$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = this.$shortcutInfoList.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        ShortcutInfo r105 = DynamicShortcutsManager.b((tw9.a) r104.next());
        if (r105 == null) goto L13;
        r103.add(r105);
        goto L13
    L17:
        DynamicShortcutsManager.c(r103);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i("DynamicShortcutsManager", "download image");
        int r106 = ShortcutCommonUtil.f369227a;
        List<tw9.a> r107 = this.$shortcutInfoList;
        this.label = 1;
        if (ShortcutCommonUtil.d(r107, this) != r101) goto L11;
        return r101;
    }
}

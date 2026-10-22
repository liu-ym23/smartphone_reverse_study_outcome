package com.larus.im.internal.core.conversation.receiver;

import com.larus.im.internal.delegate.a;
import com.larus.im.service.b0;
import com.larus.im.service.d0;
import com.larus.im.service.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.receiver.ConversationDispatcher$notifyReplace$1", f = "ConversationDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationDispatcher$notifyReplace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $localCvs;
    final /* synthetic */ String $localCvsId;
    final /* synthetic */ e $remote;
    int label;

    public ConversationDispatcher$notifyReplace$1(String r100, e r101, e r102, Continuation<? super ConversationDispatcher$notifyReplace$1> r103) {
        this.$localCvsId = r100;
        this.$remote = r101;
        this.$localCvs = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ConversationDispatcher$notifyReplace$1(this.$localCvsId, this.$remote, this.$localCvs, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ConversationDispatcher$notifyReplace$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r100);
        ArrayList r101 = new ArrayList();
        e r102 = this.$localCvs;
        e r103 = this.$remote;
        if (r102 == null) goto L7;
        r101.add(r102);
    L7:
        r101.add(r103);
        Iterator<z<List<e>>> r104 = ConversationDispatcher.f347638a.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        r104.next().c(r101);
        goto L9
    L11:
        a r105 = a.f348188b;
        StringBuilder r106 = new StringBuilder("global local replace listeners size = ");
        CopyOnWriteArrayList<b0> r107 = ConversationDispatcher.f347640c;
        r106.append(r107.size());
        r106.append(" replace cvs oldId-");
        r106.append(this.$localCvsId);
        r106.append(" newId-");
        r106.append(this.$remote.f559198a);
        r105.i("ConversationDispatcher", r106.toString());
        Iterator<b0> r108 = r107.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        r108.next().a();
        goto L13
    L15:
        CopyOnWriteArrayList<d0<e>> r109 = ConversationDispatcher.f347639b.get(this.$localCvsId);
        a r110 = a.f348188b;
        StringBuilder r111 = new StringBuilder("local listeners size = ");
        if (r109 == null) goto L18;
        Integer r112 = Boxing.boxInt(r109.size());
    L19:
        r111.append(r112);
        r111.append(" replace cvs old-");
        r111.append(this.$localCvs);
        r111.append("  new- ");
        r111.append(this.$remote);
        r110.i("ConversationDispatcher", r111.toString());
        boolean r113 = true;
        if (r109 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L31;
        e r115 = this.$localCvs;
        e r116 = this.$remote;
        Iterator<T> r117 = r109.iterator();
    L29:
        if (r117.hasNext() == false) goto L31;
        ((d0) r117.next()).a(r115, r116);
    L31:
        CopyOnWriteArrayList<d0<e>> r118 = ConversationDispatcher.f347639b.get(this.$remote.f559198a);
        if (r118 != null) goto L34;
    L37:
        if (r113 == true) goto L43;
        e r119 = this.$remote;
        Iterator<T> r120 = r118.iterator();
    L40:
        if (r120.hasNext() == false) goto L43;
        ((d0) r120.next()).c(r119);
    L43:
        return Unit.INSTANCE;
    L34:
        if (r118.isEmpty() == true) goto L37;
        r113 = false;
        goto L37
    L22:
        if (r109.isEmpty() == true) goto L25;
        r114 = false;
        goto L26
    L18:
        r112 = null;
        goto L19
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

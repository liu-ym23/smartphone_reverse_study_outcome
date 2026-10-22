package com.obric.assistant.obric_action.handler.server;

import android.content.Context;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/server/ShortLinkApiActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShortLinkApiActionHandler implements IObricActionHandler<String, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<String> f390518b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.j.f390436a;
        return d.j.f390436a;
    }

    public ShortLinkApiActionHandler() {
        this.f390518b = String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return this.f390518b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r100, String r101) {
        return (String) IObricActionHandler.b.a(this, r100, r101);
    }

    public final Object e(String r100, Continuation r101) {
        if ((r101 instanceof ShortLinkApiActionHandler$execute$1) == false) goto L7;
        ShortLinkApiActionHandler$execute$1 r102 = (ShortLinkApiActionHandler$execute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        h.a r107 = (h.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        return r107.b(((Boolean) r104).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == null) goto L17;
        h.a r108 = h.f390443d;
        CoroutineDispatcher r109 = Dispatchers.getIO();
        ShortLinkApiActionHandler$execute$2 r110 = new ShortLinkApiActionHandler$execute$2(r100, null);
        r102.L$0 = r108;
        r102.label = 1;
        Object r111 = BuildersKt.withContext(r109, r110, r102);
        if (r111 != r105) goto L21;
        return r105;
    L21:
        r104 = r111;
        r107 = r108;
        goto L23
    L17:
        return h.a.a(h.f390443d, "short link is null", 2);
    L7:
        r102 = new ShortLinkApiActionHandler$execute$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, String r101, Continuation<? super h<? extends Unit>> r102) {
        return e(r101, r102);
    }
}

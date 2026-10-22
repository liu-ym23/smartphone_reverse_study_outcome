package com.obric.assistant.obric_action;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.obric_action.executor.ObricActionExecutor;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0017J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u001c\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/obric_action/ObricActionServiceImpl;", "Lcom/obric/assistant/obric_action/IObricActionService;", "<init>", "()V", "handlerMap", "", "", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "intentResolver", "Lcom/obric/assistant/obric_action/protocol/ObricActionIntentResolver;", "actionExecutor", "Lcom/obric/assistant/obric_action/executor/ObricActionExecutor;", "actionUIScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchAsync", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fullUrl", "expectKey", "dispatch", "Lcom/obric/assistant/obric_action/ObricActionResult;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchInternal", "toObricActionString", "actionHost", "data", "key", "isSchemaMatch", "", "url", "generateKey", "obricActionKey", WikiFolderPushPlugin.BLOCK_ID, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionServiceImpl implements IObricActionService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IObricActionHandler<?, ?>> f390398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ffa.a f390399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricActionExecutor f390400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f390401d;

    public static final class a {
    }

    static {
    }

    public ObricActionServiceImpl() {
        this.f390401d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        LinkedHashMap r100 = new LinkedHashMap();
        IObricActionHandler.f390395a.getClass();
        Iterator<T> r101 = IObricActionHandler.a.f390397b.getValue().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        IObricActionHandler r102 = (IObricActionHandler) r101.next();
        Iterator<T> r103 = r102.c().f390404b.iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        String r104 = (String) r103.next();
        if (r100.containsKey(r104) == true) goto L11;
        FLogger.f375446a.i("ObricActionServiceImpl", "register " + r104 + " with " + r102);
        r100.put(r104, r102);
        goto L7
    L11:
        FLogger.f375446a.e("ObricActionServiceImpl", "duplicate host " + r104);
        throw new RuntimeException("should not register duplicate host " + r104);
    L13:
        this.f390398a = r100;
        this.f390399b = new ffa.a(r100.keySet());
        this.f390400c = new ObricActionExecutor(r100);
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f390399b.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        String r101 = UriProtector.parse(r100).getScheme();
        if (Intrinsics.areEqual(r101, "obric_action") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r101, ChatFromType.OBRIC_INTENT) == true) goto L8;
        return false;
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String c(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i("ObricActionServiceImpl", "generateKey: obricActionKey = " + r100 + ", blockId = " + r101);
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        return "";
    L12:
        if (r101 != null) goto L14;
    L15:
        r103 = true;
    L16:
        if (r103 == false) goto L18;
        return "";
    L18:
        String r105 = FunctionsKt.b(r100 + '/' + r101);
        StringBuilder r106 = new StringBuilder("generateKey: result ");
        r106.append(r105);
        r102.i("ObricActionServiceImpl", r106.toString());
        return r105;
    L14:
        if (r101.length() != 0) goto L16;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L10
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String b(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "actionHost");
        Intrinsics.checkNotNullParameter(r111, "data");
        this.f390399b.getClass();
        Intrinsics.checkNotNullParameter(r110, "actionHost");
        Intrinsics.checkNotNullParameter(r111, "data");
        String[] r100 = new String[2];
        boolean r101 = false;
        r100[0] = "data=" + Uri.encode(r111);
        StringBuilder r113 = new StringBuilder("key=");
        if (r112 != null) goto L5;
    L6:
        r101 = true;
    L7:
        if (r101 == false) goto L9;
        String r114 = "";
    L10:
        r113.append(r114);
        r100[1] = r113.toString();
        return "obric_action://" + r110 + '?' + CollectionsKt.joinToString$default(CollectionsKt.mutableListOf(r100), "&", null, null, 0, null, null, 62, null);
    L9:
        r114 = Uri.encode(r112);
        goto L10
    L5:
        if (r112.length() != 0) goto L7;
        goto L6
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final void d(Context r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "fullUrl");
        BuildersKt.launch$default(this.f390401d, null, null, new ObricActionServiceImpl$dispatchAsync$1(this, r110, r111, r112, null), 3, null);
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final Object e(Context r110, String r111, String r112, Continuation<? super h<? extends Object>> r113) {
        return BuildersKt.async$default(this.f390401d, null, null, new ObricActionServiceImpl$dispatch$2(this, r110, r111, r112, null), 3, null).await(r113);
    }

    public static final Object f(ObricActionServiceImpl r110, Context r111, String r112, String r113, Continuation r114) {
        r110.getClass();
        if ((r114 instanceof ObricActionServiceImpl$dispatchInternal$1) == false) goto L7;
        ObricActionServiceImpl$dispatchInternal$1 r100 = (ObricActionServiceImpl$dispatchInternal$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        efa.a r116 = (efa.a) r100.L$0;
        ResultKt.throwOnFailure(r115);     // Catch: Throwable -> L30
    L27:
        FLogger.f375446a.i("ObricActionServiceImpl", "dispatchInternal: action=" + r116.f472594a + ", result=" + ((h) r115));     // Catch: Throwable -> L30
        h<Object> r117 = (h) r115;     // Catch: Throwable -> L30
    L28:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L30
    L32:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 != null) goto L36;
    L51:
        return r118;
    L36:
        if ((r119 instanceof CancellationException) == true) goto L48;
        FLogger.f375446a.e("ObricActionServiceImpl", "dispatchInternal failed. " + r119.getMessage(), r119);
        h.a r120 = h.f390443d;
        String r121 = r119.getMessage();
        if (r121 != null) goto L41;
        r121 = "";
    L41:
        if (r121.length() == 0) goto L44;
        r104 = false;
    L44:
        if (r104 == false) goto L46;
        r121 = "dispatch obric action failed";
    L46:
        r118 = h.a.a(r120, r121, 2);
        goto L51
    L48:
        throw r119;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r115);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L30
        FLogger r123 = FLogger.f375446a;     // Catch: Throwable -> L30
        r123.i("ObricActionServiceImpl", "dispatchInternal: context=" + r111 + ", fullUrl=" + r112 + ", expectKey=" + r113);     // Catch: Throwable -> L30
        Uri r124 = UriProtector.parse(r112);     // Catch: Throwable -> L30
        ffa.b r125 = r110.f390399b.a(r124, r113);     // Catch: Throwable -> L30
        efa.a r105 = r125.f476781a;     // Catch: Throwable -> L30
        if (r105 != null) goto L23;
        r117 = r125.f476782b;     // Catch: Throwable -> L30
        if (r117 != null) goto L22;
        r117 = h.a.a(h.f390443d, "resolve obric action failed", 2);     // Catch: Throwable -> L30
    L22:
        r123.w("ObricActionServiceImpl", "dispatchInternal: resolve obric action failed, uri=" + r124 + ", errorResult=" + r117);     // Catch: Throwable -> L30
        goto L28
    L23:
        r123.i("ObricActionServiceImpl", "dispatchInternal: use action=" + r105.f472594a + " handle " + r124);     // Catch: Throwable -> L30
        ObricActionExecutor r126 = r110.f390400c;     // Catch: Throwable -> L30
        r100.L$0 = r105;     // Catch: Throwable -> L30
        r100.label = 1;     // Catch: Throwable -> L30
        r115 = r126.a(r111, r105, r100);     // Catch: Throwable -> L30
        if (r115 == r102) goto L47;
        r116 = r105;
        goto L27
    L47:
        return r102;
    L30:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ObricActionServiceImpl$dispatchInternal$1(r110, r114);
        goto L8
    }
}

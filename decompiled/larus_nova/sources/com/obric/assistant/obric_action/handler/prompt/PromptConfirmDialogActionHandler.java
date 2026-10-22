package com.obric.assistant.obric_action.handler.prompt;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J:\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionParams;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConfirmDialog", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", BitableAnalytic.SelectSceneClickType.COMPLETE, "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "hasVisibleContent", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptConfirmDialogActionHandler implements IObricActionHandler<e, j> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f390487c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<e> f390488b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final com.obric.assistant.obric_action.d c() {
        com.obric.assistant.obric_action.d r100 = com.obric.assistant.obric_action.d.h.f390433a;
        return com.obric.assistant.obric_action.d.h.f390433a;
    }

    public PromptConfirmDialogActionHandler() {
        this.f390488b = e.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<e> b() {
        return this.f390488b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final e a(Context r100, String r101) {
        return (e) IObricActionHandler.b.a(this, r100, r101);
    }

    public final Object e(final e r100, Continuation r101) {
        if ((r101 instanceof PromptConfirmDialogActionHandler$execute$1) == false) goto L7;
        PromptConfirmDialogActionHandler$execute$1 r102 = (PromptConfirmDialogActionHandler$execute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        com.obric.assistant.obric_action.h.a r107 = (com.obric.assistant.obric_action.h.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L50:
        return com.obric.assistant.obric_action.h.a.c(r107, r104, null, 2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == null) goto L17;
        String r108 = r100.e();
        boolean r109 = false;
        if (r108 != null) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == false) goto L34;
        String r111 = r100.d();
        if (r111 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == false) goto L34;
    L35:
        if (r109 == false) goto L37;
        IObricActivityStackService r113 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r113 == null) goto L41;
        final FragmentActivity r114 = (FragmentActivity) r113.a(FragmentActivity.class);
    L42:
        if (r114 != null) goto L45;
        FLogger.f375446a.w("PromptConfirmDialogActionHandler", "handle: no available fragment activity");
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "no available fragment activity", 2);
    L45:
        com.obric.assistant.obric_action.h.a r115 = com.obric.assistant.obric_action.h.f390443d;
        Function2 r116 = new com.obric.assistant.obric_action.handler.prompt.a(this, r114, r100);
        r102.L$0 = r115;
        r102.label = 1;
        r104 = h.a(r114, r116, r102);
        if (r104 != r105) goto L48;
        return r105;
    L48:
        r107 = r115;
        goto L50
    L41:
        r114 = null;
        goto L42
    L37:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "title and message are empty", 2);
    L29:
        if (StringsKt.isBlank(r111) == true) goto L32;
        r112 = false;
    L34:
        r109 = true;
        goto L35
    L21:
        if (StringsKt.isBlank(r108) == true) goto L24;
        r110 = false;
        goto L25
    L17:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "params is null", 2);
    L7:
        r102 = new PromptConfirmDialogActionHandler$execute$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, e r101, Continuation<? super com.obric.assistant.obric_action.h<? extends j>> r102) {
        return e(r101, r102);
    }
}

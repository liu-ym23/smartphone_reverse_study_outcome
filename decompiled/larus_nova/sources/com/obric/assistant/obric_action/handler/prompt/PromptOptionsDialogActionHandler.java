package com.obric.assistant.obric_action.handler.prompt;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013JH\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0002J\u0012\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u0002H\u0002J\f\u0010!\u001a\u00020\u0003*\u00020\u001aH\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionParams;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOptionsDialog", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "options", "", "Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionHandler$IndexedOption;", BitableAnalytic.SelectSceneClickType.COMPLETE, "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "validOptions", "toResult", "Companion", "IndexedOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptOptionsDialogActionHandler implements IObricActionHandler<q, j> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f390489c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<q> f390490b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f390491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f390492b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f390491a == r101.f390491a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f390492b, r101.f390492b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f390491a * 31) + this.f390492b.hashCode();
        }

        public final String toString() {
            return "IndexedOption(index=" + this.f390491a + ", option=" + this.f390492b + ')';
        }

        public b(int r100, i r101) {
            Intrinsics.checkNotNullParameter(r101, "option");
            this.f390491a = r100;
            this.f390492b = r101;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final com.obric.assistant.obric_action.d c() {
        com.obric.assistant.obric_action.d r100 = com.obric.assistant.obric_action.d.h.f390433a;
        return com.obric.assistant.obric_action.d.h.f390434b;
    }

    public PromptOptionsDialogActionHandler() {
        this.f390490b = q.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<q> b() {
        return this.f390490b;
    }

    public static final j e(PromptOptionsDialogActionHandler r100, b r101) {
        r100.getClass();
        return new j("selected", r101.f390492b.a(), r101.f390492b.b(), Integer.valueOf(r101.f390491a));
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final q a(Context r100, String r101) {
        return (q) IObricActionHandler.b.a(this, r100, r101);
    }

    public final Object f(final q r110, Continuation r111) {
        if ((r111 instanceof PromptOptionsDialogActionHandler$execute$1) == false) goto L7;
        PromptOptionsDialogActionHandler$execute$1 r100 = (PromptOptionsDialogActionHandler$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        com.obric.assistant.obric_action.h.a r113 = (com.obric.assistant.obric_action.h.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L63:
        return com.obric.assistant.obric_action.h.a.c(r113, r112, null, 2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r110 == null) goto L17;
        List<i> r114 = r110.c();
        if (r114 != null) goto L21;
        r114 = CollectionsKt.emptyList();
    L21:
        final ArrayList r104 = new ArrayList();
        Iterator<T> r115 = r114.iterator();
        int r105 = 0;
    L23:
        if (r115.hasNext() == false) goto L44;
        Object r106 = r115.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        i r108 = (i) r106;
        if (r108 == null) goto L38;
        String r116 = r108.b();
        if (r116 != null) goto L33;
    L36:
        boolean r117 = true;
    L37:
        if (r117 == true) goto L38;
        b r118 = new b(r105, r108);
    L40:
        if (r118 == null) goto L42;
        r104.add(r118);
    L42:
        r105 = r107;
        goto L23
    L33:
        if (StringsKt.isBlank(r116) == true) goto L36;
        r117 = false;
    L38:
        r118 = null;
        goto L40
    L44:
        if (r104.isEmpty() == false) goto L48;
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "options is empty", 2);
    L48:
        if (r104.size() > 3) goto L50;
        IObricActivityStackService r119 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r119 == null) goto L54;
        final FragmentActivity r120 = (FragmentActivity) r119.a(FragmentActivity.class);
    L55:
        if (r120 != null) goto L58;
        FLogger.f375446a.w("PromptOptionsDialogActionHandler", "handle: no available fragment activity");
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "no available fragment activity", 2);
    L58:
        com.obric.assistant.obric_action.h.a r109 = com.obric.assistant.obric_action.h.f390443d;
        Function2 r121 = new k(this, r120, r110, r104);
        r100.L$0 = r109;
        r100.label = 1;
        r112 = h.a(r120, r121, r100);
        if (r112 != r102) goto L61;
        return r102;
    L61:
        r113 = r109;
        goto L63
    L54:
        r120 = null;
        goto L55
    L50:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "dialog options size exceeds current dialog button slot count: 3", 2);
    L17:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "params is null", 2);
    L7:
        r100 = new PromptOptionsDialogActionHandler$execute$1(this, r111);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, q r101, Continuation<? super com.obric.assistant.obric_action.h<? extends j>> r102) {
        return f(r101, r102);
    }
}

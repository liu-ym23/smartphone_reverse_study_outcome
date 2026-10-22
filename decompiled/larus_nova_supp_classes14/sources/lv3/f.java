package lv3;

import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.api.l2;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ l2 b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ f(FragmentActivity r1, l2 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [lv3.g] */
    @Override // java.lang.Runnable
    public final void run() {
        FragmentActivity r0 = this.a;
        l2 r1 = this.b;
        final Function1 r2 = this.c;
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        n r5 = n.a;
        final ?? r6 = new g(r3, r4);
        r5.getClass();
        final l0 r7 = new l0(r0, 0.0f, true, 2);
        r7.setCancelable(true);
        r7.setOnCancelListener(new l(r6));
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L11
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r7);     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        r3.element = new h(r7, r2);
        r4.element = new i(r7, r2);
        r1.f("OpenECommerceHelper-loadInDemand", new m(r3, r4));
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15 Throwable -> L11
    L8:
        DialogLancet.beforeDialogShow(r7);     // Catch: Throwable -> L11
        r7.show();     // Catch: Throwable -> L11
        DialogLancet.afterDialogShow(r7);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}

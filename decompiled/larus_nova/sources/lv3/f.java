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

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f510903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l2 f510904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f510905c;

    public /* synthetic */ f(FragmentActivity r100, l2 r101, Function1 r102) {
        this.f510903a = r100;
        this.f510904b = r101;
        this.f510905c = r102;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, lv3.h] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, lv3.i] */
    /* JADX WARN: Type inference failed for: r6v0, types: [lv3.g] */
    @Override // java.lang.Runnable
    public final void run() {
        FragmentActivity r100 = this.f510903a;
        l2 r101 = this.f510904b;
        final Function1 r102 = this.f510905c;
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        n r105 = n.f510919a;
        final ?? r106 = new g(r103, r104);
        r105.getClass();
        final l0 r107 = new l0(r100, 0.0f, true, 2);
        r107.setCancelable(true);
        r107.setOnCancelListener(new l(r106));
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L11
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r107);     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        r103.element = new h(r107, r102);
        r104.element = new i(r107, r102);
        r101.f("OpenECommerceHelper-loadInDemand", new m(r103, r104));
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15 Throwable -> L11
    L8:
        DialogLancet.beforeDialogShow(r107);     // Catch: Throwable -> L11
        r107.show();     // Catch: Throwable -> L11
        DialogLancet.afterDialogShow(r107);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}

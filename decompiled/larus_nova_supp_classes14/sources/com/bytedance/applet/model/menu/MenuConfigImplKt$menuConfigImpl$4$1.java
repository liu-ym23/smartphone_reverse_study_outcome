package com.bytedance.applet.model.menu;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.menu.MenuConfigImplKt$menuConfigImpl$4$1", f = "MenuConfigImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MenuConfigImplKt$menuConfigImpl$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WidgetContainer $container;
    int label;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ t1a.b a;

        public final boolean mustInMain() {
            return true;
        }

        public a(t1a.b r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r4) {
            Message r5 = (Message) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            t1a.b r0 = this.a;
            if (r0 == null) goto L8;
            u7 r1 = r0.getAbility(u7.class);
            if (r1 == null) goto L9;
            r1.CX(CollectionsKt.mutableListOf(new Message[]{r5}));
            return;
        L9:
            return;
        }
    }

    public MenuConfigImplKt$menuConfigImpl$4$1(WidgetContainer r1, Continuation<? super MenuConfigImplKt$menuConfigImpl$4$1> r2) {
        this.$container = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MenuConfigImplKt$menuConfigImpl$4$1(this.$container, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        String r5 = this.$container.l();
        if (r5 == null) goto L7;
        View r0 = this.$container.realView();
        t1a.b r1 = null;
        if (r0 == null) goto L11;
        Fragment r2 = e1.k(r0);
    L13:
        if ((r2 instanceof xe8.a) == false) goto L15;
        xe8.a r3 = (xe8.a) r2;
    L16:
        if (r3 == null) goto L18;
        r1 = r3.WF();
    L18:
        com.larus.im.d.e().m(r5, new a(r1));
        return Unit.INSTANCE;
    L15:
        r3 = null;
        goto L16
    L11:
        r2 = null;
        goto L13
    L7:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

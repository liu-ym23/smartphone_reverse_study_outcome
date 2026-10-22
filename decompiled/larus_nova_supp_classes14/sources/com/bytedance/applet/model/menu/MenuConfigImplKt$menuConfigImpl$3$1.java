package com.bytedance.applet.model.menu;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.e1;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.menu.MenuConfigImplKt$menuConfigImpl$3$1", f = "MenuConfigImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MenuConfigImplKt$menuConfigImpl$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WidgetContainer $container;
    int label;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ t1a.b a;
        public final /* synthetic */ WidgetContainer b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r8) {
            Message r9 = (Message) r8;
            Intrinsics.checkNotNullParameter(r9, "result");
            t1a.b r0 = this.a;
            if (r0 == null) goto L11;
            y r1 = r0.getAbility(y.class);
            if (r1 == null) goto L11;
            wc9.e r2 = r1.h();
            if (r2 == null) goto L11;
            if (n.C(r2) != true) goto L11;
            boolean r3 = true;
        L12:
            List r4 = null;
            Context r5 = null;
            r4 = null;
            if (r3 == false) goto L18;
            s r10 = s.a;
            View r6 = this.b.realView();
            if (r6 == null) goto L17;
            r5 = r6.getContext();
        L17:
            r10.getClass();
            s.s(r5, 2131900761);
            return;
        L18:
            t1a.b r7 = this.a;
            if (r7 == null) goto L21;
            u7 r11 = (u7) r7.getAbility(u7.class);
        L22:
            t1a.b r12 = this.a;
            if (r12 == null) goto L34;
            IChatMessageShareAbility r13 = r12.getAbility(IChatMessageShareAbility.class);
            if (r13 == null) goto L35;
            IChatMessageShareAbility.ActionType r14 = IChatMessageShareAbility.ActionType.SHARE;
            if (r11 == null) goto L31;
            MessageAdapter r15 = r11.MF();
            if (r15 == null) goto L31;
            r4 = r15.getCurrentList();
        L31:
            r13.yt(r14, r9, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "answer")}));
            return;
        L35:
            return;
        L34:
            return;
        L21:
            r11 = null;
        L11:
            r3 = false;
            goto L12
        }

        public a(t1a.b r1, WidgetContainer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MenuConfigImplKt$menuConfigImpl$3$1(WidgetContainer r1, Continuation<? super MenuConfigImplKt$menuConfigImpl$3$1> r2) {
        this.$container = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MenuConfigImplKt$menuConfigImpl$3$1(this.$container, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        String r6 = this.$container.l();
        if (r6 == null) goto L7;
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
        com.larus.im.d.e().m(r6, new a(r1, this.$container));
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

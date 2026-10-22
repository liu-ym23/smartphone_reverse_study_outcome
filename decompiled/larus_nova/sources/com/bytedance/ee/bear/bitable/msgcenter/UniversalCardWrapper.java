package com.bytedance.ee.bear.bitable.msgcenter;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.card.cardcontainer.render.b;
import com.larksuite.component.card.cardcontainer.render.c;
import com.larksuite.component.card.cardcontainer.render.d;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u001e\u001a\u00020\fH\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/UniversalCardWrapper;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", BrowserDependency.UrlClickType.CARD, "Lcom/larksuite/component/card/protocol/ICard;", "getCard", "()Lcom/larksuite/component/card/protocol/ICard;", "setCard", "(Lcom/larksuite/component/card/protocol/ICard;)V", "clickEmpty", "Lkotlin/Function0;", "", "getClickEmpty", "()Lkotlin/jvm/functions/Function0;", "setClickEmpty", "(Lkotlin/jvm/functions/Function0;)V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setLifecycle", "(Landroidx/lifecycle/Lifecycle;)V", ChameleonOpenTracker.Stage.RENDER, PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "json", "", "newCard", "Landroid/view/View;", "onDestory", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardWrapper implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CardImpl f214671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f214672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lifecycle f214673c;

    public static final class a implements fz7.a.InterfaceC5971a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f214674a;

        /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.bitable.msgcenter.UniversalCardWrapper$render$1$getOpenUrlService$1] */
        @Override // fz7.a.InterfaceC5971a
        public final UniversalCardWrapper$render$1$getOpenUrlService$1 getOpenUrlService() {
            final Function0<Unit> r100 = this.f214674a;
            return new UniversalCardWrapper$render$1$getOpenUrlService$1(r100);
        }

        public a(Function0<Unit> r100) {
            this.f214674a = r100;
        }
    }

    public UniversalCardWrapper() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestory() {
        CardImpl r100 = this.f214671a;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        Lifecycle r101 = this.f214673c;
        if (r101 == null) goto L8;
        r101.removeObserver(this);
    L8:
        this.f214673c = null;
    }

    public final void a(Context r100, String r101, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "json");
        Intrinsics.checkNotNullParameter(r110, "clickEmpty");
        this.f214672b = r110;
        CardImpl r102 = this.f214671a;
        if (r102 == null) goto L20;
        fz7.a r103 = new fz7.a(new a(r110), new CardStyle(false, false, true, 20));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "serverEntityJson");
        Intrinsics.checkNotNullParameter(r103, "cardRenderEntityConfig");
        com.larksuite.component.card.cardcontainer.render.a r111 = (com.larksuite.component.card.cardcontainer.render.a) ((LinkedHashMap) r102.f283206d).get(d.class);
        if (r111 == null) goto L8;
        d r112 = (d) r111;
    L17:
        r112.d(r100, r101, r103);
        return;
    L8:
        if (Intrinsics.areEqual(d.class, b.class) == false) goto L11;
        com.larksuite.component.card.cardcontainer.render.a r113 = new b(r102.f283205c, r102.f283203a);
    L16:
        r102.f283206d.put(d.class, r113);
        r112 = (d) r113;
        goto L17
    L11:
        if (Intrinsics.areEqual(d.class, c.class) == false) goto L14;
        r113 = new c(r102.f283205c, r102.f283203a);
        goto L16
    L14:
        if (Intrinsics.areEqual(d.class, d.class) == false) goto L19;
        r113 = new d(r102.f283205c, r102.f283203a);
        goto L16
    L19:
        throw new IllegalArgumentException("unsupported render type");
    }
}

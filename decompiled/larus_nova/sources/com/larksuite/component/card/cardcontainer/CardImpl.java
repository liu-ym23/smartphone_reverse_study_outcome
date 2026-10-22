package com.larksuite.component.card.cardcontainer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.card.component.CardResourceProvider;
import com.larksuite.component.card.debugger.ICardDebugger;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.service.d;
import com.larksuite.component.card.utils.j;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J*\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J*\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J*\u0010$\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\u001a\u0010)\u001a\u0002H*\"\n\b\u0000\u0010*\u0018\u0001*\u00020\u0010H\u0082\b¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u001cH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, d2 = {"Lcom/larksuite/component/card/cardcontainer/CardImpl;", "Lcom/larksuite/component/card/protocol/ICard;", "Landroidx/lifecycle/LifecycleObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "cardConfig", "Lcom/larksuite/component/card/protocol/CardConfig;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/larksuite/component/card/protocol/CardConfig;)V", "destroyed", "", "universalCardRender", "Lcom/larksuite/component/card/cardcontainer/UniversalCardLynxRender;", "cardRenderByClass", "", "Ljava/lang/Class;", "Lcom/larksuite/component/card/cardcontainer/render/BaseCardRender;", ChameleonOpenTracker.Stage.RENDER, "getRender", "()Lcom/larksuite/component/card/cardcontainer/UniversalCardLynxRender;", "createView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getLynxView", "Lcom/lynx/tasm/LynxView;", "createCardWidget", "Lcom/larksuite/component/card/cell/UniversalCardWidget;", "", "bizId", "", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "Lcom/larksuite/component/card/protocol/ICardLifeCycle;", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "renderEntity", "serverEntityJson", "cardRenderEntityConfig", "Lcom/larksuite/component/card/protocol/render/CardRenderEntityConfig;", MapMonitorConst.EVENT_DESTROY, "acquireRender", ExifInterface.GPS_DIRECTION_TRUE, "()Lcom/larksuite/component/card/cardcontainer/render/BaseCardRender;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardImpl implements bz7.a, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardConfig f283203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f283204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UniversalCardLynxRender f283205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends com.larksuite.component.card.cardcontainer.render.a>, com.larksuite.component.card.cardcontainer.render.a> f283206d;

    public static final class a {
    }

    static {
    }

    @Override // bz7.a
    public final LynxView a() {
        ILarkLynxContainer r100 = this.f283205c.f283208a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r100 = null;
    L5:
        View r101 = r100.getLynxView();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.lynx.tasm.LynxView");
        return (LynxView) r101;
    }

    public final void e() {
        if (this.f283204b == false) goto L6;
        Log.w("CardImpl", "already destroyed");
        return;
    L6:
        Log.i("CardImpl", MapMonitorConst.EVENT_DESTROY);
        Iterator r100 = ((LinkedHashMap) this.f283206d).values().iterator();
    L8:
        if (r100.hasNext() == false) goto L10;
        ((com.larksuite.component.card.cardcontainer.render.a) r100.next()).a();
        goto L8
    L10:
        UniversalCardLynxRender r101 = this.f283205c;
        ((d) r101.f283211d.getValue()).destroy();
        ILarkLynxContainer r102 = r101.f283208a;
        if (r102 == null) goto L13;
        r102.destroy();
    L13:
        this.f283204b = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Log.i("CardImpl", MapMonitorConst.EVENT_DESTROY);
        e();
    }

    @Override // bz7.a
    public final UniversalCardLynxRender b() {
        return this.f283205c;
    }

    public final View d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UniversalCardLynxRender r101 = this.f283205c;
        CardConfig r102 = this.f283203a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "cardConfig");
        Activity r103 = UIUtils.getActivityFromContext(r100);
        if (r103 == null) goto L6;
        r100 = r103;
    L6:
        b r104 = r101.f283210c;
        ((IUniversalCardJsService) LarkContext.spiByDwarf(IUniversalCardJsService.class)).initCardEnv(LarkContext.getApplication());
        LarkLynxContainerBuilder r105 = new LarkLynxContainerBuilder(r100).tagForCustomComponent("UniversalCard").containerContext(r101.f283209b).tagForJsContext("UniversalCard").tagForBridgeMethodDispatcher("UniversalCard");
        if (r104 == null) goto L9;
        r105.lynxViewLifeCycle(r104);
    L9:
        Integer r106 = r102.getMaxWidth();
        if (r106 == null) goto L12;
        r106.intValue();
        Log.d("UniversalCardLynxRender", "lynxViewWidth : " + r102 + ".maxWidth");
        r105.widthMeasureSpec(View.MeasureSpec.makeMeasureSpec(r102.getMaxWidth().intValue(), 1073741824));
    L12:
        LarkLynxContainerBuilder r107 = r105.setResourceProvider("EXTERNAL_JS_SOURCE", new CardResourceProvider());
        ICardDebugger.f283712a.getClass();
        ICardDebugger.Companion.f283714b.getValue().getEnable();
        ILarkLynxContainer r108 = r107.setEnableUserCodeCache(true).setCodeCacheSourceUrl("local://open_card").build();
        r101.f283208a = r108;
        ILarkLynxContainer r109 = null;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r108 = null;
    L15:
        View r110 = r108.getLynxView();
        ILarkLynxContainer r111 = r101.f283208a;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
    L19:
        r109.updateGlobalData(j.a(r102, r100));
        r110.setFocusable(false);
        return r110;
    L18:
        r109 = r111;
        goto L19
    }

    public CardImpl(Lifecycle r100, CardConfig r101) {
        Intrinsics.checkNotNullParameter(r101, "cardConfig");
        this.f283203a = r101;
        this.f283205c = new UniversalCardLynxRender(r100);
        this.f283206d = new LinkedHashMap();
        if (r100 == null) goto L6;
        r100.addObserver(this);
        return;
    }

    @Override // bz7.a
    public final void c(CardData r100, CardContext r101, CardConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "cardContext");
        Intrinsics.checkNotNullParameter(r102, "cardConfig");
        com.larksuite.component.card.cardcontainer.render.a r103 = (com.larksuite.component.card.cardcontainer.render.a) ((LinkedHashMap) this.f283206d).get(com.larksuite.component.card.cardcontainer.render.c.class);
        if (r103 == null) goto L6;
        com.larksuite.component.card.cardcontainer.render.c r104 = (com.larksuite.component.card.cardcontainer.render.c) r103;
    L15:
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "cardContext");
        Intrinsics.checkNotNullParameter(r102, "cardConfig");
        r104.b(r100, r101, r102);
        return;
    L6:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.b.class) == false) goto L9;
        com.larksuite.component.card.cardcontainer.render.a r105 = new com.larksuite.component.card.cardcontainer.render.b(this.f283205c, this.f283203a);
    L14:
        this.f283206d.put(com.larksuite.component.card.cardcontainer.render.c.class, r105);
        r104 = (com.larksuite.component.card.cardcontainer.render.c) r105;
        goto L15
    L9:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.c.class) == false) goto L12;
        r105 = new com.larksuite.component.card.cardcontainer.render.c(this.f283205c, this.f283203a);
        goto L14
    L12:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.d.class) == false) goto L18;
        r105 = new com.larksuite.component.card.cardcontainer.render.d(this.f283205c, this.f283203a);
        goto L14
    L18:
        throw new IllegalArgumentException("unsupported render type");
    }
}

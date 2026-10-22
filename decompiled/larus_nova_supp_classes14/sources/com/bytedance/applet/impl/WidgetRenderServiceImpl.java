package com.bytedance.applet.impl;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.api.AppletServiceDelegate;
import com.bytedance.ai.api.AppletV2ServiceDelegate;
import com.bytedance.ai.api.model.view.WidgetEvent;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.IWidgetRenderService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u0000 W2\u00020\u0001:\u0003UVWB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\"\u0010+\u001a\u0004\u0018\u00010,2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020(2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u0002042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u00106\u001a\u0002072\u0006\u0010-\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u001a\u0010:\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020.H\u0016J\u001a\u0010;\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020.H\u0016J\u001c\u0010<\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J \u0010?\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>0AH\u0016J\u0012\u0010B\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010C\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010D\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010E\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010F\u001a\u0004\u0018\u00010\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010H\u001a\u00020(2\b\u0010F\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010I\u001a\u00020(2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00120KH\u0016J\u0010\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020(2\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0KH\u0016J\b\u0010Q\u001a\u00020(H\u0002J*\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120S2\u0014\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010SH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/bytedance/applet/impl/WidgetRenderServiceImpl;", "Lcom/larus/bmhome/chat/api/IWidgetRenderService;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "widgetManagers", "Ljava/util/WeakHashMap;", "", "Lcom/bytedance/ai/api/model/widgets/IWidgetManager;", "widgetHeightRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "isAISDKInitialized", "", "EVENT_BOT_STATE", "", "EVENT_FPA_COMMON_PARAM", "EVENT_DOUBAOAPP_DA_PARAMS", "getWidgetInfo", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "renderData", "getItemKey", "msgId", "getBoxType", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "compareData", "oldRenderData", "newRenderData", "getSavedHeight", "defValue", "getArchiveText", "getWidgetManager", "host", "Landroidx/fragment/app/Fragment;", "createWidgetManager", "preloadWidgets", "", "context", "Landroid/content/Context;", "bindWidget", "Lcom/larus/bmhome/chat/api/IAppletWidgetContainer;", "widgetRenderData", "Lcom/larus/bmhome/chat/api/WidgetRenderData;", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/chat/api/WidgetRenderData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyWidgetStyle", "container", "Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer;", "policy", "Lcom/obric/assistant/spi/miniapp/ObricIntentWidgetPolicy;", "resolveIntentWidgetPolicy", "getWidgetRenderContext", "Lcom/bytedance/ai/model/objects/WidgetRenderContext;", "observer", "Lcom/bytedance/ai/api/model/view/IWidgetLifeObserver;", "updateWidget", "onWidgetRecycled", "onWidgetArchived", "view", "Landroid/view/View;", "onWidgetVisibleChanged", "visibleWidgets", "", "onHostShow", "onHostHide", "onHostDestroy", "onConversationChanged", "convId", "sectionId", "onChatHistoryClear", "onMessageRemoved", "msgIds", "", "setEventCommonParam", "param", "Lcom/larus/bmhome/chat/api/EventParam;", "onMessageRefresh", "messageList", "ensureAISDKInit", "extractTrackerParams", "", "ext", "WidgetConversationListener", "AppletWidgetContainerAdapter", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetRenderServiceImpl implements IWidgetRenderService {
    public static final /* synthetic */ int i = 0;
    public final Gson a;
    public final WeakHashMap<Object, l2.a> b;
    public final Keva c;
    public final Handler d;
    public volatile boolean e;
    public final String f;
    public final String g;
    public final String h;

    public final class a implements com.larus.bmhome.chat.api.r {
        public final AppletWidgetContainer a;
        public final /* synthetic */ WidgetRenderServiceImpl b;

        public final WidgetBoxView a() {
            return this.a.z;
        }

        public final int getBoxType() {
            Widget r0 = this.a.D;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.P;
        }

        public final void updateData(String r27) {
            WidgetRenderServiceImpl r1 = this.b;
            int r2 = WidgetRenderServiceImpl.i;
            WidgetInfo r3 = r1.t(r27);
            if (r3 != null) goto L6;
            FLogger.a.w("WidgetRenderServiceImpl", "updateData: invalid render data");
            return;
        L6:
            AppletWidgetContainer r4 = this.a;
            com.bytedance.ai.widget.contianer.m r5 = ((WidgetContainer) r4).g;
            if (r5 != null) goto L10;
            FLogger.a.w("WidgetRenderServiceImpl", "updateData: currentData is null");
            return;
        L10:
            String r9 = r3.getWidgetData();
            String r6 = r5.a;
            String r7 = r5.b;
            String r8 = r5.d;
            String r15 = r5.e;
            String r12 = r5.f;
            String r13 = r5.g;
            Map r14 = r5.h;
            Map r10 = r5.i;
            String r11 = r5.j;
            String r16 = r5.k;
            String r17 = r5.l;
            Map r18 = r5.m;
            Map r19 = r5.n;
            String r20 = r5.o;
            String r21 = r5.p;
            String r22 = r5.q;
            Function1 r23 = r5.r;
            String r24 = r5.s;
            Intrinsics.checkNotNullParameter(r6, "packageName");
            Intrinsics.checkNotNullParameter(r7, "widgetId");
            Intrinsics.checkNotNullParameter(r8, "botId");
            Intrinsics.checkNotNullParameter(r15, "messageId");
            r4.o(new com.bytedance.ai.widget.contianer.m(r6, r7, r9, r8, r15, r12, r13, r14, r10, r11, r16, r17, r18, r19, r20, r21, r22, r23, r24));
            WidgetRenderServiceImpl r25 = this.b;
            AppletWidgetContainer r26 = this.a;
            r25.getClass();
            WidgetRenderServiceImpl.q(r26, WidgetRenderServiceImpl.w(r27));
        }

        public a(WidgetRenderServiceImpl r2, AppletWidgetContainer r3) {
            Intrinsics.checkNotNullParameter(r3, "container");
            this.b = r2;
            this.a = r3;
        }

        public final void sendEvent(String r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            d3.w r0 = ((WidgetContainer) this.a).o;
            if (r0 == null) goto L9;
            if (r4 == null) goto L6;
            JsonObject r5 = GsonProtectorUtils.toJsonTree(this.b.a, r4).getAsJsonObject();
        L7:
            r0.a(r3, r5);
            return;
        L6:
            r5 = null;
            goto L7
        }
    }

    public static final class b {
    }

    public static final class c implements wh8.b {
        public final WeakReference<Context> a;
        public final Handler b;

        public final void IJ(int r1) {
        }

        public final void Yo(List<wh8.a> r10) {
            Intrinsics.checkNotNullParameter(r10, "list");
            if (this.a.get() != null) goto L6;
            this.b.post(new g2(this));
            return;
        L6:
            ArrayList r0 = new ArrayList(r10);
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r1 = r0.iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            r11.add(wh8.a.a((wh8.a) r1.next(), null, null, 4095));
            goto L8
        L10:
            Iterator r12 = r11.iterator();
            boolean r2 = false;
        L12:
            if (r12.hasNext() == false) goto L44;
            wh8.a r3 = (wh8.a) r12.next();
            if (com.larus.bmhome.utils.i.f(r3.a) == false) goto L32;
            boolean r4 = com.bytedance.ai.widget.n.b;
            String r5 = com.bytedance.ai.widget.n.c;
            if (r5 != null) goto L18;
        L21:
            boolean r6 = true;
        L22:
            if (r6 == false) goto L32;
            FLogger r7 = FLogger.a;
            StringBuilder r8 = new StringBuilder("onConversationListChange: find main bot ");
            wc9.e r9 = r3.a;
            if (r9 == null) goto L26;
            String r13 = r9.a;
        L27:
            r8.append(r13);
            r7.i("WidgetRenderServiceImpl", r8.toString());
            wc9.e r14 = r3.a;
            if (r14 == null) goto L30;
            String r15 = r14.a;
        L31:
            com.bytedance.ai.widget.n.c = r15;
            goto L32
        L30:
            r15 = null;
            goto L31
        L26:
            r13 = null;
            goto L27
        L18:
            if (r5.length() == 0) goto L21;
            r6 = false;
        L32:
            Message r16 = r3.c;
            if (r16 != null) goto L35;
        L37:
            boolean r17 = false;
        L38:
            if (r17 == false) goto L12;
            FLogger r18 = FLogger.a;
            StringBuilder r19 = new StringBuilder("preloadWidget convId=");
            wc9.e r20 = r3.a;
            if (r20 == null) goto L42;
            String r21 = r20.a;
        L43:
            r19.append(r21);
            r19.append(" msg=");
            r19.append(r16);
            r18.i("WidgetRenderServiceImpl", r19.toString());
            r2 = true;
            goto L12
        L42:
            r21 = null;
            goto L43
        L35:
            if (r16.getContentType() != 100) goto L37;
            r17 = true;
            goto L38
        L44:
            if (r2 == false) goto L53;
            this.b.post(new h2(this));
            return;
        }

        public final void R70(List r1, List r2) {
            wh8.b.a.a(r1, r2);
        }

        public c(WeakReference<Context> r2, Gson r3, Handler r4) {
            Intrinsics.checkNotNullParameter(r2, "contextRef");
            Intrinsics.checkNotNullParameter(r3, "gson");
            Intrinsics.checkNotNullParameter(r4, "handler");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class d implements k2.u {
        public final /* synthetic */ com.larus.bmhome.chat.api.v0 a;
        public final /* synthetic */ Ref.ObjectRef<AppletWidgetContainer> b;
        public final /* synthetic */ WidgetRenderServiceImpl c;
        public final /* synthetic */ rga.a d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[WidgetEvent.values().length];
                r0[WidgetEvent.SCROLL_TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[WidgetEvent.PAGE_UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[WidgetEvent.TIMING_SETUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void a() {
            ic8.x r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public final void b() {
            ic8.x r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public final void c() {
            AppletWidgetContainer r0 = (AppletWidgetContainer) this.b.element;
            if (r0 == null) goto L5;
            WidgetRenderServiceImpl r1 = this.c;
            rga.a r2 = this.d;
            int r3 = WidgetRenderServiceImpl.i;
            r1.getClass();
            WidgetRenderServiceImpl.q(r0, r2);
        L5:
            ic8.x r4 = this.a.h;
            if (r4 == null) goto L9;
            r4.c();
            return;
        }

        public final void onDestroy() {
            ic8.x r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.onDestroy();
            return;
        }

        public final void onStart() {
            ic8.x r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.onStart();
            return;
        }

        public void onEvent(WidgetEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if (r5 != WidgetEvent.PAGE_UPDATE) goto L7;
            AppletWidgetContainer r0 = (AppletWidgetContainer) this.b.element;
            if (r0 == null) goto L7;
            WidgetRenderServiceImpl r1 = this.c;
            rga.a r2 = this.d;
            int r3 = WidgetRenderServiceImpl.i;
            r1.getClass();
            WidgetRenderServiceImpl.q(r0, r2);
        L7:
            int r6 = a.a[r5.ordinal()];
            if (r6 != 1) goto L10;
            ic8.x r7 = this.a.h;
            if (r7 == null) goto L28;
            r7.onEvent(com.larus.bmhome.chat.bean.WidgetEvent.SCROLL_TO_BOTTOM);
            return;
        L28:
            return;
        L10:
            if (r6 != 2) goto L12;
            ic8.x r8 = this.a.h;
            if (r8 == null) goto L26;
            r8.onEvent(com.larus.bmhome.chat.bean.WidgetEvent.PAGE_UPDATE);
            return;
        L26:
            return;
        L12:
            if (r6 != 3) goto L29;
            ic8.x r9 = this.a.h;
            if (r9 == null) goto L24;
            r9.onEvent(com.larus.bmhome.chat.bean.WidgetEvent.TIMING_SETUP);
            return;
        L24:
            return;
        }

        public d(com.larus.bmhome.chat.api.v0 r1, Ref.ObjectRef<AppletWidgetContainer> r2, WidgetRenderServiceImpl r3, rga.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r4).getLocalIndex()), Long.valueOf(((Message) r3).getLocalIndex()));
        }
    }

    static {
    }

    public final synchronized void r() {
        monitor-enter(this);
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L11
        StringBuilder r3 = new StringBuilder("ensureAISDKInit ");     // Catch: Throwable -> L11
        r3.append(this.e);     // Catch: Throwable -> L11
        r3.append(' ');     // Catch: Throwable -> L11
        AppletServiceDelegate r0 = AppletServiceDelegate.b;     // Catch: Throwable -> L11
        r3.append(r0.isInitialized());     // Catch: Throwable -> L11
        r1.i("WidgetRenderServiceImpl", r3.toString());     // Catch: Throwable -> L11
        if (this.e == false) goto L7;
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r0.isInitialized() == true) goto L9;
        r1.i("BackgroundLazyInit", "event=component_init_request, component=Applet, trigger=first_use");     // Catch: Throwable -> L11
        AppHost.Companion r2 = AppHost.a;     // Catch: Throwable -> L11
        r0.h(r2.getApplication(), com.larus.ivykit.c.a(), r2.isDebug(), pg9.b.a);     // Catch: Throwable -> L11
        this.e = true;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public WidgetRenderServiceImpl() {
        this.a = new Gson();
        this.b = new WeakHashMap();
        this.c = Keva.getRepo("WIDGET_HEIGHT");
        this.d = new Handler(Looper.getMainLooper());
        this.e = AppletServiceDelegate.b.isInitialized();
        this.f = "bot_state";
        this.g = "fpa_common_param";
        this.h = "doubaoapp_da_params";
    }

    public static rga.a w(String r2) {
        IObricIntentWidgetPolicy r0 = (IObricIntentWidgetPolicy) ServiceManager.get().getService(IObricIntentWidgetPolicy.class);
        if (r0 == null) goto L7;
        rga.a r3 = r0.resolve(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return new rga.a(0);
    }

    public final void a(String r3) {
        Iterator<Map.Entry<Object, l2.a>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().a(r3);
        goto L4
    }

    public final void c(List<? extends Object> r27) {
        Intrinsics.checkNotNullParameter(r27, "messageList");
        boolean r2 = com.larus.platform.exp.p.a;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onMessageRefresh ");
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) r27;
        r4.append(r1.size());
        r4.append(" isAISDKInitialized=");
        r4.append(this.e);
        r4.append(" asyncAISDKInit=");
        r4.append(r2);
        r3.i("WidgetRenderServiceImpl", r4.toString());
        if (r2 == false) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WidgetRenderServiceImpl$onMessageRefresh$1(this, null), 3, null);
    L6:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r1.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r7 = r6.next();
        if ((r7 instanceof Message) == false) goto L8;
        r5.add(r7);
        goto L8
    L12:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r5.iterator();
    L14:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if (((Message) r10).getContentType() != 100) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == false) goto L14;
        r8.add(r10);
        goto L14
    L18:
        r11 = false;
        goto L19
    L21:
        List r12 = CollectionsKt.sortedWith(r8, new e());
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L23:
        if (r14.hasNext() == false) goto L55;
        Message r15 = (Message) r14.next();
        String r16 = r15.getMessageId();
        if (r16 != null) goto L27;
        String r17 = "";
    L28:
        String r18 = r15.getConversationId();
        String r19 = r15.getSectionId();
        String r110 = r15.getReplyId();
        String r111 = r15.getSenderId();
        if (com.larus.im.bean.message.a.b0(r15) == true) goto L31;
        String r20 = r15.getContent();
    L54:
        r13.add(new h5.k(r17, r18, r19, r110, r111, t(r20), null, null, 0, s(r15.getExt()), null, false, null, null, 61440));
        goto L23
    L31:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        List r21 = vd9.r.a(r15);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L33:
        if (r23.hasNext() == false) goto L41;
        Object r24 = r23.next();
        if (((Block) r24).getBlockType() != BlockType.BLOCK_TYPE_WIDGET.getValue()) goto L37;
        boolean r25 = true;
    L38:
        if (r25 == false) goto L33;
        r22.add(r24);
        goto L33
    L37:
        r25 = false;
        goto L38
    L41:
        ArrayList r26 = new ArrayList();
        Iterator r28 = r22.iterator();
    L43:
        if (r28.hasNext() == false) goto L50;
        BlockContent r29 = ((Block) r28.next()).getContent();
        if (r29 == null) goto L47;
        AppletBlock r30 = r29.getAppletBlock();
    L48:
        if (r30 == null) goto L43;
        r26.add(r30);
        goto L43
    L47:
        r30 = null;
        goto L48
    L50:
        AppletBlock r31 = (AppletBlock) CollectionsKt.firstOrNull(r26);
        if (r31 == null) goto L53;
        r20 = r31.renderData;
        goto L54
    L53:
        r20 = null;
        goto L54
    L27:
        r17 = r16;
        goto L28
    L55:
        WidgetManager r32 = WidgetManager.h.b();
        if (r32 == null) goto L112;
        Intrinsics.checkNotNullParameter(r13, "list");
        com.bytedance.ai.widget.n r33 = r32.e;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r13, "list");
        if (com.bytedance.ai.widget.n.b == true) goto L112;
        com.bytedance.ai.utils.g r34 = com.bytedance.ai.utils.g.a;
        r34.d("WidgetPrefetcher", "onWidgetMessageRefresh: size=" + r13.size());
        if (r13.isEmpty() == false) goto L63;
        r34.e("WidgetPrefetcher", "onWidgetMessageRefresh: list is NULL");
        goto L112
    L63:
        h5.k r35 = (h5.k) CollectionsKt.first(r13);
        WidgetInfo r36 = r35.f;
        if (Intrinsics.areEqual(com.bytedance.ai.widget.n.c, r35.b) == false) goto L102;
        if (r36 == null) goto L100;
        String r37 = r36.getAppletId();
        if (r37 != null) goto L69;
    L72:
        boolean r38 = true;
    L73:
        if (r38 == true) goto L100;
        String r39 = r36.getWidgetId();
        if (r39 != null) goto L77;
    L80:
        boolean r210 = true;
    L81:
        if (r210 == true) goto L100;
        Keva r40 = com.bytedance.ai.widget.cache.c.a;
        String r112 = r36.getAppletId();
        String r113 = r36.getWidgetId();
        String r114 = r35.a();
        String r41 = r35.b;
        if (r41 != null) goto L86;
        String r115 = "";
    L87:
        String r42 = r35.e;
        if (r42 != null) goto L90;
        String r116 = "";
    L91:
        String r117 = r35.b();
        WidgetInfo r43 = r35.f;
        if (r43 == null) goto L94;
        String r118 = r43.getAppType();
    L95:
        WidgetInfo r44 = r35.f;
        if (r44 == null) goto L98;
        String r119 = r44.getVersionTag();
    L99:
        com.bytedance.ai.widget.cache.c.b(new ConversationWidgetData(r112, r113, r114, r116, r115, r117, null, r118, r119, 64, null));
        goto L102
    L98:
        r119 = null;
        goto L99
    L94:
        r118 = null;
        goto L95
    L90:
        r116 = r42;
        goto L91
    L86:
        r115 = r41;
        goto L87
    L77:
        if (r39.length() == 0) goto L80;
        r210 = false;
        goto L81
    L69:
        if (r37.length() == 0) goto L72;
        r38 = false;
    L100:
        r34.e("WidgetPrefetcher", "onWidgetMessageRefresh: widgetInfo is NULL");
    L102:
        if (r33.a.isClosedForSend() == false) goto L104;
        r34.i("WidgetPrefetcher", "onWidgetMessageRefresh: loadChannel is closed");
        goto L112
    L104:
        Iterator r45 = r13.iterator();
    L106:
        if (r45.hasNext() == false) goto L112;
        h5.k r46 = (h5.k) r45.next();
        com.bytedance.ai.utils.g r47 = com.bytedance.ai.utils.g.a;
        StringBuilder r48 = new StringBuilder("onWidgetMessageRefresh: send ");
        WidgetInfo r49 = r46.f;
        if (r49 == null) goto L110;
        String r50 = r49.getWidgetId();
    L111:
        r48.append(r50);
        r48.append(" on ");
        r48.append(ThreadMethodProxy.currentThread().getName());
        r47.d("WidgetPrefetcher", r48.toString());
        r33.a.trySend-JP2dKIU(r46);
        goto L106
    L110:
        r50 = null;
    L112:
        ArrayList r51 = new ArrayList();
        Iterator r52 = r1.iterator();
    L114:
        if (r52.hasNext() == false) goto L118;
        Object r53 = r52.next();
        if ((r53 instanceof Message) == false) goto L114;
        r51.add(r53);
        goto L114
    L118:
        Iterator r54 = r51.iterator();
        if (r54.hasNext() == true) goto L121;
        Object r55 = null;
    L130:
        Message r56 = (Message) r55;
        if (r56 == null) goto L166;
        Keva r57 = com.bytedance.ai.widget.cache.c.a;
        com.bytedance.ai.widget.cache.c.c = r56.getMessageId();
        return;
    L166:
        return;
    L121:
        r55 = r54.next();
        if (r54.hasNext() == false) goto L130;
        long r58 = ((Message) r55).getLocalIndex();
    L125:
        Object r59 = r54.next();
        long r60 = ((Message) r59).getLocalIndex();
        if (r58 >= r60) goto L129;
        r55 = r59;
        r58 = r60;
    L129:
        if (r54.hasNext() == true) goto L125;
    L5:
        r();
        goto L6
    }

    public final void f(com.larus.bmhome.chat.api.q r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        HashMap r0 = new HashMap();
        String r1 = r4.a;
        if (r1 == null) goto L5;
        r0.put("conversation_id", r1);
    L5:
        String r2 = r4.b;
        if (r2 == null) goto L8;
        r0.put("current_page", r2);
    L8:
        String r5 = r4.c;
        if (r5 == null) goto L11;
        r0.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r5);
    L11:
        AppletRuntimeManager.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        AppletRuntimeManager.e = r0;
    }

    public final void g(Fragment r10) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onHostShow initWhenShowWidget=");
        z2 r2 = z2.a;
        r1.append(r2.T3().a());
        r0.i("WidgetRenderServiceImpl", r1.toString());
        WidgetManager.a r3 = WidgetManager.h;
        WidgetManager.j = r2.T3().a();
        if (r2.T3().a() == true) goto L5;
        r();
    L5:
        l2.a r4 = null;
        if (r10 != null) goto L9;
    L12:
        if (r4 == null) goto L15;
        r4.onHostShow();
        return;
    L15:
        return;
    L9:
        if (this.b.containsKey(r10) == true) goto L11;
        int r5 = l2.b.a;
        l2.a r6 = new WidgetManager();
        Intrinsics.checkNotNullParameter(new h5.j(i5.b(), i5.b(), ve8.d.a(2131103685, r10.requireContext()), i5.q(), i5.y0(v19.c.b(2130971179, null, 2131166727))), "config");
        this.b.put(r10, r6);
    L11:
        r4 = this.b.get(r10);
        goto L12
    }

    public final void h(Fragment r1) {
        l2.a r2 = u(r1);
        if (r2 == null) goto L6;
        r2.onHostHide();
        return;
    }

    public final void j(final List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "msgIds");
        this.d.post(new f2(this, r3));
    }

    public final void l(Fragment r2) {
        l2.a r0 = u(r2);
        if (r0 == null) goto L5;
        r0.onHostDestroy();
    L5:
        this.b.remove(r2);
    }

    public final void n(Context r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        c r0 = new c(new WeakReference(r4), this.a, this.d);
        com.larus.bmhome.chat.api.w r5 = ILegacyChatUiServiceDelegate.b.z8();
        if (r5 == null) goto L8;
        r5.e(r0, false);
        return;
    }

    public final Integer o(String r1) {
        WidgetInfo r2 = t(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getBoxType();
    }

    public final Map<String, String> s(Map<String, String> r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L7;
        String r1 = r4.get(this.f);
        if (r1 == null) goto L7;
        String r2 = (String) r0.put(this.f, r1);
    L7:
        if (r4 == null) goto L11;
        String r3 = r4.get(this.g);
        if (r3 == null) goto L11;
        String r5 = (String) r0.put(this.g, r3);
    L11:
        if (r4 == null) goto L15;
        String r6 = r4.get(this.h);
        if (r6 == null) goto L15;
        String r7 = (String) r0.put(this.h, r6);
    L15:
        return r0;
    }

    public final WidgetInfo t(String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl((WidgetInfo) this.a.fromJson(r3, WidgetInfo.class));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        return (WidgetInfo) r4;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final l2.a u(Fragment r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.b.get(r2);
    }

    public static void q(AppletWidgetContainer r8, rga.a r9) {
        if (r9.b == true) goto L5;
        return;
    L5:
        Integer r10 = r9.c;
        if (r10 == null) goto L8;
        int r6 = c7.b(r10);
    L9:
        r8.w(new h5.j(0, 0, 0, 0.0f, r6));
        WidgetBoxView r11 = r8.z;
        r11.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r11.setForeground(null);
    L12:
        View r12 = r8.engineView();
        if (r12 == null) goto L16;
        r12.setBackgroundColor(0);
        return;
    L16:
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public final String b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        WidgetInfo r5 = t(r4);
        StringBuilder r6 = new StringBuilder();
        String r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getAppletId();
    L6:
        r6.append(r1);
        r6.append('.');
        if (r5 == null) goto L9;
        r0 = r5.getWidgetId();
    L9:
        r6.append(r0);
        return r6.toString();
    L5:
        r1 = null;
        goto L6
    }

    public final void d(Fragment r20, com.larus.bmhome.chat.api.v0 r21) {
        Intrinsics.checkNotNullParameter(r21, "widgetRenderData");
        h5.k r2 = new h5.k(r21.a, r21.c, r21.d, r21.e, r21.b, t(r21.f), r21.g, null, r21.i, s(r21.k), r21.l, r21.n, null, null, 57344);
        l2.a r1 = u(r20);
        if (r1 == null) goto L6;
        r1.e(r2);
        return;
    }

    public final void e(Fragment r2, com.larus.bmhome.chat.api.v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "widgetRenderData");
        l2.a r4 = u(r2);
        if (r4 == null) goto L6;
        r4.g(v(r3, null));
        return;
    }

    public final int i(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        return this.c.getInt(r2, r3);
    }

    public final void k(Fragment r2, Iterable<? extends View> r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleWidgets");
        l2.a r4 = u(r2);
        if (r4 == null) goto L6;
        r4.h(r3);
        return;
    }

    public final h5.k v(com.larus.bmhome.chat.api.v0 r23, d r24) {
        Map r2 = MapsKt.createMapBuilder();
        String r3 = r23.p;
        if (r3 == null) goto L5;
        r2.put("appTheme", r3);
    L5:
        Map r4 = MapsKt.build(r2);
        if (r23.o == null) goto L13;
        String r5 = r23.a;
        String r6 = r23.c;
        String r7 = r23.d;
        String r8 = r23.e;
        String r9 = r23.b;
        WidgetInfo r10 = t(r23.f);
        ViewGroup r11 = r23.g;
        boolean r12 = r23.m;
        int r13 = r23.i;
        int r14 = r23.j;
        Map<String, String> r15 = s(r23.k);
        Map r16 = r23.l;
        String r1 = r23.o;
        Map r17 = MapsKt.createMapBuilder();
        if (com.larus.platform.service.x1.a.a() == false) goto L11;
        r17.put("isMinorMode", CommentScene.COMMENTSCENE_NO_AWEME);
    L11:
        r17.putAll(r4);
        return new f5.a(r5, r6, r7, r8, r9, r10, r11, r24, r13, r14, r15, r16, r12, MapsKt.build(r17), r1);
    L13:
        String r18 = r23.a;
        String r19 = r23.c;
        String r20 = r23.d;
        String r21 = r23.e;
        String r110 = r23.b;
        WidgetInfo r111 = t(r23.f);
        ViewGroup r112 = r23.g;
        boolean r0 = r23.m;
        return new h5.k(r18, r19, r20, r21, r110, r111, r112, r24, r23.i, s(r23.k), r23.l, r0, r4, r23.q, 32768);
    }

    public final Object m(Fragment r8, com.larus.bmhome.chat.api.v0 r9, Continuation<? super com.larus.bmhome.chat.api.r> r10) {
        if ((r10 instanceof WidgetRenderServiceImpl$bindWidget$1) == false) goto L7;
        WidgetRenderServiceImpl$bindWidget$1 r0 = (WidgetRenderServiceImpl$bindWidget$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r12 = (Ref.ObjectRef) r0.L$1;
        rga.a r13 = (rga.a) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L30:
        AppletWidgetContainer r14 = (AppletWidgetContainer) r11;
        if (r14 == null) goto L33;
        r12.element = r14;
        q(r14, r13);
        return new a(this, r14);
    L33:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        FLogger.a.i("WidgetRenderServiceImpl", "bindWidget isAISDKInitialized=" + this.e + ", " + AppletServiceDelegate.b.isInitialized());
        if (z2.a.T3().a() == false) goto L17;
        r();
    L17:
        t(r9.f);
        rga.a r15 = w(r9.f);
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        h5.k r16 = v(r9, new d(r9, r4, this, r15));
        WidgetInfo r5 = r16.f;
        if (r5 != null) goto L20;
    L24:
        l2.a r17 = u(r8);
        if (r17 == null) goto L33;
        r0.L$0 = r15;
        r0.L$1 = r4;
        r0.label = 1;
        Object r18 = r17.b(r16, r0);
        if (r18 != r2) goto L29;
        return r2;
    L29:
        r13 = r15;
        r11 = r18;
        r12 = r4;
        goto L30
    L20:
        if (Intrinsics.areEqual(r5.getAppType(), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L24;
        String r6 = r5.getAppletId();
        if (r6 == null) goto L24;
        AppletV2ServiceDelegate.b.b(r6);
    L7:
        r0 = new WidgetRenderServiceImpl$bindWidget$1(this, r10);
        goto L8
    }

    public final void p(Fragment r1, String r2, String r3) {
        l2.a r4 = u(r1);
        if (r4 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r4.d(r2, r3);
        return;
    }
}

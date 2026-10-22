package com.bytedance.ee.bear.document.event;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.editionmanager.EditionListPluginInterface;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.loader.BaseDocumentLoader;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.e;
import com.bytedance.ee.bear.document.titlebar.NavigationTitle;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.k;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import iu5.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u0000 /2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003./0B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/document/event/OfficeEventPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/event/IEventPlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "()V", "mDeleteListenerList", "", "Lcom/bytedance/ee/bear/document/event/IEventPlugin$OnDeleteListener;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "addDeleteListener", "listener", "addOnDeleteListener", "Lcom/bytedance/ee/bear/document/event/OfficeEventPlugin$OnDeleteListener;", "getPluginId", "removeDeleteListener", "removeOnDeleteListener", "onDetachFromHost", "host", "handleEventDelete", "data", "Lcom/bytedance/ee/bear/document/event/EventModel;", "getDeleteErrorCode", "", "isEditionDoc", "", "reportEditionDeleteBackView", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "handleEditionDocStatus", "handleEventKeyDelete", "handleEventKeyEditionRecover", "showFailed", "code", "e", "", "handlerUnSupportEvent", "event", "dispatchDeleteEvent", "token", "getRealType", "OnDeleteListener", "Companion", "EventHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeEventPlugin extends DocumentPluginV3 implements IEventPlugin<ChameleonPluginHost> {
    public static final a Companion = null;
    private static final String EVENT_DELETE = "NOTE_DELETED";
    private static final String EVENT_KEY_DELETE = "KEY_DELETED";
    private static final String EVENT_KEY_EDITION_RECOVER = "EDITION_RECOVER";
    private static final String TAG = "EventPlugin";
    private final List<IEventPlugin.a> mDeleteListenerList;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<EventModel> {
        public final /* synthetic */ OfficeEventPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeEventPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            EventModel r6 = (EventModel) r4;
            tt5.a.h(OfficeEventPlugin.TAG, "EventModel: " + r6);
            if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L5;
        L7:
            boolean r7 = false;
        L8:
            String r1 = null;
            if (r7 == false) goto L13;
            k r8 = (k) org.koin.java.a.c(k.class, null, null, 6);
            if (TextUtils.isEmpty(r8.m()) == true) goto L13;
            tt5.a.h(OfficeEventPlugin.TAG, " EditionDocument delete return!");
            r8.j(null);
            return;
        L13:
            if (r6 == null) goto L15;
            r1 = r6.getEvent();
        L15:
            if (r1 == null) goto L43;
            String r9 = r6.getEvent();
            if (r9 == null) goto L37;
            int r0 = r9.hashCode();
            if (r0 == (-1118739549)) goto L34;
            if (r0 == 375117305) goto L30;
            if (r0 != 2097412268) goto L37;
            if (r9.equals(OfficeEventPlugin.EVENT_DELETE) == false) goto L37;
            OfficeEventPlugin.access$handleEventDelete(this.a, r6);
            return;
        L30:
            if (r9.equals(OfficeEventPlugin.EVENT_KEY_DELETE) == false) goto L37;
            OfficeEventPlugin.access$handleEventKeyDelete(this.a, r6);
            return;
        L34:
            if (r9.equals(OfficeEventPlugin.EVENT_KEY_EDITION_RECOVER) == false) goto L37;
            OfficeEventPlugin.access$handleEventKeyEditionRecover(this.a, r6);
            return;
        L37:
            OfficeEventPlugin.access$handlerUnSupportEvent(this.a, r6.getEvent());
            return;
        L43:
            return;
        L5:
            if (z05.i.b(OfficeEventPlugin.access$getRealType(this.a)) == false) goto L7;
            r7 = true;
            goto L8
        }
    }

    public interface c extends IEventPlugin.a {
    }

    static {
        Companion = new a();
    }

    private final int getDeleteErrorCode(boolean r1) {
        if (r1 == false) goto L4;
        return -57;
    L4:
        return -55;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public String getPluginId() {
        String r0 = y5.a;
        return y5.f;
    }

    public OfficeEventPlugin() {
        this.mDeleteListenerList = new CopyOnWriteArrayList();
    }

    private final int getRealType() {
        return getDocumentMetadata().getDocumentTypeValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEditionDocStatus() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L8;
        EditionListPluginInterface r0 = (EditionListPluginInterface) findPlugin(EditionListPluginInterface.class);
        if (r0 == null) goto L9;
        r0.handleEventDelete();
        return;
    L9:
        return;
    }

    public static final /* synthetic */ int access$getRealType(OfficeEventPlugin r0) {
        return r0.getRealType();
    }

    private final void dispatchDeleteEvent(String r3) {
        Iterator<T> r0 = this.mDeleteListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IEventPlugin.a r1 = (IEventPlugin.a) r0.next();
        if (r1 == null) goto L4;
        r1.a(r3);
        goto L4
    }

    private final void handleEventDelete(EventModel r6) {
        if (TextUtils.isEmpty(r6.getToken()) == true) goto L23;
        y3 r0 = getDocumentMetadata();     // Catch: Throwable -> L18
        if ((r0 instanceof DocViewModel) == false) goto L7;
        DocViewModel r1 = (DocViewModel) r0;     // Catch: Throwable -> L18
    L8:
        if (r1 == null) goto L10;
        boolean r2 = r1.isEditionDoc();     // Catch: Throwable -> L18
    L11:
        if (r2 == false) goto L13;
        handleEditionDocStatus();     // Catch: Throwable -> L18
    L13:
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).W(r6.getToken());     // Catch: Throwable -> L18
        dispatchDeleteEvent(r6.getToken());     // Catch: Throwable -> L18
        int r7 = getDeleteErrorCode(r2);     // Catch: Throwable -> L18
        if (r2 == false) goto L16;
        reportEditionDeleteBackView(r1);     // Catch: Throwable -> L18
    L16:
        showFailed(r7, new DocException(r7, ""));     // Catch: Throwable -> L18
        return;
    L10:
        r2 = false;
        goto L11
    L7:
        r1 = null;
    L18:
        th = move-exception;
        d.a(TAG, th);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEventKeyDelete(EventModel r3) {
        tt5.a.b(TAG, "handleEventKeyDelete");
        y3 r0 = getDocumentMetadata();
        if (fx4.a.g(r0.getOriginBearUrl()) == true) goto L6;
        r0.updateTitle(new NavigationTitle());
        getTitleBar().clearMenus();
    L6:
        if (TextUtils.isEmpty(r3.getToken()) == true) goto L9;
        dispatchDeleteEvent(r3.getToken());
        showFailed(-56, new DocException(-56, ""));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEventKeyEditionRecover(EventModel r1) {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L8;
        EditionListPluginInterface r2 = (EditionListPluginInterface) findPlugin(EditionListPluginInterface.class);
        if (r2 == null) goto L9;
        r2.recoverEdition();
        return;
    L9:
        return;
    }

    private final void handlerUnSupportEvent(String r7) {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L16;
        x2 r0 = getDocumentLoader();
        if ((r0 instanceof BaseDocumentLoader) == false) goto L25;
        BaseDocumentLoader r1 = (BaseDocumentLoader) r0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "event");
        tt5.a.h(r1.l(), "dispatchUnSupportEvent, event: " + r7);
        Iterator r2 = CollectionsKt.toMutableList(r1.b).iterator();
    L8:
        if (r2.hasNext() == false) goto L26;
        x2.b r3 = (x2.b) r2.next();
    L14:
        e = move-exception;
        tt5.a.e(r1.l(), "dispatchUnSupportEvent failed, e = " + e, e, false);
        d.a(r1.l(), e);
        goto L8
    L11:
        if ((r3 instanceof x2.a) == false) goto L8;
        ((x2.a) r3).a(r7);     // Catch: Exception -> L14
        goto L8
    L26:
        return;
    L25:
        return;
    }

    private final void reportEditionDeleteBackView(DocViewModel r4) {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L17;
        return;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        int r5 = r4.getDocumentTypeValue();     // Catch: Throwable -> L11
    L9:
        ((k) org.koin.java.a.c(k.class, null, null, 6)).r(r5);     // Catch: Throwable -> L11
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        tt5.a.e(TAG, "reportEditionDeleteBackView failed", r7, false);
        return;
    L19:
        return;
    L8:
        r5 = -1;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.event.IEventPlugin
    public void addDeleteListener(IEventPlugin.a r2) {
        if (this.mDeleteListenerList.contains(r2) == true) goto L6;
        this.mDeleteListenerList.add(r2);
        return;
    }

    public final void addOnDeleteListener(c r1) {
        addDeleteListener(r1);
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.notify.event", new b(this));
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.mDeleteListenerList.clear();
    }

    @Override // com.bytedance.ee.bear.document.event.IEventPlugin
    public void removeDeleteListener(IEventPlugin.a r2) {
        this.mDeleteListenerList.remove(r2);
    }

    public final void removeOnDeleteListener(c r1) {
        removeDeleteListener(r1);
    }

    @Override // com.bytedance.ee.bear.document.event.IEventPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$handleEventDelete(OfficeEventPlugin r0, EventModel r1) {
        r0.handleEventDelete(r1);
    }

    public static final /* synthetic */ void access$handleEventKeyDelete(OfficeEventPlugin r0, EventModel r1) {
        r0.handleEventKeyDelete(r1);
    }

    public static final /* synthetic */ void access$handleEventKeyEditionRecover(OfficeEventPlugin r0, EventModel r1) {
        r0.handleEventKeyEditionRecover(r1);
    }

    public static final /* synthetic */ void access$handlerUnSupportEvent(OfficeEventPlugin r0, String r1) {
        r0.handlerUnSupportEvent(r1);
    }

    private final void showFailed(int r3, Throwable r4) {
        x2 r0 = getDocumentLoader();
        if ((r0 instanceof DocumentLoaderV3) == false) goto L6;
        e.a.a((e) r0, r3, r4);
        return;
    }
}

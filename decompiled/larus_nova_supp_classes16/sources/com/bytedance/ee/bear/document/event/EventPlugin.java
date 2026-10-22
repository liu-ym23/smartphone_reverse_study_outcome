package com.bytedance.ee.bear.document.event;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.titlebar.NavigationTitle;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.k;
import iu5.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u0000 (2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003'()B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/event/EventPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/event/IEventPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "()V", "mDeleteListenerList", "", "Lcom/bytedance/ee/bear/document/event/IEventPlugin$OnDeleteListener;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "addDeleteListener", "listener", "addOnDeleteListener", "Lcom/bytedance/ee/bear/document/event/EventPlugin$OnDeleteListener;", "removeDeleteListener", "removeOnDeleteListener", "onDetachFromHost", "host", "handleEventDelete", "data", "Lcom/bytedance/ee/bear/document/event/EventModel;", "handleEditionDocStatus", "handleEventKeyDelete", "handleEventKeyEditionRecover", "showFailed", "code", "", "e", "", "handlerUnSupportEvent", "event", "dispatchDeleteEvent", "token", "getRealType", "OnDeleteListener", "Companion", "EventHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventPlugin extends DocumentPlugin implements IEventPlugin<DocumentPluginHost> {
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
        public final /* synthetic */ EventPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EventPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            EventModel r6 = (EventModel) r4;
            tt5.a.h(EventPlugin.TAG, "EventModel: " + r6);
            String r2 = null;
            k r7 = (k) org.koin.java.a.c(k.class, null, null, 6);
            if (z05.i.b(EventPlugin.access$getRealType(this.a)) == true) goto L5;
        L7:
            if (r6 == null) goto L9;
            r2 = r6.getEvent();
        L9:
            if (r2 == null) goto L37;
            String r8 = r6.getEvent();
            if (r8 == null) goto L31;
            int r0 = r8.hashCode();
            if (r0 == (-1118739549)) goto L28;
            if (r0 == 375117305) goto L24;
            if (r0 != 2097412268) goto L31;
            if (r8.equals(EventPlugin.EVENT_DELETE) == false) goto L31;
            EventPlugin.access$handleEventDelete(this.a, r6);
            return;
        L24:
            if (r8.equals(EventPlugin.EVENT_KEY_DELETE) == false) goto L31;
            EventPlugin.access$handleEventKeyDelete(this.a, r6);
            return;
        L28:
            if (r8.equals(EventPlugin.EVENT_KEY_EDITION_RECOVER) == false) goto L31;
            EventPlugin.access$handleEventKeyEditionRecover(this.a, r6);
            return;
        L31:
            EventPlugin.access$handlerUnSupportEvent(this.a, r6.getEvent());
            return;
        L37:
            return;
        L5:
            if (TextUtils.isEmpty(r7.m()) == true) goto L7;
            tt5.a.h(EventPlugin.TAG, " EditionDocument delete return!");
            r7.j(null);
        }
    }

    public interface c extends IEventPlugin.a {
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handleEditionDocStatus() {
        EditionListPlugin r0 = (EditionListPlugin) findPlugin(EditionListPlugin.class);
        if (r0 == null) goto L6;
        r0.handleEventDelete();
        return;
    }

    public EventPlugin() {
        this.mDeleteListenerList = new CopyOnWriteArrayList();
    }

    private final int getRealType() {
        if (getDocViewModel() == null) goto L10;
        WikiInfo r0 = getDocViewModel().getWikiInfo();
        if (r0 == null) goto L9;
        return r0.getObjType();
    L9:
        return getDocViewModel().getDocumentTypeValue();
    L10:
        return -1;
    }

    public static final /* synthetic */ int access$getRealType(EventPlugin r0) {
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

    private final void handleEventDelete(EventModel r4) {
        if (TextUtils.isEmpty(r4.getToken()) == true) goto L17;
        DocViewModel r0 = getDocViewModel();     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        boolean r1 = r0.isEditionDoc();     // Catch: Throwable -> L12
    L8:
        if (r1 == false) goto L10;
        handleEditionDocStatus();     // Catch: Throwable -> L12
    L10:
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).W(r4.getToken());     // Catch: Throwable -> L12
        dispatchDeleteEvent(r4.getToken());     // Catch: Throwable -> L12
        showFailed(-55, new DocException(-55, ""));     // Catch: Throwable -> L12
        return;
    L7:
        r1 = false;
    L12:
        th = move-exception;
        d.a(TAG, th);
        return;
    }

    private final void handleEventKeyDelete(EventModel r3) {
        tt5.a.b(TAG, "handleEventKeyDelete");
        if (fx4.a.g(getDocViewModel().getOriginBearUrl()) == true) goto L6;
        getDocViewModel().updateTitle(new NavigationTitle());
        getTitleBar().clearMenus();
    L6:
        if (TextUtils.isEmpty(r3.getToken()) == true) goto L9;
        dispatchDeleteEvent(r3.getToken());
        showFailed(-56, new DocException(-56, ""));
        return;
    }

    private final void handleEventKeyEditionRecover(EventModel r1) {
        EditionListPlugin r2 = (EditionListPlugin) findPlugin(EditionListPlugin.class);
        if (r2 == null) goto L6;
        r2.recoverEdition();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handlerUnSupportEvent(String r3) {
        if (getDocViewModel() == null) goto L8;
        x2 r0 = ((DocumentPluginHost) getHost()).getDocumentLoader();
        if ((r0 instanceof y4) == false) goto L9;
        ((y4) r0).n(r3);
        return;
    L9:
        return;
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

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.notify.event", new b(this));
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        this.mDeleteListenerList.clear();
    }

    @Override // com.bytedance.ee.bear.document.event.IEventPlugin
    public void removeDeleteListener(IEventPlugin.a r2) {
        this.mDeleteListenerList.remove(r2);
    }

    public final void removeOnDeleteListener(c r1) {
        removeDeleteListener(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$handleEventDelete(EventPlugin r0, EventModel r1) {
        r0.handleEventDelete(r1);
    }

    public static final /* synthetic */ void access$handleEventKeyDelete(EventPlugin r0, EventModel r1) {
        r0.handleEventKeyDelete(r1);
    }

    public static final /* synthetic */ void access$handleEventKeyEditionRecover(EventPlugin r0, EventModel r1) {
        r0.handleEventKeyEditionRecover(r1);
    }

    public static final /* synthetic */ void access$handlerUnSupportEvent(EventPlugin r0, String r1) {
        r0.handlerUnSupportEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showFailed(int r3, Throwable r4) {
        if (getDocViewModel() == null) goto L8;
        x2 r0 = ((DocumentPluginHost) getHost()).getDocumentLoader();
        if ((r0 instanceof y4) == false) goto L9;
        ((y4) r0).c(r3, r4);
        return;
    L9:
        return;
    }
}

package com.bytedance.ee.bear.document.scroll;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/scroll/ScrollOffsetPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "offsetData", "Lcom/bytedance/ee/bear/document/scroll/ScrollOffsetPlugin$OffsetData;", "mWebScrollOffsetChangeListners", "Ljava/util/LinkedList;", "Lcom/bytedance/ee/bear/document/scroll/ScrollOffsetPlugin$WebScrollOffsetChangeListner;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "addWebScrollOffsetListner", "listner", "removeWebScrollOffsetChangeListner", "notfyWebScrollOffsetChange", "JSNotifyScrollOffsetHandler", "OffsetData", "WebScrollOffsetChangeListner", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollOffsetPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String JS_NOTIFY_SCROLLY = "biz.util.notifyScrollY";
    private static final String TAG = "ScrollOffsetPlugin";
    private LinkedList<d> mWebScrollOffsetChangeListners;
    private c offsetData;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollOffsetPlugin f221507a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ScrollOffsetPlugin r100) {
            this.f221507a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            if (r102 != null) goto L10;
            tt5.a.h(ScrollOffsetPlugin.TAG, "js notify scroll offset, data is null");
            return;
        L10:
            JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L7
            ScrollOffsetPlugin.access$setOffsetData$p(this.f221507a, new c());     // Catch: Throwable -> L7
            c r104 = ScrollOffsetPlugin.access$getOffsetData$p(this.f221507a);     // Catch: Throwable -> L7
            r104.f221508a = n.c((float) JSONObjectProtectorUtils.getDouble(r103, "scrollTop"));     // Catch: Throwable -> L7
            ScrollOffsetPlugin r105 = this.f221507a;     // Catch: Throwable -> L7
            ScrollOffsetPlugin.access$notfyWebScrollOffsetChange(r105, ScrollOffsetPlugin.access$getOffsetData$p(r105));     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            tt5.a.m(ScrollOffsetPlugin.TAG, th);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f221508a;

        public c() {
        }
    }

    public interface d {
        void a(c r100);
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public ScrollOffsetPlugin() {
        this.offsetData = new c();
        this.mWebScrollOffsetChangeListners = new LinkedList();
    }

    public static final /* synthetic */ c access$getOffsetData$p(ScrollOffsetPlugin r100) {
        return r100.offsetData;
    }

    private final void notfyWebScrollOffsetChange(c r100) {
        StringBuilder r101 = new StringBuilder("js notify scroll offset, offsetY = 0 , scrollTop = ");
        r100.getClass();
        r101.append(r100.f221508a);
        tt5.a.b(TAG, r101.toString());
        Iterator<d> r102 = this.mWebScrollOffsetChangeListners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100);
        goto L4
    }

    public final void addWebScrollOffsetListner(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listner");
        if (this.mWebScrollOffsetChangeListners.contains(r100) == true) goto L6;
        this.mWebScrollOffsetChangeListners.add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(JS_NOTIFY_SCROLLY, new b(this));
    }

    public final void removeWebScrollOffsetChangeListner(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listner");
        this.mWebScrollOffsetChangeListners.remove(r100);
    }

    public static final /* synthetic */ void access$notfyWebScrollOffsetChange(ScrollOffsetPlugin r100, c r101) {
        r100.notfyWebScrollOffsetChange(r101);
    }

    public static final /* synthetic */ void access$setOffsetData$p(ScrollOffsetPlugin r100, c r101) {
        r100.offsetData = r101;
    }
}

package com.bytedance.bdp.live.livecontainer.miniapp;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import na4.a;
import na4.e;
import org.json.JSONObject;
import ya4.b;
import ya4.f;
import ya4.g;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J<\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0012j\u0002`\u0015JI\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0012j\u0002`\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0013J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010'J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002J\u000e\u0010/\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200J\u000e\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R&\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020005048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/miniapp/MiniAppPluginEventManager;", "", "", "appId", "", "clickMoreButton", "clickUnMountButton", "path", "query", "openReportPage", "openSettingPage", "Landroid/os/Bundle;", "param", "notifyMiniAppHide", "notifyMiniAppShow", "page", "Lya4/f;", "pageParams", "Lkotlin/Function2;", "", "Lcom/bytedance/bdp/live/livecontainer/miniapp/PageStatus;", "Lcom/bytedance/bdp/live/livecontainer/miniapp/MiniAppPluginEventCallBack;", "callLoadingFinish", "mountToLive", "show", "showOrHideCard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)V", "isMountedInLive", "Lya4/g;", "getCurPageConfig", "unMount", "updateScreenPage", "cancel", "logLiveCastMenuItemClick", "logLiveCastMenuItemShow", "startFromLiveOpenPlatform", "", "castWidth", "caseHeight", "Lorg/json/JSONObject;", "extraParam", "notifyLiveCastStart", "exitReason", "onMiniAppExit", "notifyLiveCastStop", "errMsg", "notifyLiveCastError", "isLiveCasting", "Lna4/a;", "listener", "addCustomEventListener", "removeCustomEventListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "listenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
public final class MiniAppPluginEventManager {
    public static final MiniAppPluginEventManager INSTANCE = null;
    private static final ConcurrentHashMap<String, WeakReference<a>> listenerMap = null;

    private MiniAppPluginEventManager() {
    }

    static {
        INSTANCE = new MiniAppPluginEventManager();
        listenerMap = new ConcurrentHashMap();
    }

    public final void clickMoreButton(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        if (r101 == null) goto L8;
        a r102 = r101.get();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        r103.put("event", "clickMore");
        r102.onEvent(r103);
        return;
    L9:
        return;
    }

    public final void clickUnMountButton(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        if (r101 == null) goto L8;
        a r102 = r101.get();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        r103.put("event", "clickUnMount");
        r102.onEvent(r103);
        return;
    L9:
        return;
    }

    public final boolean isLiveCasting(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        a r102 = null;
        if (r101 == null) goto L5;
        a r103 = r101.get();
    L7:
        if ((r103 instanceof e) == false) goto L10;
        r102 = r103;
    L10:
        e r104 = (e) r102;
        if (r104 != null) goto L15;
        return false;
    L15:
        return r104.b();
    L5:
        r103 = null;
        goto L7
    }

    public final boolean isMountedInLive(String r100) {
        WeakReference<a> r101 = listenerMap.get(r100);
        a r102 = null;
        if (r101 == null) goto L5;
        a r103 = r101.get();
    L7:
        if ((r103 instanceof e) == false) goto L10;
        r102 = r103;
    L10:
        e r104 = (e) r102;
        if (r104 != null) goto L15;
        return false;
    L15:
        return r104.c();
    L5:
        r103 = null;
        goto L7
    }

    public final void notifyMiniAppShow(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        if (r101 == null) goto L8;
        a r102 = r101.get();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        cb4.a.a();
        r103.put("event", "miniAppShow");
        r102.onEvent(r103);
        return;
    L9:
        return;
    }

    public final void openSettingPage(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        if (r101 == null) goto L8;
        a r102 = r101.get();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        cb4.a.a();
        r103.put("event", "openSettingPage");
        r102.onEvent(r103);
        return;
    L9:
        return;
    }

    public final void removeCustomEventListener(String r100) {
        cb4.a.a();
        listenerMap.remove(r100);
    }

    public final boolean startFromLiveOpenPlatform(String r100) {
        return listenerMap.containsKey(r100);
    }

    public final void unMount(String r100) {
        cb4.a.a();
        WeakReference<a> r101 = listenerMap.get(r100);
        if (r101 == null) goto L8;
        a r102 = r101.get();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        cb4.a.a();
        r103.put("event", "unMount");
        r102.onEvent(r103);
        return;
    L9:
        return;
    }

    public final void addCustomEventListener(String r100, a r101) {
        cb4.a.a();
        listenerMap.put(r100, new WeakReference(r101));
    }

    public final g getCurPageConfig(String r100, String r101) {
        WeakReference<a> r102 = listenerMap.get(r100);
        a r103 = null;
        if (r102 == null) goto L5;
        a r104 = r102.get();
    L7:
        if ((r104 instanceof e) == false) goto L10;
        r103 = r104;
    L10:
        e r105 = (e) r103;
        if (r105 == null) goto L15;
        g r106 = r105.a();
        if (r106 == null) goto L15;
    L16:
        int r107 = cb4.a.f23001a;
        r106.toString();
        cb4.a.a();
        return r106;
    L15:
        r106 = new g(PageStatus.ADD);
        goto L16
    L5:
        r104 = null;
        goto L7
    }

    public final void logLiveCastMenuItemClick(String r100, boolean r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        r104.put("event", "logLiveCastBtnClick");
        JSONObject r105 = new JSONObject();
        r105.put("cancel", r101);
        r105.put("appId", r100);
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void logLiveCastMenuItemShow(String r100, boolean r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        r104.put("event", "logLiveCastBtnShow");
        JSONObject r105 = new JSONObject();
        r105.put("cancel", r101);
        r105.put("appId", r100);
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void notifyLiveCastError(String r100, String r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        r104.put("event", "liveCastError");
        JSONObject r105 = new JSONObject();
        r105.put("errMsg", r101);
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void notifyLiveCastStop(String r100, JSONObject r101) {
        int r102 = cb4.a.f23001a;
        Objects.toString(r101);
        cb4.a.a();
        WeakReference<a> r103 = listenerMap.get(r100);
        if (r103 == null) goto L8;
        a r104 = r103.get();
        if (r104 == null) goto L9;
        JSONObject r105 = new JSONObject();
        r105.put("event", "liveCastStop");
        JSONObject r106 = new JSONObject();
        r106.put("extraParam", r101);
        r105.put("param", r106);
        r104.onEvent(r105);
        return;
    L9:
        return;
    }

    public final void notifyMiniAppHide(String r100, Bundle r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        cb4.a.a();
        r104.put("event", "miniAppHide");
        JSONObject r105 = new JSONObject();
        r105.put("exit_reason", r101.getString("exit_reason"));
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void onMiniAppExit(String r100, String r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        r104.put("event", "miniAppExit");
        JSONObject r105 = new JSONObject();
        r105.put("exitReason", r101);
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void updateScreenPage(String r100, String r101) {
        cb4.a.a();
        WeakReference<a> r102 = listenerMap.get(r100);
        if (r102 == null) goto L8;
        a r103 = r102.get();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        r104.put("event", "updateScreenPage");
        JSONObject r105 = new JSONObject();
        r105.put("page", r101);
        r104.put("param", r105);
        r103.onEvent(r104);
        return;
    L9:
        return;
    }

    public final void openReportPage(String r100, String r101, String r102) {
        cb4.a.a();
        WeakReference<a> r103 = listenerMap.get(r100);
        if (r103 == null) goto L8;
        a r104 = r103.get();
        if (r104 == null) goto L9;
        JSONObject r105 = new JSONObject();
        cb4.a.a();
        r105.put("event", "openReportPage");
        JSONObject r106 = new JSONObject();
        r106.put("path", r101);
        r106.put("query", r102);
        r105.put("param", r106);
        r104.onEvent(r105);
        return;
    L9:
        return;
    }

    public final void mountToLive(String r100, String r101, f r102, Function2<? super Boolean, ? super PageStatus, Unit> r103) {
        cb4.a.a();
        WeakReference<a> r104 = listenerMap.get(r100);
        a r105 = null;
        if (r104 == null) goto L5;
        a r106 = r104.get();
    L7:
        if ((r106 instanceof e) == false) goto L10;
        r105 = r106;
    L10:
        e r107 = (e) r105;
        if (r107 == null) goto L14;
        r107.e();
        return;
    L14:
        return;
    L5:
        r106 = null;
        goto L7
    }

    public final void notifyLiveCastStart(String r100, int r101, int r102, JSONObject r103) {
        cb4.a.a();
        WeakReference<a> r104 = listenerMap.get(r100);
        if (r104 == null) goto L8;
        a r105 = r104.get();
        if (r105 == null) goto L9;
        JSONObject r106 = new JSONObject();
        r106.put("event", "liveCastStart");
        JSONObject r107 = new JSONObject();
        r107.put("castWidth", r101);
        r107.put("caseHeight", r102);
        r107.put("extraParam", r103);
        r106.put("param", r107);
        r105.onEvent(r106);
        return;
    L9:
        return;
    }

    public final void showOrHideCard(String r100, String r101, Boolean r102, Function2<? super Boolean, ? super PageStatus, Unit> r103) {
        cb4.a.a();
        if (r102 == null) goto L5;
        r102.booleanValue();
    L11:
        WeakReference<a> r104 = listenerMap.get(r100);
        a r105 = null;
        if (r104 == null) goto L14;
        a r106 = r104.get();
    L16:
        if ((r106 instanceof e) == false) goto L19;
        r105 = r106;
    L19:
        e r107 = (e) r105;
        if (r107 == null) goto L23;
        r107.d();
        return;
    L23:
        return;
    L14:
        r106 = null;
        goto L16
    L5:
        int r108 = b.f567020a[getCurPageConfig(r100, r101).a().ordinal()];
        if (r108 == 1) goto L11;
        if (r108 == 2) goto L11;
        cb4.a.a();
    }

    public static /* synthetic */ void openReportPage$default(MiniAppPluginEventManager r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.openReportPage(r101, r102, r103);
    }

    public static /* synthetic */ void showOrHideCard$default(MiniAppPluginEventManager r100, String r101, String r102, Boolean r103, Function2 r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = Boolean.FALSE;
    L8:
        r100.showOrHideCard(r101, r102, r103, r104);
    }
}

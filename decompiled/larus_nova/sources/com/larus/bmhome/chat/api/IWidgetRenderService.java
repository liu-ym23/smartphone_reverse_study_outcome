package com.larus.bmhome.chat.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u001a\u0010\u001c\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u001c\u0010\u001d\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J \u0010 \u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\"H&J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0012\u0010$\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0012\u0010%\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J&\u0010&\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010)\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010*\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,H&J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H&J\u0018\u00100\u001a\u00020\u00112\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,H&¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/api/IWidgetRenderService;", "", "getItemKey", "", RemoteMessageConst.MSGID, "renderData", "getBoxType", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "compareData", "", "oldRenderData", "newRenderData", "getSavedHeight", "defValue", "getArchiveText", "preloadWidgets", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindWidget", "Lcom/larus/bmhome/chat/api/IAppletWidgetContainer;", "host", "Landroidx/fragment/app/Fragment;", "widgetRenderData", "Lcom/larus/bmhome/chat/api/WidgetRenderData;", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/chat/api/WidgetRenderData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidget", "onWidgetRecycled", "onWidgetArchived", "view", "Landroid/view/View;", "onWidgetVisibleChanged", "visibleWidgets", "", "onHostShow", "onHostHide", "onHostDestroy", "onConversationChanged", "convId", "sectionId", "onChatHistoryClear", "onMessageRemoved", "msgIds", "", "setEventCommonParam", "param", "Lcom/larus/bmhome/chat/api/EventParam;", "onMessageRefresh", "messageList", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWidgetRenderService {
    void a(String r100);

    String b(String r100, String r101);

    void c(List<? extends Object> r100);

    void d(Fragment r100, v0 r101);

    void e(Fragment r100, v0 r101);

    void f(q r100);

    void g(Fragment r100);

    void h(Fragment r100);

    int i(String r100, int r101);

    void j(List<String> r100);

    void k(Fragment r100, Iterable<? extends View> r101);

    void l(Fragment r100);

    Object m(Fragment r100, v0 r101, Continuation<? super r> r102);

    void n(Context r100);

    Integer o(String r100);

    void p(Fragment r100, String r101, String r102);
}

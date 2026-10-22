package com.larus.bmhome.chat.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J \u0010#\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0016J\u0012\u0010&\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010'\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010)\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010,\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010-\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020\u00142\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050/H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/api/WidgetRenderDelegate;", "Lcom/larus/bmhome/chat/api/IWidgetRenderService;", "<init>", "()V", "impl", "getItemKey", "", RemoteMessageConst.MSGID, "renderData", "getBoxType", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "compareData", "", "oldRenderData", "newRenderData", "getSavedHeight", "defValue", "getArchiveText", "preloadWidgets", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindWidget", "Lcom/larus/bmhome/chat/api/IAppletWidgetContainer;", "host", "Landroidx/fragment/app/Fragment;", "widgetRenderData", "Lcom/larus/bmhome/chat/api/WidgetRenderData;", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/chat/api/WidgetRenderData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidget", "onWidgetRecycled", "onWidgetArchived", "view", "Landroid/view/View;", "onWidgetVisibleChanged", "visibleWidgets", "", "onHostShow", "onHostHide", "onHostDestroy", "onConversationChanged", "convId", "sectionId", "onChatHistoryClear", "onMessageRemoved", "msgIds", "", "setEventCommonParam", "param", "Lcom/larus/bmhome/chat/api/EventParam;", "onMessageRefresh", "messageList", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetRenderDelegate implements IWidgetRenderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WidgetRenderDelegate f297181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IWidgetRenderService f297182b = null;

    private WidgetRenderDelegate() {
    }

    static {
        f297181a = new WidgetRenderDelegate();
        f297182b = (IWidgetRenderService) ServiceManager.get().getService(IWidgetRenderService.class);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void a(String r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void c(List<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageList");
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void f(q r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void g(Fragment r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void h(Fragment r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void j(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "msgIds");
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void l(Fragment r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.l(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void n(Context r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 == null) goto L6;
        r101.n(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final Integer o(String r100) {
        IWidgetRenderService r101 = f297182b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.o(r100);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        IWidgetRenderService r102 = f297182b;
        if (r102 == null) goto L9;
        String r103 = r102.b(r100, r101);
        if (r103 != null) goto L8;
        return r100;
    L8:
        return r103;
    L9:
        return r100;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void d(Fragment r100, v0 r101) {
        Intrinsics.checkNotNullParameter(r101, "widgetRenderData");
        IWidgetRenderService r102 = f297182b;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void e(Fragment r100, v0 r101) {
        Intrinsics.checkNotNullParameter(r101, "widgetRenderData");
        IWidgetRenderService r102 = f297182b;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final int i(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        IWidgetRenderService r102 = f297182b;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.i(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void k(Fragment r100, Iterable<? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "visibleWidgets");
        IWidgetRenderService r102 = f297182b;
        if (r102 == null) goto L6;
        r102.k(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final Object m(Fragment r100, v0 r101, Continuation<? super r> r102) {
        IWidgetRenderService r103 = f297182b;
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.m(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void p(Fragment r100, String r101, String r102) {
        IWidgetRenderService r103 = f297182b;
        if (r103 == null) goto L6;
        r103.p(r100, r101, r102);
        return;
    }
}

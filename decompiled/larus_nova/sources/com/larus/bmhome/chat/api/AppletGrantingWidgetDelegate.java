package com.larus.bmhome.chat.api;

import android.content.Context;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/api/AppletGrantingWidgetDelegate;", "Lcom/larus/bmhome/chat/api/IAppletGrantingWidgetService;", "<init>", "()V", "impl", "bindData", "Lcom/larus/bmhome/chat/api/CardModel;", "permissionData", "", "msgData", "Lcom/larus/bmhome/chat/api/MsgData;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/larus/bmhome/chat/api/Delegate;", "unbindData", "", "onExpose", "onUnexpose", "operateResult", "agree", "", "weakReference", "Landroid/content/Context;", "cardModel", "onNewMessageInput", "latestMsgID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletGrantingWidgetDelegate implements IAppletGrantingWidgetService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletGrantingWidgetDelegate f297128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IAppletGrantingWidgetService f297129b = null;

    private AppletGrantingWidgetDelegate() {
    }

    static {
        f297128a = new AppletGrantingWidgetDelegate();
        f297129b = (IAppletGrantingWidgetService) ServiceManager.get().getService(IAppletGrantingWidgetService.class);
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "latestMsgID");
        IAppletGrantingWidgetService r101 = f297129b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void d(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "msgData");
        IAppletGrantingWidgetService r101 = f297129b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void e(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "msgData");
        IAppletGrantingWidgetService r101 = f297129b;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void b(boolean r100, WeakReference<Context> r101, f r102) {
        Intrinsics.checkNotNullParameter(r101, "weakReference");
        Intrinsics.checkNotNullParameter(r102, "cardModel");
        IAppletGrantingWidgetService r103 = f297129b;
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final f c(String r100, r0 r101, WeakReference<k> r102) {
        Intrinsics.checkNotNullParameter(r100, "permissionData");
        Intrinsics.checkNotNullParameter(r101, "msgData");
        Intrinsics.checkNotNullParameter(r102, "delegate");
        IAppletGrantingWidgetService r103 = f297129b;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.c(r100, r101, r102);
    }
}

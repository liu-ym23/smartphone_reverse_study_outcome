package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bytedance.ai.applet.components.page.AppletPageActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.IRenderLiteService;
import com.larus.common.apphost.AppHost;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/applet/impl/RenderLiteServiceImpl;", "Lcom/larus/bmhome/chat/api/IRenderLiteService;", "<init>", "()V", "lynxPageHostWhitelist", "", "", "getLynxPageHostWhitelist", "()Ljava/util/List;", "lynxPageHostWhitelist$delegate", "Lkotlin/Lazy;", "hasDebugImplModule", "", "getHasDebugImplModule", "()Z", "hasDebugImplModule$delegate", "createLiteView", "Landroid/view/View;", "context", "Landroid/content/Context;", "templateUrl", "lifecycle", "Lcom/larus/bmhome/chat/bean/IRenderLiteLifeCycle;", "initData", "updateLiteViewData", "", "liteView", "renderData", "destroyLiteView", "openPage", "uri", "Landroid/net/Uri;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderLiteServiceImpl implements IRenderLiteService {
    public final Lazy a;
    public final Lazy b;

    public RenderLiteServiceImpl() {
        this.a = LazyKt.lazy(new c2());
        this.b = LazyKt.lazy(new d2());
    }

    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "liteView");
        if ((r2 instanceof com.bytedance.ai.lite.view.b) == false) goto L5;
        com.bytedance.ai.lite.view.b r3 = (com.bytedance.ai.lite.view.b) r2;
    L6:
        if (r3 == null) goto L9;
        r3.a();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "liteView");
        Intrinsics.checkNotNullParameter(r3, "renderData");
        if ((r2 instanceof com.bytedance.ai.lite.view.b) == false) goto L5;
        com.bytedance.ai.lite.view.b r4 = (com.bytedance.ai.lite.view.b) r2;
    L6:
        if (r4 == null) goto L9;
        r4.b(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void b(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        String r2 = UriProtector.getQueryParameter(r11, "url");
        if (r2 != null) goto L5;
        return;
    L5:
        String r3 = UriProtector.parse(r2).getHost();
        List r4 = (List) this.a.getValue();
        boolean r5 = false;
        if ((r4 instanceof Collection) == true) goto L8;
    L10:
        Iterator r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) r6.next();
        if (r3 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L12;
        r5 = true;
        goto L21
    L16:
        if (StringsKt.endsWith$default(r3, r7, false, 2, null) != true) goto L18;
        r8 = true;
    L21:
        if (r5 == false) goto L23;
        int r9 = d5.a.a;
        String r12 = r11.toString();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "url");
        com.bytedance.ai.utils.g.a.i("LiteViewService", "openPage: url = " + r12);
        com.bytedance.ai.applet.components.page.c.a(r12);     // Catch: Exception -> L29
        Intent r0 = new Intent(r10, AppletPageActivity.class);
        r0.putExtra("ARG_URL", r12);
        r10.startActivity(r0);
        return;
    L29:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LiteViewService", "openPage: url parse error", e);
        return;
    L23:
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L39;
        t19.s r13 = t19.s.a;
        Application r14 = AppHost.a.getApplication();
        r13.getClass();
        t19.s.t(r14, "This link does not hit the host whitelist and cannot be accessed as full page");
        return;
    L39:
        return;
    L8:
        if (r4.isEmpty() == false) goto L10;
        goto L10
    }

    public final View c(Context r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "templateUrl");
        int r2 = d5.a.a;
        e2 r3 = new e2();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "templateUrl");
        com.bytedance.ai.lite.view.a r0 = new com.bytedance.ai.lite.view.a(r4);
        r0.c(r5, r3, r6);
        return r0;
    }
}

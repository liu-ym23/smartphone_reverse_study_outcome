package com.obric.assistant.chat;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.h4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386974a = 0;

    static {
    }

    public static t1a.b b() {
        if (HomeService.f344094a.o() == true) goto L13;
        ComponentCallbacks2 r100 = AppHost.f326268a.a().getCurrentActivity();
        if ((r100 instanceof d4) == false) goto L8;
        d4 r101 = (d4) r100;
    L9:
        if (r101 == null) goto L12;
        return r101.getVContext();
    L12:
        return null;
    L8:
        r101 = null;
        goto L9
    L13:
        return c();
    }

    public static t1a.b c() {
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isShowing() != true) goto L7;
    L8:
        if (r101 == false) goto L12;
        return r100.provideWindowVContext();
    L12:
        return a(AppHost.f326268a.a().getCurrentActivity());
    L7:
        r101 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static t1a.b a(Activity r100) {
        Object r101 = null;
        if (r100 != 0) goto L33;
        return null;
    L33:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        HomeService r103 = HomeService.f344094a;     // Catch: Throwable -> L25
        if (r103.o() == false) goto L8;
        xe8.a r104 = r103.v(r100);     // Catch: Throwable -> L25
        if (r104 == null) goto L17;
        t1a.b r105 = r104.WF();     // Catch: Throwable -> L25
    L18:
        if (r105 == null) goto L20;
    L22:
        t1a.b r106 = r105;
    L23:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r107) == true) goto L32;
        r101 = r107;
    L32:
        return (t1a.b) r101;
    L20:
        if (e(r100) == false) goto L22;
        FLogger.f375446a.i("ObricChatPageCompat", "query chat context: no selected chat, host=".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L25
        goto L22
    L17:
        r105 = null;
        goto L18
    L8:
        if ((r100 instanceof d4) == false) goto L10;
        d4 r108 = (d4) r100;     // Catch: Throwable -> L25
    L11:
        if (r108 == null) goto L13;
        r106 = r108.getVContext();     // Catch: Throwable -> L25
        goto L23
    L13:
        r106 = null;
        goto L23
    L10:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    public static boolean d(Activity r100) {
        if ((r100 instanceof d4) == false) goto L5;
    L10:
        return true;
    L5:
        if (HomeService.f344094a.o() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r100 instanceof j4) == false) goto L9;
        goto L9
    }

    public static boolean e(Activity r100) {
        if ((r100 instanceof h4) == false) goto L5;
    L10:
        return true;
    L5:
        if (HomeService.f344094a.o() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r100 instanceof j4) == false) goto L9;
        goto L9
    }

    public static boolean f(FragmentActivity r100, com.larus.bmhome.chat.component.cvs.y r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (AppHost.f326268a.a().getCurrentActivity() == r100) goto L5;
        return false;
    L5:
        HomeService r102 = HomeService.f344094a;
        if (r102.o() == false) goto L8;
        xe8.a r103 = r102.v(r100);
        if (r101 == null) goto L19;
        if (r103 == null) goto L15;
        t1a.b r104 = r103.WF();
        if (r104 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r105 = (com.larus.bmhome.chat.component.cvs.y) r104.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L16:
        if (r105 != r101) goto L20;
        return true;
    L20:
        return false;
    L15:
        r105 = null;
        goto L16
    L19:
        return false;
    L8:
        return r100 instanceof h4;
    }
}

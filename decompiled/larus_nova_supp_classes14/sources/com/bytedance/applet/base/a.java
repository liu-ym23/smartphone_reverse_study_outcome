package com.bytedance.applet.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetCancelSource;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.i;
import f2.g;
import f2.j;
import g2.f;
import java.util.Arrays;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a implements g2.b {

    /* JADX INFO: renamed from: com.bytedance.applet.base.a$a, reason: collision with other inner class name */
    public static final class C0053a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ f a;

        public final void onAllActivityDestroyed() {
            Function0 r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public final void onAppBackground() {
            Function0 r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public final void onAppForeground() {
            Function0 r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public b(f r1) {
            this.a = r1;
        }
    }

    static {
    }

    public a() {
    }

    public void A() {
    }

    public void C(g r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
    }

    public void D(Context r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public void E(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "queryMsgId");
    }

    public String I(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsID");
        return null;
    }

    public Object J(String r1, Continuation<? super Bitmap> r2) {
        return null;
    }

    public void K(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    public Activity O() {
        return null;
    }

    public Map<String, Object> P() {
        return null;
    }

    public void b(boolean r1) {
    }

    public void d(AppletAppActivity r1, int r2, String r3, String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public String e() {
        return null;
    }

    public Map<String, Object> getSettings() {
        return null;
    }

    public g2.a h() {
        return null;
    }

    public void k(String r1, String r2) {
    }

    public Activity m() {
        return null;
    }

    public void q(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "toastIconType");
        Intrinsics.checkNotNullParameter(r3, "toastContent");
    }

    public View.OnLongClickListener s(WidgetContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetContainer");
        return null;
    }

    public Activity z() {
        return null;
    }

    public final Activity currentActivity() {
        AppHost.Companion r0 = AppHost.a;
        Activity r1 = r0.a().getCurrentActivity();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return (Activity) CollectionsKt.lastOrNull(r0.a().g());
    }

    public final String f() {
        AppHost.Companion r0 = AppHost.a;
        ContextWrapper r1 = r0.a().getCurrentActivity();
        if (r1 != null) goto L5;
        r1 = r0.getApplication();
    L5:
        int r2 = r1.getResources().getColor(v19.c.b(2130970529, r1, 2131102529));
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format("#%02X%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(r2)), Integer.valueOf(Color.green(r2)), Integer.valueOf(Color.blue(r2)), Integer.valueOf(Color.alpha(r2))}, 4));
    }

    public WidgetResourceLoader B(ConversationWidgetData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return new WidgetResourceLoader(r2);
    }

    public final Pair<Integer, Integer> L(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if ((r3 instanceof FlowCommonAppCompatActivity) == false) goto L5;
        FlowCommonAppCompatActivity r4 = (FlowCommonAppCompatActivity) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.D1();
    L5:
        r4 = null;
        goto L6
    }

    public int R(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return 0;
    }

    public void c(Function2<? super Boolean, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.invoke(Boolean.FALSE, "Not supported by the current AppletService");
    }

    public AIFragmentBase g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        return new c();
    }

    public final int getStatusBarHeight(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return i.e(r2);
    }

    public final void i(f r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r3 = r2.d;
        if ((r3 instanceof f09.a.b) == false) goto L5;
        f09.a.b r4 = (f09.a.b) r3;
    L6:
        if (r4 == null) goto L9;
        AppHost.a.a().c(r4);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final int j(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Color.argb(1, 255, 255, 255);
    }

    public final boolean o(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r1 = h.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        if (h.c(r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public AppletChatInputController p(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new d();
    }

    public final void u(j r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        AppHost.a.a().j(new com.bytedance.applet.base.b(r3));
    }

    public final boolean v(Context r2) {
        boolean r0 = h.a;
        return h.a(r2);
    }

    public final void w(f r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Object r0 = r3.d;
        if ((r0 instanceof f09.a.b) == false) goto L5;
        f09.a.b r1 = (f09.a.b) r0;
    L6:
        if (r1 != null) goto L8;
        r1 = new b(r3);
        r3.d = r1;
    L8:
        AppHost.a.a().j(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public boolean x(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return false;
    }

    public void F(u2.i r2, Function1<? super GrantingAction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "completion");
        r3.invoke(GrantingAction.DISMISSED);
    }

    public Object G(String r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(false);
    }

    public void H(com.bytedance.ai.applet.login.i r2, Function1<? super GrantingAction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "completion");
        r3.invoke(GrantingAction.DISMISSED);
    }

    public void M(m3.d r2, m3.e r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "completion");
        int r4 = com.bytedance.ai.bridge.method.bottomsheet.a.d;
        r3.invoke(com.bytedance.ai.bridge.method.bottomsheet.a.a.a(DoubaoBottomSheetCancelSource.HOST_UNAVAILABLE));
    }

    public Boolean N(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        return Boolean.FALSE;
    }

    public Object l(String r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(false);
    }

    public void r(String r3, com.bytedance.ai.applet.douyinAuth.b r4) {
        Intrinsics.checkNotNullParameter("aw730v27vx2bu2qw", "clientKey");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "completion");
        r4.invoke(null, null, "Not supported by the current AppletService");
    }

    public void a(Context r2, String r3, com.bytedance.ai.bridge.method.authorize.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appletId");
        Intrinsics.checkNotNullParameter(r4, "completion");
        r4.invoke("applet settings are not supported by host");
    }

    public void n(String r2, String r3, DouyinGeneralAuthHelper.a r4) {
        Intrinsics.checkNotNullParameter(r2, "clientKey");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "completion");
        r4.invoke(Boolean.FALSE, "Not supported by the current AppletService");
    }

    public void y(Context r1, String r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "permissionName");
        Intrinsics.checkNotNullParameter(r3, "completion");
        r3.invoke(Boolean.FALSE);
    }

    public void t(String r2, String r3, String r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "cardId");
        Intrinsics.checkNotNullParameter(r4, "contentDataStr");
        Intrinsics.checkNotNullParameter(r5, "completion");
        r5.invoke(Boolean.FALSE);
    }

    public void Q(String r1, String r2, boolean r3, Map r4, u2.i r5, DouyinGeneralAuthHelper.b r6) {
        Intrinsics.checkNotNullParameter(r1, "clientKey");
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r4, "trackInfo");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "completion");
        r6.invoke(GrantingAction.DISMISSED, "Not supported by the current AppletService");
    }
}

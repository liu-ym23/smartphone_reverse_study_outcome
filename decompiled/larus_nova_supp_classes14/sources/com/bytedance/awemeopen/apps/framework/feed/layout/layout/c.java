package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.text.TextUtils;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.host.IHandleByHostCallback;
import com.bytedance.awemeopen.export.api.host.IHandleBySdkCallback;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements IHandleBySdkCallback {
    public final /* synthetic */ AosFeedPagerListLayout<FeedPagerListViewModel> a;
    public final /* synthetic */ jz3.a b;
    public final /* synthetic */ Ref.ObjectRef<List<String>> c;

    public final void notifyShowButtonNames(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "buttonList");
        this.c.element = r2;
    }

    public c(AosFeedPagerListLayout<FeedPagerListViewModel> r1, jz3.a r2, Ref.ObjectRef<List<String>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.Object] */
    public final void handleBySdk(String r13, JSONObject r14, IHandleByHostCallback r15) {
        Intrinsics.checkNotNullParameter(r13, "buttonType");
        Intrinsics.checkNotNullParameter(r14, "extraInfo");
        Intrinsics.checkNotNullParameter(r15, "handleByHostCallback");
        AosEventReporter r16 = AosEventReporter.a;
        FeedPagerListViewModel r0 = this.a.getVm();
        jz3.a r1 = this.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r13, "function_name");
        if (r0 == null) goto L8;
        String r2 = r0.sceneId();
        if (r2 == null) goto L8;
        String r4 = r2;
    L9:
        if (r0 == null) goto L11;
        r0.getPageConfig();
    L11:
        if (r1 == null) goto L40;
        r14.c r3 = r1.a;
        if (r3 == null) goto L40;
        d14.a r5 = b14.a.a;
        t24.a r6 = b14.a.a(t24.a.class);
        User r7 = r3.f();
        if (r7 == null) goto L18;
        String r8 = r7.u();
        if (r8 == null) goto L18;
    L19:
        String r9 = r3.c();
        a0 r10 = r3.d;
        if (r10 == null) goto L25;
        String r11 = r10.a();
        if (r11 == null) goto L25;
        String r12 = r11;
    L26:
        String r17 = AosEventReporter.c(r1.a);
        if (r1.a.W() == false) goto L29;
        String r18 = "origin";
    L30:
        String r19 = r18;
        if (r0 == null) goto L38;
        FeedPageConfig r20 = r0.getPageConfig();
        if (r20 == null) goto L38;
        String r21 = r20.getPreviousPage();
        if (r21 == null) goto L38;
        String r110 = r21;
    L39:
        r6.g0(r4, r8, r9, r12, r17, r19, r110, r13);
    L38:
        r110 = "";
        goto L39
    L29:
        r18 = "sdk";
    L25:
        r12 = "";
    L18:
        r8 = "";
    L40:
        r14.c r111 = this.a.getAweme();
        boolean r22 = false;
        if (r111 != null) goto L43;
    L45:
        boolean r112 = false;
    L46:
        if (r112 == true) goto L48;
    L57:
        r15.handleByHost(r22, new JSONObject());
        return;
    L48:
        if (TextUtils.equals("more", r13) == false) goto L57;
        Object r113 = this.a.getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r113);
        List r114 = (List) ((ListState) r113).a;
        int r115 = this.a.getVm().getCurrentSelectedIndex();
        if (r115 >= 0) goto L52;
    L56:
        r22 = true;
        goto L57
    L52:
        if (r115 >= r114.size()) goto L56;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r116 = this.a.getAdapter().k(ListProtector.get(r114, r115));
        if (r116 == null) goto L56;
        r116.j();
        goto L56
    L43:
        if (r111.W() == true) goto L45;
        r112 = true;
    L8:
        r4 = "";
        goto L9
    }
}

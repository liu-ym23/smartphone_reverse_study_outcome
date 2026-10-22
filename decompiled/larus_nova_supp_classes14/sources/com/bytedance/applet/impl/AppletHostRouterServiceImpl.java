package com.bytedance.applet.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.applet.view.AppletFragment;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletHostRouterServiceImpl implements r4.j {

    public static final class a {
    }

    public static final class b extends r4.b {
        public final /* synthetic */ e3.d c;

        public b(e3.d r1) {
            this.c = r1;
        }

        public final boolean a(String r3, Map<String, ? extends Object> r4, Context r5) {
            Intrinsics.checkNotNullParameter(r3, "schema");
            Intrinsics.checkNotNullParameter(r4, "extraInfo");
            if (this.c != null) goto L5;
            return false;
        L5:
            Map r0 = com.ivy.ivykit.api.bridge.b.a;
            hx7.f r1 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);
            if (r1 != null) goto L8;
            return false;
        L8:
            return r1.openSchema(r3, r4, r5);
        }
    }

    static {
    }

    public AppletHostRouterServiceImpl() {
    }

    public final r4.b provideRouteOpenExceptionHandler(e3.d r1) {
        return null;
    }

    public final List<r4.b> provideRouteOpenHandlerList(e3.d r2) {
        return CollectionsKt.listOf(new b(r2));
    }

    public final boolean closeView(e3.d r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        FragmentActivity r1 = null;
        Object r2 = null;
        if (r0 == true) goto L40;
        com.bytedance.ai.utils.g.a.i("AppletHostRouterService", "closeView, containerID: " + r8);
        Sequence r3 = SequencesKt.filter(CollectionsKt.asSequence(AppHost.a.a().g()), AppletHostRouterServiceImpl$closeView$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator r4 = SequencesKt.flatMap(r3, new j0()).iterator();
    L13:
        if (r4.hasNext() == false) goto L28;
        Object r5 = r4.next();
        Fragment r6 = (Fragment) r5;
        if ((r6 instanceof AppletFragment) == false) goto L17;
    L18:
        Bundle r10 = r6.getArguments();
        if (r10 == null) goto L21;
        String r11 = r10.getString("pageId");
    L23:
        if (Intrinsics.areEqual(r11, r8) == false) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L13;
        r2 = r5;
    L25:
        r12 = false;
        goto L26
    L21:
        r11 = null;
        goto L23
    L17:
        if ((r6 instanceof AppletPopup) == false) goto L25;
    L28:
        AppletFragment r13 = (Fragment) r2;
        if (r13 != null) goto L31;
        com.bytedance.ai.utils.g.a.e("AppletHostRouterService", "closeView, not found fragmentToClose: " + r8);
        return false;
    L31:
        if ((r13 instanceof AppletFragment) == false) goto L34;
        r13.close();
    L36:
        com.bytedance.ai.utils.g.a.i("AppletHostRouterService", "closeView, close fragment: " + r13);
        return true;
    L34:
        if ((r13 instanceof AppletPopup) == false) goto L36;
        ((AppletPopup) r13).da0(true);
        goto L36
    L40:
        Activity r14 = AppHost.a.a().getCurrentActivity();
        if ((r14 instanceof FragmentActivity) == false) goto L43;
        r1 = (FragmentActivity) r14;
    L43:
        if (r1 == null) goto L57;
        FragmentManager r15 = r1.getSupportFragmentManager();
        if (r15.getFragments().size() <= 0) goto L57;
        AppletFragment r16 = (Fragment) CollectionsKt.last(r15.getFragments());
        if ((r16 instanceof AppletFragment) == false) goto L50;
        r16.close();
    L56:
        return true;
    L50:
        if ((r16 instanceof AppletPopup) == false) goto L53;
        ((AppletPopup) r16).da0(true);
        goto L56
    L53:
        if (r15.getBackStackEntryCount() <= 0) goto L55;
        r15.popBackStackImmediate();
        goto L56
    L55:
        r15.beginTransaction().remove(r16).commit();
    L57:
        if (r14 == null) goto L60;
        r14.finish();
        return true;
    L60:
        return false;
    L5:
        if (r8.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final boolean openSchema(e3.d r1, String r2, Map<String, ? extends Object> r3, Context r4) {
        return r4.j.a.b(this, r1, r2, r3, r4);
    }
}

package com.bytedance.applet.jsb;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.view.AppletFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements hx7.f {
    public static final hx7.f b = null;
    public static final List<hx7.f> c = null;
    public final WeakReference<AppletFragment> a;

    public static final class a {
    }

    static {
        Map r0 = com.ivy.ivykit.api.bridge.b.a;
        b = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);
        c = new ArrayList();
    }

    public m(AppletFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "appletFragment");
        this.a = new WeakReference(r2);
        Map r3 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, this);
        ListProtector.add(c, 0, this);
    }

    public final boolean closeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AppletFragment r0 = this.a.get();
        if (r0 == null) goto L12;
        FragmentActivity r1 = r0.getActivity();
        if ((r4 instanceof Activity) == false) goto L7;
        Activity r2 = (Activity) r4;
    L9:
        if (Intrinsics.areEqual(r1, r2) == false) goto L12;
        r0.close();
        return true;
    L7:
        r2 = null;
    L12:
        hx7.f r3 = b;
        if (r3 != null) goto L17;
        return false;
    L17:
        return r3.closeView(r4);
    }

    public final boolean interceptClose(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public final boolean openSchema(String r2, Map<String, ? extends Object> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "extraInfo");
        hx7.f r0 = b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.openSchema(r2, r3, r4);
    }
}

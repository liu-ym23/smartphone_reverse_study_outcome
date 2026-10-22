package com.bytedance.widget;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/widget/WidgetHost;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "widget_release"}, k = 1, mv = {1, 4, 0})
public final class WidgetHost extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f272652h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, Widget> f272653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f272654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Lifecycle, WidgetManager> f272655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Function0<Unit>> f272656g;

    public static final class a {
    }

    public interface b {
        void a();

        void onWidgetLoaded();
    }

    @Override // androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    static {
    }

    public WidgetHost() {
        this.f272653d = new HashMap();
        this.f272654e = new ArrayList();
        this.f272655f = new WeakHashMap();
        this.f272656g = new LinkedHashSet();
    }

    public final void T90(Intent r100, int r101, Widget r102) {
        this.f272653d.put(Integer.valueOf(r101), r102);
        super.startActivityForResult(r100, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Widget r103 = this.f272653d.get(Integer.valueOf(r100));
        if (r103 == null) goto L5;
        r103.onActivityResult(r100, r101, r102);
    L5:
        this.f272653d.remove(Integer.valueOf(r100));
    }

    public final void S90(Intent r100, int r101, Bundle r102, Widget r103) {
        this.f272653d.put(Integer.valueOf(r101), r103);
        super.startActivityForResult(r100, r101, r102);
    }
}

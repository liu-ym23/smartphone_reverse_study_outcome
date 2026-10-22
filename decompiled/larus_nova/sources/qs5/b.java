package qs5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import js5.g;
import kotlin.jvm.internal.Intrinsics;
import ts5.d;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f534667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rxb.c f534668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f534670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f534671e;

    public static final class a {
    }

    static {
    }

    @Override // qs5.c
    public final View b() {
        if (TextUtils.isEmpty(this.f534669c) == false) goto L6;
        this.f534668b.e("CoreSubNativeViewContainer", "onCreateNativeView with empty viewId");
        return null;
    L6:
        ks5.a r100 = this.f534670d.getComponent(this.f534669c);
        if (r100 == null) goto L11;
        Map<String, g> r101 = r100.a();
        if (r101 == null) goto L11;
        g r102 = r101.get(this.f534669c);
    L12:
        if (r102 != null) goto L15;
        this.f534668b.e("CoreSubNativeViewContainer", "onCreateNativeView, cannot find subComponent");
        return null;
    L15:
        View r103 = r102.a();
        this.f534671e = r103;
        return r103;
    L11:
        r102 = null;
        goto L12
    }

    @Override // qs5.c
    public final View a() {
        return this.f534671e;
    }

    @Override // qs5.c
    public final View c() {
        return this.f534671e;
    }

    public final Context getContext() {
        return this.f534667a;
    }

    public b(Context r100, rxb.c r101, String r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "subViewId");
        Intrinsics.checkNotNullParameter(r103, "nativeComponentProviderService");
        this.f534667a = r100;
        this.f534668b = r101;
        this.f534669c = r102;
        this.f534670d = r103;
    }
}

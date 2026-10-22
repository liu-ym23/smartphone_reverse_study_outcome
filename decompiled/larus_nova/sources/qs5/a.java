package qs5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ts5.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f534662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rxb.c f534663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f534665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f534666e;

    /* JADX INFO: renamed from: qs5.a$a, reason: collision with other inner class name */
    public static final class C7388a {
    }

    static {
    }

    @Override // qs5.c
    public final View b() {
        if (TextUtils.isEmpty(this.f534664c) == false) goto L6;
        this.f534663b.e("CoreNativeViewContainer", "onCreateNativeView with empty viewId");
        return null;
    L6:
        ks5.a r100 = this.f534665d.getComponent(this.f534664c);
        if (r100 != null) goto L10;
        this.f534663b.a("CoreNativeViewContainer", this.f534664c, "onCreateNativeView, context not added");
        return null;
    L10:
        JSONObject r101 = r100.getData();
        if (r101 == null) goto L13;
        r101.put("__viewId__", this.f534664c);
    L13:
        this.f534666e = r100.g().d(r100.getData());
        r100.i();
        return this.f534666e;
    }

    @Override // qs5.c
    public final View a() {
        return this.f534666e;
    }

    @Override // qs5.c
    public final View c() {
        return this.f534666e;
    }

    public final Context getContext() {
        return this.f534662a;
    }

    public a(Context r100, rxb.c r101, String r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "viewId");
        Intrinsics.checkNotNullParameter(r103, "nativeComponentProviderService");
        this.f534662a = r100;
        this.f534663b = r101;
        this.f534664c = r102;
        this.f534665d = r103;
    }
}

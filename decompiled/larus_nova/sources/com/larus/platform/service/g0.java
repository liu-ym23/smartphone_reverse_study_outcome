package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements com.larus.platform.api.h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f365740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365741b = null;

    public g0() {
    }

    static {
        f365740a = new g0();
        f365741b = LazyKt.lazy(new f0());
    }

    public static com.larus.platform.api.h2 r() {
        return (com.larus.platform.api.h2) f365741b.getValue();
    }

    @Override // com.larus.platform.api.h2
    public final JSONObject c() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.h2
    public final com.larus.platform.api.h1 d() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    @Override // com.larus.platform.api.h2
    public final boolean e() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    @Override // com.larus.platform.api.h2
    public final boolean f() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.h2
    public final LiveData<Message> g() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    @Override // com.larus.platform.api.h2
    public final JSONObject h() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.h2
    public final void i() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    @Override // com.larus.platform.api.h2
    public final Integer j() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j();
    }

    @Override // com.larus.platform.api.h2
    public final boolean k() {
        if (r() != null) goto L5;
        return false;
    L5:
        com.larus.platform.api.h2 r100 = r();
        Intrinsics.checkNotNull(r100);
        return r100.k();
    }

    @Override // com.larus.platform.api.h2
    public final int l() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.l();
    }

    @Override // com.larus.platform.api.h2
    public final boolean m() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m();
    }

    @Override // com.larus.platform.api.h2
    public final boolean o() {
        com.larus.platform.api.h2 r100 = r();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.o() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.h2
    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.larus.platform.api.h2 r101 = r();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.platform.api.h2
    public final void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        com.larus.platform.api.h2 r102 = r();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.h2
    public final boolean n(Context r100, UserCreation r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userCreation");
        com.larus.platform.api.h2 r102 = r();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.n(r100, r101);
    }

    @Override // com.larus.platform.api.h2
    public final void q(String r100, com.larus.camera.impl.ui.viewmodel.d r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        com.larus.platform.api.h2 r102 = r();
        if (r102 == null) goto L6;
        r102.q(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.h2
    public final void p(Context r100, String r101, String r110, String r111, Message r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        com.larus.platform.api.h2 r102 = r();
        if (r102 == null) goto L6;
        r102.p(r100, r101, r110, r111, r112);
        return;
    }
}

package com.larus.office.plugins.inputv2.coordinator.document;

import com.alibaba.fastjson.JSONObject;
import com.larus.office.plugins.inputv2.u1;
import com.larus.office.plugins.inputv2.v1;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ChameleonPluginHost> f362775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f362776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f362777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f362778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f362779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f362780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f362781g;

    public static final class a {
    }

    static {
    }

    public c() {
        throw null;
    }

    public final void a() {
        if (this.f362780f == false) goto L5;
        this.f362777c.invoke("ai_edit_answer_finished");
    L5:
        this.f362780f = false;
        this.f362781g = false;
    }

    public final void c() {
        this.f362776b.invoke();
        this.f362780f = this.f362781g;
        this.f362781g = false;
        this.f362779e = false;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f362779e == true) goto L7;
        this.f362779e = true;
        final JSONObject r101 = new JSONObject();
        final String r102 = "notifyAiMessageEnd#".concat(r100);
        t0.e(new b(this, r102, r101));
    L7:
        if (this.f362778d == 0) goto L11;
        this.f362778d = 0;
        return;
    }

    public c(u1 r100, v1 r101) {
        Function0<Unit> r102 = new com.larus.office.plugins.inputv2.coordinator.document.a();
        Intrinsics.checkNotNullParameter(r100, "hostProvider");
        Intrinsics.checkNotNullParameter(r102, "onPrepareForNewAnswer");
        Intrinsics.checkNotNullParameter(r101, "onAiEditAnswerFinished");
        this.f362775a = r100;
        this.f362776b = r102;
        this.f362777c = r101;
    }
}

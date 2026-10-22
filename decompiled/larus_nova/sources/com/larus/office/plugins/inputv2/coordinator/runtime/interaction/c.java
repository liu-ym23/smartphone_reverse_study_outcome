package com.larus.office.plugins.inputv2.coordinator.runtime.interaction;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.nova.R;
import com.larus.office.OfficeInputParam;
import com.larus.office.k;
import com.larus.office.plugins.inputv2.a0;
import com.larus.office.plugins.inputv2.a2;
import com.larus.office.plugins.inputv2.b0;
import com.larus.office.plugins.inputv2.c0;
import com.larus.office.plugins.inputv2.d0;
import com.larus.office.plugins.inputv2.e0;
import com.larus.office.plugins.inputv2.f0;
import com.larus.office.plugins.inputv2.g0;
import com.larus.office.plugins.inputv2.z;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Context> f362942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ChameleonPluginHost> f362943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<ViewGroup> f362945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f362946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f362947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f362948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Boolean, Unit> f362949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f362950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<dw8.a, Unit> f362951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<dw8.a, Unit> f362952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.office.plugins.inputv2.adapter.g f362953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fo9.a f362954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f362955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f362956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f362957p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.a f362958q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e f362959r;

    public static final class a {
    }

    static {
    }

    public final fo9.a a() {
        ChameleonPluginHost r100 = this.f362943b.invoke();
        if (this.f362954m != null) goto L20;
        boolean r101 = false;
        if (r100 == null) goto L11;
        FragmentActivity r102 = r100.getActivity();
        if (r102 == null) goto L11;
        if (r102.isFinishing() == true) goto L11;
        r101 = true;
    L11:
        if (r101 == false) goto L20;
        FragmentActivity r103 = r100.getActivity();
        if (r103 == null) goto L17;
        t1a.b r104 = s1a.a.h(r103);
        if (r104 == null) goto L17;
        fo9.a r105 = (fo9.a) r104.getAbility(fo9.a.class);
    L18:
        this.f362954m = r105;
    L17:
        r105 = null;
    L20:
        return this.f362954m;
    }

    public final void c() {
        com.larus.office.plugins.inputv2.adapter.g r100 = this.f362953l;
        if (r100 == null) goto L5;
        r100.n(this.f362959r);
    L5:
        com.larus.office.plugins.inputv2.adapter.g r101 = this.f362953l;
        if (r101 == null) goto L13;
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.a r102 = this.f362958q;
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r101.f362685h.remove(r102) == false) goto L13;
        if (r101.f362685h.isEmpty() == false) goto L13;
        r101.s();
    L13:
        this.f362953l = null;
        this.f362956o = false;
    }

    public final void b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        com.larus.office.plugins.inputv2.adapter.g r100 = this.f362953l;
        if (r100 != null) goto L5;
        return;
    L5:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("刷新输入框配置, reason=");
        r102.append(r110);
        r102.append(", type=");
        OfficeInputParam r103 = this.f362944c.invoke();
        String r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.getType();
    L9:
        r102.append(r105);
        r102.append(", canEdit=");
        fo9.a r106 = a();
        if (r106 != null) goto L12;
    L14:
        boolean r107 = false;
    L15:
        r102.append(r107);
        r101.i("OfficeChatInput", r102.toString());
        int r108 = a2.f362666a;
        Context r109 = this.f362942a.invoke();
        OfficeInputParam r111 = this.f362944c.invoke();
        fo9.a r112 = a();
        if (r112 != null) goto L18;
    L20:
        boolean r113 = false;
    L21:
        if (r111 == null) goto L23;
        String r114 = r111.getType();
    L24:
        if (r109 == null) goto L48;
        if (r113 == true) goto L28;
        int r115 = k.f362219a;
        r104 = r109.getString(R.string.larus_Doubao_chat_input_placeholder_ask_cn);
        goto L48
    L28:
        if (r114 == null) goto L48;
        switch(r114.hashCode()) {
            case -899647262: goto L45;
            case 3016401: goto L41;
            case 3088960: goto L37;
            case 109403487: goto L33;
            default: goto L48;
        };
    L33:
        if (r114.equals(DocumentType.SHEET_NAME) == false) goto L48;
        int r116 = k.f362219a;
        r104 = r109.getString(R.string.larus_Doubao_sheet_input_placeholder_editOrAsk_cn);
        goto L48
    L37:
        if (r114.equals(DocumentType.DOCX_NAME) == false) goto L48;
        int r117 = k.f362219a;
        r104 = r109.getString(R.string.larus_Doubao_doc_input_placeholder_editOrAsk_cn);
        goto L48
    L41:
        if (r114.equals("base") == false) goto L48;
        int r118 = k.f362219a;
        r104 = r109.getString(R.string.larus_DoubaoBase_AskEdit_Placeholder);
        goto L48
    L45:
        if (r114.equals("slides") == false) goto L48;
        int r119 = k.f362219a;
        r104 = r109.getString(R.string.larus_Doubao_slide_input_placeholder_editOrAsk_cn);
    L48:
        AIChatInputConfig r120 = new AIChatInputConfig(0, r104, 1, true, CollectionsKt.listOf(new AIChatInputConfig.PlusAction[]{AIChatInputConfig.PlusAction.CAMERA, AIChatInputConfig.PlusAction.FILE}), 0, null, 3861);
        Intrinsics.checkNotNullParameter(r120, "config");
        if (r100.f362693p == true) goto L58;
        r100.f362679b.k8(r120);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "更新输入框配置失败", th);
        return;
    L58:
        return;
    L23:
        r114 = null;
        goto L24
    L18:
        if (r112.canEdit() != true) goto L20;
        r113 = true;
        goto L21
    L12:
        if (r106.canEdit() != true) goto L14;
        r107 = true;
        goto L15
    L8:
        r105 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.office.plugins.inputv2.coordinator.runtime.interaction.a] */
    public c(z r100, a0 r101, b0 r102, c0 r103, Function0 r104, d0 r105, e0 r106, f0 r107, g0 r110, Function1 r111, Function1 r112) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        Intrinsics.checkNotNullParameter(r101, "hostProvider");
        Intrinsics.checkNotNullParameter(r102, "paramsProvider");
        Intrinsics.checkNotNullParameter(r103, "fullScreenContainerProvider");
        Intrinsics.checkNotNullParameter(r104, "onInputActivated");
        Intrinsics.checkNotNullParameter(r105, "onInputTouched");
        Intrinsics.checkNotNullParameter(r106, "onInputFocused");
        Intrinsics.checkNotNullParameter(r107, "onFullScreenChanged");
        Intrinsics.checkNotNullParameter(r110, "onPermissionChanged");
        Intrinsics.checkNotNullParameter(r111, "onReady");
        Intrinsics.checkNotNullParameter(r112, "onNotReady");
        this.f362942a = r100;
        this.f362943b = r101;
        this.f362944c = r102;
        this.f362945d = r103;
        this.f362946e = r104;
        this.f362947f = r105;
        this.f362948g = r106;
        this.f362949h = r107;
        this.f362950i = r110;
        this.f362951j = r111;
        this.f362952k = r112;
        this.f362957p = new d(this);
        this.f362958q = new com.larus.office.plugins.inputv2.coordinator.runtime.interaction.a(this);
        this.f362959r = new e(this);
    }
}

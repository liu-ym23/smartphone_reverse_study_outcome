package com.larus.bmhome.chat.markdown.code;

import android.content.Context;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q0 implements jw8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f307008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw8.d f307009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fh8.f f307010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AttachReceiver f307011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f307012e;

    @Override // jw8.c
    public final void f() {
        ((oj8.c) this.f307012e.getValue()).c();
    }

    @Override // jw8.c
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ((oj8.c) this.f307012e.getValue()).b();
    }

    public q0(Context r100, lw8.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f307008a = r100;
        this.f307009b = r101;
        this.f307012e = LazyKt.lazy(new l0(this));
    }

    @Override // jw8.c
    public final Size b(TextView r410, Spanned r411, jw8.b r412, Map r413, int r414, boolean r415) {
        Intrinsics.checkNotNullParameter(r410, "textView");
        Intrinsics.checkNotNullParameter(r411, "text");
        Intrinsics.checkNotNullParameter(r412, "span");
        if (r413 == null) goto L5;
        fh8.f r100 = fh8.h.b(r413);
    L6:
        this.f307010c = r100;
        if (r100 == null) goto L9;
        AttachReceiver r101 = r100.f477085o;
    L10:
        this.f307011d = r101;
        p0 r102 = new p0(this);
        if (r101 == null) goto L13;
        final t1a.b r103 = s1a.d.a(r101);
    L14:
        if (r103 != null) goto L21;
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L20;
        r104.P();
        Fragment r105 = ChatServiceImpl.f346124a.f();
        if (r105 == null) goto L20;
        r103 = s1a.a.g(r105);
    L20:
        r103 = null;
    L21:
        if (r103 == null) goto L23;
        va8.p r106 = (va8.p) r103.getAbility(va8.p.class);
    L24:
        fh8.f r107 = this.f307010c;
        if (r107 == null) goto L29;
        Function0<? extends Fragment> r108 = r107.f477083m;
        if (r108 == null) goto L29;
        Fragment r109 = r108.invoke();
    L30:
        fh8.f r110 = this.f307010c;
        if (r110 == null) goto L35;
        Message r111 = r110.f477072b;
        if (r111 == null) goto L35;
        int r112 = com.larus.bmhome.chat.cotdetail.list.processor.f.f302020f;
        com.larus.bmhome.chat.cotdetail.list.processor.f r113 = com.larus.bmhome.chat.cotdetail.list.processor.f.a.a(r109, r111, null);
    L36:
        fh8.f r114 = this.f307010c;
        if (r114 == null) goto L39;
        String r115 = r114.f477074d;
    L40:
        if (r114 == null) goto L42;
        Message r116 = r114.f477072b;
    L43:
        if (r103 == null) goto L47;
        de8.c r117 = (de8.c) r103.a(de8.c.class);
        if (r117 == null) goto L47;
        Integer r118 = r117.m();
    L49:
        if (r118 == null) goto L51;
        boolean r119 = true;
    L52:
        LruCache<String, wc9.e> r120 = ko8.a.f504531a;
        long r121 = ko8.a.g();
        Integer r122 = r412.getStartIndex();
        if (r122 == null) goto L55;
        int r123 = r122.intValue();
    L56:
        if (r106 == null) goto L58;
        RecyclerView r210 = r106.Ly();
    L59:
        if (r113 == null) goto L61;
        by7.e r124 = r113;
    L64:
        lw8.d r125 = this.f307009b;
        if (r125 == null) goto L69;
        CodeBlockConfig r126 = r125.f511075v;
        if (r126 == null) goto L69;
        boolean r211 = r126.getEnableCodeBlockStroke();
    L70:
        lw8.d r127 = this.f307009b;
        if (r127 == null) goto L75;
        CodeBlockConfig r128 = r127.f511075v;
        if (r128 == null) goto L75;
        boolean r212 = r128.getEnableCodeBlockHeaderBackground();
    L76:
        hh8.a r129 = new hh8.a(r211, r212, false, null, null, false, 60);
        fh8.f r130 = this.f307010c;
        if (r130 == null) goto L79;
        Function0<Map<String, Object>> r213 = r130.f477089s;
    L80:
        if (r113 == null) goto L94;
        if (r109 == null) goto L83;
        by7.e r131 = by7.h.h(r109);
    L85:
        if ((r131 instanceof TraceFragment) == false) goto L87;
        TraceFragment r132 = (TraceFragment) r131;
    L88:
        if (r132 == null) goto L91;
        String r133 = r132.k();
        if (r133 == null) goto L91;
    L96:
        String r214 = r133;
    L98:
        String r134 = r412.getCode();
        if (r134 != null) goto L101;
        String r215 = "";
    L102:
        String r135 = r412.getLanguage();
        if (r135 != null) goto L105;
        String r216 = "";
    L106:
        Intrinsics.checkNotNullParameter(r411, "text");
        Intrinsics.checkNotNullParameter(r412, "span");
        if (z2.f365865a.getMarkdownCodeRenderConfig().f486571c == true) goto L109;
        boolean r217 = r415;
    L131:
        fh8.f r136 = this.f307010c;
        if (r136 == null) goto L134;
        fh8.c r137 = r136.f477081k;
    L135:
        if (r137 == null) goto L137;
        boolean r310 = true;
    L138:
        if (r136 == null) goto L142;
        jh8.b r138 = r136.f477092v;
        if (r138 == null) goto L142;
        Integer r311 = r138.f499100a;
    L143:
        if (r136 == null) goto L147;
        jh8.b r139 = r136.f477092v;
        if (r139 == null) goto L147;
        Integer r312 = r139.f499102c;
    L148:
        if (r136 == null) goto L150;
        com.larus.bmhome.chat.api.q0 r313 = r136.f477087q;
    L151:
        if (r136 == null) goto L153;
        com.larus.bmhome.chat.api.q0.a r314 = r136.f477084n;
    L154:
        if (r136 == null) goto L156;
        RecyclerView.Adapter<?> r140 = r136.f477086p;
    L158:
        if ((r140 instanceof ry8.d) == false) goto L160;
        ry8.d r315 = (ry8.d) r140;
    L161:
        rj8.a r141 = new rj8.a(r115, r116, r119, Long.valueOf(r121), r123, r124, r210, new m0(r103), new n0(r103), r129, r213, r214, r215, null, r216, r217, r310, r311, r312, r313, r314, r315, null, false, false, null, null, null, 264241152);
        ((oj8.c) this.f307012e.getValue()).a(r141, r102);
        oj8.c r142 = (oj8.c) this.f307012e.getValue();
        r142.getClass();
        Intrinsics.checkNotNullParameter(r141, "vmData");
        return r142.b().g(((rj8.d) r142.f523596c.getValue()).a(), r414);
    L160:
        r315 = null;
        goto L161
    L156:
        r140 = null;
        goto L158
    L153:
        r314 = null;
        goto L154
    L150:
        r313 = null;
    L147:
        r312 = null;
    L142:
        r311 = null;
        goto L143
    L137:
        r310 = false;
        goto L138
    L134:
        r137 = null;
        goto L135
    L109:
        if (r415 == true) goto L120;
        fh8.f r143 = this.f307010c;
        if (r143 == null) goto L129;
        Message r144 = r143.f477072b;
        if (r144 == null) goto L129;
        if (com.larus.im.bean.message.a.w0(r144) == false) goto L119;
    L121:
        Integer r145 = r412.getEndIndex();
        if (r145 == null) goto L124;
        int r146 = r145.intValue();
    L126:
        if (r146 < (r411.length() - 1)) goto L129;
        boolean r147 = false;
    L130:
        r217 = r147;
        goto L131
    L124:
        r146 = 0;
        goto L126
    L119:
        if (com.larus.bmhome.chat.bean.d.j0(r144) == false) goto L121;
    L129:
        r147 = true;
    L120:
        r217 = true;
        goto L131
    L105:
        r216 = r135;
        goto L106
    L101:
        r215 = r134;
    L91:
        fh8.f r148 = this.f307010c;
        if (r148 == null) goto L97;
        r133 = r148.f477075e;
    L97:
        r214 = null;
        goto L98
    L87:
        r132 = null;
        goto L88
    L83:
        r131 = null;
        goto L85
    L94:
        if (r130 == null) goto L97;
        r133 = r130.f477075e;
        goto L96
    L79:
        r213 = null;
    L75:
        r212 = false;
    L69:
        r211 = false;
        goto L70
    L61:
        if (r109 == null) goto L63;
        r124 = by7.h.h(r109);
        goto L64
    L63:
        r124 = null;
        goto L64
    L58:
        r210 = null;
        goto L59
    L55:
        r123 = 0;
        goto L56
    L51:
        r119 = false;
    L47:
        r118 = null;
        goto L49
    L42:
        r116 = null;
        goto L43
    L39:
        r115 = null;
    L35:
        r113 = null;
    L29:
        r109 = null;
        goto L30
    L23:
        r106 = null;
        goto L24
    L13:
        r103 = null;
        goto L14
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = null;
        goto L6
    }
}

package com.larus.bmhome.block.newheader.foldcontainer;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.bmhome.utils.z;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDVideoUploaderBase;
import fh8.t;
import ib8.b0;
import ib8.c;
import ib8.c0;
import ib8.d0;
import ib8.g;
import ib8.q;
import ib8.s;
import ib8.w;
import ib8.w0;
import ib8.x;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kb8.i;
import kb8.m;
import kb8.n;
import kb8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import lb8.h;
import nb8.k;
import nb8.l;
import po8.e;
import so8.j;
import so8.r;
import so8.u;
import so8.v;
import tk8.f;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements hb8.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f296351y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ib8.b f296352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f296353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f296354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f296355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f296356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f296357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Message f296358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f296359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f296360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f296361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f296362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f296363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f296364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f296365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f296366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f296367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f296368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DeepThinkFoldStatus f296369r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f296370s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f296371t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f296372u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w f296373v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f296374w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f296375x;

    /* JADX INFO: renamed from: com.larus.bmhome.block.newheader.foldcontainer.a$a, reason: collision with other inner class name */
    public static final class C4020a {
    }

    public static final class b implements com.larus.bmhome.block.newheader.foldcontainer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f296376a;

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final f f() {
            return null;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void c() {
            g r100 = this.f296376a.f296353b;
            if (r100 == null) goto L6;
            r100.U1();
            return;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final h d() {
            return (mb8.c.a) ((mb8.c) this.f296376a.f296364m.getValue()).f512791c.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final n e() {
            return (m.a) ((m) this.f296376a.f296365n.getValue()).f502251e.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final l g() {
            return (k.a) ((k) this.f296376a.f296366o.getValue()).f518545f.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final com.larus.bmhome.chat.standarduikit.vlm.view.b i() {
            return (do8.w.b) ((do8.w) this.f296376a.f296372u.getValue()).f469502j.getValue();
        }

        public b(a r100) {
            this.f296376a = r100;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void b(String r510) {
            Intrinsics.checkNotNullParameter(r510, "clickPosition");
            ib8.b r100 = this.f296376a.f296352a;
            boolean r101 = false;
            if (r100 == null) goto L9;
            c0 r102 = r100.f489005a;
            if (r102 == null) goto L9;
            if (r102.f489027h != true) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L12;
            return;
        L12:
            if (r100 == null) goto L20;
            c0 r104 = r100.f489005a;
            if (r104 == null) goto L20;
            Function0<Boolean> r105 = r104.f489026g;
            if (r105 == null) goto L20;
            if (r105.invoke().booleanValue() != true) goto L20;
            boolean r106 = true;
        L21:
            if (r106 == false) goto L23;
            return;
        L23:
            ib8.b r107 = this.f296376a.f296352a;
            if (r107 == null) goto L33;
            mb8.a r108 = r107.f489007c;
            if (r108 == null) goto L33;
            List<jc8.a> r109 = r108.f512782a;
            if (r109 == null) goto L33;
            jc8.a r110 = (jc8.a) CollectionsKt.firstOrNull(r109);
            if (r110 == null) goto L33;
            Block r111 = r110.f498145a;
            if (r111 == null) goto L33;
        L34:
            ib8.b r112 = this.f296376a.f296352a;
            if (r112 == null) goto L40;
            c0 r113 = r112.f489005a;
            if (r113 == null) goto L40;
            Message r114 = r113.f489023d;
            if (r114 == null) goto L40;
        L41:
            FLogger.f375446a.i("FoldContainerViewModel", "onClickExpandAllOrHeadTitle, clickPos: " + r510 + ", msgId: " + r114.getMessageId() + ", blockType: " + r111.getBlockType());
            ComplexTaskDelegate r115 = ComplexTaskDelegate.f392864b;
            String r116 = r115.e(r114, r111);
            if (r116 != null) goto L45;
            r116 = "";
        L45:
            if (r115.f(r114) == false) goto L58;
            if (o0.d(r116) == false) goto L58;
            IFlowSdkDepend r117 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r117 == null) goto L117;
            r117.P();
            Fragment r118 = ChatServiceImpl.f346124a.f();
            if (r118 == null) goto L118;
            t1a.b r119 = s1a.a.g(r118);
            if (r119 == null) goto L119;
            u7 r120 = (u7) r119.getAbility(u7.class);
            if (r120 == null) goto L120;
            r120.kx(r116, true);
            return;
        L120:
            return;
        L119:
            return;
        L118:
            return;
        L117:
            return;
        L58:
            if (r114.getMessageStatusLocal() != 21) goto L91;
            Set r121 = SetsKt.setOf(new String[]{"1", "true"});
            Map<String, String> r122 = r114.getExt();
            if (r122 == null) goto L62;
            String r123 = r122.get("need_lazy_load");
        L64:
            if (CollectionsKt.contains(r121, r123) == false) goto L91;
            if (this.f296376a.f296367p.a() == DeepThinkFoldStatus.CompleteExpand) goto L91;
            a r124 = this.f296376a;
            if (r124.f296360i == true) goto L114;
            String r125 = r114.getConversationId();
            if (r125 != null) goto L73;
            return;
        L73:
            if ((!StringsKt.isBlank(r125)) == false) goto L75;
            String r126 = r125;
        L76:
            if (r126 == null) goto L115;
            String r127 = r114.getMessageId();
            if (r127 != null) goto L81;
            return;
        L81:
            if ((!StringsKt.isBlank(r127)) == false) goto L83;
            String r128 = r127;
        L84:
            if (r128 == null) goto L116;
            r124.f296360i = true;
            g r129 = r124.f296353b;
            if (r129 == null) goto L89;
            r129.g(null);
        L89:
            int r130 = r124.f296359h;
            d.e().s(r126, r128, new b0(new WeakReference(r124), r130, r128, r126, r510));
            return;
        L116:
            return;
        L83:
            r128 = null;
            goto L84
        L115:
            return;
        L75:
            r126 = null;
            goto L76
        L114:
            return;
        L62:
            r123 = null;
        L91:
            a r131 = this.f296376a;
            ib8.b r132 = r131.f296352a;
            if (r132 == null) goto L98;
            c0 r133 = r132.f489005a;
            if (r133 == null) goto L98;
            if (r133.f489024e != true) goto L98;
            boolean r134 = true;
        L99:
            if (r134 == false) goto L108;
            if (r132 == null) goto L106;
            c0 r135 = r132.f489005a;
            if (r135 == null) goto L106;
            if (r135.f489028i != true) goto L106;
            r101 = true;
        L106:
            if (r101 == false) goto L108;
            return;
        L108:
            g r136 = r131.f296353b;
            if (r136 == null) goto L122;
            r136.g(new d0(true, r510));
            return;
        L122:
            return;
        L98:
            r134 = false;
        L40:
            r114 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        L33:
            r111 = new Block(0, null, null, null, false, null, null, null, 255, null);
        L20:
            r106 = false;
        L9:
            r103 = false;
            goto L10
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void h(st8.a r100, CustomMarkdownTextView r101) {
            Intrinsics.checkNotNullParameter(r100, "anchorView");
            ib8.b r102 = this.f296376a.f296352a;
            boolean r103 = false;
            if (r102 == null) goto L11;
            c0 r104 = r102.f489005a;
            if (r104 == null) goto L11;
            Message r105 = r104.f489023d;
            if (r105 == null) goto L11;
            if (com.larus.im.bean.message.a.f0(r105) != true) goto L11;
            r103 = true;
        L11:
            if (r103 == false) goto L13;
            LongClickSource r106 = LongClickSource.Thinking;
        L14:
            a r107 = this.f296376a;
            g r108 = r107.f296353b;
            if (r108 == null) goto L24;
            ib8.b r109 = r107.f296352a;
            if (r109 == null) goto L21;
            c0 r110 = r109.f489005a;
            if (r110 == null) goto L21;
            Message r111 = r110.f489023d;
        L22:
            r108.b(r111, r100, r101, r106);
            return;
        L21:
            r111 = null;
            goto L22
        L24:
            return;
        L13:
            r106 = LongClickSource.Content;
            goto L14
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void a(int r100, int r101, Interpolator r102) {
            Intrinsics.checkNotNullParameter(r102, "animationInterpolator");
            g r103 = this.f296376a.f296353b;
            if (r103 == null) goto L6;
            r103.a(r100, r101, r102);
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [nb8.i] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [com.larus.bmhome.chat.standarduikit.vlm.view.a] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3, types: [fh8.d] */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5, types: [kc8.o] */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r39v3, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r39v5 */
    /* JADX WARN: Type inference failed for: r40v2 */
    /* JADX WARN: Type inference failed for: r40v3, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r40v5 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v3, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r41v5 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r6v57 */
    public final ib8.a a() {
        ib8.b r100 = this.f296352a;
        if (r100 != null) goto L5;
    L41:
        i r110 = null;
    L42:
        ib8.b r101 = this.f296352a;
        if (r101 != null) goto L45;
    L68:
        lb8.g r111 = null;
    L70:
        if (this.f296357f == false) goto L95;
        r r102 = (r) this.f296371t.getValue();
        r102.getClass();
        Set<String> r103 = so8.w.f542790a;
        so8.k r104 = r102.f542773e;
        if (r104 == null) goto L75;
        String r105 = r104.f542757a;
        if (r105 == null) goto L75;
    L76:
        so8.w.a(r105);
        v r106 = r102.f542769a;
        ((ArrayList) r106.f542788a).clear();
        ((LinkedHashMap) r106.f542789b).clear();
        ((LinkedHashMap) r102.f542779k).clear();
        r102.a(ZoomInAnimationState.IDLE);
        View r107 = r102.f542771c;
        if (r107 == null) goto L83;
        so8.k r108 = r102.f542773e;
        if (r108 == null) goto L83;
        IZoomInAnimationProvider r109 = r108.f542760d;
        if (r109 == null) goto L83;
        r109.e(r107);
    L83:
        r102.f542771c = null;
        r102.f542773e = null;
        so8.f r112 = (so8.f) r102.f542776h.getValue();
        AnimatorSet r113 = r112.f542747a;
        if (r113 == null) goto L86;
        r113.cancel();
    L86:
        FrameLayout r114 = r112.f542749c;
        if (r114 == null) goto L89;
        r114.removeAllViews();
    L89:
        FrameLayout r115 = r112.f542749c;
        if (r115 == null) goto L92;
        e1.o(r115);
    L92:
        ViewGroup r116 = r112.f542750d;
        if (r116 == null) goto L241;
        r116.setAlpha(1.0f);
    L241:
        ib8.b r117 = this.f296352a;
        if (r117 == null) goto L246;
        c0 r118 = r117.f489005a;
        if (r118 == null) goto L246;
        boolean r119 = r118.f489024e;
    L247:
        if (r117 == null) goto L255;
        c0 r120 = r117.f489005a;
        if (r120 == null) goto L255;
        ib8.m r121 = r120.f489022c;
        if (r121 == null) goto L255;
        Function1<DeepThinkFoldStatus, String> r122 = r121.f489076b;
        if (r122 == null) goto L255;
        String r123 = r122.invoke(this.f296367p.a());
    L256:
        if (r123 != null) goto L258;
        String r124 = "";
    L259:
        z r125 = z.f315156a;
        e r126 = this.f296367p;
        Message r127 = this.f296358g;
        String r128 = this.f296355d;
        String r129 = this.f296356e;
        ib8.b r130 = this.f296352a;
        if (r130 == null) goto L262;
        c0 r131 = r130.f489005a;
    L263:
        DeepThinkFoldStatus r132 = r126.a();
        boolean r133 = this.f296360i;
        r125.getClass();
        w0 r134 = z.b(r126, r119, r127, r128, r129, r124, r131, r132, r133);
        ib8.b r135 = this.f296352a;
        if (r135 == null) goto L270;
        c0 r136 = r135.f489005a;
        if (r136 == null) goto L270;
        if (r136.f489027h != true) goto L270;
        boolean r137 = true;
    L271:
        if (r137 == false) goto L273;
        String r138 = null;
        r134 = w0.a(r134, null, BDVideoUploaderBase.KeyIsDynamicSliceForceConfig);
    L274:
        w0 r210 = r134;
        ib8.b r139 = this.f296352a;
        if (r139 == null) goto L279;
        c0 r140 = r139.f489005a;
        if (r140 == null) goto L279;
        boolean r211 = r140.f489024e;
    L280:
        r r310 = (r) this.f296371t.getValue();
        ib8.b r141 = this.f296352a;
        if (r141 == null) goto L287;
        c0 r142 = r141.f489005a;
        if (r142 == null) goto L287;
        if (r142.f489039t != true) goto L287;
        boolean r143 = true;
    L288:
        if (r143 == true) goto L323;
        if (r141 == null) goto L320;
        c0 r144 = r141.f489005a;
        if (r144 == null) goto L320;
        Message r145 = r144.f489023d;
        if (r145 == null) goto L320;
        boolean r146 = this.f296367p.b();
        Regex r147 = com.larus.bmhome.chat.bean.d.f297444a;
        Intrinsics.checkNotNullParameter(r145, "<this>");
        if (r145.getMessageStatusLocal() != 23) goto L298;
    L301:
        boolean r148 = true;
    L302:
        ib8.b r149 = this.f296352a;
        if (r149 == null) goto L307;
        c0 r150 = r149.f489005a;
        if (r150 == null) goto L307;
        boolean r151 = r150.f489024e;
    L308:
        boolean r152 = !r151;
        if (com.larus.bmhome.chat.bean.d.e0(r145) == true) goto L313;
        if (r148 == false) goto L313;
        boolean r153 = false;
    L314:
        if (r146 == false) goto L320;
        if (r152 == false) goto L320;
        if (r153 == false) goto L320;
        if (com.larus.im.bean.message.a.f0(r145) == false) goto L320;
        boolean r154 = true;
    L321:
        if (r154 == false) goto L323;
        boolean r212 = true;
    L324:
        ib8.b r155 = this.f296352a;
        if (r155 == null) goto L329;
        c0 r156 = r155.f489005a;
        if (r156 == null) goto L329;
        boolean r213 = r156.f489024e;
    L330:
        if (r155 == null) goto L336;
        c0 r157 = r155.f489005a;
        if (r157 == null) goto L336;
        Message r158 = r157.f489023d;
        if (r158 == null) goto L336;
        boolean r214 = com.larus.im.bean.message.a.f0(r158);
    L337:
        ib8.b r159 = this.f296352a;
        if (r159 == null) goto L342;
        c0 r160 = r159.f489005a;
        if (r160 == null) goto L342;
        boolean r161 = r160.f489028i;
    L344:
        if (this.f296367p.b() == false) goto L347;
        if (r161 == true) goto L347;
        boolean r162 = true;
    L348:
        ib8.b r163 = this.f296352a;
        if (r163 == null) goto L354;
        c0 r164 = r163.f489005a;
        if (r164 == null) goto L354;
        Message r165 = r164.f489023d;
        if (r165 == null) goto L354;
    L355:
        ib8.b r166 = this.f296352a;
        if (r166 == null) goto L365;
        mb8.a r167 = r166.f489007c;
        if (r167 == null) goto L365;
        List<jc8.a> r168 = r167.f512782a;
        if (r168 == null) goto L365;
        jc8.a r169 = (jc8.a) CollectionsKt.firstOrNull(r168);
        if (r169 == null) goto L365;
        Block r170 = r169.f498145a;
        if (r170 == null) goto L365;
    L366:
        ComplexTaskDelegate r171 = ComplexTaskDelegate.f392864b;
        if (r171.f(r165) == false) goto L381;
        ib8.b r172 = this.f296352a;
        if (r172 == null) goto L375;
        c0 r173 = r172.f489005a;
        if (r173 == null) goto L375;
        if (r173.f489024e != true) goto L375;
        boolean r174 = true;
    L376:
        if (r174 == false) goto L381;
        if (r171.c(r165, r170) == true) goto L380;
        boolean r215 = true;
    L382:
        ib8.b r175 = this.f296352a;
        if (r175 == null) goto L387;
        c0 r176 = r175.f489005a;
        if (r176 == null) goto L387;
        boolean r177 = r176.f489024e;
    L388:
        boolean r311 = !r177;
        if (r175 == null) goto L391;
        ?? r216 = r175.f489010f;
    L392:
        if (r175 == null) goto L396;
        c0 r178 = r175.f489005a;
        if (r178 == null) goto L396;
        boolean r217 = r178.f489035p;
    L397:
        int r410 = c7.b(16);
        int r411 = c7.b(12);
        c r179 = this.f296368q;
        ib8.b r180 = this.f296352a;
        if (r180 == null) goto L402;
        c0 r181 = r180.f489005a;
        if (r181 == null) goto L402;
        boolean r312 = r181.f489029j;
    L403:
        boolean r182 = this.f296357f;
        if (r180 == null) goto L408;
        c0 r183 = r180.f489005a;
        if (r183 == null) goto L408;
        boolean r184 = r183.f489024e;
    L409:
        boolean r313 = !r184;
        if (r180 == null) goto L415;
        c0 r185 = r180.f489005a;
        if (r185 == null) goto L415;
        Function0<Integer> r186 = r185.f489031l;
        if (r186 == null) goto L415;
    L416:
        Function0<Integer> r314 = r186;
        if (r180 == null) goto L421;
        c0 r187 = r180.f489005a;
        if (r187 == null) goto L421;
        boolean r315 = r187.f489033n;
    L422:
        if (r180 == null) goto L428;
        c0 r188 = r180.f489005a;
        if (r188 == null) goto L428;
        if (r188.f489039t != true) goto L428;
        boolean r189 = true;
    L429:
        if (r189 == true) goto L441;
        if (r180 == null) goto L434;
        c0 r190 = r180.f489005a;
        if (r190 == null) goto L434;
        boolean r191 = r190.f489034o;
    L435:
        if (r191 == false) goto L441;
        if (r179.f489019d == DeepThinkFoldStatus.CompleteFold) goto L441;
        if (this.f296367p.b() == true) goto L441;
        boolean r316 = true;
    L442:
        ib8.b r192 = this.f296352a;
        if (r192 == null) goto L447;
        c0 r193 = r192.f489005a;
        if (r193 == null) goto L447;
        ?? r317 = r193.f489036q;
    L448:
        if (r192 == null) goto L452;
        c0 r194 = r192.f489005a;
        if (r194 == null) goto L452;
        ?? r412 = r194.f489037r;
    L453:
        if (r192 == null) goto L457;
        c0 r195 = r192.f489005a;
        if (r195 == null) goto L457;
        ?? r413 = r195.f489038s;
    L458:
        if (r192 == null) goto L462;
        c0 r196 = r192.f489005a;
        if (r196 == null) goto L462;
        boolean r414 = r196.f489030k;
    L463:
        ib8.n r197 = new ib8.n(r211, r212, r216, r210, r217, r215, r213, r214, r311, r179, r182, r313, r312, r314, r315, r316, r310, r317, r412, r413, null, false, false, r410, r411, false, 0, r414, 484442112);
        ib8.b r198 = this.f296352a;
        if (r198 != null) goto L466;
    L547:
        ?? r199 = r138;
    L548:
        ib8.b r200 = this.f296352a;
        if (r200 != null) goto L551;
    L553:
        ?? r1100 = r138;
    L554:
        ib8.a r201 = new ib8.a(r197, r111, r110, r199, r1100, null, 32);
        Message r202 = this.f296358g;
        if (r202 == null) goto L557;
        r138 = r202.getMessageId();
    L557:
        this.f296354c = r138;
        this.f296357f = false;
        this.f296363l = false;
        return r201;
    L551:
        if (r200.f489009e == null) goto L553;
        r1100 = ((do8.w) this.f296372u.getValue()).g();
        goto L554
    L466:
        if (r198.f489008d == null) goto L547;
        k r203 = (k) this.f296366o.getValue();
        nb8.m r204 = r203.f518540a;
        if (r204 == null) goto L470;
        ?? r205 = r204.f518548b;
    L471:
        r203.f518541b = r205;
        if (r204 == null) goto L478;
        String r206 = r204.f518549c;
        if (r206 == null) goto L478;
        if (StringsKt.isBlank(r206) != true) goto L478;
        boolean r207 = true;
    L479:
        if (r207 == false) goto L481;
        boolean r218 = false;
    L507:
        nb8.m r208 = r203.f518540a;
        if (r208 == null) goto L510;
        boolean r219 = r208.f518553g;
    L511:
        if (r208 == null) goto L514;
        fh8.f r209 = r208.f518547a;
        if (r209 == null) goto L514;
    L515:
        fh8.f r220 = r209;
        if (r208 == null) goto L519;
        Message r221 = r208.f518548b;
        if (r221 == null) goto L519;
    L520:
        Message r222 = r221;
        nb8.m r223 = r203.f518540a;
        if (r223 == null) goto L526;
        String r224 = r223.f518549c;
        if (r224 == null) goto L526;
        String r225 = r224;
    L527:
        if (r223 == null) goto L530;
        t.a r226 = r223.f518550d;
        if (r226 == null) goto L530;
    L531:
        t.a r227 = r226;
        nb8.m r228 = r203.f518540a;
        if (r228 == null) goto L534;
        boolean r229 = r228.f518551e;
    L535:
        if (r228 == null) goto L537;
        ?? r230 = r228.f518554h;
    L538:
        nb8.i r231 = new nb8.i(r229, r230, r218, r220, r222, r225, r219, r227);
        Message r232 = r203.f518541b;
        if (r232 == null) goto L541;
        String r233 = r232.getMessageId();
    L542:
        r203.f518542c = r233;
        nb8.m r234 = r203.f518540a;
        if (r234 == null) goto L545;
        boolean r235 = r234.f518551e;
    L546:
        r203.f518544e = !r235;
        r199 = r231;
        goto L548
    L545:
        r235 = false;
        goto L546
    L541:
        r233 = r138;
        goto L542
    L537:
        r230 = r138;
        goto L538
    L534:
        r229 = false;
    L530:
        r226 = new t.a();
    L526:
        r225 = "";
    L519:
        r221 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L514:
        r209 = new fh8.f(0);
        goto L515
    L510:
        r219 = false;
        goto L511
    L481:
        nb8.m r236 = r203.f518540a;
        if (r236 != null) goto L484;
    L486:
        boolean r237 = false;
    L487:
        if (r237 == false) goto L489;
        r218 = true;
        goto L507
    L489:
        Message r238 = r203.f518541b;
        if (r238 != null) goto L492;
    L494:
        boolean r239 = false;
    L495:
        if (r239 == true) goto L497;
    L505:
        boolean r240 = false;
    L506:
        r218 = r240;
        goto L507
    L497:
        if (r203.f518544e == false) goto L504;
        String r241 = r203.f518542c;
        Message r242 = r203.f518541b;
        if (r242 == null) goto L501;
        String r243 = r242.getMessageId();
    L503:
        if ((!Intrinsics.areEqual(r241, r243)) == false) goto L505;
    L501:
        r243 = r138;
    L504:
        r240 = true;
        goto L506
    L492:
        if (com.larus.im.bean.message.a.f0(r238) != true) goto L494;
        r239 = true;
        goto L495
    L484:
        if (r236.f518552f != true) goto L486;
        r237 = true;
    L478:
        r207 = false;
        goto L479
    L470:
        r205 = r138;
    L462:
        r414 = false;
    L457:
        r413 = r138;
    L452:
        r412 = r138;
    L447:
        r317 = r138;
    L434:
        r191 = false;
    L441:
        r316 = false;
    L428:
        r189 = false;
    L421:
        r315 = false;
    L415:
        r186 = new ib8.r();
    L408:
        r184 = false;
    L402:
        r312 = false;
    L396:
        r217 = true;
        goto L397
    L391:
        r216 = r138;
    L387:
        r177 = false;
        goto L388
    L380:
        r215 = false;
    L375:
        r174 = false;
    L381:
        r215 = r162;
    L365:
        r170 = new Block(0, null, null, null, false, null, null, null, 255, null);
    L354:
        r165 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L347:
        r162 = false;
    L342:
        r161 = true;
    L336:
        r214 = false;
    L329:
        r213 = false;
    L313:
        r153 = true;
    L307:
        r151 = false;
        goto L308
    L298:
        if (r145.getMessageStatusLocal() == 22) goto L301;
        r148 = false;
    L320:
        r154 = false;
    L323:
        r212 = false;
    L287:
        r143 = false;
    L279:
        r211 = false;
        goto L280
    L273:
        r138 = null;
    L270:
        r137 = false;
        goto L271
    L262:
        r131 = null;
        goto L263
    L258:
        r124 = r123;
    L255:
        r123 = null;
    L246:
        r119 = false;
    L75:
        r105 = "";
        goto L76
    L95:
        ib8.b r244 = this.f296352a;
        if (r244 == null) goto L241;
        c0 r245 = r244.f489005a;
        if (r245 == null) goto L241;
        List<jc8.a> r246 = r245.f489020a;
        if (r246 == null) goto L241;
        Iterator r247 = r246.iterator();
    L103:
        if (r247.hasNext() == false) goto L241;
        jc8.a r248 = (jc8.a) r247.next();
        final r r249 = (r) this.f296371t.getValue();
        j r1101 = new j(r248);
        r249.getClass();
        Intrinsics.checkNotNullParameter(r1101, "input");
        jc8.a r250 = r1101.f542756a;
        String r251 = r250.getClass().getName();
        so8.t r252 = so8.t.f542785a;
        Intrinsics.checkNotNull(r251);
        Intrinsics.checkNotNullParameter(r251, "blockBizModelClassName");
        List r253 = (List) ((LinkedHashMap) so8.t.f542786b).get(r251);
        if (r253 == null) goto L103;
        Iterator r1102 = r253.iterator();
    L108:
        if (r1102.hasNext() == false) goto L103;
        IZoomInAnimationProvider r1103 = (IZoomInAnimationProvider) r1102.next();
        String r1104 = r1103.a(r250);
        Set<String> r254 = so8.w.f542790a;
        Intrinsics.checkNotNullParameter(r1104, "animationID");
        if (so8.w.f542790a.contains(r1104) == true) goto L108;
        if (r1103.g(r250, r249.f542777i) == false) goto L108;
        final so8.k r1105 = new so8.k(r1104, r1101, r1103.f(r250), r1103, r1103.b(r250));
        so8.k r255 = r249.f542773e;
        if (r255 == null) goto L116;
        String r256 = r255.f542757a;
    L118:
        if (Intrinsics.areEqual(r1104, r256) == false) goto L120;
        r249.c(r1105, "dispatchInput");
        goto L108
    L120:
        FLogger.f375446a.d("ZoomInAnimationManager", "enqueue wait animation queue");
        ZoomInAnimationState r257 = r249.f542772d.f542737a;
        ZoomInAnimationAction r258 = r1105.f542759c;
        ZoomInAnimationAction r259 = ZoomInAnimationAction.HIDE;
        if (r258 != r259) goto L136;
        v r260 = r249.f542769a;
        String r261 = r1105.f542757a;
        r260.getClass();
        Intrinsics.checkNotNullParameter(r261, "animationId");
        List<so8.k> r262 = r260.f542788a;
        ArrayList r263 = new ArrayList();
        Iterator r264 = ((ArrayList) r262).iterator();
    L124:
        if (r264.hasNext() == false) goto L128;
        Object r1106 = r264.next();
        if (Intrinsics.areEqual(((so8.k) r1106).f542757a, r261) == false) goto L124;
        r263.add(r1106);
        goto L124
    L128:
        ((ArrayList) r260.f542788a).removeAll(r263);
        Iterator r265 = r263.iterator();
    L130:
        if (r265.hasNext() == false) goto L108;
        so8.k r266 = (so8.k) r265.next();
        Set r267 = (Set) ((LinkedHashMap) r260.f542789b).get(r266.f542759c);
        if (r267 != null) goto L134;
        r267 = new LinkedHashSet();
    L134:
        r267.remove(r266.f542757a);
        goto L130
    L136:
        if (r257 == ZoomInAnimationState.IDLE) goto L138;
    L141:
        boolean r268 = true;
    L143:
        if (r1105.f542761e.f542741c != ZoomInAnimationEnqueueStrategy.SKIP_IF_BUSY) goto L145;
        boolean r1107 = true;
    L146:
        if (r1107 == false) goto L149;
        if (r268 == true) goto L108;
    L149:
        so8.k r269 = r249.f542773e;
        if (r269 == null) goto L152;
        String r1108 = r269.f542757a;
    L153:
        if (r269 == null) goto L157;
        so8.c r270 = r269.f542761e;
        if (r270 == null) goto L157;
        ZoomInAnimationEndStrategy r271 = r270.f542742d;
    L159:
        if (r257 != ZoomInAnimationState.STAY) goto L161;
    L164:
        boolean r272 = true;
    L165:
        if (r272 == false) goto L172;
        if (r1108 == null) goto L172;
        if (Intrinsics.areEqual(r1105.f542757a, r1108) == true) goto L172;
        if (r271 != ZoomInAnimationEndStrategy.PASSIVE_WAIT) goto L172;
        boolean r273 = true;
    L173:
        so8.k r274 = r249.f542773e;
        if (r274 == null) goto L176;
        final so8.k r275 = so8.k.a(r274, r259);
    L177:
        if (r273 == false) goto L210;
        Runnable r276 = r249.f542775g;
        if (r276 == null) goto L181;
        SoftReference<Handler> r1109 = y.f375498a;
        Intrinsics.checkNotNullParameter(r276, "action");
        y.a(r276);
    L181:
        r249.f542775g = new so8.n(r249, r275);
        so8.b r277 = r249.f542772d;
        ZoomInAnimationState r1110 = r277.f542737a;
        long r1111 = r277.f542738b;
        int r278 = r.b.f542780a[r1110.ordinal()];
        long r279 = 1000;
        if (r278 != 1) goto L184;
        long r1112 = Math.abs(System.currentTimeMillis() - r1111);
        so8.k r280 = r249.f542773e;
        if (r280 == null) goto L203;
        so8.c r281 = r280.f542761e;
        if (r281 == null) goto L203;
        r279 = r281.f542740b;
    L203:
        long r1113 = Math.abs(200 - r1112) + r279;
    L205:
        if (r1113 <= 0) goto L209;
        Runnable r282 = r249.f542775g;
        if (r282 == null) goto L210;
        SoftReference<Handler> r283 = y.f375498a;
        Intrinsics.checkNotNullParameter(r282, "action");
        y.d(r282, r1113);
        goto L210
    L209:
        r249.c(r275, "passive hide");
        goto L210
    L184:
        if (r278 != 2) goto L196;
        long r1114 = Math.abs(System.currentTimeMillis() - r1111);
        so8.k r284 = r249.f542773e;
        if (r284 == null) goto L192;
        so8.c r285 = r284.f542761e;
        if (r285 == null) goto L192;
        r279 = r285.f542740b;
    L192:
        if (r1114 <= r279) goto L194;
        boolean r286 = true;
    L195:
        if (r286 == true) goto L196;
        r1113 = Math.abs(r279 - r1114);
        goto L205
    L194:
        r286 = false;
    L196:
        r1113 = 0;
    L210:
        v r287 = r249.f542769a;
        r287.getClass();
        Intrinsics.checkNotNullParameter(r1105, "zoomInItem");
        Set<String> r288 = (Set) ((LinkedHashMap) r287.f542789b).get(r1105.f542759c);
        if (r288 != null) goto L213;
        r288 = new LinkedHashSet();
    L213:
        r287.f542789b.put(r1105.f542759c, r288);
        if (r288.contains(r1105.f542757a) == false) goto L238;
        Iterator r289 = ((ArrayList) r287.f542788a).iterator();
        int r290 = 0;
    L217:
        if (r289.hasNext() == false) goto L227;
        so8.k r1115 = (so8.k) r289.next();
        if (Intrinsics.areEqual(r1115.f542757a, r1105.f542757a) == true) goto L221;
    L223:
        boolean r1116 = false;
    L224:
        if (r1116 == true) goto L228;
        r290 = r290 + 1;
    L228:
        CollectionsKt.removeAll(r287.f542788a, new u(r1105));
        if (r290 >= 0) goto L231;
    L233:
        r290 = ((ArrayList) r287.f542788a).size();
    L234:
        ListProtector.add(r287.f542788a, r290, r1105);
        Set<String> r291 = (Set) ((LinkedHashMap) r287.f542789b).get(r1105.f542759c);
        if (r291 != null) goto L237;
        r291 = new LinkedHashSet();
    L237:
        r287.f542789b.put(r1105.f542759c, r291);
        r291.add(r1105.f542757a);
        goto L108
    L231:
        if (r290 > ((ArrayList) r287.f542788a).size()) goto L233;
    L221:
        if (r1115.f542759c != r1105.f542759c) goto L223;
        r1116 = true;
        goto L224
    L227:
        r290 = -1;
        goto L228
    L238:
        ((ArrayList) r287.f542788a).add(r1105);
        r288.add(r1105.f542757a);
        goto L108
    L176:
        r275 = null;
    L172:
        r273 = false;
        goto L173
    L161:
        if (r257 == ZoomInAnimationState.ZOOM_IN) goto L164;
        r272 = false;
    L157:
        r271 = null;
        goto L159
    L152:
        r1108 = null;
        goto L153
    L145:
        r1107 = false;
        goto L146
    L138:
        if (((ArrayList) r249.f542769a.f542788a).isEmpty() == false) goto L141;
        r268 = false;
        goto L143
    L116:
        r256 = null;
        goto L118
    L45:
        if (r101.f489007c == null) goto L68;
        mb8.c r292 = (mb8.c) this.f296364m.getValue();
        r292.getClass();
        mb8.a r293 = r292.f512789a;
        if (r293 == null) goto L50;
        List<jc8.a> r294 = r293.f512782a;
        if (r294 == null) goto L50;
    L51:
        List<jc8.a> r295 = r294;
        mb8.a r296 = r292.f512789a;
        if (r296 == null) goto L54;
        Message r297 = r296.f512784c;
    L55:
        if (r296 == null) goto L57;
        boolean r298 = r296.f512786e;
    L58:
        if (r296 == null) goto L60;
        fh8.d r299 = r296.f512787f;
    L61:
        if (r296 == null) goto L63;
        kc8.b r1117 = r296.f512785d;
    L64:
        if (r296 == null) goto L66;
        boolean r1118 = r296.f512783b;
    L67:
        r111 = new lb8.g(r295, r297, r298, r299, r1117, r1118);
        goto L70
    L66:
        r1118 = false;
        goto L67
    L63:
        r1117 = null;
        goto L64
    L60:
        r299 = null;
        goto L61
    L57:
        r298 = false;
        goto L58
    L54:
        r297 = null;
    L50:
        r294 = CollectionsKt.emptyList();
        goto L51
    L5:
        if (r100.f489006b == null) goto L41;
        m r300 = (m) this.f296365n.getValue();
        boolean r301 = r300.f502250d;
        kb8.a r302 = r300.f502247a;
        if (r302 == null) goto L9;
        List<String> r303 = r302.f502226c;
    L10:
        if (r303 == null) goto L25;
        int r304 = r303.size();
        StringBuilder r305 = new StringBuilder();
        Iterator r306 = r303.iterator();
        int r307 = 0;
    L13:
        if (r306.hasNext() == false) goto L24;
        Object r1119 = r306.next();
        int r1120 = r307 + 1;
        if (r307 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r1121 = (String) r1119;
        if (r307 >= r304) goto L23;
        if (r307 >= (r304 - 1)) goto L22;
        r305.append("“" + r1121 + "”、");
        goto L23
    L22:
        r305.append("“" + r1121 + Typography.rightDoubleQuote);
    L23:
        r307 = r1120;
        goto L13
    L24:
        String r308 = r305.toString();
    L26:
        List<kb8.u> r309 = r300.f502249c;
        kb8.a r318 = r300.f502247a;
        if (r318 == null) goto L29;
        o r319 = r318.f502228e;
    L30:
        if (r318 == null) goto L32;
        boolean r1122 = r318.f502230g;
    L33:
        if (r318 == null) goto L35;
        boolean r1123 = r318.f502229f;
    L36:
        if (r318 == null) goto L39;
        DeepThinkFoldStatus r320 = r318.f502231h;
        if (r320 == null) goto L39;
    L40:
        r110 = new i(r301, r308, r309, r319, r1123, r1122, r320);
    L39:
        r320 = DeepThinkFoldStatus.CompleteExpand;
        goto L40
    L35:
        r1123 = false;
        goto L36
    L32:
        r1122 = false;
        goto L33
    L29:
        r319 = null;
        goto L30
    L25:
        r308 = "";
        goto L26
    L9:
        r303 = null;
        goto L10
    }

    public final void b() {
        if (this.f296361j != null) goto L5;
        return;
    L5:
        final int r100 = this.f296359h;
        final WeakReference r101 = new WeakReference(this);
        new Handler(Looper.getMainLooper()).post(new q(r101, r100));
    }

    @Override // hb8.a
    public final void f() {
        this.f296359h++;
        this.f296360i = false;
        this.f296361j = null;
        this.f296354c = null;
        this.f296355d = null;
        this.f296356e = null;
        this.f296370s = null;
        ((m) this.f296365n.getValue()).f();
        ((k) this.f296366o.getValue()).f518544e = false;
        e r100 = this.f296367p;
        r100.f530106b = null;
        ((ArrayList) r100.f530107c).clear();
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [ib8.w] */
    public a() {
        this.f296364m = LazyKt.lazy(new ib8.o());
        this.f296365n = LazyKt.lazy(new s());
        this.f296366o = LazyKt.lazy(new ib8.t());
        this.f296367p = new e();
        this.f296368q = new c(false, null, null, 15);
        this.f296371t = LazyKt.lazy(new ib8.u());
        this.f296372u = LazyKt.lazy(new ib8.v());
        this.f296373v = new w(this);
        this.f296374w = new b(this);
        this.f296375x = LazyKt.lazy(new x(this));
    }
}

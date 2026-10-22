package fca;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.im.bean.message.block.OSearchReference;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.block.search.local.adapter.SearchLocalItemAdapter;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends uba.a<fca.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricBlockLocalSearchBinding f476374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ShimmerTextView> f476375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public eca.c f476376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f476377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f476378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f476379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f476380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f476381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f476382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f476383m;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f476384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObricBlockLocalSearchBinding f476385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f476386c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            this.f476384a.f476377g = null;
            h.m(this.f476385b, this.f476386c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f476384a.f476377g = null;
            h.m(this.f476385b, this.f476386c);
        }

        public b(h r100, ObricBlockLocalSearchBinding r101, boolean r102) {
            this.f476384a = r100;
            this.f476385b = r101;
            this.f476386c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f476387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f476388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ObricBlockLocalSearchBinding f476389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RoundRelativeLayout f476390d;

        public c(RoundRelativeLayout r100, h r101, ObricBlockLocalSearchBinding r102, RoundRelativeLayout r103) {
            this.f476387a = r100;
            this.f476388b = r101;
            this.f476389c = r102;
            this.f476390d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f476388b;     // Catch: Throwable -> L15
            Integer r101 = Integer.valueOf(this.f476389c.f386067j.getWidth());     // Catch: Throwable -> L15
            if (r101.intValue() <= 0) goto L5;
            boolean r102 = true;
        L7:
            if (Boolean.valueOf(r102).booleanValue() == true) goto L10;
            r101 = null;
        L10:
            if (r101 == null) goto L12;
            int r103 = r101.intValue();     // Catch: Throwable -> L15
        L13:
            r100.f476379i = r103;     // Catch: Throwable -> L15
            this.f476390d.invalidateOutline();     // Catch: Throwable -> L15
            return;
        L12:
            r103 = this.f476390d.getWidth();     // Catch: Throwable -> L15
            goto L13
        L5:
            r102 = false;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L19;
            return;
        L19:
            throw th;
        }
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundRelativeLayout f476391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f476392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f476393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ObricBlockLocalSearchBinding f476394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f476395e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ h f476396f;

        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f476397a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RelativeLayout f476398b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecyclerView f476399c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f476400d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ RoundRelativeLayout f476401e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f476402f;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f476397a.f476378h = null;
                RelativeLayout r101 = this.f476398b;
                ViewGroup.LayoutParams r102 = r101.getLayoutParams();
                if (r102 == null) goto L14;
                r102.height = -2;
                r101.setLayoutParams(r102);
                RecyclerView r103 = this.f476399c;
                ViewGroup.LayoutParams r104 = r103.getLayoutParams();
                if (r104 == null) goto L12;
                r104.height = -2;
                r103.setLayoutParams(r104);
                if (this.f476400d == false) goto L9;
                this.f476401e.setClipToOutline(false);
                this.f476397a.f476379i = 0;
                return;
            L9:
                e1.o(this.f476398b);
                h r105 = this.f476397a;
                r105.f476379i = this.f476402f;
                this.f476401e.invalidateOutline();
                return;
            L12:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L14:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }

            public a(h r100, RelativeLayout r101, RecyclerView r102, boolean r103, RoundRelativeLayout r104, int r105) {
                this.f476397a = r100;
                this.f476398b = r101;
                this.f476399c = r102;
                this.f476400d = r103;
                this.f476401e = r104;
                this.f476402f = r105;
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f476391a.getViewTreeObserver().removeOnPreDrawListener(this);
            int r100 = this.f476392b.getHeight();
            int r101 = this.f476393c.getHeight();
            Integer r102 = Integer.valueOf(this.f476394d.f386067j.getWidth());
            if (r102.intValue() <= 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L9;
            r102 = null;
        L9:
            if (r102 == null) goto L11;
            int r104 = r102.intValue();
        L12:
            int r110 = r104;
            int r105 = this.f476391a.getWidth();
            boolean r106 = this.f476395e;
            if (r106 == false) goto L15;
            int r107 = r110;
        L16:
            if (r106 == false) goto L18;
            final int r111 = r105;
        L19:
            if (r106 == false) goto L21;
            int r108 = 0;
        L22:
            if (r106 == false) goto L24;
            final int r210 = r100;
        L26:
            if (r101 <= 0) goto L32;
            RecyclerView r109 = this.f476393c;
            ViewGroup.LayoutParams r112 = r109.getLayoutParams();
            if (r112 == null) goto L31;
            r112.height = r101;
            r109.setLayoutParams(r112);
            goto L32
        L31:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L32:
            RelativeLayout r113 = this.f476392b;
            ViewGroup.LayoutParams r114 = r113.getLayoutParams();
            if (r114 == null) goto L40;
            r114.height = r108;
            r113.setLayoutParams(r114);
            this.f476396f.f476379i = r107;
            this.f476391a.invalidateOutline();
            ValueAnimator r115 = this.f476396f.f476378h;
            if (r115 == null) goto L37;
            r115.cancel();
        L37:
            h r116 = this.f476396f;
            ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            final RelativeLayout r118 = this.f476392b;
            final h r119 = this.f476396f;
            final RoundRelativeLayout r120 = this.f476391a;
            RecyclerView r121 = this.f476393c;
            boolean r122 = this.f476395e;
            r117.setDuration(150);
            final int r123 = r107;
            final int r124 = r108;
            r117.addUpdateListener(new j(r118, r119, r123, r111, r120, r124, r210));
            r117.addListener(new a(r119, r118, r121, r122, r120, r110));
            r117.start();
            r116.f476378h = r117;
            return false;
        L40:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L24:
            r210 = 0;
            goto L26
        L21:
            r108 = r100;
            goto L22
        L18:
            r111 = r110;
            goto L19
        L15:
            r107 = r105;
            goto L16
        L11:
            r104 = this.f476391a.getWidth();
            goto L12
        L5:
            r103 = false;
            goto L6
        }

        public d(RoundRelativeLayout r100, RelativeLayout r101, RecyclerView r102, ObricBlockLocalSearchBinding r103, boolean r104, h r105) {
            this.f476391a = r100;
            this.f476392b = r101;
            this.f476393c = r102;
            this.f476394d = r103;
            this.f476395e = r104;
            this.f476396f = r105;
        }
    }

    static {
    }

    @Override // jc8.b
    public final void i() {
        FLogger.f375446a.d("LocalSearchBlockHolder", "onViewRecycled");
        k(this.f476374d, true);
    }

    public final void p() {
        Iterator<T> r100 = this.f476375e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ShimmerTextView) r100.next()).x();
        goto L4
    L6:
        ((ArrayList) this.f476375e).clear();
    }

    public h() {
        this.f476375e = new ArrayList();
        this.f476382l = LazyKt.lazy(new fca.d());
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L9;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L9;
        DeepThinkingConfig r102 = r101.S();
        if (r102 == null) goto L9;
        boolean r103 = r102.b();
    L10:
        this.f476383m = r103;
        return;
    L9:
        r103 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v39, types: [java.util.ArrayList] */
    @Override // jc8.b
    public final void g(jc8.a r210) {
        fca.a r100 = (fca.a) r210;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        final ObricBlockLocalSearchBinding r101 = this.f476374d;
        if (r101 == null) goto L363;
        Message r102 = r100.j();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Map<String, String> r103 = r102.getExt();
        if (r103 == null) goto L8;
        String r104 = r103.get("o_did");
    L9:
        final String r105 = "";
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        if (Intrinsics.areEqual(r104, (String) this.f476382l.getValue()) == true) goto L15;
        e1.o(r101.f386058a);
        FLogger.f375446a.i("LocalSearchBlockHolder", "is not this device msg: did = " + ((String) this.f476382l.getValue()) + ", msgDid = " + r104);
        return;
    L15:
        BlockContent r106 = r100.f498145a.getContent();
        if (r106 == null) goto L18;
        OSearchQueryResultBlock r107 = r106.getOSearchQueryResultBlock();
    L19:
        if (r107 != null) goto L21;
        FLogger.f375446a.w("LocalSearchBlockHolder", "searchQueryResultBlock == null");
        e1.o(r101.f386058a);
        return;
    L21:
        String r108 = r107.oShownState;
        if (r108 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == false) goto L30;
        FLogger.f375446a.w("LocalSearchBlockHolder", "no oShownState, is invalid data");
        e1.o(r101.f386058a);
        return;
    L30:
        e1.x(r101.f386058a);
        boolean r110 = r100.f498145a.isFinish();
        Boolean r111 = r107.oIsSubBlock;
        if (r111 == null) goto L33;
        final boolean r112 = r111.booleanValue();
    L34:
        FLogger r113 = FLogger.f375446a;
        r113.d("LocalSearchBlockHolder", "onBindBlockView: isFinish = " + r110 + ", isSubBlock = " + r112 + ", messageStatusLocal = " + r100.j().getMessageStatusLocal());
        String r114 = r107.iconUrl;
        boolean r115 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L47;
        String r116 = r107.iconUrlDark;
        if (r116 != null) goto L39;
    L42:
        boolean r117 = true;
    L43:
        if (r117 == true) goto L47;
        r114 = r107.iconUrlDark;
        if (r114 != null) goto L50;
    L48:
        r114 = "";
    L50:
        if (r114.length() != 0) goto L52;
        boolean r118 = true;
    L54:
        if (r118 == false) goto L56;
    L62:
        ViewGroup.LayoutParams r119 = r101.f386063f.getLayoutParams();
        if (r119 == null) goto L65;
        r119.width = i5.v();
        r119.height = i5.v();
        Unit r120 = Unit.INSTANCE;
    L65:
        r101.f386063f.setImageResource(R.drawable.obric_ic_local_search_default);
    L66:
        boolean r121 = !Intrinsics.areEqual(r107.iconUrl, "https://decode/tool_icon/Search.png");
        this.f476381k = r121;
        if (r121 == true) goto L71;
        Intrinsics.checkNotNull(r101.f386058a.getContext().getString(R.string.obric_local_search_result));
    L71:
        if (r110 == false) goto L73;
    L151:
        k(r101, true);
        MessageLoading r122 = r101.f386065h;
        r122.f304832e.cancel();
        r122.f304830c = false;
        e1.o(r101.f386065h);
        e1.x(r101.f386069l);
        TextView r123 = r101.f386069l;
        String r124 = r107.summary;
        if (r124 != null) goto L154;
        r124 = "";
    L154:
        r123.setText(r124);
    L155:
        List<OSearchReference> r125 = r107.results;
        if (r125 != null) goto L158;
    L161:
        boolean r126 = true;
    L162:
        if (r126 == false) goto L164;
    L175:
        boolean r127 = false;
    L176:
        FLogger r128 = FLogger.f375446a;
        StringBuilder r129 = new StringBuilder("item count = ");
        List<OSearchReference> r130 = r107.results;
        if (r130 == null) goto L179;
        int r131 = r130.size();
    L180:
        r129.append(r131);
        r129.append(", shownState = ");
        r129.append(r107.oShownState);
        r129.append(", isFinish = ");
        r129.append(r110);
        r129.append(", isSubBlock = ");
        r129.append(r112);
        r128.d("LocalSearchBlockHolder", r129.toString());
        if (r127 == false) goto L266;
        e1.x(r101.f386059b);
        o(r101, !this.f476383m, false);
        Context r132 = r101.f386058a.getContext();
        if (this.f476381k == false) goto L206;
        String r133 = r132.getString(R.string.obric_double_quotation_marks);
        String r134 = r132.getString(R.string.obric_enumeration_comma);
        List<String> r135 = r107.queries;
        if (r135 == null) goto L199;
        ArrayList r136 = new ArrayList();
        Iterator<T> r137 = r135.iterator();
    L188:
        if (r137.hasNext() == false) goto L195;
        String r138 = (String) r137.next();
        if (r138 == null) goto L192;
        StringCompanionObject r139 = StringCompanionObject.INSTANCE;
        String r140 = String.format(r133, Arrays.copyOf(new Object[]{r138}, 1));
    L193:
        if (r140 == null) goto L188;
        r136.add(r140);
        goto L188
    L192:
        r140 = null;
        goto L193
    L195:
        String r141 = CollectionsKt.joinToString$default(r136, r134, null, null, 0, null, null, 62, null);
        if (r141 == null) goto L199;
        r105 = r141;
    L199:
        r101.f386068k.setText(r105);
        if (r105.length() != 0) goto L202;
        boolean r142 = true;
    L203:
        if (r142 == false) goto L205;
        e1.o(r101.f386068k);
        goto L206
    L205:
        e1.x(r101.f386068k);
        goto L206
    L202:
        r142 = false;
    L206:
        RecyclerView.Adapter r143 = r101.f386064g.getAdapter();
        if ((r143 instanceof SearchLocalItemAdapter) == false) goto L209;
        SearchLocalItemAdapter r144 = (SearchLocalItemAdapter) r143;
    L210:
        if (r144 == null) goto L216;
        List<OSearchReference> r145 = r107.results;
        if (r145 == null) goto L214;
        List<OSearchReference> r146 = CollectionsKt.filterNotNull(r145);
    L215:
        r144.y2(r146, r112);
        goto L216
    L214:
        r146 = null;
    L216:
        e1.d(r101.f386067j, new fca.b(this, r101, r112));
        Lazy r147 = gca.c.f480885a;
        RelativeLayout r148 = r101.f386058a;
        Intrinsics.checkNotNullParameter(r148, "blockView");
        Intrinsics.checkNotNullParameter(r100, "baseBlockBizModel");
        boolean r149 = r100.m();
        boolean r150 = r100.n();
        ViewGroup.LayoutParams r151 = r148.getLayoutParams();
        if ((r151 instanceof ViewGroup.MarginLayoutParams) == false) goto L219;
        ViewGroup.MarginLayoutParams r152 = (ViewGroup.MarginLayoutParams) r151;
    L220:
        jc8.a r153 = r100.k();
        if (r153 == null) goto L225;
        Block r154 = r153.f498145a;
        if (r154 == null) goto L225;
        Integer r155 = Integer.valueOf(r154.getBlockType());
    L226:
        int r156 = r100.f498145a.getBlockType();
        int r157 = BlockType.BLOCK_TYPE_TEXT.getValue();
        if (r155 != null) goto L230;
    L231:
        boolean r158 = true;
    L233:
        if (r152 == null) goto L259;
        if (r149 == false) goto L236;
        int r159 = i5.h();
    L249:
        if (r150 == true) goto L251;
        int r160 = 0;
    L253:
        if (r152.bottomMargin == r160) goto L256;
        r152.bottomMargin = r160;
        r148.setLayoutParams(r152);
    L256:
        if (r152.topMargin == r159) goto L259;
        r152.topMargin = r159;
        r148.setLayoutParams(r152);
        goto L259
    L251:
        r160 = i5.q();
        goto L253
    L236:
        if (r158 == false) goto L248;
        Set<Integer> r161 = gca.c.f480887c;
        if (CollectionsKt.contains(r161, r155) == true) goto L240;
    L242:
        Set<Integer> r162 = gca.c.f480888d;
        if (CollectionsKt.contains(r162, r155) == true) goto L245;
    L247:
        r159 = i5.q();
        goto L249
    L245:
        if (r162.contains(Integer.valueOf(r156)) == false) goto L247;
        r159 = i5.h();
        goto L249
    L240:
        if (r161.contains(Integer.valueOf(r156)) == false) goto L242;
        r159 = i5.v0();
        goto L249
    L248:
        r159 = 0;
    L259:
        if (this.f476381k == false) goto L265;
        View r163 = r101.f386061d;
        if (r112 == false) goto L263;
        int r164 = 0;
    L264:
        r163.setVisibility(r164);
    L280:
        if (this.f476381k == false) goto L311;
        RelativeLayout r165 = r101.f386062e;
        ViewGroup.LayoutParams r166 = r165.getLayoutParams();
        if (r166 == null) goto L309;
        r166.width = -1;
        r165.setLayoutParams(r166);
        RecyclerView r167 = r101.f386064g;
        ViewGroup.LayoutParams r168 = r167.getLayoutParams();
        if (r168 == null) goto L307;
        r168.width = -1;
        r167.setLayoutParams(r168);
        r101.f386060c.getDelegate().e(i5.r0());
        TextView r169 = r101.f386069l;
        ViewGroup.LayoutParams r170 = r169.getLayoutParams();
        if (r170 == null) goto L305;
        ViewGroup.MarginLayoutParams r171 = (ViewGroup.MarginLayoutParams) r170;
        r171.setMarginStart(0);
        r169.setLayoutParams(r171);
        SimpleDraweeView r172 = r101.f386063f;
        ViewGroup.LayoutParams r173 = r172.getLayoutParams();
        if (r173 == null) goto L303;
        r173.width = i5.J();
        r173.height = i5.J();
        r172.setLayoutParams(r173);
        LinearLayout r174 = r101.f386067j;
        ViewGroup.LayoutParams r175 = r174.getLayoutParams();
        if (r175 == null) goto L301;
        r175.width = -2;
        r175.height = r101.f386058a.getResources().getDimensionPixelSize(R.dimen.dp_34);
        r174.setLayoutParams(r175);
        RoundRelativeLayout r176 = r101.f386060c;
        ViewGroup.LayoutParams r177 = r176.getLayoutParams();
        if (r177 == null) goto L299;
        r177.width = -2;
        r176.setLayoutParams(r177);
        if (r112 == false) goto L296;
        e1.x(r101.f386063f);
        r101.f386060c.getDelegate().a(ContextCompat.getColor(r101.f386058a.getContext(), R.color.base_3));
        LinearLayout r178 = r101.f386067j;
        r178.setPadding(0, r178.getPaddingTop(), i5.c(), r178.getPaddingBottom());
        we8.a.b(r101.f386069l, i5.o(), false, null, null, 12);
        r101.f386069l.setTypeface(Typeface.DEFAULT, 1);
        TextView r179 = r101.f386068k;
        r179.setPadding(i5.h(), r179.getPaddingTop(), i5.h(), r179.getPaddingBottom());
        RelativeLayout r180 = r101.f386062e;
        r180.setPadding(r180.getPaddingLeft(), r180.getPaddingTop(), r180.getPaddingRight(), i5.v0());
    L297:
        we8.a.b(r101.f386068k, i5.o(), false, null, null, 12);
        return;
    L296:
        e1.o(r101.f386063f);
        r101.f386060c.getDelegate().a(0);
        LinearLayout r181 = r101.f386067j;
        r181.setPadding(0, r181.getPaddingTop(), 0, r181.getPaddingBottom());
        we8.a.b(r101.f386069l, i5.t(), false, null, null, 12);
        r101.f386069l.setTypeface(Typeface.DEFAULT, 0);
        TextView r182 = r101.f386068k;
        r182.setPadding(0, r182.getPaddingTop(), 0, r182.getPaddingBottom());
        RelativeLayout r183 = r101.f386062e;
        r183.setPadding(r183.getPaddingLeft(), r183.getPaddingTop(), r183.getPaddingRight(), 0);
        goto L297
    L299:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L301:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L303:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L305:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L307:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L309:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L311:
        if (r112 == false) goto L329;
        e1.o(r101.f386068k);
        RelativeLayout r184 = r101.f386062e;
        ViewGroup.LayoutParams r185 = r184.getLayoutParams();
        if (r185 == null) goto L328;
        r185.width = -1;
        r184.setLayoutParams(r185);
        RecyclerView r186 = r101.f386064g;
        ViewGroup.LayoutParams r187 = r186.getLayoutParams();
        if (r187 == null) goto L326;
        r187.width = -1;
        r186.setLayoutParams(r187);
        e1.x(r101.f386063f);
        SimpleDraweeView r188 = r101.f386063f;
        ViewGroup.LayoutParams r189 = r188.getLayoutParams();
        if (r189 == null) goto L324;
        r189.width = i5.v();
        r189.height = i5.v();
        r188.setLayoutParams(r189);
        r101.f386060c.getDelegate().a(ContextCompat.getColor(r101.f386058a.getContext(), R.color.base_3));
        r101.f386060c.getDelegate().e(i5.r0());
        LinearLayout r190 = r101.f386067j;
        ViewGroup.LayoutParams r191 = r190.getLayoutParams();
        if (r191 == null) goto L322;
        r191.width = -2;
        r191.height = -2;
        r190.setLayoutParams(r191);
        r101.f386067j.setPadding(i5.r0(), i5.r0(), i5.r0(), i5.r0());
        we8.a.b(r101.f386069l, i5.m(), false, null, null, 12);
        r101.f386069l.setTypeface(Typeface.create("sans-serif-medium", 0));
        RecyclerView r192 = r101.f386064g;
        r192.setPadding(i5.r0(), r192.getPaddingTop(), i5.r0(), r192.getPaddingBottom());
        RelativeLayout r193 = r101.f386062e;
        r193.setPadding(r193.getPaddingLeft(), r193.getPaddingTop(), r193.getPaddingRight(), i5.v0());
        return;
    L322:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L324:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L326:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L328:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L329:
        e1.o(r101.f386068k);
        RelativeLayout r194 = r101.f386062e;
        ViewGroup.LayoutParams r195 = r194.getLayoutParams();
        if (r195 == null) goto L346;
        r195.width = -1;
        r194.setLayoutParams(r195);
        RecyclerView r196 = r101.f386064g;
        ViewGroup.LayoutParams r197 = r196.getLayoutParams();
        if (r197 == null) goto L344;
        r197.width = -1;
        r196.setLayoutParams(r197);
        e1.x(r101.f386063f);
        SimpleDraweeView r198 = r101.f386063f;
        ViewGroup.LayoutParams r199 = r198.getLayoutParams();
        if (r199 == null) goto L342;
        r199.width = i5.v();
        r199.height = i5.v();
        r198.setLayoutParams(r199);
        r101.f386060c.getDelegate().a(v19.c.a(R.attr.larus_base_1, r101.f386058a.getContext(), R.color.larus_base_1));
        r101.f386060c.getDelegate().e(i5.r0());
        LinearLayout r200 = r101.f386067j;
        ViewGroup.LayoutParams r201 = r200.getLayoutParams();
        if (r201 == null) goto L340;
        r201.width = -2;
        r201.height = -2;
        r200.setLayoutParams(r201);
        r101.f386067j.setPadding(i5.r0(), i5.r0(), i5.r0(), i5.r0());
        we8.a.b(r101.f386069l, i5.m(), false, null, null, 12);
        r101.f386069l.setTypeface(Typeface.create("sans-serif-medium", 0));
        RecyclerView r202 = r101.f386064g;
        r202.setPadding(i5.r0(), r202.getPaddingTop(), i5.r0(), r202.getPaddingBottom());
        RelativeLayout r203 = r101.f386062e;
        r203.setPadding(r203.getPaddingLeft(), r203.getPaddingTop(), r203.getPaddingRight(), i5.r0());
        return;
    L340:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L342:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L344:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L346:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L263:
        r164 = 4;
        goto L264
    L265:
        e1.x(r101.f386061d);
        goto L280
    L230:
        if (r155.intValue() != r157) goto L231;
        r158 = false;
    L225:
        r155 = null;
        goto L226
    L219:
        r152 = null;
        goto L220
    L209:
        r144 = null;
        goto L210
    L266:
        ValueAnimator r204 = this.f476377g;
        if (r204 == null) goto L269;
        r204.cancel();
        Unit r205 = Unit.INSTANCE;
    L269:
        this.f476377g = null;
        m(r101, true);
        e1.o(r101.f386059b);
        e1.o(r101.f386062e);
        r101.f386067j.setOnClickListener(null);
        String r206 = r107.oJumpUrl;
        if (r206 == null) goto L274;
        r105 = r206;
    L274:
        if (Intrinsics.areEqual(r107.oShownState, "1") == true) goto L276;
    L278:
        e1.o(r101.f386059b);
        r101.f386067j.setOnClickListener(null);
        goto L280
    L276:
        if (o0.d(r105) == false) goto L278;
        e1.x(r101.f386059b);
        e1.d(r101.f386067j, new fca.c(this, r101, r105));
        goto L280
    L179:
        r131 = 0;
        goto L180
    L164:
        if (Intrinsics.areEqual(r107.oShownState, "2") == true) goto L173;
        String r1100 = r107.oShownState;
        if (r1100 != null) goto L168;
    L171:
        boolean r1101 = true;
    L172:
        if (r1101 == false) goto L175;
    L168:
        if (r1100.length() == 0) goto L171;
        r1101 = false;
    L173:
        if (r110 == false) goto L175;
        r127 = true;
        goto L176
    L158:
        if (r125.isEmpty() == true) goto L161;
        r126 = false;
        goto L162
    L73:
        if (com.larus.im.bean.message.a.o0(r100.j()) == false) goto L151;
        Boolean r1102 = r107.oHasNotAnimation;
        if (r1102 == null) goto L78;
        boolean r1103 = r1102.booleanValue();
    L79:
        if (r1103 == false) goto L84;
        r113.i("LocalSearchBlockHolder", "oHasNotAnimation = true");
        k(r101, true);
        MessageLoading r1104 = r101.f386065h;
        r1104.f304832e.cancel();
        r1104.f304830c = false;
        e1.o(r101.f386065h);
        e1.x(r101.f386069l);
        TextView r1105 = r101.f386069l;
        String r1106 = r107.summary;
        if (r1106 != null) goto L83;
        r1106 = "";
    L83:
        r1105.setText(r1106);
        goto L155
    L84:
        List<String> r1107 = r107.queries;
        if (r1107 == null) goto L97;
        List r1108 = CollectionsKt.filterNotNull(r1107);
        if (r1108 == null) goto L97;
        List r1109 = new ArrayList();
        Iterator r1110 = r1108.iterator();
    L90:
        if (r1110.hasNext() == false) goto L98;
        String r1111 = (String) r1110.next();
        String r1112 = r107.summary;
        if (r1112 == null) goto L94;
        String r1113 = StringsKt.replace$default(r1112, "%s", r1111, false, 4, null);
    L95:
        if (r1113 == null) goto L90;
        r1109.add(r1113);
        goto L90
    L94:
        r1113 = null;
    L98:
        if (r1109 != 0) goto L100;
    L103:
        boolean r1114 = true;
    L104:
        if (r1114 == false) goto L109;
        String r1115 = r107.summary;
        if (r1115 != null) goto L108;
        r1115 = "";
    L108:
        r1109 = CollectionsKt.listOf(r1115);
    L109:
        if (r112 == false) goto L146;
        MessageLoading r1116 = r101.f386065h;
        r1116.f304832e.cancel();
        r1116.f304830c = false;
        e1.o(r101.f386065h);
        eca.c r1117 = this.f476376f;
        if (r1117 == null) goto L113;
        List<String> r1118 = r1117.f472160b;
    L114:
        if (r1118 == null) goto L122;
        if (r1117 == null) goto L117;
        List<String> r1119 = r1117.f472160b;
    L119:
        if (Intrinsics.areEqual(r1109, r1119) == true) goto L122;
        k(r101, false);
        FLogger.f375446a.i("LocalSearchBlockHolder", "is change to " + r1109);
        goto L122
    L117:
        r1119 = null;
    L122:
        if (this.f476376f != null) goto L137;
        final Context r1120 = r101.f386058a.getContext();
        p();
        ObricBlockLocalSearchBinding r1121 = this.f476374d;
        if (r1121 == null) goto L128;
        TextSwitcher r1122 = r1121.f386066i;
        if (r1122 == null) goto L128;
        r1122.removeAllViews();
    L128:
        ObricBlockLocalSearchBinding r1123 = this.f476374d;
        if (r1123 == null) goto L133;
        TextSwitcher r1124 = r1123.f386066i;
        if (r1124 == null) goto L133;
        r1124.setFactory(new g(r1120, this));
    L133:
        eca.c r1125 = new eca.c(r101.f386066i, r1109);
        this.f476376f = r1125;
        r1125.a(r101.f386058a.getContext());
        eca.c r1126 = this.f476376f;
        if (r1126 == null) goto L136;
        r1126.c();
    L136:
        boolean r1127 = true;
    L138:
        if (r1127 == false) goto L143;
        Iterator r1128 = ((ArrayList) this.f476375e).iterator();
    L141:
        if (r1128.hasNext() == false) goto L143;
        ShimmerTextView r1129 = (ShimmerTextView) r1128.next();
        int r1130 = ShimmerTextView.f304901h;
        r1129.z(false);
    L143:
        TextSwitcher r1131 = r101.f386066i;
        if (r1131 == null) goto L147;
        r1131.setVisibility(0);
    L147:
        e1.o(r101.f386069l);
        TextView r1132 = r101.f386069l;
        String r1133 = r107.summary;
        if (r1133 != null) goto L150;
        r1133 = "";
    L150:
        r1132.setText(r1133);
        goto L155
    L137:
        r1127 = false;
        goto L138
    L113:
        r1118 = null;
        goto L114
    L146:
        k(r101, true);
        e1.x(r101.f386065h);
        r101.f386065h.setLoadingText(CollectionsKt.joinToString$default(r1109, String.valueOf(r101.f386058a.getContext().getString(R.string.obric_enumeration_comma)), null, null, 0, null, null, 62, null));
        r101.f386065h.c();
        goto L147
    L100:
        if (r1109.isEmpty() == true) goto L103;
        r1114 = false;
    L97:
        r1109 = 0;
        goto L98
    L78:
        r1103 = false;
        goto L79
    L56:
        if (Intrinsics.areEqual(r114, "https://decode/tool_icon/Search.png") == true) goto L62;
        ViewGroup.LayoutParams r1134 = r101.f386063f.getLayoutParams();
        if (r1134 == null) goto L61;
        r1134.width = i5.J();
        r1134.height = i5.J();
        Unit r207 = Unit.INSTANCE;
    L61:
        ImageLoaderKt.u(r101.f386063f, r114, "obric_chat.cards");
        goto L66
    L52:
        r118 = false;
        goto L54
    L39:
        if (r116.length() == 0) goto L42;
        r117 = false;
    L47:
        if (r114 != null) goto L50;
    L33:
        r112 = false;
        goto L34
    L24:
        if (r108.length() == 0) goto L27;
        r109 = false;
        goto L28
    L18:
        r107 = null;
        goto L19
    L8:
        r104 = null;
        goto L9
    }

    @Override // jc8.b
    public final View h(ViewGroup r210) {
        Intrinsics.checkNotNullParameter(r210, "viewGroup");
        View r100 = LayoutInflater.from(r210.getContext()).inflate(R.layout.obric_block_local_search, r210, false);
        int r101 = R.id.arrow;
        View r102 = ViewBindings.findChildViewById(r100, R.id.arrow);
        if (r102 == null) goto L33;
        r101 = R.id.container;
        RoundRelativeLayout r103 = (RoundRelativeLayout) ViewBindings.findChildViewById(r100, R.id.container);
        if (r103 == null) goto L33;
        r101 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r100, R.id.divider);
        if (r104 == null) goto L33;
        r101 = R.id.dropdown_layout;
        RelativeLayout r110 = (RelativeLayout) ViewBindings.findChildViewById(r100, R.id.dropdown_layout);
        if (r110 == null) goto L33;
        r101 = R.id.icon;
        SimpleDraweeView r111 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.icon);
        if (r111 == null) goto L33;
        r101 = R.id.item_list;
        RecyclerView r112 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.item_list);
        if (r112 == null) goto L33;
        r101 = R.id.message_loading;
        MessageLoading r113 = (MessageLoading) ViewBindings.findChildViewById(r100, R.id.message_loading);
        if (r113 == null) goto L33;
        r101 = R.id.search_reference_switcher;
        TextSwitcher r114 = (TextSwitcher) ViewBindings.findChildViewById(r100, R.id.search_reference_switcher);
        if (r114 == null) goto L33;
        r101 = R.id.title_layout;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.title_layout);
        if (r115 == null) goto L33;
        r101 = R.id.tv_queries;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_queries);
        if (r116 == null) goto L33;
        r101 = R.id.tv_title;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_title);
        if (r117 == null) goto L33;
        RelativeLayout r105 = (RelativeLayout) r100;
        ObricBlockLocalSearchBinding r106 = new ObricBlockLocalSearchBinding(r105, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117);
        this.f476374d = r106;
        Intrinsics.checkNotNull(r106);
        TextView r107 = (TextView) r113.findViewById(R.id.tv_loading_text);
        if (r107 == null) goto L27;
        we8.a.b(r107, i5.t(), false, null, null, 12);
    L27:
        TextView r108 = (TextView) r113.findViewById(R.id.progress_text_view);
        if (r108 == null) goto L30;
        we8.a.b(r108, i5.t(), false, null, null, 12);
    L30:
        r112.setLayoutManager(new LinearLayoutManager(r105.getContext(), 1, false));
        r112.setAdapter(new SearchLocalItemAdapter());
        r103.setOutlineProvider(new i(this));
        ((ArrayList) this.f476375e).clear();
        this.f476376f = null;
        return r105;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static void m(ObricBlockLocalSearchBinding r100, boolean r101) {
        View r102 = r100.f386059b;
        if (r101 == false) goto L5;
        float r103 = 0.0f;
    L6:
        r102.setRotation(r103);
        return;
    L5:
        r103 = 90.0f;
        goto L6
    }

    public final void k(ObricBlockLocalSearchBinding r100, boolean r101) {
        eca.c r102 = this.f476376f;
        if (r102 == null) goto L5;
        r102.b();
    L5:
        this.f476376f = null;
        p();
        if (r101 == false) goto L12;
        if (r100 == null) goto L13;
        TextSwitcher r103 = r100.f386066i;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void l(final ObricBlockLocalSearchBinding r100, boolean r101, boolean r102) {
        ValueAnimator r103 = this.f476377g;
        if (r103 == null) goto L5;
        r103.cancel();
        this.f476377g = null;
    L5:
        if (r101 == false) goto L10;
        float r104 = 0.0f;
        float r105 = 90.0f;
        if (r102 == false) goto L9;
        r104 = 90.0f;
        r105 = 0.0f;
    L9:
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r104, r105});
        this.f476377g = r106;
        r106.setDuration(150);
        r106.addUpdateListener(new e(r100));
        r106.addListener(new b(this, r100, r102));
        r106.start();
        return;
    L10:
        m(r100, r102);
    }

    public final void o(ObricBlockLocalSearchBinding r100, boolean r110, boolean r111) {
        FLogger.f375446a.d("LocalSearchBlockHolder", "setDropdownExpandState: expand = " + r110 + ", withArrowAnimation = " + r111);
        ValueAnimator r101 = this.f476378h;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f476378h = null;
        if (this.f476381k == false) goto L12;
        if (r110 == false) goto L9;
        e1.x(r100.f386062e);
    L10:
        l(r100, r111, !r110);
        return;
    L9:
        e1.o(r100.f386062e);
        goto L10
    L12:
        RoundRelativeLayout r102 = r100.f386060c;
        RelativeLayout r103 = r100.f386062e;
        RecyclerView r104 = r100.f386064g;
        this.f476380j = i5.r0();
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        if (r105 == null) goto L43;
        r105.width = -1;
        r102.setLayoutParams(r105);
        if (r111 == true) goto L32;
        if (r110 == false) goto L18;
        e1.x(r103);
    L19:
        ViewGroup.LayoutParams r112 = r103.getLayoutParams();
        if (r112 == null) goto L31;
        r112.height = -2;
        r103.setLayoutParams(r112);
        ViewGroup.LayoutParams r113 = r104.getLayoutParams();
        if (r113 == null) goto L29;
        r113.height = -2;
        r104.setLayoutParams(r113);
        l(r100, false, !r110);
        if (r110 == false) goto L26;
        r102.setClipToOutline(false);
        this.f476379i = 0;
        return;
    L26:
        r102.setClipToOutline(true);
        OneShotPreDrawListener.add(r102, new c(r102, this, r100, r102));
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        e1.o(r103);
        goto L19
    L32:
        e1.x(r103);
        ViewGroup.LayoutParams r114 = r103.getLayoutParams();
        if (r114 == null) goto L41;
        r114.height = -2;
        r103.setLayoutParams(r114);
        ViewGroup.LayoutParams r115 = r104.getLayoutParams();
        if (r115 == null) goto L39;
        r115.height = -2;
        r104.setLayoutParams(r115);
        r102.setClipToOutline(true);
        l(r100, true, !r110);
        r102.getViewTreeObserver().addOnPreDrawListener(new d(r102, r103, r104, r100, r110, this));
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}

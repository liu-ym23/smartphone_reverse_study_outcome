package com.larus.bmhome.chat.layout.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.bean.CardCandidateConf;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.bean.NexPulseMedia;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0003-./B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u000bJ,\u0010!\u001a\u00020\u00182$\u0010\"\u001a \u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0015J&\u0010#\u001a\u00020\u00182\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u001aJ\b\u0010$\u001a\u00020\u0018H\u0002J\u0014\u0010%\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160'J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\fR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/WelcomeBackSpan;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;)V", "isDarkMode", "", "()Z", "isDarkMode$delegate", "Lkotlin/Lazy;", "cinitIsLoad", "needRefresh", "getNeedRefresh", "setNeedRefresh", "(Z)V", "cardItemClickListener", "Lkotlin/Function4;", "Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "", "cardItemExposeListener", "Lkotlin/Function3;", "adapter", "Lcom/larus/bmhome/chat/layout/item/WelcomeBackSpan$WelcomeAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cinit", "forceLoad", "setCardItemClickListener", "listener", "setCardItemExposeListener", "initRecyclerView", "setContent", "candidateList", "", "getCardSpanMaxWidth", "getLeftPadding", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "WelcomeAdapter", "WelcomeViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WelcomeBackSpan extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f304227g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f304228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f304229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f304230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function4<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, ? super Integer, Unit> f304231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function3<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, Unit> f304232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f304233f;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<NexPulseCandidate> f304234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WelcomeBackSpan f304235b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f304234a).size();
        }

        public b(WelcomeBackSpan r100) {
            this.f304235b = r100;
            this.f304234a = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v23, types: [com.larus.bmhome.chat.layout.item.u4] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r111) {
            final c r112 = (c) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            final NexPulseCandidate r100 = (NexPulseCandidate) ListProtector.get(this.f304234a, r111);
            final CardCandidateConf r101 = r100.getCardConf();
            if (r101 == null) goto L80;
            Map<String, String> r102 = r100.getCandidateExt();
            r112.getClass();
            Intrinsics.checkNotNullParameter(r101, "conf");
            View r103 = r112.itemView;
            Integer r104 = r101.getCardSize();
            boolean r105 = true;
            String r106 = null;
            if (r104 != null) goto L9;
        L11:
            if (r104 != null) goto L14;
        L16:
            if (r104 != null) goto L19;
        L33:
            RecyclerView.LayoutParams r107 = new RecyclerView.LayoutParams(((Number) i5.f552559y0.getValue()).intValue(), i5.l());
        L34:
            r103.setLayoutParams(r107);
            if (((Boolean) r112.f304238c.f304228a.getValue()).booleanValue() == false) goto L45;
            NexPulseMedia r108 = r101.getCardMedia();
            if (r108 == null) goto L39;
            String r109 = r108.getMediaDarkUrl();
        L41:
            if (com.larus.utils.o0.d(r109) == false) goto L45;
            NexPulseMedia r113 = r101.getCardMedia();
            if (r113 == null) goto L48;
            final String r114 = r113.getMediaDarkUrl();
        L49:
            if (r102 == null) goto L51;
            String r115 = r102.get("use_gecko_load");
        L52:
            boolean r116 = Intrinsics.areEqual(r115, "1");
            if (r102 == null) goto L55;
            r106 = r102.get("gecko_channel");
        L55:
            if (r116 == true) goto L57;
        L65:
            r112.T3(r114);
        L66:
            String r117 = r101.getCardLabel();
            if (r117 != null) goto L69;
        L72:
            if (r105 == false) goto L74;
            r112.f304237b.setVisibility(8);
        L75:
            View r118 = r112.itemView;
            final WelcomeBackSpan r119 = this.f304235b;
            com.larus.utils.e1.d(r118, new p4(r119, r100, r101, r111));
            if (r101.getLabelSugItemType() == null) goto L78;
            TextView r120 = r112.f304237b;
            final WelcomeBackSpan r121 = this.f304235b;
            com.larus.utils.e1.d(r120, new q4(r121, r100, r101, r111));
        L78:
            View r122 = r112.itemView;
            final WelcomeBackSpan r123 = this.f304235b;
            ExposeXTrackerExtKt.b(r122, new r4(r100, r123, r101, r111));
            return;
        L74:
            r112.f304237b.setVisibility(0);
            r112.f304237b.setText(r101.getCardLabel());
            goto L75
        L69:
            if (r117.length() == 0) goto L72;
            r105 = false;
            goto L72
        L57:
            if (com.larus.utils.o0.d(r106) == false) goto L65;
            FLogger.f375446a.i("WcbSpan", "geckoChannel: " + r106 + ", imageUrl: " + r114);
            com.larus.platform.service.c1 r124 = com.larus.platform.service.c1.f365723a;
            if (r114 != null) goto L61;
            String r125 = "";
        L62:
            if (r106 != null) goto L64;
            r106 = "";
        L64:
            r124.e(r125, r106, new u4(r112, r114));
            goto L66
        L61:
            r125 = r114;
            goto L62
        L51:
            r115 = null;
        L48:
            r114 = null;
            goto L49
        L39:
            r109 = null;
        L45:
            NexPulseMedia r126 = r101.getCardMedia();
            if (r126 == null) goto L48;
            r114 = r126.getMediaLightUrl();
            goto L49
        L19:
            if (r104.intValue() != 3) goto L33;
            Float r127 = r101.getRatio();
            if (r127 != null) goto L23;
        L25:
            boolean r128 = false;
        L26:
            if (r128 == true) goto L29;
            r127 = null;
        L29:
            if (r127 == null) goto L31;
            float r129 = r127.floatValue();
        L32:
            int r130 = WelcomeBackSpan.a(r112.f304238c);
            r107 = new RecyclerView.LayoutParams(r130, (int) (r130 * r129));
            goto L34
        L31:
            r129 = i5.l() / ((Number) i5.N1.getValue()).intValue();
            goto L32
        L23:
            if (r127.floatValue() <= 0.0f) goto L25;
            r128 = true;
            goto L26
        L14:
            if (r104.intValue() != 2) goto L16;
            r107 = new RecyclerView.LayoutParams(((Number) i5.f552524m1.getValue()).intValue(), i5.l());
            goto L34
        L9:
            if (r104.intValue() != 1) goto L11;
            r107 = new RecyclerView.LayoutParams(((Number) i5.f552559y0.getValue()).intValue(), i5.l());
            goto L34
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_welcome_back, r100, false);
            WelcomeBackSpan r103 = this.f304235b;
            Intrinsics.checkNotNull(r102);
            return new c(r103, r102);
        }
    }

    public final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SimpleDraweeView f304236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f304237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WelcomeBackSpan f304238c;

        public final void T3(String r100) {
            ImageLoaderKt.y(this.f304236a, r100, "prompt_span_background", new v4(this), 4);
        }

        public c(WelcomeBackSpan r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f304238c = r100;
            super(r101);
            this.f304236a = (SimpleDraweeView) r101.findViewById(R.id.wcb_card_image);
            this.f304237b = (TextView) r101.findViewById(R.id.wcb_card_label);
        }
    }

    public WelcomeBackSpan(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, 0);
    }

    public WelcomeBackSpan(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, 0);
    }

    private final int getCardSpanMaxWidth() {
        return com.larus.bmhome.utils.z1.h(0, null, false, false, 28);
    }

    static {
        f304227g = i5.y0(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
    }

    private final int getLeftPadding() {
        if (com.larus.platform.service.e2.f365734a.isPad() == false) goto L6;
        return 0;
    L6:
        return getResources().getDimensionPixelSize(R.dimen.larus_message_item_start_margin);
    }

    public final boolean getNeedRefresh() {
        return this.f304230c;
    }

    public static final /* synthetic */ int a(WelcomeBackSpan r100) {
        return r100.getCardSpanMaxWidth();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        com.larus.platform.service.e2 r101 = com.larus.platform.service.e2.f365734a;
        Context r102 = getContext();
        if ((r102 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r102;
    L7:
        if (r101.a(r103, r100) == false) goto L10;
        boolean r104 = this.f304229b;
        this.f304229b = true;
        setOrientation(1);
        setGravity(GravityCompat.START);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.f304230c = true;
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void setCardItemClickListener(Function4<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f304231d = r100;
    }

    public final void setCardItemExposeListener(Function3<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f304232e = r100;
    }

    public final void setContent(List<NexPulseCandidate> r100) {
        Intrinsics.checkNotNullParameter(r100, "candidateList");
        removeAllViews();
        setPadding(getLeftPadding(), 0, 0, f304227g);
        RecyclerView r101 = new RecyclerView(getContext());
        r101.setLayoutManager(new LinearLayoutManager(r101.getContext(), 0, false));
        r101.setAdapter(this.f304233f);
        r101.addItemDecoration(new WelcomeBackSpan$initRecyclerView$1$1());
        r101.addOnItemTouchListener(new WelcomeBackSpan$initRecyclerView$1$2());
        ExposeXTrackerExtKt.c(r101);
        addView(r101, new ViewGroup.LayoutParams(-1, -2));
        if ((!r100.isEmpty()) == false) goto L14;
        b r102 = this.f304233f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "newData");
        ((ArrayList) r102.f304234a).clear();
        List<NexPulseCandidate> r103 = r102.f304234a;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        if (((NexPulseCandidate) r106).getCardConf() == null) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L6;
        r104.add(r106);
        goto L6
    L10:
        r107 = false;
        goto L11
    L13:
        ((ArrayList) r103).addAll(r104);
        r102.notifyDataSetChanged();
    L14:
        this.f304230c = false;
    }

    public final void setNeedRefresh(boolean r100) {
        this.f304230c = r100;
    }

    public WelcomeBackSpan(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f304228a = LazyKt.lazy(new o4(this));
        this.f304230c = true;
        this.f304233f = new b(this);
    }
}

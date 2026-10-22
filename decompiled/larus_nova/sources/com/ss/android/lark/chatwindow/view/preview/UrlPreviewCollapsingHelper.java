package com.ss.android.lark.chatwindow.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.framework.ui.ViewTransitionContainer;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.w0;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.utils.UIHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w4b.l;

/* JADX INFO: loaded from: classes35.dex */
public final class UrlPreviewCollapsingHelper<T extends BaseTextContentVO<?>> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f417006o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f417007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y6b.a<T> f417008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f417009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.ViewHolder f417010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f417011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f417012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f417013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewTransitionContainer<TextView> f417014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f417015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j f417016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f417017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f417018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f417019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CollapsingState f417020n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/preview/UrlPreviewCollapsingHelper$CollapsingState;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Collapsed", "Expanded", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CollapsingState extends Enum<CollapsingState> {
        public static final CollapsingState Collapsed = null;
        public static final a Companion = null;
        public static final CollapsingState Default = null;
        public static final CollapsingState Expanded = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CollapsingState[] f417021a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f417022b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CollapsingState> getEntries() {
            return f417022b;
        }

        static {
            CollapsingState r100 = new CollapsingState("Default", 0);
            Default = r100;
            CollapsingState r101 = new CollapsingState("Collapsed", 1);
            Collapsed = r101;
            CollapsingState r102 = new CollapsingState("Expanded", 2);
            Expanded = r102;
            CollapsingState[] r103 = {r100, r101, r102};
            f417021a = r103;
            f417022b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static CollapsingState[] values() {
            return (CollapsingState[]) f417021a.clone();
        }

        public static CollapsingState valueOf(String r100) {
            return (CollapsingState) r27.a.a(CollapsingState.class, r100);
        }

        public CollapsingState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f417023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView.ViewHolder f417024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f417025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f417026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f417027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function0<Unit> f417028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AnimatorSet f417029g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f417030h;

        /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.preview.UrlPreviewCollapsingHelper$a$a, reason: collision with other inner class name */
        public static final class C4881a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417031a;

            public C4881a(a r100) {
                this.f417031a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                View r101 = this.f417031a.f417026d;
                Object r102 = r100.getAnimatedValue();
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
                r101.setRotation(((Float) r102).floatValue());
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417032a;

            public b(a r100) {
                this.f417032a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                View r101 = this.f417032a.f417027e;
                Object r102 = r100.getAnimatedValue();
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
                r101.setAlpha(((Float) r102).floatValue());
            }
        }

        public static final class c implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417033a;

            public c(a r100) {
                this.f417033a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                ViewGroup.LayoutParams r101 = this.f417033a.f417027e.getLayoutParams();
                Object r102 = r100.getAnimatedValue();
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
                r101.height = ((Integer) r102).intValue();
                this.f417033a.f417027e.setLayoutParams(r101);
            }
        }

        public static final class d extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417034a;

            public d(a r100) {
                this.f417034a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationCancel(r100);
                a r101 = this.f417034a;
                View r102 = r101.f417027e;
                int r103 = r101.f417030h;
                ViewGroup.LayoutParams r104 = r102.getLayoutParams();
                r104.height = r103;
                r102.setLayoutParams(r104);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationEnd(r100);
                a r101 = this.f417034a;
                View r102 = r101.f417027e;
                int r103 = r101.f417030h;
                ViewGroup.LayoutParams r104 = r102.getLayoutParams();
                r104.height = r103;
                r102.setLayoutParams(r104);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationStart(r100);
                a r101 = this.f417034a;
                if (r101.f417023a == true) goto L6;
                r101.f417027e.setVisibility(0);
                return;
            }
        }

        public static final class e implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417035a;

            public e(a r100) {
                this.f417035a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                View r101 = this.f417035a.f417025c;
                Object r102 = r100.getAnimatedValue();
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
                k.a(r101, ((Integer) r102).intValue());
            }
        }

        public static final class f extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417036a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f417037b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationCancel(r100);
                k.a(this.f417036a.f417025c, this.f417037b);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationEnd(r100);
                k.a(this.f417036a.f417025c, this.f417037b);
            }

            public f(a r100, int r101) {
                this.f417036a = r100;
                this.f417037b = r101;
            }
        }

        public static final class g extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f417038a;

            public g(a r100) {
                this.f417038a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationCancel(r100);
                this.f417038a.f417028f.invoke();
                RecyclerView.ViewHolder r101 = this.f417038a.f417024b;
                if (r101 == null) goto L6;
                r101.setIsRecyclable(true);
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationEnd(r100);
                this.f417038a.f417028f.invoke();
                RecyclerView.ViewHolder r101 = this.f417038a.f417024b;
                if (r101 == null) goto L6;
                r101.setIsRecyclable(true);
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationStart(r100);
                RecyclerView.ViewHolder r101 = this.f417038a.f417024b;
                if (r101 == null) goto L6;
                r101.setIsRecyclable(false);
                return;
            }
        }

        public static final class h {
        }

        static {
        }

        public a(boolean r100, RecyclerView.ViewHolder r101, View r110, View r111, View r112, Function0<Unit> r113) {
            Intrinsics.checkNotNullParameter(r110, "entryView");
            Intrinsics.checkNotNullParameter(r111, "arrowView");
            Intrinsics.checkNotNullParameter(r112, "collapsedView");
            Intrinsics.checkNotNullParameter(r113, "completion");
            this.f417023a = r100;
            this.f417024b = r101;
            this.f417025c = r110;
            this.f417026d = r111;
            this.f417027e = r112;
            this.f417028f = r113;
            this.f417030h = -2;
            float r102 = r111.getRotation();
            if (r100 == false) goto L5;
            float r114 = 180.0f;
        L6:
            ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r102, r114}).setDuration(300);
            r115.addUpdateListener(new C4881a(this));
            if (r100 == false) goto L9;
            float r103 = 0.0f;
        L10:
            if (r100 == true) goto L12;
            r112.setAlpha(0.0f);
        L12:
            ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r112.getAlpha(), r103}).setDuration(300);
            r104.addUpdateListener(new b(this));
            int[] r105 = new int[2];
            r105[0] = r112.getHeight();
            if (r100 == false) goto L15;
            int r116 = 0;
        L16:
            r105[1] = r116;
            ValueAnimator r117 = ValueAnimator.ofInt(r105).setDuration(300);
            r117.addUpdateListener(new c(this));
            r117.addListener(new d(this));
            if (r100 == false) goto L19;
            int r106 = 0;
        L20:
            ValueAnimator r118 = ValueAnimator.ofInt(new int[]{r110.getPaddingBottom(), r106}).setDuration(300);
            r118.addUpdateListener(new e(this));
            r118.addListener(new f(this, r106));
            AnimatorSet r107 = new AnimatorSet();
            this.f417029g = r107;
            r107.playTogether(new Animator[]{r115, r104, r117, r118});
            r107.setDuration(300);
            r107.addListener(new g(this));
            return;
        L19:
            r106 = UIHelper.dp2px(4.0f);
            goto L20
        L15:
            ViewParent r108 = r112.getParent();
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup");
            r112.measure(View.MeasureSpec.makeMeasureSpec(((ViewGroup) r108).getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            r116 = r112.getMeasuredHeight();
            goto L16
        L9:
            r103 = 1.0f;
            goto L10
        L5:
            r114 = 360.0f;
            goto L6
        }
    }

    public static final class b {
    }

    public interface c {
        void a(String r100, boolean r101);
    }

    static {
    }

    public final void a() {
        if (((Boolean) this.f417017k.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        a r100 = this.f417018l;
        if (r100 == null) goto L8;
        r100.f417029g.cancel();
        View r101 = r100.f417027e;
        int r102 = r100.f417030h;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        r103.height = r102;
        r101.setLayoutParams(r103);
    L8:
        Integer r104 = null;
        this.f417018l = null;
        boolean r105 = true;
        if (this.f417011e.getVisibility() == 8) goto L19;
        Object r106 = this.f417011e.getTag(R.id.tag_msg_url_preview_valid_card_count);
        if ((r106 instanceof Integer) == false) goto L14;
        r104 = (Integer) r106;
    L14:
        if (r104 == null) goto L16;
        int r107 = r104.intValue();
    L17:
        if (r107 <= 1) goto L19;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L38;
        CollapsingState r109 = this.f417020n;
        if (r109 != CollapsingState.Collapsed) goto L25;
    L28:
        boolean r110 = true;
    L29:
        if (r110 == false) goto L31;
        this.f417011e.setVisibility(8);
    L37:
        this.f417012f.setVisibility(0);
        this.f417012f.setOnClickListener(this.f417016j);
        c();
        return;
    L31:
        ViewGroup r111 = this.f417011e;
        if (r111.getAlpha() == 1.0f) goto L35;
        r105 = false;
    L35:
        if (r105 == true) goto L37;
        r111.setAlpha(1.0f);
        goto L37
    L25:
        if (r109 == CollapsingState.Default) goto L28;
        r110 = false;
        goto L29
    L38:
        this.f417012f.setVisibility(8);
        ViewGroup r112 = this.f417011e;
        if (r112.getAlpha() == 1.0f) goto L42;
        r105 = false;
    L42:
        if (r105 == true) goto L46;
        r112.setAlpha(1.0f);
        return;
    L46:
        return;
    L16:
        r107 = 0;
    L19:
        r108 = false;
        goto L21
    }

    public final void c() {
        if (this.f417011e.getVisibility() != 8) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        this.f417015i.setRotation(180.0f);
        this.f417011e.setAlpha(0.0f);
        d(R.string.Lark_IM_MsgShowLinkPreview_Button, false);
        k.a(this.f417012f, 0);
        return;
    L8:
        this.f417015i.setRotation(360.0f);
        this.f417011e.setAlpha(1.0f);
        d(R.string.Lark_IM_MsgHideLinkPreview_Button, false);
        k.a(this.f417012f, UIHelper.dp2px(4.0f));
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "fold";
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        Map<String, Object> r103 = ChatParamUtils.f(this.f417007a.getChatId());
        if (r103 == null) goto L8;
        r102.putAll(r103);
    L8:
        r102.putAll(ChatParamUtils.h(this.f417008b));
        r102.putAll(ChatHitPointNew.a(this.f417008b));
        r102.put("click", r101);
        Statistics.sendEvent("im_url_render_click", new JSONObject(r102));
        return;
    L4:
        r101 = "unfold";
        goto L5
    }

    public final void d(int r100, boolean r101) {
        final String r102 = UIHelper.getString(r100);
        this.f417014h.update(r101, new UrlPreviewCollapsingHelper$updateBtnTitle$1(r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlPreviewCollapsingHelper(m2b.a r100, y6b.a r101, l r102, BlueprintCellViewHolder r103, ViewGroup r104, View r105, w0 r106) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "fgDependency");
        Intrinsics.checkNotNullParameter(r104, "previewContainer");
        Intrinsics.checkNotNullParameter(r105, "collapseButton");
        this.f417007a = r100;
        this.f417008b = r101;
        this.f417009c = r102;
        this.f417010d = r103;
        this.f417011e = r104;
        this.f417012f = r105;
        this.f417013g = r106;
        this.f417014h = (ViewTransitionContainer) r105.findViewById(R.id.btn_title_container);
        this.f417015i = (ImageView) r105.findViewById(android.R.id.icon);
        this.f417016j = new j(this);
        this.f417017k = LazyKt.lazy(new UrlPreviewCollapsingHelper$isFeatureEnabled$2(this));
        this.f417019m = r101.getId();
        CollapsingState.a r107 = CollapsingState.Companion;
        Boolean r108 = ((BaseTextContentVO) r101.b()).D;
        r107.getClass();
        if (r108 != null) goto L6;
        CollapsingState r109 = CollapsingState.Default;
    L11:
        this.f417020n = r109;
        return;
    L6:
        if (Intrinsics.areEqual(r108, Boolean.TRUE) == false) goto L9;
        r109 = CollapsingState.Collapsed;
        goto L11
    L9:
        if (Intrinsics.areEqual(r108, Boolean.FALSE) == false) goto L14;
        r109 = CollapsingState.Expanded;
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }
}

package com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmAIInterpretationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingViewModel f435926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f435927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f435928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f435929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f435930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f435931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<g> f435932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f435933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f435934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f435935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f435936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f435937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f435938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f435939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f435940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f435941p;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAIInterpretationView f435942a;

        public a(MmAIInterpretationView r100) {
            this.f435942a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f435942a.f435927b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAIInterpretationView f435943a;

        public b(MmAIInterpretationView r100) {
            this.f435943a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MmAIInterpretationView r101 = this.f435943a;
            boolean r102 = false;
            if (r101.f435936k == false) goto L5;
        L8:
            boolean r103 = true;
        L10:
            if (r103 == false) goto L13;
            int r104 = bwb.b.f21271a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "actionClick", "skip updating", null, 8);
            return;
        L13:
            g r105 = r101.f435933h;
            if (r105 != null) goto L18;
            int r106 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "actionClick", "no selected language", null);
            return;
        L18:
            if (r101.f435935j == false) goto L23;
            if (r101.d(r105) == true) goto L23;
        L25:
            boolean r107 = true;
        L26:
            MmAIInterpretationView r108 = this.f435943a;
            r108.f435937l = true;
            r108.f435938m = false;
            r108.f435939n = Boolean.valueOf(r107);
            MmAIInterpretationView r109 = this.f435943a;
            if (r107 == true) goto L29;
        L31:
            r109.f435940o = r102;
            r109.f435941p = true;
            MmAIInterpretationView.a(r109);
            int r110 = bwb.b.f21271a;
            MmUiLogScene r111 = MmUiLogScene.AI_NOTE;
            StringBuilder r112 = new StringBuilder("targetEnabled=");
            r112.append(r107);
            r112.append(", currentEnabled=");
            r112.append(this.f435943a.f435935j);
            r112.append(", language=");
            r112.append(r105.f434765a);
            r112.append(", activeLanguage=");
            g r113 = this.f435943a.f435934i;
            if (r113 == null) goto L34;
            String r114 = r113.f434765a;
        L35:
            r112.append(r114);
            r112.append(", selectedLanguage=");
            g r115 = this.f435943a.f435933h;
            if (r115 == null) goto L38;
            String r116 = r115.f434765a;
        L39:
            r112.append(r116);
            r112.append(", languageSize=");
            r112.append(this.f435943a.f435932g.size());
            bwb.b.g(r111, "actionClick", r112.toString(), null, 8);
            this.f435943a.f435926a.dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g.n(r107, r105));
            return;
        L38:
            r116 = null;
            goto L39
        L34:
            r114 = null;
            goto L35
        L29:
            if (r109.f435935j == true) goto L31;
            r102 = true;
        L23:
            if (this.f435943a.f435935j == false) goto L25;
            r107 = false;
            goto L26
        L5:
            if (r101.f435937l == true) goto L8;
            r103 = false;
            goto L10
        }
    }

    public final void c() {
        this.f435937l = false;
        this.f435938m = false;
        this.f435939n = null;
        this.f435940o = false;
        this.f435941p = false;
    }

    public final boolean e() {
        Boolean r100 = this.f435939n;
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L15;
        if (this.f435935j == false) goto L24;
        g r101 = this.f435933h;
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L25;
    L20:
        return true;
    L25:
        return false;
    L9:
        if (d(r101) != true) goto L11;
        r102 = true;
        goto L12
    L24:
        return false;
    L15:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L17;
        if (r100 == null) goto L20;
        throw new NoWhenBranchMatchedException();
    L17:
        if (this.f435935j == false) goto L20;
        return false;
    }

    public final void f() {
        boolean r100 = true;
        if (this.f435933h == null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (this.f435937l == true) goto L12;
    L16:
        boolean r102 = false;
    L18:
        if (this.f435935j == true) goto L22;
        if (r102 == true) goto L22;
        r100 = false;
    L22:
        this.f435930e.setEnabled(r101);
        this.f435931f.setEnabled(r101);
        TextView r103 = this.f435930e;
        float r104 = 1.0f;
        if (r101 == false) goto L25;
        float r105 = 1.0f;
    L26:
        r103.setAlpha(r105);
        TextView r106 = this.f435931f;
        if (r101 == true) goto L30;
        r104 = 0.4f;
    L30:
        r106.setAlpha(r104);
        if (r100 == false) goto L33;
        this.f435930e.setVisibility(8);
        this.f435931f.setVisibility(0);
        return;
    L33:
        this.f435930e.setVisibility(0);
        this.f435931f.setVisibility(8);
        return;
    L25:
        r105 = 0.4f;
        goto L26
    L12:
        if (Intrinsics.areEqual(this.f435939n, Boolean.TRUE) == false) goto L16;
        if (this.f435941p == true) goto L16;
        r102 = true;
        goto L18
    L5:
        if ((!this.f435932g.isEmpty()) == true) goto L8;
        r101 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r100 = ViewTreeLifecycleOwner.get(this);
        if (r100 == null) goto L8;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L9;
        int r102 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "onAttachedToWindow", "onAttachedToWindow scope=" + r101, null, 8);
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$1.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$2(this, null));
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$3.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$4(this, null));
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$5.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$6(this, null));
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$7.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$8(this, null));
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$9.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$10(this, null));
        this.f435926a.selectSubscribe(r101, MmAIInterpretationView$onAttachedToWindow$1$11.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$12(this, null));
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "onDetachedFromWindow", null, null, 12);
    }

    public static final void a(final MmAIInterpretationView r110) {
        r110.f435929d.removeAllViews();
        if (r110.f435932g.isEmpty() == false) goto L9;
        LinearLayout r100 = r110.f435929d;
        TextView r101 = new TextView(r110.getContext());
        if (r110.f435936k == false) goto L7;
        String r102 = r101.getContext().getString(R.string.MMWeb_G_Loading);
    L8:
        r101.setText(r102);
        r101.setTextColor(r101.getContext().getColor(R.color.text_title));
        r101.setTextSize(16.0f);
        r101.setGravity(16);
        r101.setPadding(UIUtils.dp2px(r110.getContext(), 16.0f), 0, UIUtils.dp2px(r110.getContext(), 16.0f), 0);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.dp2px(r110.getContext(), 52.0f)));
        r100.addView(r101);
        r110.f();
        return;
    L7:
        r102 = r101.getContext().getString(R.string.MMWeb_G_SomethingWentWrong);
        goto L8
    L9:
        Iterator<T> r103 = r110.f435932g.iterator();
        int r104 = 0;
    L11:
        if (r103.hasNext() == false) goto L43;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final g r107 = (g) r105;
        LinearLayout r108 = r110.f435929d;
        int r109 = r110.f435932g.size();
        e r111 = e.f436896a;
        MmRecordingUILaunchMode r112 = r110.f435926a.getUiLaunchMode();
        r111.getClass();
        View r113 = e.b(r112).getLayout().y(LayoutInflater.from(c.c(r110.getContext(), r110.f435926a.getUiLaunchMode())), r110.f435929d);
        boolean r114 = true;
        if (r109 != 1) goto L18;
        Drawable r115 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r110.getContext()).m(r110.getContext());
    L24:
        r113.setBackground(r115);
        h.a(r113, new MmAIInterpretationView$createLanguageRow$1(r110, r107));
        TextView r116 = (TextView) r113.findViewById(R.id.tvAIInterpretationLanguage);
        String r117 = r107.f434766b;
        if (r117.length() == 0) goto L28;
        r114 = false;
    L28:
        if (r114 == false) goto L30;
        r117 = r107.f434765a;
    L30:
        r116.setText(r117);
        g r118 = r110.f435933h;
        if (r118 == null) goto L33;
        String r119 = r118.f434765a;
    L34:
        boolean r120 = Intrinsics.areEqual(r119, r107.f434765a);
        ImageView r121 = (ImageView) r113.findViewById(R.id.ivAIInterpretationChecked);
        if (r120 == false) goto L37;
        int r122 = 0;
    L38:
        r121.setVisibility(r122);
        View r123 = r113.findViewById(R.id.aiInterpretationDividerLine);
        if (r104 != (r109 - 1)) goto L41;
        int r124 = 8;
    L42:
        r123.setVisibility(r124);
        r108.addView(r113);
        r104 = r106;
        goto L11
    L41:
        r124 = 0;
        goto L42
    L37:
        r122 = 4;
        goto L38
    L33:
        r119 = null;
        goto L34
    L18:
        if (r104 != 0) goto L21;
        r115 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r110.getContext()).r(r110.getContext());
        goto L24
    L21:
        if (r104 != (r109 - 1)) goto L23;
        r115 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r110.getContext()).n(r110.getContext());
        goto L24
    L23:
        r115 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r110.getContext()).b(r110.getContext());
        goto L24
    L43:
        r110.f();
    }

    public static final boolean b(MmAIInterpretationView r100) {
        if (r100.f435937l == true) goto L5;
        return false;
    L5:
        if (r100.f435938m == true) goto L7;
        return false;
    L7:
        if (r100.f435936k == false) goto L10;
        return false;
    L10:
        if (r100.f435941p == true) goto L12;
        boolean r101 = false;
    L20:
        if (r101 == false) goto L35;
        if (r100.f435940o == true) goto L24;
    L30:
        r100.c();
        Function0<Unit> r102 = r100.f435927b;
        if (r102 == null) goto L33;
        r102.invoke();
    L33:
        return true;
    L24:
        if (Intrinsics.areEqual(r100.f435939n, Boolean.TRUE) == false) goto L30;
        if (r100.f435935j == false) goto L30;
        Function0<Unit> r103 = r100.f435928c;
        if (r103 == null) goto L30;
        r103.invoke();
        goto L30
    L35:
        if (r100.e() == false) goto L42;
        r100.c();
        return false;
    L42:
        return false;
    L12:
        Boolean r104 = r100.f435939n;
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L16;
        r101 = r100.e();
        goto L20
    L16:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == true) goto L19;
        if (r104 == null) goto L19;
        throw new NoWhenBranchMatchedException();
    L19:
        r101 = true;
        goto L20
    }

    public final boolean d(g r100) {
        g r101 = this.f435934i;
        if (r101 == null) goto L5;
        String r102 = r101.f434765a;
    L7:
        return Intrinsics.areEqual(r102, r100.f434765a);
    L5:
        r102 = null;
        goto L7
    }

    public MmAIInterpretationView(Context r100, MmRecordingViewModel r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        super(r100);
        this.f435926a = r101;
        this.f435927b = r102;
        this.f435928c = r103;
        this.f435932g = CollectionsKt.emptyList();
        setOrientation(1);
        e r104 = e.f436896a;
        MmRecordingUILaunchMode r105 = r101.getUiLaunchMode();
        r104.getClass();
        e.b(r105).getLayout().k(LayoutInflater.from(c.c(r100, r101.getUiLaunchMode())), this);
        MmTitleBarView r106 = (MmTitleBarView) findViewById(R.id.titleBar);
        LinearLayout r107 = (LinearLayout) findViewById(R.id.aiInterpretationLanguageContainer);
        this.f435929d = r107;
        TextView r108 = (TextView) findViewById(R.id.startAIInterpretation);
        this.f435930e = r108;
        TextView r109 = (TextView) findViewById(R.id.stopAIInterpretation);
        this.f435931f = r109;
        int r110 = uvb.b.f551863a;
        uvb.b.a(this, R.id.aiInterpretationLanguageContainer, uvb.c.U);
        uvb.b.a(this, R.id.ivClose, uvb.c.V);
        uvb.b.a(this, R.id.startAIInterpretation, uvb.c.W);
        uvb.b.a(this, R.id.stopAIInterpretation, uvb.c.X);
        r106.setCloseClickListener(new a(this));
        r107.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).k(r100));
        final b r111 = new b(this);
        h.a(r108, new AnonymousClass2(r111));
        h.a(r109, new AnonymousClass3(r111));
        f();
    }
}

package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import hq9.m2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes25.dex */
public final class MultiTypeMentionPanelController {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f298629c0 = 0;
    public final boolean A;
    public final boolean B;
    public final SkillSearchIndex C;
    public boolean D;
    public boolean E;
    public final h1 F;
    public k1 G;
    public Integer H;
    public b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f298630J;
    public boolean K;
    public Integer L;
    public boolean M;
    public boolean N;
    public final e1 O;
    public List<d0> P;
    public Job Q;
    public Job R;
    public Pair<Boolean, Boolean> S;
    public final EditText T;
    public final b0 U;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 V;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r W;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.project.h X;
    public MentionPanelController Y;
    public SlashPanelController Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatInputWithMentionDelegate f298631a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ProjectPanelController f298632a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f298633b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final i1 f298634b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y8 f298635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final va8.c f298636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Integer> f298637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f298638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qp8.e f298639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Fragment f298640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f298641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Boolean> f298642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f298643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Boolean> f298644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Boolean> f298645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Boolean> f298646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<be8.a> f298647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<MentionFilePickerType, Unit> f298648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function1<Boolean, Unit> f298649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<Boolean, Unit> f298650r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function1<Boolean, Unit> f298651s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Unit> f298652t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f298653u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f298654v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set<SlashPanelContent> f298655w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set<MentionPanelContent> f298656x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f298657y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f298658z;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3", f = "MultiTypeMentionPanelController.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiTypeMentionPanelController this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MultiTypeMentionPanelController f298659a;

            public a(MultiTypeMentionPanelController r100) {
                this.f298659a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                Pair<Boolean, Boolean> r102 = (Pair) r100;
                MultiTypeMentionPanelController r103 = this.f298659a;
                if (r103.E == true) goto L19;
                if (Intrinsics.areEqual(r102, r103.S) == true) goto L19;
                MultiTypeMentionPanelController r104 = this.f298659a;
                r104.S = r102;
                if (r104.f298656x.contains(MentionPanelContent.CONTACT) == false) goto L20;
                MultiTypeMentionPanelController r105 = this.f298659a;
                k1 r106 = r105.G;
                if (r106 == null) goto L13;
                MultiTypePanelTrigger r107 = r106.f298768d;
            L15:
                if (r107 != MultiTypePanelTrigger.MENTION) goto L17;
                r105.l();
            L17:
                this.f298659a.d();
                return Unit.INSTANCE;
            L13:
                r107 = null;
                goto L15
            L20:
                return Unit.INSTANCE;
            L19:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(MultiTypeMentionPanelController r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LarkSocialExp.f365340a.getClass();
            final StateFlowImpl r103 = LarkSocialExp.f365344e;
            Flow r104 = kotlinx.coroutines.flow.e.n(new MultiTypeMentionPanelController$3$invokeSuspend$$inlined$map$1(r103));
            a r105 = new a(this.this$0);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f298662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MultiTypePanelTrigger f298663b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f298662a == r101.f298662a) goto L12;
            return false;
        L12:
            if (this.f298663b == r101.f298663b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f298662a * 31) + this.f298663b.hashCode();
        }

        public final String toString() {
            return "DismissedQuery(start=" + this.f298662a + ", trigger=" + this.f298663b + ')';
        }

        public b(int r100, MultiTypePanelTrigger r101) {
            Intrinsics.checkNotNullParameter(r101, "trigger");
            this.f298662a = r100;
            this.f298663b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298664a = null;

        static {
            int[] r100 = new int[MultiTypePanelTrigger.values().length];
            r100[MultiTypePanelTrigger.MENTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MultiTypePanelTrigger.SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MultiTypePanelTrigger.EXTERNAL_SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f298664a = r100;
        }
    }

    static {
    }

    public final void l() {
        o(false);
        this.G = null;
        this.H = null;
        this.M = false;
        MentionPanelController r100 = this.Y;
        if (r100 == null) goto L5;
        r100.i();
    L5:
        SlashPanelController r101 = this.Z;
        if (r101 == null) goto L8;
        r101.d();
    L8:
        ProjectPanelController r102 = this.f298632a0;
        if (r102 == null) goto L11;
        r102.b();
    L11:
        p(false);
    }

    public final void d() {
        MentionPanelController r100 = this.Y;
        if (r100 == null) goto L17;
        Job r101 = r100.f298793q;
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        r100.E.a();
        r100.F = null;
        gc8.b r102 = r100.G;
        if (r102 == null) goto L10;
        r102.release();
    L10:
        r100.B++;
        r100.C++;
        Job r103 = r100.f298792p;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        Job r104 = r100.f298794r;
        if (r104 == null) goto L16;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L16:
        r100.q();
        r100.Q.remove();
        r100.f298790n = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.m0 r105 = r100.P;
        r105.f298940c = false;
        ExposeXTrackerExtKt.a(r105.f298938a, "mention_panel_option:");
    L17:
        this.Y = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r106 = this.V;
        if (r106 == null) goto L25;
        r106.f298957d.i(false);
        MentionPanelListView r107 = r106.f298954a;
        r107.f(true);
        r107.j(0);
        r107.f298823h = null;
        ViewParent r108 = r106.f298955b.getParent();
        if ((r108 instanceof ViewGroup) == false) goto L22;
        ViewGroup r109 = (ViewGroup) r108;
    L23:
        if (r109 == null) goto L25;
        r109.removeView(r106.f298955b);
        goto L25
    L22:
        r109 = null;
    L25:
        this.V = null;
    }

    public final void f() {
        ProjectPanelController r100 = this.f298632a0;
        if (r100 == null) goto L8;
        r100.f299117j = false;
        Job r101 = r100.f299121n;
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        r100.f299122o.remove();
    L8:
        this.f298632a0 = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r102 = this.X;
        if (r102 == null) goto L16;
        r102.f299135b = null;
        ViewParent r103 = r102.f299142i.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L13;
        ViewGroup r104 = (ViewGroup) r103;
    L14:
        if (r104 == null) goto L16;
        r104.removeView(r102.f299142i);
        goto L16
    L13:
        r104 = null;
    L16:
        this.X = null;
    }

    public final void g() {
        SlashPanelController r100 = this.Z;
        if (r100 == null) goto L14;
        r100.f299181w = false;
        r100.f299177s.a();
        r100.C++;
        View r101 = r100.E;
        if (r101 == null) goto L7;
        com.larus.bmhome.view.screenmenu.d.b(r101);
    L7:
        r100.E = null;
        Job r102 = r100.B;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        Job r103 = r100.D;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        r100.f299182x = null;
        r100.F = false;
        r100.G = 0;
        ExposeXTrackerExtKt.a(r100.f299176r, "slash_panel_option:");
    L14:
        this.Z = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r104 = this.W;
        if (r104 == null) goto L22;
        r104.f299230e.i(false);
        ViewParent r105 = r104.f299229d.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L19;
        ViewGroup r106 = (ViewGroup) r105;
    L20:
        if (r106 == null) goto L22;
        r106.removeView(r104.f299229d);
        goto L22
    L19:
        r106 = null;
    L22:
        this.W = null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.x0] */
    public final ProjectPanelController h() {
        ProjectPanelController r100 = this.f298632a0;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r101 = new com.larus.bmhome.chat.component.bottom.core.inputtext.project.h(this.f298633b, new x0(this));
        this.X = r101;
        ProjectPanelController r102 = new ProjectPanelController(this.f298638f, this.f298640h, r101, this.f298647o, this.f298642j, new MultiTypeMentionPanelController$ensureProjectController$2(this), new MultiTypeMentionPanelController$ensureProjectController$3(this));
        this.f298632a0 = r102;
        return r102;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.z0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.a1] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.b1] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.c1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.d1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.y0] */
    public final SlashPanelController i() {
        SlashPanelController r100 = this.Z;
        if (r100 == null) goto L5;
        return r100;
    L5:
        final String r101 = AccountService.f365697a.getUserId();
        final String r102 = this.f298639g.f534374d.invoke();
        final com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r110 = new com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r(this.f298633b, new y0(this));
        this.W = r110;
        SlashPanelController r111 = new SlashPanelController(this.f298631a, this.f298638f, this.f298640h, r110, this.f298647o, this.f298642j, this.f298644l, new z0(this, r101, r102), new a1(this), this.f298652t, this.f298646n, this.f298655w, new b1(this), new c1(r110, this), new d1(this), new MultiTypeMentionPanelController$ensureSlashController$7(this), new MultiTypeMentionPanelController$ensureSlashController$8(this), this.C);
        this.Z = r111;
        return r111;
    }

    public final void m() {
        boolean r100 = this.f298641i.invoke().booleanValue();
        if (this.D != r100) goto L5;
        return;
    L5:
        this.D = r100;
        k1 r101 = this.G;
        k1 r102 = null;
        if (r101 == null) goto L8;
        MultiTypePanelTrigger r103 = r101.f298768d;
    L10:
        if (r103 != MultiTypePanelTrigger.MENTION) goto L12;
        l();
    L12:
        d();
        k1 r104 = this.G;
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.f298768d != MultiTypePanelTrigger.SLASH) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r102 = r104;
    L20:
        if (r102 == null) goto L26;
        SlashPanelController r106 = this.Z;
        if (r106 == null) goto L27;
        r106.l(r102);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        r105 = false;
        goto L18
    L8:
        r103 = null;
        goto L10
    }

    public final void q() {
        k1 r100 = this.G;
        if (r100 == null) goto L5;
        String r101 = r100.f298767c;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        MentionPanelController r102 = this.Y;
        if (r102 == null) goto L11;
        r102.i();
    L11:
        SlashPanelController r103 = this.Z;
        if (r103 == null) goto L17;
        r103.f299181w = false;
        r103.f299177s.a();
        View r104 = r103.E;
        if (r104 == null) goto L16;
        com.larus.bmhome.view.screenmenu.d.b(r104);
    L16:
        r103.E = null;
        r103.f299162d.f299230e.i(false);
        r103.F = false;
        r103.G = 0;
        ExposeXTrackerExtKt.a(r103.f299176r, "slash_panel_option:");
    L17:
        ProjectPanelController r105 = h();
        Intrinsics.checkNotNullParameter(r101, "query");
        r105.f299117j = true;
        r105.f299116i = StringsKt.trim(r101).toString();
        r105.f299122o.setEnabled(true);
        r105.d();
        r105.e();
        p(true);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void s() {
        if (this.K == true) goto L5;
        return;
    L5:
        Integer r100 = this.f298637e.invoke();
        if (r100 != null) goto L9;
        FLogger.f375446a.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] skip, reason=missingTopAnchor");
        return;
    L9:
        int[] r101 = new int[2];
        this.f298633b.getLocationOnScreen(r101);
        int r102 = r101[1] + this.f298633b.getHeight();
        int r103 = RangesKt.coerceAtLeast(r102 - r100.intValue(), 0);
        FLogger r104 = FLogger.f375446a;
        r104.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] apply, topAnchorY=" + r100 + ", panelY=" + r101[1] + ", panelSize=" + this.f298633b.getWidth() + Permission.EXECUTE + this.f298633b.getHeight() + ", availableHeight=" + r103);
        View r105 = this.f298633b.getRootView();
        int[] r106 = new int[2];
        r105.getLocationOnScreen(r106);
        int r107 = r106[1] + ((int) (((float) r105.getHeight()) * 0.34f));
        WindowInsetsCompat r108 = ViewCompat.getRootWindowInsets(r105);
        if (r108 != null) goto L12;
    L14:
        boolean r109 = false;
    L15:
        View r110 = this.f298636d.j();
        Integer r111 = null;
        if (r110 != null) goto L18;
    L23:
        int r112 = r100.intValue();
        ConstraintLayout r113 = this.f298636d.h();
        if (r113 == null) goto L26;
        int r114 = r113.getPaddingTop();
    L27:
        int r115 = r112 + r114;
        int r116 = RangesKt.coerceAtLeast(r102 - r115, 0);
        int r117 = r102 - r107;
        r104.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] inputBounds, inputPanelTop=" + r115 + ", inputPanelBottom=" + r102 + ", inputPanelMaxHeight=" + r116 + ", inputPanelInitialHeight=" + r117 + ", imeVisible=" + r109);
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r118 = this.V;
        if (r118 == null) goto L55;
        if (r116 <= 0) goto L55;
        if (r118.f298957d.f299036p == true) goto L55;
        if (r118.f298958e == r109) goto L36;
        MentionPanelListView r119 = r118.f298954a;
        r119.f(true);
        r119.j(0);
        r119.f298823h = null;
        r118.f298958e = r109;
    L36:
        r118.f298957d.j(r116, r117, r109);
        MentionPanelListView r120 = r118.f298954a;
        r120.getClass();
        int r121 = RangesKt.coerceAtLeast(r116, 0);
        if (r120.f298822g == r121) goto L55;
        r120.f298822g = r121;
        Integer r122 = r120.f298823h;
        if (r122 == null) goto L42;
        r111 = Integer.valueOf(RangesKt.coerceAtMost(r122.intValue(), r121));
    L42:
        r120.f298823h = r111;
        if (r120.f298825j.isEmpty() == true) goto L45;
    L47:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.y> r123 = r120.e();
        r120.c(r123);
        if (Intrinsics.areEqual(r123, r120.f298826k) == true) goto L50;
        r120.f298826k = r123;
        r120.f298819d.y2(r123, r120.f298827l, r120.f298829n);
        r120.f298836u.invalidateItemDecorations();
    L50:
        Integer r124 = r120.f298823h;
        if (r124 == null) goto L53;
        int r125 = r124.intValue();
    L54:
        r120.f298824i = r125;
        r120.f298817b.invoke(Boolean.FALSE);
        goto L55
    L53:
        r125 = RangesKt.coerceAtMost(r120.g(r120.f298826k), r120.f298822g);
        goto L54
    L45:
        if (r120.f298828m == true) goto L47;
    L55:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r126 = this.W;
        if (r126 == null) goto L59;
        r126.f299230e.j(r116, r117, r109);
    L59:
        if (this.f298633b.getHeight() <= 0) goto L67;
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r127 = this.X;
        if (r127 == null) goto L68;
        int r128 = RangesKt.coerceAtLeast(r103, 0);
        if (r127.f299136c == r128) goto L69;
        r127.f299136c = r128;
        r127.a();
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L26:
        r114 = 0;
        goto L27
    L18:
        if (r110.isLaidOut() == true) goto L21;
        r110 = null;
    L21:
        if (r110 == null) goto L23;
        r110.getLocationOnScreen(r101);
        r102 = r101[1];
        goto L23
    L12:
        if (r108.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L14;
        r109 = true;
        goto L15
    }

    public final void a(MultiTypePanelTrigger r100) {
        if (r100 != MultiTypePanelTrigger.MENTION) goto L5;
        boolean r101 = true;
    L6:
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r102 = this.V;
        if (r102 == null) goto L9;
        r102.f298957d.i(r101);
    L9:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r103 = this.W;
        if (r103 == null) goto L12;
        r103.f299230e.i(!r101);
    L12:
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r104 = this.X;
        if (r104 == null) goto L16;
        r104.f299142i.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void b(MultiTypePanelTrigger r100) {
        o(false);
        k1 r101 = this.G;
        if (r101 != null) goto L5;
    L13:
        b r102 = null;
    L14:
        this.I = r102;
        this.G = null;
        this.H = null;
        this.M = false;
        e(r100);
        p(false);
        return;
    L5:
        if (r101.f298768d != r100) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        r102 = new b(r101.f298765a, r101.f298768d);
        goto L14
    L7:
        r103 = false;
        goto L8
    }

    public final boolean c(k1 r100) {
        Editable r101 = this.T.getText();
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.length();
        int r103 = r100.f298765a;
        if (r103 < 0) goto L9;
        if (r103 > r102) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L25;
        int r105 = r101.length();
        int r106 = r100.f298766b;
        if (r103 > r106) goto L15;
        if (r106 > r105) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L25;
        this.f298630J = true;
        r101.delete(r100.f298765a, r106);     // Catch: Throwable -> L22
        this.f298630J = false;
        this.G = null;
        this.H = null;
        this.I = null;
        return true;
    L22:
        th = move-exception;
        this.f298630J = false;
        throw th;
    L15:
        r107 = false;
    L25:
        return false;
    L9:
        r104 = false;
        goto L10
    }

    public final void e(MultiTypePanelTrigger r100) {
        int r101 = c.f298664a[r100.ordinal()];
        if (r101 != 1) goto L5;
        d();
        return;
    L5:
        if (r101 != 2) goto L7;
    L11:
        g();
        f();
        return;
    L7:
        if (r101 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    public final k1 j(Editable r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = this.T.getSelectionStart();
        if (r100 >= 0) goto L8;
    L71:
        return null;
    L8:
        if (r100 != this.T.getSelectionEnd()) goto L71;
        if (r100 > r110.length()) goto L71;
        int r101 = r100 - 1;
    L13:
        if (r101 < 0) goto L71;
        if (CharsKt.isWhitespace(r110.charAt(r101)) == true) goto L71;
        char r102 = r110.charAt(r101);
        if (r102 != '/') goto L19;
        MultiTypePanelTrigger r103 = MultiTypePanelTrigger.SLASH;
        if (this.f298657y == true) goto L26;
    L20:
        r103 = null;
    L26:
        if (r103 == null) goto L70;
        boolean r104 = false;
        if (r101 <= 0) goto L55;
        char r105 = r110.charAt(r101 - 1);
        if ('A' <= r105) goto L32;
    L34:
        boolean r106 = false;
    L35:
        if (r106 == false) goto L37;
    L52:
        boolean r107 = true;
    L53:
        if (r107 == false) goto L55;
    L37:
        if ('a' <= r105) goto L39;
    L41:
        boolean r108 = false;
    L42:
        if (r108 == true) goto L52;
        if ('0' <= r105) goto L46;
    L48:
        boolean r109 = false;
    L49:
        if (r109 == true) goto L52;
        r107 = false;
        goto L53
    L46:
        if (r105 >= ':') goto L48;
        r109 = true;
        goto L49
    L39:
        if (r105 >= '{') goto L41;
        r108 = true;
        goto L42
    L32:
        if (r105 >= '[') goto L34;
        r106 = true;
    L55:
        Object[] r111 = r110.getSpans(0, r110.length(), l0.class);
        int r112 = r111.length;
        int r113 = 0;
    L56:
        if (r113 >= r112) goto L66;
        l0 r114 = (l0) r111[r113];
        if (r110.getSpanStart(r114) <= r101) goto L60;
    L62:
        boolean r115 = false;
    L63:
        if (r115 == true) goto L64;
        r113 = r113 + 1;
        goto L56
    L64:
        r104 = true;
        goto L66
    L60:
        if (r110.getSpanEnd(r114) < r100) goto L62;
        r115 = true;
    L66:
        if (r104 == false) goto L69;
        return null;
    L69:
        return new k1(r101, r100, r110.subSequence(r101 + 1, r100).toString(), r103);
    L70:
        r101 = r101 - 1;
        goto L13
    L19:
        if (r102 != '@') goto L20;
        r103 = MultiTypePanelTrigger.MENTION;
        if (this.f298658z == false) goto L20;
        goto L20
    }

    public final void k(MultiTypePanelTrigger r100) {
        o(false);
        this.G = null;
        this.H = null;
        this.I = null;
        this.M = false;
        e(r100);
        p(false);
    }

    public final boolean n(boolean r110) {
        FLogger r100 = FLogger.f375446a;
        r100.i("MultiTypeMentionPanelController", "[openSkillPanel] begin, available=" + this.A + ", useActionBarPresetMaxHeight=" + r110 + ", editVisibility=" + this.T.getVisibility() + ", editShown=" + this.T.isShown() + ", editAttached=" + this.T.isAttachedToWindow() + ", editEnabled=" + this.T.isEnabled() + ", editFocused=" + this.T.isFocused() + ", containerVisibility=" + this.f298633b.getVisibility() + ", containerShown=" + this.f298633b.isShown() + ", containerAttached=" + this.f298633b.isAttachedToWindow() + ", containerSize=" + this.f298633b.getWidth() + Permission.EXECUTE + this.f298633b.getHeight());
        if (this.A == true) goto L6;
        r100.i("MultiTypeMentionPanelController", "[openSkillPanel] rejected, reason=skillPanelUnavailable");
        return false;
    L6:
        Editable r101 = this.T.getText();
        int r102 = this.T.getSelectionStart();
        int r103 = this.T.getSelectionEnd();
        StringBuilder r111 = new StringBuilder("[openSkillPanel] input ready, textLength=");
        if (r101 == null) goto L9;
        int r112 = r101.length();
    L10:
        r111.append(r112);
        r111.append(", selection=");
        r111.append(r102);
        r111.append(DownloadConstants.VULNERABILITY_PATH);
        r111.append(r103);
        r100.i("MultiTypeMentionPanelController", r111.toString());
        if (r102 < 0) goto L50;
        if (r102 != r103) goto L50;
        k1 r104 = j(r101);
        if (r104 != null) goto L17;
    L22:
        r104 = null;
    L23:
        if (r104 != null) goto L26;
        r104 = new k1(r102, r102, "", MultiTypePanelTrigger.EXTERNAL_SKILL);
    L26:
        if (this.H != null) goto L35;
        if (r110 == true) goto L29;
    L33:
        boolean r113 = false;
    L34:
        o(r113);
        goto L35
    L29:
        if (r104.f298768d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L33;
        if (this.f298645m.invoke().booleanValue() == false) goto L33;
        r113 = true;
    L35:
        this.G = r104;
        Integer r114 = Integer.valueOf(r104.f298765a);
        r114.intValue();
        if (r104.f298768d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L38;
        boolean r105 = true;
    L39:
        if (r105 == true) goto L42;
        r114 = null;
    L42:
        this.H = r114;
        this.I = null;
        this.M = false;
        SlashPanelController r115 = i();
        MentionPanelController r106 = this.Y;
        if (r106 == null) goto L45;
        r106.i();
    L45:
        ProjectPanelController r107 = this.f298632a0;
        if (r107 == null) goto L48;
        r107.b();
    L48:
        a(r104.f298768d);
        Intrinsics.checkNotNullParameter(r104, "queryRange");
        r115.l(r104);
        r100.i("MultiTypeMentionPanelController", "[openSkillPanel] end, trigger=" + r104.f298768d + ", taskSkillPanelVisible=" + this.K + ", containerVisibility=" + this.f298633b.getVisibility() + ", containerShown=" + this.f298633b.isShown() + ", containerSize=" + this.f298633b.getWidth() + Permission.EXECUTE + this.f298633b.getHeight());
        return true;
    L38:
        r105 = false;
        goto L39
    L17:
        if (r104.f298768d != MultiTypePanelTrigger.SLASH) goto L19;
        boolean r116 = true;
    L20:
        if (r116 == false) goto L22;
    L19:
        r116 = false;
    L50:
        r100.i("MultiTypeMentionPanelController", "[openSkillPanel] rejected, reason=invalidSelection");
        return false;
    L9:
        r112 = 0;
        goto L10
    }

    public final void o(boolean r100) {
        if (this.N != r100) goto L5;
        return;
    L5:
        this.N = r100;
        this.f298651s.invoke(Boolean.valueOf(r100));
    }

    public final void p(boolean r110) {
        FLogger r100 = FLogger.f375446a;
        r100.i("MultiTypeMentionPanelController", "[setPanelVisible] request=" + r110 + ", current=" + this.K + ", containerVisibility=" + this.f298633b.getVisibility() + ", containerShown=" + this.f298633b.isShown() + ", containerAttached=" + this.f298633b.isAttachedToWindow() + ", containerSize=" + this.f298633b.getWidth() + Permission.EXECUTE + this.f298633b.getHeight());
        int r101 = 0;
        if (r110 == true) goto L11;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r102 = this.V;
        if (r102 == null) goto L7;
        r102.f298957d.i(false);
    L7:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r103 = this.W;
        if (r103 == null) goto L11;
        r103.f299230e.i(false);
    L11:
        if (this.K == r110) goto L13;
        this.K = r110;
        this.f298650r.invoke(Boolean.valueOf(r110));
    L13:
        ConstraintLayout r104 = this.f298636d.h();
        if (r104 == null) goto L27;
        if (r110 == true) goto L18;
        Integer r105 = this.L;
        if (r105 == null) goto L27;
        int r106 = r105.intValue();
        this.L = null;
        if (r104.getPaddingTop() != 0) goto L27;
        r104.setPadding(r104.getPaddingLeft(), r106, r104.getPaddingRight(), r104.getPaddingBottom());
        goto L27
    L18:
        if (this.L != null) goto L27;
        this.L = Integer.valueOf(r104.getPaddingTop());
        r104.setPadding(r104.getPaddingLeft(), 0, r104.getPaddingRight(), r104.getPaddingBottom());
    L27:
        if (this.f298633b.getVisibility() != 0) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == r110) goto L36;
        ViewGroup r108 = this.f298633b;
        if (r110 == true) goto L35;
        r101 = 8;
    L35:
        r108.setVisibility(r101);
        this.f298649q.invoke(Boolean.valueOf(r110));
    L36:
        r100.i("MultiTypeMentionPanelController", "[setPanelVisible] applied=" + r110 + ", taskSkillPanelVisible=" + this.K + ", containerVisibility=" + this.f298633b.getVisibility() + ", containerShown=" + this.f298633b.isShown() + ", containerSize=" + this.f298633b.getWidth() + Permission.EXECUTE + this.f298633b.getHeight());
        if (r110 == false) goto L40;
        this.f298633b.post(new q0(this));
        return;
    L40:
        return;
    L29:
        r107 = false;
        goto L30
    }

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
    public final void r(List<d0> r110) {
        this.P = r110;
        ChatInputWithMentionDelegate r100 = this.f298631a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "references");
        List<d0> r101 = r100.f298622k;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L17;
        Object r105 = r103.next();
        d0 r106 = (d0) r105;
        if (r110.isEmpty() == true) goto L14;
        Iterator<T> r107 = r110.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        if (ChatInputWithMentionDelegate.k(r106, (d0) r107.next()) == false) goto L10;
    L15:
        if (r104 == false) goto L3;
        r102.add(r105);
    L14:
        r104 = true;
        goto L15
    L17:
        r100.f298622k = r110;
        Editable r108 = r100.f298616e.getEditableText();
        if (r108 == null) goto L64;
        Object[] r109 = r108.getSpans(0, r108.length(), l0.class);
        ArrayList r111 = new ArrayList();
        int r112 = r109.length;
        int r113 = 0;
    L21:
        if (r113 >= r112) goto L29;
        Object r114 = r109[r113];
        if (((l0) r114).f298770a.getType() != InputReferenceType.ATTACHMENT) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L28;
        r111.add(r114);
    L28:
        r113 = r113 + 1;
        goto L21
    L25:
        r115 = false;
        goto L26
    L29:
        Iterator r116 = CollectionsKt.sortedWith(r111, new z(r108)).iterator();
    L31:
        if (r116.hasNext() == false) goto L64;
        l0 r117 = (l0) r116.next();
        d0 r118 = r117.f298770a;
        int r119 = r108.getSpanStart(r117);
        int r120 = r108.getSpanEnd(r117);
        if (r119 < 0) goto L31;
        if (r120 <= r119) goto L31;
        if (r102.isEmpty() == true) goto L45;
        Iterator r121 = r102.iterator();
    L41:
        if (r121.hasNext() == false) goto L45;
        if (ChatInputWithMentionDelegate.k(r118, (d0) r121.next()) == false) goto L41;
        boolean r122 = true;
    L46:
        if (r122 == true) goto L48;
        d0 r123 = r100.m(r118);
        if (Intrinsics.areEqual(r123, r118) == true) goto L31;
        r108.removeSpan(r117);
        Object[] r124 = r108.getSpans(r119, r120, j0.class);
        int r125 = r124.length;
        int r126 = 0;
    L61:
        if (r126 >= r125) goto L63;
        r108.removeSpan(r124[r126]);
        r126 = r126 + 1;
        goto L61
    L63:
        r100.e(r108, r123, r119, r120);
        goto L31
    L48:
        if (r120 < r108.length()) goto L50;
    L52:
        r100.f298620i = true;
        r108.delete(r119, r120);     // Catch: Throwable -> L55
        r100.f298620i = false;
        r100.f298621j = CollectionsKt.emptyList();
    L55:
        th = move-exception;
        r100.f298620i = false;
        r100.f298621j = CollectionsKt.emptyList();
        throw th;
    L50:
        if (r108.charAt(r120) != ' ') goto L52;
        r120 = r120 + 1;
    L45:
        r122 = false;
    L64:
        MentionPanelController r127 = this.Y;
        if (r127 == null) goto L99;
        Intrinsics.checkNotNullParameter(r110, "references");
        r127.f298791o = r110;
        k1 r128 = r127.f298790n;
        if (r128 == null) goto L100;
        r127.p(r128);
        return;
    L100:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24, types: [android.view.View$OnLayoutChangeListener, com.larus.bmhome.chat.component.bottom.core.inputtext.e1] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.f1] */
    public MultiTypeMentionPanelController(ChatInputWithMentionDelegate r110, ViewGroup r111, y8 r112, va8.c r210, Function0 r211, CoroutineScope r212, qp8.e r213, Fragment r214, Function0 r215, Function0 r216, i r217, j r218, k r219, l r310, Function0 r311, Function1 r312, Function1 r313, Function1 r314, Function1 r315, m r316, boolean r317, boolean r318, boolean r319, List r410, List r411) {
        Intrinsics.checkNotNullParameter(r110, "inputDelegate");
        Intrinsics.checkNotNullParameter(r111, "panelContainer");
        Intrinsics.checkNotNullParameter(r112, "dependency");
        Intrinsics.checkNotNullParameter(r210, "inputUiContract");
        Intrinsics.checkNotNullParameter(r211, "panelTopAnchorYProvider");
        Intrinsics.checkNotNullParameter(r212, "coroutineScope");
        Intrinsics.checkNotNullParameter(r213, "officeMentionConfig");
        Intrinsics.checkNotNullParameter(r214, "hostFragment");
        Intrinsics.checkNotNullParameter(r215, "isInTaskMode");
        Intrinsics.checkNotNullParameter(r216, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r217, "isVoiceMode");
        Intrinsics.checkNotNullParameter(r218, "canCreateDocument");
        Intrinsics.checkNotNullParameter(r219, "shouldSelectSkillInActionBar");
        Intrinsics.checkNotNullParameter(r310, "shouldShowProjects");
        Intrinsics.checkNotNullParameter(r311, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r312, "onSelectFile");
        Intrinsics.checkNotNullParameter(r313, "onPanelVisibleChanged");
        Intrinsics.checkNotNullParameter(r314, "onTaskSkillPanelVisibleChanged");
        Intrinsics.checkNotNullParameter(r315, "onSkillSearchModeChanged");
        Intrinsics.checkNotNullParameter(r316, "onSkillSearchFinished");
        this.f298631a = r110;
        this.f298633b = r111;
        this.f298635c = r112;
        this.f298636d = r210;
        this.f298637e = r211;
        this.f298638f = r212;
        this.f298639g = r213;
        this.f298640h = r214;
        this.f298641i = r215;
        this.f298642j = r216;
        this.f298643k = r217;
        this.f298644l = r218;
        this.f298645m = r219;
        this.f298646n = r310;
        this.f298647o = r311;
        this.f298648p = r312;
        this.f298649q = r313;
        this.f298650r = r314;
        this.f298651s = r315;
        this.f298652t = r316;
        this.f298653u = r317;
        this.f298654v = r318;
        SlashPanelContent.Companion.getClass();
        if (r410 != null) goto L5;
        List r100 = SlashMentionConfig.DEFAULT_SLASH_CONTENTS;
    L6:
        EnumEntries<SlashPanelContent> r101 = SlashPanelContent.getEntries();
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator<SlashPanelContent> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        SlashPanelContent r104 = r103.next();
        if (r100.contains(r104.getConfigValue()) == false) goto L8;
        r102.add(r104);
        goto L8
    L12:
        this.f298655w = r102;
        MentionPanelContent.Companion.getClass();
        if (r411 != null) goto L15;
        List r105 = SlashMentionConfig.DEFAULT_MENTION_CONTENTS;
    L16:
        EnumEntries<MentionPanelContent> r106 = MentionPanelContent.getEntries();
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<MentionPanelContent> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L22;
        MentionPanelContent r109 = r108.next();
        if (r105.contains(r109.getConfigValue()) == false) goto L18;
        r107.add(r109);
        goto L18
    L22:
        this.f298656x = r107;
        boolean r113 = this.f298640h instanceof xe8.a;
        boolean r114 = false;
        if (r113 == true) goto L25;
    L30:
        boolean r115 = false;
    L31:
        this.f298657y = r115;
        if (r113 == true) goto L34;
    L39:
        boolean r116 = false;
    L40:
        this.f298658z = r116;
        if (r115 == true) goto L43;
    L45:
        boolean r117 = false;
    L46:
        this.A = r117;
        if (r115 == true) goto L49;
    L51:
        this.B = r114;
        this.C = new SkillSearchIndex();
        this.D = this.f298641i.invoke().booleanValue();
        this.F = new h1(this);
        ?? r118 = new e1(this);
        this.O = r118;
        this.P = CollectionsKt.emptyList();
        LarkSocialExp.f365340a.getClass();
        m2 r119 = (m2) LarkSocialExp.f365344e.getValue();
        this.S = TuplesKt.to(Boolean.valueOf(r119.f486674c), Boolean.valueOf(r119.f486675d));
        EditText r120 = this.f298631a.f298729a;
        this.T = r120;
        this.U = new b0(r120, new f1(this));
        this.f298633b.removeAllViews();
        this.f298633b.setOutlineProvider(new g1());
        this.f298633b.setClipToOutline(true);
        this.f298633b.addOnLayoutChangeListener(r118);
        ViewExtKt.n(this.f298633b, null, null, new r0(this), 3);
        i1 r121 = new i1(this);
        this.f298634b0 = r121;
        r120.addTextChangedListener(r121);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r122 = this.f298635c.f70();
        if (r122 == null) goto L60;
        kotlinx.coroutines.flow.b1 r123 = r122.YB();
        if (r123 == null) goto L60;
        Iterable r124 = (Iterable) r123.getValue();
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r126 = r124.iterator();
    L57:
        if (r126.hasNext() == false) goto L59;
        r125.add(k0.d((id8.f) r126.next()));
        goto L57
    L59:
        r(r125);
        this.Q = BuildersKt.launch$default(this.f298638f, null, null, new MultiTypeMentionPanelController$observeAttachmentReferences$2(r123, this, null), 3, null);
    L60:
        AccountService.f365697a.E(this.F);
        this.R = BuildersKt.launch$default(this.f298638f, Dispatchers.getMain().getImmediate(), null, new AnonymousClass3(this, null), 2, null);
        return;
    L49:
        if (this.f298655w.contains(SlashPanelContent.PROJECT) == false) goto L51;
        r114 = true;
        goto L51
    L43:
        if (this.f298655w.contains(SlashPanelContent.SKILL) == false) goto L45;
        r117 = true;
        goto L46
    L34:
        if (this.f298654v == false) goto L39;
        if ((!r107.isEmpty()) == false) goto L39;
        if (r319 == true) goto L39;
        r116 = true;
        goto L40
    L25:
        if (this.f298653u == false) goto L30;
        if ((!this.f298655w.isEmpty()) == false) goto L30;
        if (r319 == true) goto L30;
        r115 = true;
        goto L31
    L15:
        r105 = r411;
        goto L16
    L5:
        r100 = r410;
        goto L6
    }
}

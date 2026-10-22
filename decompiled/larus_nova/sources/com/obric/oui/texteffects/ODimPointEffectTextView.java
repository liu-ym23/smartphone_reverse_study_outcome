package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.TextSource;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import qma.k;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u001f !\"B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tR\u001a\u0010\u0011\u001a\u00020\f8\u0014X\u0094D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00068\u0014X\u0094D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "mode", "", "setDimPointMode", "", "scale", "setDebugAnimationDurationScale", "", "text", "setTextWithEffect", "", "w", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "x", FaceService.girlLabel, "getMaxBlurRadiusDp", "()F", "maxBlurRadiusDp", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DimPointMode", "PendingTextType", "RewritePhase", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DimPointMode f403251r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PendingTextType f403252s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f403253t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RewritePhase f403254u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f403255v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f403256w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f403257x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "", UserProfileEvent.POSITION_NONE, "PENDING", "PROMPT_EXIT_TO_GENERATE", "PROMPT_SWITCH", "GENERATE", "REWRITE", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum DimPointMode extends Enum<DimPointMode> {
        public static final DimPointMode GENERATE = null;
        public static final DimPointMode NONE = null;
        public static final DimPointMode PENDING = null;
        public static final DimPointMode PROMPT_EXIT_TO_GENERATE = null;
        public static final DimPointMode PROMPT_SWITCH = null;
        public static final DimPointMode REWRITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DimPointMode[] f403258a = null;

        public static DimPointMode valueOf(String r100) {
            return (DimPointMode) r27.a.a(DimPointMode.class, r100);
        }

        public static DimPointMode[] values() {
            return (DimPointMode[]) f403258a.clone();
        }

        static {
            DimPointMode r100 = new DimPointMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            DimPointMode r101 = new DimPointMode("PENDING", 1);
            PENDING = r101;
            DimPointMode r102 = new DimPointMode("PROMPT_EXIT_TO_GENERATE", 2);
            PROMPT_EXIT_TO_GENERATE = r102;
            DimPointMode r103 = new DimPointMode("PROMPT_SWITCH", 3);
            PROMPT_SWITCH = r103;
            DimPointMode r104 = new DimPointMode("GENERATE", 4);
            GENERATE = r104;
            DimPointMode r105 = new DimPointMode("REWRITE", 5);
            REWRITE = r105;
            f403258a = new DimPointMode[]{r100, r101, r102, r103, r104, r105};
        }

        public DimPointMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "", "CONTENT", "PROMPT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum PendingTextType extends Enum<PendingTextType> {
        public static final PendingTextType CONTENT = null;
        public static final PendingTextType PROMPT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PendingTextType[] f403259a = null;

        public static PendingTextType valueOf(String r100) {
            return (PendingTextType) r27.a.a(PendingTextType.class, r100);
        }

        public static PendingTextType[] values() {
            return (PendingTextType[]) f403259a.clone();
        }

        static {
            PendingTextType r100 = new PendingTextType("CONTENT", 0);
            CONTENT = r100;
            PendingTextType r101 = new PendingTextType("PROMPT", 1);
            PROMPT = r101;
            f403259a = new PendingTextType[]{r100, r101};
        }

        public PendingTextType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "", UserProfileEvent.POSITION_NONE, "EXITING_OLD_TEXT", "ENTERING_NEW_TEXT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum RewritePhase extends Enum<RewritePhase> {
        public static final RewritePhase ENTERING_NEW_TEXT = null;
        public static final RewritePhase EXITING_OLD_TEXT = null;
        public static final RewritePhase NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RewritePhase[] f403260a = null;

        public static RewritePhase valueOf(String r100) {
            return (RewritePhase) r27.a.a(RewritePhase.class, r100);
        }

        public static RewritePhase[] values() {
            return (RewritePhase[]) f403260a.clone();
        }

        static {
            RewritePhase r100 = new RewritePhase(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            RewritePhase r101 = new RewritePhase("EXITING_OLD_TEXT", 1);
            EXITING_OLD_TEXT = r101;
            RewritePhase r102 = new RewritePhase("ENTERING_NEW_TEXT", 2);
            ENTERING_NEW_TEXT = r102;
            f403260a = new RewritePhase[]{r100, r101, r102};
        }

        public RewritePhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403261a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f403262b = null;

        static {
            int[] r100 = new int[DimPointMode.values().length];
            r100[DimPointMode.PENDING.ordinal()] = 1;
            r100[DimPointMode.GENERATE.ordinal()] = 2;
            r100[DimPointMode.REWRITE.ordinal()] = 3;
            r100[DimPointMode.PROMPT_EXIT_TO_GENERATE.ordinal()] = 4;
            r100[DimPointMode.PROMPT_SWITCH.ordinal()] = 5;
            r100[DimPointMode.NONE.ordinal()] = 6;
            f403261a = r100;
            int[] r101 = new int[RewritePhase.values().length];
            r101[RewritePhase.EXITING_OLD_TEXT.ordinal()] = 1;
            r101[RewritePhase.ENTERING_NEW_TEXT.ordinal()] = 2;
            r101[RewritePhase.NONE.ordinal()] = 3;
            f403262b = r101;
        }
    }

    static {
    }

    public ODimPointEffectTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ODimPointEffectTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void q() {
        DimPointMode r100 = this.f403251r;
        this.f403251r = DimPointMode.NONE;
        this.f403254u = RewritePhase.NONE;
        if (r100 != DimPointMode.PROMPT_EXIT_TO_GENERATE) goto L8;
        CharSequence r101 = this.f403253t;
        this.f403253t = null;
        this.f403252s = PendingTextType.CONTENT;
        if (r101 == null) goto L18;
        w(r101);
        return;
    L18:
        return;
    L8:
        if (r100 != DimPointMode.PROMPT_SWITCH) goto L11;
        this.f403252s = PendingTextType.PROMPT;
        return;
    L11:
        if (r100 != DimPointMode.REWRITE) goto L21;
        CharSequence r102 = this.f403255v;
        this.f403255v = null;
        if (r102 != null) goto L15;
        return;
    L15:
        if (TextUtils.equals(getText(), r102) == true) goto L23;
        y(r102);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void s() {
        this.f403251r = DimPointMode.NONE;
        this.f403254u = RewritePhase.NONE;
    }

    public final boolean v() {
        if (this.f403251r == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.f403252s != PendingTextType.PROMPT) goto L7;
        return true;
    }

    public final void z() {
        if (this.f403251r == DimPointMode.REWRITE) goto L5;
        RewritePhase r100 = RewritePhase.NONE;
    L9:
        this.f403254u = r100;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r100 = RewritePhase.EXITING_OLD_TEXT;
        goto L9
    L7:
        r100 = RewritePhase.ENTERING_NEW_TEXT;
        goto L9
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void u() {
        super.u();
        this.f403251r = DimPointMode.NONE;
        this.f403252s = PendingTextType.CONTENT;
        this.f403253t = null;
        this.f403254u = RewritePhase.NONE;
        this.f403255v = null;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public String getLogTag() {
        return this.f403256w;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public float getMaxBlurRadiusDp() {
        return this.f403257x;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final sma.c d(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = sma.d.f542607a;
        return sma.d.a(r100, getPaint(), e(), getEllipsize(), new ODimPointEffectTextView$buildTextCache$1(this), new ODimPointEffectTextView$buildTextCache$2(this));
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r100) {
        float r101 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r100);
        if (r101 != getDebugAnimationDurationScale()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (this.f403251r != DimPointMode.PENDING) goto L12;
        OProtocolTextEffectTextView.t(this, rma.a.f538614a.i(), AiBotPollingAuthResult.STATUS_PENDING, true, null, null, null, 56);
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setDimPointMode(DimPointMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (this.f403251r != r100) goto L5;
        return;
    L5:
        u();
        int r101 = b.f403261a[r100.ordinal()];
        if (r101 != 1) goto L8;
        this.f403252s = PendingTextType.CONTENT;
        OProtocolTextEffectTextView.t(this, rma.a.f538614a.i(), AiBotPollingAuthResult.STATUS_PENDING, false, null, null, null, 60);
        return;
    L8:
        if (r101 != 2) goto L14;
        w(null);
        return;
    }

    public final void setTextWithEffect(CharSequence r100) {
        CharSequence r101 = getText();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        boolean r102 = true;
        if (v() == false) goto L16;
        if (r100.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        x(r100);
        return;
    L12:
        r103 = false;
    L16:
        if (TextUtils.equals(r101, r100) == false) goto L24;
        if (r101.length() == 0) goto L21;
        r102 = false;
    L21:
        if (r102 == false) goto L32;
        u();
        setText(r100);
        return;
    L32:
        return;
    L24:
        if (r101.length() == 0) goto L27;
        r102 = false;
    L27:
        if (r102 == false) goto L29;
        w(r100);
        return;
    L29:
        y(r100);
    }

    public final void w(CharSequence r110) {
        if (r110 == null) goto L4;
        setText(r110);
    L4:
        this.f403252s = PendingTextType.CONTENT;
        this.f403253t = null;
        OProtocolTextEffectTextView.t(this, rma.a.f538614a.d(false), "generate", false, getText(), null, null, 52);
    }

    public final void x(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "actualText");
        if (v() == true) goto L6;
        w(r110);
        return;
    L6:
        this.f403253t = r110;
        rma.a r111 = rma.a.f538614a;
        OProtocolTextEffectTextView.t(this, new k("oui.dim_point.prompt_pending_exit", 150, null, CollectionsKt.listOf(new qma.c("prompt_pending_exit", 150, CollectionsKt.listOf(rma.a.a("prompt_text_exit", TextSource.Current, CollectionsKt.listOf(rma.a.c(EffectProperty.Alpha, rma.a.f538616c, new Pair[]{TuplesKt.to(0L, Float.valueOf(1.0f)), TuplesKt.to(150L, Float.valueOf(0.0f))})))))), 10), "prompt_exit_to_generate", false, "", null, null, 52);
    }

    public final void y(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "newText");
        if (this.f403251r != DimPointMode.REWRITE) goto L12;
        int r100 = b.f403262b[this.f403254u.ordinal()];
        if (r100 != 1) goto L7;
        setText(r110);
        CharSequence r101 = this.f403283g;
        this.f403282f = r110;
        this.f403283g = r101;
        this.f403284h = r110;
        this.f403286j = null;
        this.f403287k = null;
        invalidate();
        return;
    L7:
        if (r100 != 2) goto L50;
        this.f403255v = r110;
        return;
    L50:
        return;
    L12:
        CharSequence r102 = getText();
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        CharSequence r103 = r102;
        float r104 = 0.0f;
        if (this.f403251r == DimPointMode.PENDING) goto L18;
    L44:
        this.f403252s = PendingTextType.CONTENT;
        this.f403253t = null;
        this.f403255v = null;
        setText(r110);
        OProtocolTextEffectTextView.t(this, rma.a.f538614a.j(false, r104), "rewrite", false, r110, r103, r110, 4);
        return;
    L18:
        if (this.f403252s != PendingTextType.CONTENT) goto L44;
        k r105 = this.f403279c;
        if (r105 != null) goto L23;
        com.obric.oui.texteffects.runtime.e r106 = null;
    L24:
        if (r106 == null) goto L44;
        List<com.obric.oui.texteffects.runtime.d> r107 = r106.f403339c;
        if (r107 == null) goto L44;
        Iterator<T> r108 = r107.iterator();
    L31:
        if (r108.hasNext() == false) goto L35;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((com.obric.oui.texteffects.runtime.d) r109).f403324b, "gradient_overlay") == false) goto L31;
    L36:
        com.obric.oui.texteffects.runtime.d r111 = (com.obric.oui.texteffects.runtime.d) r109;
        if (r111 == null) goto L44;
        if (Float.isNaN(r111.f403327e) == false) goto L42;
        float r112 = 0.0f;
    L43:
        r104 = RangesKt.coerceIn(r112, 0.0f, 0.8f);
        goto L44
    L42:
        r112 = r111.f403327e;
        goto L43
    L35:
        r109 = null;
        goto L36
    L23:
        LruCache<qma.a.b, PathInterpolator> r113 = com.obric.oui.texteffects.runtime.f.f403340a;
        r106 = com.obric.oui.texteffects.runtime.f.e(r105, this.f403281e);
        goto L24
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final LinearGradient c(sma.c r100, qma.e.a r110) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r110, LynxVideoManagerLite.FILL);
        float r101 = r100.f542604h;
        if (r101 > 0.01f) goto L6;
        return null;
    L6:
        float r102 = r100.f542605i;
        return new LinearGradient(r102, 0.0f, r102 + r101, 0.0f, r110.f533954a, r110.f533955b, Shader.TileMode.CLAMP);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void p(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        Intrinsics.checkNotNullParameter(r101, "spec");
        z();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void r(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        Intrinsics.checkNotNullParameter(r101, "spec");
        switch(r100.hashCode()) {
            case -1253981585: goto L22;
            case -682587753: goto L18;
            case -208065901: goto L14;
            case 1101148556: goto L10;
            case 1810371957: goto L6;
            default: goto L25;
        };
    L25:
        DimPointMode r102 = DimPointMode.NONE;
    L26:
        this.f403251r = r102;
        z();
        return;
    L6:
        if (r100.equals("generate") == false) goto L25;
        r102 = DimPointMode.GENERATE;
        goto L26
    L10:
        if (r100.equals("rewrite") == false) goto L25;
        r102 = DimPointMode.REWRITE;
        goto L26
    L14:
        if (r100.equals("prompt_exit_to_generate") == false) goto L25;
        r102 = DimPointMode.PROMPT_EXIT_TO_GENERATE;
        goto L26
    L18:
        if (r100.equals(AiBotPollingAuthResult.STATUS_PENDING) == false) goto L25;
        r102 = DimPointMode.PENDING;
        goto L26
    L22:
        if (r100.equals("prompt_switch") == false) goto L25;
        r102 = DimPointMode.PROMPT_SWITCH;
        goto L26
    }

    public ODimPointEffectTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403251r = DimPointMode.NONE;
        this.f403252s = PendingTextType.CONTENT;
        this.f403254u = RewritePhase.NONE;
        this.f403256w = "DimPointTextView";
        this.f403257x = 16.0f;
    }

    public /* synthetic */ ODimPointEffectTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

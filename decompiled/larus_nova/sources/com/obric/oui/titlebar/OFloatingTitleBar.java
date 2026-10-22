package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.color.h0;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.obric.oui.titlebar.floating.o;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\bhiNjklmnB'\b\u0007\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020\u0006¢\u0006\u0004\bf\u0010gJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b!\u0010\u0017J\u0017\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0004\b$\u0010\u0017J\u000e\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0010\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\u000e\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0006J\u0010\u00106\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\u000e\u00106\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0006J\u0010\u00108\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\u000e\u00108\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006J\u000e\u00109\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0006J\u0010\u0010:\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\u000e\u0010;\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006J\u000e\u0010<\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0006J\u0010\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u00020=H\u0007J\u000e\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020@J\u000e\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020\rJ\u0010\u0010F\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010EJ\u0010\u0010H\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010GJ\u0017\u0010K\u001a\u00020\b2\u0006\u0010I\u001a\u00020\rH\u0000¢\u0006\u0004\bJ\u0010\u0017J\u0012\u0010L\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020M8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\"\u0010\\\u001a\u00020M8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bY\u0010O\u001a\u0004\bZ\u0010Q\"\u0004\b[\u0010SR\"\u0010`\u001a\u00020M8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010S¨\u0006o"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/g;", "Lcom/obric/oui/material/b;", "Landroid/view/View;", "getDefaultTargetView", "", "width", "", "setFreezeEndAreaWidth", "(Ljava/lang/Integer;)V", "getEndAreaWidthForCenter", "getSubEndToEndGap", "", "visible", "setSubEndToEndGapVisible", "getCenterTitleGap", "type", "setTitleType", "view", "setCenterCustomView", "keep", "setKeepActionInteractiveWhenHidden$OUI_standardRelease", "(Z)V", "setKeepActionInteractiveWhenHidden", "Lkotlin/Function0;", "callback", "setActionChangeInterruptCallback$OUI_standardRelease", "(Lkotlin/jvm/functions/Function0;)V", "setActionChangeInterruptCallback", "listener", "setFloatingTransitionDrawUpdateListener$OUI_standardRelease", "setFloatingTransitionDrawUpdateListener", "setNonActionContentVisible$OUI_standardRelease", "setNonActionContentVisible", "clickable", "setTitleBarContainerClickable$OUI_standardRelease", "setTitleBarContainerClickable", "styleRes", "setStartButtonGroupStyle", "setCenterButtonGroupStyle", "setSubEndButtonGroupStyle", "setEndButtonGroupStyle", "Lcom/obric/oui/text/OTextView;", "getStartTitleView", "getStartSubtitleView", "getCenterTitleView", "getCenterSubtitleView", "", "text", "setStartTitle", "resId", "color", "setStartTitleColor", "setStartSubtitle", "setStartSubTitleColor", "setCenterTitle", "setCenterTitleColor", "setCenterSubtitle", "setCenterSubTitle", "setCenterSubTitleColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "", "radius", "setMaskBlurRadius", "enabled", "setFloatingTransitionEnabled", "Lcom/obric/oui/titlebar/OFloatingTitleBar$d;", "setTitleBarTransitionEndListener", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$c;", "setFloatingTransitionEndListener", "active", "setFloatingTransitionOwnerActive$OUI_standardRelease", "setFloatingTransitionOwnerActive", "setBackdropTarget", "Lcom/obric/oui/button/OButtonGroup;", "b", "Lcom/obric/oui/button/OButtonGroup;", "getStartButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "setStartButtonGroup", "(Lcom/obric/oui/button/OButtonGroup;)V", "startButtonGroup", ce.f26391f, "getCenterButtonGroup", "setCenterButtonGroup", "centerButtonGroup", "m", "getEndSubButtonGroup", "setEndSubButtonGroup", "endSubButtonGroup", OfficeSDKRequestTag.KEY_NEW_USER, "getEndButtonGroup", "setEndButtonGroup", "endButtonGroup", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CenterAvoidanceMode", "EndAreaActionState", "c", "EndAreaTransitionType", "d", "SubEndShiftEndRawAlphaBinding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFloatingTitleBar extends FrameLayout implements com.obric.oui.material.g, com.obric.oui.material.b {
    public static final Token$Bounce H0 = null;
    public static final Token$Duration L0 = null;
    public int A;
    public fja.d B;
    public fja.d C;
    public int D;
    public Integer E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f403400J;
    public boolean K;
    public FloatingTransitionBridge L;
    public boolean M;
    public Function0<Unit> N;
    public Function0<Unit> O;
    public final k.c P;
    public final Function1<? super Boolean, com.obric.oui.material.c> Q;
    public com.obric.oui.material.c R;
    public int S;
    public final cna.d T;
    public boolean U;
    public boolean V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f403401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButtonGroup f403402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f403403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OTextView f403404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OTextView f403405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f403406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OButtonGroup f403407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f403408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f403409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTextView f403410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OTextView f403411k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f403412k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f403413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OButtonGroup f403414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OButtonGroup f403415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f403416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f403417p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f403418p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f403419q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f403420r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f403421s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f403422t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f403423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f403424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f403425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f403426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f403427y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f403428z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$CenterAvoidanceMode;", "", UserProfileEvent.POSITION_NONE, "FREEZE", "TRANSITION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum CenterAvoidanceMode extends Enum<CenterAvoidanceMode> {
        public static final CenterAvoidanceMode FREEZE = null;
        public static final CenterAvoidanceMode NONE = null;
        public static final CenterAvoidanceMode TRANSITION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CenterAvoidanceMode[] f403429a = null;

        public static CenterAvoidanceMode valueOf(String r100) {
            return (CenterAvoidanceMode) r27.a.a(CenterAvoidanceMode.class, r100);
        }

        public static CenterAvoidanceMode[] values() {
            return (CenterAvoidanceMode[]) f403429a.clone();
        }

        static {
            CenterAvoidanceMode r100 = new CenterAvoidanceMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            CenterAvoidanceMode r101 = new CenterAvoidanceMode("FREEZE", 1);
            FREEZE = r101;
            CenterAvoidanceMode r102 = new CenterAvoidanceMode("TRANSITION", 2);
            TRANSITION = r102;
            f403429a = new CenterAvoidanceMode[]{r100, r101, r102};
        }

        public CenterAvoidanceMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;", "", "EMPTY", "SUB_ONLY", "END_ONLY", "BOTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum EndAreaActionState extends Enum<EndAreaActionState> {
        public static final EndAreaActionState BOTH = null;
        public static final EndAreaActionState EMPTY = null;
        public static final EndAreaActionState END_ONLY = null;
        public static final EndAreaActionState SUB_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EndAreaActionState[] f403430a = null;

        public static EndAreaActionState valueOf(String r100) {
            return (EndAreaActionState) r27.a.a(EndAreaActionState.class, r100);
        }

        public static EndAreaActionState[] values() {
            return (EndAreaActionState[]) f403430a.clone();
        }

        static {
            EndAreaActionState r100 = new EndAreaActionState("EMPTY", 0);
            EMPTY = r100;
            EndAreaActionState r101 = new EndAreaActionState("SUB_ONLY", 1);
            SUB_ONLY = r101;
            EndAreaActionState r102 = new EndAreaActionState("END_ONLY", 2);
            END_ONLY = r102;
            EndAreaActionState r103 = new EndAreaActionState("BOTH", 3);
            BOTH = r103;
            f403430a = new EndAreaActionState[]{r100, r101, r102, r103};
        }

        public EndAreaActionState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaTransitionType;", "", "NONE_OR_CONTENT_CHANGE", "SUB_ONLY_TO_BOTH", "BOTH_TO_SUB_ONLY", "SUB_ONLY_TO_END_ONLY", "END_ONLY_TO_SUB_ONLY", "INTERRUPTED_SHIFT_RETURN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum EndAreaTransitionType extends Enum<EndAreaTransitionType> {
        public static final EndAreaTransitionType BOTH_TO_SUB_ONLY = null;
        public static final EndAreaTransitionType END_ONLY_TO_SUB_ONLY = null;
        public static final EndAreaTransitionType INTERRUPTED_SHIFT_RETURN = null;
        public static final EndAreaTransitionType NONE_OR_CONTENT_CHANGE = null;
        public static final EndAreaTransitionType SUB_ONLY_TO_BOTH = null;
        public static final EndAreaTransitionType SUB_ONLY_TO_END_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EndAreaTransitionType[] f403431a = null;

        public static EndAreaTransitionType valueOf(String r100) {
            return (EndAreaTransitionType) r27.a.a(EndAreaTransitionType.class, r100);
        }

        public static EndAreaTransitionType[] values() {
            return (EndAreaTransitionType[]) f403431a.clone();
        }

        static {
            EndAreaTransitionType r100 = new EndAreaTransitionType("NONE_OR_CONTENT_CHANGE", 0);
            NONE_OR_CONTENT_CHANGE = r100;
            EndAreaTransitionType r101 = new EndAreaTransitionType("SUB_ONLY_TO_BOTH", 1);
            SUB_ONLY_TO_BOTH = r101;
            EndAreaTransitionType r102 = new EndAreaTransitionType("BOTH_TO_SUB_ONLY", 2);
            BOTH_TO_SUB_ONLY = r102;
            EndAreaTransitionType r103 = new EndAreaTransitionType("SUB_ONLY_TO_END_ONLY", 3);
            SUB_ONLY_TO_END_ONLY = r103;
            EndAreaTransitionType r104 = new EndAreaTransitionType("END_ONLY_TO_SUB_ONLY", 4);
            END_ONLY_TO_SUB_ONLY = r104;
            EndAreaTransitionType r105 = new EndAreaTransitionType("INTERRUPTED_SHIFT_RETURN", 5);
            INTERRUPTED_SHIFT_RETURN = r105;
            f403431a = new EndAreaTransitionType[]{r100, r101, r102, r103, r104, r105};
        }

        public EndAreaTransitionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$SubEndShiftEndRawAlphaBinding;", "", UserProfileEvent.POSITION_NONE, "APPEARING", "DISAPPEARING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum SubEndShiftEndRawAlphaBinding extends Enum<SubEndShiftEndRawAlphaBinding> {
        public static final SubEndShiftEndRawAlphaBinding APPEARING = null;
        public static final SubEndShiftEndRawAlphaBinding DISAPPEARING = null;
        public static final SubEndShiftEndRawAlphaBinding NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SubEndShiftEndRawAlphaBinding[] f403432a = null;

        public static SubEndShiftEndRawAlphaBinding valueOf(String r100) {
            return (SubEndShiftEndRawAlphaBinding) r27.a.a(SubEndShiftEndRawAlphaBinding.class, r100);
        }

        public static SubEndShiftEndRawAlphaBinding[] values() {
            return (SubEndShiftEndRawAlphaBinding[]) f403432a.clone();
        }

        static {
            SubEndShiftEndRawAlphaBinding r100 = new SubEndShiftEndRawAlphaBinding(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SubEndShiftEndRawAlphaBinding r101 = new SubEndShiftEndRawAlphaBinding("APPEARING", 1);
            APPEARING = r101;
            SubEndShiftEndRawAlphaBinding r102 = new SubEndShiftEndRawAlphaBinding("DISAPPEARING", 2);
            DISAPPEARING = r102;
            f403432a = new SubEndShiftEndRawAlphaBinding[]{r100, r101, r102};
        }

        public SubEndShiftEndRawAlphaBinding(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<View> f403433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<View> f403434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<View> f403435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<View> f403436d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f403433a, r101.f403433a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f403434b, r101.f403434b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403435c, r101.f403435c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f403436d, r101.f403436d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f403433a.hashCode() * 31) + this.f403434b.hashCode()) * 31) + this.f403435c.hashCode()) * 31) + this.f403436d.hashCode();
        }

        public final String toString() {
            return "ActionTargetViews(start=" + this.f403433a + ", center=" + this.f403434b + ", subEnd=" + this.f403435c + ", end=" + this.f403436d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends View> r100, List<? extends View> r101, List<? extends View> r102, List<? extends View> r103) {
            Intrinsics.checkNotNullParameter(r100, "start");
            Intrinsics.checkNotNullParameter(r101, "center");
            Intrinsics.checkNotNullParameter(r102, "subEnd");
            Intrinsics.checkNotNullParameter(r103, "end");
            this.f403433a = r100;
            this.f403434b = r101;
            this.f403435c = r102;
            this.f403436d = r103;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EndAreaActionState f403437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<View> f403438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<View> f403439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f403441e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f403442f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f403437a == r101.f403437a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f403438b, r101.f403438b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403439c, r101.f403439c) == true) goto L18;
            return false;
        L18:
            if (this.f403440d == r101.f403440d) goto L21;
            return false;
        L21:
            if (this.f403441e == r101.f403441e) goto L24;
            return false;
        L24:
            if (this.f403442f == r101.f403442f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f403437a.hashCode() * 31) + this.f403438b.hashCode()) * 31) + this.f403439c.hashCode()) * 31) + this.f403440d) * 31) + this.f403441e) * 31) + this.f403442f;
        }

        public final String toString() {
            return "EndAreaSnapshot(state=" + this.f403437a + ", subEndViews=" + this.f403438b + ", endViews=" + this.f403439c + ", width=" + this.f403440d + ", endWidth=" + this.f403441e + ", endContentWidth=" + this.f403442f + ')';
        }

        public final boolean a() {
            EndAreaActionState r100 = this.f403437a;
            if (r100 != EndAreaActionState.END_ONLY) goto L5;
        L8:
            return true;
        L5:
            if (r100 == EndAreaActionState.BOTH) goto L8;
            return false;
        }

        public final boolean b() {
            EndAreaActionState r100 = this.f403437a;
            if (r100 != EndAreaActionState.SUB_ONLY) goto L5;
        L8:
            return true;
        L5:
            if (r100 == EndAreaActionState.BOTH) goto L8;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(EndAreaActionState r100, List<? extends View> r101, List<? extends View> r102, int r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "state");
            Intrinsics.checkNotNullParameter(r101, "subEndViews");
            Intrinsics.checkNotNullParameter(r102, "endViews");
            this.f403437a = r100;
            this.f403438b = r101;
            this.f403439c = r102;
            this.f403440d = r103;
            this.f403441e = r104;
            this.f403442f = r105;
        }
    }

    public interface d {
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403443a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f403444b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f403445c = null;

        static {
            int[] r100 = new int[EndAreaTransitionType.values().length];
            r100[EndAreaTransitionType.SUB_ONLY_TO_BOTH.ordinal()] = 1;
            r100[EndAreaTransitionType.BOTH_TO_SUB_ONLY.ordinal()] = 2;
            r100[EndAreaTransitionType.SUB_ONLY_TO_END_ONLY.ordinal()] = 3;
            r100[EndAreaTransitionType.END_ONLY_TO_SUB_ONLY.ordinal()] = 4;
            r100[EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN.ordinal()] = 5;
            r100[EndAreaTransitionType.NONE_OR_CONTENT_CHANGE.ordinal()] = 6;
            f403443a = r100;
            int[] r101 = new int[SubEndShiftEndRawAlphaBinding.values().length];
            r101[SubEndShiftEndRawAlphaBinding.APPEARING.ordinal()] = 1;
            r101[SubEndShiftEndRawAlphaBinding.DISAPPEARING.ordinal()] = 2;
            r101[SubEndShiftEndRawAlphaBinding.NONE.ordinal()] = 3;
            f403444b = r101;
            int[] r102 = new int[CenterAvoidanceMode.values().length];
            r102[CenterAvoidanceMode.NONE.ordinal()] = 1;
            r102[CenterAvoidanceMode.FREEZE.ordinal()] = 2;
            r102[CenterAvoidanceMode.TRANSITION.ordinal()] = 3;
            f403445c = r102;
        }
    }

    public OFloatingTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OFloatingTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void c(OFloatingTitleBar r100) {
        m8594setFloatingTransitionOwnerActive$lambda59(r100);
    }

    public static /* synthetic */ void d(OFloatingTitleBar r100) {
        m8593setFloatingTransitionEnabled$lambda58(r100);
    }

    public final void m() {
        Iterator r100 = CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        OButtonGroup r101 = (OButtonGroup) r100.next();
        r101.setTouchEventBlocked$OUI_standardRelease(this.G);
        if (this.F == false) goto L7;
        if (r101.Q() == true) goto L4;
        r101.setAlpha(1.0f);
        goto L4
    L7:
        r101.setAlpha(0.0f);
        goto L4
    }

    public final void setFloatingTransitionEndListener(FloatingTransitionBridge.c r100) {
    }

    public final void setTitleBarTransitionEndListener(d r100) {
    }

    static {
        H0 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1;
        L0 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2;
    }

    private final int getCenterTitleGap() {
        if (this.U == false) goto L6;
        return this.f403418p0;
    L6:
        return this.f403412k0;
    }

    private final int getEndAreaWidthForCenter() {
        Integer r100 = this.E;
        if (r100 != null) goto L9;
        LinearLayout r101 = this.f403413l;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r101 = null;
    L10:
        return r101.getMeasuredWidth();
    L9:
        return r100.intValue();
    }

    public final boolean E() {
        OTextView r100 = this.f403404d;
        OTextView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r100 = null;
    L5:
        boolean r102 = false;
        if (r100.getVisibility() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L15;
        OTextView r104 = this.f403404d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L14:
        int r105 = r101.getTextColors().getDefaultColor();
    L28:
        return !h0.b(r105);
    L13:
        r101 = r104;
        goto L14
    L15:
        OTextView r106 = this.f403410j;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r106 = null;
    L19:
        if (r106.getVisibility() != 0) goto L21;
        r102 = true;
    L21:
        if (r102 == false) goto L30;
        OTextView r107 = this.f403410j;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L26:
        r105 = r101.getTextColors().getDefaultColor();
        goto L28
    L25:
        r101 = r107;
        goto L26
    L30:
        return vma.i.a(this);
    L8:
        r103 = false;
        goto L9
    }

    public final void I() {
        fja.d r100 = this.B;
        if (r100 == null) goto L6;
        int r101 = fja.d.f477533d;
        r100.a(false);
    L6:
        this.B = null;
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        fja.d r102 = this.C;
        if (r102 == null) goto L10;
        int r103 = fja.d.f477533d;
        r102.a(false);
    L10:
        this.C = null;
        ((ArrayList) getEndSubButtonGroup().Q).clear();
        ((ArrayList) getEndButtonGroup().Q).clear();
        Iterator r104 = CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}).iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((OButtonGroup) r104.next()).H(true);
        goto L12
    }

    public final void J() {
        this.W = pla.d.n(this, 8);
        this.f403412k0 = pla.d.n(this, 12);
        this.f403418p0 = pla.d.n(this, 4);
        this.f403400J = pla.d.n(this, 12);
    }

    public final void K() {
        Integer r100 = this.E;
        if (r100 != null) goto L5;
        return;
    L5:
        final int r101 = r100.intValue();
        LinearLayout r102 = this.f403413l;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r102 = null;
    L8:
        Integer r103 = Integer.valueOf(r102.getWidth());
        boolean r104 = true;
        if (r103.intValue() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L15;
        r103 = null;
    L15:
        if (r103 != null) goto L20;
        LinearLayout r106 = this.f403413l;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r106 = null;
    L19:
        int r107 = r106.getMeasuredWidth();
    L22:
        if (getEndSubButtonGroup().Q() == false) goto L24;
    L27:
        if (r107 <= r101) goto L31;
        if (r104 == false) goto L31;
        post(new com.obric.oui.titlebar.b(this, r101));
        return;
    L31:
        setFreezeEndAreaWidth(null);
        return;
    L24:
        if (getEndButtonGroup().Q() == true) goto L27;
        r104 = false;
        goto L27
    L20:
        r107 = r103.intValue();
        goto L22
    L11:
        r105 = false;
        goto L12
    }

    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r100 = this.f403407g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
        return null;
    }

    public final OTextView getCenterSubtitleView() {
        OTextView r100 = this.f403411k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        return null;
    L6:
        return r100;
    }

    public final OTextView getCenterTitleView() {
        OTextView r100 = this.f403410j;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        return null;
    L6:
        return r100;
    }

    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r100 = this.f403415n;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
        return null;
    }

    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r100 = this.f403414m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
        return null;
    }

    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r100 = this.f403402b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
        return null;
    }

    public final OTextView getStartSubtitleView() {
        OTextView r100 = this.f403405e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        return null;
    L6:
        return r100;
    }

    public final OTextView getStartTitleView() {
        OTextView r100 = this.f403404d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        return null;
    L6:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FloatingTransitionBridge r100 = this.L;
        if (r100 == null) goto L6;
        Map<IBinder, FloatingTransitionBridge> r101 = FloatingTransitionBridge.H;
        r100.K(true, true);
    L6:
        super.onDetachedFromWindow();
    }

    public final k s() {
        FrameLayout r100 = this.f403408h;
        ViewGroup.MarginLayoutParams r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r100 = null;
    L5:
        View r102 = r100.getChildAt(0);
        int[] r103 = new int[2];
        if (isAttachedToWindow() == false) goto L8;
        getLocationOnScreen(r103);
    L8:
        boolean r104 = true;
        k.e r105 = new k.e(getWidth(), getHeight(), r103[0], r103[1]);
        LinearLayout r106 = this.f403403c;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleContainer");
        r106 = null;
    L11:
        int r110 = r(r106);
        LinearLayout r107 = this.f403409i;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleContainer");
        r107 = null;
    L14:
        int r111 = r(r107);
        if (r102 == null) goto L23;
        Integer r108 = Integer.valueOf(r102.getMeasuredWidth());
        if (r108.intValue() <= 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
    L24:
        if (r108 != null) goto L28;
        if (r102 != null) goto L27;
        int r112 = 0;
    L29:
        if (r102 == null) goto L37;
        Integer r113 = Integer.valueOf(r102.getMeasuredHeight());
        if (r113.intValue() > 0) goto L35;
        r104 = false;
    L35:
        if (r104 == false) goto L37;
    L38:
        if (r113 != null) goto L42;
        if (r102 != null) goto L41;
        int r114 = 0;
    L44:
        View r115 = this.f403417p;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r115 = null;
    L47:
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r101 = (ViewGroup.MarginLayoutParams) r116;
    L50:
        if (r101 != null) goto L52;
        int r117 = 0;
    L54:
        return new k(r105, new k.g(r110, r111, r112, r114, r117), new k.c(t(getStartButtonGroup(), this.P.f403642a, this.f403419q), t(getCenterButtonGroup(), this.P.f403643b, this.f403420r), t(getEndSubButtonGroup(), this.P.f403644c, this.f403422t), t(getEndButtonGroup(), this.P.f403645d, this.f403421s)), new k.h(this.f403426x, this.f403427y, this.f403428z, this.A), 48);
    L52:
        r117 = r101.topMargin;
        goto L54
    L41:
        int r118 = Integer.valueOf(r102.getHeight()).intValue();
    L43:
        r114 = r118;
        goto L44
    L42:
        r118 = r113.intValue();
    L37:
        r113 = null;
        goto L38
    L27:
        r108 = Integer.valueOf(r102.getWidth());
    L28:
        r112 = r108.intValue();
        goto L29
    L20:
        r109 = false;
    L23:
        r108 = null;
        goto L24
    }

    public final void B() {
        if (o.c() == true) goto L5;
        return;
    L5:
        final FloatingTransitionBridge r100 = this.L;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.f403559v == false) goto L11;
    L22:
        boolean r101 = true;
    L23:
        if (r101 == false) goto L32;
        Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
        FloatingTransitionBridge.b.b();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L28;
        r100.r(true);
        return;
    L28:
        r100.f403538a.post(new com.obric.oui.titlebar.floating.d(r100));
        return;
    L32:
        return;
    L11:
        if (r100.f403560w == true) goto L22;
        if (r100.B == true) goto L22;
        if (r100.C == true) goto L22;
        if (r100.f403555r == true) goto L22;
        if (r100.f403553p != null) goto L22;
        r101 = false;
        goto L23
    }

    public final boolean D() {
        if (getCenterButtonGroup().getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L35;
        OTextView r101 = this.f403410j;
        FrameLayout r102 = null;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r101 = null;
    L11:
        if (r101.getVisibility() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L36;
        OTextView r104 = this.f403411k;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r104 = null;
    L19:
        if (r104.getVisibility() != 0) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == true) goto L37;
        FrameLayout r106 = this.f403408h;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L28:
        if (r102.getVisibility() != 0) goto L30;
        boolean r107 = true;
    L31:
        if (r107 == true) goto L38;
        return false;
    L38:
        return true;
    L30:
        r107 = false;
        goto L31
    L26:
        r102 = r106;
        goto L28
    L37:
        return true;
    L21:
        r105 = false;
        goto L22
    L36:
        return true;
    L13:
        r103 = false;
        goto L14
    L35:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean F() {
        if (getEndButtonGroup().getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (getEndSubButtonGroup().getVisibility() != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final boolean G() {
        if (getStartButtonGroup().getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L27;
        OTextView r101 = this.f403404d;
        OTextView r102 = null;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r101 = null;
    L11:
        if (r101.getVisibility() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L28;
        OTextView r104 = this.f403405e;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L20:
        if (r102.getVisibility() != 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == true) goto L29;
        return false;
    L29:
        return true;
    L22:
        r105 = false;
        goto L23
    L18:
        r102 = r104;
        goto L20
    L28:
        return true;
    L13:
        r103 = false;
        goto L14
    L27:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final void H() {
        if (o.c() == true) goto L5;
        return;
    L5:
        if (this.K == true) goto L7;
        return;
    L7:
        if (isAttachedToWindow() == true) goto L9;
        return;
    L9:
        if (this.M == false) goto L32;
        FloatingTransitionBridge r100 = this.L;
        if (r100 == null) goto L33;
        r100.L();
        if (r100.B == false) goto L17;
    L26:
        r100.F("stateChanged");
        return;
    L17:
        if (r100.C == true) goto L26;
        if (r100.f403555r == true) goto L26;
        if (r100.f403553p != null) goto L26;
        if (r100.f403559v == true) goto L26;
        if (r100.f403560w == true) goto L26;
        return;
    L33:
        return;
    }

    public final void P() {
        View r100 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r100);
        getCenterButtonGroup().setBackdropTarget(r100);
        getEndButtonGroup().setBackdropTarget(r100);
        getEndSubButtonGroup().setBackdropTarget(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        boolean r100 = true;
        if ((getParent() instanceof com.obric.oui.material.b) == false) goto L8;
    L11:
        if (r100 == false) goto L13;
        R(false);
        goto L13
    L8:
        if ((getParent().getParent() instanceof com.obric.oui.material.b) == true) goto L11;
        r100 = false;
    L13:
        this.T.b();
        FloatingTransitionBridge r101 = this.L;
        if (r101 == null) goto L17;
        Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
        r101.x(false);
    L17:
        FloatingTransitionBridge r103 = this.L;
        if (r103 == null) goto L21;
        r103.C("attached");
    L21:
        post(new com.obric.oui.titlebar.d(this));
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (this.f403425w == (-1)) goto L6;
        com.obric.oui.material.h.c(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), this.f403425w);
        return;
    }

    private final View getDefaultTargetView() {
        Integer r100 = OMaterialHelper.f401446a;
        return this;
    }

    private final int getSubEndToEndGap() {
        return this.f403400J;
    }

    public static List A(OButtonGroup r100) {
        ArrayList r101 = new ArrayList(r100.getItemCount());
        int r102 = r100.getItemCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        int r104 = r103 + 1;
        LinearLayout r105 = r100.D;
        if (r105 != null) goto L7;
        View r106 = null;
    L8:
        if (r106 == null) goto L11;
        r101.add(r106);
    L11:
        r103 = r104;
        goto L3
    L7:
        r106 = r105.getChildAt(r103);
        goto L8
    L12:
        return r101;
    }

    public static int r(View r100) {
        boolean r101 = true;
        if (r100.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return 0;
    L8:
        Integer r103 = Integer.valueOf(r100.getMeasuredWidth());
        if (r103.intValue() > 0) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L15;
        r103 = null;
    L15:
        if (r103 != null) goto L18;
        return r100.getWidth();
    L18:
        return r103.intValue();
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setFloatingTransitionEnabled$lambda-58, reason: not valid java name */
    private static final void m8593setFloatingTransitionEnabled$lambda58(OFloatingTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.H();
    }

    /* JADX INFO: renamed from: setFloatingTransitionOwnerActive$lambda-59, reason: not valid java name */
    private static final void m8594setFloatingTransitionOwnerActive$lambda59(OFloatingTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.H();
    }

    private final void setFreezeEndAreaWidth(Integer r100) {
        if (Intrinsics.areEqual(this.E, r100) == false) goto L5;
        return;
    L5:
        this.E = r100;
        requestLayout();
    }

    private final void setSubEndToEndGapVisible(boolean r100) {
        ViewGroup.LayoutParams r101 = getEndButtonGroup().getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r100 == false) goto L10;
        int r103 = this.f403400J;
    L12:
        if (r102.getMarginStart() != r103) goto L14;
        return;
    L14:
        r102.setMarginStart(r103);
        getEndButtonGroup().setLayoutParams(r102);
        return;
    L10:
        r103 = 0;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void L(OTextView r100) {
        CharSequence r101 = r100.getText();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if ((!r103) == true) goto L13;
        r102 = 8;
    L13:
        r100.setVisibility(r102);
        requestLayout();
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final String M(int r100) {
        if (r100 != 0) goto L8;
        return null;
    L8:
        return getResources().getResourceTypeName(r100) + '/' + getResources().getResourceEntryName(r100);
    L10:
        return null;
    }

    public final void Q(boolean r100) {
        OButtonGroup r101 = getEndButtonGroup();
        boolean r102 = false;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        if (getEndSubButtonGroup().getVisibility() == 0) goto L9;
    L15:
        setSubEndToEndGapVisible(r102);
        return;
    L9:
        if (getEndButtonGroup().getVisibility() != 0) goto L15;
        if (getEndSubButtonGroup().getItemCount() <= 0) goto L15;
        if (getEndButtonGroup().getItemCount() <= 0) goto L15;
        r102 = true;
        goto L15
    L5:
        r103 = 8;
        goto L6
    }

    public final void R(boolean r100) {
        View r101 = this.f403416o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void W(int r100) {
        View r101 = this.f403416o;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        r103.height = getContext().getResources().getDimensionPixelSize(R.dimen.oui_title_bar_mask_height) + r100;
        View r104 = this.f403416o;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r104 = null;
    L8:
        r104.setLayoutParams(r103);
        View r105 = this.f403417p;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r105 = null;
    L11:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L20;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        r107.topMargin = r100;
        View r108 = this.f403417p;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L17:
        r102.setLayoutParams(r107);
        return;
    L16:
        r102 = r108;
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        this.f403425w = r100;
        com.obric.oui.material.h.c(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r100);
    }

    @Override // com.obric.oui.material.b
    public final void b(boolean r100) {
        int r101 = this.f403425w;
        if (r101 == (-1)) goto L6;
        com.obric.oui.material.h.a(this, false, r101);
        return;
    L6:
        com.obric.oui.material.h.b(this, false, this.f403424v);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        this.U = vma.h.b(r100.fontScale);
    L6:
        J();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == false) goto L9;
        FloatingTransitionBridge r101 = this.L;
        if (r101 == null) goto L10;
        r101.C("windowFocus");
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L9;
        FloatingTransitionBridge r101 = this.L;
        if (r101 == null) goto L10;
        r101.C("windowVisible");
        return;
    L10:
        return;
    }

    public final void setActionChangeInterruptCallback$OUI_standardRelease(Function0<Unit> r100) {
        this.N = r100;
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        this.f403423u = r100;
        if (r100 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, this);
        P();
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r100);
        List r101 = CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()});
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((com.obric.oui.material.g) r102.next()).setBackdropTarget(r100);
        goto L8
    }

    public final void setCenterButtonGroup(OButtonGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403407g = r100;
    }

    public final void setCenterButtonGroupStyle(int r100) {
        this.f403427y = r100;
        o(getCenterButtonGroup(), r100, new AnonymousClass1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCenterCustomView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FrameLayout r101 = this.f403408h;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r101 = null;
    L5:
        r101.removeAllViews();
        FrameLayout r103 = this.f403408h;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r103 = null;
    L8:
        r103.addView(r100);
        FrameLayout r104 = this.f403408h;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L12:
        r102.setVisibility(0);
        if ((r100 instanceof com.obric.oui.material.g) == false) goto L16;
        ((com.obric.oui.material.g) r100).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r102 = r104;
        goto L12
    }

    public final void setCenterSubTitle(int r100) {
        setCenterSubtitle(getResources().getString(r100));
    }

    public final void setCenterSubTitleColor(int r100) {
        OTextView r101 = this.f403411k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
    }

    public final void setCenterSubtitle(String r100) {
        OTextView r101 = this.f403411k;
        OTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r101 = null;
    L5:
        r101.setText(r100);
        OTextView r103 = this.f403411k;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L9:
        L(r102);
        H();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setCenterTitle(String r100) {
        OTextView r101 = this.f403410j;
        OTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r101 = null;
    L5:
        r101.setText(r100);
        OTextView r103 = this.f403410j;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L9:
        L(r102);
        H();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setCenterTitleColor(int r100) {
        OTextView r101 = this.f403410j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
        this.R = this.Q.invoke(Boolean.valueOf(E()));
    }

    public final void setEndButtonGroup(OButtonGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403415n = r100;
    }

    public final void setEndButtonGroupStyle(int r100) {
        this.A = r100;
        o(getEndButtonGroup(), r100, new C116821(this));
    }

    public final void setEndSubButtonGroup(OButtonGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403414m = r100;
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(Function0<Unit> r100) {
        this.O = r100;
        Iterator r101 = CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((OButtonGroup) r101.next()).setAnimationUpdateListener$OUI_standardRelease(r100);
        goto L4
    }

    public final void setFloatingTransitionEnabled(boolean r100) {
        if (this.K != r100) goto L5;
        return;
    L5:
        this.K = r100;
        if (r100 == true) goto L8;
        FloatingTransitionBridge r101 = this.L;
        if (r101 == null) goto L26;
        Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
        r101.K(true, true);
    L26:
        this.L = null;
        return;
    L8:
        if (o.c() == true) goto L11;
        return;
    L11:
        if (this.L != null) goto L14;
        this.L = new FloatingTransitionBridge(this);
    L14:
        if (isAttachedToWindow() == true) goto L16;
        return;
    L16:
        if (this.M == false) goto L29;
        FloatingTransitionBridge r103 = this.L;
        if (r103 == null) goto L21;
        Map<IBinder, FloatingTransitionBridge> r104 = FloatingTransitionBridge.H;
        r103.x(false);
    L21:
        post(new com.obric.oui.titlebar.c(this));
        return;
    }

    public final void setFloatingTransitionOwnerActive$OUI_standardRelease(boolean r100) {
        if (this.M != r100) goto L5;
        return;
    L5:
        this.M = r100;
        if (o.c() == true) goto L9;
        return;
    L9:
        if (this.K == true) goto L11;
        return;
    L11:
        if (isAttachedToWindow() == false) goto L26;
        if (r100 == false) goto L19;
        FloatingTransitionBridge r101 = this.L;
        if (r101 == null) goto L18;
        r101.x(true);
    L18:
        post(new f(this));
        return;
    L19:
        FloatingTransitionBridge r102 = this.L;
        if (r102 == null) goto L27;
        r102.K(false, false);
        return;
    L27:
        return;
    }

    public final void setKeepActionInteractiveWhenHidden$OUI_standardRelease(boolean r100) {
        this.H = r100;
    }

    @Deprecated(message = "not support set mask background")
    public final void setMaskBackground(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        R(true);
    }

    public final void setMaskBlurRadius(float r100) {
        com.obric.oui.material.c r101 = this.R;
        com.obric.oui.material.c r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r101 = null;
    L5:
        com.obric.oui.blur.a r103 = r101.f401458g;
        if (r103 == null) goto L9;
        r103.f398866a = r100;
    L9:
        cna.d r104 = this.T;
        com.obric.oui.material.c r105 = this.R;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L13:
        r104.a(this, r102, this.f403425w);
        if (r100 != 0.0f) goto L16;
        boolean r106 = true;
    L17:
        R(!r106);
        return;
    L16:
        r106 = false;
        goto L17
    L12:
        r102 = r105;
        goto L13
    }

    public final void setNonActionContentVisible$OUI_standardRelease(boolean r100) {
        if (this.I != r100) goto L5;
        return;
    L5:
        this.I = r100;
        if (r100 == false) goto L8;
        float r101 = 1.0f;
    L9:
        ViewGroup[] r102 = new ViewGroup[3];
        LinearLayout r103 = this.f403403c;
        FrameLayout r104 = null;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleContainer");
        r103 = null;
    L12:
        r102[0] = r103;
        LinearLayout r105 = this.f403409i;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleContainer");
        r105 = null;
    L15:
        r102[1] = r105;
        FrameLayout r106 = this.f403408h;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L19:
        r102[2] = r104;
        Iterator r107 = CollectionsKt.listOf(r102).iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        ViewGroup r108 = (ViewGroup) r107.next();
        r108.setAlpha(r101);
        r108.setEnabled(this.I);
        r108.setClickable(this.I);
        goto L21
    L23:
        return;
    L18:
        r104 = r106;
        goto L19
    L8:
        r101 = 0.0f;
        goto L9
    }

    public final void setStartButtonGroup(OButtonGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403402b = r100;
    }

    public final void setStartButtonGroupStyle(int r100) {
        this.f403426x = r100;
        o(getStartButtonGroup(), r100, new C116831(this));
    }

    public final void setStartSubTitleColor(int r100) {
        OTextView r101 = this.f403405e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
    }

    public final void setStartSubtitle(String r100) {
        OTextView r101 = this.f403405e;
        OTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r101 = null;
    L5:
        r101.setText(r100);
        OTextView r103 = this.f403405e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L9:
        L(r102);
        H();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setStartTitle(String r100) {
        OTextView r101 = this.f403404d;
        OTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r101 = null;
    L5:
        r101.setText(r100);
        OTextView r103 = this.f403404d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L9:
        L(r102);
        H();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setStartTitleColor(int r100) {
        OTextView r101 = this.f403404d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
        this.R = this.Q.invoke(Boolean.valueOf(E()));
    }

    public final void setSubEndButtonGroupStyle(int r100) {
        this.f403428z = r100;
        o(getEndSubButtonGroup(), r100, new C116841(this));
    }

    public final void setTitleBarContainerClickable$OUI_standardRelease(boolean r100) {
        View r101 = this.f403417p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r101 = null;
    L5:
        r101.setClickable(r100);
    }

    public final void setTitleType(int r100) {
        this.S = r100;
        cna.d r101 = this.T;
        if (r100 != 2) goto L5;
        boolean r102 = true;
    L6:
        r101.f24581b = r102;
        View r103 = null;
        com.obric.oui.material.c r104 = null;
        View r105 = null;
        if (r100 == 0) goto L33;
        if (r100 == 1) goto L25;
        if (r100 != 2) goto L44;
        View r106 = this.f403417p;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r106 = null;
    L14:
        r106.setMinimumHeight(pla.d.n(this, 56));
        View r107 = this.f403417p;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r107 = null;
    L17:
        r107.setPadding(pla.d.n(this, 12), pla.d.n(this, 8), pla.d.n(this, 12), pla.d.n(this, 8));
        com.obric.oui.material.c r108 = this.R;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L21:
        com.obric.oui.blur.a r109 = r104.f401458g;
        if (r109 == null) goto L45;
        setMaskBlurRadius(r109.f398866a);
        return;
    L45:
        return;
    L20:
        r104 = r108;
        goto L21
    L44:
        return;
    L25:
        View r110 = this.f403417p;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r110 = null;
    L28:
        r110.setMinimumHeight(pla.d.n(this, 64));
        View r111 = this.f403417p;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L32:
        r105.setPadding(pla.d.n(this, 16), pla.d.n(this, 16), pla.d.n(this, 16), pla.d.n(this, 8));
        return;
    L31:
        r105 = r111;
        goto L32
    L33:
        View r112 = this.f403417p;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r112 = null;
    L36:
        r112.setMinimumHeight(pla.d.n(this, 56));
        View r113 = this.f403417p;
        if (r113 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L40:
        r103.setPadding(pla.d.n(this, 12), pla.d.n(this, 8), pla.d.n(this, 12), pla.d.n(this, 8));
        return;
    L39:
        r103 = r113;
        goto L40
    L5:
        r102 = false;
        goto L6
    }

    public final void setCenterTitle(int r100) {
        setCenterTitle(getResources().getString(r100));
    }

    public final void setStartSubtitle(int r100) {
        setStartSubtitle(getResources().getString(r100));
    }

    public final void setStartTitle(int r100) {
        setStartTitle(getResources().getString(r100));
    }

    public static int C(List r100, int r101) {
        if (r101 < 0) goto L6;
        if (r101 > r100.size()) goto L6;
        return r101;
    L6:
        return r100.size();
    }

    public static void X(View r100, int r101) {
        k.b r102 = null;
        if (r100 != null) goto L5;
        Object r103 = null;
    L7:
        if ((r103 instanceof k.b) == false) goto L9;
        r102 = (k.b) r103;
    L9:
        int r104 = 0;
        if (r102 == null) goto L14;
        r100.setTag(k.b.a(r102, 0, r101, 55));
    L14:
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r105 = (ViewGroup) r100;
        int r106 = r105.getChildCount();
    L16:
        if (r104 >= r106) goto L28;
        X(r105.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L16
    L28:
        return;
    L19:
        if ((r100 instanceof ImageView) == false) goto L22;
        ((ImageView) r100).setColorFilter(r101);
        return;
    L22:
        if ((r100 instanceof TextView) == false) goto L27;
        ((TextView) r100).setTextColor(r101);
        return;
    L27:
        return;
    L5:
        r103 = r100.getTag();
        goto L7
    }

    public final void O(boolean r100, boolean r101) {
        boolean r102 = false;
        if (r100 == true) goto L21;
        FloatingTransitionBridge r103 = this.L;
        if (r103 != null) goto L8;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
    L20:
        r101 = true;
        goto L21
    L19:
        if (this.H == false) goto L21;
    L8:
        if (r103.f403555r == false) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 != true) goto L16;
        r104 = true;
        goto L17
    L10:
        if (r103.f403553p != null) goto L13;
        r105 = false;
    L21:
        if (r101 == true) goto L25;
        if (r100 == true) goto L25;
        r102 = true;
    L25:
        if (this.F == r100) goto L27;
    L29:
        this.F = r100;
        this.G = r102;
        m();
        return;
    L27:
        if (this.G != r102) goto L29;
    }

    public final k.b T(k.a r100, int r110) {
        int r101 = r100.getType();
        int r102 = r100.f403629b;
        String r103 = r100.f403630c;
        String r104 = r100.f403631d;
        String r105 = r100.f403635h;
        if (r105 != null) goto L6;
        r105 = M(r102);
    L6:
        return new k.b(r101, r102, r103, r110, r104, r105);
    }

    public final k.a Y(k.a r110, final View r111) {
        View.OnClickListener r100 = r110.f403633f;
        if (r100 == null) goto L7;
        return k.a.a(r110, 0, null, 0, new com.obric.oui.titlebar.e(this, r100), false, null, 223);
    L7:
        if (r111.hasOnClickListeners() == true) goto L10;
        return r110;
    L10:
        return k.a.a(r110, 0, null, 0, new g(this, r111), false, null, 223);
    }

    public final View j(int r100, View.OnClickListener r101) {
        int r102 = k.a.f403627i;
        k.a r103 = k.a.C4681a.a(R.drawable.o_floating_title_bar_icon_back, r101);
        int r104 = C(this.P.f403642a, r100);
        List<k.a> r105 = this.P.f403642a;
        List r106 = CollectionsKt.toMutableList(r105);
        ListProtector.add(r106, C(r105, r100), r103);
        return (View) ListProtector.get(V(this, r106, null, false, 14).f403433a, r104);
    }

    public final void l(int r100, final Function0<Unit> r101) {
        FrameLayout r102 = this.f403406f;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r102 = null;
    L5:
        float r104 = r102.getX();
        FrameLayout r105 = this.f403406f;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r105 = null;
    L8:
        final float r106 = r104 + (r105.getWidth() / 2.0f);
        fja.d r107 = this.C;
        if (r107 == null) goto L12;
        int r108 = fja.d.f477533d;
        r107.a(false);
    L12:
        this.C = null;
        setFreezeEndAreaWidth(Integer.valueOf(r100));
        Function0<Unit> r109 = new OFloatingTitleBar$animateFreezeEndAreaWidthTo$1(this, r106, r101);
        View r110 = this.f403417p;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L16:
        ViewTreeObserver r111 = r103.getViewTreeObserver();
        r111.addOnPreDrawListener(new h(r111, this, r109));
        return;
    L15:
        r103 = r110;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        this.V = false;
        OTextView r100 = this.f403410j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r100 = null;
    L5:
        r100.setMaxWidth(Integer.MAX_VALUE);
        OTextView r101 = this.f403411k;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r101 = null;
    L8:
        r101.setMaxWidth(Integer.MAX_VALUE);
        OTextView r102 = this.f403404d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r102 = null;
    L11:
        r102.setMaxWidth(Integer.MAX_VALUE);
        OTextView r103 = this.f403405e;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r103 = null;
    L14:
        r103.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r210, r211);
        boolean r104 = G();
        boolean r105 = D();
        if (F() == false) goto L17;
    L20:
        boolean r106 = true;
    L21:
        int r110 = getEndAreaWidthForCenter();
        int r111 = getMeasuredWidth();
        View r112 = this.f403417p;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r112 = null;
    L24:
        int r113 = r112.getPaddingLeft();
        View r114 = this.f403417p;
        if (r114 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r114 = null;
    L27:
        int r115 = r114.getPaddingRight();
        int r116 = getCenterTitleGap();
        if (r105 == false) goto L33;
        int r117 = r111 / 2;
        FrameLayout r107 = this.f403406f;
        if (r107 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r107 = null;
    L32:
        int r118 = (r117 - (r107.getMeasuredWidth() / 2)) - r116;
    L37:
        if (r104 == false) goto L42;
        int r119 = (r111 / 2) - r113;
        FrameLayout r120 = this.f403401a;
        if (r120 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r120 = null;
    L41:
        int r108 = (r119 - r120.getMeasuredWidth()) - r116;
    L43:
        if (r106 == false) goto L45;
        int r121 = (((r111 / 2) - r115) - r110) - r116;
    L46:
        if (r104 == false) goto L59;
        int r109 = Math.max(0, r118 - r113);
        FrameLayout r122 = this.f403401a;
        if (r122 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r122 = null;
    L51:
        if (r122.getMeasuredWidth() <= r109) goto L59;
        OTextView r123 = this.f403404d;
        if (r123 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r123 = null;
    L55:
        r123.setMaxWidth(r109);
        OTextView r124 = this.f403405e;
        if (r124 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r124 = null;
    L58:
        r124.setMaxWidth(r109);
        boolean r125 = true;
    L60:
        if (r105 == false) goto L103;
        int r126 = Math.min(r108 * 2, r121 * 2);
        boolean r127 = false;
        int r128 = Math.max(0, r126);
        FrameLayout r129 = this.f403406f;
        if (r129 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r129 = null;
    L65:
        if (r129.getMeasuredWidth() <= r128) goto L103;
        this.V = true;
        int r130 = r108 + r121;
        OTextView r131 = this.f403410j;
        if (r131 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r131 = null;
    L69:
        r131.setMaxWidth(r130);
        OTextView r132 = this.f403410j;
        if (r132 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r132 = null;
    L73:
        if (r132.getMeasuredWidth() <= r128) goto L78;
        OTextView r133 = this.f403411k;
        if (r133 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r133 = null;
    L77:
        r133.setMaxWidth(r130);
    L82:
        FrameLayout r134 = this.f403408h;
        if (r134 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r134 = null;
    L86:
        if (r134.getVisibility() != 0) goto L88;
        r127 = true;
    L88:
        if (r127 == false) goto L102;
        FrameLayout r135 = this.f403408h;
        if (r135 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r135 = null;
    L92:
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        FrameLayout r137 = this.f403408h;
        if (r137 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r137 = null;
    L96:
        if (r137.getMeasuredWidth() <= r130) goto L102;
        r136.width = r130;
        FrameLayout r138 = this.f403408h;
        if (r138 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        FrameLayout r139 = null;
    L101:
        r139.setLayoutParams(r136);
        goto L102
    L100:
        r139 = r138;
    L102:
        boolean r140 = true;
    L104:
        if (r140 == false) goto L107;
        super.onMeasure(r210, r211);
        return;
    L107:
        return;
    L78:
        OTextView r141 = this.f403411k;
        if (r141 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r141 = null;
    L81:
        r141.setMaxWidth(r128);
    L103:
        r140 = r125;
    L59:
        r125 = false;
        goto L60
    L45:
        r121 = ((r111 / 2) - r115) - this.W;
        goto L46
    L42:
        r108 = ((r111 / 2) - r113) - this.W;
        goto L43
    L33:
        if (r106 == false) goto L35;
        r118 = ((r111 - r115) - r110) - r116;
        goto L37
    L35:
        r118 = r111 - r115;
        goto L37
    L17:
        if (this.E != null) goto L20;
        r106 = false;
        goto L21
    }

    public final a u(k.c r100, boolean r101) {
        return new a(v(r100.f403642a, this.f403419q, A(getStartButtonGroup()), r101), v(r100.f403643b, this.f403420r, A(getCenterButtonGroup()), r101), v(r100.f403644c, this.f403422t, A(getEndSubButtonGroup()), r101), v(r100.f403645d, this.f403421s, A(getEndButtonGroup()), r101));
    }

    public final c w(List<? extends View> r110, List<? extends View> r111) {
        List<? extends View> r100 = r110;
        boolean r101 = !r100.isEmpty();
        List<? extends View> r102 = r111;
        boolean r103 = !r102.isEmpty();
        if (r101 == false) goto L6;
        if (r103 == false) goto L6;
        EndAreaActionState r104 = EndAreaActionState.BOTH;
    L12:
        if ((!r100.isEmpty()) == false) goto L14;
        OButtonGroup r105 = getEndSubButtonGroup();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "views");
        int r106 = r105.U(r110) + 0;
    L16:
        if ((!r102.isEmpty()) == true) goto L18;
    L21:
        int r107 = r106;
        if (r111.isEmpty() == false) goto L24;
        int r108 = 0;
    L26:
        if (r111.isEmpty() == false) goto L28;
        int r109 = 0;
    L30:
        return new c(r104, r110, r111, r107, r108, r109);
    L28:
        OButtonGroup r112 = getEndButtonGroup();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r111, "views");
        r109 = r112.U(r111);
        goto L30
    L24:
        OButtonGroup r113 = getEndButtonGroup();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r111, "views");
        r108 = r113.U(r111) + getSubEndToEndGap();
        goto L26
    L18:
        if ((!r100.isEmpty()) == false) goto L20;
        r106 = r106 + getSubEndToEndGap();
    L20:
        OButtonGroup r114 = getEndButtonGroup();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r111, "views");
        r106 = r106 + r114.U(r111);
        goto L21
    L14:
        r106 = 0;
    L6:
        if (r101 == false) goto L8;
        r104 = EndAreaActionState.SUB_ONLY;
        goto L12
    L8:
        if (r103 == false) goto L10;
        r104 = EndAreaActionState.END_ONLY;
        goto L12
    L10:
        r104 = EndAreaActionState.EMPTY;
        goto L12
    }

    public final OUIFrameLayout x(int r100, int r101) {
        OUIFrameLayout r102 = new OUIFrameLayout(getContext(), null, 0, 14);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        r102.setPadding(pla.d.n(r102, 7), pla.d.n(r102, 7), pla.d.n(r102, 7), pla.d.n(r102, 7));
        r102.setClickable(true);
        r102.setRadius(pla.d.n(r102, 99));
        ImageView r103 = new ImageView(r102.getContext());
        r103.setImageResource(r100);
        if (r101 == 0) goto L5;
        r103.setColorFilter(r101);
    L5:
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(pla.d.n(r102, 22), pla.d.n(r102, 22));
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r102.addView(r103, r104);
        return r102;
    }

    public final OUIFrameLayout y(String r100, int r110) {
        OUIFrameLayout r101 = new OUIFrameLayout(getContext(), null, 0, 14);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setMinimumHeight(pla.d.n(r101, 36));
        r101.setPadding(pla.d.n(r101, 7), 0, pla.d.n(r101, 7), 0);
        r101.setClickable(true);
        r101.setRadius(pla.d.n(r101, 99));
        OTextView r102 = new OTextView(r101.getContext(), null, 0, 14);
        r102.setText(r100);
        r102.setGravity(17);
        r102.setPadding(pla.d.n(r102, 4), 0, pla.d.n(r102, 4), 0);
        r102.setSingleLine(true);
        r102.setMinHeight(pla.d.n(r102, 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r102.setTextAppearance(R.style.Button_2_Medium);
    L5:
        if (r110 == 0) goto L7;
        r102.setTextColor(r110);
    L7:
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, -2);
        r111.gravity = 17;
        Unit r103 = Unit.INSTANCE;
        r101.addView(r102, r111);
        return r101;
    }

    public final OUILinearLayout z(String r110, int r111) {
        OUILinearLayout r100 = new OUILinearLayout(getContext(), null, 0, 14);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.setMinimumHeight(pla.d.n(r100, 36));
        r100.setPadding(pla.d.n(r100, 7), 0, pla.d.n(r100, 8), 0);
        r100.setClickable(true);
        r100.setRadius(pla.d.n(r100, 99));
        r100.setOrientation(0);
        r100.setGravity(16);
        OTextView r101 = new OTextView(r100.getContext(), null, 0, 14);
        r101.setText(r110);
        r101.setGravity(16);
        r101.setPadding(pla.d.n(r101, 4), 0, 0, 0);
        r101.setSingleLine(true);
        r101.setMinHeight(pla.d.n(r101, 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r101.setTextAppearance(R.style.Title_1_Bold);
    L5:
        if (r111 == 0) goto L7;
        r101.setTextColor(r111);
    L7:
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
        r102.gravity = 16;
        Unit r103 = Unit.INSTANCE;
        r100.addView(r101, r102);
        ImageView r104 = new ImageView(r100.getContext());
        r104.setImageResource(R.drawable.o_card_list_item_tail_icon_chevron);
        if (r111 == 0) goto L10;
        r104.setColorFilter(r111);
    L10:
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(pla.d.n(r100, 20), pla.d.n(r100, 20));
        r112.gravity = 16;
        r112.setMarginStart(pla.d.n(r100, 4));
        r100.addView(r104, r112);
        return r100;
    }

    public OFloatingTitleBar(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        boolean r113 = true;
        this.f403424v = true;
        int r100 = 2;
        this.f403425w = 2;
        this.F = true;
        this.I = true;
        this.M = true;
        this.P = new k.c(0);
        Function1<Boolean, com.obric.oui.material.c> r101 = new OFloatingTitleBar$maskMaterial$1(this);
        this.Q = r101;
        cna.d r102 = new cna.d(this);
        this.T = r102;
        this.U = vma.h.b(r110.getResources().getConfiguration().fontScale);
        J();
        LayoutInflater.from(r110).inflate(R.layout.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        this.f403401a = (FrameLayout) findViewById(R.id.start_container);
        setStartButtonGroup((OButtonGroup) findViewById(R.id.start_button_group));
        this.f403403c = (LinearLayout) findViewById(R.id.start_title_container);
        this.f403404d = (OTextView) findViewById(R.id.start_title);
        this.f403405e = (OTextView) findViewById(R.id.start_sub_title);
        this.f403406f = (FrameLayout) findViewById(R.id.center_container);
        setCenterButtonGroup((OButtonGroup) findViewById(R.id.center_button_group));
        this.f403408h = (FrameLayout) findViewById(R.id.center_custom_container);
        this.f403409i = (LinearLayout) findViewById(R.id.center_title_container);
        this.f403410j = (OTextView) findViewById(R.id.center_title);
        this.f403411k = (OTextView) findViewById(R.id.center_sub_title);
        com.obric.oui.material.c r103 = null;
        if (Build.VERSION.SDK_INT < 28) goto L17;
        OTextView r114 = this.f403404d;
        if (r114 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r114 = null;
    L7:
        r114.setFallbackLineSpacing(false);
        OTextView r115 = this.f403405e;
        if (r115 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r115 = null;
    L10:
        r115.setFallbackLineSpacing(false);
        OTextView r116 = this.f403410j;
        if (r116 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r116 = null;
    L13:
        r116.setFallbackLineSpacing(false);
        OTextView r117 = this.f403411k;
        if (r117 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r117 = null;
    L16:
        r117.setFallbackLineSpacing(false);
    L17:
        this.f403413l = (LinearLayout) findViewById(R.id.end_container);
        setEndSubButtonGroup((OButtonGroup) findViewById(R.id.end_sub_button_group));
        setEndButtonGroup((OButtonGroup) findViewById(R.id.end_button_group));
        this.f403416o = findViewById(R.id.material_mask);
        View r118 = findViewById(R.id.title_bar_container);
        this.f403417p = r118;
        if (r118 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r118 = null;
    L20:
        r118.setClickable(true);
        this.R = r101.invoke(Boolean.valueOf(!E()));
        P();
        if (r111 == null) goto L91;
        TypedArray r119 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.oFloatingTitleBar_centerButtonGroupStyle, R.attr.oFloatingTitleBar_centerSubTitle, R.attr.oFloatingTitleBar_centerSubTitleColor, R.attr.oFloatingTitleBar_centerTitle, R.attr.oFloatingTitleBar_centerTitleColor, R.attr.oFloatingTitleBar_defaultMaskBackground, R.attr.oFloatingTitleBar_enableFloatingTransition, R.attr.oFloatingTitleBar_endButtonGroupStyle, R.attr.oFloatingTitleBar_endSubButtonGroupStyle, R.attr.oFloatingTitleBar_maskBackground, R.attr.oFloatingTitleBar_maskBlurRadius, R.attr.oFloatingTitleBar_startButtonGroupStyle, R.attr.oFloatingTitleBar_startSubTitle, R.attr.oFloatingTitleBar_startSubTitleColor, R.attr.oFloatingTitleBar_startTitle, R.attr.oFloatingTitleBar_startTitleColor, R.attr.oFloatingTitleBar_statusBarImmersion, R.attr.oFloatingTitleBar_type, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetFitInsetLeft, R.attr.oui_widgetFitInsetRight, R.attr.oui_widgetFitInsetTop, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialSrcType}, 0, 0);
        if (r119.hasValue(17) == false) goto L26;
        setTitleType(r119.getInt(17, 0));
    L26:
        if (r119.hasValue(14) == false) goto L29;
        setStartTitle(r119.getString(14));
    L29:
        if (r119.hasValue(15) == false) goto L32;
        setStartTitleColor(r119.getColor(15, R.color.oui_basic_text_1));
    L32:
        if (r119.hasValue(12) == false) goto L35;
        setStartSubtitle(r119.getString(12));
    L35:
        if (r119.hasValue(13) == false) goto L38;
        setStartSubTitleColor(r119.getColor(13, R.color.oui_basic_text_3));
    L38:
        if (r119.hasValue(3) == false) goto L41;
        setCenterTitle(r119.getString(3));
    L41:
        if (r119.hasValue(4) == false) goto L44;
        setCenterTitleColor(r119.getColor(4, R.color.oui_basic_text_1));
    L44:
        if (r119.hasValue(1) == false) goto L47;
        setCenterSubtitle(r119.getString(1));
    L47:
        if (r119.hasValue(2) == false) goto L49;
        setCenterSubTitleColor(r119.getColor(2, R.color.oui_basic_text_3));
    L49:
        setStartButtonGroupStyle(r119.getResourceId(11, R.style.OFloatingTitleBar_Action_Standard));
        setCenterButtonGroupStyle(r119.getResourceId(0, R.style.OFloatingTitleBar_Action_Standard));
        setSubEndButtonGroupStyle(r119.getResourceId(8, R.style.OFloatingTitleBar_Action_Standard));
        setEndButtonGroupStyle(r119.getResourceId(7, R.style.OFloatingTitleBar_Action_Standard));
        if (r119.hasValue(9) == false) goto L56;
        Drawable r104 = r119.getDrawable(9);
        if (r104 == null) goto L54;
        setMaskBackground(r104);
        goto L56
    L54:
        setMaskBackground(new ColorDrawable(r119.getColor(9, 0)));
    L56:
        if (r119.hasValue(5) == false) goto L59;
        r119.getBoolean(5, false);
    L59:
        if (r119.hasValue(19) == false) goto L73;
        if (r119.hasValue(18) == false) goto L73;
        int r105 = r119.getResourceId(19, R.array.oui_titlebar_blur_colors);
        int r106 = r119.getResourceId(18, R.array.oui_titlebar_blur_blend_modes);
        com.obric.oui.material.c r107 = this.R;
        if (r107 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r107 = null;
    L65:
        r107.f401454c = OMaterialHelper.d(r119.getResources(), r105, r106);
        com.obric.oui.material.c r108 = this.R;
        if (r108 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L70:
        if (r103.f401454c != null) goto L73;
        wma.b.b("OFloatingTitleBar", "init get widget blur colors or modes error");
        goto L73
    L68:
        r103 = r108;
    L73:
        if (r119.hasValue(25) == false) goto L79;
        if (this.S != 2) goto L77;
        r100 = 4;
    L77:
        this.f403425w = r119.getInt(25, r100);
    L79:
        if (r119.hasValue(10) == false) goto L82;
        setMaskBlurRadius(r119.getFloat(10, BlurToken.Blur_Progress_Thin));
    L82:
        if (r119.getBoolean(23, r119.getBoolean(16, false)) == true) goto L84;
    L86:
        r113 = false;
    L87:
        r102.c(r113, new OFloatingTitleBar$initAttrs$1$1(this));
        if (r119.hasValue(6) == false) goto L90;
        setFloatingTransitionEnabled(r119.getBoolean(6, false));
    L90:
        r119.recycle();
        goto L91
    L84:
        if (this.S == 1) goto L86;
    L91:
        r102.f24582c = 49;
    }

    public static final void g(OFloatingTitleBar r100, OButtonGroup r101, int r102) {
        r100.getClass();
        int r103 = r101.getItemCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        int r105 = r104 + 1;
        LinearLayout r106 = r101.D;
        if (r106 != null) goto L7;
        View r107 = null;
    L8:
        X(r107, r102);
        r104 = r105;
        goto L3
    L7:
        r107 = r106.getChildAt(r104);
        goto L8
    }

    public static /* synthetic */ View i(OFloatingTitleBar r100, int r101, View.OnClickListener r102) {
        return r100.h(r101, -1, r102);
    }

    public static /* synthetic */ View k(OFloatingTitleBar r100, View.OnClickListener r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        int r103 = -1;
    L7:
        if ((r102 & 4) == 0) goto L10;
        r101 = null;
    L10:
        return r100.j(r103, r101);
    L5:
        r103 = 0;
        goto L7
    }

    public static void p(OTextView r100, OTextView r101, int r102) {
        r100.setMinWidth(RangesKt.coerceAtLeast(r102, 0));
        r100.setText("");
        if (r102 <= 0) goto L5;
        int r103 = 0;
    L6:
        r100.setVisibility(r103);
        r101.setMinWidth(0);
        r101.setText(null);
        r101.setVisibility(8);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final View h(int r100, int r101, View.OnClickListener r102) {
        int r103 = k.a.f403627i;
        k.a r104 = k.a.C4681a.a(r100, r102);
        int r105 = C(this.P.f403645d, r101);
        List<k.a> r106 = this.P.f403645d;
        List r107 = CollectionsKt.toMutableList(r106);
        ListProtector.add(r107, C(r106, r101), r104);
        return (View) ListProtector.get(V(this, null, r107, false, 7).f403436d, r105);
    }

    public final void n(k r110, boolean r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r112, "onTransitionEnd");
        k.h r100 = r110.f403624d;
        int r101 = r100.f403662a;
        if (r101 == 0) goto L5;
        setStartButtonGroupStyle(r101);
    L5:
        int r102 = r100.f403663b;
        if (r102 == 0) goto L8;
        setCenterButtonGroupStyle(r102);
    L8:
        int r103 = r100.f403664c;
        if (r103 == 0) goto L11;
        setSubEndButtonGroupStyle(r103);
    L11:
        int r104 = r100.f403665d;
        if (r104 == 0) goto L14;
        setEndButtonGroupStyle(r104);
    L14:
        FrameLayout r113 = null;
        if (this.I == true) goto L29;
        k.g r105 = r110.f403622b;
        OTextView r106 = this.f403404d;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r106 = null;
    L19:
        OTextView r107 = this.f403405e;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r107 = null;
    L22:
        p(r106, r107, r105.f403657a);
        OTextView r108 = this.f403410j;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r108 = null;
    L25:
        OTextView r109 = this.f403411k;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r109 = null;
    L28:
        p(r108, r109, r105.f403658b);
    L29:
        k.g r114 = r110.f403622b;
        int r115 = r114.f403659c;
        boolean r116 = true;
        if (r115 <= 0) goto L32;
    L35:
        boolean r117 = true;
    L36:
        if (r117 == true) goto L44;
        FrameLayout r118 = this.f403408h;
        if (r118 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r118 = null;
    L40:
        r118.removeAllViews();
        FrameLayout r119 = this.f403408h;
        if (r119 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r119 = null;
    L43:
        r119.setVisibility(8);
    L66:
        k.c r120 = r110.f403623c;
        a r121 = u(r120, true);
        if (r111 == true) goto L69;
    L71:
        r116 = false;
    L73:
        if (r110.f403625e != null) goto L75;
        Function0<Unit> r122 = r112;
    L76:
        U(r120, r121, r116, false, r122, false);
        k.d r123 = r110.f403625e;
        if (r123 == null) goto L85;
        Intrinsics.checkNotNullParameter(r123, "state");
        I();
        getStartButtonGroup().Y(r123.f403646a, new OFloatingTitleBar$restoreAnimationState$1(this));
        getCenterButtonGroup().Y(r123.f403647b, new OFloatingTitleBar$restoreAnimationState$2(this));
        getEndSubButtonGroup().Y(r123.f403648c, new OFloatingTitleBar$restoreAnimationState$3(this));
        getEndButtonGroup().Y(r123.f403649d, new OFloatingTitleBar$restoreAnimationState$4(this));
        getEndSubButtonGroup().setTranslationX(r123.f403650e);
        setFreezeEndAreaWidth(r123.f403651f);
        FrameLayout r124 = this.f403406f;
        if (r124 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L83:
        r113.setTranslationX(r123.f403652g);
        r112.invoke();
        return;
    L82:
        r113 = r124;
        goto L83
    L85:
        return;
    L75:
        r122 = null;
        goto L76
    L69:
        if (r110.f403625e != null) goto L71;
    L44:
        int r125 = r114.f403660d;
        View r126 = new View(getContext());
        r126.setAlpha(0.0f);
        r126.setImportantForAccessibility(2);
        Integer r127 = Integer.valueOf(r115);
        if (r127.intValue() <= 0) goto L47;
        boolean r128 = true;
    L48:
        if (r128 == true) goto L51;
        r127 = null;
    L51:
        int r129 = -2;
        if (r127 != null) goto L54;
        int r130 = -2;
    L55:
        Integer r131 = Integer.valueOf(r125);
        if (r131.intValue() <= 0) goto L58;
        boolean r132 = true;
    L59:
        if (r132 == true) goto L62;
        r131 = null;
    L62:
        if (r131 == null) goto L65;
        r129 = r131.intValue();
    L65:
        r126.setLayoutParams(new FrameLayout.LayoutParams(r130, r129));
        setCenterCustomView(r126);
        goto L66
    L58:
        r132 = false;
        goto L59
    L54:
        r130 = r127.intValue();
        goto L55
    L47:
        r128 = false;
        goto L48
    L32:
        if (r114.f403660d > 0) goto L35;
        r117 = false;
        goto L36
    }

    public final void o(OButtonGroup r100, int r110, Function1<? super Integer, Unit> r111) {
        if (r110 != 0) goto L4;
        return;
    L4:
        TypedArray r112 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorDisabled, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetIcon, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialBackground, R.attr.oui_widgetMaterialDisabled, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetPaddingB, R.attr.oui_widgetPaddingL, R.attr.oui_widgetPaddingR, R.attr.oui_widgetPaddingT, R.attr.oui_widgetPressColor, R.attr.oui_widgetPressScale, R.attr.oui_widgetRadius, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowPressed, R.attr.oui_widgetText, R.attr.oui_widgetTextColor, R.attr.oui_widgetTextStyle, R.attr.oui_widgetTintColor});
        int r101 = r112.getColor(0, 0);
        int r102 = r112.getColor(12, 0);
        int r103 = 1;
        int r104 = r112.getColor(1, 0);
        int r105 = r112.getColor(20, 0);
        String r106 = r112.getString(4);
        String r107 = r112.getString(6);
        r112.recycle();
        if (StringsKt.contentEquals(getContext().getString(R.string.oui_material_bg_floating), r106) == true) goto L7;
    L9:
        if (r101 == 0) goto L31;
        if (r106 == null) goto L16;
        if (r104 != 0) goto L14;
        r104 = r101;
    L14:
        r100.p(r101, r104, r106, r107);
        goto L31
    L16:
        if (h0.a(r101) == false) goto L27;
        if (r104 == 0) goto L19;
        int r113 = r104;
    L20:
        int r108 = com.obric.oui.material.d.f401462a;
        com.obric.oui.material.c[] r109 = MaterialToken.OUI_Bg_Floating_Tinted_Light;
        com.obric.oui.material.c[] r114 = com.obric.oui.material.d.a(r109, r101);
        com.obric.oui.material.c[] r115 = com.obric.oui.material.d.a(r109, r104);
        r100.f399144k = r101;
        r100.f399145l = r113;
        r100.q(r114, r115);
        if (h0.b(r101) == false) goto L24;
        r103 = 2;
    L24:
        if (r103 == r100.f399154u) goto L26;
        r100.d(r103);
        goto L31
    L26:
        r100.t(r100.isEnabled());
        goto L31
    L19:
        r113 = r101;
        goto L20
    L27:
        if (r104 != 0) goto L30;
        r104 = r101;
    L30:
        r100.p(r101, r104, null, null);
    L31:
        if (r102 == 0) goto L33;
        r100.setPressColor(r102);
    L33:
        if (r105 == 0) goto L36;
        r111.invoke(Integer.valueOf(r105));
        return;
    L36:
        return;
    L7:
        if (h0.a(r101) == false) goto L9;
        r106 = null;
        goto L9
    }

    public final List<k.a> q(List<k.a> r210, List<? extends View> r211, int r212) {
        List r100 = CollectionsKt.toMutableList(r211);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r210.iterator();
    L4:
        if (r102.hasNext() == false) goto L33;
        k.a r103 = (k.a) r102.next();
        k.b r104 = T(r103, r212);
        Iterator r105 = r100.iterator();
        int r106 = 0;
    L7:
        if (r105.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((View) r105.next()).getTag(), r104) == true) goto L13;
        r106 = r106 + 1;
    L13:
        k.a r107 = null;
        if (r106 < 0) goto L16;
        View r110 = (View) ListProtector.remove(r100, r106);
    L17:
        if (r110 != null) goto L19;
    L21:
        if (r110 != null) goto L23;
    L25:
        boolean r108 = r103.f403634g;
    L26:
        boolean r111 = r108;
        k.a r109 = k.a.a(k.a.a(r103, 0, null, r212, null, false, null, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X), 0, null, 0, null, false, M(r103.f403629b), 127);
        if (r110 == null) goto L30;
        r109 = Y(r109, r110);
    L30:
        r107 = r109.b(r111);
    L31:
        if (r107 == null) goto L4;
        r101.add(r107);
        goto L4
    L23:
        if (this.F == false) goto L25;
        r108 = r110.isEnabled();
        goto L26
    L19:
        if (r110.getVisibility() == 0) goto L21;
    L16:
        r110 = null;
        goto L17
    L12:
        r106 = -1;
        goto L13
    L33:
        return r101;
    }

    public final List<k.a> t(OButtonGroup r310, List<k.a> r311, int r312) {
        if (r310.getVisibility() != 0) goto L5;
        ArrayList r100 = new ArrayList();
        List r101 = CollectionsKt.toMutableList(r311);
        int r102 = r310.getItemCount();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L57;
        int r105 = r104 + 1;
        LinearLayout r106 = r310.D;
        View.OnClickListener r107 = null;
        if (r106 != null) goto L11;
        View r108 = null;
    L12:
        if (r108 == null) goto L56;
        if (r108.getVisibility() != 0) goto L56;
        Object r109 = r108.getTag();
        if ((r109 instanceof k.b) == false) goto L20;
        k.b r110 = (k.b) r109;
    L21:
        if (r110 == null) goto L56;
        Iterator r111 = r101.iterator();
        int r112 = 0;
    L25:
        if (r111.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(T((k.a) r111.next(), r312), r110) == true) goto L32;
        r112 = r112 + 1;
    L32:
        if (this.F == false) goto L34;
        boolean r113 = r108.isEnabled();
    L38:
        if (r112 < 0) goto L40;
        k.a r114 = (k.a) ListProtector.remove(r101, r112);
        r114.getClass();
        r100.add(Y(k.a.a(k.a.a(r114, 0, null, r312, null, false, null, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X), 0, null, 0, null, false, M(r114.f403629b), 127), r108).b(r113));
        goto L56
    L40:
        int r115 = r110.getType();
        if (r115 == 1) goto L54;
        int r116 = 3;
        String r117 = "";
        if (r115 == 3) goto L49;
        int r118 = k.a.f403627i;
        String r119 = r110.f403638c;
        if (r119 == null) goto L48;
        r117 = r119;
    L48:
        Intrinsics.checkNotNullParameter(r117, "text");
        k.a r120 = new k.a(2, r103, r117, r107);
    L55:
        r100.add(Y(k.a.a(k.a.a(k.a.a(r120, 0, r110.f403640e, 0, null, false, null, 247), 0, null, r110.f403639d, null, false, null, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X), 0, null, 0, null, false, r110.f403641f, 127), r108).b(r113));
        goto L56
    L49:
        int r121 = k.a.f403627i;
        String r122 = r110.f403638c;
        if (r122 == null) goto L53;
        r117 = r122;
    L53:
        Intrinsics.checkNotNullParameter(r117, "title");
        r120 = new k.a(r116, r103, r117, r107);
        goto L55
    L54:
        int r123 = k.a.f403627i;
        r120 = k.a.C4681a.a(r110.f403637b, null);
        goto L55
    L34:
        k.a r124 = (k.a) CollectionsKt.getOrNull(r101, r112);
        if (r124 != null) goto L37;
        r113 = true;
        goto L38
    L37:
        r113 = r124.f403634g;
        goto L38
    L30:
        r112 = -1;
        goto L32
    L20:
        r110 = null;
    L56:
        r104 = r105;
        goto L7
    L11:
        r108 = r106.getChildAt(r104);
        goto L12
    L57:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public /* synthetic */ OFloatingTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final View e(OFloatingTitleBar r100, OButtonGroup.d r101, int r102, List r103) {
        r100.getClass();
        Object r104 = r101.f399113a;
        com.obric.oui.titlebar.e r105 = null;
        if ((r104 instanceof k.b) == false) goto L5;
        k.b r106 = (k.b) r104;
    L6:
        if (r106 == null) goto L56;
        Integer r107 = Integer.valueOf(r106.f403639d);
        if (r107.intValue() == 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L15;
        r107 = null;
    L15:
        if (r107 == null) goto L18;
        r102 = r107.intValue();
    L18:
        k.b r109 = k.b.a(r106, 0, r102, 55);
        Iterator r110 = r103.iterator();
    L20:
        if (r110.hasNext() == false) goto L24;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(r100.T((k.a) r111, r102), r109) == false) goto L20;
    L25:
        k.a r112 = (k.a) r111;
        int r113 = r106.getType();
        if (r113 == 1) goto L39;
        String r114 = "";
        if (r113 == 3) goto L34;
        String r115 = r106.f403638c;
        if (r115 == null) goto L33;
        r114 = r115;
    L33:
        View r116 = r100.y(r114, r102);
    L40:
        r116.setTag(r109);
        if (r112 != null) goto L43;
        View.OnClickListener r117 = null;
    L44:
        if (r117 == null) goto L47;
        r105 = new com.obric.oui.titlebar.e(r100, r117);
    L47:
        r116.setOnClickListener(r105);
        if (r112 == null) goto L52;
        r116.setEnabled(r112.f403634g);
    L52:
        return r116;
    L43:
        r117 = r112.f403633f;
        goto L44
    L34:
        String r118 = r106.f403638c;
        if (r118 == null) goto L38;
        r114 = r118;
    L38:
        r116 = r100.z(r114, r102);
        goto L40
    L39:
        r116 = r100.x(r106.f403637b, r102);
        goto L40
    L24:
        r111 = null;
        goto L25
    L11:
        r108 = false;
        goto L12
    L56:
        return null;
    L5:
        r106 = null;
        goto L6
    }

    public final fja.d S(float r100, final float r101, final Function1<? super Float, Unit> r102, final Function0<Unit> r103) {
        com.obric.common.oea.foundation.animation.builder.d.a r104 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r105 = gja.b.a(H0, L0, Token$Delay.OUI_ANIMATION_DELAY_NONE);
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r105.f396390b = 10.0f;
        r104.b(r100, r101, r105, null);
        Function3<String, Object, Object, Unit> r106 = new OFloatingTitleBar$startTranslationXSpring$1(r102, this);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r104.f396382d = r106;
        Function2<Boolean, Throwable, Unit> r107 = new OFloatingTitleBar$startTranslationXSpring$2(r102, r101, this, r103);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r104.f396383e = r107;
        return r104.a().a();
    }

    public final List<View> v(List<k.a> r100, int r101, List<? extends View> r102, boolean r110) {
        List r103 = CollectionsKt.toMutableList(r102);
        List<k.a> r104 = r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L38;
        k.a r107 = (k.a) r106.next();
        k.b r108 = T(r107, r101);
        Iterator r109 = r103.iterator();
        int r111 = 0;
    L7:
        if (r109.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((View) r109.next()).getTag(), r108) == true) goto L13;
        r111 = r111 + 1;
    L13:
        if (r111 < 0) goto L15;
        View r112 = (View) ListProtector.remove(r103, r111);
    L30:
        r112.setTag(r108);
        View.OnClickListener r113 = r107.f403633f;
        if (r113 != null) goto L33;
        com.obric.oui.titlebar.e r114 = null;
    L34:
        r112.setOnClickListener(r114);
        X(r112, r101);
        if (r110 == false) goto L37;
        r112.setEnabled(r107.f403634g);
    L37:
        r105.add(r112);
        goto L4
    L33:
        r114 = new com.obric.oui.titlebar.e(this, r113);
        goto L34
    L15:
        int r115 = r107.getType();
        if (r115 == 1) goto L29;
        String r116 = "";
        if (r115 == 3) goto L24;
        String r117 = r107.f403630c;
        if (r117 == null) goto L23;
        r116 = r117;
    L23:
        r112 = y(r116, r101);
        goto L30
    L24:
        String r118 = r107.f403630c;
        if (r118 == null) goto L28;
        r116 = r118;
    L28:
        r112 = z(r116, r101);
        goto L30
    L29:
        r112 = x(r107.f403629b, r101);
        goto L30
    L12:
        r111 = -1;
        goto L13
    L38:
        return r105;
    }

    public static a V(OFloatingTitleBar r100, List r110, List r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r110 = r100.P.f403642a;
    L5:
        List<k.a> r101 = null;
        if ((r113 & 2) == 0) goto L8;
        List<k.a> r102 = r100.P.f403643b;
    L10:
        if ((r113 & 4) == 0) goto L13;
        r101 = r100.P.f403644c;
    L13:
        if ((r113 & 8) == 0) goto L15;
        r111 = r100.P.f403645d;
    L15:
        r100.getClass();
        k.c r103 = new k.c(r110, r102, r101, r111);
        a r114 = r100.u(r103, false);
        r100.U(r103, r114, r112, true, null, true);
        return r114;
    L8:
        r102 = null;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r110, r111);
        if (D() == true) goto L5;
        return;
    L5:
        int r103 = getMeasuredWidth();
        View r104 = this.f403417p;
        FrameLayout r112 = null;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r104 = null;
    L8:
        int r105 = r104.getPaddingLeft();
        View r113 = this.f403417p;
        if (r113 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r113 = null;
    L11:
        int r114 = r113.getPaddingRight();
        int r106 = getCenterTitleGap();
        if (F() == false) goto L14;
    L17:
        boolean r107 = true;
    L18:
        int r108 = getEndAreaWidthForCenter();
        if (G() == false) goto L24;
        FrameLayout r109 = this.f403401a;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r109 = null;
    L23:
        r105 = (r105 + r109.getMeasuredWidth()) + r106;
    L24:
        int r115 = r103 - r114;
        if (r107 == false) goto L27;
        r115 = (r115 - r108) - r106;
    L27:
        FrameLayout r116 = this.f403406f;
        if (r116 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r116 = null;
    L30:
        int r117 = r116.getMeasuredWidth();
        FrameLayout r118 = this.f403406f;
        if (r118 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r118 = null;
    L33:
        int r119 = r118.getMeasuredHeight();
        int r120 = (r103 - r117) / 2;
        int r121 = r120 + r117;
        int r122 = r115 - r105;
        if (r117 <= r122) goto L36;
        r120 = r105;
    L40:
        r121 = r115;
    L42:
        if (this.V == false) goto L44;
        int r123 = (r122 - r117) / 2;
        r120 = r105 + r123;
        r121 = r115 - r123;
    L44:
        View r124 = this.f403417p;
        if (r124 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r124 = null;
    L47:
        int r125 = r124.getPaddingTop();
        View r126 = this.f403417p;
        if (r126 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r126 = null;
    L50:
        int r127 = r126.getMeasuredHeight();
        View r128 = this.f403417p;
        if (r128 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r128 = null;
    L53:
        int r129 = r125 + ((((r127 - r128.getPaddingBottom()) - r125) - r119) / 2);
        int r130 = r119 + r129;
        FrameLayout r131 = this.f403406f;
        if (r131 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L57:
        r112.layout(r120, r129, r121, r130);
        return;
    L56:
        r112 = r131;
        goto L57
    L36:
        if (r120 >= r105) goto L38;
        r121 = r105 + r117;
        r120 = r105;
        goto L42
    L38:
        if (r121 <= r115) goto L42;
        r120 = r115 - r117;
        goto L40
    L14:
        if (this.E != null) goto L17;
        r107 = false;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v126 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [fja.d, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r1v30, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.obric.oui.button.OButtonGroup] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void U(k.c r410, a r411, boolean r412, boolean r413, final Function0 r414, boolean r415) {
        final boolean r110 = false;
        if (r413 == false) goto L33;
        Function0<Unit> r100 = this.N;
        if (r100 != null) goto L7;
        Unit r101 = null;
    L8:
        if (r101 != null) goto L33;
        if (o.c() == false) goto L33;
        final FloatingTransitionBridge r102 = this.L;
        if (r102 == null) goto L33;
        if (r102.C == true) goto L18;
    L26:
        boolean r103 = false;
    L27:
        if (r103 == false) goto L33;
        Map<IBinder, FloatingTransitionBridge> r104 = FloatingTransitionBridge.H;
        FloatingTransitionBridge.b.b();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L32;
        r102.r(true);
        goto L33
    L32:
        r102.f403538a.post(new com.obric.oui.titlebar.floating.l(r102));
        goto L33
    L18:
        if (r102.f403560w == false) goto L20;
    L25:
        r103 = true;
        goto L27
    L20:
        if (r102.B == true) goto L25;
        if (r102.f403555r == true) goto L25;
        if (r102.f403553p == null) goto L26;
    L7:
        r100.invoke();
        r101 = Unit.INSTANCE;
    L33:
        if (r414 != null) goto L35;
        final Function0<Unit> r111 = null;
    L36:
        c r112 = w(A(getEndSubButtonGroup()), A(getEndButtonGroup()));
        final c r105 = w(r411.f403435c, r411.f403436d);
        int r106 = getMeasuredWidth();
        if (r106 <= 0) goto L69;
        FrameLayout r107 = this.f403406f;
        if (r107 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r107 = null;
    L42:
        Integer r108 = Integer.valueOf(r107.getWidth());
        if (r108.intValue() <= 0) goto L45;
        boolean r109 = true;
    L46:
        if (r109 == true) goto L49;
        r108 = null;
    L49:
        if (r108 != null) goto L54;
        FrameLayout r113 = this.f403406f;
        if (r113 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r113 = null;
    L53:
        int r114 = r113.getMeasuredWidth();
    L55:
        if (r114 <= 0) goto L69;
        int r115 = Math.max(r112.f403440d, r105.f403440d);
        if (r115 <= 0) goto L69;
        int r116 = getCenterTitleGap();
        View r117 = this.f403417p;
        if (r117 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r117 = null;
    L63:
        int r118 = r117.getPaddingLeft();
        View r119 = this.f403417p;
        if (r119 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r119 = null;
    L66:
        int r120 = r106 - r119.getPaddingRight();
        if ((r118 + (((r120 - r118) + r114) / 2)) <= ((r120 - r115) - r116)) goto L69;
        boolean r121 = true;
    L71:
        if (r112.f403440d == r105.f403440d) goto L73;
    L82:
        boolean r122 = true;
    L83:
        if (r121 == false) goto L86;
        CenterAvoidanceMode r123 = CenterAvoidanceMode.TRANSITION;
    L85:
        final CenterAvoidanceMode r124 = r123;
        if (r410 == null) goto L93;
        k.c r125 = this.P;
        List<k.a> r126 = r410.f403642a;
        List<k.a> r127 = r410.f403643b;
        List<k.a> r128 = r410.f403644c;
        List<k.a> r129 = r410.f403645d;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r126, "start");
        Intrinsics.checkNotNullParameter(r127, "center");
        Intrinsics.checkNotNullParameter(r128, "subEnd");
        Intrinsics.checkNotNullParameter(r129, "end");
        r125.f403642a = r126;
        r125.f403643b = r127;
        r125.f403644c = r128;
        r125.f403645d = r129;
    L93:
        if (r410 == null) goto L96;
        List<k.a> r130 = q(r410.f403642a, r411.f403433a, this.f403419q);
        List<k.a> r131 = q(r410.f403643b, r411.f403434b, this.f403420r);
        List<k.a> r132 = q(r410.f403644c, r411.f403435c, this.f403422t);
        List<k.a> r133 = q(r410.f403645d, r411.f403436d, this.f403421s);
        Intrinsics.checkNotNullParameter(r130, "start");
        Intrinsics.checkNotNullParameter(r131, "center");
        Intrinsics.checkNotNullParameter(r132, "subEnd");
        Intrinsics.checkNotNullParameter(r133, "end");
    L96:
        getStartButtonGroup().h0(r411.f403433a, r412);
        getCenterButtonGroup().h0(r411.f403434b, r412);
        final Ref.BooleanRef r134 = new Ref.BooleanRef();
        if (r111 != null) goto L99;
        boolean r135 = true;
    L100:
        r134.element = r135;
        final Ref.BooleanRef r136 = new Ref.BooleanRef();
        if (r111 != null) goto L103;
        boolean r137 = true;
    L104:
        r136.element = r137;
        final Ref.BooleanRef r138 = new Ref.BooleanRef();
        final Function0<Unit> r139 = new OFloatingTitleBar$updateAction$2(r136, r138, r134, r111);
        fja.d r140 = this.B;
        if (r140 != null) goto L107;
        ?? r141 = 0;
        boolean r142 = false;
    L108:
        this.B = r141;
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(r141);
        fja.d r143 = this.C;
        if (r143 == null) goto L112;
        int r144 = fja.d.f477533d;
        r143.a(r142);
    L112:
        this.C = r141;
        this.D++;
        ((ArrayList) getEndSubButtonGroup().Q).clear();
        ((ArrayList) getEndButtonGroup().Q).clear();
        CenterAvoidanceMode r145 = CenterAvoidanceMode.NONE;
        if (r124 != r145) goto L118;
        FrameLayout r146 = this.f403406f;
        if (r146 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r146 = null;
    L117:
        r146.setTranslationX(0.0f);
        Integer r147 = null;
        setFreezeEndAreaWidth(null);
    L119:
        if (r412 == true) goto L130;
        setFreezeEndAreaWidth(r147);
        FrameLayout r148 = this.f403406f;
        if (r148 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r148 = null;
    L123:
        r148.setTranslationX(0.0f);
        getEndSubButtonGroup().setTranslationX(0.0f);
        if (r105.b() == true) goto L126;
    L128:
        boolean r149 = false;
    L129:
        setSubEndToEndGapVisible(r149);
        getEndSubButtonGroup().h0(r105.f403438b, false);
        getEndButtonGroup().h0(r105.f403439c, false);
        r139.invoke();
        r138 = r138;
        r134 = r134;
        ?? r150 = 1;
        char r151 = 0;
        char r310 = 3;
        char r311 = 2;
    L339:
        if (r111 == 0) goto L353;
        final Ref.BooleanRef r152 = r138;
        final Ref.BooleanRef r153 = r134;
        final Function0<Unit> r154 = new OFloatingTitleBar$updateAction$3(r153, r152, r136, r111);
        OButtonGroup[] r155 = new OButtonGroup[4];
        r155[r151] = getStartButtonGroup();
        r155[r150] = getCenterButtonGroup();
        r155[r311] = getEndSubButtonGroup();
        r155[r310] = getEndButtonGroup();
        List r156 = CollectionsKt.listOf(r155);
        ArrayList r157 = new ArrayList();
        Iterator r158 = r156.iterator();
    L342:
        if (r158.hasNext() == false) goto L347;
        Object r159 = r158.next();
        if (((OButtonGroup) r159).Q() == false) goto L342;
        r157.add(r159);
        goto L342
    L347:
        if (r157.isEmpty() == false) goto L349;
        r154.invoke();
        goto L353
    L349:
        final Ref.IntRef r160 = new Ref.IntRef();
        r160.element = r157.size();
        Iterator r161 = r157.iterator();
    L351:
        if (r161.hasNext() == false) goto L353;
        ((OButtonGroup) r161.next()).C(new OFloatingTitleBar$waitForButtonGroupAnimationsEnd$1$1(r160, r154));
    L353:
        m();
        H();
        return;
    L126:
        if (r105.a() == false) goto L128;
        r149 = true;
        goto L129
    L130:
        float r162 = getEndSubButtonGroup().getTranslationX();
        if (r112.b() == true) goto L133;
    L139:
        boolean r163 = false;
    L141:
        if (r112.b() == true) goto L143;
    L149:
        boolean r164 = false;
    L150:
        if (r163 == false) goto L152;
        EndAreaTransitionType r165 = EndAreaTransitionType.SUB_ONLY_TO_BOTH;
    L154:
        c r166 = r112;
    L155:
        final EndAreaTransitionType r210 = r165;
        final int r167 = this.D;
        int[] r168 = e.f403443a;
        int r169 = r168[r210.ordinal()];
        Float r170 = Float.valueOf(0.0f);
        switch(r169) {
            case 1: goto L234;
            case 2: goto L225;
            case 3: goto L210;
            case 4: goto L198;
            case 5: goto L178;
            case 6: goto L177;
            default: goto L176;
        };
    L177:
        Float[] r171 = {null, null};
        r145 = r145;
        int r172 = 1;
    L223:
        Float[] r173 = r171;
    L224:
        char r174 = 0;
    L235:
        Float r175 = r173[r174];
        if (r175 != null) goto L239;
    L245:
        Float r211 = null;
    L246:
        final Float r212 = r173[r172];
        int r176 = r168[r210.ordinal()];
        if (r176 == r172) goto L252;
        int r177 = 2;
        if (r176 == 2) goto L251;
        SubEndShiftEndRawAlphaBinding r178 = SubEndShiftEndRawAlphaBinding.NONE;
    L253:
        final SubEndShiftEndRawAlphaBinding r179 = r178;
        int r180 = e.f403444b[r179.ordinal()];
        if (r180 == r172) goto L262;
        if (r180 != r177) goto L257;
        float[] r181 = new float[r177];
        char r182 = 0;
        r181[0] = getEndButtonGroup().getRawGroupAlphaForTitleBarTransition$OUI_standardRelease();
        char r183 = 1;
        r181[1] = 0.0f;
    L263:
        final float r213 = r181[r182];
        final float r214 = r181[r183];
        if (r166.b() == false) goto L268;
        if (r166.a() == false) goto L268;
    L271:
        boolean r184 = true;
    L273:
        final Ref.IntRef r185 = new Ref.IntRef();
        final Ref.BooleanRef r215 = new Ref.BooleanRef();
        Ref.BooleanRef r186 = new Ref.BooleanRef();
        final Ref.BooleanRef r187 = new Ref.BooleanRef();
        if (r211 == null) goto L277;
        if (r212 != null) goto L277;
        boolean r216 = true;
    L278:
        setSubEndToEndGapVisible(r184);
        CenterAvoidanceMode r188 = CenterAvoidanceMode.TRANSITION;
        if (r124 != r188) goto L281;
        r185.element++;
    L281:
        int r189 = r105.f403440d;
        if (r124 != r188) goto L284;
        final Ref.BooleanRef r416 = r186;
        r310 = 3;
        r311 = 2;
        Function0<Unit> r190 = new OFloatingTitleBar$runEndAreaTransition$1(r185, r416, r167, this, r215, r105, r124, r139);
    L285:
        if (r124 != r145) goto L295;
        FrameLayout r191 = this.f403406f;
        if (r191 != null) goto L289;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r191 = null;
    L289:
        r191.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        K();
        if (r190 == null) goto L309;
        r190.invoke();
    L309:
        if (r179 != SubEndShiftEndRawAlphaBinding.NONE) goto L312;
        boolean r192 = false;
    L319:
        getEndSubButtonGroup().h0(r105.f403438b, true);
        getEndButtonGroup().h0(r105.f403439c, true);
        if (getEndSubButtonGroup().Q() == false) goto L322;
        r185.element++;
        final c r193 = r166;
        final Ref.BooleanRef r194 = r416;
        View r195 = null;
        getEndSubButtonGroup().C(new OFloatingTitleBar$runEndAreaTransition$2(r210, this, r187, r185, r193, r105, r194, r167, r215, r124, r139));
    L324:
        if (getEndButtonGroup().Q() == false) goto L326;
        r185.element++;
        final c r196 = r166;
        final Ref.BooleanRef r197 = r416;
        getEndButtonGroup().C(new OFloatingTitleBar$runEndAreaTransition$3(r210, this, r187, r185, r196, r105, r197, r167, r215, r124, r139));
    L326:
        if (r211 != null) goto L330;
        if (r212 != null) goto L330;
        final CenterAvoidanceMode r198 = r124;
        boolean r199 = true;
        r151 = 0;
    L338:
        r416.element = r199;
        N(r416, r185, r167, this, r215, r105, r198, r139);
        r150 = r199;
    L330:
        if (r192 == true) goto L333;
        if (r216 == true) goto L333;
        r185.element++;
        final Ref.BooleanRef r200 = r187;
        r200.element = true;
    L334:
        final boolean r201 = r192;
        final boolean r202 = r216;
        final Float r203 = r211;
        final c r1100 = r166;
        r198 = r124;
        final Ref.BooleanRef r1101 = r416;
        r151 = 0;
        Function0<Unit> r1102 = new OFloatingTitleBar$runEndAreaTransition$4(r167, this, r200, r201, r202, r203, r212, r210, r185, r1100, r105, r1101, r215, r198, r139);
        View r1103 = this.f403417p;
        if (r1103 != null) goto L337;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r1103 = r195;
    L337:
        ViewTreeObserver r204 = r1103.getViewTreeObserver();
        r204.addOnPreDrawListener(new h(r204, this, r1102));
        r199 = true;
    L333:
        r200 = r187;
        goto L334
    L322:
        r195 = null;
        goto L324
    L312:
        if (r179 != SubEndShiftEndRawAlphaBinding.APPEARING) goto L318;
        OButtonGroup r205 = getEndSubButtonGroup();
        if (r211 != null) goto L316;
        float r206 = 0.0f;
    L317:
        r205.setTranslationX(r206);
        goto L318
    L316:
        r206 = r211.floatValue();
    L318:
        final Float r207 = r211;
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(new OFloatingTitleBar$bindSubEndShiftToEndRawAlphaIfNeeded$1(r167, this, r179, r207, r212, r213, r214));
        r192 = true;
        goto L319
    L295:
        if (r124 != CenterAvoidanceMode.FREEZE) goto L307;
        fja.d r208 = this.C;
        if (r208 != null) goto L299;
        fja.d r209 = null;
    L300:
        this.C = r209;
        FrameLayout r217 = this.f403406f;
        ?? r218 = r217;
        if (r217 != null) goto L303;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r218 = r209;
    L303:
        r218.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        setFreezeEndAreaWidth(Integer.valueOf(r189));
        if (r190 == null) goto L309;
        r190.invoke();
        goto L309
    L299:
        int r219 = fja.d.f477533d;
        r208.a(false);
        r209 = null;
        goto L300
    L307:
        l(r189, r190);
        goto L309
    L284:
        r416 = r186;
        r310 = 3;
        r311 = 2;
        r190 = null;
    L277:
        r216 = false;
    L268:
        if (r105.b() == true) goto L270;
    L272:
        r184 = false;
        goto L273
    L270:
        if (r105.a() == false) goto L272;
    L257:
        if (r180 != 3) goto L260;
        r181 = new float[r177];
        r181 = {x073e: FILL_ARRAY_DATA  (LINE:100665150), data: [1065353216, 1065353216} // fill-array;
        r183 = 1;
        r182 = 0;
        goto L263
    L260:
        throw new NoWhenBranchMatchedException();
    L262:
        r183 = 1;
        r182 = 0;
        r181 = new float[r177];
        r181 = {x0746: FILL_ARRAY_DATA  (LINE:100665158), data: [0, 1065353216} // fill-array;
        goto L263
    L251:
        r178 = SubEndShiftEndRawAlphaBinding.DISAPPEARING;
        goto L253
    L252:
        r177 = 2;
        r178 = SubEndShiftEndRawAlphaBinding.APPEARING;
        goto L253
    L239:
        if (r175.floatValue() != 0.0f) goto L241;
        int r220 = 1;
    L243:
        if ((r220 ^ r172) == 0) goto L245;
        r211 = r175;
        goto L246
    L241:
        r220 = 0;
        goto L243
    L178:
        r173 = new Float[2];
        r145 = r145;
        if (r166.f403437a == EndAreaActionState.BOTH) goto L181;
    L183:
        Float r221 = Float.valueOf(r162);
        if (r221.floatValue() != 0.0f) goto L186;
        boolean r222 = true;
    L188:
        if ((!r222) == true) goto L191;
        r221 = null;
    L191:
        r173[0] = r221;
        if (r166.b() == true) goto L194;
    L196:
        r172 = 1;
    L197:
        r173[r172] = r170;
        goto L224
    L194:
        if (r105.f403437a != EndAreaActionState.END_ONLY) goto L196;
        r172 = 1;
        r170 = null;
        goto L197
    L186:
        r222 = false;
        goto L188
    L181:
        if (r105.f403437a != EndAreaActionState.END_ONLY) goto L183;
        r221 = Float.valueOf(r105.f403441e);
        goto L191
    L198:
        Float[] r223 = new Float[2];
        Float r224 = Float.valueOf(r162);
        if (r224.floatValue() != 0.0f) goto L201;
        boolean r225 = true;
    L203:
        if ((!r225) == true) goto L206;
        r224 = null;
    L206:
        if (r224 != null) goto L208;
        float r226 = r166.f403442f;
    L209:
        r223[0] = Float.valueOf(r226);
        r172 = 1;
        r223[1] = null;
    L222:
        r171 = r223;
        goto L223
    L208:
        r226 = r224.floatValue();
        goto L209
    L201:
        r225 = false;
        goto L203
    L210:
        r223 = new Float[2];
        Float r227 = Float.valueOf(r162);
        if (r227.floatValue() != 0.0f) goto L213;
        boolean r228 = true;
    L215:
        if ((!r228) == true) goto L218;
        r227 = null;
    L218:
        if (r227 != null) goto L220;
        float r229 = r105.f403442f;
    L221:
        r223[0] = Float.valueOf(r229);
        r172 = 1;
        r223[1] = null;
        goto L222
    L220:
        r229 = r227.floatValue();
        goto L221
    L213:
        r228 = false;
        goto L215
    L225:
        r145 = r145;
        r172 = 1;
        r173 = new Float[2];
        Float r230 = Float.valueOf(r162);
        if (r230.floatValue() != 0.0f) goto L228;
        boolean r231 = true;
    L230:
        if ((!r231) == true) goto L233;
        r230 = null;
    L233:
        r174 = 0;
        r173[0] = r230;
        r173[1] = Float.valueOf(r166.f403441e);
        goto L235
    L228:
        r231 = false;
        goto L230
    L234:
        r145 = r145;
        r172 = 1;
        r174 = 0;
        r173 = new Float[]{Float.valueOf(r105.f403441e), r170};
        goto L235
    L176:
        throw new NoWhenBranchMatchedException();
    L152:
        if (r164 == false) goto L156;
        r165 = EndAreaTransitionType.BOTH_TO_SUB_ONLY;
        goto L154
    L156:
        r166 = r112;
        EndAreaActionState r232 = r166.f403437a;
        EndAreaActionState r233 = EndAreaActionState.SUB_ONLY;
        if (r232 != r233) goto L162;
        if (r105.f403437a != EndAreaActionState.END_ONLY) goto L162;
        r165 = EndAreaTransitionType.SUB_ONLY_TO_END_ONLY;
    L162:
        if (r232 != EndAreaActionState.END_ONLY) goto L167;
        if (r105.f403437a != r233) goto L167;
        r165 = EndAreaTransitionType.END_ONLY_TO_SUB_ONLY;
    L167:
        if (r162 != 0.0f) goto L169;
        boolean r234 = true;
    L170:
        if (r234 == true) goto L172;
        r165 = EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN;
        goto L155
    L172:
        r165 = EndAreaTransitionType.NONE_OR_CONTENT_CHANGE;
        goto L155
    L169:
        r234 = false;
        goto L170
    L143:
        if (r105.b() == false) goto L149;
        if (r112.a() == false) goto L149;
        if (r105.a() == true) goto L149;
        r164 = true;
        goto L150
    L133:
        if (r105.b() == false) goto L139;
        if (r112.a() == true) goto L139;
        if (r105.a() == false) goto L139;
        r163 = true;
        goto L141
    L118:
        r147 = null;
        goto L119
    L107:
        int r235 = fja.d.f477533d;
        r142 = false;
        r140.a(false);
        r141 = 0;
        goto L108
    L103:
        r137 = false;
        goto L104
    L99:
        r135 = false;
        goto L100
    L86:
        if (r122 == false) goto L88;
        r123 = CenterAvoidanceMode.FREEZE;
        goto L85
    L88:
        r123 = CenterAvoidanceMode.NONE;
        goto L85
    L73:
        if (r112.f403437a != r105.f403437a) goto L82;
        if (this.E != null) goto L82;
        if (getEndSubButtonGroup().Q() == true) goto L82;
        if (getEndButtonGroup().Q() == true) goto L82;
        r122 = false;
        goto L83
    L54:
        r114 = r108.intValue();
        goto L55
    L45:
        r109 = false;
    L69:
        r121 = false;
        goto L71
    L35:
        r111 = new OFloatingTitleBar$updateAction$transitionEndCallback$1(r414, r110, this);
        goto L36
    }

    public static final void N(Ref.BooleanRef r100, Ref.IntRef r101, int r102, final OFloatingTitleBar r103, Ref.BooleanRef r104, c r105, CenterAvoidanceMode r106, final Function0<Unit> r107) {
        if (r100.element == true) goto L5;
        return;
    L5:
        if (r101.element == 0) goto L7;
        return;
    L7:
        if (r102 == r103.D) goto L10;
        return;
    L10:
        if (r104.element == true) goto L44;
        r104.element = true;
        FrameLayout r108 = null;
        r103.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r105.b() == true) goto L15;
    L17:
        boolean r109 = false;
    L18:
        r103.setSubEndToEndGapVisible(r109);
        r103.getEndSubButtonGroup().setTranslationX(0.0f);
        int r110 = r105.f403440d;
        final Function0<Unit> r111 = new OFloatingTitleBar$runEndAreaTransition$finishTransition$1(r107);
        int r112 = e.f403445c[r106.ordinal()];
        if (r112 != 1) goto L21;
        FrameLayout r113 = r103.f403406f;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L36:
        r108.setTranslationX(0.0f);
        r103.getCenterButtonGroup().setTranslationX(0.0f);
        r103.K();
        r111.invoke();
        return;
    L35:
        r108 = r113;
        goto L36
    L21:
        if (r112 != 2) goto L23;
        r103.K();
        r111.invoke();
        return;
    L23:
        if (r112 != 3) goto L45;
        Integer r114 = r103.E;
        if (r114 != null) goto L28;
    L30:
        r103.K();
        r111.invoke();
        return;
    L28:
        if (r114.intValue() == r110) goto L30;
        r103.l(r110, new OFloatingTitleBar$finishCenterForEndAreaTransition$1(r103, r111));
        return;
    L45:
        return;
    L15:
        if (r105.a() == false) goto L17;
        r109 = true;
        goto L18
    }

    public static final void f(EndAreaTransitionType r100, OFloatingTitleBar r101, Ref.BooleanRef r110, Ref.IntRef r111, c r112, c r113, Ref.BooleanRef r114, int r115, Ref.BooleanRef r116, CenterAvoidanceMode r117, Function0 r118, String r119) {
        boolean r102 = false;
        if (Intrinsics.areEqual(r119, "end") == false) goto L18;
        if (r100 != EndAreaTransitionType.BOTH_TO_SUB_ONLY) goto L7;
    L9:
        r101.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r110.element == false) goto L16;
        r110.element = false;
        fja.d r103 = r101.B;
        if (r103 == null) goto L15;
        int r104 = fja.d.f477533d;
        r103.a(false);
    L15:
        r101.B = null;
        r111.element--;
    L16:
        r101.getEndSubButtonGroup().setTranslationX(0.0f);
    L35:
        r111.element--;
        N(r114, r111, r115, r101, r116, r113, r117, r118);
        return;
    L7:
        if (r100 == EndAreaTransitionType.END_ONLY_TO_SUB_ONLY) goto L9;
    L18:
        if (Intrinsics.areEqual(r119, "subEnd") == false) goto L35;
        if (r100 == EndAreaTransitionType.SUB_ONLY_TO_END_ONLY) goto L30;
        if (r100 != EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN) goto L31;
        if (r112.b() == false) goto L31;
        if (r113.f403437a == EndAreaActionState.END_ONLY) goto L30;
    L31:
        if (r102 == false) goto L35;
        r101.getEndSubButtonGroup().setTranslationX(0.0f);
    L30:
        r102 = true;
        goto L31
    }
}

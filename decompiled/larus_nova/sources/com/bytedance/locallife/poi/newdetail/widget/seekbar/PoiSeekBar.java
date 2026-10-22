package com.bytedance.locallife.poi.newdetail.widget.seekbar;

import android.R;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.Logger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u001bB'\b\u0007\u0012\u0006\u0010v\u001a\u00020u\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010w\u0012\b\b\u0002\u0010y\u001a\u00020\b¢\u0006\u0004\bz\u0010{J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R$\u0010&\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00102\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010?\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00101\u001a\u0004\b?\u00103\"\u0004\b@\u00105R\"\u0010C\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00101\u001a\u0004\bA\u00103\"\u0004\bB\u00105R$\u0010J\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010N\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR$\u0010R\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010E\u001a\u0004\bP\u0010G\"\u0004\bQ\u0010IR$\u0010V\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010E\u001a\u0004\bT\u0010G\"\u0004\bU\u0010IR6\u0010_\u001a\u0016\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010c\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u00101\u001a\u0004\ba\u00103\"\u0004\bb\u00105R\"\u0010g\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u00101\u001a\u0004\be\u00103\"\u0004\bf\u00105R(\u0010k\u001a\u0004\u0018\u00010\u00132\b\u0010h\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bi\u0010\u0015\u001a\u0004\bj\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bl\u0010mR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006|"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/PoiSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "getScale", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "", "setOnSeekBarChangeListener", "", "progress", "setProgress", RemoteMessageConst.Notification.VISIBILITY, "setVisibility", "Landroid/graphics/drawable/Drawable;", "thumb", "setThumb", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/SeekBarState$State;", "state", "setState", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/h;", "getDefaultStyleConfig", "()Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/h;", "setDefaultStyleConfig", "(Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/h;)V", "defaultStyleConfig", "b", "getActiveStyleConfig", "setActiveStyleConfig", "activeStyleConfig", "c", "getDragStyleConfig", "setDragStyleConfig", "dragStyleConfig", "d", "getFrozenStyleConfig", "setFrozenStyleConfig", "frozenStyleConfig", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/j;", "e", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/j;", "getTotalSeekbarConfig", "()Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/j;", "setTotalSeekbarConfig", "(Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/j;)V", "totalSeekbarConfig", "", RXScreenCaptureService.KEY_INDEX, "Z", "isMultiStateStyle", "()Z", "setMultiStateStyle", "(Z)V", "", ce.f26395j, "J", "getDurationOfReset", "()J", "setDurationOfReset", "(J)V", "durationOfReset", ce.f26396k, "isUseAnimation", "setUseAnimation", "getForbidAnchorUpdate", "setForbidAnchorUpdate", "forbidAnchorUpdate", "p", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "thumbDrawable", "q", "getBgDrawable", "setBgDrawable", "bgDrawable", "r", "getProDrawable", "setProDrawable", "proDrawable", "s", "getSecondProDrawable", "setSecondProDrawable", "secondProDrawable", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "C", "Lkotlin/jvm/functions/Function2;", "getMapper", "()Lkotlin/jvm/functions/Function2;", "setMapper", "(Lkotlin/jvm/functions/Function2;)V", "mapper", "D", "getEnableTimeOut", "setEnableTimeOut", "enableTimeOut", ExifInterface.LONGITUDE_EAST, "getResumeByDragRelease", "setResumeByDragRelease", "resumeByDragRelease", "<set-?>", FaceService.girlLabel, "getMCurrentSeekbarConfig", "mCurrentSeekbarConfig", "getState", "()Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/SeekBarState$State;", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/PoiSeekBar$b;", "onVisibilityChangeListener", "Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/PoiSeekBar$b;", "getOnVisibilityChangeListener", "()Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/PoiSeekBar$b;", "setOnVisibilityChangeListener", "(Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/PoiSeekBar$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiSeekBar extends AppCompatSeekBar {
    public boolean A;
    public final com.bytedance.locallife.poi.newdetail.widget.seekbar.e B;
    public Function2<? super MotionEvent, ? super Float, Integer> C;
    public boolean D;
    public boolean E;
    public h F;
    public final SeekBarState G;
    public final e H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f263440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f263441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f263442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f263443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f263444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f263445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f263446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f263447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f263448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f263449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f263450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f263451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f263452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f263453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LayerDrawable f263454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f263455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f263456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f263457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f263458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f263459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f263460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f263461v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f263462w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f263463x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f263464y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.locallife.poi.newdetail.widget.seekbar.d f263465z;

    public static final class a {
    }

    public interface b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f263466a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f263467b = null;

        static {
            int[] r100 = new int[SeekBarState.Action.values().length];
            r100[SeekBarState.Action.VIDEO_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[SeekBarState.Action.RENDER_FIRST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r100[SeekBarState.Action.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[SeekBarState.Action.TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[SeekBarState.Action.PAUSE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r100[SeekBarState.Action.SEARCH_SEEK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r100[SeekBarState.Action.RELEASE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            f263466a = r100;
            int[] r101 = new int[SeekBarState.State.values().length];
            r101[SeekBarState.State.FROZEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r101[SeekBarState.State.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r101[SeekBarState.State.ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r101[SeekBarState.State.DRAGGING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            f263467b = r101;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f263468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f263469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PoiSeekBar f263470c;

        public d(h r100, h r101, PoiSeekBar r102) {
            this.f263468a = r100;
            this.f263469b = r101;
            this.f263470c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r210) {
            Intrinsics.checkNotNullParameter(r210, "it");
            Lazy r100 = PoiSeekbarConfigHolder.f263472a;
            h r101 = this.f263468a;
            h r102 = this.f263469b;
            Object r103 = r210.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            float r104 = ((Float) r103).floatValue();
            Intrinsics.checkNotNullParameter(r101, "start");
            Intrinsics.checkNotNullParameter(r102, "end");
            PoiSeekbarConfigHolder.a(r101);
            PoiSeekbarConfigHolder.a(r102);
            if (r104 < 1.0f) goto L6;
            boolean r105 = r102.f263497b.f263486c;
        L12:
            long r106 = r102.f263501f.f263482a;
            int r110 = r101.f263502g;
            int r111 = r110 + ((int) ((r102.f263502g - r110) * r104));
            int r112 = r101.f263505j;
            int r113 = r112 + ((int) ((r102.f263505j - r112) * r104));
            int r114 = r101.f263506k;
            int r115 = r114 + ((int) ((r102.f263506k - r114) * r104));
            int r116 = r101.f263503h;
            int r117 = r116 + ((int) ((r102.f263503h - r116) * r104));
            int r118 = r101.f263504i;
            int r119 = r118 + ((int) ((r102.f263504i - r118) * r104));
            int r107 = r101.f263497b.f263484a;
            int r108 = r107 + ((int) ((r102.f263497b.f263484a - r107) * r104));
            Lazy r109 = PoiSeekbarConfigHolder.f263473b;
            Object r120 = ((ArgbEvaluator) r109.getValue()).evaluate(r104, Integer.valueOf(r101.f263497b.f263485b), Integer.valueOf(r102.f263497b.f263485b));
            if ((r120 instanceof Integer) == false) goto L15;
            Integer r121 = (Integer) r120;
        L16:
            if (r121 == null) goto L18;
            int r122 = r121.intValue();
        L19:
            Drawable r123 = r102.f263497b.f263487d;
            int r124 = r101.f263498c.f263490a;
            int r125 = r124 + ((int) ((r102.f263498c.f263490a - r124) * r104));
            boolean r211 = r105;
            Object r126 = ((ArgbEvaluator) r109.getValue()).evaluate(r104, Integer.valueOf(r101.f263498c.f263491b), Integer.valueOf(r102.f263498c.f263491b));
            if ((r126 instanceof Integer) == false) goto L22;
            Integer r127 = (Integer) r126;
        L23:
            if (r127 == null) goto L25;
            int r128 = r127.intValue();
        L26:
            Drawable r129 = r102.f263498c.f263492c;
            int r130 = r101.f263499d.f263493a;
            int r131 = r130 + ((int) ((r102.f263499d.f263493a - r130) * r104));
            int r212 = r128;
            Object r132 = ((ArgbEvaluator) r109.getValue()).evaluate(r104, Integer.valueOf(r101.f263499d.f263494b), Integer.valueOf(r102.f263499d.f263494b));
            if ((r132 instanceof Integer) == false) goto L29;
            Integer r133 = (Integer) r132;
        L30:
            if (r133 == null) goto L32;
            int r134 = r133.intValue();
        L33:
            Drawable r135 = r102.f263499d.f263495c;
            int r136 = r101.f263500e.f263510d;
            int r137 = r136 + ((int) ((r102.f263500e.f263510d - r136) * r104));
            Object r138 = ((ArgbEvaluator) r109.getValue()).evaluate(r104, Integer.valueOf(r101.f263500e.f263511e), Integer.valueOf(r102.f263500e.f263511e));
            if ((r138 instanceof Integer) == false) goto L36;
            Integer r139 = (Integer) r138;
        L37:
            if (r139 == null) goto L39;
            int r140 = r139.intValue();
        L40:
            i r141 = r101.f263500e;
            int r142 = r141.f263507a;
            i r143 = r102.f263500e;
            int r144 = r142 + ((int) ((r143.f263507a - r142) * r104));
            int r145 = r141.f263508b;
            int r146 = r140;
            int r147 = r145 + ((int) ((r143.f263508b - r145) * r104));
            int r148 = r141.f263509c;
            int r149 = r148 + ((int) ((r143.f263509c - r148) * r104));
            Drawable r150 = r143.f263512f;
            h r151 = new h();
            r151.f263502g = r111;
            r151.f263505j = r113;
            r151.f263506k = r115;
            r151.f263503h = r117;
            r151.f263504i = r119;
            com.bytedance.locallife.poi.newdetail.widget.seekbar.a r152 = new com.bytedance.locallife.poi.newdetail.widget.seekbar.a();
            r152.f263482a = r106;
            Intrinsics.checkNotNullParameter(r152, "<set-?>");
            r151.f263501f = r152;
            com.bytedance.locallife.poi.newdetail.widget.seekbar.b r153 = new com.bytedance.locallife.poi.newdetail.widget.seekbar.b();
            r153.f263485b = r122;
            r153.f263484a = r108;
            r153.f263486c = r211;
            r153.f263487d = r123;
            Intrinsics.checkNotNullParameter(r153, "<set-?>");
            r151.f263497b = r153;
            f r154 = new f();
            r154.f263491b = r212;
            r154.f263490a = r125;
            r154.f263492c = r129;
            Intrinsics.checkNotNullParameter(r154, "<set-?>");
            r151.f263498c = r154;
            g r155 = new g();
            r155.f263494b = r134;
            r155.f263493a = r131;
            r155.f263495c = r135;
            Intrinsics.checkNotNullParameter(r155, "<set-?>");
            r151.f263499d = r155;
            i r156 = new i();
            r156.f263507a = r144;
            r156.f263508b = r147;
            r156.f263509c = r149;
            r156.f263510d = r137;
            r156.f263511e = r146;
            r156.f263512f = r150;
            Intrinsics.checkNotNullParameter(r156, "<set-?>");
            r151.f263500e = r156;
            r151.f263501f.getClass();
            PoiSeekBar r157 = this.f263470c;
            h r158 = this.f263469b;
            r157.b(r151);
            Object r159 = r210.getAnimatedValue();
            Intrinsics.checkNotNull(r159, "null cannot be cast to non-null type kotlin.Float");
            if (((Float) r159).floatValue() < 1.0f) goto L43;
            r151 = r158;
        L43:
            r157.F = r151;
            return;
        L39:
            r140 = 0;
            goto L40
        L36:
            r139 = null;
            goto L37
        L32:
            r134 = 0;
            goto L33
        L29:
            r133 = null;
            goto L30
        L25:
            r128 = 0;
            goto L26
        L22:
            r127 = null;
            goto L23
        L18:
            r122 = 0;
            goto L19
        L15:
            r121 = null;
            goto L16
        L6:
            if (r101.f263497b.f263486c == false) goto L8;
        L11:
            r105 = true;
            goto L12
        L8:
            if (r102.f263497b.f263486c == true) goto L11;
            r105 = false;
            goto L12
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiSeekBar f263471a;

        public e(PoiSeekBar r100) {
            this.f263471a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f263471a.d(SeekBarState.Action.TIMEOUT);     // Catch: Throwable -> L4
            this.f263471a.setResumeByDragRelease(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public PoiSeekBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiSeekBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final b getOnVisibilityChangeListener() {
        return null;
    }

    public final void setOnVisibilityChangeListener(b r100) {
    }

    public final void g() {
        if (this.f263460u == true) goto L6;
        return;
    L6:
        if (isEnabled() == true) goto L9;
        return;
    L9:
        if (getVisibility() == 0) goto L11;
        return;
    L11:
        this.f263465z.onStopTrackingTouch(this);
        this.f263460u = false;
        if (this.f263448i == false) goto L17;
        d(SeekBarState.Action.RELEASE);
        if (this.D == false) goto L18;
        removeCallbacks(this.H);
        postDelayed(this.H, this.f263449j);
        return;
    L18:
        return;
    }

    public final h getActiveStyleConfig() {
        if (this.f263441b != null) goto L6;
        this.f263441b = PoiSeekbarConfigHolder.b();
    L6:
        return this.f263441b;
    }

    public final h getDefaultStyleConfig() {
        if (this.f263440a != null) goto L6;
        Lazy r100 = PoiSeekbarConfigHolder.f263472a;
        this.f263440a = new h();
    L6:
        return this.f263440a;
    }

    public final h getDragStyleConfig() {
        if (this.f263442c != null) goto L6;
        this.f263442c = PoiSeekbarConfigHolder.c();
    L6:
        return this.f263442c;
    }

    public final h getFrozenStyleConfig() {
        if (this.f263443d != null) goto L34;
        Lazy r100 = PoiSeekbarConfigHolder.f263472a;
        h r101 = new h();
        com.bytedance.locallife.poi.newdetail.widget.seekbar.b r102 = r101.f263497b;
        if (r102 == null) goto L9;
        r102.f263484a = 20;
    L9:
        if (r102 == null) goto L12;
        r102.f263485b = -1;
    L12:
        i r103 = r101.f263500e;
        if (r103 == null) goto L16;
        r103.f263511e = 0;
    L16:
        if (r103 == null) goto L19;
        r103.f263507a = 0;
    L19:
        if (r103 == null) goto L22;
        r103.f263508b = 0;
    L22:
        if (r103 == null) goto L25;
        r103.f263509c = 0;
    L25:
        f r104 = r101.f263498c;
        if (r104 == null) goto L29;
        r104.f263490a = 51;
    L29:
        if (r104 == null) goto L32;
        r104.f263491b = -1;
    L32:
        r101.f263502g = PoiSeekbarConfigHolder.f263474c;
        this.f263443d = r101;
    L34:
        return this.f263443d;
    }

    public final SeekBarState.State getState() {
        return this.G.f263476b;
    }

    private final float getScale() {
        int r100 = getMax();
        if (r100 > 0) goto L7;
        return 0.0f;
    L7:
        return getProgress() / r100;
    }

    public final Drawable getBgDrawable() {
        return this.f263456q;
    }

    public final long getDurationOfReset() {
        return this.f263449j;
    }

    public final boolean getEnableTimeOut() {
        return this.D;
    }

    public final boolean getForbidAnchorUpdate() {
        return this.f263451l;
    }

    public final h getMCurrentSeekbarConfig() {
        return this.F;
    }

    public final Function2<MotionEvent, Float, Integer> getMapper() {
        return this.C;
    }

    public final Drawable getProDrawable() {
        return this.f263457r;
    }

    public final boolean getResumeByDragRelease() {
        return this.E;
    }

    public final Drawable getSecondProDrawable() {
        return this.f263458s;
    }

    public final Drawable getThumbDrawable() {
        return this.f263455p;
    }

    public final j getTotalSeekbarConfig() {
        return this.f263444e;
    }

    public final void a(SeekBar.OnSeekBarChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.locallife.poi.newdetail.widget.seekbar.d r101 = this.f263465z;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) r101.f263488a).contains(r100) == true) goto L6;
        ((ArrayList) r101.f263488a).add(r100);
        return;
    }

    public final void b(h r110) {
        this.F = r110;
        if (r110 != null) goto L6;
    L9:
        GradientDrawable r100 = null;
        if (r110 == null) goto L12;
        com.bytedance.locallife.poi.newdetail.widget.seekbar.b r101 = r110.f263497b;
    L13:
        int r102 = 255;
        int r103 = 0;
        if (r101 == null) goto L43;
        Drawable r104 = r101.f263487d;
        if (r104 == null) goto L21;
        LayerDrawable r105 = this.f263454o;
        if (r105 == null) goto L43;
        r105.setDrawableByLayerId(this.f263447h, r104);
        goto L43
    L21:
        LayerDrawable r106 = this.f263454o;
        if (r106 == null) goto L43;
        int r107 = r106.getNumberOfLayers();
        int r108 = 0;
    L24:
        if (r108 >= r107) goto L43;
        if (r106.getId(r108) != this.f263447h) goto L42;
        Drawable r109 = r106.getDrawable(r108);
        if ((r109 instanceof GradientDrawable) == false) goto L30;
        GradientDrawable r111 = (GradientDrawable) r109;
    L31:
        if (r111 == null) goto L42;
        if (r101.f263486c == false) goto L35;
        int r112 = 2;
    L36:
        r111.setStroke(r112, 352321535);
        int r113 = r101.f263484a;
        int r114 = r101.f263485b;
        int r115 = Color.alpha(r114);
        int r116 = Color.red(r114);
        int r117 = Color.green(r114);
        int r118 = Color.blue(r114);
        if (r113 >= 0) goto L39;
        r101.f263484a = r115;
        r111.setColor(Color.argb(r115, r116, r117, r118));
        goto L42
    L39:
        if (r113 <= 255) goto L41;
        r113 = 255;
    L41:
        r111.setColor(Color.argb(r113, r116, r117, r118));
        goto L42
    L35:
        r112 = 0;
        goto L36
    L30:
        r111 = null;
    L42:
        r108 = r108 + 1;
    L43:
        if (r110 == null) goto L45;
        f r119 = r110.f263498c;
    L46:
        if (r119 == null) goto L77;
        Drawable r120 = r119.f263492c;
        if (r120 == null) goto L59;
        LayerDrawable r121 = this.f263454o;
        if (r121 == null) goto L55;
        Drawable r122 = r121.getDrawable(2);
        if (r122 == null) goto L55;
        int r123 = r122.getLevel();
    L56:
        LayerDrawable r124 = this.f263454o;
        if (r124 == null) goto L77;
        int r125 = this.f263445f;
        r120.setLevel(r123);
        Unit r126 = Unit.INSTANCE;
        r124.setDrawableByLayerId(r125, r120);
    L55:
        r123 = 0;
        goto L56
    L59:
        LayerDrawable r127 = this.f263454o;
        if (r127 == null) goto L77;
        int r128 = r127.getNumberOfLayers();
        int r129 = 0;
    L62:
        if (r129 >= r128) goto L77;
        if (r127.getId(r129) != this.f263445f) goto L76;
        Drawable r130 = r127.getDrawable(r129);
        if ((r130 instanceof ClipDrawable) == false) goto L68;
        ClipDrawable r131 = (ClipDrawable) r130;
    L69:
        if (r131 == null) goto L76;
        int r132 = r119.f263490a;
        int r133 = r119.f263491b;
        int r134 = Color.alpha(r133);
        int r135 = Color.red(r133);
        int r136 = Color.green(r133);
        int r137 = Color.blue(r133);
        if (r132 >= 0) goto L73;
        r119.f263490a = r134;
        r131.setColorFilter(Color.argb(r134, r135, r136, r137), PorterDuff.Mode.SRC);
        goto L76
    L73:
        if (r132 <= 255) goto L75;
        r132 = 255;
    L75:
        r131.setColorFilter(Color.argb(r132, r135, r136, r137), PorterDuff.Mode.SRC);
        goto L76
    L68:
        r131 = null;
    L76:
        r129 = r129 + 1;
    L77:
        if (r110 == null) goto L79;
        g r138 = r110.f263499d;
    L80:
        if (r138 == null) goto L110;
        Drawable r139 = r138.f263495c;
        if (r139 == null) goto L92;
        LayerDrawable r140 = this.f263454o;
        if (r140 == null) goto L89;
        Drawable r141 = r140.getDrawable(1);
        if (r141 == null) goto L89;
        r103 = r141.getLevel();
    L89:
        LayerDrawable r142 = this.f263454o;
        if (r142 == null) goto L110;
        int r143 = this.f263446g;
        r139.setLevel(r103);
        Unit r144 = Unit.INSTANCE;
        r142.setDrawableByLayerId(r143, r139);
        goto L110
    L92:
        LayerDrawable r145 = this.f263454o;
        if (r145 == null) goto L110;
        int r146 = r145.getNumberOfLayers();
    L95:
        if (r103 >= r146) goto L110;
        if (r145.getId(r103) != this.f263446g) goto L109;
        Drawable r147 = r145.getDrawable(r103);
        if ((r147 instanceof ClipDrawable) == false) goto L101;
        ClipDrawable r148 = (ClipDrawable) r147;
    L102:
        if (r148 == null) goto L109;
        int r149 = r138.f263493a;
        int r150 = r138.f263494b;
        int r151 = Color.alpha(r150);
        int r152 = Color.red(r150);
        int r153 = Color.green(r150);
        int r154 = Color.blue(r150);
        if (r149 >= 0) goto L106;
        r138.f263493a = r151;
        r148.setColorFilter(Color.argb(r151, r152, r153, r154), PorterDuff.Mode.SRC);
        goto L109
    L106:
        if (r149 <= 255) goto L108;
        r149 = 255;
    L108:
        r148.setColorFilter(Color.argb(r149, r152, r153, r154), PorterDuff.Mode.SRC);
        goto L109
    L101:
        r148 = null;
    L109:
        r103 = r103 + 1;
    L110:
        if (r110 == null) goto L112;
        i r155 = r110.f263500e;
    L113:
        if (r155 == null) goto L132;
        Drawable r156 = r155.f263512f;
        if (r156 != null) goto L118;
        Drawable r157 = this.f263455p;
        if ((r157 instanceof GradientDrawable) == false) goto L124;
        r100 = (GradientDrawable) r157;
    L124:
        if (r100 == null) goto L132;
        r100.setSize(r155.f263507a, r155.f263508b);
        r100.setCornerRadius(r155.f263509c);
        int r158 = r155.f263510d;
        int r159 = r155.f263511e;
        int r160 = Color.alpha(r159);
        int r161 = Color.red(r159);
        int r162 = Color.green(r159);
        int r163 = Color.blue(r159);
        if (r158 >= 0) goto L128;
        r155.f263510d = r160;
        r100.setColor(Color.argb(r160, r161, r162, r163));
        goto L132
    L128:
        if (r158 > 255) goto L131;
        r102 = r158;
    L131:
        r100.setColor(Color.argb(r102, r161, r162, r163));
        goto L132
    L118:
        if ((r156 instanceof GradientDrawable) == false) goto L120;
        GradientDrawable r164 = (GradientDrawable) r156;
        r164.setSize(r155.f263507a, r155.f263508b);
        r164.setCornerRadius(r155.f263509c);
    L120:
        this.f263455p = r156;
    L132:
        setProgressDrawable(this.f263454o);
        setThumb(this.f263455p);
        requestLayout();
        return;
    L112:
        r155 = null;
        goto L113
    L79:
        r138 = null;
        goto L80
    L45:
        r119 = null;
        goto L46
    L12:
        r101 = null;
        goto L13
    L6:
        if (getDefaultStyleConfig() == null) goto L9;
        ViewGroup.LayoutParams r165 = getLayoutParams();
        int r166 = r110.f263502g;
        int r167 = r110.f263503h;
        int r168 = r110.f263504i;
        r165.height = (r166 + r167) + r168;
        setPadding(r110.f263505j, r167, r110.f263506k, r168);
        goto L9
    }

    public final void c(SeekBarState.State r100) {
        int r101 = c.f263467b[r100.ordinal()];
        if (r101 != 1) goto L5;
        b(getFrozenStyleConfig());
        return;
    L5:
        if (r101 != 2) goto L7;
        Logger.d("OSeekBar", "enterPlayShowMode: ");
        b(getDefaultStyleConfig());
        return;
    L7:
        if (r101 != 3) goto L9;
        Logger.d("OSeekBar", "enterPauseShowMode: ");
        b(getActiveStyleConfig());
        return;
    L9:
        if (r101 != 4) goto L19;
        Logger.d("OSeekBar", "enterDragMode: ");
        b(getDragStyleConfig());
        return;
    }

    public final void d(SeekBarState.Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        SeekBarState r101 = this.G;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        SeekBarState.State r102 = r101.f263476b;
        switch(SeekBarState.a.f263481b[r100.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L22;
            case 7: goto L18;
            case 8: goto L14;
            case 9: goto L10;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        SeekBarState.State r103 = r101.f263476b;
        if (SeekBarState.a.f263480a[r103.ordinal()] != 1) goto L9;
        SeekBarState.State r104 = SeekBarState.State.ACTIVE;
    L37:
        r101.f263476b = r104;
        if (r102 == r104) goto L40;
    L43:
        r101.f263477c = r102;
        r101.f263475a.invoke(r104, r100);
        return;
    L40:
        if (r100 == SeekBarState.Action.VIDEO_CHANGE) goto L43;
        if (r100 == SeekBarState.Action.PAUSE) goto L43;
        return;
    L9:
        r104 = r101.f263476b;
        goto L37
    L10:
        SeekBarState.State r105 = r101.f263476b;
        if (SeekBarState.a.f263480a[r105.ordinal()] != 2) goto L13;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L13:
        r104 = r101.f263476b;
        goto L37
    L14:
        SeekBarState.State r106 = r101.f263476b;
        if (SeekBarState.a.f263480a[r106.ordinal()] != 2) goto L17;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L17:
        r104 = r101.f263476b;
        goto L37
    L18:
        SeekBarState.State r107 = r101.f263476b;
        if (SeekBarState.a.f263480a[r107.ordinal()] != 3) goto L21;
        r104 = SeekBarState.State.ACTIVE;
        goto L37
    L21:
        r104 = SeekBarState.State.ACTIVE;
        goto L37
    L22:
        SeekBarState.State r108 = r101.f263476b;
        int r109 = SeekBarState.a.f263480a[r108.ordinal()];
        if (r109 == 1) goto L26;
        if (r109 == 2) goto L26;
        r104 = r101.f263476b;
    L26:
        r104 = SeekBarState.State.DRAGGING;
        goto L37
    L27:
        SeekBarState.State r110 = r101.f263476b;
        if (SeekBarState.a.f263480a[r110.ordinal()] != 2) goto L30;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L30:
        r104 = r101.f263476b;
        goto L37
    L31:
        SeekBarState.State r111 = r101.f263476b;
        if (SeekBarState.a.f263480a[r111.ordinal()] != 1) goto L34;
        r104 = SeekBarState.State.ACTIVE;
        goto L37
    L34:
        r104 = r101.f263476b;
        goto L37
    L35:
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L36:
        r104 = SeekBarState.State.FROZEN;
        goto L37
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(h r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setDuration(r100.f263501f.f263482a);
        TimeInterpolator r102 = r100.f263501f.f263483b;
        if (r102 != null) goto L8;
        Lazy r103 = PoiSeekbarConfigHolder.f263472a;
        r102 = (vl4.b) PoiSeekbarConfigHolder.f263472a.getValue();
    L8:
        r101.setInterpolator(r102);
        h r104 = this.F;
        if (r104 == null) goto L11;
        r101.addUpdateListener(new d(r104.a(), r100, this));
        r101.start();
    L11:
        this.f263459t = r101;
    }

    public final boolean f(MotionEvent r100) {
        float r101 = r100.getRawX();
        float r102 = r100.getRawY();
        int[] r103 = new int[2];
        getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = getMeasuredWidth() + r104;
        int r107 = getMeasuredHeight() + r105;
        if (r101 > r104) goto L5;
        return false;
    L5:
        if (r101 < r106) goto L7;
        return false;
    L7:
        if (r102 > r105) goto L9;
        return false;
    L9:
        if (r102 >= r107) goto L15;
        return true;
    L15:
        return false;
    }

    public final void h(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Float.isNaN(r100.getX()) == false) goto L5;
        return;
    L5:
        if (Float.isNaN(r100.getY()) == true) goto L30;
        float r101 = MathKt.roundToInt(r100.getX());
        float r102 = MathKt.roundToInt(r100.getY());
        Drawable r103 = getBackground();
        if (r103 == null) goto L10;
        r103.setHotspot(r101, r102);
    L10:
        Intrinsics.checkNotNullParameter(r100, "event");
        Function2<? super MotionEvent, ? super Float, Integer> r104 = this.C;
        int r105 = 0;
        Float r106 = null;
        if (r104 == null) goto L21;
        Integer r107 = Integer.valueOf(r104.invoke(r100, Float.valueOf(this.f263463x)).intValue());
        if (r107.intValue() < 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L19;
        r107 = null;
    L19:
        if (r107 == null) goto L21;
        int r109 = r107.intValue();
    L27:
        setProgress(r109);
        return;
    L15:
        r108 = false;
    L21:
        Float r110 = Float.valueOf(((this.f263463x / ((getWidth() - getPaddingLeft()) - getPaddingRight())) * getMax()) + getProgress());
        if ((!Float.isNaN(r110.floatValue())) == false) goto L24;
        r106 = r110;
    L24:
        if (r106 == null) goto L26;
        r105 = MathKt.roundToInt(r106.floatValue());
    L26:
        r109 = r105;
        goto L27
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.f263453n == true) goto L6;
        return false;
    L6:
        if (isEnabled() == false) goto L64;
        if (r100 == null) goto L64;
        this.f263463x = r100.getX() - this.f263462w;
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L12;
        this.f263461v = r100.getX();
        this.f263452m = f(r100);
    L62:
        this.f263462w = r100.getX();
        return true;
    L12:
        if (r102 != 1) goto L14;
        this.f263461v = -1.0f;
        if (this.f263460u == false) goto L54;
        h(r100);
        g();
        setPressed(false);
    L60:
        invalidate();
        goto L62
    L54:
        if (this.f263451l == true) goto L60;
        if (this.f263452m == false) goto L60;
        if (f(r100) == false) goto L60;
        super.onTouchEvent(r100);
        goto L60
    L14:
        if (r102 == 2) goto L23;
        if (r102 != 3) goto L62;
        this.f263461v = -1.0f;
        if (this.f263460u == false) goto L21;
        g();
        setPressed(false);
    L21:
        invalidate();
        goto L62
    L23:
        if (this.f263460u == false) goto L26;
        h(r100);
        goto L62
    L26:
        if (Math.abs(r100.getX() - this.f263461v) <= this.f263464y) goto L62;
        if (this.f263461v != (-1.0f)) goto L30;
        r101 = true;
    L30:
        if (r101 == true) goto L62;
        setPressed(true);
        if (getThumb() == null) goto L35;
        invalidate(getThumb().getBounds());
    L35:
        if (this.f263460u == false) goto L38;
    L47:
        h(r100);
        if (getParent() == null) goto L62;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L62
    L38:
        if (isEnabled() == false) goto L47;
        if (getVisibility() != 0) goto L47;
        this.f263460u = true;
        if (this.f263448i == false) goto L46;
        removeCallbacks(this.H);
        d(SeekBarState.Action.DRAG);
    L46:
        this.f263465z.onStartTrackingTouch(this);
    L64:
        return false;
    }

    public final void setActiveStyleConfig(h r100) {
        this.f263441b = r100;
    }

    public final void setBgDrawable(Drawable r100) {
        this.f263456q = r100;
    }

    public final void setDefaultStyleConfig(h r100) {
        this.f263440a = r100;
    }

    public final void setDragStyleConfig(h r100) {
        this.f263442c = r100;
    }

    public final void setDurationOfReset(long r100) {
        this.f263449j = r100;
    }

    public final void setEnableTimeOut(boolean r100) {
        this.D = r100;
    }

    public final void setForbidAnchorUpdate(boolean r100) {
        this.f263451l = r100;
    }

    public final void setFrozenStyleConfig(h r100) {
        this.f263443d = r100;
    }

    public final void setMapper(Function2<? super MotionEvent, ? super Float, Integer> r100) {
        this.C = r100;
    }

    public final void setMultiStateStyle(boolean r100) {
        this.f263448i = r100;
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        if (this.A == true) goto L6;
        super.setOnSeekBarChangeListener(r100);
        this.A = true;
        return;
    L6:
        if (r100 == null) goto L9;
        a(r100);
        return;
    }

    public final void setProDrawable(Drawable r100) {
        this.f263457r = r100;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        j r101 = this.f263444e;
        super.setProgress(r100);
    }

    public final void setResumeByDragRelease(boolean r100) {
        this.E = r100;
    }

    public final void setSecondProDrawable(Drawable r100) {
        this.f263458s = r100;
    }

    public final void setState(SeekBarState.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        SeekBarState r101 = this.G;
        SeekBarState.State r102 = r101.f263476b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f263477c = r102;
        SeekBarState r103 = this.G;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r103.f263476b = r100;
        c(r100);
        this.B.a(this.G.f263477c, r100, null);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable r100) {
        super.setThumb(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        i(getWidth(), getHeight());
        return;
    }

    public final void setThumbDrawable(Drawable r100) {
        this.f263455p = r100;
    }

    public final void setTotalSeekbarConfig(j r100) {
        this.f263444e = r100;
    }

    public final void setUseAnimation(boolean r100) {
        this.f263450k = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        getVisibility();
        super.setVisibility(r100);
    }

    public final void i(int r100, int r101) {
        int r102 = (r101 - getPaddingTop()) - getPaddingBottom();
        Drawable r103 = getProgressDrawable();
        Drawable r104 = getThumb();
        if (r104 == null) goto L5;
        int r105 = r104.getIntrinsicHeight();
    L6:
        if (r105 <= r102) goto L8;
        int r106 = (r102 - r105) / 2;
        int r107 = ((r105 - r102) / 2) + r106;
    L9:
        if (r103 == null) goto L11;
        r103.setBounds(0, r107, (r100 - getPaddingRight()) - getPaddingLeft(), r102 + r107);
    L11:
        if (r104 == null) goto L18;
        getScale();
        int r108 = r104.getIntrinsicHeight();
        if (r106 != Integer.MIN_VALUE) goto L15;
        Rect r109 = r104.getBounds();
        r106 = r109.top;
        int r110 = r109.bottom;
    L16:
        r104.setBounds(r104.getBounds().left, r106, r104.getBounds().right, r110);
        return;
    L15:
        r110 = r108 + r106;
        goto L16
    L18:
        return;
    L8:
        int r111 = (r102 - r102) / 2;
        r106 = ((r102 - r105) / 2) + r111;
        r107 = r111;
        goto L9
    L5:
        r105 = 0;
        goto L6
    }

    public PoiSeekBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263445f = R.id.progress;
        this.f263446g = R.id.secondaryProgress;
        this.f263447h = R.id.background;
        this.f263448i = true;
        this.f263449j = 2000;
        this.f263450k = true;
        this.f263453n = true;
        this.f263461v = -1.0f;
        com.bytedance.locallife.poi.newdetail.widget.seekbar.d r103 = new com.bytedance.locallife.poi.newdetail.widget.seekbar.d();
        this.f263465z = r103;
        this.B = new com.bytedance.locallife.poi.newdetail.widget.seekbar.e();
        this.D = true;
        this.G = new SeekBarState(new PoiSeekBar$seekBarState$1(this));
        this.f263464y = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f263455p = ContextCompat.getDrawable(r100, com.larus.nova.R.drawable.poi_default_seekbar_thumb);
        Drawable r104 = ContextCompat.getDrawable(r100, com.larus.nova.R.drawable.poi_default_seekbar_progress_layer);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable r105 = (LayerDrawable) r104;
        this.f263454o = r105;
        Drawable r106 = this.f263456q;
        if (r106 == null) goto L6;
        if (r105 == null) goto L6;
        r105.setDrawableByLayerId(R.id.background, r106);
    L6:
        Drawable r107 = this.f263457r;
        if (r107 == null) goto L11;
        LayerDrawable r108 = this.f263454o;
        if (r108 == null) goto L11;
        r108.setDrawableByLayerId(R.id.progress, r107);
    L11:
        Drawable r109 = this.f263458s;
        if (r109 == null) goto L16;
        LayerDrawable r110 = this.f263454o;
        if (r110 == null) goto L16;
        r110.setDrawableByLayerId(R.id.secondaryProgress, r109);
    L16:
        setProgressDrawable(this.f263454o);
        setThumb(this.f263455p);
        setOnSeekBarChangeListener(r103);
        this.H = new e(this);
    }

    public /* synthetic */ PoiSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        i(r100, r101);
        return;
    }
}

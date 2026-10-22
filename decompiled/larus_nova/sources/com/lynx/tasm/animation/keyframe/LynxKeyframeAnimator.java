package com.lynx.tasm.animation.keyframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.l;
import com.lynx.tasm.behavior.ui.utils.m;
import com.lynx.tasm.behavior.ui.utils.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxKeyframeAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f381793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<LynxUI> f381794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f381795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f381796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f381797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f381798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator[] f381799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LynxKFAnimatorState f381800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s6a.a f381801i;

    public static final enum LynxAnimationPropertyType extends Enum<LynxAnimationPropertyType> {
        public static final LynxAnimationPropertyType BG_COLOR = null;
        public static final LynxAnimationPropertyType OPACITY = null;
        public static final LynxAnimationPropertyType ROTATE_X = null;
        public static final LynxAnimationPropertyType ROTATE_Y = null;
        public static final LynxAnimationPropertyType ROTATE_Z = null;
        public static final LynxAnimationPropertyType SCALE_X = null;
        public static final LynxAnimationPropertyType SCALE_Y = null;
        public static final LynxAnimationPropertyType TRANSLATE_X = null;
        public static final LynxAnimationPropertyType TRANSLATE_Y = null;
        public static final LynxAnimationPropertyType TRANSLATE_Z = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxAnimationPropertyType[] f381802a = null;

        static {
            LynxAnimationPropertyType r100 = new LynxAnimationPropertyType("TRANSLATE_X", 0);
            TRANSLATE_X = r100;
            LynxAnimationPropertyType r101 = new LynxAnimationPropertyType("TRANSLATE_Y", 1);
            TRANSLATE_Y = r101;
            LynxAnimationPropertyType r102 = new LynxAnimationPropertyType("TRANSLATE_Z", 2);
            TRANSLATE_Z = r102;
            LynxAnimationPropertyType r103 = new LynxAnimationPropertyType("ROTATE_X", 3);
            ROTATE_X = r103;
            LynxAnimationPropertyType r104 = new LynxAnimationPropertyType("ROTATE_Y", 4);
            ROTATE_Y = r104;
            LynxAnimationPropertyType r105 = new LynxAnimationPropertyType("ROTATE_Z", 5);
            ROTATE_Z = r105;
            LynxAnimationPropertyType r110 = new LynxAnimationPropertyType("SCALE_X", 6);
            SCALE_X = r110;
            LynxAnimationPropertyType r111 = new LynxAnimationPropertyType("SCALE_Y", 7);
            SCALE_Y = r111;
            LynxAnimationPropertyType r112 = new LynxAnimationPropertyType("OPACITY", 8);
            OPACITY = r112;
            LynxAnimationPropertyType r113 = new LynxAnimationPropertyType("BG_COLOR", 9);
            BG_COLOR = r113;
            f381802a = new LynxAnimationPropertyType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static LynxAnimationPropertyType[] values() {
            return (LynxAnimationPropertyType[]) f381802a.clone();
        }

        public static LynxAnimationPropertyType valueOf(String r100) {
            return (LynxAnimationPropertyType) r27.a.a(LynxAnimationPropertyType.class, r100);
        }

        public LynxAnimationPropertyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LynxKFAnimatorState extends Enum<LynxKFAnimatorState> {
        public static final LynxKFAnimatorState CANCELED = null;
        public static final LynxKFAnimatorState DESTROYED = null;
        public static final LynxKFAnimatorState IDLE = null;
        public static final LynxKFAnimatorState PAUSED = null;
        public static final LynxKFAnimatorState RUNNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxKFAnimatorState[] f381803a = null;

        static {
            LynxKFAnimatorState r100 = new LynxKFAnimatorState("IDLE", 0);
            IDLE = r100;
            LynxKFAnimatorState r101 = new LynxKFAnimatorState("RUNNING", 1);
            RUNNING = r101;
            LynxKFAnimatorState r102 = new LynxKFAnimatorState("PAUSED", 2);
            PAUSED = r102;
            LynxKFAnimatorState r103 = new LynxKFAnimatorState("CANCELED", 3);
            CANCELED = r103;
            LynxKFAnimatorState r104 = new LynxKFAnimatorState("DESTROYED", 4);
            DESTROYED = r104;
            f381803a = new LynxKFAnimatorState[]{r100, r101, r102, r103, r104};
        }

        public static LynxKFAnimatorState[] values() {
            return (LynxKFAnimatorState[]) f381803a.clone();
        }

        public static LynxKFAnimatorState valueOf(String r100) {
            return (LynxKFAnimatorState) r27.a.a(LynxKFAnimatorState.class, r100);
        }

        public LynxKFAnimatorState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxKeyframeAnimator f381804a;

        public a(LynxKeyframeAnimator r100) {
            this.f381804a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            LynxUI r101 = this.f381804a.f381794b.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if ((r101.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r101.getParent()).N();
            return;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381805a = null;

        static {
            int[] r100 = new int[LynxKFAnimatorState.values().length];
            f381805a = r100;
            r100[LynxKFAnimatorState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f381805a[LynxKFAnimatorState.CANCELED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f381805a[LynxKFAnimatorState.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f381805a[LynxKFAnimatorState.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, Object> f381806b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LynxKeyframeAnimator> f381807a;

        static {
            HashMap r100 = new HashMap();
            f381806b = r100;
            r100.put("animation_type", "keyframe-animation");
            r100.put("animation_name", "");
        }

        public c(LynxKeyframeAnimator r100) {
            this.f381807a = new WeakReference(r100);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            super.onAnimationCancel(r100);
            if (r100 == null) goto L6;
            r100.removeAllListeners();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            LynxKeyframeAnimator r101 = this.f381807a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            s6a.a r102 = r101.f381801i;
            if (r102 == null) goto L8;
            String r103 = r102.f540860a;
        L9:
            LynxKFAnimatorState r104 = r101.f381800h;
            LynxKFAnimatorState r105 = LynxKFAnimatorState.RUNNING;
            boolean r106 = false;
            if (r104 != r105) goto L12;
            boolean r107 = true;
        L13:
            if (r107 == false) goto L22;
            LynxUI r108 = r101.h();
            a(r108, "animationend", r103);
            if (r108 == null) goto L18;
            r108.onAnimationEnd(r103);
        L18:
            if (r101.f381800h != r105) goto L20;
            boolean r109 = true;
        L21:
            LLog.DCHECK(r109);
            r101.f381800h = LynxKFAnimatorState.IDLE;
            goto L22
        L20:
            r109 = false;
        L22:
            if (r102 == null) goto L30;
            int r110 = r102.f540871l;
            if (r110 != 1) goto L26;
        L27:
            r106 = true;
        L28:
            if (r106 == true) goto L30;
            r101.k();
            goto L30
        L26:
            if (r110 != 3) goto L28;
        L30:
            r101.f381799g = null;
            return;
        L12:
            r107 = false;
            goto L13
        L8:
            r103 = "";
            goto L9
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            super.onAnimationRepeat(r100);
            LynxKeyframeAnimator r101 = this.f381807a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            s6a.a r102 = r101.f381801i;
            if (r102 == null) goto L8;
            String r103 = r102.f540860a;
        L9:
            a(r101.h(), "animationiteration", r103);
            return;
        L8:
            r103 = "";
            goto L9
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
        }

        public static void a(LynxUI r100, String r101, String r102) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getEvents() != null) goto L7;
            return;
        L7:
            if (r100.getEvents().containsKey(r101) == false) goto L11;
            Map<String, Object> r103 = f381806b;
            ((HashMap) r103).put("animation_name", r102);
            r100.getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(r100.getSign(), r101, r103));
            return;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<Keyframe> f381808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<Keyframe> f381809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Keyframe> f381810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<Keyframe> f381811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList<Keyframe> f381812e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<Keyframe> f381813f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ArrayList<Keyframe> f381814g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ArrayList<Keyframe> f381815h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList<Keyframe> f381816i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList<Keyframe> f381817j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f381818k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Set<LynxAnimationPropertyType> f381819l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Set<LynxAnimationPropertyType> f381820m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public PropertyValuesHolder[] f381821n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public PropertyValuesHolder[] f381822o;

        public d() {
            this.f381808a = new ArrayList();
            this.f381809b = new ArrayList();
            this.f381810c = new ArrayList();
            this.f381811d = new ArrayList();
            this.f381812e = new ArrayList();
            this.f381813f = new ArrayList();
            this.f381814g = new ArrayList();
            this.f381815h = new ArrayList();
            this.f381816i = new ArrayList();
            this.f381817j = new ArrayList();
            this.f381818k = false;
            this.f381819l = new HashSet();
            this.f381820m = new HashSet();
        }
    }

    public interface e {
        void a(String r100);
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f381823a;

        public f() {
            this.f381823a = -1;
        }
    }

    public static class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
            r100.cancel();
        }
    }

    public final void e() {
        LynxKFAnimatorState r100 = this.f381800h;
        if (r100 != LynxKFAnimatorState.RUNNING) goto L5;
    L7:
        ObjectAnimator[] r101 = this.f381799g;
        if (r101 != null) goto L10;
    L14:
        this.f381799g = null;
        this.f381800h = LynxKFAnimatorState.CANCELED;
        return;
    L10:
        if (r101.length <= 0) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L14;
        r101[r103].cancel();
        r103 = r103 + 1;
        goto L12
    L5:
        if (r100 == LynxKFAnimatorState.PAUSED) goto L7;
    }

    public final void f() {
        LynxKFAnimatorState r100 = this.f381800h;
        if (r100 != LynxKFAnimatorState.CANCELED) goto L5;
    L8:
        LynxUI r101 = h();
        s6a.a r102 = this.f381801i;
        if (r102 == null) goto L11;
        String r103 = r102.f540860a;
    L12:
        c.a(r101, "animationcancel", r103);
    L13:
        e();
        k();
        this.f381800h = LynxKFAnimatorState.DESTROYED;
        return;
    L11:
        r103 = "";
        goto L12
    L5:
        if (r100 == LynxKFAnimatorState.RUNNING) goto L8;
        if (r100 != LynxKFAnimatorState.PAUSED) goto L13;
        goto L8
    }

    public final LynxUI h() {
        return this.f381794b.get();
    }

    public final void k() {
        View r100 = this.f381795c.get();
        LynxUI r101 = h();
        if (r101 == null) goto L36;
        if (r100 == null) goto L50;
        Iterator<Map.Entry<String, Object>> r102 = this.f381796d.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L51;
        Map.Entry<String, Object> r103 = r102.next();
        String r104 = r103.getKey();
        r104.getClass();
        byte r105 = -1;
        switch(r104.hashCode()) {
            case -1238332596: goto L25;
            case 63357246: goto L21;
            case 65290051: goto L17;
            case 290107061: goto L13;
            default: goto L28;
        };
    L28:
        switch(r105) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            default: goto L8;
        };
    L30:
        r100.setBackgroundColor(((Integer) r103.getValue()).intValue());
        goto L8
    L31:
        g().setColor(((Integer) r103.getValue()).intValue());
        goto L8
    L32:
        r100.setAlpha(((Float) r103.getValue()).floatValue());
        goto L8
    L34:
        if (r101.getBackgroundManager() == null) goto L8;
        r101.getBackgroundManager().t((List) r103.getValue());
        goto L8
    L13:
        if (r104.equals("BackgroundColor") == false) goto L28;
        r105 = 3;
        goto L28
    L17:
        if (r104.equals("Color") == false) goto L28;
        r105 = 2;
        goto L28
    L21:
        if (r104.equals("Alpha") == false) goto L28;
        r105 = 1;
        goto L28
    L25:
        if (r104.equals("Transform") == false) goto L28;
        r105 = 0;
        goto L28
    L51:
        return;
    L50:
        return;
    }

    public final boolean m() {
        LynxUI r100 = this.f381794b.get();
        d r101 = this.f381798f;
        if (r101 != null) goto L5;
    L7:
        l r102 = h().getTransformOriginStr();
        if (r102 != null) goto L10;
    L24:
        boolean r103 = false;
    L25:
        if (r103 == false) goto L30;
        if (r100 == null) goto L30;
        if (r100.hasSizeChanged() == false) goto L30;
        return true;
    L30:
        return false;
    L10:
        if (r102.f383156b != 1) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L24;
    L23:
        r103 = true;
        goto L25
    L15:
        if (r102.f383158d != 1) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L21;
        r105 = false;
        goto L22
    L17:
        r106 = false;
        goto L18
    L12:
        r104 = false;
        goto L13
    L5:
        if (r101.f381818k == false) goto L7;
        goto L7
    }

    public final BackgroundDrawable g() {
        LynxUI r100 = h();
        if (r100 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.ui.utils.a r101 = r100.getBackgroundManager();
        if (r101 != null) goto L8;
        return null;
    L8:
        return (BackgroundDrawable) r101.f383142b;
    }

    public final void a(s6a.a r110) {
        s6a.a r100 = this.f381801i;
        int r101 = 0;
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        LLog.DCHECK(r103);
        if (h() != null) goto L12;
        return;
    L12:
        int r104 = b.f381805a[this.f381800h.ordinal()];
        long r105 = 0;
        if (r104 != 1) goto L15;
    L62:
        s6a.a r106 = this.f381801i;
        if (r106 != null) goto L65;
    L69:
        if (r101 == 0) goto L76;
        if (this.f381800h != LynxKFAnimatorState.IDLE) goto L76;
        if (m() == true) goto L76;
        return;
    L76:
        if (r110.f540870k >= 0) goto L78;
        return;
    L78:
        if (r110.f540861b <= 0) goto L88;
        b(r110);
        return;
    L88:
        return;
    L65:
        if (r110.a(r106) == false) goto L69;
        if (r110.f540873n != r106.f540873n) goto L69;
        r101 = 1;
        goto L69
    L15:
        if (r104 == 2) goto L62;
        if (r104 != 3) goto L19;
    L21:
        s6a.a r107 = this.f381801i;
        if (r107 != null) goto L24;
    L28:
        boolean r108 = false;
    L29:
        if (r108 == true) goto L31;
    L33:
        s6a.a r109 = this.f381801i;
        if (r110.a(r109) == true) goto L36;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == false) goto L61;
        LynxKFAnimatorState r112 = this.f381800h;
        LynxKFAnimatorState r113 = LynxKFAnimatorState.PAUSED;
        if (r112 == r113) goto L43;
        j(r110);
        return;
    L43:
        if (r110.f540873n != 1) goto L45;
        boolean r114 = true;
    L46:
        LLog.DCHECK(r114);
        if (this.f381800h == r113) goto L50;
        r102 = false;
    L50:
        LLog.DCHECK(r102);
        this.f381800h = LynxKFAnimatorState.RUNNING;
        ObjectAnimator[] r115 = this.f381799g;
        if (r115 == null) goto L55;
        int r116 = r115.length;
    L53:
        if (r101 >= r116) goto L55;
        r115[r101].resume();
        r101 = r101 + 1;
    L55:
        long r117 = this.f381797e;
        f r118 = this.f381793a;
        if (r118.f381823a == (-1)) goto L59;
        r105 = System.currentTimeMillis() - r118.f381823a;
        r118.f381823a = -1;
    L59:
        this.f381797e = r117 + r105;
        this.f381801i = r110;
        return;
    L45:
        r114 = false;
        goto L46
    L61:
        e();
        a(r110);
        return;
    L36:
        if (r110.f540873n == r109.f540873n) goto L38;
        r111 = true;
        goto L39
    L31:
        if (m() == true) goto L33;
        return;
    L24:
        if (r110.a(r107) == false) goto L28;
        if (r110.f540873n != r107.f540873n) goto L28;
        r108 = true;
        goto L29
    L19:
        if (r104 == 4) goto L21;
        return;
    L5:
        if (r110.f540860a.equals(r100.f540860a) == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void b(s6a.a r210) {
        LynxKFAnimatorState r100 = this.f381800h;
        int r101 = 1;
        if (r100 != LynxKFAnimatorState.IDLE) goto L5;
    L8:
        boolean r102 = true;
    L9:
        LLog.DCHECK(r102);
        View r103 = this.f381795c.get();
        LynxUI r104 = h();
        if (r103 == null) goto L313;
        if (r104 == null) goto L314;
        if (r210 == null) goto L315;
        int r105 = 3;
        if (this.f381798f != null) goto L17;
    L20:
        ReadableMap r106 = r104.getKeyframes(r210.f540860a);
        if (r106 == null) goto L49;
        d r110 = new d();
        ReadableMapKeySetIterator r111 = r106.keySetIterator();
    L24:
        String r112 = "BackgroundColor";
        String r107 = "Alpha";
        if (r111.hasNextKey() == false) goto L64;
        String r113 = r111.nextKey();
        float r114 = CastFloatProtector.parseFloat(r113);
        int r108 = r210.f540872m;
        if (r108 == r101) goto L31;
        if (r108 == r105) goto L31;
        boolean r109 = false;
    L32:
        if (r109 == false) goto L34;
        r114 = 1.0f - r114;
    L34:
        float r115 = r114;
        ReadableMap r116 = r106.getMap(r113);
        ReadableMapKeySetIterator r117 = r116.keySetIterator();
    L36:
        if (r117.hasNextKey() == false) goto L24;
        String r118 = r117.nextKey();
        if (r118.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L45;
        l("Alpha", Float.valueOf(this.f381795c.get().getAlpha()));
        d(r115, LynxAnimationPropertyType.OPACITY, r110);
        String r119 = r112;
        float r120 = (float) r116.getDouble(r118);
        if (r120 < 0.0f) goto L49;
        if (r120 > 1.0f) goto L49;
        r110.f381808a.add(Keyframe.ofFloat(r115, r120));
    L61:
        r112 = r119;
    L62:
        r101 = 1;
        r105 = 3;
        goto L36
    L45:
        r119 = r112;
        if (r118.equals("transform") == false) goto L55;
        l("Transform", r104.getTransformRaws());
        List<n> r121 = n.d(r116.getArray(r118));
        r104.getLynxContext().getUIBody().getFontSize();
        r104.getFontSize();
        r104.getLynxContext().getUIBody().getLatestWidth();
        r104.getLynxContext().getUIBody().getLatestHeight();
        m r122 = m.k(r121, r104.getLatestWidth(), r104.getLatestHeight());
        if (r122 == null) goto L49;
        if (n.a(r121) == false) goto L53;
        r110.f381818k = true;
    L53:
        d(r115, LynxAnimationPropertyType.TRANSLATE_X, r110);
        r110.f381809b.add(Keyframe.ofFloat(r115, r122.h()));
        d(r115, LynxAnimationPropertyType.TRANSLATE_Y, r110);
        r110.f381810c.add(Keyframe.ofFloat(r115, r122.i()));
        r104.getView().setOutlineProvider(null);
        d(r115, LynxAnimationPropertyType.TRANSLATE_Z, r110);
        r110.f381811d.add(Keyframe.ofFloat(r115, r122.j()));
        d(r115, LynxAnimationPropertyType.ROTATE_Z, r110);
        r110.f381812e.add(Keyframe.ofFloat(r115, r122.c()));
        d(r115, LynxAnimationPropertyType.ROTATE_X, r110);
        r110.f381813f.add(Keyframe.ofFloat(r115, r122.d()));
        d(r115, LynxAnimationPropertyType.ROTATE_Y, r110);
        r110.f381814g.add(Keyframe.ofFloat(r115, r122.e()));
        d(r115, LynxAnimationPropertyType.SCALE_X, r110);
        r110.f381815h.add(Keyframe.ofFloat(r115, r122.f()));
        d(r115, LynxAnimationPropertyType.SCALE_Y, r110);
        r110.f381816i.add(Keyframe.ofFloat(r115, r122.g()));
        goto L61
    L55:
        if (r118.equals(GXTemplateKey.STYLE_BACKGROUND_COLOR) == false) goto L61;
        if (g() != null) goto L59;
        r112 = r119;
        l(r112, Integer.valueOf(r104.getBackgroundColor()));
    L60:
        d(r115, LynxAnimationPropertyType.BG_COLOR, r110);
        r110.f381817j.add(Keyframe.ofInt(r115, r116.getInt(r118)));
        goto L62
    L59:
        r112 = r119;
        l("Color", Integer.valueOf(r104.getBackgroundColor()));
    L31:
        r109 = true;
        goto L32
    L64:
        if (g() == null) goto L66;
        int r123 = 2;
    L67:
        int r124 = 0;
    L68:
        if (r124 >= r123) goto L198;
        View r125 = this.f381795c.get();
        LynxUI r126 = h();
        if (r125 == null) goto L188;
        if (r126 == null) goto L188;
        ArrayList r127 = new ArrayList();
        com.lynx.tasm.animation.keyframe.b r128 = new com.lynx.tasm.animation.keyframe.b();
        if (r110.f381808a.size() == 0) goto L84;
        if (r124 != 0) goto L84;
        Set<LynxAnimationPropertyType> r129 = r110.f381819l;
        LynxAnimationPropertyType r130 = LynxAnimationPropertyType.OPACITY;
        if (((HashSet) r129).contains(r130) == true) goto L81;
        r110.f381808a.add(Keyframe.ofFloat(0.0f, r125.getAlpha()));
    L81:
        if (((HashSet) r110.f381820m).contains(r130) == true) goto L83;
        r110.f381808a.add(Keyframe.ofFloat(1.0f, r125.getAlpha()));
    L83:
        Collections.sort(r110.f381808a, r128);
        r127.add(c(r110.f381808a, r107));
    L86:
        if (r110.f381809b.size() == 0) goto L96;
        if (r124 != 0) goto L96;
        Set<LynxAnimationPropertyType> r131 = r110.f381819l;
        LynxAnimationPropertyType r132 = LynxAnimationPropertyType.TRANSLATE_X;
        if (((HashSet) r131).contains(r132) == true) goto L92;
        r110.f381809b.add(Keyframe.ofFloat(0.0f, r125.getTranslationX()));
    L92:
        if (((HashSet) r110.f381820m).contains(r132) == true) goto L94;
        r110.f381809b.add(Keyframe.ofFloat(1.0f, r125.getTranslationX()));
    L94:
        Collections.sort(r110.f381809b, r128);
        r127.add(c(r110.f381809b, "TranslationX"));
    L96:
        if (r110.f381810c.size() == 0) goto L106;
        if (r124 != 0) goto L106;
        Set<LynxAnimationPropertyType> r133 = r110.f381819l;
        LynxAnimationPropertyType r134 = LynxAnimationPropertyType.TRANSLATE_Y;
        if (((HashSet) r133).contains(r134) == true) goto L102;
        r110.f381810c.add(Keyframe.ofFloat(0.0f, r125.getTranslationY()));
    L102:
        if (((HashSet) r110.f381820m).contains(r134) == true) goto L104;
        r110.f381810c.add(Keyframe.ofFloat(1.0f, r125.getTranslationY()));
    L104:
        Collections.sort(r110.f381810c, r128);
        r127.add(c(r110.f381810c, "TranslationY"));
    L106:
        if (r110.f381811d.size() == 0) goto L116;
        if (r124 != 0) goto L116;
        float r135 = r125.getTranslationZ();
        Set<LynxAnimationPropertyType> r136 = r110.f381819l;
        LynxAnimationPropertyType r137 = LynxAnimationPropertyType.TRANSLATE_Z;
        if (((HashSet) r136).contains(r137) == true) goto L113;
        r110.f381811d.add(Keyframe.ofFloat(0.0f, r135));
    L113:
        if (((HashSet) r110.f381820m).contains(r137) == true) goto L115;
        r110.f381811d.add(Keyframe.ofFloat(1.0f, r135));
    L115:
        Collections.sort(r110.f381811d, r128);
        r127.add(c(r110.f381811d, "TranslationZ"));
    L118:
        if (r110.f381812e.size() == 0) goto L128;
        if (r124 != 0) goto L128;
        Set<LynxAnimationPropertyType> r138 = r110.f381819l;
        LynxAnimationPropertyType r139 = LynxAnimationPropertyType.ROTATE_Z;
        if (((HashSet) r138).contains(r139) == true) goto L124;
        r110.f381812e.add(Keyframe.ofFloat(0.0f, r125.getRotation()));
    L124:
        if (((HashSet) r110.f381820m).contains(r139) == true) goto L126;
        r110.f381812e.add(Keyframe.ofFloat(1.0f, r125.getRotation()));
    L126:
        Collections.sort(r110.f381812e, r128);
        r127.add(c(r110.f381812e, "Rotation"));
    L128:
        if (r110.f381813f.size() == 0) goto L138;
        if (r124 != 0) goto L138;
        Set<LynxAnimationPropertyType> r140 = r110.f381819l;
        LynxAnimationPropertyType r141 = LynxAnimationPropertyType.ROTATE_X;
        if (((HashSet) r140).contains(r141) == true) goto L134;
        r110.f381813f.add(Keyframe.ofFloat(0.0f, r125.getRotationX()));
    L134:
        if (((HashSet) r110.f381820m).contains(r141) == true) goto L136;
        r110.f381813f.add(Keyframe.ofFloat(1.0f, r125.getRotationX()));
    L136:
        Collections.sort(r110.f381813f, r128);
        r127.add(c(r110.f381813f, "RotationX"));
    L138:
        if (r110.f381814g.size() == 0) goto L148;
        if (r124 != 0) goto L148;
        Set<LynxAnimationPropertyType> r142 = r110.f381819l;
        LynxAnimationPropertyType r143 = LynxAnimationPropertyType.ROTATE_Y;
        if (((HashSet) r142).contains(r143) == true) goto L144;
        r110.f381814g.add(Keyframe.ofFloat(0.0f, r125.getRotationY()));
    L144:
        if (((HashSet) r110.f381820m).contains(r143) == true) goto L146;
        r110.f381814g.add(Keyframe.ofFloat(1.0f, r125.getRotationY()));
    L146:
        Collections.sort(r110.f381814g, r128);
        r127.add(c(r110.f381814g, "RotationY"));
    L148:
        if (r110.f381815h.size() == 0) goto L158;
        if (r124 != 0) goto L158;
        Set<LynxAnimationPropertyType> r144 = r110.f381819l;
        LynxAnimationPropertyType r145 = LynxAnimationPropertyType.SCALE_X;
        if (((HashSet) r144).contains(r145) == true) goto L154;
        r110.f381815h.add(Keyframe.ofFloat(0.0f, r125.getScaleX()));
    L154:
        if (((HashSet) r110.f381820m).contains(r145) == true) goto L156;
        r110.f381815h.add(Keyframe.ofFloat(1.0f, r125.getScaleX()));
    L156:
        Collections.sort(r110.f381815h, r128);
        r127.add(c(r110.f381815h, "ScaleX"));
    L158:
        if (r110.f381816i.size() == 0) goto L168;
        if (r124 != 0) goto L168;
        Set<LynxAnimationPropertyType> r146 = r110.f381819l;
        LynxAnimationPropertyType r147 = LynxAnimationPropertyType.SCALE_Y;
        if (((HashSet) r146).contains(r147) == true) goto L164;
        r110.f381816i.add(Keyframe.ofFloat(0.0f, r125.getScaleY()));
    L164:
        if (((HashSet) r110.f381820m).contains(r147) == true) goto L166;
        r110.f381816i.add(Keyframe.ofFloat(1.0f, r125.getScaleY()));
    L166:
        Collections.sort(r110.f381816i, r128);
        r127.add(c(r110.f381816i, "ScaleY"));
    L168:
        if (r110.f381817j.size() == 0) goto L186;
        if ((r124 + 1) != r123) goto L186;
        Set<LynxAnimationPropertyType> r148 = r110.f381819l;
        LynxAnimationPropertyType r149 = LynxAnimationPropertyType.BG_COLOR;
        if (((HashSet) r148).contains(r149) == true) goto L176;
        r110.f381817j.add(Keyframe.ofInt(0.0f, r126.getBackgroundColor()));
    L176:
        if (((HashSet) r110.f381820m).contains(r149) == true) goto L179;
        r110.f381817j.add(Keyframe.ofInt(1.0f, r126.getBackgroundColor()));
    L179:
        Collections.sort(r110.f381817j, r128);
        if (r124 != 0) goto L182;
        PropertyValuesHolder r150 = c(r110.f381817j, "BackgroundColor");
    L183:
        r150.setEvaluator(new ArgbEvaluator());
        r127.add(r150);
        goto L186
    L182:
        r150 = c(r110.f381817j, "Color");
    L186:
        if (r127.size() == 0) goto L189;
        PropertyValuesHolder[] r151 = (PropertyValuesHolder[]) r127.toArray(new PropertyValuesHolder[r127.size()]);
    L190:
        if (r151 == null) goto L197;
        if (r124 != 0) goto L195;
        r110.f381821n = r151;
        goto L197
    L195:
        if (r124 != 1) goto L197;
        r110.f381822o = r151;
    L197:
        r124 = r124 + 1;
        r103 = r103;
        r104 = r104;
        r107 = r107;
    L189:
        r151 = null;
    L116:
        r107 = r107;
    L84:
        r103 = r103;
        r104 = r104;
    L188:
        r103 = r103;
        r104 = r104;
        r107 = r107;
        goto L189
    L198:
        View r211 = r103;
        LynxUI r212 = r104;
        this.f381798f = r110;
        boolean r152 = true;
    L199:
        if (r152 == true) goto L202;
        LLog.e("Lynx", "Keyframes input error.");
        return;
    L202:
        long r153 = this.f381797e;
        long r154 = 0;
        if (r153 != (-1)) goto L205;
    L211:
        BackgroundDrawable r155 = g();
        if (r155 == null) goto L214;
        int r156 = 2;
    L215:
        ObjectAnimator[] r157 = new ObjectAnimator[r156];
        int r158 = 0;
        int r159 = 0;
    L216:
        if (r158 >= r156) goto L259;
        d r160 = this.f381798f;
        if (r158 != 1) goto L220;
        PropertyValuesHolder[] r161 = r160.f381822o;
    L221:
        if (r161 == null) goto L258;
        if (r158 != 1) goto L225;
        Object r162 = r155;
    L226:
        ObjectAnimator r163 = ObjectAnimator.ofPropertyValuesHolder(r162, r161);
        r163.addUpdateListener(new a(this));
        r157[r158] = r163;
        r163.setDuration(r210.f540861b);
        r163.setRepeatCount(r210.f540870k);
        int r164 = r210.f540872m;
        if (r164 != 2) goto L229;
    L232:
        boolean r165 = true;
    L233:
        if (r165 == false) goto L235;
        r163.setRepeatMode(2);
    L236:
        r163.setInterpolator(s6a.b.a(r210));
        if (r210.f540862c == r154) goto L247;
        int r166 = r210.f540871l;
        if (r166 == 2) goto L243;
        if (r166 == 3) goto L243;
        boolean r167 = false;
    L244:
        if (r167 == false) goto L247;
        ObjectAnimator r168 = r163.clone();
        r168.setDuration(StackLeakChecker.CHECK_INTERVAL_10_SEC);
        r168.addListener(new g());
        r168.start();
    L243:
        r167 = true;
    L247:
        r159 = r159 + 1;
        long r169 = r210.f540862c;
        if (r169 < r154) goto L250;
        r163.setStartDelay(r169);
    L252:
        if (this.f381797e == (-1)) goto L257;
        long r170 = System.currentTimeMillis() - this.f381797e;
        long r171 = r210.f540862c;
        if (r170 >= r171) goto L256;
        r163.setStartDelay(r171 - r170);
        goto L257
    L256:
        r163.setCurrentPlayTime(r170 - r171);
    L257:
        r163.start();
        goto L258
    L250:
        r163.setCurrentPlayTime(r169 * (-1));
        goto L252
    L235:
        r163.setRepeatMode(1);
        goto L236
    L229:
        if (r164 == 3) goto L232;
        r165 = false;
        goto L233
    L225:
        r162 = r211;
    L258:
        r158 = r158 + 1;
        r154 = 0;
        goto L216
    L220:
        r161 = r160.f381821n;
        goto L221
    L259:
        if (r159 != 0) goto L261;
        this.f381799g = null;
    L269:
        ObjectAnimator[] r172 = this.f381799g;
        if (r172 == null) goto L276;
        int r173 = r172.length;
        if (r173 <= 0) goto L276;
        r172[r173 - 1].addListener(new c(this));
    L276:
        if (this.f381797e != (-1)) goto L279;
        this.f381797e = System.currentTimeMillis();
    L279:
        if (i(r210) == true) goto L293;
        LynxKFAnimatorState r174 = this.f381800h;
        LynxKFAnimatorState r175 = LynxKFAnimatorState.IDLE;
        if (r174 != r175) goto L283;
        c.a(r212, "animationstart", r210.f540860a);
    L283:
        LynxKFAnimatorState r176 = this.f381800h;
        if (r176 != r175) goto L286;
    L289:
        boolean r177 = true;
    L290:
        LLog.DCHECK(r177);
        this.f381800h = LynxKFAnimatorState.RUNNING;
        if (r210.f540873n != 0) goto L293;
        j(r210);
        goto L293
    L286:
        if (r176 == LynxKFAnimatorState.CANCELED) goto L289;
        r177 = false;
    L293:
        this.f381801i = r210;
        return;
    L261:
        if (r159 != r156) goto L263;
        this.f381799g = r157;
        goto L269
    L263:
        this.f381799g = new ObjectAnimator[r159];
        int r178 = 0;
        int r179 = 0;
    L264:
        if (r178 >= r156) goto L269;
        ObjectAnimator r180 = r157[r178];
        if (r180 == null) goto L268;
        this.f381799g[r179] = r180;
        r179 = r179 + 1;
    L268:
        r178 = r178 + 1;
        goto L264
    L214:
        r156 = 1;
        goto L215
    L205:
        if (r210.f540873n != 1) goto L211;
        f r181 = this.f381793a;
        if (r181.f381823a != (-1)) goto L209;
        long r182 = 0;
    L210:
        this.f381797e = r153 + r182;
        goto L211
    L209:
        r182 = System.currentTimeMillis() - r181.f381823a;
        r181.f381823a = -1;
        goto L210
    L66:
        r123 = 1;
    L49:
        r211 = r103;
        r212 = r104;
        r152 = false;
        goto L199
    L17:
        if (m() == true) goto L20;
        r211 = r103;
        r212 = r104;
        goto L202
    L315:
        return;
    L314:
        return;
    L313:
        return;
    L5:
        if (r100 == LynxKFAnimatorState.CANCELED) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean i(s6a.a r110) {
        if (this.f381797e != (-1)) goto L5;
        return false;
    L5:
        int r100 = r110.f540870k;
        if (r100 < 9.99999999E8d) goto L8;
        long r101 = Long.MAX_VALUE;
    L10:
        if ((System.currentTimeMillis() - this.f381797e) < r101) goto L13;
        return true;
    L13:
        return false;
    L8:
        r101 = (r110.f540861b * ((long) (r100 + 1))) + r110.f540862c;
        goto L10
    }

    public final void j(s6a.a r100) {
        boolean r101 = true;
        int r102 = 0;
        if (r100.f540873n != 0) goto L5;
        boolean r103 = true;
    L6:
        LLog.DCHECK(r103);
        if (this.f381800h == LynxKFAnimatorState.RUNNING) goto L10;
        r101 = false;
    L10:
        LLog.DCHECK(r101);
        this.f381800h = LynxKFAnimatorState.PAUSED;
        ObjectAnimator[] r104 = this.f381799g;
        if (r104 == null) goto L16;
        int r105 = r104.length;
    L13:
        if (r102 >= r105) goto L16;
        r104[r102].pause();
        r102 = r102 + 1;
    L16:
        if (i(r100) == true) goto L20;
        f r106 = this.f381793a;
        if (r106.f381823a != (-1)) goto L20;
        r106.f381823a = System.currentTimeMillis();
    L20:
        this.f381801i = r100;
        return;
    L5:
        r103 = false;
        goto L6
    }

    public LynxKeyframeAnimator(View r100, LynxUI r101) {
        this.f381793a = new f();
        this.f381796d = new HashMap();
        this.f381797e = -1;
        this.f381798f = null;
        this.f381799g = null;
        this.f381800h = LynxKFAnimatorState.IDLE;
        this.f381801i = null;
        this.f381794b = new WeakReference(r101);
        this.f381795c = new WeakReference(r100);
    }

    public static PropertyValuesHolder c(ArrayList r100, String r101) {
        return PropertyValuesHolder.ofKeyframe(r101, (Keyframe[]) r100.toArray(new Keyframe[r100.size()]));
    }

    public final void l(String r100, Object r101) {
        if (this.f381796d.containsKey(r100) == true) goto L6;
        this.f381796d.put(r100, r101);
        return;
    }

    public static void d(float r100, LynxAnimationPropertyType r101, d r102) {
        if (r100 != 0.0f) goto L6;
        ((HashSet) r102.f381819l).add(r101);
    L6:
        if (r100 != 1.0f) goto L9;
        ((HashSet) r102.f381820m).add(r101);
        return;
    }
}

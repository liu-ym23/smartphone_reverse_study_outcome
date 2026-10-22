package com.larus.camera.impl.edulibs.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.google.gson.Gson;
import com.larus.camera.impl.edulibs.camera.internal.EduClipImageView;
import com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.camera.internal.idl.Orientation;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipImageRect;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipRectAnimateView;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import mx8.e;
import nx8.f;
import nx8.g;
import nx8.i;
import nx8.j;
import nx8.m;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f321548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.camera.impl.edulibs.camera.a.b f321549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f321550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EduQuestionSearchLogic f321551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f321552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EduClipImageView f321553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EduClipRectAnimateView f321554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StateFlowImpl f321555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f321556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f321557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f321558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IdentifyDetectionResult f321559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f321560m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f321561n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f321562o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f321563p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f321564q;

    public static final class a {
    }

    static {
    }

    @Override // nx8.m
    public final Bitmap b() {
        Bitmap r100 = this.f321553f.getOriginBitmap();
        if (r100 != null) goto L5;
        return null;
    L5:
        float[] r101 = new float[8];
        int r102 = 0;
    L6:
        if (r102 >= 8) goto L19;
        int r103 = r102 % 4;
        if (r103 != 0) goto L10;
    L16:
        float r104 = 0.0f;
    L17:
        r101[r102] = r104;
        r102 = r102 + 1;
        goto L6
    L10:
        if (r103 == 1) goto L16;
        if (r103 == 2) goto L14;
        int r105 = r100.getHeight();
    L15:
        r104 = r105;
        goto L17
    L14:
        r105 = r100.getWidth();
        goto L15
    L19:
        if (this.f321551d.f321585a.f521081a == false) goto L21;
        int r106 = this.f321553f.getRotateDegrees() + this.f321557j;
    L36:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L24
        Object r108 = Result.m9449constructorimpl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r100, r101, r106));     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L30;
        this.f321549b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r109);
    L30:
        if (Result.m9455isFailureimpl(r108) == false) goto L32;
        r108 = null;
    L32:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a r110 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a) r108;
        if (r110 != null) goto L35;
        return null;
    L35:
        return r110.f321631a;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L21:
        r106 = this.f321553f.getRotateDegrees();
        goto L36
    }

    @Override // nx8.m
    public final boolean d() {
        return this.f321553f.f321571f.f321644h;
    }

    @Override // nx8.m
    public final void destroy() {
        com.larus.camera.impl.edulibs.camera.a r100 = com.larus.camera.impl.edulibs.camera.a.f321539a;
        com.larus.camera.impl.edulibs.camera.a.f321543e.remove(this.f321560m);
        CoroutineScopeKt.cancel$default(this.f321551d.f321588d, null, 1, null);
        CoroutineScopeKt.cancel$default(this.f321550c, "EduImageViewHolder destroy", null, 2, null);
    }

    @Override // nx8.m
    public final Bitmap h() {
        EduClipImageView r100 = this.f321553f;
        int r101 = 0;
        if (r100.f321571f.f321644h == true) goto L75;
        kx8.c r102 = this.f321551d.f321592h;
        Integer r103 = Integer.valueOf(r100.getSelectIndex());
        if (r103.intValue() < 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L11;
        r103 = null;
    L11:
        if (r103 != null) goto L17;
        if (r102 == null) goto L15;
        r103 = r102.f506588c;
    L16:
        if (r103 != null) goto L17;
        int r104 = 0;
    L19:
        if (r102 == null) goto L25;
        List<kx8.b> r105 = r102.f506587b;
        if (r105 == null) goto L25;
        kx8.b r106 = (kx8.b) CollectionsKt.getOrNull(r105, r104);
        if (r106 == null) goto L25;
        Bitmap r107 = (Bitmap) r106.f506585d.getValue();
    L26:
        Boolean r108 = (Boolean) CollectionsKt.firstOrNull(this.f321553f.getClipModifyList());
        if (r108 == null) goto L29;
        boolean r109 = r108.booleanValue();
    L30:
        i r111 = this.f321551d.f321585a;
        if (r111.f521082b != 1) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L39;
        if (r109 == true) goto L39;
        if (r107 == null) goto L39;
        this.f321549b.i("EduImageViewHolder", "getClipBitmap: return cloud result: " + r107.getWidth() + ", " + r107.getHeight() + ", initDegree=" + this.f321556i);
    L113:
        return r107;
    L39:
        r107 = this.f321553f.getOriginBitmap();
        if (r107 != null) goto L42;
        this.f321549b.e("EduImageViewHolder", "getClipBitmap: imageView.originBitmap is null", null);
        return null;
    L42:
        if (r112 == false) goto L44;
        RectF r113 = this.f321553f.getClipRect();
    L45:
        if (r113 != null) goto L47;
        this.f321549b.e("EduImageViewHolder", "getClipBitmap: imageView.rectF is null", null);
        goto L113
    L47:
        float[] r114 = new float[8];
    L48:
        if (r101 >= 8) goto L59;
        int r115 = r101 % 4;
        if (r115 == 0) goto L56;
        if (r115 == 1) goto L55;
        if (r115 == 2) goto L54;
        float r116 = r113.bottom;
    L57:
        r114[r101] = r116;
        r101 = r101 + 1;
        goto L48
    L54:
        r116 = r113.right;
        goto L57
    L55:
        r116 = r113.top;
        goto L57
    L56:
        r116 = r113.left;
        goto L57
    L59:
        if (r111.f521081a == false) goto L61;
        int r117 = this.f321553f.getRotateDegrees() + this.f321557j;
    L102:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L64
        Object r119 = Result.m9449constructorimpl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r107, r114, r117));     // Catch: Throwable -> L64
    L66:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L70;
        this.f321549b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r120);
    L70:
        if (Result.m9455isFailureimpl(r119) == false) goto L72;
        r119 = null;
    L72:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a r121 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a) r119;
        if (r121 != null) goto L116;
        return null;
    L116:
        return r121.f321631a;
    L64:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L61:
        r117 = this.f321553f.getRotateDegrees();
        goto L102
    L44:
        r113 = new RectF(0.0f, 0.0f, r107.getWidth(), r107.getHeight());
        goto L45
    L33:
        r112 = false;
        goto L34
    L29:
        r109 = false;
    L25:
        r107 = null;
        goto L26
    L15:
        r103 = null;
    L17:
        r104 = r103.intValue();
        goto L19
    L7:
        r110 = false;
        goto L8
    L75:
        Bitmap r123 = r100.m();
        if (r123 == null) goto L117;
        float[] r124 = new float[8];
    L78:
        if (r101 >= 8) goto L104;
        int r125 = r101 % 4;
        if (r125 == 0) goto L86;
        if (r125 == 1) goto L86;
        if (r125 == 2) goto L84;
        int r126 = r123.getHeight();
    L85:
        float r127 = r126;
    L87:
        r124[r101] = r127;
        r101 = r101 + 1;
        goto L78
    L84:
        r126 = r123.getWidth();
    L86:
        r127 = 0.0f;
        goto L87
    L104:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L90
        int r129 = com.larus.camera.impl.edulibs.camera.internal.util.a.f321630a;     // Catch: Throwable -> L90
        Object r130 = Result.m9449constructorimpl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r123, r124, -this.f321556i));     // Catch: Throwable -> L90
    L92:
        Throwable r131 = Result.m9452exceptionOrNullimpl(r130);
        if (r131 == null) goto L96;
        this.f321549b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r131);
    L96:
        if (Result.m9455isFailureimpl(r130) == false) goto L98;
        r130 = null;
    L98:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a r132 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C4147a) r130;
        if (r132 != null) goto L101;
        return null;
    L101:
        return r132.f321631a;
    L90:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L92
    L117:
        return null;
    }

    @Override // nx8.m
    public final boolean k() {
        kx8.c r100 = this.f321551d.c();
        if (r100 == null) goto L7;
        List<kx8.b> r101 = r100.f506587b;
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L9:
        if (r102 <= 1) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = 0;
        goto L9
    }

    @Override // nx8.m
    public final int l() {
        kx8.c r100 = this.f321551d.c();
        if (r100 == null) goto L7;
        List<kx8.b> r101 = r100.f506587b;
        if (r101 == null) goto L7;
        return r101.size();
    L7:
        return 0;
    }

    @Override // nx8.m
    public final boolean p() {
        kx8.c r100 = this.f321551d.c();
        if (r100 == null) goto L11;
        Bitmap r101 = r100.f506593h;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101 != this.f321553f.getOriginBitmap()) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // nx8.m
    public final boolean q() {
        kx8.c r100 = this.f321551d.c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.f506592g, Boolean.TRUE);
    }

    public final void s() {
        this.f321553f.p(1.0f, 1.0f);
        kx8.c r100 = this.f321551d.c();
        if (r100 == null) goto L44;
        List<kx8.b> r101 = r100.f506587b;
        if (r101 == null) goto L10;
        List<kx8.b> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L11;
        r103.add(((kx8.b) r104.next()).f506582a);
    L11:
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.size() <= 1) goto L46;
        EduClipImageView r105 = this.f321553f;
        Integer r106 = r100.f506588c;
        int r107 = 0;
        if (r106 == null) goto L17;
        int r108 = r106.intValue();
    L18:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r103, SVGRenderEngine.RECT);
        EduClipImageRect r109 = r105.f321571f;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r103, "rectList");
        ((ArrayList) r109.f321643g).clear();
        Iterator r110 = r103.iterator();
    L20:
        if (r110.hasNext() == false) goto L25;
        RectF r111 = (RectF) r110.next();
        EduClipImageRect.b r112 = r109.f321638b;
        EduClipImageRect.a r113 = new EduClipImageRect.a(r112.f321666e, r112.f321667f, r112.f321668g);
        r113.f321652d.set(r111);
        r113.b(r109.f321637a.f516319d);
        RectF r114 = EduClipImageRect.b(r109, r113.f321653e, true);
        if (Intrinsics.areEqual(r114, r113.f321653e) == true) goto L24;
        r113.f321653e.set(r114);
        Matrix r115 = r109.f321637a.f516320e;
        Intrinsics.checkNotNullParameter(r115, "invertMatrix");
        r115.mapRect(r113.f321652d, r113.f321653e);
    L24:
        ((ArrayList) r109.f321643g).add(r113);
        goto L20
    L25:
        EduClipImageRect.a r116 = (EduClipImageRect.a) CollectionsKt.getOrNull(r109.f321643g, r108);
        if (r116 != null) goto L28;
        r116 = (EduClipImageRect.a) CollectionsKt.firstOrNull(r109.f321643g);
    L28:
        r109.f321642f = r116;
        ((ArrayList) r105.f321573h).clear();
        Iterator r117 = r103.iterator();
    L30:
        if (r117.hasNext() == false) goto L35;
        Object r118 = r117.next();
        int r119 = r107 + 1;
        if (r107 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        RectF r120 = (RectF) r118;
        List<e> r121 = r105.f321573h;
        ArrayList r122 = (ArrayList) r121;
        r122.add(new e(r105.getContext(), String.valueOf(r119)));
        r107 = r119;
        goto L30
    L35:
        r105.f321571f.c(true);
        r105.invalidate();
        return;
    L17:
        r108 = 0;
        goto L18
    L46:
        return;
    L10:
        r103 = null;
        goto L11
    }

    public final void t() {
        this.f321558k = 200L;
    }

    @Override // nx8.m
    public final Bitmap e() {
        return this.f321561n;
    }

    @Override // nx8.m
    public final View getView() {
        return this.f321552e;
    }

    @Override // nx8.m
    public final StateFlowImpl i() {
        return this.f321555h;
    }

    @Override // nx8.m
    public final g j(i r210) {
        EduQuestionSearchLogic r100 = this.f321551d;
        List<Boolean> r101 = this.f321553f.getClipModifyList();
        List<RectF> r102 = this.f321553f.getAllClipRect();
        int r103 = this.f321553f.getSelectIndex();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "userChangeBoxes");
        if (r210 != null) goto L5;
        i r104 = r100.f321585a;
    L6:
        Integer r105 = Integer.valueOf(r103);
        if (r105.intValue() < 0) goto L9;
        boolean r106 = true;
    L10:
        String r110 = null;
        if (r106 == true) goto L14;
        r105 = null;
    L14:
        if (r105 != null) goto L21;
        kx8.c r107 = r100.f321592h;
        if (r107 == null) goto L19;
        r105 = r107.f506588c;
    L20:
        if (r105 != null) goto L21;
        int r108 = 0;
    L23:
        i.f r109 = i.f.f521088d;
        if (Intrinsics.areEqual(r104, r109) == true) goto L26;
    L32:
        List<Boolean> r111 = r101;
        i.e r112 = i.e.f521087d;
        if (Intrinsics.areEqual(r104, r112) == false) goto L36;
        List<j> r113 = r100.b(r102, null);
    L38:
        List<j> r114 = r113;
    L40:
        DetectionType r115 = r100.e(r104);
        if (r115 != DetectionType.MultiQuestion) goto L50;
        if (r114 != null) goto L44;
    L47:
        boolean r116 = true;
    L48:
        if (r116 == false) goto L50;
        Integer r117 = Integer.valueOf(DetectionType.SingleQuestion.getValue());
    L52:
        Integer r118 = r117;
    L54:
        kx8.c r119 = r100.f321592h;
        if (r119 == null) goto L59;
        Long r120 = r119.f506586a;
        if (r120 == null) goto L59;
        long r121 = r120.longValue();
    L60:
        Long r122 = Long.valueOf(r121);
        if (Intrinsics.areEqual(r100.f321585a, i.b.f521084d) == false) goto L63;
        Integer r123 = 1;
    L65:
        if (Intrinsics.areEqual(r104, r112) == true) goto L68;
        r103 = 0;
    L68:
        Integer r124 = Integer.valueOf(r103);
        SceneType r125 = r100.f321589e;
        if (r125 == null) goto L71;
        Integer r126 = Integer.valueOf(r125.getValue());
    L72:
        String r127 = r100.f321590f;
        if (r127 != null) goto L78;
        kx8.c r128 = r100.f321592h;
        if (r128 == null) goto L77;
        r127 = r128.f506590e;
        goto L78
    L77:
        String r211 = null;
    L79:
        kx8.c r129 = r100.f321592h;
        if (r129 == null) goto L83;
        r110 = r129.f506591f;
    L83:
        return new g("10400", r118, r122, r111, r123, r114, r124, r126, r211, r110, 5);
    L78:
        r211 = r127;
        goto L79
    L71:
        r126 = null;
        goto L72
    L63:
        r123 = null;
    L59:
        r121 = 0;
        goto L60
    L44:
        if (r114.isEmpty() == true) goto L47;
        r116 = false;
    L50:
        if (r115 == null) goto L53;
        r117 = Integer.valueOf(r115.getValue());
        goto L52
    L53:
        r118 = null;
        goto L54
    L36:
        if (Intrinsics.areEqual(r104, r109) == false) goto L39;
        r113 = r100.b(r102, Integer.valueOf(r108));
        goto L38
    L39:
        r114 = null;
        goto L40
    L26:
        if (Intrinsics.areEqual(r100.f321585a, i.e.f521087d) == false) goto L32;
        Boolean r130 = (Boolean) CollectionsKt.getOrNull(r101, r108);
        if (r130 == null) goto L30;
        boolean r131 = r130.booleanValue();
    L31:
        r101 = CollectionsKt.listOf(Boolean.valueOf(r131));
        goto L32
    L30:
        r131 = false;
        goto L31
    L19:
        r105 = null;
    L21:
        r108 = r105.intValue();
        goto L23
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = r210;
        goto L6
    }

    @Override // nx8.m
    public final void m(m.a r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f321553f.setClipRectChangeListener(r100);
    }

    @Override // nx8.m
    public final void n(SceneType r100) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        this.f321551d.f321589e = r100;
    }

    public final void u(boolean r100) {
        FLogger.f375446a.i("EduImageViewHolder", "updateDisplayedBitmap shouldShowCaptureOriginalImage=" + this.f321562o);
        if (this.f321562o == false) goto L5;
        Bitmap r101 = this.f321561n;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101 == this.f321553f.getOriginBitmap()) goto L18;
        if (r100 == false) goto L14;
        this.f321553f.setImageBitmapAndReprepare$impl_mainlandRelease(r101);
    L15:
        this.f321553f.invalidate();
        return;
    L14:
        this.f321553f.setImageBitmap(r101);
        goto L15
    L18:
        return;
    L5:
        kx8.c r102 = this.f321551d.c();
        if (r102 == null) goto L8;
        r101 = r102.f506593h;
        goto L9
    L8:
        r101 = null;
        goto L9
    }

    @Override // nx8.m
    public final void a(nx8.c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        i r102 = this.f321551d.f321585a;
        if (Intrinsics.areEqual(r100, nx8.c.b.f521067a) == false) goto L6;
        i r103 = i.e.f521087d;
    L11:
        EduQuestionSearchLogic r104 = this.f321551d;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r104.f321585a = r103;
        this.f321562o = r101;
        boolean r105 = false;
        u(false);
        EduClipImageView r106 = this.f321553f;
        if (r103.f521082b == 0) goto L14;
        boolean r107 = true;
    L15:
        r106.setEnableClipRect(r107);
        EduClipImageView r108 = this.f321553f;
        if (r103.f521082b != 2) goto L18;
        r105 = true;
    L18:
        r108.setMultiMode(r105);
        int r109 = this.f321557j;
        if (r109 == 0) goto L29;
        boolean r110 = r103.f521081a;
        if (r110 == r102.f521081a) goto L30;
        if (r110 == false) goto L24;
        int r111 = r109 + this.f321556i;
    L25:
        this.f321553f.j(r111);
        return;
    L24:
        r111 = this.f321556i;
        goto L25
    L30:
        return;
    L29:
        return;
    L14:
        r107 = false;
        goto L15
    L6:
        if (Intrinsics.areEqual(r100, nx8.c.a.f521066a) == false) goto L9;
        r103 = i.g.f521089d;
        goto L11
    L9:
        if (Intrinsics.areEqual(r100, nx8.c.C6990c.f521068a) == false) goto L28;
        r103 = i.f.f521088d;
        goto L11
    L28:
        throw new NoWhenBranchMatchedException();
    }

    @Override // nx8.m
    public final void c(int r100, boolean r101) {
        EduClipImageView r102 = this.f321553f;
        int r103 = r100 + this.f321557j;
        r102.getClass();
        int r104 = r103 % 360;
        if (r104 >= 0) goto L5;
        r104 = r104 + 360;
    L5:
        mx8.a r105 = r102.f321568c;
        int r106 = ((int) r105.f516318c) % 360;
        if (r106 >= 0) goto L8;
        r106 = r106 + 360;
    L8:
        int r107 = r104 - r106;
        if (r107 <= 180) goto L12;
        r107 = r107 - 360;
    L14:
        if (r107 == 0) goto L24;
        r102.f321580o = true;
        if (r102.f321569d == false) goto L19;
        return;
    L19:
        if (r105.f516316a == true) goto L22;
        if (r101 == true) goto L25;
        int r108 = r102.f321575j + r107;
        r102.f321575j = r108;
        r105.f516318c = r108 + r102.f321576k;
        return;
    L25:
        return;
    L22:
        r102.f321575j += r107;
        r102.o(r101, false);
        return;
    L24:
        return;
    L12:
        if (r107 >= (-180)) goto L14;
        r107 = r107 + 360;
        goto L14
    }

    @Override // nx8.m
    public final void f(int r100, int r101) {
        if (r100 <= 0) goto L4;
        this.f321563p = r100;
    L4:
        if (r101 <= 0) goto L6;
        this.f321564q = r101;
    L6:
        EduClipRectAnimateView r102 = this.f321554g;
        if (r102 == null) goto L10;
        int r103 = this.f321563p;
        int r104 = this.f321564q;
        float r105 = r102.getResources().getDimension(R.dimen.larus_edu_clip_anim_init_radius);
        EduClipRectAnimateView.a r106 = r102.f321684d;
        RectF r107 = r106.f321691a;
        r107.right = r103;
        r107.bottom = r104;
        r106.f321692b = r105;
        r106.f321693c = r105;
        return;
    }

    public c(Context r110, i r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "eduImageScene");
        this.f321548a = r112;
        this.f321549b = com.larus.camera.impl.edulibs.camera.a.f321541c;
        boolean r100 = true;
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f321550c = r101;
        if (r112 == null) goto L5;
        Object r102 = r112.get("need_question_detection");
    L7:
        if ((r102 instanceof Boolean) == false) goto L9;
        Boolean r103 = (Boolean) r102;
    L10:
        Boolean r104 = Boolean.TRUE;
        boolean r105 = Intrinsics.areEqual(r103, r104);
        if (r112 == null) goto L13;
        Object r113 = r112.get("need_dewarp");
    L15:
        if ((r113 instanceof Boolean) == false) goto L17;
        Boolean r114 = (Boolean) r113;
    L18:
        EduQuestionSearchLogic r106 = new EduQuestionSearchLogic(r111, r105, Intrinsics.areEqual(r114, r104));
        this.f321551d = r106;
        FrameLayout r115 = new FrameLayout(r110);
        this.f321552e = r115;
        EduClipImageView r116 = new EduClipImageView(r110, null, 2);
        this.f321553f = r116;
        this.f321555h = j1.a(f.c.f521076b);
        this.f321560m = "";
        this.f321563p = r110.getResources().getDimensionPixelSize(R.dimen.larus_edu_capture_tip_view_width_backup);
        this.f321564q = r110.getResources().getDimensionPixelSize(R.dimen.larus_edu_capture_tip_view_height_backup);
        r115.addView(r116, new FrameLayout.LayoutParams(-1, -1));
        if (r106.f321585a.f521082b != 0) goto L22;
        r100 = false;
    L22:
        r116.setEnableClipRect(r100);
        EduClipRectAnimateView r117 = new EduClipRectAnimateView(r110, null);
        r117.f321681a.setStrokeWidth(r117.getResources().getDimensionPixelSize(R.dimen.larus_edu_clip_corner_line_width));
        r117.f321681a.setColor(-1);
        this.f321554g = r117;
        r115.addView(r117, new FrameLayout.LayoutParams(-1, -1));
        r117.setVisibility(8);
        BuildersKt.launch$default(r101, null, null, new EduImageViewHolder$init$1(this, null), 3, null);
        return;
    L17:
        r114 = null;
        goto L18
    L13:
        r113 = null;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final Object r(final c r110, kx8.c r111, Continuation r112) {
        kx8.c r100 = r111;
        r110.getClass();
        if ((r112 instanceof EduImageViewHolder$onDetectComplete$1) == false) goto L7;
        EduImageViewHolder$onDetectComplete$1 r101 = (EduImageViewHolder$onDetectComplete$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        Long r107 = null;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L20;
        if (r105 == 3) goto L19;
        if (r105 == 4) goto L18;
        if (r105 == 5) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
    L121:
        return Unit.INSTANCE;
    L19:
        r100 = (kx8.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L79:
        if (r100 == null) goto L87;
        List<kx8.b> r108 = r100.f506587b;
        if (r108 == null) goto L87;
        Integer r109 = r100.f506588c;
        if (r109 == null) goto L85;
        int r113 = r109.intValue();
    L86:
        kx8.b r114 = (kx8.b) CollectionsKt.getOrNull(r108, r113);
    L88:
        if (r114 == null) goto L90;
        RectF r115 = r114.f506582a;
    L91:
        final EduClipRectAnimateView r116 = r110.f321554g;
        if (r116 == null) goto L121;
        r116.setVisibility(0);
        r110.f321553f.p(0.0f, 0.0f);
        if (r115 == null) goto L97;
        EduClipImageView r117 = r110.f321553f;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r115, "originRect");
        RectF r118 = new RectF();
        r117.f321568c.f516319d.mapRect(r118, r115);
        r118.set(EduClipImageRect.b(r117.f321571f, r118, true));
        RectF r119 = r118;
    L102:
        r110.f321549b.d("EduImageViewHolder", "startClipRectAnimation: dstRect=" + r119);
        Long r120 = r110.f321558k;
        if (r120 != null) goto L105;
    L112:
        long r121 = 300;
    L113:
        r116.setAnimateDuration(r121);
        Function2<? super Float, ? super EduClipRectAnimateView.a, Unit> r122 = new b(r110, r116);
        Intrinsics.checkNotNullParameter(r122, "block");
        r116.f321683c = r122;
        float r123 = r116.getResources().getDimension(R.dimen.larus_edu_clip_anim_dst_radius);
        EduClipRectAnimateView.a r124 = new EduClipRectAnimateView.a(r119, r123, r123);
        Intrinsics.checkNotNullParameter(r124, "dst");
        r116.f321685e = r124;
        r116.b();
        goto L121
    L105:
        if (r120.longValue() > 0) goto L108;
        r106 = false;
    L108:
        if (r106 == false) goto L110;
        r107 = r120;
    L110:
        if (r107 == null) goto L112;
        r121 = r107.longValue();
        goto L113
    L97:
        if ((r110.f321556i % 180) == 0) goto L99;
        boolean r125 = true;
    L100:
        r119 = r110.f321553f.l(r110.f321563p, r110.f321564q, r125);
        goto L102
    L99:
        r125 = false;
        goto L100
    L90:
        r115 = null;
        goto L91
    L85:
        r113 = 0;
    L87:
        r114 = null;
        goto L88
    L20:
        r100 = (kx8.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L69:
        i r126 = r110.f321551d.f321585a;
        if (r126.f521082b == 0) goto L72;
        boolean r127 = true;
    L73:
        if (r127 == true) goto L75;
        r110.s();
        StateFlowImpl r128 = r110.f321555h;
        f.a r129 = f.a.f521074b;
        r101.L$0 = null;
        r101.label = 5;
        r128.setValue(r129);
        if (Unit.INSTANCE != r104) goto L121;
        return r104;
    L75:
        if (r126.f521083c == false) goto L114;
        StateFlowImpl r130 = r110.f321555h;
        f.b r131 = f.b.f521075b;
        r101.L$0 = r100;
        r101.label = 3;
        r130.setValue(r131);
        if (Unit.INSTANCE != r104) goto L79;
        return r104;
    L114:
        r110.s();
        r110.f321553f.setMultiMode(true);
        StateFlowImpl r132 = r110.f321555h;
        f.a r133 = f.a.f521074b;
        r101.L$0 = null;
        r101.label = 4;
        r132.setValue(r133);
        if (Unit.INSTANCE != r104) goto L121;
        return r104;
    L72:
        r127 = false;
        goto L73
    L21:
        r100 = (kx8.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L57:
        EduClipImageView r134 = r110.f321553f;
        r101.L$0 = r100;
        r101.label = 2;
        if (r134.f321568c.f516316a == true) goto L66;
        kotlinx.coroutines.j r135 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r135.C();
        r134.f321578m = r135;
        Object r136 = r135.B();
        if (r136 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L63:
        if (r136 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r136 = Unit.INSTANCE;
    L67:
        if (r136 != r104) goto L69;
        return r104;
    L66:
        r136 = Unit.INSTANCE;
        goto L67
    L22:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L27;
        Bitmap r137 = r100.f506593h;
        if (r137 == null) goto L27;
        FLogger.f375446a.i("EduImageViewHolder", "clipQuestion dewarpBitmap width=" + r137.getWidth() + " height=" + r137.getHeight());
        r110.u(true);
    L27:
        com.larus.camera.impl.edulibs.camera.internal.b r138 = com.larus.camera.impl.edulibs.camera.internal.b.f321602a;
        if (r100 == null) goto L30;
        Integer r139 = r100.f506589d;
    L31:
        r138.getClass();
        int r140 = Orientation.Angle_180.getValue();
        if (r139 != null) goto L35;
    L37:
        int r141 = Orientation.Angle_90.getValue();
        if (r139 != null) goto L41;
    L43:
        int r142 = Orientation.Angle_270.getValue();
        if (r139 != null) goto L47;
    L49:
        int r143 = 0;
    L50:
        r110.f321557j = r143;
        if (r143 == 0) goto L57;
        if (r110.f321551d.f321585a.f521081a == false) goto L57;
        r110.f321553f.j(r143 + r110.f321556i);
        r101.L$0 = r100;
        r101.label = 1;
        if (DelayKt.delay(200, r101) != r104) goto L57;
        return r104;
    L47:
        if (r139.intValue() != r142) goto L49;
        r143 = 270;
        goto L50
    L41:
        if (r139.intValue() != r141) goto L43;
        r143 = 90;
        goto L50
    L35:
        if (r139.intValue() != r140) goto L37;
        r143 = 180;
        goto L50
    L30:
        r139 = null;
    L7:
        r101 = new EduImageViewHolder$onDetectComplete$1(r110, r112);
        goto L8
    }

    @Override // nx8.m
    public final void o(Bitmap r110, String r111, int r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "imageId");
        this.f321556i = r112;
        this.f321560m = r111;
        this.f321559l = (IdentifyDetectionResult) ((LinkedHashMap) com.larus.camera.impl.edulibs.camera.a.f321543e).get(r111);
        this.f321553f.setScreenOrientationDegrees(r112);
        this.f321553f.j(r112);
        this.f321549b.i("EduImageViewHolder", "Bitmap: view rotate=" + r112);
        Matrix r100 = new Matrix();
        this.f321549b.d("EduImageViewHolder", "rotateAndCompressBitmap: w=" + r110.getWidth() + ",h=" + r110.getHeight() + ",r=0.0");
        int r114 = Math.min(r110.getWidth(), r110.getHeight());
        float r115 = (float) r114;
        boolean r101 = false;
        if (r115 <= 720.0f) goto L5;
        float r102 = 720.0f / r115;
        this.f321549b.d("EduImageViewHolder", "resizeBitmap scaleFactor " + r102 + " shortSide " + r114);
        r100.postScale(r102, r102);
        boolean r116 = true;
    L6:
        Boolean r117 = null;
        if (r116 == true) goto L39;
    L22:
        this.f321561n = r110;
        this.f321553f.setImageBitmap(r110);
        if (r113 == false) goto L34;
        EduQuestionSearchLogic r118 = this.f321551d;
        IdentifyDetectionResult r119 = this.f321559l;
        Map<String, Object> r103 = this.f321548a;
        if (r103 == null) goto L27;
        Object r104 = r103.get("is_from_live_tutor");
    L29:
        if ((r104 instanceof Boolean) == false) goto L31;
        r117 = (Boolean) r104;
    L31:
        if (r117 == null) goto L33;
        r101 = r117.booleanValue();
    L33:
        r118.d(r110, r119, r101);
    L35:
        EduClipRectAnimateView r120 = this.f321554g;
        if (r120 == null) goto L41;
        int r121 = this.f321563p;
        int r122 = this.f321564q;
        float r123 = r120.getResources().getDimension(R.dimen.larus_edu_clip_anim_init_radius);
        EduClipRectAnimateView.a r124 = r120.f321684d;
        RectF r105 = r124.f321691a;
        r105.right = r121;
        r105.bottom = r122;
        r124.f321692b = r123;
        r124.f321693c = r123;
        return;
    L41:
        return;
    L27:
        r104 = null;
        goto L29
    L34:
        this.f321555h.setValue(f.a.f521074b);
        goto L35
    L39:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L10
        Object r126 = Result.m9449constructorimpl(Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), r110.getHeight(), r100, true));     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r126);
        if (r106 == null) goto L16;
        this.f321549b.e("EduImageViewHolder", "rotateAndCompressBitmap error", r106);
    L16:
        if (Result.m9455isFailureimpl(r126) == false) goto L18;
        r126 = null;
    L18:
        Bitmap r127 = (Bitmap) r126;
        if (r127 == null) goto L22;
        r110 = r127;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r116 = false;
        goto L6
    }

    @Override // nx8.m
    public final nx8.b g(String r110, int r111, int r112, boolean r210, SceneType r211, String r212, String r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r211, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Bitmap r100 = null;
        Object r101 = null;
        r100 = null;
        r100 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        com.larus.camera.impl.edulibs.camera.internal.util.c.f321632a.getClass();     // Catch: Throwable -> L9
        ox8.a r103 = (ox8.a) ((Gson) com.larus.camera.impl.edulibs.camera.internal.util.c.f321634c.getValue()).fromJson(r110, ox8.a.class);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        ox8.e r104 = ox8.b.a(r103);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        this.f321549b.e("EduImageViewHolder", "setServerClipResponse error", r106);
    L15:
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        r105 = null;
    L17:
        ox8.e r107 = (ox8.e) r105;
        if (r107 == null) goto L20;
        kx8.c r108 = new kx8.c(null);
        boolean r113 = true;
        if (r214 == false) goto L45;
        String r109 = r107.e();
        if (r109 == null) goto L45;
        if (r109.length() <= 0) goto L28;
        boolean r114 = true;
    L29:
        if (r114 == true) goto L32;
        r109 = null;
    L32:
        if (r109 == null) goto L45;
        Object r115 = Result.m9449constructorimpl(com.larus.camera.impl.edulibs.camera.internal.util.a.a(r109));     // Catch: Throwable -> L35
    L37:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L41;
        this.f321549b.e("EduImageViewHolder", "setServerClipResponse decode dewarp image error", r116);
    L41:
        if (Result.m9455isFailureimpl(r115) == true) goto L44;
        r101 = r115;
    L44:
        r100 = (Bitmap) r101;
    L35:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L28:
        r114 = false;
    L45:
        r108.f506593h = r100;
        Bitmap r118 = this.f321553f.getOriginBitmap();
        if (r100 == null) goto L49;
        FLogger.f375446a.i("EduImageViewHolder", "setServerClipResponse dewarpBitmap width=" + r100.getWidth() + " height=" + r100.getHeight());
        com.larus.camera.impl.edulibs.camera.internal.b r119 = com.larus.camera.impl.edulibs.camera.internal.b.f321602a;
        ox8.e r120 = ox8.e.a(r107, 0, null, null, null, 16319);
        int r121 = r100.getWidth();
        int r122 = r100.getHeight();
        r119.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r108, r120, 1.0f, r121, r122);
    L54:
        r108.f506591f = r213;
        List<kx8.b> r123 = r108.f506587b;
        if (r123 == null) goto L57;
        int r124 = r123.size();
    L58:
        if (r124 > 1) goto L62;
        r113 = false;
    L62:
        if (r210 == false) goto L65;
        if (r113 == false) goto L65;
        EduQuestionSearchLogic r125 = this.f321551d;
        i.e r126 = i.e.f521087d;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r125.f321585a = r126;
    L66:
        EduQuestionSearchLogic r127 = this.f321551d;
        r127.f321589e = r211;
        r127.f321590f = r212;
        Intrinsics.checkNotNullParameter(r108, "resp");
        r127.f321592h = r108;
        r127.f321591g.setValue(new com.larus.camera.impl.edulibs.camera.internal.e.a(r108));
        if (r113 == false) goto L70;
        return nx8.b.a.f521063a;
    L70:
        return nx8.b.C6989b.f521064a;
    L65:
        EduQuestionSearchLogic r128 = this.f321551d;
        i.f r129 = i.f.f521088d;
        r128.getClass();
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r128.f321585a = r129;
        goto L66
    L57:
        r124 = 0;
        goto L58
    L49:
        if (r118 != null) goto L51;
    L53:
        com.larus.camera.impl.edulibs.camera.internal.b.f321602a.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r108, r107, 1.0f, r111, r112);
        goto L54
    L51:
        if (r118.getWidth() <= 0) goto L53;
        float r130 = r111 / r118.getWidth();
        com.larus.camera.impl.edulibs.camera.internal.b r131 = com.larus.camera.impl.edulibs.camera.internal.b.f321602a;
        int r132 = r118.getWidth();
        int r133 = r118.getHeight();
        r131.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r108, r107, r130, r132, r133);
        goto L54
    L20:
        return nx8.b.c.f521065a;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}

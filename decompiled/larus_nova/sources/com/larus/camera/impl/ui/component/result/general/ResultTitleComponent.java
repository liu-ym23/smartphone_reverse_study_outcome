package com.larus.camera.impl.ui.component.result.general;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.widget.title.TitleRightIconView;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class ResultTitleComponent extends com.larus.camera.impl.ui.base.k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f322210s = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f322211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f322212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f322213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f322214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f322215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f322216r;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f322217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f322218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f322219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final n f322220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f322221e;

        public b() {
            Boolean r100 = null;
            this(r100, false, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f322217a, r101.f322217a) == true) goto L12;
            return false;
        L12:
            if (this.f322218b == r101.f322218b) goto L15;
            return false;
        L15:
            if (this.f322219c == r101.f322219c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f322220d, r101.f322220d) == true) goto L21;
            return false;
        L21:
            if (this.f322221e == r101.f322221e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.f322217a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            int r103 = 1231;
            if (this.f322218b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f322219c == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (((r105 + r106) * 31) + this.f322220d.hashCode()) * 31;
            if (this.f322221e == true) goto L19;
            r103 = 1237;
        L19:
            return r107 + r103;
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "TitleRightIconParams(photoEditable=" + this.f322217a + ", inCropMode=" + this.f322218b + ", inFreeInputMode=" + this.f322219c + ", detectResult=" + this.f322220d + ", hasAIBeautyAccess=" + this.f322221e + ')';
        }

        public /* synthetic */ b(Boolean r100, boolean r110, int r111) {
            n.b r101 = null;
            if ((r111 & 1) == 0) goto L5;
            Boolean r102 = null;
        L7:
            if ((r111 & 2) == 0) goto L9;
            boolean r103 = false;
        L11:
            if ((r111 & 8) == 0) goto L13;
            r101 = n.b.f322320a;
        L13:
            this(r102, r103, false, r101, false);
            return;
        L9:
            r103 = r110;
            goto L11
        L5:
            r102 = r100;
            goto L7
        }

        public b(Boolean r100, boolean r101, boolean r102, n r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r103, "detectResult");
            this.f322217a = r100;
            this.f322218b = r101;
            this.f322219c = r102;
            this.f322220d = r103;
            this.f322221e = r104;
        }

        public static b a(b r100, boolean r101, n r102, boolean r110, int r111) {
            if ((r111 & 1) == 0) goto L5;
            Boolean r103 = r100.f322217a;
        L6:
            Boolean r104 = r103;
            if ((r111 & 2) == 0) goto L9;
            boolean r105 = r100.f322218b;
        L11:
            if ((r111 & 4) == 0) goto L13;
            r101 = r100.f322219c;
        L13:
            boolean r106 = r101;
            if ((r111 & 8) == 0) goto L16;
            r102 = r100.f322220d;
        L16:
            n r107 = r102;
            if ((r111 & 16) == 0) goto L19;
            r110 = r100.f322221e;
        L19:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r107, "detectResult");
            return new b(r104, r105, r106, r107, r110);
        L9:
            r105 = false;
            goto L11
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        p(new q0(r100));
        w(r100);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.isPhotoEditable(), new ResultTitleComponent$onViewCreated$2(this, r100, null)), k());
        CameraResultViewModel r101 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r101 != null) goto L8;
        Flow r102 = kotlinx.coroutines.flow.j1.a(new ay8.a(false, false, 31));
    L9:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r102, new ResultTitleComponent$onViewCreated$3(this, null)), k());
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r103 = com.larus.camera.impl.utils.eventbus.c.f322750a;
        CoroutineScope r104 = k();
        final kotlinx.coroutines.flow.a1 r105 = com.larus.camera.impl.utils.eventbus.c.f322751b;
        Flow<Object> r106 = new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$1(r105);
        kotlinx.coroutines.flow.g1.f504854a.getClass();
        kotlinx.coroutines.flow.h1 r107 = kotlinx.coroutines.flow.g1.a.f504856b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(kotlinx.coroutines.flow.e.D(r106, r104, r107, 0), new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$2(null, this)), r104);
        CoroutineScope r108 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(kotlinx.coroutines.flow.e.D(new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$3(r105), r108, r107, 0), new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$4(null, this)), r108);
        return;
    L8:
        FLogger.f375446a.i("ResultTitleComponent", "[resultTitleRightIconStateFlow] combine");
        kotlinx.coroutines.flow.v0 r109 = new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(r101.isPhotoEditable(), r101.isInCropMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$1(null)), r101.getInFreeInputMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$2(null)), r101.getResultDetectionStatus(), new ResultTitleComponent$resultTitleRightIconStateFlow$3(null)), r101.getHasAccessToAIBeauty(), new ResultTitleComponent$resultTitleRightIconStateFlow$4(null)), r101.isInMarkSelectMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$5(this, null));
        CoroutineScope r110 = k();
        kotlinx.coroutines.flow.g1.f504854a.getClass();
        r102 = kotlinx.coroutines.flow.e.F(r109, r110, kotlinx.coroutines.flow.g1.a.f504856b, y(r101.isPhotoEditable().getValue(), r101.isInCropMode().getValue().booleanValue(), r101.getInFreeInputMode().getValue().booleanValue(), n.b.f322320a, r101.getHasAccessToAIBeauty().getValue().booleanValue(), r101.isInMarkSelectMode().getValue().booleanValue()));
        goto L9
    }

    public ResultTitleComponent() {
    }

    public final void w(final CameraResultViewModel r100) {
        if (r100.shouldUseUnifiedResultTopStyle() == true) goto L5;
        return;
    L5:
        Function1 r101 = new x0();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(h(R.id.title));
        Function1 r102 = new y0();
        Intrinsics.checkNotNullParameter(r102, "config");
        r102.invoke(h(R.id.title_bold));
        Function1 r103 = new z0();
        Intrinsics.checkNotNullParameter(r103, "config");
        r103.invoke(h(R.id.title_ic));
        p(new a1(this, r100));
        Function1 r104 = new b1(r100);
        Intrinsics.checkNotNullParameter(r104, "config");
        r104.invoke(h(R.id.left_text));
        Function1 r105 = new c1();
        Intrinsics.checkNotNullParameter(r105, "config");
        r105.invoke(h(R.id.right_icon_group));
    }

    public static final void s(ResultTitleComponent r100, Function1 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.h(R.id.tile_and_icon_container));
    }

    public static final void t(ResultTitleComponent r100, Function1 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.h(R.id.redo_btn));
    }

    public static final void u(ResultTitleComponent r100, Function1 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.h(R.id.redo_undo_container));
    }

    public static final void v(ResultTitleComponent r100, Function1 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.h(R.id.undo_btn));
    }

    public static void x(TitleRightIconView r100, CameraResultViewModel r101, int r102) {
        if (r101.shouldUseUnifiedResultTopStyle() == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 != null) goto L8;
        r103 = new ViewGroup.LayoutParams(i5.c0(), i5.c0());
    L8:
        r103.width = i5.c0();
        r103.height = i5.c0();
        r100.setLayoutParams(r103);
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(1);
        r104.setColor(ColorProtector.parseColor("#664E4E4E"));
        r100.setBackground(r104);
        r100.setGravity(17);
        LinearLayout r105 = r100.f322927a.f321512a;
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r105.setGravity(17);
        r100.f322927a.f321513b.setVisibility(8);
        ImageView r106 = r100.f322927a.f321514c;
        r106.setLayoutParams(new LinearLayout.LayoutParams(r102, r102));
        r106.setPadding(0, 0, 0, 0);
        r100.setIcon(new w0());
    }

    public final ay8.a y(Boolean r110, boolean r111, boolean r112, n r113, boolean r210, boolean r211) {
        boolean r100 = false;
        if ((r113 instanceof n.a) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        CameraResultViewModel r102 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r102 != null) goto L11;
    L13:
        boolean r114 = false;
    L14:
        if (r102 != null) goto L16;
    L18:
        boolean r103 = false;
    L19:
        FLogger.f375446a.i("ResultTitleComponent", "[produceResultTitleRightIconState] isPhotoEditable:" + r110 + ", isInCropMode:" + r111 + ", inFreeInputMode:" + r112 + ", isEduIntent:" + r101 + ", hasAIBeautyAccess:" + r210 + " shouldHideEditControls:" + r114 + " markSelectModeEnabled:" + r103 + " inMarkSelectMode:" + r211);
        if (r110 != null) goto L22;
        boolean r115 = true;
    L23:
        if (r103 == false) goto L36;
        if (r211 == false) goto L36;
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L30;
        if (r111 == true) goto L30;
        if (r114 == true) goto L30;
        boolean r104 = true;
    L31:
        if (r111 == false) goto L35;
        if (r114 == true) goto L35;
        r100 = true;
    L35:
        return new ay8.a(r104, r100, 22);
    L30:
        r104 = false;
    L36:
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r110, r105) == false) goto L41;
        if (r111 == true) goto L41;
        if (r114 == true) goto L41;
        boolean r116 = true;
    L43:
        if (Intrinsics.areEqual(r110, Boolean.FALSE) == true) goto L45;
        if (r111 == true) goto L45;
    L47:
        boolean r117 = false;
    L48:
        if (r115 == false) goto L50;
    L56:
        boolean r106 = false;
    L57:
        if (r115 == true) goto L61;
        if (r112 == false) goto L61;
        if (r111 == true) goto L61;
        boolean r107 = true;
    L62:
        if (r103 == false) goto L69;
        if (Intrinsics.areEqual(r110, r105) == false) goto L69;
        if (r111 == true) goto L69;
        if (r114 == true) goto L69;
        r100 = true;
    L69:
        return new ay8.a(r116, r106, r107, r117, r100);
    L61:
        r107 = false;
        goto L62
    L50:
        if (z2.f365865a.enableTopBeautyButton() == false) goto L56;
        if (r210 == false) goto L56;
        if (r111 == true) goto L56;
        if (r101 == true) goto L56;
        if (r114 == true) goto L56;
        r106 = true;
    L45:
        if (r114 == true) goto L47;
        r117 = true;
    L41:
        r116 = false;
        goto L43
    L22:
        r115 = false;
        goto L23
    L16:
        if (r102.shouldUseMarkSelectMode() != true) goto L18;
        r103 = true;
        goto L19
    L11:
        if (r102.currentPreviewShouldHideEditControls() != true) goto L13;
        r114 = true;
        goto L14
    L5:
        if ((((n.a) r113).f322319a instanceof ix8.d.b) == false) goto L7;
        r101 = true;
        goto L8
    }
}

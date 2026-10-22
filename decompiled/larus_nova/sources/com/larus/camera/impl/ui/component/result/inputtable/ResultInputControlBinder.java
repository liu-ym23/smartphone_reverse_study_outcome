package com.larus.camera.impl.ui.component.result.inputtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.TeaEventTrack;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.d;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.n;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.x;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.camera.impl.utils.eventbus.e;
import com.larus.camera.impl.utils.eventbus.g;
import com.larus.camera.impl.utils.eventbus.h;
import com.larus.camera.impl.utils.eventbus.i;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import op8.c;
import op8.f;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
public final class ResultInputControlBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f322480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f322481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<CameraResultViewModel> f322482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f322483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f322484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f.b f322485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f322486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f322487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f322488i;

    public final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResultInputControlBinder f322489a;

        @Override // op8.c, op8.f
        public final boolean g() {
            CameraResultViewModel r100 = this.f322489a.f322482c.invoke();
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.supportsEduIntentOnResultPage() == true) goto L8;
        L10:
            Lazy r101 = o.f322668a;
            return o.a(r100.isSupportMultiImages(), r100.getCameraData());
        L8:
            if (r100.getEduResultTabState().getValue().f530944b == EduResultMode.PHOTO) goto L10;
            return false;
        }

        @Override // op8.c, op8.f
        public final Map<String, String> getEventInfo() {
            CameraResultViewModel r100 = this.f322489a.f322482c.invoke();
            if (r100 == null) goto L5;
            ICameraEventExt r101 = r100.getCameraData().getEventExt();
            if (r101 == null) goto L9;
            Long r102 = Long.valueOf(r101.chatKey());
        L10:
            LinkedHashMap r103 = new LinkedHashMap();
            if (r102 == null) goto L13;
            String r104 = (String) r103.put("camera_mob_key_chat_key", String.valueOf(r102.longValue()));
        L13:
            r103.put("camera_mob_key_current_page", "camera_confirm");
            return r103;
        L9:
            r102 = null;
            goto L10
        L5:
            return MapsKt.emptyMap();
        }

        public a(ResultInputControlBinder r100) {
            this.f322489a = r100;
        }

        @Override // op8.c, op8.f
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            FLogger.f375446a.i("ResultInputtableControlComponent", "[onInputTextChanged] content:" + r100);
        }

        @Override // op8.f
        public final boolean c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            FLogger.f375446a.i("ResultInputtableControlComponent", "[onSend] content:" + r100);
            ResultInputControlBinder.a(this.f322489a, new Pair(r100, 1));
            return true;
        }

        @Override // op8.c, op8.f
        public final void d(int r100) {
            t r101 = t.f322672a;
            if (t.e() < r100) goto L6;
            s.j(s.f544207a, AppHost.f326268a.getApplication(), this.f322489a.f322480a.getString(R.string.larus_camera_multi_toast_limit), null, false, 28);
            return;
        L6:
            CameraResultViewModel r102 = this.f322489a.f322482c.invoke();
            if (r102 != null) goto L10;
            return;
        L10:
            if (r102.getEnableUndo().getValue().booleanValue() == true) goto L12;
        L17:
            r102.onMultiCameraCapture();
            return;
        L12:
            if (CameraResultViewModel.shouldUseOriginalImageDeferredEdit$default(r102, null, 1, null) == false) goto L14;
            r102.setImageHasBeenMarked(true);
            goto L17
        L14:
            Bitmap r103 = r102.getMarkedImageBitmap();
            if (r103 == null) goto L17;
            r102.updateCurrentBitmap(r103, "onMultiCameraCapture");
            r102.setImageHasBeenMarked(true);
            goto L17
        }

        @Override // op8.c, op8.f
        public final void e(f.a r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            FLogger.f375446a.i("ResultInputtableControlComponent", "[onAsrStateChanged] state:" + r100);
            if (Intrinsics.areEqual(r100, f.a.C7086a.f524757a) == false) goto L6;
            MutableSharedFlow<g> r101 = com.larus.camera.impl.utils.eventbus.c.f322750a;
            com.larus.camera.impl.utils.eventbus.c.a(this.f322489a.f322481b, new i(op8.i.a.C7088a.f524765a));
            this.f322489a.d().a();
            return;
        L6:
            if (Intrinsics.areEqual(r100, f.a.b.f524758a) == false) goto L9;
            MutableSharedFlow<g> r102 = com.larus.camera.impl.utils.eventbus.c.f322750a;
            com.larus.camera.impl.utils.eventbus.c.a(this.f322489a.f322481b, new i(op8.i.a.C7088a.f524765a));
            this.f322489a.d().a();
            return;
        L9:
            if (Intrinsics.areEqual(r100, f.a.c.f524759a) == false) goto L12;
            MutableSharedFlow<g> r103 = com.larus.camera.impl.utils.eventbus.c.f322750a;
            com.larus.camera.impl.utils.eventbus.c.a(this.f322489a.f322481b, new h(op8.i.a.C7088a.f524765a));
            this.f322489a.d().e();
            return;
        L12:
            if ((r100 instanceof f.a.e) == false) goto L15;
            ResultInputControlBinder.a(this.f322489a, new Pair(((f.a.e) r100).f524761a, 2));
            this.f322489a.d().a();
            return;
        L15:
            if ((r100 instanceof f.a.d) == false) goto L18;
            return;
        L18:
            throw new NoWhenBranchMatchedException();
        }

        @Override // op8.c, op8.f
        public final void f(f.b r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            FLogger.f375446a.i("ResultInputtableControlComponent", "[onInputStateChanged] state:" + r100);
            if (Intrinsics.areEqual(r100, f.b.a.f524762a) == false) goto L5;
        L12:
            f.b r101 = this.f322489a.f322485f;
            boolean r102 = false;
            if (r101 == null) goto L19;
            boolean r103 = !Intrinsics.areEqual(r101, f.b.C7087b.f524763a);
            boolean r104 = !Intrinsics.areEqual(this.f322489a.f322485f, r100);
            if (r103 == false) goto L19;
            if (r104 == false) goto L19;
            r102 = true;
        L19:
            if (r102 == false) goto L23;
            CameraResultViewModel r105 = this.f322489a.f322482c.invoke();
            if (r105 == null) goto L23;
            r105.clickInputFunctionSwitchOnResultPage();
        L23:
            this.f322489a.f322485f = r100;
            return;
        L5:
            if (Intrinsics.areEqual(r100, f.b.c.f524764a) == true) goto L12;
            if (Intrinsics.areEqual(r100, f.b.C7087b.f524763a) == false) goto L11;
            return;
        L11:
            throw new NoWhenBranchMatchedException();
        }

        @Override // op8.c, op8.f
        public final void h(boolean r100) {
            MutableSharedFlow<g> r101 = com.larus.camera.impl.utils.eventbus.c.f322750a;
            com.larus.camera.impl.utils.eventbus.c.a(this.f322489a.f322481b, new e(r100));
        }

        @Override // op8.c, op8.f
        public final void b(int r100, long r101) {
            this.f322489a.d().b(r100, r101);
        }
    }

    public static final class b implements vx8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResultInputControlBinder f322490a;

        @Override // vx8.b
        public final CameraResultViewModel a() {
            return this.f322490a.f322482c.invoke();
        }

        @Override // vx8.b
        public final op8.i b() {
            return (op8.i) this.f322490a.f322487h.getValue();
        }

        @Override // vx8.b
        public final CoroutineScope scope() {
            return this.f322490a.f322481b;
        }

        @Override // vx8.b
        public final void submit() {
            ResultInputControlBinder.a(this.f322490a, new Pair("", 0));
        }

        public b(ResultInputControlBinder r100) {
            this.f322490a = r100;
        }
    }

    public final vx8.a d() {
        d r100 = this.f322484e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new com.larus.camera.impl.ui.component.result.inputtable.strategy.e(this.f322488i);
    }

    public final void b(Flow<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "showInputFlow");
        d().onViewCreated();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(kotlinx.coroutines.flow.e.n(r100), new ResultInputControlBinder$bind$1(this, null)), this.f322481b);
    }

    public static final void a(ResultInputControlBinder r100, Pair r101) {
        CameraResultViewModel r102 = r100.f322482c.invoke();
        if (r102 != null) goto L6;
        return;
    L6:
        if (((CharSequence) r101.getFirst()).length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = "input";
    L12:
        r102.clickSubmitOnResultPage();
        r102.leaveResultPageOnSubmit(r104);
        r102.prepareFreeInputImagePolicy(r101);
        r102.onComplete(r101, "input_control_".concat(r104));
        return;
    L11:
        r104 = TeaEventTrack.ACTION_DRAMA_NEXT;
        goto L12
    L8:
        r103 = false;
        goto L9
    }

    public ResultInputControlBinder(Context r100, CoroutineScope r101, Function0<CameraResultViewModel> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "viewModelProvider");
        this.f322480a = r100;
        this.f322481b = r101;
        this.f322482c = r102;
        this.f322487h = LazyKt.lazy(new com.larus.camera.impl.ui.component.result.inputtable.a(this));
        this.f322488i = new b(this);
    }

    public final View c(LayoutInflater r100, ViewGroup r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "outsideClickParent");
        yx8.a r103 = yx8.c.f569432a;
        yx8.a r104 = yx8.c.f569432a;
        if (Intrinsics.areEqual(r104, yx8.a.b.f569426b) == false) goto L6;
        d r105 = new n(this.f322488i);
    L11:
        this.f322484e = r105;
        View r106 = d().f(r100, r101);
        this.f322483d = r106;
        d().c(r102);
        return r106;
    L6:
        if (Intrinsics.areEqual(r104, yx8.a.c.f569427b) == false) goto L9;
        r105 = new x(this.f322488i);
        goto L11
    L9:
        if (Intrinsics.areEqual(r104, yx8.a.d.f569428b) == false) goto L14;
        FLogger.f375446a.e("ResultInputtableControlComponent", "[createView] unexpected CameraInputStyle.None");
        r105 = new com.larus.camera.impl.ui.component.result.inputtable.strategy.e(this.f322488i);
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }
}

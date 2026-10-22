package com.ss.android.lark.keyboard.biz.plus.inject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import wnb.e;
import wxa.f;

/* JADX INFO: loaded from: classes36.dex */
public final class PlusInnerEndPlugin implements wnb.b<PlusInnerEndPlugin> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f428504i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f428506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f428507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.keyboard.ime.c f428508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f428509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f428510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public wnb.c f428512h;

    public static final class a implements wxa.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlusInnerEndPlugin f428513a;

        @Override // wxa.c
        public final void a(UplinkFileEntity r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
        }

        public a(PlusInnerEndPlugin r100) {
            this.f428513a = r100;
        }

        @Override // wxa.c
        public final void b(UplinkFileEntity r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
            PlusInnerEndPlugin r101 = this.f428513a;
            r101.getClass();
            if (f.d(r100) == false) goto L5;
        L6:
            int r102 = xob.a.f564691a;
            Context r103 = r101.f428505a.f410096a.requireContext();
            String r104 = r101.f428505a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r104, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r104), new Pair("click", "image_media_insert"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r103))});
            return;
        L5:
            if (f.e(r100) == true) goto L6;
        }
    }

    public static final class b implements wnb.b.a<PlusInnerEndPlugin> {
        public b() {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlusInnerEndPlugin f428515a;

        public c(PlusInnerEndPlugin r100) {
            this.f428515a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f428515a.g().z().B() == false) goto L12;
            m r101 = this.f428515a.g().H().k();
            if (r101 == null) goto L7;
            KeyboardMenuItemKey r102 = r101.g();
        L9:
            if (r102 != KeyboardMenuItemKey.Plus) goto L12;
            this.f428515a.g().z().a();
            PlusInnerEndPlugin.f(this.f428515a, false, "plus_click_close");
            return;
        L7:
            r102 = null;
        L12:
            PlusInnerEndPlugin.f(this.f428515a, true, "plus_click_open");
            this.f428515a.g().H().f(KeyboardMenuItemKey.Plus);
        }
    }

    public static final class d implements dya.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlusInnerEndPlugin f428516a;

        public d(PlusInnerEndPlugin r100) {
            this.f428516a = r100;
        }

        @Override // dya.a
        public final void a(boolean r100) {
            PlusInnerEndPlugin r101 = this.f428516a;
            Log.i("PlusInnerEndPlugin", r101.k("FLOW_PLUS_EXTERNAL_SELECT_BEFORE", Boolean.valueOf(r100), "external_callback", r101.f428510f));
            PlusInnerEndPlugin r102 = this.f428516a;
            com.ss.android.lark.keyboard.keyboard2.d r103 = r102.g().H();
            if (r100 == false) goto L8;
            r103.w(KeyboardMenuItemKey.Plus);
            View r104 = r102.f428507c;
            if (r104 == null) goto L7;
            PlusInnerEndPlugin.m(r104, r102.j(), true);
        L7:
            Log.i("PlusInnerEndPlugin", "select plus item.");
        L18:
            PlusInnerEndPlugin r105 = this.f428516a;
            Log.i("PlusInnerEndPlugin", r105.k("FLOW_PLUS_EXTERNAL_SELECT_AFTER", Boolean.valueOf(r100), "external_callback", r105.f428510f));
            return;
        L8:
            m r106 = r103.k();
            if (r106 == null) goto L11;
            KeyboardMenuItemKey r107 = r106.g();
        L13:
            if (r107 != KeyboardMenuItemKey.Plus) goto L15;
            Log.i("PlusInnerEndPlugin", "unSelect plus item.");
            r103.h();
        L15:
            View r108 = r102.f428507c;
            if (r108 == null) goto L18;
            PlusInnerEndPlugin.m(r108, false, true);
            goto L18
        L11:
            r107 = null;
            goto L13
        }
    }

    static {
        f428504i = new b();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        View r100 = this.f428507c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        final View r101 = LayoutInflater.from(this.f428505a.f410096a.requireContext()).inflate(R.layout.item_icon_button_plus, null);
        r101.setOnClickListener(new c(this));
        this.f428507c = r101;
        Intrinsics.checkNotNull(r101);
        if (this.f428508d != null) goto L9;
        com.ss.android.lark.keyboard.ime.a r102 = g().z();
        m(r101, j(), false);
        com.ss.android.lark.keyboard.ime.c r103 = r102.v(this);
        r103.a(new PlusInnerEndPlugin$bindPanelShowHideRotate$1$1(this, r101));
        r103.d(new PlusInnerEndPlugin$bindPanelShowHideRotate$1$2(this, r101));
        this.f428508d = r103;
    L9:
        Job r104 = this.f428509e;
        if (r104 == null) goto L12;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L12:
        this.f428509e = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f428505a.f410096a), null, null, new PlusInnerEndPlugin$bindPanelEvent$1(this, null), 3, null);
        return r101;
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    public final com.ss.android.lark.keyboard.b g() {
        com.ss.android.lark.keyboard.b r100 = this.f428511g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428512h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        com.ss.android.lark.keyboard.ime.c r100 = this.f428508d;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f428508d = null;
        View r101 = this.f428507c;
        if (r101 == null) goto L10;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        this.f428507c = null;
        Job r103 = this.f428509e;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        this.f428509e = null;
        Boolean r104 = this.f428510f;
        Log.i("PlusInnerEndPlugin", k("FLOW_PLUS_STATE_RESET", r104, MapMonitorConst.EVENT_DESTROY, r104));
        this.f428510f = null;
    }

    public final boolean j() {
        if (g().z().B() == false) goto L15;
        m r100 = g().H().k();
        if (r100 == null) goto L7;
        KeyboardMenuItemKey r101 = r100.g();
    L9:
        if (r101 != KeyboardMenuItemKey.Plus) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r102 = false;
        goto L12
    L7:
        r101 = null;
        goto L9
    L15:
        return false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEnd;
    }

    @Override // wnb.b
    public final wnb.b.a<PlusInnerEndPlugin> getKey() {
        return f428504i;
    }

    public PlusInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428505a = r100;
        Lazy r101 = LazyKt.lazy(new PlusInnerEndPlugin$plusExtension$2(this));
        this.f428506b = r101;
        d r102 = new d(this);
        eya.b r103 = (eya.b) r101.getValue();
        if (r103 == null) goto L5;
        r103.Z6(r102);
    L5:
        eya.b r104 = (eya.b) r101.getValue();
        if (r104 == null) goto L9;
        r104.K3(new a(this));
        return;
    }

    public static String l(Object r100) {
        if (r100 == null) goto L5;
        String r101 = Integer.toHexString(System.identityHashCode(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "null";
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428512h = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428511g = r100;
    }

    public static final void f(PlusInnerEndPlugin r100, boolean r101, String r102) {
        Boolean r103 = r100.f428510f;
        if (Intrinsics.areEqual(r103, Boolean.valueOf(r101)) == false) goto L5;
        Log.i("PlusInnerEndPlugin", r100.k("FLOW_PLUS_STATE_SKIP_DUPLICATE", Boolean.valueOf(r101), r102, r103));
        return;
    L5:
        eya.b r104 = (eya.b) r100.f428506b.getValue();
        if (r104 != null) goto L8;
        Log.w("PlusInnerEndPlugin", r100.k("FLOW_PLUS_STATE_EXTENSION_UNAVAILABLE", Boolean.valueOf(r101), r102, r103));
        return;
    L8:
        r100.f428510f = Boolean.valueOf(r101);
        Log.i("PlusInnerEndPlugin", r100.k("FLOW_PLUS_STATE_DISPATCH_BEFORE", Boolean.valueOf(r101), r102, r103));
        r104.d7(r101);
        Log.i("PlusInnerEndPlugin", r100.k("FLOW_PLUS_STATE_DISPATCH_AFTER", Boolean.valueOf(r101), r102, r103));
    }

    public static void m(View r100, boolean r101, boolean r102) {
        if (r101 == false) goto L4;
        float r103 = 45.0f;
    L5:
        if (r102 == true) goto L8;
        r100.animate().cancel();
        r100.setRotation(r103);
        return;
    L8:
        r100.animate().rotation(r103).setDuration(150).start();
        return;
    L4:
        r103 = 0.0f;
        goto L5
    }

    public final String k(String r100, Boolean r101, String r110, Boolean r111) {
        if (this.f428511g == null) goto L5;
        com.ss.android.lark.keyboard.ime.a r102 = g().z();
        m r103 = g().H().k();
        if (r103 == null) goto L9;
        KeyboardMenuItemKey r104 = r103.g();
    L11:
        return r100 + " select=" + r101 + " previous=" + r111 + " source=" + r110 + " keyboardInitialized=true plugin=" + l(this) + " fragment=" + l(this.f428505a.f410096a) + " wrapper=" + l(r102) + " ime=" + r102.getImeState().b() + " panel=" + r102.getPanelState().b() + " wrapperHeight=" + r102.height() + " panelShowing=" + r102.B() + " selected=" + r104;
    L9:
        r104 = null;
        goto L11
    L5:
        return r100 + " select=" + r101 + " previous=" + r111 + " source=" + r110 + " keyboardInitialized=false plugin=" + l(this) + " fragment=" + l(this.f428505a.f410096a);
    }
}

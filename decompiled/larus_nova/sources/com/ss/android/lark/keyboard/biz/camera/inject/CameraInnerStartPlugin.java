package com.ss.android.lark.keyboard.biz.camera.inject;

import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wnb.b;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class CameraInnerStartPlugin implements b<CameraInnerStartPlugin> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f428294e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f428296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f428298d;

    public static final class a implements b.a<CameraInnerStartPlugin> {
        public a() {
        }
    }

    static {
        f428294e = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        View r100 = LayoutInflater.from(this.f428295a.f410096a.requireContext()).inflate(R.layout.item_icon_button_camera, null);
        r100.setOnClickListener(new CameraInnerStartPlugin$getPluginView$1$1(this));
        r100.setOnLongClickListener(new CameraInnerStartPlugin$getPluginView$1$2(this));
        return r100;
    }

    @Override // wnb.b
    public final e b() {
        return new e(UIHelper.dp2px(12.0f), 0, 0, 0);
    }

    @Override // wnb.b
    public final c h() {
        c r100 = this.f428298d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.BOTTOM;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerStart;
    }

    @Override // wnb.b
    public final b.a<CameraInnerStartPlugin> getKey() {
        return f428294e;
    }

    public CameraInnerStartPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428295a = r100;
        this.f428296b = LazyKt.lazy(CameraInnerStartPlugin$cameraExtension$2.INSTANCE);
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428298d = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428297c = r100;
    }

    public static final void f(CameraInnerStartPlugin r100, Function0 r101, String r102) {
        if (((xxa.a) r100.f428296b.getValue()) != null) goto L7;
        Log.e("CameraInnerStartPlugin", "cameraExtension is null, failed to start camera or photo.");
        if (DevEnvUtil.isDevelopPackage(r100.f428295a.f410096a.requireContext()) == false) goto L9;
        UDToast.show(r100.f428295a.f410096a.requireContext(), r102);
        return;
    L9:
        return;
    L7:
        r101.invoke();
    }
}

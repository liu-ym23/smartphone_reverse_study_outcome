package p46;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a<T extends View> implements LynxUIWrapper<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f527676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f527677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o46.a f527678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, Method> f527679d;

    public final e getContext() {
        return null;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void initialize() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void onAttach() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void onDetach() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void onLayoutUpdated() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void updateExtraData(Object r100) {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void updateLayout(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115, int r116, Rect r117) {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void updateLayoutInfo(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115, int r116, Rect r117) {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final T getMInnerView() {
        T r100 = this.f527676a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
    L5:
        return r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final o46.a getMPropSetter() {
        return this.f527678c;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final HashMap<String, Method> getMUIMethods() {
        return this.f527679d;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final int getSign() {
        return this.f527677b;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final T createView(Context r100) {
        return createView(r100, null);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void setMInnerView(T r100) {
        this.f527676a = r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void setMPropSetter(o46.a r100) {
        this.f527678c = r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void setMUIMethods(HashMap<String, Method> r100) {
        this.f527679d = r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public final void setSign(int r100) {
        this.f527677b = r100;
    }
}

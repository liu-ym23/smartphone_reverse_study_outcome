package com.lynx.xelement.input;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.amap.api.col.s.ce;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0011./B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u0019\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b&\u0010*B!\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b&\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/lynx/xelement/input/LynxEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lx6a/e;", "Lx6a/i;", "renderer", "", "setRenderer", "getRenderer", "Landroid/view/View;", "getView", "Lcom/lynx/xelement/input/a$a;", "backSpaceListener", "setBackSpaceListener", "Lcom/lynx/xelement/input/LynxEditText$b;", "copyListener", "setCopyListener", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMPasting", "()Z", "setMPasting", "(Z)V", "mPasting", "f", "getMHasDrawn", "setMHasDrawn", "mHasDrawn", "Lcom/lynx/xelement/input/LynxEditText$c;", ce.f26391f, "Lcom/lynx/xelement/input/LynxEditText$c;", "getOnAttachedToWindowListener", "()Lcom/lynx/xelement/input/LynxEditText$c;", "setOnAttachedToWindowListener", "(Lcom/lynx/xelement/input/LynxEditText$c;)V", "onAttachedToWindowListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxEditText extends AppCompatEditText implements x6a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f384125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.lynx.xelement.input.a f384126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f384127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f384128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x6a.i f384129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f384130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f384131g;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(int r100);
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public final void setBackSpaceListener(com.lynx.xelement.input.a.InterfaceC4581a r100) {
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public final void setCopyListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "copyListener");
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final void c() {
        com.lynx.xelement.input.a r100 = new com.lynx.xelement.input.a();
        this.f384126b = r100;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(this, "editText");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCursorVisible(true);
        int r100 = this.f384128d;
        if (r100 == (-1)) goto L8;
        c r101 = this.f384131g;
        if (r101 == null) goto L9;
        r101.a(r100);
        return;
    L9:
        return;
    }

    public final boolean getMHasDrawn() {
        return this.f384130f;
    }

    public final boolean getMPasting() {
        return this.f384125a;
    }

    public final c getOnAttachedToWindowListener() {
        return this.f384131g;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.f384129e;
    }

    public LynxEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f384128d = -1;
        c();
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        x6a.i r101 = this.f384129e;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        com.lynx.xelement.input.a r102 = this.f384126b;     // Catch: SecurityException -> L10
        if (r102 == null) goto L8;
        r102.setTarget(r101);     // Catch: SecurityException -> L10
    L8:
        this.f384127c = true;
        return this.f384126b;
    L10:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        x6a.i r101 = this.f384129e;
        if (r101 == null) goto L5;
        r101.g(r100);
        r101.c(r100);
    L5:
        super.onDraw(r100);
        this.f384130f = true;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        switch(r100) {
            case 16908321: goto L8;
            case 16908322: goto L5;
            default: goto L4;
        };
    L5:
        this.f384125a = true;
        return super.onTextContextMenuItem(r100);
    L4:
        return super.onTextContextMenuItem(r100);
    L8:
        return super.onTextContextMenuItem(r100);
    }

    public final void setMHasDrawn(boolean r100) {
        this.f384130f = r100;
    }

    public final void setMPasting(boolean r100) {
        this.f384125a = r100;
    }

    public final void setOnAttachedToWindowListener(c r100) {
        this.f384131g = r100;
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f384129e = r100;
    }

    public LynxEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101);
        this.f384128d = -1;
        c();
    }

    @Override // x6a.e
    public final x6a.i createRenderer(PlatformRendererContext r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "platformRendererContext");
        return new x6a.i(r100, r101);
    }

    public LynxEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f384128d = -1;
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        x6a.i r105 = this.f384129e;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}

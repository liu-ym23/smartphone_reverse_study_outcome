package com.bytedance.ies.xelement.input;

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
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0011*+B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b\"\u0010&B!\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\"\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lx6a/e;", "Lx6a/i;", "renderer", "", "setRenderer", "getRenderer", "Landroid/view/View;", "getView", "Lcom/bytedance/ies/xelement/input/f$a;", "backSpaceListener", "setBackSpaceListener", "Lcom/bytedance/ies/xelement/input/LynxEditText$b;", "copyListener", "setCopyListener", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMPasting", "()Z", "setMPasting", "(Z)V", "mPasting", "Lcom/bytedance/ies/xelement/input/LynxEditText$c;", ce.f26391f, "Lcom/bytedance/ies/xelement/input/LynxEditText$c;", "getOnAttachedToWindowListener", "()Lcom/bytedance/ies/xelement/input/LynxEditText$c;", "setOnAttachedToWindowListener", "(Lcom/bytedance/ies/xelement/input/LynxEditText$c;)V", "onAttachedToWindowListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "x-element-input_release"}, k = 1, mv = {1, 6, 0})
public class LynxEditText extends AppCompatEditText implements x6a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f250053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f250054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f250055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x6a.i f250057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f250058g;

    public static final class a {
    }

    public interface b {
        void a();
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

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final void c() {
        f r100 = new f();
        this.f250053b = r100;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(this, "editText");
    }

    public final f d() {
        if (this.f250055d == true) goto L7;
        LLog.w("LynxEditText", "InputConnection has not been initialized yet ");
        return null;
    L7:
        return this.f250053b;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCursorVisible(true);
        int r100 = this.f250056e;
        if (r100 == (-1)) goto L8;
        c r101 = this.f250058g;
        if (r101 == null) goto L9;
        r101.a(r100);
        return;
    L9:
        return;
    }

    public final boolean getMPasting() {
        return this.f250052a;
    }

    public final c getOnAttachedToWindowListener() {
        return this.f250058g;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.f250057f;
    }

    public LynxEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f250056e = -1;
        c();
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        x6a.i r101 = this.f250057f;
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
        f r102 = this.f250053b;     // Catch: SecurityException -> L10
        if (r102 == null) goto L8;
        r102.setTarget(r101);     // Catch: SecurityException -> L10
    L8:
        this.f250055d = true;
        return this.f250053b;
    L10:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        x6a.i r101 = this.f250057f;
        if (r101 == null) goto L5;
        r101.g(r100);
        r101.c(r100);
    L5:
        super.onDraw(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        switch(r100) {
            case 16908321: goto L8;
            case 16908322: goto L6;
            default: goto L5;
        };
    L6:
        this.f250052a = true;
        return super.onTextContextMenuItem(r100);
    L8:
        b r101 = this.f250054c;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNull(r101);
        r101.a();
        return true;
    L12:
        return super.onTextContextMenuItem(r100);
    L5:
        return super.onTextContextMenuItem(r100);
    }

    public final void setBackSpaceListener(f.a r100) {
        f r101 = this.f250053b;
        if (r101 == null) goto L6;
        r101.f250089a = r100;
        return;
    }

    public final void setCopyListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "copyListener");
        this.f250054c = r100;
    }

    public final void setMPasting(boolean r100) {
        this.f250052a = r100;
    }

    public final void setOnAttachedToWindowListener(c r100) {
        this.f250058g = r100;
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f250057f = r100;
    }

    public LynxEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101);
        this.f250056e = -1;
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
        this.f250056e = -1;
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        x6a.i r105 = this.f250057f;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
        if (r105 == null) goto L20;
        LynxBaseUI r107 = r105.f562747h;
        if ((r107 instanceof LynxBaseInputView) == false) goto L12;
        LynxBaseInputView r108 = (LynxBaseInputView) r107;
    L13:
        if (r108 != null) goto L15;
        return;
    L15:
        if (r108.V() == true) goto L17;
        return;
    L17:
        if (r108.f250011J == false) goto L23;
        r108.f250011J = false;
        r108.setFocus(true);
        return;
    L23:
        return;
    L12:
        r108 = null;
        goto L13
    }
}

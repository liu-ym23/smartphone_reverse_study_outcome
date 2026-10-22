package com.ss.android.lark.keyboard.edittext2.base;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.keyboard.edittext2.widget.g;
import com.ss.android.lark.keyboard.edittext2.widget.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\rJ%\u0010\u0013\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010\u0017\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u000e*\b\u0012\u0004\u0012\u0002H\u00110\rH\u0002¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00102\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100\u001b¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/ss/android/lark/keyboard/edittext2/base/IFunctionProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "editors", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", NameKeys.LoadStrategy_Use, "", ExifInterface.LONGITUDE_EAST, "clazz", MonitorConstants.CONNECT_TYPE_GET, "key", "Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction$Key;", "(Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction$Key;)Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", "instanceAndInit", "(Ljava/lang/Class;)Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", "batchEdit", "action", "Lkotlin/Function2;", "Landroid/text/Editable;", "Lkotlin/ExtensionFunctionType;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FunctionEditText extends AppCompatEditText implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Class<? extends com.ss.android.lark.keyboard.edittext2.base.a>> f428959b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, com.ss.android.lark.keyboard.edittext2.base.a> f428960a;

    public static final class a {
    }

    public FunctionEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FunctionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f428959b = new CopyOnWriteArraySet();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final Context context() {
        return getContext();
    }

    public final void c(Function2<? super FunctionEditText, ? super Editable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Editable r101 = getEditableText();
        if ((r101 instanceof p) == true) goto L6;
        Intrinsics.checkNotNull(r101);
        r100.invoke(this, r101);
        return;
    L6:
        p r102 = (p) r101;
        r102.a();
        r100.invoke(this, r101);
        Iterator<p.b> r103 = r102.f429280b.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().f429282b.decrementAndGet();
        goto L8
    L10:
        r102.b();
    }

    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> void d(Class<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Iterator<Class<? extends com.ss.android.lark.keyboard.edittext2.base.a>> r101 = f428959b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Class<? extends com.ss.android.lark.keyboard.edittext2.base.a> r102 = r101.next();
        if (r102.isAssignableFrom(r100) == false) goto L4;
    L9:
        Class<? extends com.ss.android.lark.keyboard.edittext2.base.a> r103 = r102;
        if (r103 != null) goto L13;
        Log.e("FunctionEditText", "use current class " + r100.getName() + " is not registered in support class set");
        return;
    L13:
        Map<Class<?>, com.ss.android.lark.keyboard.edittext2.base.a> r104 = this.f428960a;
        E r105 = r100.newInstance();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.instanceAndInit");
        E r106 = r105;
        r106.A(this);
        r106.d();
        r104.put(r103, r106);
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (KeyboardBaseModule.a().isFeatureGatingEnable("im.messenger.keyboard.pass_attrs_revert") == false) goto L6;
        return r101;
    L6:
        if (r100.extras != null) goto L8;
        r100.extras = new Bundle();
    L8:
        Log.i("FunctionEditText", "set scene for funcEditText");
        Bundle r102 = r100.extras;
        if (r102 == null) goto L11;
        r102.putString("scene", "lark_im");
    L11:
        return r101;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> E q(com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Class<E> r101 = r100.a();
        LinkedHashMap r102 = (LinkedHashMap) this.f428960a;
        E r103 = (E) r102.get(r101);
        if (r103 != null) goto L5;
        E r104 = r101.newInstance();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.instanceAndInit");
        r103 = r104;
        r103.A(this);
        r103.d();
        r102.put(r101, r103);
    L5:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.get");
        return r103;
    }

    public FunctionEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f428960a = new LinkedHashMap();
        setEditableFactory(g.f429265a);
    }

    public /* synthetic */ FunctionEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

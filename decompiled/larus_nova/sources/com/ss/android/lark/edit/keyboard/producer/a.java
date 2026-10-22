package com.ss.android.lark.edit.keyboard.producer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import rcb.f;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseKeyboardHeightProducer f420593a;

    public a(BaseKeyboardHeightProducer r100) {
        this.f420593a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r110, WindowInsetsCompat r111) {
        Intrinsics.checkNotNullParameter(r110, "<unused var>");
        Intrinsics.checkNotNullParameter(r111, "insets");
        BaseKeyboardHeightProducer r112 = this.f420593a;
        boolean r100 = true;
        if (rcb.b.a(r112.f420585a) == true) goto L41;
        Configuration r101 = f.f537199a;
        if (f.a(r112.f420585a) == false) goto L41;
        Object r102 = r112.f420585a.getSystemService("input_method");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L9
        InputMethodManager r103 = (InputMethodManager) r102;     // Catch: Exception -> L9
        Method r104 = r103.getClass().getDeclaredMethod("getInputMethodWindowVisibleHeight", new Class[0]);     // Catch: Exception -> L9
        r104.setAccessible(true);     // Catch: Exception -> L9
        Object r105 = r104.invoke(r103, new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L9
        int r106 = ((Integer) r105).intValue();     // Catch: Exception -> L9
        Log.i("BaseBaseKBH#Producer", "getKeyboardHeightByInvoke height : " + r106);     // Catch: Exception -> L9
    L11:
        Log.i("BaseBaseKBH#Producer", "invokeImpl imeHeight=" + r106 + ';');
        if (r106 > 0) goto L14;
    L16:
        if (r106 > 0) goto L18;
        r106 = 0;
    L18:
        b r113 = (b) r112;
        if (((Boolean) r113.f420602m.getValue()).booleanValue() == false) goto L28;
        if (r106 == 0) goto L22;
    L24:
        if (r106 == 0) goto L26;
        boolean r107 = true;
    L27:
        r113.f420601l = r107;
        goto L28
    L26:
        r107 = false;
        goto L27
    L22:
        if (r113.f420601l == true) goto L24;
        Log.i("InsetsKBH#Producer", "notifyFromInvoke not notify, reason: mIsNotifyNotZero = false");
    L73:
        return r111.consumeSystemWindowInsets();
    L28:
        Context r108 = r113.f420585a.getBaseContext();
        int r109 = rcb.a.f537196a;
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r114 = rcb.a.f537196a;
        if (r114 != (-1)) goto L36;
        Resources r115 = r108.getResources();
        if (r115.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L35;
        int r116 = r115.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r116 <= 0) goto L35;
        int r117 = r115.getDimensionPixelSize(r116);
        rcb.a.f537196a = r117;
    L37:
        BaseKeyboardHeightProducer.b r118 = new BaseKeyboardHeightProducer.b(r106, r117, 0, true);
        if (r106 >= 300) goto L40;
        r118.f420592d = false;
    L40:
        Log.i("InsetsKBH#Producer", "notifyFromInvoke keyboard = " + r118);
        r113.b(r118);
    L35:
        r114 = 0;
    L36:
        r117 = r114;
        goto L37
    L14:
        if (f.b() == false) goto L16;
        r106 = 1;
    L9:
        e = move-exception;
        Log.e("BaseBaseKBH#Producer", "getKeyboardHeightByInvoke height : -1; " + e.getMessage());
        r106 = -1;
    L41:
        Insets r119 = r111.getInsets(WindowInsetsCompat.Type.systemBars());
        Insets r120 = r111.getInsets(WindowInsetsCompat.Type.ime());
        Insets r121 = r111.getInsets(WindowInsetsCompat.Type.captionBar());
        Insets r122 = r111.getInsets(WindowInsetsCompat.Type.navigationBars());
        int r123 = r120.bottom;
        boolean r124 = r111.isVisible(WindowInsetsCompat.Type.ime());
        Log.i("BaseBaseKBH#Producer", "handleInsertsChanged  \n imeInset = " + r120 + " ; \n captionInset = " + r121 + " ; \n navInset = " + r122 + " ; \n systemBarInset = " + r119 + " \n imeHeight = " + r123 + " \n isKeyboardVisible = " + r124);
        Configuration r125 = f.f537199a;
        BaseKeyboardHeightProducer.b r126 = new BaseKeyboardHeightProducer.b(r123, r122.bottom, r121.bottom, r124);
        if (rcb.b.a(r112.f420585a) == false) goto L47;
        if (r124 == false) goto L47;
        if (r126.f420589a != 0) goto L47;
        r126.f420589a = 1;
    L47:
        b r127 = (b) r112;
        Intrinsics.checkNotNullParameter(r126, "data");
        Log.i("InsetsKBH#Producer", "notifyFromInsert keyboard = " + r126);
        if (r126.f420589a == 0) goto L50;
    L52:
        Log.i("InsetsKBH#Producer", "configurationChanged: " + r127.f420598i + "; mHandleChanged: " + r127.f420599j);
        if (r127.f420598i == true) goto L55;
    L63:
        r127.f420596g = r126;
    L64:
        boolean r128 = true;
    L65:
        if (r128 == false) goto L73;
        r127.b(r126);
        if (r126.f420589a != 0) goto L71;
        r100 = false;
    L71:
        r127.f420597h = r100;
        goto L73
    L55:
        if (r127.f420599j == true) goto L63;
        int r129 = r126.f420589a;
        BaseKeyboardHeightProducer.b r130 = r127.f420596g;
        if (r130 == null) goto L59;
        int r131 = r130.f420589a;
    L60:
        if (r129 <= 300) goto L62;
        r127.f420598i = false;
        goto L64
    L62:
        Log.i("InsetsKBH#Producer", "not notify, reason: newKeyboardHeight = " + r129 + "; lastNotifyKeyboardHeight = " + r131);
        r128 = false;
        goto L65
    L59:
        r131 = 0;
        goto L60
    L50:
        if (r127.f420597h == true) goto L52;
        Log.i("InsetsKBH#Producer", "not notify, reason: mIsNotifyNot0 = false");
        goto L73
    }
}

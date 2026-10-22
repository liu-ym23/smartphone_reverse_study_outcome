package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\b\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"intValue", "", "Lcom/google/gson/JsonObject;", "key", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "booleanValue", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "screenHeightPx", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "navigationBarHeightPx", "dpToPx", "dp", "stringValue", "updateLayoutHeight", "", "view", "Landroid/view/View;", "height", "findActivity", "Landroid/app/Activity;", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetHostKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ Activity access$findActivity(Context r100) {
        return findActivity(r100);
    }

    public static final /* synthetic */ int access$navigationBarHeightPx(Context r100) {
        return navigationBarHeightPx(r100);
    }

    public static final /* synthetic */ int access$screenHeightPx(Context r100) {
        return screenHeightPx(r100);
    }

    private static final Activity findActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    private static final int navigationBarHeightPx(Context r100) {
        int r101 = r100.getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getResources().getDimensionPixelSize(r101);
    }

    private static final int screenHeightPx(Context r100) {
        return INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).heightPixels;
    }

    public static final /* synthetic */ Boolean access$booleanValue(JsonObject r100, String r101) {
        return booleanValue(r100, r101);
    }

    public static final /* synthetic */ int access$dpToPx(Context r100, int r101) {
        return dpToPx(r100, r101);
    }

    public static final /* synthetic */ Integer access$intValue(JsonObject r100, String r101) {
        return intValue(r100, r101);
    }

    public static final /* synthetic */ String access$stringValue(JsonObject r100, String r101) {
        return stringValue(r100, r101);
    }

    public static final /* synthetic */ void access$updateLayoutHeight(View r100, int r101) {
        updateLayoutHeight(r100, r101);
    }

    private static final Boolean booleanValue(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonPrimitive() == false) goto L11;
        if (r102.getAsJsonPrimitive().isBoolean() == false) goto L11;
        return Boolean.valueOf(r102.getAsBoolean());
    L11:
        if (r102.isJsonPrimitive() == true) goto L13;
        return null;
    L13:
        if (r102.getAsJsonPrimitive().isString() == true) goto L15;
        return null;
    L15:
        return StringsKt.toBooleanStrictOrNull(r102.getAsString());
    }

    private static final int dpToPx(Context r100, int r101) {
        return (int) (r101 * INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density);
    }

    private static final Integer intValue(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonPrimitive() == false) goto L11;
        if (r102.getAsJsonPrimitive().isNumber() == false) goto L11;
        return Integer.valueOf(r102.getAsInt());
    L11:
        if (r102.isJsonPrimitive() == true) goto L13;
        return null;
    L13:
        if (r102.getAsJsonPrimitive().isString() == true) goto L15;
        return null;
    L15:
        return StringsKt.toIntOrNull(r102.getAsString());
    }

    private static final String stringValue(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        JsonPrimitive r103 = r102.getAsJsonPrimitive();
        if (r103.isString() == false) goto L12;
        return r103.getAsString();
    L12:
        if (r103.isNumber() == true) goto L16;
        if (r103.isBoolean() == true) goto L16;
        return null;
    L16:
        return r103.toString();
    }

    private static final void updateLayoutHeight(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.height != r101) goto L8;
        return;
    L8:
        r102.height = r101;
        r100.setLayoutParams(r102);
        r100.requestLayout();
    }
}

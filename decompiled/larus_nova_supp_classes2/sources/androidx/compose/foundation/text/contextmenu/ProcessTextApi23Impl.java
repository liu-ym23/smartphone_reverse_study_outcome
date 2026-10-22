package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.TextRange;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f06.d;
import j.a;
import j.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010%\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0014\u0010%\u001a\u00020\u0014*\u00020&2\u0006\u0010\t\u001a\u00020\u0006H\u0002RE\u0010\u0004\u001a#\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0093\u0001\u0010\u0011\u001aq\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/ProcessTextApi23Impl;", "", "<init>", "()V", "processTextActivitiesQuery", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "context", "", "Landroid/content/pm/ResolveInfo;", "getProcessTextActivitiesQuery$annotations", "getProcessTextActivitiesQuery", "()Lkotlin/jvm/functions/Function1;", "setProcessTextActivitiesQuery", "(Lkotlin/jvm/functions/Function1;)V", "onClickProcessTextItem", "Lkotlin/Function5;", "resolveInfo", "", "editable", "", "text", "Landroidx/compose/ui/text/TextRange;", "textRange", "", "getOnClickProcessTextItem$annotations", "getOnClickProcessTextItem", "()Lkotlin/jvm/functions/Function5;", "setOnClickProcessTextItem", "(Lkotlin/jvm/functions/Function5;)V", "createProcessTextIntent", "Landroid/content/Intent;", "createProcessTextIntentForResolveInfo", "info", "queryProcessTextActivities", "hasPermission", "Landroid/content/pm/ActivityInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProcessTextApi23Impl {
    public static final int $stable = 0;
    public static final ProcessTextApi23Impl INSTANCE = null;
    private static Function5<? super Context, ? super ResolveInfo, ? super Boolean, ? super CharSequence, ? super TextRange, Unit> onClickProcessTextItem;
    private static Function1<? super Context, ? extends List<? extends ResolveInfo>> processTextActivitiesQuery;

    private ProcessTextApi23Impl() {
    }

    public static /* synthetic */ Unit a(Context r0, ResolveInfo r1, boolean r2, CharSequence r3, TextRange r4) {
        return onClickProcessTextItem$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ List b(Context r0) {
        return processTextActivitiesQuery$lambda$1(r0);
    }

    public static /* synthetic */ void getOnClickProcessTextItem$annotations() {
    }

    public static /* synthetic */ void getProcessTextActivitiesQuery$annotations() {
    }

    static {
        INSTANCE = new ProcessTextApi23Impl();
        processTextActivitiesQuery = new a();
        onClickProcessTextItem = new b();
        $stable = 8;
    }

    private final Intent createProcessTextIntent() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    public final Function5<Context, ResolveInfo, Boolean, CharSequence, TextRange, Unit> getOnClickProcessTextItem() {
        return onClickProcessTextItem;
    }

    public final Function1<Context, List<ResolveInfo>> getProcessTextActivitiesQuery() {
        return processTextActivitiesQuery;
    }

    private static final List processTextActivitiesQuery$lambda$1(Context r7) {
        int r2 = 0;
        List<ResolveInfo> r0 = r7.getPackageManager().queryIntentActivities(INSTANCE.createProcessTextIntent(), 0);
        ArrayList r1 = new ArrayList(r0.size());
        int r3 = r0.size();
    L3:
        if (r2 >= r3) goto L8;
        Object r4 = ListProtector.get(r0, r2);
        ProcessTextApi23Impl r6 = INSTANCE;
        if (r6.hasPermission((ResolveInfo) r4, r7) == false) goto L7;
        r1.add(r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r1;
    }

    public final List<ResolveInfo> queryProcessTextActivities(Context r2) {
        return (List) processTextActivitiesQuery.invoke(r2);
    }

    public final void setOnClickProcessTextItem(Function5<? super Context, ? super ResolveInfo, ? super Boolean, ? super CharSequence, ? super TextRange, Unit> r1) {
        onClickProcessTextItem = r1;
    }

    public final void setProcessTextActivitiesQuery(Function1<? super Context, ? extends List<? extends ResolveInfo>> r1) {
        processTextActivitiesQuery = r1;
    }

    private static int androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private final boolean hasPermission(ResolveInfo r3, Context r4) {
        if (r4.getPackageName().equals(r3.activityInfo.packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasPermission(r3.activityInfo, r4) == true) goto L8;
        return false;
    }

    public final Intent createProcessTextIntentForResolveInfo(ResolveInfo r3, boolean r4) {
        Intent r5 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", r4);
        ActivityInfo r6 = r3.activityInfo;
        return r5.setClassName(r6.packageName, r6.name);
    }

    private final boolean hasPermission(ActivityInfo r2, Context r3) {
        if (r2.exported == false) goto L9;
        String r4 = r2.permission;
        if (r4 != null) goto L7;
    L8:
        return true;
    L7:
        if (androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission(r3, r4) == 0) goto L8;
    L9:
        return false;
    }

    private static final Unit onClickProcessTextItem$lambda$2(Context r3, ResolveInfo r4, boolean r5, CharSequence r6, TextRange r7) {
        String r8 = r6.subSequence(TextRange.getMin-impl(r7.unbox-impl()), TextRange.getMax-impl(r7.unbox-impl())).toString();
        Intent r9 = INSTANCE.createProcessTextIntentForResolveInfo(r4, r5);
        r9.putExtra("android.intent.extra.PROCESS_TEXT", r8);
        r3.startActivity(r9);
        return Unit.INSTANCE;
    }
}

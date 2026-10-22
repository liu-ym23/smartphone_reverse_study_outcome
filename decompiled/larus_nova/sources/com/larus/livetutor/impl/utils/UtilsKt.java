package com.larus.livetutor.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f356659a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f356660b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f356661c = null;

    public static final class a implements com.airbnb.lottie.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f356662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f356663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f356664c;

        @Override // com.airbnb.lottie.j
        public final void a(LottieComposition r100) {
            if (r100 == null) goto L4;
            int r101 = this.f356663b;
            int r102 = this.f356664c;
            LottieAnimationView r103 = this.f356662a;
            Matrix r104 = new Matrix();
            r104.postScale(r101 / r100.getBounds().width(), r102 / r100.getBounds().height());
            r103.setImageMatrix(r104);
        L4:
            this.f356662a.removeLottieOnCompositionLoadedListener(this);
        }

        public a(LottieAnimationView r100, int r101, int r102) {
            this.f356662a = r100;
            this.f356663b = r101;
            this.f356664c = r102;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.livetutor.impl.utils.l] */
    static {
        f356660b = new Handler(Looper.getMainLooper());
        f356661c = new l();
    }

    public static final Context c() {
        return AppHost.f326268a.getApplication().getApplicationContext();
    }

    public static final String a(String r100) {
        if (StringsKt.contains$default(r100, "Chrome/", false, 2, null) == false) goto L12;
        MatchResult r101 = Regex.find$default(new Regex("Chrome/(\\d+\\.\\d+\\.\\d+\\.\\d+)"), r100, 0, 2, null);
        if (r101 == null) goto L19;
        List<String> r102 = r101.getGroupValues();
        if (r102 == null) goto L19;
        String r103 = (String) CollectionsKt.getOrNull(r102, 1);
        if (r103 == null) goto L19;
        return r103;
    L19:
        return "未知版本";
    L12:
        if (StringsKt.contains$default(r100, "AppleWebKit/", false, 2, null) == false) goto L20;
        MatchResult r104 = Regex.find$default(new Regex("AppleWebKit/([\\d.]+)"), r100, 0, 2, null);
        if (r104 == null) goto L19;
        List<String> r105 = r104.getGroupValues();
        if (r105 == null) goto L19;
        String r106 = (String) CollectionsKt.getOrNull(r105, 1);
        if (r106 == null) goto L19;
        return r106;
    L20:
        return "无法从UserAgent解析版本";
    }

    public static final Activity b(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return b(((ContextWrapper) r100).getBaseContext());
    }

    public static final float d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final void r(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = Integer.valueOf(r100.getPaddingLeft());
        int r102 = r100.getPaddingTop();
        i0.f375410a.getClass();
        i(r100, r101, Integer.valueOf(r102 + i0.g()), Integer.valueOf(r100.getPaddingRight()), Integer.valueOf(r100.getPaddingBottom()));
    }

    public static final String t(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + '{' + Integer.toHexString(System.identityHashCode(r100)) + '}';
    }

    public static final String u(Object r100) {
        return GsonProtectorUtils.toJson(new GsonBuilder().registerTypeAdapterFactory(new RpcEnumTypeAdapterFactory()).create(), r100);
    }

    public static final boolean e(long r100, long r101) {
        TimeZone r102 = TimeZone.getDefault();     // Catch: Exception -> L8
        Calendar r103 = Calendar.getInstance(r102);     // Catch: Exception -> L8
        Calendar r104 = Calendar.getInstance(r102);     // Catch: Exception -> L8
        r103.setTimeInMillis(r100);     // Catch: Exception -> L8
        r104.setTimeInMillis(r101);     // Catch: Exception -> L8
        if (r103.get(1) != r104.get(1)) goto L13;
        if (r103.get(6) != r104.get(6)) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        e = move-exception;
        FLogger.f375446a.e("LiveTutorUtils", "isSameDay failed, error=" + e.getMessage());
        return false;
    }

    public static void h(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.setOnClickListener(new c(500, r101));
    }

    public static final void j(JSONObject r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "map");
        if (r101.isEmpty() == true) goto L9;
        Iterator r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.putOpt((String) r103.getKey(), r103.getValue());
        goto L7
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(CustomMarkdownTextView r610, String r611) {
        Intrinsics.checkNotNullParameter(r610, "<this>");
        Intrinsics.checkNotNullParameter(r611, "markdown");
        gw8.c.f483071a.getClass();
        gw8.c r100 = gw8.c.a.b();
        if (r100 != null) goto L5;
        return;
    L5:
        ThematicBreakConfig r101 = new ThematicBreakConfig(Integer.valueOf(c7.b(Double.valueOf(0.5d))), null, 2, null == true ? 1 : 0);
        int r102 = i5.r0();
        int r103 = v19.c.b(R.attr.larus_neutral_transparent_2, r610.getContext(), R.color.larus_neutral_transparent_2);
        TitleStyle r410 = TitleStyle.LARGE;
        int r104 = ContextCompat.getColor(r610.getContext(), R.color.larus_static_black);
        Integer r310 = null;
        boolean r411 = false;
        Integer r510 = null;
        CodeBlockConfig r311 = new CodeBlockConfig(Integer.valueOf(r102), Integer.valueOf(r103), false, null, 0, r310, true, "", false, true, r410, false, Integer.valueOf(ContextCompat.getColor(r610.getContext(), R.color.code_block_bg)), Integer.valueOf(ContextCompat.getColor(r610.getContext(), R.color.code_block_bg)), Integer.valueOf(r104), null, r411, false, null, false, null, r510, null, false, null, false, false, 134187324, null);
        int r312 = v19.c.b(R.attr.larus_neutral_transparent_1, r610.getContext(), R.color.larus_neutral_transparent_1);
        float r105 = i5.q();
        int r106 = i5.b();
        int r107 = v19.c.b(R.attr.larus_neutral_transparent_3_web, r610.getContext(), R.color.larus_neutral_transparent_3_web);
        int r110 = i5.r0();
        Integer r412 = null;
        boolean r108 = false;
        String r109 = null;
        Integer r111 = null;
        int r112 = 0;
        Float r113 = null;
        float r114 = 0.0f;
        Float r115 = null;
        int r116 = 0;
        r610.setMarkdown(gw8.c.b.b(r100, r610, r611, true, new lw8.d(i5.h(), Integer.valueOf(v19.c.b(R.attr.larus_press, r610.getContext(), R.color.larus_press)), r109, r108, r111, r112, r113, r114, r115, r116, 0, null, null, null, null, r101, r311, new TableConfig(true, r312, Float.valueOf(r105), Integer.valueOf(r106), Integer.valueOf(r107), r310, Integer.valueOf(r110), 0, null, null, r412, null, r610.getContext().getString(R.string.larus_chat_list_subtitle_table), Integer.valueOf(i5.m()), true, false, r411, true, false, null, Integer.valueOf(ContextCompat.getColor(r610.getContext(), android.R.color.transparent)), r510, 2985760, null), null, null, null, null, new mw8.b(r610.getTextSize(), r610.getCurrentTextColor()), null, -7344132, 30)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object o(ApiCallConfig r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof UtilsKt$safelyCall$1) == false) goto L7;
        UtilsKt$safelyCall$1 r102 = (UtilsKt$safelyCall$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ApiCallConfig r107 = (ApiCallConfig) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
        r100 = r107;
    L28:
        goto L27
    L18:
        ResultKt.throwOnFailure(r104);
        Function1<? super Continuation<? super Unit>, ? extends Object> r108 = r100.f356637a;     // Catch: Throwable -> L22
        r102.L$0 = r100;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        Object r109 = r108.invoke(r102);     // Catch: Throwable -> L22
        r100 = r109;
        if (r109 != r105) goto L28;
        return r105;
    L22:
        th = move-exception;
        Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r110 = r100.f356638b;
        r102.L$0 = null;
        r102.label = 2;
        if (r110.invoke(th, r102) != r105) goto L27;
        return r105;
    L7:
        r102 = new UtilsKt$safelyCall$1(r101);
        goto L8
    }

    public static final void q(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.height = r101;
        r100.setLayoutParams(r102);
    }

    public static void w(View r100, Function2 r101) {
        EmptyCoroutineContext r102 = EmptyCoroutineContext.INSTANCE;
        CoroutineStart r103 = CoroutineStart.DEFAULT;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "start");
        Intrinsics.checkNotNullParameter(r101, "block");
        LifecycleOwner r104 = ViewTreeLifecycleOwner.get(r100);
        if (r104 == null) goto L8;
        LifecycleCoroutineScope r105 = LifecycleOwnerKt.getLifecycleScope(r104);
        if (r105 == null) goto L9;
        BuildersKt.launch(r105, r102, r103, new UtilsKt$viewLaunch$1(r101, null));
        return;
    L9:
        return;
    }

    public static final void x(ViewModel r100, Function1<? super ApiCallConfig, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        ApiCallConfig r102 = new ApiCallConfig();
        r101.invoke(r102);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r100), Dispatchers.getIO(), null, new UtilsKt$viewModelApiCall$1$1(r102, null), 2, null);
    }

    public static final void y(CoroutineScope r100, com.larus.livetutor.impl.rtc.g r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        ApiCallConfig r102 = new ApiCallConfig();
        r101.invoke(r102);
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new UtilsKt$withApiCall$1$1(r102, null), 2, null);
    }

    public static final void p(LottieAnimationView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setScaleType(ImageView.ScaleType.MATRIX);
        r100.addLottieOnCompositionLoadedListener(new a(r100, r101, r102));
    }

    public static final void s(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 != null) goto L5;
        return;
    L5:
        r103.width = r101;
        r103.height = r102;
        r100.setLayoutParams(r103);
    }

    public static void v(Function0 r100, Function1 r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        String r103 = "tryExtensions";
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = null;
    L9:
        Intrinsics.checkNotNullParameter(r100, "normalLogic");
        Intrinsics.checkNotNullParameter(r103, "catchTag");
        r100.invoke();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        FLogger.f375446a.e(r103, th.toString());     // Catch: Throwable -> L17
        if (r101 == null) goto L23;
        r101.invoke(th);     // Catch: Throwable -> L17
        return;
    L23:
        return;
    L17:
        th = move-exception;
        throw th;
    L5:
        r103 = null;
        goto L7
    }

    public static final Job l(CoroutineScope r100, CoroutineContext r101, CoroutineStart r102, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "start");
        Intrinsics.checkNotNullParameter(r103, "block");
        return BuildersKt.launch(r100, r101, r102, new UtilsKt$safeLaunch$1(r103, null));
    }

    public static /* synthetic */ Job m(CoroutineScope r100, CoroutineDispatcher r101, Function2 r102, int r103) {
        CoroutineContext r104 = r101;
        if ((r103 & 1) == 0) goto L6;
        r104 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L8;
        CoroutineStart r105 = CoroutineStart.DEFAULT;
    L10:
        return l(r100, r104, r105, r102);
    L8:
        r105 = null;
        goto L10
    }

    public static Job n(CoroutineScope r100, CoroutineDispatcher r101, Function2 r102, int r103) {
        CoroutineContext r104 = r101;
        if ((r103 & 1) == 0) goto L6;
        r104 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L8;
        CoroutineStart r105 = CoroutineStart.DEFAULT;
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "start");
        Intrinsics.checkNotNullParameter(r102, "block");
        return l(r100, r104, r105, new UtilsKt$safeLaunchAlive$1(r102, null));
    L8:
        r105 = null;
        goto L9
    }

    public static final void f(View r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        if (r101 == null) goto L10;
        r106.leftMargin = r101.intValue();
    L10:
        if (r102 == null) goto L12;
        r106.topMargin = r102.intValue();
    L12:
        if (r103 == null) goto L14;
        r106.rightMargin = r103.intValue();
    L14:
        if (r104 == null) goto L16;
        r106.bottomMargin = r104.intValue();
    L16:
        r100.setLayoutParams(r106);
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static final void i(View r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L5;
        int r105 = r101.intValue();
    L6:
        if (r102 == null) goto L8;
        int r106 = r102.intValue();
    L9:
        if (r103 == null) goto L11;
        int r107 = r103.intValue();
    L12:
        if (r104 == null) goto L14;
        int r108 = r104.intValue();
    L15:
        r100.setPadding(r105, r106, r107, r108);
        return;
    L14:
        r108 = r100.getPaddingBottom();
        goto L15
    L11:
        r107 = r100.getPaddingRight();
        goto L12
    L8:
        r106 = r100.getPaddingTop();
        goto L9
    L5:
        r105 = r100.getPaddingLeft();
        goto L6
    }

    public static /* synthetic */ void g(View r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = null;
    L14:
        f(r100, r101, r102, r103, r104);
    }
}

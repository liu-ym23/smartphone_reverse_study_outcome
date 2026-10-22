package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import bt3.b;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.d;
import com.bytedance.apm.internal.ApmDelegate;
import ft3.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    public FragmentTimeAgent() {
    }

    static {
        sMethodSet = new HashSet(32);
    }

    public static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    public static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    public static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    public static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ WeakReference access$302(WeakReference r0) {
        sRootViewRef = r0;
        return r0;
    }

    public static /* synthetic */ long access$402(long r0) {
        sCheckVisibilityStartTime = r0;
        return r0;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r0) {
        sOnGlobalLayoutListener = r0;
        return r0;
    }

    private static boolean isValid(String r1) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void onHiddenChanged(Fragment r6, boolean r7) {
        if (r7 == false) goto L12;
        return;
    L12:
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r2 = a.a(r0);     // Catch: Exception -> L11
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void onResumeShow(Fragment r7, String r8) {
        if (r7.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r7.isHidden() == true) goto L20;
        Integer r3 = a.a(r8);     // Catch: Exception -> L14
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r8, r7.getView(), r3, sOnCreateStart, "fragmentOnCreateToViewShow");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    public static void setUserVisibleHint(Fragment r6, boolean r7) {
        if (r7 == true) goto L4;
        return;
    L4:
        if (r6.isResumed() == true) goto L6;
        return;
    L6:
        if (r6.isHidden() == true) goto L22;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r2 = a.a(r0);     // Catch: Exception -> L15
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }

    public static /* synthetic */ void access$200(boolean r0, String r1, long r2, long r4) {
        reportStats(r0, r1, r2, r4);
    }

    public static /* synthetic */ void access$800(String r0, String r1, long r2, long r4) {
        reportTraceTime(r0, r1, r2, r4);
    }

    public static void onTrace(Fragment r3, String r4, String r5, boolean r6) {
        if (TextUtils.equals("onCreate", r5) == false) goto L13;
        if (r6 == false) goto L10;
        sFragmentName = r4;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        sMaxWaitTime = ApmDelegate.g.a.a().b;
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r4) == false) goto L56;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L56:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r5) == false) goto L24;
        if (isValid(r4) == false) goto L24;
        if (r6 == false) goto L21;
        if (sOnCreateStart <= 0) goto L58;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L58:
        return;
    L21:
        if (sOnCreateStart <= 0) goto L60;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L60:
        return;
    L24:
        if (TextUtils.equals("onActivityCreated", r5) == false) goto L35;
        if (isValid(r4) == false) goto L35;
        if (r6 == false) goto L32;
        if (sOnCreateStart <= 0) goto L62;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L62:
        return;
    L32:
        if (sOnCreateStart <= 0) goto L64;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L64:
        return;
    L35:
        if (TextUtils.equals("onResume", r5) == true) goto L37;
        return;
    L37:
        if (isValid(r4) == false) goto L67;
        if (r6 == false) goto L43;
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r3, r4);
        return;
    L68:
        return;
    L43:
        if (sOnCreateStart <= 0) goto L70;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r7 = a.a(r4);     // Catch: Exception -> L52
        if (r7 != null) goto L48;
    L49:
        b.d.a.e(new AnonymousClass1());     // Catch: Exception -> L52
        goto L50
    L48:
        if (r7.intValue() <= 0) goto L49;
    L50:
        sReported = true;
        sFragmentName = null;
        return;
    L70:
        return;
    }

    private static void reportStats(boolean r9, String r10, long r11, long r13) {
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L12
        r3.put("name", "onCreate");     // Catch: Exception -> L12
        r3.put(UploadTypeInf.START, sOnCreateStart);     // Catch: Exception -> L12
        r3.put("end", sOnCreateEnd);     // Catch: Exception -> L12
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L12
        r4.put("name", "onViewCreated");     // Catch: Exception -> L12
        r4.put(UploadTypeInf.START, sOnViewCreatedStart);     // Catch: Exception -> L12
        r4.put("end", sOnViewCreatedEnd);     // Catch: Exception -> L12
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L12
        r5.put("name", "onActivityCreated");     // Catch: Exception -> L12
        r5.put(UploadTypeInf.START, sOnActivityCreatedStart);     // Catch: Exception -> L12
        r5.put("end", sOnActivityCreatedEnd);     // Catch: Exception -> L12
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L12
        r6.put("name", "onResume");     // Catch: Exception -> L12
        r6.put(UploadTypeInf.START, sOnResumeStart);     // Catch: Exception -> L12
        r6.put("end", sOnResumeEnd);     // Catch: Exception -> L12
        JSONArray r7 = new JSONArray();     // Catch: Exception -> L12
        r7.put(r3);     // Catch: Exception -> L12
        r7.put(r4);     // Catch: Exception -> L12
        r7.put(r5);     // Catch: Exception -> L12
        r7.put(r6);     // Catch: Exception -> L12
        if (r10 == null) goto L6;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L12
        r8.put("name", r10);     // Catch: Exception -> L12
        r8.put(UploadTypeInf.START, r11);     // Catch: Exception -> L12
        r8.put("end", r13);     // Catch: Exception -> L12
        r7.put(r8);     // Catch: Exception -> L12
    L6:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L12
        r12.put("name", "page_load_stats");     // Catch: Exception -> L12
        r12.put("page_type", "fragment");     // Catch: Exception -> L12
        r12.put(UploadTypeInf.START, sOnCreateStart);     // Catch: Exception -> L12
        r12.put("spans", r7);     // Catch: Exception -> L12
        if (r9 == false) goto L9;
        int r14 = 2;
    L10:
        r12.put("launch_mode", r14);     // Catch: Exception -> L12
        r12.put("collect_from", 1);     // Catch: Exception -> L12
        r12.put("page_name", sFragmentName);     // Catch: Exception -> L12
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L12
        r15.put("trace", r12);     // Catch: Exception -> L12
        MonitorTool.monitorPerformance("page_load_trace", null, null, r15);     // Catch: Exception -> L12
        return;
    L9:
        r14 = 1;
    L12:
        e = move-exception;
        if (d.j() == false) goto L19;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r7, final String r8, final long r9, final long r11) {
        b.d.a.e(new AnonymousClass2(r8, r9, r11));
    }

    private static void registerOnGlobalLayoutListener(String r2, View r3, final Integer r4, final long r5, final String r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.intValue() <= 0) goto L21;
        sFragmentName = r2;
        WeakReference<View> r6 = sRootViewRef;
        if (r6 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r3);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new AnonymousClass3(r4, r5, r7);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass4();
        bt3.a.a.postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r6.get() == r3) goto L18;
        ViewTreeObserver r8 = sRootViewRef.get().getViewTreeObserver();
        if (r8.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r0 = sOnGlobalLayoutListener;
        if (r0 == null) goto L16;
        r8.removeOnGlobalLayoutListener(r0);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        bt3.a.a.removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }
}

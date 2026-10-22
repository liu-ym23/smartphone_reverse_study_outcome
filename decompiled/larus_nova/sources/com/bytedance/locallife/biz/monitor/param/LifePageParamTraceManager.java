package com.bytedance.locallife.biz.monitor.param;

import android.net.Uri;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class LifePageParamTraceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f256714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f256715b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f256716a = null;

        static {
            int[] r100 = new int[PageParamType.values().length];
            r100[PageParamType.QUERY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PageParamType.SESSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PageParamType.API_TRACK_PARAMS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PageParamType.SOURCE_DETAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f256716a = r100;
        }
    }

    public LifePageParamTraceManager() {
    }

    public static void g() {
        f256714a = false;
        e r100 = f256715b;
        ((ReentrantReadWriteLock) r100.f256747b).readLock().lock();
        boolean r101 = ((ArrayList) r100.f256746a).isEmpty();     // Catch: Throwable -> L11
        ((ReentrantReadWriteLock) r100.f256747b).readLock().unlock();
        if (r101 == true) goto L18;
        r100.a();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.locallife.biz.common.utils.c.c("LifePageParamTrace", "setEnabled false but clear pageStack failed", e);
        return;
    L18:
        return;
    L11:
        th = move-exception;
        ((ReentrantReadWriteLock) r100.f256747b).readLock().unlock();
        throw th;
    }

    static {
        if (HostServiceUtilsKt.u().i() == false) goto L7;
        boolean r100 = h.f256757a;
        if (h.f256757a == false) goto L7;
        boolean r101 = true;
    L8:
        f256714a = r101;
        f256715b = new e();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static final JSONObject a(Uri r100) {
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L11
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: Exception -> L11
        List<String> r104 = UriProtector.getQueryParameters(r100, r103);     // Catch: Exception -> L11
        if (r104.size() == 1) goto L8;
        r101.put(r103, new JSONArray(r104));     // Catch: Exception -> L11
        goto L4
    L8:
        r101.put(r103, ListProtector.get(r104, 0));     // Catch: Exception -> L11
    L13:
        return r101;
    L11:
        e = move-exception;
        com.bytedance.locallife.biz.common.utils.c.c("LifePageParamTrace", "copyFromUri error", e);
        goto L13
    }

    public static void f(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageSessionId");
        if (f256714a == true) goto L5;
        return;
    L5:
        ThreadPoolHelper.b().execute(new i(TaskType.REMOVE_PAGE, new LifePageParamTraceManager$removePage$1(r100)));
    }

    public static final void b(final String r100, KeyPageName r101, PageParamType r102) {
        if (h.f256758b == true) goto L6;
        return;
    L6:
        if (r101 != KeyPageName.PDP_PAGE) goto L14;
        if (r102 != PageParamType.API_TRACK_PARAMS) goto L14;
        final LifePageParamTraceManager$onKeyEvent$1 r103 = LifePageParamTraceManager$onKeyEvent$1.INSTANCE;
        if (f256714a == false) goto L26;
        ThreadPoolHelper.b().execute(new i(TaskType.CHECK_PARAMS, new LifePageParamTraceManager$checkPageParams$1(r100, r103)));
        return;
    L26:
        return;
    L14:
        if (r101 == KeyPageName.CONFIRM_PAGE) goto L16;
        return;
    L16:
        if (r102 != PageParamType.QUERY) goto L24;
        final Function1<d, Unit> r104 = new LifePageParamTraceManager$onKeyEvent$2(r100);
        if (f256714a == false) goto L27;
        ThreadPoolHelper.b().execute(new i(TaskType.CHECK_PARAMS, new LifePageParamTraceManager$checkPageParams$1(r100, r104)));
        return;
    L27:
        return;
    }

    public static final void c(d r100, PageParamType r101, JSONObject r102) {
        int r103 = a.f256716a[r101.ordinal()];
        if (r103 != 1) goto L5;
        Intrinsics.checkNotNullParameter(r102, "params");
        ((ReentrantReadWriteLock) r100.f256732g).writeLock().lock();
        r100.f256728c = new JSONObject(r102.toString());     // Catch: Throwable -> L33
        ((ReentrantReadWriteLock) r100.f256732g).writeLock().unlock();
        r100.e();
        return;
    L33:
        th = move-exception;
        ((ReentrantReadWriteLock) r100.f256732g).writeLock().unlock();
        r100.e();
        throw th;
    L5:
        if (r103 != 2) goto L7;
        Intrinsics.checkNotNullParameter(r102, "params");
        ((ReentrantReadWriteLock) r100.f256733h).writeLock().lock();
        r100.f256729d = new JSONObject(r102.toString());     // Catch: Throwable -> L26
        ((ReentrantReadWriteLock) r100.f256733h).writeLock().unlock();
        r100.e();
        return;
    L26:
        th = move-exception;
        ((ReentrantReadWriteLock) r100.f256733h).writeLock().unlock();
        r100.e();
        throw th;
    L7:
        if (r103 != 3) goto L9;
        Intrinsics.checkNotNullParameter(r102, "params");
        ((ReentrantReadWriteLock) r100.f256734i).writeLock().lock();
        r100.f256730e = new JSONObject(r102.toString());     // Catch: Throwable -> L20
        ((ReentrantReadWriteLock) r100.f256734i).writeLock().unlock();
        r100.e();
        return;
    L20:
        th = move-exception;
        ((ReentrantReadWriteLock) r100.f256734i).writeLock().unlock();
        r100.e();
        throw th;
    L9:
        if (r103 != 4) goto L47;
        Intrinsics.checkNotNullParameter(r102, "params");
        ((ReentrantReadWriteLock) r100.f256735j).writeLock().lock();
        r100.f256731f = new JSONObject(r102.toString());     // Catch: Throwable -> L14
        ((ReentrantReadWriteLock) r100.f256735j).writeLock().unlock();
        r100.e();
        return;
    L14:
        th = move-exception;
        ((ReentrantReadWriteLock) r100.f256735j).writeLock().unlock();
        r100.e();
        throw th;
    }

    public static void d(final KeyPageName r100, final String r101, final PageParamType r102, final Uri r103) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "pageSessionId");
        Intrinsics.checkNotNullParameter(r102, "pageParamType");
        Intrinsics.checkNotNullParameter(r103, "uri");
        if (f256714a == true) goto L5;
        return;
    L5:
        ThreadPoolHelper.b().execute(new i(TaskType.SET_PARAMS_URI, new LifePageParamTraceManager$addPageParams$1(r101, r100, r103, r102)));
    }

    public static void e(final KeyPageName r100, final String r101, final PageParamType r102, final String r103) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "pageSessionId");
        Intrinsics.checkNotNullParameter(r102, "pageParamType");
        Intrinsics.checkNotNullParameter(r103, "jsonParams");
        if (f256714a == true) goto L5;
        return;
    L5:
        ThreadPoolHelper.b().execute(new i(TaskType.SET_PARAMS_JSON, new LifePageParamTraceManager$addPageParams$2(r101, r100, r102, r103)));
    }
}

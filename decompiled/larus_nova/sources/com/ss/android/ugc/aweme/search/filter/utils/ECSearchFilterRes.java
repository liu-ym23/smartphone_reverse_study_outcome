package com.ss.android.ugc.aweme.search.filter.utils;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/utils/ECSearchFilterRes;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterRes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Context> f452966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchFilterRes f452967b = null;

    private ECSearchFilterRes() {
    }

    static {
        f452967b = new ECSearchFilterRes();
        f452966a = new WeakReference(null);
    }

    public final WeakReference<Context> getContext() {
        return f452966a;
    }

    public static int a(int r100) {
        Context r101 = f452966a.get();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return ContextCompat.getColor(r101, r100);
    }

    public static void b(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        r100.setTextColor(a(r101));
    }
}

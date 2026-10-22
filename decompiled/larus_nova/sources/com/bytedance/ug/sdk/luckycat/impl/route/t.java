package com.bytedance.ug.sdk.luckycat.impl.route;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class t implements gn7.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f271472b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f271473a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f271474a;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("TigerBlockRequestInterceptor", "set isTigerBlockRequest=false");     // Catch: Throwable -> L4
            this.f271474a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(t r100) {
            this.f271474a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f271475a;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("TigerBlockRequestInterceptor", "set isTigerBlockRequest=true");     // Catch: Throwable -> L4
            this.f271475a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(t r100) {
            this.f271475a = r100;
        }
    }

    @Override // gn7.f
    public final void a() {
    }

    @Override // gn7.f
    public final boolean b() {
        return true;
    }

    @Override // gn7.f
    public final int d() {
        return 0;
    }

    static {
        f271472b = new Handler(Looper.getMainLooper());
    }

    public t() {
        this.f271473a = new a(this);
    }

    @Override // gn7.f
    public final boolean c(gn7.g r100) {
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.g() == false) goto L39;
        int r102 = r101.k();
        if (r102 < 0) goto L40;
        String r103 = r100.f481827j;
        if (TextUtils.isEmpty(r103) == true) goto L41;
        StringBuilder r104 = new StringBuilder();
        Uri r105 = UriProtector.parse(r103);     // Catch: Exception -> L28
        if (r105 != null) goto L14;
    L30:
        r104.append(" url=");
        r104.append(r103);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("TigerBlockRequestInterceptor", r104.toString());
        return false;
    L14:
        if (r105.isHierarchical() == false) goto L30;
        if ("1".equals(UriProtector.getQueryParameter(r105, "tiger_block_request")) == false) goto L30;
        r104.append(" enable");     // Catch: Exception -> L28
        String r106 = UriProtector.getQueryParameter(r105, "tiger_block_request_timeout");     // Catch: Exception -> L28
        List<String> r107 = LuckyCatUtils.f271506a;     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r106) == false) goto L36;
    L21:
        Integer r108 = null;
    L22:
        r104.append(" timeout=");     // Catch: Exception -> L28
        r104.append(r108);     // Catch: Exception -> L28
        if (r108 == null) goto L30;
        if (r108.intValue() <= 0) goto L30;
        Integer r109 = Integer.valueOf(Math.min(r108.intValue(), r102));     // Catch: Exception -> L28
        r104.append(" maxTimeout=");     // Catch: Exception -> L28
        r104.append(r102);     // Catch: Exception -> L28
        Handler r110 = f271472b;     // Catch: Exception -> L28
        r110.removeCallbacks(this.f271473a);     // Catch: Exception -> L28
        r110.postDelayed(this.f271473a, r109.intValue());     // Catch: Exception -> L28
        r110.post(new b(this));     // Catch: Exception -> L28
        goto L30
    L36:
        r108 = Integer.valueOf(CastIntegerProtector.parseInt(r106));     // Catch: NumberFormatException -> L33 Exception -> L28
    L28:
        e = move-exception;
        r104.append(" errorMsg=");
        r104.append(e.getMessage());
        e.printStackTrace();
        goto L30
    L41:
        return false;
    L40:
        return false;
    L39:
        return false;
    }
}

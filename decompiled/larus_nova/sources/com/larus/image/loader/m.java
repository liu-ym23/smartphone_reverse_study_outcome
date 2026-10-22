package com.larus.image.loader;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f350982g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f350986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f350987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<StackTraceElement> f350988f;

    public static final class a {
    }

    static {
    }

    public final void b(String r100) {
        if (b0.f350967a == false) goto L6;
        FLogger.f375446a.d("flow_image", "Loader@" + this.f350985c + " renewResult=" + r100);
        return;
    }

    public m(String r100, String r101) {
        this.f350983a = r100;
        this.f350984b = r101;
        String r102 = Integer.toHexString(hashCode());
        this.f350985c = r102;
        boolean r103 = b0.f350967a;
        if (r103 == false) goto L5;
        FLogger.f375446a.d("flow_image", "Loader@" + r102 + " init, bizTag=" + r101 + ", imageTestFlag=" + o.a());
    L5:
        if (r103 == false) goto L17;
        StackTraceElement[] r104 = new Throwable().getStackTrace();
        Intrinsics.checkNotNull(r104);
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L22;
        StackTraceElement r107 = r104[r106];
        if (r106 >= 8) goto L23;
        if (this.f350988f != null) goto L13;
        this.f350988f = new ArrayList();
    L13:
        List<StackTraceElement> r108 = this.f350988f;
        if (r108 == null) goto L16;
        Intrinsics.checkNotNull(r107);
        r108.add(r107);
    L16:
        r106 = r106 + 1;
        goto L7
    L23:
        return;
    L22:
        return;
    }

    public final void a(String r100, Uri r101) {
        boolean r102 = b0.f350967a;
        if (r102 == false) goto L6;
        FLogger.f375446a.d("flow_image", "Loader@" + this.f350985c + " finish, loadType=" + this.f350986d + ", finishType=" + r100 + ", skipRenewReason=" + this.f350987e);
    L6:
        if (r102 == false) goto L8;
        FLogger.f375446a.d("flow_image", "Loader@" + this.f350985c + " finish-1, [" + this.f350983a + ", " + this.f350984b + ']');
    L8:
        if (r102 == false) goto L11;
        FLogger.f375446a.d("flow_image", "Loader@" + this.f350985c + " finish-2, [" + r101 + ']');
        return;
    }
}

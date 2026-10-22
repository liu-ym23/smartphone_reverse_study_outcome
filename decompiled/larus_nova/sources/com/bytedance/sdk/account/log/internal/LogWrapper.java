package com.bytedance.sdk.account.log.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.account.log.util.LogFormatter;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class LogWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ub7.a f269166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f269167b;

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/sdk/account/log/internal/LogWrapper$StacktraceThrowable;", "", "()V", "account-sdk-log_release"}, k = 1, mv = {1, 1, 15})
    public static final class StacktraceThrowable extends Throwable {
        public StacktraceThrowable() {
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "LogWrapper(isBeforeInit=" + this.f269167b + ')';
    }

    public LogWrapper(ub7.a r100, boolean r101) {
        this.f269166a = r100;
        this.f269167b = r101;
    }

    public static String a(String r100, Pair[] r101) {
        return r100 + "\n" + LogFormatter.a(r101);
    }

    public final void b(int r100, String r110, String r111, Throwable r112) {
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L12;
        if (r100 == 4) goto L11;
        if (r100 == 5) goto L10;
        if (r100 == 6) goto L9;
        String r101 = "X";
    L14:
        String r113 = "BDAccountSDK/" + r101 + '/' + r110;
        if (this.f269167b == false) goto L17;
        String r114 = "(LogCalledBeforeInit) " + r111;
    L18:
        if (r100 == 2) goto L28;
        if (r100 == 3) goto L27;
        if (r100 == 4) goto L26;
        if (r100 == 5) goto L25;
        if (r100 != 6) goto L34;
        this.f269166a.e(r113, r114, r112);
        return;
    L34:
        return;
    L25:
        this.f269166a.w(r113, r114, r112);
        return;
    L26:
        this.f269166a.i(r113, r114);
        return;
    L27:
        this.f269166a.d(r113, r114);
        return;
    L28:
        this.f269166a.v(r113, r114);
        return;
    L17:
        r114 = String.valueOf(r111);
        goto L18
    L9:
        r101 = ExifInterface.LONGITUDE_EAST;
        goto L14
    L10:
        r101 = ExifInterface.LONGITUDE_WEST;
        goto L14
    L11:
        r101 = "I";
        goto L14
    L12:
        r101 = "D";
        goto L14
    L13:
        r101 = "V";
        goto L14
    }
}

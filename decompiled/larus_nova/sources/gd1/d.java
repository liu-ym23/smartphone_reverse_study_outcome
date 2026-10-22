package gd1;

import com.bytedance.android.live.xplay.basic.api.ErrorCodeException;
import com.bytedance.android.live.xplay.basic.api.XplayErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f480906c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XplayErrorCode f480907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ErrorCodeException f480908b;

    public static final class a {
        public a() {
        }

        public static d b(a r100, Integer r101, String r102) {
            r100.getClass();
            return a(XplayErrorCode.XPLAY_INTERNAL_ERROR, r101, r102, null);
        }

        public static d a(XplayErrorCode r100, Integer r101, String r102, Throwable r103) {
            Intrinsics.checkNotNullParameter(r100, "xplayErrorCode");
            if (r101 != null) goto L10;
            if (r103 != null) goto L10;
            if (r102 != null) goto L10;
            throw new IllegalArgumentException("confirm arguments");
        L10:
            return new d(r100, new ErrorCodeException(r101, r102, r103));
        }
    }

    static {
        f480906c = new a();
    }

    public final int a() {
        XplayErrorCode r100 = this.f480907a;
        if (r100 != XplayErrorCode.XPLAY_INTERNAL_ERROR) goto L8;
        ErrorCodeException r101 = this.f480908b;
        if (r101 == null) goto L8;
        return r101.getCode();
    L8:
        return r100.getCode();
    }

    public final String b() {
        ErrorCodeException r100 = this.f480908b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getMsg();
    L6:
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L17;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f480907a.getErrorMsg());
        r104.append(": ");
        ErrorCodeException r105 = this.f480908b;
        if (r105 == null) goto L15;
        r101 = r105.getMsg();
    L15:
        r104.append(r101);
        return r104.toString();
    L17:
        return this.f480907a.getErrorMsg();
    L8:
        if (r102.length() <= 0) goto L10;
        r103 = true;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public d(XplayErrorCode r100, ErrorCodeException r101) {
        this.f480907a = r100;
        this.f480908b = r101;
    }
}

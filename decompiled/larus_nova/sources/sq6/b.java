package sq6;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.locallife.dito.log.error.API_REQUEST_CLIENT_ERROR;
import com.bytedance.locallife.dito.log.error.API_REQUEST_ERROR;
import com.bytedance.locallife.dito.log.error.API_REQUEST_NETWORK_ERROR;
import com.bytedance.locallife.dito.log.error.API_REQUEST_NETWORK_NOT_AVAILABLE_ERROR;
import com.bytedance.locallife.dito.log.error.API_REQUEST_OTHER_ERROR;
import com.bytedance.locallife.dito.log.error.API_REQUEST_SERVER_ERROR;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.locallife.dito.log.error.a f543074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f543076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f543077d;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_ERROR.f258446a) == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_NETWORK_NOT_AVAILABLE_ERROR.f258448a) == true) goto L16;
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_CLIENT_ERROR.f258445a) == true) goto L16;
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_SERVER_ERROR.f258450a) == true) goto L16;
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_OTHER_ERROR.f258449a) == true) goto L16;
        if (Intrinsics.areEqual(this.f543074a, API_REQUEST_NETWORK_ERROR.f258447a) == true) goto L16;
        return false;
    }

    public final String toString() {
        return this.f543074a.getType() + " : msg = " + this.f543075b + " :params = " + this.f543076c + " :throwable = " + this.f543077d + HTTP.HEADER_LINE_DELIM;
    }

    public b(com.bytedance.locallife.dito.log.error.a r100, String r101, Map<String, String> r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f543074a = r100;
        this.f543075b = r101;
        this.f543076c = r102;
        this.f543077d = r103;
        r102.put("dito_type", r100.getType());
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.put("dito_msg", r101);
        r102.put("dito_exception_level", r100.b().name());
        if (r100.a() == false) goto L8;
        String r104 = "0";
    L9:
        r102.put("dito_exception_type", r104);
        if ((r103 instanceof InvocationTargetException) == false) goto L15;
        Throwable r105 = ((InvocationTargetException) r103).getTargetException();
        if (r105 == null) goto L15;
        r103 = r105;
    L15:
        if (r103 == null) goto L18;
        r102.put("dito_throwable", r103.toString());
        return;
    L18:
        return;
    L8:
        r104 = "1";
        goto L9
    }
}

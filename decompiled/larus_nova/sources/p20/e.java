package p20;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f527362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f527363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Object> f527364c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f527365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f527367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f527368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f527369e;

        public a() {
            this(null, null, null, null, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f527365a, r101.f527365a) == true) goto L8;
            return false;
        L8:
            if (this.f527366b == r101.f527366b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f527367c, r101.f527367c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f527368d, r101.f527368d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f527369e, r101.f527369e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f527365a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f527366b) * 31;
            String r104 = this.f527367c;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f527368d;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f527369e;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "DebugJsbInfo(jsbMethodName=" + this.f527365a + ", statueCode=" + this.f527366b + ", callBackId=" + this.f527367c + ", jsbRequestParam=" + this.f527368d + ", jsbCallBackInfo=" + this.f527369e + ")";
        }

        public /* synthetic */ a(String r100, String r110, String r111, String r112, int r113) {
            if ((r113 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r113 & 2) == 0) goto L9;
            int r102 = -100020;
        L11:
            if ((r113 & 4) == 0) goto L13;
            r110 = "-1";
        L13:
            String r103 = r110;
            if ((r113 & 8) == 0) goto L16;
            String r104 = "";
        L18:
            if ((r113 & 16) == 0) goto L20;
            String r105 = "";
        L21:
            this(r101, r102, r103, r104, r105);
            return;
        L20:
            r105 = r112;
            goto L21
        L16:
            r104 = r111;
            goto L18
        L9:
            r102 = 0;
            goto L11
        L5:
            r101 = r100;
            goto L7
        }

        public a(String r100, int r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r102, "callBackId");
            this.f527365a = r100;
            this.f527366b = r101;
            this.f527367c = r102;
            this.f527368d = r103;
            this.f527369e = r104;
        }
    }

    static {
        f527362a = "";
        f527363b = new ArrayList();
        f527364c = new ArrayList();
        if (v.a() == false) goto L7;
        Observable.create(f.f527370a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(g.f527371a, h.f527372a);
        return;
    }

    public static boolean a() {
        if (v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if ((!Intrinsics.areEqual(f527362a, "")) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (v.a() == false) goto L5;
    L42:
        int r101 = r100.length();     // Catch: Exception -> L39
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L17;
        if (r100.charAt(r102) != '{') goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L18;
        r102 = r102 + 1;     // Catch: Exception -> L39
    L18:
        int r104 = r100.length() - 1;     // Catch: Exception -> L39
    L19:
        if (r104 < 0) goto L27;
        if (r100.charAt(r104) != '}') goto L23;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L28;
        r104 = r104 - 1;     // Catch: Exception -> L39
    L28:
        if (r102 == (-1)) goto L38;
        if (r104 == (-1)) goto L48;
        JSONObject r106 = new JSONObject(r100.substring(r102, r104 + 1));     // Catch: Exception -> L39
        String r107 = r106.optString("__callback_id");     // Catch: Exception -> L39
        JSONObject r108 = r106.optJSONObject("__params");     // Catch: Exception -> L39
        if (Intrinsics.areEqual(r106.optString("__msg_type"), "callback") == false) goto L49;
        ALogger.i("DebugHybridTools", "getResultFromLoadUrl-> jsbInfo=" + r108 + " ， url" + r100);     // Catch: Exception -> L39
        a r109 = new a(null, r107, null, r108.toString(), 11);     // Catch: Exception -> L39
        Intrinsics.checkNotNullParameter(r109, "jsbInfo");     // Catch: Exception -> L39
        if (a() == false) goto L50;
        ALogger.i("DebugHybridTools", "addResultJsbCallInfo-> jsbInfo=" + r109);     // Catch: Exception -> L39
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L38:
        return;
    L23:
        r105 = false;
        goto L24
    L27:
        r104 = -1;
        goto L28
    L13:
        r103 = false;
        goto L14
    L17:
        r102 = -1;
    L39:
        e = move-exception;
        ALogger.e("DebugHybridTools", e);
        return;
    L5:
        if (StringsKt.startsWith$default(r100, "javascript:", false, 2, null) == true) goto L42;
    }
}

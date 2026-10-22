package yo0;

import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f568624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f568626c;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C8364a f568627d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f568628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f568629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f568630c;

        /* JADX INFO: renamed from: yo0.d$a$a, reason: collision with other inner class name */
        public static final class C8364a {
            public C8364a() {
            }

            public static a b(OpenApiErrorInfo r100, JSONObject r101) {
                Intrinsics.checkNotNullParameter(r100, "errorInfo");
                return a(r100.getErrorCode(), r100.getErrorMsg(), r101);
            }

            public static a a(int r100, String r101, JSONObject r102) {
                Intrinsics.checkNotNullParameter(r101, "errMsg");
                switch(r100) {
                    case 408: goto L25;
                    case 10001: goto L24;
                    case 10002: goto L24;
                    case 10003: goto L23;
                    case 10004: goto L22;
                    case 10011: goto L21;
                    case 10013: goto L20;
                    case 20003: goto L19;
                    case 20087: goto L18;
                    case 40023: goto L17;
                    case 40033: goto L16;
                    case 41001: goto L15;
                    case 90203: goto L14;
                    case 90204: goto L14;
                    case 90504: goto L13;
                    case 4001010: goto L24;
                    case 4001011: goto L24;
                    case 4005024: goto L16;
                    case 4008074: goto L12;
                    case 4014016: goto L11;
                    case 4014023: goto L10;
                    case 4014031: goto L22;
                    case 4014034: goto L9;
                    case 4014035: goto L8;
                    case 4014036: goto L7;
                    case 4014038: goto L21;
                    case 4014040: goto L22;
                    case 4014044: goto L6;
                    case 4014045: goto L16;
                    case 4014047: goto L13;
                    case 4014048: goto L13;
                    case 4014052: goto L13;
                    case 4019001: goto L5;
                    default: goto L4;
                };
            L4:
                OpenApiErrorInfo r103 = null;
            L26:
                if (r103 == null) goto L28;
                r100 = r103.getErrorCode();
                r101 = r103.getErrorMsg();
            L28:
                a r104 = new a(r100);
                Intrinsics.checkNotNullParameter(r101, "errMsg");
                r104.f568628a = r101;
                r104.f568629b = r102;
                return r104;
            L5:
                r103 = OpenApiErrorInfo.LOGIN_OUT_DATE;
                goto L26
            L6:
                r103 = OpenApiErrorInfo.PAY_DIAMONDS_REACH_LIMIT;
                goto L26
            L7:
                r103 = OpenApiErrorInfo.INVALID_ACCESS_TOKEN;
                goto L26
            L8:
                r103 = OpenApiErrorInfo.SENSITIVE_WORD_DETECTED;
                goto L26
            L9:
                r103 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
                goto L26
            L10:
                r103 = OpenApiErrorInfo.USER_NOT_IN_ROOM;
                goto L26
            L11:
                r103 = OpenApiErrorInfo.APP_NOT_LAUNCH;
                goto L26
            L12:
                r103 = OpenApiErrorInfo.REWARD_REACH_LIMIT;
                goto L26
            L13:
                r103 = OpenApiErrorInfo.INCORRECT_PARAMS;
                goto L26
            L14:
                r103 = OpenApiErrorInfo.NET_REQUEST_CONCURRENCY_EXCEED_LIMIT;
                goto L26
            L15:
                r103 = OpenApiErrorInfo.ACCOUNT_EXCEPTION;
                goto L26
            L16:
                r103 = OpenApiErrorInfo.DATA_ALREADY_EXIST;
                goto L26
            L17:
                r103 = OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE;
                goto L26
            L18:
                r103 = OpenApiErrorInfo.ILLEGAL_APP_ID;
                goto L26
            L19:
                r103 = OpenApiErrorInfo.NOT_LOGIN;
                goto L26
            L20:
                r103 = OpenApiErrorInfo.INVALID_URL_PARAMS;
                goto L26
            L21:
                r103 = OpenApiErrorInfo.INCORRECT_PARAMS;
                goto L26
            L22:
                r103 = OpenApiErrorInfo.DATA_NOT_EXIST;
                goto L26
            L23:
                r103 = OpenApiErrorInfo.SIGNATURE_ERROR;
                goto L26
            L24:
                r103 = OpenApiErrorInfo.INTERNAL_ERROR;
                goto L26
            L25:
                r103 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
                goto L26
            }
        }

        static {
            f568627d = new C8364a();
        }

        public final d a() {
            return new d(this.f568630c, this.f568628a, this.f568629b);
        }

        public a(int r100) {
            this.f568630c = r100;
            this.f568628a = "";
        }
    }

    public static final class b {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = this.f568626c;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        r101.put("errCode", this.f568624a);
        Unit r102 = Unit.INSTANCE;
        r100.put("data", r101);
        r100.put("resultCode", this.f568624a);
        return r100;
    }

    public d(int r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.f568624a = r100;
        this.f568625b = r101;
        this.f568626c = r102;
    }
}

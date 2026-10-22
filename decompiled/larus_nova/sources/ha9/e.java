package ha9;

import com.larus.flowsdk.common.experiment.FlowABValueType;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f484420a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f484421a = null;

        static {
            int[] r100 = new int[FlowABValueType.values().length];
            r100[FlowABValueType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[FlowABValueType.INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[FlowABValueType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[FlowABValueType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[FlowABValueType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[FlowABValueType.DICT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[FlowABValueType.ARRAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f484421a = r100;
        }
    }

    static {
        f484420a = new e();
    }

    public e() {
    }

    public static Object a(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L7;
        Object r101 = new JSONObject(((JSONObject) r100).toString());
    L9:
        return r101;
    L7:
        if ((r100 instanceof JSONArray) == false) goto L10;
        r101 = new JSONArray(((JSONArray) r100).toString());
        goto L9
    L10:
        return r100;
    }
}

package fn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckType;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477928a = 0;

    /* JADX INFO: renamed from: fn6.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5931a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f477929a = null;

        static {
            int[] r100 = new int[CheckType.values().length];
            r100[CheckType.COVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CheckType.VALID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f477929a = r100;
        }
    }

    static {
    }

    public static String a(Object r100, String r101) {
        if ((r100 instanceof JSONObject) == false) goto L6;
        return ((JSONObject) r100).optString(r101);
    L6:
        if ((r100 instanceof Map) == false) goto L10;
        Object r102 = ((Map) r100).get(r101);
        if ((r102 instanceof String) == false) goto L10;
        return (String) r102;
    L10:
        return null;
    }
}

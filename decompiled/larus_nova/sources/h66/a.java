package h66;

import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.XDynamicType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: h66.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6105a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483922a = null;

        static {
            int[] r100 = new int[XDynamicType.values().length];
            r100[XDynamicType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[XDynamicType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[XDynamicType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[XDynamicType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[XDynamicType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[XDynamicType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[XDynamicType.Array.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[XDynamicType.ByteArray.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[XDynamicType.Null.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f483922a = r100;
        }
    }

    public static final Object a(IDLXDynamic r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        XDynamicType r101 = r100.getType();
        switch(C6105a.f483922a[r101.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L9:
        return r100.asByteArray();
    L11:
        return r100.asArray();
    L13:
        return r100.asMap();
    L15:
        return Integer.valueOf(r100.asInt());
    L17:
        return Long.valueOf(r100.asLong());
    L19:
        return Boolean.valueOf(r100.asBoolean());
    L21:
        return Double.valueOf(r100.asDouble());
    L23:
        return r100.asString();
    }

    public static final Object b(IDLXDynamic r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        XDynamicType r101 = r100.getType();
        switch(C6105a.f483922a[r101.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        return JSONObject.NULL;
    L9:
        return r100.asByteArray();
    L11:
        return com.bytedance.ies.xbridge.utils.a.a(r100.asArray());
    L13:
        return com.bytedance.ies.xbridge.utils.a.b(r100.asMap());
    L15:
        return Integer.valueOf(r100.asInt());
    L17:
        return Long.valueOf(r100.asLong());
    L19:
        return Boolean.valueOf(r100.asBoolean());
    L21:
        return Double.valueOf(r100.asDouble());
    L23:
        return r100.asString();
    }
}

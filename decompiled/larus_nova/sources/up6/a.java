package up6;

import androidx.camera.video.AudioStats;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.XDynamicType;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7913a f551056a = null;

    /* JADX INFO: renamed from: up6.a$a, reason: collision with other inner class name */
    public static final class C7913a {

        /* JADX INFO: renamed from: up6.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7914a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f551057a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f551058b = null;

            static {
                int[] r100 = new int[XDynamicType.values().length];
                r100[XDynamicType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
            L34:
                r100[XDynamicType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
            L52:
                r100[XDynamicType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            L42:
                r100[XDynamicType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
            L44:
                r100[XDynamicType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
            L32:
                r100[XDynamicType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
            L46:
                r100[XDynamicType.Array.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
            L48:
                r100[XDynamicType.ByteArray.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
            L36:
                r100[XDynamicType.Null.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
            L14:
                f551057a = r100;
                int[] r101 = new int[ReadableType.values().length];
                r101[ReadableType.Array.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
            L54:
                r101[ReadableType.Map.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
            L38:
                r101[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
            L18:
                f551058b = r101;
            }
        }

        public C7913a() {
        }

        public static Number a(Number r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(Integer.valueOf(r100.intValue()));     // Catch: Throwable -> L4
        L6:
            Object r103 = null;
            if (Result.m9455isFailureimpl(r102) == false) goto L9;
            r102 = null;
        L9:
            Integer r104 = (Integer) r102;
            if (r104 == null) goto L12;
            int r105 = r104.intValue();
        L35:
            Object r106 = Result.m9449constructorimpl(Double.valueOf(r100.doubleValue()));     // Catch: Throwable -> L15
        L18:
            if (Result.m9455isFailureimpl(r106) == true) goto L21;
            r103 = r106;
        L21:
            Double r107 = (Double) r103;
            if (r107 == null) goto L24;
            double r108 = r107.doubleValue();
        L26:
            if (Double.compare(r105, r108) == 0) goto L28;
            long r109 = (long) r108;
            if (Double.compare(r108, r109) != 0) goto L34;
            return Long.valueOf(r109);
        L34:
            return Double.valueOf(r108);
        L28:
            return Integer.valueOf(r105);
        L24:
            r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L15:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L18
        L12:
            r105 = 0;
        L4:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        public static Object b(IDLXDynamic r100) {
            XDynamicType r101 = r100.getType();
            switch(C7914a.f551057a[r101.ordinal()]) {
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

        public static JSONArray c(JavaOnlyArray r100) {
            JSONArray r101 = new JSONArray();
            int r102 = r100.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L42;
            Object r104 = r100.get(r103);
            ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L43
            if (r105 != null) goto L8;
            int r106 = -1;
        L9:
            boolean r107 = true;
            if (r106 != 1) goto L12;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
            r101.put(c((JavaOnlyArray) r104));
            goto L41
        L12:
            if (r106 != 2) goto L14;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
            r101.put(d((JavaOnlyMap) r104));
            goto L41
        L14:
            if (r106 == 3) goto L25;
            if (r104 == null) goto L41;
            if ((r104 instanceof String) == false) goto L20;
            r101.put(r104);     // Catch: Throwable -> L43
            goto L41
        L20:
            if ((r104 instanceof Boolean) == false) goto L23;
            r101.put(((Boolean) r104).booleanValue());     // Catch: Throwable -> L43
            goto L41
        L23:
            if ((r104 instanceof IDLXDynamic) == false) goto L41;
            r101.put(b((IDLXDynamic) r104));     // Catch: Throwable -> L43
            goto L41
        L25:
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L43
            Number r108 = a((Number) r104);     // Catch: Throwable -> L43
            if ((r108 instanceof Integer) == false) goto L29;
            r101.put(r108.intValue());     // Catch: Throwable -> L43
            goto L41
        L29:
            if ((r108 instanceof Double) == false) goto L32;
            r101.put(r108.doubleValue());     // Catch: Throwable -> L43
            goto L41
        L32:
            if ((r108 instanceof Long) == true) goto L35;
            r107 = r108 instanceof Float;     // Catch: Throwable -> L43
        L35:
            if (r107 == false) goto L37;
            r101.put(r108.doubleValue());     // Catch: Throwable -> L43
            goto L41
        L37:
            r101.put(r108);     // Catch: Throwable -> L43
            goto L41
        L8:
            r106 = C7914a.f551058b[r105.ordinal()];     // Catch: Throwable -> L43
        L41:
            r103 = r103 + 1;
            goto L3
        L42:
            return r101;
        }

        public static JSONObject d(JavaOnlyMap r100) {
            JSONObject r101 = new JSONObject();
            if (r100.isEmpty() == false) goto L5;
            return r101;
        L5:
            ReadableMapKeySetIterator r102 = r100.keySetIterator();
        L7:
            if (r102.hasNextKey() == false) goto L46;
            String r103 = r102.nextKey();
            Object r104 = r100.get(r103);
            ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L45
            if (r105 != null) goto L12;
            int r106 = -1;
        L13:
            boolean r107 = true;
            if (r106 != 1) goto L16;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
            r101.put(r103, c((JavaOnlyArray) r104));
            goto L7
        L16:
            if (r106 != 2) goto L18;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
            r101.put(r103, d((JavaOnlyMap) r104));
            goto L7
        L18:
            if (r106 != 3) goto L19;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L45
            Number r108 = a((Number) r104);     // Catch: Throwable -> L45
            if ((r108 instanceof Integer) == true) goto L31;
            if ((r108 instanceof Double) == true) goto L34;
            if ((r108 instanceof Long) == true) goto L39;
            r107 = r108 instanceof Float;     // Catch: Throwable -> L45
        L39:
            if (r107 == true) goto L40;
            r101.put(r103, r108);     // Catch: Throwable -> L45
            goto L7
        L40:
            r101.put(r103, r108.doubleValue());     // Catch: Throwable -> L45
            goto L7
        L34:
            r101.put(r103, r108.doubleValue());     // Catch: Throwable -> L45
            goto L7
        L31:
            r101.put(r103, r108.intValue());     // Catch: Throwable -> L45
            goto L7
        L19:
            if (r104 == null) goto L7;
            if ((r104 instanceof String) == true) goto L22;
            if ((r104 instanceof Boolean) == true) goto L25;
            if ((r104 instanceof IDLXDynamic) == false) goto L7;
            r101.put(r103, b((IDLXDynamic) r104));     // Catch: Throwable -> L45
            goto L7
        L25:
            r101.put(r103, ((Boolean) r104).booleanValue());     // Catch: Throwable -> L45
            goto L7
        L22:
            r101.put(r103, r104);     // Catch: Throwable -> L45
            goto L7
        L12:
            r106 = C7914a.f551058b[r105.ordinal()];     // Catch: Throwable -> L45
            goto L13
        L46:
            return r101;
        }
    }

    static {
        f551056a = new C7913a();
    }
}

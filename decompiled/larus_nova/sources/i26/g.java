package i26;

import android.os.Bundle;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableTypeWrapper;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.TemplateData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {
    public static final e a(ReadableArray r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new e(r100);
    }

    public static final f b(ReadableMap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new f(r100);
    }

    public static final ReadableTypeWrapper c(ReadableType r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        switch(b.f488042a[r100.ordinal()]) {
            case 1: goto L15;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L17;
        };
    L17:
        return ReadableTypeWrapper.Null;
    L18:
        return ReadableTypeWrapper.ByteArray;
    L19:
        return ReadableTypeWrapper.Long;
    L20:
        return ReadableTypeWrapper.Array;
    L21:
        return ReadableTypeWrapper.Map;
    L22:
        return ReadableTypeWrapper.String;
    L23:
        return ReadableTypeWrapper.Number;
    L24:
        return ReadableTypeWrapper.Int;
    L15:
        return ReadableTypeWrapper.Boolean;
    }

    public static final TemplateData d(p46.f r100) {
        String r101 = r100.f527682b;
        if (r101 == null) goto L5;
        TemplateData r102 = TemplateData.fromString(r101);
    L6:
        Map<String, Object> r103 = r100.f527681a;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r105 = r103.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, Object> r106 = r105.next();
        if ((r106.getValue() instanceof Bundle) == false) goto L8;
        r104.put(r106.getKey(), r106.getValue());
        goto L8
    L12:
        Iterator r107 = r104.entrySet().iterator();
    L14:
        if (r107.hasNext() == false) goto L27;
        Map.Entry r108 = (Map.Entry) r107.next();
        Map<String, Object> r109 = r100.f527681a;
        Object r110 = r108.getKey();
        Object r111 = r108.getValue();
        if (r111 == null) goto L26;
        Bundle r112 = (Bundle) r111;
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator<T> r114 = r112.keySet().iterator();
    L19:
        if (r114.hasNext() == false) goto L24;
        String r115 = (String) r114.next();
        Object r116 = r112.get(r115);
        if (r116 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r113.put(r115, r116);
        goto L19
    L24:
        r109.put((String) r110, r113);
        goto L14
    L26:
        throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
    L27:
        r102.updateData(r100.f527681a);
        return r102;
    L5:
        r102 = TemplateData.empty();
        goto L6
    }
}

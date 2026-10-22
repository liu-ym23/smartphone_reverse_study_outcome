package xv6;

import androidx.collection.ArrayMap;
import com.bytedance.locallife.model.response.Required;
import com.bytedance.locallife.model.response.exceptions.ApiServerException;
import com.bytedance.locallife.model.response.exceptions.JSONParseException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {
    private static final Object LOCK = null;
    private static final Map<Class<?>, List<Field>> REQUIRED_MAP = null;

    public a() {
    }

    static {
        LOCK = new Object();
        REQUIRED_MAP = Collections.synchronizedMap(new ArrayMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T checkValid() throws Throwable {
        Class<?> r100 = getClass();
        initRequiredFieldMap(r100);
        List<Field> r101 = REQUIRED_MAP.get(r100);
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Field r104 = (Field) ListProtector.get(r101, r103);     // Catch: IllegalAccessException -> L9
        if (r104.get(this) == null) goto L8;
        r103 = r103 + 1;     // Catch: IllegalAccessException -> L9
        goto L3
    L8:
        throw new JsonSyntaxException("Unexpected null value in " + r100.getName() + ", required field: " + r104.getName());     // Catch: IllegalAccessException -> L9
    L10:
        throw new AssertionError();
    L11:
        return this;
    }

    public static RuntimeException getCompatibleException(ExecutionException r100) throws Exception {
        Throwable r101 = r100.getCause();
        if ((r101 instanceof ApiServerException) == false) goto L7;
        return (ApiServerException) r101;
    L7:
        if ((r101 instanceof JsonParseException) == false) goto L11;
        return new JSONParseException(r101);
    L11:
        throw ((Exception) r101);
    }

    public static void initRequiredFieldMap(Class<?> r100) {
        if (REQUIRED_MAP.get(r100) != null) goto L18;
        Object r101 = LOCK;
        monitor-enter(r101);
        Field[] r102 = r100.getDeclaredFields();     // Catch: Throwable -> L15
        ArrayList r103 = new ArrayList(r102.length);     // Catch: Throwable -> L15
        int r104 = r102.length;     // Catch: Throwable -> L15
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        Field r106 = r102[r105];     // Catch: Throwable -> L15
        if (r106.getAnnotation(Required.class) == null) goto L11;
        r106.setAccessible(true);     // Catch: Throwable -> L15
        r103.add(r106);     // Catch: Throwable -> L15
    L11:
        r105 = r105 + 1;     // Catch: Throwable -> L15
        goto L7
    L12:
        REQUIRED_MAP.put(r100, Collections.unmodifiableList(r103));     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}

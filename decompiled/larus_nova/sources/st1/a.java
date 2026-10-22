package st1;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {
    public a() {
    }

    public abstract Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a();

    public Map<String, Function1<Object, Unit>> b() {
        return null;
    }

    public abstract void c();
}

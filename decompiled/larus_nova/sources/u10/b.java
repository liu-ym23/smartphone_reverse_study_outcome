package u10;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    void a(String r100, String r101, String r102, Map<String, String> r103, byte[] r104, String r105, long r106, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r107, Function1<? super Throwable, Unit> r110, boolean r111);

    void b(String r100, String r101, String r102, Map<String, String> r103, Map<String, String> r104, long r105, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r106, Function1<? super Throwable, Unit> r107, boolean r110);

    boolean c();
}

package os6;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface d {
    long a();

    void b(Context r100, b r101, a r102, Function2<? super Boolean, ? super String, Unit> r103);

    boolean c();

    String d();

    String e();

    void f(int r100, int r101, Function1<? super JSONObject, Unit> r102);

    void g(Context r100, String r101, String r102, f r103);

    String getAvatarUrl();

    String getNickName();

    String getSecUid();

    String getUid();

    String getUniqueId();

    boolean isLogin();
}

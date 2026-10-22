package yj;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface s {
    void a();

    void b();

    void c();

    void d();

    void e(Activity r100, String r101, String r102, Function0 r103, Function1 r104);

    String getAccessToken();

    String getCurrentUserId();

    boolean isLogin();
}

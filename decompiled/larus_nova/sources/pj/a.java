package pj;

import android.app.Activity;
import android.os.Bundle;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    long a();

    Observable<Boolean> b();

    boolean c(String r100);

    void d(Activity r100, String r101, String r102, String r103, Function0<Unit> r104, Function0<Unit> r105);

    void e(Activity r100, String r101, String r102, Bundle r103, Function0<Unit> r104, Function0<Unit> r105);

    String f();

    String getAccessToken();

    String getCurrentUserId();

    boolean isLogin();

    void showLogin(Activity r100, String r101, String r102, Function0<Unit> r103, Function0<Unit> r104);
}

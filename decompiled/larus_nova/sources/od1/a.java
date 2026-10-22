package od1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.account.api.AuthScope;
import com.bytedance.android.livesdk.user.l;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends IService {

    /* JADX INFO: renamed from: od1.a$a, reason: collision with other inner class name */
    public interface InterfaceC7035a {
    }

    boolean blockReport();

    boolean enableRevokeAuthorizationInRoom();

    String getAccessToken();

    String getOpenId();

    boolean hostIsLogin();

    boolean interceptEnterRoom();

    d report();

    void requestRefresh(AuthScope r100, InterfaceC7035a r101, Activity r102, boolean r103, Map<String, String> r104);

    void requestUserLogIn(Context r100, l r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103);

    void revokeAuthorization();

    boolean shouldTreatAsLoggedIn();
}

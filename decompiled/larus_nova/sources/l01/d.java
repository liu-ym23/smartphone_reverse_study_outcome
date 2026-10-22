package l01;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.Single;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface d extends f80.a, dy0.c {
    IBaseUser b();

    String getCurrentUserId();

    boolean isLogin();

    Single<IBaseUser> t3(Context r100);

    Single<IBaseUser> z4(Context r100, Function1<? super ds2.b, Unit> r101);
}

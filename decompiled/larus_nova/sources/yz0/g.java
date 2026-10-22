package yz0;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface g extends dy0.d, f80.b, j {
    Observable<? extends IBaseUser> L0();

    Context getContext();

    IBaseUser getUser();

    boolean isAnchor();
}

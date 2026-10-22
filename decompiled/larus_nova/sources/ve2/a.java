package ve2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void a(MusicPanel r100, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r101);

    void b(Context r100, IRoom r101, com.bytedance.android.livesdk.ktvimpl.multichorus.d r102);

    void cancelApply(h80.a<Boolean> r100);

    void i5(IBaseUser r100, h80.a<Boolean> r101, String r102);
}

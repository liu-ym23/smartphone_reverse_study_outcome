package ve2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void a(MusicPanel r1, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r2);

    void b(Context r1, IRoom r2, com.bytedance.android.livesdk.ktvimpl.multichorus.d r3);

    void cancelApply(h80.a<Boolean> r1);

    void i5(IBaseUser r1, h80.a<Boolean> r2, String r3);
}

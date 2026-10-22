package m00;

import android.content.Intent;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.sk;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes45.dex */
public interface f {
    void a(kj r100, LiveMode r101);

    void d(sk r100);

    void destroy();

    void onActivityResult(int r100, int r101, Intent r102);
}

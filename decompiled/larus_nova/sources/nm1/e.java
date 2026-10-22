package nm1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public interface e extends b {
    jm1.f a(long r100, Bundle r101);

    lm1.a c();

    boolean f(DataCenter r100);

    h80.d<Pair<Fragment, FragmentManager>> g(DataCenter r100);

    ReplayDataContext h(DataCenter r100);
}

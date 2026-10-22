package im1;

import aj1.f;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    View W5();

    void a9();

    boolean ca();

    IRoom getCurRoom();

    void hv(IRoom r100, f r101, Bundle r102);

    boolean onBackPressed();

    void onHideFragment();

    Fragment self();

    void setDataCenter(DataCenter r100);

    void z3(boolean r100);
}

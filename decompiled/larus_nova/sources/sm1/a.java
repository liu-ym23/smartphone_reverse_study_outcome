package sm1;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    void onRoomEnter(Context r100, LifecycleOwner r101, long r102, DataCenter r103);

    void onRoomExit(long r100);
}

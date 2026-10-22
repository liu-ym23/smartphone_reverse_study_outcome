package pr3;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes14.dex */
public interface b {
    void onError(BDLocationException r100);

    void onLocationChanged(BDLocation r100);
}

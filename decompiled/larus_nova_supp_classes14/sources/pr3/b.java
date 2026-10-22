package pr3;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface b {
    void onError(BDLocationException r1);

    void onLocationChanged(BDLocation r1);
}

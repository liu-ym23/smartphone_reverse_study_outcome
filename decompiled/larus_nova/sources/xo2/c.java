package xo2;

import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface c {

    public interface a {
        void a(UpdatePackage r100, long r101, long r102);
    }

    void a(GeckoClient r100, String r101, Map<String, Map<String, Object>> r102, Map<String, List<CheckRequestBodyModel.TargetChannel>> r103, GeckoUpdateListener r104, a r105);
}

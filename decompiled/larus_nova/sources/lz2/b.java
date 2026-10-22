package lz2;

import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BidInfo f511346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f511347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f511348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f511349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f511350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Integer> f511351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<String> f511352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CheckFilter f511353h;

    public final String toString() {
        return "HybridSettingResponse{bidInfo=" + this.f511346a + ", switchConfig=" + this.f511347b + ", updateTime='" + this.f511348c + "', duration=" + this.f511349d + ", settingId=" + this.f511350e + "', allEventSample=" + this.f511351f + ", hostWhiteSet=" + this.f511352g + ", checkFilter=" + this.f511353h + '}';
    }

    public b() {
        this.f511346a = new BidInfo();
        this.f511347b = new d();
        this.f511351f = new HashMap();
        this.f511352g = new HashSet();
        this.f511353h = new CheckFilter(0);
    }
}

package r77;

import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f536465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f536466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f536467c;

    public b() {
        PushCommonConfiguration r100 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        this.f536465a = false;
        if (r100 == null) goto L7;
        IPushCommonConfiguration r101 = r100.mIPushCommonConfiguration;
        if (r101 == null) goto L7;
        this.f536465a = r101.defaultEnableUnDuplicateMessage();
        f.b("UnDuplicateSettingsModel", "use default UnDuplicateMessage:" + this.f536465a);
    L7:
        this.f536466b = 200;
        this.f536467c = 24;
    }
}

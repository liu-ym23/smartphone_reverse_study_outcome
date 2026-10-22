package mtb;

import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f515689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f515690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f515691f;

    public j(String r100, String r101, String r102, boolean r103, boolean r104, List<String> r105) {
        Intrinsics.checkNotNullParameter(r100, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r105, "profileFieldTexts");
        this.f515686a = r100;
        this.f515687b = r101;
        this.f515688c = r102;
        this.f515689d = r103;
        this.f515690e = r104;
        this.f515691f = r105;
    }
}

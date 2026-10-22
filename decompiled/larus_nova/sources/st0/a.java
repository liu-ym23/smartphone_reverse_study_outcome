package st0;

import com.bytedance.android.live.base.model.user.ActivityBadges;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActivityBadges.NewProfileBadge f543533d;

    public a(ActivityBadges.NewProfileBadge r100) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.CONTENT_TYPE_BADGE);
        super(3, null, 6);
        this.f543533d = r100;
    }
}

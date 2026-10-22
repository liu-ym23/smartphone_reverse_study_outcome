package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class AvatarModel extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tz3.b<FollowStatus> f196621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tz3.b<List<String>> f196622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tz3.b<Unit> f196623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tz3.b<yz3.b> f196624d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/avatar/AvatarModel$FollowStatus;", "", "MYSELF", "FOLLOWED", "UNFOLLOWED", "UNSHOWFOLLOW", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FollowStatus extends Enum<FollowStatus> {
        public static final FollowStatus FOLLOWED = null;
        public static final FollowStatus MYSELF = null;
        public static final FollowStatus UNFOLLOWED = null;
        public static final FollowStatus UNSHOWFOLLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FollowStatus[] f196625a = null;

        public static FollowStatus valueOf(String r100) {
            return (FollowStatus) r27.a.a(FollowStatus.class, r100);
        }

        public static FollowStatus[] values() {
            return (FollowStatus[]) f196625a.clone();
        }

        static {
            FollowStatus r100 = new FollowStatus("MYSELF", 0);
            MYSELF = r100;
            FollowStatus r101 = new FollowStatus("FOLLOWED", 1);
            FOLLOWED = r101;
            FollowStatus r102 = new FollowStatus("UNFOLLOWED", 2);
            UNFOLLOWED = r102;
            FollowStatus r103 = new FollowStatus("UNSHOWFOLLOW", 3);
            UNSHOWFOLLOW = r103;
            f196625a = new FollowStatus[]{r100, r101, r102, r103};
        }

        public FollowStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AvatarModel() {
        this.f196621a = new tz3.b();
        this.f196622b = new tz3.b();
        this.f196623c = new tz3.b();
        this.f196624d = new tz3.b();
    }
}

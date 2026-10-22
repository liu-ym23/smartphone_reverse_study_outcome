package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AvatarModel extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {
    public final tz3.b<FollowStatus> a;
    public final tz3.b<List<String>> b;
    public final tz3.b<Unit> c;
    public final tz3.b<yz3.b> d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/avatar/AvatarModel$FollowStatus;", "", "MYSELF", "FOLLOWED", "UNFOLLOWED", "UNSHOWFOLLOW", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FollowStatus extends Enum<FollowStatus> {
        public static final FollowStatus FOLLOWED = null;
        public static final FollowStatus MYSELF = null;
        public static final FollowStatus UNFOLLOWED = null;
        public static final FollowStatus UNSHOWFOLLOW = null;
        public static final /* synthetic */ FollowStatus[] a = null;

        public static FollowStatus valueOf(String r1) {
            return (FollowStatus) r27.a.a(FollowStatus.class, r1);
        }

        public static FollowStatus[] values() {
            return (FollowStatus[]) a.clone();
        }

        static {
            FollowStatus r0 = new FollowStatus("MYSELF", 0);
            MYSELF = r0;
            FollowStatus r1 = new FollowStatus("FOLLOWED", 1);
            FOLLOWED = r1;
            FollowStatus r3 = new FollowStatus("UNFOLLOWED", 2);
            UNFOLLOWED = r3;
            FollowStatus r5 = new FollowStatus("UNSHOWFOLLOW", 3);
            UNSHOWFOLLOW = r5;
            a = new FollowStatus[]{r0, r1, r3, r5};
        }

        public FollowStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public AvatarModel() {
        this.a = new tz3.b();
        this.b = new tz3.b();
        this.c = new tz3.b();
        this.d = new tz3.b();
    }
}

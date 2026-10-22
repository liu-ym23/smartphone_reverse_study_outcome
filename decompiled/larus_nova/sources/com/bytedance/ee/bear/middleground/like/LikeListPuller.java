package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.widgets.tagview.TagValue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class LikeListPuller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f232734b;

    public static class LikeCountResult extends Result {
        int count;

        public LikeCountResult() {
        }
    }

    public static class LikeResult extends Result {
        boolean hasMore;
        List<a> likeUsers;

        public LikeResult() {
            this.likeUsers = new ArrayList();
        }

        public List<a> getLikeUsers() {
            return this.likeUsers;
        }

        public boolean hasMore() {
            return this.hasMore;
        }

        public void addLikeUser(a r100) {
            this.likeUsers.add(r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f232735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f232736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f232737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f232738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f232739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DisplayName f232740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b f232741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f232742h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f232743i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f232744j;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TagValue f232745a;

        public b() {
        }
    }

    public LikeListPuller(String r100, int r101) {
        this.f232733a = r100;
        this.f232734b = r101;
    }
}

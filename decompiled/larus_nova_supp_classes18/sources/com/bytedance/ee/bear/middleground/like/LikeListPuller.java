package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.widgets.tagview.TagValue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LikeListPuller {
    public final String a;
    public final int b;

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

        public void addLikeUser(a r2) {
            this.likeUsers.add(r2);
        }
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public DisplayName f;
        public b g;
        public String h;
        public long i;
        public boolean j;

        public a() {
        }
    }

    public static class b {
        public TagValue a;

        public b() {
        }
    }

    public LikeListPuller(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}

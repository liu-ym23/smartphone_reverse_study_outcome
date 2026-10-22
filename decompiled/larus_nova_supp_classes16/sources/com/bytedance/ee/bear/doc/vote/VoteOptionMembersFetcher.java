package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.contract.Result;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class VoteOptionMembersFetcher {
    public final String a;
    public final String b;
    public final String c;

    public static class VoteOptionMemberResult extends Result {
        public List<a> members;
        public String nextOffset;
        public int totalCount;

        public VoteOptionMemberResult() {
            this.members = new ArrayList();
        }
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public long d;

        public a() {
        }
    }

    public VoteOptionMembersFetcher(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

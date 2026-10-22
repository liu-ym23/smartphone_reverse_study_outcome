package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.contract.Result;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class VoteOptionMembersFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f218407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f218408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f218409c;

    public static class VoteOptionMemberResult extends Result {
        public List<a> members;
        public String nextOffset;
        public int totalCount;

        public VoteOptionMemberResult() {
            this.members = new ArrayList();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f218410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f218411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f218412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f218413d;

        public a() {
        }
    }

    public VoteOptionMembersFetcher(String r100, String r101, String r102) {
        this.f218407a = r100;
        this.f218408b = r101;
        this.f218409c = r102;
    }
}

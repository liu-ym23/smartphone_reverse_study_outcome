package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.common.DisplayName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f232758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f232759b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f232760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f232761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f232762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f232763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f232764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f232765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DisplayName f232766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public LikeListPuller.b f232767h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f232768i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f232769j;

        public a() {
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f232760a, this.f232761b, this.f232762c, this.f232763d, this.f232764e, this.f232765f, this.f232766g, this.f232767h, Long.valueOf(this.f232768i), Boolean.valueOf(this.f232769j)});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L33:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L33;
            a r101 = (a) r100;
            if (this.f232768i == r101.f232768i) goto L13;
        L31:
            return false;
        L13:
            if (this.f232769j != r101.f232769j) goto L31;
            if (Objects.equals(this.f232760a, r101.f232760a) == false) goto L31;
            if (Objects.equals(this.f232761b, r101.f232761b) == false) goto L31;
            if (Objects.equals(this.f232762c, r101.f232762c) == false) goto L31;
            if (Objects.equals(this.f232763d, r101.f232763d) == false) goto L31;
            if (Objects.equals(this.f232764e, r101.f232764e) == false) goto L31;
            if (Objects.equals(this.f232766g, r101.f232766g) == false) goto L31;
            if (Objects.equals(this.f232767h, r101.f232767h) == false) goto L31;
            if (Objects.equals(this.f232765f, r101.f232765f) == false) goto L31;
            return true;
        }
    }

    public b() {
        this.f232758a = new ArrayList();
        this.f232759b = true;
    }
}

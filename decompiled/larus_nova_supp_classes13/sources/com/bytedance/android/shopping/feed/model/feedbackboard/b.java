package com.bytedance.android.shopping.feed.model.feedbackboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/feedbackboard/b;", "", "", "title", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/bytedance/android/shopping/feed/model/feedbackboard/f;", "feedbackGroups", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "extra", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("feedback_groups")
    private final List<f> feedbackGroups;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.feedbackGroups, r4.feedbackGroups) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<f> r4 = this.feedbackGroups;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.extra;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedbackBoard(title=" + this.title + ", feedbackGroups=" + this.feedbackGroups + ", extra=" + this.extra + ")";
    }

    public b() {
        this.title = null;
        this.feedbackGroups = null;
        this.extra = null;
    }

    public final Map<String, String> a() {
        return this.extra;
    }

    public final List<f> b() {
        return this.feedbackGroups;
    }

    public final String c() {
        return this.title;
    }
}

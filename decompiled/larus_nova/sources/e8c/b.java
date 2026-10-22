package e8c;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.todo.v1.GetRecommendedContentsResponse;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GetRecommendedContentsResponse.RecommendContent> f471421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Chatter> f471422b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f471421a, r101.f471421a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471422b, r101.f471422b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<GetRecommendedContentsResponse.RecommendContent> r100 = this.f471421a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Chatter> r104 = this.f471422b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendData(recommend_contents=" + this.f471421a + ", chatters=" + this.f471422b + ')';
    }

    public b(List<GetRecommendedContentsResponse.RecommendContent> r100, Map<String, Chatter> r101) {
        this.f471421a = r100;
        this.f471422b = r101;
    }
}

package ehb;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.flow.feed.component.title.a> f472752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f472753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f472754d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, List<? extends com.ss.android.lark.flow.feed.component.title.a> r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "titleText");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
        this.f472751a = r100;
        this.f472752b = r101;
        this.f472753c = r102;
        this.f472754d = r103;
    }

    public /* synthetic */ b(String r100, List r101, boolean r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 16;
    L11:
        this(r100, r101, r102, r103);
    }
}

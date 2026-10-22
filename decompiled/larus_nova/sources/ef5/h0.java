package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 implements gf5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f472470c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentBottomPopupData f472471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf5.b f472472b;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "SharePermissionShowDialogEvent";
    }

    public h0(CommentBottomPopupData r100, bf5.b r101) {
        Intrinsics.checkNotNullParameter(r100, "commentBottomPopupData");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f472471a = r100;
        this.f472472b = r101;
    }
}

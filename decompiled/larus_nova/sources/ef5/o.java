package ef5;

import android.widget.EditText;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kf5.b f472488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f472489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MentionUserState f472492e;

    public o(kf5.b r100, CommentEditText r101, String r102, String r103, MentionUserState r104) {
        Intrinsics.checkNotNullParameter(r100, "inputComment");
        Intrinsics.checkNotNullParameter(r101, "commentEditText");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, "state");
        this.f472488a = r100;
        this.f472489b = r101;
        this.f472490c = r102;
        this.f472491d = r103;
        this.f472492e = r104;
    }
}

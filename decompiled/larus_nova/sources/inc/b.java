package inc;

import android.text.TextUtils;
import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.LikeInfo;
import com.larus.platform.model.comment.UserInfo;
import com.story.ai.biz.comment.model.CommentPublishState;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f490636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommentContent f490637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentPublishState f490638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UserInfo f490639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UserInfo f490640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f490641i;

    public b() {
        this(null, null, null, null, null, null, null, 511);
    }

    public final b a() {
        return new b(this.f490633a, this.f490634b, this.f490635c, this.f490636d, this.f490637e, this.f490638f, this.f490639g, this.f490640h, this.f490641i);
    }

    public final CommentInfo b() {
        String r100 = this.f490641i;
        String r101 = this.f490633a;
        String r102 = this.f490635c;
        String r103 = this.f490636d;
        CommentContent r104 = this.f490637e;
        long r105 = System.currentTimeMillis() / ((long) 1000);
        UserInfo r110 = this.f490640h;
        UserInfo r106 = this.f490639g;
        LikeInfo r111 = new LikeInfo(0);
        List r112 = CollectionsKt.emptyList();
        return new CommentInfo(r103, r102, r106, r100, r101, r104, Long.valueOf(r105), r110, r111, 0L, r112, 65);
    }

    public /* synthetic */ b(String r110, String r111, String r112, CommentContent r113, CommentPublishState r114, UserInfo r115, UserInfo r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = UUID.randomUUID().toString();
    L7:
        if ((r210 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r210 & 16) == 0) goto L17;
        CommentContent r103 = null;
    L19:
        if ((r210 & 32) == 0) goto L21;
        CommentPublishState r104 = CommentPublishState.SENDING;
    L23:
        if ((r210 & 64) == 0) goto L25;
        UserInfo r105 = null;
    L27:
        if ((r210 & 128) == 0) goto L29;
        UserInfo r117 = null;
    L30:
        this(r100, null, r101, r102, r103, r104, r105, r117, null);
        return;
    L29:
        r117 = r116;
        goto L30
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, String r103, CommentContent r104, CommentPublishState r105, UserInfo r106, UserInfo r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "clientCommentId");
        Intrinsics.checkNotNullParameter(r105, "state");
        this.f490633a = r100;
        this.f490634b = r101;
        this.f490635c = r102;
        this.f490636d = r103;
        this.f490637e = r104;
        this.f490638f = r105;
        this.f490639g = r106;
        this.f490640h = r107;
        this.f490641i = r110;
        TextUtils.isEmpty(r102);
    }
}

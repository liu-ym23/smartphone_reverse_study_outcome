package bz3;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$PresenterTag;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.CmtInputPresenterManager;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.CmtInputPresenterManager$build$1;
import hy3.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b a(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "mPageOwner");
        Intrinsics.checkNotNullParameter(r4, "service");
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b r0 = new com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b(new hy3.b(r3, r4, CommentPublishScene.COMMENT_LIST));
        r0.j(CommentConstants$PresenterTag.EMOJI);
        r0.j(CommentConstants$PresenterTag.EDIT);
        r0.j(CommentConstants$PresenterTag.KEYBOARD);
        r0.j(CommentConstants$PresenterTag.PUBLISH);
        r0.j(CommentConstants$PresenterTag.CHECKER);
        final CmtInputPresenterManager r5 = r0.a;
        if (r5 == null) goto L11;
        r5.a.a.d.getLifecycle().addObserver(new CmtInputPresenterManager$build$1(r5));
        Iterator r6 = ((ArrayList) r5.c).iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a r7 = (com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a) r6.next();
        if (r7.f.a(r7.c) == null) goto L10;
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a.C0070a r1 = r7.f;
        Intrinsics.checkNotNullParameter(r1, "viewFinder");
        r7.b = r1;
        r7.A(r1);
    L10:
        r7.E();
    L11:
        return r0;
    }
}

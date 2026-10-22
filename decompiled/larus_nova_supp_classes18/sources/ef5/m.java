package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements gf5.c {
    public final List<CommentBean> a;
    public final Integer b;
    public final Integer c;
    public final List<CommentBean> d;

    public /* synthetic */ m() {
        throw null;
    }

    public final String toString() {
        return "DataUpdatedEvent(data=" + this.a + ", position=" + this.b + ", lastPosition=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(List<? extends CommentBean> r2, Integer r3, Integer r4, List<? extends CommentBean> r5) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}

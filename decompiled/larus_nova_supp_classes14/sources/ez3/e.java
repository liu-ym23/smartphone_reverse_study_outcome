package ez3;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface e extends xy3.c {
    public static final a Z1 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static e a(wy3.a r1) {
            int r0 = xy3.a.a;
            if (r1 == null) goto L7;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2 = r1.b;
            if (r2 == null) goto L7;
            LifecycleOwner r3 = r2.d;
        L8:
            Intrinsics.checkNotNull(r3);
            return (e) xy3.a.a(e.class, r3);
        L7:
            r3 = null;
            goto L8
        }
    }

    static {
        Z1 = a.a;
    }

    CommentMentionEditText c();

    void h();

    void v(String r1);
}

package ez3;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface e extends xy3.c {
    public static final a Z1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f474871a = null;

        static {
            f474871a = new a();
        }

        public a() {
        }

        public static e a(wy3.a r100) {
            int r101 = xy3.a.f565402a;
            if (r100 == null) goto L7;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r102 = r100.f561864b;
            if (r102 == null) goto L7;
            LifecycleOwner r103 = r102.f195172d;
        L8:
            Intrinsics.checkNotNull(r103);
            return (e) xy3.a.a(e.class, r103);
        L7:
            r103 = null;
            goto L8
        }
    }

    static {
        Z1 = a.f474871a;
    }

    CommentMentionEditText c();

    void h();

    void v(String r100);
}

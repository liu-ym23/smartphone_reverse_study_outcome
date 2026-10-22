package ny3;

import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentReplyButtonViewHolder;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sy3.j;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends tx3.a<my3.c, com.bytedance.awemeopen.apps.framework.comment.view.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentPageParam f521202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ky3.c f521203d;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ky3.b f521204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f521205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f521206c;

        public final boolean b() {
            List<o14.a> r100 = this.f521206c.f521203d.a(this.f521204a);
            if (r100 != null) goto L5;
            return true;
        L5:
            ky3.b r101 = this.f521204a;
            if (r101.f506630h == false) goto L8;
        L17:
            return true;
        L8:
            if (r101.f506631i >= r100.size()) goto L17;
            int r102 = this.f521204a.f506631i;
            int r103 = Math.min(3 + r102, r100.size());
            List<o14.a> r104 = r100.subList(r102, r103);
            com.bytedance.awemeopen.apps.framework.comment.view.d r105 = (com.bytedance.awemeopen.apps.framework.comment.view.d) this.f521206c.f547816b;
            if (r105 == null) goto L12;
            r105.l(this.f521204a, r104);
        L12:
            ky3.b r106 = this.f521204a;
            r106.getClass();
            r106.f506631i = Math.max(r103, 0);
            if (this.f521204a.f506631i < r100.size()) goto L15;
            this.f521205b.O1(this.f521204a, 2);
        L16:
            return false;
        L15:
            this.f521205b.O1(this.f521204a, 1);
            goto L16
        }

        public final void a(o14.f r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "data");
            List<o14.a> r100 = r110.g();
            if (r100 == null) goto L15;
            Iterator<o14.a> r101 = r100.iterator();
        L7:
            if (r101.hasNext() == false) goto L15;
            o14.a r102 = r101.next();
            Intrinsics.checkNotNullParameter(r102, "<this>");
            Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r102.c() * 1000), "<set-?>");
            List<o14.a> r103 = r102.replyComments;
            if (r103 == null) goto L7;
            Iterator<o14.a> r104 = r103.iterator();
        L13:
            if (r104.hasNext() == false) goto L7;
            o14.a r105 = r104.next();
            Intrinsics.checkNotNullParameter(r105, "<this>");
            Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r105.c() * 1000), "<set-?>");
        L15:
            List<o14.a> r106 = r110.g();
            boolean r107 = false;
            if (r106 != null) goto L18;
        L21:
            boolean r108 = true;
        L22:
            if (r108 == false) goto L24;
            r110.i();
        L24:
            List<o14.a> r109 = r110.g();
            long r112 = r110.e();
            boolean r113 = r110.f();
            int r114 = r110.h();
            List<o14.a> r115 = r109;
            if (r115 != null) goto L27;
        L30:
            boolean r116 = true;
        L32:
            if (r116 == false) goto L38;
            if (r111 == true) goto L35;
            ky3.b r117 = this.f521204a;
            r117.f506629g = r112;
            r117.f506630h = r113;
        L35:
            if (r113 == false) goto L37;
            this.f521205b.O1(this.f521204a, 1);
            return;
        L37:
            this.f521205b.O1(this.f521204a, 2);
            return;
        L38:
            List<o14.a> r118 = this.f521206c.f521203d.a(this.f521204a);
            if (r118 == null) goto L47;
            Iterator<o14.a> r119 = r109.iterator();
        L43:
            if (r119.hasNext() == false) goto L47;
            if (r118.contains(r119.next()) == false) goto L43;
            r119.remove();
        L47:
            ky3.b r120 = this.f521204a;
            r120.replyCommentTotal = r114;
            r120.f506629g = r112;
            r120.f506631i += r109.size();
            if (r113 == true) goto L50;
        L52:
            ky3.b r121 = this.f521204a;
            r121.f506630h = r107;
            com.bytedance.awemeopen.apps.framework.comment.view.d r122 = (com.bytedance.awemeopen.apps.framework.comment.view.d) this.f521206c.f547816b;
            if (r122 == null) goto L55;
            r122.l(r121, r109);
        L55:
            if (r107 == false) goto L57;
            this.f521205b.O1(this.f521204a, 1);
            return;
        L57:
            this.f521205b.O1(this.f521204a, 2);
            return;
        L50:
            if (r114 <= this.f521204a.f506631i) goto L52;
            r107 = true;
            goto L52
        L27:
            if (r115.isEmpty() == true) goto L30;
            r116 = false;
            goto L32
        L18:
            if (r106.isEmpty() == true) goto L21;
            r108 = false;
            goto L22
        }

        public a(h r100, ky3.b r101, CommentReplyButtonViewHolder r102) {
            Intrinsics.checkNotNullParameter(r101, "replyButton");
            Intrinsics.checkNotNullParameter(r102, "viewHolder");
            this.f521206c = r100;
            this.f521204a = r101;
            this.f521205b = r102;
        }
    }

    public h(CommentPageParam r100, ky3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mPageParam");
        Intrinsics.checkNotNullParameter(r101, "mDataManager");
        this.f521202c = r100;
        this.f521203d = r101;
    }
}

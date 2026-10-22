package ny3;

import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentReplyButtonViewHolder;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sy3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends tx3.a<my3.c, com.bytedance.awemeopen.apps.framework.comment.view.d> {
    public final CommentPageParam c;
    public final ky3.c d;

    public final class a {
        public final ky3.b a;
        public final j b;
        public final /* synthetic */ h c;

        public final boolean b() {
            List<o14.a> r0 = this.c.d.a(this.a);
            if (r0 != null) goto L5;
            return true;
        L5:
            ky3.b r2 = this.a;
            if (r2.h == false) goto L8;
        L17:
            return true;
        L8:
            if (r2.i >= r0.size()) goto L17;
            int r3 = this.a.i;
            int r4 = Math.min(3 + r3, r0.size());
            List<? extends o14.a> r5 = r0.subList(r3, r4);
            com.bytedance.awemeopen.apps.framework.comment.view.d r6 = (com.bytedance.awemeopen.apps.framework.comment.view.d) this.c.b;
            if (r6 == null) goto L12;
            r6.l(this.a, r5);
        L12:
            ky3.b r7 = this.a;
            r7.getClass();
            r7.i = Math.max(r4, 0);
            if (this.a.i < r0.size()) goto L15;
            this.b.O1(this.a, 2);
        L16:
            return false;
        L15:
            this.b.O1(this.a, 1);
            goto L16
        }

        public final void a(o14.f r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "data");
            List r0 = r11.g();
            if (r0 == null) goto L15;
            Iterator r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L15;
            o14.a r2 = (o14.a) r1.next();
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r2.c() * 1000), "<set-?>");
            List r3 = r2.replyComments;
            if (r3 == null) goto L7;
            Iterator r4 = r3.iterator();
        L13:
            if (r4.hasNext() == false) goto L7;
            o14.a r5 = (o14.a) r4.next();
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r5.c() * 1000), "<set-?>");
        L15:
            List r6 = r11.g();
            boolean r7 = false;
            if (r6 != null) goto L18;
        L21:
            boolean r8 = true;
        L22:
            if (r8 == false) goto L24;
            r11.i();
        L24:
            List<? extends o14.a> r9 = r11.g();
            long r10 = r11.e();
            boolean r13 = r11.f();
            int r14 = r11.h();
            List<? extends o14.a> r15 = r9;
            if (r15 != null) goto L27;
        L30:
            boolean r16 = true;
        L32:
            if (r16 == false) goto L38;
            if (r12 == true) goto L35;
            ky3.b r17 = this.a;
            r17.g = r10;
            r17.h = r13;
        L35:
            if (r13 == false) goto L37;
            this.b.O1(this.a, 1);
            return;
        L37:
            this.b.O1(this.a, 2);
            return;
        L38:
            List<o14.a> r18 = this.c.d.a(this.a);
            if (r18 == null) goto L47;
            Iterator<? extends o14.a> r19 = r9.iterator();
        L43:
            if (r19.hasNext() == false) goto L47;
            if (r18.contains(r19.next()) == false) goto L43;
            r19.remove();
        L47:
            ky3.b r110 = this.a;
            ((o14.a) r110).replyCommentTotal = r14;
            r110.g = r10;
            r110.i += r9.size();
            if (r13 == true) goto L50;
        L52:
            ky3.b r111 = this.a;
            r111.h = r7;
            com.bytedance.awemeopen.apps.framework.comment.view.d r112 = (com.bytedance.awemeopen.apps.framework.comment.view.d) this.c.b;
            if (r112 == null) goto L55;
            r112.l(r111, r9);
        L55:
            if (r7 == false) goto L57;
            this.b.O1(this.a, 1);
            return;
        L57:
            this.b.O1(this.a, 2);
            return;
        L50:
            if (r14 <= this.a.i) goto L52;
            r7 = true;
            goto L52
        L27:
            if (r15.isEmpty() == true) goto L30;
            r16 = false;
            goto L32
        L18:
            if (r6.isEmpty() == true) goto L21;
            r8 = false;
            goto L22
        }

        public a(h r2, ky3.b r3, CommentReplyButtonViewHolder r4) {
            Intrinsics.checkNotNullParameter(r3, "replyButton");
            Intrinsics.checkNotNullParameter(r4, "viewHolder");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public h(CommentPageParam r2, ky3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "mPageParam");
        Intrinsics.checkNotNullParameter(r3, "mDataManager");
        this.c = r2;
        this.d = r3;
    }
}

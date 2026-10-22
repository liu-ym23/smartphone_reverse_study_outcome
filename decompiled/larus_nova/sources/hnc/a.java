package hnc;

import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.CommentAction;
import com.story.ai.biz.comment.model.CommentSection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a implements com.story.ai.base.components.mvi.e {

    /* JADX INFO: renamed from: hnc.a$a, reason: collision with other inner class name */
    public static final class C6176a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f486163a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6176a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486163a, ((C6176a) r100).f486163a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486163a.hashCode();
        }

        public final String toString() {
            return "CommentDraftChangeEffect(content=" + this.f486163a + ')';
        }

        public C6176a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f486163a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f486164a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486164a, ((b) r100).f486164a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486164a.hashCode();
        }

        public final String toString() {
            return "CommentSendEffect(content=" + this.f486164a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f486164a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f486165a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f486165a == ((c) r100).f486165a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486165a;
        }

        public final String toString() {
            return "KeyboardHeightChange(height=" + this.f486165a + ')';
        }

        public c(int r100) {
            this.f486165a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f486166a = null;

        static {
            f486166a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f486167a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f486167a == ((e) r100).f486167a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f486167a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "LoadMoreStateEffect(enable=" + this.f486167a + ')';
        }

        public e(boolean r100) {
            this.f486167a = r100;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f486168a = null;

        static {
            f486168a = new f();
        }

        public f() {
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f486169a = null;

        static {
            f486169a = new g();
        }

        public g() {
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final inc.b f486170a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486170a, ((h) r100).f486170a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486170a.hashCode();
        }

        public final String toString() {
            return "PublishStateChange(publishData=" + this.f486170a + ')';
        }

        public h(inc.b r100) {
            Intrinsics.checkNotNullParameter(r100, "publishData");
            this.f486170a = r100;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseComment f486171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f486172b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f486171a, r101.f486171a) == true) goto L12;
            return false;
        L12:
            if (this.f486172b == r101.f486172b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f486171a.hashCode() * 31) + this.f486172b;
        }

        public final String toString() {
            return "ReplyCommentEffect(comment=" + this.f486171a + ", position=" + this.f486172b + ')';
        }

        public i(BaseComment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            this.f486171a = r100;
            this.f486172b = r101;
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CommentSection f486173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f486174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<CommentAction> f486175c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (Intrinsics.areEqual(this.f486173a, r101.f486173a) == true) goto L12;
            return false;
        L12:
            if (this.f486174b == r101.f486174b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f486175c, r101.f486175c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f486173a.hashCode() * 31) + this.f486174b) * 31) + this.f486175c.hashCode();
        }

        public final String toString() {
            return "ShowActionsEffect(item=" + this.f486173a + ", position=" + this.f486174b + ", actionList=" + this.f486175c + ')';
        }

        public j(BaseComment r100, int r101, List r102) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, ActionList.ELEM_NAME);
            this.f486173a = r100;
            this.f486174b = r101;
            this.f486175c = r102;
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f486176a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            if (this.f486176a == ((k) r100).f486176a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f486176a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ShowLoading(show=" + this.f486176a + ')';
        }

        public k(boolean r100) {
            this.f486176a = r100;
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CommentSection f486177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f486178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f486179c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (Intrinsics.areEqual(this.f486177a, r101.f486177a) == true) goto L12;
            return false;
        L12:
            if (this.f486178b == r101.f486178b) goto L15;
            return false;
        L15:
            if (this.f486179c == r101.f486179c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f486177a.hashCode() * 31) + this.f486178b) * 31;
            if (this.f486179c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "UpdateListItemEffect(item=" + this.f486177a + ", index=" + this.f486178b + ", needScrollToItem=" + this.f486179c + ')';
        }

        public l(BaseComment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f486177a = r100;
            this.f486178b = r101;
            this.f486179c = false;
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f486180a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f486180a == ((m) r100).f486180a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f486180a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "UpdateTotalNum(num=" + this.f486180a + ')';
        }

        public m(long r100) {
            this.f486180a = r100;
        }
    }

    public static final class n extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            ((n) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 1237;
        }

        public final String toString() {
            return "UserBlockStateChange(isBlock=false)";
        }
    }

    public a() {
    }
}

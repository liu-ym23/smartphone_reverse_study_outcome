package hnc;

import com.story.ai.base.components.mvi.g;
import com.story.ai.biz.comment.model.CommentSection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b implements g {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CommentSection> f486181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f486182b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f486181a, r101.f486181a) == true) goto L12;
            return false;
        L12:
            if (this.f486182b == r101.f486182b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f486181a.hashCode() * 31;
            if (this.f486182b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ShowEmptyState(commentDataList=" + this.f486181a + ", isFromRefresh=" + this.f486182b + ')';
        }

        public a(List<CommentSection> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "commentDataList");
            this.f486181a = r100;
            this.f486182b = r101;
        }
    }

    /* JADX INFO: renamed from: hnc.b$b, reason: collision with other inner class name */
    public static final class C6177b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CommentSection> f486183a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6177b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486183a, ((C6177b) r100).f486183a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f486183a.hashCode();
        }

        public final String toString() {
            return "ShowErrorState(commentDataList=" + this.f486183a + ')';
        }

        public C6177b(List<CommentSection> r100) {
            Intrinsics.checkNotNullParameter(r100, "commentDataList");
            this.f486183a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CommentSection> f486184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f486185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f486186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f486187d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f486184a, r101.f486184a) == true) goto L12;
            return false;
        L12:
            if (this.f486185b == r101.f486185b) goto L15;
            return false;
        L15:
            if (this.f486186c == r101.f486186c) goto L18;
            return false;
        L18:
            if (this.f486187d == r101.f486187d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f486184a.hashCode() * 31) + this.f486185b) * 31;
            int r101 = 1231;
            if (this.f486186c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f486187d == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ShowListState(commentDataList=" + this.f486184a + ", scrollToIndex=" + this.f486185b + ", isRefresh=" + this.f486186c + ", hasMore=" + this.f486187d + ')';
        }

        public c(List<CommentSection> r100, int r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "commentDataList");
            this.f486184a = r100;
            this.f486185b = r101;
            this.f486186c = r102;
            this.f486187d = r103;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CommentSection> f486188a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f486188a, ((d) r100).f486188a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<CommentSection> r100 = this.f486188a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ShowLoadingState(commentDataList=" + this.f486188a + ')';
        }

        public d(List<CommentSection> r100) {
            this.f486188a = r100;
        }
    }

    public b() {
    }
}

package ry9;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface i {

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaAttachment f539932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f539933b;

        public /* synthetic */ a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f539932a, r101.f539932a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f539933b, r101.f539933b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f539932a.hashCode() * 31;
            Boolean r101 = this.f539933b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageSelectorData(selectedData=" + this.f539932a + ", hasFace=" + this.f539933b + ')';
        }

        public a(MediaAttachment r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "selectedData");
            this.f539932a = r100;
            this.f539933b = r101;
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaAttachment f539934a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f539934a, ((b) r100).f539934a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f539934a.hashCode();
        }

        public final String toString() {
            return "VideoSelectorData(selectedData=" + this.f539934a + ')';
        }

        public b(MediaAttachment r100) {
            Intrinsics.checkNotNullParameter(r100, "selectedData");
            this.f539934a = r100;
        }
    }
}

package mcc;

import android.view.View;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f513252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f513253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UrlInfo f513254c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f513252a, r101.f513252a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f513253b, r101.f513253b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f513254c, r101.f513254c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f513252a.hashCode() * 31;
            String r101 = this.f513253b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            UrlInfo r105 = this.f513254c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CardClickInfo(tag=" + this.f513252a + ", id=" + this.f513253b + ", url=" + this.f513254c + ')';
        }

        public a(String r100, String r101, UrlInfo r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f513252a = r100;
            this.f513253b = r101;
            this.f513254c = r102;
        }
    }

    void e(View r100, a r101);
}

package wp3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f560569d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C8144b> f560570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560572c;

    public static final class a {
        public static b a(List r100, up3.c r101) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r101 != null) goto L7;
            return null;
        L7:
            ArrayList r102 = new ArrayList();
            Iterator r103 = r100.iterator();
        L9:
            if (r103.hasNext() == false) goto L26;
            Object r104 = r103.next();
            up3.d r105 = (up3.d) r104;
            ECUrlModel r106 = r105.b();
            boolean r107 = false;
            if (r106 == null) goto L24;
            String r108 = r106.getFirstUrl();
            if (r108 == null) goto L24;
            if (r108.length() <= 0) goto L17;
            boolean r109 = true;
        L18:
            if (r109 != true) goto L24;
            String r110 = r105.a();
            if (r110 == null) goto L24;
            if ((!StringsKt.isBlank(r110)) != true) goto L24;
            r107 = true;
            goto L24
        L17:
            r109 = false;
        L24:
            if (r107 == false) goto L9;
            r102.add(r104);
            goto L9
        L26:
            ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r112 = r102.iterator();
        L27:
            String r113 = "";
            if (r112.hasNext() == false) goto L42;
            up3.d r114 = (up3.d) r112.next();
            String r115 = r114.a();
            if (r115 == null) goto L39;
            ECUrlModel r116 = r114.b();
            if (r116 == null) goto L34;
            String r117 = r116.getFirstUrl();
        L35:
            if (r117 == null) goto L38;
            r113 = r117;
        L38:
            C8144b r118 = new C8144b(r113, r115);
        L40:
            r111.add(r118);
            goto L27
        L34:
            r117 = null;
            goto L35
        L39:
            r118 = null;
            goto L40
        L42:
            if (r111.isEmpty() == false) goto L44;
            return null;
        L44:
            String r119 = r101.a();
            if (r119 == null) goto L49;
            r113 = r119;
        L49:
            return new b(r111, r113, r101.b());
        }
    }

    /* JADX INFO: renamed from: wp3.b$b, reason: collision with other inner class name */
    public static final class C8144b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f560573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f560574b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C8144b) == false) goto L10;
            C8144b r101 = (C8144b) r100;
            if (Intrinsics.areEqual(this.f560573a, r101.f560573a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f560574b, r101.f560574b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f560573a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f560574b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ECCommentVO(authorAvatar=" + this.f560573a + ", comment=" + this.f560574b + ")";
        }

        public C8144b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "authorAvatar");
            Intrinsics.checkNotNullParameter(r101, "comment");
            this.f560573a = r100;
            this.f560574b = r101;
        }
    }

    static {
    }

    public b(List<C8144b> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "hotCommentCountDesc");
        this.f560570a = r100;
        this.f560571b = r101;
        this.f560572c = r102;
    }
}

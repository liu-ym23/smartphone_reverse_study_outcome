package wp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f560565b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C8143a> f560566a;

    /* JADX INFO: renamed from: wp3.a$a, reason: collision with other inner class name */
    public static final class C8143a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f560567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f560568b;

        public C8143a() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C8143a) == false) goto L10;
            C8143a r101 = (C8143a) r100;
            if (Intrinsics.areEqual(this.f560567a, r101.f560567a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f560568b, r101.f560568b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f560567a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f560568b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CommentTagsVO(desc=" + this.f560567a + ", count=" + this.f560568b + ")";
        }

        public C8143a(String r100, String r101) {
            this.f560567a = r100;
            this.f560568b = r101;
        }
    }

    public static final class b {
        public static a a(List r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            Iterator r103 = r100.iterator();
        L7:
            if (r103.hasNext() == false) goto L16;
            Object r104 = r103.next();
            up3.b r105 = (up3.b) r104;
            if (r105.b() == null) goto L13;
            boolean r106 = true;
            if ((!StringsKt.isBlank(r105.b())) == false) goto L13;
        L14:
            if (r106 == false) goto L7;
            r102.add(r104);
        L13:
            r106 = false;
            goto L14
        L16:
            Iterator r107 = r102.iterator();
        L18:
            if (r107.hasNext() == false) goto L21;
            up3.b r108 = (up3.b) r107.next();
            r101.add(new C8143a(r108.b(), String.valueOf(r108.a())));
            goto L18
        L21:
            if (r101.isEmpty() == false) goto L24;
            return null;
        L24:
            return new a(r101);
        }
    }

    static {
    }

    public a(List<C8143a> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f560566a = r100;
    }
}

package ylb;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<ITEM_TYPE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends ITEM_TYPE> f568346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super ITEM_TYPE, String> f568347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ITEM_TYPE> f568348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f568349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f568350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ylb.a<ITEM_TYPE> f568351f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f568352a;

        public a() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f568352a == ((a) r100).f568352a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f568352a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveButton(show=" + this.f568352a + ')';
        }

        public a(boolean r100) {
            this.f568352a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f568346a, r101.f568346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568347b, r101.f568347b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568348c, r101.f568348c) == true) goto L18;
        return false;
    L18:
        if (this.f568349d == r101.f568349d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f568350e, r101.f568350e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f568351f, r101.f568351f) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f568346a.hashCode() * 31) + this.f568347b.hashCode()) * 31) + this.f568348c.hashCode()) * 31) + this.f568349d) * 31;
        a r101 = this.f568350e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + 0) * 31;
        ylb.a<ITEM_TYPE> r105 = this.f568351f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageViewConfig(items=" + this.f568346a + ", urlExtractor=" + this.f568347b + ", defaultCheckedItems=" + this.f568348c + ", defaultIndex=" + this.f568349d + ", saveButton=" + this.f568350e + ", confirmButton=null, callback=" + this.f568351f + ')';
    }

    public c(List r100, Function1 r101, List r102, int r103, a r104, ylb.a r105) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, "urlExtractor");
        Intrinsics.checkNotNullParameter(r102, "defaultCheckedItems");
        this.f568346a = r100;
        this.f568347b = r101;
        this.f568348c = r102;
        this.f568349d = r103;
        this.f568350e = r104;
        this.f568351f = r105;
    }
}

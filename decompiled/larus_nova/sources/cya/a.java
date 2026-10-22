package cya;

import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C5608a f465968c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RichText f465969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f465970b;

    /* JADX INFO: renamed from: cya.a$a, reason: collision with other inner class name */
    public static final class C5608a implements n.a<a> {
        public static a a() {
            return new a(com.ss.android.lark.widget.richtext.c.a(), "");
        }

        public C5608a() {
        }
    }

    static {
        f465968c = new C5608a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f465969a, r101.f465969a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465970b, r101.f465970b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f465969a.hashCode() * 31) + this.f465970b.hashCode();
    }

    public final String toString() {
        return "EditInfo(richText=" + this.f465969a + ", title=" + this.f465970b + ')';
    }

    public a(RichText r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f465969a = r100;
        this.f465970b = r101;
    }
}

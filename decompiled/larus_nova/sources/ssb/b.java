package ssb;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f543503a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f543504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f543505c;

        /* JADX INFO: renamed from: ssb.b$a$a, reason: collision with other inner class name */
        public static final class C7649a {
        }

        static {
        }

        public a() {
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
            if (Intrinsics.areEqual(this.f543504b, r101.f543504b) == true) goto L12;
            return false;
        L12:
            if (this.f543505c == r101.f543505c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f543504b.hashCode() * 31) + this.f543505c;
        }

        public final String toString() {
            return "CustomArea(data=" + this.f543504b + ", lines=" + this.f543505c + ')';
        }

        public /* synthetic */ a(List r100) {
            this(r100, usb.a.a());
        }

        public a(List<c> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super(2);
            this.f543504b = r100;
            this.f543505c = r101;
        }
    }

    /* JADX INFO: renamed from: ssb.b$b, reason: collision with other inner class name */
    public static final class C7650b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f543506b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7650b) == true) goto L9;
            return false;
        L9:
            if (this.f543506b == ((C7650b) r100).f543506b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f543506b;
        }

        public final String toString() {
            return "CustomSpace(height=" + this.f543506b + ')';
        }

        public C7650b(int r100) {
            super(3);
            this.f543506b = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.newemoji.larkemoji.a f543507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f543508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s5c.d f543509d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f543510e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f543507b, r101.f543507b) == true) goto L12;
            return false;
        L12:
            if (this.f543508c == r101.f543508c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f543509d, r101.f543509d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f543510e, r101.f543510e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f543507b.hashCode() * 31;
            if (this.f543508c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            s5c.d r103 = this.f543509d;
            int r104 = 0;
            if (r103 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r102 + r105) * 31;
            Integer r107 = this.f543510e;
            if (r107 == null) goto L15;
            r104 = r107.hashCode();
        L15:
            return r106 + r104;
        L9:
            r105 = r103.hashCode();
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Emoji(data=" + this.f543507b + ", enableEmojiSkin=" + this.f543508c + ", tab=" + this.f543509d + ", position=" + this.f543510e + ')';
        }

        public c(com.ss.android.lark.newemoji.larkemoji.a r100, boolean r101, s5c.a r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super(1);
            this.f543507b = r100;
            this.f543508c = r101;
            this.f543509d = r102;
            this.f543510e = r103;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f543511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f543512c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f543511b, r101.f543511b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f543512c, r101.f543512c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f543511b.hashCode() * 31;
            String r101 = this.f543512c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Title(title=" + this.f543511b + ", iconKey=" + this.f543512c + ')';
        }

        public d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            super(0);
            this.f543511b = r100;
            this.f543512c = r101;
        }
    }

    public final int getType() {
        return this.f543503a;
    }

    public b(int r100) {
        this.f543503a = r100;
    }
}

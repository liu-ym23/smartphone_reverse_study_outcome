package qma;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.TextSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f533933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f533934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f533935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<i> f533936d;

        public final int hashCode() {
            int r100 = ((this.f533933a.hashCode() * 31) + this.f533934b.hashCode()) * 31;
            h r101 = this.f533935c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f533936d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ExternalView(id=" + this.f533933a + ", bindingKey=" + this.f533934b + ", material=" + this.f533935c + ", properties=" + this.f533936d + ')';
        }

        @Override // qma.b
        public final String a() {
            return this.f533933a;
        }

        @Override // qma.b
        public final List<i> b() {
            return this.f533936d;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f533933a, r101.f533933a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f533934b, r101.f533934b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f533935c, r101.f533935c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f533936d, r101.f533936d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public a(String r100, String r101, h r102, List<i> r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "bindingKey");
            Intrinsics.checkNotNullParameter(r103, "properties");
            this.f533933a = r100;
            this.f533934b = r101;
            this.f533935c = r102;
            this.f533936d = r103;
        }
    }

    /* JADX INFO: renamed from: qma.b$b, reason: collision with other inner class name */
    public static final class C7362b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f533937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextSource f533938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f533939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BlendSpec f533940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<i> f533941e;

        public final int hashCode() {
            return (((((((this.f533937a.hashCode() * 31) + this.f533938b.hashCode()) * 31) + this.f533939c.hashCode()) * 31) + this.f533940d.hashCode()) * 31) + this.f533941e.hashCode();
        }

        public final String toString() {
            return "Text(id=" + this.f533937a + ", source=" + this.f533938b + ", fill=" + this.f533939c + ", blend=" + this.f533940d + ", properties=" + this.f533941e + ')';
        }

        @Override // qma.b
        public final String a() {
            return this.f533937a;
        }

        @Override // qma.b
        public final List<i> b() {
            return this.f533941e;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7362b) == true) goto L8;
            return false;
        L8:
            C7362b r101 = (C7362b) r100;
            if (Intrinsics.areEqual(this.f533937a, r101.f533937a) == true) goto L12;
            return false;
        L12:
            if (this.f533938b == r101.f533938b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f533939c, r101.f533939c) == true) goto L18;
            return false;
        L18:
            if (this.f533940d == r101.f533940d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f533941e, r101.f533941e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public C7362b(String r100, TextSource r101, e r102, BlendSpec r103, List<i> r104) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r102, LynxVideoManagerLite.FILL);
            Intrinsics.checkNotNullParameter(r103, "blend");
            Intrinsics.checkNotNullParameter(r104, "properties");
            this.f533937a = r100;
            this.f533938b = r101;
            this.f533939c = r102;
            this.f533940d = r103;
            this.f533941e = r104;
        }
    }

    public b() {
    }

    public abstract String a();

    public abstract List<i> b();
}

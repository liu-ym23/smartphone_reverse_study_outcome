package dz7;

import com.larksuite.component.card.protocol.context.BizContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BizContext f470590c;

    /* JADX INFO: renamed from: dz7.a$a, reason: collision with other inner class name */
    public static final class C5723a {

        /* JADX INFO: renamed from: dz7.a$a$a, reason: collision with other inner class name */
        public static final class C5724a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f470591a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f470592b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public BizContext f470593c;

            public final a a() {
                String r100 = this.f470591a;
                BizContext r101 = null;
                if (r100 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("elementTag");
                r100 = null;
            L5:
                String r102 = this.f470592b;
                BizContext r103 = this.f470593c;
                if (r103 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("bizContext");
            L10:
                return new a(r100, r102, r101);
            L8:
                r101 = r103;
                goto L10
            }

            public C5724a() {
                this.f470592b = "";
            }
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f470588a, r101.f470588a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470589b, r101.f470589b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470590c, r101.f470590c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470588a.hashCode() * 31;
        String r101 = this.f470589b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f470590c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardActionContext(elementTag=" + this.f470588a + ", elementID=" + this.f470589b + ", bizContext=" + this.f470590c + ')';
    }

    public a(String r100, String r101, BizContext r102) {
        Intrinsics.checkNotNullParameter(r100, "elementTag");
        Intrinsics.checkNotNullParameter(r102, "bizContext");
        this.f470588a = r100;
        this.f470589b = r101;
        this.f470590c = r102;
    }
}

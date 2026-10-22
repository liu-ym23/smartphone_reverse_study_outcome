package ev6;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f474320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<g> f474321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f474322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f474323e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f474324a;

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
            if (this.f474324a == ((a) r100).f474324a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f474324a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "PropsUIData(visible=" + this.f474324a + ')';
        }

        public a(boolean r100) {
            this.f474324a = r100;
        }
    }

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f474319a, r101.f474319a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474320b, r101.f474320b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474321c, r101.f474321c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474322d, r101.f474322d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474323e, r101.f474323e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474319a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.f474320b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<g> r107 = this.f474321c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f474322d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, ? extends Object> r113 = this.f474323e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfIndustryUIData(propsUIData=" + this.f474319a + ", titleImage=" + this.f474320b + ", industryTagList=" + this.f474321c + ", tipsText=" + this.f474322d + ", payload=" + this.f474323e + ')';
    }

    public h(Object r100) {
        this.f474319a = null;
        this.f474320b = null;
        this.f474321c = null;
        this.f474322d = null;
        this.f474323e = null;
    }
}

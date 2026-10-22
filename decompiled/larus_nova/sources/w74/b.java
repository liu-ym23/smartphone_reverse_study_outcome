package w74;

import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f558512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f558513h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f558514a = null;

        static {
            int[] r100 = new int[DTraitRiskType.values().length];
            f558514a = r100;
            r100[DTraitRiskType.HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f558514a[DTraitRiskType.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final Map<String, String> a() {
        Map<String, String> r100 = this.f558513h;
        HashMap r101 = (HashMap) r100;
        r101.put("dtrait_pk1", this.f558506a);
        Map<String, String> r102 = this.f558513h;
        HashMap r103 = (HashMap) r102;
        r103.put("dtrait_pk2", this.f558507b);
        Map<String, String> r104 = this.f558513h;
        HashMap r105 = (HashMap) r104;
        r105.put("dtrait_pk1_version", this.f558510e);
        Map<String, String> r106 = this.f558513h;
        HashMap r107 = (HashMap) r106;
        r107.put("dtrait_pk2_version", this.f558511f);
        Map<String, String> r108 = this.f558513h;
        HashMap r109 = (HashMap) r108;
        r109.put("dtrait_version", String.valueOf(this.f558509d));
        Map<String, String> r110 = this.f558513h;
        HashMap r111 = (HashMap) r110;
        r111.put("dtrait_token", this.f558508c);
        return this.f558513h;
    }

    public final String toString() {
        return "DTraitInfo{dtraitHK='" + this.f558506a + "', dtraitLK='" + this.f558507b + "', dtraitToken='" + this.f558508c + "', dtraitVersion='" + this.f558509d + "', dtraitPK1Version='" + this.f558510e + "', dtraitPK2Version='" + this.f558511f + "', bindDTrait=" + this.f558512g + '}';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106) {
        this.f558506a = r100;
        this.f558507b = r101;
        this.f558510e = r102;
        this.f558511f = r103;
        this.f558508c = r104;
        this.f558509d = r105;
        this.f558512g = r106;
        this.f558513h = new HashMap();
    }
}

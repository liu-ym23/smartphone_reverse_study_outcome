package eab;

import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownAtUser;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends v7b.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, ImageSetV2> f471742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Long> f471743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f471744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, MarkdownAtUser> f471745n;

    public e() {
        this("", null, null, false, null);
    }

    @Override // v7b.s
    public final s h() {
        return new e(this.f471741j, this.f471742k, this.f471743l, this.f471744m, this.f471745n);
    }

    public final int hashCode() {
        int r100 = this.f471741j.hashCode() * 31;
        Map<String, ImageSetV2> r101 = this.f471742k;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L9:
        int r104 = (r100 + r103) * 31;
        List<Long> r105 = this.f471743l;
        if (r105 == null) goto L12;
        int r106 = r105.hashCode();
    L13:
        int r107 = (r104 + r106) * 31;
        if (this.f471744m == false) goto L16;
        int r108 = 1231;
    L17:
        int r109 = (r107 + r108) * 31;
        Map<String, MarkdownAtUser> r110 = this.f471745n;
        if (r110 == null) goto L21;
        r102 = r110.hashCode();
    L21:
        return r109 + r102;
    L16:
        r108 = 1237;
        goto L17
    L12:
        r106 = 0;
        goto L13
    L5:
        Iterator<Map.Entry<String, ImageSetV2>> r111 = r101.entrySet().iterator();
        r103 = 0;
    L7:
        if (r111.hasNext() == false) goto L9;
        Map.Entry<String, ImageSetV2> r112 = r111.next();
        String r113 = r112.getKey();
        ImageSetV2 r114 = r112.getValue();
        int r115 = r113.hashCode();
        r103 = r103 + (Arrays.hashCode(r114.encode()) ^ r115);
        goto L7
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f471741j, r101.f471741j) == false) goto L48;
        Map<String, ImageSetV2> r102 = this.f471742k;
        Map<String, ImageSetV2> r103 = r101.f471742k;
        if (r102 == r103) goto L39;
        if (r102 == null) goto L38;
        if (r103 == null) goto L38;
        if (r102.size() != r103.size()) goto L38;
        if (r102.isEmpty() == true) goto L39;
        Iterator<Map.Entry<String, ImageSetV2>> r104 = r102.entrySet().iterator();
    L23:
        if (r104.hasNext() == false) goto L39;
        Map.Entry<String, ImageSetV2> r105 = r104.next();
        String r106 = r105.getKey();
        ImageSetV2 r107 = r105.getValue();
        if (r103.containsKey(r106) == false) goto L36;
        ImageSetV2 r108 = r103.get(r106);
        if (r107 != r108) goto L29;
        boolean r109 = true;
    L34:
        if (r109 == false) goto L36;
        boolean r110 = true;
    L37:
        if (r110 == true) goto L23;
    L29:
        if (r107 == null) goto L33;
        if (r108 == null) goto L33;
        r109 = Arrays.equals(r107.encode(), r108.encode());
    L33:
        r109 = false;
    L36:
        r110 = false;
    L38:
        boolean r111 = false;
    L40:
        if (r111 == false) goto L48;
        if (Intrinsics.areEqual(this.f471743l, r101.f471743l) == false) goto L48;
        if (this.f471744m != r101.f471744m) goto L48;
        if (Intrinsics.areEqual(this.f471745n, r101.f471745n) == false) goto L48;
        return true;
    L39:
        r111 = true;
    L48:
        return false;
    }

    public e(String r100, Map<String, ImageSetV2> r101, List<Long> r102, boolean r103, Map<String, MarkdownAtUser> r104) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f471741j = r100;
        this.f471742k = r101;
        this.f471743l = r102;
        this.f471744m = r103;
        this.f471745n = r104;
    }
}

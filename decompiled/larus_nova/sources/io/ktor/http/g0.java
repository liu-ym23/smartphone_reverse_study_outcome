package io.ktor.http;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
public final class g0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Url f491861k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f491862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f491863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f491864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f491865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f491866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f491867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f491868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f491869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a0 f491870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m0 f491871j;

    public static final class a {
        public a() {
        }
    }

    public g0() {
        this(null);
    }

    static {
        Intrinsics.checkNotNullParameter(new a(), "<this>");
        f491861k = l0.b("http://localhost");
    }

    public final void a() {
        if (this.f491863b.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f491862a.f491881a, "file") == true) goto L19;
        Url r101 = f491861k;
        this.f491863b = r101.f491817b;
        j0 r102 = this.f491862a;
        j0 r103 = j0.f491877c;
        if (Intrinsics.areEqual(r102, j0.f491877c) == false) goto L14;
        this.f491862a = r101.f491816a;
    L14:
        if (this.f491864c != 0) goto L18;
        this.f491864c = r101.f491818c;
        return;
    L18:
        return;
    L19:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(256);
        h0.a(this, r100);
        return r100.toString();
    }

    public final Url b() {
        a();
        j0 r100 = this.f491862a;
        String r101 = this.f491863b;
        int r102 = this.f491864c;
        List<String> r103 = this.f491869h;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(CodecsKt.d((String) r105.next()));
        goto L4
    L6:
        z r106 = n0.b(this.f491871j.f491890a);
        String r107 = CodecsKt.e(this.f491868g, 0, 0, false, 15);
        String r108 = this.f491866e;
        if (r108 == null) goto L9;
        String r109 = CodecsKt.d(r108);
    L10:
        String r110 = this.f491867f;
        if (r110 == null) goto L13;
        String r111 = CodecsKt.d(r110);
    L15:
        return new Url(r100, r101, r102, r104, r106, r107, r109, r111, this.f491865d, c());
    L13:
        r111 = null;
        goto L15
    L9:
        r109 = null;
        goto L10
    }

    public final String c() {
        a();
        StringBuilder r100 = new StringBuilder(256);
        h0.a(this, r100);
        return r100.toString();
    }

    public g0(Object r110) {
        j0 r111 = j0.f491877c;
        List r100 = CollectionsKt.emptyList();
        z.f491930b.getClass();
        i r101 = z.a.f491932b;
        Intrinsics.checkNotNullParameter(r111, "protocol");
        Intrinsics.checkNotNullParameter("", "host");
        Intrinsics.checkNotNullParameter(r100, "pathSegments");
        Intrinsics.checkNotNullParameter(r101, "parameters");
        Intrinsics.checkNotNullParameter("", WidgetService.PARAM_FRAGMENT);
        this.f491862a = r111;
        this.f491863b = "";
        final boolean r112 = false;
        this.f491864c = 0;
        this.f491865d = false;
        this.f491866e = null;
        this.f491867f = null;
        Set<Byte> r102 = CodecsKt.f491800a;
        Charset r103 = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter("", "<this>");
        Intrinsics.checkNotNullParameter(r103, "charset");
        final StringBuilder r104 = new StringBuilder();
        CodecsKt.h(ksc.b.b(r103.newEncoder(), "", 0, "".length()), new CodecsKt$encodeURLQueryComponent$1$1(r112, r104, r112));
        this.f491868g = r104.toString();
        List r105 = r100;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L4:
        if (r107.hasNext() == false) goto L29;
        String r108 = (String) r107.next();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r108, "<this>");
        final StringBuilder r109 = new StringBuilder();
        Charset r113 = Charsets.UTF_8;
        int r114 = 0;
    L7:
        if (r114 >= r108.length()) goto L28;
        char r115 = r108.charAt(r114);
        if (CodecsKt.f491801b.contains(Character.valueOf(r115)) == true) goto L27;
        if (CodecsKt.f491804e.contains(Character.valueOf(r115)) == true) goto L27;
        if (r115 != '%') goto L23;
        int r116 = r114 + 2;
        if (r116 >= r108.length()) goto L23;
        Set<Character> r117 = CodecsKt.f491802c;
        int r118 = r114 + 1;
        if (r117.contains(Character.valueOf(r108.charAt(r118))) == false) goto L23;
        if (r117.contains(Character.valueOf(r108.charAt(r116))) == false) goto L23;
        r109.append(r115);
        r109.append(r108.charAt(r118));
        r109.append(r108.charAt(r116));
        r114 = r114 + 3;
    L23:
        if (CharsKt.isSurrogate(r115) == false) goto L25;
        int r119 = 2;
    L26:
        int r120 = r119 + r114;
        CodecsKt.h(ksc.b.b(r113.newEncoder(), r108, r114, r120), new CodecsKt$encodeURLPath$1$1(r109));
        r114 = r120;
        goto L7
    L25:
        r119 = 1;
    L27:
        r109.append(r115);
        r114 = r114 + 1;
        goto L7
    L28:
        r106.add(r109.toString());
        goto L4
    L29:
        this.f491869h = r106;
        Intrinsics.checkNotNullParameter(r101, "parameters");
        b0 r121 = d0.a();
        n0.a(r121, r101);
        this.f491870i = r121;
        this.f491871j = new m0(r121);
    }

    public final void d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491869h = r100;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491863b = r100;
    }

    public final void f(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491862a = r100;
    }
}

package tw8;

import android.text.Spanned;
import android.util.Size;
import com.larus.business.markdown.impl.markwon.e;
import io.noties.markwon.core.CoreProps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.u;
import lsc.y;
import tsc.a0;
import tsc.g;
import tsc.l;
import tsc.m;
import tsc.v;
import usc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.larus.business.markdown.api.depend.a> f547798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f547800c;

    public static final class a {
    }

    static {
    }

    @Override // tsc.a0
    public final Collection c() {
        return CollectionsKt.listOf(new String[]{"data-block", "data-inline", "data-inline-no-margin", "data-block-full"});
    }

    @Override // tsc.a0
    public final CharSequence b(m r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "emptyReplacement");
        String r102 = r100.b().get("alt");
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r101.getClass();
        r102 = g.a(r100);
    L11:
        if (r102 != null) goto L13;
    L16:
        if (r103 == false) goto L19;
        return " ";
    L19:
        return r102;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L16
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends com.larus.business.markdown.api.depend.a> r100, boolean r101, boolean r102) {
        this.f547798a = r100;
        this.f547799b = r101;
        this.f547800c = r102;
    }

    @Override // tsc.a0
    public final void a(lsc.m r210, v r211, l r212) {
        Intrinsics.checkNotNullParameter(r210, "visitor");
        Intrinsics.checkNotNullParameter(r211, "renderer");
        Intrinsics.checkNotNullParameter(r212, "tag");
        String r100 = r212.b().get("type");
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r212.b().get("value");
        if (r101 != null) goto L8;
        String r102 = "";
    L9:
        String r103 = r212.b().get("value_id");
        if (r103 != null) goto L12;
        String r104 = "";
    L13:
        String r105 = r212.b().get("extra");
        t r106 = r210.r();
        u r107 = (u) r106;
        Integer r108 = (Integer) r107.a(e.f320693a);
        if (r108 != null) goto L16;
        return;
    L16:
        int r110 = r108.intValue();
        t r109 = r210.r();
        u r111 = (u) r109;
        Object r112 = r111.a(e.f320695c);
        if ((r112 instanceof Map) == false) goto L19;
        Map<String, ? extends Object> r113 = (Map) r112;
    L20:
        t r114 = r210.r();
        u r115 = (u) r114;
        CharSequence r116 = (CharSequence) r115.a(e.f320694b);
        List<com.larus.business.markdown.api.depend.a> r117 = this.f547798a;
        if (r117 == null) goto L97;
        Iterator<T> r118 = r117.iterator();
    L24:
        if (r118.hasNext() == false) goto L28;
        Object r119 = r118.next();
        if (((com.larus.business.markdown.api.depend.a) r119).a(r100) == false) goto L24;
    L29:
        com.larus.business.markdown.api.depend.a r120 = (com.larus.business.markdown.api.depend.a) r119;
        if (r120 != null) goto L32;
        return;
    L32:
        if ((r116 instanceof Spanned) == false) goto L34;
        Spanned r121 = (Spanned) r116;
    L36:
        if (r121 == null) goto L75;
        b[] r122 = (b[]) r121.getSpans(r212.start(), r212.end(), b.class);
        if (r122 == null) goto L73;
        int r123 = r122.length;
        int r124 = 0;
    L40:
        if (r124 >= r123) goto L60;
        b r125 = r122[r124];
        if (Intrinsics.areEqual(r125.f547780a, r100) == true) goto L44;
    L56:
        boolean r126 = false;
    L57:
        if (r126 == true) goto L61;
        r124 = r124 + 1;
    L61:
        if (r125 == null) goto L73;
        r125.f547787h = r110;
        r125.f547789j = r113;
        if (r125.f547792m == false) goto L72;
        f r127 = r125.f547796q;
        Spanned r128 = r125.f547795p;
        if (r127 == null) goto L72;
        if (r128 == null) goto L72;
        if (r125.f547797r.getHeight() <= 0) goto L70;
        int r129 = r125.f547797r.getHeight();
    L71:
        r125.f547797r = new Size(r125.n(r128), r129);
        goto L72
    L70:
        r129 = r127.asView().getMeasuredHeight();
    L72:
        b r130 = r125;
    L74:
        if (r130 == null) goto L75;
    L83:
        y.f(r210.builder(), r130, r212.start(), r212.end());
        HashMap<String, Integer> r131 = CoreProps.f492268j.a(r210.r());
        if (r131 == null) goto L87;
        Integer r132 = r131.get(r100);
        if (r132 == null) goto L87;
    L88:
        int r133 = r132.intValue() + 1;
        if (r131 == null) goto L99;
        Integer r134 = r131.put(r100, Integer.valueOf(r133));
        return;
    L99:
        return;
    L87:
        r132 = 0;
        goto L88
    L44:
        if (Intrinsics.areEqual(r125.f547781b, r102) == false) goto L56;
        if (Intrinsics.areEqual(r125.f547782c, r104) == false) goto L56;
        if (r125.f547785f != r212.start()) goto L56;
        if (r125.f547786g != r212.end()) goto L56;
        if (r125.f547793n == true) goto L56;
        if (Intrinsics.areEqual(r125.f547784e, r212.name()) == false) goto L56;
        r126 = true;
        goto L57
    L60:
        r125 = null;
    L73:
        r130 = null;
    L75:
        String r135 = r212.name();
        int r136 = r212.start();
        int r137 = r212.end();
        if (Intrinsics.areEqual(r212.name(), "data-inline-no-margin") == false) goto L78;
    L81:
        boolean r138 = true;
    L82:
        r130 = new b(r100, r102, r104, r105, r135, r136, r137, r110, r120, r113, r138, this.f547799b, this.f547800c);
        goto L83
    L78:
        if (Intrinsics.areEqual(r100, "creation") == true) goto L81;
        r138 = false;
        goto L82
    L34:
        r121 = null;
        goto L36
    L28:
        r119 = null;
        goto L29
    L97:
        return;
    L19:
        r113 = null;
        goto L20
    L12:
        r104 = r103;
        goto L13
    L8:
        r102 = r101;
        goto L9
    }
}

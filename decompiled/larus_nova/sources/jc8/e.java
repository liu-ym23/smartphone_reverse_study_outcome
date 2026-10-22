package jc8;

import android.content.res.Resources;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MetaInfoBlock;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    public static final int b(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static final d d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = r100.m();
        boolean r102 = r100.n();
        if (r101 == false) goto L7;
        if (r102 == false) goto L7;
        d r103 = new d(b(16), b(12), b(16), b(14));
    L13:
        return a(r100, r103);
    L7:
        if (r101 == false) goto L9;
        r103 = new d(b(16), b(12), b(16), b(6));
        goto L13
    L9:
        if (r102 == false) goto L11;
        r103 = new d(b(16), b(6), b(16), b(14));
        goto L13
    L11:
        r103 = new d(b(16), b(6), b(16), b(6));
        goto L13
    }

    public static final d a(a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_MARGIN);
        f r102 = r100.f498148d;
        int r103 = 0;
        if (r102 == null) goto L38;
        a r104 = r102.f498162c;
        if (r104 == null) goto L38;
        BlockContent r105 = r104.f498145a.getContent();
        MetaInfoBlock r106 = null;
        if (r105 == null) goto L10;
        MetaInfoBlock r107 = r105.getMetaInfoBlock();
    L11:
        boolean r108 = true;
        if (r107 == null) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == true) goto L39;
        String r110 = r100.f498145a.getParentId();
        if (r110 == null) goto L38;
        if (r110.length() <= 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L26;
        r110 = null;
    L26:
        if (r110 == null) goto L38;
        a r112 = c(r104, r110);
        if (r112 == null) goto L38;
        BlockContent r113 = r112.f498145a.getContent();
        if (r113 == null) goto L33;
        r106 = r113.getMetaInfoBlock();
    L33:
        if (r106 == null) goto L35;
        boolean r114 = true;
    L36:
        if (r114 != true) goto L38;
    L35:
        r114 = false;
        goto L36
    L22:
        r111 = false;
    L39:
        if (r108 == true) goto L42;
        return r101;
    L42:
        if (r100.m() == true) goto L44;
    L46:
        int r115 = b(6);
    L47:
        int r116 = r101.f498156a;
        if (r116 <= 0) goto L50;
        r116 = 0;
    L50:
        int r117 = r101.f498158c;
        if (r117 > 0) goto L55;
        r103 = r117;
    L55:
        return d.a(r101, r116, r103, r115, 2);
    L44:
        if (r100.n() == false) goto L46;
        r115 = r101.f498159d;
        goto L47
    L14:
        r109 = false;
        goto L15
    L10:
        r107 = null;
    L38:
        r108 = false;
        goto L39
    }

    public static final a c(a r100, String r101) {
        Iterator<T> r102 = r100.i().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        a r103 = (a) r102.next();
        if (Intrinsics.areEqual(r103.h(), r101) == true) goto L7;
        a r104 = c(r103, r101);
        if (r104 == null) goto L4;
        return r104;
    L7:
        return r103;
    L11:
        return null;
    }
}

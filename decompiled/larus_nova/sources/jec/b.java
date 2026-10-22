package jec;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498844a = 0;

    static {
    }

    public static int d(c r100) {
        if (r100.f498845a.getTag() == RichTextElement.RichTextTag.LI) goto L5;
        return 0;
    L5:
        return Math.max(((RichTextElement.LIProperty) r100.f498845a.getProperty()).getFloor(), 0);
    }

    public static c a(c r100, List r101) {
        RichTextElement r102 = r100.f498845a;
        RichTextElement.RichTextProperty r103 = r102.getElementExtra().getFloorInfo().getFloorProperty();
        if ((r103 instanceof RichTextElement.OLProperty) == false) goto L5;
        RichTextElement.RichTextTag r104 = RichTextElement.RichTextTag.OL;
    L7:
        if (r104 != RichTextElement.RichTextTag.OL) goto L10;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement.OLProperty");
        c r105 = new c(RichTextElementCreator.h((RichTextElement.OLProperty) r103), new ArrayList());
    L16:
        ((RichTextElement.LIProperty) r102.getProperty()).getFloor();
        ArrayList r106 = new ArrayList();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f498846b = r106;
        int r107 = 0;
    L18:
        if (r107 >= r101.size()) goto L24;
        c r108 = (c) ListProtector.get(r101, r107);
        if (r108.f498845a.getTag() == RichTextElement.RichTextTag.LI) goto L24;
        r100.f498846b.add(r108);
        r107 = r107 + 1;
    L24:
        if ((!r100.f498846b.isEmpty()) == false) goto L26;
        r105.f498846b.add(r100);
    L26:
        int r109 = d(r100);
    L28:
        if (r107 >= r101.size()) goto L35;
        c r110 = (c) ListProtector.get(r101, r107);
        if (r110.f498845a.getTag() == RichTextElement.RichTextTag.LI) goto L32;
        r105.f498846b.add(r110);
    L33:
        r107 = r107 + 1;
        goto L28
    L32:
        c r111 = c(r110, r109 + 1);
        e(r105.f498846b, a(r111, r111.f498846b));
        goto L33
    L35:
        if (r105.f498846b.isEmpty() == false) goto L37;
        r105.f498846b.add(r100);
    L37:
        return r105;
    L10:
        if ((r103 instanceof RichTextElement.ULProperty) == false) goto L12;
        RichTextElement.ULProperty r112 = (RichTextElement.ULProperty) r103;
    L13:
        if (r112 != null) goto L15;
        RichTextElement.ULProperty.Type r113 = RichTextElement.ULProperty.Type.NONE;
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r114 = RichTextElementCreator.f448209a;
        Intrinsics.checkNotNullParameter(r113, "type");
        RichTextElement.ULProperty r115 = new RichTextElement.ULProperty();
        r115.setType(r113);
        r112 = r115;
    L15:
        r105 = new c(RichTextElementCreator.h(r112), new ArrayList());
        goto L16
    L12:
        r112 = null;
        goto L13
    L5:
        r104 = RichTextElement.RichTextTag.UL;
        goto L7
    }

    public static c c(c r100, int r101) {
        if (r100.f498845a.getTag() == RichTextElement.RichTextTag.LI) goto L5;
        return r100;
    L5:
        int r102 = d(r100);
        RichTextElement.RichTextProperty r103 = r100.f498845a.getElementExtra().getFloorInfo().getFloorProperty();
    L6:
        int r104 = r102 - 1;
        if (r102 <= r101) goto L9;
        RichTextElement.LIProperty r105 = new RichTextElement.LIProperty();
        r105.setFloor(r104);
        RichTextElement r106 = RichTextElementCreator.h(r105);
        r106.getElementExtra().getFloorInfo().setFloorProperty(r103);
        c r107 = new c(r106, CollectionsKt.mutableListOf(new c[]{r100}));
        r102 = r104;
        r100 = r107;
        goto L6
    L9:
        return r100;
    }

    public static void e(List r100, c r101) {
        if (r100.isEmpty() == false) goto L6;
        r100.add(r101);
        return;
    L6:
        c r102 = (c) CollectionsKt.last(r100);
        RichTextElement.RichTextTag r103 = r102.f498845a.getTag();
        if (r103 != RichTextElement.RichTextTag.OL) goto L9;
    L12:
        int r104 = d(r102);
        if (d(r101) == r104) goto L15;
    L19:
        r100.add(r101);
        return;
    L15:
        if (r101.f498845a.getTag() != r103) goto L19;
        r102.f498846b.addAll(r101.f498846b);
        return;
    L9:
        if (r103 == RichTextElement.RichTextTag.UL) goto L12;
        r100.add(r101);
    }

    public static void b(int r100, LinkedList r101, LinkedList r102, List r103) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        r102.clear();
    L7:
        if ((!r101.isEmpty()) == false) goto L16;
        if (d((c) r101.getLast()) <= r100) goto L16;
        c r104 = (c) r101.remove(CollectionsKt.getLastIndex(r101));
        r102.addFirst(r104);
        if ((!r101.isEmpty()) == false) goto L7;
        if (d((c) r101.getLast()) >= d(r104)) goto L7;
        ((c) r101.getLast()).f498846b.addAll(r102);
        r102.clear();
    L16:
        if ((!r102.isEmpty()) == false) goto L22;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        c r107 = c((c) r106.next(), 0);
        e(r105, a(r107, r107.f498846b));
        goto L19
    L21:
        ((ArrayList) r103).addAll(r105);
    L22:
        r102.clear();
    }
}

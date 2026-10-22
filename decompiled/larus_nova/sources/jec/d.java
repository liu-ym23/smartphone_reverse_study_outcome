package jec;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498847a = 0;

    static {
    }

    public static void a(RichTextElement r110, AtomicInteger r111, List r112, RichText r113) {
        Intrinsics.checkNotNullParameter(r110, "element");
        Intrinsics.checkNotNullParameter(r111, "idGenerator");
        Intrinsics.checkNotNullParameter(r112, "nodeList");
        Intrinsics.checkNotNullParameter(r113, "richText");
        Map<String, RichTextElement> r100 = r113.getElements().getDictionary();
        LinkedList r101 = new LinkedList();
        Iterator r114 = r112.iterator();
    L4:
        if (r114.hasNext() == false) goto L13;
        c r102 = (c) r114.next();
        String r103 = String.valueOf(r111.getAndIncrement());
        if (r102 == null) goto L4;
        RichTextElement r104 = r102.f498845a;
        if (r104 == null) goto L4;
        Intrinsics.checkNotNull(r100);
        r100.put(r103, r104);
        r101.add(r103);
        if (CollectionUtils.isNotEmpty(r102.f498846b) == false) goto L4;
        a(r104, r111, r102.f498846b, r113);
        goto L4
    L13:
        LinkedList r115 = new LinkedList();
        ArrayList r105 = new ArrayList();
    L14:
        boolean r106 = true;
        if ((!r101.isEmpty()) == false) goto L71;
        String r107 = (String) r101.remove(0);
        if (r107 == null) goto L14;
        RichTextElement r108 = r100.get(r107);
        if (r108 == null) goto L14;
        RichTextElement.RichTextTag r109 = r108.getTag();
        if (r109 == null) goto L14;
        EnumSet<RichTextElement.RichTextTag> r116 = a.f498841a;
        Intrinsics.checkNotNullParameter(r113, "richText");
        Intrinsics.checkNotNullParameter(r109, "tag");
        Intrinsics.checkNotNullParameter(r107, "id");
        switch(a.C6429a.f498843a[r109.ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L34;
        };
    L28:
        r113.getMarkdownIds().add(r107);
        goto L34
    L29:
        r113.getAtUserGroupIds().add(r107);
        goto L34
    L30:
        r113.getMediaIds().add(r107);
        goto L34
    L31:
        r113.getAnchorIds().add(r107);
        goto L34
    L32:
        r113.getAtIds().add(r107);
        goto L34
    L33:
        r113.getImageIds().add(r107);
    L34:
        Intrinsics.checkNotNullParameter(r108, "element");
        if (a.f498841a.contains(r108.getTag()) == true) goto L36;
        r115.add(r107);
        goto L14
    L36:
        Intrinsics.checkNotNull(r100);
        if (r115.isEmpty() == true) goto L55;
        if (r108.getTag() != RichTextElement.RichTextTag.PARAGRAPH) goto L42;
        String r117 = r107;
        RichTextElement r118 = r108;
    L43:
        List<String> r119 = r118.getChildIds();
        if (r119 != null) goto L46;
    L49:
        boolean r120 = true;
    L50:
        if (r120 == false) goto L52;
        r118.setChildIds(r115);
    L53:
        r105.add(r117);
        r115.clear();
        goto L55
    L52:
        r118.setChildIds(CollectionsKt.plus(r115, r118.getChildIds()));
        goto L53
    L46:
        if (r119.isEmpty() == true) goto L49;
        r120 = false;
        goto L50
    L42:
        r118 = RichTextElementCreator.d();
        r117 = String.valueOf(r111.getAndIncrement());
        r100.put(r117, r118);
    L55:
        if (r110.getTag() == RichTextElement.RichTextTag.IMAGE_GALLERY) goto L67;
        if (r108.getTag() != RichTextElement.RichTextTag.IMG) goto L59;
    L62:
        if (r106 == false) goto L67;
        if (r110.getTag() == RichTextElement.RichTextTag.FIGURE) goto L67;
        String r121 = String.valueOf(r111.getAndIncrement());
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r122 = RichTextElementCreator.f448209a;
        RichTextElement r123 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
        r100.put(r121, r123);
        r123.setChildIds(CollectionsKt.listOf(r107));
        r107 = r121;
        goto L67
    L59:
        if (r108.getTag() == RichTextElement.RichTextTag.MEDIA) goto L62;
        r106 = false;
    L67:
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(r105), r107) == true) goto L14;
        r105.add(r107);
        goto L14
    L71:
        if ((!r115.isEmpty()) == true) goto L73;
    L79:
        r110.setChildIds(r105);
        return;
    L73:
        if ((!r105.isEmpty()) == true) goto L78;
        EnumSet<RichTextElement.RichTextTag> r124 = a.f498841a;
        Intrinsics.checkNotNullParameter(r110, "element");
        if (a.f498842b.contains(r110.getTag()) == true) goto L78;
        r105.addAll(r115);
    L78:
        RichTextElement r125 = RichTextElementCreator.d();
        String r126 = String.valueOf(r111.getAndIncrement());
        Intrinsics.checkNotNull(r100);
        r100.put(r126, r125);
        r105.add(r126);
        r125.setChildIds(r115);
        r115.clear();
        goto L79
    }
}

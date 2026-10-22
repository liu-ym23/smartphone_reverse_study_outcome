package r3;

import com.bytedance.ai.bridge.doubao.chat.AbsSetChatActionBarMethodIDL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r2.e;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final r2.c a(List<AbsSetChatActionBarMethodIDL.ChatActionBarItem> r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        a r100 = new a();
        Intrinsics.checkNotNullParameter(r210, "items");
        List<AbsSetChatActionBarMethodIDL.ChatActionBarItem> r101 = r210;
        int r102 = 10;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L75;
        AbsSetChatActionBarMethodIDL.ChatActionBarItem r105 = (AbsSetChatActionBarMethodIDL.ChatActionBarItem) r104.next();
        r100.c(r105.getId());
        int r106 = a.c.f535853a[r105.getKind().ordinal()];
        int r107 = 0;
        boolean r108 = true;
        if (r106 != 1) goto L8;
        Iterator r110 = r104;
        String r109 = "action item " + r105.getId();
        String r111 = a.d(r105.getTitle(), r109 + " title is empty");
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r112 = r105.getItems();
        if (r112 != null) goto L59;
    L62:
        boolean r113 = true;
    L63:
        if (r113 == false) goto L73;
        if (r105.getRowCount() != null) goto L67;
        r107 = 1;
    L67:
        if (r107 == 0) goto L71;
        a.b r114 = a.b(r105.getIcon(), r109);
        e r115 = new e(r105.getId(), r111, r114.f535851a, r114.f535852b, new r2.b.C7425b(a.a(r105.getAction(), r109)));
    L69:
        r103.add(r115);
        r104 = r110;
        r102 = 10;
        goto L4
    L71:
        throw new IllegalArgumentException((r109 + " rowCount is only supported by an action_group item").toString());
    L73:
        throw new IllegalArgumentException((r109 + " items must be empty").toString());
    L59:
        if (r112.isEmpty() == true) goto L62;
        r113 = false;
        goto L63
    L8:
        if (r106 != 2) goto L55;
        String r116 = "action group item " + r105.getId();
        String r117 = a.d(r105.getTitle(), r116 + " title is empty");
        if (r105.getAction() != null) goto L12;
        boolean r118 = true;
    L13:
        if (r118 == false) goto L53;
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r119 = r105.getItems();
        if (r119 != null) goto L18;
        r119 = CollectionsKt.emptyList();
    L18:
        if ((!r119.isEmpty()) == false) goto L51;
        Integer r120 = r105.getRowCount();
        if (r120 == null) goto L22;
        int r121 = r120.intValue();
    L23:
        if (1 <= r121) goto L25;
    L27:
        r108 = false;
    L28:
        if (r108 == false) goto L49;
        a.b r122 = a.b(r105.getIcon(), r116);
        String r123 = r105.getId();
        String r124 = r122.f535851a;
        String r125 = r122.f535852b;
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r126 = r119;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, r102));
        Iterator r128 = r126.iterator();
    L31:
        if (r128.hasNext() == false) goto L47;
        Object r129 = r128.next();
        int r130 = r107 + 1;
        if (r107 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem r131 = (AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem) r129;
        Intrinsics.checkNotNull(r131);
        String r132 = r105.getId();
        Iterator r133 = r104;
        StringBuilder r134 = new StringBuilder("action group item ");
        r134.append(r132);
        Iterator r135 = r128;
        r134.append(" items[");
        r134.append(r107);
        r134.append(']');
        String r136 = r134.toString();
        String r137 = a.d(r131.getId(), r136 + " id is empty");
        r100.c(r137);
        String r138 = "action group item " + r132 + '/' + r137;
        String r211 = a.d(r131.getTitle(), r138 + " title is empty");
        AbsSetChatActionBarMethodIDL.ChatActionBarIcon r139 = r131.getIcon();
        if (r139 == null) goto L38;
        a.b r140 = a.b(r139, r138);
    L39:
        r2.a r212 = a.a(r131.getAction(), r138);
        if (r140 == null) goto L42;
        String r213 = r140.f535851a;
    L43:
        if (r140 == null) goto L45;
        String r214 = r140.f535852b;
    L46:
        r127.add(new r2.d(r137, r211, r213, r214, r212));
        r107 = r130;
        r128 = r135;
        r104 = r133;
        goto L31
    L45:
        r214 = null;
        goto L46
    L42:
        r213 = null;
        goto L43
    L38:
        r140 = null;
        goto L39
    L47:
        r110 = r104;
        r115 = new e(r123, r117, r124, r125, new r2.b.a(r127, r121));
        goto L69
    L49:
        throw new IllegalArgumentException((r116 + " rowCount must be between 1 and " + r119.size()).toString());
    L25:
        if (r121 > r119.size()) goto L27;
    L22:
        r121 = 1;
        goto L23
    L51:
        throw new IllegalArgumentException((r116 + " items is empty").toString());
    L53:
        throw new IllegalArgumentException((r116 + " action must be empty").toString());
    L12:
        r118 = false;
        goto L13
    L55:
        throw new NoWhenBranchMatchedException();
    L75:
        return new r2.c(r103);
    }
}

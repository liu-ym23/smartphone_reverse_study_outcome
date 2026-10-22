package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class x {
    public static final w d(ComplexTaskBlock r100) {
        String r101 = r100.displayType;
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L8:
        String r102 = r100.agentType;
        if (r102 != null) goto L11;
    L13:
        r102 = null;
    L14:
        if (r101 != null) goto L18;
        if (r102 != null) goto L18;
        return null;
    L18:
        return new w(r101, r102);
    L11:
        if ((!StringsKt.isBlank(r102)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        goto L7
    }

    public static final void a(JSONObject r100, w r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = null;
        if (r101 == null) goto L12;
        String r103 = r101.f312442a;
        if (r103 == null) goto L12;
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        r100.put("display_type", r103);
    L12:
        if (r101 == null) goto L21;
        String r104 = r101.f312443b;
        if (r104 != null) goto L16;
        return;
    L16:
        if ((!StringsKt.isBlank(r104)) == false) goto L18;
        r102 = r104;
    L18:
        if (r102 == null) goto L23;
        r100.put("agent_type", r102);
        return;
    L23:
        return;
    }

    public static final w b(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<Block> r102 = r100.getContentBlock();
        if (r102 != null) goto L6;
        r102 = CollectionsKt.emptyList();
    L6:
        return c(r102, r100.getThreadId(), r101);
    }

    public static final w c(List<Block> r100, String r101, Block r102) {
        Intrinsics.checkNotNullParameter(r100, "blocks");
        if (r102 == null) goto L11;
        BlockContent r103 = r102.getContent();
        if (r103 == null) goto L11;
        ComplexTaskBlock r104 = r103.getComplexTaskBlock();
        if (r104 == null) goto L11;
        w r105 = d(r104);
        if (r105 == null) goto L11;
        return r105;
    L11:
        List<Block> r106 = r100;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L12:
        Pair r109 = null;
        if (r108.hasNext() == false) goto L24;
        Block r110 = (Block) r108.next();
        String r111 = r110.getBlockId();
        if (r111 != null) goto L17;
    L22:
        if (r109 == null) goto L12;
        r107.add(r109);
        goto L12
    L17:
        if ((true ^ StringsKt.isBlank(r111)) == true) goto L20;
        r111 = null;
    L20:
        if (r111 == null) goto L22;
        r109 = TuplesKt.to(r111, r110);
        goto L22
    L24:
        Map r112 = MapsKt.toMap(r107);
        if (r102 == null) goto L27;
        String r113 = r102.getParentId();
    L28:
        LinkedHashSet r114 = new LinkedHashSet();
    L29:
        if (r113 != null) goto L31;
    L34:
        boolean r115 = true;
    L35:
        if (r115 == true) goto L49;
        if (r114.add(r113) == false) goto L49;
        Block r116 = (Block) r112.get(r113);
        if (r116 == null) goto L49;
        BlockContent r117 = r116.getContent();
        if (r117 == null) goto L48;
        ComplexTaskBlock r118 = r117.getComplexTaskBlock();
        if (r118 == null) goto L48;
        w r119 = d(r118);
        if (r119 == null) goto L48;
        return r119;
    L48:
        r113 = r116.getParentId();
    L49:
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r106.iterator();
    L51:
        if (r121.hasNext() == false) goto L58;
        BlockContent r122 = ((Block) r121.next()).getContent();
        if (r122 == null) goto L55;
        ComplexTaskBlock r123 = r122.getComplexTaskBlock();
    L56:
        if (r123 == null) goto L51;
        r120.add(r123);
        goto L51
    L55:
        r123 = null;
        goto L56
    L58:
        if (r101 != null) goto L60;
    L72:
        ComplexTaskBlock r124 = null;
    L73:
        if (r124 != null) goto L75;
        r124 = (ComplexTaskBlock) CollectionsKt.singleOrNull(r120);
    L75:
        if (r124 != null) goto L77;
        return null;
    L77:
        return d(r124);
    L60:
        if ((!StringsKt.isBlank(r101)) == true) goto L63;
        r101 = null;
    L63:
        if (r101 == null) goto L72;
        Iterator r125 = r120.iterator();
    L66:
        if (r125.hasNext() == false) goto L70;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((ComplexTaskBlock) r126).threadId, r101) == false) goto L66;
    L71:
        r124 = (ComplexTaskBlock) r126;
        goto L73
    L70:
        r126 = null;
        goto L71
    L31:
        if (StringsKt.isBlank(r113) == true) goto L34;
        r115 = false;
        goto L35
    L27:
        r113 = null;
        goto L28
    }
}

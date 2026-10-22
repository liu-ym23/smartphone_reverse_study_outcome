package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o2<T, R> implements Function {
    public final /* synthetic */ ar5.a a;
    public final /* synthetic */ ce5.a b;

    public o2(ar5.a r1, ce5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r13) {
        WikiRelation r14 = (WikiRelation) r13;
        Intrinsics.checkNotNullParameter(r14, "relation");
        int r1 = ar5.c.a;
        Intrinsics.checkNotNullParameter(r14, "relation");
        WikiRelation.Tree r2 = r14.tree;
        if (r2 == null) goto L11;
        List<String> r3 = r2.paths;
        if (r3 == null) goto L11;
        if (r3.isEmpty() == true) goto L11;
        ar5.d r4 = new ar5.d(CollectionsKt.toList(r3));
    L12:
        ar5.a r5 = this.a;
        ce5.a r6 = this.b;
        Intrinsics.checkNotNullParameter(r14, "relation");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        Integer r0 = r14.pathResolveResult;
        if (r0 == null) goto L150;
        boolean r7 = true;
        if (r0.intValue() != 1) goto L150;
        if (r4 == null) goto L150;
        if (r14.isValid() == false) goto L182;
        WikiRelation.Tree r8 = r14.tree;
        if (r8.nodes == null) goto L182;
        if (r8.child_map == null) goto L182;
        if (TextUtils.equals(r14.space.space_id, r5.a) == false) goto L173;
        List<String> r9 = r4.a;
        if (r9.size() < 3) goto L181;
        if (TextUtils.equals((CharSequence) CollectionsKt.first(r9), r14.tree.root_token) == false) goto L181;
        if (TextUtils.equals((CharSequence) CollectionsKt.last(r9), r5.c) == false) goto L181;
        List<String> r10 = r9;
        if ((r10 instanceof Collection) == true) goto L39;
    L41:
        Iterator<T> r11 = r10.iterator();
    L43:
        if (r11.hasNext() == false) goto L56;
        String r12 = (String) r11.next();
        if (r12.length() != 0) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
    L53:
        boolean r16 = true;
    L54:
        if (r16 == false) goto L43;
        boolean r17 = true;
    L57:
        if (r17 == true) goto L174;
        int r18 = CollectionsKt.getLastIndex(r9);
        int r19 = 0;
    L60:
        boolean r20 = false;
    L61:
        if (r19 >= r18) goto L80;
        TreeNode r21 = r14.tree.nodes.get(ListProtector.get(r9, r19));
        if (r21 == null) goto L175;
        if (r21.isShortcut() == false) goto L70;
        List<String> r22 = r14.tree.child_map.get(r21.wiki_token);
        if (r22 != null) goto L71;
        r22 = r14.tree.child_map.get(r21.getOriginToken());
    L71:
        if (r22 == null) goto L176;
        r19 = r19 + 1;
        if (r22.contains(ListProtector.get(r9, r19)) == false) goto L177;
        if (r20 == true) goto L79;
        if (r21.isShortcut() == false) goto L60;
    L79:
        r20 = true;
        goto L61
    L177:
        return new ar5.b.a(false);
    L176:
        return new ar5.b.a(false);
    L70:
        r22 = r14.tree.child_map.get(r21.getOriginToken());
        goto L71
    L175:
        return new ar5.b.a(false);
    L80:
        if (r20 == false) goto L178;
        e3 r23 = new e3(r14, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e(), r6);
        String r24 = "";
        if (hu5.a.d(r9) == false) goto L85;
    L140:
        Intrinsics.checkNotNull(r24);
        if (r24.length() == 0) goto L144;
        r7 = false;
    L144:
        if (r7 == false) goto L180;
        return new ar5.b.a(false);
    L180:
        return new ar5.b.C0004b(r23, r4, r24);
    L85:
        if (TextUtils.equals(r23.b, (CharSequence) ListProtector.get(r9, 0)) == false) goto L140;
        HashMap r110 = new HashMap();
        int r25 = 0;
        boolean r26 = false;
    L89:
        if (r25 >= r9.size()) goto L118;
        Map<String, TreeNode> r27 = r23.g;
        ConcurrentHashMap r28 = (ConcurrentHashMap) r27;
        TreeNode r29 = (TreeNode) r28.get(ListProtector.get(r9, r25));
        if (r29 == null) goto L140;
        if (r26 == false) goto L95;
    L98:
        r26 = true;
    L100:
        if (r25 >= (r9.size() - 1)) goto L117;
        if (r29.isShortcut() == false) goto L104;
        Map<String, List<String>> r30 = r23.f;
        ConcurrentHashMap r31 = (ConcurrentHashMap) r30;
        List r32 = (List) r31.get(r29.wiki_token);
    L105:
        if (r32 != null) goto L110;
        if (r29.isShortcut() == false) goto L110;
        Map<String, List<String>> r33 = r23.f;
        ConcurrentHashMap r34 = (ConcurrentHashMap) r33;
        r32 = (List) r34.get(r29.getOriginToken());
    L110:
        if (hu5.a.d(r32) == true) goto L140;
        if (r32.contains(ListProtector.get(r9, r25 + 1)) == false) goto L140;
        if (r29.isShortcut() == false) goto L117;
        r110.put(r29.getOriginToken(), r32);
        goto L117
    L104:
        Map<String, List<String>> r35 = r23.f;
        ConcurrentHashMap r36 = (ConcurrentHashMap) r35;
        r32 = (List) r36.get(r29.getOriginToken());
    L117:
        r25 = r25 + 1;
        goto L89
    L95:
        if (r29.isShortcut() == true) goto L98;
        r26 = false;
        goto L100
    L118:
        if (r26 == false) goto L140;
        ((ConcurrentHashMap) r23.f).putAll(r110);
        String r111 = (String) ListProtector.get(r9, 0);
        String r37 = "";
        int r38 = 0;
    L122:
        if (r38 >= r9.size()) goto L139;
        String r39 = (String) ListProtector.get(r9, r38);
        TreeNode r40 = (TreeNode) ((ConcurrentHashMap) r23.g).get(r39);
        if (r38 != 0) goto L126;
        int r112 = 0;
    L127:
        String r113 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r111, r39, r112, r24);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r41 = r23.n(r113, r37, r39);
        r41.e = r112;
        if (r38 >= (r9.size() - 1)) goto L130;
    L137:
        boolean r114 = true;
    L138:
        r41.d = r114;
        r24 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.b(r40.isShortcut(), r39, r24);
        r38 = r38 + 1;
        r37 = r113;
        goto L122
    L130:
        if (r23.q(r40.getOriginToken()) == true) goto L137;
        if (r40.isShortcut() == true) goto L134;
    L136:
        r114 = false;
        goto L138
    L134:
        if (r23.q(r40.wiki_token) == false) goto L136;
    L126:
        r112 = r38;
        goto L127
    L139:
        r24 = r37;
        goto L140
    L178:
        return new ar5.b.a(false);
    L174:
        return new ar5.b.a(false);
    L50:
        if (r14.tree.nodes.get(r12) == null) goto L53;
        r16 = false;
        goto L54
    L47:
        r15 = false;
    L56:
        r17 = false;
        goto L57
    L39:
        if (r10.isEmpty() == false) goto L41;
    L181:
        return new ar5.b.a(false);
    L173:
        return new ar5.b.a(false);
    L182:
        return new ar5.b.a(false);
    L150:
        return new ar5.b.a(false);
    L11:
        r4 = null;
        goto L12
    }
}

package kq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final void a(String r1, WikiRelation.Tree r2) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "parentTree");
        List r0 = r2.root_list;
        if (r0 != null) goto L6;
        r0 = new ArrayList();
        r2.root_list = r0;
    L6:
        if (r0.contains(r1) == true) goto L9;
        r0.add(r1);
        return;
    }

    @JvmStatic
    public static final void c(WikiRelation.Tree r9, WikiRelation.Tree r10) {
        Intrinsics.checkNotNullParameter(r9, "appendTree");
        Intrinsics.checkNotNullParameter(r10, "mergeTree");
        List<String> r0 = r9.root_list;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        Intrinsics.checkNotNull(r2);
        a(r2, r10);
    L8:
        HashMap<String, TreeNode> r3 = r9.nodes;
        if (r3 == null) goto L14;
        Iterator<Map.Entry<String, TreeNode>> r4 = r3.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, TreeNode> r5 = r4.next();
        String r6 = r5.getKey();
        TreeNode r7 = r5.getValue();
        Intrinsics.checkNotNull(r7);
        b(r7, r10, true);
    L14:
        HashMap<String, List<String>> r11 = r9.child_map;
        if (r11 == null) goto L36;
        Iterator<Map.Entry<String, List<String>>> r12 = r11.entrySet().iterator();
    L18:
        if (r12.hasNext() == false) goto L46;
        Map.Entry<String, List<String>> r8 = r12.next();
        String r13 = r8.getKey();
        List<String> r14 = r8.getValue();
        if (r14 == null) goto L18;
        ArrayList r15 = new ArrayList();
        int r16 = r14.size();
        int r17 = 0;
    L22:
        if (r17 >= r16) goto L18;
        Intrinsics.checkNotNull(r13);
        String r18 = (String) ListProtector.get(r14, r17);
        Intrinsics.checkNotNullParameter(r13, "parentToken");
        Intrinsics.checkNotNullParameter(r18, "childToken");
        Intrinsics.checkNotNullParameter(r15, "childMapList");
        Intrinsics.checkNotNullParameter(r10, "parentTree");
        r10.child_map.put(r13, r15);
        if (r15.contains(r18) == true) goto L33;
        VirtualNode.Companion.getClass();
        if (VirtualNode.a.a(r18) == true) goto L29;
        ListProtector.add(r15, r17, r18);
        goto L33
    L29:
        if (Intrinsics.areEqual(VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken(), r18) == false) goto L31;
        ListProtector.add(r15, 0, r18);
        goto L33
    L31:
        r15.add(r18);
    L33:
        if (r10.child_map.get(r18) != null) goto L35;
        r10.child_map.put(r18, new ArrayList());
    L35:
        r17 = r17 + 1;
        goto L22
    L46:
        return;
    }

    @JvmStatic
    public static final TreeNode d(WikiRelation.Tree r2, String r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        HashMap<String, TreeNode> r4 = r2.nodes;
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.get(r3);
    L13:
        return null;
    }

    @JvmStatic
    public static final void e(WikiRelation.Tree r9, WikiRelation.Tree r10) {
        Intrinsics.checkNotNullParameter(r9, "appendTree");
        Intrinsics.checkNotNullParameter(r10, "mergeTree");
        List<String> r0 = r9.root_list;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        Intrinsics.checkNotNull(r2);
        a(r2, r10);
    L8:
        HashMap<String, TreeNode> r3 = r9.nodes;
        if (r3 == null) goto L14;
        Iterator<Map.Entry<String, TreeNode>> r4 = r3.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, TreeNode> r5 = r4.next();
        String r6 = r5.getKey();
        TreeNode r7 = r5.getValue();
        Intrinsics.checkNotNull(r7);
        b(r7, r10, false);
    L14:
        HashMap<String, List<String>> r11 = r9.child_map;
        if (r11 == null) goto L40;
        Iterator<Map.Entry<String, List<String>>> r12 = r11.entrySet().iterator();
    L18:
        if (r12.hasNext() == false) goto L52;
        Map.Entry<String, List<String>> r8 = r12.next();
        String r13 = r8.getKey();
        List<String> r14 = r8.getValue();
        if (r14 == null) goto L18;
        int r15 = r14.size();
        int r16 = 0;
    L22:
        if (r16 >= r15) goto L18;
        Intrinsics.checkNotNull(r13);
        String r17 = (String) ListProtector.get(r14, r16);
        Intrinsics.checkNotNullParameter(r13, "parentToken");
        Intrinsics.checkNotNullParameter(r17, "childToken");
        Intrinsics.checkNotNullParameter(r10, "parentTree");
        List<String> r18 = r10.child_map.get(r13);
        if (r18 != null) goto L27;
        r18 = new ArrayList();
        r10.child_map.put(r13, r18);
    L27:
        if (r10.child_map.get(r17) != null) goto L30;
        r10.child_map.put(r17, new ArrayList());
    L30:
        if (r18.contains(r17) == true) goto L39;
        VirtualNode.Companion.getClass();
        if (VirtualNode.a.a(r17) == true) goto L36;
        ListProtector.add(r18, r16, r17);
        goto L39
    L36:
        if (Intrinsics.areEqual(VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken(), r17) == false) goto L38;
        ListProtector.add(r18, 0, r17);
        goto L39
    L38:
        r18.add(r17);
    L39:
        r16 = r16 + 1;
        goto L22
    L52:
        return;
    }

    @JvmStatic
    public static final void b(TreeNode r2, WikiRelation.Tree r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "treeNode");
        Intrinsics.checkNotNullParameter(r3, "parentTree");
        String r0 = r2.wiki_token;
        HashMap<String, TreeNode> r1 = r3.nodes;
        if (r1 != null) goto L5;
        r1 = new HashMap();
        r3.nodes = r1;
    L5:
        TreeNode r5 = r1.get(r0);
        if (r5 != null) goto L8;
        r1.put(r0, r2);
        return;
    L8:
        if (r4 == true) goto L10;
        return;
    L10:
        if (r5.isSortIdNativeGenerate() == true) goto L12;
        r2.sort_id = r5.sort_id;
    L12:
        r1.put(r0, r2);
    }
}

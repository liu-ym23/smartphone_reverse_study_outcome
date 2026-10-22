package kq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final void a(String r100, WikiRelation.Tree r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "parentTree");
        List r102 = r101.root_list;
        if (r102 != null) goto L6;
        r102 = new ArrayList();
        r101.root_list = r102;
    L6:
        if (r102.contains(r100) == true) goto L9;
        r102.add(r100);
        return;
    }

    @JvmStatic
    public static final void c(WikiRelation.Tree r100, WikiRelation.Tree r110) {
        Intrinsics.checkNotNullParameter(r100, "appendTree");
        Intrinsics.checkNotNullParameter(r110, "mergeTree");
        List<String> r101 = r100.root_list;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        Intrinsics.checkNotNull(r103);
        a(r103, r110);
    L8:
        HashMap<String, TreeNode> r104 = r100.nodes;
        if (r104 == null) goto L14;
        Iterator<Map.Entry<String, TreeNode>> r105 = r104.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, TreeNode> r106 = r105.next();
        String r107 = r106.getKey();
        TreeNode r108 = r106.getValue();
        Intrinsics.checkNotNull(r108);
        b(r108, r110, true);
    L14:
        HashMap<String, List<String>> r109 = r100.child_map;
        if (r109 == null) goto L36;
        Iterator<Map.Entry<String, List<String>>> r111 = r109.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L46;
        Map.Entry<String, List<String>> r112 = r111.next();
        String r113 = r112.getKey();
        List<String> r114 = r112.getValue();
        if (r114 == null) goto L18;
        ArrayList r115 = new ArrayList();
        int r116 = r114.size();
        int r117 = 0;
    L22:
        if (r117 >= r116) goto L18;
        Intrinsics.checkNotNull(r113);
        String r118 = (String) ListProtector.get(r114, r117);
        Intrinsics.checkNotNullParameter(r113, "parentToken");
        Intrinsics.checkNotNullParameter(r118, "childToken");
        Intrinsics.checkNotNullParameter(r115, "childMapList");
        Intrinsics.checkNotNullParameter(r110, "parentTree");
        r110.child_map.put(r113, r115);
        if (r115.contains(r118) == true) goto L33;
        VirtualNode.Companion.getClass();
        if (VirtualNode.a.a(r118) == true) goto L29;
        ListProtector.add(r115, r117, r118);
        goto L33
    L29:
        if (Intrinsics.areEqual(VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken(), r118) == false) goto L31;
        ListProtector.add(r115, 0, r118);
        goto L33
    L31:
        r115.add(r118);
    L33:
        if (r110.child_map.get(r118) != null) goto L35;
        r110.child_map.put(r118, new ArrayList());
    L35:
        r117 = r117 + 1;
        goto L22
    L46:
        return;
    }

    @JvmStatic
    public static final TreeNode d(WikiRelation.Tree r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        HashMap<String, TreeNode> r102 = r100.nodes;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.get(r101);
    L13:
        return null;
    }

    @JvmStatic
    public static final void e(WikiRelation.Tree r100, WikiRelation.Tree r110) {
        Intrinsics.checkNotNullParameter(r100, "appendTree");
        Intrinsics.checkNotNullParameter(r110, "mergeTree");
        List<String> r101 = r100.root_list;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        Intrinsics.checkNotNull(r103);
        a(r103, r110);
    L8:
        HashMap<String, TreeNode> r104 = r100.nodes;
        if (r104 == null) goto L14;
        Iterator<Map.Entry<String, TreeNode>> r105 = r104.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, TreeNode> r106 = r105.next();
        String r107 = r106.getKey();
        TreeNode r108 = r106.getValue();
        Intrinsics.checkNotNull(r108);
        b(r108, r110, false);
    L14:
        HashMap<String, List<String>> r109 = r100.child_map;
        if (r109 == null) goto L40;
        Iterator<Map.Entry<String, List<String>>> r111 = r109.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L52;
        Map.Entry<String, List<String>> r112 = r111.next();
        String r113 = r112.getKey();
        List<String> r114 = r112.getValue();
        if (r114 == null) goto L18;
        int r115 = r114.size();
        int r116 = 0;
    L22:
        if (r116 >= r115) goto L18;
        Intrinsics.checkNotNull(r113);
        String r117 = (String) ListProtector.get(r114, r116);
        Intrinsics.checkNotNullParameter(r113, "parentToken");
        Intrinsics.checkNotNullParameter(r117, "childToken");
        Intrinsics.checkNotNullParameter(r110, "parentTree");
        List<String> r118 = r110.child_map.get(r113);
        if (r118 != null) goto L27;
        r118 = new ArrayList();
        r110.child_map.put(r113, r118);
    L27:
        if (r110.child_map.get(r117) != null) goto L30;
        r110.child_map.put(r117, new ArrayList());
    L30:
        if (r118.contains(r117) == true) goto L39;
        VirtualNode.Companion.getClass();
        if (VirtualNode.a.a(r117) == true) goto L36;
        ListProtector.add(r118, r116, r117);
        goto L39
    L36:
        if (Intrinsics.areEqual(VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken(), r117) == false) goto L38;
        ListProtector.add(r118, 0, r117);
        goto L39
    L38:
        r118.add(r117);
    L39:
        r116 = r116 + 1;
        goto L22
    L52:
        return;
    }

    @JvmStatic
    public static final void b(TreeNode r100, WikiRelation.Tree r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "treeNode");
        Intrinsics.checkNotNullParameter(r101, "parentTree");
        String r103 = r100.wiki_token;
        HashMap<String, TreeNode> r104 = r101.nodes;
        if (r104 != null) goto L5;
        r104 = new HashMap();
        r101.nodes = r104;
    L5:
        TreeNode r105 = r104.get(r103);
        if (r105 != null) goto L8;
        r104.put(r103, r100);
        return;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        if (r105.isSortIdNativeGenerate() == true) goto L12;
        r100.sort_id = r105.sort_id;
    L12:
        r104.put(r103, r100);
    }
}

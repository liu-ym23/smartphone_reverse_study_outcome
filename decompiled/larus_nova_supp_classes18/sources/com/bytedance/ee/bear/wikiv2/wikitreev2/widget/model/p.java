package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements Function<TreeNode, Boolean> {
    public volatile Boolean a;
    public final HashMap<Integer, b> b;

    public static final class a<T> implements Observer {
        public final /* synthetic */ p a;
        public final /* synthetic */ WeakReference<WikiTreeCtrlView> b;

        public a(p r1, WeakReference<WikiTreeCtrlView> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((ConnectionService.NetworkState) r3).a();
            if (Intrinsics.areEqual(this.a.a, Boolean.valueOf(r4)) == true) goto L13;
            p r0 = this.a;
            r0.a = Boolean.valueOf(r4);
            WikiTreeCtrlView r5 = this.b.get();
            if (r5 != null) goto L8;
            return;
        L8:
            if (r5.f == null) goto L12;
            r5.getViewModel().refresh();
            return;
        L12:
            return;
        }
    }

    public interface b {
        boolean a(TreeNode r1);
    }

    public static final class c implements b {
        public c() {
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p.b
        public final boolean a(TreeNode r2) {
            Intrinsics.checkNotNullParameter(r2, "treeNode");
            return true;
        }
    }

    public static final class d implements b {
        public d() {
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p.b
        public final boolean a(TreeNode r2) {
            Intrinsics.checkNotNullParameter(r2, "treeNode");
            return false;
        }
    }

    public final Object apply(Object r3) {
        TreeNode r4 = (TreeNode) r3;
        Intrinsics.checkNotNullParameter(r4, "treeNode");
        Boolean r0 = this.a;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        b r2 = this.b.get(Integer.valueOf(r4.wiki_node_type));
        if (r2 != null) goto L9;
        r2 = new d();
    L9:
        return Boolean.valueOf(r2.a(r4));
    L10:
        return r1;
    }

    public p(LifecycleOwner r5, WeakReference<WikiTreeCtrlView> r6) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r6, "view");
        this.b = MapsKt.hashMapOf(new Pair[]{new Pair(Integer.valueOf(WikNodeType.DOCUMENT.getValue()), new c())});
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r5, new a(this, r6));
    }
}

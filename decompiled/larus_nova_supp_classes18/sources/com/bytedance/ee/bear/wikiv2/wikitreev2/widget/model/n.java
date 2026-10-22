package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements Function<TreeNode, Boolean> {
    public final ce5.a a;
    public boolean b;
    public final List<a> c;

    public static abstract class a {
        public final String a;
        public final MutableLiveData<Boolean> b;
        public final Set<String> c;

        public abstract LiveData<List<String>> b(ce5.a r1);

        public a() {
            this.a = "CacheChecker";
            this.b = new MutableLiveData();
            this.c = new LinkedHashSet();
        }

        public String a() {
            return this.a;
        }
    }

    public static final class b {
    }

    public static final class c extends a {
        public final String d;

        public c() {
            this.d = "DocumentCacheChecker";
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final String a() {
            return this.d;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final LiveData<List<String>> b(ce5.a r5) {
            Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
            k25.e0 r6 = k25.e0.m();
            r6.getClass();
            k25.b1 r7 = r6.q().e();     // Catch: Exception -> L5
            r7.getClass();     // Catch: Exception -> L5
            RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' order by update_time desc limit ?", 1);     // Catch: Exception -> L5
            r0.bindLong(1, 999);     // Catch: Exception -> L5
            return r7.a.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new k25.r0(r7, r0));
        L5:
            e = move-exception;
            iu5.d.c(e);
            return new MediatorLiveData();
        }
    }

    public static final class d extends a {
        public final String d;

        public d() {
            this.d = "FileCacheChecker";
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final String a() {
            return this.d;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final LiveData<List<String>> b(ce5.a r2) {
            Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
            return ((mc5.j) r2.a(mc5.j.class)).T9();
        }
    }

    static {
    }

    public final Object apply(Object r5) {
        TreeNode r6 = (TreeNode) r5;
        Intrinsics.checkNotNullParameter(r6, "node");
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L16;
        Iterator<a> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        a r1 = r0.next();
        String r2 = r6.obj_token;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "objToken");
        if (r1.c.contains(r2) == false) goto L7;
        return Boolean.TRUE;
    L12:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    }

    public n(LifecycleOwner r6, WeakReference<WikiTreeCtrlView> r7, ce5.a r8) {
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
        this.a = r8;
        List<a> r9 = CollectionsKt.listOf(new a[]{new c(), new d()});
        this.c = r9;
        Iterator<a> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        a r2 = r10.next();
        ce5.a r3 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        r2.b(r3).observe(r6, new m(r2));
        r2.b.observe(r6, new o(this, r7));
        goto L4
    }
}

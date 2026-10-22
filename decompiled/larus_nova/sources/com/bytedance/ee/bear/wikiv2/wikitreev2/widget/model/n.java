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

/* JADX INFO: loaded from: classes18.dex */
public final class n implements Function<TreeNode, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce5.a f241956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f241957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f241958c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f241959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableLiveData<Boolean> f241960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f241961c;

        public abstract LiveData<List<String>> b(ce5.a r100);

        public a() {
            this.f241959a = "CacheChecker";
            this.f241960b = new MutableLiveData();
            this.f241961c = new LinkedHashSet();
        }

        public String a() {
            return this.f241959a;
        }
    }

    public static final class b {
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f241962d;

        public c() {
            this.f241962d = "DocumentCacheChecker";
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final String a() {
            return this.f241962d;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final LiveData<List<String>> b(ce5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
            k25.e0 r101 = k25.e0.m();
            r101.getClass();
            k25.b1 r102 = (k25.b1) r101.q().e();     // Catch: Exception -> L5
            r102.getClass();     // Catch: Exception -> L5
            RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' order by update_time desc limit ?", 1);     // Catch: Exception -> L5
            r103.bindLong(1, 999);     // Catch: Exception -> L5
            return r102.f501476a.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new k25.r0(r102, r103));
        L5:
            e = move-exception;
            iu5.d.c(e);
            return new MediatorLiveData();
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f241963d;

        public d() {
            this.f241963d = "FileCacheChecker";
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final String a() {
            return this.f241963d;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n.a
        public final LiveData<List<String>> b(ce5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
            return ((mc5.j) r100.a(mc5.j.class)).T9();
        }
    }

    static {
    }

    @Override // io.reactivex.functions.Function
    public final Boolean apply(TreeNode r100) {
        TreeNode r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "node");
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L16;
        Iterator<a> r102 = this.f241958c.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        a r103 = r102.next();
        String r104 = r101.obj_token;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "objToken");
        if (r103.f241961c.contains(r104) == false) goto L7;
        return Boolean.TRUE;
    L12:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    }

    public n(LifecycleOwner r100, WeakReference<WikiTreeCtrlView> r101, ce5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        this.f241956a = r102;
        List<a> r103 = CollectionsKt.listOf(new a[]{new c(), new d()});
        this.f241958c = r103;
        Iterator<a> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        a r105 = r104.next();
        ce5.a r106 = this.f241956a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r106, "userComponentAbility");
        r105.b(r106).observe(r100, new m(r105));
        r105.f241960b.observe(r100, new o(this, r101));
        goto L4
    }
}

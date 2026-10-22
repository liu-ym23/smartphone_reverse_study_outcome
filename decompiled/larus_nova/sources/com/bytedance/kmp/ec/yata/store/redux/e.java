package com.bytedance.kmp.ec.yata.store.redux;

import com.byted.cast.common.TeaEventTrack;
import java.util.ArrayList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements j<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d<Object>[] f251810a;

    public static final class a implements i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Object> f251811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d<Object>[] f251812b;

        public a(i<Object> r100, d<Object>[] r101) {
            this.f251811a = r100;
            this.f251812b = r101;
        }

        @Override // com.bytedance.kmp.ec.yata.store.redux.i
        public final h a(g r100, com.bytedance.kmp.ec.yata.store.core.l r101) {
            Intrinsics.checkNotNullParameter(r100, "reducer");
            h r102 = this.f251811a.a(r100, r101);
            b r103 = r102.b();
            d<Object>[] r104 = this.f251812b;
            ArrayList r105 = new ArrayList(r104.length);
            int r106 = r104.length;
            int r107 = 0;
        L3:
            if (r107 >= r106) goto L5;
            r105.add(r104[r107].a(r102));
            r107 = r107 + 1;
            goto L3
        L5:
            Intrinsics.checkNotNullParameter(r103, TeaEventTrack.ACTION_DRAMA_NEXT);
            if (r105.isEmpty() == true) goto L11;
            ListIterator r108 = r105.listIterator(r105.size());
        L9:
            if (r108.hasPrevious() == false) goto L11;
            r103 = ((c) r108.previous()).a(r103);
        L11:
            r102.c(r103);
            return r102;
        }
    }

    public e(d<Object>[] r100) {
        this.f251810a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.j
    public final i<Object> a(i<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "storeCreator");
        return new a(r100, this.f251810a);
    }
}

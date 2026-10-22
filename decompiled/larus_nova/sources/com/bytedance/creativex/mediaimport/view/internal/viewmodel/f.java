package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import ki4.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class f<DATA> extends j<DATA> {

    public static class a extends f<ki4.r> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f204131e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f204132f;

        public a() {
            this.f204131e = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
            this.f204132f = new AtomicInteger();
        }

        public final String e(ki4.r r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f204131e.getClass();
            Intrinsics.checkNotNullParameter(r100, "data");
            return r100.getPath();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final /* bridge */ /* synthetic */ String getPath(Object r100) {
            return e((ki4.r) r100);
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.viewmodel.j, ti4.i
        public final int getSelectIndex(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            Iterator r102 = ((ArrayList) this.f204138a).iterator();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L18;
            ki4.r r104 = (ki4.r) r102.next();
            if (Intrinsics.areEqual(e(r104), e(r101)) == true) goto L8;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == true) goto L22;
            r103 = r103 + 1;
            goto L4
        L22:
            return r103;
        L8:
            if (r101.getVersion() != (-1)) goto L10;
        L13:
            r105 = true;
            goto L15
        L10:
            if (r104.getVersion() == (-1)) goto L13;
            if (r104.getVersion() != r101.getVersion()) goto L14;
        L18:
            return -1;
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final e0 getSourceType(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204131e.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getSourceType();
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f204131e.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    public f() {
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.viewmodel.j, ti4.i
    public final void add(DATA r100, int r101) {
        ki4.r r102 = (ki4.r) r100;
        Intrinsics.checkNotNullParameter(r102, TemplateNodeType.RAW);
        super.add(r102.a(((a) this).f204132f.incrementAndGet()), r101);
    }
}

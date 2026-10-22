package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f440402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f440403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f440404e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440405a = null;

        static {
            int[] r100 = new int[FileBizDomain.values().length];
            r100[FileBizDomain.FileBizDomainCALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FileBizDomain.FileBizDomainMeetingMinutes.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f440405a = r100;
        }
    }

    public final void c() {
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).g(new com.ss.android.lark.security.compliance.api.model.filepolicy.a(this.f440404e));
    }

    public final String getIdentifier() {
        return this.f440404e;
    }

    public final void a(FileBizDomain r310, Long r311, Long r312) {
        c r100 = this;
        Intrinsics.checkNotNullParameter(r310, "fileBizDomain");
        int r101 = a.f440405a[r310.ordinal()];
        if (r101 != 1) goto L5;
        ArrayList r110 = new ArrayList();
        String r102 = r100.f440401b;
        r110.add(h.f(r102, r310, r100.f440400a, r311, r312, r102, r100.f440402c));
        r110.add(h.e(r100.f440400a, r310, r311, r312, r100.f440401b, r100.f440402c));
        if (Intrinsics.areEqual(r100.f440401b, "FILE") == false) goto L14;
        r110.add(h.g(r100.f440400a, r310, r311, r312, r100.f440401b, r100.f440402c));
        String r111 = r100.f440400a;
        FileBizDomain r112 = FileBizDomain.FileBizDomainCCM;
        String r103 = r100.f440401b;
        int r104 = r100.f440402c;
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r112, "fileBizDomain");
        long r105 = com.ss.android.lark.security.compliance.infra.util.h.a();
        long r113 = com.ss.android.lark.security.compliance.infra.util.h.b();
        r110.add(new PolicyModel("PointKey_CCM_FILE_UPLOAD", new CCMFileEntity("FILE", EntityDomain.EntityDomainCCM, "CCM_FILE_UPLOAD", r105, r113, r112, r111, r311, r312, r103, Integer.valueOf(r104), r310, "CCM_FILE_SAVE", "FILE"), null, 4, null));
        ArrayList r106 = r110;
        r100 = this;
        r106.add(h.h(r100.f440400a, r310, r311, r312, r100.f440401b, r100.f440402c));
    L15:
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).g(new b(r100, r100.f440404e, r106));
        return;
    L14:
        r106 = r110;
        goto L15
    L5:
        if (r101 == 2) goto L10;
        r106 = new ArrayList();
        String r107 = r100.f440401b;
        FileBizDomain r313 = FileBizDomain.FileBizDomainCCM;
        r106.add(h.f(r107, r313, r100.f440400a, r311, r312, r107, r100.f440402c));
        String r108 = r100.f440401b;
        String r109 = r100.f440400a;
        int r114 = r100.f440402c;
        Intrinsics.checkNotNullParameter(r108, "entityType");
        Intrinsics.checkNotNullParameter(r109, "token");
        long r115 = com.ss.android.lark.security.compliance.infra.util.h.a();
        long r210 = com.ss.android.lark.security.compliance.infra.util.h.b();
        EntityDomain r314 = EntityDomain.EntityDomainCCM;
        r106.add(new PolicyModel("PointKey_CCM_OPEN_EXTERNAL_ACCESS", new CCMFileEntity(r108, r314, "CCM_OPEN_EXTERNAL_ACCESS", r115, r210, r313, r109, r311, r312, r108, Integer.valueOf(r114), null, null, null, 14336, null), null, 4, null));
        r106.add(h.e(r100.f440400a, r313, r311, r312, r100.f440401b, r100.f440402c));
        String r116 = r100.f440401b;
        String r117 = r100.f440400a;
        int r118 = r100.f440402c;
        Intrinsics.checkNotNullParameter(r116, "entityType");
        Intrinsics.checkNotNullParameter(r117, "token");
        r106.add(new PolicyModel("PointKey_CCM_CREATE_COPY", new CCMFileEntity(r116, r314, "CCM_CREATE_COPY", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r313, r117, r311, r312, r116, Integer.valueOf(r118), null, null, null, 14336, null), null, 4, null));
        if (Intrinsics.areEqual(r100.f440401b, "FILE") == false) goto L9;
        r106.add(h.g(r100.f440400a, r310, r311, r312, r100.f440401b, r100.f440402c));
        r106.add(h.h(r100.f440400a, r313, r311, r312, r100.f440401b, r100.f440402c));
        goto L15
    L9:
        String r119 = r100.f440401b;
        String r120 = r100.f440400a;
        int r121 = r100.f440402c;
        Intrinsics.checkNotNullParameter(r119, "entityType");
        Intrinsics.checkNotNullParameter(r120, "token");
        r106.add(new PolicyModel("PointKey_CCM_EXPORT", new CCMFileEntity(r119, r314, "CCM_EXPORT", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r313, r120, r311, r312, r119, Integer.valueOf(r121), null, null, null, 14336, null), null, 4, null));
        String r122 = r100.f440401b;
        String r123 = r100.f440400a;
        int r124 = r100.f440402c;
        Intrinsics.checkNotNullParameter(r122, "entityType");
        Intrinsics.checkNotNullParameter(r123, "token");
        r106.add(new PolicyModel("PointKey_CCM_CONTENT_PREVIEW", new CCMFileEntity(r122, r314, "CCM_CONTENT_PREVIEW", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r313, r123, r311, r312, r122, Integer.valueOf(r124), null, null, null, 14336, null), null, 4, null));
        goto L15
    L10:
        r106 = new ArrayList();
        r106.add(b("PointKey_CCM_CONTENT_COPY", "CCM_CONTENT_COPY", r100.f440400a, r100.f440401b, r100.f440402c, r311, r312));
        r106.add(b("PointKey_CCM_CREATE_COPY", "CCM_CREATE_COPY", r100.f440400a, r100.f440401b, r100.f440402c, r311, r312));
        r106.add(b("PointKey_CCM_EXPORT", "CCM_EXPORT", r100.f440400a, r100.f440401b, r100.f440402c, r311, r312));
        r106.add(b("PointKey_CCM_CONTENT_PREVIEW", "CCM_CONTENT_PREVIEW", r100.f440400a, r100.f440401b, r100.f440402c, r311, r312));
        goto L15
    }

    public c(String r100, @EntityType String r101, int r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "tokenEntityType");
        this.f440400a = r100;
        this.f440401b = r101;
        this.f440402c = r102;
        this.f440403d = r103;
        this.f440404e = String.valueOf(hashCode());
    }

    public static PolicyModel b(@PointKey String r210, @EntityOperate String r211, String r212, @EntityType String r213, int r214, Long r215, Long r216) {
        long r100 = com.ss.android.lark.security.compliance.infra.util.h.a();
        long r101 = com.ss.android.lark.security.compliance.infra.util.h.b();
        return new PolicyModel(r210, new CCMFileEntity(r213, EntityDomain.EntityDomainCCM, r211, r100, r101, FileBizDomain.FileBizDomainMeetingMinutes, r212, r215, r216, r213, Integer.valueOf(r214), null, null, null, 14336, null), null, 4, null);
    }
}

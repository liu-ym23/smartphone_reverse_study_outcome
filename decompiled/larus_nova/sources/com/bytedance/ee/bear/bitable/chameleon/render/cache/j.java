package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import android.net.Uri;
import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.rust.BitableCacheDocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.trace.CopyContentTypeString;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.rust.e f209729a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209730a = null;

        static {
            int[] r100 = new int[BitableSubType.values().length];
            r100[BitableSubType.BaseMain.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[BitableSubType.BaseRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[BitableSubType.BaseAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[BitableSubType.BaseApp.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[BitableSubType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f209730a = r100;
        }
    }

    static {
    }

    public j(int r100) {
        com.bytedance.ee.bear.bitable.rust.f r101 = com.bytedance.ee.bear.bitable.rust.f.f215276a;
        Intrinsics.checkNotNullParameter(r101, "cacheSource");
        this.f209729a = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.cache.e
    public final d a(f r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        BitableSubType r100 = r110.f209709b;
        int[] r101 = b.f209730a;
        int r102 = r101[r100.ordinal()];
        String r103 = null;
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L12;
        if (r102 == 4) goto L11;
        if (r102 == 5) goto L11;
        throw new NoWhenBranchMatchedException();
    L11:
        BitableCacheDocumentType r104 = null;
    L15:
        if (r104 == null) goto L17;
        com.bytedance.ee.bear.bitable.rust.d r111 = this.f209729a.a(r110.f209710c, r104, r110.f209711d);
        int r105 = r101[r110.f209709b.ordinal()];
        if (r105 == 1) goto L78;
        if (r105 == 2) goto L81;
        if (r105 == 3) goto L81;
        if (r105 == 4) goto L80;
        if (r105 == 5) goto L80;
        throw new NoWhenBranchMatchedException();
    L80:
        return new d(null, null, null, null, null, null, 63);
    L81:
        return new d(null, null, null, r111.f215274f, null, null, 55);
    L78:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L31
        Object r107 = Result.m9449constructorimpl(UriProtector.parse(r110.f209711d));     // Catch: Throwable -> L31
    L34:
        if (Result.m9455isFailureimpl(r107) == false) goto L36;
        r107 = null;
    L36:
        Uri r108 = (Uri) r107;
        if (r108 == null) goto L39;
        String r109 = UriProtector.getQueryParameter(r108, CopyContentTypeString.TABLE);
    L41:
        if (r109 != null) goto L43;
        r109 = "";
    L43:
        if (r108 == null) goto L45;
        String r112 = UriProtector.getQueryParameter(r108, "view");
    L46:
        if (r112 != null) goto L48;
        r112 = "";
    L48:
        String r113 = r110.f209710c;
        if (r109.length() != 0) goto L51;
        boolean r114 = true;
    L52:
        if (r114 == false) goto L57;
        String r115 = r111.f215269a;
        if (r115 != null) goto L56;
        r115 = "";
    L56:
        String r116 = r115;
    L59:
        if (r112.length() != 0) goto L61;
        boolean r117 = true;
    L62:
        if (r117 == false) goto L66;
        r112 = r111.f215270b;
        if (r112 != null) goto L66;
        String r118 = "";
    L67:
        if (r108 == null) goto L69;
        r103 = UriProtector.getQueryParameter(r108, "record");
    L69:
        if (r103 != null) goto L71;
        String r119 = "";
    L72:
        BitableCacheBlockType r120 = r111.f215273e;
        if (r109.length() <= 0) goto L75;
        boolean r121 = true;
    L77:
        return new d(new c(r113, r116, r118, r119, r120, r121), r111.f215271c, r111.f215272d, null, r111.f215275g, null, 40);
    L75:
        r121 = false;
        goto L77
    L71:
        r119 = r103;
    L66:
        r118 = r112;
        goto L67
    L61:
        r117 = false;
        goto L62
    L57:
        r116 = r109;
        goto L59
    L51:
        r114 = false;
        goto L52
    L45:
        r112 = null;
        goto L46
    L39:
        r109 = null;
    L31:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L17:
        return new d(null, null, null, null, null, null, 63);
    L12:
        r104 = BitableCacheDocumentType.AddRecord;
        goto L15
    L13:
        r104 = BitableCacheDocumentType.Record;
        goto L15
    L14:
        r104 = BitableCacheDocumentType.Main;
        goto L15
    }
}

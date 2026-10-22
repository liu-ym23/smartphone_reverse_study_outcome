package com.larus.photopicker.v2.impl.data;

import com.larus.photopicker.v2.impl.data.model.MediaType;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f364362c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaType f364363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f364364b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f364365a = null;

        static {
            int[] r100 = new int[MediaType.values().length];
            r100[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f364365a = r100;
        }
    }

    static {
    }

    public final Pair<String, String[]> a() {
        if (this.f364363a == null) goto L9;
        Long r100 = this.f364364b;
        if (r100 == null) goto L9;
        if (r100.longValue() != (-1)) goto L9;
        return b(this.f364363a);
    L9:
        MediaType r101 = this.f364363a;
        if (r101 == null) goto L14;
        Long r102 = this.f364364b;
        if (r102 == null) goto L14;
        return c(r101, r102.toString());
    L14:
        if (r101 != null) goto L28;
        Long r103 = this.f364364b;
        if (r103 != null) goto L19;
    L21:
        Long r104 = this.f364364b;
        if (r104 == null) goto L25;
        return c(null, r104.toString());
    L25:
        return b(null);
    L19:
        if (r103.longValue() != (-1)) goto L21;
        return b(null);
    L28:
        return b(r101);
    }

    public static Pair b(MediaType r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
        List r102 = CollectionsKt.listOf("1");
    L13:
        return new Pair(CollectionsKt.joinToString$default(r102, " OR ", null, null, 0, null, new com.larus.photopicker.v2.impl.data.b(), 30, null), r102.toArray(new String[0]));
    L8:
        if (r101 == 2) goto L10;
        r102 = CollectionsKt.listOf(new String[]{"1", "3"});
        goto L13
    L10:
        r102 = CollectionsKt.listOf("3");
        goto L13
    L4:
        r101 = b.f364365a[r100.ordinal()];
        goto L6
    }

    public c(MediaType r100, Long r101) {
        this.f364363a = r100;
        this.f364364b = r101;
    }

    public static Pair c(MediaType r100, String r101) {
        Pair r102 = b(r100);
        return new Pair("(" + ((String) r102.component1()) + ") AND bucket_id = ?", ArraysKt.plus((String[]) r102.component2(), new String[]{r101}));
    }
}

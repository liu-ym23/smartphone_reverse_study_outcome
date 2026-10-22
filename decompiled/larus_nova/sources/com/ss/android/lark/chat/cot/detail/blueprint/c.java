package com.ss.android.lark.chat.cot.detail.blueprint;

import com.ss.android.lark.blueprint.f;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.o;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements o<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<k> f414938a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414939a = null;

        static {
            int[] r100 = new int[CotDetailBlockType.values().length];
            r100[CotDetailBlockType.THINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[CotDetailBlockType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[CotDetailBlockType.TOOLCALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CotDetailBlockType.ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f414939a = r100;
        }
    }

    public c() {
        this.f414938a = k.class;
    }

    @Override // com.ss.android.lark.blueprint.o
    public final Class<k> getDataType() {
        return this.f414938a;
    }

    @Override // com.ss.android.lark.blueprint.o
    public final n a(k r100) {
        k r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        CotDetailBlockType r102 = r101.f414983b;
        int r103 = a.f414939a[r102.ordinal()];
        if (r103 != 1) goto L5;
        Object r104 = b.f414858a;
    L20:
        return new f(CotDetailCellKeys$Layouts.SINGLE, CollectionsKt.listOf(r104));
    L5:
        if (r103 != 2) goto L7;
        r104 = b.f414859b;
        goto L20
    L7:
        if (r103 != 3) goto L9;
        r104 = b.f414860c;
        goto L20
    L9:
        if (r103 != 4) goto L11;
        r104 = b.f414861d;
        goto L20
    L11:
        if (r103 != 5) goto L14;
        r104 = b.f414862e;
        goto L20
    L14:
        throw new NoWhenBranchMatchedException();
    }
}

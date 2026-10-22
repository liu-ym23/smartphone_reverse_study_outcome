package com.larus.paging;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes29.dex */
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f363661b;

    /* JADX INFO: renamed from: com.larus.paging.LegacyPagingSource$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ LegacyPagingSource<Object, Object> this$0;

        public AnonymousClass2(LegacyPagingSource<Object, Object> r100) {
            this.this$0 = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.getClass();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    public LegacyPagingSource() {
        throw null;
    }

    @Override // com.larus.paging.PagingSource
    public final boolean a() {
        throw null;
    }

    @Override // com.larus.paging.PagingSource
    public final Key b(w0<Key, Value> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        throw null;
    }

    @Override // com.larus.paging.PagingSource
    public final Object c(PagingSource.a<Key> r100, Continuation<? super PagingSource.b<Key, Value>> r110) {
        boolean r101 = r100 instanceof PagingSource.a.d;
        if (r101 == false) goto L7;
        LoadType r102 = LoadType.REFRESH;
    L5:
        LoadType r103 = r102;
        if (this.f363661b != Integer.MIN_VALUE) goto L22;
        String r104 = StringsKt.trimIndent("\n                WARNING: pageSize on the LegacyPagingSource is not set.\n                When using legacy DataSource / DataSourceFactory with Paging3, page size\n                should've been set by the paging library but it is not set yet.\n\n                If you are seeing this message in tests where you are testing DataSource\n                in isolation (without a Pager), it is expected and page size will be estimated\n                based on parameters.\n\n                If you are seeing this message despite using a Pager, please file a bug:\n                https://issuetracker.google.com/issues/new?component=413106\n                ");
        System.out.println(r104);
        if (r101 == false) goto L19;
        int r105 = r100.f363722a;
        if ((r105 % 3) != 0) goto L19;
        int r106 = r105 / 3;
    L20:
        this.f363661b = r106;
    L19:
        r106 = r100.f363722a;
    L22:
        return BuildersKt.withContext(null, new LegacyPagingSource$load$2(this, new DataSource.e(r103, r100.a(), r100.f363722a, r100.f363723b, this.f363661b), r100, null), r110);
    L7:
        if ((r100 instanceof PagingSource.a.C4453a) == false) goto L10;
        r102 = LoadType.APPEND;
        goto L5
    L10:
        if ((r100 instanceof PagingSource.a.c) == false) goto L24;
        r102 = LoadType.PREPEND;
        goto L5
    L24:
        throw new NoWhenBranchMatchedException();
    }
}

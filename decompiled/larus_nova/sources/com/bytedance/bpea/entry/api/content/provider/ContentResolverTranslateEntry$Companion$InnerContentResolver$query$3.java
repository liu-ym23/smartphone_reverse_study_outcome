package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$query$3 extends Lambda implements Function0<Cursor> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ String[] $projection;
    final /* synthetic */ Bundle $queryArgs;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$query$3(ContentResolverTranslateEntry$Companion$InnerContentResolver r100, String[] r101, Bundle r102, CancellationSignal r103) {
        this.this$0 = r100;
        this.$projection = r101;
        this.$queryArgs = r102;
        this.$cancellationSignal = r103;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Cursor invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        String[] r100 = this.$projection;
        Bundle r101 = this.$queryArgs;
        CancellationSignal r102 = this.$cancellationSignal;
        f06.c r110 = new f06.c();
        Object[] r111 = {null, r100, r101, r102};
        f06.b r103 = new f06.b();
        f06.d r104 = r110.b(240004, "android/content/ContentResolver", "query", null, r111, "android.database.Cursor", r103);
        if (r104.f474982a == false) goto L6;
        r110.a(240004, "android/content/ContentResolver", "query", null, r111, null, r103, false);
        return (Cursor) r104.f474983b;
    L6:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Cursor invoke() {
        return invoke();
    }
}

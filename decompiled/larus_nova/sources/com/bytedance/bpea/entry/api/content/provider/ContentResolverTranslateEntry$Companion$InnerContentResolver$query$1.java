package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$query$1 extends Lambda implements Function0<Cursor> {
    final /* synthetic */ String[] $projection;
    final /* synthetic */ String $selection;
    final /* synthetic */ String[] $selectionArgs;
    final /* synthetic */ String $sortOrder;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$query$1(ContentResolverTranslateEntry$Companion$InnerContentResolver r100, String[] r101, String r102, String[] r103, String r104) {
        this.this$0 = r100;
        this.$projection = r101;
        this.$selection = r102;
        this.$selectionArgs = r103;
        this.$sortOrder = r104;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Cursor invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        String[] r100 = this.$projection;
        String r101 = this.$selection;
        String[] r102 = this.$selectionArgs;
        String r103 = this.$sortOrder;
        f06.c r110 = new f06.c();
        Object[] r111 = {null, r100, r101, r102, r103};
        f06.b r104 = new f06.b();
        f06.d r105 = r110.b(240004, "android/content/ContentResolver", "query", null, r111, "android.database.Cursor", r104);
        if (r105.f474982a == false) goto L6;
        r110.a(240004, "android/content/ContentResolver", "query", null, r111, null, r104, false);
        return (Cursor) r105.f474983b;
    L6:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Cursor invoke() {
        return invoke();
    }
}

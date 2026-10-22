package com.bytedance.bpea.entry.api.content.provider;

import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ String[] $selectionArgs;
    final /* synthetic */ String $where;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$1(ContentResolverTranslateEntry$Companion$InnerContentResolver r100, String r101, String[] r102) {
        this.this$0 = r100;
        this.$where = r101;
        this.$selectionArgs = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        this.this$0.getClass();
        this.this$0.getClass();
        String r100 = this.$where;
        String[] r101 = this.$selectionArgs;
        ArrayList r102 = new ArrayList();
        Object[] r103 = {null, r100, r101};
        f06.b r104 = new f06.b();
        g06.a r105 = ApiHookConfig.f245611b.get(240019);
        if (r105 == null) goto L5;
        f06.a[] r106 = r105.f479473i;
    L6:
        f06.a[] r110 = r106;
        int r111 = r110.length;
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L15;
        f06.a r107 = r110[r112];
        int r113 = r112;
        int r114 = r111;
        f06.a[] r115 = r110;
        f06.d r108 = r107.preInvoke(240019, "android/content/ContentResolver", "delete", null, r103, "int", r104);     // Catch: Exception -> L21
        if (r108.f474982a == true) goto L17;
        r102.add(r107);     // Catch: Exception -> L21
    L17:
        if (r108.f474982a == true) goto L19;
        throw null;
    L19:
        return ((Integer) r108.f474983b).intValue();
    L14:
        r112 = r113 + 1;
        r111 = r114;
        r110 = r115;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r106 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}

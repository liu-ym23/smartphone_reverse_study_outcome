package com.bytedance.bpea.entry.api.content.provider;

import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$delete$2(ContentResolverTranslateEntry$Companion$InnerContentResolver r100, Bundle r101) {
        this.this$0 = r100;
        this.$extras = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        this.this$0.getClass();
        this.this$0.getClass();
        Bundle r100 = this.$extras;
        ArrayList r101 = new ArrayList();
        Object[] r102 = {null, r100};
        f06.b r103 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240019);
        if (r104 == null) goto L5;
        f06.a[] r105 = r104.f479473i;
    L6:
        f06.a[] r110 = r105;
        int r111 = r110.length;
        int r106 = 0;
    L8:
        if (r106 >= r111) goto L15;
        f06.a r107 = r110[r106];
        int r112 = r106;
        int r113 = r111;
        f06.a[] r114 = r110;
        f06.d r108 = r107.preInvoke(240019, "android/content/ContentResolver", "delete", null, r102, "int", r103);     // Catch: Exception -> L21
        if (r108.f474982a == true) goto L17;
        r101.add(r107);     // Catch: Exception -> L21
    L17:
        if (r108.f474982a == true) goto L19;
        throw null;
    L19:
        return ((Integer) r108.f474983b).intValue();
    L14:
        r106 = r112 + 1;
        r111 = r113;
        r110 = r114;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r105 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}

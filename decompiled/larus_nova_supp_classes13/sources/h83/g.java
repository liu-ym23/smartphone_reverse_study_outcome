package h83;

import android.os.Bundle;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements m {
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b a;
    public final String b;
    public final ECUrlModel c;
    public final l53.b d;
    public final boolean e;
    public final String f;
    public final String g;
    public final GaussianBlurConfig h;
    public final boolean i;
    public final a j;
    public final Function0<Bundle> k;
    public final boolean l;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.listOfNotNull(this.c);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.g;
    }

    public g(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1, String r2, ECUrlModel r3, l53.b r4, String r5, String r6, GaussianBlurConfig r7, boolean r8, a r9, Function0 r10, boolean r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = false;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
    }
}

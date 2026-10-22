package h83;

import android.os.Bundle;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b f484091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f484093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l53.b f484094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f484095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f484097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GaussianBlurConfig f484098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f484099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f484100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Bundle> f484101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f484102l;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.listOfNotNull(this.f484093c);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.f484093c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f484097g;
    }

    public g(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100, String r101, ECUrlModel r102, l53.b r103, String r104, String r105, GaussianBlurConfig r106, boolean r107, a r108, Function0 r110, boolean r111) {
        this.f484091a = r100;
        this.f484092b = r101;
        this.f484093c = r102;
        this.f484094d = r103;
        this.f484095e = false;
        this.f484096f = r104;
        this.f484097g = r105;
        this.f484098h = r106;
        this.f484099i = r107;
        this.f484100j = r108;
        this.f484101k = r110;
        this.f484102l = r111;
    }
}

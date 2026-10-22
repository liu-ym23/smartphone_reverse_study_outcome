package h83;

import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f484070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f484074e;

    public b() {
        this(null, 0, null, null, null);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.listOfNotNull(this.f484070a);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.f484070a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f484073d;
    }

    public b(ECUrlModel r100, int r101, String r102, String r103, Drawable r104) {
        this.f484070a = r100;
        this.f484071b = r101;
        this.f484072c = r102;
        this.f484073d = r103;
        this.f484074e = r104;
    }
}

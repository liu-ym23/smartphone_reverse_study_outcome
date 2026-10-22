package vc6;

import com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f554119a;

    public c(d r100) {
        this.f554119a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UIHandleStatus r101 = (UIHandleStatus) r100;
        b r102 = this.f554119a.f554120a;
        String r103 = b.f554113f;
        r102.getClass();
        UIHandleStatus.HybridStatus r104 = r101.i7();
        if (r104 != null) goto L5;
    L6:
        UIHandleStatus.HybridStatus r105 = r101.i7();
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L15;
        b r107 = this.f554119a.f554120a;
        r107.f554116c = null;
        r107.f554115b = false;
        return;
    L15:
        return;
    L9:
        if (r105.getType() != UIHandleStatus.HybridStatus.HybridStatusType.LOADING.getTag()) goto L11;
    L10:
        r106 = true;
        goto L12
    L5:
        if (r104.getType() == UIHandleStatus.HybridStatus.HybridStatusType.LOADED.getTag()) goto L10;
        goto L6
    }
}

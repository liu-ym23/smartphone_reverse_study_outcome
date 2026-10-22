package s0b;

import com.bytedance.geckox.model.UpdatePackage;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UpdatePackage f540059a;

    public c(UpdatePackage r100) {
        this.f540059a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j.c("CML_TAG_GeckoResManager", "applyGeckoResource failed ", (Throwable) r100);
        int r101 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.f411278a;
        UpdatePackage r102 = this.f540059a;
        Intrinsics.checkNotNullParameter(r102, "updatePackage");
        j.e(ChameleonResUtils.TAG, "clearGeckoResourceByChannel, channel = " + r102.getChannel());
        swb.j.h(a.b().getVfsPath().subPath(r102.getAccessKey()).subPath(r102.getChannel()));
    }
}

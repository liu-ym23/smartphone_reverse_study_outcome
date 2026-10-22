package fd6;

import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.UnzipException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f476535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e f476536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uy0.b f476537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f476538d;

    public d(e r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101, uy0.b r102, Ref.ObjectRef r103) {
        this.f476535a = r100;
        this.f476536b = r101;
        this.f476537c = r102;
        this.f476538d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UnzipException r101 = new UnzipException("unzip exception", (Throwable) r100, this.f476536b);
        this.f476535a.l(this.f476536b, r101);
        this.f476537c.J((String) this.f476538d.element);
    }
}

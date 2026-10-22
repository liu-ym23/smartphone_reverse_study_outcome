package fd6;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f476530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e f476531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f476532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ uy0.b f476533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f476534e;

    public c(e r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101, Ref.ObjectRef r102, uy0.b r103, String r104) {
        this.f476530a = r100;
        this.f476531b = r101;
        this.f476532c = r102;
        this.f476533d = r103;
        this.f476534e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r102 = this.f476530a.f476539a;
        if (r102 == null) goto L5;
        r102.b(this.f476531b, (String) this.f476532c.element);
    L5:
        this.f476533d.J(this.f476534e);
    }
}

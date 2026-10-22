package rc6;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.scope.o;
import i12.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements sc6.c, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<List<l2>> f537156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f537157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xc6.e f537158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f537159d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // sc6.c
    public final com.bytedance.revenue.platform.api.core.rx.b al() {
        i12.d r100 = m.f487958e2.a();
        String r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.scope.m.f163449e.getClass();
        o r102 = (o) com.bytedance.android.scope.m.b(r100).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r103 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r102;
        if (r103 == null) goto L9;
        ReceiverType r104 = r103.f128463b;
    L11:
        if (r104 != ReceiverType.AllMic) goto L13;
        IBaseUser r105 = this.f537159d.getRoom().getOwnerKt();
    L17:
        int r106 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.g.a(null);
        xc6.e r107 = this.f537158c;
        String r108 = this.f537159d.getRoom().getIdStr();
        if (r105 == null) goto L20;
        r101 = r105.getIdString();
    L20:
        if (r101 != null) goto L22;
        r101 = "";
    L22:
        if (r105 == null) goto L24;
        String r109 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.a(r105);
    L25:
        com.bytedance.revenue.platform.api.core.rx.f.a(r107.c(r108, r101, r106, r109).subscribe(new d(this), e.f537155a), this.f537157b);
        return new com.bytedance.revenue.platform.api.core.rx.b(this.f537156a);
    L24:
        r109 = this.f537159d.getRoom().getIdStr();
        goto L25
    L13:
        if (r103 == null) goto L16;
        r105 = r103.f128462a;
        if (r105 != null) goto L17;
    L16:
        r105 = this.f537159d.getRoom().getOwnerKt();
        goto L17
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f537157b.clear();
    }

    public f(xc6.e r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "propListRemoteDataSource");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f537158c = r100;
        this.f537159d = r101;
        int r102 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f537156a = BehaviorSubject.createDefault(com.bytedance.revenue.platform.api.core.c.a(new l2[0]));
        this.f537157b = new CompositeDisposable();
    }
}

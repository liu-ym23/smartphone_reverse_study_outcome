package qe1;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.sharedpref.f;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f532618a;

    public c(e r100) {
        this.f532618a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.f158131c3;
        Boolean r103 = Boolean.valueOf(((com.bytedance.android.live.base.model.gift.a) r101.data).getHasAudienceAuthSwitch());
        r102.getClass();
        f.d(r102, r103);
        com.bytedance.android.livesdk.sharedpref.e<Long> r104 = com.bytedance.android.livesdk.sharedpref.b.f158136d3;
        Long r105 = Long.valueOf(((com.bytedance.android.live.base.model.gift.a) r101.data).getAuthSwitch());
        r104.getClass();
        f.d(r104, r105);
        re1.a r106 = this.f532618a.f532621b;
        if (r106 == null) goto L6;
        r106.a();
        return;
    }
}

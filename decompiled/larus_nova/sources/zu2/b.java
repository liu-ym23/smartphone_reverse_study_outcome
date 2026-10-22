package zu2;

import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.d;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f573663a;

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.d
    public final void Ko(Map<String, String> r100, String r101, boolean r102, Episode r103) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "ticketEntrance");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.d
    public final void ld() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.d
    public final Map<String, String> Ph() {
        return new LinkedHashMap();
    }

    public b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "attachScene");
        this.f573663a = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.d
    public final Boolean F0(PaidInteractEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        if (a.f573662a[r100.ordinal()] == 1) goto L6;
        return null;
    L6:
        return Boolean.FALSE;
    }
}

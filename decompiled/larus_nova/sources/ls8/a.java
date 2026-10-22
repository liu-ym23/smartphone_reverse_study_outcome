package ls8;

import com.larus.bmhome.upload.sdk.f;
import com.larus.bmhome.upload.sdk.impl.ApiCredentialProviderAdapter;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import hs8.b;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.upload.sdk.impl.a f510558a;

    public a(com.larus.bmhome.upload.sdk.impl.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f510558a = r100;
    }

    @Override // hs8.b
    public final com.larus.bmhome.upload.sdk.impl.a a(f r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        com.larus.bmhome.upload.sdk.impl.a r101 = this.f510558a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        r100.a(r101);
        return r101;
    }

    @Override // hs8.b
    public final com.larus.bmhome.upload.sdk.impl.a b(hs8.f r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        com.larus.bmhome.upload.sdk.impl.a r101 = this.f510558a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        ApiCredentialProviderAdapter r102 = new ApiCredentialProviderAdapter(r100);
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((ArrayList) r101.f314845b).add(r102);
        return r101;
    }
}

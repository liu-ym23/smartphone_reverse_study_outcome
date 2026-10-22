package iq2;

import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b8 f495333a;

    public final String a() {
        return n8.b(this.f495333a);
    }

    public final String b() {
        return this.f495333a.getNickNameFlex();
    }

    public c(b8 r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f495333a = r100;
    }
}

package com.larus.dora.impl.ota.g2;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class l4 implements h4 {
    private static final a Companion = null;
    public static final String KEY_SNAPSHOT = "snapshot";
    public static final String REPO_NAME = "dora_g2_ota_engine";
    public static final String TAG = "G2OtaStore";
    private final g4 codec;
    private final Keva keva;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larus.dora.impl.ota.g2.h4
    public final b5 load() {
        String r100 = this.keva.getString("snapshot", "");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        b5 r102 = this.codec.a(r100);
        if (r102 != null) goto L16;
        b5 r103 = new b5(Long.MAX_VALUE, 16379);
        g49.d.b(TAG, "load failed, install recovery blocked until local state is cleared");
        a(r103);
        return r103;
    L16:
        return r102;
    L11:
        return new b5(0, 16383);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public l4(int r100) {
        Keva r101 = Keva.getRepo(REPO_NAME, 0);
        g4 r102 = new g4(0);
        Intrinsics.checkNotNullParameter(r101, "keva");
        Intrinsics.checkNotNullParameter(r102, "codec");
        this.keva = r101;
        this.codec = r102;
    }

    @Override // com.larus.dora.impl.ota.g2.h4
    public final void a(b5 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.keva.storeString("snapshot", this.codec.b(r100));
    }
}

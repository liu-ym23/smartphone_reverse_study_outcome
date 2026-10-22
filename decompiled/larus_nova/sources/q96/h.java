package q96;

import com.bytedance.kmp.crypto.PaddingModeRsa;
import javax.crypto.Cipher;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p96.b f532117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PaddingModeRsa f532118c;

    public h() {
        r96.e r100 = new r96.e();
        PaddingModeRsa r101 = PaddingModeRsa.PKCS1Padding;
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "paddingModeCurrent");
        this.f532117b = r100;
        this.f532118c = r101;
    }

    @Override // q96.m
    public final p96.b b() {
        return this.f532117b;
    }

    @Override // q96.q
    public final void c(PaddingModeRsa r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        d(r100);
    }

    public final void d(PaddingModeRsa r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f532118c = r100;
    }

    @Override // q96.q
    public final byte[] a(byte[] r100, r96.g r101) {
        Intrinsics.checkNotNullParameter(r100, "plaintext");
        Intrinsics.checkNotNullParameter(r101, "key");
        if ((r101 instanceof r96.f) == false) goto L18;
        PaddingModeRsa r102 = this.f532118c;
        int r103 = i.f532119a[r102.ordinal()];
        if (r103 != 1) goto L7;
        String r104 = com.baidu.bbalbscesium.k.d.c.f30370p;
    L15:
        Cipher r105 = Cipher.getInstance("RSA/ECB/".concat(r104));
        r105.init(1, ((r96.f) r101).f536738a);
        return r105.doFinal(r100);
    L7:
        if (r103 != 2) goto L9;
        r104 = "OAEPWithSHA-1AndMGF1Padding";
        goto L15
    L9:
        if (r103 != 3) goto L12;
        r104 = "OAEPWithSHA-256AndMGF1Padding";
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        throw new RuntimeException("[crypto] AndroidRsa.encrypt: key is not instance of AndroidRsaPublicKey.");
    }
}

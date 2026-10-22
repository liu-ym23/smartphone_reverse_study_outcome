package io.ktor.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class CryptoKt__CryptoJvmKt$getDigestFunction$1 extends Lambda implements Function1<String, byte[]> {
    final /* synthetic */ String $algorithm;
    final /* synthetic */ Function1<String, String> $salt;

    /* JADX WARN: Multi-variable type inference failed */
    public CryptoKt__CryptoJvmKt$getDigestFunction$1(String r100, Function1<? super String, String> r101) {
        this.$algorithm = r100;
        this.$salt = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final byte[] invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        String r101 = this.$algorithm;
        Function1<String, String> r102 = this.$salt;
        MessageDigest r103 = MessageDigest.getInstance(r101);
        String r104 = r102.invoke(r100);
        Charset r105 = Charsets.UTF_8;
        r103.update(r104.getBytes(r105));
        return r103.digest(r100.getBytes(r105));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ byte[] invoke(String r100) {
        return invoke2(r100);
    }
}

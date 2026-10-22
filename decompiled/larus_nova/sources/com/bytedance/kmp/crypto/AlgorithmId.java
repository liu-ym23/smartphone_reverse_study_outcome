package com.bytedance.kmp.crypto;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/crypto/AlgorithmId;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/kmp/crypto/Algorithm;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AlgorithmId<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251230a;

    public AlgorithmId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f251230a = r100;
    }
}

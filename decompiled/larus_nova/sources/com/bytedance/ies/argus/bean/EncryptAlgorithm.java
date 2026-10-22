package com.bytedance.ies.argus.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "", "", "value", "B", "getValue", "()B", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, com.alipay.sdk.m.n.d.f25615a, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum EncryptAlgorithm extends Enum<EncryptAlgorithm> {
    public static final a Companion = null;
    public static final EncryptAlgorithm RSA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncryptAlgorithm[] f246010a = null;
    private final byte value;

    public static final class a {
        public a() {
        }
    }

    public static EncryptAlgorithm valueOf(String r100) {
        return (EncryptAlgorithm) r27.a.a(EncryptAlgorithm.class, r100);
    }

    public static EncryptAlgorithm[] values() {
        return (EncryptAlgorithm[]) f246010a.clone();
    }

    static {
        EncryptAlgorithm r100 = new EncryptAlgorithm();
        RSA = r100;
        f246010a = new EncryptAlgorithm[]{r100};
        Companion = new a();
    }

    public EncryptAlgorithm() {
        super(com.alipay.sdk.m.n.d.f25615a, 0);
        this.value = 16;
    }

    public final byte getValue() {
        return this.value;
    }
}

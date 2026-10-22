package com.bytedance.ies.argus.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/DigestAlgorithm;", "", "", "value", "B", "getValue", "()B", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SHA256", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum DigestAlgorithm extends Enum<DigestAlgorithm> {
    public static final a Companion = null;
    public static final DigestAlgorithm SHA256 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigestAlgorithm[] f246009a = null;
    private final byte value;

    public static final class a {
        public a() {
        }
    }

    public static DigestAlgorithm valueOf(String r100) {
        return (DigestAlgorithm) r27.a.a(DigestAlgorithm.class, r100);
    }

    public static DigestAlgorithm[] values() {
        return (DigestAlgorithm[]) f246009a.clone();
    }

    static {
        DigestAlgorithm r100 = new DigestAlgorithm();
        SHA256 = r100;
        f246009a = new DigestAlgorithm[]{r100};
        Companion = new a();
    }

    public DigestAlgorithm() {
        super("SHA256", 0);
        this.value = 1;
    }

    public final byte getValue() {
        return this.value;
    }
}

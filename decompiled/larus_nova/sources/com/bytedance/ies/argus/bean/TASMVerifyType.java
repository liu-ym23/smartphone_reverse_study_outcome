package com.bytedance.ies.argus.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/TASMVerifyType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SIGN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TASMVerifyType extends Enum<TASMVerifyType> {
    public static final a Companion = null;
    public static final TASMVerifyType SIGN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TASMVerifyType[] f246012a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public final TASMVerifyType getType(int r100) {
            if (r100 == 978000000) goto L7;
            return null;
        L7:
            return TASMVerifyType.SIGN;
        }
    }

    public static TASMVerifyType valueOf(String r100) {
        return (TASMVerifyType) r27.a.a(TASMVerifyType.class, r100);
    }

    public static TASMVerifyType[] values() {
        return (TASMVerifyType[]) f246012a.clone();
    }

    static {
        TASMVerifyType r100 = new TASMVerifyType();
        SIGN = r100;
        f246012a = new TASMVerifyType[]{r100};
        Companion = new a();
    }

    public TASMVerifyType() {
        super("SIGN", 0);
        this.type = 978000000;
    }

    public final int getType() {
        return this.type;
    }
}

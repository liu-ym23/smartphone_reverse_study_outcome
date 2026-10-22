package com.bytedance.ee.lark.infra.file;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTParamError;", "Lcom/bytedance/ee/lark/infra/file/TTFileError;", "paramName", "", "<init>", "(Ljava/lang/String;)V", "getParamName", "()Ljava/lang/String;", "Companion", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTParamError extends TTFileError {
    public static final a Companion = null;
    public static final TTParamError INVALID_LENGTH = null;
    public static final TTParamError INVALID_POSITION = null;
    private final String paramName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        INVALID_LENGTH = new TTParamError("length");
        INVALID_POSITION = new TTParamError("position");
    }

    public final String getParamName() {
        return this.paramName;
    }

    public TTParamError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "paramName");
        TTFileError r101 = TTFileError.INVALID_PARAM;
        super(r101.getCode(), r101.getMsg());
        this.paramName = r100;
    }
}

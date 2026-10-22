package com.bytedance.ee.lark.infra.file;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTBizError;", "Lcom/bytedance/ee/lark/infra/file/TTFileError;", "code", "", "msg", "", "<init>", "(ILjava/lang/String;)V", "Companion", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTBizError extends TTFileError {
    public static final a Companion = null;
    public static final TTBizError DATA_IS_NULL = null;
    public static final TTBizError DIR_EMPTY = null;
    public static final TTBizError EXTRACT_EXCEPTION = null;
    public static final TTBizError LOGIC_ERROR = null;
    public static final TTBizError ZIP_EXCEPTION = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        DATA_IS_NULL = new TTBizError(10001, "data is null");
        DIR_EMPTY = new TTBizError(10003, "directory is empty");
        LOGIC_ERROR = new TTBizError(10004, "logic error");
        ZIP_EXCEPTION = new TTBizError(10005, "zip exception");
        EXTRACT_EXCEPTION = new TTBizError(10006, "extract exception");
    }

    public TTBizError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        super(r100, r101);
    }
}

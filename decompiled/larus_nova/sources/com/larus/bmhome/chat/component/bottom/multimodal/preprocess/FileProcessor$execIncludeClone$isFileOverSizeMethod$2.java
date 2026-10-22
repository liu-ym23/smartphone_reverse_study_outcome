package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.bmhome.utils.ImFileUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FileProcessor$execIncludeClone$isFileOverSizeMethod$2 extends FunctionReferenceImpl implements Function3<Boolean, Long, Boolean, Boolean> {
    public FileProcessor$execIncludeClone$isFileOverSizeMethod$2(Object r100) {
        super(3, r100, ImFileUtil.class, "isFileOverSize", "isFileOverSize(ZJZ)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean r100, Long r101, Boolean r102) {
        return invoke(r100.booleanValue(), r101.longValue(), r102.booleanValue());
    }

    public final Boolean invoke(boolean r100, long r101, boolean r102) {
        ((ImFileUtil) this.receiver).getClass();
        return Boolean.valueOf(ImFileUtil.v(r101, r102));
    }
}

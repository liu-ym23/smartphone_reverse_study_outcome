package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.bmhome.utils.ImFileUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FileProcessor$execIncludeClone$isFileOverSizeMethod$1 extends FunctionReferenceImpl implements Function3<Boolean, Long, Boolean, Boolean> {
    public FileProcessor$execIncludeClone$isFileOverSizeMethod$1(Object r100) {
        super(3, r100, ImFileUtil.class, "isAudioFileOverSize", "isAudioFileOverSize(ZJZ)Z", 0);
    }

    public final Boolean invoke(boolean r100, long r101, boolean r102) {
        ((ImFileUtil) this.receiver).getClass();
        long r103 = ((Number) ImFileUtil.f314913o.getValue()).longValue();
        if (r101 > 0) goto L5;
    L8:
        boolean r104 = true;
    L10:
        return Boolean.valueOf(r104);
    L5:
        if (r101 > r103) goto L8;
        r104 = false;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean r100, Long r101, Boolean r102) {
        return invoke(r100.booleanValue(), r101.longValue(), r102.booleanValue());
    }
}

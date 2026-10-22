package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/jedi/arch/MultiEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "peekContent", "()Ljava/lang/Object;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public class MultiEvent<T> {
    private final T content;

    public final T peekContent() {
        return this.content;
    }

    public MultiEvent(T r100) {
        this.content = r100;
    }
}

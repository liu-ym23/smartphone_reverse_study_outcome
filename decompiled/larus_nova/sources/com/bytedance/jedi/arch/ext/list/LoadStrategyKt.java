package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003\u001a:\u0010\u0005\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003\u001a:\u0010\u0006\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003*X\u0010\u0007\u001a\u0004\b\u0000\u0010\u0003\"&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u00012&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001¨\u0006\b"}, d2 = {"Append", "Lkotlin/Function2;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/arch/ext/list/LoadStrategy;", "Prepend", "Replace", "LoadStrategy", "ext_list_release"}, k = 2, mv = {1, 1, 16})
public final class LoadStrategyKt {
    public static final <T> Function2<List<? extends T>, List<? extends T>, List<T>> Append() {
        return AnonymousClass1.INSTANCE;
    }

    public static final <T> Function2<List<? extends T>, List<? extends T>, List<T>> Prepend() {
        return C106171.INSTANCE;
    }

    public static final <T> Function2<List<? extends T>, List<? extends T>, List<T>> Replace() {
        return C106181.INSTANCE;
    }
}

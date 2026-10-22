package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/jedi/arch/ViewModelInitializer;", ExifInterface.LATITUDE_SOUTH, "", "initialize", "", "argsAcceptor", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ViewModelInitializer<S> {
    void initialize(Function1<? super S, ? extends S> r100);
}

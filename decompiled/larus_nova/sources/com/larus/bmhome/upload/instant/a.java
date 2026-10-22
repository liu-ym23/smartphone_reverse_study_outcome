package com.larus.bmhome.upload.instant;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Byte) r100).byteValue())}, 1));
    }
}

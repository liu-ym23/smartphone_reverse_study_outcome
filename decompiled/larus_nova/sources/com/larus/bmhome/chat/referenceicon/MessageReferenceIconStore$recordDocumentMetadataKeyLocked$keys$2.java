package com.larus.bmhome.chat.referenceicon;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2 INSTANCE = null;

    static {
        INSTANCE = new MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2();
    }

    public MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2() {
        super(1, StringsKt.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Boolean.valueOf(!StringsKt.isBlank(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return invoke2(r100);
    }
}

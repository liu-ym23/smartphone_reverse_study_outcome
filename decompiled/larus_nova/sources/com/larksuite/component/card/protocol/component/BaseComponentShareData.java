package com.larksuite.component.card.protocol.component;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/protocol/component/BaseComponentShareData;", "Ljava/io/Serializable;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseComponentShareData implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283895id;

    public final String getId() {
        return this.f283895id;
    }

    public BaseComponentShareData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f283895id = r100;
    }
}

package com.ss.android.lark.picker.config;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/config/MailUserExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "extraMap", "", "", "getExtraMap", "()Ljava/util/Map;", "setExtraMap", "(Ljava/util/Map;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MailUserExtra implements Extra {
    private Map<String, String> extraMap;

    public MailUserExtra() {
        this.extraMap = new LinkedHashMap();
    }

    public final Map<String, String> getExtraMap() {
        return this.extraMap;
    }

    public final void setExtraMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraMap = r100;
    }
}

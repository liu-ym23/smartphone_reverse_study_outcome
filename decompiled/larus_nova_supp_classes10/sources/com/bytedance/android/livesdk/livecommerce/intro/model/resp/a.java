package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a;", "", "", "Lcom/bytedance/android/ec/model/live/b;", "content", "Ljava/util/List;", "a", "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("content")
    private final List<com.bytedance.android.ec.model.live.b> content;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.content, ((a) r2).content) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<com.bytedance.android.ec.model.live.b> r0 = this.content;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ElementIcon(content=" + this.content + ")";
    }

    public a() {
        this.content = null;
    }

    public final List<com.bytedance.android.ec.model.live.b> a() {
        return this.content;
    }
}

package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.s1;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroElasticMultiElementTitle;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroElasticTitle;", "titles", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/s1;", "trackEvents", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroElasticMultiElementTitle {

    @SerializedName("titles")
    private final List<IntroElasticTitle> titles;

    @SerializedName("track_events")
    private final List<s1> trackEvents;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroElasticMultiElementTitle) == false) goto L10;
        IntroElasticMultiElementTitle r4 = (IntroElasticMultiElementTitle) r3;
        if (Intrinsics.areEqual(this.titles, r4.titles) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackEvents, r4.trackEvents) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<IntroElasticTitle> r0 = this.titles;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<s1> r4 = this.trackEvents;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroElasticMultiElementTitle(titles=" + this.titles + ", trackEvents=" + this.trackEvents + ")";
    }

    public final String a() {
        List<IntroElasticTitle> r0 = this.titles;
        if (r0 == null) goto L5;
        String r1 = CollectionsKt.joinToString$default(r0, null, null, null, 0, null, IntroElasticMultiElementTitle$getContentDescription$1.INSTANCE, 31, null);
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public IntroElasticMultiElementTitle() {
        this.titles = null;
        this.trackEvents = null;
    }

    public final List<IntroElasticTitle> b() {
        return this.titles;
    }

    public final List<s1> c() {
        return this.trackEvents;
    }
}

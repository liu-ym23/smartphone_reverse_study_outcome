package yl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lyl/c;", "", "Ljava/util/HashMap;", "", "Lyl/d;", "Lkotlin/collections/HashMap;", "preloadData", "Ljava/util/HashMap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashMap;", "", "supportStreamingResponse", "Ljava/lang/Boolean;", "getSupportStreamingResponse", "()Ljava/lang/Boolean;", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRELOAD_DATA)
    private final HashMap<String, d> preloadData;

    @SerializedName("support_streaming_response")
    private final Boolean supportStreamingResponse;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.preloadData, r101.preloadData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supportStreamingResponse, r101.supportStreamingResponse) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HashMap<String, d> r100 = this.preloadData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.supportStreamingResponse;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NetImagePreloadConfig(preloadData=" + this.preloadData + ", supportStreamingResponse=" + this.supportStreamingResponse + ")";
    }

    public final HashMap<String, d> a() {
        return this.preloadData;
    }

    public c(Object r100) {
        this.preloadData = null;
        this.supportStreamingResponse = null;
    }
}

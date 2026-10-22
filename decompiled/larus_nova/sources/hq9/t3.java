package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/PadConfig;", "", "enablePadAdapter", "", "isPadDevice", "", "adaptPadPageBlockList", "", "", "isPadDeviceUseKevaCache", "<init>", "(ZILjava/util/List;Z)V", "getEnablePadAdapter", "()Z", "()I", "getAdaptPadPageBlockList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t3 {

    @SerializedName("adapt_pad_page_block_list")
    private final List<String> adaptPadPageBlockList;

    @SerializedName("enable_pad_adapter")
    private final boolean enablePadAdapter;

    @SerializedName("is_pad_device")
    private final int isPadDevice;

    @SerializedName("is_pad_device_use_keva_cache")
    private final boolean isPadDeviceUseKevaCache;

    public t3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t3) == true) goto L8;
        return false;
    L8:
        t3 r101 = (t3) r100;
        if (this.enablePadAdapter == r101.enablePadAdapter) goto L12;
        return false;
    L12:
        if (this.isPadDevice == r101.isPadDevice) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.adaptPadPageBlockList, r101.adaptPadPageBlockList) == true) goto L18;
        return false;
    L18:
        if (this.isPadDeviceUseKevaCache == r101.isPadDeviceUseKevaCache) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enablePadAdapter == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.isPadDevice) * 31;
        List<String> r103 = this.adaptPadPageBlockList;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.isPadDeviceUseKevaCache == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PadConfig(enablePadAdapter=" + this.enablePadAdapter + ", isPadDevice=" + this.isPadDevice + ", adaptPadPageBlockList=" + this.adaptPadPageBlockList + ", isPadDeviceUseKevaCache=" + this.isPadDeviceUseKevaCache + ')';
    }

    public final List<String> a() {
        return this.adaptPadPageBlockList;
    }

    public final boolean b() {
        return this.enablePadAdapter;
    }

    public final int c() {
        return this.isPadDevice;
    }

    public final boolean d() {
        return this.isPadDeviceUseKevaCache;
    }

    public t3(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        this.enablePadAdapter = true;
        this.isPadDevice = 0;
        this.adaptPadPageBlockList = r101;
        this.isPadDeviceUseKevaCache = true;
    }
}

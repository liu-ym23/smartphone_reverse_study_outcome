package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0006\u0010'\u001a\u00020(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "Landroid/os/Parcelable;", "scale", "", "onlyAppWindow", "", "delay", "", "cacheStrategy", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "excludeLayerPackages", "", "", "useHardwareBuffer", "heifOutput", "Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "<init>", "(FZJLcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;Ljava/util/List;ZLcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;)V", "getScale", "()F", "getOnlyAppWindow", "()Z", "getDelay", "()J", "getCacheStrategy", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "getExcludeLayerPackages", "()Ljava/util/List;", "getUseHardwareBuffer", "getHeifOutput", "()Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotOption implements Parcelable {
    public static final Parcelable.Creator<ScreenshotOption> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f397282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f397283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f397284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScreenshotCacheStrategy f397285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f397286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f397287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HeifOutputOption f397288g;

    public static final class a implements Parcelable.Creator<ScreenshotOption> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            float r100 = r110.readFloat();
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            long r102 = r110.readLong();
            ScreenshotCacheStrategy r103 = ScreenshotCacheStrategy.CREATOR.createFromParcel(r110);
            ArrayList<String> r104 = r110.createStringArrayList();
            if (r110.readInt() == 0) goto L9;
            boolean r111 = true;
        L11:
            if (r110.readInt() != 0) goto L13;
            HeifOutputOption r112 = null;
        L14:
            boolean r105 = r101;
            boolean r106 = r111;
            return new ScreenshotOption(r100, r105, r102, r103, r104, r106, r112);
        L13:
            r112 = HeifOutputOption.CREATOR.createFromParcel(r110);
            goto L14
        L9:
            r111 = false;
            goto L11
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption[] newArray(int r100) {
            return new ScreenshotOption[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScreenshotOption) == true) goto L8;
        return false;
    L8:
        ScreenshotOption r101 = (ScreenshotOption) r100;
        if (Float.compare(this.f397282a, r101.f397282a) == 0) goto L12;
        return false;
    L12:
        if (this.f397283b == r101.f397283b) goto L15;
        return false;
    L15:
        if (this.f397284c == r101.f397284c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397285d, r101.f397285d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397286e, r101.f397286e) == true) goto L24;
        return false;
    L24:
        if (this.f397287f == r101.f397287f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397288g, r101.f397288g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f397282a) * 31;
        int r101 = 1231;
        if (this.f397283b == false) goto L5;
        int r102 = 1231;
    L6:
        long r103 = this.f397284c;
        int r104 = (((((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f397285d.hashCode()) * 31;
        List<String> r105 = this.f397286e;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        if (this.f397287f == true) goto L14;
        r101 = 1237;
    L14:
        int r109 = (r108 + r101) * 31;
        HeifOutputOption r110 = this.f397288g;
        if (r110 == null) goto L19;
        r106 = r110.hashCode();
    L19:
        return r109 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenshotOption(scale=" + this.f397282a + ", onlyAppWindow=" + this.f397283b + ", delay=" + this.f397284c + ", cacheStrategy=" + this.f397285d + ", excludeLayerPackages=" + this.f397286e + ", useHardwareBuffer=" + this.f397287f + ", heifOutput=" + this.f397288g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeFloat(this.f397282a);
        r100.writeInt(this.f397283b ? 1 : 0);
        r100.writeLong(this.f397284c);
        this.f397285d.writeToParcel(r100, r101);
        r100.writeStringList(this.f397286e);
        r100.writeInt(this.f397287f ? 1 : 0);
        HeifOutputOption r102 = this.f397288g;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public ScreenshotOption() {
        this(1.0f, false, 0, new ScreenshotCacheStrategy(CacheStrategy.CACHE_WITH_ROOT_NODE, null), null, false, null);
    }

    public ScreenshotOption(float r100, boolean r101, long r102, ScreenshotCacheStrategy r103, List<String> r104, boolean r105, HeifOutputOption r106) {
        Intrinsics.checkNotNullParameter(r103, "cacheStrategy");
        this.f397282a = r100;
        this.f397283b = r101;
        this.f397284c = r102;
        this.f397285d = r103;
        this.f397286e = r104;
        this.f397287f = r105;
        this.f397288g = r106;
        boolean r107 = false;
        if (r105 == false) goto L7;
        if (r106 == null) goto L7;
        boolean r108 = false;
    L8:
        if (r108 == false) goto L30;
        if (r101 == false) goto L13;
        if (r106 == null) goto L13;
        boolean r109 = false;
    L14:
        if (r109 == false) goto L28;
        if (r104 != null) goto L17;
    L19:
        boolean r110 = false;
    L20:
        if (r110 == false) goto L22;
        if (r106 == null) goto L22;
    L23:
        if (r107 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("heifOutput is incompatible with excludeLayerPackages".toString());
    L22:
        r107 = true;
        goto L23
    L17:
        if ((!r104.isEmpty()) != true) goto L19;
        r110 = true;
        goto L20
    L28:
        throw new IllegalArgumentException("heifOutput is incompatible with onlyAppWindow".toString());
    L13:
        r109 = true;
        goto L14
    L30:
        throw new IllegalArgumentException("heifOutput is incompatible with useHardwareBuffer".toString());
    L7:
        r108 = true;
        goto L8
    }
}

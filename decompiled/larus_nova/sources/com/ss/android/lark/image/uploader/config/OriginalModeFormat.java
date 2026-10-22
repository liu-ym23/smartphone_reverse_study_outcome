package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/OriginalModeFormat;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "FILE", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OriginalModeFormat extends Enum<OriginalModeFormat> {

    @SerializedName("file")
    public static final OriginalModeFormat FILE = null;

    @SerializedName("image")
    public static final OriginalModeFormat IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OriginalModeFormat[] f426371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426372b = null;

    public static EnumEntries<OriginalModeFormat> getEntries() {
        return f426372b;
    }

    static {
        OriginalModeFormat r100 = new OriginalModeFormat("IMAGE", 0);
        IMAGE = r100;
        OriginalModeFormat r101 = new OriginalModeFormat("FILE", 1);
        FILE = r101;
        OriginalModeFormat[] r102 = {r100, r101};
        f426371a = r102;
        f426372b = EnumEntriesKt.enumEntries(r102);
    }

    public static OriginalModeFormat[] values() {
        return (OriginalModeFormat[]) f426371a.clone();
    }

    public static OriginalModeFormat valueOf(String r100) {
        return (OriginalModeFormat) r27.a.a(OriginalModeFormat.class, r100);
    }

    public OriginalModeFormat(String r100, int r101) {
        super(r100, r101);
    }
}

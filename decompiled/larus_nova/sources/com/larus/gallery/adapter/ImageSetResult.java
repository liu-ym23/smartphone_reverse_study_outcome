package com.larus.gallery.adapter;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/gallery/adapter/ImageSetResult;", "", "<init>", "(Ljava/lang/String;I)V", "Success", CheckStatus.FAIL, "LowRes", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageSetResult extends Enum<ImageSetResult> {
    public static final ImageSetResult Fail = null;
    public static final ImageSetResult LowRes = null;
    public static final ImageSetResult Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageSetResult[] f343698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343699b = null;

    public static EnumEntries<ImageSetResult> getEntries() {
        return f343699b;
    }

    static {
        ImageSetResult r100 = new ImageSetResult("Success", 0);
        Success = r100;
        ImageSetResult r101 = new ImageSetResult(CheckStatus.FAIL, 1);
        Fail = r101;
        ImageSetResult r102 = new ImageSetResult("LowRes", 2);
        LowRes = r102;
        ImageSetResult[] r103 = {r100, r101, r102};
        f343698a = r103;
        f343699b = EnumEntriesKt.enumEntries(r103);
    }

    public static ImageSetResult[] values() {
        return (ImageSetResult[]) f343698a.clone();
    }

    public static ImageSetResult valueOf(String r100) {
        return (ImageSetResult) r27.a.a(ImageSetResult.class, r100);
    }

    public ImageSetResult(String r100, int r101) {
        super(r100, r101);
    }
}

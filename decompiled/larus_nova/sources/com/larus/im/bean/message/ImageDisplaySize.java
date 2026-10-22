package com.larus.im.bean.message;

import com.lynx.canvas.KryptonCamera;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/bean/message/ImageDisplaySize;", "", "<init>", "(Ljava/lang/String;I)V", "small", KryptonCamera.Config.RESOLUTION_MEDIUM, "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageDisplaySize extends Enum<ImageDisplaySize> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageDisplaySize[] f346649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346650b = null;
    public static final ImageDisplaySize medium = null;
    public static final ImageDisplaySize small = null;

    public static EnumEntries<ImageDisplaySize> getEntries() {
        return f346650b;
    }

    static {
        ImageDisplaySize r100 = new ImageDisplaySize("small", 0);
        small = r100;
        ImageDisplaySize r101 = new ImageDisplaySize(KryptonCamera.Config.RESOLUTION_MEDIUM, 1);
        medium = r101;
        ImageDisplaySize[] r102 = {r100, r101};
        f346649a = r102;
        f346650b = EnumEntriesKt.enumEntries(r102);
    }

    public static ImageDisplaySize[] values() {
        return (ImageDisplaySize[]) f346649a.clone();
    }

    public static ImageDisplaySize valueOf(String r100) {
        return (ImageDisplaySize) r27.a.a(ImageDisplaySize.class, r100);
    }

    public ImageDisplaySize(String r100, int r101) {
        super(r100, r101);
    }
}

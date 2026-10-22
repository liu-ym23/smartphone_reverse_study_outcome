package iv7;

import com.google.archivepatcher.shared.PatchConstants$CompressionMethod;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f495955a = null;

    static {
        int[] r100 = new int[PatchConstants$CompressionMethod.values().length];
        f495955a = r100;
        r100[PatchConstants$CompressionMethod.DEFLATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f495955a[PatchConstants$CompressionMethod.STORED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}

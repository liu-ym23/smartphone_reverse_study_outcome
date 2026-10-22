package w88;

import com.larus.avlink.api.DatasetVideoRatio;
import com.larus.avlink.api.DatasetVideoResolution;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558659a = 0;

    static {
        int[] r100 = new int[DatasetVideoRatio.values().length];
        r100[DatasetVideoRatio.R3_4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L18:
        r100[DatasetVideoRatio.R9_16.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L24:
        r100[DatasetVideoRatio.R16_9.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L7:
        int[] r101 = new int[DatasetVideoResolution.values().length];
        r101[DatasetVideoResolution.P1080.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L16:
        r101[DatasetVideoResolution.K3.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        return;
    }
}

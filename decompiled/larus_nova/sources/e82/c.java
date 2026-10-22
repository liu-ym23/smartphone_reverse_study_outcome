package e82;

import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f471287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f471288b = null;

    static {
        int[] r100 = new int[ImageRecognitionEntry.values().length];
        f471287a = r100;
        ImageRecognitionEntry r101 = ImageRecognitionEntry.LongPressPanel;
        r100[r101.ordinal()] = 1;
        ImageRecognitionEntry r102 = ImageRecognitionEntry.ClearScreen;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ImageRecognitionEntry.values().length];
        f471288b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}

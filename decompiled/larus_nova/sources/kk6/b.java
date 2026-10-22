package kk6;

import com.bytedance.live.richcontent.model.style.ImageStyle;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f503813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f503814b = null;

    static {
        int[] r100 = new int[ImageStyle.PlaceHolderType.values().length];
        f503813a = r100;
        ImageStyle.PlaceHolderType r101 = ImageStyle.PlaceHolderType.TEXT;
        r100[r101.ordinal()] = 1;
        ImageStyle.PlaceHolderType r102 = ImageStyle.PlaceHolderType.EMPTY;
        r100[r102.ordinal()] = 2;
        ImageStyle.PlaceHolderType r103 = ImageStyle.PlaceHolderType.FIX_SIZE;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[ImageStyle.PlaceHolderType.values().length];
        f503814b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}

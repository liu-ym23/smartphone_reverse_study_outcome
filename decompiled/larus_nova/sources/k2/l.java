package k2;

import com.bytedance.ai.model.objects.PageType;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f501449a = null;

    static {
        int[] r100 = new int[PageType.values().length];
        r100[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r100[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f501449a = r100;
    }
}

package qb2;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends com.bytedance.android.livesdk.interactivity.service.richcontent.config.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f532291i;

    public /* synthetic */ g(boolean r100, float r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = 1.0f;
    L8:
        this(0, r100, r101);
    }

    public g(int r100, boolean r101, float r102) {
        if (r100 <= 0) goto L4;
        boolean r103 = true;
    L5:
        super(r103, r100, r101);
        this.f532291i = r102;
        return;
    L4:
        r103 = false;
        goto L5
    }
}

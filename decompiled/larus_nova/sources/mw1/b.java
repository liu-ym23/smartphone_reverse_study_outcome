package mw1;

import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends LiveCoverConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f515909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f515911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f515912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f515913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f515915g;

    public b() {
        boolean r100 = false;
        this(r100, r100, r100, 127);
    }

    @Override // com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig
    public final boolean getEnableCategoryLabel() {
        return this.f515912d;
    }

    @Override // com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig
    public final boolean getEnableContentLabel() {
        return this.f515911c;
    }

    @Override // com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig
    public final boolean getEnableOperationLabel() {
        return this.f515910b;
    }

    public /* synthetic */ b(boolean r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Integer r114 = 0;
    L14:
        Integer r102 = r114;
        if ((r113 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r113 & 64) == 0) goto L21;
        boolean r104 = true;
    L22:
        this(r100, r101, false, r102, r103, r104);
        return;
    L21:
        r104 = r112;
        goto L22
    L17:
        r103 = r111;
        goto L19
    L13:
        r114 = null;
        goto L14
    L9:
        r101 = r110;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public b(boolean r100, boolean r101, boolean r102, Integer r103, boolean r104, boolean r105) {
        super(r100, r101, r102);
        this.f515910b = r100;
        this.f515911c = r101;
        this.f515912d = r102;
        this.f515913e = r103;
        this.f515914f = r104;
        this.f515915g = r105;
    }
}

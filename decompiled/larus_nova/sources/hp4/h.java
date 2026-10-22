package hp4;

import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f486409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EFieldUneditableReason f486410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f486411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f486412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f486413e;

    public h() {
        this.f486409a = true;
        this.f486413e = true;
    }

    public final void a(boolean r100) {
        boolean r101 = this.f486409a;
        if (r101 == true) goto L5;
    L8:
        boolean r102 = false;
    L9:
        this.f486413e = r102;
        if (r101 == true) goto L12;
    L14:
        if (r101 == false) goto L18;
        if (r100 == false) goto L19;
        this.f486410b = EFieldUneditableReason.FIELD_NOT_SUPPORT_EDIT;
        return;
    L19:
        return;
    L18:
        return;
    L12:
        if (this.f486412d == false) goto L14;
        this.f486410b = EFieldUneditableReason.LANDSCAPE_READONLY;
        goto L14
    L5:
        if (this.f486412d == true) goto L8;
        if (r100 == true) goto L8;
        r102 = true;
        goto L9
    }
}

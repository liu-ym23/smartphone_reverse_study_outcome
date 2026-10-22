package i02;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidgetOrigin;

/* JADX INFO: loaded from: classes9.dex */
public final class c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f487862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f487864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f487865d;

    public interface a<E> {
        boolean compare(E r100, E r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int r100 = 1;
        int r101 = 2;
    L3:
        int r102 = this.f487864c;
        if (r101 > r102) goto L13;
        int r103 = r101 + 1;
        if (r103 > r102) goto L10;
        a r104 = this.f487865d;
        Object[] r105 = this.f487862a;
        if (r104.compare(r105[r103], r105[r101]) == false) goto L10;
        r101 = r103;
    L10:
        a r106 = this.f487865d;
        Object[] r107 = this.f487862a;
        if (r106.compare(r107[r101], r107[r100]) == false) goto L16;
        Object[] r108 = this.f487862a;
        Object r109 = r108[r100];
        r108[r100] = r108[r101];
        r108[r101] = r109;
        int r110 = r101;
        r101 = r101 * 2;
        r100 = r110;
        goto L3
    L16:
        return;
    }

    public c(int r100, BaseVideoGiftWidgetOrigin.d r101) {
        this.f487863b = r100;
        this.f487864c = 0;
        this.f487862a = new Object[r100 + 1];
        this.f487865d = r101;
    }
}

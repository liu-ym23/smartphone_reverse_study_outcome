package g2b;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f479764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f479765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f479766c;

    public /* synthetic */ f(int r100, View r101, Drawable r102) {
        this.f479764a = r100;
        this.f479765b = r101;
        this.f479766c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f479764a;
        View r101 = this.f479765b;
        Drawable r102 = this.f479766c;
        if (r100 < 0) goto L5;
        r101.setBackgroundColor(r100);
    L6:
        ItemShineManager.b(r101);
        return;
    L5:
        r101.setBackground(r102);
        goto L6
    }
}

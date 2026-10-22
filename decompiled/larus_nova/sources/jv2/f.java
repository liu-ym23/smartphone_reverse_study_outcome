package jv2;

import android.graphics.RectF;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.widget.crop.PreviewBoxViewV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewBoxViewV2 f500549a;

    public final void a() {
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f500549a.f161674m.getLayoutParams();
        PreviewBoxViewV2 r101 = this.f500549a;
        RectF r102 = r101.f161671j;
        r100.leftMargin = (int) r102.left;
        r100.topMargin = (int) r102.top;
        float r103 = r101.getWidth();
        PreviewBoxViewV2 r104 = this.f500549a;
        r100.rightMargin = (int) (r103 - r104.f161671j.right);
        float r105 = r104.getHeight();
        PreviewBoxViewV2 r106 = this.f500549a;
        RectF r107 = r106.f161671j;
        float r108 = r107.bottom;
        r100.bottomMargin = (int) (r105 - r108);
        int r109 = (int) (r107.right - r107.left);
        r100.width = r109;
        r100.height = (int) (r108 - r107.top);
        r106.f161674m.setMinWidth(r109);
        this.f500549a.f161674m.setMinHeight(r100.height);
        this.f500549a.f161674m.setLayoutParams(r100);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(PreviewBoxViewV2 r100) {
        this.f500549a = r100;
    }
}

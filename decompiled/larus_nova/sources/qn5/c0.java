package qn5;

import android.view.View;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f534038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SheetEditorLayout f534039b;

    public c0(SheetEditorLayout r100, Runnable r101) {
        this.f534039b = r100;
        this.f534038a = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f534039b.removeOnLayoutChangeListener(this);
        this.f534038a.run();
    }
}

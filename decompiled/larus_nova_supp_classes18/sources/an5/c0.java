package an5;

import android.view.View;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ SheetEditorLayout b;

    public c0(SheetEditorLayout r1, Runnable r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.b.removeOnLayoutChangeListener(this);
        this.a.run();
    }
}

package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$5 implements ContentFrameLayout.OnAttachListener {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onAttachedFromWindow() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }

    public AppCompatDelegateImpl$5(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }
}

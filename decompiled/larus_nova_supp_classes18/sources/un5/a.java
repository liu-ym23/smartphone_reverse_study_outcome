package un5;

import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a extends ClickableSpan implements i {
    public InterfaceC0318a a;
    public int b;

    /* JADX INFO: renamed from: un5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0318a {
        void B3(a r1);
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        return 33;
    }

    public a() {
        this.b = -1;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r2) {
        if (this.a == null) goto L6;
        tt5.a.h("FileSpan", "onClick: ");
        this.a.B3(this);
        return;
    }
}

package un5;

import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a extends ClickableSpan implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC7903a f550772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f550773b;

    /* JADX INFO: renamed from: un5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7903a {
        void B3(a r100);
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        return 33;
    }

    public a() {
        this.f550773b = -1;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        if (this.f550772a == null) goto L6;
        tt5.a.h("FileSpan", "onClick: ");
        this.f550772a.B3(this);
        return;
    }
}

package ta5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends k {
    public final AppCompatActivity b;

    @Override // ta5.k
    public final List<Fragment> k() {
        return this.b.getSupportFragmentManager().getFragments();
    }

    @Override // ta5.k, sa5.e
    public final boolean j() {
        if (super.j() == false) goto L6;
        return true;
    L6:
        rcb.c.c(this.b);
        return false;
    }

    public a(AppCompatActivity r1) {
        this.b = r1;
    }
}

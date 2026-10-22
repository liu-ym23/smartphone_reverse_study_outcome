package xp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.util.ui.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends sa5.e {
    public final AppCompatActivity a;

    public final boolean j() {
        FragmentManager r0 = this.a.getSupportFragmentManager();
        int r1 = r0.getBackStackEntryCount();
        if (r1 <= 0) goto L5;
        boolean r2 = "document_stack".equals(r0.getBackStackEntryAt(r1 - 1).getName());
    L6:
        tt5.a.h("DocumentFragmentBackHandler", "onDispatchFragmentBackPress , documentAtTopBackStack:" + r2);
        if (r2 == false) goto L10;
        i.a(r0);
        r0.popBackStack();
        return true;
    L10:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    public a(AppCompatActivity r1) {
        this.a = r1;
    }
}

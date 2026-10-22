package bh2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Observer<Void> {
    public final /* synthetic */ Fragment a;

    public m(Fragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Void r2 = (Void) r1;
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }
}

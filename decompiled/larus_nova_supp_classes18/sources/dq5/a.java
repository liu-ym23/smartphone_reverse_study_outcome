package dq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.ss.android.lark.picker.Picker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ HomeLibraryFragment a;

    public a(HomeLibraryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WikiSearchPickerView r3 = this.a.m;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        WikiSearchPickerView r4 = this.a.m;
        if (r4 == null) goto L14;
        com.bytedance.ee.bear.wikiv2.searchv2.b.a r0 = r4.b;
        if (r0 == null) goto L10;
        r0.b();
    L10:
        Picker r5 = r4.a;
        if (r5 == null) goto L15;
        r5.defaultMode(true);
        return;
    L15:
        return;
    }
}

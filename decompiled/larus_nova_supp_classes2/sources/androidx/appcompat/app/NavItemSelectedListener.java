package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    public NavItemSelectedListener(ActionBar.OnNavigationListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        ActionBar.OnNavigationListener r5 = this.mListener;
        if (r5 == null) goto L6;
        r5.onNavigationItemSelected(r3, r4);
        return;
    }
}

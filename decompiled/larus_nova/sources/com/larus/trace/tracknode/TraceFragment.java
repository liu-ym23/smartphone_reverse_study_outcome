package com.larus.trace.tracknode;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import by7.e;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ixigua.lib.track.TrackParams;
import kotlin.Metadata;
import tx9.a1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/trace/tracknode/TraceFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "<init>", "()V", "enterPageTraced", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "autoLogEnterPage", "logEnterPage", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TraceFragment extends Fragment implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f370171d;

    public abstract boolean S90();

    public boolean et() {
        return false;
    }

    public String getPageName() {
        return null;
    }

    public e parentTrackNode() {
        return null;
    }

    @Override // by7.c
    public final void te() {
    }

    public void T90() {
        String r100 = getPageName();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        String r103 = k();
    L12:
        String r110 = r103;
        if (r110 != null) goto L15;
    L20:
        if (r101 == false) goto L23;
        a1.c(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r110, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -524289, -16777217, 7);
        return;
    L23:
        return;
    L15:
        if (r110.length() <= 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 != true) goto L20;
        r101 = true;
        goto L20
    L17:
        r104 = false;
        goto L18
    L11:
        r103 = getPageName();
        goto L12
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (S90() == true) goto L5;
        return;
    L5:
        if (this.f370171d == true) goto L9;
        T90();
        this.f370171d = true;
        return;
    }

    public e referrerTrackNode() {
        return e.a.a(this);
    }

    public TraceFragment() {
    }

    public void fillTrackParams(TrackParams r100) {
        a.C4500a.a(this, r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }
}

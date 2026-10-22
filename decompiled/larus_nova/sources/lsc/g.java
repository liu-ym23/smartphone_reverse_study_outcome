package lsc;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f510587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f510588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView.BufferType f510589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ysc.a f510590d;

    public g(Context r100) {
        this.f510588b = new ArrayList(3);
        this.f510589c = TextView.BufferType.SPANNABLE;
        this.f510587a = r100;
    }

    public final g a(a r100) {
        ((ArrayList) this.f510588b).add(r100);
        return this;
    }
}

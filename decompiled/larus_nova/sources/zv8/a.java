package zv8;

import android.widget.TextView;
import com.larus.business.debug.base.register.EntranceType;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f573741b;

    public abstract void f();

    @Override // zv8.e
    public void a() {
        TextView r100 = this.f573741b;
        if (r100 == null) goto L5;
        r100.setText("");
    L5:
        TextView r101 = this.f573741b;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public a() {
    }

    @Override // zv8.e
    public final EntranceType d() {
        return EntranceType.BUTTON;
    }
}

package zv8;

import androidx.appcompat.widget.SwitchCompat;
import com.larus.business.debug.base.register.EntranceType;

/* JADX INFO: loaded from: classes26.dex */
public abstract class p extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SwitchCompat f573771b;

    public abstract boolean f();

    public abstract void g();

    public p() {
    }

    @Override // zv8.e
    public final EntranceType d() {
        return EntranceType.SWITCH;
    }
}

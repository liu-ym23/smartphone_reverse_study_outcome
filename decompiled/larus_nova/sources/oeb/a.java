package oeb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements d, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f523048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f523049b;

    /* JADX INFO: renamed from: oeb.a$a, reason: collision with other inner class name */
    public static final class C7043a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // oeb.d
    public final boolean get() {
        return this.f523049b.get();
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f523048a;
    }

    @Inject
    public a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f523048a = r100;
        this.f523049b = new AtomicBoolean(false);
        r100.d(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("FeedStrangerData", "rest stranger available");
        this.f523049b.set(false);
    }

    @Override // oeb.d
    public void update(boolean r100) {
        Log.i("FeedStrangerData", "update stranger available " + r100);
        this.f523049b.set(r100);
    }
}

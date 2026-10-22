package oe0;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f522916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f522917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f522918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f522919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f522920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f522921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f522922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i<ILinkPlayerInfoBridge> f522923h;

    public static final class a {
    }

    static {
    }

    public final long b() {
        if (this.f522919d == false) goto L11;
        if (this.f522920e == false) goto L11;
        if (this.f522921f <= 0) goto L11;
        return this.f522922g + (SystemClock.elapsedRealtime() - this.f522921f);
    L11:
        return this.f522922g;
    }

    public b(y r100) {
        Intrinsics.checkNotNullParameter(r100, "userCenter");
        this.f522923h = r100;
        c r101 = new c(this);
        this.f522916a = r101;
        CompositeDisposable r102 = new CompositeDisposable();
        this.f522918c = r102;
        r100.Q4(r101);
        d(r100.f76316c);
        CPositionContext.a r103 = CPositionContext.Companion;
        r103.getContext();
        CPositionContext r104 = r103.getContext();
        if (r104 == null) goto L11;
        m<EnlargeGuestInfo> r105 = r104.getEnlargeGuestInfo();
        if (r105 == null) goto L11;
        Observable<EnlargeGuestInfo> r106 = r105.a();
        if (r106 == null) goto L11;
        Disposable r107 = r106.subscribe(new oe0.a(this));
        if (r107 == null) goto L11;
        r102.add(r107);
    L11:
        CPositionContext r108 = r103.getContext();
        if (r108 == null) goto L19;
        m<EnlargeGuestInfo> r109 = r108.getEnlargeGuestInfo();
        if (r109 == null) goto L20;
        EnlargeGuestInfo r110 = r109.getValue();
        if (r110 == null) goto L21;
        c(r110);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void c(EnlargeGuestInfo r100) {
        if (r100.getEnlargeGuestType() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = this.f522919d;
        if (this.f522920e == r101) goto L13;
        if (r101 == false) goto L10;
        a(r102, true);
    L11:
        this.f522920e = r101;
        return;
    L10:
        a(r102, false);
        goto L11
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void d(List<? extends ILinkPlayerInfoBridge> r100) {
        String r101 = je0.d.b0();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L10:
        boolean r103 = false;
    L23:
        boolean r104 = this.f522919d;
        boolean r105 = this.f522920e;
        if (r104 == r103) goto L33;
        if (r103 == false) goto L27;
        a(true, r105);
    L28:
        this.f522919d = r103;
        return;
    L27:
        a(false, r105);
        goto L28
    L33:
        return;
    L11:
        Iterator<T> r106 = r100.iterator();
    L12:
        Object r107 = null;
        if (r106.hasNext() == false) goto L20;
        Object r108 = r106.next();
        IBaseUser r109 = ((ILinkPlayerInfoBridge) r108).getUser();
        if (r109 == null) goto L18;
        r107 = r109.getIdString();
    L18:
        if (Intrinsics.areEqual(r107, r101) == false) goto L12;
        r107 = r108;
    L20:
        ILinkPlayerInfoBridge r110 = (ILinkPlayerInfoBridge) r107;
        if (r110 == null) goto L10;
        r103 = r110.isEnlarged();
        goto L23
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void a(boolean r100, boolean r101) {
        if (r100 == false) goto L7;
        if (r101 == false) goto L7;
        this.f522921f = SystemClock.elapsedRealtime();
        return;
    L7:
        if (this.f522921f <= 0) goto L11;
        this.f522922g += SystemClock.elapsedRealtime() - this.f522921f;
        this.f522921f = 0;
        return;
    }
}

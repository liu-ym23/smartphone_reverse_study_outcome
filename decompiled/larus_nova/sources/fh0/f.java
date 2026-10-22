package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.h0;
import sh0.i0;
import sh0.j0;
import sh0.o;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f476945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f476946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f476947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f476948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f476949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f476950g;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f476951a;

        public b(f r100) {
            this.f476951a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            f r102 = this.f476951a;
            if (r101 == null) goto L5;
            Object r103 = r101.getData();
        L6:
            if (r103 == null) goto L12;
            Object r104 = r101.getData();
            if (r104 == null) goto L11;
            boolean r105 = ((Boolean) r104).booleanValue();
        L13:
            r102.f476945b = r105;
            gh0.a.b("UniversalPlayModeExtHandler", "state changed isGuestBattleShowing: " + this.f476951a.f476945b + ' ', 4);
            this.f476951a.a().c1(this.f476951a.f476945b);
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L12:
            r105 = false;
            goto L13
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c implements ne0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f476952a;

        public c(f r100) {
            this.f476952a = r100;
        }

        @Override // ne0.a
        public final void a(ne0.e r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
            if ((r101 instanceof sh0.p) == false) goto L9;
            f r102 = this.f476952a;
            ((sh0.p) r101).getClass();
            r102.getClass();
            g r103 = new g(r102);
            if ((System.currentTimeMillis() - r102.f476946c) >= 60) goto L7;
            gh0.a.b("UniversalPlayModeExtHandler", "dispatchGuestBattleMicSeatUpdateAction: null, delay", 4);
            MainThreadPostUtils.c(r103, 60);
            return;
        L7:
            gh0.a.b("UniversalPlayModeExtHandler", "dispatchGuestBattleMicSeatUpdateAction: null", 4);
            r103.run();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        i0 r100 = j0.f541918a;
        DataCenter r101 = this.f476950g;
        int r102 = h0.f541915a;
        j0.f(r101, "is_guestbattle_showing", new b(this));
        i0 r103 = j0.a(this.f476950g);
        if (r103 == null) goto L6;
        r103.d(o.f541925b, new c(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f476949f.dispose();
    }

    public f(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f476950g = r100;
        this.f476949f = new CompositeDisposable();
        i0 r101 = j0.a(r100);
        if (r101 == null) goto L11;
        ne0.g r102 = r101.f518850b;
        if (r102 == null) goto L7;
        int r103 = h0.f541915a;
        Boolean r104 = (Boolean) r102.a("is_guestbattle_showing");
    L8:
        boolean r105 = true;
        if (Intrinsics.areEqual(r104, Boolean.TRUE) != true) goto L11;
    L12:
        this.f476945b = r105;
        return;
    L7:
        r104 = null;
    L11:
        r105 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.e> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
        ch0.e r101 = null;
    L4:
        if (r112.hasNext() == false) goto L15;
        ch0.e r102 = (ch0.e) r112.next();
        HashMap r103 = new HashMap(r102.f23727d);
        r103.put("EXT_KEY_GUEST_BATTLE_ACTION", this.f476947d);
        r103.put("EXT_KEY_GUEST_BATTLE_ACTION_PAYLOAD", this.f476948e);
        ch0.e r104 = ch0.e.a(r102, null, null, null, r103, 7);
        IBaseUser r105 = r104.f23724a.getUser();
        if (r105 == null) goto L8;
        String r106 = r105.getIdString();
    L10:
        if (Intrinsics.areEqual(r106, gh0.a.c()) == false) goto L13;
        if (r104 == r102) goto L13;
        r101 = r104;
    L13:
        r100.add(r104);
        goto L4
    L8:
        r106 = null;
        goto L10
    L15:
        return new h.a(true, r100, r101);
    }
}

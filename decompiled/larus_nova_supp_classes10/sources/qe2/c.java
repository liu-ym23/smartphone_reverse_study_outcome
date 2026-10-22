package qe2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.g;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public boolean a;
    public final BehaviorSubject<List<tf0.e>> b;
    public final BehaviorSubject<Map<String, Boolean>> c;
    public final CompositeDisposable d;
    public IRoom e;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d f;
    public ue0.c g;
    public boolean h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("KtvSeatListDataCenter", "feed linkedUserMergeDataListObservable change, size: " + r4.size());
            this.a.h();
            return;
        }
    }

    /* JADX INFO: renamed from: qe2.c$c, reason: collision with other inner class name */
    public static final class C0161c<T> implements Consumer {
        public final /* synthetic */ c a;

        public C0161c(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("KtvSeatListDataCenter", "linkedUserMergeDataListObservable change, size: " + r4.size());
            this.a.h();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IVoiceLiveTheme r4 = (IVoiceLiveTheme) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "themeObservable change, " + r4);
            this.a.h();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.b r3 = (ch0.b) r2;
            c r4 = this.a;
            if (r4.a == false) goto L6;
            r4.h();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ c a;

        public f(c r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Map r3 = (Map) r2;
            Objects.toString(r3);
            this.a.c.onNext(r3);
        }
    }

    static {
    }

    public final List<ch0.e> c() {
        int r0 = g.a;
        if (g.a(e()) == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r1 = this.f;
        if (r1 == null) goto L26;
        BehaviorSubject r2 = r1.f();
        if (r2 == null) goto L26;
        List<ch0.e> r3 = (List) r2.getValue();
        if (r3 == null) goto L26;
        return r3;
    L26:
        return CollectionsKt.emptyList();
    L12:
        if (this.h == false) goto L17;
        ue0.c r4 = this.g;
        if (r4 == null) goto L28;
        return r4.o();
    L28:
        return CollectionsKt.emptyList();
    L17:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r5 = this.f;
        if (r5 == null) goto L24;
        BehaviorSubject r6 = r5.f();
        if (r6 == null) goto L24;
        List<ch0.e> r7 = (List) r6.getValue();
        if (r7 == null) goto L24;
        return r7;
    L24:
        return CollectionsKt.emptyList();
    }

    public final int e() {
        if (this.h == false) goto L14;
        ue0.c r0 = this.g;
        if (r0 == null) goto L8;
        int r1 = r0.l;
    L7:
        Integer r2 = Integer.valueOf(r1);
    L12:
        if (r2 != null) goto L19;
        return 0;
    L19:
        return r2.intValue();
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = this.f;
        if (r3 == null) goto L11;
        r1 = r3.getShowFrom();
        goto L7
    L11:
        r2 = null;
        goto L12
    L14:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = this.f;
        if (r4 != null) goto L17;
        return 0;
    L17:
        return r4.getShowFrom();
    }

    public final void f() {
        ALogger.i("KtvSeatListDataCenter", "onAttach, " + this);
        ue0.c r0 = this.g;
        if (r0 == null) goto L9;
        BehaviorSubject r1 = r0.b;
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new b(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, this.d);
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = this.f;
        if (r3 == null) goto L16;
        BehaviorSubject r4 = r3.f();
        if (r4 == null) goto L16;
        Disposable r5 = r4.subscribe(new C0161c(this));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.d);
    L16:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r6 = this.f;
        if (r6 == null) goto L23;
        BehaviorSubject r7 = r6.G0();
        if (r7 == null) goto L23;
        Disposable r8 = r7.subscribe(new d(this));
        if (r8 == null) goto L23;
        RxUtilKt.c(r8, this.d);
    L23:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r9 = this.f;
        if (r9 == null) goto L31;
        BehaviorSubject r10 = r9.o1();
        if (r10 == null) goto L31;
        Disposable r11 = r10.subscribe(new e(this));
        if (r11 == null) goto L31;
        RxUtilKt.c(r11, this.d);
    L31:
        if (g.a(0) == false) goto L39;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r12 = this.f;
        if (r12 == null) goto L39;
        BehaviorSubject r13 = r12.j1();
        if (r13 == null) goto L39;
        Disposable r14 = r13.subscribe(new f(this));
        if (r14 == null) goto L39;
        RxUtilKt.c(r14, this.d);
    L39:
        h();
        this.a = true;
    }

    public final void g() {
        ALogger.i("KtvSeatListDataCenter", "onDetach, " + this);
        CompositeDisposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.a = false;
    }

    public final void h() {
        ArrayList r0 = new ArrayList(9);
        int r3 = 0;
    L3:
        if (r3 >= 9) goto L5;
        r0.add(a(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        Iterator<ch0.e> r4 = c().iterator();
        int r5 = 0;
    L6:
        String r6 = null;
        if (r4.hasNext() == false) goto L24;
        ch0.e r7 = r4.next();
        ILinkPlayerInfoBridge r8 = r7.a;
        if (r8.getUser() == null) goto L6;
        MultiLinkGuestViewBinder.a r9 = new MultiLinkGuestViewBinder.a(r7, null, 62);
        IBaseUser r10 = r8.getUser();
        if (r10 == null) goto L13;
        String r11 = r10.getIdString();
    L14:
        IRoom r12 = this.e;
        if (r12 == null) goto L18;
        r6 = r12.getOwnerUserIdString();
    L18:
        if ((!Intrinsics.areEqual(r11, r6)) == false) goto L20;
        int r13 = r5 - 1;
    L21:
        ((tf0.e) r9).a = r13;
        if (r5 >= r0.size()) goto L6;
        ListProtector.set(r0, r5, r9);
        r5 = r5 + 1;
        goto L6
    L20:
        r13 = r5;
        goto L21
    L13:
        r11 = null;
        goto L14
    L24:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = this.f;
        if (r14 == null) goto L29;
        BehaviorSubject r15 = r14.V0();
        if (r15 == null) goto L29;
        Boolean r16 = (Boolean) r15.getValue();
    L30:
        boolean r17 = Intrinsics.areEqual(r16, Boolean.TRUE);
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r18 = this.f;
        if (r18 == null) goto L37;
        BehaviorSubject r19 = r18.o1();
        if (r19 == null) goto L37;
        ch0.b r20 = (ch0.b) r19.getValue();
        if (r20 == null) goto L37;
        IBaseUser r21 = r20.a;
    L38:
        if (r21 == null) goto L40;
        boolean r22 = true;
    L41:
        Iterator r23 = r0.iterator();
    L43:
        if (r23.hasNext() == false) goto L70;
        MultiLinkNormalEmptyViewBinder.a r24 = (tf0.e) r23.next();
        if ((r24 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L43;
        MultiLinkNormalEmptyViewBinder.a r25 = r24;
        Integer r26 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r26 != null) goto L50;
    L52:
        boolean r27 = false;
    L53:
        r25.m(r27);
        if (r22 == true) goto L55;
        if (r17 == false) goto L43;
        r25.k();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r28 = this.f;
        if (r28 == null) goto L70;
        r28.E0(false);
        goto L70
    L55:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r29 = this.f;
        if (r29 == null) goto L62;
        BehaviorSubject r30 = r29.o1();
        if (r30 == null) goto L62;
        ch0.b r31 = (ch0.b) r30.getValue();
        if (r31 == null) goto L62;
        ch0.b r32 = new ch0.b(r31.a, r31.b);
    L63:
        r25.j(r32);
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r33 = this.f;
        if (r33 == null) goto L70;
        r33.O0(new ch0.b(null, false));
    L62:
        r32 = null;
        goto L63
    L50:
        if (2 != r26.intValue()) goto L52;
        r27 = true;
    L70:
        int r2 = g.a;
        if (g.a(e()) == false) goto L78;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r34 = this.f;
        if (r34 == null) goto L87;
        BehaviorSubject r35 = r34.G0();
        if (r35 == null) goto L87;
        r6 = (IVoiceLiveTheme) r35.getValue();
    L87:
        Iterator r36 = r0.iterator();
    L89:
        if (r36.hasNext() == false) goto L91;
        tf0.e r37 = (tf0.e) r36.next();
        r37.c = r6;
        r37.h = this.e;
        r37.d = e();
        r37.e = 9;
        goto L89
    L91:
        this.b.onNext(r0);
        ALogger.i("KtvSeatListDataCenter", "updateAndNotifyUserList, size: " + r0.size());
        return;
    L78:
        if (this.h == false) goto L82;
        ue0.c r38 = this.g;
        if (r38 == null) goto L87;
        r6 = r38.m;
        goto L87
    L82:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r39 = this.f;
        if (r39 == null) goto L87;
        BehaviorSubject r40 = r39.G0();
        if (r40 == null) goto L87;
        r6 = (IVoiceLiveTheme) r40.getValue();
        goto L87
    L40:
        r22 = false;
    L37:
        r21 = null;
    L29:
        r16 = null;
        goto L30
    }

    public static MultiLinkNormalEmptyViewBinder.a a(int r12) {
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L8:
        boolean r7 = false;
    L10:
        return new MultiLinkNormalEmptyViewBinder.a(r12, null, null, false, false, r7, false, false, ThemedCompetitionContext.Companion.g(), 734);
    L6:
        if (2 != r0.intValue()) goto L8;
        r7 = true;
        goto L10
    }

    public static List b(List r11) {
        if (r11 == null) goto L17;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r11.iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        MultiLinkGuestViewBinder.a r5 = (tf0.e) r4;
        if ((r5 instanceof MultiLinkGuestViewBinder.a) == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        if (n.g(r5.k.a) == false) goto L12;
        r6 = true;
        goto L13
    L15:
        List r7 = CollectionsKt.toMutableList(r3);
        if (r7 == null) goto L17;
    L18:
        if (r11 == null) goto L39;
        ArrayList r8 = new ArrayList();
        Iterator r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L37;
        Object r9 = r12.next();
        MultiLinkGuestViewBinder.a r10 = (tf0.e) r9;
        boolean r13 = r10 instanceof MultiLinkGuestViewBinder.a;
        if (r13 == false) goto L27;
        g0 r14 = r10.k.a.getMicPosTagInfo();
        if (r14 == null) goto L27;
        long r15 = r14.getTagType();
    L28:
        if (r13 == true) goto L30;
    L34:
        boolean r16 = false;
    L35:
        if (r16 == false) goto L21;
        r8.add(r9);
        goto L21
    L30:
        if (r15 != 1) goto L34;
        if (n.g(r10.k.a) == true) goto L34;
        r16 = true;
    L27:
        r15 = 0;
        goto L28
    L37:
        Collection r17 = CollectionsKt.toMutableList(r8);
        if (r17 == null) goto L39;
    L40:
        r7.addAll(r17);
        return r7;
    L39:
        r17 = new ArrayList();
    L17:
        r7 = new ArrayList();
        goto L18
    }

    public static List d(List r11) {
        if (r11 == null) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L5:
        if (r12.hasNext() == false) goto L26;
        Object r1 = r12.next();
        MultiLinkGuestViewBinder.a r2 = (tf0.e) r1;
        boolean r3 = r2 instanceof MultiLinkGuestViewBinder.a;
        if (r3 == false) goto L9;
        g0 r4 = r2.k.a.getMicPosTagInfo();
    L10:
        boolean r5 = false;
        if (r4 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r3 == true) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == true) goto L24;
        if (r6 == true) goto L24;
        r5 = true;
    L24:
        if (r5 == false) goto L5;
        r0.add(r1);
        goto L5
    L18:
        if (n.g(r2.k.a) == false) goto L20;
        r7 = true;
        goto L21
    L13:
        if (r4.getTagType() != 1) goto L15;
        r6 = true;
        goto L16
    L9:
        r4 = null;
        goto L10
    L26:
        List r13 = CollectionsKt.toMutableList(r0);
        if (r13 == null) goto L29;
        return r13;
    L29:
        return new ArrayList();
    }

    public c(IRoom r1, com.bytedance.android.live.liveinteract.plantform.datamerge.d r2) {
        this.e = r1;
        this.f = r2;
        this.g = null;
        this.h = false;
        this.b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.c = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.d = new CompositeDisposable();
    }
}

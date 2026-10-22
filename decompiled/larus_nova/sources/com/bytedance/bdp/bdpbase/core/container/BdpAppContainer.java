package com.bytedance.bdp.bdpbase.core.container;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpAppContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StateEvent f201088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f201089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f201090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentActivity f201091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<a> f201092e;

    public static final enum StateEvent extends Enum<StateEvent> {
        public static final StateEvent INIT = null;
        public static final StateEvent ON_DESTROY = null;
        public static final StateEvent ON_PAUSE = null;
        public static final StateEvent ON_RESUME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StateEvent[] f201093a = null;

        static {
            StateEvent r100 = new StateEvent(ErrorCode.INIT, 0);
            INIT = r100;
            StateEvent r101 = new StateEvent("ON_RESUME", 1);
            ON_RESUME = r101;
            StateEvent r102 = new StateEvent("ON_PAUSE", 2);
            ON_PAUSE = r102;
            StateEvent r103 = new StateEvent("ON_DESTROY", 3);
            ON_DESTROY = r103;
            f201093a = new StateEvent[]{r100, r101, r102, r103};
        }

        public static StateEvent[] values() {
            return (StateEvent[]) f201093a.clone();
        }

        public static StateEvent valueOf(String r100) {
            return (StateEvent) r27.a.a(StateEvent.class, r100);
        }

        public StateEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void a() {
        StateEvent r100 = this.f201088a;
        StateEvent r101 = StateEvent.ON_DESTROY;
        if (r100 != r101) goto L5;
        return;
    L5:
        b(r101);
        this.f201091d = null;
        this.f201092e.clear();
    }

    public FragmentActivity getActivity() {
        if (this.f201088a == StateEvent.ON_DESTROY) goto L7;
        return this.f201091d;
    L7:
        throw new IllegalStateException("can not getActivity on destroyed BdpAppContainer");
    }

    public final void b(StateEvent r100) {
        this.f201088a = r100;
        Iterator<a> r101 = this.f201092e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    }

    public BdpAppContainer(ViewGroup r100, FragmentActivity r101) {
        this.f201088a = StateEvent.INIT;
        this.f201092e = new CopyOnWriteArraySet();
        this.f201089b = r100;
        this.f201091d = r101;
    }

    public BdpAppContainer(ViewGroup r100, ViewGroup r101, FragmentActivity r102) {
        this.f201088a = StateEvent.INIT;
        this.f201092e = new CopyOnWriteArraySet();
        this.f201089b = r100;
        this.f201091d = r102;
        this.f201090c = r101;
    }
}

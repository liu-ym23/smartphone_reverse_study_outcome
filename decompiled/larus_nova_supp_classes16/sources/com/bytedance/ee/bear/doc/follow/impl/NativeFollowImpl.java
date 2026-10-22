package com.bytedance.ee.bear.doc.follow.impl;

import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.FollowModuleStateAdapter;
import com.bytedance.ee.bear.doc.follow.event.ContentEvent;
import com.bytedance.ee.bear.doc.follow.event.PresenterLocationChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEventTypes;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NativeFollowImpl extends BaseFollowImpl implements NonProguard {
    private static final String PRESENTER_FOLLOWER_LOCATION = null;
    private py4.i followableContentHost;
    protected List<py4.g> followableContents;

    public class a implements py4.k<FollowModuleState> {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ NativeFollowImpl b;

        @Override // py4.k
        public final void b(NonProguard r2) {
            if ((r2 instanceof FollowModuleState) == false) goto L8;
            FollowModuleState r3 = (FollowModuleState) r2;
            if (r3 == null) goto L9;
            this.a.c(r3);
            return;
        L9:
            return;
        }

        public a(NativeFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // py4.k
        public final NonProguard a(Set r3, RNFollowEvent r4) {
            return (FollowModuleState) JSON.parseObject(r4.dataJson, FollowModuleState.class);
        L4:
            e = move-exception;
            tt5.a.e(this.b.TAG, "setStates err", e, false);
            return null;
        }
    }

    public class b implements py4.k<FollowModuleState> {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ NativeFollowImpl b;

        @Override // py4.k
        public final void b(NonProguard r2) {
            if ((r2 instanceof FollowModuleState) == false) goto L8;
            FollowModuleState r3 = (FollowModuleState) r2;
            if (r3 == null) goto L9;
            this.a.b(r3);
            return;
        L9:
            return;
        }

        public b(NativeFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // py4.k
        public final NonProguard a(Set r4, RNFollowEvent r5) {
            if (r5 == null) goto L13;
            return (FollowModuleState) JSON.parseObject(r5.dataJson, FollowModuleState.class);
        L7:
            e = move-exception;
            tt5.a.e(this.b.TAG, "updatePresenterState err", e, false);
            return null;
        L13:
            return null;
        }
    }

    public class c implements py4.h {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ NativeFollowImpl b;

        @Override // py4.h
        public final boolean a(ContentEvent r3) {
            if ((r3 instanceof PresenterLocationChangedEvent) == false) goto L7;
            this.b.dispatchPresenterLocationChangedEventToRN(this.a.getModule(), r3);
            return true;
        L7:
            return this.b.processContentEvent(r3);
        }

        @Override // py4.h
        public final void b(FollowModuleState r5) {
            this.b.getFollowBridge().g(this.b.documentToken, r5.module, RNFollowEventTypes.FOLLOW_ACTION.name(), FollowModuleStateAdapter.jsonString(r5));
        }

        public c(NativeFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d extends py4.i {
        public final /* synthetic */ NativeFollowImpl a;

        public d(NativeFollowImpl r1) {
            this.a = r1;
        }

        @Override // py4.i
        public final void a(sy4.d r4) {
            tt5.a.h(this.a.TAG, "registerDriveFollowStateObserver:" + r4);
            this.a.registerDocFollowStateObserver(r4);
        }

        @Override // py4.i
        public final void b(l65.e r5) {
            if (this.a.followableContents.contains(r5) == false) goto L6;
            tt5.a.k(this.a.TAG, "registerFollowableContent already exist ! (name=" + r5.getClass().getSimpleName() + ", module=" + r5.a + ")");
            return;
        L6:
            tt5.a.h(this.a.TAG, "registerFollowableContent: name=" + r5.getClass().getSimpleName() + ", module=" + r5.a);
            this.a.bindFollowableContent(r5);
        }

        @Override // py4.i
        public final void c(sy4.d r4) {
            tt5.a.h(this.a.TAG, "unregisterDriveFollowStateObserver:" + r4);
            this.a.unregisterDocFollowStateObserver(r4);
        }

        @Override // py4.i
        public final void d(l65.e r4) {
            tt5.a.h(this.a.TAG, "unregisterFollowableContent: name=" + r4.getClass().getSimpleName() + ", module=" + r4.a);
            NativeFollowImpl.access$100(this.a, r4);
        }
    }

    public static /* synthetic */ void x(py4.k r0, RNFollowEvent r1) {
        lambda$bindFollowableContent$1(r0, r1);
    }

    public static /* synthetic */ void y(py4.k r0, RNFollowEvent r1) {
        lambda$bindFollowableContent$0(r0, r1);
    }

    public /* bridge */ /* synthetic */ void registerPerfMonitor(py4.d.b r1) {
    }

    public /* bridge */ /* synthetic */ void unregisterPerfMonitor(py4.d.b r1) {
    }

    static {
        PRESENTER_FOLLOWER_LOCATION = "FOLLOW_EVENT:" + RNFollowEventTypes.PRESENTER_FOLLOWER_LOCATION.name();
    }

    private void clearPresenterState() {
        Iterator<py4.g> r0 = this.followableContents.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        updatePresenterState(r0.next(), null);
        goto L4
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void startReplay() {
        super.startReplay();
        clearPresenterState();
    }

    public py4.i getFollowableContentHost() {
        return this.followableContentHost;
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void stopRecord() {
        super.stopRecord();
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void stopReplay() {
        super.stopReplay();
    }

    private void unbindFollowableContent(py4.g r5) {
        this.followableContents.remove(r5);
        getFollowBridge().i(this.documentToken, r5.getModule(), RNFollowEventTypes.FOLLOW_REPLAY.name());
        getFollowBridge().i(this.documentToken, r5.getModule(), RNFollowEventTypes.PRESENTER_STATE.name());
    }

    public void bindFollowableContent(py4.g r7) {
        if (this.followableContents.contains(r7) == true) goto L5;
        this.followableContents.add(r7);
    L5:
        String r0 = r7.getModule();
        final a r1 = new a(this, r7);
        py4.a r2 = new py4.a(this.documentToken, r0, RNFollowEventTypes.FOLLOW_REPLAY.name(), false);
        getFollowBridge().j(r1, new u(r1), r2);
        final b r3 = new b(this, r7);
        py4.a r4 = new py4.a(this.documentToken, r0, RNFollowEventTypes.PRESENTER_STATE.name(), false);
        getFollowBridge().j(r3, new v(r3), r4);
        r7.a(new c(this, r7));
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl, py4.d
    public void setAudioMute(boolean r1) {
        super.setAudioMute(r1);
    }

    public static /* synthetic */ void access$100(NativeFollowImpl r0, py4.g r1) {
        r0.unbindFollowableContent(r1);
    }

    private static /* synthetic */ void lambda$bindFollowableContent$0(py4.k r1, RNFollowEvent r2) {
        FollowModuleState r3 = (FollowModuleState) r1.a(null, r2);
        if (r3 == null) goto L6;
        r1.b(r3);
        return;
    }

    private static /* synthetic */ void lambda$bindFollowableContent$1(py4.k r1, RNFollowEvent r2) {
        FollowModuleState r3 = (FollowModuleState) r1.a(null, r2);
        if (r3 == null) goto L6;
        r1.b(r3);
        return;
    }

    private void updatePresenterState(py4.g r3, RNFollowEvent r4) {
        if (r4 != null) goto L10;
        FollowModuleState r5 = null;
    L5:
        r3.b(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e(this.TAG, "setStates err", e, false);
        return;
    L10:
        r5 = (FollowModuleState) JSON.parseObject(r4.dataJson, FollowModuleState.class);     // Catch: Exception -> L7
        goto L5
    }

    public void dispatchPresenterLocationChangedEventToRN(String r4, ContentEvent r5) {
        getFollowBridge().g(this.documentToken, r4, PRESENTER_FOLLOWER_LOCATION, JSON.toJSONString(r5));
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void startRecord(py4.d.a r1, String[] r2) {
        super.startRecord(r1, r2);
        clearPresenterState();
    }

    public NativeFollowImpl(Fragment r2, String r3, com.bytedance.ee.bear.doc.follow.impl.d r4) {
        super(r2, r3, 12, r4);
        this.followableContents = new ArrayList();
        this.followableContentHost = new d(this);
    }

    public static <T extends com.bytedance.ee.bear.doc.follow.impl.d> NativeFollowImpl newFollowImpl(Fragment r1, String r2, T r3) {
        return new NativeFollowImpl(r1, r2, r3);
    }
}

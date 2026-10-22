package com.bytedance.ee.bear.doc.follow.impl;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.FollowModuleStateAdapter;
import com.bytedance.ee.bear.doc.follow.FollowModuleStateArrayAdapter;
import com.bytedance.ee.bear.doc.follow.FollowModuleStateMap;
import com.bytedance.ee.bear.doc.follow.event.ContentEvent;
import com.bytedance.ee.bear.doc.follow.event.PresenterLocationChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEventTypes;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AttachmentFollowImpl extends NativeFollowImpl {
    private static final String KEY_DRIVE_UPDATE_MAP = "driveUpdateMap";
    private static final String KEY_DRIVE_UPDATE_RECORD_MAP = "driveUpdateRecordIdMap";
    private static final String MODULE_NAME_ATTACHMENT_BLOCK = "DocxBoxPreview";
    private final boolean isBlockPreview;
    private final String mountNodeToken;

    public class a implements py4.k<FollowModuleStateMap> {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ AttachmentFollowImpl b;

        @Override // py4.k
        public final void b(NonProguard r2) {
            if ((r2 instanceof FollowModuleStateMap) == false) goto L8;
            FollowModuleState r3 = ((FollowModuleStateMap) r2).followModuleStateMap.get(AttachmentFollowImpl.access$100(this.b));
            if (r3 == null) goto L9;
            this.a.c(r3);
            return;
        L9:
            return;
        }

        public a(AttachmentFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // py4.k
        public final NonProguard a(Set r3, RNFollowEvent r4) {
            return AttachmentFollowImpl.access$000(this.b, r3, r4);
        L4:
            e = move-exception;
            tt5.a.e(this.b.TAG, "setStates err", e, false);
            return null;
        }
    }

    public class b implements py4.k<FollowModuleStateMap> {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ AttachmentFollowImpl b;

        @Override // py4.k
        public final void b(NonProguard r2) {
            if ((r2 instanceof FollowModuleStateMap) == false) goto L8;
            FollowModuleState r3 = ((FollowModuleStateMap) r2).followModuleStateMap.get(AttachmentFollowImpl.access$100(this.b));
            if (r3 == null) goto L9;
            this.a.b(r3);
            return;
        L9:
            return;
        }

        public b(AttachmentFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // py4.k
        public final NonProguard a(Set r3, RNFollowEvent r4) {
            return AttachmentFollowImpl.access$000(this.b, r3, r4);
        L4:
            e = move-exception;
            tt5.a.e(this.b.TAG, "updatePresenterState err", e, false);
            return null;
        }
    }

    public class c implements py4.h {
        public final /* synthetic */ py4.g a;
        public final /* synthetic */ AttachmentFollowImpl b;

        @Override // py4.h
        public final boolean a(ContentEvent r3) {
            if ((r3 instanceof PresenterLocationChangedEvent) == false) goto L7;
            this.b.dispatchPresenterLocationChangedEventToRN(this.a.getModule(), r3);
            return true;
        L7:
            return this.b.processContentEvent(r3);
        }

        @Override // py4.h
        public final void b(FollowModuleState r6) {
            this.b.getFollowBridge().g(this.b.documentToken, r6.module, RNFollowEventTypes.FOLLOW_ACTION.name(), AttachmentFollowImpl.access$200(this.b, r6));
        }

        public c(AttachmentFollowImpl r1, py4.g r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ void A(AttachmentFollowImpl r0, py4.k r1, RNFollowEvent r2) {
        r0.lambda$bindFollowableContent$0(r1, r2);
    }

    public static /* synthetic */ void z(AttachmentFollowImpl r0, py4.k r1, RNFollowEvent r2) {
        r0.lambda$bindFollowableContent$1(r1, r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void registerBaseRNEventHandler() {
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.NativeFollowImpl
    public /* bridge */ /* synthetic */ void registerPerfMonitor(py4.d.b r1) {
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.NativeFollowImpl
    public /* bridge */ /* synthetic */ void unregisterPerfMonitor(py4.d.b r1) {
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl
    public void unregisterBaseRNEventHandler() {
        getFollowBridge().i(this.documentToken, "", RNFollowEventTypes.NEW_ACTIONS.name());
        getFollowBridge().i(this.documentToken, "", RNFollowEventTypes.NEW_PATCHES.name());
        getFollowBridge().i(this.documentToken, "", RNFollowEventTypes.PRESENTER_FOLLOWER_LOCATION.name());
        if (this.isBlockPreview == false) goto L8;
        r r0 = this.followApiV2Delegate;
        if (r0 == null) goto L9;
        String r1 = this.mountNodeToken;
        ((CopyOnWriteArraySet) r0.c).remove(r1);
        return;
    L9:
        return;
    }

    public static /* synthetic */ String access$100(AttachmentFollowImpl r0) {
        return r0.mountNodeToken;
    }

    private String generatePresenterJson(FollowModuleState r3) {
        if (MODULE_NAME_ATTACHMENT_BLOCK.equals(r3.module) == false) goto L7;
        return FollowModuleStateArrayAdapter.jsonString(KEY_DRIVE_UPDATE_RECORD_MAP, this.mountNodeToken, r3);
    L7:
        return FollowModuleStateAdapter.jsonString(r3);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.NativeFollowImpl
    public void bindFollowableContent(py4.g r7) {
        if (this.followableContents.contains(r7) == true) goto L5;
        this.followableContents.add(r7);
    L5:
        String r0 = r7.getModule();
        final a r1 = new a(this, r7);
        py4.a r2 = new py4.a(this.documentToken, r0, RNFollowEventTypes.FOLLOW_REPLAY.name(), false);
        getFollowBridge().j(r1, new com.bytedance.ee.bear.doc.follow.impl.a(this, r1), r2);
        final b r3 = new b(this, r7);
        py4.a r4 = new py4.a(this.documentToken, r0, RNFollowEventTypes.PRESENTER_STATE.name(), false);
        getFollowBridge().j(r3, new com.bytedance.ee.bear.doc.follow.impl.b(this, r3), r4);
        r7.a(new c(this, r7));
    }

    public static /* synthetic */ String access$200(AttachmentFollowImpl r0, FollowModuleState r1) {
        return r0.generatePresenterJson(r1);
    }

    private FollowModuleStateMap generateFollowModuleStateMap(Set<String> r8, RNFollowEvent r9) {
        List r10 = JSON.parseArray(r9.dataJson, FollowModuleState.class);
        FollowModuleStateMap r0 = new FollowModuleStateMap();
        Iterator<String> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        String r1 = r11.next();
        if (TextUtils.isEmpty(r1) == true) goto L4;
        Iterator r2 = r10.iterator();
    L10:
        if (r2.hasNext() == false) goto L4;
        FollowModuleState r3 = (FollowModuleState) r2.next();
        JSONObject r4 = JSON.parseObject(r3.data).getJSONObject(KEY_DRIVE_UPDATE_RECORD_MAP);
        FollowModuleState r5 = new FollowModuleState();
        r5.module = r3.module;
        r5.actionType = r3.actionType;
        if (r4 == null) goto L16;
        String r6 = r4.getString(r1);
        if (r6 == null) goto L16;
        r5.data = r6;
    L17:
        r0.addFollowModuleState(r1, r5);
    L16:
        r5.data = r3.data;
        goto L17
    L18:
        return r0;
    }

    private /* synthetic */ void lambda$bindFollowableContent$0(py4.k r3, RNFollowEvent r4) {
        FollowModuleStateMap r5 = (FollowModuleStateMap) r3.a(new HashSet(Collections.singleton(this.mountNodeToken)), r4);
        if (r5 == null) goto L6;
        r3.b(r5);
        return;
    }

    private /* synthetic */ void lambda$bindFollowableContent$1(py4.k r3, RNFollowEvent r4) {
        FollowModuleStateMap r5 = (FollowModuleStateMap) r3.a(new HashSet(Collections.singleton(this.mountNodeToken)), r4);
        if (r5 == null) goto L6;
        r3.b(r5);
        return;
    }

    public static /* synthetic */ FollowModuleStateMap access$000(AttachmentFollowImpl r0, Set r1, RNFollowEvent r2) {
        return r0.generateFollowModuleStateMap(r1, r2);
    }

    private AttachmentFollowImpl(Fragment r1, String r2, String r3, d r4, boolean r5) {
        super(r1, r2, r4);
        this.mountNodeToken = r3;
        this.isBlockPreview = r5;
        r r6 = this.followApiV2Delegate;
        if (r6 == null) goto L5;
        ((CopyOnWriteArraySet) r6.c).add(r3);
    L5:
        r4.a = this;
    }

    public static <T extends d> AttachmentFollowImpl newFollowImpl(Fragment r7, String r8, String r9, T r10, boolean r11) {
        return new AttachmentFollowImpl(r7, r8, r9, r10, r11);
    }
}

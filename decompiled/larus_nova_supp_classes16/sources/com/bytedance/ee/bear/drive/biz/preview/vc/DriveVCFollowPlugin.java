package com.bytedance.ee.bear.drive.biz.preview.vc;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.doc.follow.event.TitleChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.AttachmentFollowImpl;
import com.bytedance.ee.bear.doc.follow.impl.NativeFollowImpl;
import com.bytedance.ee.bear.drive.biz.docplugin.AttachmentFollowVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.DownLoadState;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/vc/DriveVCFollowPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/IVCFollowManagerAbility;", "<init>", "()V", "mVCFollowManager", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/VCFollowManager;", "mMeetingId", "", "mVCFollowUUID", "mIsVCFollowRefresh", "", "Ljava/lang/Boolean;", "mCallback", "Lcom/bytedance/ee/bear/drive/biz/docplugin/ICallback;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "getVcManager", "onAttachPreview", "getVCFollowManager", "attachmentFollowVM", "Lcom/bytedance/ee/bear/drive/biz/docplugin/AttachmentFollowVM;", "fileBlockStateObserver", "Landroidx/lifecycle/Observer;", "getFileBlockStateObserver", "()Landroidx/lifecycle/Observer;", "onDetachPreview", "onBackPressed", "followDocumentInfoObserver", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/DriveFollowDocumentInfo;", "observeFollowDocumentInfo", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVCFollowPlugin extends AbsDrivePlugin implements sa5.d, com.bytedance.ee.bear.browser.plugin.i {
    public static final a Companion = null;
    public static final String TAG = "DriveVCPlugin";
    private final Observer<Boolean> fileBlockStateObserver;
    private final Observer<l65.d> followDocumentInfoObserver;
    private com.bytedance.ee.bear.drive.biz.docplugin.d mCallback;
    private Boolean mIsVCFollowRefresh;
    private String mMeetingId;
    private l65.i mVCFollowManager;
    private String mVCFollowUUID;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public b(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            boolean r5 = ((Boolean) r4).booleanValue();
            DriveVCFollowPlugin r0 = this.a;
            int r1 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
            if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r0.getHost().c.getBizType()) == false) goto L25;
            l65.i r2 = DriveVCFollowPlugin.access$getMVCFollowManager$p(r0);
            if (r2 == null) goto L8;
            r2.j = Boolean.valueOf(r5);
        L8:
            l65.i r3 = DriveVCFollowPlugin.access$getMVCFollowManager$p(r0);
            if (r3 == null) goto L17;
            List<com.bytedance.ee.bear.drive.biz.preview.vc.connector.d> r6 = r3.i;
            if (r6 == null) goto L17;
            Iterator r7 = ((ArrayList) r6).iterator();
        L14:
            if (r7.hasNext() == false) goto L17;
            ((com.bytedance.ee.bear.drive.biz.preview.vc.connector.d) r7.next()).onChanged(r5);
        L17:
            if (r0.getHost().c.fromBlockPreview() == true) goto L19;
            return;
        L19:
            if ((r0.getHost().c.getOpenEntity() instanceof SpaceThirdPartyOpenEntity) == false) goto L24;
            tt5.a.h(DriveVCFollowPlugin.TAG, "fileBlock state changed!");
            BaseOpenEntity r8 = r0.getHost().c.getOpenEntity();
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity");
            MutableLiveData<Pair<Boolean, SpaceThirdPartyOpenEntity>> r9 = r0.attachmentFollowVM().getFileBlockPresenterState();
            Boolean r10 = Boolean.valueOf(r5);
            r9.postValue(new Pair(r10, (SpaceThirdPartyOpenEntity) r8));
            return;
        L24:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public c(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            l65.d r4 = (l65.d) r3;
            if (r4 == null) goto L10;
            l65.i r0 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r0 == null) goto L9;
            r0.a(r4.a, r4.b);
            return;
        L9:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public d(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.onBackPressed();
        }
    }

    public static final class e extends sy4.c {
        public final /* synthetic */ DriveVCFollowPlugin b;

        @Override // sy4.c
        public final View c() {
            View r0 = this.b.findViewById(2131370319);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return DriveVCFollowPlugin.access$getTitleBar(this.b).getTitleBarLayout();
        }

        public e(DriveVCFollowPlugin r1) {
            this.b = r1;
        }

        @Override // sy4.c, sy4.d
        public final void a(sy4.b r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            l65.i r0 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.b);
            if (r0 == null) goto L11;
            List<l65.e> r1 = r0.g.d;
            if (r1 == null) goto L11;
            Iterator r2 = ((CopyOnWriteArrayList) r1).iterator();
        L8:
            if (r2.hasNext() == false) goto L11;
            ((l65.e) r2.next()).d(r5);
        L11:
            if ((r5 instanceof sy4.f) == false) goto L19;
            StringBuilder r3 = new StringBuilder("isGuest=");
            sy4.f r4 = (sy4.f) r5;
            r3.append(r4.b);
            tt5.a.h(DriveVCFollowPlugin.TAG, r3.toString());
            super.a(r5);
            if (r4.b == true) goto L15;
            return;
        L15:
            if (DriveVCFollowPlugin.access$isUIContainerDetached(this.b) == false) goto L17;
            return;
        L17:
            ((DriveVCFollowVM) DriveVCFollowPlugin.access$viewModel(this.b, DriveVCFollowVM.class)).getLiveIsGuest().postValue(Boolean.TRUE);
            return;
        L19:
            if ((r5 instanceof sy4.e) == false) goto L22;
            StringBuilder r6 = new StringBuilder("isPresenter=");
            sy4.e r7 = (sy4.e) r5;
            r6.append(r7.a);
            tt5.a.h(DriveVCFollowPlugin.TAG, r6.toString());
            DriveVCFollowVM r8 = (DriveVCFollowVM) DriveVCFollowPlugin.access$viewModel(this.b, DriveVCFollowVM.class);
            r8.getLiveIsPresenter().setValue(Boolean.valueOf(r7.a));
            r8.getLiveIsReplay().setValue(Boolean.valueOf(r7.b));
            return;
        L22:
            if ((r5 instanceof sy4.a) == false) goto L29;
            StringBuilder r9 = new StringBuilder("mute=");
            sy4.a r10 = (sy4.a) r5;
            r9.append(r10.a);
            tt5.a.h(DriveVCFollowPlugin.TAG, r9.toString());
            ((DriveVCFollowVM) DriveVCFollowPlugin.access$viewModel(this.b, DriveVCFollowVM.class)).getLiveIsMuted().setValue(Boolean.valueOf(r10.a));
            return;
        }
    }

    public static final class f implements sy4.c.b {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public f(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        @Override // sy4.c.b
        public final boolean a(sy4.b r1) {
            if (this.a.getHost().c.isInBlockFullScreenState() == true) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final class g implements sy4.c.b {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public g(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        @Override // sy4.c.b
        public final boolean a(sy4.b r2) {
            return Intrinsics.areEqual(k75.a.i(this.a.getHost()).liveInnerIsPresentationMode().getValue(), Boolean.TRUE);
        }
    }

    public static final class h extends u75.b.C0306b {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public h(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r3) {
            Intrinsics.checkNotNullParameter(r3, "previewFileModel");
            l65.i r4 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r4 == null) goto L10;
            List<l65.e> r5 = r4.g.d;
            if (r5 == null) goto L12;
            Iterator<T> r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L13;
            ((l65.e) r6.next()).h(DownLoadState.LoadSuccess);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            l65.i r4 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r4 == null) goto L10;
            List<l65.e> r5 = r4.g.d;
            if (r5 == null) goto L10;
            Iterator<T> r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            ((l65.e) r6.next()).h(DownLoadState.LoadFail);
        L10:
            l65.i r7 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r7 == null) goto L16;
            Iterator r8 = ((CopyOnWriteArrayList) r7.g.d).iterator();
        L14:
            if (r8.hasNext() == false) goto L19;
            ((l65.e) r8.next()).c = true;
            goto L14
        L19:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void onProgress(int r3) {
            l65.i r4 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r4 == null) goto L10;
            List<l65.e> r5 = r4.g.d;
            if (r5 == null) goto L12;
            Iterator<T> r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L13;
            ((l65.e) r6.next()).h(DownLoadState.Loading);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 != InfoCode.HitCache) goto L12;
            l65.i r4 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r4 == null) goto L14;
            List<l65.e> r5 = r4.g.d;
            if (r5 == null) goto L15;
            Iterator<T> r6 = r5.iterator();
        L10:
            if (r6.hasNext() == false) goto L16;
            ((l65.e) r6.next()).h(DownLoadState.LoadSuccess);
            goto L10
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveVCFollowPlugin a;

        public i(DriveVCFollowPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            l65.i r0 = DriveVCFollowPlugin.access$getMVCFollowManager$p(this.a);
            if (r0 == null) goto L12;
            List<l65.e> r1 = r0.g.d;
            if (r1 == null) goto L18;
            Iterator r2 = ((CopyOnWriteArrayList) r1).iterator();
        L8:
            if (r2.hasNext() == false) goto L19;
            l65.e r3 = (l65.e) r2.next();
            if (r3.d == null) goto L8;
            TitleChangedEvent r6 = new TitleChangedEvent(r5);
            py4.h r7 = r3.d;
            Intrinsics.checkNotNull(r7);
            r7.a(r6);
            goto L8
        L19:
            return;
        L18:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void observeFollowDocumentInfo() {
        MutableLiveData<l65.d> r0 = ((DriveVCFollowVM) viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo();
        r0.removeObserver(this.followDocumentInfoObserver);
        r0.observe(getLifecycleOwner(), this.followDocumentInfoObserver);
    }

    public final AttachmentFollowVM attachmentFollowVM() {
        return (AttachmentFollowVM) new ViewModelProvider(getActivity()).get(this.mVCFollowUUID, AttachmentFollowVM.class);
    }

    public DriveVCFollowPlugin() {
        this.mVCFollowUUID = "";
        this.fileBlockStateObserver = new b(this);
        this.followDocumentInfoObserver = new c(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        getTitleBar().getTitleBarLayout().setLeftClickListener(new d(this));
        boolean r0 = getHost().c.fromBlockPreview();
        BaseOpenEntity r1 = getHost().c.getOpenEntity();
        int r2 = r1.getBizType();
        String r3 = r1.getFileId();
        if ((r1 instanceof BaseSpaceOpenEntity) == false) goto L5;
        String r4 = ((BaseSpaceOpenEntity) r1).getMountNodeToken();
    L6:
        AttachmentFollowVM r5 = attachmentFollowVM();
        StringBuilder r6 = new StringBuilder("isBlockPreview=");
        r6.append(r0);
        r6.append(", isAttachmentBizType=");
        int r7 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        r6.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r2));
        r6.append(", attachmentFollowVM=");
        r6.append(r5);
        tt5.a.h(TAG, r6.toString());
        l65.i r8 = new l65.i(r2, r0, r5, r4);
        this.mVCFollowManager = r8;
        r8.h = new e(this);
        l65.i r9 = this.mVCFollowManager;
        if (r9 == null) goto L10;
        String r10 = this.mMeetingId;
        r9.b = true;
        t85.h r11 = new t85.h(true, r10);
        o75.b.a().Ke().h = r11;
        o75.b.a().Tb().d = r11;
    L10:
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r2) == true) goto L12;
        com.bytedance.ee.bear.doc.follow.impl.d r12 = new ry4.e();
    L13:
        Intrinsics.checkNotNullParameter(r12, "adapter");
        l65.i r13 = this.mVCFollowManager;
        if (r13 == null) goto L29;
        Fragment r14 = getLifecycleOwner();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment r16 = r14;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r2) == false) goto L18;
        NativeFollowImpl r17 = AttachmentFollowImpl.newFollowImpl(r16, r3, r4, r12, r0);
    L19:
        Intrinsics.checkNotNullParameter(r17, "nativeFollow");
        r13.c = r17.isPresenter();
        r13.d = r17.isAudioMuted();
        py4.i r18 = r17.getFollowableContentHost();
        r13.f = r18;
        l65.f r19 = r13.g;
        if (r18 != null) goto L22;
        r19.getClass();
    L26:
        py4.i r20 = r13.f;
        if (r20 == null) goto L29;
        r20.a(r13.h);
        goto L29
    L22:
        Iterator r21 = ((CopyOnWriteArrayList) r19.d).iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        r18.b((l65.e) r21.next());
        goto L24
    L18:
        r17 = NativeFollowImpl.newFollowImpl(r16, r3, r12);
    L29:
        DriveVCFollowVM r22 = (DriveVCFollowVM) viewModel(DriveVCFollowVM.class);
        MutableLiveData<Boolean> r23 = r22.getLiveIsPresenter();
        l65.i r24 = this.mVCFollowManager;
        sy4.c r26 = null;
        if (r24 == null) goto L32;
        Boolean r27 = Boolean.valueOf(r24.c);
    L33:
        r23.setValue(r27);
        MutableLiveData<Boolean> r28 = r22.getLiveIsMuted();
        l65.i r29 = this.mVCFollowManager;
        if (r29 == null) goto L36;
        Boolean r30 = Boolean.valueOf(r29.d);
    L37:
        r28.setValue(r30);
        r22.getLiveBizType().setValue(Integer.valueOf(r2));
        MutableLiveData<Boolean> r31 = r22.getLiveIsVCFollowMode();
        Boolean r32 = Boolean.TRUE;
        r31.setValue(r32);
        if (this.mVCFollowManager == null) goto L40;
        Intrinsics.areEqual(this.mIsVCFollowRefresh, r32);
    L40:
        PreviewViewModel r33 = k75.a.i(getHost());
        l65.i r34 = this.mVCFollowManager;
        if (r34 != null) goto L43;
    L45:
        boolean r36 = false;
    L46:
        r33.setVCFollowMode(r36);
        ((com.bytedance.ee.bear.document.titlebar.a) org.koin.java.a.c(com.bytedance.ee.bear.document.titlebar.a.class, null, null, 6)).a();
        int r37 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r2) == false) goto L62;
        getTitleBar().setLeftIconVisibility(true);
        getTitleBar().setTitleVisibility(true);
        l65.i r38 = this.mVCFollowManager;
        if (r38 == null) goto L51;
        sy4.d r39 = r38.h;
    L53:
        if ((r39 instanceof sy4.c) == false) goto L76;
        if (r38 == null) goto L56;
        sy4.d r40 = r38.h;
    L58:
        if ((r40 instanceof sy4.c) == false) goto L60;
        r26 = (sy4.c) r40;
    L60:
        if (r26 == null) goto L76;
        r26.b(new f(this));
        goto L76
    L56:
        r40 = null;
    L76:
        r5.getFileBlockState().observe(getLifecycleOwner(), this.fileBlockStateObserver);
        return;
    L51:
        r39 = null;
        goto L53
    L62:
        getTitleBar().setLeftIconVisibility(false);
        l65.i r41 = this.mVCFollowManager;
        if (r41 == null) goto L65;
        sy4.d r42 = r41.h;
    L67:
        if ((r42 instanceof sy4.c) == false) goto L76;
        if (r41 == null) goto L70;
        sy4.d r43 = r41.h;
    L72:
        if ((r43 instanceof sy4.c) == false) goto L74;
        r26 = (sy4.c) r43;
    L74:
        if (r26 == null) goto L76;
        r26.b(new g(this));
        goto L76
    L70:
        r43 = null;
        goto L72
    L65:
        r42 = null;
        goto L67
    L43:
        if (r34.b != true) goto L45;
        r36 = true;
        goto L46
    L36:
        r30 = null;
        goto L37
    L32:
        r27 = null;
        goto L33
    L12:
        r12 = new l65.c(r3, this.mVCFollowUUID);
        goto L13
    L5:
        r4 = "";
        goto L6
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        return k75.a.f(getHost(), this.mCallback);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        attachmentFollowVM().getFileBlockState().removeObserver(this.fileBlockStateObserver);
        l65.i r0 = this.mVCFollowManager;
        if (r0 == null) goto L16;
        r0.k = true;
        l65.f r1 = r0.g;
        py4.i r2 = r0.f;
        if (r2 != null) goto L7;
        r1.getClass();
    L11:
        py4.i r3 = r0.f;
        if (r3 == null) goto L17;
        r3.c(r0.h);
        return;
    L17:
        return;
    L7:
        Iterator r4 = ((CopyOnWriteArrayList) r1.d).iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        l65.e r5 = (l65.e) r4.next();
        r5.onDetach();
        r2.d(r5);
        goto L9
    }

    public final Observer<Boolean> getFileBlockStateObserver() {
        return this.fileBlockStateObserver;
    }

    public l65.i getVCFollowManager() {
        return this.mVCFollowManager;
    }

    @Deprecated(message = "Use IVCFollowManagerAbility instead.")
    public l65.i getVcManager() {
        return this.mVCFollowManager;
    }

    public static final /* synthetic */ l65.i access$getMVCFollowManager$p(DriveVCFollowPlugin r0) {
        return r0.mVCFollowManager;
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DriveVCFollowPlugin r0) {
        return r0.getTitleBar();
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveVCFollowPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onAttachToHost(r6);
        Bundle r1 = r6.c.getArgs();     // Catch: Exception -> L23
        String r2 = "";
        IBinder r3 = null;
        if (r1 == null) goto L7;
        String r4 = r1.getString("vc_follow_meeting_id", "");     // Catch: Exception -> L23
    L8:
        this.mMeetingId = r4;     // Catch: Exception -> L23
        Bundle r5 = r6.c.getArgs();     // Catch: Exception -> L23
        if (r5 == null) goto L14;
        String r7 = r5.getString("vc_follow_uuid", "");     // Catch: Exception -> L23
        if (r7 == null) goto L14;
        r2 = r7;
    L14:
        this.mVCFollowUUID = r2;     // Catch: Exception -> L23
        Bundle r8 = r6.c.getArgs();     // Catch: Exception -> L23
        if (r8 == null) goto L17;
        Boolean r9 = Boolean.valueOf(r8.getBoolean("vc_follow_refresh", false));     // Catch: Exception -> L23
    L18:
        this.mIsVCFollowRefresh = r9;     // Catch: Exception -> L23
        Bundle r10 = r6.c.getArgs();     // Catch: Exception -> L23
        if (r10 == null) goto L21;
        r3 = r10.getBinder("drive_uistate_callback");     // Catch: Exception -> L23
    L21:
        this.mCallback = (com.bytedance.ee.bear.drive.biz.docplugin.d) r3;     // Catch: Exception -> L23
    L26:
        if (r6.c.isVCFollowMode() == false) goto L30;
        View r0 = findViewById(2131379453);
        if (r0 == null) goto L30;
        r0.setBackgroundColor(getResources().getColor(2131106521));
    L30:
        r6.c().c(new h(this));
        r6.c.liveFileName().observe(getLifecycleOwner(), new i(this));
        r6.registerHostAbility(this);
        observeFollowDocumentInfo();
        return;
    L17:
        r9 = null;
        goto L18
    L7:
        r4 = null;
    L23:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        goto L26
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveVCFollowPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}

package com.bytedance.ee.bear.drive.biz.preview.more.download.im;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu;
import com.larksuite.component.universe_design.progress.UDProgress;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\n\u0010\u001b\u001a\u00060\u000fR\u00020\u0000H\u0002J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0019J\u0016\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0012H\u0002J\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003¢\u0006\u0002\u0010&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\r\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u000fR\u00020\u00000\u000ej\f\u0012\b\u0012\u00060\u000fR\u00020\u0000`\u00100\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/im/DriveImFileDownloadVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveDownload", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DownloadingViewState;", "getLiveDownload", "()Landroidx/lifecycle/MutableLiveData;", "downloadRootViewTag", "", "mDownloadMenuBinderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ee/bear/drivesdk/plugin/model/menu/DownloadMenu;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/drive/biz/preview/more/download/im/DriveImFileDownloadVM$BinderDownloadUpdater;", "Lkotlin/collections/ArrayList;", "findDownloadRootView", "Landroid/view/View;", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveMenuClickContext;", "instanceDownloadRootView", "menuContext", "Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveMenuInfoContext;", "addBinderProxyDownloadUpdater", "", "menuAction", "binderDownloadUpdater", "initDownloadActionsInterface", "releaseDownloadActionsInterface", "handleFileDownloadMenuClick", "showDownloadContentViewIfNeed", "downloadRootView", "showNormalTips", "textView", "Landroid/widget/TextView;", "fileSize", "", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "Companion", "BinderDownloadUpdater", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileDownloadVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveSdk";
    private final int downloadRootViewTag;
    private final MutableLiveData<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> liveDownload;
    private ConcurrentHashMap<DownloadMenu, ArrayList<BinderDownloadUpdater>> mDownloadMenuBinderMap;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/im/DriveImFileDownloadVM$BinderDownloadUpdater;", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/BinderProxyDownloadUpdater$Stub;", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveMenuClickContext;", "menuContext", "Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveMenuInfoContext;", "<init>", "(Lcom/bytedance/ee/bear/drive/biz/preview/more/download/im/DriveImFileDownloadVM;Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveMenuClickContext;Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveMenuInfoContext;)V", "actionRef", "Ljava/lang/ref/WeakReference;", "menuContextRef", "showDownloadingView", "", "appId", "", "uniqueId", "onDownloadingProgressChange", "progress", "", "hideDownloadingView", "onFailed", "msg", "postViewState", "state", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DownloadingViewState;", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BinderDownloadUpdater extends BinderProxyDownloadUpdater.Stub {
        private final WeakReference<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b> actionRef;
        private final WeakReference<e65.a> menuContextRef;
        final /* synthetic */ DriveImFileDownloadVM this$0;

        public String toString() {
            return "BinderDownloadUpdater(actionRef=" + this.actionRef.hashCode() + ", menuContextRef=" + this.menuContextRef.hashCode() + ')';
        }

        private final void postViewState(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a r2) {
            e65.a r0 = this.menuContextRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.d.getLiveDownload().postValue(r2);
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater.Stub, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public void hideDownloadingView(String r4, String r5) {
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.actionRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            tt5.a.h(DriveImFileDownloadVM.TAG, "BinderDownloadUpdater#setBinderProxyDownloadUpdater hideDownloadingView(), appId= " + r4 + ", uniqueId= " + r5 + ", isActive= " + com.bytedance.ee.util.ui.b.a(r0.getActivity()));
            postViewState(new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a(3));
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater.Stub, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public void showDownloadingView(String r4, String r5) {
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.actionRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            tt5.a.h(DriveImFileDownloadVM.TAG, "BinderDownloadUpdater#setBinderProxyDownloadUpdater showDownloadingView(), appId= " + r4 + ", uniqueId= " + r5 + ", isActive= " + com.bytedance.ee.util.ui.b.a(r0.getActivity()));
            postViewState(new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a(1));
        }

        public BinderDownloadUpdater(DriveImFileDownloadVM r2, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r3, e65.a r4) {
            Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
            Intrinsics.checkNotNullParameter(r4, "menuContext");
            this.this$0 = r2;
            this.actionRef = new WeakReference(r3);
            this.menuContextRef = new WeakReference(r4);
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater.Stub, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public void onDownloadingProgressChange(String r4, String r5, int r6) {
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.actionRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            tt5.a.h(DriveImFileDownloadVM.TAG, "BinderDownloadUpdater#setBinderProxyDownloadUpdater onDownloadingProgressChange(), appId= " + r4 + ", uniqueId= " + r5 + ", progress= " + r6 + ", isActive= " + com.bytedance.ee.util.ui.b.a(r0.getActivity()));
            postViewState(new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a(r6, 0));
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater.Stub, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public void onFailed(String r4, String r5, String r6) {
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.actionRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            tt5.a.h(DriveImFileDownloadVM.TAG, "BinderDownloadUpdater#setBinderProxyDownloadUpdater onFailed(), appId= " + r4 + ", uniqueId= " + r5 + ", msg= " + r6 + ", isActive= " + com.bytedance.ee.util.ui.b.a(r0.getActivity()));
            postViewState(new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a(r6));
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ e65.a a;

        public b(e65.a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ArrayList<BaseMoreMenuAction> r5 = this.a.a.getMoreMenuActions();
            if (r5 != null) goto L5;
            return;
        L5:
            Iterator<BaseMoreMenuAction> r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L16;
            BaseMoreMenuAction r0 = r6.next();
            if ((r0 instanceof DownloadMenu) == false) goto L7;
            if (((DownloadMenu) r0).n == null) goto L7;
            ((DownloadMenu) r0).n.cancel();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            tt5.a.d(DriveImFileDownloadVM.TAG, "DriveSdkDownloadPlugin#liveDownload() click error= " + e);
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public final void releaseDownloadActionsInterface() {
        Iterator<Map.Entry<DownloadMenu, ArrayList<BinderDownloadUpdater>>> r0 = this.mDownloadMenuBinderMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<DownloadMenu, ArrayList<BinderDownloadUpdater>> r1 = r0.next();
        Iterator<BinderDownloadUpdater> r2 = r1.getValue().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        BinderDownloadUpdater r3 = r2.next();
        DownloadMenu r4 = r1.getKey();
        r4.getClass();
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "DownloadMenu#removeBinderProxyDownloadUpdater() -> " + r3 + " this=" + r4.hashCode());
        r4.o.removeProxyDownloadUpdater(r3);
        goto L7
    L9:
        this.mDownloadMenuBinderMap.clear();
    }

    public DriveImFileDownloadVM() {
        this.liveDownload = new MutableLiveData();
        this.downloadRootViewTag = 2131370273;
        this.mDownloadMenuBinderMap = new ConcurrentHashMap();
    }

    public final MutableLiveData<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> getLiveDownload() {
        return this.liveDownload;
    }

    private final View findDownloadRootView(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
        Object r3 = r2.d.c(r2.c).getTag(this.downloadRootViewTag);
        if ((r3 instanceof View) == true) goto L7;
        return null;
    L7:
        return (View) r3;
    }

    private final void addBinderProxyDownloadUpdater(DownloadMenu r4, BinderDownloadUpdater r5) {
        ArrayList<BinderDownloadUpdater> r0 = this.mDownloadMenuBinderMap.get(r4);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.mDownloadMenuBinderMap.put(r4, r0);
    L5:
        r4.getClass();
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "DownloadMenu#addBinderProxyDownloadUpdater() -> " + r5 + " this=" + r4.hashCode());
        r4.o.addProxyDownloadUpdater(r5);
        r0.add(r5);
    }

    private final View instanceDownloadRootView(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4, e65.a r5) {
        View r0 = LayoutInflater.from(r4.getActivity()).inflate(2131560227, null);
        r0.setVisibility(8);
        ((ImageView) r0.findViewById(2131370317)).setOnClickListener(new b(r5));
        r4.d.c(r4.c).setTag(this.downloadRootViewTag, r0);
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final void showDownloadContentViewIfNeed(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2, View r3) {
        if (r3.getVisibility() == 0) goto L5;
        r3.setVisibility(0);
        r2.d.h(r2.c, r3);
        return;
    L5:
        tt5.a.k(TAG, "DriveImFileDownloadVM#liveDownload() show state, but current download view VISIBLE, ignore reshow");
    }

    private final void showNormalTips(TextView r5, Long r6) {
        Context r0 = r5.getContext();
        if (r6 != null) goto L5;
        tt5.a.d(TAG, "DriveImFileDownloadVM#liveDownload() current fileModel null, so get file size empty");
        String r7 = "";
    L6:
        r5.setTextColor(r0.getResources().getColor(2131106622));
        r5.setText(r7 + r0.getString(2131888472));
        return;
    L5:
        r7 = com.bytedance.ee.util.io.a.a(r6.longValue()) + ' ';
        goto L6
    }

    public final void handleFileDownloadMenuClick(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r10, e65.a r11) {
        Intrinsics.checkNotNullParameter(r10, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r11, "menuContext");
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a r0 = (com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a) this.liveDownload.getValue();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "DriveImFileDownloadVM#liveDownload state is null");
        return;
    L6:
        View r2 = findDownloadRootView(r10);
        if (r2 != null) goto L9;
        r2 = instanceDownloadRootView(r10, r11);
    L9:
        tt5.a.h(TAG, "DriveImFileDownloadVM#liveDownload state= " + r0.a);
        TextView r3 = (TextView) r2.findViewById(2131370318);     // Catch: Exception -> L27
        UDProgress r4 = r2.findViewById(2131383297);     // Catch: Exception -> L27
        int r5 = r0.a;     // Catch: Exception -> L27
        Long r8 = null;
        if (r5 != 1) goto L13;
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L27
        c r12 = r11.b.getIFileModel();     // Catch: Exception -> L27
        if (r12 == null) goto L25;
        r8 = Long.valueOf(r12.getFileSize());     // Catch: Exception -> L27
    L25:
        showNormalTips(r3, r8);     // Catch: Exception -> L27
        r4.setIndicatorColor(ContextCompat.getColor(r10.getActivity(), 2131101111));     // Catch: Exception -> L27
        showDownloadContentViewIfNeed(r10, r2);     // Catch: Exception -> L27
        return;
    L13:
        if (r5 != 2) goto L15;
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L27
        c r13 = r11.b.getIFileModel();     // Catch: Exception -> L27
        if (r13 == null) goto L21;
        r8 = Long.valueOf(r13.getFileSize());     // Catch: Exception -> L27
    L21:
        showNormalTips(r3, r8);     // Catch: Exception -> L27
        r4.setIndicatorColor(ContextCompat.getColor(r10.getActivity(), 2131101111));     // Catch: Exception -> L27
        r4.setProgress(r0.b);     // Catch: Exception -> L27
        showDownloadContentViewIfNeed(r10, r2);     // Catch: Exception -> L27
        return;
    L15:
        if (r5 == 4) goto L17;
        r2.setVisibility(8);     // Catch: Exception -> L27
        r4.setProgress(0);     // Catch: Exception -> L27
        r10.d.m(r10.c, r2);     // Catch: Exception -> L27
        return;
    L17:
        showDownloadContentViewIfNeed(r10, r2);     // Catch: Exception -> L27
        r3.setTextColor(r3.getResources().getColor(2131102093));     // Catch: Exception -> L27
        r4.setIndicatorColor(ContextCompat.getColor(r10.getActivity(), 2131102093));     // Catch: Exception -> L27
        r3.setText(r0.c);     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        tt5.a.d(TAG, "DriveImFileDownloadVM#liveDownload() switch state error= " + e);
    }

    public final void initDownloadActionsInterface(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4, e65.a r5) {
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        ArrayList<BaseMoreMenuAction> r0 = r5.a.getMoreMenuActions();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<BaseMoreMenuAction> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        BaseMoreMenuAction r2 = r1.next();
        if ((r2 instanceof DownloadMenu) == false) goto L7;
        addBinderProxyDownloadUpdater((DownloadMenu) r2, new BinderDownloadUpdater(this, r4, r5));
        goto L7
    }
}

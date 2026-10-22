package com.bytedance.ee.bear.drive.view.preview.archive;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.plugin.PluginException;
import com.bytedance.ee.bear.drive.view.preview.archive.view.FileDirNavigationView;
import com.bytedance.ee.bear.drive.view.preview.archive.view.FileTreeRvView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import e95.c;
import e95.f;
import e95.g;
import e95.h;
import f95.d;
import f95.e;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ArchivePreviewView extends AbsPreviewView implements f95.a {
    private static final String TAG = "Drive_CFPreviewView";
    private e95.b mArchiveLoader;
    private FileTreeRvView mFileTreeRvView;

    public class a implements e95.b.c {
        public final /* synthetic */ ArchivePreviewView a;

        public a(ArchivePreviewView r1) {
            this.a = r1;
        }

        public final void a(Throwable r4) {
            if ((r4 instanceof PluginException) == false) goto L5;
            tt5.a.d(ArchivePreviewView.TAG, "show() onFailed plugin error, show not support preview");
            ArchivePreviewView.access$300(this.a).liveInnerUnsupprtPreview().postValue(ArchivePreviewView.access$200(this.a).c);
            return;
        L5:
            if (r4 != null) goto L7;
        L13:
            ArchivePreviewView.access$600(this.a, "archive_view", new Throwable("parse archive tree fail. ", r4));
            return;
        L7:
            if (r4.getMessage() == null) goto L13;
            if (r4.getMessage().contains("encrypted") == false) goto L13;
            if (ArchivePreviewView.access$400(this.a) == null) goto L13;
            ArchivePreviewView.access$500(this.a).liveInnerPasswordProtected().postValue("");
        }

        public final void b(com.bytedance.ee.bear.drive.view.preview.archive.a r3) {
            ArchivePreviewView.access$000(this.a, "archive_view");
            ArchivePreviewView.access$100(this.a).setDataProvider(r3);
            ArchivePreviewView.access$100(this.a).setContentItemClickListener(this.a);
            ArchivePreviewView.access$100(this.a).setNavigationItemClickListener(new d95.a(this));
        }
    }

    public class b implements e95.b.InterfaceC0219b {
        public final /* synthetic */ a95.a a;
        public final /* synthetic */ d b;
        public final /* synthetic */ ArchivePreviewView c;

        public final void a(String r4, boolean r5) {
            if (ArchivePreviewView.access$1100(this.c) != null) goto L5;
            return;
        L5:
            if (this.b == null) goto L14;
            HashMap r0 = new HashMap();
            r0.put("file_type", com.bytedance.ee.util.io.a.c(this.b.d));
            r0.put("error_message", r4);
            r0.put("is_encrypted", Integer.valueOf(ArchivePreviewView.access$1200(this.c).c ? 1 : 0));
            if (r5 == false) goto L10;
            int r6 = 0;
        L11:
            r0.put(TipCallBackData.RESULT, Integer.valueOf(r6));
            ArchivePreviewView.access$1300(this.c).liveInnerReportMsg().a(new a0(30, r0));
            return;
        L10:
            r6 = -1;
            goto L11
        }

        public b(ArchivePreviewView r1, a95.a r2, d r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        FileTreeRvView r0 = this.mFileTreeRvView;
        if (r0.e == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r0.f.a.a() == true) goto L31;
        FileDirNavigationView r2 = r0.a;
        FileTreeRvView.a r4 = r0.f;
        int r3 = ((ArrayList) r2.b).indexOf(r4) - 1;
        FileDirNavigationView r5 = r0.a;
        if (r3 >= 0) goto L13;
        r5.getClass();
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
        FileTreeRvView.a r7 = (FileTreeRvView.a) ListProtector.get(r5.b, r3);
    L20:
        FileDirNavigationView r8 = r0.a;
        if (r3 >= 0) goto L23;
        r8.getClass();
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L29;
        ArrayList r10 = new ArrayList(((ArrayList) r8.b).subList(0, r3));
    L30:
        if (r7 == null) goto L31;
        r0.c(r10, r7);
        boolean r11 = true;
    L33:
        if (r11 == false) goto L37;
        return true;
    L37:
        return false;
    L29:
        r10 = new ArrayList();
        goto L30
    L23:
        if (r3 >= ((ArrayList) r8.b).size()) goto L26;
        r9 = true;
        goto L27
    L19:
        r7 = null;
        goto L20
    L13:
        if (r3 >= ((ArrayList) r5.b).size()) goto L16;
        r6 = true;
    L31:
        r11 = false;
        goto L33
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        trackOpenStart();
        this.mFileTreeRvView.setVisibility(0);
        e95.b r0 = this.mArchiveLoader;
        a r2 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (TextUtils.isEmpty(r0.a.g) == false) goto L5;
        tt5.a.h("ArchiveTreeDataLoader", "load() local file parse");
        r0.d = true;
        r0.e.add(Flowable.fromCallable(new f(r0)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new g(r0, r2), new h(r2)));
        return;
    L5:
        tt5.a.h("ArchiveTreeDataLoader", "load() online file parse");
        r0.d = false;
        z r1 = r0.a;     // Catch: Throwable -> L15
        String r5 = r1.g;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L9;
        tt5.a.k("ArchiveTreeDataLoader", "parseDirectoryTree() extra is empty");     // Catch: Throwable -> L15
        ArchiveTree r3 = new ArchiveTree();     // Catch: Throwable -> L15
    L13:
        r2.b(new com.bytedance.ee.bear.drive.view.preview.archive.a(r3));     // Catch: Throwable -> L15
        return;
    L9:
        ArchiveTree r6 = (ArchiveTree) JSON.parseObject(r5, ArchiveTree.class);     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        r6.setName(com.bytedance.ee.util.io.a.d(r1.a));     // Catch: Throwable -> L15
    L12:
        r3 = r6;
    L15:
        th = move-exception;
        r2.a(th);
        tt5.a.e("ArchiveTreeDataLoader", "load() online file parse failed", th, false);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mFileTreeRvView;
    }

    public static /* synthetic */ FileTreeRvView access$100(ArchivePreviewView r0) {
        return r0.mFileTreeRvView;
    }

    public static /* synthetic */ z access$1000(ArchivePreviewView r0) {
        return r0.mFileModel;
    }

    public static /* synthetic */ PreviewViewModel access$1100(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ e95.b access$1200(ArchivePreviewView r0) {
        return r0.mArchiveLoader;
    }

    public static /* synthetic */ PreviewViewModel access$1300(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ z access$200(ArchivePreviewView r0) {
        return r0.mFileModel;
    }

    public static /* synthetic */ PreviewViewModel access$300(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$400(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$500(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$700(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$800(ArchivePreviewView r0) {
        return r0.mPreviewViewModel;
    }

    public static /* synthetic */ z access$900(ArchivePreviewView r0) {
        return r0.mFileModel;
    }

    private void reportClickEvent(boolean r3) {
        PreviewViewModel r0 = this.mPreviewViewModel;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r0.liveInnerReportMsg().a(new a0(13));
        return;
    L7:
        r0.liveInnerReportMsg().a(new a0(14));
    }

    public static /* synthetic */ void access$000(ArchivePreviewView r0, String r1) {
        r0.trackOpenSuccess(r1);
    }

    private void init(Context r2, z r3) {
        FileTreeRvView r4 = new FileTreeRvView(r2);
        this.mFileTreeRvView = r4;
        r4.setUserAbility(this.mUserComponentAbility);
        FileTreeRvView r5 = this.mFileTreeRvView;
        ViewOwner r6 = this.mParentViewOwner;
        r5.d.c(r6);
        this.mArchiveLoader = new e95.b(this.mFileModel, this.mUserComponentAbility);
    }

    public static /* synthetic */ void access$600(ArchivePreviewView r0, String r1, Throwable r2) {
        r0.trackOpenFailed(r1, r2);
    }

    public ArchivePreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        init(r3, r4);
    }

    @Override // f95.a
    public boolean onContentItemClick(e r5, d r6, boolean r7, View r8, a95.a r9) {
        reportClickEvent(r7);
        if (r7 == false) goto L5;
    L29:
        return false;
    L5:
        if (this.mArchiveLoader.d == false) goto L26;
        if (com.bytedance.ee.util.ui.h.a(800) == true) goto L11;
        tt5.a.h(TAG, "onContentItemClick() isValidClick=false");
        return true;
    L11:
        if (this.mArchiveLoader.c == false) goto L13;
        Toast.showFailureText(getView().getContext(), 2131887225);
    L24:
        return true;
    L13:
        this.mFileTreeRvView.d.a();
        e95.b r10 = this.mArchiveLoader;
        String r0 = r6.d;
        long r1 = r6.c;
        b r3 = new b(this, r9, r6);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "entryPath");
        Intrinsics.checkNotNullParameter(r3, "cb");
        Disposable r11 = r10.f;
        if (r11 != null) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == false) goto L23;
        Disposable r13 = r10.f;
        if (r13 == null) goto L23;
        r13.dispose();
    L23:
        Disposable r14 = Flowable.fromCallable(new c(r10, r0, r1)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new e95.d(r3), new e95.e(r3));
        r10.f = r14;
        r10.e.addAll(new Disposable[]{r14});
        goto L24
    L16:
        if (r11.isDisposed() == true) goto L18;
        r12 = true;
        goto L19
    L26:
        if ((r6 instanceof com.bytedance.ee.bear.drive.view.preview.archive.a.C0172a) == false) goto L29;
        Toast.showFailureText(this.mContext, xo5.a.c(this.mContext, 2131888439, "type", com.bytedance.ee.util.io.a.c(((com.bytedance.ee.bear.drive.view.preview.archive.a.C0172a) r6).e.getName())), 0);
        return true;
    }
}

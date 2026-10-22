package com.bytedance.ee.bear.drive.view.preview.archive;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public class ArchivePreviewView extends AbsPreviewView implements f95.a {
    private static final String TAG = "Drive_CFPreviewView";
    private e95.b mArchiveLoader;
    private FileTreeRvView mFileTreeRvView;

    public class a implements e95.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArchivePreviewView f224703a;

        public a(ArchivePreviewView r100) {
            this.f224703a = r100;
        }

        public final void a(Throwable r100) {
            if ((r100 instanceof PluginException) == false) goto L5;
            tt5.a.d(ArchivePreviewView.TAG, "show() onFailed plugin error, show not support preview");
            ArchivePreviewView.access$300(this.f224703a).liveInnerUnsupprtPreview().postValue(ArchivePreviewView.access$200(this.f224703a).f225835c);
            return;
        L5:
            if (r100 != null) goto L7;
        L13:
            ArchivePreviewView.access$600(this.f224703a, "archive_view", new Throwable("parse archive tree fail. ", r100));
            return;
        L7:
            if (r100.getMessage() == null) goto L13;
            if (r100.getMessage().contains("encrypted") == false) goto L13;
            if (ArchivePreviewView.access$400(this.f224703a) == null) goto L13;
            ArchivePreviewView.access$500(this.f224703a).liveInnerPasswordProtected().postValue("");
        }

        public final void b(com.bytedance.ee.bear.drive.view.preview.archive.a r100) {
            ArchivePreviewView.access$000(this.f224703a, "archive_view");
            ArchivePreviewView.access$100(this.f224703a).setDataProvider(r100);
            ArchivePreviewView.access$100(this.f224703a).setContentItemClickListener(this.f224703a);
            ArchivePreviewView.access$100(this.f224703a).setNavigationItemClickListener(new d95.a(this));
        }
    }

    public class b implements e95.b.InterfaceC5757b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a95.a f224704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f224705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArchivePreviewView f224706c;

        public final void a(String r100, boolean r101) {
            if (ArchivePreviewView.access$1100(this.f224706c) != null) goto L5;
            return;
        L5:
            if (this.f224705b == null) goto L14;
            HashMap r102 = new HashMap();
            r102.put("file_type", com.bytedance.ee.util.io.a.c(this.f224705b.f475968d));
            r102.put("error_message", r100);
            r102.put("is_encrypted", Integer.valueOf(ArchivePreviewView.access$1200(this.f224706c).f471492c ? 1 : 0));
            if (r101 == false) goto L10;
            int r103 = 0;
        L11:
            r102.put("result", Integer.valueOf(r103));
            ArchivePreviewView.access$1300(this.f224706c).liveInnerReportMsg().a(new a0(30, r102));
            return;
        L10:
            r103 = -1;
            goto L11
        }

        public b(ArchivePreviewView r100, a95.a r101, d r102) {
            this.f224706c = r100;
            this.f224704a = r101;
            this.f224705b = r102;
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
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        FileTreeRvView r100 = this.mFileTreeRvView;
        if (r100.f224733e == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r100.f224734f.f224738a.a() == true) goto L31;
        FileDirNavigationView r102 = r100.f224729a;
        FileTreeRvView.a r103 = r100.f224734f;
        int r104 = ((ArrayList) r102.f224711b).indexOf(r103) - 1;
        FileDirNavigationView r105 = r100.f224729a;
        if (r104 >= 0) goto L13;
        r105.getClass();
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L19;
        FileTreeRvView.a r107 = (FileTreeRvView.a) ListProtector.get(r105.f224711b, r104);
    L20:
        FileDirNavigationView r108 = r100.f224729a;
        if (r104 >= 0) goto L23;
        r108.getClass();
    L26:
        boolean r109 = false;
    L27:
        if (r109 == false) goto L29;
        ArrayList r110 = new ArrayList(((ArrayList) r108.f224711b).subList(0, r104));
    L30:
        if (r107 == null) goto L31;
        r100.c(r110, r107);
        boolean r111 = true;
    L33:
        if (r111 == false) goto L37;
        return true;
    L37:
        return false;
    L29:
        r110 = new ArrayList();
        goto L30
    L23:
        if (r104 >= ((ArrayList) r108.f224711b).size()) goto L26;
        r109 = true;
        goto L27
    L19:
        r107 = null;
        goto L20
    L13:
        if (r104 >= ((ArrayList) r105.f224711b).size()) goto L16;
        r106 = true;
    L31:
        r111 = false;
        goto L33
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        trackOpenStart();
        this.mFileTreeRvView.setVisibility(0);
        e95.b r100 = this.mArchiveLoader;
        a r101 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (TextUtils.isEmpty(r100.f471490a.f225839g) == false) goto L5;
        tt5.a.h("ArchiveTreeDataLoader", "load() local file parse");
        r100.f471493d = true;
        r100.f471494e.add(Flowable.fromCallable(new f(r100)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new g(r100, r101), new h(r101)));
        return;
    L5:
        tt5.a.h("ArchiveTreeDataLoader", "load() online file parse");
        r100.f471493d = false;
        z r102 = r100.f471490a;     // Catch: Throwable -> L15
        String r103 = r102.f225839g;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r103) == false) goto L9;
        tt5.a.k("ArchiveTreeDataLoader", "parseDirectoryTree() extra is empty");     // Catch: Throwable -> L15
        ArchiveTree r104 = new ArchiveTree();     // Catch: Throwable -> L15
    L13:
        r101.b(new com.bytedance.ee.bear.drive.view.preview.archive.a(r104));     // Catch: Throwable -> L15
        return;
    L9:
        ArchiveTree r105 = (ArchiveTree) JSON.parseObject(r103, ArchiveTree.class);     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        r105.setName(com.bytedance.ee.util.io.a.d(r102.f225833a));     // Catch: Throwable -> L15
    L12:
        r104 = r105;
    L15:
        th = move-exception;
        r101.a(th);
        tt5.a.e("ArchiveTreeDataLoader", "load() online file parse failed", th, false);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mFileTreeRvView;
    }

    public static /* synthetic */ FileTreeRvView access$100(ArchivePreviewView r100) {
        return r100.mFileTreeRvView;
    }

    public static /* synthetic */ z access$1000(ArchivePreviewView r100) {
        return r100.mFileModel;
    }

    public static /* synthetic */ PreviewViewModel access$1100(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ e95.b access$1200(ArchivePreviewView r100) {
        return r100.mArchiveLoader;
    }

    public static /* synthetic */ PreviewViewModel access$1300(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ z access$200(ArchivePreviewView r100) {
        return r100.mFileModel;
    }

    public static /* synthetic */ PreviewViewModel access$300(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$400(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$500(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$700(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ PreviewViewModel access$800(ArchivePreviewView r100) {
        return r100.mPreviewViewModel;
    }

    public static /* synthetic */ z access$900(ArchivePreviewView r100) {
        return r100.mFileModel;
    }

    private void reportClickEvent(boolean r100) {
        PreviewViewModel r101 = this.mPreviewViewModel;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.liveInnerReportMsg().a(new a0(13));
        return;
    L7:
        r101.liveInnerReportMsg().a(new a0(14));
    }

    public static /* synthetic */ void access$000(ArchivePreviewView r100, String r101) {
        r100.trackOpenSuccess(r101);
    }

    private void init(Context r100, z r101) {
        FileTreeRvView r102 = new FileTreeRvView(r100);
        this.mFileTreeRvView = r102;
        r102.setUserAbility(this.mUserComponentAbility);
        FileTreeRvView r103 = this.mFileTreeRvView;
        ViewOwner r104 = this.mParentViewOwner;
        r103.f224732d.c(r104);
        this.mArchiveLoader = new e95.b(this.mFileModel, this.mUserComponentAbility);
    }

    public static /* synthetic */ void access$600(ArchivePreviewView r100, String r101, Throwable r102) {
        r100.trackOpenFailed(r101, r102);
    }

    public ArchivePreviewView(ViewOwner r100, ViewOwner r101, Context r102, z r103, a95.a r104) {
        super(r100, r101, r102, r103, r104);
        init(r102, r103);
    }

    @Override // f95.a
    public boolean onContentItemClick(e r100, d r101, boolean r102, View r103, a95.a r104) {
        reportClickEvent(r102);
        if (r102 == false) goto L5;
    L29:
        return false;
    L5:
        if (this.mArchiveLoader.f471493d == false) goto L26;
        if (com.bytedance.ee.util.ui.h.a(800) == true) goto L11;
        tt5.a.h(TAG, "onContentItemClick() isValidClick=false");
        return true;
    L11:
        if (this.mArchiveLoader.f471492c == false) goto L13;
        Toast.showFailureText(getView().getContext(), R.string.CreationMobile_Docs_decompress_encrypted);
    L24:
        return true;
    L13:
        this.mFileTreeRvView.f224732d.a();
        e95.b r105 = this.mArchiveLoader;
        String r106 = r101.f475968d;
        long r107 = r101.f475967c;
        b r108 = new b(this, r104, r101);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "entryPath");
        Intrinsics.checkNotNullParameter(r108, "cb");
        Disposable r109 = r105.f471495f;
        if (r109 != null) goto L16;
    L18:
        boolean r110 = false;
    L19:
        if (r110 == false) goto L23;
        Disposable r111 = r105.f471495f;
        if (r111 == null) goto L23;
        r111.dispose();
    L23:
        Disposable r112 = Flowable.fromCallable(new c(r105, r106, r107)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new e95.d(r108), new e95.e(r108));
        r105.f471495f = r112;
        r105.f471494e.addAll(new Disposable[]{r112});
        goto L24
    L16:
        if (r109.isDisposed() == true) goto L18;
        r110 = true;
        goto L19
    L26:
        if ((r101 instanceof com.bytedance.ee.bear.drive.view.preview.archive.a.C3228a) == false) goto L29;
        Toast.showFailureText(this.mContext, xo5.a.c(this.mContext, R.string.Drive_Drive_PreviewUnsupportInArchive, "type", com.bytedance.ee.util.io.a.c(((com.bytedance.ee.bear.drive.view.preview.archive.a.C3228a) r101).f224709e.getName())), 0);
        return true;
    }
}

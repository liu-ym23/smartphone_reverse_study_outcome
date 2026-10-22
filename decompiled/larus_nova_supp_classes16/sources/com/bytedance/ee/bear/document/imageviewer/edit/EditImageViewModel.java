package com.bytedance.ee.bear.document.imageviewer.edit;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.imageviewer.bean.EditImageData;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import e0c.k;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j25.q;
import java.io.File;
import java.util.ArrayList;
import k25.e0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007J&\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/edit/EditImageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "editImageData", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "Lcom/bytedance/ee/bear/document/imageviewer/bean/EditImageData;", "delegate", "Lcom/bytedance/ee/bear/document/imageviewer/edit/EditImageViewModel$Delegate;", "isSupportRenameImg", "", "updateEditImageData", "", "data", "setCallback", "getEditImageData", "saveFile", "token", "", "docUrl", "localUrl", TipCallBackData.RESULT, "Lcom/bytedance/ee/bear/document/imageviewer/edit/EditResult;", "getFilePath", "path", "getPathFromUrl", "url", "image", "Lcom/bytedance/ee/bear/contract/imageviewer/bean/ImageData$Image;", RectColorView.RectColorType.TYPE_CLEAR, "Companion", "Delegate", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditImageViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String SEPARATOR = "_";
    private static final String TAG = "EditImageViewModel";
    private final CompositeDisposable compositeDisposable;
    private b delegate;
    private final SingleLiveEvent<EditImageData> editImageData;
    private boolean isSupportRenameImg;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(String r1);

        String b(String r1, ImageData.Image r2);

        void c(t15.a r1);
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ EditImageViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageData.Image c;

        public c(EditImageViewModel r1, String r2, ImageData.Image r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            b r4 = EditImageViewModel.access$getDelegate$p(this.a);
            if (r4 != null) goto L7;
            return null;
        L7:
            return r4.b(this.b, this.c);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ EditImageViewModel a;

        public d(EditImageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            b r0 = EditImageViewModel.access$getDelegate$p(this.a);
            if (r0 == null) goto L6;
            r0.a(r3);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            tt5.a.d(EditImageViewModel.TAG, "saveFile " + ((Throwable) r3).getMessage());
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditImageViewModel d;
        public final /* synthetic */ String e;

        public f(String r1, String r2, String r3, EditImageViewModel r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((String) r6, "<unused var>");
            ArrayList r7 = new ArrayList();
            q r0 = new q();
            if (FileUtils.F(false, this.a) == false) goto L5;
            tt5.a.h(EditImageViewModel.TAG, "saveFile:isFileExists  path=" + this.a);
            r0.a = FileUtils.x(false, this.a) + '_' + System.currentTimeMillis();
            r0.b = this.b;
            r0.f = this.c;
            r0.e = "";
            r0.d = this.d.getFilePath(this.a);
            r0.h = Long.valueOf(FileUtils.w(false, this.a));
            r0.c = this.e;
            r7.add(r0);
        L5:
            return r7;
        }
    }

    public static final class g<T, R> implements Function {
        public static final g<T, R> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r3) {
            e0 r0 = e0.m();
            long[] r4 = r0.v((ArrayList) r3);
            Intrinsics.checkNotNull(r4);
            boolean r1 = false;
            if (r4.length != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L8;
            tt5.a.d(EditImageViewModel.TAG, "saveFile Insert db fail !");
        L10:
            return Boolean.valueOf(r1);
        L8:
            r1 = true;
            goto L10
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ EditImageViewModel a;
        public final /* synthetic */ t15.a b;

        public h(EditImageViewModel r1, t15.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L8;
            b r3 = EditImageViewModel.access$getDelegate$p(this.a);
            if (r3 == null) goto L9;
            r3.c(this.b);
            return;
        L9:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public static final i<T> a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r3) {
            tt5.a.d(EditImageViewModel.TAG, "saveFile " + ((Throwable) r3).getMessage());
        }
    }

    static {
        Companion = new a();
    }

    public final void clear() {
        this.compositeDisposable.clear();
    }

    public EditImageViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.editImageData = new SingleLiveEvent();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        this.isSupportRenameImg = ((dn4.a) k.b(((v) k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.edit_image_disable_rename_img");
    }

    public final SingleLiveEvent<EditImageData> getEditImageData() {
        return this.editImageData;
    }

    public static final /* synthetic */ b access$getDelegate$p(EditImageViewModel r0) {
        return r0.delegate;
    }

    public final String getFilePath(String r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        tt5.a.h(TAG, "getFilePath: path=" + r13);
        VFSFile r0 = ay4.d.a().i(r13);
        if (r0.exists() == true) goto L7;
        tt5.a.d(TAG, "getFilePath: originalFile not exists");
        return r13;
    L7:
        if (this.isSupportRenameImg == true) goto L11;
        tt5.a.d(TAG, "getFilePath: fg is false");
        return r0.getAbsolutePath();
    L11:
        if (StringsKt.endsWith$default(r13, ".0", false, 2, null) == true) goto L14;
        tt5.a.h(TAG, "getFilePath: not end with .0, path=" + r13);
        return r0.getAbsolutePath();
    L14:
        tt5.a.h(TAG, "getFilePath: end with .0, path=" + r13);
        VFSPath r2 = VFSFiles.b.z(r13);
        String r3 = com.bytedance.ee.util.io.b.b(r2);
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
    L26:
        tt5.a.h(TAG, "getFilePath: safeFileType=" + r3);
        String r14 = FileUtils.x(false, r13);
        Intrinsics.checkNotNull(r14);
        String r5 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r14, new String[]{"."}, false, 0, 6, null));
        if (r5 == null) goto L30;
        r14 = r5;
    L30:
        String r16 = r14 + '.' + r3;
        com.ss.android.lark.vfs.h r6 = ay4.d.a();
        File r7 = r0.getParentFile();
        if (r7 == null) goto L34;
        String r8 = r7.getPath();
        if (r8 == null) goto L34;
    L35:
        VFSFile r17 = r6.v(r8, r16);
        if (r17.exists() == false) goto L39;
        r17.delete();
    L39:
        if (r0.renameTo(r17) == true) goto L41;
        tt5.a.d(TAG, "Rename failed: originalFile=" + r0 + ", newFile=" + r17);
        String r18 = r0.getAbsolutePath();
        Intrinsics.checkNotNull(r18);
        return r18;
    L41:
        tt5.a.h(TAG, "Rename success: originalFile=" + r0 + ", newFile=" + r17);
        String r19 = r17.getAbsolutePath();
        Intrinsics.checkNotNull(r19);
        return r19;
    L34:
        r8 = "";
        goto L35
    L24:
        if (com.bytedance.ee.util.io.b.c(r2) == false) goto L43;
        tt5.a.h(TAG, "getFilePath: is image,use default ext jpg, path=".concat(r13));
        r3 = "jpg";
        goto L26
    L43:
        tt5.a.d(TAG, "getFilePath: unknown fileType and not image, path=".concat(r13));
        return r0.getAbsolutePath();
    L17:
        if (StringsKt.isBlank(r3) == true) goto L20;
        r4 = false;
        goto L21
    }

    public final void setCallback(b r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
    }

    public final void updateEditImageData(EditImageData r2) {
        this.editImageData.setValue(r2);
    }

    public final void getPathFromUrl(String r3, ImageData.Image r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "image");
        Disposable r5 = Flowable.just("").map(new c(this, r3, r4)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new d(this), e.a);
        this.compositeDisposable.add(r5);
    }

    public final void saveFile(String r9, String r10, String r11, t15.a r12) {
        Intrinsics.checkNotNullParameter(r9, "token");
        Intrinsics.checkNotNullParameter(r10, "docUrl");
        Intrinsics.checkNotNullParameter(r11, "localUrl");
        Intrinsics.checkNotNullParameter(r12, TipCallBackData.RESULT);
        tt5.a.h(TAG, "saveFile: localUrl=" + r11);
        this.compositeDisposable.add(Flowable.just("").map(new f(r12.b, r9, r11, this, r10)).map(g.a).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new h(this, r12), i.a));
    }
}

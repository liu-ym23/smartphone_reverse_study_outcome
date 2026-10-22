package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.text.TextUtils;
import android.widget.EditText;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<VideoInfo> f429794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoKBPlugin f429795b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f429797b;

        public a(PhotoKBPlugin r100, ErrorResult r101) {
            this.f429796a = r100;
            this.f429797b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.f429796a.n().l().getContext(), this.f429797b.getDisplayMsg(UIHelper.getString(R.string.Lark_Legacy_ErrorMessageTip)));     // Catch: Throwable -> L4
            this.f429796a.f429748i.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429798a;

        public b(PhotoKBPlugin r100) {
            this.f429798a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f429798a.f429748i.dismiss();     // Catch: Throwable -> L4
            this.f429798a.n().z().z();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<VideoInfo> f429799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, FrameInfo> f429800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429801c;

        public c(List<VideoInfo> r100, Map<String, FrameInfo> r101, PhotoKBPlugin r102) {
            this.f429799a = r100;
            this.f429800b = r101;
            this.f429801c = r102;
        }

        public final void a() {
            List<VideoInfo> r100 = this.f429799a;
            Map<String, FrameInfo> r101 = this.f429800b;
            PhotoKBPlugin r102 = this.f429801c;
            Iterator<T> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L13;
            VideoInfo r104 = (VideoInfo) r103.next();
            FrameInfo r105 = r101.get(r104.getPath());
            if (r105 == null) goto L12;
            if (TextUtils.isEmpty(r105.getPath()) == true) goto L12;
            int r106 = PhotoKBPlugin.f429742w;
            r102.getClass();
            com.ss.android.lark.widget.span.b.AbstractC5432b.a r107 = new com.ss.android.lark.widget.span.b.AbstractC5432b.a(r105.getPath(), r105.getWidth(), r105.getHeight());
            EditText r108 = r102.n().L().c();
            if ((r108 instanceof FunctionEditText) == false) goto L4;
            ((com.ss.android.lark.keyboard.edittext2.edittors.e) ((FunctionEditText) r108).q(com.ss.android.lark.keyboard.edittext2.edittors.e.f429054e)).insert(new hob.g(r107, (int) r104.getDuration(), r104, r105, null));
            r102.f429745f.a();
        L12:
            Log.e("get first frame failed：" + r104.getPath());
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onFinish() {
        UICallbackExecutor.execute(new b(this.f429795b));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        UICallbackExecutor.execute(new a(this.f429795b, r100));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onSuccess(Map<String, FrameInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "ret");
        UICallbackExecutor.execute(new c(this.f429794a, r100, this.f429795b));
    }

    public l(List<VideoInfo> r100, PhotoKBPlugin r101) {
        this.f429794a = r100;
        this.f429795b = r101;
    }
}

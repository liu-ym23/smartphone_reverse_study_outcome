package com.ss.android.lark.contact.base.contact_list.mvp;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.contact.base.service.InvRequestUtils;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$localCallback$1;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.b0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ExternalContactPresenter2 extends BasePresenter<l, m, m.a> {

    public class ViewDelegate implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalContactPresenter2 f418574a;

        public ViewDelegate(ExternalContactPresenter2 r100) {
            this.f418574a = r100;
        }

        @Override // com.ss.android.lark.contact.base.contact_list.mvp.m.a
        public final void N6(String r100) {
            this.f418574a.getModel().X3(r100, new UIGetDataCallback(new AnonymousClass1(this)));
        }

        @Override // com.ss.android.lark.contact.base.contact_list.mvp.m.a
        public final void t4(final w8b.a r100) {
            this.f418574a.getModel().z4(r100.f558707e, new UIGetDataCallback(new AnonymousClass2(this, r100)));
        }
    }

    public class a implements InvRequestUtils.a<List<w8b.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalContactPresenter2 f418575a;

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void c() {
            this.f418575a.getView().hideLoading();
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void onShowLoading() {
            this.f418575a.getView().showLoading();
        }

        public a(ExternalContactPresenter2 r100) {
            this.f418575a = r100;
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void a(InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 r100) {
            Log.i("ExternalContactPresenter2", "start load local data");
            this.f418575a.getModel().b1(Boolean.TRUE, r100);
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final /* bridge */ /* synthetic */ boolean d(List<w8b.a> r100) {
            return true;
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void e(InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 r100) {
            Log.i("ExternalContactPresenter2", "start load server data");
            this.f418575a.getModel().b1(Boolean.FALSE, r100);
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void f(ErrorResult r210) {
            this.f418575a.getView().l3();
            if (r210 == null) goto L5;
            Log.e("ExternalContactPresenter2", "get external contacts failed: " + r210.toString());
        L6:
            ConcurrentHashMap<String, Long> r100 = a0.f418905a;
            Intrinsics.checkNotNullParameter(r210, "err");
            AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Contact, Event.show_external_contacts, ErrorType.SDK, ErrorLevel.Fatal, r210.getErrorCode(), "show_contact_external", "ContactExternalView".concat("V2"), r210.getMessage(), Boolean.TRUE, null, null, null, 7168, null));
            return;
        L5:
            Log.e("ExternalContactPresenter2", "get external contacts failed.");
            goto L6
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void b(boolean r100, List<w8b.a> r101) {
            List<w8b.a> r102 = r101;
            StringBuilder r103 = new StringBuilder("isFromLocal: ");
            r103.append(r100);
            r103.append(", size: ");
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            r103.append(r104);
            Log.i("ExternalContactPresenter2", r103.toString());
            if (CollectionUtils.isEmpty(r102) == false) goto L9;
            this.f418575a.getView().l3();
        L10:
            if (r100 == true) goto L13;
            a0.e(false);
            return;
        L13:
            return;
        L9:
            this.f418575a.getView().o2(r102);
            goto L10
        L5:
            r104 = r102.size();
            goto L6
        }
    }

    public class b implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalContactPresenter2 f418576a;

        public b(ExternalContactPresenter2 r100) {
            this.f418576a = r100;
        }

        public final w8b.a a(String r100) {
            Iterator<w8b.a> r101 = this.f418576a.getView().j6().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            w8b.a r102 = r101.next();
            if (r100.equals(r102.f558707e) == false) goto L4;
            return r102;
        L8:
            return null;
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        a0.e(true);
        a r100 = new a(this);
        int r101 = InvRequestUtils.f418898a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r100, "callback");
        ViewUtils.runOnUiThread(new b0(new InvRequestUtils.LocalAndServerRequestImpl(r100)));
    }

    public ExternalContactPresenter2(ExternalContactModel2 r100, ExternalContactView2 r101) {
        super(r100, r101);
        r100.f418570a = new b(this);
    }
}

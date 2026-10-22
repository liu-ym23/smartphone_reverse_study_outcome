package com.bytedance.ee.bear.templates.preview.single.common;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.list.create.l;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements e {
    public boolean a;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.a = false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MutableLiveData<Boolean> a;
        public final /* synthetic */ CommonPreviewTemplateData b;
        public final /* synthetic */ Item c;

        public c(MutableLiveData<Boolean> r1, CommonPreviewTemplateData r2, Item r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            DocumentCreateInfo r7 = (DocumentCreateInfo) r6;
            if (ForsetiHelper.p() == true) goto L5;
        L7:
            this.a.postValue(Boolean.FALSE);
        L8:
            RouteBean r0 = new RouteBean();
            r0.c = 1;
            Lazy r2 = TemplateUtils.b;
            if (((Boolean) r2.getValue()).booleanValue() == false) goto L11;
            String r3 = "";
        L12:
            r0.j = r3;
            if (((Boolean) r2.getValue()).booleanValue() == true) goto L15;
            r0.t = true;
        L15:
            String r4 = null;
            h r1 = (h) org.koin.java.a.c(h.class, null, null, 6);
            String r5 = r7.d;
            CommonPreviewTemplateData r8 = this.b;
            if (r8 == null) goto L19;
            r4 = r8.getTemplateSource();
        L19:
            if (com.bytedance.ee.bear.templates.h.a(r4) == true) goto L21;
        L23:
            r1.m9(r5, r0);
            Lazy r9 = CommonTemplatePreviewAnalytic.a;
            CommonTemplatePreviewAnalytic.e(this.c, r7.b, this.b);
            return;
        L21:
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.larkform.new.enable") == false) goto L23;
            r5 = UriProtector.parse(r5).buildUpon().appendQueryParameter("larkForm", "1").build().toString();
            goto L23
        L11:
            r3 = "scene_template";
            goto L12
        L5:
            if (((Boolean) TemplateUtils.b.getValue()).booleanValue() == true) goto L7;
            this.a.setValue(Boolean.FALSE);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.preview.single.common.d$d, reason: collision with other inner class name */
    public static final class C0188d<T> implements Consumer {
        public final /* synthetic */ Item a;

        public C0188d(Item r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            tt5.a.e("DefaultTemplateCreator", "loadTemplateDataFromNet: ", r8, false);
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r8, null) == false) goto L6;
            return;
        L6:
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).p(r8, null, false) == true) goto L27;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L13;
            ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r2 = this.a.getObjToken();
            Integer r4 = Integer.valueOf(this.a.getObjType());
            Intrinsics.checkNotNull(r8);
            ErrorResponse r1 = r0.e(r2, r4, "CREATE_COPY", r8);
            if (r1.getHasHandledUiAction() == false) goto L17;
            r1.getCallback().a(eu5.b.a, r1);
            return;
        L17:
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).q(r8) == false) goto L19;
            return;
        L19:
            if ((r8 instanceof NetService.ServerErrorException) == false) goto L25;
            Toast.showFailureText(eu5.b.a, 2131887995);
            return;
        L25:
            return;
        L13:
            String r3 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(this.a.getObjToken(), "CCM_CREATE_COPY", k0.a(r8));
            if (TextUtils.isEmpty(r3) == true) goto L17;
            Toast.showFailureText(eu5.b.a, r3);
            return;
        }
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.templates.preview.single.common.e
    public final Disposable a(Item r18, CommonPreviewTemplateData r19, MutableLiveData<Boolean> r20) {
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r20, "previewActive");
        if (this.a == false) goto L6;
        UDToast.show(eu5.b.a, 2131887994);
        return null;
    L6:
        UDToast.show(eu5.b.a, 2131887994);
        this.a = true;
        String r7 = r18.getObjToken();
        String r8 = r18.getName();
        int r9 = r18.getObjType();
        if (r19 == null) goto L10;
        String r11 = r19.getModule();
        if (r11 == null) goto L10;
    L12:
        if (r18.getSource() != 1) goto L14;
        boolean r12 = true;
    L16:
        if (r19 == null) goto L18;
        String r14 = r19.getTemplateSource();
    L19:
        CreateSelectResult.a r4 = CreateSelectResult.CREATOR;
        if (r19 == null) goto L22;
        String r16 = r19.getCreateSelectResultJson();
    L23:
        r4.getClass();
        CreateSelectResult r5 = CreateSelectResult.a.c(r16);
        if (r19 == null) goto L27;
        String r17 = r19.getSpaceId();
        if (r17 == null) goto L27;
    L28:
        l r15 = new l(r7, r8, r9, false, r11, r12, "preview_create", r14, r5, r17);
        if (r19 == null) goto L33;
        yn5.d r6 = r19.getBitableSelectResult();
        if (r6 == null) goto L33;
        er5.c r10 = new er5.c(r6.a, r6.b);
    L34:
        r15.p = r10;
        return new g0().b(r15).doOnTerminate(new b(this)).subscribe(new c(r20, r19, r18), new C0188d(r18));
    L33:
        r10 = null;
    L27:
        r17 = "";
        goto L28
    L22:
        r16 = null;
        goto L23
    L18:
        r14 = null;
        goto L19
    L14:
        r12 = false;
    L10:
        r11 = "";
        goto L12
    }
}

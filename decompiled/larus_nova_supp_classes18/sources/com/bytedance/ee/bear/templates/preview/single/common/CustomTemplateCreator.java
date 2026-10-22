package com.bytedance.ee.bear.templates.preview.single.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.dto.CustomCreateDocumentByTemplateResult;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.ss.android.lark.compose.foundation.toast.g;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CustomTemplateCreator implements e {
    public final BinderISelectTemplateCallback.Stub a;
    public final SelectTemplateConfig b;
    public boolean c;
    public g d;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ CustomTemplateCreator a;

        public b(CustomTemplateCreator r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.b();
            this.a.c = false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MutableLiveData<Boolean> a;
        public final /* synthetic */ Item b;
        public final /* synthetic */ CommonPreviewTemplateData c;

        public c(MutableLiveData<Boolean> r1, Item r2, CommonPreviewTemplateData r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            CustomCreateDocumentByTemplateResult r4 = (CustomCreateDocumentByTemplateResult) r3;
            if (TextUtils.isEmpty(r4.d) == true) goto L6;
            Toast.showFailureText(eu5.b.a, r4.d);
        L6:
            if (r4.a == false) goto L9;
            this.a.postValue(Boolean.FALSE);
        L9:
            if (r4.b == false) goto L15;
            Lazy r0 = CommonTemplatePreviewAnalytic.a;
            Item r1 = this.b;
            String r5 = p.a().Z(r4.c).b;
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            CommonTemplatePreviewAnalytic.e(r1, r5, this.c);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Item a;

        public d(Item r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            tt5.a.e("CustomTemplateCreator", "loadTemplateDataFrom customCallBack: ", r8, false);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L7;
            ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r3 = this.a.getObjToken();
            Integer r4 = Integer.valueOf(this.a.getObjType());
            Intrinsics.checkNotNull(r8);
            ErrorResponse r1 = r0.e(r3, r4, "CREATE_COPY", r8);
            if (r1.getHasHandledUiAction() == false) goto L11;
            r1.getCallback().a(eu5.b.a, r1);
            return;
        L11:
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).q(r8) == false) goto L13;
            return;
        L13:
            if ((r8 instanceof NetService.ServerErrorException) == false) goto L19;
            Toast.showFailureText(eu5.b.a, 2131887995);
            return;
        L19:
            return;
        L7:
            String r2 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(this.a.getObjToken(), "CCM_CREATE_COPY", k0.a(r8));
            if (TextUtils.isEmpty(r2) == true) goto L11;
            Toast.showFailureText(eu5.b.a, r2, 1);
        }
    }

    static {
    }

    public final void b() {
        g r0 = this.d;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isShowing() != true) goto L7;
    L8:
        if (r1 == false) goto L13;
        tt5.a.h("CustomTemplateCreator", "start cancel");
        g r2 = this.d;
        if (r2 == null) goto L14;
        r2.cancel();
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public CustomTemplateCreator(BinderISelectTemplateCallback.Stub r1, SelectTemplateConfig r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.templates.preview.single.common.e
    public final Disposable a(final Item r5, CommonPreviewTemplateData r6, MutableLiveData<Boolean> r7) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r7, "previewActive");
        tt5.a.h("CustomTemplateCreator", "startCreate");
        if (this.c == false) goto L6;
        tt5.a.h("CustomTemplateCreator", "startCreate creating, ignore");
        return null;
    L6:
        boolean r0 = true;
        this.c = true;
        b();
        SelectTemplateConfig r1 = this.b;
        if (r1 != null) goto L9;
    L11:
        r0 = false;
    L12:
        if (r0 == true) goto L31;
        if (r1 != null) goto L17;
    L25:
        Context r2 = ((com.bytedance.ee.bear.lark.dependency.d) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.d.class, null, null, 6)).getCurrentActivity();
        if (r2 != null) goto L28;
        r2 = eu5.b.a;
    L28:
        g r3 = x08.a.a(r2, 2131887994);
    L29:
        this.d = r3;
        r3.show();
        goto L31
    L17:
        if (TextUtils.isEmpty(r1.b) == true) goto L25;
        Context r4 = ((com.bytedance.ee.bear.lark.dependency.d) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.d.class, null, null, 6)).getCurrentActivity();
        if (r4 != null) goto L21;
        r4 = eu5.b.a;
    L21:
        String r8 = this.b.b;
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        r3 = x08.a.b(r4, r8);
    L31:
        return Flowable.create(new CustomTemplateCreator$startCreate$1(r5, this), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).doFinally(new b(this)).subscribe(new c(r7, r5, r6), new d(r5));
    L9:
        if (r1.a != true) goto L11;
        goto L11
    }
}

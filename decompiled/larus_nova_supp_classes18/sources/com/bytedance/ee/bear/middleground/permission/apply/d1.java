package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ PermApplyFragment c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PermApplyFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(PermApplyFragment r1, int r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            PermApplyFragment r7 = this.a;
            UDEditText r0 = r7.j;
            if (r0 != null) goto L9;
            View r1 = r7.getView();
            if (r1 == null) goto L7;
            r0 = r1.findViewById(2131371423);
        L8:
            r7.j = (SpaceEditText) r0;
            goto L9
        L7:
            r0 = null;
        L9:
            ((SpaceEditText) r0).setText("");
            int r8 = this.b;
            String r2 = this.a.W90().getToken();
            String r3 = this.c;
            if (this.d.length() <= 0) goto L12;
            boolean r4 = true;
        L13:
            PermissionAnalytic.h(r8, r2, r3, r4);
            Toast.showSuccessText(this.a.getContext(), this.a.getString(2131887829), 0);
            PermApplyFragment.U90(this.a, false);
            return;
        L12:
            r4 = false;
            goto L13
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PermApplyFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(PermApplyFragment r1, int r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            boolean r2 = false;
            tt5.a.e("PermApplyFragment", "request perm fail. ", r7, false);
            PermApplyFragment.U90(this.a, false);
            int r0 = this.b;
            String r1 = this.a.W90().getToken();
            String r3 = this.c;
            if (this.d.length() <= 0) goto L5;
            r2 = true;
        L5:
            PermissionAnalytic.g(r0, r1, r3, r2);
            Context r4 = this.a.getContext();
            Intrinsics.checkNotNull(r4);
            Intrinsics.checkNotNull(r7);
            ui5.a.b(r4, r7, this.a.W90().getOwnerName(), this.a.W90().getToken(), this.a.W90().getDocumentType());
        }
    }

    public d1(PermApplyFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r13) {
        rcb.c.d(this.c.getView());
        PermApplyFragment r14 = this.c;
        UDEditText r0 = r14.j;
        if (r0 != null) goto L9;
        View r1 = r14.getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131371423);
    L8:
        r14.j = (SpaceEditText) r0;
        goto L9
    L7:
        r0 = null;
    L9:
        String r9 = String.valueOf(((SpaceEditText) r0).getText());
        Integer r15 = StringsKt.toIntOrNull(this.c.W90().getDocumentType());
        if (r15 == null) goto L12;
        int r16 = r15.intValue();
    L14:
        if (this.c.Z90().getPermType().getValue() != PermApplyViewModel.PermType.EDIT) goto L16;
        String r2 = "edit";
    L17:
        PermApplyFragment.U90(this.c, true);
        Flowable<Boolean> r3 = this.c.Z90().requestPerm(r9);
        PermApplyFragment r4 = this.c;
        Disposable r17 = r3.subscribe(new a(r4, r16, r2, r9), new b(r4, r16, r2, r9));
        String r5 = this.c.W90().getToken();
        int r6 = sbb.e.g(this.c.W90().getDocumentType());
        String r7 = this.c.W90().getSubType();
        boolean r8 = this.c.W90().getFromVc();
        boolean r10 = this.c.W90().isWiki();
        String r11 = this.c.W90().getModule();
        String r12 = this.c.W90().getUserPerm();
        String r18 = this.c.W90().getPublicPerm();
        PermApplyViewModel.PermType r19 = (PermApplyViewModel.PermType) this.c.Z90().getPermType().getValue();
        if (r19 == null) goto L20;
        int r110 = r19.getCode();
    L21:
        com.bytedance.ee.bear.middleground.permission.c.i(r5, r6, r7, r8, r10, r11, r12, r18, r110, r9, "apply_permission");
        this.c.m.add(r17);
        return;
    L20:
        r110 = 1;
        goto L21
    L16:
        r2 = "read";
        goto L17
    L12:
        r16 = -1;
        goto L14
    }
}

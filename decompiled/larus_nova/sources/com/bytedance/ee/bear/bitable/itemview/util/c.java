package com.bytedance.ee.bear.bitable.itemview.util;

import android.content.Context;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.view.cell.text.CustomTextMenuEnum;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.utils.statistics.PerfLog;
import hp4.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    public static final class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f214274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<CustomTextMenuEnum> f214275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f214276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v f214277d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<String> f214278e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f214279f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f214280g;

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            this.f214276c.invoke();
            boolean r102 = false;
            if (r101.getItemId() != CustomTextMenuEnum.COPY.getId()) goto L21;
            v r103 = this.f214277d;
            if (r103 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            if (r104 == false) goto L21;
            if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(this.f214278e.invoke(), new Token(this.f214279f)) == false) goto L14;
            UDToast.show(this.f214274a, R.string.Bitable_Common_CopiedToClipboard);
        L14:
            v r105 = this.f214277d;
            if (r105 != null) goto L17;
        L19:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
            jg5.k.a.f499019a.d(r102, true);
        L31:
            return true;
        L17:
            if (r105.t1() != true) goto L19;
            r102 = true;
            goto L19
        L7:
            if (r103.S1(r101.getItemId()) != true) goto L9;
            r104 = true;
        L21:
            if (r101.getItemId() != CustomTextMenuEnum.DELETE.getId()) goto L31;
            v r106 = this.f214277d;
            if (r106 != null) goto L25;
        L27:
            if (r102 == false) goto L31;
            Function0<Unit> r107 = this.f214280g;
            if (r107 == null) goto L31;
            r107.invoke();
            goto L31
        L25:
            if (r106.canEdit() != true) goto L27;
            r102 = true;
            goto L27
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            eu5.h.a(this.f214274a, 10, 50);
            Iterator<CustomTextMenuEnum> r102 = this.f214275b.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            CustomTextMenuEnum r103 = r102.next();
            r101.add(769711401, r103.getId(), 0, r103.getTitleResId());
            goto L4
        L6:
            return true;
        }

        public a(Context r100, List<CustomTextMenuEnum> r101, Function0<Unit> r102, v r103, Function0<String> r104, String r105, Function0<Unit> r106) {
            this.f214274a = r100;
            this.f214275b = r101;
            this.f214276c = r102;
            this.f214277d = r103;
            this.f214278e = r104;
            this.f214279f = r105;
            this.f214280g = r106;
        }
    }

    public static final ActionMode a(View r110, v r111, Context r112, Function0<Unit> r113, Function0<Unit> r114, Function0<String> r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "destroyCustomMenu");
        Intrinsics.checkNotNullParameter(r115, "getText");
        Intrinsics.checkNotNullParameter(r116, "copyID");
        View r100 = null;
        if (Build.VERSION.SDK_INT < 23) goto L24;
        ArrayList r101 = new ArrayList();
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile_fix_text_long_press") == false) goto L12;
        Object r103 = r110.getParent();
        if ((r103 instanceof View) == false) goto L9;
        r100 = (View) r103;
    L9:
        if (r100 == null) goto L12;
        View r104 = r100;
    L13:
        r101.add(CustomTextMenuEnum.COPY);
        if (r111 != null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L23;
        if (r114 == null) goto L23;
        r101.add(CustomTextMenuEnum.DELETE);
    L23:
        return r104.startActionMode(new a(r112, r101, r113, r111, r115, r116, r114), 1);
    L16:
        if (r111.canEdit() != true) goto L18;
        r105 = true;
    L12:
        r104 = r110;
        goto L13
    L24:
        return null;
    }
}

package com.bytedance.ee.bear.list.create;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.creation.CreationMenuPanel;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x0 implements iw4.g {
    public a a;

    public class a implements Observer<iw4.b> {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ x0 c;

        public final void onChanged(Object r30) {
            final iw4.b r2 = (iw4.b) r30;
            if (r2 == null) goto L99;
            tt5.a.h("ListSelectCreationMenuManager", "bindObserver onChanged()...creationMenuItemClick, sourceFragment = " + this.a + ", current ListSelectCreationMenuManager：" + this.c);
            x0 r0 = this.c;
            FragmentActivity r3 = this.b;
            r0.getClass();
            final SelectCreationMenuViewModel r4 = ViewModelProviders.of(r3).get(SelectCreationMenuViewModel.class);
            final Context r1 = this.b;
            Fragment r5 = this.a;
            int r6 = r2.a.type;
            String r13 = r2.c;
            String r8 = r2.d;
            String r11 = r2.b;
            boolean r14 = r2.f;
            boolean r7 = r2.h;
            boolean r15 = r2.g;
            sbb.e r12 = sbb.e.e;
            int r10 = r12.b;
            SelectCreationMenuItem.ItemType r9 = SelectCreationMenuItem.ItemType.ADD_DOC;
            int r16 = r10;
            int r17 = -1;
            if (r6 == r9.getType()) goto L30;
            if (r6 == SelectCreationMenuItem.ItemType.ADD_SHEET.getType()) goto L30;
            if (r6 == SelectCreationMenuItem.ItemType.ADD_MINDNOTE.getType()) goto L30;
            if (r6 == SelectCreationMenuItem.ItemType.ADD_BITABLE.getType()) goto L30;
            if (r6 == SelectCreationMenuItem.ItemType.ADD_DOCX.getType()) goto L30;
            if (r6 == SelectCreationMenuItem.ItemType.ADD_SURVEY.getType()) goto L30;
            if (r6 != SelectCreationMenuItem.ItemType.ADD_FOLDER.getType()) goto L21;
            sbb.e r18 = sbb.e.f;
            int r19 = r18.b;
            final int r20 = ((Integer) com.bytedance.ee.bear.appsetting.c.a.a.d("create_folder_delay", 0)).intValue();
            com.bytedance.ee.bear.list.t0.I(r1, r2.c, r2.d, r2.b, new t0(r4, r2, r20, r1));
            lc5.f.a.C(new tc5.a(r2.c, r2.d, DocumentType.FOLDER_NAME, "ccm_space_folder_view", r2.b, r18.b));
            int r110 = r19;
        L27:
            r2 = r2;
            r4 = r4;
            sbb.e r111 = r12;
        L90:
            if (r6 != SelectCreationMenuItem.ItemType.CANCEL.getType()) goto L93;
            iw4.b r21 = r2;
            jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), DocFeed$Value$Result.CANCEL, "", r21.c, r21.f, r21.g));
        L95:
            r4.clearClickCreationMenuItem();
            return;
        L93:
            if (r110 == r111.b) goto L95;
            jw4.a.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), sbb.e.c(r110), r13);
            goto L95
        L21:
            if (r6 != SelectCreationMenuItem.ItemType.UPLOAD_PHOTOS.getType()) goto L24;
            sbb.e r22 = sbb.e.l;
            int r23 = r22.b;
            tt5.a.h("ListSelectCreationMenuClickHandler", "uploadMedia()...");
            r4.setSelectedCreationType(r22.b);
            ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).r0(r2.b, "explorer", w0.a(r2), -1);
            jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "upload_image", "", r2.c, r2.f, r2.g));
            lc5.f.a.C(new tc5.a(r2.c, r2.d, "image_upload", "ccm_space_file_choose_view", r2.b, r12.b));
            lc5.f.g(r2.c, r2.d, r2.b);
        L26:
            r110 = r23;
            goto L27
        L24:
            if (r6 != SelectCreationMenuItem.ItemType.UPLOAD_FILE.getType()) goto L28;
            sbb.e r24 = sbb.e.l;
            r23 = r24.b;
            tt5.a.h("ListSelectCreationMenuClickHandler", "uploadFile()...");
            r4.setSelectedCreationType(r24.b);
            ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).J0(r2.b, "explorer", w0.a(r2), -1);
            jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "upload_file", "", r2.c, r2.f, r2.g));
            lc5.f.a.C(new tc5.a(r2.c, r2.d, "file_upload", "ccm_space_file_choose_view", r2.b, r12.b));
            lc5.f.g(r2.c, r2.d, r2.b);
            goto L26
        L28:
            r2 = r2;
            r111 = r12;
            r16 = r16;
        L88:
            r110 = r16;
        L30:
            if (r6 != r9.getType()) goto L33;
            r17 = sbb.e.g.b;
        L47:
            r4.setSelectedCreationType(r6);
            if (TextUtils.equals(r13, "home") == false) goto L50;
            String r25 = "create_new_recent";
        L51:
            SelectCreationMenuItem.ItemType r26 = SelectCreationMenuItem.ItemType.ADD_SURVEY;
            String r112 = r25;
            if (r6 != r26.getType()) goto L54;
            String r27 = "larktab_bitable";
            r111 = r12;
            String r113 = "space_home_create_form";
        L55:
            Parcelable r114 = CreateSelectResult.b();
            if ("new_drive".equals(r13) == false) goto L58;
        L72:
            r114 = CreateSelectResult.a(r11);
        L73:
            Parcelable r28 = r114;
            RouteBean r29 = new RouteBean();
            if (r5 != null) goto L76;
        L78:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).yd("/list/template4/activity", r29).j("objType", r17).i("enterSource", r27).i("template_source", r113).i("openTemplateCenter", "system").l("key_folder_version", r7).i("MODULE", r13).i("ROOT_TOKEN", r11).o("CREATION_LOCATION", r28).d(r1).e();
            com.bytedance.ee.bear.contract.d r31 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            JSONObject r32 = new JSONObject();     // Catch: Exception -> L81
            r32.put("source", "docs_newcreate_click");     // Catch: Exception -> L81
            r31.a("enter_template_center", r32);     // Catch: Exception -> L81
        L84:
            if (r6 != r26.getType()) goto L86;
            int r33 = r17;
            lc5.f.a.C(new tc5.a(r13, r8, "new_form_templates", "ccm_template_systemcenter_view", r11, r33));
        L87:
            jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), sbb.e.c(r33), r13, r14, r15));
            goto L88
        L86:
            r33 = r17;
            lc5.f.a.C(new tc5.a(r13, r8, r33, r11));
        L81:
            e = move-exception;
            tt5.a.e("CreateAnalytic", "reportClickBtnEnterTemplateCenter()...error = ", e, false);
            goto L84
        L76:
            if (ForsetiHelper.i() == false) goto L78;
            r29.a(r5);
            goto L78
        L58:
            if ("personal_subfolder".equals(r13) == true) goto L72;
            if (WikiSpaceType.PERSONAL.equals(r13) == true) goto L72;
            if ("shared_subfolder".equals(r13) == true) goto L72;
            if ("personal_folder_root".equals(r13) == true) goto L72;
            if (OperationName.OPERATION_OFFLINE_AVAILABLE.equals(r13) == true) goto L72;
            if (TextUtils.isEmpty(r11) == true) goto L73;
            tt5.a.k("ListSelectCreationMenuClickHandler", "Invalid location: parentToken=" + du5.b.i(r11) + " with module=" + r13 + ". Default location should not be used when parentToken exists.");
            goto L73
        L54:
            r113 = "create_new_template";
            r27 = r112;
            r111 = r12;
            goto L55
        L50:
            r25 = "create_new";
            goto L51
        L33:
            if (r6 != SelectCreationMenuItem.ItemType.ADD_SHEET.getType()) goto L36;
            r17 = sbb.e.h.b;
            goto L47
        L36:
            if (r6 != SelectCreationMenuItem.ItemType.ADD_MINDNOTE.getType()) goto L39;
            r17 = sbb.e.k.b;
            goto L47
        L39:
            if (r6 != SelectCreationMenuItem.ItemType.ADD_BITABLE.getType()) goto L41;
        L46:
            r17 = sbb.e.i.b;
            goto L47
        L41:
            if (r6 == SelectCreationMenuItem.ItemType.ADD_SURVEY.getType()) goto L46;
            if (r6 != SelectCreationMenuItem.ItemType.ADD_DOCX.getType()) goto L47;
            r17 = sbb.e.o.b;
            goto L47
        }

        public a(x0 r1, Fragment r2, FragmentActivity r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public x0() {
    }

    public final boolean a(FragmentActivity r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
        return false;
    L5:
        CreationMenuPanel r1 = r5.getSupportFragmentManager().findFragmentByTag("CreationMenuPanel");
        if ((r1 instanceof CreationMenuPanel) == false) goto L8;
        tt5.a.h("ListSelectCreationMenuManager", "getCreationMenuPanel()...success");
        CreationMenuPanel r2 = r1;
    L9:
        if (r2 != null) goto L11;
    L22:
        tt5.a.h("ListSelectCreationMenuManager", "creationMenuPanel dismissCreationMenuPanelIfSupport: " + r0);
        return r0;
    L11:
        if (r2.getDialog() == null) goto L22;
        if (r2.getDialog().isShowing() == false) goto L22;
        tt5.a.h("ListSelectCreationMenuManager", "create menu is already showing");
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L17
    L21:
        d(r5);
        r0 = true;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L21;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L21
    L8:
        r2 = null;
        goto L9
    }

    public final void d(FragmentActivity r3) {
        tt5.a.h("ListSelectCreationMenuManager", "unbindObserver()...current ListSelectCreationMenuManager：" + this);
        if (this.a != null) goto L5;
        return;
    L5:
        ViewModelProviders.of(r3).get(SelectCreationMenuViewModel.class).getCreationMenuItemClick().removeObserver(this.a);
        this.a = null;
    }

    public final void b(FragmentActivity r3, Fragment r4) {
        tt5.a.h("ListSelectCreationMenuManager", "bindObserver()...sourceFragment=" + r4 + ",current ListSelectCreationMenuManager：" + this);
        if (this.a != null) goto L5;
        this.a = new a(this, r4, r3);
    L5:
        ViewModelProviders.of(r3).get(SelectCreationMenuViewModel.class).getCreationMenuItemClick().observe(r3, this.a);
    }

    public final CreationMenuPanel c(FragmentActivity r5, iw4.h r6, SelectCreationMenuConfig r7, Fragment r8) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Bundle r0 = new Bundle();
        r0.putParcelable("key_config", r7);
        r0.putString("key_parent_token", r6.a);
        r0.putString("key_module", r6.b);
        r0.putString("key_sub_module", r6.c);
        r0.putString("key_src_module", r6.d);
        r0.putBoolean("key_is_folder", r6.e);
        r0.putBoolean("key_is_from_empty", r6.f);
        r0.putBoolean("key_folder_version", r6.g);
        Parcelable r9 = CreateSelectResult.b();
        if ("new_drive".equals(r6.b) == false) goto L8;
    L21:
        r9 = CreateSelectResult.a(r6.a);
    L22:
        tt5.a.h("ListSelectCreationMenuManager", "showCreationMenuPanel: createSelectResult=" + r9);
        r0.putParcelable("CREATION_LOCATION", r9);
        b(r5, r8);
        return CreationMenuPanel.fa0(r5, r0, r6.i);
    L8:
        if ("personal_subfolder".equals(r6.b) == true) goto L21;
        if (WikiSpaceType.PERSONAL.equals(r6.b) == true) goto L21;
        if ("shared_subfolder".equals(r6.b) == true) goto L21;
        if ("personal_folder_root".equals(r6.b) == true) goto L21;
        if (OperationName.OPERATION_OFFLINE_AVAILABLE.equals(r6.b) == true) goto L21;
        if (TextUtils.isEmpty(r6.a) == true) goto L22;
        tt5.a.k("ListSelectCreationMenuManager", "Invalid location: parentToken=" + du5.b.i(r6.a) + " with module=" + r6.b + ". Default location should not be used when parentToken exists.");
        goto L22
    }
}

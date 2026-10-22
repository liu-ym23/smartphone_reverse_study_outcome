package m15;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.bytedance.ee.bear.route.PostCard;
import iw4.h;
import jw4.d;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ b a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ h c;

    public c(b r1, FragmentActivity r2, h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r22) {
        iw4.b r2 = (iw4.b) r22;
        if (r2 == null) goto L45;
        b r0 = this.a;
        FragmentActivity r3 = this.b;
        h r4 = this.c;
        r0.getClass();
        SelectCreationMenuViewModel r5 = (SelectCreationMenuViewModel) ViewModelProviders.of(r3).get(SelectCreationMenuViewModel.class);
        int r6 = a.a;
        m r1 = r0.b;
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r2, "menuItem");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "menuContext");
        e r7 = e.e;
        int r8 = r7.b;
        SelectCreationMenuItem.ItemType r9 = r2.a;
        if (r9 != null) goto L7;
        int r10 = -1;
    L9:
        switch(r10) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L10;
        };
    L10:
        r8 = r8;
    L34:
        int r11 = r8;
    L36:
        if (r2.a != SelectCreationMenuItem.ItemType.CANCEL) goto L39;
        jw4.a.c(new d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), "cancel", "", r2.c, r2.f, r2.g));
    L41:
        r5.clearClickCreationMenuItem();
        return;
    L39:
        if (r11 == r7.b) goto L41;
        jw4.a.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), e.c(r11), r2.c);
        goto L41
    L11:
        e r12 = e.l;
        r11 = r12.b;
        tt5.a.h("DocumentSelectCreationMenuClickHandler", "uploadFile()...");
        r5.setSelectedCreationType(r12.b);
        int r13 = a.a(r2.a);
        if (r1 == null) goto L14;
        JSONObject r14 = new JSONObject();
        r14.put("objType", Integer.valueOf(r13));
        r14.put("subId", "insertFile");
        r1.b(r14);
    L14:
        jw4.a.c(new d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), "upload_file", "", r2.c, r2.f, r2.g));
        ((rc5.b) org.koin.java.a.c(rc5.b.class, null, null, 6)).b(new tc5.a(r2.c, r2.d, "file_upload", "ccm_space_file_choose_view", r2.b, r7.b));
        ((rc5.b) org.koin.java.a.c(rc5.b.class, null, null, 6)).c(r2.c, r2.d, r2.b);
        goto L36
    L15:
        e r16 = e.l;
        r11 = r16.b;
        tt5.a.h("DocumentSelectCreationMenuClickHandler", "uploadMedia()...");
        r5.setSelectedCreationType(r16.b);
        int r17 = a.a(r2.a);
        if (r1 == null) goto L18;
        JSONObject r18 = new JSONObject();
        r18.put("objType", Integer.valueOf(r17));
        r18.put("subId", "insertImage");
        r1.b(r18);
    L18:
        jw4.a.c(new d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), "upload_image", "", r2.c, r2.f, r2.g));
        ((rc5.b) org.koin.java.a.c(rc5.b.class, null, null, 6)).b(new tc5.a(r2.c, r2.d, "image_upload", "ccm_space_file_choose_view", r2.b, r7.b));
        ((rc5.b) org.koin.java.a.c(rc5.b.class, null, null, 6)).c(r2.c, r2.d, r2.b);
        goto L36
    L19:
        r11 = e.f.b;
        goto L36
    L20:
        SelectCreationMenuItem.ItemType r19 = r2.a;
        int r110 = r19.type;
        String r111 = r2.c;
        String r112 = r2.d;
        String r113 = r2.b;
        boolean r20 = r2.f;
        boolean r114 = r2.g;
        int r21 = a.a(r19);
        r5.setSelectedCreationType(r110);
        if (r1 == null) goto L25;
        JSONObject r23 = new JSONObject();
        r23.put("objType", Integer.valueOf(r21));
        r1.b(r23);
    L25:
        if (r110 != SelectCreationMenuItem.ItemType.ADD_SURVEY.getType()) goto L27;
        String r24 = "space_home_create_form";
    L28:
        PostCard r26 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/list/template4/activity").j("objType", r21).i("enterSource", "create_new_folder_block").i("template_source", r24).i("openTemplateCenter", "system").l("key_folder_version", true).i("MODULE", r111).i("ROOT_TOKEN", r113);
        CreateSelectResult.a r27 = CreateSelectResult.CREATOR;
        String r28 = r4.a;
        r27.getClass();
        r26.o("CREATION_LOCATION", CreateSelectResult.a.a("my_document_library", r28, false, "")).i("SPACE_ID", r4.h).d(r3).e();
        com.bytedance.ee.bear.contract.d r29 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        org.json.JSONObject r30 = new org.json.JSONObject();     // Catch: Exception -> L31
        r30.put("source", "docs_newcreate_click");     // Catch: Exception -> L31
        r29.a("enter_template_center", r30);     // Catch: Exception -> L31
    L33:
        rc5.b r31 = (rc5.b) org.koin.java.a.c(rc5.b.class, null, null, 6);
        Intrinsics.checkNotNull(r111);
        r31.b(new tc5.a(r111, r112, r21, r113));
        jw4.a.c(new d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), e.c(r21), r111, r20, r114));
    L31:
        e = move-exception;
        tt5.a.e("CreateAnalytic", "reportClickBtnEnterTemplateCenter()...error = ", e, false);
        goto L33
    L27:
        r24 = "create_new_template";
        goto L28
    L7:
        r10 = a.C0252a.a[r9.ordinal()];
        goto L9
    }
}

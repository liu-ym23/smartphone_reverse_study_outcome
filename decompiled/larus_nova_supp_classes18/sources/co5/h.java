package co5;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.list.dto.SaveTemplateResult;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.preview.group.SaveTemplateTokens$Tokens;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements com.bytedance.ee.bear.templates.dto.b {
    public final /* synthetic */ e a;

    @Override // com.bytedance.ee.bear.templates.dto.b
    public final void a() {
        TemplateReportV2 r0 = TemplateReportV2.a;
        e r1 = this.a;
        String r2 = r1.d;
        SceneTemplateData r3 = r1.b;
        String r4 = r3.collection_id;
        String r5 = r1.c;
        String r6 = r3.name;
        JSONObject r7 = new JSONObject();
        r7.put("click_type", DocFeed$Value$Result.CANCEL);
        r7.put("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r5)));
        r7.put("set_name", r6);
        r7.put("set_id", r4);
        r7.put("template_source", TemplateReportV2.c);
        r7.put("templatecenter_source", r2);
        TemplateReportV2.a().o("ccm_set_template_preview_click", r7, false);
    }

    @Override // com.bytedance.ee.bear.templates.dto.b
    public final void b() {
        SceneTemplateData.SceneTemplatePreviewInfo r0 = this.a.b.getSceneTemplatePreviewInfo();
        if (r0 == null) goto L14;
        e r1 = this.a;
        int r3 = r0.type;
        String r2 = r0.token;
        if (r2 != null) goto L7;
        String r5 = "";
    L8:
        String r4 = r0.name;
        if (r4 != null) goto L11;
        String r6 = "";
    L12:
        com.bytedance.ee.bear.templates.c r9 = new com.bytedance.ee.bear.templates.c(r3, r5, r6, false, 3, 40);
        TemplateUtils r7 = TemplateUtils.a;
        Context r8 = r1.a;
        r7.getClass();
        TemplateUtils.o(r8, r9);
        TemplateReportV2 r10 = TemplateReportV2.a;
        String r11 = r0.token;
        String r12 = r0.name;
        String r13 = r1.d;
        String r14 = r0.collectionId;
        String r15 = r1.c;
        JSONObject r16 = new JSONObject();
        r16.put("click_type", "share_button");
        r16.put("template_token", r11);
        r16.put("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r15)));
        r16.put("set_id", r14);
        r16.put("set_name", r12);
        r16.put("template_name", r12);
        r16.put("template_type", "egc");
        r16.put("template_source", TemplateReportV2.c);
        r16.put("templatecenter_source", r13);
        r16.put("target", "ccm_permission_share_view");
        TemplateReportV2.a().o("ccm_set_template_preview_click", r16, false);
        return;
    L11:
        r6 = r4;
        goto L12
    L7:
        r5 = r2;
        goto L8
    }

    public h(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.templates.dto.b
    public final void c(Object r37) {
        if ((r37 instanceof SaveTemplateResult) == false) goto L39;
        String r3 = null;
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        String r2 = "suite";
        SaveTemplateResult r0 = (SaveTemplateResult) r37;
        List r17 = JSON.parseArray(r0.getTokenList(), SaveTemplateTokens$Tokens.class);
        e r14 = this.a;
        List<SceneTemplateData.Scene> r4 = r14.b.template_collection;
        String r13 = "";
        if (r4 == null) goto L28;
        Iterator<T> r18 = r4.iterator();
    L8:
        if (r18.hasNext() == false) goto L28;
        SceneTemplateData.Scene r12 = (SceneTemplateData.Scene) r18.next();
        sbb.e r5 = sbb.e.d(r12.obj_type);
        if (r5 == null) goto L12;
        String r6 = r5.getType();
    L13:
        String r7 = r12.obj_token;
        Iterator r8 = r17.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        SaveTemplateTokens$Tokens r9 = (SaveTemplateTokens$Tokens) r8.next();
        if (r9.template_token.equals(r7) == false) goto L15;
        String r10 = r9.new_obj_token;
    L20:
        String r11 = r2;
        String r24 = r2;
        String r25 = r13;
        SaveTemplateResult r38 = r0;
        e r15 = r14;
        jw4.a.e(r1, new jw4.c(r6, r10, r11, r0.getParentToken(), "", "", "", r12.obj_token, "", Boolean.TRUE, "from_set", r12.name));
        String r16 = r12.obj_token;
        String r19 = r12.name;
        String r20 = r15.b.collection_id;
        String r21 = r15.d;
        String r32 = du5.b.g(r38.getToken());
        String r22 = r12.obj_token;
        Iterator r23 = r17.iterator();
    L22:
        if (r23.hasNext() == false) goto L26;
        SaveTemplateTokens$Tokens r110 = (SaveTemplateTokens$Tokens) r23.next();
        if (r110.template_token.equals(r22) == false) goto L22;
        String r111 = r110.new_obj_token;
    L27:
        com.bytedance.ee.bear.templates.b r26 = new com.bytedance.ee.bear.templates.b("use_click", r16, r19, r20, r21, r32, du5.b.g(r111), r12.obj_type, r15.c);
        TemplateReportV2 r27 = TemplateReportV2.a;
        TemplateReportV2.h(r26);
        r14 = r15;
        r2 = r24;
        r13 = r25;
        r3 = null;
        r0 = r38;
        goto L8
    L26:
        r111 = r25;
        goto L27
    L19:
        r10 = r13;
        goto L20
    L12:
        r6 = r3;
    L28:
        SaveTemplateResult r39 = r0;
        String r28 = r39.getToken();
        String r29 = r39.getParentToken();
        jw4.a.e(r1, new jw4.c(DocumentType.FOLDER_NAME, r28, r29, r13));
        return;
    }
}

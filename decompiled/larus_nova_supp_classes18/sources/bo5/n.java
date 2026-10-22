package bo5;

import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements com.bytedance.ee.bear.templates.dto.d {
    public final /* synthetic */ com.bytedance.ee.bear.templates.dto.d a;

    public n(TemplateTypeSwitchItemV2.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onFail(int r2, String r3) {
        com.bytedance.ee.bear.templates.dto.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onSuccess(int r2, String r3) {
        com.bytedance.ee.bear.templates.dto.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(r2, r3);
        return;
    }
}

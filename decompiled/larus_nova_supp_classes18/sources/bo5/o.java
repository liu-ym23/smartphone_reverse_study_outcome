package bo5;

import com.bytedance.ee.bear.templates.TemplateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements com.bytedance.ee.bear.templates.dto.d {
    public final /* synthetic */ com.bytedance.ee.bear.templates.dto.d a;
    public final /* synthetic */ com.bytedance.ee.bear.bizwidget.d b;
    public final /* synthetic */ yn5.e c;

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onFail(int r2, String r3) {
        com.bytedance.ee.bear.templates.dto.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.onFail(r2, r3);
    L5:
        com.bytedance.ee.bear.bizwidget.d r4 = this.b;
        if (r4 == null) goto L9;
        r4.a();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onSuccess(int r2, String r3) {
        com.bytedance.ee.bear.templates.dto.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.onSuccess(r2, r3);
    L5:
        com.bytedance.ee.bear.bizwidget.d r1 = this.b;
        if (r1 == null) goto L9;
        r1.a();
    L9:
        if (this.c.d == false) goto L12;
        TemplateUtils.a.getClass();
        TemplateUtils.k(r2, r3);
        return;
    }

    public o(com.bytedance.ee.bear.templates.dto.d r1, com.bytedance.ee.bear.bizwidget.d r2, yn5.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

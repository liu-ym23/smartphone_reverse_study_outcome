package com.bytedance.ee.bear.templates;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewHeadHolder;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "headTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showTitle", "", "name", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewHeadHolder extends ITemplateViewHolder {
    public final TextView a;

    public TemplateViewHeadHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = (TextView) r2.findViewById(2131388331);
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void U3(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.a.setText(r3);
        this.a.setVisibility(0);
        return;
    L8:
        this.a.setVisibility(8);
        return;
    L5:
        r0 = false;
        goto L6
    }
}

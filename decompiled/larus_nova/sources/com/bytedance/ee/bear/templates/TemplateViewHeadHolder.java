package com.bytedance.ee.bear.templates;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewHeadHolder;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "headTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showTitle", "", "name", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewHeadHolder extends ITemplateViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f238811a;

    public TemplateViewHeadHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f238811a = (TextView) r100.findViewById(R.id.template_item_head_title);
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void U3(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f238811a.setText(r100);
        this.f238811a.setVisibility(0);
        return;
    L8:
        this.f238811a.setVisibility(8);
        return;
    L5:
        r101 = false;
        goto L6
    }
}

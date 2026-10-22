package com.bytedance.ee.bear.templates;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewBlankHolder;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/templates/LayoutType;)V", "blankLabelTxt", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showTemplate", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "deleteListener", "Lkotlin/Function0;", "getBlankLabelTxt", "", "objType", "templateSource", "", "enable", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewBlankHolder extends ITemplateViewHolder {
    public final View a;
    public final TextView b;

    public static final class a {
    }

    static {
    }

    public TemplateViewBlankHolder(View r2, LayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "layoutType");
        super(r2);
        this.a = r2;
        this.b = (TextView) r2.findViewById(2131364265);
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void T3(TemplateV4 r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r4, "deleteListener");
        View r5 = this.a;
        if (r3.getEnable() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        float r1 = 1.0f;
    L12:
        r5.setAlpha(r1);
        TextView r6 = this.b;
        int r2 = r3.getObjType();
        String r7 = r3.getTemplateSource();
        if (r2 != 3) goto L15;
        int r8 = 2131887444;
    L25:
        r6.setText(r8);
        return;
    L15:
        if (r2 == 8) goto L21;
        if (r2 == 11) goto L19;
        r8 = 2131887433;
        goto L25
    L19:
        r8 = 2131887437;
        goto L25
    L21:
        if (h.a(r7) == false) goto L23;
        r8 = 2131886677;
        goto L25
    L23:
        r8 = 2131887432;
        goto L25
    L11:
        r1 = 0.3f;
        goto L12
    L5:
        if (com.bytedance.ee.bear.list.create.a.a(r3.getObjType()) == true) goto L8;
        r0 = false;
        goto L9
    }
}

package com.bytedance.ee.bear.templates;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewBlankHolder;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/templates/LayoutType;)V", "blankLabelTxt", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showTemplate", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "deleteListener", "Lkotlin/Function0;", "getBlankLabelTxt", "", "objType", "templateSource", "", "enable", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewBlankHolder extends ITemplateViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f238809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f238810b;

    public static final class a {
    }

    static {
    }

    public TemplateViewBlankHolder(View r100, LayoutType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutType");
        super(r100);
        this.f238809a = r100;
        this.f238810b = (TextView) r100.findViewById(R.id.blankLabelTxt);
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void T3(TemplateV4 r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r101, "deleteListener");
        View r102 = this.f238809a;
        if (r100.getEnable() == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        float r104 = 1.0f;
    L12:
        r102.setAlpha(r104);
        TextView r105 = this.f238810b;
        int r106 = r100.getObjType();
        String r107 = r100.getTemplateSource();
        if (r106 != 3) goto L15;
        int r108 = R.string.CreationMobile_Template_Sheet_Blanklabel;
    L25:
        r105.setText(r108);
        return;
    L15:
        if (r106 == 8) goto L21;
        if (r106 == 11) goto L19;
        r108 = R.string.CreationMobile_Template_Doc_Blanklabel;
        goto L25
    L19:
        r108 = R.string.CreationMobile_Template_Mindnote_Blanklabel;
        goto L25
    L21:
        if (h.a(r107) == false) goto L23;
        r108 = R.string.Bitable_NewSurvey_Template_CreateNewForm;
        goto L25
    L23:
        r108 = R.string.CreationMobile_Template_Bitable_Blanklabel;
        goto L25
    L11:
        r104 = 0.3f;
        goto L12
    L5:
        if (com.bytedance.ee.bear.list.create.a.a(r100.getObjType()) == true) goto L8;
        r103 = false;
        goto L9
    }
}

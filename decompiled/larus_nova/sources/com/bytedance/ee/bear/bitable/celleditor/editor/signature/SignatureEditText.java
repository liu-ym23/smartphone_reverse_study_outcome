package com.bytedance.ee.bear.bitable.celleditor.editor.signature;

import android.R;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.ss.android.lark.utils.statistics.PerfLog;
import gp4.g;
import hp4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/SignatureEditText;", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "Lcom/bytedance/ee/bear/bitable/card/view/IBindPermissionChecker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "copyChecker", "Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "setIPermissionCopyChecker", "", "permissionChecker", "onTextContextMenuItem", "", "id", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignatureEditText extends SpaceEditText implements g {
    public v V0;

    public SignatureEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SignatureEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        boolean r101 = false;
        switch(r100) {
            case 16908319: goto L38;
            case 16908320: goto L22;
            case 16908321: goto L15;
            case 16908322: goto L5;
            default: goto L40;
        };
    L5:
        v r102 = this.V0;
        if (r102 != null) goto L8;
    L10:
        if (r101 == false) goto L40;
        Editable r103 = getText();
        if (r103 == null) goto L14;
        Selection.removeSelection(r103);
    L14:
        return true;
    L8:
        if (r102.canEdit() == true) goto L10;
        r101 = true;
        goto L10
    L15:
        v r104 = this.V0;
        if (r104 != null) goto L18;
    L20:
        if (r101 == false) goto L40;
        return true;
    L18:
        if (r104.S1(r100) == true) goto L20;
        r101 = true;
        goto L20
    L22:
        v r105 = this.V0;
        if (r105 != null) goto L25;
    L27:
        boolean r106 = false;
    L28:
        if (r106 == true) goto L30;
        v r107 = this.V0;
        if (r107 != null) goto L34;
    L36:
        if (r101 == false) goto L40;
        return true;
    L34:
        if (r107.S1(r100) == true) goto L36;
        r101 = true;
        goto L36
    L30:
        return onTextContextMenuItem(R.id.copy);
    L25:
        if (r105.canEdit() == true) goto L27;
        r106 = true;
        goto L28
    L38:
        Selection.selectAll(getText());
    L40:
        return super.onTextContextMenuItem(r100);
    }

    @Override // gp4.g
    public void setIPermissionCopyChecker(v r100) {
        this.V0 = r100;
    }

    public SignatureEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SignatureEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

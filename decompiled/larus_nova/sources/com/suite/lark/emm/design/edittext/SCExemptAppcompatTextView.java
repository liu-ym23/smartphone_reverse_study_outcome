package com.suite.lark.emm.design.edittext;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/emm/design/edittext/SCExemptAppcompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/suite/lark/emm/design/edittext/ITokenComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTextContextMenuItem", "", "id", "interceptContextMenuItem", "textView", "Landroid/widget/TextView;", "getToken", "Lcom/bytedance/supervisor/token/Token;", "enterprise-mobility-management-design-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SCExemptAppcompatTextView extends AppCompatTextView {
    public Token getToken() {
        return new Token("LARK-PSDA-SCExemptAppcompatTextView_internal_clipborad");
    }

    public SCExemptAppcompatTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 == 16908321) goto L5;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
    L12:
        return true;
    L11:
        if (super.onTextContextMenuItem(r100) == true) goto L12;
        return false;
    L5:
        if (SCEditableCompat.b() == false) goto L8;
        ClipData r102 = SCEditableCompat.e(this);
        SCClipboardProvider.a().O0(SCClipboardScene.SCENE_DISABLE_COPY);
        super.onTextContextMenuItem(r100);
        SCEditableCompat.a(r102, SCClipboardScene.SCENE_SYSTEM_ONCE, getToken());
        r101 = true;
        goto L9
    }

    public SCExemptAppcompatTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public SCExemptAppcompatTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}

package com.suite.lark.emm.design.edittext;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001d\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/suite/lark/emm/design/edittext/SCAppCompatEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/suite/lark/emm/design/edittext/ITokenComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scene", "Lcom/suite/lark/emm/impl/clipboard/SCClipboardScene;", "setScene", "", "checkScene", "onTextContextMenuItem", "", "id", "interceptContextMenuItem", "editable", "Landroid/widget/EditText;", "getToken", "Lcom/bytedance/supervisor/token/Token;", "Companion", "enterprise-mobility-management-design-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SCAppCompatEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SCClipboardScene f460428a;

    public static final class a {
    }

    static {
    }

    public Token getToken() {
        return new Token("LARK-PSDA-SCAppCompatEditText_internal_clipborad");
    }

    public SCAppCompatEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        switch(r100) {
            case 16908320: goto L7;
            case 16908321: goto L7;
            case 16908322: goto L5;
            default: goto L12;
        };
    L5:
        Lazy r101 = SCEditableCompat.f460430a;
        boolean r102 = SCEditableCompat.d(this, this.f460428a, getToken());
    L13:
        if (r102 == false) goto L15;
    L16:
        return true;
    L15:
        if (super.onTextContextMenuItem(r100) == true) goto L16;
        return false;
    L12:
        r102 = false;
        goto L13
    L7:
        if (SCEditableCompat.b() == false) goto L12;
        if (this.f460428a == SCClipboardScene.SCENE_DEFAULT) goto L12;
        ClipData r103 = SCEditableCompat.e(this);
        SCClipboardProvider.a().O0(SCClipboardScene.SCENE_DISABLE_COPY);
        super.onTextContextMenuItem(r100);
        SCEditableCompat.a(r103, this.f460428a, getToken());
        r102 = true;
        goto L13
    }

    public final void setScene(SCClipboardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f460428a = r100;
        if (r100 == SCClipboardScene.SCENE_ENCRYPT) goto L5;
        return;
    L5:
        if ((r100.getParam() instanceof String) == true) goto L9;
        Log.e("SCAppCompatEditText", "encrypt scene but wrong param: " + this.f460428a.getParam() + ", ignore scene");
        this.f460428a = SCClipboardScene.SCENE_DEFAULT;
        return;
    }

    public SCAppCompatEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f460428a = SCClipboardScene.SCENE_DEFAULT;
    }

    public SCAppCompatEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f460428a = SCClipboardScene.SCENE_DEFAULT;
    }
}

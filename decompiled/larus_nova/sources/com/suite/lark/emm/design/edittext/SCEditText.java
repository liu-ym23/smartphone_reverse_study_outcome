package com.suite.lark.emm.design.edittext;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import com.suite.lark.emm.impl.clipboard.model.OpenAppDataModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001f\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/suite/lark/emm/design/edittext/SCEditText;", "Landroid/widget/EditText;", "Lcom/suite/lark/emm/design/edittext/ITokenComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scene", "Lcom/suite/lark/emm/impl/clipboard/SCClipboardScene;", "setScene", "", "setOpenPlatformAppId", "appId", "", "checkScene", "onTextContextMenuItem", "", "id", "interceptContextMenuItem", "editable", "getToken", "Lcom/bytedance/supervisor/token/Token;", "Companion", "enterprise-mobility-management-design-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SCEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SCClipboardScene f460429a;

    public static final class a {
    }

    static {
    }

    public SCEditText(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0);
    }

    public Token getToken() {
        return new Token("LARK-PSDA-SCEditText_internal_clipborad");
    }

    public SCEditText(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        switch(r100) {
            case 16908320: goto L7;
            case 16908321: goto L7;
            case 16908322: goto L5;
            default: goto L12;
        };
    L5:
        Lazy r101 = SCEditableCompat.f460430a;
        boolean r102 = SCEditableCompat.d(this, this.f460429a, getToken());
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
        if (this.f460429a == SCClipboardScene.SCENE_DEFAULT) goto L12;
        ClipData r103 = SCEditableCompat.e(this);
        SCClipboardProvider.a().O0(SCClipboardScene.SCENE_DISABLE_COPY);
        super.onTextContextMenuItem(r100);
        SCEditableCompat.a(r103, this.f460429a, getToken());
        r102 = true;
        goto L13
    }

    public final void setOpenPlatformAppId(String r100) {
        if (SCClipboardProvider.b() == true) goto L5;
        return;
    L5:
        SCClipboardScene r101 = SCClipboardScene.SCENE_OPEN_APP;
        r101.setParam(e0.c(new OpenAppDataModel(r100, null)));
        setScene(r101);
    }

    public final void setScene(SCClipboardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f460429a = r100;
        if (r100 == SCClipboardScene.SCENE_ENCRYPT) goto L5;
        return;
    L5:
        if ((r100.getParam() instanceof String) == true) goto L9;
        Log.e("SCEditText", "encrypt scene but wrong param: " + this.f460429a.getParam() + ", ignore scene");
        this.f460429a = SCClipboardScene.SCENE_DEFAULT;
        return;
    }

    public SCEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f460429a = SCClipboardScene.SCENE_DEFAULT;
    }

    public SCEditText(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, 0);
        this.f460429a = SCClipboardScene.SCENE_DEFAULT;
    }
}

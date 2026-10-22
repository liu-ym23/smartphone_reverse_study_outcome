package com.suite.lark.emm.design.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SCEditableCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f460430a = null;

    static {
        f460430a = LazyKt.lazy(SCEditableCompat$zzyIntegratedLazy$2.INSTANCE);
    }

    public static boolean b() {
        if (((Boolean) f460430a.getValue()).booleanValue() == false) goto L7;
        return false;
    L7:
        return com.suite.lark.emm.impl.clipboard.utils.a.a();
    }

    public static ClipData e(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        int r101 = r100.getSelectionStart();
        int r102 = r100.getSelectionEnd();
        Log.i("SCEditableCompat", "prepareClipDataBeforeCopy: start, end is (" + r101 + " , " + r102 + ')');
        if (r101 > r102) goto L5;
        Editable r103 = r100.getEditableText();
        if (r103 == null) goto L9;
        String r104 = r103.subSequence(Math.max(0, r101), Math.min(r102, r103.length())).toString();
    L11:
        return ClipData.newPlainText("", r104);
    L9:
        r104 = r100.getText().subSequence(Math.max(0, r101), Math.min(r102, r100.length())).toString();
        goto L11
    L5:
        return ClipData.newPlainText("", "");
    }

    public static ClipData c(Token r100, SCClipboardScene r101) throws SensitiveAPIException {
        if (r100 != null) goto L6;
        Log.i("SCEditableCompat", "getCurrentClipData no token");
        return null;
    L6:
        if (SCClipboardProvider.b() == false) goto L12;
        boc.b r102 = SCClipboardProvider.a();
        if (r101 == null) goto L11;
        r102.Q0(r101);
    L11:
        return r102.T0(r100);
    L12:
        Object r103 = LarkContext.getApplication().getSystemService(DataType.CLIPBOARD);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.content.ClipboardManager");
        qf7.a r104 = qf7.a.f532746a;
        return r104.d((ClipboardManager) r103, r100);
    }

    public static void a(ClipData r100, SCClipboardScene r101, Token r102) {
        Intrinsics.checkNotNullParameter(r100, "clip");
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r102 != null) goto L6;
        Log.i("SCEditableCompat", "copyActionWithScene token null");
        return;
    L6:
        boc.b r103 = SCClipboardProvider.a();
        r103.Q0(r101);
        r103.M0(r100, r102);     // Catch: SensitiveAPIException -> L9
        return;
    L9:
        e = move-exception;
        Log.i("SCEditableCompat", "copyActionWithScene error: " + e.getMessage());
    }

    public static boolean d(EditText r100, SCClipboardScene r101, Token r102) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "token");
        if (b() == true) goto L38;
        return false;
    L38:
        ClipData r103 = c(r102, r101);     // Catch: SensitiveAPIException -> L35
        int r104 = a.f460432a;
        if (r103 != null) goto L11;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L34;
        Intrinsics.checkNotNullParameter(r100, "editable");
        Log.i("SCEditableCompat", "pasteToEditText");
        if ((r100.getSelectionEnd() - r100.getSelectionStart()) <= 0) goto L25;
        r100.getEditableText().delete(r100.getSelectionStart(), r100.getSelectionEnd());
    L25:
        int r106 = r100.getSelectionStart();
        if (r106 >= 0) goto L28;
        r106 = r100.getEditableText().length();
    L28:
        r100.setSelection(r106);
        int r107 = r100.getSelectionStart();
        SpannableStringBuilder r108 = new SpannableStringBuilder(a.a(r103));
        r100.getEditableText().replace(r107, r100.getSelectionEnd(), r108);
        if ((r108.length() + r107) <= r100.length()) goto L31;
        int r109 = r100.length();
    L32:
        r100.setSelection(r109);
        return true;
    L31:
        r109 = r108.length() + r107;
        goto L32
    L34:
        return false;
    L11:
        if (r103.getDescription().hasMimeType("text/plain") == true) goto L15;
        if (r103.getDescription().hasMimeType("text/html") == false) goto L20;
    L15:
        if (a.a(r103).length() <= 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L20;
        r105 = true;
        goto L21
    L17:
        r110 = false;
    L35:
        e = move-exception;
        Log.i("SCEditableCompat", "getCurrentClipData token error, " + e.getMessage());
        return true;
    }
}

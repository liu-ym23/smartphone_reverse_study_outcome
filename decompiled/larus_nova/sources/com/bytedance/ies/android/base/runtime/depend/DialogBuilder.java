package com.bytedance.ies.android.base.runtime.depend;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.ui.IAdHostStyleUIDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006."}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/DialogBuilder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "title", "", "message", "positiveBtnText", "positiveClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeBtnText", "negativeClickListener", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "cancelOnTouchOutside", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Z)V", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "getCancelOnTouchOutside", "()Z", "getContext", "()Landroid/content/Context;", "getMessage", "()Ljava/lang/String;", "getNegativeBtnText", "getNegativeClickListener", "()Landroid/content/DialogInterface$OnClickListener;", "getPositiveBtnText", "getPositiveClickListener", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public final class DialogBuilder {
    private final DialogInterface.OnCancelListener cancelListener;
    private final boolean cancelOnTouchOutside;
    private final Context context;
    private final String message;
    private final String negativeBtnText;
    private final DialogInterface.OnClickListener negativeClickListener;
    private final String positiveBtnText;
    private final DialogInterface.OnClickListener positiveClickListener;
    private final String title;

    public static /* synthetic */ DialogBuilder copy$default(DialogBuilder r110, Context r111, String r112, String r113, String r114, DialogInterface.OnClickListener r115, String r116, DialogInterface.OnClickListener r117, DialogInterface.OnCancelListener r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Context r100 = r110.context;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.message;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.positiveBtnText;
    L19:
        if ((r210 & 16) == 0) goto L21;
        DialogInterface.OnClickListener r104 = r110.positiveClickListener;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.negativeBtnText;
    L27:
        if ((r210 & 64) == 0) goto L29;
        DialogInterface.OnClickListener r106 = r110.negativeClickListener;
    L31:
        if ((r210 & 128) == 0) goto L33;
        DialogInterface.OnCancelListener r107 = r110.cancelListener;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.cancelOnTouchOutside;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.positiveBtnText;
    }

    public final DialogInterface.OnClickListener component5() {
        return this.positiveClickListener;
    }

    public final String component6() {
        return this.negativeBtnText;
    }

    public final DialogInterface.OnClickListener component7() {
        return this.negativeClickListener;
    }

    public final DialogInterface.OnCancelListener component8() {
        return this.cancelListener;
    }

    public final boolean component9() {
        return this.cancelOnTouchOutside;
    }

    public final DialogBuilder copy(Context r110, String r111, String r112, String r113, DialogInterface.OnClickListener r114, String r115, DialogInterface.OnClickListener r116, DialogInterface.OnCancelListener r117, boolean r210) {
        return new DialogBuilder(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DialogBuilder) == false) goto L24;
        DialogBuilder r101 = (DialogBuilder) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.positiveBtnText, r101.positiveBtnText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.positiveClickListener, r101.positiveClickListener) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.negativeBtnText, r101.negativeBtnText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.negativeClickListener, r101.negativeClickListener) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.cancelListener, r101.cancelListener) == true) goto L22;
        return false;
    L22:
        if (this.cancelOnTouchOutside == r101.cancelOnTouchOutside) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Context r100 = this.context;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.message;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.positiveBtnText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        DialogInterface.OnClickListener r113 = this.positiveClickListener;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.negativeBtnText;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        DialogInterface.OnClickListener r119 = this.negativeClickListener;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        DialogInterface.OnCancelListener r122 = this.cancelListener;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        int r123 = (r121 + r101) * 31;
        boolean r124 = this.cancelOnTouchOutside;
        ?? r125 = r124;
        if (r124 == false) goto L37;
        r125 = 1;
    L37:
        return r123 + r125;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DialogBuilder(context=" + this.context + ", title=" + this.title + ", message=" + this.message + ", positiveBtnText=" + this.positiveBtnText + ", positiveClickListener=" + this.positiveClickListener + ", negativeBtnText=" + this.negativeBtnText + ", negativeClickListener=" + this.negativeClickListener + ", cancelListener=" + this.cancelListener + ", cancelOnTouchOutside=" + this.cancelOnTouchOutside + ")";
    }

    public final DialogInterface.OnCancelListener getCancelListener() {
        return this.cancelListener;
    }

    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getNegativeBtnText() {
        return this.negativeBtnText;
    }

    public final DialogInterface.OnClickListener getNegativeClickListener() {
        return this.negativeClickListener;
    }

    public final String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    public final DialogInterface.OnClickListener getPositiveClickListener() {
        return this.positiveClickListener;
    }

    public final String getTitle() {
        return this.title;
    }

    public DialogBuilder(Context r100, String r101, String r102, String r103, DialogInterface.OnClickListener r104, String r105, DialogInterface.OnClickListener r106, DialogInterface.OnCancelListener r107, boolean r108) {
        this.context = r100;
        this.title = r101;
        this.message = r102;
        this.positiveBtnText = r103;
        this.positiveClickListener = r104;
        this.negativeBtnText = r105;
        this.negativeClickListener = r106;
        this.cancelListener = r107;
        this.cancelOnTouchOutside = r108;
    }

    public /* synthetic */ DialogBuilder(Context r110, String r111, String r112, String r113, DialogInterface.OnClickListener r114, String r115, DialogInterface.OnClickListener r116, DialogInterface.OnCancelListener r117, boolean r118, int r119, DefaultConstructorMarker r210) {
        DialogInterface.OnCancelListener r100 = null;
        if ((r119 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r119 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r119 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r119 & 16) == 0) goto L17;
        DialogInterface.OnClickListener r104 = null;
    L19:
        if ((r119 & 32) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r119 & 64) == 0) goto L25;
        DialogInterface.OnClickListener r106 = null;
    L27:
        if ((r119 & 128) != 0) goto L31;
        r100 = r117;
    L31:
        if ((r119 & 256) == 0) goto L33;
        boolean r107 = true;
    L34:
        this(r110, r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r118;
        goto L34
    L25:
        r106 = r116;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}

package com.bytedance.android.livesdk.livecommerce.oldflash;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/InputArgs;", "Ljava/io/Serializable;", "", "hint", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "content", "getContent", "autoGenTitle", "getAutoGenTitle", "", "inputType", "I", "getInputType", "()I", "setInputType", "(I)V", "label", "getLabel", "inputLimitHigher", "getInputLimitHigher", "setInputLimitHigher", "inputLimitLower", "getInputLimitLower", "setInputLimitLower", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "inputToastHigher", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "getInputToastHigher", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "inputToastLower", "getInputToastLower", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILcom/bytedance/android/livesdk/livecommerce/oldflash/n;Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputArgs implements Serializable {
    private final String autoGenTitle;
    private final String content;
    private final String hint;
    private int inputLimitHigher;
    private int inputLimitLower;
    private final n inputToastHigher;
    private final n inputToastLower;
    private int inputType;
    private final String label;

    public InputArgs() {
        this(null, null, null, 0, null, 0, 0, null, null, 511, null);
    }

    public final String getAutoGenTitle() {
        return this.autoGenTitle;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getInputLimitHigher() {
        return this.inputLimitHigher;
    }

    public final int getInputLimitLower() {
        return this.inputLimitLower;
    }

    public final n getInputToastHigher() {
        return this.inputToastHigher;
    }

    public final n getInputToastLower() {
        return this.inputToastLower;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setInputLimitHigher(int r1) {
        this.inputLimitHigher = r1;
    }

    public final void setInputLimitLower(int r1) {
        this.inputLimitLower = r1;
    }

    public final void setInputType(int r1) {
        this.inputType = r1;
    }

    public InputArgs(String r1, String r2, String r3, int r4, String r5, int r6, int r7, n r8, n r9) {
        this.hint = r1;
        this.content = r2;
        this.autoGenTitle = r3;
        this.inputType = r4;
        this.label = r5;
        this.inputLimitHigher = r6;
        this.inputLimitLower = r7;
        this.inputToastHigher = r8;
        this.inputToastLower = r9;
        if (r6 > 0) goto L5;
        this.inputLimitHigher = 20;
    L5:
        if (r7 >= 0) goto L13;
        int r10 = 1;
        if (r4 == 0) goto L11;
        if (r4 == 1) goto L11;
        r10 = 0;
    L11:
        this.inputLimitLower = r10;
        return;
    }

    public /* synthetic */ InputArgs(String r11, String r12, String r13, int r14, String r15, int r16, int r17, n r18, n r19, int r20, DefaultConstructorMarker r21) {
        n r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r5 = 2;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r7 = 20;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = Integer.MIN_VALUE;
    L31:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        n r9 = null;
    L35:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}

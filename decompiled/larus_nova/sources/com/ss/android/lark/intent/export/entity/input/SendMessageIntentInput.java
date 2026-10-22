package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendMessageIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", PickerReporterConstants.KEY.TARGET, "Lcom/ss/android/lark/intent/export/entity/input/SendTarget;", "content", "Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/input/SendTarget;Lcom/ss/android/lark/intent/export/entity/input/SendContent;)V", "getTarget", "()Lcom/ss/android/lark/intent/export/entity/input/SendTarget;", "getContent", "()Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageIntentInput extends IntentInput implements Serializable {
    private final SendContent content;
    private final SendTarget target;

    public static /* synthetic */ SendMessageIntentInput copy$default(SendMessageIntentInput r100, SendTarget r101, SendContent r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        return r100.copy(r101, r102);
    }

    public final SendTarget component1() {
        return this.target;
    }

    public final SendContent component2() {
        return this.content;
    }

    public final SendMessageIntentInput copy(SendTarget r100, SendContent r101) {
        return new SendMessageIntentInput(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendMessageIntentInput) == true) goto L8;
        return false;
    L8:
        SendMessageIntentInput r101 = (SendMessageIntentInput) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        SendTarget r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SendContent r104 = this.content;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendMessageIntentInput(target=");
        Object r101 = this.target;
        Object r102 = "null";
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        r100.append(r101);
        r100.append(", content=");
        SendContent r103 = this.content;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    }

    public final SendContent getContent() {
        return this.content;
    }

    public final SendTarget getTarget() {
        return this.target;
    }

    public SendMessageIntentInput(SendTarget r100, SendContent r101) {
        super(IntentInput.IntentType.SEND_MESSAGE);
        this.target = r100;
        this.content = r101;
    }
}

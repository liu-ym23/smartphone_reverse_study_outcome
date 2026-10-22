package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0005H\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchContactIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", PickerReporterConstants.KEY.TARGET, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "targetType", "Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "<init>", "(Ljava/util/ArrayList;Lcom/ss/android/lark/intent/export/entity/input/TargetType;)V", "getTarget", "()Ljava/util/ArrayList;", "getTargetType", "()Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchContactIntentInput extends IntentInput implements Serializable {
    private final ArrayList<String> target;
    private final TargetType targetType;

    public String toString() {
        return "SearchContactIntentInput(target=" + this.target + ", targetType=" + this.targetType + ')';
    }

    public final ArrayList<String> getTarget() {
        return this.target;
    }

    public final TargetType getTargetType() {
        return this.targetType;
    }

    public SearchContactIntentInput(ArrayList<String> r100, TargetType r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "targetType");
        super(IntentInput.IntentType.SEARCH_CONTACT);
        this.target = r100;
        this.targetType = r101;
    }
}

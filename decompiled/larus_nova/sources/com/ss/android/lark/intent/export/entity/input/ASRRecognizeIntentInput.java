package com.ss.android.lark.intent.export.entity.input;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/ASRRecognizeIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "uri", "", "<init>", "(Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ASRRecognizeIntentInput extends IntentInput implements Serializable {
    private final String uri;

    public String toString() {
        StringBuilder r100 = new StringBuilder("ASRRecognizeIntentInput(uri='");
        String r101 = this.uri;
        if (r101 != null) goto L5;
        r101 = "nil";
    L5:
        r100.append(r101);
        r100.append("')");
        return r100.toString();
    }

    public final String getUri() {
        return this.uri;
    }

    public ASRRecognizeIntentInput(String r100) {
        super(IntentInput.IntentType.ASR_RECOGNIZE);
        this.uri = r100;
    }
}

package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \u0013*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0006\u0013\u0014\u0015\u0016\u0017\u0018B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/CallbackData;", "T", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "", "data", "keyboard", "", "<init>", "(Ljava/lang/String;Ljava/io/Serializable;I)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getKeyboard", "()I", "toString", "Companion", "Type", "HistoryData", "FeedbackData", "ImagesKey", "UrlKey", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallbackData<T extends Serializable> implements NonProguard {
    public static final a Companion = null;
    private final T data;
    private final int keyboard;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "CallbackData(type='" + this.type + "', data=" + this.data + ", keyboard=" + this.keyboard + ')';
    }

    public final T getData() {
        return this.data;
    }

    public final int getKeyboard() {
        return this.keyboard;
    }

    public final String getType() {
        return this.type;
    }

    public CallbackData(String r2, T r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
        this.data = r3;
        this.keyboard = r4;
    }
}

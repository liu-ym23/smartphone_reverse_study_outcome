package com.bytedance.ee.bear.tts.tone;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0000H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/tts/tone/TtsToneBean;", "Ljava/io/Serializable;", "", "<init>", "()V", "toneId", "", "getToneId", "()Ljava/lang/String;", "setToneId", "(Ljava/lang/String;)V", "toneName", "getToneName", "setToneName", "clone", "toString", "Companion", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsToneBean implements Serializable, Cloneable {
    public static final a Companion = null;
    private String toneId;
    private String toneName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TtsToneBean() {
    }

    public String toString() {
        return "TtsToneBean@" + hashCode() + "{toneId: " + this.toneId + ", toneName: " + this.toneName + '}';
    }

    public TtsToneBean clone() {
        Object r0 = super.clone();     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.tts.tone.TtsToneBean");     // Catch: Exception -> L4
        TtsToneBean r1 = (TtsToneBean) r0;     // Catch: Exception -> L4
    L6:
        r1.toneId = this.toneId;
        r1.toneName = this.toneName;
        return r1;
    L4:
        e = move-exception;
        tt5.a.e("TtsToneBean", "clone, error:", e, false);
        r1 = new TtsToneBean();
        goto L6
    }

    public final String getToneId() {
        return this.toneId;
    }

    public final String getToneName() {
        return this.toneName;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m633clone() {
        return clone();
    }

    public final void setToneId(String r1) {
        this.toneId = r1;
    }

    public final void setToneName(String r1) {
        this.toneName = r1;
    }
}

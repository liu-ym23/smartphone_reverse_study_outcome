package com.bytedance.android.livesdk.livecommerce.playback.applog;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/applog/ExplainPlayBackPDPEntryLogExtra;", "Ljava/io/Serializable;", "", "isFloat", "Ljava/lang/String;", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "entranceForm", "getEntranceForm", "setEntranceForm", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlayBackPDPEntryLogExtra implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String entranceForm;
    private String isFloat;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ExplainPlayBackPDPEntryLogExtra() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getEntranceForm() {
        return this.entranceForm;
    }

    public final String isFloat() {
        return this.isFloat;
    }

    public final void setEntranceForm(String r1) {
        this.entranceForm = r1;
    }

    public final void setFloat(String r1) {
        this.isFloat = r1;
    }

    public ExplainPlayBackPDPEntryLogExtra(String r1, String r2) {
        this.isFloat = r1;
        this.entranceForm = r2;
    }

    public /* synthetic */ ExplainPlayBackPDPEntryLogExtra(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}

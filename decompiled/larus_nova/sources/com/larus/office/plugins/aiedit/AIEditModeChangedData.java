package com.larus.office.plugins.aiedit;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/office/plugins/aiedit/AIEditModeChangedData;", "", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIEditModeChangedData {
    public static final a Companion = null;
    public static final int MODE_AI_REWRITE = 1;

    @SerializedName("mode")
    private Integer mode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AIEditModeChangedData() {
        this.mode = 0;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final void setMode(Integer r100) {
        this.mode = r100;
    }
}

package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ButtonStatus;", "", "Normal", "Forbidden", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus Forbidden = null;
    public static final ButtonStatus Normal = null;
    public static final /* synthetic */ ButtonStatus[] a = null;

    static {
        ButtonStatus r1 = new ButtonStatus("Normal", 0);
        Normal = r1;
        ButtonStatus r2 = new ButtonStatus("Forbidden", 1);
        Forbidden = r2;
        a = new ButtonStatus[]{r1, r2};
    }

    public static ButtonStatus valueOf(String r1) {
        return (ButtonStatus) r27.a.a(ButtonStatus.class, r1);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) a.clone();
    }

    public ButtonStatus(String r1, int r2) {
        super(r1, r2);
    }
}

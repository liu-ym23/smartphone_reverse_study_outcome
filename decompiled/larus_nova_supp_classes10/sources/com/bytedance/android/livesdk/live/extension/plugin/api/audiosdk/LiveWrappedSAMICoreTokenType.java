package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreTokenType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "TOKEN_TO_B", "TOKEN_TO_C_D", "TOKEN_TO_B_MIXED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreTokenType extends Enum<LiveWrappedSAMICoreTokenType> {
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_B = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_B_MIXED = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_C_D = null;
    public static final /* synthetic */ LiveWrappedSAMICoreTokenType[] a = null;
    public static final SparseArray<LiveWrappedSAMICoreTokenType> b = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreTokenType$a] */
    static {
        int r3 = 0;
        LiveWrappedSAMICoreTokenType r1 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_B", 0, 0);
        TOKEN_TO_B = r1;
        LiveWrappedSAMICoreTokenType r2 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_C_D", 1, 1);
        TOKEN_TO_C_D = r2;
        LiveWrappedSAMICoreTokenType r4 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_B_MIXED", 2, 2);
        TOKEN_TO_B_MIXED = r4;
        a = new LiveWrappedSAMICoreTokenType[]{r1, r2, r4};
        Companion = new a();
        b = new SparseArray();
        LiveWrappedSAMICoreTokenType[] r0 = values();
        int r5 = r0.length;
    L3:
        if (r3 >= r5) goto L5;
        LiveWrappedSAMICoreTokenType r6 = r0[r3];
        b.put(r6.value, r6);
        r3 = r3 + 1;
        goto L3
    }

    public static LiveWrappedSAMICoreTokenType valueOf(String r1) {
        return (LiveWrappedSAMICoreTokenType) r27.a.a(LiveWrappedSAMICoreTokenType.class, r1);
    }

    public static LiveWrappedSAMICoreTokenType[] values() {
        return (LiveWrappedSAMICoreTokenType[]) a.clone();
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreTokenType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

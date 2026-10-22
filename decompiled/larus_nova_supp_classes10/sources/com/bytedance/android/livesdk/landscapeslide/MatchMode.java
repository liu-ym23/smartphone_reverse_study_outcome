package com.bytedance.android.livesdk.landscapeslide;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/MatchMode;", "", "REGEX", "EQUALS", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MatchMode extends Enum<MatchMode> {
    public static final MatchMode EQUALS = null;
    public static final MatchMode REGEX = null;
    public static final /* synthetic */ MatchMode[] a = null;

    static {
        MatchMode r1 = new MatchMode("REGEX", 0);
        REGEX = r1;
        MatchMode r2 = new MatchMode("EQUALS", 1);
        EQUALS = r2;
        a = new MatchMode[]{r1, r2};
    }

    public static MatchMode valueOf(String r1) {
        return (MatchMode) r27.a.a(MatchMode.class, r1);
    }

    public static MatchMode[] values() {
        return (MatchMode[]) a.clone();
    }

    public MatchMode(String r1, int r2) {
        super(r1, r2);
    }
}

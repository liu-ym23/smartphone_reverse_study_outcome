package com.bytedance.android.livesdk.livecommerce.intro.model.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroUpdateType;", "", "CREATE", "UPDATE", "MUST_SHOW_NEW_CARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroUpdateType extends Enum<IntroUpdateType> {
    public static final IntroUpdateType CREATE = null;
    public static final IntroUpdateType MUST_SHOW_NEW_CARD = null;
    public static final IntroUpdateType UPDATE = null;
    public static final /* synthetic */ IntroUpdateType[] a = null;

    static {
        IntroUpdateType r1 = new IntroUpdateType("CREATE", 0);
        CREATE = r1;
        IntroUpdateType r2 = new IntroUpdateType("UPDATE", 1);
        UPDATE = r2;
        IntroUpdateType r3 = new IntroUpdateType("MUST_SHOW_NEW_CARD", 2);
        MUST_SHOW_NEW_CARD = r3;
        a = new IntroUpdateType[]{r1, r2, r3};
    }

    public static IntroUpdateType valueOf(String r1) {
        return (IntroUpdateType) a.a(IntroUpdateType.class, r1);
    }

    public static IntroUpdateType[] values() {
        return (IntroUpdateType[]) a.clone();
    }

    public IntroUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}

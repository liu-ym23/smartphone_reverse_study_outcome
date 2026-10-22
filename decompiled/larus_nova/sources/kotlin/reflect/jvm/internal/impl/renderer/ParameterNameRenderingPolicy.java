package kotlin.reflect.jvm.internal.impl.renderer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum ParameterNameRenderingPolicy extends Enum<ParameterNameRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ParameterNameRenderingPolicy[] $VALUES = null;
    public static final ParameterNameRenderingPolicy ALL = null;
    public static final ParameterNameRenderingPolicy NONE = null;
    public static final ParameterNameRenderingPolicy ONLY_NON_SYNTHESIZED = null;

    private static final /* synthetic */ ParameterNameRenderingPolicy[] $values() {
        return new ParameterNameRenderingPolicy[]{ALL, ONLY_NON_SYNTHESIZED, NONE};
    }

    static {
        ALL = new ParameterNameRenderingPolicy(AccountType.ALL, 0);
        ONLY_NON_SYNTHESIZED = new ParameterNameRenderingPolicy("ONLY_NON_SYNTHESIZED", 1);
        NONE = new ParameterNameRenderingPolicy(UserProfileEvent.POSITION_NONE, 2);
        ParameterNameRenderingPolicy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[]) $VALUES.clone();
    }

    public static ParameterNameRenderingPolicy valueOf(String r100) {
        return (ParameterNameRenderingPolicy) a.a(ParameterNameRenderingPolicy.class, r100);
    }

    private ParameterNameRenderingPolicy(String r100, int r101) {
        super(r100, r101);
    }
}

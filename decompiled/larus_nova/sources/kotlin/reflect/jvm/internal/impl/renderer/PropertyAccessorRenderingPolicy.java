package kotlin.reflect.jvm.internal.impl.renderer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum PropertyAccessorRenderingPolicy extends Enum<PropertyAccessorRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES = null;
    public static final PropertyAccessorRenderingPolicy DEBUG = null;
    public static final PropertyAccessorRenderingPolicy NONE = null;
    public static final PropertyAccessorRenderingPolicy PRETTY = null;

    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $values() {
        return new PropertyAccessorRenderingPolicy[]{PRETTY, DEBUG, NONE};
    }

    static {
        PRETTY = new PropertyAccessorRenderingPolicy("PRETTY", 0);
        DEBUG = new PropertyAccessorRenderingPolicy("DEBUG", 1);
        NONE = new PropertyAccessorRenderingPolicy(UserProfileEvent.POSITION_NONE, 2);
        PropertyAccessorRenderingPolicy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }

    public static PropertyAccessorRenderingPolicy valueOf(String r100) {
        return (PropertyAccessorRenderingPolicy) a.a(PropertyAccessorRenderingPolicy.class, r100);
    }

    private PropertyAccessorRenderingPolicy(String r100, int r101) {
        super(r100, r101);
    }
}

package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum OverrideRenderingPolicy extends Enum<OverrideRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OverrideRenderingPolicy[] $VALUES = null;
    public static final OverrideRenderingPolicy RENDER_OPEN = null;
    public static final OverrideRenderingPolicy RENDER_OPEN_OVERRIDE = null;
    public static final OverrideRenderingPolicy RENDER_OVERRIDE = null;

    private static final /* synthetic */ OverrideRenderingPolicy[] $values() {
        return new OverrideRenderingPolicy[]{RENDER_OVERRIDE, RENDER_OPEN, RENDER_OPEN_OVERRIDE};
    }

    static {
        RENDER_OVERRIDE = new OverrideRenderingPolicy("RENDER_OVERRIDE", 0);
        RENDER_OPEN = new OverrideRenderingPolicy("RENDER_OPEN", 1);
        RENDER_OPEN_OVERRIDE = new OverrideRenderingPolicy("RENDER_OPEN_OVERRIDE", 2);
        OverrideRenderingPolicy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[]) $VALUES.clone();
    }

    public static OverrideRenderingPolicy valueOf(String r100) {
        return (OverrideRenderingPolicy) a.a(OverrideRenderingPolicy.class, r100);
    }

    private OverrideRenderingPolicy(String r100, int r101) {
        super(r100, r101);
    }
}

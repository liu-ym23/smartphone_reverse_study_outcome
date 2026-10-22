package com.obric.capabilitykit.entity.enums;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RUNNING", "PAUSED", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum CountdownStatusEnum extends Enum<CountdownStatusEnum> {
    private static final /* synthetic */ CountdownStatusEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final CountdownStatusEnum PAUSED = null;
    public static final CountdownStatusEnum RUNNING = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ CountdownStatusEnum[] $values() {
        return new CountdownStatusEnum[]{RUNNING, PAUSED};
    }

    static {
        RUNNING = new CountdownStatusEnum("RUNNING", 0);
        PAUSED = new CountdownStatusEnum("PAUSED", 1);
        $VALUES = $values();
        Companion = new a();
    }

    private CountdownStatusEnum(String r100, int r101) {
        super(r100, r101);
    }

    public static CountdownStatusEnum valueOf(String r100) {
        return (CountdownStatusEnum) r27.a.a(CountdownStatusEnum.class, r100);
    }

    public static CountdownStatusEnum[] values() {
        return (CountdownStatusEnum[]) $VALUES.clone();
    }
}

package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public abstract enum Pack200Strategy extends Enum<Pack200Strategy> {
    private static final /* synthetic */ Pack200Strategy[] $VALUES = null;
    public static final Pack200Strategy IN_MEMORY = null;
    public static final Pack200Strategy TEMP_FILE = null;

    public abstract StreamBridge newStreamBridge() throws IOException;

    static {
        final String r100 = "IN_MEMORY";
        final int r101 = 0;
        Pack200Strategy r102 = new AnonymousClass1(r100, r101);
        IN_MEMORY = r102;
        final String r103 = "TEMP_FILE";
        final int r104 = 1;
        Pack200Strategy r105 = new AnonymousClass2(r103, r104);
        TEMP_FILE = r105;
        $VALUES = new Pack200Strategy[]{r102, r105};
    }

    public static Pack200Strategy[] values() {
        return (Pack200Strategy[]) $VALUES.clone();
    }

    public static Pack200Strategy valueOf(String r100) {
        return (Pack200Strategy) a.a(Pack200Strategy.class, r100);
    }

    private Pack200Strategy(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ Pack200Strategy(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}

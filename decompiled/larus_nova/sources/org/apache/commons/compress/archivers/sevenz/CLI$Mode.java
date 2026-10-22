package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
abstract enum CLI$Mode extends Enum<CLI$Mode> {
    private static final /* synthetic */ CLI$Mode[] $VALUES = null;
    public static final CLI$Mode EXTRACT = null;
    public static final CLI$Mode LIST = null;
    private final String message;

    public abstract void takeAction(SevenZFile r100, SevenZArchiveEntry r101) throws IOException;

    static {
        final String r100 = "Analysing";
        final String r101 = "LIST";
        final int r102 = 0;
        CLI$Mode r103 = new AnonymousClass1(r101, r102, r100);
        LIST = r103;
        final String r104 = "Extracting";
        final String r105 = "EXTRACT";
        final int r106 = 1;
        CLI$Mode r107 = new AnonymousClass2(r105, r106, r104);
        EXTRACT = r107;
        $VALUES = new CLI$Mode[]{r103, r107};
    }

    public static CLI$Mode[] values() {
        return (CLI$Mode[]) $VALUES.clone();
    }

    public String getMessage() {
        return this.message;
    }

    public static CLI$Mode valueOf(String r100) {
        return (CLI$Mode) a.a(CLI$Mode.class, r100);
    }

    private CLI$Mode(String r100, int r101, String r102) {
        super(r100, r101);
        this.message = r102;
    }

    public /* synthetic */ CLI$Mode(String r100, int r101, String r102, CLI$1 r103) {
        this(r100, r101, r102);
    }
}

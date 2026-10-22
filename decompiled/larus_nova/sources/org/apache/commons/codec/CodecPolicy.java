package org.apache.commons.codec;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum CodecPolicy extends Enum<CodecPolicy> {
    private static final /* synthetic */ CodecPolicy[] $VALUES = null;
    public static final CodecPolicy LENIENT = null;
    public static final CodecPolicy STRICT = null;

    private static /* synthetic */ CodecPolicy[] $values() {
        return new CodecPolicy[]{STRICT, LENIENT};
    }

    static {
        STRICT = new CodecPolicy("STRICT", 0);
        LENIENT = new CodecPolicy("LENIENT", 1);
        $VALUES = $values();
    }

    public static CodecPolicy[] values() {
        return (CodecPolicy[]) $VALUES.clone();
    }

    public static CodecPolicy valueOf(String r100) {
        return (CodecPolicy) a.a(CodecPolicy.class, r100);
    }

    private CodecPolicy(String r100, int r101) {
        super(r100, r101);
    }
}

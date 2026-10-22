package com.bytedance.ug.sdk.tools.debug.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/tools/debug/api/model/DebugToolAlignment;", "", "LEFT", "Right", "debug-api_release"}, k = 1, mv = {1, 4, 0})
public final enum DebugToolAlignment extends Enum<DebugToolAlignment> {
    public static final DebugToolAlignment LEFT = null;
    public static final DebugToolAlignment Right = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DebugToolAlignment[] f272362a = null;

    static {
        DebugToolAlignment r100 = new DebugToolAlignment("LEFT", 0);
        LEFT = r100;
        DebugToolAlignment r101 = new DebugToolAlignment("Right", 1);
        Right = r101;
        f272362a = new DebugToolAlignment[]{r100, r101};
    }

    public static DebugToolAlignment valueOf(String r100) {
        return (DebugToolAlignment) a.a(DebugToolAlignment.class, r100);
    }

    public static DebugToolAlignment[] values() {
        return (DebugToolAlignment[]) f272362a.clone();
    }

    public DebugToolAlignment(String r100, int r101) {
        super(r100, r101);
    }
}

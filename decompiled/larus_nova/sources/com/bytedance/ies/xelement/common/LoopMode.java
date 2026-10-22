package com.bytedance.ies.xelement.common;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xelement/common/LoopMode;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "SINGLE", "ORDER", "LIST", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum LoopMode extends Enum<LoopMode> {
    public static final LoopMode LIST = null;
    public static final LoopMode ORDER = null;
    public static final LoopMode SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoopMode[] f249857a = null;
    private final String desc;

    public static LoopMode valueOf(String r100) {
        return (LoopMode) a.a(LoopMode.class, r100);
    }

    public static LoopMode[] values() {
        return (LoopMode[]) f249857a.clone();
    }

    static {
        LoopMode r100 = new LoopMode("SINGLE", 0, "single");
        SINGLE = r100;
        LoopMode r101 = new LoopMode("ORDER", 1, "order");
        ORDER = r101;
        LoopMode r102 = new LoopMode("LIST", 2, "list");
        LIST = r102;
        f249857a = new LoopMode[]{r100, r101, r102};
    }

    public final String getDesc() {
        return this.desc;
    }

    public LoopMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}

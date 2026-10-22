package com.bytedance.ies.xelement.defaultimpl.player.engine.api.common;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/common/Quality;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "EXCELLENT", "GOOD", "REGULAR", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum Quality extends Enum<Quality> {
    public static final Quality EXCELLENT = null;
    public static final Quality GOOD = null;
    public static final Quality REGULAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Quality[] f249864a = null;
    private final String desc;

    public static Quality valueOf(String r100) {
        return (Quality) a.a(Quality.class, r100);
    }

    public static Quality[] values() {
        return (Quality[]) f249864a.clone();
    }

    static {
        Quality r100 = new Quality("EXCELLENT", 0, "excellent");
        EXCELLENT = r100;
        Quality r101 = new Quality("GOOD", 1, "good");
        GOOD = r101;
        Quality r102 = new Quality("REGULAR", 2, "regular");
        REGULAR = r102;
        f249864a = new Quality[]{r100, r101, r102};
    }

    public final String getDesc() {
        return this.desc;
    }

    public Quality(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}

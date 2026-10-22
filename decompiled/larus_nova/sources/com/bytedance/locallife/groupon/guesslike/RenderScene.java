package com.bytedance.locallife.groupon.guesslike;

import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/guesslike/RenderScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", AccountType.ALL, "FIRST_REQUEST", "REFRESH", "LOAD_MORE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum RenderScene extends Enum<RenderScene> {
    public static final RenderScene ALL = null;
    public static final RenderScene FIRST_REQUEST = null;
    public static final RenderScene LOAD_MORE = null;
    public static final RenderScene REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderScene[] f258798a = null;
    private final String value;

    public static RenderScene valueOf(String r100) {
        return (RenderScene) a.a(RenderScene.class, r100);
    }

    public static RenderScene[] values() {
        return (RenderScene[]) f258798a.clone();
    }

    static {
        RenderScene r100 = new RenderScene(AccountType.ALL, 0, "all");
        ALL = r100;
        RenderScene r101 = new RenderScene("FIRST_REQUEST", 1, "first_request");
        FIRST_REQUEST = r101;
        RenderScene r102 = new RenderScene("REFRESH", 2, "refresh");
        REFRESH = r102;
        RenderScene r103 = new RenderScene("LOAD_MORE", 3, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r103;
        f258798a = new RenderScene[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public RenderScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

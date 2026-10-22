package com.bytedance.locallife.groupon.api.undertake;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/locallife/groupon/api/undertake/IGrouponUndertakeManager$DrainageParamScene", "", "Lcom/bytedance/locallife/groupon/api/undertake/IGrouponUndertakeManager$DrainageParamScene;", "SEARCH_BACK_TO_GROUPON", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum IGrouponUndertakeManager$DrainageParamScene extends Enum<IGrouponUndertakeManager$DrainageParamScene> {
    public static final IGrouponUndertakeManager$DrainageParamScene SEARCH_BACK_TO_GROUPON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IGrouponUndertakeManager$DrainageParamScene[] f258788a = null;

    public static IGrouponUndertakeManager$DrainageParamScene valueOf(String r100) {
        return (IGrouponUndertakeManager$DrainageParamScene) a.a(IGrouponUndertakeManager$DrainageParamScene.class, r100);
    }

    public static IGrouponUndertakeManager$DrainageParamScene[] values() {
        return (IGrouponUndertakeManager$DrainageParamScene[]) f258788a.clone();
    }

    static {
        IGrouponUndertakeManager$DrainageParamScene r100 = new IGrouponUndertakeManager$DrainageParamScene();
        SEARCH_BACK_TO_GROUPON = r100;
        f258788a = new IGrouponUndertakeManager$DrainageParamScene[]{r100};
    }

    public IGrouponUndertakeManager$DrainageParamScene() {
        super("SEARCH_BACK_TO_GROUPON", 0);
    }
}

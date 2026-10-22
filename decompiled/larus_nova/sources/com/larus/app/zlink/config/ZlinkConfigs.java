package com.larus.app.zlink.config;

import com.larus.common.zlinksdk.api.IZlinkConfigs;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/app/zlink/config/ZlinkConfigs;", "Lcom/larus/common/zlinksdk/api/IZlinkConfigs;", "<init>", "()V", "getSchemeList", "", "", "getHostList", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZlinkConfigs implements IZlinkConfigs {
    public ZlinkConfigs() {
    }

    @Override // com.larus.common.zlinksdk.api.IZlinkConfigs
    public final List<String> getHostList() {
        return CollectionsKt.mutableListOf(new String[]{"doubao.zlinkurl.cn"});
    }

    @Override // com.larus.common.zlinksdk.api.IZlinkConfigs
    public final List<String> getSchemeList() {
        return CollectionsKt.mutableListOf(new String[]{"doubao"});
    }
}

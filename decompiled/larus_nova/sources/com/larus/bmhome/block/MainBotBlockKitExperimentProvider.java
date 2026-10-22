package com.larus.bmhome.block;

import com.larus.blockkit.IBlockKitExperimentProvider;
import com.larus.platform.service.p1;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/block/MainBotBlockKitExperimentProvider;", "Lcom/larus/blockkit/IBlockKitExperimentProvider;", "<init>", "()V", "enableDiffDispatchFix", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainBotBlockKitExperimentProvider implements IBlockKitExperimentProvider {
    public MainBotBlockKitExperimentProvider() {
    }

    @Override // com.larus.blockkit.IBlockKitExperimentProvider
    public final boolean a() {
        return p1.f365785a.enableBlockDiffDispatchFix();
    }
}

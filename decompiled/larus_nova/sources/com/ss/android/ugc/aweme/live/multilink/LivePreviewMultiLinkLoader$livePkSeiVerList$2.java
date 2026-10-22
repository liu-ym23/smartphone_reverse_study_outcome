package com.ss.android.ugc.aweme.live.multilink;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService;
import com.ss.android.ugc.aweme.base.common.ServiceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LivePreviewMultiLinkLoader$livePkSeiVerList$2 extends Lambda implements Function0<List<String>> {
    public static final LivePreviewMultiLinkLoader$livePkSeiVerList$2 INSTANCE = null;

    static {
        INSTANCE = new LivePreviewMultiLinkLoader$livePkSeiVerList$2();
    }

    public LivePreviewMultiLinkLoader$livePkSeiVerList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2() {
        ServiceCache.f449998c.getClass();
        List<String> r100 = (List) ((ILiveBusinessBaseService) ServiceCache.b(ILiveBusinessBaseService.class)).getLiveSettingValue("live_pk_sei_ver_list", CollectionsKt.mutableListOf(new String[]{"2", "6"}));
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.mutableListOf(new String[]{"2", "6"});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<String> invoke() {
        return invoke2();
    }
}

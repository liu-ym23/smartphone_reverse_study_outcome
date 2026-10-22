package com.ss.android.lark.language.loader;

import com.dtf.face.api.IDTFacade;
import com.larus.nova.R;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class c extends BaseLanguageLoader {
    @Override // com.ss.android.lark.language.loader.BaseLanguageLoader
    public final Map<String, Integer> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK, Integer.valueOf(R.string.Lark_Legacy_LanguageChineseTraditional)), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW, Integer.valueOf(R.string.Lark_Legacy_LanguageChineseTraditionalTW))});
    }

    public c(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "globalCoreKVRepo");
        super(r100);
    }
}

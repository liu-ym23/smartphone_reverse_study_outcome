package com.obric.assistant.cocreationreview.modules.searchqa;

import com.larus.nova.R;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.l5;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l5 f387551a = null;

    static {
        f387551a = new l5(ModuleKey.SEARCH_QA, "全搜问答", "全搜问答", R.drawable.ic_cocreation_module_search_qa, -680437, "全搜问答：基于本地资料检索并回答用户问题", CollectionsKt.listOf(new String[]{"目标内容找全", "回复准确", "本地资料引用清楚", "其他"}), CollectionsKt.listOf(new String[]{"完全没搜到目标内容", "没搜全多个目标内容", "搜到内容但回复错误", "没搜索本地数据", "其他"}), "请指明目标资料、遗漏内容或回复错误点。", true, ISmModel.VERSION_0600);
    }
}

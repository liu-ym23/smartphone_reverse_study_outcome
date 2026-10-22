package com.bytedance.ee.bear.block.codeblock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.docsdk.impl.document.plugins.codeblock.CodeLanguageData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/block/codeblock/CodeBlockViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "codeLanguageData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageData;", "getCodeLanguageData", "()Landroidx/lifecycle/MutableLiveData;", "isShowingCodeLanguageSelectionPanel", "", "onSelectCodeLanguage", "", "getOnSelectCodeLanguage", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeBlockViewModel extends ViewModel {
    private final MutableLiveData<CodeLanguageData> codeLanguageData;
    private final MutableLiveData<Boolean> isShowingCodeLanguageSelectionPanel;
    private final MutableLiveData<String> onSelectCodeLanguage;

    public CodeBlockViewModel() {
        this.isShowingCodeLanguageSelectionPanel = new MutableLiveData();
        this.codeLanguageData = new MutableLiveData();
        this.onSelectCodeLanguage = new MutableLiveData();
    }

    public final MutableLiveData<CodeLanguageData> getCodeLanguageData() {
        return this.codeLanguageData;
    }

    public final MutableLiveData<String> getOnSelectCodeLanguage() {
        return this.onSelectCodeLanguage;
    }

    public final MutableLiveData<Boolean> isShowingCodeLanguageSelectionPanel() {
        return this.isShowingCodeLanguageSelectionPanel;
    }
}

package com.bytedance.ee.bear.doc.codeblock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/doc/codeblock/CodeBlockViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isShowingCodeLanguageSelectionPanel", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "codeLanguageData", "Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageData;", "getCodeLanguageData", "onSelectCodeLanguage", "", "getOnSelectCodeLanguage", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

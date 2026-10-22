package com.bytedance.ee.bear.doc.translate;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TranslateViewModel extends ViewModel {
    private static final String PREFS_KEY_RECENT_TRANSLATE_LANGUAGES = "CCM_recent_translate_languages";
    private static final String TAG = "TranslateViewModel";
    private MutableLiveData<Original> activeOriginal;
    private int activeOriginalPanelHeight;
    private MutableLiveData<List<LanguageModel>> chooseLanguages;
    private a onLanguageSelectListener;
    private RecentUsedLanguageModel recentUsedLanguageModel;
    private MutableLiveData<List<LanguageModel>> recentlyLanguages;
    private MutableLiveData<LanguageModel> selectedLanguage;
    private MutableLiveData<Boolean> showingActiveOriginalPanel;
    private MutableLiveData<Boolean> showingChooseLanguagePanel;

    public interface a {
        void a(String r1);
    }

    public void onActiveOriginalPanelDismissed() {
        this.activeOriginalPanelHeight = 0;
        this.showingActiveOriginalPanel.setValue(Boolean.FALSE);
    }

    private void storeRecentLanguage() {
        LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate_recent", true).putJSONObject(PREFS_KEY_RECENT_TRANSLATE_LANGUAGES, this.recentUsedLanguageModel);
    }

    public MutableLiveData<List<LanguageModel>> getRecentlyUsedLanguages() {
        if (this.recentUsedLanguageModel != null) goto L5;
        this.recentUsedLanguageModel = new RecentUsedLanguageModel();
    L5:
        List<LanguageModel> r0 = this.recentUsedLanguageModel.getLanguages();
        List<LanguageModel> r1 = new ArrayList();
        List r2 = (List) getChooseLanguages().getValue();
        if (r0 != null) goto L9;
        r0 = new ArrayList();
        r1 = r0;
    L9:
        if (r0.isEmpty() == true) goto L25;
        if (r2 == null) goto L25;
        int r4 = 0;
    L13:
        if (r4 >= r0.size()) goto L25;
        LanguageModel r5 = (LanguageModel) ListProtector.get(r0, r4);
        if (r5 != null) goto L17;
        tt5.a.d(TAG, "Stored recent language model is null!");
    L24:
        r4 = r4 + 1;
        goto L13
    L17:
        int r6 = 0;
    L19:
        if (r6 >= r2.size()) goto L24;
        LanguageModel r7 = (LanguageModel) ListProtector.get(r2, r6);
        if (TextUtils.equals(r5.getTag(), r7.getTag()) == false) goto L23;
        r5.setDisplayText(r7.getDisplayText());
        r1.add(r5);
    L23:
        r6 = r6 + 1;
    L25:
        this.recentUsedLanguageModel.setLanguages(r1);
        storeRecentLanguage();
        this.recentlyLanguages.setValue(r1);
        return this.recentlyLanguages;
    }

    public TranslateViewModel() {
        this.showingChooseLanguagePanel = new MutableLiveData();
        this.selectedLanguage = new MutableLiveData();
        this.chooseLanguages = new MutableLiveData();
        this.recentlyLanguages = new MutableLiveData();
        this.activeOriginal = new MutableLiveData();
        this.showingActiveOriginalPanel = new MutableLiveData();
        this.recentUsedLanguageModel = (RecentUsedLanguageModel) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate_recent", true).getJSONObject(PREFS_KEY_RECENT_TRANSLATE_LANGUAGES, RecentUsedLanguageModel.class);
    }

    public LiveData<Original> getActiveOriginal() {
        return this.activeOriginal;
    }

    public int getActiveOriginalPanelHeight() {
        return this.activeOriginalPanelHeight;
    }

    public MutableLiveData<List<LanguageModel>> getChooseLanguages() {
        return this.chooseLanguages;
    }

    public MutableLiveData<LanguageModel> getSelectedLanguage() {
        return this.selectedLanguage;
    }

    public LiveData<Boolean> getShowingActiveOriginalPanel() {
        return this.showingActiveOriginalPanel;
    }

    public MutableLiveData<Boolean> getShowingChooseLanguagePanel() {
        return this.showingChooseLanguagePanel;
    }

    public void onActiveOriginalPanelShown(int r2) {
        this.activeOriginalPanelHeight = r2;
        this.showingActiveOriginalPanel.setValue(Boolean.TRUE);
    }

    public void onSelectLanguage(LanguageModel r3) {
        setSelectedLanguage(r3);
        RecentUsedLanguageModel r0 = this.recentUsedLanguageModel;
        if (r0 == null) goto L5;
        r0.insert(r3);
        storeRecentLanguage();
        this.recentlyLanguages.setValue(this.recentUsedLanguageModel.getLanguages());
    L5:
        a r1 = this.onLanguageSelectListener;
        if (r1 == null) goto L9;
        r1.a(r3.getTag());
        return;
    }

    public void setActiveOriginal(Original r2) {
        this.activeOriginal.setValue(r2);
    }

    public void setChooseLanguages(List<LanguageModel> r2) {
        this.chooseLanguages.setValue(r2);
    }

    public void setOnLanguageSelectListener(a r1) {
        this.onLanguageSelectListener = r1;
    }

    public void setSelectedLanguage(LanguageModel r2) {
        this.selectedLanguage.setValue(r2);
    }

    public void setShowingChooseLanguageFragment(Boolean r2) {
        this.showingChooseLanguagePanel.setValue(r2);
    }
}

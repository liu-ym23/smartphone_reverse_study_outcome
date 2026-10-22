package com.bytedance.ee.bear.doc.translate;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
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
        void a(String r100);
    }

    public void onActiveOriginalPanelDismissed() {
        this.activeOriginalPanelHeight = 0;
        this.showingActiveOriginalPanel.setValue(Boolean.FALSE);
    }

    private void storeRecentLanguage() {
        LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "translate_recent", true).putJSONObject(PREFS_KEY_RECENT_TRANSLATE_LANGUAGES, this.recentUsedLanguageModel);
    }

    public MutableLiveData<List<LanguageModel>> getRecentlyUsedLanguages() {
        if (this.recentUsedLanguageModel != null) goto L5;
        this.recentUsedLanguageModel = new RecentUsedLanguageModel();
    L5:
        List<LanguageModel> r100 = this.recentUsedLanguageModel.getLanguages();
        List<LanguageModel> r101 = new ArrayList();
        List<LanguageModel> r102 = getChooseLanguages().getValue();
        if (r100 != null) goto L9;
        r100 = new ArrayList();
        r101 = r100;
    L9:
        if (r100.isEmpty() == true) goto L25;
        if (r102 == null) goto L25;
        int r103 = 0;
    L13:
        if (r103 >= r100.size()) goto L25;
        LanguageModel r104 = (LanguageModel) ListProtector.get(r100, r103);
        if (r104 != null) goto L17;
        tt5.a.d(TAG, "Stored recent language model is null!");
    L24:
        r103 = r103 + 1;
        goto L13
    L17:
        int r105 = 0;
    L19:
        if (r105 >= r102.size()) goto L24;
        LanguageModel r106 = (LanguageModel) ListProtector.get(r102, r105);
        if (TextUtils.equals(r104.getTag(), r106.getTag()) == false) goto L23;
        r104.setDisplayText(r106.getDisplayText());
        r101.add(r104);
    L23:
        r105 = r105 + 1;
    L25:
        this.recentUsedLanguageModel.setLanguages(r101);
        storeRecentLanguage();
        this.recentlyLanguages.setValue(r101);
        return this.recentlyLanguages;
    }

    public TranslateViewModel() {
        this.showingChooseLanguagePanel = new MutableLiveData();
        this.selectedLanguage = new MutableLiveData();
        this.chooseLanguages = new MutableLiveData();
        this.recentlyLanguages = new MutableLiveData();
        this.activeOriginal = new MutableLiveData();
        this.showingActiveOriginalPanel = new MutableLiveData();
        this.recentUsedLanguageModel = (RecentUsedLanguageModel) LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "translate_recent", true).getJSONObject(PREFS_KEY_RECENT_TRANSLATE_LANGUAGES, RecentUsedLanguageModel.class);
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

    public void onActiveOriginalPanelShown(int r100) {
        this.activeOriginalPanelHeight = r100;
        this.showingActiveOriginalPanel.setValue(Boolean.TRUE);
    }

    public void onSelectLanguage(LanguageModel r100) {
        setSelectedLanguage(r100);
        RecentUsedLanguageModel r101 = this.recentUsedLanguageModel;
        if (r101 == null) goto L5;
        r101.insert(r100);
        storeRecentLanguage();
        this.recentlyLanguages.setValue(this.recentUsedLanguageModel.getLanguages());
    L5:
        a r102 = this.onLanguageSelectListener;
        if (r102 == null) goto L9;
        r102.a(r100.getTag());
        return;
    }

    public void setActiveOriginal(Original r100) {
        this.activeOriginal.setValue(r100);
    }

    public void setChooseLanguages(List<LanguageModel> r100) {
        this.chooseLanguages.setValue(r100);
    }

    public void setOnLanguageSelectListener(a r100) {
        this.onLanguageSelectListener = r100;
    }

    public void setSelectedLanguage(LanguageModel r100) {
        this.selectedLanguage.setValue(r100);
    }

    public void setShowingChooseLanguageFragment(Boolean r100) {
        this.showingChooseLanguagePanel.setValue(r100);
    }
}

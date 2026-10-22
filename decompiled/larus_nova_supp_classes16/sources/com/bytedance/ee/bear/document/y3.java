package com.bytedance.ee.bear.document;

import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.titlebar.NavigationTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface y3 extends d {
    boolean allowCustomTitle();

    boolean allowCustomTitleMenu();

    boolean canCopy();

    String getChatId();

    LiveData<Boolean> getDeleted();

    LiveData<Pair<Boolean, String>> getExternalInfo();

    DocsOpenSource getOpenSource();

    MutableLiveData<IconInfo> getShowingIconInfo();

    String getSpaceId();

    LiveData<CharSequence> getTitle();

    LiveData<NavigationTitle> getTitleInfo();

    WikiInfo getWikiInfo();

    boolean isAnnounceDoc();

    boolean isAnnounceTemplatePreview();

    boolean isCommonTemplatePreview();

    boolean isDocumentType(sbb.e r1);

    @Override // com.bytedance.ee.bear.document.d
    boolean isSyncBlock();

    boolean isType(sbb.e r1);

    LiveData<String> liveDocObjToken();

    void setDocName(String r1);

    void setTitle(CharSequence r1);

    void updateTitle(NavigationTitle r1);
}

package com.ss.android.ugc.effectmanager;

import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IDownloadProviderEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchFavoriteList;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchProviderEffect;
import com.ss.android.ugc.effectmanager.effect.listener.IModFavoriteList;
import com.ss.android.ugc.effectmanager.effect.listener.IReadUpdateTagListener;
import com.ss.android.ugc.effectmanager.effect.listener.IScanQRCodeListener;
import com.ss.android.ugc.effectmanager.effect.listener.IWriteUpdateTagListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class ListenerManger {
    private Map<String, ICheckChannelListener> checkChannelListenerMap;
    private Map<String, IFetchEffectChannelListener> fetchEffectChannelListenerMap;
    private Map<String, IFetchEffectListByIdsListener> fetchEffectListByIdsListenerMap;
    private Map<String, IFetchEffectListListener> fetchEffectListListenerMap;
    private Map<String, IFetchEffectListener> fetchEffectListenerMap;
    private Map<String, Object> mCommonListenerMap;
    private Map<String, IDownloadProviderEffectListener> mDownloadProviderEffectMap;
    private Map<String, IFetchCategoryEffectListener> mFetchCategoryEffectListenerMap;
    private Map<String, IFetchFavoriteList> mFetchFavoriteListMap;
    private Map<String, IFetchPanelInfoListener> mFetchPanelInfoListenerMap;
    private Map<String, IFetchProviderEffect> mFetchProviderEffectMap;
    private Map<String, IScanQRCodeListener> mIScanQRCodeListenerMap;
    private Map<String, IEffectPlatformBaseListener> mKNEffectPlatformListenerMap;
    private Map<String, IModFavoriteList> mModFavoriteListMap;
    private Map<String, IReadUpdateTagListener> mReadUpdateTagMap;
    private Map<String, IWriteUpdateTagListener> mWriteUpdateTagMap;

    public void destroy() {
        clearMapIfNeeded(this.checkChannelListenerMap);
        clearMapIfNeeded(this.fetchEffectChannelListenerMap);
        clearMapIfNeeded(this.fetchEffectListListenerMap);
        clearMapIfNeeded(this.fetchEffectListByIdsListenerMap);
        clearMapIfNeeded(this.fetchEffectListenerMap);
        clearMapIfNeeded(this.mWriteUpdateTagMap);
        clearMapIfNeeded(this.mModFavoriteListMap);
        clearMapIfNeeded(this.mFetchFavoriteListMap);
        clearMapIfNeeded(this.mReadUpdateTagMap);
        clearMapIfNeeded(this.mIScanQRCodeListenerMap);
        clearMapIfNeeded(this.mFetchProviderEffectMap);
        clearMapIfNeeded(this.mDownloadProviderEffectMap);
        clearMapIfNeeded(this.mFetchCategoryEffectListenerMap);
        clearMapIfNeeded(this.mFetchPanelInfoListenerMap);
        clearMapIfNeeded(this.mCommonListenerMap);
        clearMapIfNeeded(this.mKNEffectPlatformListenerMap);
    }

    public ListenerManger() {
        this.fetchEffectChannelListenerMap = new ConcurrentHashMap();
        this.checkChannelListenerMap = new ConcurrentHashMap();
        this.fetchEffectListListenerMap = new ConcurrentHashMap();
        this.fetchEffectListenerMap = new ConcurrentHashMap();
        this.mModFavoriteListMap = new ConcurrentHashMap();
        this.mFetchFavoriteListMap = new ConcurrentHashMap();
        this.mWriteUpdateTagMap = new ConcurrentHashMap();
        this.mReadUpdateTagMap = new ConcurrentHashMap();
        this.mIScanQRCodeListenerMap = new ConcurrentHashMap();
        this.mKNEffectPlatformListenerMap = new ConcurrentHashMap();
    }

    private void clearMapIfNeeded(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L8;
        r100.clear();
        return;
    }

    public ICheckChannelListener getCheckChannelListener(String r100) {
        Map<String, ICheckChannelListener> r101 = this.checkChannelListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IDownloadProviderEffectListener getDownloadProviderEffectListener(String r100) {
        Map<String, IDownloadProviderEffectListener> r101 = this.mDownloadProviderEffectMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchCategoryEffectListener getFetchCategoryEffectListener(String r100) {
        Map<String, IFetchCategoryEffectListener> r101 = this.mFetchCategoryEffectListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchEffectChannelListener getFetchEffectChannelListener(String r100) {
        Map<String, IFetchEffectChannelListener> r101 = this.fetchEffectChannelListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchEffectListListener getFetchEffectLisListener(String r100) {
        Map<String, IFetchEffectListListener> r101 = this.fetchEffectListListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchEffectListByIdsListener getFetchEffectListByIdsListener(String r100) {
        Map<String, IFetchEffectListByIdsListener> r101 = this.fetchEffectListByIdsListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchEffectListener getFetchEffectListener(String r100) {
        Map<String, IFetchEffectListener> r101 = this.fetchEffectListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchFavoriteList getFetchFavoriteListListener(String r100) {
        Map<String, IFetchFavoriteList> r101 = this.mFetchFavoriteListMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchPanelInfoListener getFetchPanelInfoListener(String r100) {
        Map<String, IFetchPanelInfoListener> r101 = this.mFetchPanelInfoListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IFetchProviderEffect getFetchProviderEffectListener(String r100) {
        Map<String, IFetchProviderEffect> r101 = this.mFetchProviderEffectMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public <T> IEffectPlatformBaseListener<T> getKNPlatformListener(String r100) {
        Map<String, IEffectPlatformBaseListener> r101 = this.mKNEffectPlatformListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public Object getListener(String r100) {
        Map<String, Object> r101 = this.mCommonListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IModFavoriteList getModFavoriteListListener(String r100) {
        Map<String, IModFavoriteList> r101 = this.mModFavoriteListMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IReadUpdateTagListener getReadUpdateTagListener(String r100) {
        Map<String, IReadUpdateTagListener> r101 = this.mReadUpdateTagMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IScanQRCodeListener getScanQRCodeListener(String r100) {
        Map<String, IScanQRCodeListener> r101 = this.mIScanQRCodeListenerMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public IWriteUpdateTagListener getWriteUpdateTagListener(String r100) {
        Map<String, IWriteUpdateTagListener> r101 = this.mWriteUpdateTagMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public void removeCheckChannelListener(String r100) {
        Map<String, ICheckChannelListener> r101 = this.checkChannelListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeDownloadProviderEffectListener(String r100) {
        Map<String, IDownloadProviderEffectListener> r101 = this.mDownloadProviderEffectMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchCategoryEffectListener(String r100) {
        Map<String, IFetchCategoryEffectListener> r101 = this.mFetchCategoryEffectListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchEffectChannelListener(String r100) {
        Map<String, IFetchEffectChannelListener> r101 = this.fetchEffectChannelListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchEffectLisListener(String r100) {
        Map<String, IFetchEffectChannelListener> r101 = this.fetchEffectChannelListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchEffectListByIdsListener(String r100) {
        Map<String, IFetchEffectListByIdsListener> r101 = this.fetchEffectListByIdsListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchEffectListener(String r100) {
        Map<String, IFetchEffectListener> r101 = this.fetchEffectListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchFavoriteListListener(String r100) {
        Map<String, IFetchFavoriteList> r101 = this.mFetchFavoriteListMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchPanelInfoListener(String r100) {
        Map<String, IFetchPanelInfoListener> r101 = this.mFetchPanelInfoListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeFetchProviderEffectListener(String r100) {
        Map<String, IFetchProviderEffect> r101 = this.mFetchProviderEffectMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeKNPlatformListener(String r100) {
        Map<String, IEffectPlatformBaseListener> r101 = this.mKNEffectPlatformListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeListener(String r100) {
        Map<String, Object> r101 = this.mCommonListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeModFavoriteListListener(String r100) {
        Map<String, IModFavoriteList> r101 = this.mModFavoriteListMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeReadUpdateTagListener(String r100) {
        Map<String, IReadUpdateTagListener> r101 = this.mReadUpdateTagMap;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void removeScanQRCodeListener(String r100) {
        Map<String, IScanQRCodeListener> r101 = this.mIScanQRCodeListenerMap;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeWriteUpdateTagListener(String r100) {
        Map<String, IWriteUpdateTagListener> r101 = this.mWriteUpdateTagMap;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void addNewKNPlatformListener(String r100, IEffectPlatformBaseListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mKNEffectPlatformListenerMap != null) goto L6;
        this.mKNEffectPlatformListenerMap = new ConcurrentHashMap();
    L6:
        this.mKNEffectPlatformListenerMap.put(r100, r101);
    }

    public void setCheckChannelListener(String r100, ICheckChannelListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.checkChannelListenerMap != null) goto L6;
        this.checkChannelListenerMap = new ConcurrentHashMap();
    L6:
        this.checkChannelListenerMap.put(r100, r101);
    }

    public void setDownloadProviderEffectListener(String r100, IDownloadProviderEffectListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mDownloadProviderEffectMap != null) goto L6;
        this.mDownloadProviderEffectMap = new ConcurrentHashMap();
    L6:
        this.mDownloadProviderEffectMap.put(r100, r101);
    }

    public void setFetchCategoryEffectListener(String r100, IFetchCategoryEffectListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mFetchCategoryEffectListenerMap != null) goto L6;
        this.mFetchCategoryEffectListenerMap = new ConcurrentHashMap();
    L6:
        this.mFetchCategoryEffectListenerMap.put(r100, r101);
    }

    public void setFetchEffectChannelListener(String r100, IFetchEffectChannelListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.fetchEffectChannelListenerMap != null) goto L6;
        this.fetchEffectChannelListenerMap = new ConcurrentHashMap();
    L6:
        this.fetchEffectChannelListenerMap.put(r100, r101);
    }

    public void setFetchEffectListByIdsListener(String r100, IFetchEffectListByIdsListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.fetchEffectListByIdsListenerMap != null) goto L6;
        this.fetchEffectListByIdsListenerMap = new ConcurrentHashMap();
    L6:
        this.fetchEffectListByIdsListenerMap.put(r100, r101);
    }

    public void setFetchEffectListListener(String r100, IFetchEffectListListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.fetchEffectListenerMap != null) goto L6;
        this.fetchEffectListenerMap = new ConcurrentHashMap();
    L6:
        this.fetchEffectListListenerMap.put(r100, r101);
    }

    public void setFetchEffectListener(String r100, IFetchEffectListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.fetchEffectListenerMap != null) goto L6;
        this.fetchEffectListenerMap = new ConcurrentHashMap();
    L6:
        this.fetchEffectListenerMap.put(r100, r101);
    }

    public void setFetchFavoriteListListener(String r100, IFetchFavoriteList r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mFetchFavoriteListMap != null) goto L6;
        this.mFetchFavoriteListMap = new ConcurrentHashMap();
    L6:
        this.mFetchFavoriteListMap.put(r100, r101);
    }

    public void setFetchPanelInfoListener(String r100, IFetchPanelInfoListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mFetchPanelInfoListenerMap != null) goto L6;
        this.mFetchPanelInfoListenerMap = new ConcurrentHashMap();
    L6:
        this.mFetchPanelInfoListenerMap.put(r100, r101);
    }

    public void setFetchProviderEffectListener(String r100, IFetchProviderEffect r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mFetchProviderEffectMap != null) goto L6;
        this.mFetchProviderEffectMap = new ConcurrentHashMap();
    L6:
        this.mFetchProviderEffectMap.put(r100, r101);
    }

    public Object setListener(String r100, Object r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (this.mCommonListenerMap != null) goto L7;
        this.mCommonListenerMap = new ConcurrentHashMap();
    L7:
        return this.mCommonListenerMap.put(r100, r101);
    }

    public void setModFavoriteListener(String r100, IModFavoriteList r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mModFavoriteListMap != null) goto L6;
        this.mModFavoriteListMap = new ConcurrentHashMap();
    L6:
        this.mModFavoriteListMap.put(r100, r101);
    }

    public void setReadUpdateTagListener(String r100, IReadUpdateTagListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mReadUpdateTagMap != null) goto L6;
        this.mReadUpdateTagMap = new ConcurrentHashMap();
    L6:
        this.mReadUpdateTagMap.put(r100, r101);
    }

    public void setScanQRCodeListener(String r100, IScanQRCodeListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mIScanQRCodeListenerMap != null) goto L6;
        this.mIScanQRCodeListenerMap = new ConcurrentHashMap();
    L6:
        this.mIScanQRCodeListenerMap.put(r100, r101);
    }

    public void setWriteUpdateTagListener(String r100, IWriteUpdateTagListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mWriteUpdateTagMap != null) goto L6;
        this.mWriteUpdateTagMap = new ConcurrentHashMap();
    L6:
        this.mWriteUpdateTagMap.put(r100, r101);
    }
}

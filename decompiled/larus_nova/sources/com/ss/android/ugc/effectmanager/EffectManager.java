package com.ss.android.ugc.effectmanager;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IDownloadProviderEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IEffectListResponseListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchFavoriteList;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchHotEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchProviderEffect;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IModFavoriteList;
import com.ss.android.ugc.effectmanager.effect.listener.IRewardEffectsListener;
import com.ss.android.ugc.effectmanager.effect.listener.IScanQRCodeListener;
import com.ss.android.ugc.effectmanager.effect.listener.ISearchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.ISearchEffectListenerV2;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import com.ss.android.ugc.effectmanager.effect.model.DownloadEffectExtra;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectQRCode;
import com.ss.android.ugc.effectmanager.effect.model.ProviderEffect;
import com.ss.android.ugc.effectmanager.knadapt.ListenerAdaptExtKt;
import com.ss.ugc.effectplatform.EffectPlatform;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.QueryTopChecklistEffectsModel;
import com.ss.ugc.effectplatform.model.RankingCategoryListModel;
import com.ss.ugc.effectplatform.model.RankingDesignerInfoConvertModel;
import com.ss.ugc.effectplatform.model.RankingEffectInfoModel;
import com.ss.ugc.effectplatform.model.net.CustomizedStickerCreateResponse;
import com.ss.ugc.effectplatform.model.net.GetCustomizedEffectIDData;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import com.ss.ugc.effectplatform.model.net.InfoStickerListResponse;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import com.ss.ugc.effectplatform.model.net.RecommendSearchWordsResponse;
import com.ss.ugc.effectplatform.model.net.StickerCategoryListResponse;
import com.ss.ugc.effectplatform.model.net.StickerUploadAuthKeyResponse;
import com.ss.ugc.effectplatform.task.c;
import com.ss.ugc.effectplatform.task.e;
import com.ss.ugc.effectplatform.task.g;
import com.ss.ugc.effectplatform.task.i;
import com.ss.ugc.effectplatform.task.k;
import com.ss.ugc.effectplatform.task.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class EffectManager {
    private EffectPlatform mEffectPlatform;

    public EffectManager() {
    }

    public void clearEffects() {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.clearEffects();
        return;
    }

    public void destroy() {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public EffectChannelResponse getCurrentEffectChannel() {
        return new EffectChannelResponse(this.mEffectPlatform.getCurrentEffectChannel());
    }

    public void removeListener() {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.removeAllListener();
        return;
    }

    public EffectPlatform getEffectPlatform() {
        return this.mEffectPlatform;
    }

    public EffectPlatform getKNEffectPlatform() {
        return this.mEffectPlatform;
    }

    public void cancelEffectTask(Effect r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.cancelEffectTask(r100);
        return;
    }

    public void clearCache(String r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.clearCache(r100);
        return;
    }

    public void clearVersion(String r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.clearVersion(r100);
        return;
    }

    public void deleteEffect(Effect r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.deleteEffect(r100);
        return;
    }

    public void fetchRankingDesignerList(IEffectPlatformBaseListener<RankingDesignerInfoConvertModel> r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchRankingDesignerList(r100);
        return;
    }

    public boolean init(EffectConfiguration r100) {
        this.mEffectPlatform = new EffectPlatform(r100.getEffectConfig());
        return true;
    }

    public boolean isEffectDownloaded(Effect r100) {
        return this.mEffectPlatform.isEffectDownloaded(r100);
    }

    public boolean isEffectDownloading(Effect r100) {
        return this.mEffectPlatform.isEffectDownloading(r100);
    }

    public boolean isEffectListCacheFileExist(String r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.isEffectListCacheExist(r100);
    }

    public boolean isEffectReady(Effect r100) {
        return this.mEffectPlatform.isEffectReady(r100);
    }

    public void markEffectUsed(Effect r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.markEffectUsed(r100);
        return;
    }

    public void onEnterScene(String r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.onEnterScene(r100);
        return;
    }

    public void pauseEffectTask(Effect r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.pauseEffectTask(r100);
        return;
    }

    public void pausePreload(String r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.pausePreload(r100);
        return;
    }

    public void recommendSearchWords(IEffectPlatformBaseListener<RecommendSearchWordsResponse> r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.recommendSearchWords(null, r100);
        return;
    }

    public void removeUnused(long r100) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.removeUnused(r100);
        return;
    }

    public void checkPanelIsUpdate(String r100, ICheckChannelListener r101) {
        checkUpdate(r100, null, 2, null, r101);
    }

    public void checkedEffectListUpdate(String r100, ICheckChannelListener r101) {
        checkUpdate(r100, null, 0, null, r101);
    }

    public void createCustomizedStickerCS(c r100, IEffectPlatformBaseListener<CustomizedStickerCreateResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.createCustomizedStickerCS(r100, r101);
        return;
    }

    public void downloadEffectList(List<Effect> r100, IFetchEffectListListener r101) {
        downloadEffectList(r100, r101, null);
    }

    public void downloadProviderEffect(ProviderEffect r100, IDownloadProviderEffectListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.downloadProviderEffect(r100, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public void fetchEffect(Effect r100, IFetchEffectListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchEffect(r100, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public void fetchEffectList(List<String> r100, IFetchEffectListListener r101) {
        fetchEffectList(r100, true, null, r101);
    }

    public void fetchEffectListFromCache(String r100, IFetchEffectChannelListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchEffectListFromCache(r100, ListenerAdaptExtKt.toKNListener(r101, r102.getEffectConfig().D));
        return;
    }

    public void fetchExistEffectList(String r100, IFetchEffectChannelListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchDownloadedEffectList(r100, ListenerAdaptExtKt.toKNListener(r101, r102.getEffectConfig().D));
        return;
    }

    public void fetchFavoriteList(String r100, IFetchFavoriteList r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchFavoriteList(r100, null, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public void fetchRankingEffectList(String r100, IEffectPlatformBaseListener<List<RankingEffectInfoModel>> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchRankingEffectList(r100, r101);
        return;
    }

    public void fetchResourceList(Map<String, String> r100, com.ss.android.ugc.effectmanager.effect.listener.IFetchResourceListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchResourceList(r100, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public boolean isEffectReady(Effect r100, boolean r101) {
        return this.mEffectPlatform.isEffectReady(r100, r101);
    }

    public void queryCustomizedStickerListCS(e r100, IEffectPlatformBaseListener<InfoStickerListResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.queryCustomizedStickerListCS(r100, r101);
        return;
    }

    public void queryRecommendStickerListCS(g r100, IEffectPlatformBaseListener<InfoStickerListResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.queryRecommendStickerListCS(r100, r101);
        return;
    }

    public void queryStickerCategoryListCS(k r100, IEffectPlatformBaseListener<StickerCategoryListResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.queryStickerCategoryListCS(r100, r101);
        return;
    }

    public void queryVideoUsedStickers(Map<String, String> r100, IEffectListResponseListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.queryVideoUsedStickers(r100, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public void recommendSearchWords(String r100, IEffectPlatformBaseListener<RecommendSearchWordsResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.recommendSearchWords(r100, null, r101);
        return;
    }

    public void searchStickerListCS(i r100, IEffectPlatformBaseListener<InfoStickerListResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.searchStickerListCS(r100, r101);
        return;
    }

    public void uploadStickerAuthKeyCS(m r100, IEffectPlatformBaseListener<StickerUploadAuthKeyResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.uploadStickerAuthKeyCS(r100, r101);
        return;
    }

    public void fetchEffect(EffectQRCode r100, IScanQRCodeListener r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchEffect(r100, ListenerAdaptExtKt.toKNListener(r101));
        return;
    }

    public void recommendSearchWords(Map<String, String> r100, IEffectPlatformBaseListener<RecommendSearchWordsResponse> r101) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.recommendSearchWords(r100, r101);
        return;
    }

    public void fetchEffect(String r100, IFetchEffectListener r101) {
        fetchEffectWithDownload(r100, null, r101);
    }

    public void checkCategoryIsUpdate(String r100, String r101, ICheckChannelListener r102) {
        checkUpdate(r100, r101, 1, null, r102);
    }

    public void checkPanelIsUpdate(String r100, Map<String, String> r101, ICheckChannelListener r102) {
        checkUpdate(r100, null, 2, r101, r102);
    }

    public void checkedEffectListUpdate(String r100, Map<String, String> r101, ICheckChannelListener r102) {
        checkUpdate(r100, null, 0, r101, r102);
    }

    public void downloadEffectList(List<Effect> r100, IFetchEffectListListener r101, DownloadEffectExtra r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.downloadEffectList(r100, ListenerAdaptExtKt.toKNListener(r101), r102);
        return;
    }

    public void fetchEffectFirst(Effect r100, boolean r101, IFetchEffectListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchEffectFirst(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void fetchEffectList(String r100, boolean r101, IFetchEffectChannelListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchEffectList(r100, r101, null, ListenerAdaptExtKt.toKNListener(r102, r103.getEffectConfig().D));
        return;
    }

    public void fetchEffectList2(List<String> r100, Map<String, String> r101, IFetchEffectListByIdsListener r102) {
        if (this.mEffectPlatform == null) goto L6;
        ArrayList<String> r103 = new ArrayList(r100);
        this.mEffectPlatform.fetchEffectListByEffectIds(r103, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void fetchEffectListFromCache(String r100, Map<String, String> r101, IFetchEffectChannelListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchEffectListFromCache(r100, r101, ListenerAdaptExtKt.toKNListener(r102, r103.getEffectConfig().D));
        return;
    }

    public void fetchEffectWithDownload(String r100, Map<String, String> r101, IFetchEffectListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchEffect(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void fetchFavoriteList(String r100, Map<String, String> r101, IFetchFavoriteList r102) {
        this.mEffectPlatform.fetchFavoriteList(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
    }

    public void getCustomizedEffectId(long r100, Map<String, String> r101, IEffectPlatformBaseListener<GetCustomizedEffectIDData> r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.getCustomizedEffectId(r100, r101, r102);
        return;
    }

    public void isTagUpdated(String r100, String r101, IIsTagNeedUpdatedListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.isTagUpdated(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void onEffectUsed(boolean r100, Effect r101, String r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.onEffectUsed(r100, r101, r102);
        return;
    }

    public void preloadResource(int r100, String r101, Map<String, Object> r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.preloadResource(r100, r101, r102);
        return;
    }

    public void queryCustomizedEffects(String r100, Map<String, String> r101, IEffectPlatformBaseListener<QueryCustomizedEffectsData> r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.queryCustomizedEffects(r100, r101, r102);
        return;
    }

    public void recommendSearchWords(String r100, Map<String, String> r101, IEffectPlatformBaseListener<RecommendSearchWordsResponse> r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.recommendSearchWords(r100, r101, r102);
        return;
    }

    public void resumeEffectTask(Effect r100, boolean r101, boolean r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.resumeEffectTask(r100, r101, r102);
        return;
    }

    public void updateTag(String r100, String r101, IUpdateTagListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.updateTag(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void fetchEffectList(List<String> r100, Map<String, String> r101, IFetchEffectListByIdsListener r102) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchEffectListByResourceIds(r100, r101, ListenerAdaptExtKt.toKNListener(r102));
        return;
    }

    public void fetchEffectList(List<String> r100, boolean r101, IFetchEffectListListener r102) {
        fetchEffectList(r100, r101, null, r102);
    }

    public void checkCategoryIsUpdate(String r100, String r101, Map<String, String> r102, ICheckChannelListener r110) {
        checkUpdate(r100, r101, 1, r102, r110);
    }

    public void fetchCategoryInfo(String r100, List<Integer> r101, Map<String, String> r102, IFetchCategoryInfoListener r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        r104.fetchCategoryInfo(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r103, r104.getEffectConfig().D));
    }

    public void fetchCategoryInfoFromCache(String r100, List<Integer> r101, Map<String, String> r102, IFetchCategoryInfoListener r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        r104.fetchCategoryInfoFromCache(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r103, r104.getEffectConfig().D));
    }

    public void fetchCustomizedEffects(String r100, String r101, Map<String, String> r102, IFetchCategoryEffectListener r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        if (r104 == null) goto L6;
        r104.fetchCustomizedEffects(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r103, r104.getEffectConfig().D));
        return;
    }

    public void fetchEffectList(String r100, boolean r101, Map<String, String> r102, IFetchEffectChannelListener r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        if (r104 == null) goto L6;
        r104.fetchEffectList(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r103, r104.getEffectConfig().D));
        return;
    }

    public void fetchRankingCategoryList(int r100, int r101, int r102, IEffectPlatformBaseListener<RankingCategoryListModel> r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        if (r104 == null) goto L6;
        r104.fetchRankingCategoryList(r100, r101, r102, r103);
        return;
    }

    public void modifyFavoriteList(String r100, String r101, Boolean r110, IModFavoriteList r111) {
        if (this.mEffectPlatform == null) goto L6;
        ArrayList r102 = new ArrayList();
        r102.add(r101);
        this.mEffectPlatform.modifyFavoriteList(r100, r102, r110.booleanValue(), null, ListenerAdaptExtKt.toKNListener(r111));
        return;
    }

    public void queryTopChecklistEffects(String r100, Boolean r101, Map<String, String> r102, IEffectPlatformBaseListener<QueryTopChecklistEffectsModel> r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        if (r104 == null) goto L6;
        r104.queryTopChecklistEffects(r100, r101, r102, r103);
        return;
    }

    public void fetchEffectList(List<String> r100, boolean r101, Map<String, String> r102, IFetchEffectListListener r103) {
        EffectPlatform r104 = this.mEffectPlatform;
        if (r104 == null) goto L6;
        r104.fetchEffectList(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r103));
        return;
    }

    public void modifyFavoriteList(String r100, List<String> r101, Boolean r102, IModFavoriteList r110) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.modifyFavoriteList(r100, r101, r102.booleanValue(), null, ListenerAdaptExtKt.toKNListener(r110));
        return;
    }

    private void checkUpdate(String r100, String r101, int r102, Map<String, String> r110, ICheckChannelListener r111) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.checkUpdate(r100, r101, r102, r110, ListenerAdaptExtKt.toKNListener(r111));
        return;
    }

    public void fetchHotEffect(int r100, int r101, Map<String, String> r102, boolean r103, IFetchHotEffectListener r104) {
        EffectPlatform r105 = this.mEffectPlatform;
        if (r105 == null) goto L6;
        r105.fetchHotEffect(r100, r101, r102, ListenerAdaptExtKt.toKNListener(r104));
        return;
    }

    public void fetchProviderEffect(String r100, boolean r101, int r110, int r111, IFetchProviderEffect r112) {
        fetchProviderEffect(r100, r101, r110, r111, null, r112);
    }

    public void fetchProviderEffectsByGiphyIds(String r100, String r101, Map<String, String> r102, boolean r110, IEffectPlatformBaseListener<GifProviderEffectListResponse> r111) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 == null) goto L6;
        r103.fetchProviderEffectsByGiphyIds(r100, r101, r102, r110, r111);
        return;
    }

    public void fetchRewardEffects(String r100, int r101, int r102, Map<String, String> r110, IRewardEffectsListener r111) {
        EffectPlatform r103 = this.mEffectPlatform;
        if (r103 != null) goto L6;
        r111.onFailed(new ExceptionResult(new IllegalAccessException("mEffectPlatform is null")));
        return;
    L6:
        r103.fetchRewardEffects(r100, r101, r102, r110, ListenerAdaptExtKt.toKNListener(r111));
    }

    public void fetchPanelInfo(String r100, boolean r110, String r111, int r112, int r113, IFetchPanelInfoListener r114) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchPanelInfo(r100, r110, r111, r112, r113, null, ListenerAdaptExtKt.toKNListener(r114, r101.getEffectConfig().D));
        return;
    }

    public void fetchPanelInfoFromCache(String r100, boolean r101, String r110, int r111, int r112, IFetchPanelInfoListener r113) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.fetchPanelInfoFromCache(r100, r101, r110, r111, r112, ListenerAdaptExtKt.toKNListener(r113, r102.getEffectConfig().D));
        return;
    }

    public void fetchProviderEffect(String r100, boolean r110, int r111, int r112, String r113, IFetchProviderEffect r114) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchProviderEffect(r100, r110, r111, r112, r113, null, ListenerAdaptExtKt.toKNListener(r114));
        return;
    }

    public void searchEffect(String r100, String r101, int r110, int r111, Map<String, String> r112, ISearchEffectListener r113) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.searchEffect(r100, r101, r110, r111, r112, ListenerAdaptExtKt.toKNListener(r113));
        return;
    }

    public void searchEffects(String r100, String r101, int r110, int r111, Map<String, String> r112, ISearchEffectListenerV2 r113) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.searchEffects(r100, r101, r110, r111, r112, ListenerAdaptExtKt.toKNListener(r113));
        return;
    }

    public void searchProviderEffect(String r100, String r110, int r111, int r112, boolean r113, IFetchProviderEffect r114) {
        searchProviderEffect(r100, r110, r111, r112, r113, null, r114);
    }

    public void fetchCategoryEffect(String r110, String r111, int r112, int r113, int r114, String r115, IFetchCategoryEffectListener r116) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchCategoryEffect(r110, r111, r112, r113, r114, r115, null, ListenerAdaptExtKt.toKNListener(r116, r100.getEffectConfig().D));
        return;
    }

    public void fetchCategoryEffectFromCache(String r100, String r110, int r111, int r112, int r113, String r114, IFetchCategoryEffectListener r115) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchCategoryEffectFromCache(r100, r110, r111, r112, r113, r114, ListenerAdaptExtKt.toKNListener(r115, r101.getEffectConfig().D));
        return;
    }

    public void fetchInspirationFeedEffects(String r100, int r110, int r111, String r112, String r113, Map<String, String> r114, IFetchEffectListListener r115) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchInspirationFeedEffects(r100, r110, r111, r112, r113, r114, ListenerAdaptExtKt.toKNListener(r115));
        return;
    }

    public void fetchPanelInfoPagingFromCache(String r100, String r110, int r111, int r112, int r113, String r114, IFetchPanelInfoListener r115) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.fetchPanelInfoPagingFromCache(r100, r110, r111, r112, r113, r114, ListenerAdaptExtKt.toKNListener(r115, r101.getEffectConfig().D));
        return;
    }

    public void searchEffects(String r100, String r110, int r111, int r112, String r113, Map<String, String> r114, ISearchEffectListenerV2 r115) {
        EffectPlatform r101 = this.mEffectPlatform;
        if (r101 == null) goto L6;
        r101.searchEffects(r100, r110, r111, r112, r113, r114, ListenerAdaptExtKt.toKNListener(r115));
        return;
    }

    public void searchProviderEffect(String r100, String r101, int r110, int r111, boolean r112, String r113, IFetchProviderEffect r114) {
        EffectPlatform r102 = this.mEffectPlatform;
        if (r102 == null) goto L6;
        r102.searchProviderEffect(r100, r101, r110, r111, r113, ListenerAdaptExtKt.toKNListener(r114));
        return;
    }

    public void fetchCategoryEffect(String r110, String r111, int r112, int r113, int r114, String r115, Map<String, String> r116, IFetchCategoryEffectListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchCategoryEffect(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
        return;
    }

    public void fetchCategoryPagingEffect(String r110, String r111, int r112, int r113, int r114, String r115, Map<String, String> r116, IFetchCategoryEffectListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchCategoryPagingEffect(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
        return;
    }

    public void fetchCategoryPagingEffectFromCache(String r110, String r111, int r112, int r113, int r114, String r115, Map<String, String> r116, IFetchCategoryEffectListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchCategoryPagingEffectFromCache(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
        return;
    }

    public void fetchPanelInfo(String r110, boolean r111, String r112, int r113, int r114, boolean r115, Map<String, String> r116, IFetchPanelInfoListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        r100.fetchPanelInfo(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
    }

    public void fetchPanelInfoChecked(String r110, boolean r111, String r112, int r113, int r114, boolean r115, Map<String, String> r116, IFetchPanelInfoListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchPanelInfoChecked(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
        return;
    }

    public void fetchPanelInfoPaging(String r110, String r111, int r112, int r113, int r114, String r115, Map<String, String> r116, IFetchPanelInfoListener r117) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchPanelInfoPaging(r110, r111, r112, r113, r114, r115, r116, ListenerAdaptExtKt.toKNListener(r117, r100.getEffectConfig().D));
        return;
    }

    public void fetchPanelInfoPagingChecked(String r110, String r111, int r112, int r113, int r114, String r115, boolean r116, Map<String, String> r117, IFetchPanelInfoListener r210) {
        EffectPlatform r100 = this.mEffectPlatform;
        if (r100 == null) goto L6;
        r100.fetchPanelInfoPagingChecked(r110, r111, r112, r113, r114, r115, r116, r117, ListenerAdaptExtKt.toKNListener(r210, r100.getEffectConfig().D));
        return;
    }
}

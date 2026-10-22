package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public abstract class ResourceDataDao {
    public ResourceDataDao() {
    }

    public abstract int deleteAllPageData();

    public abstract int deleteAllPageData(long r100);

    public abstract int deleteAllResource();

    public abstract int deleteAllResource(long r100);

    public abstract int deleteResourceData(String r100, String r101);

    public abstract int deleteResourceData(String r100, String r101, long r102);

    public abstract int deleteResourceDataByDocToken(String r100);

    public abstract int deleteResourceDataByDocToken(String r100, long r101);

    public abstract int deleteResourceDataByTokens(List<String> r100);

    public abstract int deleteResourceDataByTokens(List<String> r100, long r101);

    public abstract List<String> getTokenList();

    public abstract long insertResourceData(ResourceData r100);

    public abstract List<ResourceDataDelegate> loadAllPageResourceDelegate();

    public abstract List<ResourceDataDelegate> loadAllPageResourceDelegate(long r100);

    public abstract LiveData<List<String>> loadCacheDocumentTokens(int r100);

    public abstract List<String> loadCachedTokensBykey(List<String> r100, String r101);

    public abstract List<ResourceDataDelegate> loadDeleteResourceDataByUpdateTime(List<String> r100, int r101);

    public abstract List<ResourceDataDelegate> loadDirtyPageData();

    public abstract List<String> loadDocxWithClientVarsWithoutSSR(int r100, String r101, String r102, long r103, int r104);

    public abstract List<ResourceDataDelegate> loadReourceDelegate(String r100, String r101);

    public abstract List<ResourceDataDelegate> loadResDataInDiskCache(int r100);

    public abstract List<Integer> loadResIdsByObjToken(String r100);

    public abstract ResourceData loadResourceData(String r100, String r101, int r102);

    public abstract ResourceData loadResourceDataByCategory(String r100, String r101, int r102);

    public abstract List<ResourceDataDelegate> loadResourceDataByDocToken(String r100);

    public abstract List<ResourceDataDelegate> loadResourceDataByDocToken(String r100, long r101);

    public abstract List<ResourceDataDelegate> loadResourceDataByNeedSync(boolean r100);

    public abstract ResourceData loadResourceDataBySync(String r100, boolean r101);

    public abstract List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMills(long r100, int r101);

    public abstract List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMillsV2(long r100, List<String> r101, int r102);

    public abstract ResourceDataSubInfo loadSubInfo(String r100, String r101, int r102);

    public abstract List<String> loadTokensBySync(boolean r100);

    public abstract List<String> loadTokensBySync(boolean r100, long r101);

    public abstract LiveData<List<String>> loadUnSyncDocuments();

    public abstract int updateResourceData(ResourceData r100);

    public abstract int updateResourceDataToken(String r100, String r101, List<Integer> r102);
}

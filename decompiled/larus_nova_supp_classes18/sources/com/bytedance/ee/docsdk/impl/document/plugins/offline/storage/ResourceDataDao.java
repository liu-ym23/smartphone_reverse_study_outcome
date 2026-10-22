package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class ResourceDataDao {
    public ResourceDataDao() {
    }

    public abstract int deleteAllPageData();

    public abstract int deleteAllPageData(long r1);

    public abstract int deleteAllResource();

    public abstract int deleteAllResource(long r1);

    public abstract int deleteResourceData(String r1, String r2);

    public abstract int deleteResourceData(String r1, String r2, long r3);

    public abstract int deleteResourceDataByDocToken(String r1);

    public abstract int deleteResourceDataByDocToken(String r1, long r2);

    public abstract int deleteResourceDataByTokens(List<String> r1);

    public abstract int deleteResourceDataByTokens(List<String> r1, long r2);

    public abstract List<String> getTokenList();

    public abstract long insertResourceData(ResourceData r1);

    public abstract List<ResourceDataDelegate> loadAllPageResourceDelegate();

    public abstract List<ResourceDataDelegate> loadAllPageResourceDelegate(long r1);

    public abstract LiveData<List<String>> loadCacheDocumentTokens(int r1);

    public abstract List<String> loadCachedTokensBykey(List<String> r1, String r2);

    public abstract List<ResourceDataDelegate> loadDeleteResourceDataByUpdateTime(List<String> r1, int r2);

    public abstract List<ResourceDataDelegate> loadDirtyPageData();

    public abstract List<String> loadDocxWithClientVarsWithoutSSR(int r1, String r2, String r3, long r4, int r6);

    public abstract List<ResourceDataDelegate> loadReourceDelegate(String r1, String r2);

    public abstract List<ResourceDataDelegate> loadResDataInDiskCache(int r1);

    public abstract List<Integer> loadResIdsByObjToken(String r1);

    public abstract ResourceData loadResourceData(String r1, String r2, int r3);

    public abstract ResourceData loadResourceDataByCategory(String r1, String r2, int r3);

    public abstract List<ResourceDataDelegate> loadResourceDataByDocToken(String r1);

    public abstract List<ResourceDataDelegate> loadResourceDataByDocToken(String r1, long r2);

    public abstract List<ResourceDataDelegate> loadResourceDataByNeedSync(boolean r1);

    public abstract ResourceData loadResourceDataBySync(String r1, boolean r2);

    public abstract List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMills(long r1, int r3);

    public abstract List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMillsV2(long r1, List<String> r3, int r4);

    public abstract ResourceDataSubInfo loadSubInfo(String r1, String r2, int r3);

    public abstract List<String> loadTokensBySync(boolean r1);

    public abstract List<String> loadTokensBySync(boolean r1, long r2);

    public abstract LiveData<List<String>> loadUnSyncDocuments();

    public abstract int updateResourceData(ResourceData r1);

    public abstract int updateResourceDataToken(String r1, String r2, List<Integer> r3);
}

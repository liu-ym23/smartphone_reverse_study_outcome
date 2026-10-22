package com.larus.home.impl.keva;

import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaPreloadHolder;
import com.larus.home.api.keva.IKevaPreloadService;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/home/impl/keva/KevaPreloadServiceImpl;", "Lcom/larus/home/api/keva/IKevaPreloadService;", "<init>", "()V", "preloadKevaRepoAuto", "", "preloadKevaRepos", "repoNames", "", "", "updateABSettings", "onFirstFeedFirstFrame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KevaPreloadServiceImpl implements IKevaPreloadService {
    public KevaPreloadServiceImpl() {
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void b() {
        System.currentTimeMillis();
        KevaPreloadHolder.initFetchable();
        boolean r100 = KevaPreloadHolder.isRepoPreloadEnable();
        boolean r101 = KevaPreloadHolder.isTopRepoPreloadEnable();
        String r102 = KevaPreloadHolder.TAG;
        if (r101 == false) goto L7;
        LinkedHashSet r103 = new LinkedHashSet();
        r103.addAll(KevaPreloadHolder.getTopRepoPreloadInfos());
        Collection r104 = r103;
        if (r100 == false) goto L10;
        r103.addAll(KevaPreloadHolder.getPreloadRepoInfos());
        r104 = r103;
    L10:
        r104.size();
        Iterator r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        KevaPreloadHolder.RepoInfo r106 = (KevaPreloadHolder.RepoInfo) r105.next();
        Keva.getRepoSync(r106.name, r106.mode);
        goto L12
    L14:
        System.currentTimeMillis();
        return;
    L7:
        if (r100 == false) goto L9;
        r104 = KevaPreloadHolder.getPreloadRepoInfos();
        goto L10
    L9:
        r104 = CollectionsKt.emptyList();
        goto L10
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void a() {
        KevaPreloadHolder.onFirstFeedFirstFrame();
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void c() {
        KevaPreloadHolder.updateABSettings();
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void d(List<String> r100) {
        Iterator<KevaPreloadHolder.RepoInfo> r101 = KevaPreloadHolder.getFeedShowRepoPreloadInfos(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        KevaPreloadHolder.RepoInfo r102 = r101.next();
        Keva.getRepoSync(r102.name, r102.mode);
        goto L4
    }
}

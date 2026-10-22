package com.bytedance.ee.bear.document.editionmanager;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import com.bytedance.ee.bear.k;

/* JADX INFO: loaded from: classes16.dex */
public class EditionViewModel extends ViewModel {
    private String currEditionId;
    private boolean hasMore;
    private final MutableLiveData<Boolean> mActive;
    private a mDelegate;
    private b mLoadDelegate;
    private final MutableLiveData<Boolean> mLoadingActive;
    private d mViewDelegate;
    private c onItemClickListener;
    private String pageToken;
    private String sourceToken;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public b getLoadDelegate() {
        return null;
    }

    public void setLoadDelegate(b r100) {
    }

    public void reportEditionSavedVersionClick() {
        a r100 = this.mDelegate;
        if (r100 == null) goto L6;
        EditionListPlugin.a r101 = (EditionListPlugin.a) r100;
        r101.getClass();
        ((k) org.koin.java.a.a(k.class)).i(EditionListPlugin.access$200(r101.f219678a), "exit", "none", "none");
        return;
    }

    public void requestEditionList() {
        a r100 = this.mDelegate;
        if (r100 == null) goto L6;
        EditionListPlugin.a r101 = (EditionListPlugin.a) r100;
        EditionListPlugin r102 = r101.f219678a;
        EditionListPlugin.access$100(r102, EditionListPlugin.access$000(r102).getPageToken(), EditionListPlugin.access$000(r101.f219678a).isHasMore());
        return;
    }

    public EditionViewModel() {
        this.mActive = new MutableLiveData(Boolean.FALSE);
        this.mLoadingActive = new MutableLiveData();
        this.hasMore = false;
    }

    public MutableLiveData<Boolean> getActive() {
        return this.mActive;
    }

    public String getCurrEditionId() {
        return this.currEditionId;
    }

    public a getDelegate() {
        return this.mDelegate;
    }

    public MutableLiveData<Boolean> getLoadingActive() {
        return this.mLoadingActive;
    }

    public c getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public String getSourceToken() {
        return this.sourceToken;
    }

    public d getViewDelegate() {
        return this.mViewDelegate;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setCurrEditionId(String r100) {
        this.currEditionId = r100;
    }

    public void setDelegate(a r100) {
        this.mDelegate = r100;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setOnItemClickListener(c r100) {
        this.onItemClickListener = r100;
    }

    public void setPageToken(String r100) {
        this.pageToken = r100;
    }

    public void setSourceToken(String r100) {
        this.sourceToken = r100;
    }

    public void setViewDelegate(d r100) {
        this.mViewDelegate = r100;
    }

    public void updateActive(boolean r100) {
        this.mActive.setValue(Boolean.valueOf(r100));
    }

    public void updateLoadingActive(boolean r100) {
        this.mLoadingActive.setValue(Boolean.valueOf(r100));
    }
}

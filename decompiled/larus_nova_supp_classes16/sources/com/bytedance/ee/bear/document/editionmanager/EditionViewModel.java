package com.bytedance.ee.bear.document.editionmanager;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import com.bytedance.ee.bear.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setLoadDelegate(b r1) {
    }

    public void reportEditionSavedVersionClick() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        EditionListPlugin.a r1 = (EditionListPlugin.a) r0;
        r1.getClass();
        ((k) org.koin.java.a.a(k.class)).i(EditionListPlugin.access$200(r1.a), CustomHeaderConfig.EXIT_MENU_ID, "none", "none");
        return;
    }

    public void requestEditionList() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        EditionListPlugin.a r1 = (EditionListPlugin.a) r0;
        EditionListPlugin r2 = r1.a;
        EditionListPlugin.access$100(r2, EditionListPlugin.access$000(r2).getPageToken(), EditionListPlugin.access$000(r1.a).isHasMore());
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

    public void setCurrEditionId(String r1) {
        this.currEditionId = r1;
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setOnItemClickListener(c r1) {
        this.onItemClickListener = r1;
    }

    public void setPageToken(String r1) {
        this.pageToken = r1;
    }

    public void setSourceToken(String r1) {
        this.sourceToken = r1;
    }

    public void setViewDelegate(d r1) {
        this.mViewDelegate = r1;
    }

    public void updateActive(boolean r2) {
        this.mActive.setValue(Boolean.valueOf(r2));
    }

    public void updateLoadingActive(boolean r2) {
        this.mLoadingActive.setValue(Boolean.valueOf(r2));
    }
}

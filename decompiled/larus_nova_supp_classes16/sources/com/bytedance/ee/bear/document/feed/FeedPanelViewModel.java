package com.bytedance.ee.bear.document.feed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FeedPanelViewModel extends ViewModel {
    private MutableLiveData<ShowCardsJsData> dataFeedPanel;
    private MutableLiveData<MessageResultBean.Data> feedMessageLiveData;
    private int panelHeight;
    private boolean show;
    private MutableLiveData<Boolean> showFeedPanel;
    private boolean whole;

    public void resetValue() {
        this.showFeedPanel.setValue(null);
        this.dataFeedPanel.setValue(null);
        this.panelHeight = 0;
        this.whole = false;
        this.show = false;
    }

    public FeedPanelViewModel() {
        this.showFeedPanel = new MutableLiveData();
        this.dataFeedPanel = new MutableLiveData();
        this.feedMessageLiveData = new MutableLiveData(null);
        this.panelHeight = 0;
        this.whole = false;
        this.show = false;
    }

    public LiveData<ShowCardsJsData> getDataFeedPanel() {
        return this.dataFeedPanel;
    }

    public MutableLiveData<MessageResultBean.Data> getFeedMessageLiveData() {
        return this.feedMessageLiveData;
    }

    public int getPanelHeight() {
        return this.panelHeight;
    }

    public LiveData<Boolean> getShowFeedPanel() {
        return this.showFeedPanel;
    }

    public boolean isShowing() {
        return this.show;
    }

    public boolean isWhole() {
        return this.whole;
    }

    public void setFeedMessageData(MessageResultBean.Data r2) {
        this.feedMessageLiveData.setValue(r2);
    }

    public void setFeedPanel(Boolean r2) {
        this.showFeedPanel.setValue(r2);
    }

    public void setPanelHeight(int r1) {
        this.panelHeight = r1;
    }

    public void setShow(boolean r1) {
        this.show = r1;
    }

    public void setWhole(boolean r1) {
        this.whole = r1;
    }

    public MessageConfig jsConfig2MessageConfig(com.bytedance.ee.bear.browser.plugin.f r4, p r5, DocViewModel r6) {
        DocumentInfo r7 = r6.getDocumentInfoData();
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        TranslateConfig r9 = (TranslateConfig) ((CommentPanelViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r4.getHost(), CommentPanelViewModel.class, null)).getTranslateConfig().getValue();
        MessageConfig r1 = new MessageConfig();
        r1.setToken(r5.a);
        r1.setAuto(r5.d);
        r1.setDocumentType(sbb.e.e(r5.getType()));
        r1.setOwner(r5.c);
        r1.setLoadingSuccess(true);
        r1.setSupportMute(r5.e);
        r1.setSupportReadAll(r5.f);
        r1.setCanCopy(r8);
        r1.setFilterTimestamp(r5.g);
        if (r9 == null) goto L11;
        r1.setTranslateConfig(r9);
    L11:
        return r1;
    L5:
        if (f35.b.f(r7) == false) goto L7;
        r8 = true;
        goto L8
    }
}

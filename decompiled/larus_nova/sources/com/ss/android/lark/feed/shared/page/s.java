package com.ss.android.lark.feed.shared.page;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes35.dex */
public interface s {
    i1<Boolean> canLoadMoreState(com.larksuite.arch.jack.f r100);

    i1<com.larksuite.arch.jack.d<FeedPreview>> clearBadgeConfirmEvent(com.larksuite.arch.jack.f r100);

    i1<com.larksuite.arch.jack.d<String>> createFeedGroupActivityEvent(com.larksuite.arch.jack.f r100);

    i1<UpdateRecord> feedItemEntities(com.larksuite.arch.jack.f r100);

    void foregroundFilterChanged();

    UpdateRecord getCurrentFeedItems();

    i1<com.larksuite.arch.jack.d<Pair<FeedCard.Type, String>>> handlePendingDeleteFeedEvent(com.larksuite.arch.jack.f r100);

    boolean isDataForceEmpty(FeedFolder r100);

    i1<com.larksuite.arch.jack.d<FeedPreview>> notifyItemChangedEvent(com.larksuite.arch.jack.f r100);

    void onItemChanged(int r100, UIFeedCard r101, boolean r102);

    void onItemChangedIgnoreCanLoadMore(int r100, UIFeedCard r101, boolean r102);

    void onItemsShowed(int r100, List<? extends UIFeedCard> r101, boolean r102);

    void pauseDataChange();

    i1<com.larksuite.arch.jack.d<Unit>> recoverRecentItemPositionEvent(com.larksuite.arch.jack.f r100);

    i1<com.larksuite.arch.jack.d<String>> refreshItems(com.larksuite.arch.jack.f r100);

    void resumeData();

    void setFilterDoubaoConversation(boolean r100);

    i1<com.larksuite.arch.jack.d<FeedFolder>> showMarkedLaterDialogEvent(com.larksuite.arch.jack.f r100);

    void showNextUnreadFeedItem(UIFeedCard r100);

    i1<com.larksuite.arch.jack.d<String>> showToastEvent(com.larksuite.arch.jack.f r100);

    void start(FeedFolder r100);

    i1<com.larksuite.arch.jack.d<String>> startAddFeedGroupActivityEvent(com.larksuite.arch.jack.f r100);
}

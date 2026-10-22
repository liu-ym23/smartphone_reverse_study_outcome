package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    boolean canShowAi();

    e3 cloneWorkspace();

    void collapse(String r1);

    void collapseSpace(String r1);

    void delete(String r1, String r2);

    void deleteCurrentOnly(String r1, String r2);

    void expand(String r1);

    void expandSpace(String r1);

    void favorite(String r1);

    String getFocusToken();

    String getFocusUid();

    Flowable<GetMoveNodeAuthorizedUserInfoPuller.Result> getMoveNodeAuthorizedUserInfo(String r1, String r2);

    Flowable<MoveToSpaceStatusPuller.Result> getMoveToSpaceStatus(String r1);

    TreeNode getNode(String r1);

    String getRootToken();

    String getRootUid();

    SpaceInfo getSpaceInfo();

    SpacePerm getSpacePerm();

    SpaceUserPerm getSpaceUserPerm();

    String getTitle(String r1);

    MutableLiveData<h> getWikiUIList();

    void insert(IOperationInsert.TreeNodeInsertParams r1);

    boolean isCloudPinDocument(String r1);

    boolean isContainInParent(String r1, String r2);

    boolean isEmpty();

    boolean isFavorite(String r1);

    boolean isPersonalEmpty();

    boolean isSameSpace(String r1);

    boolean isSidebarShared(String r1);

    void load(e3 r1, String r2, String r3, boolean r4, boolean r5);

    void load(String r1, String r2, String r3, boolean r4);

    void makeCopyTo(String r1, String r2, String r3, TreeNode r4);

    void moveTo(String r1, String r2, String r3, boolean r4, String r5, int r6);

    Flowable<MoveToSpacePuller.Result> moveToSpace(String r1, String r2);

    boolean needShowMyLibrary();

    void pin(String r1, String r2, int r3);

    void refresh();

    void registerChainPush(String r1);

    void removeFromWiki(String r1, String r2);

    void rename(String r1, String r2);

    Flowable<WikNodePerm> requestNodePerm(String r1, String r2);

    void setChainPushEnable(boolean r1);

    void setDataFilter(Function<TreeNode, Boolean> r1);

    void setDisableLocalPushFocusToken(boolean r1);

    void setEnableCheckers(List<Function<TreeNode, Boolean>> r1);

    void setEnableSwipeCheckers(List<Function<TreeNode, Boolean>> r1);

    void setFavoriteEnable(boolean r1);

    void setFocus(String r1, String r2);

    void setLocalPushEnable(boolean r1);

    void setSingleNodeFilters(List<Function<j, Boolean>> r1);

    void setTagSuffix(String r1);

    void setUserComponentAbility(ce5.a r1);

    void setViewConfig(WikiTreeCtrlView.c r1);

    void shortcutTo(String r1, String r2, String r3, TreeNode r4);

    void unPin(String r1, String r2, int r3);

    void unfavorite(String r1);

    void updatePinStatus(String r1, boolean r2);

    void updateStarStatus(String r1, boolean r2);
}

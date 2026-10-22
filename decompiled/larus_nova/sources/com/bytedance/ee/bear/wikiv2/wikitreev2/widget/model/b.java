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

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    boolean canShowAi();

    e3 cloneWorkspace();

    void collapse(String r100);

    void collapseSpace(String r100);

    void delete(String r100, String r101);

    void deleteCurrentOnly(String r100, String r101);

    void expand(String r100);

    void expandSpace(String r100);

    void favorite(String r100);

    String getFocusToken();

    String getFocusUid();

    Flowable<GetMoveNodeAuthorizedUserInfoPuller.Result> getMoveNodeAuthorizedUserInfo(String r100, String r101);

    Flowable<MoveToSpaceStatusPuller.Result> getMoveToSpaceStatus(String r100);

    TreeNode getNode(String r100);

    String getRootToken();

    String getRootUid();

    SpaceInfo getSpaceInfo();

    SpacePerm getSpacePerm();

    SpaceUserPerm getSpaceUserPerm();

    String getTitle(String r100);

    MutableLiveData<h> getWikiUIList();

    void insert(IOperationInsert.TreeNodeInsertParams r100);

    boolean isCloudPinDocument(String r100);

    boolean isContainInParent(String r100, String r101);

    boolean isEmpty();

    boolean isFavorite(String r100);

    boolean isPersonalEmpty();

    boolean isSameSpace(String r100);

    boolean isSidebarShared(String r100);

    void load(e3 r100, String r101, String r102, boolean r103, boolean r104);

    void load(String r100, String r101, String r102, boolean r103);

    void makeCopyTo(String r100, String r101, String r102, TreeNode r103);

    void moveTo(String r100, String r101, String r102, boolean r103, String r104, int r105);

    Flowable<MoveToSpacePuller.Result> moveToSpace(String r100, String r101);

    boolean needShowMyLibrary();

    void pin(String r100, String r101, int r102);

    void refresh();

    void registerChainPush(String r100);

    void removeFromWiki(String r100, String r101);

    void rename(String r100, String r101);

    Flowable<WikNodePerm> requestNodePerm(String r100, String r101);

    void setChainPushEnable(boolean r100);

    void setDataFilter(Function<TreeNode, Boolean> r100);

    void setDisableLocalPushFocusToken(boolean r100);

    void setEnableCheckers(List<Function<TreeNode, Boolean>> r100);

    void setEnableSwipeCheckers(List<Function<TreeNode, Boolean>> r100);

    void setFavoriteEnable(boolean r100);

    void setFocus(String r100, String r101);

    void setLocalPushEnable(boolean r100);

    void setSingleNodeFilters(List<Function<j, Boolean>> r100);

    void setTagSuffix(String r100);

    void setUserComponentAbility(ce5.a r100);

    void setViewConfig(WikiTreeCtrlView.c r100);

    void shortcutTo(String r100, String r101, String r102, TreeNode r103);

    void unPin(String r100, String r101, int r102);

    void unfavorite(String r100);

    void updatePinStatus(String r100, boolean r101);

    void updateStarStatus(String r100, boolean r101);
}

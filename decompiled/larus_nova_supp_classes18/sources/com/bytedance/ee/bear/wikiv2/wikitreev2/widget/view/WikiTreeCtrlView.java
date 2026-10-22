package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.MoveSource;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModelV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 Â\u00012\u00020\u0001:\b¿\u0001À\u0001Á\u0001Â\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020K2\u0006\u0010M\u001a\u00020NJ\u0010\u0010P\u001a\u00020K2\u0006\u0010M\u001a\u00020NH\u0014J\u001e\u0010Q\u001a\u00020K2\b\u0010R\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#H\u0002J\b\u0010T\u001a\u00020KH\u0016J\u000e\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020WJ\u0010\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010\\\u001a\u00020K2\u0006\u0010]\u001a\u00020^H\u0002J\u0006\u0010_\u001a\u00020KJ\u0010\u0010`\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010a\u001a\u00020W2\b\u0010R\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u00020K2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020K2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020KH\u0014J\b\u0010l\u001a\u00020KH\u0002J\u0006\u0010m\u001a\u00020#J8\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u000e\u0010x\u001a\u00020K2\u0006\u0010R\u001a\u00020#J \u0010x\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0006\u0010y\u001a\u00020#2\b\u0010z\u001a\u0004\u0018\u00010#J\u0006\u0010{\u001a\u00020KJ$\u0010|\u001a\u00020K2\u0006\u0010}\u001a\u00020#2\b\u0010R\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010+J\u0006\u0010\u007f\u001a\u00020WJ\u0015\u0010\u0080\u0001\u001a\u00020K2\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001J\u0007\u0010\u0083\u0001\u001a\u00020KJ\u0018\u0010\u0084\u0001\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0007\u0010\u0085\u0001\u001a\u00020#J\u0018\u0010\u0086\u0001\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020#J\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010q2\u0006\u0010R\u001a\u00020#J\u000f\u0010¡\u0001\u001a\u00020K2\u0006\u0010S\u001a\u00020#J\u0019\u0010¢\u0001\u001a\u00020K2\u0007\u0010\u0085\u0001\u001a\u00020#2\u0007\u0010£\u0001\u001a\u00020WJ\u0017\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\u0007\u0010\u0085\u0001\u001a\u00020#J\u0012\u0010¦\u0001\u001a\u00020K2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010#J\u0012\u0010§\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010©\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010ª\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010«\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J=\u0010¬\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020s2\t\b\u0002\u0010\u0099\u0001\u001a\u00020W2\u0007\u0010\u00ad\u0001\u001a\u00020W2\u0007\u0010\u0080\u0001\u001a\u00020W2\f\b\u0002\u0010®\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\u0013\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020#H\u0002J\u0012\u0010²\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u000f\u0010³\u0001\u001a\u00020#2\u0006\u0010R\u001a\u00020#J%\u0010´\u0001\u001a\u00020K2\u0007\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020\u00072\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001J\u0007\u0010¹\u0001\u001a\u00020WJ\u0007\u0010º\u0001\u001a\u00020WJ\u0010\u0010»\u0001\u001a\u00020K2\u0007\u0010¼\u0001\u001a\u00020;J\t\u0010½\u0001\u001a\u00020KH\u0002J\t\u0010¾\u0001\u001a\u00020KH\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0015\u0010}\u001a\u0004\u0018\u00010#8F¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018F¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00018F¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0092\u0001\u001a\u00020#8F¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001R\u0016\u0010\u0094\u0001\u001a\u0004\u0018\u00010q8F¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0014\u0010\u0097\u0001\u001a\u00020#8F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0089\u0001R\u0014\u0010\u0099\u0001\u001a\u00020W8F¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0014\u0010\u009c\u0001\u001a\u00020W8F¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009b\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "wikiTreeViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "getWikiTreeViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "setWikiTreeViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;)V", "uploadViewContainerFromXml", "getUploadViewContainerFromXml", "()Landroid/widget/FrameLayout;", "setUploadViewContainerFromXml", "(Landroid/widget/FrameLayout;)V", "stickyHeadFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "getStickyHeadFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "setStickyHeadFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "TAG", "", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;", "setViewModel", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;)V", "viewConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewConfig;", "viewLifecycleOwner", "Landroidx/fragment/app/Fragment;", "getViewLifecycleOwner", "()Landroidx/fragment/app/Fragment;", "setViewLifecycleOwner", "(Landroidx/fragment/app/Fragment;)V", "uploadView", "Lcom/bytedance/ee/bear/list/common/header/DriveUploadView;", "wikiDialog", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "atomicInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onTreeUpdateListener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$OnTreeUpdateListener;", "itemMoreViewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiItemMoreViewDelegate;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;)V", "inflateLayout", "", "initOnce", "initConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlViewInitConfig;", "init", "doInit", "initView", WikiFolderPushPlugin.WIKI_TOKEN, "uniqueUiId", "initEmptyView", "setUploadViewVisible", "visible", "", "updateEmptyView", "result", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Result;", "updateSidebarEmptyViewWithPush", "bindView", "viewLifeOwner", "Landroidx/lifecycle/LifecycleOwner;", "refresh", "reportOpenFinish", "isDisableToken", "doLoading", "loading", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Loading;", "doErr", "err", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Err;", "doOk", "ok", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Ok;", "scrollToCenterWhenInit", "bindListener", "getRootToken", "getMoreProvider", "Lcom/bytedance/ee/bear/more/protocol3/extension/BaseMoreProvider;", "wikiNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "node", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "wikiPerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "delegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs$ItemMoreViewDelegate;", "focusTo", "targetSpaceId", "visibleSpaceId", "focusRoot", "load", "spaceId", "config", "isSameTenant", "insertRoot", "view", "Landroid/view/View;", "insertRootDoc", "insertDoc", "uid", "rename", "newTitle", "getSpaceId", "()Ljava/lang/String;", "spaceInfo", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo;", "getSpaceInfo", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo;", "spaceUserPerm", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceUserPerm;", "getSpaceUserPerm", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceUserPerm;", "focusToken", "getFocusToken", "focusTreeNode", "getFocusTreeNode", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "focusUid", "getFocusUid", "canCreate", "getCanCreate", "()Z", "canShowAi", "getCanShowAi", "cloneWorkspace", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "getNode", "scrollToCenter", "setSwipeMenuOpen", "open", "findSwipeItemLocation", "", "expand", "doExpand", "target", "doCollapse", "doExpandSpace", "doCollapseSpace", "doInsert", "offlineCreateEnable", "anchorView", "getFilePermissionResponse", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "operate", "doSwipeRequest", "getTitleFromToken", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "isMyLib", "isEmpty", "setTreeUpdateListener", "listener", "onClear", "onDetachedFromWindow", "ViewConfig", "ViewDelegate", "OnTreeUpdateListener", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeCtrlView extends FrameLayout {
    public static final /* synthetic */ int q = 0;
    public WikiTreeView a;
    public FrameLayout b;
    public WikItemRootView c;
    public WikiEmptyView d;
    public String e;
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b f;
    public c g;
    public Fragment h;
    public pc5.i i;
    public final WikiDialogs j;
    public final CompositeDisposable k;
    public final AtomicBoolean l;
    public b m;
    public c0 n;
    public ce5.a o;
    public d p;

    public static final class a {
        public static com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b a(ViewModelStoreOwner r3, ce5.a r4) {
            Intrinsics.checkNotNullParameter(r3, "dataLifeOwner");
            Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
            int r1 = qc5.a.a;
            Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
            boolean r0 = r4.d.isEnable("ccm.mobile.wiki_tree_optimization");
            tt5.a.h("SpaceFeatureGatingV2", "isWikiTreeOptimization()...enable = " + r0);
            if (r0 == false) goto L5;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r5 = WikiTreeModelV2.newInstance(r3, r4);
            Intrinsics.checkNotNull(r5);
            return r5;
        L5:
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r6 = WikiTreeModel.newInstance(r3, r4);
            Intrinsics.checkNotNull(r6);
            return r6;
        }
    }

    public interface b {
        void onUpdate();
    }

    public static final class c {
        public String a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public Function<TreeNode, Boolean> i;
        public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> j;
        public List<? extends Function<TreeNode, Boolean>> k;
        public List<? extends Function<TreeNode, Boolean>> l;
        public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> m;
        public boolean n;
        public List<? extends RecyclerView.ItemDecoration> o;
        public String p;
        public String q;
        public Integer r;
        public boolean s;
        public ar5.a t;
        public boolean u;

        public static final class a {
        }

        public static final class b implements Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean> {
            public b() {
            }

            public final Object apply(Object r2) {
                Intrinsics.checkNotNullParameter((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r2, "t");
                return Boolean.FALSE;
            }
        }

        static {
        }

        public c() {
            this.a = "";
            this.b = true;
            this.m = CollectionsKt.listOf(new b());
            this.p = "";
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(Throwable r1) {
        }

        public void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "newToken");
            Intrinsics.checkNotNullParameter(r3, "uniqueUiId");
        }

        public void f(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r3, "uniqueUiId");
        }

        public void g(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "toToken");
            Intrinsics.checkNotNullParameter(r4, "toSpaceName");
        }

        public void h(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "movToken");
            Intrinsics.checkNotNullParameter(r4, "focusToken");
        }

        public void i(String r2, List<String> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "movTokenList");
            Intrinsics.checkNotNullParameter(r4, "focusToken");
        }

        public void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "delParentToken");
        }

        public void k(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "movToken");
            Intrinsics.checkNotNullParameter(r4, "focusToken");
        }

        public void l() {
        }

        public void m(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "reloadType");
        }

        public void n(String r2) {
            Intrinsics.checkNotNullParameter(r2, "delParentToken");
        }

        public void o(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "toToken");
            Intrinsics.checkNotNullParameter(r4, "toSpaceName");
        }

        public void p() {
        }

        public void q(String r2) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void r(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileExtra");
        }

        public void d(WikiHomePageV2 r3) {
            Intrinsics.checkNotNullParameter(r3, "homePage");
            tt5.a.h("Wiki_WikiTreePanelDialog", "onHomePageClick default call onItemClick");
            f(r3.wikiToken, "");
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WikiAction.values().length];
            r0[WikiAction.INIT_LOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[WikiAction.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[WikiAction.MOV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[WikiAction.PUSH_MOV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[WikiAction.PUSH_UDE_NAME_ICON.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[WikiAction.PUSH_TOKEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[WikiAction.DEL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[WikiAction.MAKE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[WikiAction.FAVORITE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[WikiAction.UNFAVORITE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[WikiAction.PUSH_DEL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[WikiAction.PUSH_BATCH_MOV.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[WikiAction.SHORTCUT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    public static final class f implements WikiCreateSelectPanelDialog.b {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j a;
        public final /* synthetic */ WikiTreeCtrlView b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        @Override // com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog.b
        public final void a(int r20) {
            SelectIndex.Companion.getClass();
            SelectIndex r0 = SelectIndex.a.a(r20);
            int r2 = r0.getDocumentType();
            String r4 = gq5.d.j.a(r20);
            if (SelectIndex.a.a(r20).getDocumentType() != 12) goto L5;
            String r3 = "ccm_space_file_choose_view";
        L6:
            String r5 = r3;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r6 = this.a;
            c r7 = this.b.g;
            if (r7 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            r7 = null;
        L9:
            boolean r8 = r7.s;
            String r9 = this.b.getRootToken();
            boolean r10 = this.c;
            Intrinsics.checkNotNullParameter(r6, "<this>");
            if (r8 == true) goto L13;
        L26:
            String r11 = "wiki_tree";
        L27:
            String r12 = r11;
            String r13 = sbb.e.c(r2);
            Boolean r14 = Boolean.valueOf(this.a.d());
            String r15 = this.b.getSpaceId();
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r16 = this.a;
            String r17 = r16.b;
            Boolean r18 = Boolean.valueOf(r16.e());
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19 = this.a;
            gq5.d.f r110 = new gq5.d.f(r4, r5, r12, r13, r14, r15, r17, r18, r19.c, sbb.e.c(r19.d), Boolean.valueOf(this.b.n()));
            int r21 = gq5.d.a;
            Intrinsics.checkNotNullParameter(r110, "bean");
            JSONObject r22 = new JSONObject();
            gq5.e.b(r22, "click", r110.a);
            gq5.e.b(r22, "target", r110.b);
            gq5.e.b(r22, "children_file_type", r110.d);
            Boolean r23 = r110.e;
            if (r23 == null) goto L30;
            String r111 = r23.toString();
        L31:
            gq5.e.b(r22, "is_favorites", r111);
            gq5.e.b(r22, "trigger_location", r110.c);
            gq5.d.a(r22, r110.f, r110.g, r110.h, r110.i, r110.j, null, r110.k, 32);
            gq5.e.c("ccm_wiki_tree_add_click", r22);
            this.b.getWikiTreeViewFromXml().n(this.a.n, false);
            if (r0 != SelectIndex.MEDIA) goto L49;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L38;
            PermissionResponse r1 = WikiTreeCtrlView.b(this.b);
            r1.getCallback().a(this.b.getContext(), r1);
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.d(r1) == false) goto L47;
            return;
        L47:
            ((com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6)).r0(this.a.b(), DocumentType.WIKI_NAME, new Bundle(), -1);
            return;
        L38:
            gj5.b r24 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r25 = FileBizDomain.FileBizDomainCCM;
            gj5.c r26 = r24.g("CCM_FILE_UPLOAD", r25, 12, "");
            if (r26.a == true) goto L47;
            FileAuthResultFrom r27 = r26.b;
            if (r27 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L44;
            ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_UPLOAD", r25, 12, "");
            return;
        L44:
            if (r27 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L79;
            Toast.showText(this.b.getContext(), 2131887246);
            return;
        L79:
            return;
        L49:
            if (r0 != SelectIndex.FILE) goto L66;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L55;
            PermissionResponse r28 = WikiTreeCtrlView.b(this.b);
            r28.getCallback().a(this.b.getContext(), r28);
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.d(r28) == false) goto L64;
            return;
        L64:
            ((com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6)).J0(this.a.b(), DocumentType.WIKI_NAME, new Bundle(), -1);
            return;
        L55:
            gj5.b r29 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r30 = FileBizDomain.FileBizDomainCCM;
            gj5.c r31 = r29.g("CCM_FILE_UPLOAD", r30, 12, "");
            if (r31.a == true) goto L64;
            FileAuthResultFrom r32 = r31.b;
            if (r32 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L61;
            ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_UPLOAD", r30, 12, "");
            return;
        L61:
            if (r32 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L81;
            Toast.showText(this.b.getContext(), 2131887246);
            return;
        L81:
            return;
        L66:
            if (r2 == 12) goto L84;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r33 = this.b.getViewModel();
            IOperationInsert.TreeNodeInsertParams r34 = new IOperationInsert.TreeNodeInsertParams();
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r35 = this.a;
            WikiTreeCtrlView r36 = this.b;
            boolean r37 = this.d;
            r34.parentToken = r35.b;
            r34.documentType = r2;
            r34.uid = r35.n;
            r34.title = "";
            if (r0 != SelectIndex.SURVEY) goto L74;
            r34.templateToken = com.bytedance.ee.bear.templates.a.b();
            HashMap r38 = new HashMap();
            r38.put("business_source", "space_form");
            r38.put("time_zone", zu5.b.c());
            r34.extInfo = new Gson().toJson(r38);     // Catch: Exception -> L72
        L72:
            e = move-exception;
            tt5.a.d(r36.e, String.valueOf(e.getMessage()));
        L74:
            r34.forceExpand = true;
            r34.offlineCreateEnable = r37;
            r33.insert(r34);
            return;
        L84:
            return;
        L30:
            r111 = null;
            goto L31
        L13:
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r6.n, 0)) == false) goto L16;
            r11 = "sidebar_pin_docs";
            goto L27
        L16:
            if (TextUtils.equals("wikiroot%title_root_share_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r6.n, 0)) == false) goto L19;
            r11 = "sidebar_shared";
            goto L27
        L19:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r6.n, 0), r9) == false) goto L24;
            if (r10 == false) goto L22;
            r11 = "sidebar_my_docs_tab";
            goto L27
        L22:
            r11 = "sidebar_my_docs_node";
            goto L27
        L24:
            if (TextUtils.equals("wikiroot%top_wiki_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r6.n, 0)) == false) goto L26;
            r11 = "sidebar_pin_wiki";
            goto L27
        L5:
            r3 = "ccm_docs_page_view";
            goto L6
        }

        public f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, WikiTreeCtrlView r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public WikiTreeCtrlView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public WikiTreeCtrlView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public WikiTreeCtrlView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    public void r(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    public final String getRootToken() {
        if (this.f == null) goto L9;
        String r0 = getViewModel().getRootToken();
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    L9:
        return "";
    }

    public final WikItemRootView getStickyHeadFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131387355);
        this.c = (WikItemRootView) r0;
    L6:
        return (WikItemRootView) r0;
    }

    public final FrameLayout getUploadViewContainerFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131391938);
        this.b = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final Fragment getViewLifecycleOwner() {
        Fragment r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewLifecycleOwner");
        return null;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b getViewModel() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final WikiEmptyView getWikiEmptyViewFromXml() {
        EmptyView r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131393227);
        this.d = (WikiEmptyView) r0;
    L6:
        return (WikiEmptyView) r0;
    }

    public final WikiTreeView getWikiTreeViewFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131393270);
        this.a = (WikiTreeView) r0;
    L6:
        return (WikiTreeView) r0;
    }

    public final e3 c() {
        return getViewModel().cloneWorkspace();
    }

    public final boolean getCanCreate() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r0 = getViewModel();
        if (r0 == null) goto L10;
        SpacePerm r1 = r0.getSpacePerm();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.canEditFirstLevel != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean getCanShowAi() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r0 = getViewModel();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.canShowAi() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String getFocusToken() {
        return getViewModel().getFocusToken();
    }

    public final TreeNode getFocusTreeNode() {
        return getViewModel().getNode(getFocusToken());
    }

    public final String getFocusUid() {
        return getViewModel().getFocusUid();
    }

    public final String getSpaceId() {
        SpaceInfo r0 = getViewModel().getSpaceInfo();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.space_id;
    }

    public final SpaceInfo getSpaceInfo() {
        return getViewModel().getSpaceInfo();
    }

    public final SpaceUserPerm getSpaceUserPerm() {
        return getViewModel().getSpaceUserPerm();
    }

    public void h() {
        LayoutInflater.from(getContext()).inflate(2131568268, this);
    }

    public void j() {
        WikiEmptyView r0 = getWikiEmptyViewFromXml();
        WikiTreeView r1 = getWikiTreeViewFromXml();
        int r2 = WikiEmptyView.j;
        r0.g = r1;
        r0.h = null;
    }

    public final boolean n() {
        SpaceInfo r0 = getViewModel().getSpaceInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMyLib();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h(this.e, "onClear. ");
        this.j.c();
        this.k.clear();
        c0 r0 = this.n;
        if (r0 == null) goto L5;
        r0.j.clear();
    L5:
        pc5.i r1 = this.i;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        this.i = null;
    }

    public void p() {
        getWikiTreeViewFromXml().j(getViewModel().getFocusUid());
    }

    public final ce5.a getUserComponentAbility() {
        return this.o;
    }

    public final d getViewDelegate() {
        return this.p;
    }

    public static final PermissionResponse b(WikiTreeCtrlView r4) {
        r4.getClass();
        BaseEntity r5 = new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r5, "UPLOAD"), null);
    }

    public void d(f1 r7) {
        Intrinsics.checkNotNullParameter(r7, "initConfig");
        tt5.a.h(this.e, "doInit. ");
        setViewLifecycleOwner(r7.a);
        Fragment r0 = r7.f;
        if (r0 != null) goto L5;
        r0 = r7.a;
    L5:
        setViewModel(a.a(r0, r7.i));
        this.g = r7.e;
        this.o = r7.i;
        String r1 = r7.d;
        String r2 = r7.g;
        StringBuilder r3 = new StringBuilder("Wiki_WikiTreeCtrlView@");
        c r4 = this.g;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r4 = null;
    L8:
        r3.append(r4.p);
        this.e = r3.toString();
        WikiTreeView r5 = getWikiTreeViewFromXml();
        c r6 = this.g;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L11:
        r5.setDisableToken(r6.a);
        WikiTreeView r8 = getWikiTreeViewFromXml();
        c r9 = this.g;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r9 = null;
    L14:
        r8.setEnableRootCheckers(r9.m);
        WikiTreeView r10 = getWikiTreeViewFromXml();
        c r11 = this.g;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r11 = null;
    L17:
        r10.setEnableSwipeMenu(r11.c);
        WikiTreeView r12 = getWikiTreeViewFromXml();
        c r13 = this.g;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r13 = null;
    L20:
        r12.setItemDecorations(r13.o);
        WikiTreeView r14 = getWikiTreeViewFromXml();
        c r15 = this.g;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r15 = null;
    L23:
        r14.setSource(r15.q);
        getWikiTreeViewFromXml().setFragment(getViewLifecycleOwner());
        getWikiTreeViewFromXml().setUserComponentAbility(this.o);
        c r16 = this.g;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r16 = null;
    L27:
        if (r16.u == true) goto L36;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r17 = getViewModel();
        c r18 = this.g;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r18 = null;
    L32:
        if (r18.h == true) goto L35;
        r1 = "";
    L35:
        r17.setFocus(r1, r2);
    L36:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r19 = getViewModel();
        c r20 = this.g;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r20 = null;
    L39:
        r19.setFavoriteEnable(r20.b);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r21 = getViewModel();
        c r22 = this.g;
        if (r22 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r22 = null;
    L42:
        r21.setChainPushEnable(r22.e);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r23 = getViewModel();
        c r24 = this.g;
        if (r24 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r24 = null;
    L45:
        r23.setLocalPushEnable(r24.f);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r25 = getViewModel();
        c r26 = this.g;
        if (r26 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r26 = null;
    L48:
        r25.setDataFilter(r26.i);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r27 = getViewModel();
        c r28 = this.g;
        if (r28 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r28 = null;
    L51:
        r27.setSingleNodeFilters(r28.j);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r29 = getViewModel();
        c r30 = this.g;
        if (r30 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r30 = null;
    L54:
        r29.setEnableCheckers(r30.k);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r31 = getViewModel();
        c r32 = this.g;
        if (r32 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r32 = null;
    L57:
        r31.setEnableSwipeCheckers(r32.l);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r33 = getViewModel();
        c r34 = this.g;
        if (r34 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r34 = null;
    L60:
        r33.setTagSuffix(r34.p);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r35 = getViewModel();
        c r36 = this.g;
        if (r36 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r36 = null;
    L63:
        r35.setDisableLocalPushFocusToken(r36.n);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r37 = getViewModel();
        c r38 = this.g;
        if (r38 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r38 = null;
    L66:
        r37.setViewConfig(r38);
        j();
        c r39 = this.g;
        if (r39 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r39 = null;
    L70:
        if (r39.d == false) goto L77;
        pc5.i r40 = new pc5.i(getContext());
        this.i = r40;
        r40.setViewDelegate(new d1(this));
        pc5.i r41 = this.i;
        if (r41 == null) goto L82;
        String r42 = getSpaceId();
        if (r42 != null) goto L76;
        r42 = "none";
    L76:
        r41.a("all_files_token", "workspace", r42);
    L82:
        if (qc5.a.h() == false) goto L86;
        WikItemRootView r43 = getStickyHeadFromXml();
        if (r43 == null) goto L86;
        r43.setOnAddClickListener(new e1(this));
    L86:
        getViewModel().getWikiUIList().observe(r7.a.getViewLifecycleOwner(), new WikiTreeCtrlView$bindView$1(this));
        getWikiTreeViewFromXml().setListener(new v0(this));
        tt5.a.h(this.e, "doInit, init finish, viewModel@" + getViewModel().hashCode());
        return;
    L77:
        pc5.i r44 = this.i;
        if (r44 == null) goto L80;
        r44.setViewDelegate(null);
    L80:
        this.i = null;
        goto L82
    }

    public final TreeNode g(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        return getViewModel().getNode(r2);
    }

    public final void i(f1 r18) {
        Intrinsics.checkNotNullParameter(r18, "initConfig");
        String r3 = "";
        boolean r4 = false;
        Integer r5 = null;
        c r6 = null;
        if (yp5.c.h() == false) goto L66;
        if (r18.e.u == false) goto L66;
        d(r18);
        ar5.a r2 = r18.e.t;
        WikiTreeView r7 = getWikiTreeViewFromXml();
        SpaceInfo r8 = getViewModel().getSpaceInfo();
        if (r8 == null) goto L10;
        String r9 = r8.space_id;
        if (r9 == null) goto L10;
    L11:
        r7.setSpaceId(r9);
        WikiTreeView r10 = getWikiTreeViewFromXml();
        SpaceInfo r11 = getViewModel().getSpaceInfo();
        if (r11 == null) goto L14;
        boolean r12 = r11.isMyLib();
    L15:
        r10.setMyLib(r12);
        WikiTreeView r13 = getWikiTreeViewFromXml();
        SpaceInfo r14 = getViewModel().getSpaceInfo();
        if (r14 == null) goto L18;
        Integer r15 = Integer.valueOf(r14.space_type);
    L19:
        r13.setSpaceType(r15);
        if (getViewModel().getNode(r18.d) == null) goto L29;
        if (r2 == null) goto L28;
        SpaceInfo r16 = getViewModel().getSpaceInfo();
        if (r16 == null) goto L25;
        String r17 = r16.space_id;
    L27:
        if (TextUtils.equals(r17, r2.a) == false) goto L29;
    L25:
        r17 = null;
    L28:
        boolean r19 = true;
    L30:
        if (r19 == false) goto L63;
        c r20 = this.g;
        if (r20 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r20 = null;
    L34:
        r20.t = null;
        c r21 = this.g;
        if (r21 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L39:
        if (r6.h == false) goto L41;
        String r22 = r18.d;
    L42:
        String r23 = r18.g;
        if (r23 != null) goto L46;
        r23 = "";
    L46:
        if (r23.length() <= 0) goto L48;
        r4 = true;
    L48:
        if (r4 == false) goto L51;
        r3 = r23;
    L56:
        getViewModel().setFocus(r22, r3);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r24 = getViewModel();
        SpaceInfo r25 = getViewModel().getSpaceInfo();
        if (r25 == null) goto L60;
        String r26 = r25.space_id;
        if (r26 == null) goto L60;
    L61:
        String r1 = r18.d;
        r24.load(r26, r1, r3, !m(r1));
        return;
    L60:
        r26 = r18.b;
        goto L61
    L51:
        if (TextUtils.equals(getViewModel().getFocusToken(), r22) == false) goto L56;
        String r27 = getViewModel().getFocusUid();
        if (r27 == null) goto L56;
        r3 = r27;
        goto L56
    L41:
        r22 = "";
        goto L42
    L37:
        r6 = r21;
        goto L39
    L63:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r28 = getViewModel();
        String r29 = r18.b;
        String r30 = r18.d;
        r28.load(r29, r30, r18.g, !m(r30));
        return;
    L29:
        r19 = false;
        goto L30
    L18:
        r15 = null;
        goto L19
    L14:
        r12 = false;
    L10:
        r9 = r18.b;
    L66:
        if (TextUtils.isEmpty(r18.b) == true) goto L68;
        getWikiTreeViewFromXml().setSpaceId(r18.b);
        d(r18);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r31 = getViewModel();
        String r32 = r18.b;
        String r33 = r18.d;
        r31.load(r32, r33, r18.g, !m(r33));
    L68:
        e3 r110 = r18.c;
        if (r110 == null) goto L76;
        WikiTreeView r34 = getWikiTreeViewFromXml();
        int r35 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
        String r36 = r110.o();
        if (r36 == null) goto L74;
        r3 = r36;
    L74:
        r34.setSpaceId(r3);
        d(r18);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r111 = getViewModel();
        String r112 = r18.d;
        r111.load(r110, r112, r18.g, !m(r112), r18.h);
    L76:
        if (this.f != null) goto L78;
        d(r18);
    L78:
        WikiTreeView r37 = getWikiTreeViewFromXml();
        SpaceInfo r38 = getViewModel().getSpaceInfo();
        if (r38 == null) goto L81;
        r4 = r38.isMyLib();
    L81:
        r37.setMyLib(r4);
        WikiTreeView r39 = getWikiTreeViewFromXml();
        SpaceInfo r40 = getViewModel().getSpaceInfo();
        if (r40 == null) goto L84;
        r5 = Integer.valueOf(r40.space_type);
    L84:
        r39.setSpaceType(r5);
    }

    public final void l(View r8) {
        com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        qc5.a.h();
        String r0 = getViewModel().getRootUid();
        if (r0 == null) goto L12;
        d3 r1 = getWikiTreeViewFromXml().getWikiUIList();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "uid");
        int r2 = r1.d(r0);
        if (r2 == (-1)) goto L7;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r1.a, r2);
    L8:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r4 = r3;
        if (r4 == null) goto L13;
        e(r4, getCanCreate(), n(), true, r8);
        return;
    L13:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final boolean m(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        c r0 = this.g;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r0 = null;
    L8:
        if (TextUtils.equals(r2, r0.a) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void q(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        WikiEmptyView r1 = getWikiEmptyViewFromXml();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "result");
        if ((r6 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d) == false) goto L6;
        int r7 = 0;
    L28:
        r1.c(r7);
        return;
    L6:
        if ((r6 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == false) goto L9;
        r7 = 2;
        goto L28
    L9:
        if ((r6 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) == false) goto L31;
        if (r6.a != WikiAction.PUSH_DES) goto L13;
        int r8 = -3;
    L17:
        if (r8 != (-3)) goto L19;
        r7 = 9;
        goto L28
    L19:
        if (r8 != (-2)) goto L21;
        r7 = 1;
        goto L28
    L21:
        if (r8 == 920004002) goto L25;
        if (r8 == 920004004) goto L24;
        r7 = 3;
        goto L28
    L24:
        r7 = 99;
        goto L28
    L25:
        r7 = 5;
        goto L28
    L13:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r9 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) r6;
        if (tp5.b.d(r9.d) == false) goto L16;
        r8 = 920004004;
        goto L17
    L16:
        r8 = tp5.b.a(r9.d);
        goto L17
    L31:
        throw new NoWhenBranchMatchedException();
    }

    public final void setStickyHeadFromXml(WikItemRootView r1) {
        this.c = r1;
    }

    public final void setTreeUpdateListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m = r2;
    }

    public final void setUploadViewContainerFromXml(FrameLayout r1) {
        this.b = r1;
    }

    public final void setUploadViewVisible(boolean r4) {
        tt5.a.h(this.e, "setUploadViewVisible: " + r4);
        if (r4 == false) goto L7;
        pc5.i r5 = this.i;
        if (r5 == null) goto L11;
        r5.setVisibility(0);
        return;
    L11:
        return;
    L7:
        pc5.i r6 = this.i;
        if (r6 == null) goto L13;
        r6.setVisibility(8);
        return;
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.o = r1;
    }

    public final void setViewDelegate(d r1) {
        this.p = r1;
    }

    public final void setViewLifecycleOwner(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setViewModel(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setWikiEmptyViewFromXml(WikiEmptyView r1) {
        this.d = r1;
    }

    public final void setWikiTreeViewFromXml(WikiTreeView r1) {
        this.a = r1;
    }

    public static final void a(WikiTreeCtrlView r9, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r10) {
        c r0 = r9.g;
        String r1 = null;
        if (r0 == null) goto L18;
        if (r0.g == false) goto L18;
        if (yp5.c.i() == false) goto L18;
        WikiTreeView r2 = r9.getWikiTreeViewFromXml();
        SpaceInfo r3 = r9.getViewModel().getSpaceInfo();
        if (r3 == null) goto L11;
        Integer r4 = Integer.valueOf(r3.space_type);
    L12:
        r2.setSpaceType(r4);
        WikiTreeView r5 = r9.getWikiTreeViewFromXml();
        SpaceInfo r6 = r9.getViewModel().getSpaceInfo();
        if (r6 == null) goto L15;
        WikiHomePageV2 r7 = r6.homePageV2;
    L16:
        r5.u = r7;
        r5.h();
        goto L18
    L15:
        r7 = null;
        goto L16
    L11:
        r4 = null;
    L18:
        if (r10.d == null) goto L23;
        r9.getWikiTreeViewFromXml().k(r9.getViewModel().getFocusToken(), r9.getViewModel().getFocusUid());
        r9.getWikiTreeViewFromXml().setData(r10.d);
        b r8 = r9.m;
        if (r8 == null) goto L23;
        r8.onUpdate();
    L23:
        switch(e.a[r10.a.ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L28;
            case 6: goto L25;
            default: goto L85;
        };
    L25:
        WikiTreeView r11 = r9.getWikiTreeViewFromXml();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "ok");
        if (r11.h.c(r10.v) == false) goto L85;
        r11.e.notifyDataSetChanged();
        goto L85
    L28:
        SpaceInfo r12 = r9.getViewModel().getSpaceInfo();
        if (r12 == null) goto L31;
        WikiHomePageV2 r13 = r12.homePageV2;
    L32:
        c r14 = r9.g;
        if (r14 != null) goto L35;
    L44:
        WikiTreeView r15 = r9.getWikiTreeViewFromXml();
        String r16 = r10.j;
        TreeNode r17 = r9.getViewModel().getNode(r10.j);
        if (r17 == null) goto L47;
        String r18 = r17.title;
    L48:
        TreeNode r19 = r9.getViewModel().getNode(r10.j);
        if (r19 == null) goto L51;
        r1 = r19.iconInfo;
    L51:
        if (r16 != null) goto L53;
        r15.getClass();
        goto L85
    L53:
        if (r15.h.c(r16) == false) goto L85;
        d3 r20 = r15.h;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r16, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r16, WikiFolderPushPlugin.WIKI_TOKEN);
        List r21 = (List) ((LinkedHashMap) r20.d).get(r16);
        if (r21 == null) goto L68;
        Iterator r22 = r21.iterator();
    L58:
        if (r22.hasNext() == false) goto L68;
        int r23 = ((Number) r22.next()).intValue();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r24 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r20.a, r23);
        String r25 = "";
        if (r18 != null) goto L62;
        String r26 = "";
    L63:
        r24.e = r26;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r27 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r20.a, r23);
        if (r1 == null) goto L67;
        r25 = r1;
    L67:
        r27.v = r25;
        goto L58
    L62:
        r26 = r18;
    L68:
        r15.e.notifyDataSetChanged();
        goto L85
    L47:
        r18 = null;
        goto L48
    L35:
        if (r14.g == false) goto L44;
        if (yp5.c.i() == false) goto L44;
        if (r13 == null) goto L40;
        String r28 = r13.wikiToken;
    L42:
        if (Intrinsics.areEqual(r28, r10.j) == false) goto L44;
        WikiTreeView r29 = r9.getWikiTreeViewFromXml();
        r29.u = r13;
        r29.h();
        goto L44
    L40:
        r28 = null;
        goto L42
    L31:
        r13 = null;
        goto L32
    L73:
        r9.getWikiTreeViewFromXml().l(r10.g, r10.b);
        goto L85
    L74:
        SpaceInfo r30 = r9.getViewModel().getSpaceInfo();
        if (r30 == null) goto L79;
        String r31 = r30.space_id;
        if (r31 == null) goto L79;
        r9.getWikiTreeViewFromXml().setSpaceId(r31);
    L79:
        WikiTreeView r32 = r9.getWikiTreeViewFromXml();
        SpaceInfo r33 = r9.getViewModel().getSpaceInfo();
        if (r33 == null) goto L82;
        boolean r34 = r33.isMyLib();
    L83:
        r32.setMyLib(r34);
        r9.p();
        goto L85
    L82:
        r34 = false;
        goto L83
    L71:
        if (r10.s == false) goto L85;
        r9.getWikiTreeViewFromXml().j(r9.getViewModel().getFocusUid());
    L85:
        switch(e.a[r10.a.ordinal()]) {
            case 1: goto L115;
            case 2: goto L112;
            case 3: goto L109;
            case 4: goto L106;
            case 5: goto L142;
            case 6: goto L142;
            case 7: goto L103;
            case 8: goto L100;
            case 9: goto L97;
            case 10: goto L94;
            case 11: goto L91;
            case 12: goto L88;
            case 13: goto L87;
            default: goto L142;
        };
    L87:
        WikiDialogs r35 = r9.j;
        Context r36 = r9.getViewLifecycleOwner().getContext();
        Map<String, Integer> r37 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        int r38 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(r10.a);
        w0 r39 = new w0(r9, r10);
        r35.getClass();
        WikiDialogs.g(r36, r38, r39);
        gq5.d.c(r9.getSpaceId(), r10.m, r10.t, sbb.e.c(r10.u));
        return;
    L88:
        d r40 = r9.p;
        if (r40 == null) goto L123;
        r40.i(r10.n, r10.l, r10.p);
        return;
    L123:
        return;
    L91:
        d r41 = r9.p;
        if (r41 == null) goto L125;
        r41.j(r10.i);
        return;
    L125:
        return;
    L94:
        d r42 = r9.p;
        if (r42 == null) goto L127;
        r42.q(r10.r);
        return;
    L127:
        return;
    L97:
        d r43 = r9.p;
        if (r43 == null) goto L129;
        r43.b(r10.q);
        return;
    L129:
        return;
    L100:
        d r44 = r9.p;
        if (r44 == null) goto L131;
        r44.g(r10.n, r10.g, r10.o);
        return;
    L131:
        return;
    L103:
        d r45 = r9.p;
        if (r45 == null) goto L133;
        r45.n(r10.i);
        return;
    L133:
        return;
    L106:
        d r46 = r9.p;
        if (r46 == null) goto L135;
        r46.k(r10.n, r10.k, r10.p);
        return;
    L135:
        return;
    L109:
        d r47 = r9.p;
        if (r47 == null) goto L137;
        r47.h(r10.n, r10.k, r10.p);
        return;
    L137:
        return;
    L112:
        d r48 = r9.p;
        if (r48 == null) goto L139;
        r48.e(r10.g, r10.b);
        return;
    L139:
        return;
    L115:
        d r49 = r9.p;
        if (r49 == null) goto L141;
        r49.l();
        return;
    L141:
        return;
    }

    public final void k(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        if (yp5.c.a() == false) goto L7;
        sbb.e r0 = sbb.e.o;
    L8:
        int r1 = r0.b;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r2 = getViewModel();
        IOperationInsert.TreeNodeInsertParams r3 = new IOperationInsert.TreeNodeInsertParams();
        r3.parentToken = r4;
        r3.documentType = r1;
        r3.uid = r5;
        r3.title = "";
        r3.forceExpand = true;
        r3.offlineCreateEnable = false;
        r2.insert(r3);
        return;
    L7:
        r0 = sbb.e.g;
        goto L8
    }

    public final void o(int r10, int r11, Intent r12) {
        tt5.a.h(this.e, "onActivityResult. requestCode: " + r10 + ", resultCode: " + r11);
        TreeNode r2 = null;
        final Document r3 = null;
        TreeNode r4 = null;
        if (r11 == (-1)) goto L29;
        if (r11 != 1027) goto L7;
        if (r12 == null) goto L17;
        Integer r13 = Integer.valueOf(r12.getIntExtra("folder_type", sbb.e.f.b));
    L18:
        if (r12 == null) goto L21;
        String r14 = r12.getStringExtra("folder_url");
        if (r14 == null) goto L21;
    L22:
        if (r12 == null) goto L24;
        r3 = (Document) r12.getParcelableExtra("shortcut_info");
    L24:
        if (r13 == null) goto L26;
        int r15 = r13.intValue();
    L27:
        vc5.a.a(r15, false, r14, new WikiTreeCtrlView$onActivityResult$1(this, r3));
        return;
    L26:
        r15 = 0;
    L21:
        r14 = "";
        goto L22
    L17:
        r13 = null;
        goto L18
    L7:
        if (r11 != 1028) goto L64;
        if (r12 == null) goto L11;
        String r16 = r12.getStringExtra(ResourceData.KEY_URL);
    L13:
        if (TextUtils.isEmpty(r16) == true) goto L54;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r16);
        return;
    L54:
        return;
    L11:
        r16 = null;
        goto L13
    L64:
        return;
    L29:
        if (r10 != 1024) goto L31;
        String[] r17 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r12);
        if (r17 == null) goto L61;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r5 = getViewModel();
        if (this.f == null) goto L62;
        if (r5 == null) goto L63;
        String r6 = r17[0];
        r5.moveTo(r6, r17[1], r17[2], r5.isContainInParent(getFocusToken(), r6), getFocusToken(), MoveSource.FROM_OTHER.getValue());
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L31:
        if (r10 != 2025) goto L33;
        String[] r18 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r12);
        if (r18 == null) goto L59;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r19 = getViewModel();
        String r1 = r18[0];
        String r0 = r18[2];
        String r110 = r18[3];
        if (r12 == null) goto L46;
        r2 = (TreeNode) r12.getParcelableExtra("tree_node");
    L46:
        r19.shortcutTo(r1, r0, r110, r2);
        return;
    L59:
        return;
    L33:
        if (r10 != 2026) goto L65;
        String[] r111 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r12);
        if (r111 == null) goto L57;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r112 = getViewModel();
        String r7 = r111[0];
        String r8 = r111[2];
        String r113 = r111[3];
        if (r12 == null) goto L40;
        r4 = (TreeNode) r12.getParcelableExtra("tree_node");
    L40:
        r112.makeCopyTo(r7, r8, r113, r4);
        return;
    L57:
        return;
    }

    public WikiTreeCtrlView(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        this.e = "Wiki_WikiTreeCtrlView";
        this.j = new WikiDialogs();
        this.k = new CompositeDisposable();
        this.l = new AtomicBoolean(false);
        h();
    }

    public /* synthetic */ WikiTreeCtrlView(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3, 0);
    }

    public final void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19, boolean r20, boolean r21, boolean r22, View r23) {
        FragmentActivity r1 = getViewLifecycleOwner().getActivity();
        if (r1 == null) goto L11;
        String r3 = getSpaceId();
        String r4 = r19.b;
        Boolean r5 = Boolean.valueOf(r19.e());
        String r6 = r19.c;
        String r15 = sbb.e.c(r19.d);
        Boolean r16 = Boolean.valueOf(n());
        gq5.d.e r2 = new gq5.d.e(r3, r4, r5, r6, r15, r16);
        int r8 = gq5.d.a;
        Intrinsics.checkNotNullParameter(r2, "bean");
        JSONObject r7 = new JSONObject();
        gq5.d.a(r7, r3, r4, r5, r6, r15, null, r16, 32);
        gq5.e.c("ccm_wiki_tree_add_view", r7);
        if (com.bytedance.ee.bear.wikiv2.create.a.b().isEmpty() == false) goto L7;
        tt5.a.d(this.e, "skip wiki create panel because configured menu is empty");
        return;
    L7:
        WikiDialogs r9 = this.j;
        f r10 = new f(r19, this, r22, r21);
        Fragment r11 = getViewLifecycleOwner();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r19, "target");
        int r12 = WikiCreateSelectPanelDialog.m;
        WikiCreateSelectPanelDialog r13 = WikiCreateSelectPanelDialog.a.a(r1, r10, r19, r20, r23, r11);
        r9.e = r13;
        if (r13 == null) goto L13;
        r13.l = r19.b;
        return;
    L13:
        return;
    }

    public BaseMoreProvider f(TreeNode r9, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r10, WikNodePerm r11, c0 r12, ce5.a r13) {
        Intrinsics.checkNotNullParameter(r10, "node");
        Intrinsics.checkNotNullParameter(r11, "wikiPerm");
        if (r9 != null) goto L5;
        return null;
    L5:
        SpaceInfo r1 = getViewModel().getSpaceInfo();
        if (r1 != null) goto L8;
        return null;
    L8:
        SpaceInfo r5 = r1.clone();
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r10.n, 0)) == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        WikiTreeMoreProvider r0 = new WikiTreeMoreProvider(r9, r11, r5, r6, r13);
        r0.r = r12;
        return r0;
    L11:
        if (getViewModel().isCloudPinDocument(r9.wiki_token) == false) goto L13;
        r6 = true;
        goto L14
    }
}

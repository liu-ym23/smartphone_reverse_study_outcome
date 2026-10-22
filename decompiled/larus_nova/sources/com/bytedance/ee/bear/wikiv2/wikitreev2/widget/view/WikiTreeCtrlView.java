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
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 Â\u00012\u00020\u0001:\b¿\u0001À\u0001Á\u0001Â\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020K2\u0006\u0010M\u001a\u00020NJ\u0010\u0010P\u001a\u00020K2\u0006\u0010M\u001a\u00020NH\u0014J\u001e\u0010Q\u001a\u00020K2\b\u0010R\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#H\u0002J\b\u0010T\u001a\u00020KH\u0016J\u000e\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020WJ\u0010\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010\\\u001a\u00020K2\u0006\u0010]\u001a\u00020^H\u0002J\u0006\u0010_\u001a\u00020KJ\u0010\u0010`\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010a\u001a\u00020W2\b\u0010R\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u00020K2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020K2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020KH\u0014J\b\u0010l\u001a\u00020KH\u0002J\u0006\u0010m\u001a\u00020#J8\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u000e\u0010x\u001a\u00020K2\u0006\u0010R\u001a\u00020#J \u0010x\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0006\u0010y\u001a\u00020#2\b\u0010z\u001a\u0004\u0018\u00010#J\u0006\u0010{\u001a\u00020KJ$\u0010|\u001a\u00020K2\u0006\u0010}\u001a\u00020#2\b\u0010R\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010+J\u0006\u0010\u007f\u001a\u00020WJ\u0015\u0010\u0080\u0001\u001a\u00020K2\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001J\u0007\u0010\u0083\u0001\u001a\u00020KJ\u0018\u0010\u0084\u0001\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0007\u0010\u0085\u0001\u001a\u00020#J\u0018\u0010\u0086\u0001\u001a\u00020K2\u0006\u0010R\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020#J\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010q2\u0006\u0010R\u001a\u00020#J\u000f\u0010¡\u0001\u001a\u00020K2\u0006\u0010S\u001a\u00020#J\u0019\u0010¢\u0001\u001a\u00020K2\u0007\u0010\u0085\u0001\u001a\u00020#2\u0007\u0010£\u0001\u001a\u00020WJ\u0017\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\u0007\u0010\u0085\u0001\u001a\u00020#J\u0012\u0010¦\u0001\u001a\u00020K2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010#J\u0012\u0010§\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010©\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010ª\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u0012\u0010«\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J=\u0010¬\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020s2\t\b\u0002\u0010\u0099\u0001\u001a\u00020W2\u0007\u0010\u00ad\u0001\u001a\u00020W2\u0007\u0010\u0080\u0001\u001a\u00020W2\f\b\u0002\u0010®\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\u0013\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020#H\u0002J\u0012\u0010²\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020sH\u0002J\u000f\u0010³\u0001\u001a\u00020#2\u0006\u0010R\u001a\u00020#J%\u0010´\u0001\u001a\u00020K2\u0007\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020\u00072\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001J\u0007\u0010¹\u0001\u001a\u00020WJ\u0007\u0010º\u0001\u001a\u00020WJ\u0010\u0010»\u0001\u001a\u00020K2\u0007\u0010¼\u0001\u001a\u00020;J\t\u0010½\u0001\u001a\u00020KH\u0002J\t\u0010¾\u0001\u001a\u00020KH\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0015\u0010}\u001a\u0004\u0018\u00010#8F¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018F¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00018F¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0092\u0001\u001a\u00020#8F¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001R\u0016\u0010\u0094\u0001\u001a\u0004\u0018\u00010q8F¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0014\u0010\u0097\u0001\u001a\u00020#8F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0089\u0001R\u0014\u0010\u0099\u0001\u001a\u00020W8F¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0014\u0010\u009c\u0001\u001a\u00020W8F¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009b\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "wikiTreeViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "getWikiTreeViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "setWikiTreeViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;)V", "uploadViewContainerFromXml", "getUploadViewContainerFromXml", "()Landroid/widget/FrameLayout;", "setUploadViewContainerFromXml", "(Landroid/widget/FrameLayout;)V", "stickyHeadFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "getStickyHeadFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "setStickyHeadFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "TAG", "", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;", "setViewModel", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/IWikiTreeModel;)V", "viewConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewConfig;", "viewLifecycleOwner", "Landroidx/fragment/app/Fragment;", "getViewLifecycleOwner", "()Landroidx/fragment/app/Fragment;", "setViewLifecycleOwner", "(Landroidx/fragment/app/Fragment;)V", "uploadView", "Lcom/bytedance/ee/bear/list/common/header/DriveUploadView;", "wikiDialog", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "atomicInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onTreeUpdateListener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$OnTreeUpdateListener;", "itemMoreViewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiItemMoreViewDelegate;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewDelegate;)V", "inflateLayout", "", "initOnce", "initConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlViewInitConfig;", "init", "doInit", "initView", WikiFolderPushPlugin.WIKI_TOKEN, "uniqueUiId", "initEmptyView", "setUploadViewVisible", "visible", "", "updateEmptyView", "result", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Result;", "updateSidebarEmptyViewWithPush", "bindView", "viewLifeOwner", "Landroidx/lifecycle/LifecycleOwner;", "refresh", "reportOpenFinish", "isDisableToken", "doLoading", "loading", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Loading;", "doErr", "err", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Err;", "doOk", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE, "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Ok;", "scrollToCenterWhenInit", "bindListener", "getRootToken", "getMoreProvider", "Lcom/bytedance/ee/bear/more/protocol3/extension/BaseMoreProvider;", "wikiNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "node", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "wikiPerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "delegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs$ItemMoreViewDelegate;", "focusTo", "targetSpaceId", "visibleSpaceId", "focusRoot", "load", "spaceId", "config", "isSameTenant", "insertRoot", "view", "Landroid/view/View;", "insertRootDoc", "insertDoc", "uid", "rename", "newTitle", "getSpaceId", "()Ljava/lang/String;", "spaceInfo", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo;", "getSpaceInfo", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo;", "spaceUserPerm", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceUserPerm;", "getSpaceUserPerm", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceUserPerm;", "focusToken", "getFocusToken", "focusTreeNode", "getFocusTreeNode", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "focusUid", "getFocusUid", "canCreate", "getCanCreate", "()Z", "canShowAi", "getCanShowAi", "cloneWorkspace", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "getNode", "scrollToCenter", "setSwipeMenuOpen", "open", "findSwipeItemLocation", "", BitableAnalytic.LinkSceneClickType.EXPAND, "doExpand", PickerReporterConstants.KEY.TARGET, "doCollapse", "doExpandSpace", "doCollapseSpace", "doInsert", "offlineCreateEnable", "anchorView", "getFilePermissionResponse", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "operate", "doSwipeRequest", "getTitleFromToken", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "isMyLib", "isEmpty", "setTreeUpdateListener", "listener", "onClear", "onDetachedFromWindow", "ViewConfig", "ViewDelegate", "OnTreeUpdateListener", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeCtrlView extends FrameLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f242300q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WikiTreeView f242301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f242302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WikItemRootView f242303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WikiEmptyView f242304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f242305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b f242306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f242307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f242308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public pc5.i f242309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WikiDialogs f242310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f242311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f242312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f242313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c0 f242314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ce5.a f242315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f242316p;

    public static final class a {
        public static com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b a(ViewModelStoreOwner r100, ce5.a r101) {
            Intrinsics.checkNotNullParameter(r100, "dataLifeOwner");
            Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
            int r102 = qc5.a.f532475a;
            Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
            boolean r103 = r101.f23449d.isEnable("ccm.mobile.wiki_tree_optimization");
            tt5.a.h("SpaceFeatureGatingV2", "isWikiTreeOptimization()...enable = " + r103);
            if (r103 == false) goto L5;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r104 = WikiTreeModelV2.newInstance(r100, r101);
            Intrinsics.checkNotNull(r104);
            return r104;
        L5:
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r105 = WikiTreeModel.newInstance(r100, r101);
            Intrinsics.checkNotNull(r105);
            return r105;
        }
    }

    public interface b {
        void onUpdate();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f242318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f242319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f242320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f242321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f242322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f242323f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f242324g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f242325h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Function<TreeNode, Boolean> f242326i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> f242327j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<? extends Function<TreeNode, Boolean>> f242328k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<? extends Function<TreeNode, Boolean>> f242329l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> f242330m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f242331n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<? extends RecyclerView.ItemDecoration> f242332o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f242333p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f242334q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Integer f242335r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f242336s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public ar5.a f242337t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f242338u;

        public static final class a {
        }

        public static final class b implements Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean> {
            public b() {
            }

            @Override // io.reactivex.functions.Function
            public final Boolean apply(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100) {
                Intrinsics.checkNotNullParameter(r100, "t");
                return Boolean.FALSE;
            }
        }

        static {
        }

        public c() {
            this.f242318a = "";
            this.f242319b = true;
            this.f242330m = CollectionsKt.listOf(new b());
            this.f242333p = "";
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(Throwable r100) {
        }

        public void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "newToken");
            Intrinsics.checkNotNullParameter(r101, "uniqueUiId");
        }

        public void f(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r101, "uniqueUiId");
        }

        public void g(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "toToken");
            Intrinsics.checkNotNullParameter(r102, "toSpaceName");
        }

        public void h(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "movToken");
            Intrinsics.checkNotNullParameter(r102, "focusToken");
        }

        public void i(String r100, List<String> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "movTokenList");
            Intrinsics.checkNotNullParameter(r102, "focusToken");
        }

        public void j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "delParentToken");
        }

        public void k(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "movToken");
            Intrinsics.checkNotNullParameter(r102, "focusToken");
        }

        public void l() {
        }

        public void m(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "reloadType");
        }

        public void n(String r100) {
            Intrinsics.checkNotNullParameter(r100, "delParentToken");
        }

        public void o(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "toToken");
            Intrinsics.checkNotNullParameter(r102, "toSpaceName");
        }

        public void p() {
        }

        public void q(String r100) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        }

        public void r(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileExtra");
        }

        public void d(WikiHomePageV2 r100) {
            Intrinsics.checkNotNullParameter(r100, "homePage");
            tt5.a.h("Wiki_WikiTreePanelDialog", "onHomePageClick default call onItemClick");
            f(r100.wikiToken, "");
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f242339a = null;

        static {
            int[] r100 = new int[WikiAction.values().length];
            r100[WikiAction.INIT_LOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[WikiAction.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r100[WikiAction.MOV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r100[WikiAction.PUSH_MOV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r100[WikiAction.PUSH_UDE_NAME_ICON.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r100[WikiAction.PUSH_TOKEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[WikiAction.DEL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[WikiAction.MAKE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[WikiAction.FAVORITE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r100[WikiAction.UNFAVORITE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[WikiAction.PUSH_DEL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[WikiAction.PUSH_BATCH_MOV.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r100[WikiAction.SHORTCUT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            f242339a = r100;
        }
    }

    public static final class f implements WikiCreateSelectPanelDialog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiTreeCtrlView f242341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f242342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f242343d;

        @Override // com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog.b
        public final void a(int r210) {
            SelectIndex.Companion.getClass();
            SelectIndex r100 = SelectIndex.a.a(r210);
            int r101 = r100.getDocumentType();
            String r102 = gq5.d.j.a(r210);
            if (SelectIndex.a.a(r210).getDocumentType() != 12) goto L5;
            String r103 = "ccm_space_file_choose_view";
        L6:
            String r104 = r103;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = this.f242340a;
            c r106 = this.f242341b.f242307g;
            if (r106 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            r106 = null;
        L9:
            boolean r107 = r106.f242336s;
            String r108 = this.f242341b.getRootToken();
            boolean r109 = this.f242342c;
            Intrinsics.checkNotNullParameter(r105, "<this>");
            if (r107 == true) goto L13;
        L26:
            String r110 = "wiki_tree";
        L27:
            String r111 = r110;
            String r112 = sbb.e.c(r101);
            Boolean r113 = Boolean.valueOf(this.f242340a.d());
            String r114 = this.f242341b.getSpaceId();
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r115 = this.f242340a;
            String r116 = r115.f241914b;
            Boolean r117 = Boolean.valueOf(r115.e());
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r118 = this.f242340a;
            gq5.d.f r119 = new gq5.d.f(r102, r104, r111, r112, r113, r114, r116, r117, r118.f241915c, sbb.e.c(r118.f241916d), Boolean.valueOf(this.f242341b.n()));
            int r120 = gq5.d.f482186a;
            Intrinsics.checkNotNullParameter(r119, "bean");
            JSONObject r121 = new JSONObject();
            gq5.e.b(r121, "click", r119.f482231a);
            gq5.e.b(r121, PickerReporterConstants.KEY.TARGET, r119.f482232b);
            gq5.e.b(r121, "children_file_type", r119.f482234d);
            Boolean r122 = r119.f482235e;
            if (r122 == null) goto L30;
            String r123 = r122.toString();
        L31:
            gq5.e.b(r121, "is_favorites", r123);
            gq5.e.b(r121, "trigger_location", r119.f482233c);
            gq5.d.a(r121, r119.f482236f, r119.f482237g, r119.f482238h, r119.f482239i, r119.f482240j, null, r119.f482241k, 32);
            gq5.e.c("ccm_wiki_tree_add_click", r121);
            this.f242341b.getWikiTreeViewFromXml().n(this.f242340a.f241926n, false);
            if (r100 != SelectIndex.MEDIA) goto L49;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L38;
            PermissionResponse r124 = WikiTreeCtrlView.b(this.f242341b);
            r124.getCallback().a(this.f242341b.getContext(), r124);
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.d(r124) == false) goto L47;
            return;
        L47:
            ((com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6)).r0(this.f242340a.b(), "wiki", new Bundle(), -1);
            return;
        L38:
            gj5.b r125 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r126 = FileBizDomain.FileBizDomainCCM;
            gj5.c r127 = r125.g("CCM_FILE_UPLOAD", r126, 12, "");
            if (r127.f481503a == true) goto L47;
            FileAuthResultFrom r128 = r127.f481504b;
            if (r128 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L44;
            ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_UPLOAD", r126, 12, "");
            return;
        L44:
            if (r128 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L79;
            Toast.showText(this.f242341b.getContext(), R.string.CreationMobile_ECM_AdminDisableToast);
            return;
        L79:
            return;
        L49:
            if (r100 != SelectIndex.FILE) goto L66;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L55;
            PermissionResponse r129 = WikiTreeCtrlView.b(this.f242341b);
            r129.getCallback().a(this.f242341b.getContext(), r129);
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.d(r129) == false) goto L64;
            return;
        L64:
            ((com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6)).J0(this.f242340a.b(), "wiki", new Bundle(), -1);
            return;
        L55:
            gj5.b r130 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r131 = FileBizDomain.FileBizDomainCCM;
            gj5.c r132 = r130.g("CCM_FILE_UPLOAD", r131, 12, "");
            if (r132.f481503a == true) goto L64;
            FileAuthResultFrom r133 = r132.f481504b;
            if (r133 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L61;
            ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_UPLOAD", r131, 12, "");
            return;
        L61:
            if (r133 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L81;
            Toast.showText(this.f242341b.getContext(), R.string.CreationMobile_ECM_AdminDisableToast);
            return;
        L81:
            return;
        L66:
            if (r101 == 12) goto L84;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r134 = this.f242341b.getViewModel();
            IOperationInsert.TreeNodeInsertParams r135 = new IOperationInsert.TreeNodeInsertParams();
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r136 = this.f242340a;
            WikiTreeCtrlView r137 = this.f242341b;
            boolean r138 = this.f242343d;
            r135.parentToken = r136.f241914b;
            r135.documentType = r101;
            r135.uid = r136.f241926n;
            r135.title = "";
            if (r100 != SelectIndex.SURVEY) goto L74;
            r135.templateToken = com.bytedance.ee.bear.templates.a.b();
            HashMap r139 = new HashMap();
            r139.put("business_source", "space_form");
            r139.put("time_zone", zu5.b.c());
            r135.extInfo = new Gson().toJson(r139);     // Catch: Exception -> L72
        L72:
            e = move-exception;
            tt5.a.d(r137.f242305e, String.valueOf(e.getMessage()));
        L74:
            r135.forceExpand = true;
            r135.offlineCreateEnable = r138;
            r134.insert(r135);
            return;
        L84:
            return;
        L30:
            r123 = null;
            goto L31
        L13:
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r105.f241926n, 0)) == false) goto L16;
            r110 = "sidebar_pin_docs";
            goto L27
        L16:
            if (TextUtils.equals("wikiroot%title_root_share_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r105.f241926n, 0)) == false) goto L19;
            r110 = "sidebar_shared";
            goto L27
        L19:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r105.f241926n, 0), r108) == false) goto L24;
            if (r109 == false) goto L22;
            r110 = "sidebar_my_docs_tab";
            goto L27
        L22:
            r110 = "sidebar_my_docs_node";
            goto L27
        L24:
            if (TextUtils.equals("wikiroot%top_wiki_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r105.f241926n, 0)) == false) goto L26;
            r110 = "sidebar_pin_wiki";
            goto L27
        L5:
            r103 = "ccm_docs_page_view";
            goto L6
        }

        public f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, WikiTreeCtrlView r101, boolean r102, boolean r103) {
            this.f242340a = r100;
            this.f242341b = r101;
            this.f242342c = r102;
            this.f242343d = r103;
        }
    }

    static {
    }

    public WikiTreeCtrlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public WikiTreeCtrlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public WikiTreeCtrlView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    public void r(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    public final String getRootToken() {
        if (this.f242306f == null) goto L9;
        String r100 = getViewModel().getRootToken();
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    L9:
        return "";
    }

    public final WikItemRootView getStickyHeadFromXml() {
        KeyEvent.Callback r100 = this.f242303c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sticky_head);
        this.f242303c = (WikItemRootView) r100;
    L6:
        return (WikItemRootView) r100;
    }

    public final FrameLayout getUploadViewContainerFromXml() {
        KeyEvent.Callback r100 = this.f242302b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.upload_view_container);
        this.f242302b = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final Fragment getViewLifecycleOwner() {
        Fragment r100 = this.f242308h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewLifecycleOwner");
        return null;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b getViewModel() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r100 = this.f242306f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final WikiEmptyView getWikiEmptyViewFromXml() {
        KeyEvent.Callback r100 = this.f242304d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.wiki_empty_view);
        this.f242304d = (WikiEmptyView) r100;
    L6:
        return (WikiEmptyView) r100;
    }

    public final WikiTreeView getWikiTreeViewFromXml() {
        KeyEvent.Callback r100 = this.f242301a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.wiki_tree_view);
        this.f242301a = (WikiTreeView) r100;
    L6:
        return (WikiTreeView) r100;
    }

    public final e3 c() {
        return getViewModel().cloneWorkspace();
    }

    public final boolean getCanCreate() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r100 = getViewModel();
        if (r100 == null) goto L10;
        SpacePerm r101 = r100.getSpacePerm();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.canEditFirstLevel != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean getCanShowAi() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r100 = getViewModel();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.canShowAi() != true) goto L9;
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
        SpaceInfo r100 = getViewModel().getSpaceInfo();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.space_id;
    }

    public final SpaceInfo getSpaceInfo() {
        return getViewModel().getSpaceInfo();
    }

    public final SpaceUserPerm getSpaceUserPerm() {
        return getViewModel().getSpaceUserPerm();
    }

    public void h() {
        LayoutInflater.from(getContext()).inflate(R.layout.wiki_tree_ctrl_view, this);
    }

    public void j() {
        WikiEmptyView r100 = getWikiEmptyViewFromXml();
        WikiTreeView r101 = getWikiTreeViewFromXml();
        int r102 = WikiEmptyView.f242277j;
        r100.f242279g = r101;
        r100.f242280h = null;
    }

    public final boolean n() {
        SpaceInfo r100 = getViewModel().getSpaceInfo();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMyLib();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h(this.f242305e, "onClear. ");
        this.f242310j.c();
        this.f242311k.clear();
        c0 r100 = this.f242314n;
        if (r100 == null) goto L5;
        r100.f242425j.clear();
    L5:
        pc5.i r101 = this.f242309i;
        if (r101 == null) goto L8;
        r101.b();
    L8:
        this.f242309i = null;
    }

    public void p() {
        getWikiTreeViewFromXml().j(getViewModel().getFocusUid());
    }

    public final ce5.a getUserComponentAbility() {
        return this.f242315o;
    }

    public final d getViewDelegate() {
        return this.f242316p;
    }

    public static final PermissionResponse b(WikiTreeCtrlView r100) {
        r100.getClass();
        BaseEntity r101 = new BaseEntity("", sbb.e.f541301l, BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r101, "UPLOAD"), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "initConfig");
        tt5.a.h(this.f242305e, "doInit. ");
        setViewLifecycleOwner(r100.f242473a);
        ViewModelStoreOwner r101 = r100.f242478f;
        if (r101 != null) goto L5;
        r101 = r100.f242473a;
    L5:
        setViewModel(a.a(r101, r100.f242481i));
        this.f242307g = r100.f242477e;
        this.f242315o = r100.f242481i;
        String r102 = r100.f242476d;
        String r103 = r100.f242479g;
        StringBuilder r104 = new StringBuilder("Wiki_WikiTreeCtrlView@");
        c r105 = this.f242307g;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r105 = null;
    L8:
        r104.append(r105.f242333p);
        this.f242305e = r104.toString();
        WikiTreeView r106 = getWikiTreeViewFromXml();
        c r107 = this.f242307g;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r107 = null;
    L11:
        r106.setDisableToken(r107.f242318a);
        WikiTreeView r108 = getWikiTreeViewFromXml();
        c r109 = this.f242307g;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r109 = null;
    L14:
        r108.setEnableRootCheckers(r109.f242330m);
        WikiTreeView r110 = getWikiTreeViewFromXml();
        c r111 = this.f242307g;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r111 = null;
    L17:
        r110.setEnableSwipeMenu(r111.f242320c);
        WikiTreeView r112 = getWikiTreeViewFromXml();
        c r113 = this.f242307g;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r113 = null;
    L20:
        r112.setItemDecorations(r113.f242332o);
        WikiTreeView r114 = getWikiTreeViewFromXml();
        c r115 = this.f242307g;
        if (r115 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r115 = null;
    L23:
        r114.setSource(r115.f242334q);
        getWikiTreeViewFromXml().setFragment(getViewLifecycleOwner());
        getWikiTreeViewFromXml().setUserComponentAbility(this.f242315o);
        c r116 = this.f242307g;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r116 = null;
    L27:
        if (r116.f242338u == true) goto L36;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r117 = getViewModel();
        c r118 = this.f242307g;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r118 = null;
    L32:
        if (r118.f242325h == true) goto L35;
        r102 = "";
    L35:
        r117.setFocus(r102, r103);
    L36:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r119 = getViewModel();
        c r120 = this.f242307g;
        if (r120 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r120 = null;
    L39:
        r119.setFavoriteEnable(r120.f242319b);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r121 = getViewModel();
        c r122 = this.f242307g;
        if (r122 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r122 = null;
    L42:
        r121.setChainPushEnable(r122.f242322e);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r123 = getViewModel();
        c r124 = this.f242307g;
        if (r124 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r124 = null;
    L45:
        r123.setLocalPushEnable(r124.f242323f);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r125 = getViewModel();
        c r126 = this.f242307g;
        if (r126 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r126 = null;
    L48:
        r125.setDataFilter(r126.f242326i);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r127 = getViewModel();
        c r128 = this.f242307g;
        if (r128 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r128 = null;
    L51:
        r127.setSingleNodeFilters(r128.f242327j);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r129 = getViewModel();
        c r130 = this.f242307g;
        if (r130 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r130 = null;
    L54:
        r129.setEnableCheckers(r130.f242328k);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r131 = getViewModel();
        c r132 = this.f242307g;
        if (r132 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r132 = null;
    L57:
        r131.setEnableSwipeCheckers(r132.f242329l);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r133 = getViewModel();
        c r134 = this.f242307g;
        if (r134 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r134 = null;
    L60:
        r133.setTagSuffix(r134.f242333p);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r135 = getViewModel();
        c r136 = this.f242307g;
        if (r136 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r136 = null;
    L63:
        r135.setDisableLocalPushFocusToken(r136.f242331n);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r137 = getViewModel();
        c r138 = this.f242307g;
        if (r138 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r138 = null;
    L66:
        r137.setViewConfig(r138);
        j();
        c r139 = this.f242307g;
        if (r139 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r139 = null;
    L70:
        if (r139.f242321d == false) goto L77;
        pc5.i r140 = new pc5.i(getContext());
        this.f242309i = r140;
        r140.setViewDelegate(new d1(this));
        pc5.i r141 = this.f242309i;
        if (r141 == null) goto L82;
        String r142 = getSpaceId();
        if (r142 != null) goto L76;
        r142 = "none";
    L76:
        r141.a("all_files_token", "workspace", r142);
    L82:
        if (qc5.a.h() == false) goto L86;
        WikItemRootView r143 = getStickyHeadFromXml();
        if (r143 == null) goto L86;
        r143.setOnAddClickListener(new e1(this));
    L86:
        getViewModel().getWikiUIList().observe(r100.f242473a.getViewLifecycleOwner(), new WikiTreeCtrlView$bindView$1(this));
        getWikiTreeViewFromXml().setListener(new v0(this));
        tt5.a.h(this.f242305e, "doInit, init finish, viewModel@" + getViewModel().hashCode());
        return;
    L77:
        pc5.i r144 = this.f242309i;
        if (r144 == null) goto L80;
        r144.setViewDelegate(null);
    L80:
        this.f242309i = null;
        goto L82
    }

    public final TreeNode g(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        return getViewModel().getNode(r100);
    }

    public final void i(f1 r110) {
        Intrinsics.checkNotNullParameter(r110, "initConfig");
        String r100 = "";
        boolean r101 = false;
        Integer r102 = null;
        c r103 = null;
        if (yp5.c.h() == false) goto L66;
        if (r110.f242477e.f242338u == false) goto L66;
        d(r110);
        ar5.a r104 = r110.f242477e.f242337t;
        WikiTreeView r105 = getWikiTreeViewFromXml();
        SpaceInfo r106 = getViewModel().getSpaceInfo();
        if (r106 == null) goto L10;
        String r107 = r106.space_id;
        if (r107 == null) goto L10;
    L11:
        r105.setSpaceId(r107);
        WikiTreeView r108 = getWikiTreeViewFromXml();
        SpaceInfo r109 = getViewModel().getSpaceInfo();
        if (r109 == null) goto L14;
        boolean r111 = r109.isMyLib();
    L15:
        r108.setMyLib(r111);
        WikiTreeView r112 = getWikiTreeViewFromXml();
        SpaceInfo r113 = getViewModel().getSpaceInfo();
        if (r113 == null) goto L18;
        Integer r114 = Integer.valueOf(r113.space_type);
    L19:
        r112.setSpaceType(r114);
        if (getViewModel().getNode(r110.f242476d) == null) goto L29;
        if (r104 == null) goto L28;
        SpaceInfo r115 = getViewModel().getSpaceInfo();
        if (r115 == null) goto L25;
        String r116 = r115.space_id;
    L27:
        if (TextUtils.equals(r116, r104.f16013a) == false) goto L29;
    L25:
        r116 = null;
    L28:
        boolean r117 = true;
    L30:
        if (r117 == false) goto L63;
        c r118 = this.f242307g;
        if (r118 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r118 = null;
    L34:
        r118.f242337t = null;
        c r119 = this.f242307g;
        if (r119 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L39:
        if (r103.f242325h == false) goto L41;
        String r120 = r110.f242476d;
    L42:
        String r121 = r110.f242479g;
        if (r121 != null) goto L46;
        r121 = "";
    L46:
        if (r121.length() <= 0) goto L48;
        r101 = true;
    L48:
        if (r101 == false) goto L51;
        r100 = r121;
    L56:
        getViewModel().setFocus(r120, r100);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r122 = getViewModel();
        SpaceInfo r123 = getViewModel().getSpaceInfo();
        if (r123 == null) goto L60;
        String r124 = r123.space_id;
        if (r124 == null) goto L60;
    L61:
        String r125 = r110.f242476d;
        r122.load(r124, r125, r100, !m(r125));
        return;
    L60:
        r124 = r110.f242474b;
        goto L61
    L51:
        if (TextUtils.equals(getViewModel().getFocusToken(), r120) == false) goto L56;
        String r126 = getViewModel().getFocusUid();
        if (r126 == null) goto L56;
        r100 = r126;
        goto L56
    L41:
        r120 = "";
        goto L42
    L37:
        r103 = r119;
        goto L39
    L63:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r127 = getViewModel();
        String r128 = r110.f242474b;
        String r129 = r110.f242476d;
        r127.load(r128, r129, r110.f242479g, !m(r129));
        return;
    L29:
        r117 = false;
        goto L30
    L18:
        r114 = null;
        goto L19
    L14:
        r111 = false;
    L10:
        r107 = r110.f242474b;
    L66:
        if (TextUtils.isEmpty(r110.f242474b) == true) goto L68;
        getWikiTreeViewFromXml().setSpaceId(r110.f242474b);
        d(r110);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r130 = getViewModel();
        String r131 = r110.f242474b;
        String r132 = r110.f242476d;
        r130.load(r131, r132, r110.f242479g, !m(r132));
    L68:
        e3 r133 = r110.f242475c;
        if (r133 == null) goto L76;
        WikiTreeView r134 = getWikiTreeViewFromXml();
        int r135 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.f241908a;
        String r136 = r133.o();
        if (r136 == null) goto L74;
        r100 = r136;
    L74:
        r134.setSpaceId(r100);
        d(r110);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r137 = getViewModel();
        String r138 = r110.f242476d;
        r137.load(r133, r138, r110.f242479g, !m(r138), r110.f242480h);
    L76:
        if (this.f242306f != null) goto L78;
        d(r110);
    L78:
        WikiTreeView r139 = getWikiTreeViewFromXml();
        SpaceInfo r140 = getViewModel().getSpaceInfo();
        if (r140 == null) goto L81;
        r101 = r140.isMyLib();
    L81:
        r139.setMyLib(r101);
        WikiTreeView r141 = getWikiTreeViewFromXml();
        SpaceInfo r142 = getViewModel().getSpaceInfo();
        if (r142 == null) goto L84;
        r102 = Integer.valueOf(r142.space_type);
    L84:
        r141.setSpaceType(r102);
    }

    public final void l(View r100) {
        com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState();
        qc5.a.h();
        String r101 = getViewModel().getRootUid();
        if (r101 == null) goto L12;
        d3 r102 = getWikiTreeViewFromXml().getWikiUIList();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        int r103 = r102.d(r101);
        if (r103 == (-1)) goto L7;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r104 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r102.f241799a, r103);
    L8:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = r104;
        if (r105 == null) goto L13;
        e(r105, getCanCreate(), n(), true, r100);
        return;
    L13:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final boolean m(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        c r101 = this.f242307g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r101 = null;
    L8:
        if (TextUtils.equals(r100, r101.f242318a) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void q(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        WikiEmptyView r101 = getWikiEmptyViewFromXml();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "result");
        if ((r100 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d) == false) goto L6;
        int r102 = 0;
    L28:
        r101.c(r102);
        return;
    L6:
        if ((r100 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == false) goto L9;
        r102 = 2;
        goto L28
    L9:
        if ((r100 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) == false) goto L31;
        if (r100.f241902a != WikiAction.PUSH_DES) goto L13;
        int r103 = -3;
    L17:
        if (r103 != (-3)) goto L19;
        r102 = 9;
        goto L28
    L19:
        if (r103 != (-2)) goto L21;
        r102 = 1;
        goto L28
    L21:
        if (r103 == 920004002) goto L25;
        if (r103 == 920004004) goto L24;
        r102 = 3;
        goto L28
    L24:
        r102 = 99;
        goto L28
    L25:
        r102 = 5;
        goto L28
    L13:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r104 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) r100;
        if (tp5.b.d(r104.f241753d) == false) goto L16;
        r103 = 920004004;
        goto L17
    L16:
        r103 = tp5.b.a(r104.f241753d);
        goto L17
    L31:
        throw new NoWhenBranchMatchedException();
    }

    public final void setStickyHeadFromXml(WikItemRootView r100) {
        this.f242303c = r100;
    }

    public final void setTreeUpdateListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f242313m = r100;
    }

    public final void setUploadViewContainerFromXml(FrameLayout r100) {
        this.f242302b = r100;
    }

    public final void setUploadViewVisible(boolean r100) {
        tt5.a.h(this.f242305e, "setUploadViewVisible: " + r100);
        if (r100 == false) goto L7;
        pc5.i r101 = this.f242309i;
        if (r101 == null) goto L11;
        r101.setVisibility(0);
        return;
    L11:
        return;
    L7:
        pc5.i r102 = this.f242309i;
        if (r102 == null) goto L13;
        r102.setVisibility(8);
        return;
    }

    public final void setUserComponentAbility(ce5.a r100) {
        this.f242315o = r100;
    }

    public final void setViewDelegate(d r100) {
        this.f242316p = r100;
    }

    public final void setViewLifecycleOwner(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242308h = r100;
    }

    public final void setViewModel(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242306f = r100;
    }

    public final void setWikiEmptyViewFromXml(WikiEmptyView r100) {
        this.f242304d = r100;
    }

    public final void setWikiTreeViewFromXml(WikiTreeView r100) {
        this.f242301a = r100;
    }

    public static final void a(WikiTreeCtrlView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r110) {
        c r101 = r100.f242307g;
        String r102 = null;
        if (r101 == null) goto L18;
        if (r101.f242324g == false) goto L18;
        if (yp5.c.i() == false) goto L18;
        WikiTreeView r103 = r100.getWikiTreeViewFromXml();
        SpaceInfo r104 = r100.getViewModel().getSpaceInfo();
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf(r104.space_type);
    L12:
        r103.setSpaceType(r105);
        WikiTreeView r106 = r100.getWikiTreeViewFromXml();
        SpaceInfo r107 = r100.getViewModel().getSpaceInfo();
        if (r107 == null) goto L15;
        WikiHomePageV2 r108 = r107.homePageV2;
    L16:
        r106.f242374u = r108;
        r106.h();
        goto L18
    L15:
        r108 = null;
        goto L16
    L11:
        r105 = null;
    L18:
        if (r110.f241873d == null) goto L23;
        r100.getWikiTreeViewFromXml().k(r100.getViewModel().getFocusToken(), r100.getViewModel().getFocusUid());
        r100.getWikiTreeViewFromXml().setData(r110.f241873d);
        b r109 = r100.f242313m;
        if (r109 == null) goto L23;
        r109.onUpdate();
    L23:
        switch(e.f242339a[r110.f241902a.ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L28;
            case 6: goto L25;
            default: goto L85;
        };
    L25:
        WikiTreeView r111 = r100.getWikiTreeViewFromXml();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        if (r111.f242361h.c(r110.f241891v) == false) goto L85;
        r111.f242358e.notifyDataSetChanged();
        goto L85
    L28:
        SpaceInfo r112 = r100.getViewModel().getSpaceInfo();
        if (r112 == null) goto L31;
        WikiHomePageV2 r113 = r112.homePageV2;
    L32:
        c r114 = r100.f242307g;
        if (r114 != null) goto L35;
    L44:
        WikiTreeView r115 = r100.getWikiTreeViewFromXml();
        String r116 = r110.f241879j;
        TreeNode r117 = r100.getViewModel().getNode(r110.f241879j);
        if (r117 == null) goto L47;
        String r118 = r117.title;
    L48:
        TreeNode r119 = r100.getViewModel().getNode(r110.f241879j);
        if (r119 == null) goto L51;
        r102 = r119.iconInfo;
    L51:
        if (r116 != null) goto L53;
        r115.getClass();
        goto L85
    L53:
        if (r115.f242361h.c(r116) == false) goto L85;
        d3 r120 = r115.f242361h;
        r120.getClass();
        Intrinsics.checkNotNullParameter(r116, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r116, WikiFolderPushPlugin.WIKI_TOKEN);
        List r121 = (List) ((LinkedHashMap) r120.f241802d).get(r116);
        if (r121 == null) goto L68;
        Iterator r122 = r121.iterator();
    L58:
        if (r122.hasNext() == false) goto L68;
        int r123 = ((Number) r122.next()).intValue();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r124 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r120.f241799a, r123);
        String r125 = "";
        if (r118 != null) goto L62;
        String r126 = "";
    L63:
        r124.f241917e = r126;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r127 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(r120.f241799a, r123);
        if (r102 == null) goto L67;
        r125 = r102;
    L67:
        r127.f241934v = r125;
        goto L58
    L62:
        r126 = r118;
    L68:
        r115.f242358e.notifyDataSetChanged();
        goto L85
    L47:
        r118 = null;
        goto L48
    L35:
        if (r114.f242324g == false) goto L44;
        if (yp5.c.i() == false) goto L44;
        if (r113 == null) goto L40;
        String r128 = r113.wikiToken;
    L42:
        if (Intrinsics.areEqual(r128, r110.f241879j) == false) goto L44;
        WikiTreeView r129 = r100.getWikiTreeViewFromXml();
        r129.f242374u = r113;
        r129.h();
        goto L44
    L40:
        r128 = null;
        goto L42
    L31:
        r113 = null;
        goto L32
    L73:
        r100.getWikiTreeViewFromXml().l(r110.f241876g, r110.f241903b);
        goto L85
    L74:
        SpaceInfo r130 = r100.getViewModel().getSpaceInfo();
        if (r130 == null) goto L79;
        String r131 = r130.space_id;
        if (r131 == null) goto L79;
        r100.getWikiTreeViewFromXml().setSpaceId(r131);
    L79:
        WikiTreeView r132 = r100.getWikiTreeViewFromXml();
        SpaceInfo r133 = r100.getViewModel().getSpaceInfo();
        if (r133 == null) goto L82;
        boolean r134 = r133.isMyLib();
    L83:
        r132.setMyLib(r134);
        r100.p();
        goto L85
    L82:
        r134 = false;
        goto L83
    L71:
        if (r110.f241888s == false) goto L85;
        r100.getWikiTreeViewFromXml().j(r100.getViewModel().getFocusUid());
    L85:
        switch(e.f242339a[r110.f241902a.ordinal()]) {
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
        WikiDialogs r135 = r100.f242310j;
        Context r136 = r100.getViewLifecycleOwner().getContext();
        Map<String, Integer> r137 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f242003a;
        int r138 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(r110.f241902a);
        w0 r139 = new w0(r100, r110);
        r135.getClass();
        WikiDialogs.g(r136, r138, r139);
        gq5.d.c(r100.getSpaceId(), r110.f241882m, r110.f241889t, sbb.e.c(r110.f241890u));
        return;
    L88:
        d r140 = r100.f242316p;
        if (r140 == null) goto L123;
        r140.i(r110.f241883n, r110.f241881l, r110.f241885p);
        return;
    L123:
        return;
    L91:
        d r141 = r100.f242316p;
        if (r141 == null) goto L125;
        r141.j(r110.f241878i);
        return;
    L125:
        return;
    L94:
        d r142 = r100.f242316p;
        if (r142 == null) goto L127;
        r142.q(r110.f241887r);
        return;
    L127:
        return;
    L97:
        d r143 = r100.f242316p;
        if (r143 == null) goto L129;
        r143.b(r110.f241886q);
        return;
    L129:
        return;
    L100:
        d r144 = r100.f242316p;
        if (r144 == null) goto L131;
        r144.g(r110.f241883n, r110.f241876g, r110.f241884o);
        return;
    L131:
        return;
    L103:
        d r145 = r100.f242316p;
        if (r145 == null) goto L133;
        r145.n(r110.f241878i);
        return;
    L133:
        return;
    L106:
        d r146 = r100.f242316p;
        if (r146 == null) goto L135;
        r146.k(r110.f241883n, r110.f241880k, r110.f241885p);
        return;
    L135:
        return;
    L109:
        d r147 = r100.f242316p;
        if (r147 == null) goto L137;
        r147.h(r110.f241883n, r110.f241880k, r110.f241885p);
        return;
    L137:
        return;
    L112:
        d r148 = r100.f242316p;
        if (r148 == null) goto L139;
        r148.e(r110.f241876g, r110.f241903b);
        return;
    L139:
        return;
    L115:
        d r149 = r100.f242316p;
        if (r149 == null) goto L141;
        r149.l();
        return;
    L141:
        return;
    }

    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r101, "uid");
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        if (yp5.c.a() == false) goto L7;
        sbb.e r102 = sbb.e.f541304o;
    L8:
        int r103 = r102.f541317b;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r104 = getViewModel();
        IOperationInsert.TreeNodeInsertParams r105 = new IOperationInsert.TreeNodeInsertParams();
        r105.parentToken = r100;
        r105.documentType = r103;
        r105.uid = r101;
        r105.title = "";
        r105.forceExpand = true;
        r105.offlineCreateEnable = false;
        r104.insert(r105);
        return;
    L7:
        r102 = sbb.e.f541296g;
        goto L8
    }

    public final void o(int r110, int r111, Intent r112) {
        tt5.a.h(this.f242305e, "onActivityResult. requestCode: " + r110 + ", resultCode: " + r111);
        TreeNode r100 = null;
        final Document r101 = null;
        TreeNode r102 = null;
        if (r111 == (-1)) goto L29;
        if (r111 != 1027) goto L7;
        if (r112 == null) goto L17;
        Integer r113 = Integer.valueOf(r112.getIntExtra("folder_type", sbb.e.f541295f.f541317b));
    L18:
        if (r112 == null) goto L21;
        String r114 = r112.getStringExtra("folder_url");
        if (r114 == null) goto L21;
    L22:
        if (r112 == null) goto L24;
        r101 = (Document) r112.getParcelableExtra("shortcut_info");
    L24:
        if (r113 == null) goto L26;
        int r115 = r113.intValue();
    L27:
        vc5.a.a(r115, false, r114, new WikiTreeCtrlView$onActivityResult$1(this, r101));
        return;
    L26:
        r115 = 0;
    L21:
        r114 = "";
        goto L22
    L17:
        r113 = null;
        goto L18
    L7:
        if (r111 != 1028) goto L64;
        if (r112 == null) goto L11;
        String r116 = r112.getStringExtra("url");
    L13:
        if (TextUtils.isEmpty(r116) == true) goto L54;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r116);
        return;
    L54:
        return;
    L11:
        r116 = null;
        goto L13
    L64:
        return;
    L29:
        if (r110 != 1024) goto L31;
        String[] r117 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r112);
        if (r117 == null) goto L61;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r103 = getViewModel();
        if (this.f242306f == null) goto L62;
        if (r103 == null) goto L63;
        String r104 = r117[0];
        r103.moveTo(r104, r117[1], r117[2], r103.isContainInParent(getFocusToken(), r104), getFocusToken(), MoveSource.FROM_OTHER.getValue());
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L31:
        if (r110 != 2025) goto L33;
        String[] r118 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r112);
        if (r118 == null) goto L59;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r119 = getViewModel();
        String r105 = r118[0];
        String r106 = r118[2];
        String r120 = r118[3];
        if (r112 == null) goto L46;
        r100 = (TreeNode) r112.getParcelableExtra("tree_node");
    L46:
        r119.shortcutTo(r105, r106, r120, r100);
        return;
    L59:
        return;
    L33:
        if (r110 != 2026) goto L65;
        String[] r121 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r112);
        if (r121 == null) goto L57;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r122 = getViewModel();
        String r107 = r121[0];
        String r108 = r121[2];
        String r123 = r121[3];
        if (r112 == null) goto L40;
        r102 = (TreeNode) r112.getParcelableExtra("tree_node");
    L40:
        r122.makeCopyTo(r107, r108, r123, r102);
        return;
    L57:
        return;
    }

    public WikiTreeCtrlView(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        this.f242305e = "Wiki_WikiTreeCtrlView";
        this.f242310j = new WikiDialogs();
        this.f242311k = new CompositeDisposable();
        this.f242312l = new AtomicBoolean(false);
        h();
    }

    public /* synthetic */ WikiTreeCtrlView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, 0);
    }

    public final void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r110, boolean r210, boolean r211, boolean r212, View r213) {
        FragmentActivity r100 = getViewLifecycleOwner().getActivity();
        if (r100 == null) goto L11;
        String r101 = getSpaceId();
        String r102 = r110.f241914b;
        Boolean r103 = Boolean.valueOf(r110.e());
        String r104 = r110.f241915c;
        String r111 = sbb.e.c(r110.f241916d);
        Boolean r112 = Boolean.valueOf(n());
        gq5.d.e r105 = new gq5.d.e(r101, r102, r103, r104, r111, r112);
        int r106 = gq5.d.f482186a;
        Intrinsics.checkNotNullParameter(r105, "bean");
        JSONObject r107 = new JSONObject();
        gq5.d.a(r107, r101, r102, r103, r104, r111, null, r112, 32);
        gq5.e.c("ccm_wiki_tree_add_view", r107);
        if (com.bytedance.ee.bear.wikiv2.create.a.b().isEmpty() == false) goto L7;
        tt5.a.d(this.f242305e, "skip wiki create panel because configured menu is empty");
        return;
    L7:
        WikiDialogs r108 = this.f242310j;
        f r109 = new f(r110, this, r212, r211);
        Fragment r113 = getViewLifecycleOwner();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        int r114 = WikiCreateSelectPanelDialog.f240666m;
        WikiCreateSelectPanelDialog r115 = WikiCreateSelectPanelDialog.a.a(r100, r109, r110, r210, r213, r113);
        r108.f242254e = r115;
        if (r115 == null) goto L13;
        r115.f240670l = r110.f241914b;
        return;
    L13:
        return;
    }

    public BaseMoreProvider f(TreeNode r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r110, WikNodePerm r111, c0 r112, ce5.a r113) {
        Intrinsics.checkNotNullParameter(r110, "node");
        Intrinsics.checkNotNullParameter(r111, "wikiPerm");
        if (r100 != null) goto L5;
        return null;
    L5:
        SpaceInfo r101 = getViewModel().getSpaceInfo();
        if (r101 != null) goto L8;
        return null;
    L8:
        SpaceInfo r102 = r101.clone();
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r110.f241926n, 0)) == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        WikiTreeMoreProvider r104 = new WikiTreeMoreProvider(r100, r111, r102, r103, r113);
        r104.f242350r = r112;
        return r104;
    L11:
        if (getViewModel().isCloudPinDocument(r100.wiki_token) == false) goto L13;
        r103 = true;
        goto L14
    }
}

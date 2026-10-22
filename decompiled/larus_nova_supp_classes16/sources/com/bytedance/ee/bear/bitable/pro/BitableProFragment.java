package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.bitable.pro.accessconfig.BitableDefaultMemberAdapter;
import com.bytedance.ee.bear.bitable.pro.accessconfig.BitableDefaultRoleFragment;
import com.bytedance.ee.bear.bitable.pro.accessconfig.BitableMemberItemDecoration;
import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import com.bytedance.ee.bear.bitable.pro.member.BitableRoleMemberManagerFragment;
import com.bytedance.ee.bear.bitable.pro.roledetail.BitableProRoleDetailFragment;
import com.bytedance.ee.bear.bitable.pro.roledetail.BitableProRoleDetailFragmentV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ½\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002½\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010Q\u001a\u00020RH\u0002J\u0012\u0010v\u001a\u00020R2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J&\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\u001b\u0010\u007f\u001a\u00020R2\u0007\u0010\u0080\u0001\u001a\u00020z2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\t\u0010\u0081\u0001\u001a\u00020RH\u0002J\t\u0010\u0082\u0001\u001a\u00020RH\u0002J\t\u0010\u0083\u0001\u001a\u00020RH\u0002J\t\u0010\u0084\u0001\u001a\u00020RH\u0002J\u0007\u0010\u0085\u0001\u001a\u00020RJ\t\u0010\u0086\u0001\u001a\u00020RH\u0002J\t\u0010\u0087\u0001\u001a\u00020RH\u0002J\t\u0010\u0088\u0001\u001a\u00020iH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020R2\u0007\u0010\u008a\u0001\u001a\u00020iH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020R2\u0007\u0010\u008a\u0001\u001a\u00020iH\u0002J\t\u0010\u008c\u0001\u001a\u00020RH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020R2\u0007\u0010\u008e\u0001\u001a\u00020iH\u0002J\t\u0010\u008f\u0001\u001a\u00020RH\u0002J\t\u0010\u0090\u0001\u001a\u00020RH\u0002J#\u0010\u0091\u0001\u001a\u00020R2\n\b\u0001\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u0095\u0001J!\u0010\u0096\u0001\u001a\u00020R2\n\b\u0001\u0010\u0092\u0001\u001a\u00030\u0093\u00012\n\b\u0001\u0010\u0097\u0001\u001a\u00030\u0093\u0001H\u0002JA\u0010\u0098\u0001\u001a\u00020R2&\u0010\u0099\u0001\u001a!\u0012\u0016\u0012\u00140i¢\u0006\u000f\b\u009b\u0001\u0012\n\b\u009c\u0001\u0012\u0005\b\b(\u009d\u0001\u0012\u0004\u0012\u00020R0\u009a\u00012\u000e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u0095\u0001H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020R2\u0007\u0010 \u0001\u001a\u00020iH\u0002J)\u0010¡\u0001\u001a\u00020R2\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u0095\u00012\u000e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u0095\u0001H\u0002J\t\u0010£\u0001\u001a\u00020RH\u0002J\t\u0010¤\u0001\u001a\u00020RH\u0002J\t\u0010¥\u0001\u001a\u00020RH\u0016J\u0013\u0010¦\u0001\u001a\u00020R2\b\u0010§\u0001\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010¨\u0001\u001a\u00020R2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00020R2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\u0013\u0010¬\u0001\u001a\u00020R2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J1\u0010\u00ad\u0001\u001a\u00020R2\u0007\u0010®\u0001\u001a\u00020i2\u001d\u0010¯\u0001\u001a\u0018\u0012\u0005\u0012\u00030°\u0001\u0018\u00010Wj\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u0001`YH\u0002J\t\u0010±\u0001\u001a\u00020RH\u0002J'\u0010²\u0001\u001a\u00020R2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030\u0093\u00012\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010¹\u0001\u001a\u00020RH\u0002J\t\u0010º\u0001\u001a\u00020iH\u0016J\t\u0010»\u0001\u001a\u00020RH\u0016J\u0007\u0010¼\u0001\u001a\u00020RR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u0004\u0018\u00010(8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010(8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001e\u00100\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001e\u00103\u001a\u0004\u0018\u00010\u001c8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001e\u00106\u001a\u0004\u0018\u0001078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010=8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010C8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u0004\u0018\u0001078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00109\"\u0004\bJ\u0010;R\u001e\u0010K\u001a\u0004\u0018\u0001078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00109\"\u0004\bM\u0010;R\u001e\u0010N\u001a\u0004\u0018\u00010=8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010?\"\u0004\bP\u0010AR\u000e\u0010S\u001a\u00020TX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010V\u001a\u0016\u0012\u0004\u0012\u00020X\u0018\u00010Wj\n\u0012\u0004\u0012\u00020X\u0018\u0001`YX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Z\u001a\u0016\u0012\u0004\u0012\u00020X\u0018\u00010Wj\n\u0012\u0004\u0012\u00020X\u0018\u0001`YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bb\u0010cR\u000e\u0010f\u001a\u00020gX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProFragment;", "Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "Lcom/bytedance/ee/bear/bitable/pro/IBitableProPageTrigger;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/MemberChangeListener;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "operateRoleAndPermissionFromXml", "Landroid/widget/LinearLayout;", "getOperateRoleAndPermissionFromXml", "()Landroid/widget/LinearLayout;", "setOperateRoleAndPermissionFromXml", "(Landroid/widget/LinearLayout;)V", "emptyLayoutFromXml", "getEmptyLayoutFromXml", "setEmptyLayoutFromXml", "noRolesTipsFromXml", "Landroidx/cardview/widget/CardView;", "getNoRolesTipsFromXml", "()Landroidx/cardview/widget/CardView;", "setNoRolesTipsFromXml", "(Landroidx/cardview/widget/CardView;)V", "permissionUpdateNoticeFromXml", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "getPermissionUpdateNoticeFromXml", "()Lcom/larksuite/component/universe_design/notice/UDNotice;", "setPermissionUpdateNoticeFromXml", "(Lcom/larksuite/component/universe_design/notice/UDNotice;)V", "accessConfigLoadingFromXml", "Landroid/widget/RelativeLayout;", "getAccessConfigLoadingFromXml", "()Landroid/widget/RelativeLayout;", "setAccessConfigLoadingFromXml", "(Landroid/widget/RelativeLayout;)V", "accessConfigRoleFromXml", "getAccessConfigRoleFromXml", "setAccessConfigRoleFromXml", "defaultMemberRecyclerViewFromXml", "getDefaultMemberRecyclerViewFromXml", "setDefaultMemberRecyclerViewFromXml", "accessConfigFromXml", "getAccessConfigFromXml", "setAccessConfigFromXml", "accessConfigNameFromXml", "Landroid/widget/TextView;", "getAccessConfigNameFromXml", "()Landroid/widget/TextView;", "setAccessConfigNameFromXml", "(Landroid/widget/TextView;)V", "loadingIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getLoadingIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setLoadingIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "operateRolesFromXml", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getOperateRolesFromXml", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "setOperateRolesFromXml", "(Lcom/larksuite/component/universe_design/udswitch/UDSwitch;)V", "rolesTitleFromXml", "getRolesTitleFromXml", "setRolesTitleFromXml", "operateRoleAndPermissionTipsFromXml", "getOperateRoleAndPermissionTipsFromXml", "setOperateRoleAndPermissionTipsFromXml", "selectAccessConfigFromXml", "getSelectAccessConfigFromXml", "setSelectAccessConfigFromXml", "clearFromXmlViewCache", "", "TAG", "", "token", "tableList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/BlockSimpleInfo;", "Lkotlin/collections/ArrayList;", "blockList", "ownerId", "adapter", "Lcom/bytedance/ee/bear/bitable/pro/BitableProAdapter;", "proInfo", "Lcom/bytedance/ee/bear/document/bitable/BitableProInfo;", "loadingDialog", "Lcom/bytedance/ee/bear/widgets/LoadingDialog;", "getLoadingDialog", "()Lcom/bytedance/ee/bear/widgets/LoadingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel;", "needRemoveALLMembers", "", "isRemoteComputeUpgradeFg", "openDefaultRole", "defaultMemberAdapter", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultMemberAdapter;", "mTouchMonitor", "Lcom/bytedance/ee/bear/facade/common/TouchMonitor;", "mTouchStartIntercept", "Lcom/bytedance/ee/bear/facade/common/TouchStartIntercept;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "enableRoleInheritance", "needUpdateALLRoles", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTouchMonitor", "initUpdateNotice", "initAccessConfig", "setSysRoleUI", "startLoading", "initOperatePerm", "clickUpdatePro", "hasMember", "openProLoading", "isOpen", "notifyWebUpgradePro", "observeIsPro", "updateAccessConfigView", "enable", "observeUpgradeProSuccess", "removeAllMembers", "showReTry", "stringId", "", "onClick", "Lkotlin/Function0;", "showToast", "drawableId", "showOpenPermissionDialog", "open", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isKeep", "cancel", "updateOpenPermission", "isChecked", "showClosePermissionDialog", TipCallBackData.CONFIRM, "showChooseDefaultConfigDialog", "emptyPermissionGroupView", "onDestroyView", "onMemberChange", DocRedirectToDocxPlugin.FROM, "triggerToRoleDetail", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "triggerToInviteMember", "triggerToMemberManager", "showProUpdateFragment", "showUpdate", "formulaInfo", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "showDefaultRoleFragment", "addFragment", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerViewId", "fragment", "Landroidx/fragment/app/Fragment;", "getStatusBarColorRes", "parseArguments", "onBackPressed", "onDestroy", "back", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProFragment extends BaseBitableProFragment implements i0, com.bytedance.ee.bear.middleground_permission_export.model.i {
    public static final /* synthetic */ int N = 0;
    public BitableProAdapter A;
    public com.bytedance.ee.bear.document.bitable.c B;
    public final Lazy C;
    public BitableProViewModel D;
    public boolean E;
    public final boolean F;
    public boolean G;
    public BitableDefaultMemberAdapter H;
    public sa5.v I;
    public k J;
    public UDLoadingDrawable K;
    public final boolean L;
    public boolean M;
    public BaseTitleBar f;
    public RecyclerView g;
    public LinearLayout h;
    public LinearLayout i;
    public CardView j;
    public UDNotice k;
    public RelativeLayout l;
    public RelativeLayout m;
    public RecyclerView n;
    public CardView o;
    public TextView p;
    public AppCompatImageView q;
    public UDSwitch r;
    public TextView s;
    public TextView t;
    public AppCompatImageView u;
    public final String v;
    public String w;
    public ArrayList<BlockSimpleInfo> x;
    public ArrayList<BlockSimpleInfo> y;
    public String z;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ BitableProFragment c;

        public b(BitableProFragment r1) {
            this.c = r1;
        }

        public final void a(View r16) {
            BitableProFragment r17 = this.c;
            BitableProViewModel r0 = r17.D;
            com.bytedance.ee.bear.document.bitable.c r2 = null;
            BitableProViewModel r3 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            Boolean r1 = (Boolean) r0.getIsPro().getValue();
            BitableProViewModel r4 = r17.D;
            if (r4 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r4 = null;
        L8:
            DefaultAccessConfig r5 = (DefaultAccessConfig) r4.getDefaultAccessConfigLiveData().getValue();
            if (r5 == null) goto L11;
            Boolean r6 = Boolean.valueOf(r5.isSystemRole());
        L13:
            if (r17.L == false) goto L93;
            com.bytedance.ee.bear.document.bitable.c r7 = r17.B;
            if (r7 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r7 = null;
        L18:
            if (r7.a == true) goto L93;
            Boolean r8 = Boolean.TRUE;
            if (Intrinsics.areEqual(r1, r8) == false) goto L93;
            if (Intrinsics.areEqual(r6, r8) == true) goto L93;
            BitableProViewModel r9 = r17.D;
            if (r9 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r9 = null;
        L27:
            DefaultAccessConfig r10 = (DefaultAccessConfig) r9.getDefaultAccessConfig().getValue();
            if (r10 == null) goto L30;
            DefaultConfig r11 = r10.getDefaultConfig();
        L31:
            BitableProViewModel r12 = r17.D;
            if (r12 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r12 = null;
        L35:
            if (r12.getSelectRole() == null) goto L64;
            BitableProViewModel r13 = r17.D;
            if (r13 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r13 = null;
        L39:
            BitableProViewModel r14 = r17.D;
            if (r14 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r14 = null;
        L42:
            Role r18 = r14.getSelectRole();
            String r19 = "";
            if (r18 == null) goto L48;
            String r20 = r18.getRoleId();
            if (r20 == null) goto L48;
            String r21 = r20;
        L49:
            r13.updateDefaultConfig(new DefaultConfig(1, r21, false, 4, null), new f(r17));
            r17.T90(2130772293);
            int r22 = com.bytedance.ee.bear.bitable.pro.d.a;
            com.bytedance.ee.bear.document.bitable.c r23 = r17.B;
            if (r23 != null) goto L52;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r23 = null;
        L52:
            Boolean r24 = Boolean.valueOf(r23.a);
            BitableProViewModel r110 = r17.D;
            if (r110 != null) goto L55;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L56:
            Role r111 = r3.getSelectRole();
            if (r111 == null) goto L62;
            String r112 = r111.getRoleId();
            if (r112 == null) goto L62;
            r19 = r112;
        L62:
            com.bytedance.ee.bear.bitable.pro.d.e(r24, r19, r8);
            return;
        L55:
            r3 = r110;
        L48:
            r21 = "";
            goto L49
        L64:
            if (r11 != null) goto L66;
        L68:
            boolean r26 = false;
        L69:
            if (r26 == false) goto L85;
            r17.T90(2130772293);
            if (r11.getAccessStrategy() != 1) goto L76;
            Role r27 = r11.getBindRole();
            if (r27 == null) goto L78;
            String r28 = r27.getRoleId();
        L80:
            int r29 = com.bytedance.ee.bear.bitable.pro.d.a;
            com.bytedance.ee.bear.document.bitable.c r113 = r17.B;
            if (r113 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        L84:
            com.bytedance.ee.bear.bitable.pro.d.e(Boolean.valueOf(r2.a), r28, r8);
            return;
        L83:
            r2 = r113;
        L78:
            r28 = null;
            goto L80
        L76:
            if (r11.getAccessStrategy() != 0) goto L79;
            r8 = Boolean.FALSE;
            goto L78
        L79:
            r28 = null;
            r8 = null;
            goto L80
        L85:
            Context r30 = r17.getContext();
            if (r30 != null) goto L88;
            tt5.a.d(r17.v, "context is null");
        L89:
            int r31 = com.bytedance.ee.bear.bitable.pro.d.a;
            com.bytedance.ee.bear.document.bitable.c r114 = r17.B;
            if (r114 != null) goto L92;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r114 = null;
        L92:
            com.bytedance.ee.bear.bitable.pro.d.e(Boolean.valueOf(r114.a), null, null);
            return;
        L88:
            new UDDialogBuilder(r30).title(2131886214).titleSize(17).message(2131886222).messageTextSize(16).addActionButton(2131391777, 2131886195, new r(r17)).cancelOnTouchOutside(true).show();
            goto L89
        L66:
            if (r11.isValid() != true) goto L68;
            r26 = true;
            goto L69
        L30:
            r11 = null;
        L93:
            r17.T90(2130772293);
            int r32 = com.bytedance.ee.bear.bitable.pro.d.a;
            com.bytedance.ee.bear.document.bitable.c r115 = r17.B;
            if (r115 != null) goto L96;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r115 = null;
        L96:
            com.bytedance.ee.bear.bitable.pro.d.e(Boolean.valueOf(r115.a), null, null);
            return;
        L11:
            r6 = null;
            goto L13
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BitableProFragment a;

        public c(BitableProFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            ArrayList r7 = (ArrayList) r6;
            if (r7 != null) goto L5;
            BitableProFragment.V90(this.a);
        L32:
            BitableProFragment r8 = this.a;
            int r0 = BitableProFragment.N;
            ((com.bytedance.ee.bear.widgets.q) r8.C.getValue()).a();
            return;
        L5:
            if (r7.size() != 0) goto L7;
            BitableProFragment.V90(this.a);
            goto L32
        L7:
            BitableProFragment r1 = this.a;
            View r2 = r1.h;
            BitableProAdapter r3 = null;
            if (r2 != null) goto L14;
            View r4 = r1.getView();
            if (r4 == null) goto L12;
            r2 = r4.findViewById(2131381553);
        L13:
            r1.h = (LinearLayout) r2;
            goto L14
        L12:
            r2 = null;
        L14:
            ((LinearLayout) r2).setVisibility(0);
            this.a.ha0().setVisibility(0);
            BitableProFragment r5 = this.a;
            View r9 = r5.i;
            if (r9 != null) goto L21;
            View r10 = r5.getView();
            if (r10 == null) goto L19;
            r9 = r10.findViewById(2131371559);
        L20:
            r5.i = (LinearLayout) r9;
            goto L21
        L19:
            r9 = null;
        L21:
            ((LinearLayout) r9).setVisibility(8);
            BitableProAdapter r11 = this.a.A;
            if (r11 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L25:
            r3.setNewData(r7);
            if (r7.size() == 1) goto L28;
        L30:
            this.a.fa0().setVisibility(8);
            goto L32
        L28:
            if (((Role) ListProtector.get(r7, 0)).isFaType() == false) goto L30;
            this.a.fa0().setVisibility(0);
            goto L32
        L24:
            r3 = r11;
            goto L25
        }
    }

    public static final class d implements UDToast.b {
        public final /* synthetic */ Function0<Unit> a;

        public d(Function0<Unit> r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r2) {
            Intrinsics.checkNotNullParameter(r2, "toast");
            r2.cancel();
            this.a.invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final int U90() {
        return 2131100545;
    }

    public final CardView aa0() {
        View r0 = this.o;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131361966);
    L8:
        this.o = (CardView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CardView) r0;
    }

    public final RelativeLayout ba0() {
        View r0 = this.l;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131361967);
    L8:
        this.l = (RelativeLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RelativeLayout) r0;
    }

    public final TextView ca0() {
        View r0 = this.p;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131361968);
    L8:
        this.p = (TextView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (TextView) r0;
    }

    public final RelativeLayout da0() {
        View r0 = this.m;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131361969);
    L8:
        this.m = (RelativeLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RelativeLayout) r0;
    }

    public final RecyclerView ea0() {
        View r0 = this.n;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368738);
    L8:
        this.n = (RecyclerView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RecyclerView) r0;
    }

    public final CardView fa0() {
        View r0 = this.j;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131380961);
    L8:
        this.j = (CardView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CardView) r0;
    }

    public final UDSwitch ga0() {
        View r0 = this.r;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131381555);
    L8:
        this.r = (UDSwitch) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (UDSwitch) r0;
    }

    public final RecyclerView ha0() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131384071);
    L8:
        this.g = (RecyclerView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RecyclerView) r0;
    }

    public final void sB() {
        BitableProViewModel r0 = this.D;
        BitableProViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.fetchProData();
        sk5.c r1 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        if (this.F == false) goto L24;
        BitableProViewModel r3 = this.D;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L11:
        if (r3.getUpdateStatus().getValue() != PermissionUpdateStatus.Updated) goto L25;
        if (r1 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L26;
        BitableProViewModel r5 = this.D;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r2.fetchUpdateEffectData();
        return;
    L21:
        r2 = r5;
        goto L22
    L26:
        return;
    L14:
        if (r1.f("bitable_permission_upgrade_ssc") == true) goto L16;
        r4 = true;
        goto L17
    L25:
        return;
    }

    public BitableProFragment() {
        this.v = "BitableProFragment";
        this.w = "";
        this.z = "";
        this.C = LazyKt.lazy(new BitableProFragment$loadingDialog$2(this));
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.F = r0.h("bitable.mobile.remote_compute.upgrade");
        int r1 = e.a;
        this.L = r0.h("base.advanced_permission.role_inheritance");
    }

    public final void ka0() {
        com.bytedance.ee.bear.bitable.m.z(aa0(), true);
        TextView r0 = ca0();
        r0.setText(2131886150);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131106610));
        com.bytedance.ee.bear.bitable.m.z(ea0(), false);
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        super.onBackPressed();
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        BitableProViewModel r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.updateLandscape(false);
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final void onDestroyView() {
        super.onDestroyView();
        BitableProViewModel r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.clearUpgradePro();
        Toast.cancelLoading();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) jg5.j.b).remove(this);
        k r1 = this.J;
        if (r1 == null) goto L10;
        sa5.v r2 = this.I;
        if (r2 == null) goto L10;
        r2.b(r1);
    L10:
        UDLoadingDrawable r3 = this.K;
        if (r3 == null) goto L13;
        r3.stop();
    L13:
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public static final void V90(BitableProFragment r3) {
        View r0 = r3.h;
        View r1 = null;
        if (r0 != null) goto L9;
        View r2 = r3.getView();
        if (r2 == null) goto L7;
        r0 = r2.findViewById(2131381553);
    L8:
        r3.h = (LinearLayout) r0;
        goto L9
    L7:
        r0 = null;
    L9:
        ((LinearLayout) r0).setVisibility(8);
        r3.ha0().setVisibility(8);
        r3.fa0().setVisibility(8);
        r3.aa0().setVisibility(8);
        View r4 = r3.i;
        if (r4 != null) goto L15;
        View r5 = r3.getView();
        if (r5 == null) goto L14;
        r1 = r5.findViewById(2131371559);
    L14:
        r3.i = (LinearLayout) r1;
        r4 = r1;
    L15:
        ((LinearLayout) r4).setVisibility(0);
    }

    public static final void W90(BitableProFragment r6) {
        BitableProViewModel r0 = r6.D;
        BitableProViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        DefaultAccessConfig r2 = (DefaultAccessConfig) r0.getDefaultAccessConfig().getValue();
        if (r2 == null) goto L12;
        DefaultConfig r3 = r2.getDefaultConfig();
        if (r3 == null) goto L12;
        if (r3.getAccessStrategy() != 0) goto L12;
        boolean r4 = true;
    L13:
        BitableProViewModel r5 = r6.D;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        ArrayList r7 = (ArrayList) r1.getRoleListLiveData().getValue();
        if (r7 == null) goto L27;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        if ((!((Role) r10).isFaType()) == false) goto L21;
        r8.add(r10);
        goto L21
    L25:
        ArrayList r11 = (ArrayList) CollectionsKt.toCollection(r8, new ArrayList());
        if (r11 == null) goto L27;
    L28:
        int r12 = BitableDefaultRoleFragment.N;
        Intrinsics.checkNotNullParameter(r11, "roleList");
        Bundle r13 = new Bundle();
        r13.putBoolean("select_disable_strategy", r4);
        r13.putSerializable("role_list", r11);
        PluginHost.writePluginHostToBundle(r6, r13);
        BitableDefaultRoleFragment r14 = r6.getChildFragmentManager().getFragmentFactory().instantiate(r6.requireContext().getClassLoader(), BitableDefaultRoleFragment.class.getName());
        r14.setArguments(r13);
        BitableDefaultRoleFragment r16 = r14;
        FragmentManager r17 = r6.getChildFragmentManager();
        String r18 = BitableDefaultRoleFragment.class.getName();
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, r18, r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r16, r19) == true) goto L42;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L32:
        r16.show(r17, r18);
        return;
    L42:
        return;
    L27:
        r11 = new ArrayList();
        goto L28
    L16:
        r1 = r5;
    L12:
        r4 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.pro.i0
    public final void HB(Role r6) {
        Intrinsics.checkNotNullParameter(r6, "role");
        if (getContext() == null) goto L6;
        int r1 = BitableRoleMemberManagerFragment.s;
        String r2 = this.w;
        String r3 = this.z;
        ArrayList<BlockSimpleInfo> r4 = this.x;
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        Intrinsics.checkNotNullParameter(r6, "role");
        Bundle r0 = new Bundle();
        r0.putString("extra_token", r2);
        r0.putString("extra_owner_id", r3);
        r0.putSerializable("extra_table_list", r4);
        r0.putSerializable("extra_role", r6);
        BitableRoleMemberManagerFragment r7 = new BitableRoleMemberManagerFragment();
        r7.setArguments(r0);
        Z90(getChildFragmentManager(), r7);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.i0
    public final void I00(Role r11) {
        Intrinsics.checkNotNullParameter(r11, "role");
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L16;
        BitableProViewModel r1 = null;
        cj5.c r0 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        String r3 = this.w;
        String r4 = r11.getRoleId();
        String r5 = this.z;
        BitableProViewModel r6 = this.D;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L7:
        String r7 = r6.getCreateTenantId();
        BitableProViewModel r8 = this.D;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L10:
        boolean r9 = r8.isTemplate();
        ArrayList<UserInfo> r12 = r11.getMembers();
        BitableProViewModel r10 = this.D;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r0.O0(r2, r3, r4, r5, r7, r9, r12, r1.getWikiUsers());
        return;
    L13:
        r1 = r10;
        goto L14
    }

    public final void ia0(boolean r8) {
        BitableProViewModel r1 = null;
        if (r8 == true) goto L5;
    L41:
        String r2 = null;
    L42:
        BitableProViewModel r3 = this.D;
        if (r3 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        BitableProViewModel.c r0 = r1.getDelegate();
        if (r0 == null) goto L50;
        ((BitableProPlugin.a) r0).a.sendProUpgrade(r8, r2);
        return;
    L50:
        return;
    L45:
        r1 = r3;
        goto L46
    L5:
        if (this.L == false) goto L41;
        BitableProViewModel r4 = this.D;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L9:
        ArrayList r5 = (ArrayList) r4.getRoleListLiveData().getValue();
        boolean r6 = false;
        if (r5 != null) goto L12;
    L22:
        this.M = true;
        Context r7 = getContext();
        if (r7 != null) goto L24;
    L21:
        r2 = null;
    L25:
        BitableProViewModel r9 = this.D;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r9 = null;
    L28:
        DefaultAccessConfig r10 = (DefaultAccessConfig) r9.getDefaultAccessConfigLiveData().getValue();
        if (r10 != null) goto L31;
    L33:
        if (r6 == false) goto L35;
        ka0();
        goto L42
    L35:
        int r11 = e.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.aggressive_default_policy") == false) goto L42;
        BitableProViewModel r12 = this.D;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L40:
        r12.setSelectRoleName(r2);
        goto L42
    L31:
        if (r10.isSystemRole() != true) goto L33;
        r6 = true;
        goto L33
    L24:
        r2 = r7.getString(2131886221);
        goto L25
    L12:
        if (r5.isEmpty() == true) goto L22;
        if (r5.size() != 1) goto L21;
        if (((Role) ListProtector.get(r5, 0)).isFaType() == false) goto L21;
        this.M = true;
        Context r13 = getContext();
        if (r13 == null) goto L21;
        r2 = r13.getString(2131886221);
        goto L25
    }

    public final void ja0(boolean r2) {
        ia0(r2);
        Context r0 = getContext();
        if (r0 != null) goto L6;
        tt5.a.d(this.v, "open pro loading context is null");
        return;
    L6:
        if (r2 == false) goto L8;
        Toast.showLoading(r0, r0.getString(2131886098));
        return;
    L8:
        Toast.showLoading(r0, r0.getString(2131886102));
    }

    public final void ma0(boolean r5) {
        if (this.L == false) goto L22;
        Context r0 = getContext();
        if (r0 == null) goto L23;
        TextView r1 = ca0();
        Resources r2 = r0.getResources();
        int r3 = 2131106610;
        if (r5 == false) goto L9;
        int r4 = 2131106607;
    L10:
        r1.setTextColor(r2.getColor(r4));
        View r6 = this.u;
        if (r6 != null) goto L17;
        View r7 = getView();
        if (r7 == null) goto L15;
        r6 = r7.findViewById(2131385775);
    L16:
        this.u = (AppCompatImageView) r6;
        goto L17
    L15:
        r6 = null;
    L17:
        AppCompatImageView r8 = (AppCompatImageView) r6;
        if (r5 == false) goto L20;
        r3 = 2131102420;
    L20:
        com.bytedance.ee.util.ui.l.c(r8, r3);
        return;
    L9:
        r4 = 2131106610;
        goto L10
    L23:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = "";
        if (r4 == null) goto L6;
        String r5 = r4.getString("extra_token");
        if (r5 == null) goto L6;
    L7:
        this.w = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L13;
        String r7 = r6.getString("extra_owner_id");
        if (r7 == null) goto L13;
        r0 = r7;
    L13:
        this.z = r0;
        Bundle r8 = getArguments();
        BitableProViewModel r1 = null;
        if (r8 == null) goto L16;
        Serializable r9 = r8.getSerializable("extra_table_list");
    L17:
        this.x = (ArrayList) r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L20;
        Serializable r11 = r10.getSerializable("extra_block_list");
    L21:
        this.y = (ArrayList) r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L24;
        boolean r13 = r12.getBoolean("extra_open_default_role");
    L25:
        this.G = r13;
        BitableProViewModel r14 = (BitableProViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, BitableProViewModel.class);
        this.D = r14;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        this.B = r1.getProInfo();
        this.A = new BitableProAdapter(this);
        this.H = new BitableDefaultMemberAdapter(CollectionsKt.emptyList());
        this.I = (sa5.v) sa5.m.a.a(getActivity(), sa5.v.class);
        return;
    L28:
        r1 = r14;
        goto L29
    L24:
        r13 = false;
        goto L25
    L20:
        r11 = null;
        goto L21
    L16:
        r9 = null;
    L6:
        r5 = "";
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.pro.i0
    public final void pJ(Role r4) {
        Intrinsics.checkNotNullParameter(r4, "role");
        if (getContext() == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "role");
        Bundle r0 = new Bundle();
        r0.putSerializable("extra_role", r4);
        int r1 = com.bytedance.ee.bear.bitable.c.a;
        int r2 = com.bytedance.ee.bear.bitable.n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile_advance_new_permission.enable") == false) goto L7;
        BitableProRoleDetailFragmentV2 r3 = new BitableProRoleDetailFragmentV2();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.f = r4;
        BaseBitableProFragment r5 = r3;
    L8:
        r5.setArguments(r0);
        Z90(getChildFragmentManager(), r5);
        return;
    L7:
        r5 = new BitableProRoleDetailFragment();
        goto L8
    }

    public static void Z90(FragmentManager r4, BaseBitableProFragment r5) {
        FragmentTransaction r6 = r4.beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131364221) == true) goto L6;
        r6 = r6.add(2131364221, r5);
    L6:
        r6.commitAllowingStateLoss();
    }

    public final void la0(int r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onClick");
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        tt5.a.d(this.v, "activity is null");
        return;
    L6:
        UDToast.a r1 = UDToast.build(r0);
        r1.b.e(r3);
        r1.d(2131255144);
        r1.b(2131886356, new d(r4));
        r1.h();
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        View r9 = this.f;
        com.bytedance.ee.bear.document.bitable.c r10 = null;
        if (r9 != null) goto L9;
        View r11 = getView();
        if (r11 == null) goto L7;
        r9 = r11.findViewById(2131388775);
    L8:
        this.f = (BaseTitleBar) r9;
        goto L9
    L7:
        r9 = null;
    L9:
        ((BaseTitleBar) r9).setLeftClickListener(new b(this));
        if (this.F == false) goto L31;
        BitableProViewModel r12 = this.D;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L14:
        r12.fetchUpdateStatus();
        BitableProViewModel r13 = this.D;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L17:
        r13.getUpdateStatus().observe(getViewLifecycleOwner(), new l(this));
        BitableProViewModel r14 = this.D;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r14 = null;
    L20:
        r14.getEffectData().observe(getViewLifecycleOwner(), new m(this));
        View r16 = this.k;
        if (r16 != null) goto L27;
        View r17 = getView();
        if (r17 == null) goto L25;
        r16 = r17.findViewById(2131382179);
    L26:
        this.k = (UDNotice) r16;
        goto L27
    L25:
        r16 = null;
    L27:
        ((UDNotice) r16).setTextButtonListener(new n(this));
        BitableProViewModel r18 = this.D;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L30:
        r18.setActionPanelListener(new o(this));
    L31:
        com.bytedance.ee.bear.document.bitable.c r19 = this.B;
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r19 = null;
    L35:
        if (r19.a == false) goto L37;
        ga0().setVisibility(8);
    L64:
        RecyclerView r20 = ha0();
        RecyclerView.Adapter r3 = this.A;
        if (r3 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L67:
        r20.setAdapter(r3);
        ha0().setLayoutManager(new LinearLayoutManagerWrapper(requireContext()));
        BitableProViewModel r21 = this.D;
        if (r21 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r21 = null;
    L70:
        r21.fetchProData();
        ((com.bytedance.ee.bear.widgets.q) this.C.getValue()).d();
        BitableProViewModel r22 = this.D;
        if (r22 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r22 = null;
    L73:
        r22.getRoleListLiveData().observe(getViewLifecycleOwner(), new c(this));
        if (this.L == false) goto L97;
        com.bytedance.ee.bear.document.bitable.c r23 = this.B;
        if (r23 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r23 = null;
    L79:
        if (r23.a == false) goto L81;
        ma0(false);
    L88:
        int r24 = (com.bytedance.ee.util.ui.n.w(getContext()) - y9c.d.a(64)) / y9c.d.a(40);
        RecyclerView r4 = ea0();
        RecyclerView.Adapter r5 = this.H;
        if (r5 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("defaultMemberAdapter");
        r5 = null;
    L91:
        r4.setAdapter(r5);
        ea0().addItemDecoration(new BitableMemberItemDecoration(r24));
        ea0().setLayoutManager(new LinearLayoutManagerWrapper(requireContext(), 0));
        BitableProViewModel r2 = this.D;
        if (r2 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L94:
        r2.getDefaultAccessConfig().observe(getViewLifecycleOwner(), new h(this, r24));
        da0().setOnClickListener(new i(this));
        k r26 = new k(this);
        this.J = r26;
        sa5.v r0 = this.I;
        if (r0 == null) goto L97;
        r0.c(r26);
        goto L97
    L81:
        com.bytedance.ee.bear.document.bitable.c r27 = this.B;
        if (r27 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r27 = null;
    L84:
        ma0(r27.b);
        BitableProViewModel r28 = this.D;
        if (r28 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r28 = null;
    L87:
        r28.setSelectStrategyListener(new g(this));
    L97:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        int r29 = com.bytedance.ee.bear.bitable.pro.d.a;
        com.bytedance.ee.bear.document.bitable.c r30 = this.B;
        if (r30 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
    L101:
        Boolean r31 = Boolean.valueOf(r10.a);
        JSONObject r32 = new JSONObject();
        if (r31 == null) goto L104;
        r32.put("is_template", r31.toString());
    L104:
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_setting_view", r32);
        return;
    L100:
        r10 = r30;
        goto L101
    L37:
        ga0().setVisibility(0);
        View r33 = this.s;
        if (r33 != null) goto L44;
        View r34 = getView();
        if (r34 == null) goto L42;
        r33 = r34.findViewById(2131384746);
    L43:
        this.s = (TextView) r33;
        goto L44
    L42:
        r33 = null;
    L44:
        ((TextView) r33).setText(2131886194);
        View r36 = this.t;
        if (r36 != null) goto L51;
        View r37 = getView();
        if (r37 == null) goto L49;
        r36 = r37.findViewById(2131381554);
    L50:
        this.t = (TextView) r36;
        goto L51
    L49:
        r36 = null;
    L51:
        ((TextView) r36).setText(2131886193);
        BitableProViewModel r38 = this.D;
        if (r38 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r38 = null;
    L54:
        r38.getIsPro().observe(getViewLifecycleOwner(), new p(this));
        BitableProViewModel r39 = this.D;
        if (r39 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r39 = null;
    L57:
        r39.getIsUpgradeProSuccess().observe(getViewLifecycleOwner(), new q(this));
        BitableProViewModel r40 = this.D;
        if (r40 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r40 = null;
    L60:
        com.bytedance.ee.bear.document.bitable.c r6 = this.B;
        if (r6 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r6 = null;
    L63:
        r40.updateIsPro(r6.b);
        ga0().setOnCheckedChangeListener(new j(this));
        goto L64
    }

    public static final void X90(BitableProFragment r3, boolean r4, ArrayList r5) {
        r3.getClass();
        int r0 = BitableProUpdateFragment.Q;
        if (r5 != null) goto L5;
        r5 = new ArrayList();
    L5:
        Intrinsics.checkNotNullParameter(r5, "formulaInfoList");
        Bundle r1 = new Bundle();
        r1.putBoolean("show_update", r4);
        r1.putSerializable("formula_info", r5);
        PluginHost.writePluginHostToBundle(r3, r1);
        BitableProUpdateFragment r6 = r3.getChildFragmentManager().getFragmentFactory().instantiate(r3.requireContext().getClassLoader(), BitableProUpdateFragment.class.getName());
        r6.setArguments(r1);
        BitableProUpdateFragment r7 = r6;
        FragmentManager r8 = r3.getChildFragmentManager();
        String r2 = BitableProUpdateFragment.class.getName();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, r2, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r9) == false) goto L16;
    L10:
        if (r4 == true) goto L18;
        sk5.c r10 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        if (r10 == null) goto L19;
        r10.c("bitable_permission_upgrade_ssc");
        return;
    L19:
        return;
    L18:
        return;
    L16:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L9:
        r7.show(r8, r2);
        goto L10
    }

    public static final void Y90(BitableProFragment r1, int r2, int r3) {
        Context r0 = r1.getContext();
        if (r0 != null) goto L5;
        tt5.a.d(r1.v, "context is null");
        return;
    L5:
        UDToast.show(r0, r2, r3);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559123, r3, false);
    }
}

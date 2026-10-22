package com.bytedance.ee.bear.bitable.pro;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 p2\u00020\u0001:\u0005pqrstB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\f0\u0005J\u000e\u0010>\u001a\u00020?2\u0006\u0010=\u001a\u00020\fJ \u0010@\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0AJ\u000e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0AJ\u0010\u0010C\u001a\u00020?2\b\u0010D\u001a\u0004\u0018\u00010-J\b\u0010E\u001a\u0004\u0018\u00010\u0007J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0\u0005J\u000e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\fJ\u000e\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005J\u000e\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020\fJ\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005J\u000e\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020\fJ\u000e\u0010O\u001a\u00020?2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010P\u001a\u00020?2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010Q\u001a\u00020\u0012J\u0006\u0010R\u001a\u00020?J\u0006\u0010S\u001a\u00020?J\u0006\u0010T\u001a\u00020?J\u0006\u0010U\u001a\u00020?J\u001e\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010W\u001a\u00020XJJ\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0006j\b\u0012\u0004\u0012\u00020\u0014`\b2\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0006j\b\u0012\u0004\u0012\u00020\u0014`\b2\u001a\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\bJ\u0006\u0010\\\u001a\u00020?J\u000e\u0010]\u001a\u00020?2\u0006\u0010H\u001a\u00020\fJ\u0006\u0010^\u001a\u00020?J\u001e\u0010_\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0014J\u0016\u0010d\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0014J\u0016\u0010e\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0014J\u0010\u0010f\u001a\u00020?2\b\u0010g\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u00020?2\b\u0010g\u001a\u0004\u0018\u00010hJ\u0018\u0010j\u001a\u00020?2\u0006\u0010D\u001a\u00020k2\b\u0010g\u001a\u0004\u0018\u00010hJ\b\u0010l\u001a\u00020?H\u0014J\u001a\u0010m\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\bJ\b\u0010n\u001a\u0004\u0018\u000107J\u0006\u0010o\u001a\u00020\fR(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0006j\b\u0012\u0004\u0012\u00020\u0014`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "roleListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lkotlin/collections/ArrayList;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mIsPro", "", "mIsUpgradeProSuccess", "mUpgradePro", "repository", "Lcom/bytedance/ee/bear/bitable/pro/BitableProRepository;", "proInfo", "Lcom/bytedance/ee/bear/document/bitable/BitableProInfo;", "wikiUsers", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "mDisableLandscape", "delegate", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$Delegate;)V", "actionPanelListener", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$ActionPanelListener;", "getActionPanelListener", "()Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$ActionPanelListener;", "setActionPanelListener", "(Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$ActionPanelListener;)V", "effectData", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData;", "getEffectData", "()Landroidx/lifecycle/MutableLiveData;", "setEffectData", "(Landroidx/lifecycle/MutableLiveData;)V", "updateStatus", "Lcom/bytedance/ee/bear/bitable/pro/PermissionUpdateStatus;", "getUpdateStatus", "setUpdateStatus", "defaultAccessConfigLiveData", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultAccessConfig;", "getDefaultAccessConfigLiveData", "setDefaultAccessConfigLiveData", "selectStrategyListener", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$SelectDefaultStrategyListener;", "getSelectStrategyListener", "()Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$SelectDefaultStrategyListener;", "setSelectStrategyListener", "(Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$SelectDefaultStrategyListener;)V", "selectRoleName", "", "getSelectRoleName", "()Ljava/lang/String;", "setSelectRoleName", "(Ljava/lang/String;)V", "enableShowRoleMember", "disableLandscape", "updateLandscape", "", "getRoleListLiveData", "Landroidx/lifecycle/LiveData;", "getDefaultAccessConfig", "updateCurrentDefaultConfig", "config", "getSelectRole", "getIsPro", "updateIsPro", "isPro", "getIsUpgradeProSuccess", "updateProSuccess", "isSuccess", "getUpgradePro", "upgradePro", "isOpen", "setRepository", "setProInfo", "getProInfo", "clearUpgradePro", "fetchUpdateStatus", "fetchUpdateEffectData", "fetchRoleResult", "convertRoleList", "roleResult", "Lcom/bytedance/ee/bear/bitable/pro/RoleResult;", "findManagerAndWikiUsers", "allUsers", "members", "fetchProData", "updateRolesPro", "clearRolesMembers", "removeMember", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/contract/net/SimpleRequestResult;", "role", "userInfo", "isOverPermission", "isInOtherRole", "removeAllMembers", "callback", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$Callback;", "updatePro", "updateDefaultConfig", "Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "onCleared", "getWikiUsers", "getCreateTenantId", "isTemplate", "Companion", "Callback", "Delegate", "ActionPanelListener", "SelectDefaultStrategyListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProViewModel extends ViewModel {
    public static final b Companion = null;
    private static final String TAG = null;
    private ActionPanelListener actionPanelListener;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<DefaultAccessConfig> defaultAccessConfigLiveData;
    private c delegate;
    private MutableLiveData<PermEffectFieldData> effectData;
    private final boolean enableShowRoleMember;
    private final MutableLiveData<Boolean> mDisableLandscape;
    private final MutableLiveData<Boolean> mIsPro;
    private final MutableLiveData<Boolean> mIsUpgradeProSuccess;
    private final MutableLiveData<Boolean> mUpgradePro;
    private com.bytedance.ee.bear.document.bitable.c proInfo;
    private c0 repository;
    private final MutableLiveData<ArrayList<Role>> roleListLiveData;
    private String selectRoleName;
    private d selectStrategyListener;
    private MutableLiveData<PermissionUpdateStatus> updateStatus;
    private ArrayList<UserInfo> wikiUsers;

    public interface ActionPanelListener {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel$ActionPanelListener$Action;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HAS_UPGRADE", "LATER_UPGRADE", "TO_UPGRADE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Action extends Enum<Action> {
            public static final Action HAS_UPGRADE = null;
            public static final Action LATER_UPGRADE = null;
            public static final Action TO_UPGRADE = null;
            public static final /* synthetic */ Action[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final String value;

            public static EnumEntries<Action> getEntries() {
                return b;
            }

            static {
                Action r0 = new Action("HAS_UPGRADE", 0, "hasUpgrade");
                HAS_UPGRADE = r0;
                Action r1 = new Action("LATER_UPGRADE", 1, "laterUpgrade");
                LATER_UPGRADE = r1;
                Action r2 = new Action("TO_UPGRADE", 2, "toUpgrade");
                TO_UPGRADE = r2;
                Action[] r4 = {r0, r1, r2};
                a = r4;
                b = EnumEntriesKt.enumEntries(r4);
            }

            public static Action[] values() {
                return (Action[]) a.clone();
            }

            public final String getValue() {
                return this.value;
            }

            public static Action valueOf(String r1) {
                return (Action) r27.a.a(Action.class, r1);
            }

            public Action(String r1, int r2, String r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        void a(Action r1);
    }

    public interface a {
        void a(int r1);

        void success();
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
    }

    public interface d {
        void a(DefaultConfig r1);
    }

    public static final class e<T> implements Comparator {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r5, Object r6) {
            Role r7 = (Role) r5;
            Role r8 = (Role) r6;
            long r0 = 0;
            if (r7 == null) goto L5;
            long r2 = r7.getCreatedTime();
        L6:
            if (r8 == null) goto L9;
            r0 = r8.getCreatedTime();
        L9:
            if (r2 >= r0) goto L11;
            return -1;
        L11:
            if (r2 <= r0) goto L13;
            return 1;
        L13:
            return 0;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class f<T1, T2, T3, T4, R> implements Function4 {
        public final /* synthetic */ BitableProViewModel a;

        public f(BitableProViewModel r1) {
            this.a = r1;
        }

        public final Object apply(Object r28, Object r29, Object r30, Object r31) {
            ShareUserInfoResult r1 = (ShareUserInfoResult) r28;
            PermCostInfo r2 = (PermCostInfo) r29;
            RoleResult r3 = (RoleResult) r30;
            IDocPublicPermission r4 = (IDocPublicPermission) r31;
            Intrinsics.checkNotNullParameter(r1, "shareUserInfoResult");
            Intrinsics.checkNotNullParameter(r2, "permCostInfo");
            Intrinsics.checkNotNullParameter(r3, "roleResult");
            Intrinsics.checkNotNullParameter(r4, "pubPerm");
            DefaultAccessConfig r5 = new DefaultAccessConfig();
            r5.setDefaultConfig(r3.getDefaultConfig());
            r5.setPublicPermission(r4);
            ArrayList<UserInfo> r6 = r5.getUserList();
            BitableProViewModel r7 = this.a;
            ArrayList<UserInfo> r8 = r1.getUserInfoList();
            if (BitableProViewModel.access$getEnableShowRoleMember$p(this.a) == false) goto L5;
            ArrayList<UserInfo> r9 = r6;
        L6:
            ArrayList<UserInfo> r12 = r7.findManagerAndWikiUsers(r8, r9);
            boolean r10 = r2.getRowPermitted();
            boolean r11 = r2.getFieldPermitted();
            ArrayList<Role> r13 = this.a.convertRoleList(r3);
            if (BitableProViewModel.access$getEnableShowRoleMember$p(this.a) == false) goto L20;
            Iterator<T> r14 = r13.iterator();
        L10:
            if (r14.hasNext() == false) goto L20;
            Iterator<T> r16 = ((Role) r14.next()).getMembers().iterator();
        L13:
            if (r16.hasNext() == false) goto L10;
            UserInfo r17 = (UserInfo) r16.next();
            Iterator<UserInfo> r18 = r6.iterator();
        L16:
            if (r18.hasNext() == false) goto L13;
            if (r18.next().equals(r17) == false) goto L16;
            r18.remove();
        L20:
            ArrayList r19 = new ArrayList();
            if (r12.size() <= 0) goto L23;
            r19.add(new Role(null, null, r12, null, null, null, null, null, null, 0, false, 0, true, null, 12283, null));
        L23:
            r19.addAll(r13);
            DefaultConfig r20 = r3.getDefaultConfig();
            if (r20 == null) goto L26;
            String r21 = r20.getBindRoleId();
        L27:
            Boolean r22 = (Boolean) BitableProViewModel.access$getMIsPro$p(this.a).getValue();
            if (r22 == null) goto L30;
            boolean r23 = r22.booleanValue();
        L34:
            BitableProViewModel r110 = this.a;
            Iterator r111 = r19.iterator();
        L36:
            if (r111.hasNext() == false) goto L64;
            Role r112 = (Role) r111.next();
            r112.setCostInfo(r10, r11);
            com.bytedance.ee.bear.document.bitable.c r113 = BitableProViewModel.access$getProInfo$p(r110);
            if (r113 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r113 = null;
        L40:
            r112.setIsPro(r23, r113.a);
            if (r5.isSystemRole() == true) goto L56;
            if (TextUtils.isEmpty(r110.getSelectRoleName()) == true) goto L56;
            if (TextUtils.equals(r112.getName(), r110.getSelectRoleName()) == false) goto L56;
            r112.setIsDefaultRole(true);
            DefaultConfig r114 = new DefaultConfig(1, r112.getRoleId(), false, 4, null);
            r114.setBindRole(r112);
            r5.setDefaultConfig(r114);
            String r115 = BitableProViewModel.access$getTAG$cp();
            StringBuilder r116 = new StringBuilder("fetch default config accessStrategy ");
            DefaultConfig r117 = r3.getDefaultConfig();
            if (r117 == null) goto L49;
            Integer r118 = Integer.valueOf(r117.getAccessStrategy());
        L50:
            r116.append(r118);
            r116.append(" bindId ");
            DefaultConfig r119 = r3.getDefaultConfig();
            if (r119 == null) goto L53;
            String r120 = r119.getRoleId();
        L54:
            r116.append(r120);
            tt5.a.h(r115, r116.toString());
            goto L36
        L53:
            r120 = null;
            goto L54
        L49:
            r118 = null;
        L56:
            if (TextUtils.equals(r112.getRoleId(), r21) == false) goto L36;
            if (TextUtils.isEmpty(r21) == true) goto L36;
            DefaultConfig r121 = r3.getDefaultConfig();
            if (r121 == null) goto L62;
            r121.setBindRole(r112);
        L62:
            r112.setIsDefaultRole(true);
            goto L36
        L64:
            return new BitableProData(r19, r5);
        L30:
            com.bytedance.ee.bear.document.bitable.c r24 = BitableProViewModel.access$getProInfo$p(this.a);
            if (r24 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("proInfo");
            r24 = null;
        L33:
            r23 = r24.b;
            goto L34
        L26:
            r21 = null;
            goto L27
        L5:
            r9 = null;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public g(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            BitableProData r4 = (BitableProData) r3;
            BitableProViewModel.access$getRoleListLiveData$p(this.a).setValue(r4.getRoleList());
            this.a.getDefaultAccessConfigLiveData().setValue(r4.getDefaultConfig());
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public h(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = BitableProViewModel.access$getTAG$cp();
            tt5.a.e(r0, "fetchProData...error", (Throwable) r4, false);
            BitableProViewModel.access$getRoleListLiveData$p(this.a).setValue(null);
            this.a.getDefaultAccessConfigLiveData().setValue(null);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public i(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RoleResult r4 = (RoleResult) r3;
            MutableLiveData r0 = BitableProViewModel.access$getRoleListLiveData$p(this.a);
            BitableProViewModel r1 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.setValue(r1.convertRoleList(r4));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public j(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = BitableProViewModel.access$getTAG$cp();
            tt5.a.e(r0, "fetchRoleResult()...error", (Throwable) r4, false);
            BitableProViewModel.access$getRoleListLiveData$p(this.a).setValue(null);
        }
    }

    public static final class k<T> implements ObservableOnSubscribe {
        public final /* synthetic */ BitableProViewModel a;

        public k(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<PermEffectFieldData> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            PermEffectFieldData r0 = (PermEffectFieldData) this.a.getEffectData().getValue();
            if (r0 == null) goto L5;
            r2.onNext(r0);
        L5:
            r2.onComplete();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public l(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<PermEffectFieldData> r0 = this.a.getEffectData();
            r0.setValue((PermEffectFieldData) r2);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public m(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(BitableProViewModel.access$getTAG$cp(), "get update effect data err " + ((Throwable) r4));
            this.a.getEffectData().setValue(null);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public n(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<PermissionUpdateStatus> r0 = this.a.getUpdateStatus();
            r0.setValue((PermissionUpdateStatus) r2);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;

        public o(BitableProViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = BitableProViewModel.access$getTAG$cp();
            tt5.a.e(r0, "fetchUpdateStatus()...error", (Throwable) r4, false);
            this.a.getUpdateStatus().setValue(null);
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ BitableProViewModel a;
        public final /* synthetic */ a b;

        public p(BitableProViewModel r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            int r5 = ((SimpleRequestResult) r4).getCode();
            if (r5 != 0) goto L7;
            this.a.clearRolesMembers();
            a r6 = this.b;
            if (r6 == null) goto L12;
            r6.success();
            return;
        L12:
            return;
        L7:
            a r0 = this.b;
            if (r0 == null) goto L10;
            r0.a(r5);
        L10:
            tt5.a.d(BitableProViewModel.access$getTAG$cp(), "remove all members err code " + r5);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ a a;

        public q(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            a r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(-1);
        L5:
            tt5.a.e(BitableProViewModel.access$getTAG$cp(), "remove all members err ", r5, false);
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ a a;

        public r(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            int r5 = ((SimpleRequestResult) r4).getCode();
            if (r5 == 0) goto L8;
            a r0 = this.a;
            if (r0 == null) goto L7;
            r0.a(r5);
        L7:
            tt5.a.d(BitableProViewModel.access$getTAG$cp(), "update defaultAccessConfig fail " + r5);
            return;
        L8:
            a r6 = this.a;
            if (r6 == null) goto L13;
            r6.success();
            return;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ a a;

        public s(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            a r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(-1);
        L5:
            tt5.a.e(BitableProViewModel.access$getTAG$cp(), "upgrade defaultAccessConfig err ", r5, false);
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ a a;

        public t(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            int r5 = ((SimpleRequestResult) r4).getCode();
            if (r5 == 0) goto L8;
            a r0 = this.a;
            if (r0 == null) goto L7;
            r0.a(r5);
        L7:
            tt5.a.d(BitableProViewModel.access$getTAG$cp(), "upgrade pro fail " + r5);
            return;
        L8:
            a r6 = this.a;
            if (r6 == null) goto L13;
            r6.success();
            return;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ a a;

        public u(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            a r0 = this.a;
            if (r0 == null) goto L5;
            r0.a(-1);
        L5:
            tt5.a.e(BitableProViewModel.access$getTAG$cp(), "upgrade pro err  ", r5, false);
        }
    }

    static {
        Companion = new b();
        TAG = "BitableProViewModel";
    }

    public final void clearRolesMembers() {
        DefaultAccessConfig r0 = (DefaultAccessConfig) this.defaultAccessConfigLiveData.getValue();
        if (r0 == null) goto L5;
        ArrayList<UserInfo> r1 = r0.getUserList();
    L6:
        ArrayList r2 = (ArrayList) this.roleListLiveData.getValue();
        if (r2 == null) goto L20;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L18;
        Role r4 = (Role) r3.next();
        if (r4.isFaType() == true) goto L10;
        if (this.enableShowRoleMember == false) goto L17;
        if (r1 == null) goto L17;
        r1.addAll(r4.getMembers());
    L17:
        r4.getMembers().clear();
        goto L10
    L18:
        this.roleListLiveData.setValue(r2);
    L20:
        if (this.enableShowRoleMember == false) goto L28;
        this.defaultAccessConfigLiveData.setValue(r0);
        return;
    L28:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void clearUpgradePro() {
        this.mIsUpgradeProSuccess.setValue(null);
        this.mUpgradePro.setValue(null);
        this.updateStatus.setValue(null);
        this.effectData.setValue(null);
        this.selectRoleName = null;
    }

    public final void fetchProData() {
        c0 r0 = this.repository;
        Flowable r2 = null;
        if (r0 == null) goto L5;
        Flowable r1 = li5.c.b(8, r0.a, null);
    L6:
        c0 r3 = this.repository;
        if (r3 == null) goto L9;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        String r4 = String.format("/space/api/bitable/%s/perm_cost_info", Arrays.copyOf(new Object[]{r3.a}, 1));
        Flowable r6 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new j0()).a(new NetService.f(r4));
    L10:
        c0 r7 = this.repository;
        if (r7 == null) goto L13;
        Flowable<RoleResult> r8 = r7.a();
    L14:
        c0 r9 = this.repository;
        if (r9 == null) goto L17;
        r2 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().b(r9.a, 8);
    L17:
        this.compositeDisposable.add(Flowable.zip(r1, r6, r8, r2, new f(this)).subscribe(new g(this), new h(this)));
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void fetchRoleResult() {
        c0 r0 = this.repository;
        if (r0 == null) goto L7;
        Flowable<RoleResult> r1 = r0.a();
        if (r1 == null) goto L7;
        Disposable r2 = r1.subscribe(new i(this), new j(this));
    L8:
        if (r2 == null) goto L11;
        this.compositeDisposable.add(r2);
        return;
    L11:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void fetchUpdateEffectData() {
        Observable r0 = Observable.create(new k(this));
        c r1 = this.delegate;
        if (r1 == null) goto L5;
        Observable<PermEffectFieldData> r2 = ((BitableProPlugin.a) r1).a.getProUpdateEffectData();
    L6:
        Disposable r3 = Observable.concat(r0, r2).firstElement().toObservable().subscribe(new l(this), new m(this));
        if (r3 == null) goto L10;
        this.compositeDisposable.add(r3);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void fetchUpdateStatus() {
        c r0 = this.delegate;
        if (r0 == null) goto L7;
        Observable r1 = BitableProPlugin.access$000(((BitableProPlugin.a) r0).a);
        if (r1 == null) goto L7;
        Disposable r2 = r1.subscribe(new n(this), new o(this));
    L8:
        if (r2 == null) goto L11;
        this.compositeDisposable.add(r2);
        return;
    L11:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final String getCreateTenantId() {
        com.bytedance.ee.bear.document.bitable.c r0 = this.proInfo;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r0 = null;
    L6:
        return r0.c;
    }

    public final com.bytedance.ee.bear.document.bitable.c getProInfo() {
        com.bytedance.ee.bear.document.bitable.c r0 = this.proInfo;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        return null;
    L6:
        return r0;
    }

    public final Role getSelectRole() {
        if (TextUtils.isEmpty(this.selectRoleName) == true) goto L12;
        ArrayList r0 = (ArrayList) this.roleListLiveData.getValue();
        if (r0 == null) goto L12;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Role r2 = (Role) r1.next();
        if (TextUtils.equals(r2.getName(), this.selectRoleName) == false) goto L8;
        return r2;
    L12:
        tt5.a.h(TAG, " selectRoleName is " + this.selectRoleName);
        return null;
    }

    public final boolean isTemplate() {
        com.bytedance.ee.bear.document.bitable.c r0 = this.proInfo;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r0 = null;
    L6:
        if (r0.a == true) goto L10;
        return false;
    L10:
        return true;
    }

    public BitableProViewModel() {
        this.roleListLiveData = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
        this.mIsPro = new MutableLiveData();
        this.mIsUpgradeProSuccess = new MutableLiveData();
        this.mUpgradePro = new MutableLiveData();
        this.wikiUsers = new ArrayList();
        this.mDisableLandscape = new MutableLiveData();
        this.effectData = new MutableLiveData();
        this.updateStatus = new MutableLiveData();
        this.defaultAccessConfigLiveData = new MutableLiveData();
        int r0 = com.bytedance.ee.bear.bitable.pro.e.a;
        this.enableShowRoleMember = com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.aggressive_role_preview");
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final MutableLiveData<Boolean> disableLandscape() {
        return this.mDisableLandscape;
    }

    public final ActionPanelListener getActionPanelListener() {
        return this.actionPanelListener;
    }

    public final LiveData<DefaultAccessConfig> getDefaultAccessConfig() {
        return this.defaultAccessConfigLiveData;
    }

    public final MutableLiveData<DefaultAccessConfig> getDefaultAccessConfigLiveData() {
        return this.defaultAccessConfigLiveData;
    }

    public final c getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<PermEffectFieldData> getEffectData() {
        return this.effectData;
    }

    public final MutableLiveData<Boolean> getIsPro() {
        return this.mIsPro;
    }

    public final MutableLiveData<Boolean> getIsUpgradeProSuccess() {
        return this.mIsUpgradeProSuccess;
    }

    public final LiveData<ArrayList<Role>> getRoleListLiveData() {
        return this.roleListLiveData;
    }

    public final String getSelectRoleName() {
        return this.selectRoleName;
    }

    public final d getSelectStrategyListener() {
        return this.selectStrategyListener;
    }

    public final MutableLiveData<PermissionUpdateStatus> getUpdateStatus() {
        return this.updateStatus;
    }

    public final MutableLiveData<Boolean> getUpgradePro() {
        return this.mUpgradePro;
    }

    public final ArrayList<UserInfo> getWikiUsers() {
        return this.wikiUsers;
    }

    public static final /* synthetic */ boolean access$getEnableShowRoleMember$p(BitableProViewModel r0) {
        return r0.enableShowRoleMember;
    }

    public static final /* synthetic */ MutableLiveData access$getMIsPro$p(BitableProViewModel r0) {
        return r0.mIsPro;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.document.bitable.c access$getProInfo$p(BitableProViewModel r0) {
        return r0.proInfo;
    }

    public static final /* synthetic */ MutableLiveData access$getRoleListLiveData$p(BitableProViewModel r0) {
        return r0.roleListLiveData;
    }

    public final ArrayList<Role> convertRoleList(RoleResult r3) {
        Intrinsics.checkNotNullParameter(r3, "roleResult");
        ArrayList<Role> r0 = new ArrayList();
        if (r3.getDefaultReadRole() == null) goto L6;
        r0.add(r3.getDefaultReadRole());
    L6:
        if (r3.getDefaultEditRole() == null) goto L8;
        r0.add(r3.getDefaultEditRole());
    L8:
        r0.addAll(r3.getOtherRole());
        CollectionsKt.sortWith(r0, e.a);
        return r0;
    }

    public final void removeAllMembers(a r6) {
        c0 r0 = this.repository;
        Disposable r1 = null;
        if (r0 == null) goto L7;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        String r3 = String.format("space/api/bitable/roles/%s/clear_member", Arrays.copyOf(new Object[]{r0.a}, 1));
        NetService r4 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r5 = new NetService.f(r3);
        r5.c = 1;
        Flowable r7 = r4.Vc(new ax4.f()).a(r5);
        if (r7 == null) goto L7;
        r1 = r7.subscribe(new p(this, r6), new q(r6));
    L7:
        if (r1 == null) goto L10;
        this.compositeDisposable.add(r1);
        return;
    }

    public final void setActionPanelListener(ActionPanelListener r1) {
        this.actionPanelListener = r1;
    }

    public final void setDefaultAccessConfigLiveData(MutableLiveData<DefaultAccessConfig> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.defaultAccessConfigLiveData = r2;
    }

    public final void setDelegate(c r1) {
        this.delegate = r1;
    }

    public final void setEffectData(MutableLiveData<PermEffectFieldData> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.effectData = r2;
    }

    public final void setProInfo(com.bytedance.ee.bear.document.bitable.c r2) {
        Intrinsics.checkNotNullParameter(r2, "proInfo");
        this.proInfo = r2;
    }

    public final void setRepository(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.repository = r2;
    }

    public final void setSelectRoleName(String r1) {
        this.selectRoleName = r1;
    }

    public final void setSelectStrategyListener(d r1) {
        this.selectStrategyListener = r1;
    }

    public final void setUpdateStatus(MutableLiveData<PermissionUpdateStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.updateStatus = r2;
    }

    public final void updateCurrentDefaultConfig(DefaultAccessConfig r2) {
        this.defaultAccessConfigLiveData.setValue(r2);
    }

    public final void updateIsPro(boolean r2) {
        this.mIsPro.setValue(Boolean.valueOf(r2));
    }

    public final void updateLandscape(boolean r2) {
        this.mDisableLandscape.setValue(Boolean.valueOf(r2));
    }

    public final void updatePro(a r6) {
        c0 r0 = this.repository;
        Disposable r1 = null;
        if (r0 == null) goto L7;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        NetService.f r3 = new NetService.f(String.format("/space/api/bitable/schemaVersionSSC/%s/upgrade", Arrays.copyOf(new Object[]{r0.a}, 1)));
        r3.c = 1;
        Flowable r4 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r3);
        if (r4 == null) goto L7;
        r1 = r4.subscribe(new t(r6), new u(r6));
    L7:
        if (r1 == null) goto L10;
        this.compositeDisposable.add(r1);
        return;
    }

    public final void updateProSuccess(boolean r2) {
        this.mIsUpgradeProSuccess.setValue(Boolean.valueOf(r2));
    }

    public final void updateRolesPro(boolean r4) {
        ArrayList r0 = (ArrayList) this.roleListLiveData.getValue();
        if (r0 == null) goto L11;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((Role) r1.next()).setIsPro(r4);
        goto L6
    L8:
        this.roleListLiveData.setValue(r0);
        return;
    }

    public final void upgradePro(boolean r2) {
        this.mUpgradePro.setValue(Boolean.valueOf(r2));
    }

    public final ArrayList<UserInfo> findManagerAndWikiUsers(ArrayList<UserInfo> r5, ArrayList<UserInfo> r6) {
        Intrinsics.checkNotNullParameter(r5, "allUsers");
        ArrayList<UserInfo> r0 = new ArrayList();
        this.wikiUsers.clear();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        UserInfo r1 = (UserInfo) r7.next();
        if (r1.getOwnerType() != 24) goto L8;
        this.wikiUsers.add(r1);
    L8:
        DocUserPermission.a r2 = DocUserPermission.Companion;
        int r3 = r1.getPermission();
        r2.getClass();
        if (DocUserPermission.a.a(r3) == true) goto L10;
        if (r1.isApp() == true) goto L4;
        if (r6 == null) goto L4;
        r6.add(r1);
        goto L4
    L10:
        r0.add(r1);
        goto L4
    L15:
        return r0;
    }

    public final boolean isInOtherRole(Role r4, UserInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "role");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        ArrayList r0 = (ArrayList) this.roleListLiveData.getValue();
        if (r0 == null) goto L13;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        Role r2 = (Role) r1.next();
        if (Intrinsics.areEqual(r2, r4) == true) goto L6;
        if (r2.getMembers().contains(r5) == false) goto L6;
        return true;
    L21:
        return false;
    L13:
        return false;
    }

    public final boolean isOverPermission(Role r5, UserInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "role");
        Intrinsics.checkNotNullParameter(r6, "userInfo");
        DefaultAccessConfig r0 = (DefaultAccessConfig) this.defaultAccessConfigLiveData.getValue();
        if (r0 == null) goto L5;
        DefaultConfig r1 = r0.getDefaultConfig();
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
    L17:
        return false;
    L14:
        if (r1.getAccessStrategy() != 1) goto L17;
        return !isInOtherRole(r5, r6);
    L9:
        if (r1.isValid() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public final Flowable<SimpleRequestResult> removeMember(Role r10, UserInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "role");
        Intrinsics.checkNotNullParameter(r11, "userInfo");
        c0 r2 = this.repository;
        if (r2 == null) goto L23;
        Intrinsics.checkNotNullParameter(r10, "role");
        Intrinsics.checkNotNullParameter(r11, "userInfo");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        NetService.f r3 = new NetService.f(String.format("/space/api/bitable/roles/%s/update", Arrays.copyOf(new Object[]{r2.a}, 1)));
        r3.c = 1;
        JSONObject r1 = new JSONObject();
        r1.put("roleId", r10.getRoleId());
        ArrayList<UserInfo> r12 = r10.getMembers();
        JSONArray r4 = new JSONArray();
        Iterator<UserInfo> r13 = r12.iterator();     // Catch: JSONException -> L12
    L7:
        if (r13.hasNext() == false) goto L14;
        UserInfo r5 = r13.next();     // Catch: JSONException -> L12
        if (Objects.equals(r5, r11) == true) goto L7;
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L12
        r6.put("memberId", r5.getId());     // Catch: JSONException -> L12
        r6.put("memberType", Integer.valueOf(r5.getOwnerType()));     // Catch: JSONException -> L12
        r4.add(r6);     // Catch: JSONException -> L12
    L14:
        r1.put("members", r4);
        JSONObject r14 = new JSONObject();
        r14.put("baseRole", r1);
        r14.put("needAddCollaborators", Boolean.TRUE);
        r3.j = r14.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r3);
    L12:
        e = move-exception;
        tt5.a.f("BitableProRepository", e, false);
        goto L14
    L23:
        return null;
    }

    public final void updateDefaultConfig(DefaultConfig r6, a r7) {
        Intrinsics.checkNotNullParameter(r6, "config");
        c0 r0 = this.repository;
        if (r0 == null) goto L10;
        int r1 = r6.getAccessStrategy();
        String r8 = r6.getRoleId();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        NetService.f r3 = new NetService.f(String.format("space/api/bitable/default_access_config/%s/update", Arrays.copyOf(new Object[]{r0.a}, 1)));
        r3.c = 1;
        JSONObject r4 = new JSONObject();
        r4.put("accessStrategy", Integer.valueOf(r1));
        if (TextUtils.isEmpty(r8) == true) goto L7;
        r4.put("roleId", r8);
    L7:
        JSONObject r9 = new JSONObject();
        r9.put("defaultAccessConfig", r4);
        r3.j = r9.toJSONString();
        Flowable r10 = ((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).Vc(new ax4.f()).a(r3);
        if (r10 == null) goto L10;
        Disposable r11 = r10.subscribe(new r(r7), new s(r7));
    L11:
        if (r11 == null) goto L14;
        this.compositeDisposable.add(r11);
        return;
    L14:
        return;
    L10:
        r11 = null;
        goto L11
    }
}

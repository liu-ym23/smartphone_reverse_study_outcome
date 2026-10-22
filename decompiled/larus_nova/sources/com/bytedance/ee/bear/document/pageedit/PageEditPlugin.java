package com.bytedance.ee.bear.document.pageedit;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0004\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "orientationPlugin", "Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "getOrientationPlugin", "()Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "setOrientationPlugin", "(Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;)V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getBaseUnspecifiedOrientationPlugin", "shouldDisableLandscape", "", "Companion", "PageEditManageCollaborator", "DocInfoEditorParams", "UserInfo", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageEditPlugin extends DocumentPluginV2 implements p {
    public static final String ADD = "add";
    public static final String BIZ_DOCS_DOC_INFO_EDITOR_CLICK = "biz.docInfo.showSelectEditorPanel";
    public static final a Companion = null;
    public static final String REMOVE = "remove";
    public static final String TAG = "PageEditPlugin";
    private Fragment fragment;
    private BaseUnspecifiedOrientationPlugin<?> orientationPlugin;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$DocInfoEditorParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "selectUserIds", "getSelectUserIds", "setSelectUserIds", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DocInfoEditorParams implements NonProguard {
        private ArrayList<UserInfo> data;
        private ArrayList<String> selectUserIds;
        private String type;

        public DocInfoEditorParams() {
            this.type = "add";
            this.data = new ArrayList();
            this.selectUserIds = new ArrayList();
        }

        public final ArrayList<UserInfo> getData() {
            return this.data;
        }

        public final ArrayList<String> getSelectUserIds() {
            return this.selectUserIds;
        }

        public final String getType() {
            return this.type;
        }

        public final void setData(ArrayList<UserInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.data = r100;
        }

        public final void setSelectUserIds(ArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.selectUserIds = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "userid", "", "getUserid", "()Ljava/lang/String;", "setUserid", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_USERNAME, "getUsername", "setUsername", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "equals", "", "other", "", "hashCode", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserInfo implements NonProguard {

        @SerializedName("avatar_url")
        @JSONField(name = "avatar_url")
        private String avatarUrl;
        private String userid;
        private String username;

        public int hashCode() {
            String r100 = this.userid;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.username;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.avatarUrl;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public UserInfo() {
            this.userid = "";
            this.username = "";
            this.avatarUrl = "";
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final String getUserid() {
            return this.userid;
        }

        public final String getUsername() {
            return this.username;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(UserInfo.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.document.pageedit.PageEditPlugin.UserInfo");
            UserInfo r102 = (UserInfo) r100;
            if (Intrinsics.areEqual(this.userid, r102.userid) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.username, r102.username) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.avatarUrl, r102.avatarUrl) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public final void setAvatarUrl(String r100) {
            this.avatarUrl = r100;
        }

        public final void setUserid(String r100) {
            this.userid = r100;
        }

        public final void setUsername(String r100) {
            this.username = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<DocInfoEditorParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageEditPlugin f220794a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(PageEditPlugin r100) {
            this.f220794a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            DocInfoEditorParams r112 = (DocInfoEditorParams) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            StringBuilder r100 = new StringBuilder("handle... data is null ? ");
            boolean r101 = false;
            if (r112 != null) goto L5;
            boolean r102 = true;
        L6:
            r100.append(r102);
            tt5.a.h(PageEditPlugin.TAG, r100.toString());
            if (r112 == null) goto L57;
            Fragment r103 = this.f220794a.getFragment();
            if (r103 != null) goto L12;
        L14:
            if (r101 == false) goto L16;
            tt5.a.h(PageEditPlugin.TAG, "handle... fragment is already showing");
            return;
        L16:
            PageEditPlugin r104 = this.f220794a;
            c r105 = new c(r104, r111);
            Fragment r106 = r104.getHost().getHostFragment();
            PageEditPlugin r113 = this.f220794a;
            if (TextUtils.equals(r112.getType(), "add") == false) goto L30;
            int r107 = AddMemberFragment.f220778q;
            UserSession r108 = this.f220794a.getHost().getUserComponent().b();
            ArrayList<String> r114 = r112.getSelectUserIds();
            Intrinsics.checkNotNullParameter(r108, "userSession");
            Bundle r109 = new Bundle();
            r109.putSerializable("FORCE_SELECT", r114);
            PassportcConvention.h(r109, r108);
            AddMemberFragment r115 = new AddMemberFragment();
            r115.setArguments(r109);
            FragmentManager r116 = PageEditPlugin.access$getUIContainer(this.f220794a).getFragmentManager();
            Intrinsics.checkNotNullParameter(r116, "manager");
            Intrinsics.checkNotNullParameter(PageEditPlugin.TAG, "tag");
            Intrinsics.checkNotNullParameter(r105, "callBack");
            if (ForsetiHelper.s(r106) == true) goto L21;
        L24:
            LandscapeRestrictionOperation r117 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r115, PageEditPlugin.TAG, r117);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r115, r117) == false) goto L50;
        L29:
            r115.f220782n = r105;
            Fragment r118 = r115;
        L42:
            r113.setFragment(r118);
            Fragment r119 = this.f220794a.getFragment();
            if (r119 == null) goto L55;
            Lifecycle r120 = r119.getLifecycle();
            if (r120 == null) goto L56;
            final PageEditPlugin r121 = this.f220794a;
            r120.addObserver(new PageEditPlugin$PageEditManageCollaborator$handle$3(r121));
            return;
        L56:
            return;
        L55:
            return;
        L50:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
        L28:
            r115.show(r116, PageEditPlugin.TAG);
            goto L29
        L21:
            if (((Boolean) ForsetiHelper.f216452n.getValue()).booleanValue() == false) goto L24;
            if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r115, r106, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false, 0, true, 28) == true) goto L29;
        L30:
            int r122 = RemoveMemberFragment.f220795q;
            UserSession r123 = this.f220794a.getHost().getUserComponent().b();
            ArrayList<UserInfo> r124 = r112.getData();
            Intrinsics.checkNotNullParameter(r123, "userSession");
            Bundle r125 = new Bundle();
            r125.putSerializable("DATA_SOURCE", r124);
            PassportcConvention.h(r125, r123);
            RemoveMemberFragment r126 = new RemoveMemberFragment();
            r126.setArguments(r125);
            FragmentManager r127 = PageEditPlugin.access$getUIContainer(this.f220794a).getFragmentManager();
            Intrinsics.checkNotNullParameter(r127, "manager");
            Intrinsics.checkNotNullParameter(PageEditPlugin.TAG, "tag");
            Intrinsics.checkNotNullParameter(r105, "callBack");
            if (ForsetiHelper.s(r106) == true) goto L33;
        L36:
            LandscapeRestrictionOperation r128 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r126, PageEditPlugin.TAG, r128);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r127, r126, r128) == false) goto L52;
        L41:
            r126.f220796k = r105;
            r118 = r126;
            goto L42
        L52:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
        L40:
            r126.show(r127, PageEditPlugin.TAG);
            goto L41
        L33:
            if (((Boolean) ForsetiHelper.f216452n.getValue()).booleanValue() == false) goto L36;
            if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r126, r106, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false, 0, true, 28) == true) goto L41;
        L12:
            if (r103.isAdded() != true) goto L14;
            r101 = true;
            goto L14
        L57:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final BaseUnspecifiedOrientationPlugin<?> getBaseUnspecifiedOrientationPlugin() {
        if (this.orientationPlugin != null) goto L6;
        this.orientationPlugin = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
    L6:
        return this.orientationPlugin;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        Fragment r100 = this.fragment;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isAdded() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public PageEditPlugin() {
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final BaseUnspecifiedOrientationPlugin<?> getOrientationPlugin() {
        return this.orientationPlugin;
    }

    public static final /* synthetic */ BaseUnspecifiedOrientationPlugin access$getBaseUnspecifiedOrientationPlugin(PageEditPlugin r100) {
        return r100.getBaseUnspecifiedOrientationPlugin();
    }

    public static final /* synthetic */ t access$getUIContainer(PageEditPlugin r100) {
        return r100.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_DOCS_DOC_INFO_EDITOR_CLICK, new b(this));
    }

    public final void setFragment(Fragment r100) {
        this.fragment = r100;
    }

    public final void setOrientationPlugin(BaseUnspecifiedOrientationPlugin<?> r100) {
        this.orientationPlugin = r100;
    }
}

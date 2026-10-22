package com.bytedance.ee.bear.document.pageedit;

import android.os.Bundle;
import android.text.TextUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0004\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "orientationPlugin", "Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "getOrientationPlugin", "()Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "setOrientationPlugin", "(Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;)V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getBaseUnspecifiedOrientationPlugin", "shouldDisableLandscape", "", "Companion", "PageEditManageCollaborator", "DocInfoEditorParams", "UserInfo", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            this.type = PageEditPlugin.ADD;
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

        public final void setData(ArrayList<UserInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.data = r2;
        }

        public final void setSelectUserIds(ArrayList<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.selectUserIds = r2;
        }

        public final void setType(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.type = r2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "userid", "", "getUserid", "()Ljava/lang/String;", "setUserid", "(Ljava/lang/String;)V", "username", "getUsername", "setUsername", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "equals", "", "other", "", "hashCode", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserInfo implements NonProguard {

        @SerializedName("avatar_url")
        @JSONField(name = "avatar_url")
        private String avatarUrl;
        private String userid;
        private String username;

        public int hashCode() {
            String r0 = this.userid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.username;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.avatarUrl;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(UserInfo.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.document.pageedit.PageEditPlugin.UserInfo");
            UserInfo r6 = (UserInfo) r5;
            if (Intrinsics.areEqual(this.userid, r6.userid) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.username, r6.username) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public final void setAvatarUrl(String r1) {
            this.avatarUrl = r1;
        }

        public final void setUserid(String r1) {
            this.userid = r1;
        }

        public final void setUsername(String r1) {
            this.username = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<DocInfoEditorParams> {
        public final /* synthetic */ PageEditPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(PageEditPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r12, m r13) {
            DocInfoEditorParams r14 = (DocInfoEditorParams) r12;
            Intrinsics.checkNotNullParameter(r13, "callback");
            StringBuilder r0 = new StringBuilder("handle... data is null ? ");
            boolean r1 = false;
            if (r14 != null) goto L5;
            boolean r3 = true;
        L6:
            r0.append(r3);
            tt5.a.h(PageEditPlugin.TAG, r0.toString());
            if (r14 == null) goto L57;
            Fragment r2 = this.a.getFragment();
            if (r2 != null) goto L12;
        L14:
            if (r1 == false) goto L16;
            tt5.a.h(PageEditPlugin.TAG, "handle... fragment is already showing");
            return;
        L16:
            PageEditPlugin r4 = this.a;
            c r5 = new c(r4, r13);
            Fragment r6 = r4.getHost().getHostFragment();
            PageEditPlugin r16 = this.a;
            if (TextUtils.equals(r14.getType(), PageEditPlugin.ADD) == false) goto L30;
            int r7 = AddMemberFragment.q;
            UserSession r8 = this.a.getHost().getUserComponent().b();
            ArrayList<String> r17 = r14.getSelectUserIds();
            Intrinsics.checkNotNullParameter(r8, "userSession");
            Bundle r9 = new Bundle();
            r9.putSerializable("FORCE_SELECT", r17);
            PassportcConvention.h(r9, r8);
            Fragment r18 = new AddMemberFragment();
            r18.setArguments(r9);
            FragmentManager r10 = PageEditPlugin.access$getUIContainer(this.a).getFragmentManager();
            Intrinsics.checkNotNullParameter(r10, "manager");
            Intrinsics.checkNotNullParameter(PageEditPlugin.TAG, "tag");
            Intrinsics.checkNotNullParameter(r5, "callBack");
            if (ForsetiHelper.s(r6) == true) goto L21;
        L24:
            LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, PageEditPlugin.TAG, r11);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r18, r11) == false) goto L50;
        L29:
            r18.n = r5;
        L42:
            r16.setFragment(r18);
            Fragment r19 = this.a.getFragment();
            if (r19 == null) goto L55;
            Lifecycle r110 = r19.getLifecycle();
            if (r110 == null) goto L56;
            final PageEditPlugin r20 = this.a;
            r110.addObserver(new PageEditPlugin$PageEditManageCollaborator$handle$3(r20));
            return;
        L56:
            return;
        L55:
            return;
        L50:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
        L28:
            r18.show(r10, PageEditPlugin.TAG);
            goto L29
        L21:
            if (((Boolean) ForsetiHelper.n.getValue()).booleanValue() == false) goto L24;
            if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r18, r6, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false, 0, true, 28) == true) goto L29;
        L30:
            int r21 = RemoveMemberFragment.q;
            UserSession r22 = this.a.getHost().getUserComponent().b();
            ArrayList<UserInfo> r111 = r14.getData();
            Intrinsics.checkNotNullParameter(r22, "userSession");
            Bundle r23 = new Bundle();
            r23.putSerializable("DATA_SOURCE", r111);
            PassportcConvention.h(r23, r22);
            r18 = new RemoveMemberFragment();
            r18.setArguments(r23);
            FragmentManager r24 = PageEditPlugin.access$getUIContainer(this.a).getFragmentManager();
            Intrinsics.checkNotNullParameter(r24, "manager");
            Intrinsics.checkNotNullParameter(PageEditPlugin.TAG, "tag");
            Intrinsics.checkNotNullParameter(r5, "callBack");
            if (ForsetiHelper.s(r6) == true) goto L33;
        L36:
            LandscapeRestrictionOperation r26 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, PageEditPlugin.TAG, r26);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r24, r18, r26) == false) goto L52;
        L41:
            r18.k = r5;
            goto L42
        L52:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
        L40:
            r18.show(r24, PageEditPlugin.TAG);
            goto L41
        L33:
            if (((Boolean) ForsetiHelper.n.getValue()).booleanValue() == false) goto L36;
            if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r18, r6, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false, 0, true, 28) == true) goto L41;
        L12:
            if (r2.isAdded() != true) goto L14;
            r1 = true;
            goto L14
        L57:
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final BaseUnspecifiedOrientationPlugin<?> getBaseUnspecifiedOrientationPlugin() {
        if (this.orientationPlugin != null) goto L6;
        this.orientationPlugin = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
    L6:
        return this.orientationPlugin;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        Fragment r0 = this.fragment;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isAdded() != true) goto L9;
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

    public static final /* synthetic */ BaseUnspecifiedOrientationPlugin access$getBaseUnspecifiedOrientationPlugin(PageEditPlugin r0) {
        return r0.getBaseUnspecifiedOrientationPlugin();
    }

    public static final /* synthetic */ t access$getUIContainer(PageEditPlugin r0) {
        return r0.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_DOCS_DOC_INFO_EDITOR_CLICK, new b(this));
    }

    public final void setFragment(Fragment r1) {
        this.fragment = r1;
    }

    public final void setOrientationPlugin(BaseUnspecifiedOrientationPlugin<?> r1) {
        this.orientationPlugin = r1;
    }
}

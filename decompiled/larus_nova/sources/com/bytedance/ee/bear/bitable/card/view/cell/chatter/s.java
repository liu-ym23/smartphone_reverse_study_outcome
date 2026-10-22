package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.core.usercomponent.compat.BitableSdkSenderCompat;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsRequest;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsResponse;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public class s extends f<GroupEntity> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f207619z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, String> f207620y;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final void D() {
        UDToast.show(this.f486397a, R.string.Bitable_ContentLimitReached_ErrorMsg, R.drawable.ud_icon_warning_outlined);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final String y() {
        return AtUtils.b(ArraysKt.toMutableList(com.bytedance.ee.bear.utils.a.f239815d));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final void C(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f207578w == true) goto L5;
    L12:
        kn4.f.a.f504223a.a(r100);
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L12;
        f<T>.e r101 = this.f207572q;
        if (r101 == null) goto L11;
        r101.c();
    L11:
        ArrayList r102 = new ArrayList();
        GetRecentVisitTargetsRequest.IncludeItem.GroupChatConfig r103 = new GetRecentVisitTargetsRequest.IncludeItem.GroupChatConfig.Builder().tenant_condition(GetRecentVisitTargetsRequest.TenantCondition.ALL_TENANT).shield_type_condition(GetRecentVisitTargetsRequest.ShieldTypeCondition.ALL).group_chat_type_condition(GetRecentVisitTargetsRequest.GroupChatTypeCondition.ALL_CHAT).public_type_condition(GetRecentVisitTargetsRequest.PublicTypeCondition.ALL_STATUS).build();
        GetRecentVisitTargetsRequest.IncludeItem r104 = new GetRecentVisitTargetsRequest.IncludeItem.Builder().group_chat_configs(r103).build();
        Intrinsics.checkNotNull(r104);
        r102.add(r104);
        GetRecentVisitTargetsRequest.Builder r105 = new GetRecentVisitTargetsRequest.Builder().limit(60).include_items(r102);
        IGetDataCallback<GetRecentVisitTargetsResponse> r106 = new MentionGroupSelectPanel$getRecentVisitGroup$callback$1(this);
        tt5.a.h("GroupSelectPresenter", "getRecentVisitGroup>>>");
        Command r107 = Command.GET_RECENT_VISIT_TARGETS;
        Intrinsics.checkNotNull(r105);
        BitableSdkSenderCompat.a(r107, r105, r106, GetRecentVisitTargetsResponse.ADAPTER);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final IChatterEntity x(AtObject r100) {
        Intrinsics.checkNotNullParameter(r100, "atObj");
        if (r100.isJoinChat() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GroupEntity(r100.getId(), r100.getName(), r100.getAvatar_url(), null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ee.bear.bitable.card.view.cell.chatter.MentionGroupSelectPanel$afterChatterSelected$1$1] */
    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final void w(IChatterEntity r110, final Function0 r111, final boolean r112) {
        final GroupEntity r100 = (GroupEntity) r110;
        Intrinsics.checkNotNullParameter(r111, "action");
        if (r100 != 0) goto L5;
    L18:
        StringBuilder r113 = new StringBuilder("afterChatterSelected>>> return. entityIsNull:");
        if (r100 != 0) goto L21;
        boolean r101 = true;
    L22:
        r113.append(r101);
        tt5.a.h("GroupSelectPresenter", r113.toString());
        r111.invoke();
        return;
    L21:
        r101 = false;
        goto L22
    L5:
        if (TextUtils.isEmpty(r100.getLinkToken()) == false) goto L18;
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        if (this.f207620y.containsKey(r100.getId()) == false) goto L13;
        tt5.a.h("GroupSelectPresenter", "afterChatterSelected>>> use cache");
        String r114 = (String) ((LinkedHashMap) this.f207620y).get(r100.getId());
        ?? r115 = r114;
        if (r114 != null) goto L12;
        r115 = "";
    L12:
        r102.element = r115;
        r100.setLinkToken(r115);
        Unit r116 = (Unit) r111.invoke();
        return;
    L13:
        final String r103 = r100.getId();
        if (r103 == null) goto L25;
        tt5.a.h("GroupSelectPresenter", "afterChatterSelected>>> getGroupChatLinkToken async: " + r112);
        ((com.bytedance.ee.bear.lark.dependency.n) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.n.class, null, null, 6)).o(r103, new MentionGroupSelectPanel$afterChatterSelected$1$1(r102, this, r103, r100, r112, r111));
        if (r112 == false) goto L26;
        r111.invoke();
        return;
    L26:
        return;
    }

    public s(Context r110, FragmentActivity r111, String r112, int r113, boolean r114, BitableAnalytic r115, View.OnClickListener r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r112, "token");
        super(r110, r111, r112, r113, false, false, false, r114);
        this.f207620y = new LinkedHashMap();
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.field.group.new_edit_panel");
        this.f207578w = r100;
        int r101 = 0;
        if (r210 == null) goto L5;
        boolean r102 = true;
    L7:
        if (r100 == false) goto L14;
        if (r102 == false) goto L14;
        f<T>.e r103 = this.f207572q;
        if (r103 == null) goto L21;
        RecyclerView r104 = r103.f207589h;
        if (r104 == null) goto L21;
        r104.setPadding(0, y9c.d.d(r110, R.dimen.space_kit_len_16), 0, y9c.d.d(r110, R.dimen.space_kit_len_16));
    L21:
        if (r114 == false) goto L27;
        f<T>.e r105 = this.f207572q;
        if (r105 == null) goto L27;
        SuggestChatterAdapter<T> r106 = r105.f207597p;
        if (r106 == 0) goto L27;
        r106.f207554h = new o(r110, this);
    L27:
        f<T>.e r107 = this.f207572q;
        if (r107 == null) goto L32;
        SelectedChatterAdapter<T> r108 = r107.f207598q;
        if (r108 == 0) goto L32;
        r108.f207543e = r114;
        r108.f207542d = new p(r110);
    L32:
        if (r107 == null) goto L42;
        SuggestChatterAdapter<T> r109 = r107.f207597p;
        f<T> r116 = r107.f207601t;
        r109.f207551e = r116.f207578w;
        r107.f207583b.h(r116.f486397a.getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.text_link_hover));
        View r117 = r107.f207585d;
        if (r102 == true) goto L36;
    L40:
        r101 = 8;
    L41:
        r117.setVisibility(r101);
        goto L42
    L36:
        if (r107.f207601t.f207578w == false) goto L40;
        if (com.bytedance.ee.bear.bitable.c.w() == true) goto L40;
    L42:
        f<T>.e r118 = this.f207572q;
        if (r118 == null) goto L49;
        q r119 = new q(r210, this);
        if (r118.f207601t.f207578w == false) goto L49;
        r118.f207586e.setOnClickListener(r119);
        f<T> r120 = r118.f207601t;
        f.a r121 = r120.f207573r;
        if (r121 == null) goto L49;
        r121.a("add_group", Boolean.valueOf(r120.f207576u), null);
    L49:
        this.f207573r = new r(r115);
        return;
    L14:
        f<T>.e r122 = this.f207572q;
        if (r122 == null) goto L21;
        View r123 = r122.f207584c;
        if (r123 == null) goto L21;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L21;
        int r125 = y9c.d.d(r110, R.dimen.space_kit_len_16);
        ((LinearLayout.LayoutParams) r124).topMargin = r125;
        goto L21
    L5:
        r102 = false;
        goto L7
    }
}

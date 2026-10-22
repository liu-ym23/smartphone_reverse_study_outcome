package nt0;

import am2.n;
import am2.x;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.GroupInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WallBg;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.d;
import com.bytedance.android.live.profile.ui.base.e;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends com.bytedance.android.live.profile.ui.base.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f520453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f520454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f520455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f520456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f520457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f520458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f520459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f520460i;

    /* JADX INFO: renamed from: nt0.a$a, reason: collision with other inner class name */
    public static final class C6971a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        d r100 = this.f86336a;
        if (r100 == null) goto L6;
        r100.removeView(this.f520453b);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.a, com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.LocalLifeGroupShop.INSTANCE;
    }

    public a(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f520460i = r100;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(d r100) {
        ALogger.i("ProfileLocalLifeGroupShopComponent", "ProfileLocalLifeGroupShopComponent initView");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        e r101 = (e) r100;
        View r102 = r101.b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_LOCAL_LIFE, true);
    L6:
        if (r102 == null) goto L14;
        this.f520453b = (ViewGroup) r102.findViewById(R.id.root);
        TextView r103 = (TextView) r102.findViewById(R.id.shop_name);
        this.f520454c = r103;
        if (r103 == null) goto L12;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L12;
        r104.setFakeBoldText(true);
    L12:
        this.f520455d = (TextView) r102.findViewById(R.id.shop_goods_count);
        this.f520456e = r102.findViewById(R.id.shop_divider);
        this.f520457f = (TextView) r102.findViewById(R.id.shop_sale_count);
        this.f520458g = (HSImageView) r102.findViewById(R.id.right_bg_icon);
        this.f520459h = (HSImageView) r102.findViewById(R.id.shop_icon);
        return;
    L14:
        return;
    L5:
        r102 = ((e) r100).f(R.layout.ttlive_profile_v3_local_life_group_shop_layout, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        if (i.k(this.f520460i) == true) goto L89;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("enter_from", "livebroadcasting");
        r101.put("enter_method", "personal_card");
        GroupInfo r102 = r100.groupInfo;
        boolean r103 = true;
        String r104 = "0";
        if (r102 != null) goto L7;
    L9:
        Object r105 = "1";
    L10:
        r101.put("showcase_type", r105);
        IMiddlewareUserService r106 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        List<py.k> r107 = null;
        if (r106 == null) goto L15;
        com.bytedance.android.livesdk.user.e r108 = r106.user();
        if (r108 == null) goto L15;
        String r109 = r108.n();
    L17:
        if (Intrinsics.areEqual(r109, this.f520460i.getRoom().getOwnerUserIdStr()) == false) goto L19;
        r104 = "1";
    L19:
        r101.put(IPerformanceManager.Params.is_anchor, r104);
        j0.l().h("life_showcase_entrance_show", r101, new Object[]{IRoom.class, x.class});
        GroupInfo r110 = r100.groupInfo;
        if (r110 == null) goto L24;
        GroupInfo.GroupHeaderInfo r111 = r110.getGroupHeaderInfo();
        if (r111 == null) goto L24;
        r107 = r111.getIcons();
    L24:
        List<py.k> r112 = r107;
        if (r112 != null) goto L27;
    L30:
        if (r103 == true) goto L89;
        LinkedHashMap r113 = new LinkedHashMap();
        Map<String, String> r114 = j0.l().c(x.class).getMap();
        String r115 = "";
        if (r114 == null) goto L36;
        String r116 = r114.get("enter_from_merge");
        if (r116 == null) goto L36;
    L37:
        r113.put("enter_from_merge", r116);
        if (r114 == null) goto L41;
        String r117 = r114.get("enter_method");
        if (r117 == null) goto L41;
    L42:
        r113.put("enter_method", r117);
        if (r114 == null) goto L46;
        String r118 = r114.get("action_type");
        if (r118 == null) goto L46;
    L47:
        r113.put("action_type", r118);
        if (r114 == null) goto L51;
        String r119 = r114.get("video_id");
        if (r119 == null) goto L51;
    L52:
        r113.put("video_id", r119);
        Map<String, String> r120 = j0.l().c(IRoom.class).getMap();
        if (r120 == null) goto L56;
        String r121 = r120.get("anchor_id");
        if (r121 == null) goto L56;
    L57:
        r113.put("anchor_id", r121);
        if (r120 == null) goto L61;
        String r122 = r120.get("room_id");
        if (r122 == null) goto L61;
    L62:
        r113.put("room_id", r122);
        if (r120 == null) goto L66;
        String r123 = r120.get("request_id");
        if (r123 == null) goto L66;
    L67:
        r113.put("request_id", r123);
        if (r120 == null) goto L71;
        String r124 = r120.get("log_pb");
        if (r124 == null) goto L71;
    L72:
        r113.put("log_pb", r124);
        if (r120 == null) goto L76;
        String r125 = r120.get("is_life");
        if (r125 == null) goto L76;
    L77:
        r113.put("is_life", r125);
        Map<String, String> r126 = j0.l().c(n.class).getMap();
        if (r126 == null) goto L83;
        String r127 = r126.get("is_other_channel");
        if (r127 == null) goto L83;
        r115 = r127;
    L83:
        r113.put("is_other_channel", r115);
        GroupInfo r128 = r100.groupInfo;
        if (r128 == null) goto L88;
        Map<String, String> r129 = r128.getBuryPoint();
        if (r129 == null) goto L88;
        r113.putAll(r129);
    L88:
        os0.b.c().getIHostLiveLocalLife().d(r113);
    L76:
        r125 = "";
    L71:
        r124 = "";
    L66:
        r123 = "";
    L61:
        r122 = "";
    L56:
        r121 = "";
    L51:
        r119 = "";
    L46:
        r118 = "";
    L41:
        r117 = "";
    L36:
        r116 = "";
        goto L37
    L27:
        if (r112.isEmpty() == true) goto L30;
        r103 = false;
    L15:
        r109 = null;
        goto L17
    L7:
        if (r102.getGroupType() != 1) goto L9;
        r105 = "0";
    L89:
        this.f520460i.recordBusinessShow(TrackArea.BottomOperatingArea, "local_life");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        GroupInfo r101 = r100.groupInfo;
        if (r101 != null) goto L5;
        ALogger.e("ProfileLocalLifeGroupShopComponent", "ProfileLocalLifeGroupShopComponent bindUserData, but groupInfo is null");
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        WallBg r102 = r101.getGroupWallBg();
        boolean r103 = true;
        List<py.k> r104 = null;
        if (r102 == null) goto L43;
        String r105 = r102.getGradientStart();
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L43;
        String r107 = r102.getGradientEnd();
        if (r107 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == true) goto L43;
        int r109 = Color.parseColor(r102.getGradientEnd());     // Catch: Exception -> L41
        int r110 = Color.parseColor(r102.getGradientEnd());     // Catch: Exception -> L41
        ViewGroup r111 = this.f520453b;     // Catch: Exception -> L41
        if (r111 == null) goto L30;
        Drawable r112 = r111.getBackground();     // Catch: Exception -> L41
    L32:
        if ((r112 instanceof GradientDrawable) == true) goto L34;
        r112 = null;
    L34:
        GradientDrawable r113 = (GradientDrawable) r112;     // Catch: Exception -> L41
        if (r113 == null) goto L43;
        r113.mutate();     // Catch: Exception -> L41
        r113.setShape(0);     // Catch: Exception -> L41
        r113.setGradientType(0);     // Catch: Exception -> L41
        r113.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L41
        r113.setColors(new int[]{r109, r110});     // Catch: Exception -> L41
        ViewGroup r114 = this.f520453b;     // Catch: Exception -> L41
        if (r114 == null) goto L43;
        r114.setBackground(r113);     // Catch: Exception -> L41
        goto L43
    L30:
        r112 = null;
    L41:
        e = move-exception;
        ALogger.e("ProfileLocalLifeGroupShopComponent", "paint background error: " + e.getMessage());
        goto L43
    L21:
        if (r107.length() == 0) goto L24;
        r108 = false;
        goto L25
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
    L43:
        WallBg r115 = r101.getGroupWallBg();
        if (r115 == null) goto L58;
        py.k r116 = r115.getIcon();
        if (r116 == null) goto L58;
        HSImageView r117 = this.f520458g;
        if (r117 == null) goto L51;
        r117.setVisibility(0);
    L51:
        HSImageView r118 = this.f520458g;
        if (r118 == null) goto L54;
        a1.p(r118, UtilityKotlinExtentionsKt.i(r116.getWidth()));
    L54:
        HSImageView r119 = this.f520458g;
        if (r119 == null) goto L57;
        a1.k(r119, UtilityKotlinExtentionsKt.i(r116.getHeight()));
    L57:
        ImageLoader.bindImage(this.f520458g, r116);
    L58:
        GroupInfo.GroupHeaderInfo r120 = r101.getGroupHeaderInfo();
        if (r120 == null) goto L84;
        TextView r121 = this.f520454c;
        if (r121 == null) goto L64;
        r121.setText(r120.getName());
    L64:
        TextView r122 = this.f520455d;
        if (r122 == null) goto L67;
        r122.setText(r120.getGoods());
    L67:
        String r123 = r120.getSale();
        if (r123 != null) goto L70;
    L73:
        boolean r124 = true;
    L74:
        if (r124 == true) goto L84;
        View r125 = this.f520456e;
        if (r125 == null) goto L78;
        r125.setVisibility(0);
    L78:
        TextView r126 = this.f520457f;
        if (r126 == null) goto L81;
        r126.setVisibility(0);
    L81:
        TextView r127 = this.f520457f;
        if (r127 == null) goto L84;
        r127.setText(r120.getSale());
        goto L84
    L70:
        if (r123.length() == 0) goto L73;
        r124 = false;
    L84:
        int r128 = m.f86955a;
        m.e(this.f520454c, r101.getTitleColor());
        ViewGroup r129 = this.f520453b;
        if (r129 == null) goto L87;
        View r130 = r129.findViewById(R.id.shop_right_enter);
    L88:
        m.e(r130, r101.getTitleColor());
        ViewGroup r131 = this.f520453b;
        if (r131 == null) goto L91;
        View r132 = r131.findViewById(R.id.shop_info);
    L92:
        m.e(r132, r101.getContentColor());
        ViewGroup r133 = this.f520453b;
        if (r133 == null) goto L95;
        r133.setOnClickListener(new b(this, r101));
    L95:
        GroupInfo.GroupHeaderInfo r134 = r101.getGroupHeaderInfo();
        if (r134 == null) goto L98;
        r104 = r134.getIcons();
    L98:
        List<py.k> r135 = r104;
        if (r135 != null) goto L101;
    L104:
        if (r103 == false) goto L108;
        HSImageView r136 = this.f520459h;
        if (r136 == null) goto L115;
        r136.setVisibility(8);
        return;
    L115:
        return;
    L108:
        HSImageView r137 = this.f520459h;
        if (r137 == null) goto L111;
        r137.setVisibility(0);
    L111:
        ImageLoader.bindImage(this.f520459h, (py.k) ListProtector.get(r104, 0));
        return;
    L101:
        if (r135.isEmpty() == true) goto L104;
        r103 = false;
        goto L104
    L91:
        r132 = null;
        goto L92
    L87:
        r130 = null;
        goto L88
    }

    @Override // com.bytedance.android.live.profile.ui.base.a, com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ViewGroup r101 = this.f520453b;
        if (r101 == null) goto L5;
        r101.setBackgroundResource(R.drawable.ttlive_bg_local_life_group_shop_component);
    L5:
        HSImageView r102 = this.f520458g;
        if (r102 == null) goto L8;
        m.b(r102);
    L8:
        HSImageView r103 = this.f520458g;
        if (r103 == null) goto L11;
        r103.setVisibility(8);
    L11:
        View r104 = this.f520456e;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        TextView r105 = this.f520457f;
        if (r105 == null) goto L17;
        r105.setVisibility(8);
    L17:
        g(r100);
    }

    public final void j(GroupInfo r110, Uri.Builder r111) {
        boolean r100 = true;
        if (r110.getGroupType() != 1) goto L35;
        IMiddlewareHostAction r112 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r112 == null) goto L7;
        String r113 = r112.getNativeItem("spu_detail_list_sort");
    L9:
        if (r113 != null) goto L11;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == false) goto L33;
        return;
    L33:
        String r114 = new JSONObject(r113).optString(this.f520460i.getTargetUser().baseProfileInfo.getIdStr(), "");     // Catch: Exception -> L30
        if (r114 != null) goto L20;
    L23:
        if (r100 == false) goto L25;
        return;
    L25:
        JSONObject r102 = new JSONObject(r114);     // Catch: Exception -> L30
        if (System.currentTimeMillis() <= CastLongProtector.parseLong(r102.optString("expire", "0"))) goto L28;
        return;
    L28:
        r111.appendQueryParameter("spu_list_order_by", r102.optString("spu_list_order_by", ""));     // Catch: Exception -> L30
        r111.appendQueryParameter("spu_list_order_type", r102.optString("spu_list_order_type", ""));     // Catch: Exception -> L30
        return;
    L20:
        if (r114.length() == 0) goto L23;
        r100 = false;
    L30:
        e = move-exception;
        SafetyGuard.a(null, e, "ProfileLocalLifeGroupShopComponent: parse sort info error");
        return;
    L11:
        if (r113.length() == 0) goto L14;
        r101 = false;
        goto L15
    L7:
        r113 = null;
        goto L9
    }
}

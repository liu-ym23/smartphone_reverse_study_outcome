package com.bytedance.ee.bear.bitable.homepage.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.widgets.universedesign.SimpleTagTextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.text.StringEscapeUtils;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B<\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012#\u0010\u0006\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0014J\u0006\u0010\u0019\u001a\u00020\bJ \u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u001fH\u0002J \u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001fH\u0002J\u0018\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bJ\u0018\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R.\u0010\u0006\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableMessageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/HomePageData;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/ViewHolder;", "isTab", "", "openProfile", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "userId", "", "clickItemListener", "Lcom/bytedance/ee/bear/bitable/homepage/activity/Listener;", "<init>", "(ZLkotlin/jvm/functions/Function1;Lcom/bytedance/ee/bear/bitable/homepage/activity/Listener;)V", "()Z", "getOpenProfile", "()Lkotlin/jvm/functions/Function1;", "getClickItemListener", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/Listener;", "convert", "helper", MapController.ITEM_LAYER_TAG, "getUserId", "getContentText", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "contentBean", "Lcom/bytedance/ee/bear/bitable/homepage/activity/Content;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeInfo;", "setReactionIcon", "replaceFileName", "originText", "url", "fileName", "getTargetContent", "buildAt", "userName", "buildBitableLink", "getTime", "time", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMessageAdapter extends BaseQuickAdapter<HomePageData, ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f212268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f212269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f212270c;

    public static final class a {
    }

    static {
    }

    public static String y2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        return "<at type=\"0\" href=\"\" token=\"" + r101 + "\">@" + r100 + "</at>";
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, HomePageData r111) {
        ViewHolder r100 = (ViewHolder) r110;
        HomePageData r101 = r111;
        Intrinsics.checkNotNullParameter(r100, "helper");
        ViewGroup.LayoutParams r102 = r100.f212294a.getLayoutParams();
        String r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L7:
        if (r104 != null) goto L9;
    L13:
        if (r104 != null) goto L15;
    L19:
        r100.f212294a.setLayoutParams(r104);
        UDAvatar r105 = r100.f212294a;
        if (this.f212268a == false) goto L22;
        int r106 = -2;
    L23:
        r105.setAvatarSize(r106);
        r100.f212295b.setTypeface(Typeface.defaultFromStyle(!this.f212268a ? 1 : 0));
        CommentTextView r107 = r100.f212297d;
        if (this.f212268a == false) goto L26;
        int r108 = 1;
    L27:
        r107.setMaxLines(r108);
        CommentTextView r109 = r100.f212297d;
        Resources r112 = this.mContext.getResources();
        if (this.f212268a == false) goto L30;
        int r113 = R.color.text_caption;
    L31:
        r109.setTextColor(r112.getColor(r113));
        ViewGroup.LayoutParams r114 = r100.f212303j.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
    L35:
        if (r115 != null) goto L37;
    L41:
        if (r115 == null) goto L48;
        if (this.f212268a == false) goto L45;
        int r116 = y9c.d.a(8);
    L46:
        r115.bottomMargin = r116;
        goto L48
    L45:
        r116 = y9c.d.a(12);
    L48:
        if (r115 != null) goto L50;
    L54:
        r100.f212303j.setLayoutParams(r115);
        if (r101 == null) goto L302;
        CardInfo r117 = r101.getCardInfo();
        NoticeInfo r118 = r101.getNoticeInfo();
        r100.itemView.setOnClickListener(new b(this, r101));
        if (r101.getMessageType() != 0) goto L59;
        r100.f212294a.setBackgroundColor(this.mContext.getResources().getColor(R.color.ud_B100));
        r100.f212294a.setScaleType(ImageView.ScaleType.CENTER);
    L61:
        if (r101.getMessageType() != 0) goto L68;
        UDAvatar r119 = r100.f212294a;
        Context r120 = this.mContext;
        int r121 = r120.getResources().getColor(R.color.primary_fill_default);
        if (this.f212268a == false) goto L65;
        float r122 = 20.0f;
    L66:
        r119.setImageDrawable(UDIconUtils.getIconDrawable(r120, R.drawable.ud_icon_robot_filled, r121, new UDDimension.Dp(r122)));
        r100.f212295b.setText(this.mContext.getString(R.string.Bitable_Workspace_BaseTeamGreeting_Title));
        r100.f212297d.setText(this.mContext.getString(R.string.Bitable_Workspace_BaseTeamGreeting_Description));
        r100.f212296c.setVisibility(8);
        r100.f212298e.setVisibility(8);
        r100.f212299f.setVisibility(8);
        r100.f212300g.setVisibility(8);
        r100.f212301h.setVisibility(8);
        goto L302
    L65:
        r122 = 22.0f;
        goto L66
    L68:
        if (r101.getMessageType() != 1) goto L99;
        if (r117 == null) goto L99;
        CardSender r123 = r117.getSender();
        if (r123 == null) goto L73;
        String r124 = r123.getAvatarKey();
    L74:
        UDAvatar r125 = r100.f212294a;
        com.bytedance.ee.bear.share.export.UserInfo r126 = new com.bytedance.ee.bear.share.export.UserInfo();
        r126.setAvatarkey(r124);
        pg5.a.b(r125, r126);
        r100.f212294a.setOnClickListener(new c(this, r117));
        TextView r127 = r100.f212295b;
        if (r123 == null) goto L77;
        String r128 = r123.getName();
    L78:
        r127.setText(r128);
        SimpleTagTextView r129 = r100.f212296c;
        if (r123 == null) goto L81;
        String r130 = r123.getSenderType();
    L83:
        if (Intrinsics.areEqual(r130, "app") == false) goto L85;
        int r131 = 0;
    L86:
        r129.setVisibility(r131);
        r100.f212296c.x(this.mContext.getString(R.string.Bitable_Status_BotTag), UDTagsDrawable.TagColorSet.YELLOW);
        CardContent r132 = r117.parseContent();
        if (r132 == null) goto L90;
        r103 = r132.getTitle();
    L90:
        if (TextUtils.isEmpty(r103) == false) goto L92;
        String r133 = this.mContext.getString(R.string.Bitable_Workspace_MessageFromBot_Description);
    L93:
        r100.f212297d.setText(r133);
        r100.f212298e.setVisibility(8);
        r100.f212299f.setVisibility(0);
        TextView r134 = r100.f212299f;
        long r135 = r117.getNoticeTime();
        String r136 = zu5.a.b(r100.itemView.getContext(), r135);     // Catch: Exception -> L96
    L97:
        r134.setText(r136);
        r100.f212300g.setVisibility(8);
        r100.f212301h.setVisibility(8);
    L96:
        tt5.a.k("BitableMessageAdapter", "the time isn't right");
        r136 = String.valueOf(r135);
        goto L97
    L92:
        r133 = xo5.a.c(this.mContext, R.string.Bitable_Workspace_MessageFromBotWithTitle_Description, "title", r103);
        goto L93
    L85:
        r131 = 8;
        goto L86
    L81:
        r130 = null;
        goto L83
    L77:
        r128 = null;
        goto L78
    L73:
        r124 = null;
    L99:
        if (r101.getMessageType() != 2) goto L302;
        if (r118 == null) goto L302;
        UserInfo r137 = r118.getUserInfo();
        UDAvatar r138 = r100.f212294a;
        com.bytedance.ee.bear.share.export.UserInfo r139 = new com.bytedance.ee.bear.share.export.UserInfo();
        if (r137 == null) goto L104;
        String r140 = r137.getAvatarKey();
    L105:
        r139.setAvatarkey(r140);
        if (r137 == null) goto L108;
        String r141 = r137.getAvatarUrl();
    L109:
        r139.setAvatarUrl(r141);
        pg5.a.b(r138, r139);
        r100.f212294a.setOnClickListener(new d(this, r137));
        TextView r142 = r100.f212295b;
        if (r137 == null) goto L112;
        String r143 = r137.getUserName();
    L113:
        r142.setText(r143);
        r100.f212296c.setVisibility(8);
        CommentTextView r144 = r100.f212297d;
        AccountService$Account r145 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r145 == null) goto L116;
        String r146 = r145.uid;
    L117:
        String r147 = "";
        if (r146 == null) goto L120;
        String r148 = r145.uid;
        Intrinsics.checkNotNull(r148);
    L121:
        RichTextInjector.b(r144, CollectionsKt.listOf(r148), null, com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment_markdown_enable"), 8);
        if (TextUtils.isEmpty(r118.getObjName()) == true) goto L124;
        String r149 = r118.getObjName();
    L125:
        String r150 = r149;
        Context r151 = r100.itemView.getContext();
        String r152 = r151.getString(R.string.Bitable_Workspace_Notifications_ReceiveMessage_mobile);
        Content r153 = r118.parseContent();
        Integer r154 = r118.getNoticeStatus();
        if (r154 != null) goto L129;
    L181:
        Integer r155 = r118.getNoticeStatus();
        if (r155 != null) goto L185;
    L187:
        Integer r156 = r118.getNoticeStatus();
        if (r156 != null) goto L191;
    L221:
        Integer r157 = r118.getNoticeStatus();
        if (r157 != null) goto L225;
    L241:
        Integer r158 = r118.getNoticeStatus();
        if (r158 != null) goto L245;
    L247:
        Integer r159 = r118.getNoticeStatus();
        if (r159 != null) goto L251;
    L253:
        String r160 = r118.getObjUrl();
        if (StringsKt.indexOf$default(r152, "{{docName}}", 0, false, 6, null) < 0) goto L264;
        Intrinsics.checkNotNullParameter(r160, "url");
        Intrinsics.checkNotNullParameter(r150, "fileName");
        int r161 = sbb.e.f541298i.f541317b;
        String r162 = UriProtector.parse(r160).getLastPathSegment();     // Catch: Exception -> L261
        if (r162 == null) goto L263;
        r147 = r162;
    L263:
        r152 = StringsKt.replace$default(r152, "{{docName}}", "<at type=\"" + r161 + "\" href=\"" + r160 + "\" token=\"" + r147 + "\">" + r150 + "</at>", false, 4, null);
    L261:
        e = move-exception;
        tt5.a.e("BitableMessageAdapter", "parse err", e, false);
    L264:
        r100.f212297d.setRawString(r152);
        if (this.f212268a == true) goto L287;
        Integer r163 = r118.getNoticeType();
        if (r163 == null) goto L287;
        if (r163.intValue() != 6) goto L287;
        Integer r164 = r118.getNoticeStatus();
        if (r164 == null) goto L287;
        if (r164.intValue() != 0) goto L287;
        Content r165 = r118.parseContent();
        if (r165 == null) goto L279;
        String r166 = r165.getReactionKey();
    L281:
        if (TextUtils.isEmpty(r166) == true) goto L287;
        if (r166 == null) goto L284;
        Bitmap r167 = qsb.b.a().Hb(r166, false);
    L285:
        if (r167 == null) goto L287;
        r100.f212298e.setImageBitmap(r167);
        boolean r168 = true;
    L288:
        ImageView r169 = r100.f212298e;
        if (r168 == false) goto L291;
        int r170 = 0;
    L292:
        r169.setVisibility(r170);
        long r171 = r118.getNoticeTime();
        String r172 = zu5.a.b(r100.itemView.getContext(), r171);     // Catch: Exception -> L295
    L296:
        r100.f212300g.setVisibility(0);
        r100.f212300g.setImageResource(kac.a.b(R.drawable.ud_icon_file_link_bitable_outlined));
        r100.f212301h.setVisibility(0);
        r100.f212301h.setText(r150);
        String r173 = r172 + " · ";
        TextView r174 = r100.f212299f;
        if (TextUtils.isEmpty(r173) == true) goto L299;
        int r175 = 0;
    L300:
        r174.setVisibility(r175);
        r100.f212299f.setText(r173);
        goto L302
    L299:
        r175 = 8;
    L295:
        tt5.a.k("BitableMessageAdapter", "the time isn't right");
        r172 = String.valueOf(r171);
        goto L296
    L291:
        r170 = 8;
        goto L292
    L284:
        r167 = null;
        goto L285
    L279:
        r166 = null;
    L287:
        r168 = false;
        goto L288
    L251:
        if (r159.intValue() != 21) goto L253;
        r152 = r151.getString(R.string.Bitable_Workspace_emojiReactionRecalled_mobile);
        goto L253
    L245:
        if (r158.intValue() != 15) goto L247;
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_Notifications_ReopenComment_mobile, "content", z2(r151, r153, r118));
        goto L253
    L225:
        if (r157.intValue() != 13) goto L241;
        if (r153 == null) goto L228;
        String r176 = r153.getCommentOwnerName();
    L230:
        if (TextUtils.isEmpty(r176) == false) goto L233;
        if (r153 == null) goto L235;
        String r177 = r153.getCommentOwnerNameDefault();
    L236:
        if (r153 == null) goto L239;
        String r178 = r153.getCommentOwnerId();
        if (r178 == null) goto L239;
    L240:
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_emojiReactionResolved_mobile, "userName", y2(r177, r178));
    L239:
        r178 = "";
    L235:
        r177 = null;
        goto L236
    L233:
        if (r153 == null) goto L235;
        r177 = r153.getCommentOwnerName();
        goto L236
    L228:
        r176 = null;
        goto L230
    L191:
        if (r156.intValue() != 12) goto L221;
        String r179 = z2(r151, r153, r118);
        if (r153 == null) goto L195;
        String r180 = r153.getCommentOwnerName();
    L197:
        if (TextUtils.isEmpty(r180) == false) goto L200;
        if (r153 == null) goto L202;
        String r181 = r153.getCommentOwnerNameDefault();
    L204:
        if (TextUtils.isEmpty(r181) == false) goto L215;
        UserInfo r182 = r118.getUserInfo();
        if (r182 == null) goto L208;
        String r183 = r182.getUserName();
    L209:
        UserInfo r184 = r118.getUserInfo();
        if (r184 == null) goto L213;
        String r185 = r184.getUserId();
        if (r185 == null) goto L213;
    L214:
        String r186 = y2(r183, r185);
    L220:
        HashMap r187 = new HashMap();
        r187.put("userName", r186);
        r187.put("content", r179);
        r152 = xo5.a.d(r151, R.string.Bitable_Workspace_Notifications_UserCommentResolved_mobile, r187);
    L213:
        r185 = "";
        goto L214
    L208:
        r183 = null;
        goto L209
    L215:
        if (r153 == null) goto L218;
        String r188 = r153.getCommentOwnerId();
        if (r188 == null) goto L218;
    L219:
        r186 = y2(r181, r188);
    L218:
        r188 = "";
    L202:
        r181 = null;
        goto L204
    L200:
        if (r153 == null) goto L202;
        r181 = r153.getCommentOwnerName();
        goto L204
    L195:
        r180 = null;
        goto L197
    L185:
        if (r155.intValue() != 11) goto L187;
        r152 = r151.getString(R.string.Bitable_Workspace_Notifications_CommentDeleted_mobile);
        goto L253
    L129:
        if (r154.intValue() != 0) goto L181;
        Integer r189 = r118.getNoticeType();
        if (r189 != null) goto L134;
    L136:
        Integer r190 = r118.getNoticeType();
        if (r190 != null) goto L140;
    L142:
        Integer r191 = r118.getNoticeType();
        if (r191 != null) goto L146;
    L163:
        Integer r192 = r118.getNoticeType();
        if (r192 != null) goto L167;
    L169:
        Integer r193 = r118.getNoticeType();
        if (r193 != null) goto L173;
    L175:
        Integer r194 = r118.getNoticeType();
        if (r194 == null) goto L253;
        if (r194.intValue() != 6) goto L253;
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_Notifications_ReactToYourComment_mobile, "content", z2(r151, r153, r118));
        goto L253
    L173:
        if (r193.intValue() != 2001) goto L175;
        r152 = r151.getString(R.string.Bitable_Workspace_Notifications_mention_mobile);
        goto L253
    L167:
        if (r192.intValue() != 5) goto L169;
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_Notifications_ReopenComment_mobile, "content", z2(r151, r153, r118));
        goto L253
    L146:
        if (r191.intValue() != 4) goto L163;
        String r195 = z2(r151, r153, r118);
        if (r153 == null) goto L150;
        String r196 = r153.getCommentOwnerName();
    L152:
        if (TextUtils.isEmpty(r196) == false) goto L155;
        if (r153 == null) goto L157;
        String r197 = r153.getCommentOwnerNameDefault();
    L158:
        if (r153 == null) goto L161;
        String r198 = r153.getCommentOwnerId();
        if (r198 == null) goto L161;
    L162:
        String r199 = y2(r197, r198);
        HashMap r200 = new HashMap();
        r200.put("userName", r199);
        r200.put("content", r195);
        r152 = xo5.a.d(r151, R.string.Bitable_Workspace_Notifications_ResolveComment_mobile, r200);
    L161:
        r198 = "";
    L157:
        r197 = null;
        goto L158
    L155:
        if (r153 == null) goto L157;
        r197 = r153.getCommentOwnerName();
        goto L158
    L150:
        r196 = null;
        goto L152
    L140:
        if (r190.intValue() != 3) goto L142;
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_Common_Notifications_replyComment_mobile, "content", z2(r151, r153, r118));
        goto L253
    L134:
        if (r189.intValue() != 1) goto L136;
        r152 = xo5.a.c(r151, R.string.Bitable_Workspace_Notifications_comment_mobile, "content", z2(r151, r153, r118));
        goto L253
    L124:
        r149 = this.mContext.getString(R.string.Doc_Contract_UntitledBitable);
        goto L125
    L120:
        r148 = "";
        goto L121
    L116:
        r146 = null;
        goto L117
    L112:
        r143 = null;
        goto L113
    L108:
        r141 = null;
        goto L109
    L104:
        r140 = null;
        goto L105
    L59:
        r100.f212294a.setBackground(null);
        r100.f212294a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L302:
        if (this.f212268a == false) goto L311;
        r100.f212302i.setVisibility(8);
        return;
    L311:
        return;
    L50:
        if (this.f212268a == false) goto L52;
        int r1100 = y9c.d.a(5);
    L53:
        r115.setMarginEnd(r1100);
        goto L54
    L52:
        r1100 = y9c.d.a(20);
        goto L53
    L37:
        if (this.f212268a == false) goto L39;
        int r201 = y9c.d.a(8);
    L40:
        r115.topMargin = r201;
        goto L41
    L39:
        r201 = y9c.d.a(12);
        goto L40
    L34:
        r115 = null;
        goto L35
    L30:
        r113 = R.color.text_title;
        goto L31
    L26:
        r108 = 6;
        goto L27
    L22:
        r106 = y9c.d.a(44);
        goto L23
    L15:
        if (this.f212268a == false) goto L17;
        int r202 = y9c.d.a(8);
    L18:
        r104.bottomMargin = r202;
        goto L19
    L17:
        r202 = y9c.d.a(12);
        goto L18
    L9:
        if (this.f212268a == false) goto L11;
        int r203 = y9c.d.a(8);
    L12:
        r104.topMargin = r203;
        goto L13
    L11:
        r203 = y9c.d.a(12);
        goto L12
    L5:
        r104 = null;
        goto L7
    }

    public BitableMessageAdapter(boolean r100, Function1 r101, BitableMessageFragment.b r102) {
        Intrinsics.checkNotNullParameter(r101, "openProfile");
        Intrinsics.checkNotNullParameter(r102, "clickItemListener");
        super(R.layout.bitable_homepage_message_item);
        this.f212268a = r100;
        this.f212269b = r101;
        this.f212270c = r102;
    }

    public static String z2(Context r100, Content r101, NoticeInfo r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        StringBuilder r103 = new StringBuilder("");
        int r104 = 0;
        if (r101 != null) goto L5;
    L12:
        NoticeExtra r105 = r102.parseExtra();
        if (r105 == null) goto L17;
        ArrayList<String> r106 = r105.getImageList();
        if (r106 == null) goto L17;
        int r107 = r106.size();
    L18:
        if (r107 <= 0) goto L22;
    L19:
        if (r104 >= r107) goto L22;
        r103.append("[");
        r103.append(r100.getString(R.string.Doc_Document_ExportImage));
        r103.append("]");
        r104 = r104 + 1;
    L22:
        return r103.toString();
    L17:
        r107 = 0;
        goto L18
    L5:
        if (TextUtils.isEmpty(r101.getCommentContentFeed()) == false) goto L7;
        String r108 = r101.getCommentContentFeedDefault();
    L23:
        r103.append(StringEscapeUtils.unescapeXml(r108));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        tt5.a.e("BitableMessageAdapter", "parse exception", e, false);
        r103.append(r108);
        goto L12
    L7:
        r108 = r101.getCommentContentFeed();
        goto L23
    }
}

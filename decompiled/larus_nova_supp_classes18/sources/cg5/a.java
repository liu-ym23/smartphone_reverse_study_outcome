package cg5;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import eu5.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final HashMap<String, Context> a = null;
    public static final Map<String, Integer> b = null;

    static {
        a = new HashMap();
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("LarkCCM_Docs_Feed_VersionCompatibility", 2131889066), TuplesKt.to("LarkCCM_Notifications_commentDeleted_content", 2131889672), TuplesKt.to("LarkCCM_Notifications_CommentDeleted", 2131889659), TuplesKt.to("LarkCCM_Docs_CommentPerm_NotifNoPerm_Text", 2131888986), TuplesKt.to("LarkCCM_Docs_CommentPerm_AccessRemoved_Toast", 2131888971), TuplesKt.to("LarkCCM_Notifications_CommentResolved", 2131889660), TuplesKt.to("LarkCCM_Notifications_CommentResolved_toast", 2131889661), TuplesKt.to("LarkCCM_image_placeholder", 2131889953), TuplesKt.to("LarkCCM_Notifications_RepliedCommentSolved", 2131889667), TuplesKt.to("LarkCCM_Notifications_DocCommentResolved", 2131889662), TuplesKt.to("LarkCCM_Docs_OriginalTextDeleted_Toast", 2131889199), TuplesKt.to("LarkCCM_Notifications_ReactionRecalled", 2131889664), TuplesKt.to("LarkCCM_Notifications_ReactionCanceled_toast", 2131889663), TuplesKt.to("LarkCCM_Notifications_ResolveDocsComment_Desc", 2131889670), TuplesKt.to("LarkCCM_Common_Notifications_ResolveComment_Reopened_PC", 2131888909), TuplesKt.to("LarkCCM_Notifications_ReopenComment_Desc", 2131889665), TuplesKt.to("LarkCCM_Notifications_ReopenDocsComment_Desc", 2131889666), TuplesKt.to("LarkCCM_Common_Notifications_ReopenComment_Resolved_PC", 2131888908), TuplesKt.to("LarkCCM_Docs_Suggest_Delete_Title", 2131889273), TuplesKt.to("LarkCCM_Docs_Suggest_Replace_Title", 2131889285), TuplesKt.to("LarkCCM_Docs_Suggest_Format_Title", 2131889274), TuplesKt.to("LarkCCM_Docs_Suggest_Add_Title", 2131889270), TuplesKt.to("LarkCCM_GPE_Bold_Common", 2131889483), TuplesKt.to("LarkCCM_GPE_Italic_Common", 2131889497), TuplesKt.to("LarkCCM_GPE_Underline_Common", 2131889504), TuplesKt.to("LarkCCM_GPE_Strikethrough_Common", 2131889500), TuplesKt.to("LarkCCM_GPE_Bullet_Common", 2131889484), TuplesKt.to("LarkCCM_GPE_Ordered_Common", 2131889498), TuplesKt.to("LarkCCM_GPE_Todo_Common", 2131889503), TuplesKt.to("LarkCCM_GPE_Text_Common", 2131889502), TuplesKt.to("LarkCCM_GPE_Heading1_Common", 2131889487), TuplesKt.to("LarkCCM_GPE_Heading2_Common", 2131889488), TuplesKt.to("LarkCCM_GPE_Heading3_Common", 2131889489), TuplesKt.to("LarkCCM_GPE_Heading4_Common", 2131889490), TuplesKt.to("LarkCCM_GPE_Heading5_Common", 2131889491), TuplesKt.to("LarkCCM_GPE_Heading6_Common", 2131889492), TuplesKt.to("LarkCCM_GPE_Heading7_Common", 2131889493), TuplesKt.to("LarkCCM_GPE_Heading8_Common", 2131889494), TuplesKt.to("LarkCCM_GPE_Heading9_Common", 2131889495), TuplesKt.to("LarkCCM_GPE_InlineCode_Common", 2131889496), TuplesKt.to("LarkCCM_GPE_CodeBlock_Common", 2131889485), TuplesKt.to("LarkCCM_GPE_TextHighlight_Common", 2131889501), TuplesKt.to("LarkCCM_GPE_Background_Common", 2131889482), TuplesKt.to("LarkCCM_Docs_Suggest_ReplaceWith_Descrip", 2131889283), TuplesKt.to("LarkCCM_Docs_Suggest_UsersRejected_Title", 2131889293), TuplesKt.to("LarkCCM_Docs_Suggest_UsersAccepted_Title", 2131889292), TuplesKt.to("LarkCCM_Docs_Suggest_Accepted_Toast", 2131889269), TuplesKt.to("LarkCCM_Docs_Suggest_Rejected_Toast", 2131889282), TuplesKt.to("LarkCCM_Notifications_comment_content", 2131889673), TuplesKt.to("LarkCCM_Docs_PrivateComment_Added_Descrip", 2131889229), TuplesKt.to("LarkCCM_Notifications_ReplyToYourComment", 2131889668), TuplesKt.to("LarkCCM_Notifications_commentAll_content", 2131889671), TuplesKt.to("LarkCCM_Notifications_ResolveComment_Desc", 2131889669), TuplesKt.to("LarkCCM_Notifications_mention_content", 2131889674), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestAdded_Title", 2131889197), TuplesKt.to("LarkCCM_Docs_Suggestion_Title", 2131889294), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestAccepted_Title", 2131889196), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestRejected_Title", 2131889198), TuplesKt.to("LarkCCM_Notifications_reply_content", 2131889675), TuplesKt.to("LarkCCM_Docs_PrivateComment_Replied_Descrip", 2131889231), TuplesKt.to("LarkCCM_Docs_Comments_SyncBlock_Title", 2131889016), TuplesKt.to("LarkCCM_Feed_SharedDocWithYou", 2131889480), TuplesKt.to("LarkCCM_Docs_Suggest_ReplaceWith_New_Descrip", 2131889284), TuplesKt.to("LarkCCM_Docs_Suggest_UserRepliedSuggestion_Desc", 2131889291), TuplesKt.to("LarkCCM_Docs_Suggest_UserAcceptReponseToSuggest_Desc", 2131889287), TuplesKt.to("LarkCCM_Docs_Suggest_UserRejectReponseToSuggest_Desc", 2131889290), TuplesKt.to("LarkCCM_Docs_Suggest_UserReactToYourSuggest_Desc", 2131889289), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToSuggestAccepted_Desc", 2131889279), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToReplyAccepted_Desc", 2131889277), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToSuggestRejected_Desc", 2131889280), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToReplyRejected_Desc", 2131889278), TuplesKt.to("LarkCCM_Docs_Suggest_UserReactToYourCmt_Desc", 2131889288), TuplesKt.to("LarkCCM_Docs_Suggest_ChangeNumber_Text", 2131889271), TuplesKt.to("LarkCCM_Docs_Suggest_TaskStatus_Text", 2131889286), TuplesKt.to("LarkCCM_Docs_Notifications_DocsAiSugComputerOnly_Text", 2131889194), TuplesKt.to("LarkCCM_Docs_AiSugComputerOnly_Toast", 2131888943)});
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static String a(TextContext r12) {
        if (r12 != null) goto L5;
        return "";
    L5:
        List<TextContext.I18nData> r0 = r12.getI18nDatas();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        String r2 = r12.getText();
        List<TextContext.I18nData> r13 = r12.getI18nDatas();
        if (r13 == null) goto L70;
        Iterator<T> r14 = r13.iterator();
        String r3 = r2;
    L19:
        if (r14.hasNext() == false) goto L63;
        TextContext.I18nData r4 = (TextContext.I18nData) r14.next();
        String r5 = "{{" + r4.getKey() + "}}";
        Intrinsics.checkNotNullParameter(r4, "i18nData");
        Integer r6 = b.get(r4.getKey());
        if (r6 != null) goto L23;
        r6 = 2131889066;
    L23:
        String r7 = r4.getLang();
        if (r7 != null) goto L26;
        r7 = b.a.getResources().getConfiguration().locale.getLanguage();
    L26:
        Intrinsics.checkNotNull(r7);
        Application r8 = b.a;
        if (TextUtils.equals(r8.getResources().getConfiguration().locale.getLanguage(), r7) == false) goto L29;
        Intrinsics.checkNotNull(r8);
        Context r9 = r8;
    L36:
        List<TextContext.ReplaceInfo> r10 = r4.getReplaceMap();
        if (r10 != null) goto L39;
    L41:
        boolean r11 = false;
    L42:
        if (r11 == true) goto L45;
        String r15 = r9.getString(r6.intValue());
    L53:
        String r16 = r15;
    L61:
        r3 = StringsKt.replace$default(r3, r5, r16, false, 4, null);
        goto L19
    L45:
        if (r4.getType() != 1) goto L54;
        LinkedHashMap r17 = new LinkedHashMap();
        List<TextContext.ReplaceInfo> r18 = r4.getReplaceMap();
        if (r18 == null) goto L52;
        Iterator<T> r19 = r18.iterator();
    L50:
        if (r19.hasNext() == false) goto L52;
        TextContext.ReplaceInfo r20 = (TextContext.ReplaceInfo) r19.next();
        r17.put(r20.getKey(), r20.getValue());
    L52:
        r15 = xo5.a.d(r9, r6.intValue(), r17);
        goto L53
    L54:
        r16 = r9.getString(r6.intValue());
        List<TextContext.ReplaceInfo> r21 = r4.getReplaceMap();
        if (r21 == null) goto L61;
        Iterator<T> r22 = r21.iterator();
        String r23 = r16;
    L58:
        if (r22.hasNext() == false) goto L60;
        TextContext.ReplaceInfo r24 = (TextContext.ReplaceInfo) r22.next();
        r23 = StringsKt.replaceFirst$default(r23, r24.getKey(), r24.getValue(), false, 4, null);
        goto L58
    L60:
        r16 = r23;
        goto L61
    L39:
        if (r10.isEmpty() == true) goto L41;
        r11 = true;
        goto L42
    L29:
        HashMap<String, Context> r25 = a;
        if (r25.containsKey(r7) == false) goto L32;
        Context r26 = r25.get(r7);
    L33:
        if (r26 == null) goto L35;
        r9 = r26;
        goto L36
    L35:
        Configuration r27 = new Configuration(r8.getResources().getConfiguration());
        r27.setLocale(new Locale(r7));
        Context r28 = r8.createConfigurationContext(r27);
        NewMiraResourcesManager.getInstance().install(r28);
        r25.put(r7, r28);
        Intrinsics.checkNotNull(r28);
        r9 = r28;
        goto L36
    L32:
        r26 = null;
        goto L33
    L63:
        return r3;
    L70:
        return r2;
    L14:
        return r12.getText();
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }
}

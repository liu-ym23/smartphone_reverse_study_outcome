package gx9;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {
    static {
    }

    public static boolean a(PromptContent r110, PromptContent r111) {
        Intrinsics.checkNotNullParameter(r110, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r111, "second");
        if (r110 != r111) goto L6;
        return true;
    L6:
        if (r110.isNoDisappear() == r111.isNoDisappear()) goto L8;
    L74:
        return false;
    L8:
        if (r110.getSuggestActionCardCnt() != r111.getSuggestActionCardCnt()) goto L74;
        if (Intrinsics.areEqual(r110.getOnboardingDisplayStyle(), r111.getOnboardingDisplayStyle()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getSugType(), r111.getSugType()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getBusinessExt(), r111.getBusinessExt()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getWcbRenderStatus(), r111.getWcbRenderStatus()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getWcbTitle(), r111.getWcbTitle()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getWcbTitleStyle(), r111.getWcbTitleStyle()) == false) goto L74;
        if (Intrinsics.areEqual(r110.getSuggest(), r111.getSuggest()) == false) goto L74;
        List<PromptContent.SuggestV2> r100 = r110.getSuggestV2();
        List<PromptContent.SuggestV2> r101 = r111.getSuggestV2();
        if (r100 == r101) goto L68;
        if (r100 == null) goto L69;
        if (r101 == null) goto L69;
        if (r100.size() != r101.size()) goto L69;
        int r102 = r100.size();
        int r103 = 0;
    L32:
        if (r103 >= r102) goto L68;
        PromptContent.SuggestV2 r104 = (PromptContent.SuggestV2) ListProtector.get(r100, r103);
        PromptContent.SuggestV2 r105 = (PromptContent.SuggestV2) ListProtector.get(r101, r103);
        if (r104 == r105) goto L63;
        if (r104 == null) goto L64;
        if (r105 == null) goto L64;
        if (Intrinsics.areEqual(r104.getSuggestType(), r105.getSuggestType()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getContent(), r105.getContent()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getIconUrl(), r105.getIconUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getDarkIconUrl(), r105.getDarkIconUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getIconUri(), r105.getIconUri()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getFontColorLight(), r105.getFontColorLight()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getFontColorDark(), r105.getFontColorDark()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getStrokeColorLight(), r105.getStrokeColorLight()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getStrokeColorDark(), r105.getStrokeColorDark()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getClickUrl(), r105.getClickUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getBotId(), r105.getBotId()) == false) goto L64;
        if (Intrinsics.areEqual(r104.getExtra(), r105.getExtra()) == true) goto L63;
    L64:
        boolean r106 = false;
    L65:
        if (r106 == false) goto L69;
        r103 = r103 + 1;
    L63:
        r106 = true;
    L69:
        boolean r107 = false;
    L70:
        if (r107 == false) goto L74;
        if (b(r110.getSuggestItems(), r111.getSuggestItems()) == false) goto L74;
        return true;
    L68:
        r107 = true;
        goto L70
    }

    public static boolean b(List r100, List r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L87;
        if (r101 == null) goto L87;
        if (r100.size() != r101.size()) goto L87;
        int r102 = r100.size();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L86;
        PromptContent.SuggestItem r104 = (PromptContent.SuggestItem) ListProtector.get(r100, r103);
        PromptContent.SuggestItem r105 = (PromptContent.SuggestItem) ListProtector.get(r101, r103);
        if (r104 == r105) goto L81;
        if (r104 == null) goto L82;
        if (r105 == null) goto L82;
        if (Intrinsics.areEqual(r104.getSuggest(), r105.getSuggest()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getBgColor(), r105.getBgColor()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getDarkBgColor(), r105.getDarkBgColor()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getFontColorLight(), r105.getFontColorLight()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getFontColorDark(), r105.getFontColorDark()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getStrokeColorLight(), r105.getStrokeColorLight()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getStrokeColorDark(), r105.getStrokeColorDark()) == false) goto L82;
        if (Intrinsics.areEqual(r104.isHighlightPush(), r105.isHighlightPush()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getItemId(), r105.getItemId()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getItemType(), r105.getItemType()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getSendingContent(), r105.getSendingContent()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getSchema(), r105.getSchema()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getIconUrl(), r105.getIconUrl()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getDarkIconUrl(), r105.getDarkIconUrl()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getLightUrlItem(), r105.getLightUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getDarkUrlItem(), r105.getDarkUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getFrontLightUrlItem(), r105.getFrontLightUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getFrontDarkUrlItem(), r105.getFrontDarkUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getExpireTime(), r105.getExpireTime()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getWcbItem(), r105.getWcbItem()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getExtra(), r105.getExtra()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getQueryPassExtra(), r105.getQueryPassExtra()) == false) goto L82;
        if (r104.isRichText() != r105.isRichText()) goto L82;
        if (Intrinsics.areEqual(r104.getCandidateType(), r105.getCandidateType()) == false) goto L82;
        if (Intrinsics.areEqual(r104.isContinueAsk(), r105.isContinueAsk()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getTextIcon(), r105.getTextIcon()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getPosition(), r105.getPosition()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getDisplayRichTextContent(), r105.getDisplayRichTextContent()) == false) goto L82;
        if (Intrinsics.areEqual(r104.getSendRichTextContent(), r105.getSendRichTextContent()) == false) goto L82;
        if (b(r104.getChildCandidates(), r105.getChildCandidates()) == false) goto L82;
        if (Intrinsics.areEqual(r104.isCategoryCandidate(), r105.isCategoryCandidate()) == true) goto L81;
    L82:
        boolean r106 = false;
    L83:
        if (r106 == false) goto L84;
        r103 = r103 + 1;
        goto L12
    L84:
        return false;
    L81:
        r106 = true;
        goto L83
    L86:
        return true;
    L87:
        return false;
    }
}

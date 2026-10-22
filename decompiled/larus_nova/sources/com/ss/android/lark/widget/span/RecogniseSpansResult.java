package com.ss.android.lark.widget.span;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.card.audio.CardAudioInfo;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.myai_tool.MyAIToolsInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class RecogniseSpansResult implements Serializable {
    private List<AbbreviationInfo> abbreviationInfos;
    private final ArrayList<AlignInfo> alignInfos;
    private List<AtInfo> atSpanInfos;
    private ArrayList<AtUserGroupInfo> atUserGroupInfos;
    private ArrayList<CardAudioInfo> cardAudioInfos;
    private List<ChatInfo> chatSpanInfos;
    private List<CodeBlockV2Info> codeBlockV2Infos;
    private ArrayList<ColumnsInfo> columnsInfos;
    private List<EmojiconInfo> emojiInfos;
    private List<EmptyHolderInfo> emptyHolderInfos;
    private ArrayList<HRInfo> hrInfoList;
    private ArrayList<ImageGalleryInfo> imageGalleryInfos;
    private List<ImageInfo> imageInfos;
    private ArrayList<InlineCodeInfo> inlineCodeInfoList;
    private ArrayList<LabelInfo> labelInfos;
    private List<MediaInfo> mediaInfos;
    private List<MentionInfo> mentionInfos;
    private List<MyAIToolsInfo> myAIToolsInfos;
    private ArrayList<NumberTagInfo> numberTagInfos;
    private ArrayList<PersonInfo> personInfos;
    private List<PhoneInfo> phoneSpanInfos;
    private List<PrefixInfo> prefixInfos;
    private List<SpacingInfo> spacingInfos;
    private ArrayList<TableInfo> tableInfos;
    private List<TextStyleInfo> textStyleInfos;
    private List<UrlInfo> urlSpanInfos;

    public List<SpanInfo> getAllSpanInfos() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.urlSpanInfos);
        r100.addAll(this.atSpanInfos);
        r100.addAll(this.phoneSpanInfos);
        r100.addAll(this.chatSpanInfos);
        r100.addAll(this.textStyleInfos);
        r100.addAll(this.abbreviationInfos);
        r100.addAll(this.imageInfos);
        r100.addAll(this.spacingInfos);
        r100.addAll(this.mentionInfos);
        r100.addAll(this.mediaInfos);
        r100.addAll(this.emojiInfos);
        r100.addAll(this.prefixInfos);
        r100.addAll(this.emptyHolderInfos);
        r100.addAll(this.codeBlockV2Infos);
        r100.addAll(this.myAIToolsInfos);
        r100.addAll(this.labelInfos);
        r100.addAll(this.alignInfos);
        r100.addAll(this.hrInfoList);
        r100.addAll(this.inlineCodeInfoList);
        r100.addAll(this.tableInfos);
        r100.addAll(this.columnsInfos);
        r100.addAll(this.personInfos);
        r100.addAll(this.numberTagInfos);
        r100.addAll(this.cardAudioInfos);
        r100.addAll(this.atUserGroupInfos);
        r100.addAll(this.imageGalleryInfos);
        int r101 = r100.size();
    L3:
        r101 = r101 - 1;
        if (r101 <= (-1)) goto L9;
        if (ListProtector.get(r100, r101) != null) goto L3;
        ListProtector.remove(r100, r101);
        goto L3
    L9:
        Collections.sort(r100);
        return r100;
    }

    public List<AtInfo> getAtSpanInfos() {
        return this.atSpanInfos;
    }

    public List<ChatInfo> getChatSpanInfos() {
        return this.chatSpanInfos;
    }

    public List<EmojiconInfo> getEmojiInfos() {
        return this.emojiInfos;
    }

    public List<ImageInfo> getImageSpanInfos() {
        return this.imageInfos;
    }

    public List<MediaInfo> getMediaInfos() {
        return this.mediaInfos;
    }

    public List<MentionInfo> getMentionInfos() {
        return this.mentionInfos;
    }

    public List<PhoneInfo> getPhoneSpanInfos() {
        return this.phoneSpanInfos;
    }

    public List<TextStyleInfo> getTextStyleInfos() {
        return this.textStyleInfos;
    }

    public List<UrlInfo> getUrlSpanInfos() {
        return this.urlSpanInfos;
    }

    public void addAtSpanInfo(AtInfo r100) {
        this.atSpanInfos.add(r100);
    }

    public void addAtSpanInfos(List<AtInfo> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.atSpanInfos.addAll(r100);
    }

    public void addChatSpanInfos(List<ChatInfo> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.chatSpanInfos.addAll(r100);
    }

    public void addMentionSpanInfo(MentionInfo r100) {
        this.mentionInfos.add(r100);
    }

    public void addPhoneSpanInfo(PhoneInfo r100) {
        this.phoneSpanInfos.add(r100);
    }

    public void addPhoneSpanInfos(List<PhoneInfo> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.phoneSpanInfos.addAll(r100);
    }

    public void addTextStyleInfo(TextStyleInfo r100) {
        this.textStyleInfos.add(r100);
    }

    public void addUrlSpanInfo(UrlInfo r100) {
        this.urlSpanInfos.add(r100);
    }

    public void addUrlSpanInfos(List<UrlInfo> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.urlSpanInfos.addAll(r100);
    }

    public RecogniseSpansResult(List<UrlInfo> r100, List<AtInfo> r101, List<TextStyleInfo> r102, List<EmojiconInfo> r103) {
        this.alignInfos = new ArrayList();
        this.urlSpanInfos = new ArrayList();
        this.atSpanInfos = new ArrayList();
        this.phoneSpanInfos = new ArrayList();
        this.chatSpanInfos = new ArrayList();
        this.textStyleInfos = new ArrayList();
        this.abbreviationInfos = new ArrayList();
        this.imageInfos = new ArrayList();
        this.spacingInfos = new ArrayList();
        this.mentionInfos = new ArrayList();
        this.mediaInfos = new ArrayList();
        this.emojiInfos = new ArrayList();
        this.prefixInfos = new ArrayList();
        this.emptyHolderInfos = new ArrayList();
        this.codeBlockV2Infos = new ArrayList();
        this.myAIToolsInfos = new ArrayList();
        this.labelInfos = new ArrayList();
        this.hrInfoList = new ArrayList();
        this.inlineCodeInfoList = new ArrayList();
        this.tableInfos = new ArrayList();
        this.personInfos = new ArrayList();
        this.columnsInfos = new ArrayList();
        this.numberTagInfos = new ArrayList();
        this.cardAudioInfos = new ArrayList();
        this.atUserGroupInfos = new ArrayList();
        this.imageGalleryInfos = new ArrayList();
        this.urlSpanInfos = r100;
        this.atSpanInfos = r101;
        this.textStyleInfos = r102;
        this.emojiInfos = r103;
    }

    public RecogniseSpansResult(List<UrlInfo> r210, List<AtInfo> r310, List<PhoneInfo> r311, List<ChatInfo> r312, List<TextStyleInfo> r313, List<AbbreviationInfo> r314, List<ImageInfo> r315, List<SpacingInfo> r316, List<MentionInfo> r317) {
        this(r210, r310, r311, r312, r313, r314, r315, r316, r317, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    public RecogniseSpansResult(List<UrlInfo> r100, List<AtInfo> r101, List<PhoneInfo> r102, List<ChatInfo> r103, List<TextStyleInfo> r104, List<AbbreviationInfo> r110, List<ImageInfo> r111, List<SpacingInfo> r112, List<MentionInfo> r113, List<MediaInfo> r114, List<EmojiconInfo> r115, List<PrefixInfo> r116, List<EmptyHolderInfo> r117, List<CodeBlockV2Info> r118, List<MyAIToolsInfo> r119, List<LabelInfo> r210, List<AlignInfo> r211, List<HRInfo> r212, List<InlineCodeInfo> r213, List<TableInfo> r214, List<ColumnsInfo> r215, List<PersonInfo> r216, List<NumberTagInfo> r217, List<CardAudioInfo> r218, List<AtUserGroupInfo> r219, List<ImageGalleryInfo> r310) {
        ArrayList<AlignInfo> r105 = new ArrayList();
        this.alignInfos = r105;
        this.urlSpanInfos = new ArrayList();
        this.atSpanInfos = new ArrayList();
        this.phoneSpanInfos = new ArrayList();
        this.chatSpanInfos = new ArrayList();
        this.textStyleInfos = new ArrayList();
        this.abbreviationInfos = new ArrayList();
        this.imageInfos = new ArrayList();
        this.spacingInfos = new ArrayList();
        this.mentionInfos = new ArrayList();
        this.mediaInfos = new ArrayList();
        this.emojiInfos = new ArrayList();
        this.prefixInfos = new ArrayList();
        this.emptyHolderInfos = new ArrayList();
        this.codeBlockV2Infos = new ArrayList();
        this.myAIToolsInfos = new ArrayList();
        this.labelInfos = new ArrayList();
        this.hrInfoList = new ArrayList();
        this.inlineCodeInfoList = new ArrayList();
        this.tableInfos = new ArrayList();
        this.personInfos = new ArrayList();
        this.columnsInfos = new ArrayList();
        this.numberTagInfos = new ArrayList();
        this.cardAudioInfos = new ArrayList();
        this.atUserGroupInfos = new ArrayList();
        this.imageGalleryInfos = new ArrayList();
        this.urlSpanInfos.addAll(r100);
        this.atSpanInfos.addAll(r101);
        this.phoneSpanInfos.addAll(r102);
        this.chatSpanInfos.addAll(r103);
        this.textStyleInfos.addAll(r104);
        this.abbreviationInfos.addAll(r110);
        this.imageInfos.addAll(r111);
        this.spacingInfos.addAll(r112);
        this.mentionInfos.addAll(r113);
        this.mediaInfos.addAll(r114);
        this.emojiInfos.addAll(r115);
        this.prefixInfos.addAll(r116);
        this.emptyHolderInfos.addAll(r117);
        this.codeBlockV2Infos.addAll(r118);
        this.myAIToolsInfos.addAll(r119);
        this.labelInfos.addAll(r210);
        r105.addAll(r211);
        this.hrInfoList.addAll(r212);
        this.inlineCodeInfoList.addAll(r213);
        this.tableInfos.addAll(r214);
        this.columnsInfos.addAll(r215);
        this.personInfos.addAll(r216);
        this.numberTagInfos.addAll(r217);
        this.cardAudioInfos.addAll(r218);
        this.atUserGroupInfos.addAll(r219);
        this.imageGalleryInfos.addAll(r310);
    }
}

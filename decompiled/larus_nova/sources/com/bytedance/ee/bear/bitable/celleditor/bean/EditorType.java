package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Rating", "Phone", "Date", "Progress", ComposerHelper.CONFIG_LINK, "LinkTag", "Select", "Text", "Chatter", "Number", "Location", "Stage", "Attachment", "Barcode", "Url", "VoiceInput", "TextAiPolish", "Signature", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditorType extends Enum<EditorType> {
    public static final EditorType Attachment = null;
    public static final EditorType Barcode = null;
    public static final EditorType Chatter = null;
    public static final EditorType Date = null;
    public static final EditorType Link = null;
    public static final EditorType LinkTag = null;
    public static final EditorType Location = null;
    public static final EditorType Number = null;
    public static final EditorType Phone = null;
    public static final EditorType Progress = null;
    public static final EditorType Rating = null;
    public static final EditorType Select = null;
    public static final EditorType Signature = null;
    public static final EditorType Stage = null;
    public static final EditorType Text = null;
    public static final EditorType TextAiPolish = null;
    public static final EditorType Url = null;
    public static final EditorType VoiceInput = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditorType[] f209322a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209323b = null;
    private final String value;

    public static EnumEntries<EditorType> getEntries() {
        return f209323b;
    }

    static {
        EditorType r100 = new EditorType("Rating", 0, "rating");
        Rating = r100;
        EditorType r101 = new EditorType("Phone", 1, "phone");
        Phone = r101;
        EditorType r102 = new EditorType("Date", 2, "date");
        Date = r102;
        EditorType r103 = new EditorType("Progress", 3, "progress");
        Progress = r103;
        EditorType r104 = new EditorType(ComposerHelper.CONFIG_LINK, 4, "link");
        Link = r104;
        EditorType r105 = new EditorType("LinkTag", 5, "linkTag");
        LinkTag = r105;
        EditorType r110 = new EditorType("Select", 6, "select");
        Select = r110;
        EditorType r111 = new EditorType("Text", 7, "text");
        Text = r111;
        EditorType r112 = new EditorType("Chatter", 8, "chatter");
        Chatter = r112;
        EditorType r113 = new EditorType("Number", 9, "number");
        Number = r113;
        EditorType r114 = new EditorType("Location", 10, "location");
        Location = r114;
        EditorType r106 = new EditorType("Stage", 11, "stage");
        Stage = r106;
        EditorType r107 = new EditorType("Attachment", 12, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        Attachment = r107;
        EditorType r108 = new EditorType("Barcode", 13, "barcode");
        Barcode = r108;
        EditorType r109 = new EditorType("Url", 14, "url");
        Url = r109;
        EditorType r115 = new EditorType("VoiceInput", 15, "voiceInput");
        VoiceInput = r115;
        EditorType r116 = new EditorType("TextAiPolish", 16, "aiPolish");
        TextAiPolish = r116;
        EditorType r117 = new EditorType("Signature", 17, "signature");
        Signature = r117;
        EditorType[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117};
        f209322a = r118;
        f209323b = EnumEntriesKt.enumEntries(r118);
    }

    public static EditorType[] values() {
        return (EditorType[]) f209322a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EditorType valueOf(String r100) {
        return (EditorType) a.a(EditorType.class, r100);
    }

    public EditorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

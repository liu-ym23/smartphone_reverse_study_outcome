package com.larus.bot.impl.bean;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/bean/ContentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "NAME", "DESC", "PROLOGUE", "SUGGEST", "VOICE_ID", "LANGUAGE", "BOT_CATEGORY", CommonConstant.RETKEY.GENDER, "HEAD_IMG_PROMPT", "BG_IMG_PROMPT", "BIO", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentType extends Enum<ContentType> {
    public static final ContentType BG_IMG_PROMPT = null;
    public static final ContentType BIO = null;
    public static final ContentType BOT_CATEGORY = null;
    public static final a Companion = null;
    public static final ContentType DESC = null;
    public static final ContentType GENDER = null;
    public static final ContentType HEAD_IMG_PROMPT = null;
    public static final ContentType LANGUAGE = null;
    public static final ContentType NAME = null;
    public static final ContentType PROLOGUE = null;
    public static final ContentType SUGGEST = null;
    public static final ContentType UNKNOWN = null;
    public static final ContentType VOICE_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentType[] f317657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317658b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static ContentType a(String r100) {
            ContentType r101 = ContentType.NAME;
            if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L37;
            ContentType r102 = ContentType.DESC;
            if (Intrinsics.areEqual(r100, r102.getValue()) == true) goto L38;
            ContentType r103 = ContentType.PROLOGUE;
            if (Intrinsics.areEqual(r100, r103.getValue()) == true) goto L39;
            ContentType r104 = ContentType.SUGGEST;
            if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L40;
            ContentType r105 = ContentType.VOICE_ID;
            if (Intrinsics.areEqual(r100, r105.getValue()) == true) goto L41;
            ContentType r106 = ContentType.LANGUAGE;
            if (Intrinsics.areEqual(r100, r106.getValue()) == true) goto L42;
            ContentType r107 = ContentType.BOT_CATEGORY;
            if (Intrinsics.areEqual(r100, r107.getValue()) == true) goto L43;
            ContentType r108 = ContentType.GENDER;
            if (Intrinsics.areEqual(r100, r108.getValue()) == true) goto L44;
            ContentType r109 = ContentType.HEAD_IMG_PROMPT;
            if (Intrinsics.areEqual(r100, r109.getValue()) == true) goto L45;
            ContentType r110 = ContentType.BG_IMG_PROMPT;
            if (Intrinsics.areEqual(r100, r110.getValue()) == true) goto L46;
            ContentType r111 = ContentType.BIO;
            if (Intrinsics.areEqual(r100, r111.getValue()) == false) goto L36;
            return r111;
        L36:
            return ContentType.UNKNOWN;
        L46:
            return r110;
        L45:
            return r109;
        L44:
            return r108;
        L43:
            return r107;
        L42:
            return r106;
        L41:
            return r105;
        L40:
            return r104;
        L39:
            return r103;
        L38:
            return r102;
        L37:
            return r101;
        }
    }

    public static EnumEntries<ContentType> getEntries() {
        return f317658b;
    }

    static {
        ContentType r100 = new ContentType("UNKNOWN", 0, "");
        UNKNOWN = r100;
        ContentType r101 = new ContentType("NAME", 1, "Name");
        NAME = r101;
        ContentType r102 = new ContentType("DESC", 2, "Desc");
        DESC = r102;
        ContentType r103 = new ContentType("PROLOGUE", 3, "Prologue");
        PROLOGUE = r103;
        ContentType r104 = new ContentType("SUGGEST", 4, "Suggest");
        SUGGEST = r104;
        ContentType r105 = new ContentType("VOICE_ID", 5, "VoiceId");
        VOICE_ID = r105;
        ContentType r110 = new ContentType("LANGUAGE", 6, "Language");
        LANGUAGE = r110;
        ContentType r111 = new ContentType("BOT_CATEGORY", 7, "BotCategory");
        BOT_CATEGORY = r111;
        ContentType r112 = new ContentType(CommonConstant.RETKEY.GENDER, 8, "Gender");
        GENDER = r112;
        ContentType r113 = new ContentType("HEAD_IMG_PROMPT", 9, "HeadImgPrompt");
        HEAD_IMG_PROMPT = r113;
        ContentType r106 = new ContentType("BG_IMG_PROMPT", 10, "BgImgPrompt");
        BG_IMG_PROMPT = r106;
        ContentType r107 = new ContentType("BIO", 11, "Bio");
        BIO = r107;
        ContentType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107};
        f317657a = r108;
        f317658b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static ContentType[] values() {
        return (ContentType[]) f317657a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ContentType valueOf(String r100) {
        return (ContentType) r27.a.a(ContentType.class, r100);
    }

    public ContentType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.larus.im.bean.message;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import yc9.f1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/im/bean/message/TagEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "TagEnum_UNKNOWN", "TagEnum_Replaceable", "TagEnum_Insertable", "TagEnum_AT", "TagEnum_InsertText_V2", "TagEnum_InsertText", "TagEnum_InsertText_Lynx", "TagEnum_InsertText_APPLET", "TagEnum_InsertText_BLOCK", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum TagEnum extends Enum<TagEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TagEnum[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("3")
    public static final TagEnum TagEnum_AT = null;

    @SerialName("100")
    public static final TagEnum TagEnum_InsertText = null;

    @SerialName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final TagEnum TagEnum_InsertText_APPLET = null;

    @SerialName("202")
    public static final TagEnum TagEnum_InsertText_BLOCK = null;

    @SerialName("101")
    public static final TagEnum TagEnum_InsertText_Lynx = null;

    @SerialName("5")
    public static final TagEnum TagEnum_InsertText_V2 = null;

    @SerialName("2")
    public static final TagEnum TagEnum_Insertable = null;

    @SerialName("1")
    public static final TagEnum TagEnum_Replaceable = null;

    @SerialName("0")
    public static final TagEnum TagEnum_UNKNOWN = null;
    public final int value;

    private static final /* synthetic */ TagEnum[] $values() {
        return new TagEnum[]{TagEnum_UNKNOWN, TagEnum_Replaceable, TagEnum_Insertable, TagEnum_AT, TagEnum_InsertText_V2, TagEnum_InsertText, TagEnum_InsertText_Lynx, TagEnum_InsertText_APPLET, TagEnum_InsertText_BLOCK};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<TagEnum> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.im.bean.message.TagEnum$a] */
    static {
        TagEnum_UNKNOWN = new TagEnum("TagEnum_UNKNOWN", 0, 0);
        TagEnum_Replaceable = new TagEnum("TagEnum_Replaceable", 1, 1);
        TagEnum_Insertable = new TagEnum("TagEnum_Insertable", 2, 2);
        TagEnum_AT = new TagEnum("TagEnum_AT", 3, 3);
        TagEnum_InsertText_V2 = new TagEnum("TagEnum_InsertText_V2", 4, 5);
        TagEnum_InsertText = new TagEnum("TagEnum_InsertText", 5, 100);
        TagEnum_InsertText_Lynx = new TagEnum("TagEnum_InsertText_Lynx", 6, 101);
        TagEnum_InsertText_APPLET = new TagEnum("TagEnum_InsertText_APPLET", 7, 102);
        TagEnum_InsertText_BLOCK = new TagEnum("TagEnum_InsertText_BLOCK", 8, 202);
        TagEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f1());
    }

    public static TagEnum[] values() {
        return (TagEnum[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.message.TagEnum", values(), new String[]{"0", "1", "2", "3", "5", "100", "101", BDLocationException.ERROR_UID_IS_EMPTY, "202"}, new Annotation[][]{null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static TagEnum valueOf(String r100) {
        return (TagEnum) r27.a.a(TagEnum.class, r100);
    }

    private TagEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

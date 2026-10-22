package com.ss.android.lark.chat.entity.chatter;

import com.larus.nova.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/TagType;", "Ljava/io/Serializable;", "", "order", "", "bgColor", "textColor", "<init>", "(Ljava/lang/String;IIII)V", "getOrder", "()I", "getBgColor", "getTextColor", "UNKNOWN", "CLASS_TEACHER", "DISCIPLINE_TEACHER", "ADMIN_USER", "KA", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagType extends Enum<TagType> implements Serializable {
    public static final TagType ADMIN_USER = null;
    public static final TagType CLASS_TEACHER = null;
    public static final TagType DISCIPLINE_TEACHER = null;
    public static final TagType KA = null;
    public static final TagType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagType[] f415191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415192b = null;
    private final int bgColor;
    private final int order;
    private final int textColor;

    public static EnumEntries<TagType> getEntries() {
        return f415192b;
    }

    static {
        TagType r100 = new TagType("UNKNOWN", 0, 0, R.color.udtoken_tag_neutral_bg_normal, R.color.udtoken_tag_neutral_text_normal);
        UNKNOWN = r100;
        TagType r101 = new TagType("CLASS_TEACHER", 1, 100, R.color.udtoken_tag_bg_blue, R.color.udtoken_tag_text_s_blue);
        CLASS_TEACHER = r101;
        TagType r102 = new TagType("DISCIPLINE_TEACHER", 2, 100, R.color.udtoken_tag_bg_turquoise, R.color.udtoken_tag_text_s_turquoise);
        DISCIPLINE_TEACHER = r102;
        TagType r103 = new TagType("ADMIN_USER", 3, 50, R.color.udtoken_tag_bg_purple, R.color.udtoken_tag_text_s_purple);
        ADMIN_USER = r103;
        TagType r104 = new TagType("KA", 4, 0, R.color.udtoken_tag_bg_red, R.color.udtoken_tag_text_s_red);
        KA = r104;
        TagType[] r105 = {r100, r101, r102, r103, r104};
        f415191a = r105;
        f415192b = EnumEntriesKt.enumEntries(r105);
    }

    public static TagType[] values() {
        return (TagType[]) f415191a.clone();
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public static TagType valueOf(String r100) {
        return (TagType) r27.a.a(TagType.class, r100);
    }

    public TagType(String r100, int r101, int r102, int r103, int r104) {
        super(r100, r101);
        this.order = r102;
        this.bgColor = r103;
        this.textColor = r104;
    }
}

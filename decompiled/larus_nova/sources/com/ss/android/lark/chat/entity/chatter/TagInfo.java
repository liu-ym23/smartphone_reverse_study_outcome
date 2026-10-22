package com.ss.android.lark.chat.entity.chatter;

import com.larksuite.component.ui.tag.LarkNameTag;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/TagInfo;", "Ljava/io/Serializable;", "text", "", "type", "Lcom/ss/android/lark/chat/entity/chatter/TagType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chatter/TagType;)V", "getText", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/entity/chatter/TagType;", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "toString", "Companion", "Factory", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagInfo implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<b> f415189a = null;
    private static final long serialVersionUID = -351515894162L;
    private final String text;
    private final TagType type;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.chatter.TagInfo$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4857a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415190a = null;

            static {
                int[] r100 = new int[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.values().length];
                r100[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.CLASS_TEACHER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.DISCIPLINE_TEACHER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.ADMIN_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f415190a = r100;
            }
        }

        public a() {
        }

        @JvmStatic
        public static void a(LarkNameTag.c r100, List r101, List r102) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            Intrinsics.checkNotNullParameter(r102, "rules");
            if (r101 != null) goto L5;
            return;
        L5:
            List<TagInfo> r103 = CollectionsKt.toList(r101);
            Intrinsics.checkNotNullParameter(r103, "<this>");
            Intrinsics.checkNotNullParameter(r102, "rules");
            Iterator r104 = r102.iterator();
        L7:
            if (r104.hasNext() == false) goto L9;
            r103 = ((com.ss.android.lark.chat.entity.chatter.b) r104.next()).a(r103);
            goto L7
        L9:
            Iterator<T> r105 = r103.iterator();
        L11:
            if (r105.hasNext() == false) goto L13;
            d.a(r100, (TagInfo) r105.next());
            goto L11
        }
    }

    public static final class b {
        public b() {
        }
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r100, List<TagInfo> r101, List<? extends com.ss.android.lark.chat.entity.chatter.b> r102) {
        Companion.getClass();
        a.a(r100, r101, r102);
    }

    public static /* synthetic */ TagInfo copy$default(TagInfo r100, String r101, TagType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final TagType component2() {
        return this.type;
    }

    public final TagInfo copy(String r100, TagType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new TagInfo(r100, r101);
    }

    public String toString() {
        return "TagInfo(text=" + this.text + ", type=" + this.type + ')';
    }

    static {
        Companion = new a();
        f415189a = LazyKt.lazy(TagInfo$Companion$factory$2.INSTANCE);
    }

    public static final b getFactory() {
        Companion.getClass();
        return (b) access$getFactory$delegate$cp().getValue();
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.type.hashCode();
    }

    public static final /* synthetic */ Lazy access$getFactory$delegate$cp() {
        return f415189a;
    }

    public final String getText() {
        return this.text;
    }

    public final TagType getType() {
        return this.type;
    }

    @JvmStatic
    public static final TagInfo map(com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo r100) {
        a r101 = Companion;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tagInfo");
        String r102 = StringsKt.trim(r100.description).toString();
        com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType r103 = r100.tag_type;
        r101.getClass();
        int r104 = a.C4857a.f415190a[r103.ordinal()];
        if (r104 != 1) goto L5;
        TagType r105 = TagType.CLASS_TEACHER;
    L13:
        return new TagInfo(r102, r105);
    L5:
        if (r104 != 2) goto L7;
        r105 = TagType.DISCIPLINE_TEACHER;
        goto L13
    L7:
        if (r104 == 3) goto L9;
        r105 = TagType.UNKNOWN;
        goto L13
    L9:
        r105 = TagType.ADMIN_USER;
        goto L13
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TagInfo) == false) goto L5;
        TagInfo r101 = (TagInfo) r100;
        boolean r102 = Intrinsics.areEqual(this.text, r101.text);
        boolean r103 = false;
        boolean r104 = r102 | false;
        if (this.type.getBgColor() != r101.type.getBgColor()) goto L9;
        boolean r105 = true;
    L10:
        boolean r106 = r104 | r105;
        if (this.type.getOrder() != r101.type.getOrder()) goto L13;
        boolean r107 = true;
    L14:
        boolean r108 = r106 | r107;
        if (this.type.getTextColor() != r101.type.getTextColor()) goto L18;
        r103 = true;
    L18:
        return r108 | r103;
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        return super.equals(r100);
    }

    public TagInfo(String r100, TagType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.text = r100;
        this.type = r101;
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r100, TagInfo r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "tagInfo");
        d.a(r100, r101);
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r100, List<TagInfo> r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "builder");
        a.a(r100, r101, CollectionsKt.emptyList());
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r100, List<TagInfo> r101, com.ss.android.lark.chat.entity.chatter.b r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "infos");
        Intrinsics.checkNotNullParameter(r102, "rules");
        a.a(r100, r101, CollectionsKt.listOf(r102));
    }
}

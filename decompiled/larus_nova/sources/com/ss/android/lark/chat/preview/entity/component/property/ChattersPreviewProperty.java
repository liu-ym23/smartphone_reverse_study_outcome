package com.ss.android.lark.chat.preview.entity.component.property;

import com.alipay.sdk.m.x.d;
import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ChatterInfos;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001:BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0000H\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003JZ\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "theme", "Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "chatterCounts", "", "chatterInfoList", "", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "maxShowCount", "chattersMode", "Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", "title", "", "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;Ljava/lang/String;)V", "getTheme", "()Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "setTheme", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;)V", "getChatterCounts", "()Ljava/lang/Integer;", "setChatterCounts", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getChatterInfoList", "()Ljava/util/List;", "setChatterInfoList", "(Ljava/util/List;)V", "getMaxShowCount", "setMaxShowCount", "getChattersMode", "()Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", "setChattersMode", "(Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;Ljava/lang/String;)Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty;", "equals", "", "other", "", "hashCode", "toString", "ChattersMode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChattersPreviewProperty extends BaseProperty {
    private Integer chatterCounts;
    private List<ChatterPreviewChatterInfo> chatterInfoList;
    private ChattersMode chattersMode;
    private Integer maxShowCount;
    private Theme theme;
    private String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATIC", BannerBizName.DYNAMIC, "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChattersMode extends Enum<ChattersMode> {
        public static final a Companion = null;
        public static final ChattersMode DYNAMIC = null;
        public static final ChattersMode STATIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChattersMode[] f416251a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416252b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChattersMode> getEntries() {
            return f416252b;
        }

        static {
            ChattersMode r100 = new ChattersMode("STATIC", 0, 0);
            STATIC = r100;
            ChattersMode r101 = new ChattersMode(BannerBizName.DYNAMIC, 1, 1);
            DYNAMIC = r101;
            ChattersMode[] r102 = {r100, r101};
            f416251a = r102;
            f416252b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static ChattersMode[] values() {
            return (ChattersMode[]) f416251a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static ChattersMode valueOf(String r100) {
            return (ChattersMode) r27.a.a(ChattersMode.class, r100);
        }

        public ChattersMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ChattersPreviewProperty() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChattersPreviewProperty copy$default(ChattersPreviewProperty r100, Theme r101, Integer r102, List r103, Integer r104, ChattersMode r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.theme;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.chatterCounts;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.chatterInfoList;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.maxShowCount;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.chattersMode;
    L17:
        ChattersMode r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.title;
    L20:
        Theme r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Theme component1() {
        return this.theme;
    }

    public final Integer component2() {
        return this.chatterCounts;
    }

    public final List<ChatterPreviewChatterInfo> component3() {
        return this.chatterInfoList;
    }

    public final Integer component4() {
        return this.maxShowCount;
    }

    public final ChattersMode component5() {
        return this.chattersMode;
    }

    public final String component6() {
        return this.title;
    }

    public final ChattersPreviewProperty copy(Theme r100, Integer r110, List<ChatterPreviewChatterInfo> r111, Integer r112, ChattersMode r113, String r114) {
        Intrinsics.checkNotNullParameter(r113, "chattersMode");
        return new ChattersPreviewProperty(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChattersPreviewProperty) == true) goto L8;
        return false;
    L8:
        ChattersPreviewProperty r101 = (ChattersPreviewProperty) r100;
        if (this.theme == r101.theme) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterCounts, r101.chatterCounts) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatterInfoList, r101.chatterInfoList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxShowCount, r101.maxShowCount) == true) goto L21;
        return false;
    L21:
        if (this.chattersMode == r101.chattersMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        Theme r100 = this.theme;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.chatterCounts;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<ChatterPreviewChatterInfo> r107 = this.chatterInfoList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxShowCount;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.chattersMode.hashCode()) * 31;
        String r113 = this.title;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChattersPreviewProperty(theme=" + this.theme + ", chatterCounts=" + this.chatterCounts + ", chatterInfoList=" + this.chatterInfoList + ", maxShowCount=" + this.maxShowCount + ", chattersMode=" + this.chattersMode + ", title=" + this.title + ')';
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public ChattersPreviewProperty clone() {
        ChattersPreviewProperty r100 = new ChattersPreviewProperty(this.theme, this.chatterCounts, this.chatterInfoList, this.maxShowCount, null, null, 48, null);
        r100.setMarginLeft(getMarginLeft());
        r100.setMarginRight(getMarginRight());
        r100.setMarginTop(getMarginTop());
        r100.setMarginBottom(getMarginBottom());
        return r100;
    }

    public final Integer getChatterCounts() {
        return this.chatterCounts;
    }

    public final List<ChatterPreviewChatterInfo> getChatterInfoList() {
        return this.chatterInfoList;
    }

    public final ChattersMode getChattersMode() {
        return this.chattersMode;
    }

    public final Integer getMaxShowCount() {
        return this.maxShowCount;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L57;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.theme.getValue()) goto L9;
        Integer r104 = null;
        String r105 = null;
        Integer r106 = null;
        ArrayList<ChatterPreviewChatterInfo> r107 = null;
        r107 = null;
        if (r103 == ComponentAttribute.chatters_count.getValue()) goto L18;
        if (r103 == ComponentAttribute.chatters_infos.getValue()) goto L24;
        if (r103 == ComponentAttribute.max_show_count.getValue()) goto L32;
        if (r103 == ComponentAttribute.chatters_mode.getValue()) goto L38;
        if (r103 != ComponentAttribute.title.getValue()) goto L6;
        PreviewData r108 = r102.getValue();
        if (r108 == null) goto L56;
        r105 = r108.getString();
    L56:
        this.title = r105;
        goto L6
    L38:
        ChattersMode.a r109 = ChattersMode.Companion;
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L43;
        Integer r111 = r110.getInt();
        if (r111 == null) goto L43;
        int r112 = r111.intValue();
    L44:
        r109.getClass();
        if (r112 == 0) goto L49;
        if (r112 == 1) goto L48;
        ChattersMode r113 = ChattersMode.DYNAMIC;
    L50:
        this.chattersMode = r113;
        goto L6
    L48:
        r113 = ChattersMode.DYNAMIC;
        goto L50
    L49:
        r113 = ChattersMode.STATIC;
    L43:
        r112 = 1;
        goto L44
    L32:
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L35;
        r106 = r114.getInt();
    L35:
        this.maxShowCount = r106;
        goto L6
    L24:
        PreviewData r115 = r102.getValue();
        if (r115 == null) goto L29;
        ChatterInfos r116 = r115.getChatterInfos();
        if (r116 == null) goto L29;
        r107 = r116.getChatterInfos();
    L29:
        this.chatterInfoList = r107;
        goto L6
    L18:
        PreviewData r117 = r102.getValue();
        if (r117 == null) goto L21;
        r104 = r117.getInt();
    L21:
        this.chatterCounts = r104;
        goto L6
    L9:
        Theme.a r118 = Theme.Companion;
        PreviewData r119 = r102.getValue();
        if (r119 == null) goto L14;
        Integer r120 = r119.getInt();
        if (r120 == null) goto L14;
        int r121 = r120.intValue();
    L15:
        r118.getClass();
        this.theme = Theme.a.a(r121);
    L14:
        r121 = 0;
        goto L15
    }

    public final void setChatterCounts(Integer r100) {
        this.chatterCounts = r100;
    }

    public final void setChatterInfoList(List<ChatterPreviewChatterInfo> r100) {
        this.chatterInfoList = r100;
    }

    public final void setChattersMode(ChattersMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chattersMode = r100;
    }

    public final void setMaxShowCount(Integer r100) {
        this.maxShowCount = r100;
    }

    public final void setTheme(Theme r100) {
        this.theme = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public ChattersPreviewProperty(Theme r100, Integer r101, List<ChatterPreviewChatterInfo> r102, Integer r103, ChattersMode r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "chattersMode");
        super(Type.CHATTERS_PREVIEW);
        this.theme = r100;
        this.chatterCounts = r101;
        this.chatterInfoList = r102;
        this.maxShowCount = r103;
        this.chattersMode = r104;
        this.title = r105;
    }

    public /* synthetic */ ChattersPreviewProperty(Theme r100, Integer r101, List r102, Integer r103, ChattersMode r104, String r110, int r111, DefaultConstructorMarker r112) {
        List r105 = null;
        if ((r111 & 1) == 0) goto L5;
        Theme r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        Integer r106 = r101;
        if ((r111 & 4) != 0) goto L14;
        r105 = r102;
    L14:
        if ((r111 & 8) == 0) goto L16;
        r103 = 0;
    L16:
        Integer r107 = r103;
        if ((r111 & 16) == 0) goto L19;
        r104 = ChattersMode.DYNAMIC;
    L19:
        ChattersMode r108 = r104;
        if ((r111 & 32) == 0) goto L22;
        r110 = "";
    L22:
        this(r113, r106, r105, r107, r108, r110);
        return;
    L5:
        r113 = r100;
        goto L7
    }
}

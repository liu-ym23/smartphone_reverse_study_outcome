package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenConstant$ContentShowType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import h7b.l;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import w4b.k;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0003H\u0016J\u0013\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020\u0007H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003JU\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/MessageFullScreenLaunchData;", "Ljava/io/Serializable;", "messageId", "", "openApp", "Lcom/ss/android/lark/biz/im/api/OpenApp;", "messageType", "", "pageType", "Lcom/ss/android/lark/biz/im/extension/PageType;", "sequenceId", "contentData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;", ControlRule.KEY_EXTRA_DATA, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/OpenApp;ILcom/ss/android/lark/biz/im/extension/PageType;Ljava/lang/String;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;)V", "getMessageId", "()Ljava/lang/String;", "getOpenApp", "()Lcom/ss/android/lark/biz/im/api/OpenApp;", "getMessageType", "()I", "getPageType", "()Lcom/ss/android/lark/biz/im/extension/PageType;", "getSequenceId", "getContentData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;", "getExtraData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "isValid", "", "toString", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenLaunchData implements Serializable {
    public static final a Companion = null;
    private final ContentData contentData;
    private final ExtraData extraData;
    private Message message;
    private final String messageId;
    private final int messageType;
    private final OpenApp openApp;
    private final PageType pageType;
    private final String sequenceId;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4828a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f413971a = null;

            static {
                int[] r100 = new int[Message.Type.values().length];
                r100[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[Message.Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[Message.Type.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f413971a = r100;
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MessageFullScreenLaunchData copy$default(MessageFullScreenLaunchData r100, String r101, OpenApp r102, int r103, PageType r104, String r110, ContentData r111, ExtraData r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.messageId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.openApp;
    L8:
        OpenApp r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.messageType;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.pageType;
    L14:
        PageType r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.sequenceId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.contentData;
    L20:
        ContentData r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.extraData;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.messageId;
    }

    public final OpenApp component2() {
        return this.openApp;
    }

    public final int component3() {
        return this.messageType;
    }

    public final PageType component4() {
        return this.pageType;
    }

    public final String component5() {
        return this.sequenceId;
    }

    public final ContentData component6() {
        return this.contentData;
    }

    public final ExtraData component7() {
        return this.extraData;
    }

    public final MessageFullScreenLaunchData copy(String r110, OpenApp r111, int r112, PageType r113, String r114, ContentData r115, ExtraData r116) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r113, "pageType");
        Intrinsics.checkNotNullParameter(r114, "sequenceId");
        return new MessageFullScreenLaunchData(r110, r111, r112, r113, r114, r115, r116);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.messageId, Integer.valueOf(this.messageType), this.contentData});
    }

    public final boolean isValid() {
        ContentData r100 = this.contentData;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isValid() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("messageId = ");
        r100.append(this.messageId);
        r100.append(", messageType = ");
        r100.append(this.messageType);
        r100.append(", contentDataType = ");
        ContentData r101 = this.contentData;
        if (r101 == null) goto L14;
        int r102 = r101.getContentType();
        MessageFullScreenConstant$ContentShowType.Companion.getClass();
        if (r102 != 0) goto L7;
        String r103 = "only_origin";
    L15:
        r100.append(r103);
        return r100.toString();
    L7:
        if (r102 != 1) goto L9;
        r103 = "only_translate";
        goto L15
    L9:
        if (r102 == 2) goto L11;
        r103 = "unknown";
        goto L15
    L11:
        r103 = "origin_with_translate";
        goto L15
    L14:
        r103 = "invalid";
        goto L15
    }

    public final ContentData getContentData() {
        return this.contentData;
    }

    public final ExtraData getExtraData() {
        return this.extraData;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final OpenApp getOpenApp() {
        return this.openApp;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final String getSequenceId() {
        return this.sequenceId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(MessageFullScreenLaunchData.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData");
        MessageFullScreenLaunchData r102 = (MessageFullScreenLaunchData) r100;
        if (Intrinsics.areEqual(this.messageId, r102.messageId) == true) goto L16;
        return false;
    L16:
        if (this.messageType == r102.messageType) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.contentData, r102.contentData) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setMessage(Message r100) {
        this.message = r100;
    }

    /* JADX WARN: Type inference failed for: r11v12, types: [v5b.a] */
    @JvmStatic
    public static final MessageFullScreenLaunchData parseData(y6b.a<?> r110, Chat r111, OpenApp r210, PageType r211, String r212) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "chat");
        Intrinsics.checkNotNullParameter(r211, "pageType");
        Intrinsics.checkNotNullParameter(r212, "sequenceId");
        int r100 = a.C4828a.f413971a[r110.getType().ordinal()];
        int r101 = 1;
        RichTextData r112 = null;
        if (r100 == 1) goto L105;
        if (r100 == 2) goto L63;
        if (r100 == 3) goto L8;
        return null;
    L8:
        if (r110.isPreMessage() == false) goto L10;
        String r102 = r110.getcId();
    L11:
        ContentData.a r113 = ContentData.Companion;
        if ((r110.b() instanceof f) == true) goto L15;
    L60:
        ContentData r103 = null;
    L61:
        ExtraData.Companion.getClass();
        return new MessageFullScreenLaunchData(r102, r210, 2, r211, r212, r103, ExtraData.a.a(r110, r111, r211));
    L15:
        if ((r110.b().f553338a instanceof AudioContent) == false) goto L60;
        Lazy r114 = AudioMessageUtil.f413969a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        AudioContentVO r104 = (AudioContentVO) r110.b();
        if (r104.k() == true) goto L45;
        String r115 = r104.i();
        if (r115 != null) goto L22;
    L25:
        boolean r116 = true;
    L26:
        if (r116 == false) goto L41;
        AudioContentVO r117 = (AudioContentVO) r110.b();
        if (r117.f() <= 0) goto L30;
        long r118 = r117.f();
    L32:
        if (r117.l() == false) goto L34;
    L38:
        boolean r105 = false;
    L39:
        if (r105 == false) goto L45;
    L34:
        if (r110.isPreMessage() == true) goto L38;
        if ((System.currentTimeMillis() - (r118 * ((long) 1000))) >= 30000) goto L38;
        r105 = true;
        goto L39
    L30:
        r118 = r110.getCreateTime();
    L41:
        if (r104.f411853w == true) goto L45;
        if (((k) AudioMessageUtil.f413969a.getValue()).b() == false) goto L45;
        boolean r106 = true;
    L46:
        boolean r107 = !l.d((f) r110.b());
        if (r106 == false) goto L52;
        if (r107 == true) goto L50;
        int r108 = 0;
    L51:
        Integer r109 = Integer.valueOf(r108);
    L53:
        if (r109 == null) goto L60;
        int r119 = r109.intValue();
        Object r120 = r110.b();
        RichTextData.a r121 = RichTextData.Companion;
        AudioContentVO r122 = (AudioContentVO) r120;
        AudioContent r123 = (AudioContent) r122.f553338a;
        r121.getClass();
        RichTextData r124 = RichTextData.a.a(r123);
        v5b.a r125 = r122.f411957g;
        if (r125 == null) goto L59;
        AudioContent r126 = (AudioContent) r125.f553338a;
        if (r126 == null) goto L59;
        r112 = RichTextData.a.a(r126);
    L59:
        r103 = new ContentData(r124, r112, r119);
        goto L61
    L50:
        r108 = 2;
        goto L51
    L52:
        r109 = null;
        goto L53
    L22:
        if (r115.length() == 0) goto L25;
        r116 = false;
    L45:
        r106 = false;
        goto L46
    L10:
        r102 = r110.getId();
        goto L11
    L63:
        if (r110.isPreMessage() == false) goto L65;
        String r127 = r110.getcId();
    L66:
        ContentData.a r128 = ContentData.Companion;
        Object r129 = r110.b();
        if ((r129 instanceof f) == false) goto L102;
        f r130 = (f) r129;
        if ((r130.f553338a instanceof BaseTextContent) == false) goto L102;
        boolean r131 = !l.d(r130);
        if (r130.f411956f != 3) goto L75;
        boolean r132 = true;
    L76:
        if (r131 == true) goto L78;
        r101 = 0;
    L80:
        T r133 = r130.f553338a;
        if ((r133 instanceof TextContent) == false) goto L92;
        RichTextData.a r134 = RichTextData.Companion;
        Intrinsics.checkNotNull(r133, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        r134.getClass();
        RichTextData r135 = RichTextData.a.c((TextContent) r133);
        Object r136 = r130.f411957g;
        if ((r136 instanceof e) == false) goto L85;
        e r137 = (e) r136;
    L86:
        if (r137 == null) goto L90;
        TextContent r138 = (TextContent) r137.f553338a;
        if (r138 == null) goto L90;
        r112 = RichTextData.a.c(r138);
    L90:
        ContentData r139 = new ContentData(r135, r112, r101);
    L103:
        ExtraData.Companion.getClass();
        MessageFullScreenLaunchData r140 = new MessageFullScreenLaunchData(r127, r210, 0, r211, r212, r139, ExtraData.a.a(r110, r111, r211));
    L147:
        return r140;
    L85:
        r137 = null;
        goto L86
    L92:
        if ((r133 instanceof PostContent) == false) goto L102;
        RichTextData.a r141 = RichTextData.Companion;
        Intrinsics.checkNotNull(r133, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        r141.getClass();
        RichTextData r142 = RichTextData.a.b((PostContent) r133);
        Object r143 = r130.f411957g;
        if ((r143 instanceof PostContentVO) == false) goto L96;
        PostContentVO r144 = (PostContentVO) r143;
    L97:
        if (r144 == null) goto L101;
        PostContent r145 = (PostContent) r144.f553338a;
        if (r145 == null) goto L101;
        r112 = RichTextData.a.b(r145);
    L101:
        r139 = new ContentData(r142, r112, r101);
        goto L103
    L96:
        r144 = null;
        goto L97
    L78:
        if (r132 == false) goto L80;
        r101 = 2;
        goto L80
    L75:
        r132 = false;
    L102:
        r139 = null;
        goto L103
    L65:
        r127 = r110.getId();
        goto L66
    L105:
        if (r110.isPreMessage() == false) goto L107;
        String r146 = r110.getcId();
    L108:
        ContentData.a r147 = ContentData.Companion;
        Object r148 = r110.b();
        if ((r148 instanceof f) == false) goto L144;
        f r149 = (f) r148;
        if ((r149.f553338a instanceof BaseTextContent) == false) goto L144;
        boolean r150 = !l.d(r149);
        if (r149.f411956f != 3) goto L117;
        boolean r151 = true;
    L118:
        if (r150 == true) goto L120;
        r101 = 0;
    L122:
        T r152 = r149.f553338a;
        if ((r152 instanceof TextContent) == false) goto L134;
        RichTextData.a r153 = RichTextData.Companion;
        Intrinsics.checkNotNull(r152, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        r153.getClass();
        RichTextData r154 = RichTextData.a.c((TextContent) r152);
        Object r155 = r149.f411957g;
        if ((r155 instanceof e) == false) goto L127;
        e r156 = (e) r155;
    L128:
        if (r156 == null) goto L132;
        TextContent r157 = (TextContent) r156.f553338a;
        if (r157 == null) goto L132;
        r112 = RichTextData.a.c(r157);
    L132:
        ContentData r158 = new ContentData(r154, r112, r101);
    L145:
        ExtraData.Companion.getClass();
        r140 = new MessageFullScreenLaunchData(r146, r210, 1, r211, r212, r158, ExtraData.a.a(r110, r111, r211));
        goto L147
    L127:
        r156 = null;
        goto L128
    L134:
        if ((r152 instanceof PostContent) == false) goto L144;
        RichTextData.a r159 = RichTextData.Companion;
        Intrinsics.checkNotNull(r152, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        r159.getClass();
        RichTextData r160 = RichTextData.a.b((PostContent) r152);
        Object r161 = r149.f411957g;
        if ((r161 instanceof PostContentVO) == false) goto L138;
        PostContentVO r162 = (PostContentVO) r161;
    L139:
        if (r162 == null) goto L143;
        PostContent r163 = (PostContent) r162.f553338a;
        if (r163 == null) goto L143;
        r112 = RichTextData.a.b(r163);
    L143:
        r158 = new ContentData(r160, r112, r101);
        goto L145
    L138:
        r162 = null;
        goto L139
    L120:
        if (r151 == false) goto L122;
        r101 = 2;
        goto L122
    L117:
        r151 = false;
    L144:
        r158 = null;
        goto L145
    L107:
        r146 = r110.getId();
        goto L108
    }

    public MessageFullScreenLaunchData(String r100, OpenApp r101, int r102, PageType r103, String r104, ContentData r105, ExtraData r106) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r103, "pageType");
        Intrinsics.checkNotNullParameter(r104, "sequenceId");
        this.messageId = r100;
        this.openApp = r101;
        this.messageType = r102;
        this.pageType = r103;
        this.sequenceId = r104;
        this.contentData = r105;
        this.extraData = r106;
    }
}

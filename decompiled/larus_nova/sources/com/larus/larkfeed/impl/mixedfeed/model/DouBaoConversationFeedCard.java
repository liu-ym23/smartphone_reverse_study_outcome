package com.larus.larkfeed.impl.mixedfeed.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/larkfeed/impl/mixedfeed/model/DouBaoConversationFeedCard;", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lcom/ss/android/lark/feed/shared/data/IJumpInfo;", "<init>", "()V", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "getConversationData", "()Lcom/larus/bmhome/chat/model/api/ConversationData;", "setConversationData", "(Lcom/larus/bmhome/chat/model/api/ConversationData;)V", "isStubFeed", "", "()Z", "setStubFeed", "(Z)V", "getJumpPriority", "", "exactlyCompare", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouBaoConversationFeedCard extends UIFeedCard implements ieb.a {
    public static final a Companion = null;
    private wh8.a conversationData;
    private boolean isStubFeed;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // ieb.a
    public int getJumpPriority() {
        if (isRemind() == false) goto L9;
        if (getUnreadCount() <= 0) goto L9;
        return 2;
    L9:
        if (isRemind() == false) goto L11;
        return 0;
    L11:
        if (getUnreadCount() <= 0) goto L16;
        return 1;
    L16:
        return 0;
    }

    public DouBaoConversationFeedCard() {
    }

    public final wh8.a getConversationData() {
        return this.conversationData;
    }

    public final boolean isStubFeed() {
        return this.isStubFeed;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean exactlyCompare(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (super.exactlyCompare(r100) == true) goto L8;
        return false;
    L8:
        Message r101 = null;
        if ((r100 instanceof DouBaoConversationFeedCard) == false) goto L11;
        DouBaoConversationFeedCard r102 = (DouBaoConversationFeedCard) r100;
    L12:
        if (r102 != null) goto L15;
        return false;
    L15:
        if (this.isStubFeed == r102.isStubFeed) goto L18;
        FLogger.f375446a.d("DouBaoConversationFeedCard", "exactlyCompare diff isStubFeed: " + this.isStubFeed + " vs " + r102.isStubFeed);
        return false;
    L18:
        wh8.a r103 = this.conversationData;
        wh8.a r104 = r102.conversationData;
        if (r103 == null) goto L21;
        e r105 = r103.f559708a;
    L22:
        if (r104 == null) goto L24;
        e r106 = r104.f559708a;
    L26:
        if (Intrinsics.areEqual(r105, r106) == true) goto L28;
        return false;
    L28:
        if (r103 == null) goto L30;
        BotModel r107 = r103.f559709b;
    L31:
        if (r104 == null) goto L33;
        BotModel r108 = r104.f559709b;
    L35:
        if (Intrinsics.areEqual(r107, r108) == true) goto L37;
        return false;
    L37:
        if (r103 == null) goto L39;
        Message r109 = r103.f559710c;
    L40:
        if (r104 == null) goto L43;
        r101 = r104.f559710c;
    L43:
        if (Intrinsics.areEqual(r109, r101) == true) goto L45;
        return false;
    L45:
        return true;
    L39:
        r109 = null;
        goto L40
    L33:
        r108 = null;
        goto L35
    L30:
        r107 = null;
        goto L31
    L24:
        r106 = null;
        goto L26
    L21:
        r105 = null;
        goto L22
    L11:
        r102 = null;
        goto L12
    }

    public final void setConversationData(wh8.a r100) {
        this.conversationData = r100;
    }

    public final void setStubFeed(boolean r100) {
        this.isStubFeed = r100;
    }
}

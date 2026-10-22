package n5b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.ding.entity.DingStatus;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b, y28.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatChatter f518076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadTopic f518077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Message f518078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<ReactionInfo> f518079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<MessageInfo> f518080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<MessageInfo> f518081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Pin f518082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TranslateInfo f518083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ChatChatter f518084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f518085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f518086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Chat f518087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f518088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DingStatus f518089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ChatChatter f518090o;

    @Override // f5b.b
    public final MessageFoldDetail getMessageFoldDetail() {
        return null;
    }

    @Override // f5b.b
    public final ArrayList<String> getMsgIdPathList() {
        return null;
    }

    @Override // f5b.b
    public final b getParent() {
        return null;
    }

    @Override // f5b.b
    public final boolean isIntermediateMessage() {
        return false;
    }

    @Override // f5b.b
    public final void setMessageFoldDetail(MessageFoldDetail r100) {
    }

    @Override // f5b.b
    public final boolean canShow() {
        return this.f518078c.canShow();
    }

    @Override // f5b.b
    public final List<String> getAuthFileKeys() {
        return this.f518078c.getAuthFileKeys();
    }

    @Override // f5b.b
    public final String getId() {
        return this.f518077b.getId();
    }

    @Override // f5b.b
    public final long getUpdateTime() {
        return this.f518077b.getUpdateTime();
    }

    @Override // f5b.b
    public final String getcId() {
        return this.f518078c.getcId();
    }

    @Override // f5b.b
    public final boolean isNoTraceDelete() {
        if (this.f518077b.isNoTraceDelete() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f518078c.isNoTraceDelete() == true) goto L8;
        return false;
    }

    @Override // f5b.b
    public final boolean isPreMessage() {
        return this.f518078c.isPreMessage();
    }

    @Override // f5b.b, p5b.a
    public final boolean isShowMessageOriginContent() {
        String r100 = this.f518078c.getTranslateLanguage();
        TranslateInfo r101 = this.f518083h;
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r101 == null) goto L11;
        if (r100.equals(r101.getLanguage()) == false) goto L11;
        if (this.f518078c.getStatus() == Message.Status.DELETED) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // f5b.b
    public final boolean isTranslating() {
        Boolean r100 = this.f518086k;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.booleanValue() == false) goto L7;
        return true;
    }

    @Override // f5b.b
    public final boolean isTranslatingInited() {
        if (this.f518086k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "id:" + this.f518077b.getId() + ", position:" + this.f518077b.getPosition() + ", badgeCount:" + this.f518077b.getBadgeCount() + ", messageType:" + this.f518078c.getType();
    }

    public a() {
        this.f518085j = true;
        this.f518086k = null;
    }

    @Override // f5b.b
    public final b clone() {
        return (b) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // f5b.b
    public final Message getMessage() {
        return this.f518078c;
    }

    @Override // f5b.b
    public final ChatChatter getMessageSender() {
        return this.f518076a;
    }

    @Override // f5b.b
    public final Pin getPin() {
        return this.f518082g;
    }

    @Override // f5b.b
    public final List<ReactionInfo> getReactionInfoList() {
        return this.f518079d;
    }

    @Override // f5b.b
    public final TranslateInfo getTranslateInfo() {
        return this.f518083h;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m10972clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // p5b.c, f5b.b
    public final p5b.b getMessage() {
        return this.f518078c;
    }

    @Override // f5b.b, p5b.a
    public final Content getTranslateContent(boolean r100) {
        if (r100 == false) goto L6;
        return this.f518078c.getContent();
    L6:
        return this.f518083h.getTranslateContent();
    }

    @Override // y28.b
    public final boolean isContentSame(y28.b r100) {
        a r101 = (a) r100;
        if (y28.a.c(this.f518076a, r101.f518076a) == true) goto L6;
        return false;
    L6:
        if (y28.a.c(this.f518078c, r101.f518078c) == true) goto L9;
        return false;
    L9:
        if (y28.a.c(this.f518077b, r101.f518077b) == true) goto L12;
        return false;
    L12:
        if (y28.a.b(this.f518080e, r101.f518080e) == true) goto L15;
        return false;
    L15:
        if (y28.a.b(this.f518081f, r101.f518081f) == true) goto L18;
        return false;
    L18:
        if (y28.a.c(this.f518084i, r101.f518084i) == true) goto L21;
        return false;
    L21:
        if (y28.a.c(this.f518089n, r101.f518089n) == true) goto L24;
        return false;
    L24:
        if (y28.a.c(this.f518090o, r101.f518090o) == false) goto L49;
        TranslateInfo r102 = this.f518083h;
        if (r102 == null) goto L33;
        TranslateInfo r103 = r101.f518083h;
        if (r103 == null) goto L33;
        if (r102.equals(r103) == true) goto L33;
        return false;
    L33:
        if (this.f518085j == r101.f518085j) goto L35;
        return false;
    L35:
        if (this.f518086k.equals(r101.f518086k) == true) goto L38;
        return false;
    L38:
        throw null;
    L49:
        return false;
    }

    @Override // y28.b
    public final boolean isItemSame(y28.b r100) {
        return Objects.equals(this.f518077b.getId(), ((a) r100).f518077b.getId());
    }

    @Override // f5b.b
    public final void setDingStatus(DingStatus r100) {
        this.f518089n = r100;
    }

    @Override // f5b.b
    public final void setForceUpdate(boolean r100) {
        this.f518088m = r100;
    }

    @Override // f5b.b
    public final void setIsTranslating(boolean r100) {
        this.f518086k = Boolean.valueOf(r100);
    }

    @Override // f5b.b
    public final void setMessage(Message r100) {
        this.f518078c = r100;
    }

    @Override // f5b.b
    public final void setMessageSender(ChatChatter r100) {
        this.f518076a = r100;
    }

    @Override // f5b.b
    public final void setTranslateInfo(TranslateInfo r100) {
        this.f518083h = r100;
    }

    public a(ChatChatter r100, ThreadTopic r101, Message r102) {
        this.f518085j = true;
        this.f518086k = null;
        this.f518076a = r100;
        this.f518077b = r101;
        this.f518078c = r102;
    }
}

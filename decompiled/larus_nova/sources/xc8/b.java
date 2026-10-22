package xc8;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public class b implements wq8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f563233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f563234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f563235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentCellStateType f563236d;

    public int d() {
        return -1;
    }

    public final int e() {
        return ((Number) this.f563234b.getValue()).intValue();
    }

    @Override // ic8.v
    public final Message a() {
        return getMessage();
    }

    public ComponentCellStateType f() {
        return this.f563236d;
    }

    @Override // wq8.a
    public Message getMessage() {
        return this.f563233a;
    }

    public b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f563233a = r100;
        this.f563234b = LazyKt.lazy(new a(this));
        this.f563236d = ComponentCellStateType.DEFAULT;
    }

    public static String g(Message r100) {
        if (com.larus.im.bean.message.a.r0(r100) == false) goto L12;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L7;
        String r102 = r101.get(MusicAppletPage.KEY_MESSAGE_ID);
    L9:
        if (o0.d(r102) == false) goto L12;
        return r102;
    L7:
        r102 = null;
    L12:
        return r100.getMessageId();
    }

    public boolean b(wq8.a r110) {
        Intrinsics.checkNotNullParameter(r110, "newItem");
        Message r100 = getMessage();
        Message r111 = r110.a();
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r111, "newItem");
        Map<String, String> r101 = r111.getBusinessExt();
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.get("loading");
    L7:
        if (Intrinsics.areEqual(r103, "1") == false) goto L17;
        Map<String, String> r104 = r111.getBusinessExt();
        if (r104 == null) goto L13;
        String r105 = r104.get("progress");
        if (r105 == null) goto L13;
        int r106 = CastIntegerProtector.parseInt(r105);
    L15:
        if (r106 >= 100) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
        FLogger.f375446a.i("chatDiff", "force update msg. localMsgId=" + r100.getLocalMessageId() + " oldMsgId=" + r100.getMessageId() + " newMsgId=" + r111.getMessageId() + ' ');
    L77:
        return false;
    L20:
        Integer r108 = b0.c(r100);
        if (r108 != null) goto L24;
    L79:
    L75:
        e = move-exception;
        FLogger.f375446a.e("MessageAdapterExt", "messageSame e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        goto L77
    L34:
        if (r100.getContentType() != r111.getContentType()) goto L77;
        if (Intrinsics.areEqual(r100.getContent(), r111.getContent()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getContentBlock(), r111.getContentBlock()) == false) goto L77;
        if (r100.getMessageStatus() != r111.getMessageStatus()) goto L77;
        if (r100.getMessageStatusLocal() != r111.getMessageStatusLocal()) goto L77;
        if (r100.getLocalIndex() != r111.getLocalIndex()) goto L77;
        if (r100.getServerIndex() != r111.getServerIndex()) goto L77;
        if (Intrinsics.areEqual(r100.getFeedback(), r111.getFeedback()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getSectionId(), r111.getSectionId()) == false) goto L77;
        if (r111.getContentType() != 2) goto L63;
        List<SuggestQuestion> r109 = r100.getSuggestQuestions();     // Catch: Exception -> L75
        if (r109 == null) goto L56;
        Integer r112 = Integer.valueOf(r109.size());     // Catch: Exception -> L75
    L57:
        List<SuggestQuestion> r113 = r111.getSuggestQuestions();     // Catch: Exception -> L75
        if (r113 == null) goto L61;
        r102 = Integer.valueOf(r113.size());     // Catch: Exception -> L75
    L61:
        if (Intrinsics.areEqual(r112, r102) == false) goto L77;
    L56:
        r112 = null;
    L63:
        if (Intrinsics.areEqual(r100.getBusinessExt(), r111.getBusinessExt()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getSectionName(), r111.getSectionName()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getExt(), r111.getExt()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getSubList(), r111.getSubList()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getSubListGroup(), r111.getSubListGroup()) == false) goto L77;
        if (Intrinsics.areEqual(r100.getThinkingContent(), r111.getThinkingContent()) == false) goto L77;
        return true;
    L24:
        if (r108.intValue() != 0) goto L79;
        Integer r114 = b0.c(r111);
        if (r114 == null) goto L79;
        if (r114.intValue() != 0) goto L79;
        if (r100.getMessageStatusLocal() != r111.getMessageStatusLocal()) goto L79;
        return true;
    L13:
        r106 = 0;
    L17:
        r107 = false;
        goto L18
    L5:
        r103 = null;
        goto L7
    }

    public boolean c(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(getMessage().getLocalMessageId(), r100.a().getLocalMessageId()) == true) goto L19;
        Message r101 = getMessage();
        Message r102 = r100.a();
        if (r101 == null) goto L16;
        if (r102 == null) goto L16;
        if (com.larus.im.bean.message.a.r0(r101) == false) goto L14;
    L17:
        boolean r103 = Intrinsics.areEqual(g(r101), g(r102));
    L18:
        if (r103 == true) goto L19;
        return false;
    L14:
        if (com.larus.im.bean.message.a.r0(r102) == true) goto L17;
    L16:
        r103 = false;
    L19:
        return true;
    }

    public void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f563233a = r100;
    }
}

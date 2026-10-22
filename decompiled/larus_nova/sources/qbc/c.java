package qbc;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.content.VoteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements gya.a<VoteContent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f532429a;

    @Override // gya.a
    public final boolean b() {
        return false;
    }

    @Override // gya.a
    public final boolean c() {
        return false;
    }

    public c() {
        this.f532429a = new a();
    }

    @Override // gya.a
    public final MessageType a() {
        return MessageType.VOTE;
    }

    @Override // gya.a
    public final String d(Context r100, Content r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter((VoteContent) r101, "content");
        return UIUtils.getString(r100, R.string.Lark_Legacy_MessagePoCardVote);
    }

    @Override // gya.a
    public final String f(Context r100, Content r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter((VoteContent) r101, "content");
        return UIHelper.getString(R.string.Lark_IM_Poll_PollMessage_Text);
    }

    @Override // gya.a
    public final String h(Context r100, f5b.b r101) {
        gya.a.C6083a.a(r100, r101);
        return null;
    }

    @Override // gya.a
    public final Content g(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "pbContent");
        this.f532429a.getClass();
        return a.a(r100, r102);
    }

    @Override // gya.a
    public final Content e(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102, TranslateInfo r103) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "pbContent");
        this.f532429a.getClass();
        return a.a(r100, r102);
    }

    @Override // gya.a
    public final void i(com.bytedance.lark.pb.basic.v1.Content r100, BaseTextContent<?> r101, String r102, Entity r103) {
        gya.a.C6083a.b(r100, r101, r102);
    }
}

package com.ss.android.lark.vote.statistics;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/vote/statistics/VoteExtraParams$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESEND_TO_CHAT", "END_VOTE", "POST", "VOTE", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoteExtraParams$Click extends Enum<VoteExtraParams$Click> implements d {
    public static final VoteExtraParams$Click END_VOTE = null;
    public static final VoteExtraParams$Click POST = null;
    public static final VoteExtraParams$Click RESEND_TO_CHAT = null;
    public static final VoteExtraParams$Click VOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteExtraParams$Click[] f445309a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445310b = null;
    private final String value;

    public static EnumEntries<VoteExtraParams$Click> getEntries() {
        return f445310b;
    }

    @Override // s5c.d
    public String getKey() {
        return "click";
    }

    static {
        VoteExtraParams$Click r100 = new VoteExtraParams$Click("RESEND_TO_CHAT", 0, "resend_to_chat");
        RESEND_TO_CHAT = r100;
        VoteExtraParams$Click r101 = new VoteExtraParams$Click("END_VOTE", 1, "end_vote");
        END_VOTE = r101;
        VoteExtraParams$Click r102 = new VoteExtraParams$Click("POST", 2, UGCMonitor.TYPE_POST);
        POST = r102;
        VoteExtraParams$Click r103 = new VoteExtraParams$Click("VOTE", 3, "vote");
        VOTE = r103;
        VoteExtraParams$Click[] r104 = {r100, r101, r102, r103};
        f445309a = r104;
        f445310b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoteExtraParams$Click[] values() {
        return (VoteExtraParams$Click[]) f445309a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static VoteExtraParams$Click valueOf(String r100) {
        return (VoteExtraParams$Click) a.a(VoteExtraParams$Click.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public VoteExtraParams$Click(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

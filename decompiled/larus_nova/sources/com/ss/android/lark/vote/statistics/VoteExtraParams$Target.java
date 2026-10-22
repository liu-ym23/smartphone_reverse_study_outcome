package com.ss.android.lark.vote.statistics;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;
import s5c.e;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/vote/statistics/VoteExtraParams$Target;", "Lcom/ss/android/lark/statistics/extensions/ITargetParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IM_CHAT_VOTE_CREATE_VIEW", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoteExtraParams$Target extends Enum<VoteExtraParams$Target> implements e {
    public static final VoteExtraParams$Target IM_CHAT_VOTE_CREATE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteExtraParams$Target[] f445311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445312b = null;
    private final String value;

    public static EnumEntries<VoteExtraParams$Target> getEntries() {
        return f445312b;
    }

    @Override // s5c.d
    public String getKey() {
        return PickerReporterConstants.KEY.TARGET;
    }

    static {
        VoteExtraParams$Target r100 = new VoteExtraParams$Target();
        IM_CHAT_VOTE_CREATE_VIEW = r100;
        VoteExtraParams$Target[] r101 = {r100};
        f445311a = r101;
        f445312b = EnumEntriesKt.enumEntries(r101);
    }

    public VoteExtraParams$Target() {
        super("IM_CHAT_VOTE_CREATE_VIEW", 0);
        this.value = "im_chat_vote_create_view";
    }

    public static VoteExtraParams$Target[] values() {
        return (VoteExtraParams$Target[]) f445311a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static VoteExtraParams$Target valueOf(String r100) {
        return (VoteExtraParams$Target) a.a(VoteExtraParams$Target.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }
}

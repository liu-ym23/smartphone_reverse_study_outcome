package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "PROMPT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatJobEditTextKey extends Enum<ChatJobEditTextKey> {
    public static final ChatJobEditTextKey PROMPT = null;
    public static final ChatJobEditTextKey TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatJobEditTextKey[] f325189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325190b = null;

    public static EnumEntries<ChatJobEditTextKey> getEntries() {
        return f325190b;
    }

    static {
        ChatJobEditTextKey r100 = new ChatJobEditTextKey("TITLE", 0);
        TITLE = r100;
        ChatJobEditTextKey r101 = new ChatJobEditTextKey("PROMPT", 1);
        PROMPT = r101;
        ChatJobEditTextKey[] r102 = {r100, r101};
        f325189a = r102;
        f325190b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatJobEditTextKey[] values() {
        return (ChatJobEditTextKey[]) f325189a.clone();
    }

    public static ChatJobEditTextKey valueOf(String r100) {
        return (ChatJobEditTextKey) r27.a.a(ChatJobEditTextKey.class, r100);
    }

    public ChatJobEditTextKey(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.bmhome.chat.layout.holder.helper;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "", "source", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", CancelRetainContactInfoFunctions.All, "Thinking", "Content", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LongClickSource extends Enum<LongClickSource> {
    public static final LongClickSource All = null;
    public static final LongClickSource Content = null;
    public static final LongClickSource Thinking = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LongClickSource[] f303510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303511b = null;
    private final String source;

    public static EnumEntries<LongClickSource> getEntries() {
        return f303511b;
    }

    static {
        LongClickSource r100 = new LongClickSource(CancelRetainContactInfoFunctions.All, 0, "all");
        All = r100;
        LongClickSource r101 = new LongClickSource("Thinking", 1, SubtitleListUpdateType.THINKING);
        Thinking = r101;
        LongClickSource r102 = new LongClickSource("Content", 2, "content");
        Content = r102;
        LongClickSource[] r103 = {r100, r101, r102};
        f303510a = r103;
        f303511b = EnumEntriesKt.enumEntries(r103);
    }

    public static LongClickSource[] values() {
        return (LongClickSource[]) f303510a.clone();
    }

    public final String getSource() {
        return this.source;
    }

    public static LongClickSource valueOf(String r100) {
        return (LongClickSource) r27.a.a(LongClickSource.class, r100);
    }

    public LongClickSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}

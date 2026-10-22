package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REPLY_IN_MORE", CardAdapter.REACTION, "INPUT", "TIMESTAMP", "QUOTE_MORE", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentAction extends Enum<CommentAction> {
    public static final a Companion = null;
    public static final CommentAction INPUT = null;
    public static final CommentAction QUOTE_MORE = null;
    public static final CommentAction REACTION = null;
    public static final CommentAction REPLY_IN_MORE = null;
    public static final CommentAction TIMESTAMP = null;
    public static final /* synthetic */ CommentAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CommentAction> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction$a] */
    static {
        CommentAction r0 = new CommentAction("REPLY_IN_MORE", 0, "REPLY_IN_MORE");
        REPLY_IN_MORE = r0;
        CommentAction r1 = new CommentAction(CardAdapter.REACTION, 1, CardAdapter.REACTION);
        REACTION = r1;
        CommentAction r3 = new CommentAction("INPUT", 2, "INPUT");
        INPUT = r3;
        CommentAction r5 = new CommentAction("TIMESTAMP", 3, "TIMESTAMP");
        TIMESTAMP = r5;
        CommentAction r7 = new CommentAction("QUOTE_MORE", 4, "QUOTE_MORE");
        QUOTE_MORE = r7;
        CommentAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static CommentAction[] values() {
        return (CommentAction[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CommentAction valueOf(String r1) {
        return (CommentAction) r27.a.a(CommentAction.class, r1);
    }

    public CommentAction(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

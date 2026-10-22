package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/ListMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SELECT_MESSAGES_FOR_CALLER", "MULTI_SELECT", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ListMode extends Enum<ListMode> {
    public static final ListMode MULTI_SELECT = null;
    public static final ListMode NORMAL = null;
    public static final ListMode SELECT_MESSAGES_FOR_CALLER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListMode[] f412188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f412189b = null;

    public static EnumEntries<ListMode> getEntries() {
        return f412189b;
    }

    static {
        ListMode r100 = new ListMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ListMode r101 = new ListMode("SELECT_MESSAGES_FOR_CALLER", 1);
        SELECT_MESSAGES_FOR_CALLER = r101;
        ListMode r102 = new ListMode("MULTI_SELECT", 2);
        MULTI_SELECT = r102;
        ListMode[] r103 = {r100, r101, r102};
        f412188a = r103;
        f412189b = EnumEntriesKt.enumEntries(r103);
    }

    public static ListMode[] values() {
        return (ListMode[]) f412188a.clone();
    }

    public static ListMode valueOf(String r100) {
        return (ListMode) a.a(ListMode.class, r100);
    }

    public ListMode(String r100, int r101) {
        super(r100, r101);
    }
}

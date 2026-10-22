package com.larus.bmhome.view.actionbar;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/view/actionbar/ActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "HIGHLIGHT", "HIGHLIGHT_WITH_LEFT_ICON", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionStyle extends Enum<ActionStyle> {
    public static final ActionStyle HIGHLIGHT = null;
    public static final ActionStyle HIGHLIGHT_WITH_LEFT_ICON = null;
    public static final ActionStyle NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionStyle[] f315615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315616b = null;

    public static EnumEntries<ActionStyle> getEntries() {
        return f315616b;
    }

    static {
        ActionStyle r100 = new ActionStyle(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ActionStyle r101 = new ActionStyle("HIGHLIGHT", 1);
        HIGHLIGHT = r101;
        ActionStyle r102 = new ActionStyle("HIGHLIGHT_WITH_LEFT_ICON", 2);
        HIGHLIGHT_WITH_LEFT_ICON = r102;
        ActionStyle[] r103 = {r100, r101, r102};
        f315615a = r103;
        f315616b = EnumEntriesKt.enumEntries(r103);
    }

    public static ActionStyle[] values() {
        return (ActionStyle[]) f315615a.clone();
    }

    public static ActionStyle valueOf(String r100) {
        return (ActionStyle) a.a(ActionStyle.class, r100);
    }

    public ActionStyle(String r100, int r101) {
        super(r100, r101);
    }
}

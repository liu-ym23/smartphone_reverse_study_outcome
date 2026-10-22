package com.larus.audio.call.subtitle;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/call/subtitle/SubtitleAction;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "UPDATE", HTTP.NOTIFY, "REFRESH", "PLACEHOLDER", "WAIT", "LISTENING", "DELETE", FlowDoraWifiScene.OTHER, "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubtitleAction extends Enum<SubtitleAction> {
    public static final SubtitleAction DELETE = null;
    public static final SubtitleAction LISTENING = null;
    public static final SubtitleAction NEW = null;
    public static final SubtitleAction NOTIFY = null;
    public static final SubtitleAction OTHER = null;
    public static final SubtitleAction PLACEHOLDER = null;
    public static final SubtitleAction REFRESH = null;
    public static final SubtitleAction UPDATE = null;
    public static final SubtitleAction WAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleAction[] f289615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289616b = null;

    public static EnumEntries<SubtitleAction> getEntries() {
        return f289616b;
    }

    static {
        SubtitleAction r100 = new SubtitleAction("NEW", 0);
        NEW = r100;
        SubtitleAction r101 = new SubtitleAction("UPDATE", 1);
        UPDATE = r101;
        SubtitleAction r102 = new SubtitleAction(HTTP.NOTIFY, 2);
        NOTIFY = r102;
        SubtitleAction r103 = new SubtitleAction("REFRESH", 3);
        REFRESH = r103;
        SubtitleAction r104 = new SubtitleAction("PLACEHOLDER", 4);
        PLACEHOLDER = r104;
        SubtitleAction r105 = new SubtitleAction("WAIT", 5);
        WAIT = r105;
        SubtitleAction r110 = new SubtitleAction("LISTENING", 6);
        LISTENING = r110;
        SubtitleAction r111 = new SubtitleAction("DELETE", 7);
        DELETE = r111;
        SubtitleAction r112 = new SubtitleAction(FlowDoraWifiScene.OTHER, 8);
        OTHER = r112;
        SubtitleAction[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f289615a = r113;
        f289616b = EnumEntriesKt.enumEntries(r113);
    }

    public static SubtitleAction[] values() {
        return (SubtitleAction[]) f289615a.clone();
    }

    public static SubtitleAction valueOf(String r100) {
        return (SubtitleAction) a.a(SubtitleAction.class, r100);
    }

    public SubtitleAction(String r100, int r101) {
        super(r100, r101);
    }
}

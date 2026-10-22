package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/ViewStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "LOADING", "SEARCHING", "LOADED", "ERROR", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ViewStatus extends Enum<ViewStatus> {
    public static final a Companion = null;
    public static final ViewStatus ERROR = null;
    public static final ViewStatus LOADED = null;
    public static final ViewStatus LOADING = null;
    public static final ViewStatus NONE = null;
    public static final ViewStatus SEARCHING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewStatus[] f209326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209327b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ViewStatus> getEntries() {
        return f209327b;
    }

    static {
        ViewStatus r100 = new ViewStatus(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ViewStatus r101 = new ViewStatus("LOADING", 1, 1);
        LOADING = r101;
        ViewStatus r102 = new ViewStatus("SEARCHING", 2, 2);
        SEARCHING = r102;
        ViewStatus r103 = new ViewStatus("LOADED", 3, 3);
        LOADED = r103;
        ViewStatus r104 = new ViewStatus("ERROR", 4, 4);
        ERROR = r104;
        ViewStatus[] r105 = {r100, r101, r102, r103, r104};
        f209326a = r105;
        f209327b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ViewStatus[] values() {
        return (ViewStatus[]) f209326a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ViewStatus valueOf(String r100) {
        return (ViewStatus) r27.a.a(ViewStatus.class, r100);
    }

    public ViewStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

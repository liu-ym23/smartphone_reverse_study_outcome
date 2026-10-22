package com.ss.android.ugc.aweme.kiwi.ui;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/ui/QUIAction;", "", UserProfileEvent.POSITION_NONE, "HIDE", "SHOW", "REPLACE", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final enum QUIAction extends Enum<QUIAction> {
    public static final QUIAction HIDE = null;
    public static final QUIAction NONE = null;
    public static final QUIAction REPLACE = null;
    public static final QUIAction SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QUIAction[] f450905a = null;

    static {
        QUIAction r100 = new QUIAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        QUIAction r101 = new QUIAction("HIDE", 1);
        HIDE = r101;
        QUIAction r102 = new QUIAction("SHOW", 2);
        SHOW = r102;
        QUIAction r103 = new QUIAction("REPLACE", 3);
        REPLACE = r103;
        f450905a = new QUIAction[]{r100, r101, r102, r103};
    }

    public static QUIAction valueOf(String r100) {
        return (QUIAction) a.a(QUIAction.class, r100);
    }

    public static QUIAction[] values() {
        return (QUIAction[]) f450905a.clone();
    }

    public QUIAction(String r100, int r101) {
        super(r100, r101);
    }
}

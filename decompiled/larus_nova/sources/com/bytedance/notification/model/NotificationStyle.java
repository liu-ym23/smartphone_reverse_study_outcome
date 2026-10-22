package com.bytedance.notification.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum NotificationStyle extends Enum<NotificationStyle> {
    public static final NotificationStyle NORMAL = null;
    public static final NotificationStyle SMALL_PICTURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationStyle[] f266077a = null;
    public final int styleIndex;
    public final String styleName;

    static {
        NotificationStyle r100 = new NotificationStyle(EffectConstants.NORMAL, 0, 1, EffectConstants.NORMAL);
        NORMAL = r100;
        NotificationStyle r101 = new NotificationStyle("SMALL_PICTURE", 1, 2, "SMALL_PICTURE");
        SMALL_PICTURE = r101;
        f266077a = new NotificationStyle[]{r100, r101};
    }

    public static NotificationStyle[] values() {
        return (NotificationStyle[]) f266077a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.styleName;
    }

    public static NotificationStyle valueOf(String r100) {
        return (NotificationStyle) a.a(NotificationStyle.class, r100);
    }

    public NotificationStyle(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.styleIndex = r102;
        this.styleName = r103;
    }
}

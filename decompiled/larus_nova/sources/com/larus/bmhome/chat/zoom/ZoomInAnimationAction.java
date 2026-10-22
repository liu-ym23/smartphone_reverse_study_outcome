package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationAction extends Enum<ZoomInAnimationAction> {
    public static final ZoomInAnimationAction HIDE = null;
    public static final ZoomInAnimationAction SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ZoomInAnimationAction[] f310424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f310425b = null;

    public static EnumEntries<ZoomInAnimationAction> getEntries() {
        return f310425b;
    }

    static {
        ZoomInAnimationAction r100 = new ZoomInAnimationAction("SHOW", 0);
        SHOW = r100;
        ZoomInAnimationAction r101 = new ZoomInAnimationAction("HIDE", 1);
        HIDE = r101;
        ZoomInAnimationAction[] r102 = {r100, r101};
        f310424a = r102;
        f310425b = EnumEntriesKt.enumEntries(r102);
    }

    public static ZoomInAnimationAction[] values() {
        return (ZoomInAnimationAction[]) f310424a.clone();
    }

    public static ZoomInAnimationAction valueOf(String r100) {
        return (ZoomInAnimationAction) a.a(ZoomInAnimationAction.class, r100);
    }

    public ZoomInAnimationAction(String r100, int r101) {
        super(r100, r101);
    }
}

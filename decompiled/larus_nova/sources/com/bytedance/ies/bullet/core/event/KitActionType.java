package com.bytedance.ies.bullet.core.event;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/core/event/KitActionType;", "", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Closed", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum KitActionType extends Enum<KitActionType> {
    public static final KitActionType Closed = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KitActionType[] f246489a = null;
    private final String actionType;

    public static KitActionType valueOf(String r100) {
        return (KitActionType) r27.a.a(KitActionType.class, r100);
    }

    public static KitActionType[] values() {
        return (KitActionType[]) f246489a.clone();
    }

    static {
        KitActionType r100 = new KitActionType();
        Closed = r100;
        f246489a = new KitActionType[]{r100};
    }

    public KitActionType() {
        super("Closed", 0);
        this.actionType = PTYSocketStateCallback.CLOSED;
    }

    public final String getActionType() {
        return this.actionType;
    }
}

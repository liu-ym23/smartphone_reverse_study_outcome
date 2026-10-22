package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/ToastType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SUCCESS", "ERROR", "WARNING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToastType extends Enum<ToastType> {
    public static final ToastType ERROR = null;
    public static final ToastType NORMAL = null;
    public static final ToastType SUCCESS = null;
    public static final ToastType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToastType[] f433559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433560b = null;

    public static EnumEntries<ToastType> getEntries() {
        return f433560b;
    }

    static {
        ToastType r100 = new ToastType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ToastType r101 = new ToastType("SUCCESS", 1);
        SUCCESS = r101;
        ToastType r102 = new ToastType("ERROR", 2);
        ERROR = r102;
        ToastType r103 = new ToastType("WARNING", 3);
        WARNING = r103;
        ToastType[] r104 = {r100, r101, r102, r103};
        f433559a = r104;
        f433560b = EnumEntriesKt.enumEntries(r104);
    }

    public static ToastType[] values() {
        return (ToastType[]) f433559a.clone();
    }

    public static ToastType valueOf(String r100) {
        return (ToastType) a.a(ToastType.class, r100);
    }

    public ToastType(String r100, int r101) {
        super(r100, r101);
    }
}

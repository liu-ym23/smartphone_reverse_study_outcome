package com.larus.photopicker.v2.impl.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/EntryMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", EffectConstants.NORMAL, ErrorCode.INIT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntryMode extends Enum<EntryMode> {
    public static final EntryMode BOTTOM = null;
    public static final EntryMode INIT = null;
    public static final EntryMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntryMode[] f364482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364483b = null;

    public static EnumEntries<EntryMode> getEntries() {
        return f364483b;
    }

    static {
        EntryMode r100 = new EntryMode("BOTTOM", 0);
        BOTTOM = r100;
        EntryMode r101 = new EntryMode(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        EntryMode r102 = new EntryMode(ErrorCode.INIT, 2);
        INIT = r102;
        EntryMode[] r103 = {r100, r101, r102};
        f364482a = r103;
        f364483b = EnumEntriesKt.enumEntries(r103);
    }

    public static EntryMode[] values() {
        return (EntryMode[]) f364482a.clone();
    }

    public static EntryMode valueOf(String r100) {
        return (EntryMode) a.a(EntryMode.class, r100);
    }

    public EntryMode(String r100, int r101) {
        super(r100, r101);
    }
}

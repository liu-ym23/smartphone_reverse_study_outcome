package com.ss.android.lark.officesdk.contact.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactListScene;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_COLD", "INCR_SHORT", "contact-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeContactListScene extends Enum<OfficeContactListScene> {
    public static final OfficeContactListScene FULL_COLD = null;
    public static final OfficeContactListScene INCR_SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeContactListScene[] f433136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433137b = null;

    public static EnumEntries<OfficeContactListScene> getEntries() {
        return f433137b;
    }

    static {
        OfficeContactListScene r100 = new OfficeContactListScene("FULL_COLD", 0);
        FULL_COLD = r100;
        OfficeContactListScene r101 = new OfficeContactListScene("INCR_SHORT", 1);
        INCR_SHORT = r101;
        OfficeContactListScene[] r102 = {r100, r101};
        f433136a = r102;
        f433137b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeContactListScene[] values() {
        return (OfficeContactListScene[]) f433136a.clone();
    }

    public static OfficeContactListScene valueOf(String r100) {
        return (OfficeContactListScene) a.a(OfficeContactListScene.class, r100);
    }

    public OfficeContactListScene(String r100, int r101) {
        super(r100, r101);
    }
}

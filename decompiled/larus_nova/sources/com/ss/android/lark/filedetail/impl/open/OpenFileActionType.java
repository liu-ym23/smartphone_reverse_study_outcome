package com.ss.android.lark.filedetail.impl.open;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/open/OpenFileActionType;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW", "SHARE", "toIntentAction", "", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFileActionType extends Enum<OpenFileActionType> {
    public static final OpenFileActionType SHARE = null;
    public static final OpenFileActionType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFileActionType[] f421803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421804b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421805a = null;

        static {
            int[] r100 = new int[OpenFileActionType.values().length];
            r100[OpenFileActionType.VIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OpenFileActionType.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f421805a = r100;
        }
    }

    public static EnumEntries<OpenFileActionType> getEntries() {
        return f421804b;
    }

    static {
        OpenFileActionType r100 = new OpenFileActionType("VIEW", 0);
        VIEW = r100;
        OpenFileActionType r101 = new OpenFileActionType("SHARE", 1);
        SHARE = r101;
        OpenFileActionType[] r102 = {r100, r101};
        f421803a = r102;
        f421804b = EnumEntriesKt.enumEntries(r102);
    }

    public static OpenFileActionType[] values() {
        return (OpenFileActionType[]) f421803a.clone();
    }

    public final String toIntentAction() {
        int r100 = a.f421805a[ordinal()];
        if (r100 != 1) goto L5;
        return CommonConstant.ACTION.HWID_SCHEME_URL;
    L5:
        if (r100 != 2) goto L8;
        return "android.intent.action.SEND";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static OpenFileActionType valueOf(String r100) {
        return (OpenFileActionType) r27.a.a(OpenFileActionType.class, r100);
    }

    public OpenFileActionType(String r100, int r101) {
        super(r100, r101);
    }
}

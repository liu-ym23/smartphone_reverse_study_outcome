package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuMediaSecurityAction;", "", "<init>", "(Ljava/lang/String;I)V", "SAVE", "SHARE", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFeishuMediaSecurityAction extends Enum<OpenFeishuMediaSecurityAction> {
    public static final OpenFeishuMediaSecurityAction SAVE = null;
    public static final OpenFeishuMediaSecurityAction SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeishuMediaSecurityAction[] f410605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410606b = null;

    public static EnumEntries<OpenFeishuMediaSecurityAction> getEntries() {
        return f410606b;
    }

    static {
        OpenFeishuMediaSecurityAction r100 = new OpenFeishuMediaSecurityAction("SAVE", 0);
        SAVE = r100;
        OpenFeishuMediaSecurityAction r101 = new OpenFeishuMediaSecurityAction("SHARE", 1);
        SHARE = r101;
        OpenFeishuMediaSecurityAction[] r102 = {r100, r101};
        f410605a = r102;
        f410606b = EnumEntriesKt.enumEntries(r102);
    }

    public static OpenFeishuMediaSecurityAction[] values() {
        return (OpenFeishuMediaSecurityAction[]) f410605a.clone();
    }

    public static OpenFeishuMediaSecurityAction valueOf(String r100) {
        return (OpenFeishuMediaSecurityAction) a.a(OpenFeishuMediaSecurityAction.class, r100);
    }

    public OpenFeishuMediaSecurityAction(String r100, int r101) {
        super(r100, r101);
    }
}

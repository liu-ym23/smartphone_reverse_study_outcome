package com.ss.android.lark.biz.officesdk.im.share;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKShareScene;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT", "REPLY_IN_THREAD", "MY_QR_CODE", "GROUP_QR_CODE", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IOfficeSDKShareScene extends Enum<IOfficeSDKShareScene> {
    public static final IOfficeSDKShareScene CHAT = null;
    public static final IOfficeSDKShareScene GROUP_QR_CODE = null;
    public static final IOfficeSDKShareScene MY_QR_CODE = null;
    public static final IOfficeSDKShareScene REPLY_IN_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IOfficeSDKShareScene[] f410617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410618b = null;

    public static EnumEntries<IOfficeSDKShareScene> getEntries() {
        return f410618b;
    }

    static {
        IOfficeSDKShareScene r100 = new IOfficeSDKShareScene("CHAT", 0);
        CHAT = r100;
        IOfficeSDKShareScene r101 = new IOfficeSDKShareScene("REPLY_IN_THREAD", 1);
        REPLY_IN_THREAD = r101;
        IOfficeSDKShareScene r102 = new IOfficeSDKShareScene("MY_QR_CODE", 2);
        MY_QR_CODE = r102;
        IOfficeSDKShareScene r103 = new IOfficeSDKShareScene("GROUP_QR_CODE", 3);
        GROUP_QR_CODE = r103;
        IOfficeSDKShareScene[] r104 = {r100, r101, r102, r103};
        f410617a = r104;
        f410618b = EnumEntriesKt.enumEntries(r104);
    }

    public static IOfficeSDKShareScene[] values() {
        return (IOfficeSDKShareScene[]) f410617a.clone();
    }

    public static IOfficeSDKShareScene valueOf(String r100) {
        return (IOfficeSDKShareScene) a.a(IOfficeSDKShareScene.class, r100);
    }

    public IOfficeSDKShareScene(String r100, int r101) {
        super(r100, r101);
    }
}

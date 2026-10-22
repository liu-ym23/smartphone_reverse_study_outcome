package com.larus.setting.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/larus/setting/api/CustomAppIcon;", "Lcom/larus/setting/api/ICustomAppIcon;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/ICustomAppIcon;", "impl$delegate", "Lkotlin/Lazy;", "handleCustomAppIconChange", "", "currentSelectAppIconId", "", "cvsId", "", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "prepareCustomAppIconChange", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomAppIcon implements ICustomAppIcon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CustomAppIcon f367884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f367885b = null;

    private CustomAppIcon() {
    }

    static {
        f367884a = new CustomAppIcon();
        f367885b = LazyKt.lazy(new c());
    }

    @Override // com.larus.setting.api.ICustomAppIcon
    public final boolean b() {
        ICustomAppIcon r100 = (ICustomAppIcon) f367885b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    @Override // com.larus.setting.api.ICustomAppIcon
    public final boolean a(Integer r100, String r101) {
        ICustomAppIcon r102 = (ICustomAppIcon) f367885b.getValue();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.a(r100, r101);
    }
}
